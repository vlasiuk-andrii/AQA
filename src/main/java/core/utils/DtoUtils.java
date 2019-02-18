package core.utils;

import core.dto.BaseDTO;
import core.dto.FormFieldName;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public final class DtoUtils {

    private DtoUtils()  {}

    private static final Logger LOGGER = LoggerFactory.getLogger(DtoUtils.class);

    public static String getFieldName(final String fieldName, final BaseDTO dto) {
        try {
            if(dto.getClass().getDeclaredField(fieldName).isAnnotationPresent(FormFieldName.class)) {
                return dto.getClass().getDeclaredField(fieldName).getAnnotation(FormFieldName.class).value();
            }
        } catch (NoSuchFieldException e) {
            LOGGER.error("No such field {}", fieldName, e);
        }
        return StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(fieldName), " ");
    }

    public static Map<String, String> convertDtoToMap(final BaseDTO dto) {
        final Map<String, String> convertedMap = new HashMap<>();
        for (final Method method : dto.getClass().getMethods()) {
            try {
                if (isGetterMethod(method)) {
                    final String value = (String) method.invoke(dto);
                    final String key = firstLetterToUpperCase(getFieldName(removePrefix(method), dto));
                    convertedMap.put(key, value == null ? "" : value);
                }
            } catch (final IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                LOGGER.error("Unexpected error while converting object {} to map", dto, e);
            }
        }
        return convertedMap;
    }

    public static List<String> convertDtoToList(final BaseDTO dto) {
        final Map<String, String> convertedMap = convertDtoToMap(dto);
        final List<String> convertedList = new ArrayList<>();
        for (final Map.Entry<String, String> entry : convertedMap.entrySet()) {
            convertedList.add(entry.getKey() + entry.getValue());
        }
          return convertedList;
    }

    public static Map<String, String> convertDtoToMapExcept(final BaseDTO dto, List<String> exceptMembers) {
        final Map<String, String> convertedMap = convertDtoToMap(dto);
        for (String member : exceptMembers) {
            convertedMap.remove(member);
        }
        return convertedMap;
    }

    public static void setDto(final BaseDTO dto, List<String> listOfFields) {
        for (final String field : listOfFields) {
            ArrayList<String> fields = new ArrayList<>(asList(field.split(":")));
            String fieldName = convertToField(fields.get(0));
            if(fields.size() == 1) {
                fields.add(1, EMPTY);
            }
            try {
                FieldUtils.writeField(dto, fieldName, fields.get(1), true);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static BaseDTO getDtoFromName(final String name, final String packageName) {
        final String dtoName = name.replace(StringUtils.SPACE, EMPTY) + "DTO";
        final String propertyFileName = System.getProperty("env.config");
        final String application = propertyFileName.substring(0, propertyFileName.indexOf("_"));
        final String pathToDto = "com.aswatson.apex.taf.selenium.dto." + application + "." + packageName.replace(StringUtils.SPACE, EMPTY)
                .toLowerCase() + "." + dtoName;
        try {
            return (BaseDTO) Class.forName(pathToDto).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            LOGGER.error(String.format("Exception was thrown during creating instance of dto %s", dtoName) + e);
            return null;
        }
    }

    public static List<String> getFieldsValues(final BaseDTO dto, final List<String> listOfFields) {
        List<String> fieldsValues = new ArrayList<>();
        for (final String field : listOfFields) {
            String fieldName = convertToField(field);
            try {
                fieldsValues.add((String)FieldUtils.getField(dto.getClass(), fieldName, true).get(dto));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fieldsValues;
    }

    private static boolean isGetterMethod(final Method method) {
        return method.toString().contains("get") && !method.toString().contains("getClass");
    }

    private static String removePrefix(final Method method) {
        return method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
    }

    private static String firstLetterToUpperCase(final String fieldName) {
        return fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    private static String convertToField(final String fieldName) {
        return fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1).replaceAll(StringUtils.SPACE, EMPTY);
    }
}

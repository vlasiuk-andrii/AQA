package core.dto;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;

public class BaseDTO {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDTO.class);

    private static DateFormat[] DATE_FORMATS = new DateFormat[]{
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
            new SimpleDateFormat("dd-MM-yyyy")
    };

    protected BaseDTO() {
    }

    public Date parseDate(String value) {
        LOGGER.info(value);

        for (DateFormat format : DATE_FORMATS) {
            try {
                return format.parse(value);
            } catch (ParseException ex) {
                LOGGER.info(String.format("%s: %s", format, ex.getMessage()));
            }
        }

        return null;
    }

    @Override
    public boolean equals(final Object obj) {
        return reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }
}

package properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.google.common.base.Preconditions.checkNotNull;

public final class PropertiesHolder {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesHolder.class);
    private static PropertiesHolder instance = new PropertiesHolder();
    private final Properties properties = new Properties();

    private PropertiesHolder() {
        loadProperties(System.getProperty("user.dir"));
    }

    public static String getProperty(final String propertyName) {
        return System.getProperty(propertyName, instance.properties.getProperty(propertyName));
    }

    public static String setProperty(final String propertyName, final String propertyValue) {
        return System.setProperty(propertyName, propertyValue);
    }

    private void loadProperties(final String resource) {
        String propertyFilePath = resource + "\\target\\test-classes\\test.properties";
        LOGGER.debug("Reading environment properties: {}", propertyFilePath);
        try (final InputStream inputStream = new FileInputStream(propertyFilePath)) {
            checkNotNull(inputStream, "Environment properties file was not specified.");
            final Properties props = new Properties();
            props.load(inputStream);
            for (final String propertyName : props.stringPropertyNames()) {
                if (propertyName.startsWith("+")) {
                    loadProperties(propertyName.substring(1));
                }
            }
            properties.putAll(props);
        } catch (final IOException e) {
            throw new IllegalStateException("Failed to load environment configuration file", e);
        } catch (final NullPointerException e) {
            throw new IllegalStateException("Unable to read properties file: " + propertyFilePath, e);
        }
    }

}
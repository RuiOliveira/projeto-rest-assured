package utils;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Config {
    private static final String environmentPrefix;

    static {
        environmentPrefix = System.getProperty("environmentKey", "QC") + ".";
    }

    public static void updateAndSaveProperty(String property, String value) {
        Configurations configs = new Configurations();

        try {
            // obtain the configuration
            FileBasedConfigurationBuilder<PropertiesConfiguration> builder = configs.propertiesBuilder("env.properties");
            PropertiesConfiguration config = builder.getConfiguration();

            // update property
            config.setProperty(environmentPrefix + property, value);

            //save configuration
            builder.save();
        } catch (ConfigurationException cex) {
            System.out.println("Exception updating property: " + cex);
        }
    }

    public static String getPropertyValue(String property) {
        Configurations configs = new Configurations();
        String value = "";
        try {
            // obtain the configuration
            FileBasedConfigurationBuilder<PropertiesConfiguration> builder = configs.propertiesBuilder("env.properties");
            PropertiesConfiguration config = builder.getConfiguration();

            // get property
            value = config.getString(environmentPrefix + property);
            return value;
        } catch (ConfigurationException cex) {
            System.out.println("Exception getting property value: " + cex);
        }
        return value;
    }
}
package envReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentPropertiesReader {
	
	public static Properties properties;

    public static Properties getProperties() throws IOException
    {
        FileInputStream fis = new FileInputStream("src/main/resources/env.properties");

        properties = new Properties();

        properties.load(fis);

        fis.close();

        return properties;
    }

    public static String getProperty(String key) throws IOException
    {
        return getProperties().getProperty(key);
    }

}

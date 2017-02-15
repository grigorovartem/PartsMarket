package Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    private static final Settings settings = new Settings();

    private final Properties properties= new Properties();

    public Settings() {
        try {
            properties.load(new FileInputStream(this.getClass().getClassLoader().getResource("spm.properties").getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Settings getInstance(){return settings;}

    public String value(String key){
        return this.properties.getProperty(key);
    }
}

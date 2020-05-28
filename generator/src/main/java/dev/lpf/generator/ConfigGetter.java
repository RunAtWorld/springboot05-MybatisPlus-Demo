package dev.lpf.generator;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * ConfigGetter
 */
public class ConfigGetter {

    /**
     * 配置文件名
     */
    private String configFilePath = System.getProperty("user.dir") + "/generator.propertie";

    private Properties properties;

    public ConfigGetter(String configFilePath) {
        this.configFilePath = configFilePath;
        loadProPerty();
    }

    public ConfigGetter() {
        loadProPerty();
    }

    public static ConfigGetter getOneConfigGetter() {
        return new ConfigGetter();
    }

    public static ConfigGetter getOneConfigGetter(String configFilePath) {
        return new ConfigGetter(configFilePath);
    }

    private Properties loadProPerty() {
        try {
            URL url = ClassLoader.getSystemResource(this.configFilePath);
            FileInputStream fis = new FileInputStream(url.getFile());
            this.properties = new Properties();
            this.properties.load(fis);
            return this.properties;
        } catch (IOException e) {
            System.out.println("can't find the file:" + this.configFilePath);
        }
        return null;
    }

    public String getConfigProp(String configProName) {
        return this.properties.getProperty(configProName);
    }

}

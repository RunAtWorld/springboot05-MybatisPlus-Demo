package dev.lpf.generator;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ConfigGetter {

    /**
     * 配置文件名
     */
    private String configFilePath = System.getProperty("user.dir")+"/generator.propertie";

    private Properties properties;

    public ConfigGetter(String configFilePath){
        this.configFilePath =configFilePath;
        loadProPerty(this.configFilePath);
    }

    private void loadProPerty(String configFilePath){
        try {
            // URL url = ClassLoader.getSystemResource(configFilePath);
            System.out.println(configFilePath);
            // System.out.println(url);
            // FileInputStream fis = new FileInputStream(url.getFile());
            FileInputStream fis = new FileInputStream("F:\\myGitRepo\\springboot05-MybatisPlus-Demo\\generator\\generator.properties");
            this.properties = new Properties();// 属性集合对象
            properties.load(fis);// 将属性文件流装载到Properties对象中
        } catch (IOException e) {
            System.out.println("can't find the file:"+ this.configFilePath);
        }
    }

    public String getConfigProp(String configProName){
        return this.properties.getProperty(configProName);
    }



}

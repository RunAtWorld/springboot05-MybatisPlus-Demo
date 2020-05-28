package generator;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ConfigEditor {

    public static void main(String[] args) throws IOException {
        // System.out.println(ConfigEditor.getConfigProp(
        //         // "generator.properties").getProperty("dbPassword"));;
        URL url = ClassLoader.getSystemResource("generator.properties");
        System.out.println(url);
        FileInputStream fis = new FileInputStream(url.getFile());
        Properties prop = new Properties();// 属性集合对象
        prop.load(fis);// 将属性文件流装载到Properties对象中
        //// 获取属性值，sitename已在文件中定义
        //System.out.println("获取属性值：url=" + prop.getProperty("url"));
        //System.out.println("获取属性值：username=" + prop.getProperty("username", "root"));
        //System.out.println("获取属性值：password=" + prop.getProperty("password"));
        //System.out.println("获取属性值：driver-class-name=" + prop.getProperty("driver-class-name", "com.mysql.jdbc.Driver"));
    }

    public static Properties getConfigProp(String filename) throws IOException {
        URL url = ClassLoader.getSystemResource(filename);
        System.out.println(url);
        FileInputStream fis = new FileInputStream(url.getFile());
        Properties prop = new Properties();// 属性集合对象
        prop.load(fis);// 将属性文件流装载到Properties对象中
        //// 获取属性值，sitename已在文件中定义
        //System.out.println("获取属性值：url=" + prop.getProperty("url"));
        //System.out.println("获取属性值：username=" + prop.getProperty("username", "root"));
        //System.out.println("获取属性值：password=" + prop.getProperty("password"));
        //System.out.println("获取属性值：driver-class-name=" + prop.getProperty("driver-class-name", "com.mysql.jdbc.Driver"));
        return prop;
    }


}
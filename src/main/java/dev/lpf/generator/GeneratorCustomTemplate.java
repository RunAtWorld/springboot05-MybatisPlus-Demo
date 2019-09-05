package dev.lpf.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 自定义模板，生成代码
 * 仅示例了mapper.xml文件
 * </p>
 */
public class GeneratorCustomTemplate {
    static String dbUrl;
    static String packageName;

    /**
     * 是否强制带上注解
     */
    boolean enableTableFieldAnnotation = false;
    /**
     * 生成的注解带上IdType类型
     */
    IdType tableIdType = null;
    /**
     * 是否去掉生成实体的属性名前缀
     */
    String[] fieldPrefix = null;
    /**
     * 生成的Service 接口类名是否以I开头
     * 默认是以I开头
     * user表 -> IUserService, UserServiceImpl
     */
    boolean serviceClassNameStartWithI = true;


    public static void main(String[] args) {
        new GeneratorCustomTemplate().generateCodeWithInjectConfig();
    }

    public void generateCodeWithInjectConfig() {
        String packageName = "dev.lpf";
        String moudleName = "user";
        enableTableFieldAnnotation = false;
        tableIdType = null;
        generateByTablesWithInjectConfig(packageName + "." + moudleName, "t_user");
    }

    private void generateByTablesWithInjectConfig(String packageName, String... tableNames) {
        String baseProjectPath = System.getProperty("user.dir");

        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/mydb1?useUnicode=true&characterEncoding=UTF-8" +
                "&allowMultiQueries=true";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setVersionFieldName("version")
                .setCapitalMode(true)
                .setEntityLombokModel(true)
                .setTablePrefix("t_")
                //.setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .entityTableFieldAnnotationEnable(enableTableFieldAnnotation)
                //.fieldPrefix(fieldPrefix)//test_id -> id, test_type -> type
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setIdType(tableIdType)
                .setAuthor("lpf")
                .setIdType(IdType.AUTO)
                .setBaseResultMap(true)
                .setOutputDir(baseProjectPath + "/src/main/java")
                .setFileOverride(true);
        if (!serviceClassNameStartWithI) {
            config.setServiceName("%sService");
        }

        //TemplateConfig templateConfig = new TemplateConfig().setXml("/templates/mapper.xml");//注意：不要带上.vm
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {//自定义参数
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        //自定义文件输出位置（非必须）
        List<FileOutConfig> fileOutList = new ArrayList<>();
        fileOutList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return baseProjectPath + "/src/main/resources/mybatis/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        injectionConfig.setFileOutConfigList(fileOutList);

        new AutoGenerator().setGlobalConfig(config)
                //.setTemplate(templateConfig)//自定义模板路径
                .setCfg(injectionConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("entity")
                ).execute();
    }

}

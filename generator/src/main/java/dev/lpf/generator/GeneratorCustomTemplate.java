package dev.lpf.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
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

    private final static String[] tablePrefix = new String[] {"h_"};

    static String[] tableNames = new String[] {"h_ncov","h_ncov_us"};

    static String mouduleName = "ncov";

    static String packageName = "cn.papertalk";

    static String dbUrl =
        "jdbc:mysql://127.0.0.1:3306/ncov?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8" +
            "&allowMultiQueries=true";

    static String dbUserName = "root";

    static String dbPassword = "123456";

    static String dbDriverName = "com.mysql.jdbc.Driver";

    private static String projectSrcPath = "/mpdemo";

    static String baseProjectPath = "F:\\src_papertalk\\ncovdata_service";

    private static String xmlTemplatePath = "/templates/mapper.xml.vm";

    /**
     * 是否强制带上注解
     */
    boolean enableTableFieldAnnotation = false;

    /**
     * 生成的注解带上IdType类型
     */
    com.baomidou.mybatisplus.annotation.IdType tableIdType = null;

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
        enableTableFieldAnnotation = false;
        tableIdType = null;
        generateByTablesWithInjectConfig(packageName, tableNames);
    }

    private void generateByTablesWithInjectConfig(String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
            .setUrl(dbUrl)
            .setUsername(dbUserName)
            .setPassword(dbPassword)
            .setDriverName(dbDriverName);
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setTablePrefix(tablePrefix);
        strategyConfig.setVersionFieldName("version")
            .setCapitalMode(true)
            .setEntityLombokModel(false)
            // .setDbColumnUnderline(true)
            .setNaming(NamingStrategy.underline_to_camel)
            .entityTableFieldAnnotationEnable(enableTableFieldAnnotation)
            // .fieldPrefix(fieldPrefix)//test_id -> id, test_type -> type
            .setInclude(tableNames);// 修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
            .setIdType(tableIdType)
            .setAuthor("RunAtWorld")
            .setBaseResultMap(true)
            .setOutputDir(baseProjectPath + "/src/main/java")
            .setFileOverride(true);
        if (!serviceClassNameStartWithI) {
            config.setServiceName("%sService");
        }

        // TemplateConfig templateConfig = new TemplateConfig().setXml(xmlTemplatePath);
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {// 自定义参数
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        // 自定义文件输出位置（非必须）
        List<FileOutConfig> fileOutList = new ArrayList<>();
        fileOutList.add(new FileOutConfig(xmlTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return baseProjectPath + "/src/main/resources/mybatis/mapper/" + tableInfo.getEntityName()
                    + "Mapper.xml";
            }
        });
        injectionConfig.setFileOutConfigList(fileOutList);

        new AutoGenerator().setGlobalConfig(config)
            // .setTemplate(templateConfig)
            .setCfg(injectionConfig)
            .setDataSource(dataSourceConfig)
            .setStrategy(strategyConfig)
            .setPackageInfo(new PackageConfig().setParent(packageName)
                .setModuleName(mouduleName)
                .setController("controller")
                .setEntity("entity"))
            .execute();
    }

}
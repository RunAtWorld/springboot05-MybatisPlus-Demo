package generator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * <p>
 * 测试生成代码
 * </p>
 */
public class GeneratorGeneralTemplate {

    public static void main(String[] args) {
        new GeneratorGeneralTemplate().generateCode();
    }

    public void generateCode() {
        String packageName = "dev.lpf";
        String moudleName = "user";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName + "." + moudleName, "t_user");
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        String baseProjectPath = System.getProperty("user.dir");

        //全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false)
                .setAuthor("lpf")
                .setOutputDir(baseProjectPath + "/src/main/java")
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }

        //数据库配置
        String dbUrl = "jdbc:mysql://127.0.0.1:32000/testdb?useUnicode=true&characterEncoding=UTF-8" +
                "&allowMultiQueries=true";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.jdbc.Driver");

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                //.setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(packageName)
                .setController("controller")
                .setEntity("entity");

        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .execute();
    }

}

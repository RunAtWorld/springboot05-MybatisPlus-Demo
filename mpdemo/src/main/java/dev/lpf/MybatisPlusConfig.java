package dev.lpf;

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@MapperScan({"dev.lpf.springboot05mybatisplusdemo.*.dao.mapper","dev.lpf.springboot05mybatisplusdemo.crm.check.dao" +
//        ".mapper"})
public class MybatisPlusConfig {
    /**
     * 自定义配置{@link MybatisSqlSessionFactoryBean}
     * 使用mp-boot-starter 完全可以去掉这些配置，使用yml配置方式, 这里只做示范
     */
    //@Bean
    //public SqlSessionFactory sqlSessionFactory(DataSource dataSource, GlobalConfiguration globalConfiguration) throws Exception {
    //    MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
    //    sqlSessionFactory.setDataSource(dataSource);
    //    //sqlSessionFactory.setTypeAliasesPackage("com.baomidou.springboot.entity");
    //    //sqlSessionFactory.setTypeEnumsPackage("com.baomidou.springboot.entity.enums");
    //    MybatisConfiguration configuration = new MybatisConfiguration();
    //    configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
    //    configuration.setJdbcTypeForNull(JdbcType.NULL);
    //    configuration.setMapUnderscoreToCamelCase(true);
    //    sqlSessionFactory.setConfiguration(configuration);
    //    PaginationInterceptor pagination = new PaginationInterceptor();
    //    sqlSessionFactory.setPlugins(new Interceptor[]{
    //            pagination,
    //            new PerformanceInterceptor()
    //    });
    //    sqlSessionFactory.setGlobalConfig(globalConfiguration);
    //    return sqlSessionFactory.getObject();
    //}

    @Bean
    public GlobalConfiguration globalConfiguration() {
        GlobalConfiguration conf = new GlobalConfiguration();
        conf.setIdType(1);
        //conf.setKeyGenerator(new H2KeyGenerator());
        return conf;
    }
}

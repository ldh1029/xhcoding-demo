//package com.example.demo.config;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.env.Environment;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
////@Configuration
//public class DynamicDataSourceProvider {
//    @Autowired
//    Environment env;
//    @Bean(destroyMethod = "close")
//    public HikariDataSource d1(){
//        HikariConfig config = new HikariConfig();
//        config.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//        config.setUsername(env.getProperty("spring.datasource.d1.username"));
//        config.setPassword(env.getProperty("spring.datasource.d1.password"));
//        config.setJdbcUrl(String.format(env.getProperty("spring.datasource.mysql-url"),
//                env.getProperty("spring.datasource.d1.ip-port"),
//                env.getProperty("spring.datasource.d1.db-name")));
////        config.setJdbcUrl(env.getProperty("spring.datasource.url"));
//        // 其他配置
//        config.setConnectionTimeout(30000);
//        config.setIdleTimeout(600000);
//        config.setMaxLifetime(1765000);
//        config.setMaximumPoolSize(15);
//        HikariDataSource dataSource = new HikariDataSource(config);
//        System.out.println("数据源tripdata注入成功" + dataSource + config);
//        return dataSource;
//    }
//
//    @Bean(destroyMethod = "close")
//    public HikariDataSource d2(){
//        HikariConfig config = new HikariConfig();
//        config.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//        config.setUsername(env.getProperty("spring.datasource.d2.username"));
//        config.setPassword(env.getProperty("spring.datasource.d2.password"));
//        config.setJdbcUrl(String.format(env.getProperty("spring.datasource.mysql-url"),
//                env.getProperty("spring.datasource.d2.ip-port"),
//                env.getProperty("spring.datasource.d2.db-name")));
//        // 其他配置
//        config.setConnectionTimeout(30000);
//        config.setIdleTimeout(600000);
//        config.setMaxLifetime(1765000);
//        config.setMaximumPoolSize(15);
//        HikariDataSource dataSource = null;
//        try{
//            dataSource = new HikariDataSource(config);
//        }catch (Exception e){
//            System.out.println("数据源d2注入失败切换d1");
//            dataSource = d1();}
//        System.out.println("数据源qunar注入成功" + dataSource  + config);
//        return dataSource;
//    }
//    @Bean("dataSource")
//    @Primary
//    @DependsOn({ "d1", "d2"})
//    public DynamicDataSource dataSource(@Qualifier("d1") DataSource ds1,
//                                        @Qualifier("d2") DataSource ds2) {
//        Map<Object, Object> targetDataSources = new HashMap<>(2);
//        targetDataSources.put(DBTypeEnum.PRIMARY.getValue(), ds1);
//        targetDataSources.put(DBTypeEnum.FOLLOW.getValue(), ds2);
//        DynamicDataSource dataSource = new DynamicDataSource();
//        dataSource.setTargetDataSources(targetDataSources);
//        dataSource.setDefaultTargetDataSource(ds1);
//        System.out.println("动态数据源注入成功");
//        return dataSource;
//    }
//}

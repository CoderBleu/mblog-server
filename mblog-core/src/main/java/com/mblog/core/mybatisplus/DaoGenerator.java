package com.mblog.core.mybatisplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * @Author: Lauy
 * @Date: 2022/08/28
 * @Description: 大于等于 mybatis plus 3.5.1，mybatis-plus-generator 3.5.2
 */
public class DaoGenerator {

    private static Logger logger = LoggerFactory.getLogger(DaoGenerator.class);

    private DataSource dataSource;
    private String moduleName;
    private Class referenceClass;
    private List<String> tables;
    private boolean withService = true;
    private boolean withMapperXml;


    public DaoGenerator setDataSource(DataSource dataSourceInfo) {
        this.dataSource = dataSourceInfo;
        return this;
    }

    public DaoGenerator setModuleName(String moduleName) {
        this.moduleName = moduleName;
        return this;
    }

    public DaoGenerator setReferenceClass(Class referenceClass) {
        this.referenceClass = referenceClass;
        return this;
    }

    public DaoGenerator setTables(List<String> tables) {
        this.tables = tables;
        return this;
    }

    public DaoGenerator setWithService(boolean withService) {
        this.withService = withService;
        return this;
    }

    public DaoGenerator setWithMapperXml(boolean withMapperXml) {
        this.withMapperXml = withMapperXml;
        return this;
    }

    public String getPackage() {
        String s = referenceClass.getPackage().toString();
        return s.substring(s.indexOf(" ") + 1);
    }

    public void run() {
        // 生成文件的根路径
        String fileOutputPath = getOutputPath();
        logger.debug("FileOutputPath:\t\t" + fileOutputPath);

        FastAutoGenerator.create(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword())
                .globalConfig(builder -> {
                    builder.author("MyBatis Plus Generator") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir() //禁止打开输出目录
                            //.dateType(DateType.TIME_PACK)
                            //.commentDate("yyyy-MM-dd")
                            .outputDir(getOutputPath());
                })
                .packageConfig(builder -> {
                    builder.parent(getPackage()) // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .entity("model") //设置entity包名
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .mapper("dao")
                            .xml("dao.mapper");

                })
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addTablePrefix(getTablePrefix())
                        .addInclude(tables.toArray(new String[tables.size()]))
                        //.controllerBuilder().enableRestStyle().enableHyphenStyle() // controller restful
                        .serviceBuilder().formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImpl")
                        .entityBuilder()
                        //.enableLombok()
                        .mapperBuilder().superClass(BaseMapper.class).formatMapperFileName("%sMapper")
                        .enableMapperAnnotation().formatXmlFileName("%sMapper")
                        .build())
                .templateConfig(builder -> {
                    // 实体类使用我们自定义模板
                    builder.controller(null);
                    builder.entity("/mybatis/templates/entity.java.vm");
                    builder.service("/mybatis/templates/service.java.vm");
                    builder.serviceImpl("/mybatis/templates/serviceImpl.java.vm");
                    builder.mapper("/mybatis/templates/mapper.java.vm");
                    if (withMapperXml) {
                        builder.xml("/mybatis/templates/mapper.xml.vm");
                    }
                })
                //.templateEngine(new VelocityTemplateEngine()) // 使用Freemarker引擎模板(需要导包)，默认的是Velocity引擎模板
                .execute();
    }

    public String getTablePrefix() {
        return moduleName + "_";
    }

    private String getOutputPath() {
        try {
            File file = new File(referenceClass.getResource("").toURI());
            String path = file.getAbsolutePath();
            String outputDir = path.substring(0, path.indexOf("target/classes/")) + "src/main/java/";
            return outputDir;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

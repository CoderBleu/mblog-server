package com.mblog.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * @Author: mowi
 * @Date: 2018/12/14
 * @Description:
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

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(true)
                .setAuthor("MyBatis Plus Generator")
                .setOutputDir(getOutputPath())
                .setFileOverride(true)
                .setMapperName("%sDao")
                .setServiceName("%sService");

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl(dataSource.getUrl())
                .setUsername(dataSource.getUsername())
                .setPassword(dataSource.getPassword())
                .setTypeConvert(new MySqlTypeConvert() {
                    @Override
                    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        return super.processTypeConvert(globalConfig, fieldType);
                    }
                });

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                // todo
                //.setSuperEntityClass(BaseModel.class.getName())
                //.setSuperMapperClass(BaseDao.class.getName())
                //.setSuperServiceImplClass(BaseServiceImpl.class.getName())
                //.setSuperServiceClass(BaseService.class.getName())
                .setTablePrefix(getTablePrefix())
                .setInclude(tables.toArray(new String[tables.size()]));

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(getPackage())
                .setMapper("dao")
                .setEntity("model")
                .setXml("dao/mapper");

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(null);
        templateConfig.setEntity("/mybatisplus/templates/entity.java.vm");
        templateConfig.setMapper("/mybatisplus/templates/mapper.java.vm");
        if (withMapperXml) {
            templateConfig.setXml("/mybatisplus/templates/mapper.xml.vm");
        } else {
            templateConfig.setXml(null);
        }
        if (withService) {
            templateConfig.setService("/mybatisplus/templates/service.java.vm");
            templateConfig.setServiceImpl("/mybatisplus/templates/serviceImpl.java.vm");
        } else {
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
        }

        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.setTemplate(templateConfig);

        autoGenerator.execute();
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

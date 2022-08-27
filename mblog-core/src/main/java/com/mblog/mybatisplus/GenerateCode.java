package com.mblog.mybatisplus;

import java.util.Arrays;

/**
 * @author lauy
 * @date 2022/8/25
 * @description
 */
public class GenerateCode {

    private static final DataSource BLOG = new DataSource("jdbc:mysql://127.0.0.1:3306/blog?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false",
            "root", "root");

    public static void main(String[] args) {
        new DaoGenerator()
                .setDataSource(BLOG)
                .setReferenceClass(GenerateCode.class)
                .setModuleName("")
                .setTables(Arrays.asList(
                        "deml"
                ))
                .run();
    }
}

package com.mblog.mybatisplus;

import java.util.Arrays;

/**
 * mall     https://github.com/macrozheng/mall/blob/master/pom.xml
 * jeecg-boot   https://github.com/jeecgboot/jeecg-boot
 */
public class DataSource {

    private String url;
    private String username;
    private String password;

    public DataSource(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

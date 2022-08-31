package com.mblog.core.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lauy
 * @date 2022/8/29
 * @description
 */
public class StringUtil {

    /**
     * 检验字符串是否是非null，非空且非空格
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        return StringUtils.isNotBlank(str);
    }

    /**
     * 检验字符串是否是null，空且空格
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    /**
     * 去空格.Null返回null
     * @param str
     * @return
     */
    public static String trim(String str) {
        return StringUtils.trim(str);
    }

    /**
     * 检查是否查到，返回boolean,null返回假
     * @param str
     * @param searchStr
     * @return
     */
    public static boolean trim(String str, String searchStr) {
        return StringUtils.contains(str, searchStr);
    }


}

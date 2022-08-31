package com.mblog.core.utils;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @author lauy
 * @date 2022/8/29
 * @description
 */
public class CollUtil {

    /**
     * 判断是否空Map或者null
     *
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return CollectionUtils.isEmpty(map);
    }

    /**
     * 判断是否空Map或者null
     *
     * @param map
     * @return
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * 判断是否空集合或者null
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }

    /**
     * 判断是否非空集合或者非null
     *
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

}

package com.starfall.springmvc.response;

import java.util.HashMap;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.response
 * @className ApiResultMap
 * @date 2019/8/17 16:44
 * @description ApiResultMap
 */
public class ApiResultMap<K, V> extends HashMap<K, V> {

    private static final long serialVersionUID = -2480998907522164671L;

    public ApiResultMap<K, V> add(K key, V value) {
        super.put(key, value);
        return this;
    }

}

package com.ycpetroleum.train.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代码有问题别找我！虽然是我写的，但是它们自己长歪了。
 *
 * @auther 刘泽旻
 * @date 2015/4/17
 * @time 15:43
 */
public class FastJsonTools {
    public static <T> T getBean(String jsonString ,Class<T> cls){
        T t = null;
        try {
            t = JSON.parseObject(jsonString, cls);
    }catch (Exception e){
        e.printStackTrace();
    }
    return t;
}
    public static <T> List<T> getBeanList(String jsonString ,Class<T> cls){
        List<T> list = new ArrayList<T>();
        try {
            list = JSON.parseArray(jsonString, cls);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static List<Map<String, Object>> getlistMap(String jsonString) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            // 两种写法
            // list = JSON.parseObject(jsonString, new
            // TypeReference<List<Map<String, Object>>>(){}.getType());

            list = JSON.parseObject(jsonString,
                    new TypeReference<List<Map<String, Object>>>() {
                    });
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;

    }
    public static Map<String, Object> getMap(String jsonString) {
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            map = JSON.parseObject(jsonString, new TypeReference<Map<String, Object>>() {
            });
        }catch (Exception e){

        }
        return map;
    }
}

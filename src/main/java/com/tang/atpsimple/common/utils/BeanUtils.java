package com.tang.atpsimple.common.utils;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：对象处理工具类
 *

 */
public class BeanUtils extends org.springframework.beans.BeanUtils {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    /**
     * 复制单个对象
     *
     * @param source
     * @param c
     * @param <T>
     * @return
     */
    public static <T> T copy(Object source, Class<T> c) {
        if (source == null) {
            return null;
        }
        try {
            T instance = c.newInstance();
            BeanUtils.copyProperties(source, instance);
            return instance;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 复制列表
     *
     * @param sources
     * @param c
     * @param <E>
     * @param <T>
     * @return
     */
    public static <E, T> List<T> copyList(List<E> sources, Class<T> c) {
        if (CollectionUtils.isEmpty(sources)) {
            return new ArrayList<>();
        }
        List<T> list = new ArrayList<>();
        for (E source : sources) {
            list.add(copy(source, c));
        }
        return list;
    }

    /***
     * 复制page内容
     * @param sources：源数据的查询到的list
     * @param c：目标数据结果的class
     * @param <E>：源的数据类型
     * @param <T>：目标的数据类型
     * @return
     */
    public static  <E, T> PageInfo<T> copyPage(List<E> sources, Class<T> c){
        PageInfo<E> sourcesPage = new PageInfo<>(sources);
        PageInfo<T> result = copy(sourcesPage,PageInfo.class);
        if(result == null){
            return null;
        }
        List<T> targetList = BeanUtils.copyList(sources,c);
        result.setList(targetList);
        return result;
    }
}

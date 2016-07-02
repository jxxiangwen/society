package cn.edu.shu.society.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;


public class BeanUtility {
    public static <T> T beanCopy(Object fromBean, Class<T> type) {
        T toBean = null;
        try {
            toBean = type.newInstance(); // 创建 JavaBean 对象
            if (fromBean == null || toBean == null) {
                return null;
            }
//            BeanCopier.create(fromBean.getClass(),toBean.getClass(),true);
            BeanUtils.copyProperties(fromBean, toBean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return toBean;
    }

    public static <T> T beanCopy(Object fromBean, Class<T> type,String... ignoreProperties) {
        T toBean = null;
        try {
            toBean = type.newInstance(); // 创建 JavaBean 对象
            if (fromBean == null || toBean == null) {
                return null;
            }
//            BeanCopier.create(fromBean.getClass(),toBean.getClass(),true);
            BeanUtils.copyProperties(fromBean, toBean,ignoreProperties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return toBean;
    }

    public static List convertOtherBeanList(List list, Class tartgetClass) {
        List resultList = new ArrayList<>();
        for (int i = 0; list != null && i < list.size(); i++) {
            resultList.add(beanCopy(list.get(i), tartgetClass));
        }
        return resultList;
    }
}
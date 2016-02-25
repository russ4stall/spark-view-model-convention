package com.russ4stall.spark;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by russellf on 2/25/2016.
 */
public class TemplateModelMapImpl implements TemplateModel {

    @Override
    public Object createModel(Object obj) {
        Map<String, Object> result = new HashMap<>();
        try {
            BeanInfo info = Introspector.getBeanInfo(obj.getClass());
            for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
                Method reader = pd.getReadMethod();
                if (reader != null)
                    result.put(pd.getName(), reader.invoke(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

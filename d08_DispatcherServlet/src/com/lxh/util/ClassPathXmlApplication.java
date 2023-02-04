package com.lxh.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplication implements BeanFactory {

    private Map<String, Object> beanMap = new HashMap<>();

    public ClassPathXmlApplication() {
        loadXml();
    }

    /**
     * 加载 applicationContext中的文件
     * bean标签中的id属性值作为beanMap容器的key，bean标签中的class属性值创建出来的对象转为beanMap容器的value
     */
    public void loadXml() {
        try {
            // 1.创建 SAXReader 对象来读取XML文件，并获取Document对象
            SAXReader reader = new SAXReader();
            Document document = reader.read(this.getClass().getClassLoader().getResourceAsStream("applicationContext.xml"));
//            System.out.println(document.asXML());
            // 2.获取根元素对象 <beans>
            Element rootElement = document.getRootElement();
//            System.out.println(rootElement.asXML());
            // 3.根据根元素对象获取所有的bean对象
            List<Element> beanList = rootElement.elements("bean");
            for (Element ele: beanList) {
                // 获取bean标签中的id属性值
                String id = ele.attributeValue("id");
                // 获取bean标签中的class属性值
                String className = ele.attributeValue("class");
                // 根据className使用反射创建一个对象实例
                Object obj = Class.forName(className).newInstance();
                // 将创建好的对象放到map容器中
                beanMap.put(id, obj);
                // 获取当前bean标签的property子标签
                List<Element> propertyList = ele.elements("property");
                for (Element e: propertyList) {
                    // 获取name属性值
                    String varName = e.attributeValue("name");
                    // 获取ref属性值
                    String ref = e.attributeValue("ref");
                }
            }

            for (Element ele: beanList) {
                // 获取当前bean标签的property子标签
                List<Element> propertyList = ele.elements("property");
                for (Element e: propertyList) {
                    // 获取name属性值, 该值为变量名，我们需要为变量名赋值为 ref 的值
                    String varName = e.attributeValue("name");
                    // 获取ref属性值
                    String ref = e.attributeValue("ref");
                    // 获取当前对象
                    Object obj = this.getBean(ele.attributeValue("id"));
                    // 获取当前对象obj的变量名为 varName 的变量
                    Field field = obj.getClass().getDeclaredField(varName);
                    field.setAccessible(true); // 保证当前属性是可访问的
                    // 为属性赋值
                    field.set(obj, getBean(ref));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String id) {
        return beanMap.get(id);
    }
}

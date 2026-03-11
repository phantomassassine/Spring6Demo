package org.example.bean;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2026/3/11 17:10
 * @Description: 模拟工厂的实现
 * 1、通过构造器得到相关配置文件
 * 2、通过dom4j解析xml文件，得到List   存放id和class
 * 3、通过反射实例化得到对象   Class.forName(类的全路径).newInstance(); 通过Map<id,Class>存储
 * 4、得到指定的实例化对象
 */

public class MyClassPathXmlApplicationContext implements MyFactory {

    private Map beans = new HashMap(); // 实例化后的对象放入map
    private List<MyBean> myBeans = new ArrayList<>(); // 存放已读取bean 配置信息

    /* 1、通过构造器得到相关配置文件 */
    public MyClassPathXmlApplicationContext(String xmlPath){

        /* 2、通过dom4j解析xml文件，得到List （存放id和class） */
        this.parseXml(xmlPath);

        /* 3、通过反射实例化得到对象Class.forName(类路径).newInstance();  通过Map存储 */
        instanceBean();
    }

    /**
     * 通过反射实例化得到对象
     * Class.forName(类的全路径).newInstance();
     * 通过Map<id,Class>存储
     */
    private void instanceBean() {
        // 对 myBeans 集合遍历，得到的每一个 MyBean 对象取出clazz属性，反射new对象
        if (myBeans != null && myBeans.size() > 0) {
            for (MyBean bean : myBeans){
                try {
                    // 通过 bean 对象得到class属性，然后根据class进行反射
                    Object object = Class.forName(bean.getClazz()).newInstance();
                    // 将id与实例化对象设置到map对象中
                    beans.put(bean.getId(), object);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    /**
     * 通过dom4j解析xml文件，得到List   存放id和class
     * 1、获取解析器
     * 2、得到配置文件的URL
     * 3、通过解析器解析xml文件（applicationContext.xml）
     * 4、通过xpath语法，获取beans标签下的所有bean标签
     * 5、通过指定语法解析文档对象，返回集合
     * 6、判断集合是否为空，遍历集合
     * 7、获取标签元素中的属性
     * 8、得到Bean对象，将Bean对象设置到集合中
     * @param xmlPath
     */
    private void parseXml(String xmlPath) {
        // 1、获取解析器
        SAXReader saxReader = new SAXReader();
        // 2、得到配置文件的URL
        URL url = this.getClass().getClassLoader().getResource(xmlPath);
        try {
            // 3、通过解析器解析xml文件（applicationContext.xml）
            Document document = saxReader.read(url);
            // 4、通过xpath语法，获取beans标签下的所有bean标签
            XPath xPath = document.createXPath("beans/bean");
            // 5、通过指定语法解析文档对象，返回集合
            List<Element> list = xPath.selectNodes(document);
            // 每个文档对象Element可以看一下长什么样：
            for (Element e : list){
                System.out.println("-->" + e);
            }
            // 6、判断集合是否为空，遍历集合 ：把文档对象转为 MyBean对象
            if (list != null && list.size() > 0) {
                for (Element e : list) {
                    String id = e.attributeValue("id");
                    String clazz = e.attributeValue("class");

                    // 封装为 MyBean对象
                    MyBean myBean = new MyBean(id, clazz);
                    myBeans.add(myBean);
                }
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 通过 id 获取 bean 对象
     * @param id
     * @return
     */
    @Override
    public Object getBean(String id) {
        Object object = beans.get(id);
        return object;
    }
}

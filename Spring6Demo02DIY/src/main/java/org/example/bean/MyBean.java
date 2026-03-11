package org.example.bean;

/**
 * @Date: 2026/3/11 17:06
 * @Description: bean对象，用来接收配置文件中bean标签的id与class属性值
 */

public class MyBean {
    private String id; //bean标签的id的属性值
    private String clazz; //bean标签的class的属性值

    public MyBean() {
    }

    public MyBean(String id, String clazz) {
        this.id = id;
        this.clazz = clazz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}

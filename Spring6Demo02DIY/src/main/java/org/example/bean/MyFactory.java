package org.example.bean;

/**
 * @Date: 2026/3/11 17:08
 * @Description: Bean工厂接口定义
 */

public interface MyFactory {
    public abstract Object getBean(String id);
}

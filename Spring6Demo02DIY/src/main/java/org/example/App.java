package org.example;

import org.example.bean.MyClassPathXmlApplicationContext;
import org.example.bean.MyFactory;
import org.example.pojo.Person;
import org.example.pojo.User;

/**
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // 构建工厂对象
        MyFactory myFactory = new MyClassPathXmlApplicationContext("myApplicationContext.xml");

        // 获取对象：
        Person person = (Person)myFactory.getBean("person");
        User user = (User)myFactory.getBean("user");
        // 调用对象的方法：
        person.eat();
        user.sleep();
    }
}

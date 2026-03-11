package org.example;

import org.example.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Spring通过加载xml配置文件，创建Spring容器。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中取出叫做p的bean
        Person person = applicationContext.getBean("person", Person.class);
        Person person2 = applicationContext.getBean("person", Person.class);

        // 这个结果为true，证明从容器中获取的对象是同一个对象
        System.out.println(person == person2);
        System.out.println(person);
        System.out.println(person2);
    }
}

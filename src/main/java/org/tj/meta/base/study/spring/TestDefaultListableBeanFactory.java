package org.tj.meta.base.study.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.tj.meta.base.study.spring.entities.Person;

import java.io.IOException;

/**
 * Created by 001 on 17/1/12.
 */
@ComponentScan(basePackages = "org.tj.meta.base.study.spring")
public class TestDefaultListableBeanFactory {

    public static void main(String[] args) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("beans.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(classPathResource);

        Person person = factory.getBean("person",Person.class);
        System.out.println(person.getHand());

        System.out.println(person.getName());
        System.out.println(classPathResource.getURL());
        System.out.println(classPathResource.getFile().getAbsolutePath());

        String fileUrl = classPathResource.getFile().getAbsolutePath();
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/beans.xml");
        Person person1 = (Person) factory.getBean("person");
        System.out.println(person1);
//        System.out.println(person1.getName());
//        DefaultListableBeanFactory


    }
}

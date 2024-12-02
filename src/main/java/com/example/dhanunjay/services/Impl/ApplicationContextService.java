package com.example.dhanunjay.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
// import org.springframework.stereotype.Service;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.example.dhanunjay.ExampleBean;
import com.example.dhanunjay.services.IApplicationContextService;

public class ApplicationContextService implements IApplicationContextService {

    @Autowired
    private ApplicationContext context;

    @Override
    public String[] getApplicationContext() {
        String[] beanNames = context.getBeanDefinitionNames();

        return beanNames;
    }

    @Override
    public String getClassPathContext() {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");) {
            ExampleBean exampleBean = (ExampleBean) context.getBean("exampleBean");
            return exampleBean.getMessage();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    @Override
    public String getFileSystemContext() {
        try (ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");) {
            ExampleBean exampleBean = (ExampleBean) context.getBean("exampleBean");
            return exampleBean.getMessage();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    @Override
    public String getWebXmlApplicationContext() {
        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocation("classpath:webApplicationContext.xml");

        context.refresh();

        ExampleBean exampleBean = context.getBean(ExampleBean.class);
        System.out.println(exampleBean.getMessage());
        context.close();

        return exampleBean.getMessage();
    }

    @Override
    public String testBeanCreatedFromXML() {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");) {
            ExampleBean exampleBean = (ExampleBean) context.getBean("exampleBean");
            return exampleBean.testBean();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

}

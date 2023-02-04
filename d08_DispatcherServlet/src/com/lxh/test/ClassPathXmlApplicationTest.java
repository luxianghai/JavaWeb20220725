package com.lxh.test;

import com.lxh.util.ClassPathXmlApplication;
import org.junit.Test;

public class ClassPathXmlApplicationTest {

    ClassPathXmlApplication xmlApplication = new ClassPathXmlApplication();

    @Test
    public void loadXml() {
        xmlApplication.loadXml();
    }

    @Test
    public void getBean() {
        Object user = xmlApplication.getBean("user");
        System.out.println(user);
    }

}

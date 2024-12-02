package com.example.dhanunjay.services;

public interface IApplicationContextService {

    String[] getApplicationContext();

    String getClassPathContext();

    String getFileSystemContext();

    String getWebXmlApplicationContext();

    String testBeanCreatedFromXML();
}

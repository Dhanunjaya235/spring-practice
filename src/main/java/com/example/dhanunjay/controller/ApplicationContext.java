package com.example.dhanunjay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dhanunjay.services.IApplicationContextService;

@RestController
@RequestMapping("/application")
public class ApplicationContext {

    @Autowired
    private IApplicationContextService applicationContextService;

    @GetMapping("/get-all-beans")
    public ResponseEntity<String[]> getApplicationContect() {
        String[] result = applicationContextService.getApplicationContext();
        return ResponseEntity.ok(result);

    }

    @GetMapping("/get-classpath-context")
    public ResponseEntity<String> getClasspathContext() {
        String result = applicationContextService.getClassPathContext();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-file-system-context")
    public ResponseEntity<String> getFileSystemContext() {
        String result = applicationContextService.getFileSystemContext();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-web-xml-context")
    public ResponseEntity<String> getWebXmlApplicationContext() {
        String result = applicationContextService.getFileSystemContext();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/test-bean-created-from-xml")
    public ResponseEntity<String> testBeanCreatedFromXML() {
        String result = applicationContextService.testBeanCreatedFromXML();

        return ResponseEntity.ok(result);
    }

}

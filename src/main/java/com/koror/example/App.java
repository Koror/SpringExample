package com.koror.example;

import com.koror.example.service.annotation.ElementalService;
import com.koror.example.service.xml.WizardService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        WizardService wizardService = context.getBean("wizardService", WizardService.class);
        System.out.println(wizardService.getAction());

        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();
        annotationContext.scan("com.koror");
        annotationContext.refresh();
        ElementalService elementalService = annotationContext.getBean("elementalService", ElementalService.class);
        System.out.println(elementalService.getAction());
    }
}

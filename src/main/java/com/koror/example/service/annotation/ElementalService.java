package com.koror.example.service.annotation;

import com.koror.example.annotation.RandomService;
import com.koror.example.api.service.IElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ElementalService {

    @Autowired
    private IElementService lightService;

    @Autowired
    private IElementService darkService;

    @RandomService
    @Qualifier("lightService")
    @Autowired
    private IElementService randomService;

    @PostConstruct
    public void generateRandom() {
        System.out.println("random is " + randomService.getClass().getSimpleName());
    }

    public void setAction(String darkAction, String lightAction) {
        lightService.setAction(lightAction);
        darkService.setAction(darkAction);
    }

    public String getAction() {
        return lightService.getAction() + " " + darkService.getAction() + "  random: " + randomService.getAction();
    }
}

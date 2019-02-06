package com.koror.example.postprocessor;

import com.koror.example.annotation.RandomService;
import com.koror.example.service.annotation.ElementalService;
import com.koror.example.service.annotation.DarkService;
import com.koror.example.service.annotation.LightService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeforeInitialization : " + beanName);
        if (bean instanceof ElementalService) {
            try {
                Random random = new Random();
                int rand = random.nextInt(10);
                for (Field field : bean.getClass().getDeclaredFields()) {
                    if (field.isAnnotationPresent(RandomService.class)) {
                        field.setAccessible(true);
                        if (rand >= 5)
                            field.set(bean, new DarkService());
                        else
                            field.set(bean, new LightService());
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
}

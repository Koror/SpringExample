package com.koror.example.api.service;

import org.springframework.stereotype.Component;

@Component("elementService")
public interface IElementService {

    String getAction();

    void setAction(String action);

}

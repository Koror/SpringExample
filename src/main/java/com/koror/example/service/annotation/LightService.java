package com.koror.example.service.annotation;

import com.koror.example.api.service.IElementService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class LightService implements IElementService {

    @Getter
    @Setter
    private String action = "LightRay";

}

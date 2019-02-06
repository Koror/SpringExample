package com.koror.example.service.xml;

import com.koror.example.api.service.IElementService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;

@Getter
@Setter
public class WizardService {

    @Qualifier(value = "fireService")
    IElementService fireService;

    @Qualifier(value = "iceService")
    IElementService iceService;

    public void setAction(String iceAction, String fireAction){
        fireService.setAction(fireAction);
        iceService.setAction(iceAction);
    }

    public String getAction(){
        return fireService.getAction() + " " + iceService.getAction();
    }
}

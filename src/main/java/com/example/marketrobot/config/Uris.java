package com.example.marketrobot.config;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class Uris {
    private String uriCreateOrder;
    private String uriCancelOrder;

    public String getUriCreateOrder() {
        return uriCreateOrder;
    }

    public void setUriCreateOrder(String uriCreateOrder) {
        this.uriCreateOrder = uriCreateOrder;
    }

    public String getUriCancelOrder() {
        return uriCancelOrder;
    }

    public void setUriCancelOrder(String uriCancelOrder) {
        this.uriCancelOrder = uriCancelOrder;
    }
}

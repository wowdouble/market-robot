package com.example.marketrobot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "market")
public class Config {

    private Map<String,Exchange> exchanges;

    public Map<String, Exchange> getExchanges() {
        return exchanges;
    }

    public void setExchanges(Map<String, Exchange> exchanges) {
        this.exchanges = exchanges;
    }

}

package com.example.marketrobot.config;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class Exchange {
    private String website;
    private String sellpriKey;
    private String sellpubKey;
    private String buypriKey;
    private String buypubKey;
    private long waitTimes;
    private int buyfluctuate;
    private int sellfluctuate;
    private String sellBasePrice;
    private String buyBasePrice;
    private int priceScale;
    private int amountFluctuate;
    private String buyamount;
    private String sellAmount;
    private int buyOrderRatio;
    private Uris uris;
    private String symbol;
    private String buyType;
    private String sellType;

    private boolean stopBuy;
    private boolean stopSell;

    public int getBuyfluctuate() {
        return buyfluctuate;
    }

    public int getBuyOrderRatio() {
        return buyOrderRatio;
    }

    public int getPriceScale() {
        return priceScale;
    }

    public int getSellfluctuate() {
        return sellfluctuate;
    }

    public long getWaitTimes() {
        return waitTimes;
    }

    public int getAmountFluctuate() {
        return amountFluctuate;
    }

    public String getBuyamount() {
        return buyamount;
    }

    public String getBuypriKey() {
        return buypriKey;
    }

    public String getBuypubKey() {
        return buypubKey;
    }

    public String getSellAmount() {
        return sellAmount;
    }

    public String getBuyType() {
        return buyType;
    }

    public String getSellpubKey() {
        return sellpubKey;
    }

    public String getSellpriKey() {
        return sellpriKey;
    }

    public Uris getUris() {
        return uris;
    }

    public void setAmountFluctuate(int amountFluctuate) {
        this.amountFluctuate = amountFluctuate;
    }

    public void setBuyamount(String buyamount) {
        this.buyamount = buyamount;
    }

    public void setBuyOrderRatio(int buyOrderRatio) {
        this.buyOrderRatio = buyOrderRatio;
    }

    public void setBuyfluctuate(int buyfluctuate) {
        this.buyfluctuate = buyfluctuate;
    }

    public void setBuypriKey(String buypriKey) {
        this.buypriKey = buypriKey;
    }

    public void setPriceScale(int priceScale) {
        this.priceScale = priceScale;
    }

    public void setBuypubKey(String buypubKey) {
        this.buypubKey = buypubKey;
    }

    public void setSellpriKey(String sellpriKey) {
        this.sellpriKey = sellpriKey;
    }

    public void setSellpubKey(String sellpubKey) {
        this.sellpubKey = sellpubKey;
    }

    public void setWaitTimes(long waitTimes) {
        this.waitTimes = waitTimes;
    }

    public void setSellfluctuate(int sellfluctuate) {
        this.sellfluctuate = sellfluctuate;
    }

    public void setSellAmount(String sellAmount) {
        this.sellAmount = sellAmount;
    }

    public void setUris(Uris uris) {
        this.uris = uris;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType;
    }

    public String getSellType() {
        return sellType;
    }

    public void setSellType(String sellType) {
        this.sellType = sellType;
    }

    public String getSellBasePrice() {
        return sellBasePrice;
    }

    public void setSellBasePrice(String sellBasePrice) {
        this.sellBasePrice = sellBasePrice;
    }

    public String getBuyBasePrice() {
        return buyBasePrice;
    }

    public void setBuyBasePrice(String buyBasePrice) {
        this.buyBasePrice = buyBasePrice;
    }

    public boolean isStopBuy() {
        return stopBuy;
    }

    public void setStopBuy(boolean stopBuy) {
        this.stopBuy = stopBuy;
    }

    public boolean isStopSell() {
        return stopSell;
    }

    public void setStopSell(boolean stopSell) {
        this.stopSell = stopSell;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}

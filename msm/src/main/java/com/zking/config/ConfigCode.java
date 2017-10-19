package com.zking.config;

public enum ConfigCode {
    bushu("部署提交信息为空");


    private final String value;

    private ConfigCode(String value)
    {

        this.value = value;
    }

    public String getValue()
    {

        return value;
    }

}

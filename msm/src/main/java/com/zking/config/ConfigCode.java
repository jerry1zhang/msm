package com.zking.config;

public enum ConfigCode {
    bushu("部署提交信息为空"),
    user_error_1("用户密码错误"),
    page_title_1("保健品"),
    page_title_2("销售信息管理系统");


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

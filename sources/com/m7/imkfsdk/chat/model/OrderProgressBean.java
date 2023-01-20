package com.m7.imkfsdk.chat.model;

import java.util.List;

/* loaded from: classes2.dex */
public class OrderProgressBean {
    private String empty_message;
    private List<OrderProgressInfoBean> list;
    private String list_num;
    private String list_title;
    private String message;
    private OrderInfoParams params;

    public String getEmpty_message() {
        return this.empty_message;
    }

    public List<OrderProgressInfoBean> getList() {
        return this.list;
    }

    public String getList_num() {
        return this.list_num;
    }

    public String getList_title() {
        return this.list_title;
    }

    public String getMessage() {
        return this.message;
    }

    public OrderInfoParams getParams() {
        return this.params;
    }

    public OrderProgressBean setEmpty_message(String str) {
        this.empty_message = str;
        return this;
    }

    public OrderProgressBean setList(List<OrderProgressInfoBean> list) {
        this.list = list;
        return this;
    }

    public OrderProgressBean setList_num(String str) {
        this.list_num = str;
        return this;
    }

    public OrderProgressBean setList_title(String str) {
        this.list_title = str;
        return this;
    }

    public OrderProgressBean setMessage(String str) {
        this.message = str;
        return this;
    }

    public OrderProgressBean setParams(OrderInfoParams orderInfoParams) {
        this.params = orderInfoParams;
        return this;
    }
}

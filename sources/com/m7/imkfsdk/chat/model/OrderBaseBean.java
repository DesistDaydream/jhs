package com.m7.imkfsdk.chat.model;

/* loaded from: classes2.dex */
public class OrderBaseBean {
    private String current;
    private OrderBaseDataBean data;
    private String resp_type;

    public String getCurrent() {
        return this.current;
    }

    public OrderBaseDataBean getData() {
        return this.data;
    }

    public String getResp_type() {
        return this.resp_type;
    }

    public OrderBaseBean setCurrent(String str) {
        this.current = str;
        return this;
    }

    public OrderBaseBean setData(OrderBaseDataBean orderBaseDataBean) {
        this.data = orderBaseDataBean;
        return this;
    }

    public OrderBaseBean setResp_type(String str) {
        this.resp_type = str;
        return this;
    }
}

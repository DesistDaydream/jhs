package com.m7.imkfsdk.chat.model;

/* loaded from: classes2.dex */
public class MsgTaskItemBean {
    private String page;
    private OrderInfoParams params;
    private String target;

    public String getPage() {
        return this.page;
    }

    public OrderInfoParams getParams() {
        return this.params;
    }

    public String getTarget() {
        return this.target;
    }

    public MsgTaskItemBean setPage(String str) {
        this.page = str;
        return this;
    }

    public MsgTaskItemBean setParams(OrderInfoParams orderInfoParams) {
        this.params = orderInfoParams;
        return this;
    }

    public MsgTaskItemBean setTarget(String str) {
        this.target = str;
        return this;
    }
}

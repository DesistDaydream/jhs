package com.m7.imkfsdk.chat.model;

/* loaded from: classes2.dex */
public class MsgTaskBean {
    private String current;
    private MsgTaskItemBean item;

    public String getCurrent() {
        return this.current;
    }

    public MsgTaskItemBean getItem() {
        return this.item;
    }

    public MsgTaskBean setCurrent(String str) {
        this.current = str;
        return this;
    }

    public MsgTaskBean setItem(MsgTaskItemBean msgTaskItemBean) {
        this.item = msgTaskItemBean;
        return this;
    }
}

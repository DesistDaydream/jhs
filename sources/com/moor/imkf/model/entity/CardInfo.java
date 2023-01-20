package com.moor.imkf.model.entity;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class CardInfo implements Serializable {
    public String concent;
    public String icon;
    public String name;
    public String title;
    public String url;

    public CardInfo(String str, String str2, String str3, String str4, String str5) {
        this.icon = str;
        this.title = str2;
        this.name = str3;
        this.concent = str4;
        this.url = str5;
    }

    public CardInfo() {
    }
}

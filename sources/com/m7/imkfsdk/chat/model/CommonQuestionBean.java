package com.m7.imkfsdk.chat.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class CommonQuestionBean implements Serializable {
    private String tabContent;
    private String tabId;

    public String getTabContent() {
        return this.tabContent;
    }

    public String getTabId() {
        return this.tabId;
    }

    public void setTabContent(String str) {
        this.tabContent = str;
    }

    public void setTabId(String str) {
        this.tabId = str;
    }
}

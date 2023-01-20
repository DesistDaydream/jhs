package com.moor.imkf.model.entity;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class UploadFileBean implements Serializable {
    private String LocalUrl;
    private String name;
    private String url;

    public String getLocalUrl() {
        return this.LocalUrl;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setLocalUrl(String str) {
        this.LocalUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}

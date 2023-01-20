package com.moor.imkf.model.entity;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class Peer implements Serializable {
    private String id;
    private String name;
    private String status;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}

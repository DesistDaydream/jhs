package com.moor.imkf.model.entity;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class Schedule implements Serializable {
    public String name;
    public String processTo;
    public String processType;

    public String getName() {
        return this.name;
    }

    public String getProcessTo() {
        return this.processTo;
    }

    public String getProcessType() {
        return this.processType;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setProcessTo(String str) {
        this.processTo = str;
    }

    public void setProcessType(String str) {
        this.processType = str;
    }
}

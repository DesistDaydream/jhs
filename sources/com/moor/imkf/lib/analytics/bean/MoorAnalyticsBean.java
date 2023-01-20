package com.moor.imkf.lib.analytics.bean;

import com.j256.ormlite.field.DatabaseField;

/* loaded from: classes2.dex */
public class MoorAnalyticsBean {
    @DatabaseField
    private String analyticsStr;
    @DatabaseField(generatedId = true, unique = true)
    public long id;

    public String getAnalyticsStr() {
        return this.analyticsStr;
    }

    public void setAnalyticsStr(String str) {
        this.analyticsStr = str;
    }
}

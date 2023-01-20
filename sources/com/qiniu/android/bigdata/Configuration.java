package com.qiniu.android.bigdata;

import com.qiniu.android.http.ProxyConfiguration;

/* loaded from: classes3.dex */
public final class Configuration implements Cloneable {
    public ProxyConfiguration proxy;
    public String pipelineHost = "https://pipeline.qiniu.com";
    public int connectTimeout = 3;
    public int responseTimeout = 10;

    public static Configuration copy(Configuration configuration) {
        if (configuration == null) {
            return new Configuration();
        }
        try {
            return configuration.m38clone();
        } catch (CloneNotSupportedException unused) {
            return new Configuration();
        }
    }

    /* renamed from: clone */
    public Configuration m38clone() throws CloneNotSupportedException {
        return (Configuration) super.clone();
    }
}

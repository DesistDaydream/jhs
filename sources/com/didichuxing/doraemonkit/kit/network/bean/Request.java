package com.didichuxing.doraemonkit.kit.network.bean;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Request implements Serializable {
    public String encode;
    public String headers;
    public String method;
    public String postData;
    public String url;

    public boolean filter(String text) {
        return false;
    }

    public String toString() {
        return "";
    }
}

package com.didichuxing.doraemonkit.kit.network.bean;

import java.io.Serializable;

/* loaded from: classes.dex */
public class NetworkRecord implements Serializable {
    public long endTime;
    public String mPlatform;
    public Request mRequest;
    public int mRequestId;
    public Response mResponse;
    public String mResponseBody;
    public long requestLength;
    public long responseLength;
    public long startTime;

    public boolean filter(String text) {
        return false;
    }

    public boolean isGetRecord() {
        return false;
    }

    public boolean isPostRecord() {
        return false;
    }
}

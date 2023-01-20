package com.tencent.qcloud.tuikit.tuichat;

/* loaded from: classes3.dex */
public class OutInject {
    private static OutInject instance;
    private IRequest mIRequest;

    private OutInject() {
    }

    public static OutInject getInstance() {
        if (instance == null) {
            instance = new OutInject();
        }
        return instance;
    }

    public IRequest getRequest() {
        return this.mIRequest;
    }

    public void setRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
    }
}

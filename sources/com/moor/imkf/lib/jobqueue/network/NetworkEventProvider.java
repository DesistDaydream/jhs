package com.moor.imkf.lib.jobqueue.network;

/* loaded from: classes2.dex */
public interface NetworkEventProvider {

    /* loaded from: classes2.dex */
    public interface Listener {
        void onNetworkChange(int i2);
    }

    void setListener(Listener listener);
}

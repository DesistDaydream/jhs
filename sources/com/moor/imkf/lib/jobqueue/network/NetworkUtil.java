package com.moor.imkf.lib.jobqueue.network;

import android.content.Context;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public interface NetworkUtil {
    public static final int DISCONNECTED = 0;
    public static final int METERED = 1;
    public static final int UNMETERED = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface NetworkStatus {
    }

    int getNetworkStatus(Context context);
}

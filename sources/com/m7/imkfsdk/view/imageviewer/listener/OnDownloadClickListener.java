package com.m7.imkfsdk.view.imageviewer.listener;

import android.app.Activity;
import android.view.View;

/* loaded from: classes2.dex */
public abstract class OnDownloadClickListener {
    public abstract boolean isInterceptDownload();

    public abstract void onClick(Activity activity, View view, int i2);
}

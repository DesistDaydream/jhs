package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes2.dex */
public abstract class DialogRedirect implements DialogInterface.OnClickListener {
    public static DialogRedirect getInstance(Activity activity, Intent intent, int i2) {
        return new DialogRedirectImpl(intent, activity, i2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        try {
            try {
                redirect();
            } finally {
                dialogInterface.dismiss();
            }
        } catch (Throwable unused) {
            HMSLog.e("DialogRedirect", "Failed to start resolution intent");
        }
    }

    public abstract void redirect();
}

package com.bytedance.mapplog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bykvm_19do.bykvm_19do.bykvm_19do.l0;
import bykvm_19do.bykvm_19do.bykvm_19do.v1;

/* loaded from: classes.dex */
public class Collector extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("EMBED_K_DATA");
        if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
            l0.a(null);
        } else {
            v1.a(stringArrayExtra);
        }
    }
}

package com.tencent.android.tpush.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;

/* loaded from: classes3.dex */
public class b {
    private static volatile C0219b a;

    /* loaded from: classes3.dex */
    public static class a extends TTask {
        private Context a;
        private Intent b;

        public a(Context context, Intent intent) {
            this.a = null;
            this.b = null;
            this.a = context;
            this.b = intent;
        }

        @Override // com.tencent.tpns.baseapi.base.util.TTask
        public void TRun() {
            String action = this.b.getAction();
            if (action == null) {
                return;
            }
            if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action)) {
                TLogger.d("AppChangesHandler", "action:" + action);
            }
        }
    }

    /* renamed from: com.tencent.android.tpush.common.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0219b extends BroadcastReceiver {
        private C0219b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || context == null) {
                return;
            }
            CommonWorkingThread.getInstance().execute(new a(context, intent));
        }
    }

    public static void a(Context context) {
        try {
            if (a == null) {
                synchronized (b.class) {
                    if (a == null) {
                        a = new C0219b();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addDataScheme("package");
                        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                        BroadcastAgent.registerReceiver(context, a, intentFilter);
                    }
                }
            }
        } catch (Throwable th) {
            TLogger.e("AppChangesHandler", "AppChangesHandler setupHandler error", th);
        }
    }
}

package com.tencent.android.tpush.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import org.apache.http.HttpHost;

/* loaded from: classes3.dex */
public class b {
    private static volatile b a;
    private volatile int b = 2;

    /* renamed from: c */
    private volatile String f6408c = "";

    /* renamed from: d */
    private volatile HttpHost f6409d = null;

    /* renamed from: e */
    private Context f6410e;

    /* renamed from: f */
    private com.tencent.android.tpush.stat.b.c f6411f;

    private b(Context context) {
        this.f6410e = null;
        this.f6411f = null;
        this.f6410e = context.getApplicationContext();
        f.a(context);
        this.f6411f = com.tencent.android.tpush.stat.b.b.b();
        f();
        d();
    }

    private void f() {
        this.b = 0;
        this.f6409d = null;
        this.f6408c = null;
    }

    public String a() {
        return this.f6408c;
    }

    public boolean b() {
        return this.b == 1;
    }

    public boolean c() {
        return this.b != 0;
    }

    public void d() {
        if (DeviceInfos.isNetworkAvailable(this.f6410e)) {
            this.f6408c = DeviceInfos.getLinkedWay(this.f6410e);
            if (d.b()) {
                com.tencent.android.tpush.stat.b.c cVar = this.f6411f;
                cVar.b("NETWORK name:" + this.f6408c);
            }
            if (com.tencent.android.tpush.stat.b.b.c(this.f6408c)) {
                if ("WIFI".equalsIgnoreCase(this.f6408c)) {
                    this.b = 1;
                } else {
                    this.b = 2;
                }
                this.f6409d = com.tencent.android.tpush.stat.b.b.b(this.f6410e);
                return;
            }
            return;
        }
        if (d.b()) {
            this.f6411f.b("NETWORK TYPE: network is close.");
        }
        f();
    }

    @JgMethodChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK})
    public void e() {
        try {
            this.f6410e.getApplicationContext().registerReceiver(new BroadcastReceiver() { // from class: com.tencent.android.tpush.stat.b.1
                {
                    b.this = this;
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.stat.b.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // com.tencent.tpns.baseapi.base.util.TTask
                        public void TRun() {
                            b.this.d();
                        }
                    });
                }
            }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Throwable th) {
            TLogger.e("registerBroadcast", "", th);
        }
    }

    public static b a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        }
        return a;
    }
}

package com.meizu.cloud.pushsdk.b;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.xiaomi.mipush.sdk.Constants;
import e.t.u.b0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class b implements f {

    /* renamed from: j  reason: collision with root package name */
    private ThreadPoolExecutor f4638j;

    /* renamed from: d  reason: collision with root package name */
    private long f4632d = 60;

    /* renamed from: e  reason: collision with root package name */
    private int f4633e = 10;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4637i = false;
    private final SimpleDateFormat a = new SimpleDateFormat(b0.a.r);
    private final List<a> b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    private final Handler f4631c = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    private String f4635g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";

    /* renamed from: f  reason: collision with root package name */
    private final e f4634f = new e();

    /* renamed from: h  reason: collision with root package name */
    private final String f4636h = String.valueOf(Process.myPid());

    /* loaded from: classes2.dex */
    public class a {
        public final String a;
        public final String b;

        /* renamed from: c  reason: collision with root package name */
        public final String f4641c;

        public a(String str, String str2, String str3) {
            this.a = b.this.a.format(new Date()) + ExpandableTextView.N + b.this.f4636h + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Thread.currentThread().getId() + ExpandableTextView.N + str + MqttTopic.TOPIC_LEVEL_SEPARATOR;
            this.b = str2;
            this.f4641c = str3;
        }
    }

    public b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new j().a("log-pool-%d").a());
        this.f4638j = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private void a(a aVar) {
        try {
            this.b.add(aVar);
        } catch (Exception e2) {
            Log.e("Logger", "add logInfo error " + e2.getMessage());
        }
    }

    private void b() {
        if (this.b.size() == 0) {
            this.f4631c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.f4632d * 1000);
        }
    }

    private void c() {
        if (this.b.size() == this.f4633e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(String str) {
        this.f4635g = str;
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(String str, String str2) {
        if (this.f4637i) {
            Log.d(str, str2);
        }
        synchronized (this.b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(String str, String str2, Throwable th) {
        if (this.f4637i) {
            Log.e(str, str2, th);
        }
        synchronized (this.b) {
            b();
            a(new a(ExifInterface.LONGITUDE_EAST, str, str2 + "\n" + Log.getStackTraceString(th)));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(boolean z) {
        ThreadPoolExecutor threadPoolExecutor;
        Runnable runnable = new Runnable() { // from class: com.meizu.cloud.pushsdk.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<a> arrayList;
                b bVar;
                synchronized (b.this.b) {
                    b.this.f4631c.removeCallbacksAndMessages(null);
                    arrayList = new ArrayList(b.this.b);
                    b.this.b.clear();
                }
                try {
                    try {
                        b.this.f4634f.a(b.this.f4635g);
                        for (a aVar : arrayList) {
                            b.this.f4634f.a(aVar.a, aVar.b, aVar.f4641c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        bVar = b.this;
                    } catch (Throwable th) {
                        try {
                            b.this.f4634f.a();
                        } catch (Exception unused2) {
                        }
                        throw th;
                    }
                    bVar.f4634f.a();
                } catch (Exception unused3) {
                }
            }
        };
        if (!z || (threadPoolExecutor = this.f4638j) == null) {
            runnable.run();
        } else {
            threadPoolExecutor.execute(runnable);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public boolean a() {
        return this.f4637i;
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void b(String str, String str2) {
        if (this.f4637i) {
            Log.i(str, str2);
        }
        synchronized (this.b) {
            b();
            a(new a(ExpandableTextView.P, str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void b(boolean z) {
        this.f4637i = z;
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void c(String str, String str2) {
        if (this.f4637i) {
            Log.w(str, str2);
        }
        synchronized (this.b) {
            b();
            a(new a(ExifInterface.LONGITUDE_WEST, str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void d(String str, String str2) {
        if (this.f4637i) {
            Log.e(str, str2);
        }
        synchronized (this.b) {
            b();
            a(new a(ExifInterface.LONGITUDE_EAST, str, str2));
            c();
        }
    }
}

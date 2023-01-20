package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.sdk.internal.bp;
import com.baidu.mobads.sdk.internal.by;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/* loaded from: classes.dex */
public class bl extends Thread {
    private static final String b = "ApkDownloadThread";

    /* renamed from: c  reason: collision with root package name */
    private static final int f1507c = 900000;

    /* renamed from: h  reason: collision with root package name */
    private static volatile bl f1508h;

    /* renamed from: d  reason: collision with root package name */
    private volatile String f1509d;

    /* renamed from: e  reason: collision with root package name */
    private String f1510e;

    /* renamed from: f  reason: collision with root package name */
    private double f1511f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f1512g;

    /* renamed from: i  reason: collision with root package name */
    private final Context f1513i;

    /* renamed from: k  reason: collision with root package name */
    private final bn f1515k;

    /* renamed from: j  reason: collision with root package name */
    private by f1514j = null;

    /* renamed from: l  reason: collision with root package name */
    private bj f1516l = bj.a();
    public by.a a = new bm(this);

    private bl(Context context, bn bnVar, String str, Handler handler) {
        this.f1510e = null;
        this.f1513i = context;
        this.f1515k = bnVar;
        a(bnVar.c());
        this.f1512g = handler;
        this.f1510e = str;
    }

    private boolean b() {
        double d2;
        try {
            try {
                this.f1514j = new by(this.f1513i, new URL(this.f1509d), this.f1515k, this.a);
            } catch (MalformedURLException unused) {
                this.f1514j = new by(this.f1513i, this.f1509d, this.f1515k, this.a);
            }
            if (bp.q != null) {
                d2 = bp.q.b;
            } else if (bp.p == null) {
                d2 = 0.0d;
            } else if (bp.p.b > 0.0d) {
                d2 = bp.p.b;
            } else {
                d2 = bp.p.b;
            }
            this.f1516l.a(b, "isNewApkAvailable: local apk version is: " + d2 + ", remote apk version: " + this.f1515k.b());
            if (d2 > 0.0d) {
                if (this.f1515k.b() > 0.0d) {
                    this.f1516l.a(b, "remote not null, local apk version is null, force upgrade");
                    this.f1511f = this.f1515k.b();
                    return true;
                }
                this.f1516l.a(b, "remote is null, local apk version is null, do not upgrade");
                return false;
            } else if (this.f1515k.b() <= 0.0d) {
                this.f1516l.a(b, "remote apk version is: null, local apk version is: " + d2 + ", do not upgrade");
                return false;
            } else if (this.f1515k.b() > d2) {
                this.f1511f = this.f1515k.b();
                return true;
            } else {
                return false;
            }
        } catch (Exception e2) {
            String str = "parse apk failed, error:" + e2.toString();
            this.f1516l.a(b, str);
            throw new bp.a(str);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                try {
                    a();
                    this.f1516l.a(b, "download apk successfully, downloader exit");
                    f1508h = null;
                } catch (IOException e2) {
                    bj bjVar = this.f1516l;
                    bjVar.a(b, "create File or HTTP Get failed, exception: " + e2.getMessage());
                }
                this.f1516l.a(b, "no newer apk, downloader exit");
                f1508h = null;
            }
        } catch (Throwable unused) {
        }
    }

    public static bl a(Context context, bn bnVar, String str, Handler handler) {
        if (f1508h == null) {
            f1508h = new bl(context, bnVar, str, handler);
        }
        return f1508h;
    }

    public void a(String str) {
        this.f1509d = str;
        interrupt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, bn bnVar, String str2) {
        if (str.equals(bp.f1532k) || str.equals(bp.f1533l)) {
            Message obtainMessage = this.f1512g.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable(bp.f1534m, bnVar);
            bundle.putString(bp.n, str);
            obtainMessage.setData(bundle);
            this.f1512g.sendMessage(obtainMessage);
        }
    }

    private String a() {
        String str = bp.f1526e + UUID.randomUUID().toString() + ".jar";
        String str2 = this.f1510e + str;
        File file = new File(str2);
        try {
            file.createNewFile();
            this.f1514j.a(this.f1510e, str);
            return str2;
        } catch (IOException e2) {
            file.delete();
            throw e2;
        }
    }
}

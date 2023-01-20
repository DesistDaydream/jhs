package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.internal.t;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

/* loaded from: classes.dex */
public class aj extends Observable implements t, Runnable {

    /* renamed from: i  reason: collision with root package name */
    public static final int f1421i = 10240;

    /* renamed from: j  reason: collision with root package name */
    public static final int f1422j = 10240;

    /* renamed from: k  reason: collision with root package name */
    public static final String f1423k = ".tmp";

    /* renamed from: m  reason: collision with root package name */
    private static final String f1424m = "FileDownloader";
    public Context a;
    public URL b;

    /* renamed from: c  reason: collision with root package name */
    public String f1425c;

    /* renamed from: d  reason: collision with root package name */
    public String f1426d;

    /* renamed from: e  reason: collision with root package name */
    public int f1427e;

    /* renamed from: f  reason: collision with root package name */
    public t.a f1428f;

    /* renamed from: g  reason: collision with root package name */
    public int f1429g;

    /* renamed from: h  reason: collision with root package name */
    public int f1430h;

    /* renamed from: l  reason: collision with root package name */
    public byte[] f1431l;
    private boolean n;

    public aj(Context context, URL url, String str, String str2, boolean z) {
        this.n = false;
        this.a = context;
        this.b = url;
        this.f1425c = str;
        this.n = z;
        if (str2 != null && str2.trim().length() > 0) {
            this.f1426d = str2;
        } else {
            String file = url.getFile();
            this.f1426d = file.substring(file.lastIndexOf(47) + 1);
        }
        this.f1427e = -1;
        this.f1428f = t.a.DOWNLOADING;
        this.f1429g = 0;
        this.f1430h = 0;
    }

    private void s() {
        a(t.a.ERROR);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a() {
        a(t.a.DOWNLOADING);
        p();
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    @Deprecated
    public void b() {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    @Deprecated
    public void c() {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    @Deprecated
    public void d() {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public String e() {
        return this.b.toString();
    }

    @Override // com.baidu.mobads.sdk.internal.t
    @Deprecated
    public String f() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public String g() {
        return this.f1425c + this.f1426d;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    @Deprecated
    public String h() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    @Deprecated
    public String i() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public int j() {
        return this.f1427e;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public float k() {
        return Math.abs((this.f1429g / this.f1427e) * 100.0f);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public t.a l() {
        return this.f1428f;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void m() {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public boolean n() {
        return false;
    }

    public byte[] o() {
        return this.f1431l;
    }

    public void p() {
        at.a().a(this);
    }

    public void q() {
        setChanged();
        notifyObservers();
    }

    public void r() {
        bh.a(this.f1425c + this.f1426d + f1423k, this.f1425c + this.f1426d);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.aj.run():void");
    }

    public void a(t.a aVar) {
        this.f1428f = aVar;
        q();
    }

    public void a(int i2, float f2) {
        this.f1429g += i2;
        q();
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                URL url = new URL(httpURLConnection.getHeaderField(e.b.a.p.j.j.f9458i));
                this.b = url;
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }
}

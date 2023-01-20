package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class q {
    public final String a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5697c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f5698d;

    /* renamed from: e  reason: collision with root package name */
    private final List<m> f5699e;

    /* renamed from: f  reason: collision with root package name */
    private int f5700f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5701g;

    /* renamed from: h  reason: collision with root package name */
    private int f5702h;

    /* renamed from: i  reason: collision with root package name */
    private String f5703i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicLong f5704j;

    public q(String str, boolean z) {
        this.f5699e = new ArrayList();
        this.f5704j = new AtomicLong();
        this.a = str;
        this.f5698d = z;
        this.b = null;
        this.f5697c = null;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, lastIndexOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String e() {
        if (this.f5703i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("_");
            String str = this.b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f5698d);
            this.f5703i = sb.toString();
        }
        return this.f5703i;
    }

    public synchronized void b(m mVar) {
        try {
            this.f5699e.remove(mVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void c() {
        this.f5701g = false;
    }

    public synchronized boolean d() {
        return this.f5701g;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return e().equals(((q) obj).e());
        }
        return false;
    }

    public int hashCode() {
        if (this.f5702h == 0) {
            this.f5702h = e().hashCode();
        }
        return this.f5702h;
    }

    public String toString() {
        return "UrlRecord{url='" + this.a + "', ip='" + this.b + "', ipFamily='" + this.f5697c + "', isMainUrl=" + this.f5698d + ", failedTimes=" + this.f5700f + ", isCurrentFailed=" + this.f5701g + '}';
    }

    public synchronized void b() {
        this.f5700f++;
        this.f5701g = true;
    }

    public synchronized void a(m mVar) {
        this.f5699e.add(mVar);
    }

    public q(String str, String str2) {
        this.f5699e = new ArrayList();
        this.f5704j = new AtomicLong();
        this.a = str;
        this.f5698d = false;
        this.b = str2;
        this.f5697c = a(str2);
    }

    public synchronized int a() {
        return this.f5699e.size();
    }

    public void a(long j2) {
        this.f5704j.addAndGet(j2);
    }
}

package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;

/* loaded from: classes3.dex */
public class d {
    public final String a;
    public final g b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5836c;

    /* renamed from: d  reason: collision with root package name */
    private long f5837d;

    /* renamed from: e  reason: collision with root package name */
    private long f5838e;

    public d(String str, g gVar) throws IOException {
        this.a = str;
        this.f5836c = gVar.b();
        this.b = gVar;
    }

    public boolean a() {
        return f.c(this.f5836c);
    }

    public boolean b() {
        return f.a(this.f5836c, this.b.a("Accept-Ranges"));
    }

    public String c() {
        return this.b.a("Etag");
    }

    public String d() {
        return this.b.a("Content-Type");
    }

    public String e() {
        return f.b(this.b, "Content-Range");
    }

    public String f() {
        String b = f.b(this.b, "last-modified");
        return TextUtils.isEmpty(b) ? f.b(this.b, "Last-Modified") : b;
    }

    public String g() {
        return f.b(this.b, "Cache-Control");
    }

    public long h() {
        if (this.f5837d <= 0) {
            this.f5837d = f.a(this.b);
        }
        return this.f5837d;
    }

    public boolean i() {
        if (com.ss.android.socialbase.downloader.i.a.a(8)) {
            return f.c(this.b);
        }
        return f.b(h());
    }

    public long j() {
        if (this.f5838e <= 0) {
            if (!i()) {
                String e2 = e();
                if (!TextUtils.isEmpty(e2)) {
                    this.f5838e = f.b(e2);
                }
            } else {
                this.f5838e = -1L;
            }
        }
        return this.f5838e;
    }

    public long k() {
        return f.i(g());
    }
}

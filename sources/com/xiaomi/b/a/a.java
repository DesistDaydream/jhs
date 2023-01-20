package com.xiaomi.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.caverock.androidsvg.SVG;
import com.xiaomi.push.av;

/* loaded from: classes3.dex */
public class a {
    private String a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8192c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8193d;

    /* renamed from: e  reason: collision with root package name */
    private long f8194e;

    /* renamed from: f  reason: collision with root package name */
    private long f8195f;

    /* renamed from: g  reason: collision with root package name */
    private long f8196g;

    /* renamed from: com.xiaomi.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0295a {
        private int a = -1;
        private int b = -1;

        /* renamed from: c  reason: collision with root package name */
        private int f8197c = -1;

        /* renamed from: d  reason: collision with root package name */
        private String f8198d = null;

        /* renamed from: e  reason: collision with root package name */
        private long f8199e = -1;

        /* renamed from: f  reason: collision with root package name */
        private long f8200f = -1;

        /* renamed from: g  reason: collision with root package name */
        private long f8201g = -1;

        public C0295a a(long j2) {
            this.f8199e = j2;
            return this;
        }

        public C0295a a(String str) {
            this.f8198d = str;
            return this;
        }

        public C0295a a(boolean z) {
            this.a = z ? 1 : 0;
            return this;
        }

        public a a(Context context) {
            return new a(context, this);
        }

        public C0295a b(long j2) {
            this.f8200f = j2;
            return this;
        }

        public C0295a b(boolean z) {
            this.b = z ? 1 : 0;
            return this;
        }

        public C0295a c(long j2) {
            this.f8201g = j2;
            return this;
        }

        public C0295a c(boolean z) {
            this.f8197c = z ? 1 : 0;
            return this;
        }
    }

    private a() {
        this.b = true;
        this.f8192c = false;
        this.f8193d = false;
        this.f8194e = SVG.H;
        this.f8195f = 86400L;
        this.f8196g = 86400L;
    }

    private a(Context context, C0295a c0295a) {
        this.b = true;
        this.f8192c = false;
        this.f8193d = false;
        long j2 = SVG.H;
        this.f8194e = SVG.H;
        this.f8195f = 86400L;
        this.f8196g = 86400L;
        if (c0295a.a == 0) {
            this.b = false;
        } else {
            int unused = c0295a.a;
            this.b = true;
        }
        this.a = !TextUtils.isEmpty(c0295a.f8198d) ? c0295a.f8198d : av.a(context);
        this.f8194e = c0295a.f8199e > -1 ? c0295a.f8199e : j2;
        if (c0295a.f8200f > -1) {
            this.f8195f = c0295a.f8200f;
        } else {
            this.f8195f = 86400L;
        }
        if (c0295a.f8201g > -1) {
            this.f8196g = c0295a.f8201g;
        } else {
            this.f8196g = 86400L;
        }
        if (c0295a.b != 0 && c0295a.b == 1) {
            this.f8192c = true;
        } else {
            this.f8192c = false;
        }
        if (c0295a.f8197c != 0 && c0295a.f8197c == 1) {
            this.f8193d = true;
        } else {
            this.f8193d = false;
        }
    }

    public static C0295a a() {
        return new C0295a();
    }

    public static a a(Context context) {
        return a().a(true).a(av.a(context)).a(SVG.H).b(false).b(86400L).c(false).c(86400L).a(context);
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.f8192c;
    }

    public boolean d() {
        return this.f8193d;
    }

    public long e() {
        return this.f8194e;
    }

    public long f() {
        return this.f8195f;
    }

    public long g() {
        return this.f8196g;
    }

    public String toString() {
        return "Config{mEventEncrypted=" + this.b + ", mAESKey='" + this.a + "', mMaxFileLength=" + this.f8194e + ", mEventUploadSwitchOpen=" + this.f8192c + ", mPerfUploadSwitchOpen=" + this.f8193d + ", mEventUploadFrequency=" + this.f8195f + ", mPerfUploadFrequency=" + this.f8196g + '}';
    }
}

package com.bytedance.pangle.f.a;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class a {
    public int a;
    public b b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f2273c;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2279i;

    /* renamed from: k  reason: collision with root package name */
    private f f2281k;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2280j = false;

    /* renamed from: l  reason: collision with root package name */
    private final c f2282l = new c();

    /* renamed from: d  reason: collision with root package name */
    public int f2274d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f2275e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f2276f = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f2277g = 3;

    /* renamed from: h  reason: collision with root package name */
    public int f2278h = 4;

    public a() {
        c();
    }

    private int e(int i2) {
        if (this.a == 2) {
            int i3 = i2 * 5;
            if (i3 < this.f2273c.length) {
                return i3;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    public final void a() {
        if (this.f2280j) {
            this.f2280j = false;
            b bVar = this.b;
            InputStream inputStream = bVar.a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                bVar.a((InputStream) null);
            }
            this.f2281k = null;
            this.b = null;
            c cVar = this.f2282l;
            cVar.b = 0;
            cVar.f2283c = 0;
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0108, code lost:
        throw new java.io.IOException("Invalid resource ids size (" + r1 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0221, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r1 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b() {
        /*
            Method dump skipped, instructions count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.f.a.a.b():int");
    }

    public final int c(int i2) {
        return this.f2273c[e(i2) + 4];
    }

    public final String d(int i2) {
        int e2 = e(i2);
        int[] iArr = this.f2273c;
        if (iArr[e2 + 3] == 3) {
            return this.f2281k.a(iArr[e2 + 2]);
        }
        return "";
    }

    private void c() {
        this.f2273c = null;
        this.a = -1;
    }

    public final String a(int i2) {
        int i3 = this.f2273c[e(i2) + 1];
        return i3 == -1 ? "" : this.f2281k.a(i3);
    }

    public final int b(int i2) {
        return this.f2273c[e(i2) + 3];
    }
}

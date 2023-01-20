package com.bytedance.pangle.res.a;

import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public g f2321c;

    /* renamed from: i  reason: collision with root package name */
    private final h f2327i;

    /* renamed from: j  reason: collision with root package name */
    private final byte[] f2328j;

    /* renamed from: l  reason: collision with root package name */
    private int[] f2330l;
    private boolean n;
    private int o;
    private int[] p;
    private int q;
    public HashMap<Integer, Integer> a = new HashMap<>();
    public boolean b = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2329k = false;

    /* renamed from: m  reason: collision with root package name */
    private final a f2331m = new a();

    /* renamed from: d  reason: collision with root package name */
    public int f2322d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f2323e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f2324f = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f2325g = 3;

    /* renamed from: h  reason: collision with root package name */
    public int f2326h = 4;

    /* loaded from: classes.dex */
    public static final class a {
        public int[] a = new int[32];
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f2332c;

        public final void a() {
            b();
            int i2 = this.b;
            int[] iArr = this.a;
            iArr[i2] = 0;
            iArr[i2 + 1] = 0;
            this.b = i2 + 2;
            this.f2332c++;
        }

        public final void b() {
            int[] iArr = this.a;
            int length = iArr.length;
            int i2 = this.b;
            int i3 = length - i2;
            if (i3 > 2) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.a = iArr2;
        }
    }

    public b(byte[] bArr, h hVar) {
        this.f2327i = hVar;
        this.f2328j = bArr;
        c();
    }

    private void c() {
        this.o = -1;
        this.p = null;
        this.q = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0296, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r6 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x012b, code lost:
        throw new java.io.IOException("Invalid resource ids size (" + r6 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() {
        /*
            Method dump skipped, instructions count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.a.b.d():void");
    }

    public final void a() {
        if (this.f2329k) {
            this.f2329k = false;
            this.f2321c = null;
            this.f2330l = null;
            a aVar = this.f2331m;
            aVar.b = 0;
            aVar.f2332c = 0;
            c();
        }
    }

    public final int b() {
        if (this.f2321c != null) {
            try {
                d();
                return this.o;
            } catch (IOException e2) {
                a();
                throw e2;
            }
        }
        throw new RuntimeException("Parser is not opened.");
    }
}

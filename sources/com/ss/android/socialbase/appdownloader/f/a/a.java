package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class a implements i {
    private d b;

    /* renamed from: d  reason: collision with root package name */
    private f f5480d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f5481e;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5483g;

    /* renamed from: h  reason: collision with root package name */
    private int f5484h;

    /* renamed from: i  reason: collision with root package name */
    private int f5485i;

    /* renamed from: j  reason: collision with root package name */
    private int f5486j;

    /* renamed from: k  reason: collision with root package name */
    private int f5487k;

    /* renamed from: l  reason: collision with root package name */
    private int[] f5488l;

    /* renamed from: m  reason: collision with root package name */
    private int f5489m;
    private int n;
    private int o;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5479c = false;

    /* renamed from: f  reason: collision with root package name */
    private C0187a f5482f = new C0187a();

    public a() {
        g();
    }

    private final void g() {
        this.f5484h = -1;
        this.f5485i = -1;
        this.f5486j = -1;
        this.f5487k = -1;
        this.f5488l = null;
        this.f5489m = -1;
        this.n = -1;
        this.o = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x018e, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void h() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.a.a.h():void");
    }

    public void a(InputStream inputStream) {
        a();
        if (inputStream != null) {
            this.b = new d(inputStream, false);
        }
    }

    public int b() throws h, IOException {
        if (this.b != null) {
            try {
                h();
                return this.f5484h;
            } catch (IOException e2) {
                a();
                throw e2;
            }
        }
        throw new h("Parser is not opened.", this, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public int c() {
        return this.f5485i;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public String d() {
        return "XML line #" + c();
    }

    public int e() {
        if (this.f5484h != 2) {
            return -1;
        }
        return this.f5488l.length / 5;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public int f() {
        return -1;
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0187a {
        private int[] a = new int[32];
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f5490c;

        public final void a() {
            this.b = 0;
            this.f5490c = 0;
        }

        public final int b() {
            int i2 = this.b;
            if (i2 == 0) {
                return 0;
            }
            return this.a[i2 - 1];
        }

        public final boolean c() {
            int i2;
            int[] iArr;
            int i3;
            int i4 = this.b;
            if (i4 == 0 || (i3 = (iArr = this.a)[i4 - 1]) == 0) {
                return false;
            }
            int i5 = i3 - 1;
            int i6 = i2 - 2;
            iArr[i6] = i5;
            iArr[i6 - ((i5 * 2) + 1)] = i5;
            this.b = i4 - 2;
            return true;
        }

        public final int d() {
            return this.f5490c;
        }

        public final void e() {
            a(2);
            int i2 = this.b;
            int[] iArr = this.a;
            iArr[i2] = 0;
            iArr[i2 + 1] = 0;
            this.b = i2 + 2;
            this.f5490c++;
        }

        public final void f() {
            int i2 = this.b;
            if (i2 != 0) {
                int i3 = i2 - 1;
                int i4 = this.a[i3] * 2;
                if ((i3 - 1) - i4 != 0) {
                    this.b = i2 - (i4 + 2);
                    this.f5490c--;
                }
            }
        }

        public final void a(int i2, int i3) {
            if (this.f5490c == 0) {
                e();
            }
            a(2);
            int i4 = this.b;
            int i5 = i4 - 1;
            int[] iArr = this.a;
            int i6 = iArr[i5];
            int i7 = i6 + 1;
            iArr[(i5 - 1) - (i6 * 2)] = i7;
            iArr[i5] = i2;
            iArr[i5 + 1] = i3;
            iArr[i5 + 2] = i7;
            this.b = i4 + 2;
        }

        private void a(int i2) {
            int[] iArr = this.a;
            int length = iArr.length;
            int i3 = this.b;
            int i4 = length - i3;
            if (i4 <= i2) {
                int[] iArr2 = new int[(iArr.length + i4) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.a = iArr2;
            }
        }
    }

    private final int e(int i2) {
        if (this.f5484h == 2) {
            int i3 = i2 * 5;
            if (i3 < this.f5488l.length) {
                return i3;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    public int c(int i2) {
        return this.f5488l[e(i2) + 4];
    }

    public String d(int i2) {
        int e2 = e(i2);
        int[] iArr = this.f5488l;
        if (iArr[e2 + 3] == 3) {
            return this.f5480d.a(iArr[e2 + 2]);
        }
        int i3 = iArr[e2 + 4];
        return "";
    }

    public void a() {
        if (this.f5479c) {
            this.f5479c = false;
            this.b.a();
            this.b = null;
            this.f5480d = null;
            this.f5481e = null;
            this.f5482f.a();
            g();
        }
    }

    public int b(int i2) {
        return this.f5488l[e(i2) + 3];
    }

    public String a(int i2) {
        int i3 = this.f5488l[e(i2) + 1];
        return i3 == -1 ? "" : this.f5480d.a(i3);
    }
}

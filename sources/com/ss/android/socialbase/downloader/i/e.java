package com.ss.android.socialbase.downloader.i;

/* loaded from: classes3.dex */
public class e {
    private a a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private int f5740c;

    /* renamed from: d  reason: collision with root package name */
    private int f5741d = 10;

    /* loaded from: classes3.dex */
    public static class a {
        public long a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        public a f5742c;

        /* renamed from: d  reason: collision with root package name */
        public a f5743d;

        private a() {
        }
    }

    public boolean a(long j2, long j3) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar != null) {
                if (j2 >= aVar.a && j3 >= aVar.b) {
                    a aVar2 = aVar.f5742c;
                    if (aVar2 != null && j3 - aVar2.b < 1000) {
                        aVar.a = j2;
                        aVar.b = j3;
                        return true;
                    }
                }
                return false;
            }
            a a2 = a();
            a2.a = j2;
            a2.b = j3;
            if (aVar != null) {
                a2.f5742c = aVar;
                aVar.f5743d = a2;
            }
            this.a = a2;
            return true;
        }
    }

    public long b(long j2, long j3) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar == null) {
                return -1L;
            }
            a a2 = a(j2);
            if (a2 == null) {
                return -1L;
            }
            long j4 = aVar.a - a2.a;
            long j5 = j3 - a2.b;
            if (j4 < 0 || j5 <= 0) {
                return -1L;
            }
            return j4 / j5;
        }
    }

    private a a() {
        a aVar;
        int i2 = this.f5740c;
        if (i2 >= this.f5741d && (aVar = this.b) != null) {
            a aVar2 = aVar.f5743d;
            aVar.f5743d = null;
            this.b = aVar2;
            if (aVar2 != null) {
                aVar2.f5742c = null;
            }
            return aVar;
        }
        this.f5740c = i2 + 1;
        return new a();
    }

    private a a(long j2) {
        a aVar = this.a;
        a aVar2 = null;
        while (aVar != null && aVar.b > j2) {
            aVar2 = aVar;
            aVar = aVar.f5742c;
        }
        return (aVar == null || aVar2 == null || aVar == aVar2 || j2 - aVar.b >= aVar2.b - j2) ? aVar2 : aVar;
    }
}

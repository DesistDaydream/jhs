package e.j.f.o.e;

import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: e  reason: collision with root package name */
    public static final f f11372e = new f(g.b, 0, 0, 0);
    private final int a;
    private final g b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11373c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11374d;

    private f(g gVar, int i2, int i3, int i4) {
        this.b = gVar;
        this.a = i2;
        this.f11373c = i3;
        this.f11374d = i4;
    }

    public f a(int i2) {
        g gVar = this.b;
        int i3 = this.a;
        int i4 = this.f11374d;
        if (i3 == 4 || i3 == 2) {
            int i5 = d.f11367h[i3][0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            gVar = gVar.a(i6, i7);
            i4 += i7;
            i3 = 0;
        }
        int i8 = this.f11373c;
        f fVar = new f(gVar, i3, i8 + 1, i4 + ((i8 == 0 || i8 == 31) ? 18 : i8 == 62 ? 9 : 8));
        return fVar.f11373c == 2078 ? fVar.b(i2 + 1) : fVar;
    }

    public f b(int i2) {
        int i3 = this.f11373c;
        return i3 == 0 ? this : new f(this.b.b(i2 - i3, i3), this.a, 0, this.f11374d);
    }

    public int c() {
        return this.f11373c;
    }

    public int d() {
        return this.f11374d;
    }

    public int e() {
        return this.a;
    }

    public g f() {
        return this.b;
    }

    public boolean g(f fVar) {
        int i2;
        int i3 = this.f11374d + (d.f11367h[this.a][fVar.a] >> 16);
        int i4 = fVar.f11373c;
        if (i4 > 0 && ((i2 = this.f11373c) == 0 || i2 > i4)) {
            i3 += 10;
        }
        return i3 <= fVar.f11374d;
    }

    public f h(int i2, int i3) {
        int i4 = this.f11374d;
        g gVar = this.b;
        int i5 = this.a;
        if (i2 != i5) {
            int i6 = d.f11367h[i5][i2];
            int i7 = 65535 & i6;
            int i8 = i6 >> 16;
            gVar = gVar.a(i7, i8);
            i4 += i8;
        }
        int i9 = i2 == 2 ? 4 : 5;
        return new f(gVar.a(i3, i9), i2, 0, i4 + i9);
    }

    public f i(int i2, int i3) {
        g gVar = this.b;
        int i4 = this.a;
        int i5 = i4 == 2 ? 4 : 5;
        return new f(gVar.a(d.f11369j[i4][i2], i5).a(i3, 5), this.a, 0, this.f11374d + i5 + 5);
    }

    public e.j.f.q.a j(byte[] bArr) {
        LinkedList<g> linkedList = new LinkedList();
        for (g gVar = b(bArr.length).b; gVar != null; gVar = gVar.d()) {
            linkedList.addFirst(gVar);
        }
        e.j.f.q.a aVar = new e.j.f.q.a();
        for (g gVar2 : linkedList) {
            gVar2.c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.b[this.a], Integer.valueOf(this.f11374d), Integer.valueOf(this.f11373c));
    }
}

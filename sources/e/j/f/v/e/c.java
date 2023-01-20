package e.j.f.v.e;

import com.google.zxing.NotFoundException;
import e.j.f.l;

/* loaded from: classes2.dex */
public final class c {
    private final e.j.f.q.b a;
    private final l b;

    /* renamed from: c  reason: collision with root package name */
    private final l f11686c;

    /* renamed from: d  reason: collision with root package name */
    private final l f11687d;

    /* renamed from: e  reason: collision with root package name */
    private final l f11688e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11689f;

    /* renamed from: g  reason: collision with root package name */
    private final int f11690g;

    /* renamed from: h  reason: collision with root package name */
    private final int f11691h;

    /* renamed from: i  reason: collision with root package name */
    private final int f11692i;

    public c(e.j.f.q.b bVar, l lVar, l lVar2, l lVar3, l lVar4) throws NotFoundException {
        boolean z = false;
        boolean z2 = lVar == null || lVar2 == null;
        z = (lVar3 == null || lVar4 == null) ? true : true;
        if (z2 && z) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (z2) {
            lVar = new l(0.0f, lVar3.d());
            lVar2 = new l(0.0f, lVar4.d());
        } else if (z) {
            lVar3 = new l(bVar.n() - 1, lVar.d());
            lVar4 = new l(bVar.n() - 1, lVar2.d());
        }
        this.a = bVar;
        this.b = lVar;
        this.f11686c = lVar2;
        this.f11687d = lVar3;
        this.f11688e = lVar4;
        this.f11689f = (int) Math.min(lVar.c(), lVar2.c());
        this.f11690g = (int) Math.max(lVar3.c(), lVar4.c());
        this.f11691h = (int) Math.min(lVar.d(), lVar3.d());
        this.f11692i = (int) Math.max(lVar2.d(), lVar4.d());
    }

    public static c j(c cVar, c cVar2) throws NotFoundException {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.a, cVar.b, cVar.f11686c, cVar2.f11687d, cVar2.f11688e);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public e.j.f.v.e.c a(int r13, int r14, boolean r15) throws com.google.zxing.NotFoundException {
        /*
            r12 = this;
            e.j.f.l r0 = r12.b
            e.j.f.l r1 = r12.f11686c
            e.j.f.l r2 = r12.f11687d
            e.j.f.l r3 = r12.f11688e
            if (r13 <= 0) goto L29
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.d()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            e.j.f.l r13 = new e.j.f.l
            float r4 = r4.c()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L26
            r8 = r13
            goto L2a
        L26:
            r10 = r13
            r8 = r0
            goto L2b
        L29:
            r8 = r0
        L2a:
            r10 = r2
        L2b:
            if (r14 <= 0) goto L5b
            if (r15 == 0) goto L32
            e.j.f.l r13 = r12.f11686c
            goto L34
        L32:
            e.j.f.l r13 = r12.f11688e
        L34:
            float r0 = r13.d()
            int r0 = (int) r0
            int r0 = r0 + r14
            e.j.f.q.b r14 = r12.a
            int r14 = r14.j()
            if (r0 < r14) goto L4a
            e.j.f.q.b r14 = r12.a
            int r14 = r14.j()
            int r0 = r14 + (-1)
        L4a:
            e.j.f.l r14 = new e.j.f.l
            float r13 = r13.c()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L58
            r9 = r14
            goto L5c
        L58:
            r11 = r14
            r9 = r1
            goto L5d
        L5b:
            r9 = r1
        L5c:
            r11 = r3
        L5d:
            e.j.f.v.e.c r13 = new e.j.f.v.e.c
            e.j.f.q.b r7 = r12.a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.v.e.c.a(int, int, boolean):e.j.f.v.e.c");
    }

    public l b() {
        return this.f11686c;
    }

    public l c() {
        return this.f11688e;
    }

    public int d() {
        return this.f11690g;
    }

    public int e() {
        return this.f11692i;
    }

    public int f() {
        return this.f11689f;
    }

    public int g() {
        return this.f11691h;
    }

    public l h() {
        return this.b;
    }

    public l i() {
        return this.f11687d;
    }

    public c(c cVar) {
        this.a = cVar.a;
        this.b = cVar.h();
        this.f11686c = cVar.b();
        this.f11687d = cVar.i();
        this.f11688e = cVar.c();
        this.f11689f = cVar.f();
        this.f11690g = cVar.d();
        this.f11691h = cVar.g();
        this.f11692i = cVar.e();
    }
}

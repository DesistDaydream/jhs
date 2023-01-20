package e.j.f.w.c;

import e.j.f.l;

/* loaded from: classes2.dex */
public final class f {
    private final boolean a;

    public f(boolean z) {
        this.a = z;
    }

    public void a(l[] lVarArr) {
        if (!this.a || lVarArr == null || lVarArr.length < 3) {
            return;
        }
        l lVar = lVarArr[0];
        lVarArr[0] = lVarArr[2];
        lVarArr[2] = lVar;
    }

    public boolean b() {
        return this.a;
    }
}

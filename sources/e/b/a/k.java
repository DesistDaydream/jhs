package e.b.a;

import androidx.annotation.NonNull;
import e.b.a.k;
import e.b.a.t.l.j;
import e.b.a.v.l;

/* loaded from: classes.dex */
public abstract class k<CHILD extends k<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    private e.b.a.t.l.g<? super TranscodeType> a = e.b.a.t.l.e.c();

    private CHILD e() {
        return this;
    }

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    public final CHILD b() {
        return g(e.b.a.t.l.e.c());
    }

    public final e.b.a.t.l.g<? super TranscodeType> c() {
        return this.a;
    }

    @NonNull
    public final CHILD f(int i2) {
        return g(new e.b.a.t.l.h(i2));
    }

    @NonNull
    public final CHILD g(@NonNull e.b.a.t.l.g<? super TranscodeType> gVar) {
        this.a = (e.b.a.t.l.g) l.d(gVar);
        return e();
    }

    @NonNull
    public final CHILD h(@NonNull j.a aVar) {
        return g(new e.b.a.t.l.i(aVar));
    }
}

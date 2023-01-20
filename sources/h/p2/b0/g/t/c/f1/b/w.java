package h.p2.b0.g.t.c.f1.b;

import h.p2.b0.g.t.e.a.x.a0;
import java.lang.annotation.Annotation;
import java.util.List;

/* loaded from: classes3.dex */
public final class w extends l implements a0 {
    @k.e.a.d
    private final u a;
    @k.e.a.d
    private final Annotation[] b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private final String f15204c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15205d;

    public w(@k.e.a.d u uVar, @k.e.a.d Annotation[] annotationArr, @k.e.a.e String str, boolean z) {
        this.a = uVar;
        this.b = annotationArr;
        this.f15204c = str;
        this.f15205d = z;
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    public boolean D() {
        return false;
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    @k.e.a.e
    /* renamed from: R */
    public b c(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return f.a(this.b, cVar);
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    @k.e.a.d
    /* renamed from: S */
    public List<b> getAnnotations() {
        return f.b(this.b);
    }

    @Override // h.p2.b0.g.t.e.a.x.a0
    @k.e.a.e
    public h.p2.b0.g.t.g.f getName() {
        String str = this.f15204c;
        if (str == null) {
            return null;
        }
        return h.p2.b0.g.t.g.f.e(str);
    }

    @Override // h.p2.b0.g.t.e.a.x.a0
    public boolean k() {
        return this.f15205d;
    }

    @k.e.a.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(w.class.getName());
        sb.append(": ");
        sb.append(k() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }

    @Override // h.p2.b0.g.t.e.a.x.a0
    @k.e.a.d
    public u getType() {
        return this.a;
    }
}

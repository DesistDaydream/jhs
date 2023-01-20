package h.p2.b0.g.t.c.f1.b;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class g extends c implements h.p2.b0.g.t.e.a.x.e {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f15194c;

    public g(@k.e.a.e h.p2.b0.g.t.g.f fVar, @k.e.a.d Object[] objArr) {
        super(fVar, null);
        this.f15194c = objArr;
    }

    @Override // h.p2.b0.g.t.e.a.x.e
    @k.e.a.d
    public List<c> c() {
        Object[] objArr = this.f15194c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(c.b.a(obj, null));
        }
        return arrayList;
    }
}

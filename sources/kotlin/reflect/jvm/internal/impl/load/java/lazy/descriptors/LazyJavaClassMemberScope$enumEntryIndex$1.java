package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.a2.s0;
import h.a2.u;
import h.k2.u.a;
import h.o2.q;
import h.p2.b0.g.t.e.a.x.g;
import h.p2.b0.g.t.e.a.x.n;
import h.p2.b0.g.t.g.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope$enumEntryIndex$1 extends Lambda implements a<Map<f, ? extends n>> {
    public final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$enumEntryIndex$1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope;
    }

    @Override // h.k2.u.a
    @d
    public final Map<f, ? extends n> invoke() {
        g gVar;
        gVar = this.this$0.o;
        Collection<n> y = gVar.y();
        ArrayList arrayList = new ArrayList();
        for (Object obj : y) {
            if (((n) obj).J()) {
                arrayList.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.n(s0.j(u.Y(arrayList, 10)), 16));
        for (Object obj2 : arrayList) {
            linkedHashMap.put(((n) obj2).getName(), obj2);
        }
        return linkedHashMap;
    }
}

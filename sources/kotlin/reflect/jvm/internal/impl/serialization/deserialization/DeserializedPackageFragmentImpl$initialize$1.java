package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.a2.u;
import h.k2.u.a;
import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.g.f;
import java.util.ArrayList;
import java.util.Collection;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class DeserializedPackageFragmentImpl$initialize$1 extends Lambda implements a<Collection<? extends f>> {
    public final /* synthetic */ DeserializedPackageFragmentImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl$initialize$1(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
        super(0);
        this.this$0 = deserializedPackageFragmentImpl;
    }

    @Override // h.k2.u.a
    @d
    public final Collection<? extends f> invoke() {
        Collection<b> b = this.this$0.C0().b();
        ArrayList<b> arrayList = new ArrayList();
        for (Object obj : b) {
            b bVar = (b) obj;
            if ((bVar.l() || ClassDeserializer.f16794c.a().contains(bVar)) ? false : true) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(u.Y(arrayList, 10));
        for (b bVar2 : arrayList) {
            arrayList2.add(bVar2.j());
        }
        return arrayList2;
    }
}

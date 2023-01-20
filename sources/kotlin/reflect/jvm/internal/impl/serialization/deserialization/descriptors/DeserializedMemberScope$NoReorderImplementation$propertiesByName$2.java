package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.g.f;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* loaded from: classes3.dex */
public final class DeserializedMemberScope$NoReorderImplementation$propertiesByName$2 extends Lambda implements a<Map<f, ? extends List<? extends j0>>> {
    public final /* synthetic */ DeserializedMemberScope.NoReorderImplementation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$NoReorderImplementation$propertiesByName$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.this$0 = noReorderImplementation;
    }

    @Override // h.k2.u.a
    @d
    public final Map<f, ? extends List<? extends j0>> invoke() {
        List B;
        B = this.this$0.B();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : B) {
            f name = ((j0) obj).getName();
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        return linkedHashMap;
    }
}

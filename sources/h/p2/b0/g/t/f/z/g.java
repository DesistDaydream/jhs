package h.p2.b0.g.t.f.z;

import h.a2.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class g {
    @k.e.a.d
    private final List<ProtoBuf.Type> a;

    public g(@k.e.a.d ProtoBuf.TypeTable typeTable) {
        List<ProtoBuf.Type> typeList = typeTable.getTypeList();
        if (typeTable.hasFirstNullable()) {
            int firstNullable = typeTable.getFirstNullable();
            List<ProtoBuf.Type> typeList2 = typeTable.getTypeList();
            ArrayList arrayList = new ArrayList(u.Y(typeList2, 10));
            int i2 = 0;
            for (Object obj : typeList2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.W();
                }
                ProtoBuf.Type type = (ProtoBuf.Type) obj;
                if (i2 >= firstNullable) {
                    type = type.toBuilder().Q(true).build();
                }
                arrayList.add(type);
                i2 = i3;
            }
            typeList = arrayList;
        }
        this.a = typeList;
    }

    @k.e.a.d
    public final ProtoBuf.Type a(int i2) {
        return this.a.get(i2);
    }
}

package h.p2.b0.g.t.f.z;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class d implements c {
    @k.e.a.d
    private final ProtoBuf.StringTable a;
    @k.e.a.d
    private final ProtoBuf.QualifiedNameTable b;

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
            a = iArr;
        }
    }

    public d(@k.e.a.d ProtoBuf.StringTable stringTable, @k.e.a.d ProtoBuf.QualifiedNameTable qualifiedNameTable) {
        this.a = stringTable;
        this.b = qualifiedNameTable;
    }

    private final Triple<List<String>, List<String>, Boolean> c(int i2) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i2 != -1) {
            ProtoBuf.QualifiedNameTable.QualifiedName qualifiedName = this.b.getQualifiedName(i2);
            String string = this.a.getString(qualifiedName.getShortName());
            int i3 = a.a[qualifiedName.getKind().ordinal()];
            if (i3 == 1) {
                linkedList2.addFirst(string);
            } else if (i3 == 2) {
                linkedList.addFirst(string);
            } else if (i3 == 3) {
                linkedList2.addFirst(string);
                z = true;
            }
            i2 = qualifiedName.getParentQualifiedName();
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z));
    }

    @Override // h.p2.b0.g.t.f.z.c
    public boolean a(int i2) {
        return c(i2).getThird().booleanValue();
    }

    @Override // h.p2.b0.g.t.f.z.c
    @k.e.a.d
    public String b(int i2) {
        Triple<List<String>, List<String>, Boolean> c2 = c(i2);
        List<String> component1 = c2.component1();
        String Z2 = CollectionsKt___CollectionsKt.Z2(c2.component2(), ".", null, null, 0, null, null, 62, null);
        if (component1.isEmpty()) {
            return Z2;
        }
        return CollectionsKt___CollectionsKt.Z2(component1, MqttTopic.TOPIC_LEVEL_SEPARATOR, null, null, 0, null, null, 62, null) + Attributes.InternalPrefix + Z2;
    }

    @Override // h.p2.b0.g.t.f.z.c
    @k.e.a.d
    public String getString(int i2) {
        return this.a.getString(i2);
    }
}

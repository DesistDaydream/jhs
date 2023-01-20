package h.p2.b0.g.t.f.a0.f;

import h.a2.d1;
import h.a2.i0;
import h.a2.s0;
import h.k2.v.f0;
import h.k2.v.u;
import h.o2.q;
import h.t1;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* loaded from: classes3.dex */
public final class f implements h.p2.b0.g.t.f.z.c {
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public static final a f15363e = new a(null);
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final String f15364f;
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final List<String> f15365g;
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private static final Map<String, Integer> f15366h;
    @k.e.a.d
    private final JvmProtoBuf.StringTableTypes a;
    @k.e.a.d
    private final String[] b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final Set<Integer> f15367c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final List<JvmProtoBuf.StringTableTypes.Record> f15368d;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            a = iArr;
        }
    }

    static {
        String Z2 = CollectionsKt___CollectionsKt.Z2(CollectionsKt__CollectionsKt.L('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);
        f15364f = Z2;
        List<String> L = CollectionsKt__CollectionsKt.L(f0.C(Z2, "/Any"), f0.C(Z2, "/Nothing"), f0.C(Z2, "/Unit"), f0.C(Z2, "/Throwable"), f0.C(Z2, "/Number"), f0.C(Z2, "/Byte"), f0.C(Z2, "/Double"), f0.C(Z2, "/Float"), f0.C(Z2, "/Int"), f0.C(Z2, "/Long"), f0.C(Z2, "/Short"), f0.C(Z2, "/Boolean"), f0.C(Z2, "/Char"), f0.C(Z2, "/CharSequence"), f0.C(Z2, "/String"), f0.C(Z2, "/Comparable"), f0.C(Z2, "/Enum"), f0.C(Z2, "/Array"), f0.C(Z2, "/ByteArray"), f0.C(Z2, "/DoubleArray"), f0.C(Z2, "/FloatArray"), f0.C(Z2, "/IntArray"), f0.C(Z2, "/LongArray"), f0.C(Z2, "/ShortArray"), f0.C(Z2, "/BooleanArray"), f0.C(Z2, "/CharArray"), f0.C(Z2, "/Cloneable"), f0.C(Z2, "/Annotation"), f0.C(Z2, "/collections/Iterable"), f0.C(Z2, "/collections/MutableIterable"), f0.C(Z2, "/collections/Collection"), f0.C(Z2, "/collections/MutableCollection"), f0.C(Z2, "/collections/List"), f0.C(Z2, "/collections/MutableList"), f0.C(Z2, "/collections/Set"), f0.C(Z2, "/collections/MutableSet"), f0.C(Z2, "/collections/Map"), f0.C(Z2, "/collections/MutableMap"), f0.C(Z2, "/collections/Map.Entry"), f0.C(Z2, "/collections/MutableMap.MutableEntry"), f0.C(Z2, "/collections/Iterator"), f0.C(Z2, "/collections/MutableIterator"), f0.C(Z2, "/collections/ListIterator"), f0.C(Z2, "/collections/MutableListIterator"));
        f15365g = L;
        Iterable<i0> U5 = CollectionsKt___CollectionsKt.U5(L);
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.n(s0.j(h.a2.u.Y(U5, 10)), 16));
        for (i0 i0Var : U5) {
            linkedHashMap.put((String) i0Var.f(), Integer.valueOf(i0Var.e()));
        }
        f15366h = linkedHashMap;
    }

    public f(@k.e.a.d JvmProtoBuf.StringTableTypes stringTableTypes, @k.e.a.d String[] strArr) {
        this.a = stringTableTypes;
        this.b = strArr;
        List<Integer> localNameList = stringTableTypes.getLocalNameList();
        this.f15367c = localNameList.isEmpty() ? d1.k() : CollectionsKt___CollectionsKt.N5(localNameList);
        ArrayList arrayList = new ArrayList();
        List<JvmProtoBuf.StringTableTypes.Record> recordList = c().getRecordList();
        arrayList.ensureCapacity(recordList.size());
        for (JvmProtoBuf.StringTableTypes.Record record : recordList) {
            int range = record.getRange();
            for (int i2 = 0; i2 < range; i2++) {
                arrayList.add(record);
            }
        }
        arrayList.trimToSize();
        t1 t1Var = t1.a;
        this.f15368d = arrayList;
    }

    @Override // h.p2.b0.g.t.f.z.c
    public boolean a(int i2) {
        return this.f15367c.contains(Integer.valueOf(i2));
    }

    @Override // h.p2.b0.g.t.f.z.c
    @k.e.a.d
    public String b(int i2) {
        return getString(i2);
    }

    @k.e.a.d
    public final JvmProtoBuf.StringTableTypes c() {
        return this.a;
    }

    @Override // h.p2.b0.g.t.f.z.c
    @k.e.a.d
    public String getString(int i2) {
        String str;
        JvmProtoBuf.StringTableTypes.Record record = this.f15368d.get(i2);
        if (record.hasString()) {
            str = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                List<String> list = f15365g;
                int size = list.size() - 1;
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex <= size) {
                    str = list.get(record.getPredefinedIndex());
                }
            }
            str = this.b[i2];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            if (num.intValue() >= 0 && num.intValue() <= num2.intValue() && num2.intValue() <= str.length()) {
                str = str.substring(num.intValue(), num2.intValue());
            }
        }
        String str2 = str;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            str2 = h.t2.u.j2(str2, (char) replaceCharList.get(0).intValue(), (char) replaceCharList.get(1).intValue(), false, 4, null);
        }
        String str3 = str2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i3 = b.a[operation.ordinal()];
        if (i3 != 2) {
            if (i3 != 3) {
                return str3;
            }
            if (str3.length() >= 2) {
                str3 = str3.substring(1, str3.length() - 1);
            }
            return h.t2.u.j2(str3, '$', '.', false, 4, null);
        }
        return h.t2.u.j2(str3, '$', '.', false, 4, null);
    }
}

package h.p2.b0.g.t.f.a0.f;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import h.g2.m;
import h.k2.k;
import h.k2.v.f0;
import h.t2.u;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public final class b {
    @k.e.a.d
    public static final b a = new b();
    @k.e.a.d
    private static final String b = CollectionsKt___CollectionsKt.Z2(CollectionsKt__CollectionsKt.L('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, String> f15356c;

    static {
        int i2 = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List L = CollectionsKt__CollectionsKt.L("Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", ExpandableTextView.P, "Float", "F", "Long", "J", "Double", "D");
        int c2 = m.c(0, L.size() - 1, 2);
        if (c2 >= 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 2;
                StringBuilder sb = new StringBuilder();
                String str = b;
                sb.append(str);
                sb.append(Attributes.InternalPrefix);
                sb.append((String) L.get(i3));
                int i5 = i3 + 1;
                linkedHashMap.put(sb.toString(), L.get(i5));
                linkedHashMap.put(str + Attributes.InternalPrefix + ((String) L.get(i3)) + "Array", f0.C("[", L.get(i5)));
                if (i3 == c2) {
                    break;
                }
                i3 = i4;
            }
        }
        linkedHashMap.put(f0.C(b, "/Unit"), ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : CollectionsKt__CollectionsKt.L("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            a(linkedHashMap, str2, f0.C("java/lang/", str2));
        }
        for (String str3 : CollectionsKt__CollectionsKt.L("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            a(linkedHashMap, f0.C("collections/", str3), f0.C("java/util/", str3));
            a(linkedHashMap, f0.C("collections/Mutable", str3), f0.C("java/util/", str3));
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        while (true) {
            int i6 = i2 + 1;
            String C = f0.C("Function", Integer.valueOf(i2));
            StringBuilder sb2 = new StringBuilder();
            String str4 = b;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i2);
            a(linkedHashMap, C, sb2.toString());
            a(linkedHashMap, f0.C("reflect/KFunction", Integer.valueOf(i2)), f0.C(str4, "/reflect/KFunction"));
            if (i6 > 22) {
                break;
            }
            i2 = i6;
        }
        for (String str5 : CollectionsKt__CollectionsKt.L("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            a(linkedHashMap, f0.C(str5, ".Companion"), b + "/jvm/internal/" + str5 + "CompanionObject");
        }
        f15356c = linkedHashMap;
    }

    private b() {
    }

    private static final void a(Map<String, String> map, String str, String str2) {
        map.put(b + Attributes.InternalPrefix + str, 'L' + str2 + ';');
    }

    @k
    @k.e.a.d
    public static final String b(@k.e.a.d String str) {
        String str2 = f15356c.get(str);
        if (str2 == null) {
            return 'L' + u.j2(str, '.', '$', false, 4, null) + ';';
        }
        return str2;
    }
}

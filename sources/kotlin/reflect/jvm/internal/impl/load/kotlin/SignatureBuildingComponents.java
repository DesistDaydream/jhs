package kotlin.reflect.jvm.internal.impl.load.kotlin;

import h.k2.v.f0;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public final class SignatureBuildingComponents {
    @d
    public static final SignatureBuildingComponents a = new SignatureBuildingComponents();

    private SignatureBuildingComponents() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c(String str) {
        if (str.length() > 1) {
            return 'L' + str + ';';
        }
        return str;
    }

    @d
    public final String[] b(@d String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    @d
    public final Set<String> d(@d String str, @d String... strArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    @d
    public final Set<String> e(@d String str, @d String... strArr) {
        String h2 = h(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return d(h2, strArr2);
    }

    @d
    public final Set<String> f(@d String str, @d String... strArr) {
        String i2 = i(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return d(i2, strArr2);
    }

    @d
    public final String g(@d String str) {
        return f0.C("java/util/function/", str);
    }

    @d
    public final String h(@d String str) {
        return f0.C("java/lang/", str);
    }

    @d
    public final String i(@d String str) {
        return f0.C("java/util/", str);
    }

    @d
    public final String j(@d String str, @d List<String> list, @d String str2) {
        return str + '(' + CollectionsKt___CollectionsKt.Z2(list, "", null, null, 0, null, SignatureBuildingComponents$jvmDescriptor$1.INSTANCE, 30, null) + ')' + c(str2);
    }

    @d
    public final String k(@d String str, @d String str2) {
        return str + '.' + str2;
    }
}

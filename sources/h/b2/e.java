package h.b2;

import com.umeng.analytics.pro.am;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\"\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004¨\u0006\u000b"}, d2 = {"Lkotlin/comparisons/NaturalOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "()V", "compare", "", am.av, "b", "reversed", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class e implements Comparator<Comparable<? super Object>> {
    @k.e.a.d
    public static final e a = new e();

    private e() {
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(@k.e.a.d Comparable<Object> comparable, @k.e.a.d Comparable<Object> comparable2) {
        return comparable.compareTo(comparable2);
    }

    @Override // java.util.Comparator
    @k.e.a.d
    public final Comparator<Comparable<? super Object>> reversed() {
        return f.a;
    }
}

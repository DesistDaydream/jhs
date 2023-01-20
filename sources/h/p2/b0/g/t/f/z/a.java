package h.p2.b0.g.t.f.z;

import h.a2.n;
import h.k2.v.f0;
import h.k2.v.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public abstract class a {
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final C0455a f15382f = new C0455a(null);
    @k.e.a.d
    private final int[] a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15383c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15384d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final List<Integer> f15385e;

    /* renamed from: h.p2.b0.g.t.f.z.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0455a {
        private C0455a() {
        }

        public /* synthetic */ C0455a(u uVar) {
            this();
        }
    }

    public a(@k.e.a.d int... iArr) {
        this.a = iArr;
        Integer ke = ArraysKt___ArraysKt.ke(iArr, 0);
        this.b = ke == null ? -1 : ke.intValue();
        Integer ke2 = ArraysKt___ArraysKt.ke(iArr, 1);
        this.f15383c = ke2 == null ? -1 : ke2.intValue();
        Integer ke3 = ArraysKt___ArraysKt.ke(iArr, 2);
        this.f15384d = ke3 != null ? ke3.intValue() : -1;
        this.f15385e = iArr.length > 3 ? CollectionsKt___CollectionsKt.I5(n.r(iArr).subList(3, iArr.length)) : CollectionsKt__CollectionsKt.E();
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.f15383c;
    }

    public final boolean c(int i2, int i3, int i4) {
        int i5 = this.b;
        if (i5 > i2) {
            return true;
        }
        if (i5 < i2) {
            return false;
        }
        int i6 = this.f15383c;
        if (i6 > i3) {
            return true;
        }
        return i6 >= i3 && this.f15384d >= i4;
    }

    public final boolean d(@k.e.a.d a aVar) {
        return c(aVar.b, aVar.f15383c, aVar.f15384d);
    }

    public final boolean e(int i2, int i3, int i4) {
        int i5 = this.b;
        if (i5 < i2) {
            return true;
        }
        if (i5 > i2) {
            return false;
        }
        int i6 = this.f15383c;
        if (i6 < i3) {
            return true;
        }
        return i6 <= i3 && this.f15384d <= i4;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (obj != null && f0.g(getClass(), obj.getClass())) {
            a aVar = (a) obj;
            if (this.b == aVar.b && this.f15383c == aVar.f15383c && this.f15384d == aVar.f15384d && f0.g(this.f15385e, aVar.f15385e)) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(@k.e.a.d a aVar) {
        int i2 = this.b;
        if (i2 == 0) {
            if (aVar.b == 0 && this.f15383c == aVar.f15383c) {
                return true;
            }
        } else if (i2 == aVar.b && this.f15383c <= aVar.f15383c) {
            return true;
        }
        return false;
    }

    @k.e.a.d
    public final int[] g() {
        return this.a;
    }

    public int hashCode() {
        int i2 = this.b;
        int i3 = i2 + (i2 * 31) + this.f15383c;
        int i4 = i3 + (i3 * 31) + this.f15384d;
        return i4 + (i4 * 31) + this.f15385e.hashCode();
    }

    @k.e.a.d
    public String toString() {
        int[] g2 = g();
        ArrayList arrayList = new ArrayList();
        int length = g2.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = g2[i2];
            if (!(i3 != -1)) {
                break;
            }
            arrayList.add(Integer.valueOf(i3));
        }
        return arrayList.isEmpty() ? "unknown" : CollectionsKt___CollectionsKt.Z2(arrayList, ".", null, null, 0, null, null, 62, null);
    }
}

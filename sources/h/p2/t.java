package h.p2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.v.f0;
import h.p0;
import h.s0;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KVariance;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.1")
/* loaded from: classes3.dex */
public final class t {
    @k.e.a.e
    private final KVariance a;
    @k.e.a.e
    private final r b;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public static final a f15641d = new a(null);
    @h.k2.d
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final t f15640c = new t(null, null);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "star", "getStar$annotations", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        @p0
        public static /* synthetic */ void d() {
        }

        @h.k2.k
        @k.e.a.d
        public final t a(@k.e.a.d r rVar) {
            return new t(KVariance.IN, rVar);
        }

        @h.k2.k
        @k.e.a.d
        public final t b(@k.e.a.d r rVar) {
            return new t(KVariance.OUT, rVar);
        }

        @k.e.a.d
        public final t c() {
            return t.f15640c;
        }

        @h.k2.k
        @k.e.a.d
        public final t e(@k.e.a.d r rVar) {
            return new t(KVariance.INVARIANT, rVar);
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public t(@k.e.a.e KVariance kVariance, @k.e.a.e r rVar) {
        String str;
        this.a = kVariance;
        this.b = rVar;
        if ((kVariance == null) == (rVar == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @h.k2.k
    @k.e.a.d
    public static final t c(@k.e.a.d r rVar) {
        return f15641d.a(rVar);
    }

    public static /* synthetic */ t e(t tVar, KVariance kVariance, r rVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kVariance = tVar.a;
        }
        if ((i2 & 2) != 0) {
            rVar = tVar.b;
        }
        return tVar.d(kVariance, rVar);
    }

    @h.k2.k
    @k.e.a.d
    public static final t f(@k.e.a.d r rVar) {
        return f15641d.b(rVar);
    }

    @h.k2.k
    @k.e.a.d
    public static final t h(@k.e.a.d r rVar) {
        return f15641d.e(rVar);
    }

    @k.e.a.e
    public final KVariance a() {
        return this.a;
    }

    @k.e.a.e
    public final r b() {
        return this.b;
    }

    @k.e.a.d
    public final t d(@k.e.a.e KVariance kVariance, @k.e.a.e r rVar) {
        return new t(kVariance, rVar);
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this != obj) {
            if (obj instanceof t) {
                t tVar = (t) obj;
                return f0.g(this.a, tVar.a) && f0.g(this.b, tVar.b);
            }
            return false;
        }
        return true;
    }

    @k.e.a.e
    public final KVariance g() {
        return this.a;
    }

    @k.e.a.e
    public final r getType() {
        return this.b;
    }

    public int hashCode() {
        KVariance kVariance = this.a;
        int hashCode = (kVariance != null ? kVariance.hashCode() : 0) * 31;
        r rVar = this.b;
        return hashCode + (rVar != null ? rVar.hashCode() : 0);
    }

    @k.e.a.d
    public String toString() {
        KVariance kVariance = this.a;
        if (kVariance == null) {
            return "*";
        }
        int i2 = u.a[kVariance.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return "in " + this.b;
            } else if (i2 == 3) {
                return "out " + this.b;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return String.valueOf(this.b);
    }
}

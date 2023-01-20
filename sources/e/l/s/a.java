package e.l.s;

import h.k2.v.f0;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class a {
    @k.e.a.d
    private final String a;
    @k.e.a.d
    private final String b;

    public a(@k.e.a.d String str, @k.e.a.d String str2) {
        this.a = str;
        this.b = str2;
    }

    public static /* synthetic */ a d(a aVar, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aVar.a;
        }
        if ((i2 & 2) != 0) {
            str2 = aVar.b;
        }
        return aVar.c(str, str2);
    }

    @k.e.a.d
    public final String a() {
        return this.a;
    }

    @k.e.a.d
    public final String b() {
        return this.b;
    }

    @k.e.a.d
    public final a c(@k.e.a.d String str, @k.e.a.d String str2) {
        return new a(str, str2);
    }

    @k.e.a.d
    public final String e() {
        return this.b;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(a.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.viewmodel.FilterInfo");
            return f0.g(this.b, ((a) obj).b);
        }
        return false;
    }

    @k.e.a.d
    public final String f() {
        return this.a;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    @k.e.a.d
    public String toString() {
        return "FilterInfo(showName=" + this.a + ", requestKey=" + this.b + ')';
    }
}

package h.p2.b0.g.t.e.a.v.j;

import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.c.t0;
import k.e.a.d;
import k.e.a.e;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;

/* loaded from: classes3.dex */
public final class a {
    @d
    private final TypeUsage a;
    @d
    private final JavaTypeFlexibility b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f15291c;
    @e

    /* renamed from: d  reason: collision with root package name */
    private final t0 f15292d;

    public a(@d TypeUsage typeUsage, @d JavaTypeFlexibility javaTypeFlexibility, boolean z, @e t0 t0Var) {
        this.a = typeUsage;
        this.b = javaTypeFlexibility;
        this.f15291c = z;
        this.f15292d = t0Var;
    }

    public static /* synthetic */ a b(a aVar, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, t0 t0Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            typeUsage = aVar.a;
        }
        if ((i2 & 2) != 0) {
            javaTypeFlexibility = aVar.b;
        }
        if ((i2 & 4) != 0) {
            z = aVar.f15291c;
        }
        if ((i2 & 8) != 0) {
            t0Var = aVar.f15292d;
        }
        return aVar.a(typeUsage, javaTypeFlexibility, z, t0Var);
    }

    @d
    public final a a(@d TypeUsage typeUsage, @d JavaTypeFlexibility javaTypeFlexibility, boolean z, @e t0 t0Var) {
        return new a(typeUsage, javaTypeFlexibility, z, t0Var);
    }

    @d
    public final JavaTypeFlexibility c() {
        return this.b;
    }

    @d
    public final TypeUsage d() {
        return this.a;
    }

    @e
    public final t0 e() {
        return this.f15292d;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.f15291c == aVar.f15291c && f0.g(this.f15292d, aVar.f15292d);
        }
        return false;
    }

    public final boolean f() {
        return this.f15291c;
    }

    @d
    public final a g(@d JavaTypeFlexibility javaTypeFlexibility) {
        return b(this, null, javaTypeFlexibility, false, null, 13, null);
    }

    @d
    public final a h(@d t0 t0Var) {
        return b(this, null, null, false, t0Var, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        boolean z = this.f15291c;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        t0 t0Var = this.f15292d;
        return i3 + (t0Var == null ? 0 : t0Var.hashCode());
    }

    @d
    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.a + ", flexibility=" + this.b + ", isForAnnotationParameter=" + this.f15291c + ", upperBoundOfTypeParameter=" + this.f15292d + ')';
    }

    public /* synthetic */ a(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, t0 t0Var, int i2, u uVar) {
        this(typeUsage, (i2 & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : t0Var);
    }
}

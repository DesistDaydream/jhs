package h.p2.b0.g.t.e.a.y;

import h.k2.v.u;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* loaded from: classes3.dex */
public final class g {
    @k.e.a.d
    private final NullabilityQualifier a;
    private final boolean b;

    public g(@k.e.a.d NullabilityQualifier nullabilityQualifier, boolean z) {
        this.a = nullabilityQualifier;
        this.b = z;
    }

    public static /* synthetic */ g b(g gVar, NullabilityQualifier nullabilityQualifier, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            nullabilityQualifier = gVar.a;
        }
        if ((i2 & 2) != 0) {
            z = gVar.b;
        }
        return gVar.a(nullabilityQualifier, z);
    }

    @k.e.a.d
    public final g a(@k.e.a.d NullabilityQualifier nullabilityQualifier, boolean z) {
        return new g(nullabilityQualifier, z);
    }

    @k.e.a.d
    public final NullabilityQualifier c() {
        return this.a;
    }

    public final boolean d() {
        return this.b;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.a == gVar.a && this.b == gVar.b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        boolean z = this.b;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    @k.e.a.d
    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.a + ", isForWarningOnly=" + this.b + ')';
    }

    public /* synthetic */ g(NullabilityQualifier nullabilityQualifier, boolean z, int i2, u uVar) {
        this(nullabilityQualifier, (i2 & 2) != 0 ? false : z);
    }
}

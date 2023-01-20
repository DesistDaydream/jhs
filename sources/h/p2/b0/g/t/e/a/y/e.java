package h.p2.b0.g.t.e.a.y;

import h.k2.v.u;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* loaded from: classes3.dex */
public final class e {
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public static final a f15295e = new a(null);
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final e f15296f = new e(null, null, false, false, 8, null);
    @k.e.a.e
    private final NullabilityQualifier a;
    @k.e.a.e
    private final MutabilityQualifier b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f15297c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15298d;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k.e.a.d
        public final e a() {
            return e.f15296f;
        }
    }

    public e(@k.e.a.e NullabilityQualifier nullabilityQualifier, @k.e.a.e MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        this.a = nullabilityQualifier;
        this.b = mutabilityQualifier;
        this.f15297c = z;
        this.f15298d = z2;
    }

    @k.e.a.e
    public final MutabilityQualifier b() {
        return this.b;
    }

    @k.e.a.e
    public final NullabilityQualifier c() {
        return this.a;
    }

    public final boolean d() {
        return this.f15297c;
    }

    public final boolean e() {
        return this.f15298d;
    }

    public /* synthetic */ e(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2, int i2, u uVar) {
        this(nullabilityQualifier, mutabilityQualifier, z, (i2 & 8) != 0 ? false : z2);
    }
}

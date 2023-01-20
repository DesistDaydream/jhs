package kotlin.reflect.jvm.internal.impl.util;

import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.n.z;
import h.p2.b0.g.t.o.b;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public abstract class ReturnsCheck implements b {
    @d
    private final String a;
    @d
    private final l<f, z> b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final String f16880c;

    /* loaded from: classes3.dex */
    public static final class ReturnsBoolean extends ReturnsCheck {
        @d

        /* renamed from: d  reason: collision with root package name */
        public static final ReturnsBoolean f16881d = new ReturnsBoolean();

        /* renamed from: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsBoolean$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass1 extends Lambda implements l<f, z> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // h.k2.u.l
            @d
            public final z invoke(@d f fVar) {
                return fVar.n();
            }
        }

        private ReturnsBoolean() {
            super("Boolean", AnonymousClass1.INSTANCE, null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class ReturnsInt extends ReturnsCheck {
        @d

        /* renamed from: d  reason: collision with root package name */
        public static final ReturnsInt f16882d = new ReturnsInt();

        /* renamed from: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsInt$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass1 extends Lambda implements l<f, z> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // h.k2.u.l
            @d
            public final z invoke(@d f fVar) {
                return fVar.D();
            }
        }

        private ReturnsInt() {
            super("Int", AnonymousClass1.INSTANCE, null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class ReturnsUnit extends ReturnsCheck {
        @d

        /* renamed from: d  reason: collision with root package name */
        public static final ReturnsUnit f16883d = new ReturnsUnit();

        /* renamed from: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsUnit$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass1 extends Lambda implements l<f, z> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // h.k2.u.l
            @d
            public final z invoke(@d f fVar) {
                return fVar.Y();
            }
        }

        private ReturnsUnit() {
            super("Unit", AnonymousClass1.INSTANCE, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ReturnsCheck(String str, l<? super f, ? extends z> lVar) {
        this.a = str;
        this.b = lVar;
        this.f16880c = f0.C("must return ", str);
    }

    public /* synthetic */ ReturnsCheck(String str, l lVar, u uVar) {
        this(str, lVar);
    }

    @Override // h.p2.b0.g.t.o.b
    @e
    public String a(@d v vVar) {
        return b.a.a(this, vVar);
    }

    @Override // h.p2.b0.g.t.o.b
    public boolean b(@d v vVar) {
        return f0.g(vVar.getReturnType(), this.b.invoke(DescriptorUtilsKt.g(vVar)));
    }

    @Override // h.p2.b0.g.t.o.b
    @d
    public String getDescription() {
        return this.f16880c;
    }
}

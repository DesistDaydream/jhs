package kotlin.reflect.jvm.internal.impl.types;

import h.a2.t;
import h.k2.u.l;
import h.p2.b0.g.t.c.r0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.z;
import h.t1;
import java.util.Collection;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;

/* loaded from: classes3.dex */
public final class AbstractTypeConstructor$supertypes$3 extends Lambda implements l<AbstractTypeConstructor.a, t1> {
    public final /* synthetic */ AbstractTypeConstructor this$0;

    /* renamed from: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends Lambda implements l<q0, Iterable<? extends z>> {
        public final /* synthetic */ AbstractTypeConstructor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AbstractTypeConstructor abstractTypeConstructor) {
            super(1);
            this.this$0 = abstractTypeConstructor;
        }

        @Override // h.k2.u.l
        @d
        public final Iterable<z> invoke(@d q0 q0Var) {
            Collection g2;
            g2 = this.this$0.g(q0Var, true);
            return g2;
        }
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends Lambda implements l<z, t1> {
        public final /* synthetic */ AbstractTypeConstructor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AbstractTypeConstructor abstractTypeConstructor) {
            super(1);
            this.this$0 = abstractTypeConstructor;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(z zVar) {
            invoke2(zVar);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d z zVar) {
            this.this$0.s(zVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$supertypes$3(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.this$0 = abstractTypeConstructor;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(AbstractTypeConstructor.a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d AbstractTypeConstructor.a aVar) {
        Collection<z> a = this.this$0.n().a(this.this$0, aVar.a(), new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(this.this$0), new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(this.this$0));
        if (a.isEmpty()) {
            z i2 = this.this$0.i();
            a = i2 == null ? null : t.k(i2);
            if (a == null) {
                a = CollectionsKt__CollectionsKt.E();
            }
        }
        if (this.this$0.m()) {
            r0 n = this.this$0.n();
            AbstractTypeConstructor abstractTypeConstructor = this.this$0;
            n.a(abstractTypeConstructor, a, new AnonymousClass2(abstractTypeConstructor), new AnonymousClass3(this.this$0));
        }
        AbstractTypeConstructor abstractTypeConstructor2 = this.this$0;
        List<z> list = a instanceof List ? (List) a : null;
        if (list == null) {
            list = CollectionsKt___CollectionsKt.I5(a);
        }
        aVar.c(abstractTypeConstructor2.r(list));
    }
}

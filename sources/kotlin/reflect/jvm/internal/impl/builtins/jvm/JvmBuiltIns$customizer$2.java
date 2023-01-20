package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import h.k2.u.a;
import h.p2.b0.g.t.m.m;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;

/* loaded from: classes3.dex */
public final class JvmBuiltIns$customizer$2 extends Lambda implements a<JvmBuiltInsCustomizer> {
    public final /* synthetic */ m $storageManager;
    public final /* synthetic */ JvmBuiltIns this$0;

    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$customizer$2$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements a<JvmBuiltIns.a> {
        public final /* synthetic */ JvmBuiltIns this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(JvmBuiltIns jvmBuiltIns) {
            super(0);
            this.this$0 = jvmBuiltIns;
        }

        @Override // h.k2.u.a
        @d
        public final JvmBuiltIns.a invoke() {
            a aVar;
            aVar = this.this$0.f16429j;
            if (aVar != null) {
                JvmBuiltIns.a aVar2 = (JvmBuiltIns.a) aVar.invoke();
                this.this$0.f16429j = null;
                return aVar2;
            }
            throw new AssertionError("JvmBuiltins instance has not been initialized properly");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns$customizer$2(JvmBuiltIns jvmBuiltIns, m mVar) {
        super(0);
        this.this$0 = jvmBuiltIns;
        this.$storageManager = mVar;
    }

    @Override // h.k2.u.a
    @d
    public final JvmBuiltInsCustomizer invoke() {
        return new JvmBuiltInsCustomizer(this.this$0.r(), this.$storageManager, new AnonymousClass1(this.this$0));
    }
}

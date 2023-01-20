package kotlinx.coroutines.selects;

import h.k2.u.a;
import h.k2.u.p;
import h.t1;
import i.b.z3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0006\b\u0002\u0010\u0002 \u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"P", "Q", "R", "Lh/t1;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class UnbiasedSelectBuilderImpl$invoke$3 extends Lambda implements a<t1> {
    public final /* synthetic */ p $block;
    public final /* synthetic */ Object $param;
    public final /* synthetic */ e $this_invoke;
    public final /* synthetic */ UnbiasedSelectBuilderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnbiasedSelectBuilderImpl$invoke$3(UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl, e eVar, Object obj, p pVar) {
        super(0);
        this.this$0 = unbiasedSelectBuilderImpl;
        this.$this_invoke = eVar;
        this.$param = obj;
        this.$block = pVar;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke */
    public final void invoke2() {
        this.$this_invoke.z(this.this$0.b(), this.$param, this.$block);
    }
}

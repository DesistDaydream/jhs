package kotlinx.coroutines.selects;

import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lh/t1;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class UnbiasedSelectBuilderImpl$onTimeout$1 extends Lambda implements a<t1> {
    public final /* synthetic */ l $block;
    public final /* synthetic */ long $timeMillis;
    public final /* synthetic */ UnbiasedSelectBuilderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnbiasedSelectBuilderImpl$onTimeout$1(UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl, long j2, l lVar) {
        super(0);
        this.this$0 = unbiasedSelectBuilderImpl;
        this.$timeMillis = j2;
        this.$block = lVar;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke */
    public final void invoke2() {
        this.this$0.b().h(this.$timeMillis, this.$block);
    }
}

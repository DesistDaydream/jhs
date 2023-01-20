package kotlinx.coroutines.channels;

import h.k2.u.l;
import h.t1;
import i.b.t3.o;
import i.b.t3.y;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "cause", "Lh/t1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelsKt__Channels_commonKt$consumes$1 extends Lambda implements l<Throwable, t1> {
    public final /* synthetic */ y $this_consumes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__Channels_commonKt$consumes$1(y yVar) {
        super(1);
        this.$this_consumes = yVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Throwable th) {
        invoke2(th);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Throwable th) {
        o.r(this.$this_consumes, th);
    }
}

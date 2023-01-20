package com.eth.binder;

import androidx.exifinterface.media.ExifInterface;
import com.eth.model.NLive;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import e.g.f.a;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "com.eth.binder.BaseFlowBinder$launch$3", f = "FlowBinder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AdvanceSetting.NETWORK_TYPE, "Lkotlin/Pair;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class BaseFlowBinder$launch$3 extends SuspendLambda implements p<Pair<? extends T, ? extends T>, c<? super t1>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ BaseFlowBinder<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFlowBinder$launch$3(BaseFlowBinder<T> baseFlowBinder, c<? super BaseFlowBinder$launch$3> cVar) {
        super(2, cVar);
        this.this$0 = baseFlowBinder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        BaseFlowBinder$launch$3 baseFlowBinder$launch$3 = new BaseFlowBinder$launch$3(this.this$0, cVar);
        baseFlowBinder$launch$3.L$0 = obj;
        return baseFlowBinder$launch$3;
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@k.e.a.d Pair<? extends T, ? extends T> pair, @e c<? super t1> cVar) {
        return ((BaseFlowBinder$launch$3) create(pair, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            Pair pair = (Pair) this.L$0;
            for (a aVar : e.g.b.a.a()) {
                aVar.a(pair.getSecond());
            }
            this.this$0.u(pair.getFirst(), pair.getSecond());
            this.this$0.t(NLive.State.SUCCESS);
            return t1.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

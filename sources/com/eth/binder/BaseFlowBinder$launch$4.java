package com.eth.binder;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.q;
import h.r0;
import h.t1;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "com.eth.binder.BaseFlowBinder$launch$4", f = "FlowBinder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class BaseFlowBinder$launch$4 extends SuspendLambda implements q<f<? super Pair<? extends T, ? extends T>>, Throwable, c<? super t1>, Object> {
    public int label;
    public final /* synthetic */ BaseFlowBinder<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFlowBinder$launch$4(BaseFlowBinder<T> baseFlowBinder, c<? super BaseFlowBinder$launch$4> cVar) {
        super(3, cVar);
        this.this$0 = baseFlowBinder;
    }

    @Override // h.k2.u.q
    @e
    public final Object invoke(@k.e.a.d f<? super Pair<? extends T, ? extends T>> fVar, @e Throwable th, @e c<? super t1> cVar) {
        return new BaseFlowBinder$launch$4(this.this$0, cVar).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            this.this$0.m();
            return t1.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

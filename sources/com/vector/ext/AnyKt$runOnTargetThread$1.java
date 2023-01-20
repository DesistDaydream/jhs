package com.vector.ext;

import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.a;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "com.vector.ext.AnyKt$runOnTargetThread$1", f = "Any.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AnyKt$runOnTargetThread$1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ a<t1> $block;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnyKt$runOnTargetThread$1(a<t1> aVar, c<? super AnyKt$runOnTargetThread$1> cVar) {
        super(2, cVar);
        this.$block = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        return new AnyKt$runOnTargetThread$1(this.$block, cVar);
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@k.e.a.d n0 n0Var, @e c<? super t1> cVar) {
        return ((AnyKt$runOnTargetThread$1) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            this.$block.invoke();
            return t1.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

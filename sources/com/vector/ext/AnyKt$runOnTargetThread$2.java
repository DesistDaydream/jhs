package com.vector.ext;

import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.a;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import i.b.w0;
import java.util.concurrent.TimeUnit;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "com.vector.ext.AnyKt$runOnTargetThread$2", f = "Any.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AnyKt$runOnTargetThread$2 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ a<t1> $block;
    public final /* synthetic */ long $delay;
    public final /* synthetic */ TimeUnit $timeUnit;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnyKt$runOnTargetThread$2(TimeUnit timeUnit, long j2, a<t1> aVar, c<? super AnyKt$runOnTargetThread$2> cVar) {
        super(2, cVar);
        this.$timeUnit = timeUnit;
        this.$delay = j2;
        this.$block = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        return new AnyKt$runOnTargetThread$2(this.$timeUnit, this.$delay, this.$block, cVar);
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@k.e.a.d n0 n0Var, @e c<? super t1> cVar) {
        return ((AnyKt$runOnTargetThread$2) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            long millis = this.$timeUnit.toMillis(this.$delay);
            this.label = 1;
            if (w0.b(millis, this) == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            r0.n(obj);
        }
        this.$block.invoke();
        return t1.a;
    }
}

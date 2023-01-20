package com.eth.ext;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import i.b.v3.h;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;

@d(c = "com.eth.ext.CoroutineKt$launch$2", f = "Coroutine.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class CoroutineKt$launch$2 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ Flow<T> $this_launch;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineKt$launch$2(Flow<? extends T> flow, c<? super CoroutineKt$launch$2> cVar) {
        super(2, cVar);
        this.$this_launch = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        return new CoroutineKt$launch$2(this.$this_launch, cVar);
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@k.e.a.d n0 n0Var, @e c<? super t1> cVar) {
        return ((CoroutineKt$launch$2) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            Flow<T> flow = this.$this_launch;
            this.label = 1;
            if (h.z(flow, this) == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            r0.n(obj);
        }
        return t1.a;
    }
}

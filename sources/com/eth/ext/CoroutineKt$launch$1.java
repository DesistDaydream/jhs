package com.eth.ext;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.l;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;

@d(c = "com.eth.ext.CoroutineKt$launch$1", f = "Coroutine.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class CoroutineKt$launch$1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ l<T, t1> $result;
    public final /* synthetic */ Flow<T> $this_launch;
    public int label;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class a implements f<T> {
        public final /* synthetic */ l a;

        public a(l lVar) {
            this.a = lVar;
        }

        @Override // i.b.v3.f
        @e
        public Object emit(Object obj, @k.e.a.d c cVar) {
            Object invoke = this.a.invoke(obj);
            return invoke == b.h() ? invoke : t1.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineKt$launch$1(Flow<? extends T> flow, l<? super T, t1> lVar, c<? super CoroutineKt$launch$1> cVar) {
        super(2, cVar);
        this.$this_launch = flow;
        this.$result = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        return new CoroutineKt$launch$1(this.$this_launch, this.$result, cVar);
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@k.e.a.d n0 n0Var, @e c<? super t1> cVar) {
        return ((CoroutineKt$launch$1) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            Flow<T> flow = this.$this_launch;
            a aVar = new a(this.$result);
            this.label = 1;
            if (flow.e(aVar, this) == h2) {
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

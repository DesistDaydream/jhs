package i.b.v3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.k2.v.f0;
import h.t1;
import i.b.b2;
import i.b.s1;
import i.b.v3.c0.k;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a#\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0010\u0010\u000b\u001ab\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00022#\u0010\u0016\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u0014¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "b", "(Lkotlinx/coroutines/flow/Flow;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", am.av, "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "g", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/coroutines/CoroutineContext;", "context", "h", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/flow/Flow;", com.huawei.hms.push.e.a, "R", "flowContext", "bufferSize", "Lkotlin/Function1;", "Lh/q;", "builder", "i", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILh/k2/u/l;)Lkotlinx/coroutines/flow/Flow;", "Lh/t1;", "f", "(Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class i {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"i/b/v3/i$a", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", com.huawei.hms.push.e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements Flow<R> {
        public final /* synthetic */ Flow a;
        public final /* synthetic */ int b;

        /* renamed from: c */
        public final /* synthetic */ h.k2.u.l f15868c;

        /* renamed from: d */
        public final /* synthetic */ CoroutineContext f15869d;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"i/b/v3/i$a$a", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__ContextKt$$special$$inlined$collect$1"}, k = 1, mv = {1, 4, 0})
        /* renamed from: i.b.v3.i$a$a */
        /* loaded from: classes4.dex */
        public static final class C0483a implements f<R> {
            public final /* synthetic */ f a;

            public C0483a(f fVar) {
                this.a = fVar;
            }

            @Override // i.b.v3.f
            @k.e.a.e
            public Object emit(Object obj, @k.e.a.d h.e2.c cVar) {
                Object emit = this.a.emit(obj, cVar);
                return emit == h.e2.j.b.h() ? emit : t1.a;
            }
        }

        public a(Flow flow, int i2, h.k2.u.l lVar, CoroutineContext coroutineContext) {
            this.a = flow;
            this.b = i2;
            this.f15868c = lVar;
            this.f15869d = coroutineContext;
        }

        @Override // kotlinx.coroutines.flow.Flow
        @k.e.a.e
        public Object e(@k.e.a.d f fVar, @k.e.a.d h.e2.c cVar) {
            Flow d2;
            Flow d3;
            d2 = i.d(h.S0(this.a, cVar.getContext().minusKey(b2.y0)), this.b, null, 2, null);
            d3 = i.d(h.S0((Flow) this.f15868c.invoke(d2), this.f15869d), this.b, null, 2, null);
            Object e2 = d3.e(new C0483a(fVar), cVar);
            return e2 == h.e2.j.b.h() ? e2 : t1.a;
        }
    }

    @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    @k.e.a.d
    public static final /* synthetic */ <T> Flow<T> a(@k.e.a.d Flow<? extends T> flow, int i2) {
        Flow<T> d2;
        d2 = d(flow, i2, null, 2, null);
        return d2;
    }

    @k.e.a.d
    public static final <T> Flow<T> b(@k.e.a.d Flow<? extends T> flow, int i2, @k.e.a.d BufferOverflow bufferOverflow) {
        int i3;
        BufferOverflow bufferOverflow2;
        boolean z = true;
        if (i2 >= 0 || i2 == -2 || i2 == -1) {
            if (i2 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
                z = false;
            }
            if (z) {
                if (i2 == -1) {
                    bufferOverflow2 = BufferOverflow.DROP_OLDEST;
                    i3 = 0;
                } else {
                    i3 = i2;
                    bufferOverflow2 = bufferOverflow;
                }
                return flow instanceof i.b.v3.c0.k ? k.a.a((i.b.v3.c0.k) flow, null, i3, bufferOverflow2, 1, null) : new i.b.v3.c0.f(flow, null, i3, bufferOverflow2, 2, null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i2).toString());
    }

    public static /* synthetic */ Flow c(Flow flow, int i2, int i3, Object obj) {
        Flow a2;
        if ((i3 & 1) != 0) {
            i2 = -2;
        }
        a2 = a(flow, i2);
        return a2;
    }

    public static /* synthetic */ Flow d(Flow flow, int i2, BufferOverflow bufferOverflow, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -2;
        }
        if ((i3 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return h.q(flow, i2, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @k.e.a.d
    public static final <T> Flow<T> e(@k.e.a.d Flow<? extends T> flow) {
        return flow instanceof i.b.v3.a ? flow : new b(flow);
    }

    private static final void f(CoroutineContext coroutineContext) {
        if (coroutineContext.get(b2.y0) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
    }

    @k.e.a.d
    public static final <T> Flow<T> g(@k.e.a.d Flow<? extends T> flow) {
        Flow<T> d2;
        d2 = d(flow, -1, null, 2, null);
        return d2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @k.e.a.d
    public static final <T> Flow<T> h(@k.e.a.d Flow<? extends T> flow, @k.e.a.d CoroutineContext coroutineContext) {
        f(coroutineContext);
        return f0.g(coroutineContext, EmptyCoroutineContext.INSTANCE) ? flow : flow instanceof i.b.v3.c0.k ? k.a.a((i.b.v3.c0.k) flow, coroutineContext, 0, null, 6, null) : new i.b.v3.c0.f(flow, coroutineContext, 0, null, 12, null);
    }

    @s1
    @h.i(level = DeprecationLevel.ERROR, message = "flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
    @k.e.a.d
    public static final <T, R> Flow<R> i(@k.e.a.d Flow<? extends T> flow, @k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d h.k2.u.l<? super Flow<? extends T>, ? extends Flow<? extends R>> lVar) {
        f(coroutineContext);
        return new a(flow, i2, lVar, coroutineContext);
    }

    public static /* synthetic */ Flow j(Flow flow, CoroutineContext coroutineContext, int i2, h.k2.u.l lVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = -2;
        }
        return h.V0(flow, coroutineContext, i2, lVar);
    }
}

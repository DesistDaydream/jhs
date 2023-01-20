package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.e2.d;
import h.e2.j.b;
import h.k2.d;
import h.k2.v.f0;
import h.t1;
import i.b.t3.w;
import i.b.v3.c0.o;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B-\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H¤@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0094@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158\u0004@\u0005X\u0085\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Li/b/v3/f;", "collector", "Lh/t1;", am.aI, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "newContext", "s", "(Li/b/v3/f;Lkotlin/coroutines/CoroutineContext;Lh/e2/c;)Ljava/lang/Object;", "Li/b/t3/w;", "scope", "k", "(Li/b/t3/w;Lh/e2/c;)Ljava/lang/Object;", e.a, "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/flow/Flow;", f.f10128d, "Lkotlinx/coroutines/flow/Flow;", "flow", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {
    @d
    @k.e.a.d

    /* renamed from: d */
    public final Flow<S> f16975d;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(@k.e.a.d Flow<? extends S> flow, @k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.f16975d = flow;
    }

    public static /* synthetic */ Object q(ChannelFlowOperator channelFlowOperator, i.b.v3.f fVar, c cVar) {
        if (channelFlowOperator.b == -3) {
            CoroutineContext context = cVar.getContext();
            CoroutineContext plus = context.plus(channelFlowOperator.a);
            if (f0.g(plus, context)) {
                Object t = channelFlowOperator.t(fVar, cVar);
                return t == b.h() ? t : t1.a;
            }
            d.b bVar = h.e2.d.v0;
            if (f0.g((h.e2.d) plus.get(bVar), (h.e2.d) context.get(bVar))) {
                Object s = channelFlowOperator.s(fVar, plus, cVar);
                return s == b.h() ? s : t1.a;
            }
        }
        Object e2 = super.e(fVar, cVar);
        return e2 == b.h() ? e2 : t1.a;
    }

    public static /* synthetic */ Object r(ChannelFlowOperator channelFlowOperator, w wVar, c cVar) {
        Object t = channelFlowOperator.t(new o(wVar), cVar);
        return t == b.h() ? t : t1.a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    @k.e.a.e
    public Object e(@k.e.a.d i.b.v3.f<? super T> fVar, @k.e.a.d c<? super t1> cVar) {
        return q(this, fVar, cVar);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @k.e.a.e
    public Object k(@k.e.a.d w<? super T> wVar, @k.e.a.d c<? super t1> cVar) {
        return r(this, wVar, cVar);
    }

    @k.e.a.e
    public final /* synthetic */ Object s(@k.e.a.d i.b.v3.f<? super T> fVar, @k.e.a.d CoroutineContext coroutineContext, @k.e.a.d c<? super t1> cVar) {
        i.b.v3.f e2;
        e2 = i.b.v3.c0.e.e(fVar, cVar.getContext());
        Object d2 = i.b.v3.c0.e.d(coroutineContext, e2, null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), cVar, 4, null);
        return d2 == b.h() ? d2 : t1.a;
    }

    @k.e.a.e
    public abstract Object t(@k.e.a.d i.b.v3.f<? super T> fVar, @k.e.a.d c<? super t1> cVar);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @k.e.a.d
    public String toString() {
        return this.f16975d + " -> " + super.toString();
    }
}

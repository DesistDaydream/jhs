package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.k2.v.u;
import h.t1;
import i.b.i;
import i.b.n0;
import i.b.t3.w;
import i.b.t3.y;
import i.b.v3.c0.o;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00150\u0014\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00150\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", NotifyType.LIGHTS, "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Li/b/n0;", "scope", "Li/b/t3/y;", am.ax, "(Li/b/n0;)Li/b/t3/y;", "Li/b/t3/w;", "Lh/t1;", "k", "(Li/b/t3/w;Lh/e2/c;)Ljava/lang/Object;", "", "Lkotlinx/coroutines/flow/Flow;", f.f10128d, "Ljava/lang/Iterable;", "flows", "<init>", "(Ljava/lang/Iterable;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelLimitedFlowMerge<T> extends ChannelFlow<T> {

    /* renamed from: d  reason: collision with root package name */
    private final Iterable<Flow<T>> f16978d;

    public /* synthetic */ ChannelLimitedFlowMerge(Iterable iterable, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, int i3, u uVar) {
        this(iterable, (i3 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i3 & 4) != 0 ? -2 : i2, (i3 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @e
    public Object k(@d w<? super T> wVar, @d c<? super t1> cVar) {
        o oVar = new o(wVar);
        for (Flow<T> flow : this.f16978d) {
            i.f(wVar, null, null, new ChannelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1(flow, null, wVar, oVar), 3, null);
        }
        return t1.a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @d
    public ChannelFlow<T> l(@d CoroutineContext coroutineContext, int i2, @d BufferOverflow bufferOverflow) {
        return new ChannelLimitedFlowMerge(this.f16978d, coroutineContext, i2, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @d
    public y<T> p(@d n0 n0Var) {
        return FlowCoroutineKt.a(n0Var, this.a, this.b, n());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelLimitedFlowMerge(@d Iterable<? extends Flow<? extends T>> iterable, @d CoroutineContext coroutineContext, int i2, @d BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.f16978d = iterable;
    }
}

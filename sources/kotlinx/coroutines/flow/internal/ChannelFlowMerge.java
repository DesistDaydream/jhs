package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.e;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.e2.j.b;
import h.k2.v.u;
import h.t1;
import i.b.b2;
import i.b.n0;
import i.b.t3.w;
import i.b.t3.y;
import i.b.v3.c0.o;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.SemaphoreKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BA\u0012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowMerge;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", NotifyType.LIGHTS, "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Li/b/n0;", "scope", "Li/b/t3/y;", am.ax, "(Li/b/n0;)Li/b/t3/y;", "Li/b/t3/w;", "Lh/t1;", "k", "(Li/b/t3/w;Lh/e2/c;)Ljava/lang/Object;", "", "h", "()Ljava/lang/String;", "Lkotlinx/coroutines/flow/Flow;", f.f10128d, "Lkotlinx/coroutines/flow/Flow;", "flow", e.a, ExpandableTextView.P, "concurrency", "<init>", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelFlowMerge<T> extends ChannelFlow<T> {

    /* renamed from: d  reason: collision with root package name */
    private final Flow<Flow<T>> f16971d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16972e;

    public /* synthetic */ ChannelFlowMerge(Flow flow, int i2, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow, int i4, u uVar) {
        this(flow, i2, (i4 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i4 & 8) != 0 ? -2 : i3, (i4 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @d
    public String h() {
        return "concurrency=" + this.f16972e;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @k.e.a.e
    public Object k(@d w<? super T> wVar, @d c<? super t1> cVar) {
        Object e2 = this.f16971d.e(new ChannelFlowMerge$collectTo$$inlined$collect$1((b2) cVar.getContext().get(b2.y0), SemaphoreKt.b(this.f16972e, 0, 2, null), wVar, new o(wVar)), cVar);
        return e2 == b.h() ? e2 : t1.a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @d
    public ChannelFlow<T> l(@d CoroutineContext coroutineContext, int i2, @d BufferOverflow bufferOverflow) {
        return new ChannelFlowMerge(this.f16971d, this.f16972e, coroutineContext, i2, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @d
    public y<T> p(@d n0 n0Var) {
        return FlowCoroutineKt.a(n0Var, this.a, this.b, n());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge(@d Flow<? extends Flow<? extends T>> flow, int i2, @d CoroutineContext coroutineContext, int i3, @d BufferOverflow bufferOverflow) {
        super(coroutineContext, i3, bufferOverflow);
        this.f16971d = flow;
        this.f16972e = i2;
    }
}

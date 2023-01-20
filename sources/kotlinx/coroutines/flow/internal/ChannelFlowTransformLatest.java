package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.a;
import h.k2.u.q;
import h.k2.v.u;
import h.t1;
import i.b.q0;
import i.b.v3.c0.o;
import i.b.v3.f;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003Bz\u0012B\u0010\u001b\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012¢\u0006\u0002\b\u0018\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011RU\u0010\u001b\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012¢\u0006\u0002\b\u00188\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", NotifyType.LIGHTS, "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Li/b/v3/f;", "collector", "Lh/t1;", am.aI, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "Lkotlin/Function3;", "Lh/k0;", "name", "value", "Lh/e2/c;", "", "Lh/q;", e.a, "Lh/k2/u/q;", "transform", "Lkotlinx/coroutines/flow/Flow;", "flow", "<init>", "(Lh/k2/u/q;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {

    /* renamed from: e  reason: collision with root package name */
    private final q<f<? super R>, T, c<? super t1>, Object> f16976e;

    public /* synthetic */ ChannelFlowTransformLatest(q qVar, Flow flow, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, int i3, u uVar) {
        this(qVar, flow, (i3 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i3 & 8) != 0 ? -2 : i2, (i3 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @d
    public ChannelFlow<R> l(@d CoroutineContext coroutineContext, int i2, @d BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.f16976e, this.f16975d, coroutineContext, i2, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    @k.e.a.e
    public Object t(@d f<? super R> fVar, @d c<? super t1> cVar) {
        if (!q0.b() || a.a(fVar instanceof o).booleanValue()) {
            Object c2 = FlowCoroutineKt.c(new ChannelFlowTransformLatest$flowCollect$3(this, fVar, null), cVar);
            return c2 == b.h() ? c2 : t1.a;
        }
        throw new AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(@d q<? super f<? super R>, ? super T, ? super c<? super t1>, ? extends Object> qVar, @d Flow<? extends T> flow, @d CoroutineContext coroutineContext, int i2, @d BufferOverflow bufferOverflow) {
        super(flow, coroutineContext, i2, bufferOverflow);
        this.f16976e = qVar;
    }
}

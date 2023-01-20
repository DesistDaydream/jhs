package i.b.v3;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import h.t1;
import i.b.n0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__ChannelsKt;
import kotlinx.coroutines.flow.internal.ChannelFlow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u0006\u0010'\u001a\u00020%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u0012\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u0012\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0096@ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0014¢\u0006\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010&R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Li/b/v3/c;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lh/t1;", "q", "()V", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", NotifyType.LIGHTS, "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "m", "()Lkotlinx/coroutines/flow/Flow;", "Li/b/t3/w;", "scope", "k", "(Li/b/t3/w;Lh/e2/c;)Ljava/lang/Object;", "Li/b/n0;", "Lkotlinx/coroutines/CoroutineStart;", MessageKey.MSG_ACCEPT_TIME_START, "Li/b/t3/i;", "i", "(Li/b/n0;Lkotlinx/coroutines/CoroutineStart;)Li/b/t3/i;", "Li/b/t3/y;", am.ax, "(Li/b/n0;)Li/b/t3/y;", "Li/b/v3/f;", "collector", com.huawei.hms.push.e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "", "h", "()Ljava/lang/String;", "", "Z", "consume", e.j.a.b.c.f.f10128d, "Li/b/t3/y;", "channel", "<init>", "(Li/b/t3/y;ZLkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class c<T> extends ChannelFlow<T> {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f15860f = AtomicIntegerFieldUpdater.newUpdater(c.class, "consumed");
    private volatile int consumed;

    /* renamed from: d  reason: collision with root package name */
    private final i.b.t3.y<T> f15861d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f15862e;

    public /* synthetic */ c(i.b.t3.y yVar, boolean z, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, int i3, h.k2.v.u uVar) {
        this(yVar, z, (i3 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i3 & 8) != 0 ? -3 : i2, (i3 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    private final void q() {
        if (this.f15862e) {
            if (!(f15860f.getAndSet(this, 1) == 0)) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    @k.e.a.e
    public Object e(@k.e.a.d f<? super T> fVar, @k.e.a.d h.e2.c<? super t1> cVar) {
        if (this.b == -3) {
            q();
            Object f2 = FlowKt__ChannelsKt.f(fVar, this.f15861d, this.f15862e, cVar);
            if (f2 == h.e2.j.b.h()) {
                return f2;
            }
        } else {
            Object e2 = super.e(fVar, cVar);
            if (e2 == h.e2.j.b.h()) {
                return e2;
            }
        }
        return t1.a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @k.e.a.d
    public String h() {
        return "channel=" + this.f15861d;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @k.e.a.d
    public i.b.t3.i<T> i(@k.e.a.d n0 n0Var, @k.e.a.d CoroutineStart coroutineStart) {
        q();
        return super.i(n0Var, coroutineStart);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @k.e.a.e
    public Object k(@k.e.a.d i.b.t3.w<? super T> wVar, @k.e.a.d h.e2.c<? super t1> cVar) {
        Object f2 = FlowKt__ChannelsKt.f(new i.b.v3.c0.o(wVar), this.f15861d, this.f15862e, cVar);
        return f2 == h.e2.j.b.h() ? f2 : t1.a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @k.e.a.d
    public ChannelFlow<T> l(@k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d BufferOverflow bufferOverflow) {
        return new c(this.f15861d, this.f15862e, coroutineContext, i2, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @k.e.a.e
    public Flow<T> m() {
        return new c(this.f15861d, this.f15862e, null, 0, null, 28, null);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @k.e.a.d
    public i.b.t3.y<T> p(@k.e.a.d n0 n0Var) {
        q();
        if (this.b == -3) {
            return this.f15861d;
        }
        return super.p(n0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@k.e.a.d i.b.t3.y<? extends T> yVar, boolean z, @k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.f15861d = yVar;
        this.f15862e = z;
        this.consumed = 0;
    }
}

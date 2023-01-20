package i.b.v3;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import h.t1;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BW\u0012-\u0010\u0019\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013¢\u0006\u0002\b\u0016\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0094@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R@\u0010\u0019\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013¢\u0006\u0002\b\u00168\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Li/b/v3/d;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", NotifyType.LIGHTS, "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Li/b/t3/w;", "scope", "Lh/t1;", "k", "(Li/b/t3/w;Lh/e2/c;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lkotlin/Function2;", "Lh/e2/c;", "", "Lh/q;", e.j.a.b.c.f.f10128d, "Lh/k2/u/p;", ReportItem.LogTypeBlock, "<init>", "(Lh/k2/u/p;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class d<T> extends ChannelFlow<T> {

    /* renamed from: d */
    private final h.k2.u.p<i.b.t3.w<? super T>, h.e2.c<? super t1>, Object> f15867d;

    public /* synthetic */ d(h.k2.u.p pVar, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, int i3, h.k2.v.u uVar) {
        this(pVar, (i3 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i3 & 4) != 0 ? -2 : i2, (i3 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    public static /* synthetic */ Object q(d dVar, i.b.t3.w wVar, h.e2.c cVar) {
        Object invoke = dVar.f15867d.invoke(wVar, cVar);
        return invoke == h.e2.j.b.h() ? invoke : t1.a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @k.e.a.e
    public Object k(@k.e.a.d i.b.t3.w<? super T> wVar, @k.e.a.d h.e2.c<? super t1> cVar) {
        return q(this, wVar, cVar);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @k.e.a.d
    public ChannelFlow<T> l(@k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d BufferOverflow bufferOverflow) {
        return new d(this.f15867d, coroutineContext, i2, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @k.e.a.d
    public String toString() {
        return "block[" + this.f15867d + "] -> " + super.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@k.e.a.d h.k2.u.p<? super i.b.t3.w<? super T>, ? super h.e2.c<? super t1>, ? extends Object> pVar, @k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.f15867d = pVar;
    }
}

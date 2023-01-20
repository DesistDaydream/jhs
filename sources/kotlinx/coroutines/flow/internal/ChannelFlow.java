package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.e;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import h.e2.c;
import h.e2.j.b;
import h.k2.d;
import h.k2.u.p;
import h.k2.v.f0;
import h.t1;
import i.b.n0;
import i.b.o0;
import i.b.q0;
import i.b.r0;
import i.b.t3.i;
import i.b.t3.w;
import i.b.t3.y;
import i.b.v3.c0.k;
import i.b.v3.f;
import i.b.x1;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BroadcastKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.flow.Flow;

@x1
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b4\u00105J\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH$¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H¤@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u0011\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0096@ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0011\u0010#\u001a\u0004\u0018\u00010\"H\u0014¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\"H\u0016¢\u0006\u0004\b%\u0010$R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010&R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010(R;\u0010.\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120*\u0012\u0006\u0012\u0004\u0018\u00010+0)8@@\u0000X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\b8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b2\u00103\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/c0/k;", "Lkotlinx/coroutines/flow/Flow;", "m", "()Lkotlinx/coroutines/flow/Flow;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", am.av, "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", NotifyType.LIGHTS, "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Li/b/t3/w;", "scope", "Lh/t1;", "k", "(Li/b/t3/w;Lh/e2/c;)Ljava/lang/Object;", "Li/b/n0;", "Lkotlinx/coroutines/CoroutineStart;", MessageKey.MSG_ACCEPT_TIME_START, "Li/b/t3/i;", "i", "(Li/b/n0;Lkotlinx/coroutines/CoroutineStart;)Li/b/t3/i;", "Li/b/t3/y;", am.ax, "(Li/b/n0;)Li/b/t3/y;", "Li/b/v3/f;", "collector", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "", "h", "()Ljava/lang/String;", "toString", "Lkotlin/coroutines/CoroutineContext;", "b", ExpandableTextView.P, "Lkotlin/Function2;", "Lh/e2/c;", "", "n", "()Lh/k2/u/p;", "collectToFun", "o", "()I", "produceCapacity", "c", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class ChannelFlow<T> implements k<T> {
    @d
    @k.e.a.d
    public final CoroutineContext a;
    @d
    public final int b;
    @d
    @k.e.a.d

    /* renamed from: c */
    public final BufferOverflow f16970c;

    public ChannelFlow(@k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d BufferOverflow bufferOverflow) {
        this.a = coroutineContext;
        this.b = i2;
        this.f16970c = bufferOverflow;
        if (q0.b()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
    }

    public static /* synthetic */ Object j(ChannelFlow channelFlow, f fVar, c cVar) {
        Object g2 = o0.g(new ChannelFlow$collect$2(channelFlow, fVar, null), cVar);
        return g2 == b.h() ? g2 : t1.a;
    }

    private final int o() {
        int i2 = this.b;
        if (i2 == -3) {
            return -2;
        }
        return i2;
    }

    @Override // i.b.v3.c0.k
    @k.e.a.d
    public Flow<T> a(@k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d BufferOverflow bufferOverflow) {
        if (q0.b()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        CoroutineContext plus = coroutineContext.plus(this.a);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i3 = this.b;
            if (i3 != -3) {
                if (i2 != -3) {
                    if (i3 != -2) {
                        if (i2 != -2) {
                            if (q0.b()) {
                                if (!(this.b >= 0)) {
                                    throw new AssertionError();
                                }
                            }
                            if (q0.b()) {
                                if (!(i2 >= 0)) {
                                    throw new AssertionError();
                                }
                            }
                            i3 = this.b + i2;
                            if (i3 < 0) {
                                i2 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i2 = i3;
            }
            bufferOverflow = this.f16970c;
        }
        return (f0.g(plus, this.a) && i2 == this.b && bufferOverflow == this.f16970c) ? this : l(plus, i2, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.Flow
    @k.e.a.e
    public Object e(@k.e.a.d f<? super T> fVar, @k.e.a.d c<? super t1> cVar) {
        return j(this, fVar, cVar);
    }

    @k.e.a.e
    public String h() {
        return null;
    }

    @k.e.a.d
    public i<T> i(@k.e.a.d n0 n0Var, @k.e.a.d CoroutineStart coroutineStart) {
        int o;
        int i2 = i.b.v3.c0.d.a[this.f16970c.ordinal()];
        if (i2 == 1) {
            o = o();
        } else if (i2 != 2) {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            throw new IllegalArgumentException("Broadcast channel does not support BufferOverflow.DROP_LATEST");
        } else {
            o = -1;
        }
        return BroadcastKt.c(n0Var, this.a, o, coroutineStart, null, n(), 8, null);
    }

    @k.e.a.e
    public abstract Object k(@k.e.a.d w<? super T> wVar, @k.e.a.d c<? super t1> cVar);

    @k.e.a.d
    public abstract ChannelFlow<T> l(@k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d BufferOverflow bufferOverflow);

    @k.e.a.e
    public Flow<T> m() {
        return null;
    }

    @k.e.a.d
    public final p<w<? super T>, c<? super t1>, Object> n() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    @k.e.a.d
    public y<T> p(@k.e.a.d n0 n0Var) {
        return ProduceKt.h(n0Var, this.a, o(), this.f16970c, CoroutineStart.ATOMIC, null, n(), 16, null);
    }

    @k.e.a.d
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String h2 = h();
        if (h2 != null) {
            arrayList.add(h2);
        }
        if (this.a != EmptyCoroutineContext.INSTANCE) {
            arrayList.add("context=" + this.a);
        }
        if (this.b != -3) {
            arrayList.add("capacity=" + this.b);
        }
        if (this.f16970c != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f16970c);
        }
        return r0.a(this) + '[' + CollectionsKt___CollectionsKt.Z2(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}

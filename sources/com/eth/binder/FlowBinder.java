package com.eth.binder;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.eth.model.NLive;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.qcloud.tuicore.TUIConstants;
import e.g.d.b;
import e.g.e.a;
import h.k2.u.l;
import h.t1;
import i.b.n0;
import java.util.Iterator;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/eth/binder/FlowBinder;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/eth/binder/BaseFlowBinder;", "flow", "Lkotlinx/coroutines/flow/Flow;", "live", "Lcom/eth/model/NLive;", "(Lkotlinx/coroutines/flow/Flow;Lcom/eth/model/NLive;)V", "launch", "Lcom/eth/binder/Binder;", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", MessageKey.MSG_ACCEPT_TIME_START, "Lkotlinx/coroutines/CoroutineStart;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "eth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FlowBinder<T> extends BaseFlowBinder<T> {
    @d

    /* renamed from: h */
    private final Flow<T> f2569h;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AdvanceSetting.NETWORK_TYPE, "Lcom/eth/model/Error;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.eth.binder.FlowBinder$1 */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends Lambda implements l<a, t1> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
            invoke2(aVar);
            return t1.a;
        }

        /* renamed from: invoke */
        public final void invoke2(@d a aVar) {
            Iterator<T> it = b.a.b().iterator();
            while (it.hasNext()) {
                ((l) it.next()).invoke(aVar.f());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowBinder(@d Flow<? extends T> flow, @d NLive<T> nLive) {
        super(nLive);
        this.f2569h = flow;
        e.g.d.a.o(this, null, AnonymousClass1.INSTANCE, 1, null);
    }

    @Override // e.g.d.a
    @d
    public e.g.d.a<T> e(@e LifecycleOwner lifecycleOwner, @d CoroutineStart coroutineStart) {
        if (lifecycleOwner == null) {
            super.x(this.f2569h, null, null, coroutineStart);
        } else {
            super.x(this.f2569h, lifecycleOwner, i.b.t1.a, coroutineStart);
        }
        return this;
    }

    @Override // e.g.d.a
    @d
    public e.g.d.a<T> f(@d n0 n0Var, @d CoroutineStart coroutineStart) {
        super.x(this.f2569h, null, n0Var, coroutineStart);
        return this;
    }
}

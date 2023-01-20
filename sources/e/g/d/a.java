package e.g.d;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.eth.binder.Observer;
import com.eth.model.NLive;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.umeng.analytics.pro.am;
import h.k2.u.l;
import h.k2.u.p;
import i.b.n0;
import i.b.t1;
import kotlin.Metadata;
import kotlin.Pair;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005JJ\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002<\u0010\u0017\u001a8\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0018J\b\u0010\u001d\u001a\u00020\u001eH&J\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#H&J\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010\"\u001a\u00020#H&J:\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2 \u0010'\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u001e0(j\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`)JV\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2<\u0010'\u001a8\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014\u0012\u0004\u0012\u00020\u001e0(j\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014`)J\r\u0010+\u001a\u00020\u001eH\u0010¢\u0006\u0002\b,J6\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001e0(j\b\u0012\u0004\u0012\u00020\b`)J6\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u001c\u0010/\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001e0(j\b\u0012\u0004\u0012\u00020\u0012`)J\u0015\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\bH\u0000¢\u0006\u0002\b2J\u0015\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u0012H\u0000¢\u0006\u0002\b5J#\u00106\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u00018\u00002\b\u0010\u001c\u001a\u0004\u0018\u00018\u0000H\u0000¢\u0006\u0004\b8\u00109R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00140\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/eth/binder/Binder;", ExifInterface.GPS_DIRECTION_TRUE, "", "live", "Lcom/eth/model/NLive;", "(Lcom/eth/model/NLive;)V", "errorObservers", "Lcom/eth/binder/Observer;", "Lcom/eth/model/Error;", "getLive$eth_release", "()Lcom/eth/model/NLive;", "processor", "Lcom/eth/binder/Processor;", "getProcessor$eth_release", "()Lcom/eth/binder/Processor;", "setProcessor$eth_release", "(Lcom/eth/binder/Processor;)V", "stateObserver", "Lcom/eth/model/NLive$State;", "valueCompareObservers", "Lkotlin/Pair;", "valueObservers", "addProcessor", ReportItem.LogTypeBlock, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "old", "new", "cancel", "", "launch", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", MessageKey.MSG_ACCEPT_TIME_START, "Lkotlinx/coroutines/CoroutineStart;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "observe", "observer", "Lkotlin/Function1;", "Lcom/eth/binder/ObserveAction;", "observeComparable", "onComplete", "onComplete$eth_release", "onError", "onState", "action", "setError", com.umeng.analytics.pro.d.O, "setError$eth_release", "setState", "state", "setState$eth_release", "setValue", am.aI, "setValue$eth_release", "(Ljava/lang/Object;Ljava/lang/Object;)V", "eth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class a<T> {
    @k.e.a.d
    private final NLive<T> a;
    @k.e.a.e
    private e<T> b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final Observer<NLive.State> f10019c = new Observer<>();
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final Observer<T> f10020d = new Observer<>();
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final Observer<Pair<T, T>> f10021e = new Observer<>();
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private final Observer<e.g.e.a> f10022f = new Observer<>();

    @Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J#\u0010\u0002\u001a\u0004\u0018\u00018\u00002\b\u0010\u0003\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"com/eth/binder/Binder$addProcessor$1$p$1", "Lcom/eth/binder/Processor;", "onProcess", "old", "new", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "eth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: e.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0331a implements e<T> {
        public final /* synthetic */ p<T, T, T> a;

        /* JADX WARN: Multi-variable type inference failed */
        public C0331a(p<? super T, ? super T, ? extends T> pVar) {
            this.a = pVar;
        }

        @Override // e.g.d.e
        @k.e.a.e
        public T a(@k.e.a.e T t, @k.e.a.e T t2) {
            return this.a.invoke(t, t2);
        }
    }

    public a(@k.e.a.d NLive<T> nLive) {
        this.a = nLive;
    }

    public static /* synthetic */ a g(a aVar, LifecycleOwner lifecycleOwner, CoroutineStart coroutineStart, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                coroutineStart = CoroutineStart.DEFAULT;
            }
            return aVar.e(lifecycleOwner, coroutineStart);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launch");
    }

    public static /* synthetic */ a h(a aVar, n0 n0Var, CoroutineStart coroutineStart, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                n0Var = t1.a;
            }
            if ((i2 & 2) != 0) {
                coroutineStart = CoroutineStart.DEFAULT;
            }
            return aVar.f(n0Var, coroutineStart);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launch");
    }

    public static /* synthetic */ a j(a aVar, LifecycleOwner lifecycleOwner, l lVar, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                lifecycleOwner = null;
            }
            return aVar.i(lifecycleOwner, lVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observe");
    }

    public static /* synthetic */ a l(a aVar, LifecycleOwner lifecycleOwner, l lVar, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                lifecycleOwner = null;
            }
            return aVar.k(lifecycleOwner, lVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observeComparable");
    }

    public static /* synthetic */ a o(a aVar, LifecycleOwner lifecycleOwner, l lVar, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                lifecycleOwner = null;
            }
            return aVar.n(lifecycleOwner, lVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onError");
    }

    public static /* synthetic */ a q(a aVar, LifecycleOwner lifecycleOwner, l lVar, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                lifecycleOwner = null;
            }
            return aVar.p(lifecycleOwner, lVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onState");
    }

    @k.e.a.d
    public final a<T> a(@k.e.a.d p<? super T, ? super T, ? extends T> pVar) {
        s(new C0331a(pVar));
        return this;
    }

    public abstract void b();

    @k.e.a.d
    public final NLive<T> c() {
        return this.a;
    }

    @k.e.a.e
    public final e<T> d() {
        return this.b;
    }

    @k.e.a.d
    public abstract a<T> e(@k.e.a.e LifecycleOwner lifecycleOwner, @k.e.a.d CoroutineStart coroutineStart);

    @k.e.a.d
    public abstract a<T> f(@k.e.a.d n0 n0Var, @k.e.a.d CoroutineStart coroutineStart);

    @k.e.a.d
    public final a<T> i(@k.e.a.e LifecycleOwner lifecycleOwner, @k.e.a.d l<? super T, h.t1> lVar) {
        this.f10020d.b(lifecycleOwner, lVar);
        return this;
    }

    @k.e.a.d
    public final a<T> k(@k.e.a.e LifecycleOwner lifecycleOwner, @k.e.a.d l<? super Pair<? extends T, ? extends T>, h.t1> lVar) {
        this.f10021e.b(lifecycleOwner, lVar);
        return this;
    }

    public void m() {
        this.b = null;
    }

    @k.e.a.d
    public final a<T> n(@k.e.a.e LifecycleOwner lifecycleOwner, @k.e.a.d l<? super e.g.e.a, h.t1> lVar) {
        this.f10022f.b(lifecycleOwner, lVar);
        return this;
    }

    @k.e.a.d
    public final a<T> p(@k.e.a.e LifecycleOwner lifecycleOwner, @k.e.a.d l<? super NLive.State, h.t1> lVar) {
        this.f10019c.b(lifecycleOwner, lVar);
        return this;
    }

    public final void r(@k.e.a.d e.g.e.a aVar) {
        this.a.w(aVar);
        this.f10022f.d(aVar);
    }

    public final void s(@k.e.a.e e<T> eVar) {
        this.b = eVar;
    }

    public final void t(@k.e.a.d NLive.State state) {
        this.a.x(state);
        this.f10019c.d(state);
    }

    public final void u(@k.e.a.e T t, @k.e.a.e T t2) {
        this.a.setValue(t);
        this.f10020d.d(t);
        this.f10021e.d(new Pair<>(t, t2));
    }
}

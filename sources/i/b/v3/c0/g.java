package i.b.v3.c0;

import com.umeng.analytics.pro.am;
import h.k2.v.u;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R \u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Li/b/v3/c0/g;", "Lkotlin/coroutines/CoroutineContext$a;", "", "b", "Ljava/lang/Throwable;", com.huawei.hms.push.e.a, "Lkotlin/coroutines/CoroutineContext$b;", am.av, "Lkotlin/coroutines/CoroutineContext$b;", "getKey", "()Lkotlin/coroutines/CoroutineContext$b;", "key", "<init>", "(Ljava/lang/Throwable;)V", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class g implements CoroutineContext.a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f15865c = new a(null);
    @k.e.a.d
    private final CoroutineContext.b<?> a = f15865c;
    @h.k2.d
    @k.e.a.d
    public final Throwable b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"i/b/v3/c0/g$a", "Lkotlin/coroutines/CoroutineContext$b;", "Li/b/v3/c0/g;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements CoroutineContext.b<g> {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public g(@k.e.a.d Throwable th) {
        this.b = th;
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @k.e.a.d h.k2.u.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) CoroutineContext.a.C0492a.a(this, r, pVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k.e.a.e
    public <E extends CoroutineContext.a> E get(@k.e.a.d CoroutineContext.b<E> bVar) {
        return (E) CoroutineContext.a.C0492a.b(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    @k.e.a.d
    public CoroutineContext.b<?> getKey() {
        return this.a;
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k.e.a.d
    public CoroutineContext minusKey(@k.e.a.d CoroutineContext.b<?> bVar) {
        return CoroutineContext.a.C0492a.c(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @k.e.a.d
    public CoroutineContext plus(@k.e.a.d CoroutineContext coroutineContext) {
        return CoroutineContext.a.C0492a.d(this, coroutineContext);
    }
}

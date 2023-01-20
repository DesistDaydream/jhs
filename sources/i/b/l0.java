package i.b;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.am;
import i.b.f3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001cB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0010¨\u0006\""}, d2 = {"Li/b/l0;", "Li/b/f3;", "", "Lh/e2/a;", "toString", "()Ljava/lang/String;", "Lkotlin/coroutines/CoroutineContext;", "context", "E0", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "oldState", "Lh/t1;", "D0", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/String;)V", "", "z0", "()J", "id", "A0", "(J)Li/b/l0;", "", TTDownloadField.TT_HASHCODE, "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", am.av, "J", "C0", "<init>", "(J)V", "b", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class l0 extends h.e2.a implements f3<String> {
    public static final a b = new a(null);
    private final long a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"i/b/l0$a", "Lkotlin/coroutines/CoroutineContext$b;", "Li/b/l0;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements CoroutineContext.b<l0> {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public l0(long j2) {
        super(b);
        this.a = j2;
    }

    public static /* synthetic */ l0 B0(l0 l0Var, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = l0Var.a;
        }
        return l0Var.A0(j2);
    }

    @k.e.a.d
    public final l0 A0(long j2) {
        return new l0(j2);
    }

    public final long C0() {
        return this.a;
    }

    @Override // i.b.f3
    /* renamed from: D0 */
    public void J(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d String str) {
        Thread.currentThread().setName(str);
    }

    @Override // i.b.f3
    @k.e.a.d
    /* renamed from: E0 */
    public String u0(@k.e.a.d CoroutineContext coroutineContext) {
        m0 m0Var = (m0) coroutineContext.get(m0.b);
        String str = (m0Var == null || (str = m0Var.C0()) == null) ? "coroutine" : "coroutine";
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int F3 = StringsKt__StringsKt.F3(name, " @", 0, false, 6, null);
        if (F3 < 0) {
            F3 = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + F3 + 10);
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        sb.append(name.substring(0, F3));
        sb.append(" @");
        sb.append(str);
        sb.append('#');
        sb.append(this.a);
        h.t1 t1Var = h.t1.a;
        currentThread.setName(sb.toString());
        return name;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this != obj) {
            return (obj instanceof l0) && this.a == ((l0) obj).a;
        }
        return true;
    }

    @Override // h.e2.a, kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @k.e.a.d h.k2.u.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) f3.a.a(this, r, pVar);
    }

    @Override // h.e2.a, kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k.e.a.e
    public <E extends CoroutineContext.a> E get(@k.e.a.d CoroutineContext.b<E> bVar) {
        return (E) f3.a.b(this, bVar);
    }

    public int hashCode() {
        long j2 = this.a;
        return (int) (j2 ^ (j2 >>> 32));
    }

    @Override // h.e2.a, kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k.e.a.d
    public CoroutineContext minusKey(@k.e.a.d CoroutineContext.b<?> bVar) {
        return f3.a.c(this, bVar);
    }

    @Override // h.e2.a, kotlin.coroutines.CoroutineContext
    @k.e.a.d
    public CoroutineContext plus(@k.e.a.d CoroutineContext coroutineContext) {
        return f3.a.d(this, coroutineContext);
    }

    @k.e.a.d
    public String toString() {
        return "CoroutineId(" + this.a + ')';
    }

    public final long z0() {
        return this.a;
    }
}

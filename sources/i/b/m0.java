package i.b;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Li/b/m0;", "Lh/e2/a;", "", "toString", "()Ljava/lang/String;", "z0", "name", "A0", "(Ljava/lang/String;)Li/b/m0;", "", TTDownloadField.TT_HASHCODE, "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", am.av, "Ljava/lang/String;", "C0", "<init>", "(Ljava/lang/String;)V", "b", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class m0 extends h.e2.a {
    public static final a b = new a(null);
    @k.e.a.d
    private final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"i/b/m0$a", "Lkotlin/coroutines/CoroutineContext$b;", "Li/b/m0;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements CoroutineContext.b<m0> {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public m0(@k.e.a.d String str) {
        super(b);
        this.a = str;
    }

    public static /* synthetic */ m0 B0(m0 m0Var, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = m0Var.a;
        }
        return m0Var.A0(str);
    }

    @k.e.a.d
    public final m0 A0(@k.e.a.d String str) {
        return new m0(str);
    }

    @k.e.a.d
    public final String C0() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this != obj) {
            return (obj instanceof m0) && h.k2.v.f0.g(this.a, ((m0) obj).a);
        }
        return true;
    }

    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @k.e.a.d
    public String toString() {
        return "CoroutineName(" + this.a + ')';
    }

    @k.e.a.d
    public final String z0() {
        return this.a;
    }
}

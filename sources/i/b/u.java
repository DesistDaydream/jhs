package i.b;

import kotlin.Metadata;
import kotlinx.coroutines.JobSupport;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Li/b/u;", "Li/b/c2;", "Lkotlinx/coroutines/JobSupport;", "Li/b/t;", "", "cause", "Lh/t1;", "j0", "(Ljava/lang/Throwable;)V", "", "g", "(Ljava/lang/Throwable;)Z", "", "toString", "()Ljava/lang/String;", "Li/b/v;", com.huawei.hms.push.e.a, "Li/b/v;", "childJob", "parent", "<init>", "(Lkotlinx/coroutines/JobSupport;Li/b/v;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class u extends c2<JobSupport> implements t {
    @h.k2.d
    @k.e.a.d

    /* renamed from: e */
    public final v f15846e;

    public u(@k.e.a.d JobSupport jobSupport, @k.e.a.d v vVar) {
        super(jobSupport);
        this.f15846e = vVar;
    }

    @Override // i.b.t
    public boolean g(@k.e.a.d Throwable th) {
        return ((JobSupport) this.f15739d).f0(th);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ h.t1 invoke(Throwable th) {
        j0(th);
        return h.t1.a;
    }

    @Override // i.b.d0
    public void j0(@k.e.a.e Throwable th) {
        this.f15846e.s((r2) this.f15739d);
    }

    @Override // i.b.w3.s
    @k.e.a.d
    public String toString() {
        return "ChildHandle[" + this.f15846e + ']';
    }
}

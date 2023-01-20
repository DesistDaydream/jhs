package i.b;

import com.qiniu.android.collect.ReportItem;
import kotlin.Metadata;
import kotlinx.coroutines.JobSupport;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B>\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u001c\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR/\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f8\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Li/b/a3;", "R", "Li/b/h2;", "Lkotlinx/coroutines/JobSupport;", "", "cause", "Lh/t1;", "j0", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/Function1;", "Lh/e2/c;", "", "f", "Lh/k2/u/l;", ReportItem.LogTypeBlock, "Li/b/z3/f;", com.huawei.hms.push.e.a, "Li/b/z3/f;", "select", "job", "<init>", "(Lkotlinx/coroutines/JobSupport;Li/b/z3/f;Lh/k2/u/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class a3<R> extends h2<JobSupport> {

    /* renamed from: e  reason: collision with root package name */
    private final i.b.z3.f<R> f15718e;

    /* renamed from: f  reason: collision with root package name */
    private final h.k2.u.l<h.e2.c<? super R>, Object> f15719f;

    /* JADX WARN: Multi-variable type inference failed */
    public a3(@k.e.a.d JobSupport jobSupport, @k.e.a.d i.b.z3.f<? super R> fVar, @k.e.a.d h.k2.u.l<? super h.e2.c<? super R>, ? extends Object> lVar) {
        super(jobSupport);
        this.f15718e = fVar;
        this.f15719f = lVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ h.t1 invoke(Throwable th) {
        j0(th);
        return h.t1.a;
    }

    @Override // i.b.d0
    public void j0(@k.e.a.e Throwable th) {
        if (this.f15718e.s()) {
            i.b.x3.a.c(this.f15719f, this.f15718e.v());
        }
    }

    @Override // i.b.w3.s
    @k.e.a.d
    public String toString() {
        return "SelectJoinOnCompletion[" + this.f15718e + ']';
    }
}

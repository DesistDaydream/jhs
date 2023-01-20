package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import kotlin.Metadata;
import kotlinx.coroutines.JobSupport;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003BD\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\r\u0012\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR5\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00118\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Li/b/z2;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Li/b/h2;", "Lkotlinx/coroutines/JobSupport;", "", "cause", "Lh/t1;", "j0", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Li/b/z3/f;", com.huawei.hms.push.e.a, "Li/b/z3/f;", "select", "Lkotlin/Function2;", "Lh/e2/c;", "", "f", "Lh/k2/u/p;", ReportItem.LogTypeBlock, "job", "<init>", "(Lkotlinx/coroutines/JobSupport;Li/b/z3/f;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class z2<T, R> extends h2<JobSupport> {

    /* renamed from: e  reason: collision with root package name */
    private final i.b.z3.f<R> f15947e;

    /* renamed from: f  reason: collision with root package name */
    private final h.k2.u.p<T, h.e2.c<? super R>, Object> f15948f;

    /* JADX WARN: Multi-variable type inference failed */
    public z2(@k.e.a.d JobSupport jobSupport, @k.e.a.d i.b.z3.f<? super R> fVar, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super R>, ? extends Object> pVar) {
        super(jobSupport);
        this.f15947e = fVar;
        this.f15948f = pVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ h.t1 invoke(Throwable th) {
        j0(th);
        return h.t1.a;
    }

    @Override // i.b.d0
    public void j0(@k.e.a.e Throwable th) {
        if (this.f15947e.s()) {
            ((JobSupport) this.f15739d).Z0(this.f15947e, this.f15948f);
        }
    }

    @Override // i.b.w3.s
    @k.e.a.d
    public String toString() {
        return "SelectAwaitOnCompletion[" + this.f15947e + ']';
    }
}

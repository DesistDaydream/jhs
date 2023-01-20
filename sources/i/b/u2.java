package i.b;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.JobSupport;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Li/b/u2;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/h2;", "Lkotlinx/coroutines/JobSupport;", "", "cause", "Lh/t1;", "j0", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Li/b/o;", com.huawei.hms.push.e.a, "Li/b/o;", "continuation", "job", "<init>", "(Lkotlinx/coroutines/JobSupport;Li/b/o;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class u2<T> extends h2<JobSupport> {

    /* renamed from: e  reason: collision with root package name */
    private final o<T> f15847e;

    /* JADX WARN: Multi-variable type inference failed */
    public u2(@k.e.a.d JobSupport jobSupport, @k.e.a.d o<? super T> oVar) {
        super(jobSupport);
        this.f15847e = oVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ h.t1 invoke(Throwable th) {
        j0(th);
        return h.t1.a;
    }

    @Override // i.b.d0
    public void j0(@k.e.a.e Throwable th) {
        Object z0 = ((JobSupport) this.f15739d).z0();
        if (q0.b() && !(!(z0 instanceof v1))) {
            throw new AssertionError();
        }
        if (z0 instanceof b0) {
            o<T> oVar = this.f15847e;
            Throwable th2 = ((b0) z0).a;
            Result.a aVar = Result.Companion;
            oVar.resumeWith(Result.m106constructorimpl(h.r0.a(th2)));
            return;
        }
        o<T> oVar2 = this.f15847e;
        Object o = i2.o(z0);
        Result.a aVar2 = Result.Companion;
        oVar2.resumeWith(Result.m106constructorimpl(o));
    }

    @Override // i.b.w3.s
    @k.e.a.d
    public String toString() {
        return "ResumeAwaitOnCompletion[" + this.f15847e + ']';
    }
}

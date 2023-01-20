package i.b.y3;

import com.qiniu.android.collect.ReportItem;
import i.b.r0;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B#\u0012\n\u0010\f\u001a\u00060\bj\u0002`\t\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\f\u001a\u00060\bj\u0002`\t8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Li/b/y3/k;", "Li/b/y3/i;", "Lh/t1;", "run", "()V", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "c", "Ljava/lang/Runnable;", ReportItem.LogTypeBlock, "", "submissionTime", "Li/b/y3/j;", "taskContext", "<init>", "(Ljava/lang/Runnable;JLi/b/y3/j;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class k extends i {
    @h.k2.d
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f15927c;

    public k(@k.e.a.d Runnable runnable, long j2, @k.e.a.d j jVar) {
        super(j2, jVar);
        this.f15927c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f15927c.run();
        } finally {
            this.b.c0();
        }
    }

    @k.e.a.d
    public String toString() {
        return "Task[" + r0.a(this.f15927c) + '@' + r0.b(this.f15927c) + ", " + this.a + ", " + this.b + ']';
    }
}

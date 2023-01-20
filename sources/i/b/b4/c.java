package i.b.b4;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.k2.d;
import h.k2.v.u;
import i.b.w3.q0;
import i.b.w3.r0;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B'\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR(\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0010\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00168\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018R\"\u0010!\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b\u0017\u0010 ¨\u0006$"}, d2 = {"Li/b/b4/c;", "", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Li/b/w3/r0;", "Lh/t1;", "run", "()V", "other", "", e.a, "(Li/b/b4/c;)I", "", "toString", "()Ljava/lang/String;", "Li/b/w3/q0;", am.av, "Li/b/w3/q0;", "b", "()Li/b/w3/q0;", "(Li/b/w3/q0;)V", "heap", "", f.f10128d, "J", "count", "c", "Ljava/lang/Runnable;", "time", ExpandableTextView.P, "f", "()I", "(I)V", "index", "<init>", "(Ljava/lang/Runnable;JJ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class c implements Comparable<c>, Runnable, r0 {
    @k.e.a.e
    private q0<?> a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f15729c;

    /* renamed from: d  reason: collision with root package name */
    private final long f15730d;
    @d

    /* renamed from: e  reason: collision with root package name */
    public final long f15731e;

    public c(@k.e.a.d Runnable runnable, long j2, long j3) {
        this.f15729c = runnable;
        this.f15730d = j2;
        this.f15731e = j3;
    }

    @Override // i.b.w3.r0
    public void a(@k.e.a.e q0<?> q0Var) {
        this.a = q0Var;
    }

    @Override // i.b.w3.r0
    @k.e.a.e
    public q0<?> b() {
        return this.a;
    }

    @Override // i.b.w3.r0
    public void d(int i2) {
        this.b = i2;
    }

    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(@k.e.a.d c cVar) {
        long j2 = this.f15731e;
        long j3 = cVar.f15731e;
        if (j2 == j3) {
            j2 = this.f15730d;
            j3 = cVar.f15730d;
        }
        return (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
    }

    @Override // i.b.w3.r0
    public int f() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15729c.run();
    }

    @k.e.a.d
    public String toString() {
        return "TimedRunnable(time=" + this.f15731e + ", run=" + this.f15729c + ')';
    }

    public /* synthetic */ c(Runnable runnable, long j2, long j3, int i2, u uVar) {
        this(runnable, (i2 & 2) != 0 ? 0L : j2, (i2 & 4) != 0 ? 0L : j3);
    }
}

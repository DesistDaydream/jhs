package j;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.umeng.analytics.pro.am;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\n\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0012\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR$\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t0\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017¨\u0006\u001b"}, d2 = {"Lj/j0;", "", "Lj/i0;", com.huawei.hms.push.e.a, "()Lj/i0;", "segment", "Lh/t1;", e.j.a.b.c.f.f10128d, "(Lj/i0;)V", "Ljava/util/concurrent/atomic/AtomicReference;", am.av, "()Ljava/util/concurrent/atomic/AtomicReference;", "", ExpandableTextView.P, "c", "()I", "MAX_SIZE", "b", "byteCount", "", "[Ljava/util/concurrent/atomic/AtomicReference;", "hashBuckets", "HASH_BUCKET_COUNT", "Lj/i0;", "LOCK", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class j0 {

    /* renamed from: c  reason: collision with root package name */
    private static final int f15987c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReference<i0>[] f15988d;

    /* renamed from: e  reason: collision with root package name */
    public static final j0 f15989e = new j0();
    private static final int a = 65536;
    private static final i0 b = new i0(new byte[0], 0, 0, false, false);

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f15987c = highestOneBit;
        AtomicReference<i0>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i2 = 0; i2 < highestOneBit; i2++) {
            atomicReferenceArr[i2] = new AtomicReference<>();
        }
        f15988d = atomicReferenceArr;
    }

    private j0() {
    }

    private final AtomicReference<i0> a() {
        return f15988d[(int) (Thread.currentThread().getId() & (f15987c - 1))];
    }

    @h.k2.k
    public static final void d(@k.e.a.d i0 i0Var) {
        AtomicReference<i0> a2;
        i0 i0Var2;
        if (i0Var.f15985f == null && i0Var.f15986g == null) {
            if (i0Var.f15983d || (i0Var2 = (a2 = f15989e.a()).get()) == b) {
                return;
            }
            int i2 = i0Var2 != null ? i0Var2.f15982c : 0;
            if (i2 >= a) {
                return;
            }
            i0Var.f15985f = i0Var2;
            i0Var.b = 0;
            i0Var.f15982c = i2 + 8192;
            if (a2.compareAndSet(i0Var2, i0Var)) {
                return;
            }
            i0Var.f15985f = null;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @h.k2.k
    @k.e.a.d
    public static final i0 e() {
        AtomicReference<i0> a2 = f15989e.a();
        i0 i0Var = b;
        i0 andSet = a2.getAndSet(i0Var);
        if (andSet == i0Var) {
            return new i0();
        }
        if (andSet == null) {
            a2.set(null);
            return new i0();
        }
        a2.set(andSet.f15985f);
        andSet.f15985f = null;
        andSet.f15982c = 0;
        return andSet;
    }

    public final int b() {
        i0 i0Var = a().get();
        if (i0Var != null) {
            return i0Var.f15982c;
        }
        return 0;
    }

    public final int c() {
        return a;
    }
}

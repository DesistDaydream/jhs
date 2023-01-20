package j;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b$\u0010%J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lj/e0;", "Lj/m0;", "Lj/m;", "sink", "", "byteCount", "read", "(Lj/m;J)J", "Lj/o0;", "timeout", "()Lj/o0;", "Lh/t1;", "close", "()V", "Lj/i0;", "b", "Lj/i0;", "expectedSegment", com.huawei.hms.push.e.a, "J", "pos", "", "c", ExpandableTextView.P, "expectedPos", am.av, "Lj/m;", "buffer", "Lj/o;", "f", "Lj/o;", "upstream", "", e.j.a.b.c.f.f10128d, "Z", "closed", "<init>", "(Lj/o;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class e0 implements m0 {
    private final m a;
    private i0 b;

    /* renamed from: c */
    private int f15961c;

    /* renamed from: d */
    private boolean f15962d;

    /* renamed from: e */
    private long f15963e;

    /* renamed from: f */
    private final o f15964f;

    public e0(@k.e.a.d o oVar) {
        this.f15964f = oVar;
        m buffer = oVar.getBuffer();
        this.a = buffer;
        i0 i0Var = buffer.a;
        this.b = i0Var;
        this.f15961c = i0Var != null ? i0Var.b : -1;
    }

    @Override // j.m0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f15962d = true;
    }

    @Override // j.m0
    public long read(@k.e.a.d m mVar, long j2) {
        i0 i0Var;
        i0 i0Var2;
        boolean z = false;
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (!this.f15962d) {
                i0 i0Var3 = this.b;
                if (i0Var3 == null || (i0Var3 == (i0Var2 = this.a.a) && this.f15961c == i0Var2.b)) {
                    z = true;
                }
                if (z) {
                    if (i2 == 0) {
                        return 0L;
                    }
                    if (this.f15964f.G(this.f15963e + 1)) {
                        if (this.b == null && (i0Var = this.a.a) != null) {
                            this.b = i0Var;
                            this.f15961c = i0Var.b;
                        }
                        long min = Math.min(j2, this.a.O0() - this.f15963e);
                        this.a.H(mVar, this.f15963e, min);
                        this.f15963e += min;
                        return min;
                    }
                    return -1L;
                }
                throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    @Override // j.m0
    @k.e.a.d
    public o0 timeout() {
        return this.f15964f.timeout();
    }
}

package j;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b!\u0010\"B\u0019\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b!\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001f¨\u0006$"}, d2 = {"Lj/x;", "Lj/m0;", "Lh/t1;", "k", "()V", "Lj/m;", "sink", "", "byteCount", "read", "(Lj/m;J)J", am.av, "", "j", "()Z", "Lj/o0;", "timeout", "()Lj/o0;", "close", "b", "Z", "closed", "Ljava/util/zip/Inflater;", e.j.a.b.c.f.f10128d, "Ljava/util/zip/Inflater;", "inflater", "Lj/o;", "c", "Lj/o;", MessageKey.MSG_SOURCE, "", ExpandableTextView.P, "bufferBytesHeldByInflater", "<init>", "(Lj/o;Ljava/util/zip/Inflater;)V", "(Lj/m0;Ljava/util/zip/Inflater;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class x implements m0 {
    private int a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final o f16014c;

    /* renamed from: d  reason: collision with root package name */
    private final Inflater f16015d;

    public x(@k.e.a.d o oVar, @k.e.a.d Inflater inflater) {
        this.f16014c = oVar;
        this.f16015d = inflater;
    }

    private final void k() {
        int i2 = this.a;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.f16015d.getRemaining();
        this.a -= remaining;
        this.f16014c.skip(remaining);
    }

    public final long a(@k.e.a.d m mVar, long j2) throws IOException {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (!this.b) {
                if (i2 == 0) {
                    return 0L;
                }
                try {
                    i0 R0 = mVar.R0(1);
                    int min = (int) Math.min(j2, 8192 - R0.f15982c);
                    j();
                    int inflate = this.f16015d.inflate(R0.a, R0.f15982c, min);
                    k();
                    if (inflate > 0) {
                        R0.f15982c += inflate;
                        long j3 = inflate;
                        mVar.K0(mVar.O0() + j3);
                        return j3;
                    }
                    if (R0.b == R0.f15982c) {
                        mVar.a = R0.b();
                        j0.d(R0);
                    }
                    return 0L;
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    @Override // j.m0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.b) {
            return;
        }
        this.f16015d.end();
        this.b = true;
        this.f16014c.close();
    }

    public final boolean j() throws IOException {
        if (this.f16015d.needsInput()) {
            if (this.f16014c.b0()) {
                return true;
            }
            i0 i0Var = this.f16014c.getBuffer().a;
            int i2 = i0Var.f15982c;
            int i3 = i0Var.b;
            int i4 = i2 - i3;
            this.a = i4;
            this.f16015d.setInput(i0Var.a, i3, i4);
            return false;
        }
        return false;
    }

    @Override // j.m0
    public long read(@k.e.a.d m mVar, long j2) throws IOException {
        do {
            long a = a(mVar, j2);
            if (a > 0) {
                return a;
            }
            if (this.f16015d.finished() || this.f16015d.needsDictionary()) {
                return -1L;
            }
        } while (!this.f16014c.b0());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // j.m0
    @k.e.a.d
    public o0 timeout() {
        return this.f16014c.timeout();
    }

    public x(@k.e.a.d m0 m0Var, @k.e.a.d Inflater inflater) {
        this(z.d(m0Var), inflater);
    }
}

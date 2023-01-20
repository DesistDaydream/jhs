package h.o2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.android.tpush.common.MessageKey;
import h.a2.m0;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/LongProgression;", "", "", MessageKey.MSG_ACCEPT_TIME_START, "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public class l implements Iterable<Long>, h.k2.v.x0.a {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public static final a f14971d = new a(null);
    private final long a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f14972c;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lkotlin/ranges/LongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        @k.e.a.d
        public final l a(long j2, long j3, long j4) {
            return new l(j2, j3, j4);
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public l(long j2, long j3, long j4) {
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j4 != Long.MIN_VALUE) {
            this.a = j2;
            this.b = h.g2.m.d(j2, j3, j4);
            this.f14972c = j4;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    }

    public final long d() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (obj instanceof l) {
            if (!isEmpty() || !((l) obj).isEmpty()) {
                l lVar = (l) obj;
                if (this.a != lVar.a || this.b != lVar.b || this.f14972c != lVar.f14972c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long f() {
        return this.b;
    }

    public final long g() {
        return this.f14972c;
    }

    @Override // java.lang.Iterable
    @k.e.a.d
    /* renamed from: h */
    public m0 iterator() {
        return new m(this.a, this.b, this.f14972c);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j2 = 31;
        long j3 = this.a;
        long j4 = this.b;
        long j5 = j2 * (((j3 ^ (j3 >>> 32)) * j2) + (j4 ^ (j4 >>> 32)));
        long j6 = this.f14972c;
        return (int) (j5 + (j6 ^ (j6 >>> 32)));
    }

    public boolean isEmpty() {
        int i2 = (this.f14972c > 0L ? 1 : (this.f14972c == 0L ? 0 : -1));
        long j2 = this.a;
        long j3 = this.b;
        if (i2 > 0) {
            if (j2 > j3) {
                return true;
            }
        } else if (j2 < j3) {
            return true;
        }
        return false;
    }

    @k.e.a.d
    public String toString() {
        StringBuilder sb;
        long j2;
        if (this.f14972c > 0) {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            j2 = this.f14972c;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            j2 = -this.f14972c;
        }
        sb.append(j2);
        return sb.toString();
    }
}

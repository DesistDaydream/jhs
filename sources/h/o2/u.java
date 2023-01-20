package h.o2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.android.tpush.common.MessageKey;
import h.j1;
import h.s0;
import h.v1;
import h.x1;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\"\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u0012\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0086\u0002ø\u0001\u0000J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0019\u0010\b\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001b"}, d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", MessageKey.MSG_ACCEPT_TIME_START, "endInclusive", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-s-VKNKU", "()J", "J", "last", "getLast-s-VKNKU", "getStep", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "isEmpty", "iterator", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.5")
@x1(markerClass = {h.p.class})
/* loaded from: classes3.dex */
public class u implements Iterable<j1>, h.k2.v.x0.a {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public static final a f14983d = new a(null);
    private final long a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f14984c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lkotlin/ranges/ULongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/ULongProgression;", "rangeStart", "Lkotlin/ULong;", "rangeEnd", "step", "", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        @k.e.a.d
        public final u a(long j2, long j3, long j4) {
            return new u(j2, j3, j4, null);
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public /* synthetic */ u(long j2, long j3, long j4, h.k2.v.u uVar) {
        this(j2, j3, j4);
    }

    public final long d() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (obj instanceof u) {
            if (!isEmpty() || !((u) obj).isEmpty()) {
                u uVar = (u) obj;
                if (this.a != uVar.a || this.b != uVar.b || this.f14984c != uVar.f14984c) {
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
        return this.f14984c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j2 = this.a;
        long j3 = this.b;
        long j4 = this.f14984c;
        return ((int) (j4 ^ (j4 >>> 32))) + (((((int) j1.i(j2 ^ j1.i(j2 >>> 32))) * 31) + ((int) j1.i(j3 ^ j1.i(j3 >>> 32)))) * 31);
    }

    public boolean isEmpty() {
        int i2 = (this.f14984c > 0L ? 1 : (this.f14984c == 0L ? 0 : -1));
        int g2 = v1.g(this.a, this.b);
        if (i2 > 0) {
            if (g2 > 0) {
                return true;
            }
        } else if (g2 < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @k.e.a.d
    public final Iterator<j1> iterator() {
        return new v(this.a, this.b, this.f14984c, null);
    }

    @k.e.a.d
    public String toString() {
        StringBuilder sb;
        long j2;
        if (this.f14984c > 0) {
            sb = new StringBuilder();
            sb.append(j1.h0(this.a));
            sb.append("..");
            sb.append(j1.h0(this.b));
            sb.append(" step ");
            j2 = this.f14984c;
        } else {
            sb = new StringBuilder();
            sb.append(j1.h0(this.a));
            sb.append(" downTo ");
            sb.append(j1.h0(this.b));
            sb.append(" step ");
            j2 = -this.f14984c;
        }
        sb.append(j2);
        return sb.toString();
    }

    private u(long j2, long j3, long j4) {
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j4 != Long.MIN_VALUE) {
            this.a = j2;
            this.b = h.g2.p.c(j2, j3, j4);
            this.f14984c = j4;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    }
}

package h.o2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.android.tpush.common.MessageKey;
import h.a2.l0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lkotlin/ranges/IntProgression;", "", "", MessageKey.MSG_ACCEPT_TIME_START, "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public class i implements Iterable<Integer>, h.k2.v.x0.a {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public static final a f14965d = new a(null);
    private final int a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14966c;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        @k.e.a.d
        public final i a(int i2, int i3, int i4) {
            return new i(i2, i3, i4);
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public i(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 != Integer.MIN_VALUE) {
            this.a = i2;
            this.b = h.g2.m.c(i2, i3, i4);
            this.f14966c = i4;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public final int d() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (obj instanceof i) {
            if (!isEmpty() || !((i) obj).isEmpty()) {
                i iVar = (i) obj;
                if (this.a != iVar.a || this.b != iVar.b || this.f14966c != iVar.f14966c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        return this.b;
    }

    public final int g() {
        return this.f14966c;
    }

    @Override // java.lang.Iterable
    @k.e.a.d
    /* renamed from: h */
    public l0 iterator() {
        return new j(this.a, this.b, this.f14966c);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.b) * 31) + this.f14966c;
    }

    public boolean isEmpty() {
        if (this.f14966c > 0) {
            if (this.a > this.b) {
                return true;
            }
        } else if (this.a < this.b) {
            return true;
        }
        return false;
    }

    @k.e.a.d
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f14966c > 0) {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            i2 = this.f14966c;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            i2 = -this.f14966c;
        }
        sb.append(i2);
        return sb.toString();
    }
}

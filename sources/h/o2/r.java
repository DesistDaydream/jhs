package h.o2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpush.common.MessageKey;
import h.f1;
import h.s0;
import h.v1;
import h.x1;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\"\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0086\u0002ø\u0001\u0000J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0019\u0010\b\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001a"}, d2 = {"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", MessageKey.MSG_ACCEPT_TIME_START, "endInclusive", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-pVg5ArA", "()I", ExpandableTextView.P, "last", "getLast-pVg5ArA", "getStep", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "isEmpty", "iterator", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.5")
@x1(markerClass = {h.p.class})
/* loaded from: classes3.dex */
public class r implements Iterable<f1>, h.k2.v.x0.a {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public static final a f14977d = new a(null);
    private final int a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14978c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lkotlin/ranges/UIntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/UIntProgression;", "rangeStart", "Lkotlin/UInt;", "rangeEnd", "step", "", "fromClosedRange-Nkh28Cs", "(III)Lkotlin/ranges/UIntProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        @k.e.a.d
        public final r a(int i2, int i3, int i4) {
            return new r(i2, i3, i4, null);
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public /* synthetic */ r(int i2, int i3, int i4, h.k2.v.u uVar) {
        this(i2, i3, i4);
    }

    public final int d() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (obj instanceof r) {
            if (!isEmpty() || !((r) obj).isEmpty()) {
                r rVar = (r) obj;
                if (this.a != rVar.a || this.b != rVar.b || this.f14978c != rVar.f14978c) {
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
        return this.f14978c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.b) * 31) + this.f14978c;
    }

    public boolean isEmpty() {
        if (this.f14978c > 0) {
            if (v1.c(this.a, this.b) > 0) {
                return true;
            }
        } else if (v1.c(this.a, this.b) < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @k.e.a.d
    public final Iterator<f1> iterator() {
        return new s(this.a, this.b, this.f14978c, null);
    }

    @k.e.a.d
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f14978c > 0) {
            sb = new StringBuilder();
            sb.append(f1.h0(this.a));
            sb.append("..");
            sb.append(f1.h0(this.b));
            sb.append(" step ");
            i2 = this.f14978c;
        } else {
            sb = new StringBuilder();
            sb.append(f1.h0(this.a));
            sb.append(" downTo ");
            sb.append(f1.h0(this.b));
            sb.append(" step ");
            i2 = -this.f14978c;
        }
        sb.append(i2);
        return sb.toString();
    }

    private r(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 != Integer.MIN_VALUE) {
            this.a = i2;
            this.b = h.g2.p.d(i2, i3, i4);
            this.f14978c = i4;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }
}

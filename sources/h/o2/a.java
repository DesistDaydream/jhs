package h.o2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.v.f0;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lkotlin/ranges/CharProgression;", "", "", MessageKey.MSG_ACCEPT_TIME_START, "endInclusive", "step", "", "(CCI)V", "first", "getFirst", "()C", "last", "getLast", "getStep", "()I", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "isEmpty", "iterator", "Lkotlin/collections/CharIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public class a implements Iterable<Character>, h.k2.v.x0.a {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public static final C0426a f14959d = new C0426a(null);
    private final char a;
    private final char b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14960c;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lkotlin/ranges/CharProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/CharProgression;", "rangeStart", "", "rangeEnd", "step", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* renamed from: h.o2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0426a {
        private C0426a() {
        }

        @k.e.a.d
        public final a a(char c2, char c3, int i2) {
            return new a(c2, c3, i2);
        }

        public /* synthetic */ C0426a(h.k2.v.u uVar) {
            this();
        }
    }

    public a(char c2, char c3, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i2 != Integer.MIN_VALUE) {
            this.a = c2;
            this.b = (char) h.g2.m.c(c2, c3, i2);
            this.f14960c = i2;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public final char d() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.a != aVar.a || this.b != aVar.b || this.f14960c != aVar.f14960c) {
                }
            }
            return true;
        }
        return false;
    }

    public final char f() {
        return this.b;
    }

    public final int g() {
        return this.f14960c;
    }

    @Override // java.lang.Iterable
    @k.e.a.d
    /* renamed from: h */
    public h.a2.r iterator() {
        return new b(this.a, this.b, this.f14960c);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.b) * 31) + this.f14960c;
    }

    public boolean isEmpty() {
        if (this.f14960c > 0) {
            if (f0.t(this.a, this.b) > 0) {
                return true;
            }
        } else if (f0.t(this.a, this.b) < 0) {
            return true;
        }
        return false;
    }

    @k.e.a.d
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f14960c > 0) {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            i2 = this.f14960c;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            i2 = -this.f14960c;
        }
        sb.append(i2);
        return sb.toString();
    }
}

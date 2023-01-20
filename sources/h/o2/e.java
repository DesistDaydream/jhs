package h.o2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", MessageKey.MSG_ACCEPT_TIME_START, "endInclusive", "(FF)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Float;", "getStart", "contains", "", "value", "equals", "other", "", TTDownloadField.TT_HASHCODE, "", "isEmpty", "lessThanOrEquals", am.av, "b", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class e implements f<Float> {
    private final float a;
    private final float b;

    public e(float f2, float f3) {
        this.a = f2;
        this.b = f3;
    }

    @Override // h.o2.f
    public /* bridge */ /* synthetic */ boolean a(Float f2, Float f3) {
        return e(f2.floatValue(), f3.floatValue());
    }

    public boolean b(float f2) {
        return f2 >= this.a && f2 <= this.b;
    }

    @Override // h.o2.g
    @k.e.a.d
    /* renamed from: c */
    public Float getEndInclusive() {
        return Float.valueOf(this.b);
    }

    @Override // h.o2.f, h.o2.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return b(((Number) comparable).floatValue());
    }

    @Override // h.o2.g
    @k.e.a.d
    /* renamed from: d */
    public Float getStart() {
        return Float.valueOf(this.a);
    }

    public boolean e(float f2, float f3) {
        return f2 <= f3;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (obj instanceof e) {
            if (!isEmpty() || !((e) obj).isEmpty()) {
                e eVar = (e) obj;
                if (this.a != eVar.a || this.b != eVar.b) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.a).hashCode() * 31) + Float.valueOf(this.b).hashCode();
    }

    @Override // h.o2.f, h.o2.g
    public boolean isEmpty() {
        return this.a > this.b;
    }

    @k.e.a.d
    public String toString() {
        return this.a + ".." + this.b;
    }
}

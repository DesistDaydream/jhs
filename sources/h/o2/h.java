package h.o2;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.v.f0;
import h.o2.g;
import java.lang.Comparable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, d2 = {"Lkotlin/ranges/ComparableRange;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/ranges/ClosedRange;", MessageKey.MSG_ACCEPT_TIME_START, "endInclusive", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "getEndInclusive", "()Ljava/lang/Comparable;", "Ljava/lang/Comparable;", "getStart", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public class h<T extends Comparable<? super T>> implements g<T> {
    @k.e.a.d
    private final T a;
    @k.e.a.d
    private final T b;

    public h(@k.e.a.d T t, @k.e.a.d T t2) {
        this.a = t;
        this.b = t2;
    }

    @Override // h.o2.g
    public boolean contains(@k.e.a.d T t) {
        return g.a.a(this, t);
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (obj instanceof h) {
            if (!isEmpty() || !((h) obj).isEmpty()) {
                h hVar = (h) obj;
                if (!f0.g(getStart(), hVar.getStart()) || !f0.g(getEndInclusive(), hVar.getEndInclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // h.o2.g
    @k.e.a.d
    public T getEndInclusive() {
        return this.b;
    }

    @Override // h.o2.g
    @k.e.a.d
    public T getStart() {
        return this.a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    @Override // h.o2.g
    public boolean isEmpty() {
        return g.a.b(this);
    }

    @k.e.a.d
    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}

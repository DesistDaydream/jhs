package h.a2;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lkotlin/collections/IndexedValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "index", "", "value", "(ILjava/lang/Object;)V", "getIndex", "()I", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(ILjava/lang/Object;)Lkotlin/collections/IndexedValue;", "equals", "", "other", TTDownloadField.TT_HASHCODE, "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class i0<T> {
    private final int a;
    private final T b;

    public i0(int i2, T t) {
        this.a = i2;
        this.b = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ i0 d(i0 i0Var, int i2, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            i2 = i0Var.a;
        }
        if ((i3 & 2) != 0) {
            obj = i0Var.b;
        }
        return i0Var.c(i2, obj);
    }

    public final int a() {
        return this.a;
    }

    public final T b() {
        return this.b;
    }

    @k.e.a.d
    public final i0<T> c(int i2, T t) {
        return new i0<>(i2, t);
    }

    public final int e() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this != obj) {
            if (obj instanceof i0) {
                i0 i0Var = (i0) obj;
                return this.a == i0Var.a && h.k2.v.f0.g(this.b, i0Var.b);
            }
            return false;
        }
        return true;
    }

    public final T f() {
        return this.b;
    }

    public int hashCode() {
        int i2 = this.a * 31;
        T t = this.b;
        return i2 + (t != null ? t.hashCode() : 0);
    }

    @k.e.a.d
    public String toString() {
        return "IndexedValue(index=" + this.a + ", value=" + this.b + ")";
    }
}

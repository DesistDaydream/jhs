package e.t.r.a;

import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.v.u;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/vector/network/image/CircleShaper;", "Lcom/vector/network/image/Shaper;", "width", "", "color", "(II)V", "getColor", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a implements h {
    private final int a;
    private final int b;

    public a() {
        this(0, 0, 3, null);
    }

    public a(@IntRange(from = 0) int i2, @ColorInt int i3) {
        this.a = i2;
        this.b = i3;
    }

    public static /* synthetic */ a d(a aVar, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = aVar.a;
        }
        if ((i4 & 2) != 0) {
            i3 = aVar.b;
        }
        return aVar.c(i2, i3);
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    @k.e.a.d
    public final a c(@IntRange(from = 0) int i2, @ColorInt int i3) {
        return new a(i2, i3);
    }

    public final int e() {
        return this.b;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }
        return false;
    }

    public final int f() {
        return this.a;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    @k.e.a.d
    public String toString() {
        return "CircleShaper(width=" + this.a + ", color=" + this.b + ')';
    }

    public /* synthetic */ a(int i2, int i3, int i4, u uVar) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? 0 : i3);
    }
}

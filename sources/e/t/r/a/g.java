package e.t.r.a;

import androidx.annotation.IntRange;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.v.u;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/vector/network/image/RoundCornersShaper;", "Lcom/vector/network/image/Shaper;", "leftTop", "", "rightTop", "rightBottom", "leftBottom", "(IIII)V", "getLeftBottom", "()I", "getLeftTop", "getRightBottom", "getRightTop", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class g implements h {
    private final int a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14611c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14612d;

    public g() {
        this(0, 0, 0, 0, 15, null);
    }

    public g(@IntRange(from = 0, to = 180) int i2, @IntRange(from = 0, to = 180) int i3, @IntRange(from = 0, to = 180) int i4, @IntRange(from = 0, to = 180) int i5) {
        this.a = i2;
        this.b = i3;
        this.f14611c = i4;
        this.f14612d = i5;
    }

    public static /* synthetic */ g f(g gVar, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = gVar.a;
        }
        if ((i6 & 2) != 0) {
            i3 = gVar.b;
        }
        if ((i6 & 4) != 0) {
            i4 = gVar.f14611c;
        }
        if ((i6 & 8) != 0) {
            i5 = gVar.f14612d;
        }
        return gVar.e(i2, i3, i4, i5);
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.f14611c;
    }

    public final int d() {
        return this.f14612d;
    }

    @k.e.a.d
    public final g e(@IntRange(from = 0, to = 180) int i2, @IntRange(from = 0, to = 180) int i3, @IntRange(from = 0, to = 180) int i4, @IntRange(from = 0, to = 180) int i5) {
        return new g(i2, i3, i4, i5);
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.a == gVar.a && this.b == gVar.b && this.f14611c == gVar.f14611c && this.f14612d == gVar.f14612d;
        }
        return false;
    }

    public final int g() {
        return this.f14612d;
    }

    public final int h() {
        return this.a;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.f14611c) * 31) + this.f14612d;
    }

    public final int i() {
        return this.f14611c;
    }

    public final int j() {
        return this.b;
    }

    @k.e.a.d
    public String toString() {
        return "RoundCornersShaper(leftTop=" + this.a + ", rightTop=" + this.b + ", rightBottom=" + this.f14611c + ", leftBottom=" + this.f14612d + ')';
    }

    public /* synthetic */ g(int i2, int i3, int i4, int i5, int i6, u uVar) {
        this((i6 & 1) != 0 ? 0 : i2, (i6 & 2) != 0 ? 10 : i3, (i6 & 4) != 0 ? 10 : i4, (i6 & 8) != 0 ? 10 : i5);
    }
}

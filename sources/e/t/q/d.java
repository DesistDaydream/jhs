package e.t.q;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.v.u;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/vector/model/SizeF;", "", "width", "", "height", "(FF)V", "getHeight", "()F", "setHeight", "(F)V", "getWidth", "setWidth", "component1", "component2", "copy", "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    private float a;
    private float b;

    public d() {
        this(0.0f, 0.0f, 3, null);
    }

    public d(float f2, float f3) {
        this.a = f2;
        this.b = f3;
    }

    public static /* synthetic */ d d(d dVar, float f2, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = dVar.a;
        }
        if ((i2 & 2) != 0) {
            f3 = dVar.b;
        }
        return dVar.c(f2, f3);
    }

    public final float a() {
        return this.a;
    }

    public final float b() {
        return this.b;
    }

    @k.e.a.d
    public final d c(float f2, float f3) {
        return new d(f2, f3);
    }

    public final float e() {
        return this.b;
    }

    public boolean equals(@e Object obj) {
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.a == dVar.a) {
            return (this.b > dVar.b ? 1 : (this.b == dVar.b ? 0 : -1)) == 0;
        }
        return false;
    }

    public final float f() {
        return this.a;
    }

    public final void g(float f2) {
        this.b = f2;
    }

    public final void h(float f2) {
        this.a = f2;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    @k.e.a.d
    public String toString() {
        return "SizeF(width=" + this.a + ", height=" + this.b + ')';
    }

    public /* synthetic */ d(float f2, float f3, int i2, u uVar) {
        this((i2 & 1) != 0 ? 0.0f : f2, (i2 & 2) != 0 ? 0.0f : f3);
    }
}

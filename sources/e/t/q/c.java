package e.t.q;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.v.u;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/vector/model/Size;", "", "width", "", "height", "(II)V", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "component1", "component2", "copy", "equals", "", "other", TTDownloadField.TT_HASHCODE, "toString", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    private int a;
    private int b;

    public c() {
        this(0, 0, 3, null);
    }

    public c(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public static /* synthetic */ c d(c cVar, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = cVar.a;
        }
        if ((i4 & 2) != 0) {
            i3 = cVar.b;
        }
        return cVar.c(i2, i3);
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    @k.e.a.d
    public final c c(int i2, int i3) {
        return new c(i2, i3);
    }

    public final int e() {
        return this.b;
    }

    public boolean equals(@e Object obj) {
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && this.b == cVar.b;
    }

    public final int f() {
        return this.a;
    }

    public final void g(int i2) {
        this.b = i2;
    }

    public final void h(int i2) {
        this.a = i2;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    @k.e.a.d
    public String toString() {
        return "Size(width=" + this.a + ", height=" + this.b + ')';
    }

    public /* synthetic */ c(int i2, int i3, int i4, u uVar) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? 0 : i3);
    }
}

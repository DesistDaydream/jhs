package e.t.r.a;

import androidx.annotation.DrawableRes;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/vector/network/image/IrregularShaper;", "Lcom/vector/network/image/Shaper;", "resId", "", "(I)V", "getResId", "()I", "component1", "copy", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class e implements h {
    private final int a;

    public e(@DrawableRes int i2) {
        this.a = i2;
    }

    public static /* synthetic */ e c(e eVar, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = eVar.a;
        }
        return eVar.b(i2);
    }

    public final int a() {
        return this.a;
    }

    @k.e.a.d
    public final e b(@DrawableRes int i2) {
        return new e(i2);
    }

    public final int d() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.a == ((e) obj).a;
    }

    public int hashCode() {
        return this.a;
    }

    @k.e.a.d
    public String toString() {
        return "IrregularShaper(resId=" + this.a + ')';
    }
}

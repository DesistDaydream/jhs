package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.am;
import i.b.w3.f0;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0080@\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u00028\u00008F@\u0006¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\rø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Li/b/w3/g0;", "Li/b/w3/f0;", ExifInterface.LATITUDE_SOUTH, "", "", "toString", "()Ljava/lang/String;", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "f", "(Ljava/lang/Object;)Li/b/w3/f0;", "getSegment$annotations", "()V", "segment", am.av, "Ljava/lang/Object;", "value", "h", "isClosed", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class g0<S extends f0<S>> {
    private final Object a;

    private /* synthetic */ g0(@k.e.a.e Object obj) {
        this.a = obj;
    }

    @k.e.a.d
    public static final /* synthetic */ g0 a(@k.e.a.e Object obj) {
        return new g0(obj);
    }

    @k.e.a.d
    public static Object b(@k.e.a.e Object obj) {
        return obj;
    }

    public static boolean c(Object obj, @k.e.a.e Object obj2) {
        return (obj2 instanceof g0) && h.k2.v.f0.g(obj, ((g0) obj2).j());
    }

    public static final boolean d(@k.e.a.e Object obj, @k.e.a.e Object obj2) {
        return h.k2.v.f0.g(obj, obj2);
    }

    public static /* synthetic */ void e() {
    }

    @k.e.a.d
    public static final S f(Object obj) {
        if (obj != f.b) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type S");
            return (S) obj;
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static int g(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static final boolean h(Object obj) {
        return obj == f.b;
    }

    @k.e.a.d
    public static String i(Object obj) {
        return "SegmentOrClosed(value=" + obj + ")";
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public int hashCode() {
        return g(this.a);
    }

    @k.e.a.e
    public final /* synthetic */ Object j() {
        return this.a;
    }

    public String toString() {
        return i(this.a);
    }
}

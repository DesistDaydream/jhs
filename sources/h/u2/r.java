package h.u2;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.v.f0;
import h.k2.v.u;
import h.s0;
import kotlin.Metadata;

@j
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0018\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\bJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001a"}, d2 = {"Lkotlin/time/TimedValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "duration", "Lkotlin/time/Duration;", "(Ljava/lang/Object;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDuration-UwyO8pc", "()J", "J", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component2-UwyO8pc", "copy", "copy-RFiDyg4", "(Ljava/lang/Object;J)Lkotlin/time/TimedValue;", "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.3")
/* loaded from: classes4.dex */
public final class r<T> {
    private final T a;
    private final long b;

    private r(T t, long j2) {
        this.a = t;
        this.b = j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ r d(r rVar, Object obj, long j2, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = rVar.a;
        }
        if ((i2 & 2) != 0) {
            j2 = rVar.b;
        }
        return rVar.c(obj, j2);
    }

    public final T a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    @k.e.a.d
    public final r<T> c(T t, long j2) {
        return new r<>(t, j2);
    }

    public final long e() {
        return this.b;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this != obj) {
            if (obj instanceof r) {
                r rVar = (r) obj;
                return f0.g(this.a, rVar.a) && this.b == rVar.b;
            }
            return false;
        }
        return true;
    }

    public final T f() {
        return this.a;
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j2 = this.b;
        return (hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    @k.e.a.d
    public String toString() {
        return "TimedValue(value=" + this.a + ", duration=" + d.D0(this.b) + ")";
    }

    public /* synthetic */ r(Object obj, long j2, u uVar) {
        this(obj, j2);
    }
}

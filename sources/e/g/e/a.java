package e.g.e;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.hms.push.e;
import h.k2.v.f0;
import h.k2.v.u;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/eth/model/Error;", "", "code", "", "message", e.a, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()Ljava/lang/String;", "getE", "()Ljava/lang/Throwable;", "setE", "(Ljava/lang/Throwable;)V", "getMessage", "component1", "component2", "component3", "copy", "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "eth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class a {
    @k.e.a.d
    private final String a;
    @k.e.a.e
    private final String b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private Throwable f10023c;

    public a(@k.e.a.d String str, @k.e.a.e String str2, @k.e.a.e Throwable th) {
        this.a = str;
        this.b = str2;
        this.f10023c = th;
    }

    public static /* synthetic */ a e(a aVar, String str, String str2, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aVar.a;
        }
        if ((i2 & 2) != 0) {
            str2 = aVar.b;
        }
        if ((i2 & 4) != 0) {
            th = aVar.f10023c;
        }
        return aVar.d(str, str2, th);
    }

    @k.e.a.d
    public final String a() {
        return this.a;
    }

    @k.e.a.e
    public final String b() {
        return this.b;
    }

    @k.e.a.e
    public final Throwable c() {
        return this.f10023c;
    }

    @k.e.a.d
    public final a d(@k.e.a.d String str, @k.e.a.e String str2, @k.e.a.e Throwable th) {
        return new a(str, str2, th);
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f0.g(this.a, aVar.a) && f0.g(this.b, aVar.b) && f0.g(this.f10023c, aVar.f10023c);
        }
        return false;
    }

    @k.e.a.d
    public final String f() {
        return this.a;
    }

    @k.e.a.e
    public final Throwable g() {
        return this.f10023c;
    }

    @k.e.a.e
    public final String h() {
        return this.b;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Throwable th = this.f10023c;
        return hashCode2 + (th != null ? th.hashCode() : 0);
    }

    public final void i(@k.e.a.e Throwable th) {
        this.f10023c = th;
    }

    @k.e.a.d
    public String toString() {
        return "Error(code=" + this.a + ", message=" + ((Object) this.b) + ", e=" + this.f10023c + ')';
    }

    public /* synthetic */ a(String str, String str2, Throwable th, int i2, u uVar) {
        this(str, str2, (i2 & 4) != 0 ? null : th);
    }
}

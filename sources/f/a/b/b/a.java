package f.a.b.b;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.hms.push.constant.RemoteMessageConst;
import h.k2.v.f0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Linject/annotation/route/info/RouteInfo;", "", "path", "", RemoteMessageConst.Notification.PRIORITY, "", "classPath", "(Ljava/lang/String;ILjava/lang/String;)V", "getClassPath", "()Ljava/lang/String;", "getPath", "getPriority", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", TTDownloadField.TT_HASHCODE, "toString", "annotation"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    @d
    private final String a;
    private final int b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final String f14753c;

    public a(@d String str, int i2, @d String str2) {
        this.a = str;
        this.b = i2;
        this.f14753c = str2;
    }

    public static /* synthetic */ a e(a aVar, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = aVar.a;
        }
        if ((i3 & 2) != 0) {
            i2 = aVar.b;
        }
        if ((i3 & 4) != 0) {
            str2 = aVar.f14753c;
        }
        return aVar.d(str, i2, str2);
    }

    @d
    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    @d
    public final String c() {
        return this.f14753c;
    }

    @d
    public final a d(@d String str, int i2, @d String str2) {
        return new a(str, i2, str2);
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f0.g(this.a, aVar.a) && this.b == aVar.b && f0.g(this.f14753c, aVar.f14753c);
        }
        return false;
    }

    @d
    public final String f() {
        return this.f14753c;
    }

    @d
    public final String g() {
        return this.a;
    }

    public final int h() {
        return this.b;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.f14753c.hashCode();
    }

    @d
    public String toString() {
        return "RouteInfo(path=" + this.a + ", priority=" + this.b + ", classPath=" + this.f14753c + ')';
    }
}

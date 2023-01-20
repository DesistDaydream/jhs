package f.a.b.b;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.hms.push.constant.RemoteMessageConst;
import h.k2.v.f0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Linject/annotation/route/info/ServiceInfo;", "", "servicePath", "", "path", RemoteMessageConst.Notification.PRIORITY, "", "classPath", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getClassPath", "()Ljava/lang/String;", "getPath", "getPriority", "()I", "getServicePath", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", TTDownloadField.TT_HASHCODE, "toString", "annotation"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    @d
    private final String a;
    @d
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14754c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final String f14755d;

    public b(@d String str, @d String str2, int i2, @d String str3) {
        this.a = str;
        this.b = str2;
        this.f14754c = i2;
        this.f14755d = str3;
    }

    public static /* synthetic */ b f(b bVar, String str, String str2, int i2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = bVar.a;
        }
        if ((i3 & 2) != 0) {
            str2 = bVar.b;
        }
        if ((i3 & 4) != 0) {
            i2 = bVar.f14754c;
        }
        if ((i3 & 8) != 0) {
            str3 = bVar.f14755d;
        }
        return bVar.e(str, str2, i2, str3);
    }

    @d
    public final String a() {
        return this.a;
    }

    @d
    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.f14754c;
    }

    @d
    public final String d() {
        return this.f14755d;
    }

    @d
    public final b e(@d String str, @d String str2, int i2, @d String str3) {
        return new b(str, str2, i2, str3);
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return f0.g(this.a, bVar.a) && f0.g(this.b, bVar.b) && this.f14754c == bVar.f14754c && f0.g(this.f14755d, bVar.f14755d);
        }
        return false;
    }

    @d
    public final String g() {
        return this.f14755d;
    }

    @d
    public final String h() {
        return this.b;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.f14754c) * 31) + this.f14755d.hashCode();
    }

    public final int i() {
        return this.f14754c;
    }

    @d
    public final String j() {
        return this.a;
    }

    @d
    public String toString() {
        return "ServiceInfo(servicePath=" + this.a + ", path=" + this.b + ", priority=" + this.f14754c + ", classPath=" + this.f14755d + ')';
    }
}

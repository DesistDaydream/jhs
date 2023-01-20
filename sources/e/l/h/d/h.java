package e.l.h.d;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.v.f0;
import h.k2.v.u;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/jihuanshe/base/bus/Event;", "", "flag", "", k.b.a.a.n.n.c.b, "timestamp", "", "(Ljava/lang/String;Ljava/lang/Object;J)V", "getAny", "()Ljava/lang/Object;", "getFlag", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class h {
    @k.e.a.d
    private final String a;
    @k.e.a.e
    private final Object b;

    /* renamed from: c  reason: collision with root package name */
    private final long f12086c;

    public h(@k.e.a.d String str, @k.e.a.e Object obj, long j2) {
        this.a = str;
        this.b = obj;
        this.f12086c = j2;
    }

    public static /* synthetic */ h e(h hVar, String str, Object obj, long j2, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = hVar.a;
        }
        if ((i2 & 2) != 0) {
            obj = hVar.b;
        }
        if ((i2 & 4) != 0) {
            j2 = hVar.f12086c;
        }
        return hVar.d(str, obj, j2);
    }

    @k.e.a.d
    public final String a() {
        return this.a;
    }

    @k.e.a.e
    public final Object b() {
        return this.b;
    }

    public final long c() {
        return this.f12086c;
    }

    @k.e.a.d
    public final h d(@k.e.a.d String str, @k.e.a.e Object obj, long j2) {
        return new h(str, obj, j2);
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return f0.g(this.a, hVar.a) && f0.g(this.b, hVar.b) && this.f12086c == hVar.f12086c;
        }
        return false;
    }

    @k.e.a.e
    public final Object f() {
        return this.b;
    }

    @k.e.a.d
    public final String g() {
        return this.a;
    }

    public final long h() {
        return this.f12086c;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        Object obj = this.b;
        return ((hashCode + (obj == null ? 0 : obj.hashCode())) * 31) + defpackage.b.a(this.f12086c);
    }

    @k.e.a.d
    public String toString() {
        return "Event(flag=" + this.a + ", any=" + this.b + ", timestamp=" + this.f12086c + ')';
    }

    public /* synthetic */ h(String str, Object obj, long j2, int i2, u uVar) {
        this(str, (i2 & 2) != 0 ? null : obj, j2);
    }
}

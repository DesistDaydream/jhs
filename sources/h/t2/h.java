package h.t2;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.v.f0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lkotlin/text/MatchGroup;", "", "value", "", "range", "Lkotlin/ranges/IntRange;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getRange", "()Lkotlin/ranges/IntRange;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class h {
    @k.e.a.d
    private final String a;
    @k.e.a.d
    private final h.o2.k b;

    public h(@k.e.a.d String str, @k.e.a.d h.o2.k kVar) {
        this.a = str;
        this.b = kVar;
    }

    public static /* synthetic */ h d(h hVar, String str, h.o2.k kVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = hVar.a;
        }
        if ((i2 & 2) != 0) {
            kVar = hVar.b;
        }
        return hVar.c(str, kVar);
    }

    @k.e.a.d
    public final String a() {
        return this.a;
    }

    @k.e.a.d
    public final h.o2.k b() {
        return this.b;
    }

    @k.e.a.d
    public final h c(@k.e.a.d String str, @k.e.a.d h.o2.k kVar) {
        return new h(str, kVar);
    }

    @k.e.a.d
    public final h.o2.k e() {
        return this.b;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this != obj) {
            if (obj instanceof h) {
                h hVar = (h) obj;
                return f0.g(this.a, hVar.a) && f0.g(this.b, hVar.b);
            }
            return false;
        }
        return true;
    }

    @k.e.a.d
    public final String f() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        h.o2.k kVar = this.b;
        return hashCode + (kVar != null ? kVar.hashCode() : 0);
    }

    @k.e.a.d
    public String toString() {
        return "MatchGroup(value=" + this.a + ", range=" + this.b + ")";
    }
}

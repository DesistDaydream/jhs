package e.l.r;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.vector.util.CachingEx;

/* loaded from: classes2.dex */
public final class w extends CachingEx {
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public static final w f14319e;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final String f14320f = "/Download/";
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    public static final String f14321g = "/Pictures/";
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private static final String f14322h = "/camera/";
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    private static final String f14323i = "/music/";
    @k.e.a.e

    /* renamed from: j  reason: collision with root package name */
    private static String f14324j;
    @k.e.a.e

    /* renamed from: k  reason: collision with root package name */
    private static String f14325k;
    @k.e.a.e

    /* renamed from: l  reason: collision with root package name */
    private static String f14326l;
    @k.e.a.e

    /* renamed from: m  reason: collision with root package name */
    private static String f14327m;
    @k.e.a.e
    private static String n;

    static {
        w wVar = new w();
        f14319e = wVar;
        f14324j = CachingEx.g(wVar, f14322h, null, 2, null);
        f14325k = CachingEx.g(wVar, f14321g, null, 2, null);
        f14326l = CachingEx.g(wVar, f14320f, null, 2, null);
        f14327m = wVar.f(f14321g, e.t.u.g.a.g());
        n = CachingEx.g(wVar, f14323i, null, 2, null);
    }

    private w() {
    }

    @k.e.a.d
    public final String c() {
        return d();
    }

    @k.e.a.e
    public final String h() {
        return f14325k;
    }

    @k.e.a.e
    public final String i() {
        return f14324j;
    }

    @k.e.a.e
    public final String j() {
        return f14326l;
    }

    @k.e.a.e
    public final String k() {
        return f14327m;
    }

    @k.e.a.e
    public final String l() {
        return n;
    }

    @k.e.a.d
    public final String m(@k.e.a.d String str) {
        return CachingEx.g(this, Attributes.InternalPrefix + str + Attributes.InternalPrefix, null, 2, null);
    }
}

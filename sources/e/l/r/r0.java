package e.l.r;

import android.content.Context;
import android.net.Uri;
import java.util.Map;

/* loaded from: classes2.dex */
public final class r0 {
    @k.e.a.d
    public static final r0 a = new r0();
    @k.e.a.d
    private static final String b = "UrlTranslator";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f14309c = "from";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public static final String f14310d = "/app/webView";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public static final String f14311e = "/app/cardDetail";
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final String f14312f = "/app/packDetail";
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    public static final String f14313g = "url";
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    public static final String f14314h = "gameKey";
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    public static final String f14315i = "gameSubKey";
    @k.e.a.d

    /* renamed from: j  reason: collision with root package name */
    public static final String f14316j = "cardVersionId";
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    public static final String f14317k = "packId";

    private r0() {
    }

    private final void a(Uri uri, Map<String, String> map) {
        String queryParameter = uri.getQueryParameter(f14314h);
        boolean z = false;
        if (!(queryParameter == null || queryParameter.length() == 0)) {
            map.put(f14314h, uri.getQueryParameter(f14314h));
        }
        String queryParameter2 = uri.getQueryParameter(f14315i);
        if ((queryParameter2 == null || queryParameter2.length() == 0) ? true : true) {
            return;
        }
        map.put(f14315i, uri.getQueryParameter(f14315i));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
    @k.e.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.jihuanshe.model.RouterInfo b(@k.e.a.d android.net.Uri r10) {
        /*
            r9 = this;
            com.jihuanshe.model.RouterInfo r0 = new com.jihuanshe.model.RouterInfo
            r0.<init>()
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.lang.String r2 = r10.getPath()
            java.lang.String r3 = ""
            if (r2 == 0) goto L13
            goto L14
        L13:
            r2 = r3
        L14:
            r0.setHostPath(r2)
            java.lang.String r2 = r0.getHostPath()
            int r4 = r2.hashCode()
            r5 = -308604260(0xffffffffed9b129c, float:-5.999084E27)
            java.lang.String r6 = "url"
            r7 = 1
            r8 = 0
            if (r4 == r5) goto L7d
            r5 = -242771353(0xfffffffff1879a67, float:-1.3429484E30)
            if (r4 == r5) goto L58
            r5 = 766696990(0x2db2de1e, float:2.0334897E-11)
            if (r4 == r5) goto L33
            goto L85
        L33:
            java.lang.String r4 = "/app/cardDetail"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L3c
            goto L85
        L3c:
            r9.a(r10, r1)
            java.lang.String r2 = "cardVersionId"
            java.lang.String r4 = r10.getQueryParameter(r2)
            if (r4 == 0) goto L48
            goto L49
        L48:
            r4 = r3
        L49:
            int r5 = r4.length()
            if (r5 <= 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = 0
        L52:
            if (r5 == 0) goto Lae
            r1.put(r2, r4)
            goto Lae
        L58:
            java.lang.String r4 = "/app/packDetail"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L61
            goto L85
        L61:
            r9.a(r10, r1)
            java.lang.String r2 = "packId"
            java.lang.String r4 = r10.getQueryParameter(r2)
            if (r4 == 0) goto L6d
            goto L6e
        L6d:
            r4 = r3
        L6e:
            int r5 = r4.length()
            if (r5 <= 0) goto L76
            r5 = 1
            goto L77
        L76:
            r5 = 0
        L77:
            if (r5 == 0) goto Lae
            r1.put(r2, r4)
            goto Lae
        L7d:
            java.lang.String r4 = "/app/webView"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L98
        L85:
            java.lang.String r2 = r10.toString()
            int r4 = r2.length()
            if (r4 <= 0) goto L91
            r4 = 1
            goto L92
        L91:
            r4 = 0
        L92:
            if (r4 == 0) goto Lae
            r1.put(r6, r2)
            goto Lae
        L98:
            java.lang.String r2 = r10.getQueryParameter(r6)
            if (r2 == 0) goto L9f
            goto La0
        L9f:
            r2 = r3
        La0:
            int r4 = r2.length()
            if (r4 <= 0) goto La8
            r4 = 1
            goto La9
        La8:
            r4 = 0
        La9:
            if (r4 == 0) goto Lae
            r1.put(r6, r2)
        Lae:
            java.lang.String r2 = "from"
            java.lang.String r10 = r10.getQueryParameter(r2)
            if (r10 == 0) goto Lb7
            r3 = r10
        Lb7:
            int r10 = r3.length()
            if (r10 <= 0) goto Lbe
            goto Lbf
        Lbe:
            r7 = 0
        Lbf:
            if (r7 == 0) goto Lc4
            r1.put(r2, r3)
        Lc4:
            r0.setMap(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.r.r0.b(android.net.Uri):com.jihuanshe.model.RouterInfo");
    }

    public final void c(@k.e.a.d Context context, @k.e.a.e Uri uri) {
        e.l.h.k.b.a.a(b, h.k2.v.f0.C("uri : ", uri));
        if (uri == null) {
            return;
        }
        d(context, b(uri));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(@k.e.a.d android.content.Context r7, @k.e.a.e com.jihuanshe.model.RouterInfo r8) {
        /*
            r6 = this;
            if (r8 != 0) goto L3
            return
        L3:
            java.lang.String r0 = r8.getHostPath()
            java.lang.String r1 = "/app/cardDetail"
            boolean r1 = h.k2.v.f0.g(r0, r1)
            java.lang.String r2 = "gameSubKey"
            java.lang.String r3 = "gameKey"
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L6f
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L3c
            java.util.Map r0 = r8.getMap()     // Catch: java.lang.Throwable -> L3c
            if (r0 != 0) goto L1f
        L1d:
            r0 = r5
            goto L32
        L1f:
            java.lang.String r1 = "cardVersionId"
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L3c
            if (r0 != 0) goto L2a
            goto L1d
        L2a:
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L3c
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L3c
        L32:
            int r4 = r0.intValue()     // Catch: java.lang.Throwable -> L3c
            h.t1 r0 = h.t1.a     // Catch: java.lang.Throwable -> L3c
            kotlin.Result.m106constructorimpl(r0)     // Catch: java.lang.Throwable -> L3c
            goto L46
        L3c:
            r0 = move-exception
            kotlin.Result$a r1 = kotlin.Result.Companion
            java.lang.Object r0 = h.r0.a(r0)
            kotlin.Result.m106constructorimpl(r0)
        L46:
            java.util.Map r0 = r8.getMap()
            if (r0 != 0) goto L4e
            r0 = r5
            goto L54
        L4e:
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
        L54:
            java.util.Map r8 = r8.getMap()
            if (r8 != 0) goto L5b
            goto L62
        L5b:
            java.lang.Object r8 = r8.get(r2)
            r5 = r8
            java.lang.String r5 = (java.lang.String) r5
        L62:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            com.jihuanshe.ui.page.detail.CardDetailActivityCreator r8 = com.jihuanshe.ui.page.detail.CardDetailActivityCreator.create(r8, r0, r5)
            r8.start(r7)
            goto Lec
        L6f:
            java.lang.String r1 = "/app/packDetail"
            boolean r0 = h.k2.v.f0.g(r0, r1)
            if (r0 == 0) goto Ld0
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L9e
            java.util.Map r0 = r8.getMap()     // Catch: java.lang.Throwable -> L9e
            if (r0 != 0) goto L81
        L7f:
            r0 = r5
            goto L94
        L81:
            java.lang.String r1 = "packId"
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L9e
            if (r0 != 0) goto L8c
            goto L7f
        L8c:
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L9e
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L9e
        L94:
            int r4 = r0.intValue()     // Catch: java.lang.Throwable -> L9e
            h.t1 r0 = h.t1.a     // Catch: java.lang.Throwable -> L9e
            kotlin.Result.m106constructorimpl(r0)     // Catch: java.lang.Throwable -> L9e
            goto La8
        L9e:
            r0 = move-exception
            kotlin.Result$a r1 = kotlin.Result.Companion
            java.lang.Object r0 = h.r0.a(r0)
            kotlin.Result.m106constructorimpl(r0)
        La8:
            java.util.Map r0 = r8.getMap()
            if (r0 != 0) goto Lb0
            r0 = r5
            goto Lb6
        Lb0:
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
        Lb6:
            java.util.Map r8 = r8.getMap()
            if (r8 != 0) goto Lbd
            goto Lc4
        Lbd:
            java.lang.Object r8 = r8.get(r2)
            r5 = r8
            java.lang.String r5 = (java.lang.String) r5
        Lc4:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            com.jihuanshe.ui.page.detail.CardPackDetailActivityCreator r8 = com.jihuanshe.ui.page.detail.CardPackDetailActivityCreator.create(r8, r0, r5)
            r8.start(r7)
            goto Lec
        Ld0:
            java.util.Map r8 = r8.getMap()
            if (r8 != 0) goto Ld7
            goto Le0
        Ld7:
            java.lang.String r0 = "url"
            java.lang.Object r8 = r8.get(r0)
            r5 = r8
            java.lang.String r5 = (java.lang.String) r5
        Le0:
            if (r5 == 0) goto Le3
            goto Le5
        Le3:
            java.lang.String r5 = ""
        Le5:
            com.jihuanshe.ui.page.web.CommonWebViewActivityCreator r8 = com.jihuanshe.ui.page.web.CommonWebViewActivityCreator.create(r5)
            r8.start(r7)
        Lec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.r.r0.d(android.content.Context, com.jihuanshe.model.RouterInfo):void");
    }
}

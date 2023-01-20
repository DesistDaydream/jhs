package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.j0;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TToast;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class g {
    private static Comparator<TTBaseAd> a = null;
    private static String b = "KEY_LOAD_SEQ";

    /* renamed from: c  reason: collision with root package name */
    private static String f916c = "KEY_LOAD_SEQ_TIME";

    /* loaded from: classes.dex */
    public static final class a implements Comparator<TTBaseAd> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TTBaseAd tTBaseAd, TTBaseAd tTBaseAd2) {
            if (tTBaseAd.getCpm() <= tTBaseAd2.getCpm()) {
                if (tTBaseAd.getCpm() < tTBaseAd2.getCpm()) {
                    return 1;
                }
                if (tTBaseAd.getCpm() != tTBaseAd2.getCpm() || tTBaseAd.getAdNetworkPlatformId() != 1) {
                    return 0;
                }
            }
            return -1;
        }
    }

    public static int a() {
        long a2 = c0.a((String) null, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).a(f916c, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        boolean a3 = a(new Date(a2), new Date(currentTimeMillis));
        c0.a((String) null, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).b(f916c, currentTimeMillis);
        int a4 = (a3 ? c0.a((String) null, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).a(b, 0) : 0) + 1;
        c0.a((String) null, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).b(b, a4);
        return a4;
    }

    public static j a(String str, String str2, int i2, int i3) {
        j jVar = new j();
        jVar.b(str2);
        jVar.a(str);
        jVar.c(0);
        jVar.e("0");
        jVar.f("1");
        jVar.g(i2);
        jVar.j(i3);
        jVar.i(3);
        jVar.g("%1$s%2$sAdapter");
        return jVar;
    }

    public static TTAbsAdLoaderAdapter a(String str, j jVar) {
        if (jVar != null) {
            String a2 = a(jVar.q(), c(jVar.e()), e.c.c.a.a.c(jVar.t(), jVar.z()));
            TTAbsAdLoaderAdapter b2 = b(a2);
            if (b2 != null) {
                Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(str, "request") + "创建adapter成功!! class=" + a2 + " adn_version:" + b2.getSdkVersion());
                return b2;
            }
            return b2;
        }
        return null;
    }

    public static String a(String str, String str2, String str3) {
        if (TextUtils.equals("pangle", e.c.c.a.a.e(str2)) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().z()) {
            String format = String.format(str, "PangleCustom", str3);
            return "com.bytedance.msdk.adapter.panglecustom." + format;
        }
        String format2 = String.format(str, str2, str3);
        return "com.bytedance.msdk.adapter." + e.c.c.a.a.e(str2) + "." + format2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.Object> a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r7, com.bytedance.msdk.api.AdSlot r8, java.util.Map<java.lang.String, java.lang.Object> r9, com.bytedance.msdk.api.v2.GMNetworkRequestInfo r10, int r11, int r12, boolean r13, long r14) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()
            java.lang.String r2 = r7.e()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a r1 = r1.a(r2)
            java.lang.String r2 = "tt_ad_network_config_appKey"
            java.lang.String r3 = "tt_ad_network_config_appid"
            if (r1 == 0) goto L26
            java.lang.String r10 = r1.a()
            r0.put(r3, r10)
            java.lang.String r10 = r1.b()
        L22:
            r0.put(r2, r10)
            goto L56
        L26:
            java.lang.String r1 = r7.e()
            r4 = 0
            if (r10 == 0) goto L35
            int r4 = r10.getAdNetworkFlatFromId()
            java.lang.String r4 = e.c.c.a.a.b(r4)
        L35:
            if (r10 == 0) goto L56
            int r5 = r7.p()
            r6 = -4
            if (r5 != r6) goto L56
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L56
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L56
            java.lang.String r1 = r10.getAppId()
            r0.put(r3, r1)
            java.lang.String r10 = r10.getAppKey()
            goto L22
        L56:
            int r10 = r7.s()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r1 = "tt_ad_origin_type"
            r0.put(r1, r10)
            int r7 = r7.z()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r10 = "tt_ad_sub_type"
            r0.put(r10, r7)
            if (r8 == 0) goto Lad
            com.bytedance.msdk.api.TTRequestExtraParams r7 = r8.getReuestParam()
            if (r7 == 0) goto L7f
            java.util.Map r7 = r7.getExtraObject()
            r0.putAll(r7)
        L7f:
            int r7 = r8.getImgAcceptedWidth()
            int r10 = r8.getImgAcceptedHeight()
            r1 = 0
            if (r7 >= 0) goto L8b
            r7 = 0
        L8b:
            if (r10 >= 0) goto L8e
            r10 = 0
        L8e:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r1 = "ad_height"
            r0.put(r1, r10)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r10 = "ad_width"
            r0.put(r10, r7)
            int r7 = r8.getAdType()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "ad_type"
            r0.put(r8, r7)
        Lad:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)
            java.lang.String r8 = "key_mediation_rit_req_type"
            r0.put(r8, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)
            java.lang.String r8 = "key_mediation_rit_req_type_src"
            r0.put(r8, r7)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r13)
            java.lang.String r8 = "key_is_from_developer_req"
            r0.put(r8, r7)
            java.lang.Long r7 = java.lang.Long.valueOf(r14)
            java.lang.String r8 = "key_requestwfb_ms"
            r0.put(r8, r7)
            if (r9 == 0) goto Ldc
            int r7 = r9.size()
            if (r7 <= 0) goto Ldc
            r0.putAll(r9)
        Ldc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, com.bytedance.msdk.api.AdSlot, java.util.Map, com.bytedance.msdk.api.v2.GMNetworkRequestInfo, int, int, boolean, long):java.util.Map");
    }

    public static void a(AdError adError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().H() || adError == null || dVar == null) {
            return;
        }
        if (20001 == adError.code) {
            TToast.show(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), String.format("error_adn:%1$s no ads，please check ad network", dVar.c()));
        } else {
            TToast.show(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), String.format("test error_adn:%1$s  error_slot_id: %2$s  error_code:%3$d  error_message:%4$s", dVar.c(), dVar.d(), Integer.valueOf(adError.thirdSdkErrorCode), adError.thirdSdkErrorMessage));
        }
    }

    public static void a(String str, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar, TTBaseAd tTBaseAd) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().H() && dVar != null && a(str, tTBaseAd)) {
            TToast.show(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), String.format("fill_suceess ,test_adn:%1$s,slot_id : %2$s", dVar.c(), dVar.d()));
        }
    }

    public static void a(List<TTBaseAd> list, Comparator<TTBaseAd> comparator) {
        if (comparator == null) {
            j0.a(list);
        } else {
            j0.a(list, comparator);
        }
    }

    public static boolean a(String str) {
        return true;
    }

    private static boolean a(String str, TTBaseAd tTBaseAd) {
        if (tTBaseAd != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c c2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().c(str);
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().f(str) && c2 != null && c2.i() != null && c2.i().size() > 0 && c2.A() != null && c2.A().size() > 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    public static TTAbsAdLoaderAdapter b(String str) {
        try {
            return (TTAbsAdLoaderAdapter) Class.forName(str).newInstance();
        } catch (Exception e2) {
            Logger.e("TTMediationSDK", "创建广告网络adapter加载器失败：class=" + str + ",异常信息：" + e2.toString());
            return null;
        }
    }

    public static Comparator<TTBaseAd> b() {
        a aVar = new a();
        a = aVar;
        return aVar;
    }

    public static void b(String str, TTBaseAd tTBaseAd) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().H() && tTBaseAd != null && a(str, tTBaseAd)) {
            TToast.show(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), String.format("test_suceess ,test_adn:%1$s,slot_id : %2$s", e.c.c.a.a.b(tTBaseAd.getAdNetworkPlatformId()), tTBaseAd.getAdNetworkSlotId()));
        }
    }

    public static String c(String str) {
        return !TextUtils.isEmpty(str) ? str.substring(0, 1).toUpperCase().concat(str.substring(1).toLowerCase()) : str;
    }

    public static Comparator<TTBaseAd> c() {
        Comparator<TTBaseAd> comparator = a;
        return comparator != null ? comparator : b();
    }

    public static String d() {
        return UUID.randomUUID().toString();
    }

    public static void e() {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().H()) {
            TToast.show(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), "slot setting error");
        }
    }
}

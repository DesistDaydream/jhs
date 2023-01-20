package e.l.r;

import android.content.Context;
import cn.thinkingdata.android.TDConfig;
import cn.thinkingdata.android.TDFirstEvent;
import cn.thinkingdata.android.ThinkingAnalyticsSDK;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.utils.StringUtil;
import java.util.Objects;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class r {
    @k.e.a.d
    private static final String A = "is_register";
    @k.e.a.d
    private static final String B = "type";
    @k.e.a.d
    private static final String C = "reason";
    private static ThinkingAnalyticsSDK D = null;
    @k.e.a.d
    public static final r a = new r();
    @k.e.a.d
    private static final String b = "AnalysisHelper";
    @k.e.a.d

    /* renamed from: c */
    private static final String f14298c = "9673995364cc4d70b2814f4b9f6eff1c";
    @k.e.a.d

    /* renamed from: d */
    private static final String f14299d = "https://stat.jihuanshe.com";
    @k.e.a.d

    /* renamed from: e */
    private static final String f14300e = "previous_page";
    @k.e.a.d

    /* renamed from: f */
    private static final String f14301f = "game_type";
    @k.e.a.d

    /* renamed from: g */
    private static final String f14302g = "series_category";
    @k.e.a.d

    /* renamed from: h */
    private static final String f14303h = "series_name";
    @k.e.a.d

    /* renamed from: i */
    private static final String f14304i = "series_number";
    @k.e.a.d

    /* renamed from: j */
    private static final String f14305j = "card_name";
    @k.e.a.d

    /* renamed from: k */
    private static final String f14306k = "card_version_id";
    @k.e.a.d

    /* renamed from: l */
    private static final String f14307l = "card_number";
    @k.e.a.d

    /* renamed from: m */
    private static final String f14308m = "rarity";
    @k.e.a.d
    private static final String n = "avg_price";
    @k.e.a.d
    private static final String o = "release_date";
    @k.e.a.d
    private static final String p = "card_version_count";
    @k.e.a.d
    private static final String q = "grade";
    @k.e.a.d
    private static final String r = "grade_count";
    @k.e.a.d
    private static final String s = "review_count";
    @k.e.a.d
    private static final String t = "seller_count";
    @k.e.a.d
    private static final String u = "like_count";
    @k.e.a.d
    private static final String v = "desire_count";
    @k.e.a.d
    private static final String w = "operation";
    @k.e.a.d
    private static final String x = "device_activate_time";
    @k.e.a.d
    private static final String y = "is_success";
    @k.e.a.d
    private static final String z = "failure_reason";

    private r() {
    }

    public static /* synthetic */ void h(r rVar, String str, boolean z2, Boolean bool, String str2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        rVar.g(str, z2, bool, str2);
    }

    public final void a(@k.e.a.d Context context) {
        ThinkingAnalyticsSDK sharedInstance = ThinkingAnalyticsSDK.sharedInstance(TDConfig.getInstance(context, f14298c, f14299d));
        D = sharedInstance;
        Objects.requireNonNull(sharedInstance);
        sharedInstance.enableAutoTrack(CollectionsKt__CollectionsKt.P(ThinkingAnalyticsSDK.AutoTrackEventType.APP_INSTALL, ThinkingAnalyticsSDK.AutoTrackEventType.APP_START, ThinkingAnalyticsSDK.AutoTrackEventType.APP_END, ThinkingAnalyticsSDK.AutoTrackEventType.APP_CRASH));
        d();
    }

    public final void b() {
        ThinkingAnalyticsSDK thinkingAnalyticsSDK = D;
        Objects.requireNonNull(thinkingAnalyticsSDK);
        thinkingAnalyticsSDK.login(String.valueOf(UserKV.f3913c.v()));
    }

    public final void c() {
        ThinkingAnalyticsSDK thinkingAnalyticsSDK = D;
        Objects.requireNonNull(thinkingAnalyticsSDK);
        thinkingAnalyticsSDK.logout();
    }

    public final void d() {
        JSONObject jSONObject = new JSONObject();
        try {
            Result.a aVar = Result.Companion;
            Result.m106constructorimpl(jSONObject.put(x, StringUtil.a.g(Long.valueOf(System.currentTimeMillis()), "yyyy-MM-dd HH:mm:ss.SSS")));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(h.r0.a(th));
        }
        ThinkingAnalyticsSDK thinkingAnalyticsSDK = D;
        Objects.requireNonNull(thinkingAnalyticsSDK);
        thinkingAnalyticsSDK.track(new TDFirstEvent("device_activate", jSONObject));
    }

    public final void e(@k.e.a.e String str, @k.e.a.e String str2, @k.e.a.e String str3, @k.e.a.e String str4, @k.e.a.e Integer num, @k.e.a.e String str5, @k.e.a.e String str6, @k.e.a.e String str7) {
        JSONObject jSONObject = new JSONObject();
        try {
            Result.a aVar = Result.Companion;
            jSONObject.put(f14301f, str);
            jSONObject.put(f14303h, str2);
            jSONObject.put(f14304i, str3);
            jSONObject.put(f14305j, str4);
            jSONObject.put(f14306k, num);
            jSONObject.put(f14307l, str5);
            jSONObject.put(f14308m, str6);
            Result.m106constructorimpl(jSONObject.put(w, str7));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(h.r0.a(th));
        }
        ThinkingAnalyticsSDK thinkingAnalyticsSDK = D;
        Objects.requireNonNull(thinkingAnalyticsSDK);
        thinkingAnalyticsSDK.track("series_card_operation", jSONObject);
    }

    public final void f(@k.e.a.d String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            Result.a aVar = Result.Companion;
            Result.m106constructorimpl(jSONObject.put("reason", str));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(h.r0.a(th));
        }
        ThinkingAnalyticsSDK thinkingAnalyticsSDK = D;
        Objects.requireNonNull(thinkingAnalyticsSDK);
        thinkingAnalyticsSDK.track("encry_error", jSONObject);
    }

    public final void g(@k.e.a.d String str, boolean z2, @k.e.a.e Boolean bool, @k.e.a.e String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            Result.a aVar = Result.Companion;
            jSONObject.put("type", str);
            jSONObject.put(y, z2);
            jSONObject.put(z, str2);
            Result.m106constructorimpl(jSONObject.put(A, bool));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(h.r0.a(th));
        }
        ThinkingAnalyticsSDK thinkingAnalyticsSDK = D;
        Objects.requireNonNull(thinkingAnalyticsSDK);
        thinkingAnalyticsSDK.track("register_or_login", jSONObject);
    }

    public final void i(@k.e.a.e String str, @k.e.a.e String str2, @k.e.a.e String str3, @k.e.a.e String str4, @k.e.a.e String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            Result.a aVar = Result.Companion;
            jSONObject.put(f14301f, str);
            jSONObject.put(f14302g, str2);
            jSONObject.put(f14303h, str3);
            jSONObject.put(f14304i, str4);
            Result.m106constructorimpl(jSONObject.put(w, str5));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(h.r0.a(th));
        }
        ThinkingAnalyticsSDK thinkingAnalyticsSDK = D;
        Objects.requireNonNull(thinkingAnalyticsSDK);
        thinkingAnalyticsSDK.track("homepage_click", jSONObject);
    }

    public final void j(@k.e.a.e String str, @k.e.a.e String str2, @k.e.a.e String str3, @k.e.a.e String str4, @k.e.a.e Integer num, @k.e.a.e String str5, @k.e.a.e String str6, @k.e.a.e Float f2, @k.e.a.e Float f3, @k.e.a.e Integer num2, @k.e.a.e Integer num3, @k.e.a.e Integer num4, @k.e.a.e Integer num5, @k.e.a.e Integer num6) {
        JSONObject jSONObject = new JSONObject();
        try {
            Result.a aVar = Result.Companion;
            jSONObject.put(f14300e, str);
            jSONObject.put(f14301f, str2);
            jSONObject.put(f14303h, str3);
            jSONObject.put(f14305j, str4);
            jSONObject.put(f14306k, num);
            jSONObject.put(f14307l, str5);
            jSONObject.put(f14308m, str6);
            jSONObject.put(q, f2);
            jSONObject.put(n, f3);
            jSONObject.put(s, num2);
            jSONObject.put(t, num3);
            jSONObject.put(u, num4);
            jSONObject.put(r, num5);
            Result.m106constructorimpl(jSONObject.put(v, num6));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(h.r0.a(th));
        }
        ThinkingAnalyticsSDK thinkingAnalyticsSDK = D;
        Objects.requireNonNull(thinkingAnalyticsSDK);
        thinkingAnalyticsSDK.track("visit_card", jSONObject);
    }

    public final void k(@k.e.a.e String str, @k.e.a.e String str2, @k.e.a.e String str3, @k.e.a.e String str4, @k.e.a.e String str5, @k.e.a.e Integer num) {
        JSONObject jSONObject = new JSONObject();
        try {
            Result.a aVar = Result.Companion;
            jSONObject.put(f14300e, str);
            jSONObject.put(f14301f, str2);
            jSONObject.put(f14303h, str3);
            jSONObject.put(f14304i, str4);
            jSONObject.put(o, str5);
            Result.m106constructorimpl(jSONObject.put(p, num));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(h.r0.a(th));
        }
        ThinkingAnalyticsSDK thinkingAnalyticsSDK = D;
        Objects.requireNonNull(thinkingAnalyticsSDK);
        thinkingAnalyticsSDK.track("visit_series_card_list", jSONObject);
    }

    public final void l(@k.e.a.e String str, @k.e.a.e String str2, @k.e.a.e String str3, @k.e.a.e String str4, @k.e.a.e String str5, @k.e.a.e Integer num, @k.e.a.e Float f2, @k.e.a.e Integer num2, @k.e.a.e Integer num3, @k.e.a.e Integer num4, @k.e.a.e Integer num5) {
        JSONObject jSONObject = new JSONObject();
        try {
            Result.a aVar = Result.Companion;
            jSONObject.put(f14300e, str);
            jSONObject.put(f14301f, str2);
            jSONObject.put(f14303h, str3);
            jSONObject.put(f14304i, str4);
            jSONObject.put(o, str5);
            jSONObject.put(p, num);
            jSONObject.put(q, f2);
            jSONObject.put(s, num2);
            jSONObject.put(u, num3);
            jSONObject.put(r, num4);
            Result.m106constructorimpl(jSONObject.put(v, num5));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(h.r0.a(th));
        }
        ThinkingAnalyticsSDK thinkingAnalyticsSDK = D;
        Objects.requireNonNull(thinkingAnalyticsSDK);
        thinkingAnalyticsSDK.track("visit_series", jSONObject);
    }
}

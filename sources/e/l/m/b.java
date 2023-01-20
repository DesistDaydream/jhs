package e.l.m;

import com.jihuanshe.R;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.ReasonResult;
import com.vector.util.Res;
import e.l.r.f0;
import e.t.u.t;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class b extends a {
    @d

    /* renamed from: c */
    public static final b f14084c = new b();
    @d

    /* renamed from: d */
    private static final String f14085d = "CacheKV";
    @d

    /* renamed from: e */
    public static final String f14086e = "search_history";
    @d

    /* renamed from: f */
    public static final String f14087f = "game_list";
    @d

    /* renamed from: g */
    public static final String f14088g = "choose_game";
    @d

    /* renamed from: h */
    public static final String f14089h = "app_version";
    @d

    /* renamed from: i */
    public static final String f14090i = "report_reason";
    @d

    /* renamed from: j */
    public static final String f14091j = "im_notice_close_time";
    @d

    /* renamed from: k */
    public static final String f14092k = "ware_notice_close_time";

    private b() {
    }

    private final void A(long j2) {
        f().encode("app_version", j2);
    }

    private final long s() {
        return f().decodeLong("app_version", 0L);
    }

    public final void B(@d List<Game> list) {
        f().encode(f14087f, f0.a.d(list));
    }

    public final void C() {
        f().encode(f14091j, System.currentTimeMillis());
    }

    public final void D(@d ReasonResult reasonResult) {
        f().encode(f14090i, f0.a.d(reasonResult));
    }

    public final void E(@d String str, @d List<String> list) {
        f().encode(h.k2.v.f0.C(f14086e, str), f0.a.d(list));
    }

    public final void F() {
        f().encode(f14092k, System.currentTimeMillis());
    }

    @Override // e.l.m.a
    @d
    public String c() {
        return "cache";
    }

    @Override // e.l.m.a
    public boolean j() {
        return true;
    }

    @Override // e.l.m.a
    public boolean p() {
        return false;
    }

    public final void q(@d String str) {
        f().remove(h.k2.v.f0.C(f14086e, str));
    }

    @e
    public final String r() {
        return f().decodeString(f14088g);
    }

    @d
    public final List<Game> t() {
        String decodeString = f().decodeString(f14087f);
        if (decodeString == null || decodeString.length() == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        return f0.a.b(decodeString, Game.class);
    }

    @d
    public final ReasonResult u() {
        String decodeString = f().decodeString(f14090i);
        if (decodeString == null || decodeString.length() == 0) {
            Res res = Res.a;
            List P = CollectionsKt__CollectionsKt.P(Res.w(res, R.string.report_reason_ad, null, 2, null), Res.w(res, R.string.report_reason_unkind, null, 2, null), Res.w(res, R.string.report_reason_tort, null, 2, null), Res.w(res, R.string.report_reason_sex, null, 2, null), Res.w(res, R.string.report_reason_country, null, 2, null), Res.w(res, R.string.report_reason_blood, null, 2, null), Res.w(res, R.string.report_reason_guilt, null, 2, null), Res.w(res, R.string.report_reason_gamble, null, 2, null), Res.w(res, R.string.report_reason_other, null, 2, null));
            Constants.Companion companion = Constants.Companion;
            return new ReasonResult(P, companion.getERROR_CORRECTION(), companion.getREPORT_SELLER_REASON());
        }
        return (ReasonResult) f0.a.a().n(decodeString, ReasonResult.class);
    }

    @d
    public final List<String> v(@d String str) {
        String decodeString = f().decodeString(h.k2.v.f0.C(f14086e, str));
        if (decodeString == null || decodeString.length() == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        return f0.a.b(decodeString, String.class);
    }

    public final void w() {
        long d2 = t.a.d();
        long s = s();
        if (s < d2) {
            A(d2);
            if (d2 < 2000000 || s >= 2000000) {
                return;
            }
            e.l.h.k.b.a.a(f14085d, "clear game list cache.");
            f().remove(f14087f);
        }
    }

    public final boolean x() {
        return System.currentTimeMillis() - f().decodeLong(f14091j) > 259200000;
    }

    public final boolean y() {
        return System.currentTimeMillis() - f().decodeLong(f14092k, 0L) > 259200000;
    }

    public final void z(@e String str) {
        f().encode(f14088g, str);
    }
}

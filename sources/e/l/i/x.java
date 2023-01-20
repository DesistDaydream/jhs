package e.l.i;

import android.view.View;
import androidx.annotation.IdRes;
import androidx.databinding.BindingAdapter;
import com.jihuanshe.ui.widget.RankIndicatorView;
import com.vector.view.pager.ViewPager;
import h.t1;
import java.util.List;

/* loaded from: classes2.dex */
public final class x {
    @k.e.a.d
    public static final x a = new x();
    @k.e.a.d
    private static final String b = "android:rankIndicatorView_data";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12219c = "android:rankIndicatorView_badge";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12220d = "android:rankIndicatorView_viewPager";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f12221e = "android:rankIndicatorView_textSize";
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final String f12222f = "android:rankIndicatorView_selectTextSize";
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final String f12223g = "android:rankIndicatorView_lineWidth";
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private static final String f12224h = "android:rankIndicatorView_lineHeight";
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    private static final String f12225i = "android:rankIndicatorView_lineColor";
    @k.e.a.d

    /* renamed from: j  reason: collision with root package name */
    private static final String f12226j = "android:rankIndicatorView_roundRadius";
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    private static final String f12227k = "android:rankIndicatorView_slideZoom";
    @k.e.a.d

    /* renamed from: l  reason: collision with root package name */
    private static final String f12228l = "android:rankIndicatorView_normalTextColor";
    @k.e.a.d

    /* renamed from: m  reason: collision with root package name */
    private static final String f12229m = "android:rankIndicatorView_selectTextColor";
    @k.e.a.d
    private static final String n = "android:rankIndicatorView_yOffset";
    @k.e.a.d
    private static final String o = "android:rankIndicatorView_xOffset";
    @k.e.a.d
    private static final String p = "android:rankIndicatorView_isAdjustMode";
    @k.e.a.d
    private static final String q = "android:rankIndicatorView_isUnselectedBold";
    @k.e.a.d
    private static final String r = "android:rankIndicatorView_badgeRes";
    @k.e.a.d
    private static final String s = "android:rankIndicatorView_badgeIsSelect";
    @k.e.a.d
    private static final String t = "android:rankIndicatorView_repeatClick";
    @k.e.a.d
    private static final String u = "android:rankIndicatorView_listener";
    @k.e.a.d
    private static final String v = "android:rankIndicatorView_drawableTintId";

    private x() {
    }

    @BindingAdapter(requireAll = false, value = {f12220d, f12223g, f12224h, f12221e, f12222f, f12219c, f12225i, f12226j, f12227k, f12228l, f12229m, n, o, p, q, r, s, t})
    @h.k2.k
    public static final void a(@k.e.a.d RankIndicatorView rankIndicatorView, @IdRes int i2, @k.e.a.e Integer num, @k.e.a.e Integer num2, @k.e.a.e Integer num3, @k.e.a.e Integer num4, @k.e.a.e List<String> list, @k.e.a.e Integer num5, @k.e.a.e Integer num6, @k.e.a.e Boolean bool, @k.e.a.e Integer num7, @k.e.a.e Integer num8, @k.e.a.e Integer num9, @k.e.a.e Integer num10, @k.e.a.e Boolean bool2, @k.e.a.e Boolean bool3, @k.e.a.e List<Integer> list2, @k.e.a.e List<Boolean> list3, @k.e.a.e e.t.j.h.g gVar) {
        rankIndicatorView.setBadge(list);
        if (num != null) {
            rankIndicatorView.setLineWidth(num.intValue());
        }
        if (num2 != null) {
            rankIndicatorView.setLineHeight(num2.intValue());
        }
        if (num3 != null) {
            rankIndicatorView.setNormalTextSize(num3.intValue());
        }
        if (num4 != null) {
            rankIndicatorView.setSelectTextSize(num4.intValue());
        }
        if (num5 != null) {
            rankIndicatorView.setLineColor(num5.intValue());
        }
        if (num7 != null) {
            rankIndicatorView.setNormalTextColor(num7.intValue());
        }
        if (num8 != null) {
            rankIndicatorView.setSelectTextColor(num8.intValue());
        }
        if (num6 != null) {
            rankIndicatorView.setRoundRadius(num6.intValue());
        }
        if (bool != null) {
            rankIndicatorView.setSlideZoom(bool.booleanValue());
        }
        if (num9 != null) {
            rankIndicatorView.setYOffset(num9.intValue());
        }
        if (num10 != null) {
            rankIndicatorView.setXOffset(num10.intValue());
        }
        if (bool2 != null) {
            rankIndicatorView.setAdjustMode(bool2.booleanValue());
        }
        if (bool3 != null) {
            rankIndicatorView.setUnSelectedBold(bool3.booleanValue());
        }
        if (list2 != null) {
            rankIndicatorView.setBadgeImgRes(list2);
        }
        if (list3 != null) {
            rankIndicatorView.setBadgeIsSelect(list3);
        }
        if (gVar != null) {
            rankIndicatorView.setClickOnRepeat(gVar.a());
        }
        View findViewById = rankIndicatorView.getRootView().findViewById(i2);
        if (!(findViewById instanceof ViewPager) || h.k2.v.f0.g(findViewById, rankIndicatorView.getViewPager())) {
            return;
        }
        rankIndicatorView.setViewPager((ViewPager) findViewById);
    }

    @BindingAdapter({b, u})
    @h.k2.k
    public static final void b(@k.e.a.d RankIndicatorView rankIndicatorView, @k.e.a.e List<? extends Object> list, @k.e.a.e h.k2.u.l<? super Integer, t1> lVar) {
        if (list != null) {
            rankIndicatorView.setData(list);
        }
        if (lVar == null) {
            return;
        }
        rankIndicatorView.setListener(lVar);
    }

    @BindingAdapter({v})
    @h.k2.k
    public static final void d(@k.e.a.d RankIndicatorView rankIndicatorView, int i2) {
        rankIndicatorView.setDrawableTintId(Integer.valueOf(i2));
    }
}

package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.ui.widget.MIndicatorView;
import h.t1;
import java.util.List;

/* loaded from: classes2.dex */
public final class r {
    @k.e.a.d
    public static final r a = new r();
    @k.e.a.d
    private static final String b = "android:indicator_data";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12197c = "android:indicator_listener";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12198d = "android:indicator_badge";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f12199e = "android:indicator_textSize";
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final String f12200f = "android:indicator_selectTextSize";
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final String f12201g = "android:indicator_lineWidth";
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private static final String f12202h = "android:indicator_lineHeight";
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    private static final String f12203i = "android:indicator_lineColor";
    @k.e.a.d

    /* renamed from: j  reason: collision with root package name */
    private static final String f12204j = "android:indicator_roundRadius";
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    private static final String f12205k = "android:indicator_slideZoom";
    @k.e.a.d

    /* renamed from: l  reason: collision with root package name */
    private static final String f12206l = "android:indicator_normalTextColor";
    @k.e.a.d

    /* renamed from: m  reason: collision with root package name */
    private static final String f12207m = "android:indicator_selectTextColor";
    @k.e.a.d
    private static final String n = "android:indicator_yOffset";
    @k.e.a.d
    private static final String o = "android:indicator_xOffset";
    @k.e.a.d
    private static final String p = "android:indicator_isAdjustMode";
    @k.e.a.d
    private static final String q = "android:indicator_isUnselectedBold";
    @k.e.a.d
    private static final String r = "android:indicator_badgeRes";
    @k.e.a.d
    private static final String s = "android:indicator_badgeIsSelect";
    @k.e.a.d
    private static final String t = "android:indicator_repeatClick";

    private r() {
    }

    @BindingAdapter(requireAll = false, value = {f12201g, f12202h, f12199e, f12200f, f12198d, f12203i, f12204j, f12205k, f12206l, f12207m, n, o, p, q, r, s, t})
    @h.k2.k
    public static final void a(@k.e.a.d MIndicatorView mIndicatorView, @k.e.a.e Integer num, @k.e.a.e Integer num2, @k.e.a.e Integer num3, @k.e.a.e Integer num4, @k.e.a.e List<String> list, @k.e.a.e Integer num5, @k.e.a.e Integer num6, @k.e.a.e Boolean bool, @k.e.a.e Integer num7, @k.e.a.e Integer num8, @k.e.a.e Integer num9, @k.e.a.e Integer num10, @k.e.a.e Boolean bool2, @k.e.a.e Boolean bool3, @k.e.a.e List<Integer> list2, @k.e.a.e List<Boolean> list3, @k.e.a.e e.t.j.h.g gVar) {
        mIndicatorView.setBadge(list);
        if (num != null) {
            mIndicatorView.setLineWidth(num.intValue());
        }
        if (num2 != null) {
            mIndicatorView.setLineHeight(num2.intValue());
        }
        if (num3 != null) {
            mIndicatorView.setNormalTextSize(num3.intValue());
        }
        if (num4 != null) {
            mIndicatorView.setSelectTextSize(num4.intValue());
        }
        if (num5 != null) {
            mIndicatorView.setLineColor(num5.intValue());
        }
        if (num7 != null) {
            mIndicatorView.setNormalTextColor(num7.intValue());
        }
        if (num8 != null) {
            mIndicatorView.setSelectTextColor(num8.intValue());
        }
        if (num6 != null) {
            mIndicatorView.setRoundRadius(num6.intValue());
        }
        if (bool != null) {
            mIndicatorView.setSlideZoom(bool.booleanValue());
        }
        if (num9 != null) {
            mIndicatorView.setYOffset(num9.intValue());
        }
        if (num10 != null) {
            mIndicatorView.setXOffset(num10.intValue());
        }
        if (bool2 != null) {
            mIndicatorView.setAdjustMode(bool2.booleanValue());
        }
        if (bool3 != null) {
            mIndicatorView.setUnSelectedBold(bool3.booleanValue());
        }
        if (list2 != null) {
            mIndicatorView.setBadgeImgRes(list2);
        }
        if (list3 != null) {
            mIndicatorView.setBadgeIsSelect(list3);
        }
        if (gVar != null) {
            mIndicatorView.setClickOnRepeat(gVar.a());
        }
        mIndicatorView.d();
    }

    @BindingAdapter({b, f12197c})
    @h.k2.k
    public static final void b(@k.e.a.d MIndicatorView mIndicatorView, @k.e.a.e List<String> list, @k.e.a.e h.k2.u.l<? super Integer, t1> lVar) {
        mIndicatorView.scrollTo(0, 0);
        mIndicatorView.setData(list);
        mIndicatorView.setListener(lVar);
    }
}

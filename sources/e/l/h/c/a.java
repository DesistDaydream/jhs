package e.l.h.c;

import android.view.View;
import androidx.annotation.IdRes;
import androidx.databinding.BindingAdapter;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.vector.view.pager.ViewPager;
import e.j.a.b.c.r.c0;
import e.t.j.h.g;
import h.k2.k;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J¬\u0002\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001d2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010'2\u0012\b\u0002\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010#2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010#2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012+\b\u0002\u00102\u001a%\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0019\u0018\u000103j\u0004\u0018\u0001`7H\u0007¢\u0006\u0002\u00108J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010#H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/jihuanshe/base/binding/SlideIndicatorViewBinding;", "", "()V", "BADGE", "", "BADGE_IS_SELECTED", "BADGE_RES", "DATA", "IS_ADJUST_MODE", "IS_UNSELECTED_BOLD", "LINE_COLOR", "LINE_HEIGHT", "LINE_WIDTH", "LISTENER", "NORMAL_TEXT_COLOR", "NORMAL_TEXT_SIZE", "REPEAT_CLICK", "ROUND_RADIUS", "SELECT_TEXT_COLOR", "SELECT_TEXT_SIZE", "SLIDE_ZOOM", "VIEW_PAGER", "X_OFFSET", "Y_OFFSET", "setData", "", "view", "Lcom/jihuanshe/base/ui/widget/SlideIndicatorView;", "id", "", "lineWidth", "lineHeight", "normalTextSize", "selectTextSize", "badge", "", "lineColor", "roundRadius", "slideZoom", "", "normalTextColor", "selectTextColor", "yOffset", "xOffset", "isAdjustMode", "isUnselectedBold", "badgeRes", "badgeIsSelect", "repeatClick", "Lcom/vector/databinding/onBind/OnClickBinding;", c0.a.a, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "pos", "Lcom/jihuanshe/base/ui/widget/onChoose;", "(Lcom/jihuanshe/base/ui/widget/SlideIndicatorView;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lcom/vector/databinding/onBind/OnClickBinding;Lkotlin/jvm/functions/Function1;)V", "data", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class a {
    @d
    public static final a a = new a();
    @d
    private static final String b = "android:slideIndicatorView_data";
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12073c = "android:slideIndicatorView_badge";
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12074d = "android:slideIndicatorView_viewPager";
    @d

    /* renamed from: e  reason: collision with root package name */
    private static final String f12075e = "android:slideIndicatorView_textSize";
    @d

    /* renamed from: f  reason: collision with root package name */
    private static final String f12076f = "android:slideIndicatorView_selectTextSize";
    @d

    /* renamed from: g  reason: collision with root package name */
    private static final String f12077g = "android:slideIndicatorView_lineWidth";
    @d

    /* renamed from: h  reason: collision with root package name */
    private static final String f12078h = "android:slideIndicatorView_lineHeight";
    @d

    /* renamed from: i  reason: collision with root package name */
    private static final String f12079i = "android:slideIndicatorView_lineColor";
    @d

    /* renamed from: j  reason: collision with root package name */
    private static final String f12080j = "android:slideIndicatorView_roundRadius";
    @d

    /* renamed from: k  reason: collision with root package name */
    private static final String f12081k = "android:slideIndicatorView_slideZoom";
    @d

    /* renamed from: l  reason: collision with root package name */
    private static final String f12082l = "android:slideIndicatorView_normalTextColor";
    @d

    /* renamed from: m  reason: collision with root package name */
    private static final String f12083m = "android:slideIndicatorView_selectTextColor";
    @d
    private static final String n = "android:slideIndicatorView_yOffset";
    @d
    private static final String o = "android:slideIndicatorView_xOffset";
    @d
    private static final String p = "android:slideIndicatorView_isAdjustMode";
    @d
    private static final String q = "android:slideIndicatorView_isUnselectedBold";
    @d
    private static final String r = "android:slideIndicatorView_badgeRes";
    @d
    private static final String s = "android:slideIndicatorView_badgeIsSelect";
    @d
    private static final String t = "android:slideIndicatorView_repeatClick";
    @d
    private static final String u = "android:slideIndicatorView_listener";

    private a() {
    }

    @BindingAdapter(requireAll = false, value = {f12074d, f12077g, f12078h, f12075e, f12076f, f12073c, f12079i, f12080j, f12081k, f12082l, f12083m, n, o, p, q, r, s, t, u})
    @k
    public static final void a(@d SlideIndicatorView slideIndicatorView, @IdRes int i2, @e Integer num, @e Integer num2, @e Integer num3, @e Integer num4, @e List<String> list, @e Integer num5, @e Integer num6, @e Boolean bool, @e Integer num7, @e Integer num8, @e Integer num9, @e Integer num10, @e Boolean bool2, @e Boolean bool3, @e List<Integer> list2, @e List<Boolean> list3, @e g gVar, @e l<? super Integer, t1> lVar) {
        slideIndicatorView.setBadge(list);
        if (num != null) {
            slideIndicatorView.setLineWidth(num.intValue());
        }
        if (num2 != null) {
            slideIndicatorView.setLineHeight(num2.intValue());
        }
        if (num3 != null) {
            slideIndicatorView.setNormalTextSize(num3.intValue());
        }
        if (num4 != null) {
            slideIndicatorView.setSelectTextSize(num4.intValue());
        }
        if (num5 != null) {
            slideIndicatorView.setLineColor(num5.intValue());
        }
        if (num7 != null) {
            slideIndicatorView.setNormalTextColor(num7.intValue());
        }
        if (num8 != null) {
            slideIndicatorView.setSelectTextColor(num8.intValue());
        }
        if (num6 != null) {
            slideIndicatorView.setRoundRadius(num6.intValue());
        }
        if (bool != null) {
            slideIndicatorView.setSlideZoom(bool.booleanValue());
        }
        if (num9 != null) {
            slideIndicatorView.setYOffset(num9.intValue());
        }
        if (num10 != null) {
            slideIndicatorView.setXOffset(num10.intValue());
        }
        if (bool2 != null) {
            slideIndicatorView.setAdjustMode(bool2.booleanValue());
        }
        if (bool3 != null) {
            slideIndicatorView.setUnSelectedBold(bool3.booleanValue());
        }
        if (list2 != null) {
            slideIndicatorView.setBadgeImgRes(list2);
        }
        if (list3 != null) {
            slideIndicatorView.setBadgeIsSelect(list3);
        }
        if (gVar != null) {
            slideIndicatorView.setClickOnRepeat(gVar.a());
        }
        slideIndicatorView.setListener(lVar);
        View findViewById = slideIndicatorView.getRootView().findViewById(i2);
        if (!(findViewById instanceof ViewPager) || f0.g(findViewById, slideIndicatorView.getViewPager())) {
            return;
        }
        slideIndicatorView.setViewPager((ViewPager) findViewById);
    }

    @BindingAdapter({b})
    @k
    public static final void b(@d SlideIndicatorView slideIndicatorView, @e List<? extends Object> list) {
        if (list == null) {
            return;
        }
        slideIndicatorView.setData(list);
    }
}

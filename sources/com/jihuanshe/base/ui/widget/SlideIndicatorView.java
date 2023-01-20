package com.jihuanshe.base.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.AnyRes;
import com.jihuanshe.base.magicindicator.MagicIndicator;
import com.jihuanshe.base.magicindicator.commonnavigator.CommonNavigator;
import com.jihuanshe.base.magicindicator.commonnavigator.indicators.LinePagerIndicator;
import com.jihuanshe.base.magicindicator.commonnavigator.titles.SimplePagerTitleView;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.vector.util.Res;
import com.vector.view.pager.ViewPager;
import e.j.a.b.c.r.c0;
import e.l.h.h.g.a.c;
import e.t.o.d;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010`\u001a\u00020\u00132\b\b\u0001\u0010a\u001a\u00020\u000fH\u0002R4\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR8\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\b2\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR4\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR7\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\u001a\u0010(\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001a\u0010.\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u001a\u00100\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R$\u00102\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R=\u0010@\u001a%\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0018j\u0004\u0018\u0001`BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001f\"\u0004\bD\u0010!R$\u0010E\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00104\"\u0004\bG\u00106R\u001a\u0010H\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010:\"\u0004\bJ\u0010<R\u001a\u0010K\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010:\"\u0004\bM\u0010<R$\u0010N\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u00104\"\u0004\bP\u00106R\u001a\u0010Q\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010:\"\u0004\bS\u0010<R(\u0010U\u001a\u0004\u0018\u00010T2\b\u0010\u0007\u001a\u0004\u0018\u00010T@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010Z\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00104\"\u0004\b\\\u00106R\u001a\u0010]\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010:\"\u0004\b_\u0010<¨\u0006b"}, d2 = {"Lcom/jihuanshe/base/ui/widget/SlideIndicatorView;", "Lcom/jihuanshe/base/magicindicator/MagicIndicator;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "", "badge", "getBadge", "()Ljava/util/List;", "setBadge", "(Ljava/util/List;)V", "", "badgeImgRes", "getBadgeImgRes", "setBadgeImgRes", "", "badgeIsSelect", "getBadgeIsSelect", "setBadgeIsSelect", "clickOnRepeat", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getClickOnRepeat", "()Lkotlin/jvm/functions/Function1;", "setClickOnRepeat", "(Lkotlin/jvm/functions/Function1;)V", "commonNavigator", "Lcom/jihuanshe/base/magicindicator/commonnavigator/CommonNavigator;", "", "data", "getData", "setData", "isAdjustMode", "()Z", "setAdjustMode", "(Z)V", "isSelectBold", "setSelectBold", "isSlideZoom", "setSlideZoom", "isUnSelectedBold", "setUnSelectedBold", "lineColor", "getLineColor", "()I", "setLineColor", "(I)V", "lineHeight", "", "getLineHeight", "()F", "setLineHeight", "(F)V", "lineWidth", "getLineWidth", "setLineWidth", c0.a.a, "pos", "Lcom/jihuanshe/base/ui/widget/onChoose;", "getListener", "setListener", "normalTextColor", "getNormalTextColor", "setNormalTextColor", "normalTextSize", "getNormalTextSize", "setNormalTextSize", "roundRadius", "getRoundRadius", "setRoundRadius", "selectTextColor", "getSelectTextColor", "setSelectTextColor", "selectTextSize", "getSelectTextSize", "setSelectTextSize", "Lcom/vector/view/pager/ViewPager;", "viewPager", "getViewPager", "()Lcom/vector/view/pager/ViewPager;", "setViewPager", "(Lcom/vector/view/pager/ViewPager;)V", "xOffset", "getXOffset", "setXOffset", "yOffset", "getYOffset", "setYOffset", "isDrawable", "id", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class SlideIndicatorView extends MagicIndicator {
    @e
    private l<? super Integer, t1> b;
    @e

    /* renamed from: c */
    private List<? extends Object> f3876c;
    @e

    /* renamed from: d */
    private List<String> f3877d;
    @e

    /* renamed from: e */
    private List<Integer> f3878e;
    @e

    /* renamed from: f */
    private List<Boolean> f3879f;
    @e

    /* renamed from: g */
    private l<? super View, t1> f3880g;

    /* renamed from: h */
    private float f3881h;

    /* renamed from: i */
    private float f3882i;

    /* renamed from: j */
    private float f3883j;

    /* renamed from: k */
    private int f3884k;

    /* renamed from: l */
    private int f3885l;

    /* renamed from: m */
    private int f3886m;
    private float n;
    private float o;
    private boolean p;
    private boolean q;
    private float r;
    private int s;
    private boolean t;
    private boolean u;
    @e
    private CommonNavigator v;
    @e
    private ViewPager w;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"com/jihuanshe/base/ui/widget/SlideIndicatorView$viewPager$1", "Lcom/jihuanshe/base/magicindicator/commonnavigator/abs/CommonNavigatorAdapter;", "getCount", "", "getCurrentItem", "getIndicator", "Lcom/jihuanshe/base/magicindicator/commonnavigator/abs/IPagerIndicator;", "context", "Landroid/content/Context;", "getTitleView", "Lcom/jihuanshe/base/magicindicator/commonnavigator/abs/IPagerTitleView;", "index", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class a extends e.l.h.h.g.a.a {
        public a() {
            SlideIndicatorView.this = r1;
        }

        public static final void j(SlideIndicatorView slideIndicatorView, int i2, View view) {
            l<Integer, t1> listener = slideIndicatorView.getListener();
            if (listener != null) {
                listener.invoke(Integer.valueOf(i2));
            }
            ViewPager viewPager = slideIndicatorView.getViewPager();
            boolean z = false;
            if (viewPager != null && viewPager.getCurrentItem() == i2) {
                z = true;
            }
            if (z) {
                l<View, t1> clickOnRepeat = slideIndicatorView.getClickOnRepeat();
                if (clickOnRepeat == null) {
                    return;
                }
                clickOnRepeat.invoke(slideIndicatorView);
                return;
            }
            ViewPager viewPager2 = slideIndicatorView.getViewPager();
            if (viewPager2 == null) {
                return;
            }
            viewPager2.setCurrentItem(i2);
        }

        @Override // e.l.h.h.g.a.a
        public int a() {
            List<Object> data = SlideIndicatorView.this.getData();
            if (data == null) {
                return 0;
            }
            return data.size();
        }

        @Override // e.l.h.h.g.a.a
        public int b() {
            ViewPager viewPager = SlideIndicatorView.this.getViewPager();
            if (viewPager == null) {
                return 0;
            }
            return viewPager.getCurrentItem();
        }

        @Override // e.l.h.h.g.a.a
        @d
        public c c(@d Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(2);
            d.a aVar = e.t.o.d.a;
            linePagerIndicator.setLineHeight(d.a.c(aVar, null, 1, null).c(SlideIndicatorView.this.getLineHeight()));
            linePagerIndicator.setLineWidth(d.a.c(aVar, null, 1, null).c(SlideIndicatorView.this.getLineWidth()));
            linePagerIndicator.setRoundRadius(d.a.c(aVar, null, 1, null).c(SlideIndicatorView.this.getRoundRadius()));
            linePagerIndicator.setColors(Integer.valueOf(SlideIndicatorView.this.getLineColor()));
            linePagerIndicator.setYOffset(d.a.c(aVar, null, 1, null).c(SlideIndicatorView.this.getYOffset()));
            linePagerIndicator.setXOffset(d.a.c(aVar, null, 1, null).d(SlideIndicatorView.this.getXOffset()));
            if (SlideIndicatorView.this.h()) {
                linePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
                linePagerIndicator.setEndInterpolator(new DecelerateInterpolator());
            }
            return linePagerIndicator;
        }

        @Override // e.l.h.h.g.a.a
        @k.e.a.d
        public e.l.h.h.g.a.d d(@k.e.a.d Context context, final int i2) {
            SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
            List<Object> data = SlideIndicatorView.this.getData();
            if (data != null) {
                SlideIndicatorView slideIndicatorView = SlideIndicatorView.this;
                Object obj = data.get(i2);
                if (obj instanceof Integer) {
                    Number number = (Number) obj;
                    if (slideIndicatorView.f(number.intValue())) {
                        simplePagerTitleView.setDrawable(number.intValue());
                    } else {
                        simplePagerTitleView.setText(Res.w(Res.a, number.intValue(), null, 2, null));
                    }
                } else if (obj instanceof CharSequence) {
                    simplePagerTitleView.setText((CharSequence) obj);
                }
            }
            simplePagerTitleView.setNormalColor(SlideIndicatorView.this.getNormalTextColor());
            simplePagerTitleView.f3856i = SlideIndicatorView.this.getXOffset();
            simplePagerTitleView.f3857j = SlideIndicatorView.this.getXOffset();
            simplePagerTitleView.f();
            simplePagerTitleView.setSelectedColor(SlideIndicatorView.this.getSelectTextColor());
            simplePagerTitleView.f3854g = SlideIndicatorView.this.g();
            simplePagerTitleView.f3855h = SlideIndicatorView.this.i();
            simplePagerTitleView.f3852e = SlideIndicatorView.this.getNormalTextSize();
            simplePagerTitleView.f3851d = SlideIndicatorView.this.getSelectTextSize();
            final SlideIndicatorView slideIndicatorView2 = SlideIndicatorView.this;
            simplePagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: e.l.h.j.b.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SlideIndicatorView.a.j(slideIndicatorView2, i2, view);
                }
            });
            return simplePagerTitleView;
        }
    }

    @h
    public SlideIndicatorView(@k.e.a.d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ SlideIndicatorView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public final boolean f(@AnyRes int i2) {
        try {
            return StringsKt__StringsKt.V2(getResources().getResourceTypeName(i2), "drawable", false, 2, null);
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean e() {
        return this.t;
    }

    public final boolean g() {
        return this.p;
    }

    @e
    public final List<String> getBadge() {
        return this.f3877d;
    }

    @e
    public final List<Integer> getBadgeImgRes() {
        return this.f3878e;
    }

    @e
    public final List<Boolean> getBadgeIsSelect() {
        return this.f3879f;
    }

    @e
    public final l<View, t1> getClickOnRepeat() {
        return this.f3880g;
    }

    @e
    public final List<Object> getData() {
        return this.f3876c;
    }

    public final int getLineColor() {
        return this.f3884k;
    }

    public final float getLineHeight() {
        return this.f3882i;
    }

    public final float getLineWidth() {
        return this.f3881h;
    }

    @e
    public final l<Integer, t1> getListener() {
        return this.b;
    }

    public final int getNormalTextColor() {
        return this.f3885l;
    }

    public final float getNormalTextSize() {
        return this.n;
    }

    public final float getRoundRadius() {
        return this.f3883j;
    }

    public final int getSelectTextColor() {
        return this.f3886m;
    }

    public final float getSelectTextSize() {
        return this.o;
    }

    @e
    public final ViewPager getViewPager() {
        return this.w;
    }

    public final int getXOffset() {
        return this.s;
    }

    public final float getYOffset() {
        return this.r;
    }

    public final boolean h() {
        return this.u;
    }

    public final boolean i() {
        return this.q;
    }

    public final void setAdjustMode(boolean z) {
        this.t = z;
    }

    public final void setBadge(@e List<String> list) {
        e.l.h.h.g.a.a adapter;
        this.f3877d = list;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setBadgeImgRes(@e List<Integer> list) {
        e.l.h.h.g.a.a adapter;
        this.f3878e = list;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setBadgeIsSelect(@e List<Boolean> list) {
        e.l.h.h.g.a.a adapter;
        this.f3879f = list;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setClickOnRepeat(@e l<? super View, t1> lVar) {
        this.f3880g = lVar;
    }

    public final void setData(@e List<? extends Object> list) {
        e.l.h.h.g.a.a adapter;
        this.f3876c = list;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setLineColor(int i2) {
        this.f3884k = i2;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null) {
            return;
        }
        commonNavigator.e();
    }

    public final void setLineHeight(float f2) {
        this.f3882i = f2;
    }

    public final void setLineWidth(float f2) {
        this.f3881h = f2;
    }

    public final void setListener(@e l<? super Integer, t1> lVar) {
        this.b = lVar;
    }

    public final void setNormalTextColor(int i2) {
        this.f3885l = i2;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null) {
            return;
        }
        commonNavigator.e();
    }

    public final void setNormalTextSize(float f2) {
        this.n = f2;
    }

    public final void setRoundRadius(float f2) {
        this.f3883j = f2;
    }

    public final void setSelectBold(boolean z) {
        this.p = z;
    }

    public final void setSelectTextColor(int i2) {
        this.f3886m = i2;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null) {
            return;
        }
        commonNavigator.e();
    }

    public final void setSelectTextSize(float f2) {
        this.o = f2;
    }

    public final void setSlideZoom(boolean z) {
        this.u = z;
    }

    public final void setUnSelectedBold(boolean z) {
        this.q = z;
    }

    public final void setViewPager(@e ViewPager viewPager) {
        this.w = viewPager;
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        this.v = commonNavigator;
        if (commonNavigator != null) {
            commonNavigator.setFollowTouch(false);
        }
        CommonNavigator commonNavigator2 = this.v;
        if (commonNavigator2 != null) {
            commonNavigator2.setEnablePivotScroll(true);
        }
        CommonNavigator commonNavigator3 = this.v;
        if (commonNavigator3 != null) {
            commonNavigator3.setSmoothScroll(true);
        }
        CommonNavigator commonNavigator4 = this.v;
        if (commonNavigator4 != null) {
            commonNavigator4.setScrollPivotX(0.3f);
        }
        CommonNavigator commonNavigator5 = this.v;
        if (commonNavigator5 != null) {
            commonNavigator5.setAdjustMode(this.t);
        }
        CommonNavigator commonNavigator6 = this.v;
        if (commonNavigator6 != null) {
            commonNavigator6.setAdapter(new a());
        }
        setNavigator(this.v);
        ViewPager viewPager2 = this.w;
        if (viewPager2 == null) {
            return;
        }
        viewPager2.addOnPageChangeListener(new SlideIndicatorView$viewPager$2(this));
    }

    public final void setXOffset(int i2) {
        this.s = i2;
    }

    public final void setYOffset(float f2) {
        this.r = f2;
    }

    @h
    public SlideIndicatorView(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3881h = 20.0f;
        this.f3882i = 3.0f;
        this.f3883j = 3.0f;
        this.f3884k = Color.parseColor("#000000");
        this.f3885l = Color.parseColor("#87888A");
        this.f3886m = Color.parseColor("#000000");
        this.n = 16.0f;
        this.p = true;
        this.s = 5;
        this.t = true;
    }
}

package com.jihuanshe.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.AnyRes;
import com.jihuanshe.base.magicindicator.MagicIndicator;
import com.jihuanshe.base.magicindicator.commonnavigator.CommonNavigator;
import com.jihuanshe.base.magicindicator.commonnavigator.titles.SimplePagerTitleView;
import com.jihuanshe.ui.widget.RankIndicatorView;
import com.vector.util.Res;
import com.vector.view.pager.ViewPager;
import e.l.h.h.g.a.c;
import e.t.o.d;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class RankIndicatorView extends MagicIndicator {
    @e
    private l<? super Integer, t1> b;
    @e

    /* renamed from: c */
    private List<? extends Object> f4173c;
    @e

    /* renamed from: d */
    private List<String> f4174d;
    @e

    /* renamed from: e */
    private List<Integer> f4175e;
    @e

    /* renamed from: f */
    private List<Boolean> f4176f;
    @e

    /* renamed from: g */
    private Integer f4177g;
    @e

    /* renamed from: h */
    private l<? super View, t1> f4178h;

    /* renamed from: i */
    private float f4179i;

    /* renamed from: j */
    private float f4180j;

    /* renamed from: k */
    private float f4181k;

    /* renamed from: l */
    private int f4182l;

    /* renamed from: m */
    private int f4183m;
    private int n;
    private float o;
    private float p;
    private boolean q;
    private boolean r;
    private float s;
    private int t;
    private boolean u;
    private boolean v;
    @e
    private CommonNavigator w;
    @e
    private ViewPager x;

    /* loaded from: classes2.dex */
    public static final class a extends e.l.h.h.g.a.a {
        public a() {
            RankIndicatorView.this = r1;
        }

        public static final void j(RankIndicatorView rankIndicatorView, int i2, View view) {
            l<Integer, t1> listener = rankIndicatorView.getListener();
            if (listener != null) {
                listener.invoke(Integer.valueOf(i2));
            }
            ViewPager viewPager = rankIndicatorView.getViewPager();
            boolean z = false;
            if (viewPager != null && viewPager.getCurrentItem() == i2) {
                z = true;
            }
            if (z) {
                l<View, t1> clickOnRepeat = rankIndicatorView.getClickOnRepeat();
                if (clickOnRepeat == null) {
                    return;
                }
                clickOnRepeat.invoke(rankIndicatorView);
                return;
            }
            ViewPager viewPager2 = rankIndicatorView.getViewPager();
            if (viewPager2 == null) {
                return;
            }
            viewPager2.setCurrentItem(i2);
        }

        @Override // e.l.h.h.g.a.a
        public int a() {
            List<Object> data = RankIndicatorView.this.getData();
            if (data == null) {
                return 0;
            }
            return data.size();
        }

        @Override // e.l.h.h.g.a.a
        public int b() {
            ViewPager viewPager = RankIndicatorView.this.getViewPager();
            if (viewPager == null) {
                return 0;
            }
            return viewPager.getCurrentItem();
        }

        @Override // e.l.h.h.g.a.a
        @d
        public c c(@d Context context) {
            RankPagerIndicator rankPagerIndicator = new RankPagerIndicator(context);
            rankPagerIndicator.setLineRectBottom(RankIndicatorView.this.getHeight());
            Integer drawableTintId = RankIndicatorView.this.getDrawableTintId();
            if (drawableTintId != null) {
                rankPagerIndicator.setDrawableTint(drawableTintId.intValue());
            }
            rankPagerIndicator.setXOffset(d.a.c(e.t.o.d.a, null, 1, null).d(RankIndicatorView.this.getXOffset()));
            if (RankIndicatorView.this.h()) {
                rankPagerIndicator.setStartInterpolator(new AccelerateInterpolator());
                rankPagerIndicator.setEndInterpolator(new DecelerateInterpolator());
            }
            return rankPagerIndicator;
        }

        @Override // e.l.h.h.g.a.a
        @k.e.a.d
        public e.l.h.h.g.a.d d(@k.e.a.d Context context, final int i2) {
            SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
            List<Object> data = RankIndicatorView.this.getData();
            if (data != null) {
                RankIndicatorView rankIndicatorView = RankIndicatorView.this;
                Object obj = data.get(i2);
                if (obj instanceof Integer) {
                    Number number = (Number) obj;
                    if (rankIndicatorView.f(number.intValue())) {
                        simplePagerTitleView.setDrawable(number.intValue());
                    } else {
                        simplePagerTitleView.setText(Res.w(Res.a, number.intValue(), null, 2, null));
                    }
                } else if (obj instanceof String) {
                    simplePagerTitleView.setText((CharSequence) obj);
                }
            }
            simplePagerTitleView.setNormalColor(RankIndicatorView.this.getNormalTextColor());
            simplePagerTitleView.f3856i = RankIndicatorView.this.getXOffset() * (i2 == 0 ? 2 : 1);
            int xOffset = RankIndicatorView.this.getXOffset();
            int i3 = i2 + 1;
            List<Object> data2 = RankIndicatorView.this.getData();
            boolean z = false;
            if (data2 != null && i3 == data2.size()) {
                z = true;
            }
            simplePagerTitleView.f3857j = xOffset * (z ? 2 : 1);
            simplePagerTitleView.f();
            simplePagerTitleView.setSelectedColor(RankIndicatorView.this.getSelectTextColor());
            simplePagerTitleView.f3854g = RankIndicatorView.this.g();
            simplePagerTitleView.f3855h = RankIndicatorView.this.i();
            simplePagerTitleView.f3852e = RankIndicatorView.this.getNormalTextSize();
            simplePagerTitleView.f3851d = RankIndicatorView.this.getSelectTextSize();
            final RankIndicatorView rankIndicatorView2 = RankIndicatorView.this;
            simplePagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RankIndicatorView.a.j(rankIndicatorView2, i2, view);
                }
            });
            return simplePagerTitleView;
        }
    }

    @h
    public RankIndicatorView(@k.e.a.d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ RankIndicatorView(Context context, AttributeSet attributeSet, int i2, u uVar) {
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
        return this.u;
    }

    public final boolean g() {
        return this.q;
    }

    @e
    public final List<String> getBadge() {
        return this.f4174d;
    }

    @e
    public final List<Integer> getBadgeImgRes() {
        return this.f4175e;
    }

    @e
    public final List<Boolean> getBadgeIsSelect() {
        return this.f4176f;
    }

    @e
    public final l<View, t1> getClickOnRepeat() {
        return this.f4178h;
    }

    @e
    public final List<Object> getData() {
        return this.f4173c;
    }

    @e
    public final Integer getDrawableTintId() {
        return this.f4177g;
    }

    public final int getLineColor() {
        return this.f4182l;
    }

    public final float getLineHeight() {
        return this.f4180j;
    }

    public final float getLineWidth() {
        return this.f4179i;
    }

    @e
    public final l<Integer, t1> getListener() {
        return this.b;
    }

    public final int getNormalTextColor() {
        return this.f4183m;
    }

    public final float getNormalTextSize() {
        return this.o;
    }

    public final float getRoundRadius() {
        return this.f4181k;
    }

    public final int getSelectTextColor() {
        return this.n;
    }

    public final float getSelectTextSize() {
        return this.p;
    }

    @e
    public final ViewPager getViewPager() {
        return this.x;
    }

    public final int getXOffset() {
        return this.t;
    }

    public final float getYOffset() {
        return this.s;
    }

    public final boolean h() {
        return this.v;
    }

    public final boolean i() {
        return this.r;
    }

    public final void setAdjustMode(boolean z) {
        this.u = z;
    }

    public final void setBadge(@e List<String> list) {
        e.l.h.h.g.a.a adapter;
        this.f4174d = list;
        CommonNavigator commonNavigator = this.w;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setBadgeImgRes(@e List<Integer> list) {
        e.l.h.h.g.a.a adapter;
        this.f4175e = list;
        CommonNavigator commonNavigator = this.w;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setBadgeIsSelect(@e List<Boolean> list) {
        e.l.h.h.g.a.a adapter;
        this.f4176f = list;
        CommonNavigator commonNavigator = this.w;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setClickOnRepeat(@e l<? super View, t1> lVar) {
        this.f4178h = lVar;
    }

    public final void setData(@e List<? extends Object> list) {
        e.l.h.h.g.a.a adapter;
        this.f4173c = list;
        CommonNavigator commonNavigator = this.w;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setDrawableTintId(@e Integer num) {
        e.l.h.h.g.a.a adapter;
        this.f4177g = num;
        CommonNavigator commonNavigator = this.w;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setLineColor(int i2) {
        this.f4182l = i2;
        CommonNavigator commonNavigator = this.w;
        if (commonNavigator == null) {
            return;
        }
        commonNavigator.e();
    }

    public final void setLineHeight(float f2) {
        this.f4180j = f2;
    }

    public final void setLineWidth(float f2) {
        this.f4179i = f2;
    }

    public final void setListener(@e l<? super Integer, t1> lVar) {
        this.b = lVar;
    }

    public final void setNormalTextColor(int i2) {
        this.f4183m = i2;
        CommonNavigator commonNavigator = this.w;
        if (commonNavigator == null) {
            return;
        }
        commonNavigator.e();
    }

    public final void setNormalTextSize(float f2) {
        this.o = f2;
    }

    public final void setRoundRadius(float f2) {
        this.f4181k = f2;
    }

    public final void setSelectBold(boolean z) {
        this.q = z;
    }

    public final void setSelectTextColor(int i2) {
        this.n = i2;
        CommonNavigator commonNavigator = this.w;
        if (commonNavigator == null) {
            return;
        }
        commonNavigator.e();
    }

    public final void setSelectTextSize(float f2) {
        this.p = f2;
    }

    public final void setSlideZoom(boolean z) {
        this.v = z;
    }

    public final void setUnSelectedBold(boolean z) {
        this.r = z;
    }

    public final void setViewPager(@e ViewPager viewPager) {
        this.x = viewPager;
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        this.w = commonNavigator;
        if (commonNavigator != null) {
            commonNavigator.setAdjustMode(this.u);
        }
        CommonNavigator commonNavigator2 = this.w;
        if (commonNavigator2 != null) {
            commonNavigator2.setAdapter(new a());
        }
        setNavigator(this.w);
        ViewPager viewPager2 = this.x;
        if (viewPager2 == null) {
            return;
        }
        viewPager2.addOnPageChangeListener(new RankIndicatorView$viewPager$2(this));
    }

    public final void setXOffset(int i2) {
        this.t = i2;
    }

    public final void setYOffset(float f2) {
        this.s = f2;
    }

    @h
    public RankIndicatorView(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4182l = Color.parseColor("#000000");
        this.f4183m = Color.parseColor("#87888A");
        this.n = Color.parseColor("#000000");
        this.o = 13.0f;
        this.p = 13.0f;
        this.q = true;
        this.t = 16;
    }
}

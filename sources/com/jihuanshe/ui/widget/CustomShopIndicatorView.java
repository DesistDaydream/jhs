package com.jihuanshe.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AnyRes;
import androidx.annotation.RequiresApi;
import androidx.core.widget.TextViewCompat;
import com.jihuanshe.R;
import com.jihuanshe.base.magicindicator.MagicIndicator;
import com.jihuanshe.base.magicindicator.commonnavigator.CommonNavigator;
import com.jihuanshe.base.magicindicator.commonnavigator.titles.SimplePagerTitleView;
import com.jihuanshe.model.Category;
import com.jihuanshe.model.Constants;
import com.jihuanshe.ui.widget.CustomShopIndicatorView;
import com.vector.util.Res;
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
public final class CustomShopIndicatorView extends MagicIndicator {
    @e
    private List<Category> b;
    @e

    /* renamed from: c */
    private l<? super Integer, t1> f4058c;
    @e

    /* renamed from: d */
    private List<String> f4059d;
    @e

    /* renamed from: e */
    private List<Integer> f4060e;
    @e

    /* renamed from: f */
    private List<Boolean> f4061f;
    @e

    /* renamed from: g */
    private l<? super View, t1> f4062g;

    /* renamed from: h */
    private float f4063h;

    /* renamed from: i */
    private float f4064i;

    /* renamed from: j */
    private float f4065j;

    /* renamed from: k */
    private int f4066k;

    /* renamed from: l */
    private int f4067l;

    /* renamed from: m */
    private int f4068m;
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
    private int w;

    /* loaded from: classes2.dex */
    public static final class a extends e.l.h.h.g.a.a {
        public a() {
            CustomShopIndicatorView.this = r1;
        }

        public static final void j(CustomShopIndicatorView customShopIndicatorView, int i2, View view) {
            c pagerIndicator;
            l<Integer, t1> listener = customShopIndicatorView.getListener();
            if (listener != null) {
                listener.invoke(Integer.valueOf(i2));
            }
            if (customShopIndicatorView.w != i2) {
                customShopIndicatorView.w = i2;
                CommonNavigator commonNavigator = customShopIndicatorView.v;
                if (commonNavigator != null && (pagerIndicator = commonNavigator.getPagerIndicator()) != null) {
                    pagerIndicator.onPageScrolled(i2, 0.0f, 0);
                }
                customShopIndicatorView.c(i2);
                return;
            }
            l<View, t1> clickOnRepeat = customShopIndicatorView.getClickOnRepeat();
            if (clickOnRepeat == null) {
                return;
            }
            clickOnRepeat.invoke(customShopIndicatorView);
        }

        public static /* synthetic */ void k(CustomShopIndicatorView customShopIndicatorView, int i2, View view) {
            j(customShopIndicatorView, i2, view);
        }

        @Override // e.l.h.h.g.a.a
        public int a() {
            List<Category> data = CustomShopIndicatorView.this.getData();
            if (data == null) {
                return 0;
            }
            return data.size();
        }

        @Override // e.l.h.h.g.a.a
        public int b() {
            return CustomShopIndicatorView.this.w;
        }

        @Override // e.l.h.h.g.a.a
        @d
        public c c(@d Context context) {
            ShopPagerIndicator shopPagerIndicator = new ShopPagerIndicator(context);
            shopPagerIndicator.setLineRectBottom(CustomShopIndicatorView.this.getHeight());
            shopPagerIndicator.setXOffset(d.a.c(e.t.o.d.a, null, 1, null).d(CustomShopIndicatorView.this.getXOffset()));
            return shopPagerIndicator;
        }

        @Override // e.l.h.h.g.a.a
        @RequiresApi(23)
        @k.e.a.d
        public e.l.h.h.g.a.d d(@k.e.a.d Context context, final int i2) {
            List<Category> data = CustomShopIndicatorView.this.getData();
            Category category = data == null ? null : data.get(i2);
            if (category.getId() != Constants.Companion.getCATEGORY_DIVIDER_ID()) {
                SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
                simplePagerTitleView.setText(category.getName());
                simplePagerTitleView.setNormalColor(CustomShopIndicatorView.this.getNormalTextColor());
                simplePagerTitleView.f3856i = CustomShopIndicatorView.this.getXOffset() * (i2 == 0 ? 2 : 1);
                int xOffset = CustomShopIndicatorView.this.getXOffset();
                int i3 = i2 + 1;
                List<Category> data2 = CustomShopIndicatorView.this.getData();
                simplePagerTitleView.f3857j = xOffset * (data2 != null && i3 == data2.size() ? 2 : 1);
                simplePagerTitleView.f();
                simplePagerTitleView.setSelectedColor(CustomShopIndicatorView.this.getSelectTextColor());
                simplePagerTitleView.f3854g = true;
                simplePagerTitleView.f3855h = true;
                simplePagerTitleView.f3852e = CustomShopIndicatorView.this.getNormalTextSize();
                simplePagerTitleView.f3851d = CustomShopIndicatorView.this.getSelectTextSize();
                final CustomShopIndicatorView customShopIndicatorView = CustomShopIndicatorView.this;
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CustomShopIndicatorView.a.k(CustomShopIndicatorView.this, i2, view);
                    }
                });
                if (i2 == 0) {
                    TextViewCompat.setCompoundDrawableTintList(simplePagerTitleView, ColorStateList.valueOf(Res.k(R.color.common_color)));
                    simplePagerTitleView.setCompoundDrawablePadding(d.a.c(e.t.o.d.a, null, 1, null).d(6));
                    simplePagerTitleView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.svg_home_bar_start, 0, 0, 0);
                    return simplePagerTitleView;
                }
                return simplePagerTitleView;
            }
            IndicatorDividerView indicatorDividerView = new IndicatorDividerView(context, null, 0, 6, null);
            CustomShopIndicatorView customShopIndicatorView2 = CustomShopIndicatorView.this;
            d.a aVar = e.t.o.d.a;
            indicatorDividerView.setPadding(d.a.c(aVar, null, 1, null).d(customShopIndicatorView2.getXOffset()), 0, d.a.c(aVar, null, 1, null).d(customShopIndicatorView2.getXOffset()), 0);
            return indicatorDividerView;
        }
    }

    @h
    public CustomShopIndicatorView(@k.e.a.d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ CustomShopIndicatorView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    private final boolean h(@AnyRes int i2) {
        try {
            return StringsKt__StringsKt.V2(getResources().getResourceTypeName(i2), "drawable", false, 2, null);
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean g() {
        return this.t;
    }

    @e
    public final List<String> getBadge() {
        return this.f4059d;
    }

    @e
    public final List<Integer> getBadgeImgRes() {
        return this.f4060e;
    }

    @e
    public final List<Boolean> getBadgeIsSelect() {
        return this.f4061f;
    }

    @e
    public final l<View, t1> getClickOnRepeat() {
        return this.f4062g;
    }

    @e
    public final List<Category> getData() {
        return this.b;
    }

    public final int getLineColor() {
        return this.f4066k;
    }

    public final float getLineHeight() {
        return this.f4064i;
    }

    public final float getLineWidth() {
        return this.f4063h;
    }

    @e
    public final l<Integer, t1> getListener() {
        return this.f4058c;
    }

    public final int getNormalTextColor() {
        return this.f4067l;
    }

    public final float getNormalTextSize() {
        return this.n;
    }

    public final float getRoundRadius() {
        return this.f4065j;
    }

    public final int getSelectTextColor() {
        return this.f4068m;
    }

    public final float getSelectTextSize() {
        return this.o;
    }

    public final int getXOffset() {
        return this.s;
    }

    public final float getYOffset() {
        return this.r;
    }

    public final boolean i() {
        return this.p;
    }

    public final boolean j() {
        return this.u;
    }

    public final boolean k() {
        return this.q;
    }

    public final void setAdjustMode(boolean z) {
        this.t = z;
    }

    public final void setBadge(@e List<String> list) {
        e.l.h.h.g.a.a adapter;
        this.f4059d = list;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setBadgeImgRes(@e List<Integer> list) {
        e.l.h.h.g.a.a adapter;
        this.f4060e = list;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setBadgeIsSelect(@e List<Boolean> list) {
        e.l.h.h.g.a.a adapter;
        this.f4061f = list;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setClickOnRepeat(@e l<? super View, t1> lVar) {
        this.f4062g = lVar;
    }

    public final void setData(@e List<Category> list) {
        e.l.h.h.g.a.a adapter;
        this.b = list;
        this.w = 0;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setLineColor(int i2) {
        this.f4066k = i2;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null) {
            return;
        }
        commonNavigator.e();
    }

    public final void setLineHeight(float f2) {
        this.f4064i = f2;
    }

    public final void setLineWidth(float f2) {
        this.f4063h = f2;
    }

    public final void setListener(@e l<? super Integer, t1> lVar) {
        this.f4058c = lVar;
    }

    public final void setNormalTextColor(int i2) {
        this.f4067l = i2;
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
        this.f4065j = f2;
    }

    public final void setSelectBold(boolean z) {
        this.p = z;
    }

    public final void setSelectTextColor(int i2) {
        this.f4068m = i2;
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

    public final void setXOffset(int i2) {
        this.s = i2;
    }

    public final void setYOffset(float f2) {
        this.r = f2;
    }

    @h
    public CustomShopIndicatorView(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4063h = 20.0f;
        this.f4064i = 3.0f;
        this.f4065j = 3.0f;
        this.f4066k = Color.parseColor("#000000");
        this.f4067l = Color.parseColor("#333333");
        this.f4068m = Color.parseColor("#000000");
        this.n = 12.0f;
        this.o = 12.0f;
        this.p = true;
        this.s = 16;
        this.u = true;
        CommonNavigator commonNavigator = new CommonNavigator(context);
        this.v = commonNavigator;
        if (commonNavigator != null) {
            commonNavigator.setFollowTouch(false);
        }
        CommonNavigator commonNavigator2 = this.v;
        if (commonNavigator2 != null) {
            commonNavigator2.setAdjustMode(this.t);
        }
        CommonNavigator commonNavigator3 = this.v;
        if (commonNavigator3 != null) {
            commonNavigator3.setSmoothScroll(true);
        }
        CommonNavigator commonNavigator4 = this.v;
        if (commonNavigator4 != null) {
            commonNavigator4.setEnablePivotScroll(true);
        }
        CommonNavigator commonNavigator5 = this.v;
        if (commonNavigator5 != null) {
            commonNavigator5.setScrollPivotX(0.3f);
        }
        CommonNavigator commonNavigator6 = this.v;
        if (commonNavigator6 != null) {
            commonNavigator6.setAdapter(new a());
        }
        setNavigator(this.v);
    }
}

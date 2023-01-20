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
import com.jihuanshe.base.magicindicator.commonnavigator.indicators.LinePagerIndicator;
import com.jihuanshe.base.magicindicator.commonnavigator.titles.SimplePagerTitleView;
import com.jihuanshe.ui.widget.MIndicatorView;
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
public final class MIndicatorView extends MagicIndicator {
    @e
    private List<String> b;
    @e

    /* renamed from: c */
    private l<? super Integer, t1> f4148c;
    @e

    /* renamed from: d */
    private List<String> f4149d;
    @e

    /* renamed from: e */
    private List<Integer> f4150e;
    @e

    /* renamed from: f */
    private List<Boolean> f4151f;
    @e

    /* renamed from: g */
    private l<? super View, t1> f4152g;

    /* renamed from: h */
    private float f4153h;

    /* renamed from: i */
    private float f4154i;

    /* renamed from: j */
    private float f4155j;

    /* renamed from: k */
    private int f4156k;

    /* renamed from: l */
    private int f4157l;

    /* renamed from: m */
    private int f4158m;
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
            MIndicatorView.this = r1;
        }

        public static final void j(MIndicatorView mIndicatorView, int i2, View view) {
            l<Integer, t1> listener = mIndicatorView.getListener();
            if (listener != null) {
                listener.invoke(Integer.valueOf(i2));
            }
            if (mIndicatorView.getCurPos() == i2) {
                l<View, t1> clickOnRepeat = mIndicatorView.getClickOnRepeat();
                if (clickOnRepeat == null) {
                    return;
                }
                clickOnRepeat.invoke(mIndicatorView);
                return;
            }
            mIndicatorView.setCurPos(i2);
            mIndicatorView.c(i2);
            mIndicatorView.b(i2, 0.0f, 0);
        }

        public static /* synthetic */ void k(MIndicatorView mIndicatorView, int i2, View view) {
            j(mIndicatorView, i2, view);
        }

        @Override // e.l.h.h.g.a.a
        public int a() {
            List<String> data = MIndicatorView.this.getData();
            if (data == null) {
                return 0;
            }
            return data.size();
        }

        @Override // e.l.h.h.g.a.a
        public int b() {
            return MIndicatorView.this.getCurPos();
        }

        @Override // e.l.h.h.g.a.a
        @d
        public c c(@d Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(2);
            d.a aVar = e.t.o.d.a;
            linePagerIndicator.setLineHeight(d.a.c(aVar, null, 1, null).c(MIndicatorView.this.getLineHeight()));
            linePagerIndicator.setLineWidth(d.a.c(aVar, null, 1, null).c(MIndicatorView.this.getLineWidth()));
            linePagerIndicator.setRoundRadius(d.a.c(aVar, null, 1, null).c(MIndicatorView.this.getRoundRadius()));
            linePagerIndicator.setColors(Integer.valueOf(MIndicatorView.this.getLineColor()));
            linePagerIndicator.setYOffset(d.a.c(aVar, null, 1, null).c(MIndicatorView.this.getYOffset()));
            linePagerIndicator.setXOffset(d.a.c(aVar, null, 1, null).d(MIndicatorView.this.getXOffset()));
            if (MIndicatorView.this.h()) {
                linePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
                linePagerIndicator.setEndInterpolator(new DecelerateInterpolator());
            }
            return linePagerIndicator;
        }

        @Override // e.l.h.h.g.a.a
        @k.e.a.d
        public e.l.h.h.g.a.d d(@k.e.a.d Context context, final int i2) {
            SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
            List<String> data = MIndicatorView.this.getData();
            if (data != null) {
                simplePagerTitleView.setText(data.get(i2));
            }
            simplePagerTitleView.setNormalColor(MIndicatorView.this.getNormalTextColor());
            simplePagerTitleView.f3856i = MIndicatorView.this.getXOffset() * (i2 == 0 ? 2 : 1);
            int xOffset = MIndicatorView.this.getXOffset();
            int i3 = i2 + 1;
            List<String> data2 = MIndicatorView.this.getData();
            simplePagerTitleView.f3857j = xOffset * (data2 != null && i3 == data2.size() ? 2 : 1);
            simplePagerTitleView.f();
            simplePagerTitleView.setSelectedColor(MIndicatorView.this.getSelectTextColor());
            simplePagerTitleView.f3854g = false;
            simplePagerTitleView.f3855h = false;
            simplePagerTitleView.f3852e = MIndicatorView.this.getNormalTextSize();
            simplePagerTitleView.f3851d = MIndicatorView.this.getSelectTextSize();
            final MIndicatorView mIndicatorView = MIndicatorView.this;
            simplePagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MIndicatorView.a.k(MIndicatorView.this, i2, view);
                }
            });
            return simplePagerTitleView;
        }
    }

    @h
    public MIndicatorView(@k.e.a.d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ MIndicatorView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    private final boolean f(@AnyRes int i2) {
        try {
            return StringsKt__StringsKt.V2(getResources().getResourceTypeName(i2), "drawable", false, 2, null);
        } catch (Exception unused) {
            return false;
        }
    }

    public final void d() {
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        this.v = commonNavigator;
        if (commonNavigator != null) {
            commonNavigator.setEnablePivotScroll(true);
        }
        CommonNavigator commonNavigator2 = this.v;
        if (commonNavigator2 != null) {
            commonNavigator2.setFollowTouch(false);
        }
        CommonNavigator commonNavigator3 = this.v;
        if (commonNavigator3 != null) {
            commonNavigator3.setAdjustMode(this.t);
        }
        CommonNavigator commonNavigator4 = this.v;
        if (commonNavigator4 != null) {
            commonNavigator4.setAdapter(new a());
        }
        setNavigator(this.v);
    }

    public final boolean e() {
        return this.t;
    }

    public final boolean g() {
        return this.p;
    }

    @e
    public final List<String> getBadge() {
        return this.f4149d;
    }

    @e
    public final List<Integer> getBadgeImgRes() {
        return this.f4150e;
    }

    @e
    public final List<Boolean> getBadgeIsSelect() {
        return this.f4151f;
    }

    @e
    public final l<View, t1> getClickOnRepeat() {
        return this.f4152g;
    }

    public final int getCurPos() {
        return this.w;
    }

    @e
    public final List<String> getData() {
        return this.b;
    }

    public final int getLineColor() {
        return this.f4156k;
    }

    public final float getLineHeight() {
        return this.f4154i;
    }

    public final float getLineWidth() {
        return this.f4153h;
    }

    @e
    public final l<Integer, t1> getListener() {
        return this.f4148c;
    }

    public final int getNormalTextColor() {
        return this.f4157l;
    }

    public final float getNormalTextSize() {
        return this.n;
    }

    public final float getRoundRadius() {
        return this.f4155j;
    }

    public final int getSelectTextColor() {
        return this.f4158m;
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
        this.f4149d = list;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setBadgeImgRes(@e List<Integer> list) {
        e.l.h.h.g.a.a adapter;
        this.f4150e = list;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setBadgeIsSelect(@e List<Boolean> list) {
        e.l.h.h.g.a.a adapter;
        this.f4151f = list;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setClickOnRepeat(@e l<? super View, t1> lVar) {
        this.f4152g = lVar;
    }

    public final void setCurPos(int i2) {
        this.w = i2;
    }

    public final void setData(@e List<String> list) {
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
        this.f4156k = i2;
        CommonNavigator commonNavigator = this.v;
        if (commonNavigator == null) {
            return;
        }
        commonNavigator.e();
    }

    public final void setLineHeight(float f2) {
        this.f4154i = f2;
    }

    public final void setLineWidth(float f2) {
        this.f4153h = f2;
    }

    public final void setListener(@e l<? super Integer, t1> lVar) {
        this.f4148c = lVar;
    }

    public final void setNormalTextColor(int i2) {
        this.f4157l = i2;
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
        this.f4155j = f2;
    }

    public final void setSelectBold(boolean z) {
        this.p = z;
    }

    public final void setSelectTextColor(int i2) {
        this.f4158m = i2;
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
    public MIndicatorView(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4153h = 20.0f;
        this.f4154i = 3.0f;
        this.f4155j = 3.0f;
        this.f4156k = Color.parseColor("#000000");
        this.f4157l = Color.parseColor("#000000");
        this.f4158m = Color.parseColor("#000000");
        this.n = 12.0f;
        this.o = 12.0f;
        this.p = true;
        this.s = 16;
    }
}

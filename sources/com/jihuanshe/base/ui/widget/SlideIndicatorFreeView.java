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
import com.jihuanshe.base.ui.widget.SlideIndicatorFreeView;
import com.vector.util.Res;
import e.l.h.h.g.a.c;
import e.t.o.d;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import h.r0;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001:\u0001]B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010X\u001a\u00020\u001dJ\u0012\u0010Y\u001a\u00020\u00132\b\b\u0001\u0010Z\u001a\u00020\u000fH\u0002J\u0010\u0010[\u001a\u00020\u001d2\u0006\u0010\\\u001a\u00020\u000fH\u0016R4\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR8\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\b2\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR4\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR7\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\u001a\u0010(\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001a\u0010.\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u001a\u00100\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R$\u00102\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010F\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u00104\"\u0004\bH\u00106R\u001a\u0010I\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010:\"\u0004\bK\u0010<R$\u0010L\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00104\"\u0004\bN\u00106R\u001a\u0010O\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010:\"\u0004\bQ\u0010<R\u001a\u0010R\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u00104\"\u0004\bT\u00106R\u001a\u0010U\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010:\"\u0004\bW\u0010<¨\u0006^"}, d2 = {"Lcom/jihuanshe/base/ui/widget/SlideIndicatorFreeView;", "Lcom/jihuanshe/base/magicindicator/MagicIndicator;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "", "badge", "getBadge", "()Ljava/util/List;", "setBadge", "(Ljava/util/List;)V", "", "badgeImgRes", "getBadgeImgRes", "setBadgeImgRes", "", "badgeIsSelect", "getBadgeIsSelect", "setBadgeIsSelect", "clickOnRepeat", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getClickOnRepeat", "()Lkotlin/jvm/functions/Function1;", "setClickOnRepeat", "(Lkotlin/jvm/functions/Function1;)V", "commonNavigator", "Lcom/jihuanshe/base/magicindicator/commonnavigator/CommonNavigator;", "", "data", "getData", "setData", "isAdjustMode", "()Z", "setAdjustMode", "(Z)V", "isSelectBold", "setSelectBold", "isSlideZoom", "setSlideZoom", "isUnSelectedBold", "setUnSelectedBold", "lineColor", "getLineColor", "()I", "setLineColor", "(I)V", "lineHeight", "", "getLineHeight", "()F", "setLineHeight", "(F)V", "lineWidth", "getLineWidth", "setLineWidth", "mSelectedListener", "Lcom/jihuanshe/base/ui/widget/SlideIndicatorFreeView$SelectedListener;", "getMSelectedListener", "()Lcom/jihuanshe/base/ui/widget/SlideIndicatorFreeView$SelectedListener;", "setMSelectedListener", "(Lcom/jihuanshe/base/ui/widget/SlideIndicatorFreeView$SelectedListener;)V", "normalTextColor", "getNormalTextColor", "setNormalTextColor", "roundRadius", "getRoundRadius", "setRoundRadius", "selectTextColor", "getSelectTextColor", "setSelectTextColor", "textSize", "getTextSize", "setTextSize", "xOffset", "getXOffset", "setXOffset", "yOffset", "getYOffset", "setYOffset", "init", "isDrawable", "id", "onPageSelected", "position", "SelectedListener", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class SlideIndicatorFreeView extends MagicIndicator {
    @e
    private List<? extends Object> b;
    @e

    /* renamed from: c */
    private List<String> f3864c;
    @e

    /* renamed from: d */
    private List<Integer> f3865d;
    @e

    /* renamed from: e */
    private List<Boolean> f3866e;
    @e

    /* renamed from: f */
    private l<? super View, t1> f3867f;

    /* renamed from: g */
    private float f3868g;

    /* renamed from: h */
    private float f3869h;

    /* renamed from: i */
    private float f3870i;

    /* renamed from: j */
    private int f3871j;

    /* renamed from: k */
    private int f3872k;

    /* renamed from: l */
    private int f3873l;

    /* renamed from: m */
    private float f3874m;
    private boolean n;
    private boolean o;
    private float p;
    private int q;
    private boolean r;
    private boolean s;
    @e
    private CommonNavigator t;
    @e
    private a u;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/jihuanshe/base/ui/widget/SlideIndicatorFreeView$SelectedListener;", "", "onSelected", "", "text", "", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public interface a {
        void a(@e String str);
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"com/jihuanshe/base/ui/widget/SlideIndicatorFreeView$init$1", "Lcom/jihuanshe/base/magicindicator/commonnavigator/abs/CommonNavigatorAdapter;", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "getCount", "getCurrentItem", "getIndicator", "Lcom/jihuanshe/base/magicindicator/commonnavigator/abs/IPagerIndicator;", "context", "Landroid/content/Context;", "getTitleView", "Lcom/jihuanshe/base/magicindicator/commonnavigator/abs/IPagerTitleView;", "index", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class b extends e.l.h.h.g.a.a {
        private int b;

        public b() {
            SlideIndicatorFreeView.this = r1;
        }

        public static final void k(SlideIndicatorFreeView slideIndicatorFreeView, int i2, View view) {
            slideIndicatorFreeView.c(i2);
        }

        @Override // e.l.h.h.g.a.a
        public int a() {
            List<Object> data = SlideIndicatorFreeView.this.getData();
            if (data == null) {
                return 0;
            }
            return data.size();
        }

        @Override // e.l.h.h.g.a.a
        public int b() {
            return this.b;
        }

        @Override // e.l.h.h.g.a.a
        @d
        public c c(@d Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(2);
            d.a aVar = e.t.o.d.a;
            linePagerIndicator.setLineHeight(d.a.c(aVar, null, 1, null).c(SlideIndicatorFreeView.this.getLineHeight()));
            linePagerIndicator.setLineWidth(d.a.c(aVar, null, 1, null).c(SlideIndicatorFreeView.this.getLineWidth()));
            linePagerIndicator.setRoundRadius(d.a.c(aVar, null, 1, null).c(SlideIndicatorFreeView.this.getRoundRadius()));
            linePagerIndicator.setColors(Integer.valueOf(SlideIndicatorFreeView.this.getLineColor()));
            linePagerIndicator.setYOffset(d.a.c(aVar, null, 1, null).c(SlideIndicatorFreeView.this.getYOffset()));
            linePagerIndicator.setXOffset(d.a.c(aVar, null, 1, null).d(SlideIndicatorFreeView.this.getXOffset()));
            if (SlideIndicatorFreeView.this.i()) {
                linePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
                linePagerIndicator.setEndInterpolator(new DecelerateInterpolator());
            }
            return linePagerIndicator;
        }

        @Override // e.l.h.h.g.a.a
        @k.e.a.d
        public e.l.h.h.g.a.d d(@k.e.a.d Context context, final int i2) {
            SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
            List<Object> data = SlideIndicatorFreeView.this.getData();
            if (data != null) {
                SlideIndicatorFreeView slideIndicatorFreeView = SlideIndicatorFreeView.this;
                Object obj = data.get(i2);
                if (obj instanceof Integer) {
                    Number number = (Number) obj;
                    if (slideIndicatorFreeView.g(number.intValue())) {
                        simplePagerTitleView.setDrawable(number.intValue());
                    } else {
                        simplePagerTitleView.setText(Res.w(Res.a, number.intValue(), null, 2, null));
                    }
                } else if (obj instanceof String) {
                    simplePagerTitleView.setText((CharSequence) obj);
                }
            }
            simplePagerTitleView.setNormalColor(SlideIndicatorFreeView.this.getNormalTextColor());
            simplePagerTitleView.f3856i = SlideIndicatorFreeView.this.getXOffset();
            simplePagerTitleView.f3857j = SlideIndicatorFreeView.this.getXOffset();
            simplePagerTitleView.f();
            simplePagerTitleView.f3856i = SlideIndicatorFreeView.this.getNormalTextColor();
            simplePagerTitleView.f3857j = SlideIndicatorFreeView.this.getNormalTextColor();
            simplePagerTitleView.setSelectedColor(SlideIndicatorFreeView.this.getSelectTextColor());
            simplePagerTitleView.f3854g = SlideIndicatorFreeView.this.h();
            simplePagerTitleView.f3855h = SlideIndicatorFreeView.this.j();
            simplePagerTitleView.setTextSize(SlideIndicatorFreeView.this.getTextSize());
            final SlideIndicatorFreeView slideIndicatorFreeView2 = SlideIndicatorFreeView.this;
            simplePagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: e.l.h.j.b.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SlideIndicatorFreeView.b.k(slideIndicatorFreeView2, i2, view);
                }
            });
            return simplePagerTitleView;
        }

        public final int j() {
            return this.b;
        }

        public final void m(int i2) {
            this.b = i2;
        }
    }

    @h
    public SlideIndicatorFreeView(@k.e.a.d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ SlideIndicatorFreeView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public final boolean g(@AnyRes int i2) {
        try {
            return StringsKt__StringsKt.V2(getResources().getResourceTypeName(i2), "drawable", false, 2, null);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.jihuanshe.base.magicindicator.MagicIndicator
    public void c(int i2) {
        super.c(i2);
        try {
            Result.a aVar = Result.Companion;
            a mSelectedListener = getMSelectedListener();
            Object obj = null;
            if (mSelectedListener != null) {
                List<Object> data = getData();
                if (data != null) {
                    obj = CollectionsKt___CollectionsKt.J2(data, i2);
                }
                mSelectedListener.a((String) obj);
                obj = t1.a;
            }
            Result.m106constructorimpl(obj);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
        }
    }

    public final void e() {
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        this.t = commonNavigator;
        if (commonNavigator != null) {
            commonNavigator.setAdjustMode(this.r);
        }
        CommonNavigator commonNavigator2 = this.t;
        if (commonNavigator2 != null) {
            commonNavigator2.setAdapter(new b());
        }
        setNavigator(this.t);
    }

    public final boolean f() {
        return this.r;
    }

    @e
    public final List<String> getBadge() {
        return this.f3864c;
    }

    @e
    public final List<Integer> getBadgeImgRes() {
        return this.f3865d;
    }

    @e
    public final List<Boolean> getBadgeIsSelect() {
        return this.f3866e;
    }

    @e
    public final l<View, t1> getClickOnRepeat() {
        return this.f3867f;
    }

    @e
    public final List<Object> getData() {
        return this.b;
    }

    public final int getLineColor() {
        return this.f3871j;
    }

    public final float getLineHeight() {
        return this.f3869h;
    }

    public final float getLineWidth() {
        return this.f3868g;
    }

    @e
    public final a getMSelectedListener() {
        return this.u;
    }

    public final int getNormalTextColor() {
        return this.f3872k;
    }

    public final float getRoundRadius() {
        return this.f3870i;
    }

    public final int getSelectTextColor() {
        return this.f3873l;
    }

    public final float getTextSize() {
        return this.f3874m;
    }

    public final int getXOffset() {
        return this.q;
    }

    public final float getYOffset() {
        return this.p;
    }

    public final boolean h() {
        return this.n;
    }

    public final boolean i() {
        return this.s;
    }

    public final boolean j() {
        return this.o;
    }

    public final void setAdjustMode(boolean z) {
        this.r = z;
    }

    public final void setBadge(@e List<String> list) {
        e.l.h.h.g.a.a adapter;
        this.f3864c = list;
        CommonNavigator commonNavigator = this.t;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setBadgeImgRes(@e List<Integer> list) {
        e.l.h.h.g.a.a adapter;
        this.f3865d = list;
        CommonNavigator commonNavigator = this.t;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setBadgeIsSelect(@e List<Boolean> list) {
        e.l.h.h.g.a.a adapter;
        this.f3866e = list;
        CommonNavigator commonNavigator = this.t;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setClickOnRepeat(@e l<? super View, t1> lVar) {
        this.f3867f = lVar;
    }

    public final void setData(@e List<? extends Object> list) {
        e.l.h.h.g.a.a adapter;
        this.b = list;
        CommonNavigator commonNavigator = this.t;
        if (commonNavigator == null || (adapter = commonNavigator.getAdapter()) == null) {
            return;
        }
        adapter.f();
    }

    public final void setLineColor(int i2) {
        this.f3871j = i2;
        CommonNavigator commonNavigator = this.t;
        if (commonNavigator == null) {
            return;
        }
        commonNavigator.e();
    }

    public final void setLineHeight(float f2) {
        this.f3869h = f2;
    }

    public final void setLineWidth(float f2) {
        this.f3868g = f2;
    }

    public final void setMSelectedListener(@e a aVar) {
        this.u = aVar;
    }

    public final void setNormalTextColor(int i2) {
        this.f3872k = i2;
        CommonNavigator commonNavigator = this.t;
        if (commonNavigator == null) {
            return;
        }
        commonNavigator.e();
    }

    public final void setRoundRadius(float f2) {
        this.f3870i = f2;
    }

    public final void setSelectBold(boolean z) {
        this.n = z;
    }

    public final void setSelectTextColor(int i2) {
        this.f3873l = i2;
        CommonNavigator commonNavigator = this.t;
        if (commonNavigator == null) {
            return;
        }
        commonNavigator.e();
    }

    public final void setSlideZoom(boolean z) {
        this.s = z;
    }

    public final void setTextSize(float f2) {
        this.f3874m = f2;
    }

    public final void setUnSelectedBold(boolean z) {
        this.o = z;
    }

    public final void setXOffset(int i2) {
        this.q = i2;
    }

    public final void setYOffset(float f2) {
        this.p = f2;
    }

    @h
    public SlideIndicatorFreeView(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3868g = 20.0f;
        this.f3869h = 3.0f;
        this.f3870i = 3.0f;
        this.f3871j = Color.parseColor("#000000");
        this.f3872k = Color.parseColor("#87888A");
        this.f3873l = Color.parseColor("#000000");
        this.f3874m = 16.0f;
        this.n = true;
        this.q = 5;
        this.r = true;
        this.s = true;
    }
}

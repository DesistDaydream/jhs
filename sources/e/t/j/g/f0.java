package e.t.j.g;

import android.content.Context;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.umeng.analytics.pro.am;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.design.ui.adapter.pager.FragStatePagerAdapter;
import com.vector.design.ui.adapter.pager.PagerAdapterEx;
import com.vector.view.pager.indicator.IconPageIndicator;
import e.t.o.d;
import h.t1;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J1\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0007J'\u0010,\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010-\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0002\u0010/J\u0018\u00100\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00101\u001a\u00020\u001eH\u0007JQ\u00102\u001a\u00020#\"\b\b\u0000\u00103*\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\b\u00104\u001a\u0004\u0018\u00010+2\b\u0010$\u001a\u0004\u0018\u0001H32\b\u0010%\u001a\u0004\u0018\u00010&2\b\u00105\u001a\u0004\u0018\u00010+2\b\u0010'\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u00106J'\u00107\u001a\u00020#\"\b\b\u0000\u00108*\u0002092\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010:\u001a\u0002H8H\u0007¢\u0006\u0002\u0010;J$\u00107\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010<\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010>H\u0007J\u001f\u0010?\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\b\u0010@\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0002\u0010AJ'\u0010B\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010FJ\u0018\u0010B\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010G\u001a\u00020HH\u0007J8\u0010I\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010QH\u0007JC\u0010R\u001a\u00020#\"\u0004\b\u0000\u00108\"\u000e\b\u0001\u00103*\b\u0012\u0004\u0012\u0002H80S2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u0002H32\u000e\u0010T\u001a\n\u0012\u0004\u0012\u0002H8\u0018\u00010UH\u0007¢\u0006\u0002\u0010VJ\u0018\u0010W\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010X\u001a\u00020+H\u0007J\u001a\u0010Y\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010<\u001a\u00020\u001eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/vector/databinding/adapter/ViewPagerBinding;", "", "()V", "ADAPTER", "", "AUTO_SCROLL", "CURRENT_ITEM", "DATA", "DURATION", "INDICATOR", "INDICATOR_ICON_CONFIG", "INTERVAL", "IS_RTL", "OFFSCREEN_PAGE_LIMIT", "ON_PAGE_SCROLLED", "ON_PAGE_SCROLL_STATE_CHANGED", "ON_PAGE_SELECTED", "PAGER", "PAGE_INTERCEPT", "PAGE_MARGIN", "PAGE_TRANSFORMER", "SCROLLABLE", "SMOOTH_SCROLL", "TAB_LAYOUT_ID", "USE_STATE_ADAPTER", "getAdapter", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "getCurrentItem", "", "view", "Lcom/vector/view/pager/ViewPager;", "getStateAdapter", "nativeSetFragPagerAdapter", "", "adapter", "pager", "Lcom/vector/design/ui/adapter/pager/Pager;", "limit", "(Lcom/vector/view/pager/ViewPager;Landroidx/viewpager/widget/PagerAdapter;Lcom/vector/design/ui/adapter/pager/Pager;Ljava/lang/Integer;)V", "setAutoScroll", "enable", "", "setCurrentItem", "position", "smoothScroll", "(Lcom/vector/view/pager/ViewPager;ILjava/lang/Boolean;)V", "setDuration", "duration", "setFragPagerAdapter", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isRtl", "useState", "(Lcom/vector/view/pager/ViewPager;Ljava/lang/Boolean;Landroidx/viewpager/widget/PagerAdapter;Lcom/vector/design/ui/adapter/pager/Pager;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "setIndicator", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/vector/view/pager/indicator/PageIndicator;", "indicator", "(Lcom/vector/view/pager/ViewPager;Lcom/vector/view/pager/indicator/PageIndicator;)V", "id", "config", "Lcom/vector/view/pager/indicator/IconPageIndicator$Config;", "setIntercept", "b", "(Lcom/vector/view/pager/ViewPager;Ljava/lang/Boolean;)V", "setInterval", "pageTransformer", "Landroidx/viewpager/widget/ViewPager$PageTransformer;", "padding", "(Lcom/vector/view/pager/ViewPager;Landroidx/viewpager/widget/ViewPager$PageTransformer;Ljava/lang/Integer;)V", am.aU, "", "setOnPageChangeListener", "onPageScrollStateChangedBinding", "Lcom/vector/databinding/onBind/OnPageScrollStateChangedBinding;", "onPageScrolledBinding", "Lcom/vector/databinding/onBind/OnPageScrolledBinding;", "onPageSelectedBinding", "Lcom/vector/databinding/onBind/OnPageSelectedBinding;", "attrChanged", "Landroidx/databinding/InverseBindingListener;", "setPagerAdapter", "Lcom/vector/design/ui/adapter/pager/PagerAdapterEx;", "data", "", "(Lcom/vector/view/pager/ViewPager;Lcom/vector/design/ui/adapter/pager/PagerAdapterEx;Ljava/util/List;)V", "setScrollable", "scrollable", "setTabLayout", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class f0 {
    @k.e.a.d
    public static final f0 a = new f0();
    @k.e.a.d
    private static final String b = "android:viewPager_onPageScrollStateChanged";
    @k.e.a.d

    /* renamed from: c */
    private static final String f14499c = "android:viewPager_onPageScrolled";
    @k.e.a.d

    /* renamed from: d */
    private static final String f14500d = "android:viewPager_onPageSelected";
    @k.e.a.d

    /* renamed from: e */
    private static final String f14501e = "android:viewPager_indicator";
    @k.e.a.d

    /* renamed from: f */
    private static final String f14502f = "android:viewPager_indicator_config_icon";
    @k.e.a.d

    /* renamed from: g */
    private static final String f14503g = "android:viewPager_adapter";
    @k.e.a.d

    /* renamed from: h */
    private static final String f14504h = "android:viewPager_useState";
    @k.e.a.d

    /* renamed from: i */
    private static final String f14505i = "android:viewPager_offscreenPageLimit";
    @k.e.a.d

    /* renamed from: j */
    private static final String f14506j = "android:viewPager_currentItem";
    @k.e.a.d

    /* renamed from: k */
    private static final String f14507k = "android:viewPager_scrollable";
    @k.e.a.d

    /* renamed from: l */
    private static final String f14508l = "android:viewPager_duration";
    @k.e.a.d

    /* renamed from: m */
    private static final String f14509m = "android:viewPager_smoothScroll";
    @k.e.a.d
    private static final String n = "android:viewPager_autoScroll";
    @k.e.a.d
    private static final String o = "android:viewPager_scrollIntervalInMillis";
    @k.e.a.d
    private static final String p = "android:viewPager_data";
    @k.e.a.d
    private static final String q = "android:viewPager_pager";
    @k.e.a.d
    private static final String r = "android:viewPager_tabLayoutId";
    @k.e.a.d
    private static final String s = "android:viewPager_isRtl";
    @k.e.a.d
    private static final String t = "android:viewPager_pageTransformer";
    @k.e.a.d
    private static final String u = "android:viewPager_pageMargin";
    @k.e.a.d
    private static final String v = "android:viewPager_intercept";

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/vector/databinding/adapter/ViewPagerBinding$setOnPageChangeListener$listener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements ViewPager.OnPageChangeListener {
        public final /* synthetic */ e.t.j.h.w a;
        public final /* synthetic */ e.t.j.h.x b;

        /* renamed from: c */
        public final /* synthetic */ e.t.j.h.y f14510c;

        /* renamed from: d */
        public final /* synthetic */ InverseBindingListener f14511d;

        public a(e.t.j.h.w wVar, e.t.j.h.x xVar, e.t.j.h.y yVar, InverseBindingListener inverseBindingListener) {
            this.a = wVar;
            this.b = xVar;
            this.f14510c = yVar;
            this.f14511d = inverseBindingListener;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            h.k2.u.l<Integer, t1> a;
            e.t.j.h.w wVar = this.a;
            if (wVar == null || (a = wVar.a()) == null) {
                return;
            }
            a.invoke(Integer.valueOf(i2));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            h.k2.u.q<Integer, Float, Integer, t1> a;
            e.t.j.h.x xVar = this.b;
            if (xVar == null || (a = xVar.a()) == null) {
                return;
            }
            a.invoke(Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            h.k2.u.l<Integer, t1> a;
            e.t.j.h.y yVar = this.f14510c;
            if (yVar != null && (a = yVar.a()) != null) {
                a.invoke(Integer.valueOf(i2));
            }
            InverseBindingListener inverseBindingListener = this.f14511d;
            if (inverseBindingListener == null) {
                return;
            }
            inverseBindingListener.onChange();
        }
    }

    private f0() {
    }

    private final PagerAdapter a(Context context) throws NullPointerException {
        if (context instanceof FragmentActivity) {
            return new FragPagerAdapter((FragmentActivity) context);
        }
        if (context instanceof e.t.l.u) {
            return a(((e.t.l.u) context).getBaseContext());
        }
        throw new NullPointerException("Context is not a Fragment or FragmentActivity");
    }

    @h.k2.k
    @InverseBindingAdapter(attribute = f14506j)
    public static final int b(@k.e.a.d com.vector.view.pager.ViewPager viewPager) {
        return viewPager.getCurrentItem();
    }

    private final PagerAdapter c(Context context) throws NullPointerException {
        if (context instanceof FragmentActivity) {
            return new FragStatePagerAdapter((FragmentActivity) context);
        }
        if (context instanceof e.t.l.u) {
            return c(((e.t.l.u) context).getBaseContext());
        }
        throw new NullPointerException("Context is not a Fragment or FragmentActivity");
    }

    private final void e(final com.vector.view.pager.ViewPager viewPager, PagerAdapter pagerAdapter, e.t.k.a.c.h.c cVar, Integer num) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            viewPager.setAdapter(pagerAdapter);
            e.t.v.h.d.c indicator = viewPager.getIndicator();
            if (indicator != null) {
                indicator.setViewPager(viewPager);
            }
        } else {
            pagerAdapter = adapter;
        }
        if (pagerAdapter != null && (pagerAdapter instanceof e.t.k.a.c.h.a)) {
            e.t.k.a.c.h.a aVar = (e.t.k.a.c.h.a) pagerAdapter;
            if (cVar != null) {
                aVar.setData(cVar, viewPager);
            }
        }
        new e.t.l.h();
        viewPager.notifyDataSetChanged();
        Integer d2 = cVar == null ? null : cVar.d();
        if (d2 != null) {
            final int intValue = d2.intValue();
            viewPager.post(new Runnable() { // from class: e.t.j.g.p
                @Override // java.lang.Runnable
                public final void run() {
                    f0.f(viewPager, intValue);
                }
            });
        }
        if (num == null || num.intValue() <= 0) {
            return;
        }
        viewPager.setOffscreenPageLimit(num.intValue());
    }

    public static final void f(com.vector.view.pager.ViewPager viewPager, int i2) {
        viewPager.setCurrentItem(i2, false);
    }

    @BindingAdapter({n})
    @h.k2.k
    public static final void g(@k.e.a.d com.vector.view.pager.ViewPager viewPager, boolean z) {
        viewPager.setAutoScroll(z);
    }

    @BindingAdapter(requireAll = false, value = {f14506j, f14509m})
    @h.k2.k
    public static final void h(@k.e.a.d com.vector.view.pager.ViewPager viewPager, int i2, @k.e.a.e Boolean bool) {
        viewPager.setSmoothScroll(bool == null ? true : bool.booleanValue());
        if (viewPager.getCurrentItem() == i2) {
            return;
        }
        viewPager.setCurrentItem(i2, viewPager.getSmoothScroll());
    }

    @BindingAdapter({f14508l})
    @h.k2.k
    public static final void i(@k.e.a.d com.vector.view.pager.ViewPager viewPager, int i2) {
        viewPager.setScrollDuration(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [e.t.j.g.f0] */
    /* JADX WARN: Type inference failed for: r2v0, types: [A extends androidx.viewpager.widget.PagerAdapter] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.viewpager.widget.PagerAdapter] */
    @BindingAdapter(requireAll = false, value = {s, f14503g, q, f14504h, f14505i})
    @h.k2.k
    public static final <A extends PagerAdapter> void j(@k.e.a.d com.vector.view.pager.ViewPager viewPager, @k.e.a.e Boolean bool, @k.e.a.e A a2, @k.e.a.e e.t.k.a.c.h.c cVar, @k.e.a.e Boolean bool2, @k.e.a.e Integer num) throws NullPointerException {
        if (bool != null) {
            viewPager.setRtl(bool.booleanValue());
        }
        if (a2 == 0) {
            if (h.k2.v.f0.g(bool2, Boolean.TRUE)) {
                a2 = a.c(viewPager.getContext());
            } else {
                a2 = a.a(viewPager.getContext());
            }
        }
        ?? r1 = a;
        if (num == null) {
            num = cVar == null ? null : Integer.valueOf(cVar.f());
        }
        r1.e(viewPager, a2, cVar, num);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View] */
    @BindingAdapter(requireAll = false, value = {f14501e, f14502f})
    @h.k2.k
    public static final void k(@k.e.a.d com.vector.view.pager.ViewPager viewPager, @IdRes int i2, @k.e.a.e IconPageIndicator.c cVar) {
        View rootView = viewPager.getRootView();
        IconPageIndicator findViewById = rootView == null ? null : rootView.findViewById(i2);
        if (findViewById instanceof e.t.v.h.d.c) {
            viewPager.setIndicator(findViewById);
            if ((findViewById instanceof IconPageIndicator) && cVar != null) {
                d.a aVar = e.t.o.d.a;
                IconPageIndicator iconPageIndicator = findViewById;
                iconPageIndicator.setIndicatorSpace(aVar.a(viewPager.getContext()).c(cVar.f()));
                iconPageIndicator.setIndicatorSize(aVar.a(viewPager.getContext()).d(cVar.e()));
                iconPageIndicator.setResId(cVar.d());
            }
            if (viewPager.getAdapter() != null) {
                e.t.v.h.d.c indicator = viewPager.getIndicator();
                if (indicator != null) {
                    indicator.setViewPager(viewPager);
                }
                e.t.v.h.d.c indicator2 = viewPager.getIndicator();
                if (indicator2 == null) {
                    return;
                }
                indicator2.e();
            }
        }
    }

    @BindingAdapter({f14501e})
    @h.k2.k
    public static final <T extends e.t.v.h.d.c> void l(@k.e.a.d com.vector.view.pager.ViewPager viewPager, @k.e.a.d T t2) {
        viewPager.setIndicator(t2);
        if (viewPager.getAdapter() != null) {
            e.t.v.h.d.c indicator = viewPager.getIndicator();
            if (indicator != null) {
                indicator.setViewPager(viewPager);
            }
            e.t.v.h.d.c indicator2 = viewPager.getIndicator();
            if (indicator2 == null) {
                return;
            }
            indicator2.e();
        }
    }

    @BindingAdapter(requireAll = false, value = {v})
    @h.k2.k
    public static final void m(@k.e.a.d com.vector.view.pager.ViewPager viewPager, @k.e.a.e Boolean bool) {
        if (bool == null) {
            return;
        }
        bool.booleanValue();
        viewPager.setInterceptEvent(bool.booleanValue());
    }

    @BindingAdapter({o})
    @h.k2.k
    public static final void n(@k.e.a.d com.vector.view.pager.ViewPager viewPager, long j2) {
        viewPager.setInterval(j2);
    }

    @BindingAdapter(requireAll = false, value = {t, u})
    @h.k2.k
    public static final void o(@k.e.a.d com.vector.view.pager.ViewPager viewPager, @k.e.a.d ViewPager.PageTransformer pageTransformer, @k.e.a.e Integer num) {
        viewPager.setPageTransformer(true, pageTransformer);
        if (num != null) {
            viewPager.setPageMargin(d.a.c(e.t.o.d.a, null, 1, null).d(num.intValue()));
        }
    }

    @BindingAdapter(requireAll = false, value = {b, f14499c, f14500d, "android:viewPager_currentItemAttrChanged"})
    @h.k2.k
    public static final void p(@k.e.a.d com.vector.view.pager.ViewPager viewPager, @k.e.a.e e.t.j.h.w wVar, @k.e.a.e e.t.j.h.x xVar, @k.e.a.e e.t.j.h.y yVar, @k.e.a.e InverseBindingListener inverseBindingListener) {
        a aVar = new a(wVar, xVar, yVar, inverseBindingListener);
        if (viewPager.getIndicator() != null) {
            e.t.v.h.d.c indicator = viewPager.getIndicator();
            if (indicator != null) {
                indicator.setOnPageChangeListener(aVar);
            }
            if (viewPager.getAdapter() != null) {
                e.t.v.h.d.c indicator2 = viewPager.getIndicator();
                if (indicator2 != null) {
                    indicator2.b(viewPager, viewPager.getCurrentItem());
                }
                e.t.v.h.d.c indicator3 = viewPager.getIndicator();
                if (indicator3 == null) {
                    return;
                }
                indicator3.e();
                return;
            }
            return;
        }
        viewPager.addOnPageChangeListener(aVar);
    }

    @BindingAdapter({f14503g, p})
    @h.k2.k
    public static final <T, A extends PagerAdapterEx<T>> void q(@k.e.a.d com.vector.view.pager.ViewPager viewPager, @k.e.a.d A a2, @k.e.a.e List<? extends T> list) {
        if (!h.k2.v.f0.g(viewPager.getAdapter(), a2)) {
            viewPager.setAdapter(a2);
            e.t.v.h.d.c indicator = viewPager.getIndicator();
            if (indicator != null) {
                indicator.setViewPager(viewPager);
            }
        }
        a2.setData(list);
        viewPager.notifyDataSetChanged();
    }

    @BindingAdapter({f14507k})
    @h.k2.k
    public static final void r(@k.e.a.d com.vector.view.pager.ViewPager viewPager, boolean z) {
        viewPager.setScrollable(z);
    }

    @BindingAdapter({r})
    @h.k2.k
    public static final void s(@k.e.a.d com.vector.view.pager.ViewPager viewPager, @IdRes int i2) {
        View rootView = viewPager.getRootView();
        TabLayout tabLayout = rootView == null ? null : (TabLayout) rootView.findViewById(i2);
        if (tabLayout == null) {
            return;
        }
        tabLayout.setupWithViewPager(viewPager);
    }
}

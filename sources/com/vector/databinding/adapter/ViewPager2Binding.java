package com.vector.databinding.adapter;

import android.content.Context;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.vector.view.pager.indicator.IconPageIndicator;
import e.t.j.h.w;
import e.t.j.h.x;
import e.t.j.h.y;
import e.t.k.a.c.h.b;
import e.t.k.a.c.h.c;
import e.t.l.h;
import e.t.l.u;
import e.t.o.d;
import h.k2.k;
import h.k2.u.l;
import h.k2.u.q;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J)\u0010 \u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u00182\b\u0010\"\u001a\u0004\u0018\u00010#H\u0007¢\u0006\u0002\u0010$J'\u0010%\u001a\u00020\u001c\"\b\b\u0000\u0010\u0012*\u00020&2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010'\u001a\u0002H\u0012H\u0007¢\u0006\u0002\u0010(J$\u0010%\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010)\u001a\u00020\u00182\b\u0010*\u001a\u0004\u0018\u00010+H\u0007J\u0018\u0010,\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u0018H\u0007J8\u0010.\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0007J\u0018\u00107\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u0018H\u0007J\u0018\u00109\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020#H\u0007J\u001a\u0010;\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010)\u001a\u00020\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/vector/databinding/adapter/ViewPager2Binding;", "", "()V", "ADAPTER", "", "CURRENT_ITEM", "INDICATOR", "INDICATOR_ICON_CONFIG", "OFF_SCREEN_PAGE_LIMIT", "ON_PAGE_SCROLLED", "ON_PAGE_SCROLL_STATE_CHANGED", "ON_PAGE_SELECTED", "ORIENTATION", "PAGER", "SCROLLABLE", "SMOOTH_SCROLL", "TAB_LAYOUT_ID", "getAdapter", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/vector/design/ui/adapter/pager/FragStateAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Lcom/vector/design/ui/adapter/pager/FragStateAdapter;", "getCurrentItem", "", "view", "Lcom/vector/view/pager/ViewPager2;", "setAdapter", "", "adapter", "pager", "Lcom/vector/design/ui/adapter/pager/Pager;", "setCurrentItem", "item", "smoothScroll", "", "(Lcom/vector/view/pager/ViewPager2;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "setIndicator", "Lcom/vector/view/pager/indicator/PageIndicator;", "indicator", "(Lcom/vector/view/pager/ViewPager2;Lcom/vector/view/pager/indicator/PageIndicator;)V", "id", "config", "Lcom/vector/view/pager/indicator/IconPageIndicator$Config;", "setOffscreenPageLimit", "limit", "setOnPageChangeListener", "onPageScrollStateChangedBinding", "Lcom/vector/databinding/onBind/OnPageScrollStateChangedBinding;", "onPageScrolledBinding", "Lcom/vector/databinding/onBind/OnPageScrolledBinding;", "onPageSelectedBinding", "Lcom/vector/databinding/onBind/OnPageSelectedBinding;", "attrChanged", "Landroidx/databinding/InverseBindingListener;", "setOrientation", "orientation", "setScrollable", "scrollable", "setTabLayout", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewPager2Binding {
    @d
    public static final ViewPager2Binding a = new ViewPager2Binding();
    @d
    private static final String b = "android:viewPager2_adapter";
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final String f7702c = "android:viewPager2_pager";
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final String f7703d = "android:viewPager2_orientation";
    @d

    /* renamed from: e  reason: collision with root package name */
    private static final String f7704e = "android:viewPager2_tabLayoutId";
    @d

    /* renamed from: f  reason: collision with root package name */
    private static final String f7705f = "android:viewPager2_offscreenPageLimit";
    @d

    /* renamed from: g  reason: collision with root package name */
    private static final String f7706g = "android:viewPager2_scrollable";
    @d

    /* renamed from: h  reason: collision with root package name */
    private static final String f7707h = "android:viewPager2_smoothScroll";
    @d

    /* renamed from: i  reason: collision with root package name */
    private static final String f7708i = "android:viewPager2_currentItem";
    @d

    /* renamed from: j  reason: collision with root package name */
    private static final String f7709j = "android:viewPager2_onPageScrollStateChanged";
    @d

    /* renamed from: k  reason: collision with root package name */
    private static final String f7710k = "android:viewPager2_onPageScrolled";
    @d

    /* renamed from: l  reason: collision with root package name */
    private static final String f7711l = "android:viewPager2_onPageSelected";
    @d

    /* renamed from: m  reason: collision with root package name */
    private static final String f7712m = "android:viewPager2_indicator";
    @d
    private static final String n = "android:viewPager2_indicator_config_icon";

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/vector/databinding/adapter/ViewPager2Binding$setOnPageChangeListener$listener$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a extends ViewPager2.OnPageChangeCallback {
        public final /* synthetic */ w a;
        public final /* synthetic */ x b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ y f7713c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ InverseBindingListener f7714d;

        public a(w wVar, x xVar, y yVar, InverseBindingListener inverseBindingListener) {
            this.a = wVar;
            this.b = xVar;
            this.f7713c = yVar;
            this.f7714d = inverseBindingListener;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i2) {
            l<Integer, t1> a;
            w wVar = this.a;
            if (wVar == null || (a = wVar.a()) == null) {
                return;
            }
            a.invoke(Integer.valueOf(i2));
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i2, float f2, int i3) {
            q<Integer, Float, Integer, t1> a;
            x xVar = this.b;
            if (xVar == null || (a = xVar.a()) == null) {
                return;
            }
            a.invoke(Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3));
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            l<Integer, t1> a;
            y yVar = this.f7713c;
            if (yVar != null && (a = yVar.a()) != null) {
                a.invoke(Integer.valueOf(i2));
            }
            InverseBindingListener inverseBindingListener = this.f7714d;
            if (inverseBindingListener == null) {
                return;
            }
            inverseBindingListener.onChange();
        }
    }

    private ViewPager2Binding() {
    }

    private final <T extends b> T a(Context context) throws NullPointerException {
        if (context instanceof u) {
            return (T) a(((u) context).getBaseContext());
        }
        if (context instanceof FragmentActivity) {
            return (T) new b((FragmentActivity) context);
        }
        throw new NullPointerException("Context is not a Fragment or FragmentActivity");
    }

    @k
    @InverseBindingAdapter(attribute = f7708i)
    public static final int b(@d com.vector.view.pager.ViewPager2 viewPager2) {
        return viewPager2.getCurrentItem();
    }

    @BindingAdapter(requireAll = false, value = {b, f7702c})
    @k
    public static final void c(@d com.vector.view.pager.ViewPager2 viewPager2, @e b bVar, @e c cVar) {
        RecyclerView.Adapter<?> adapter = viewPager2.getAdapter();
        if (adapter == null) {
            if (bVar == null) {
                bVar = a.a(viewPager2.getContext());
            }
            viewPager2.setAdapter(bVar);
            e.t.v.h.d.c indicator = viewPager2.getIndicator();
            if (indicator != null) {
                indicator.setViewPager2(viewPager2);
            }
            adapter = bVar;
        }
        if (adapter != null && (adapter instanceof b)) {
            b bVar2 = (b) adapter;
            if (cVar != null) {
                bVar2.c(cVar, viewPager2);
            }
            e.t.v.h.d.c indicator2 = viewPager2.getIndicator();
            if (indicator2 != null) {
                indicator2.e();
            }
        }
        new h();
    }

    @BindingAdapter(requireAll = false, value = {f7708i, f7707h})
    @k
    public static final void d(@d com.vector.view.pager.ViewPager2 viewPager2, @e Integer num, @e Boolean bool) {
        viewPager2.setSmoothScroll(bool == null ? true : bool.booleanValue());
        if (num == null || viewPager2.getCurrentItem() == num.intValue()) {
            return;
        }
        viewPager2.setCurrentItem(num.intValue());
    }

    @BindingAdapter(requireAll = false, value = {f7712m, n})
    @k
    public static final void e(@d com.vector.view.pager.ViewPager2 viewPager2, @IdRes int i2, @e IconPageIndicator.c cVar) {
        View rootView = viewPager2.getRootView();
        View findViewById = rootView == null ? null : rootView.findViewById(i2);
        if (findViewById instanceof e.t.v.h.d.c) {
            if ((findViewById instanceof IconPageIndicator) && cVar != null) {
                d.a aVar = e.t.o.d.a;
                IconPageIndicator iconPageIndicator = (IconPageIndicator) findViewById;
                iconPageIndicator.setIndicatorSpace(aVar.a(viewPager2.getContext()).c(cVar.f()));
                iconPageIndicator.setIndicatorSize(aVar.a(viewPager2.getContext()).d(cVar.e()));
                iconPageIndicator.setResId(cVar.d());
            }
            viewPager2.setIndicator((e.t.v.h.d.c) findViewById);
            if (viewPager2.getAdapter() != null) {
                e.t.v.h.d.c indicator = viewPager2.getIndicator();
                if (indicator != null) {
                    indicator.setViewPager2(viewPager2);
                }
                e.t.v.h.d.c indicator2 = viewPager2.getIndicator();
                if (indicator2 == null) {
                    return;
                }
                indicator2.e();
            }
        }
    }

    @BindingAdapter({f7712m})
    @k
    public static final <T extends e.t.v.h.d.c> void f(@k.e.a.d com.vector.view.pager.ViewPager2 viewPager2, @k.e.a.d T t) {
        viewPager2.setIndicator(t);
        if (viewPager2.getAdapter() != null) {
            e.t.v.h.d.c indicator = viewPager2.getIndicator();
            if (indicator != null) {
                indicator.setViewPager2(viewPager2);
            }
            e.t.v.h.d.c indicator2 = viewPager2.getIndicator();
            if (indicator2 == null) {
                return;
            }
            indicator2.e();
        }
    }

    @BindingAdapter({f7705f})
    @k
    public static final void g(@k.e.a.d com.vector.view.pager.ViewPager2 viewPager2, int i2) {
        viewPager2.setOffscreenPageLimit(i2);
    }

    @BindingAdapter(requireAll = false, value = {f7709j, f7710k, f7711l, "android:viewPager2_currentItemAttrChanged"})
    @k
    public static final void h(@k.e.a.d com.vector.view.pager.ViewPager2 viewPager2, @e w wVar, @e x xVar, @e y yVar, @e InverseBindingListener inverseBindingListener) {
        if (viewPager2.getIndicator() != null) {
            a aVar = new a(wVar, xVar, yVar, inverseBindingListener);
            e.t.v.h.d.c indicator = viewPager2.getIndicator();
            if (indicator != null) {
                indicator.setOnPageChangeCallback(aVar);
            }
            if (viewPager2.getAdapter() != null) {
                e.t.v.h.d.c indicator2 = viewPager2.getIndicator();
                if (indicator2 != null) {
                    indicator2.a(viewPager2, viewPager2.getCurrentItem());
                }
                e.t.v.h.d.c indicator3 = viewPager2.getIndicator();
                if (indicator3 == null) {
                    return;
                }
                indicator3.e();
                return;
            }
            return;
        }
        viewPager2.a(new ViewPager2Binding$setOnPageChangeListener$1(wVar, xVar, yVar, inverseBindingListener));
    }

    @BindingAdapter({f7703d})
    @k
    public static final void i(@k.e.a.d com.vector.view.pager.ViewPager2 viewPager2, int i2) {
        viewPager2.setOrientation(i2);
    }

    @BindingAdapter({f7706g})
    @k
    public static final void j(@k.e.a.d com.vector.view.pager.ViewPager2 viewPager2, boolean z) {
        viewPager2.setScrollable(z);
    }

    @BindingAdapter({f7704e})
    @k
    public static final void k(@k.e.a.d com.vector.view.pager.ViewPager2 viewPager2, @IdRes int i2) {
        View rootView = viewPager2.getRootView();
        TabLayout tabLayout = rootView == null ? null : (TabLayout) rootView.findViewById(i2);
        if (tabLayout == null) {
            return;
        }
        e.t.v.h.b.a(tabLayout, viewPager2);
    }
}

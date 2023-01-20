package com.vector.view.pager;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.badge.BadgeDrawable;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import e.t.u.p;
import h.k2.h;
import h.k2.u.l;
import h.k2.u.q;
import h.k2.v.u;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 Y2\u00020\u0001:\u0003XYZB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ#\u0010>\u001a\u00020?2\u001b\u0010@\u001a\u0017\u0012\b\u0012\u00060BR\u00020\u0000\u0012\u0004\u0012\u00020?0A¢\u0006\u0002\bCJ\u0006\u0010D\u001a\u00020?J\b\u0010E\u001a\u00020?H\u0014J\b\u0010F\u001a\u00020?H\u0014J0\u0010G\u001a\u00020?2\u0006\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0007H\u0014J\u0018\u0010M\u001a\u00020?2\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007H\u0014J\u0012\u0010P\u001a\u00020?2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0014J\u000e\u0010S\u001a\u00020?2\u0006\u0010T\u001a\u00020UJ\u0016\u0010\u0019\u001a\u00020?2\u0006\u0010V\u001a\u00020\u00072\u0006\u00104\u001a\u00020!J\u000e\u0010W\u001a\u00020?2\u0006\u0010T\u001a\u00020UR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR0\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00102\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020!2\u0006\u0010\u000f\u001a\u00020!8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010,\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u0012\u0012\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR$\u00101\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010\u0018\"\u0004\b3\u0010\u001aR\u001a\u00104\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010#\"\u0004\b6\u0010%R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010:\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=¨\u0006["}, d2 = {"Lcom/vector/view/pager/ViewPager2;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accessibilityProvider", "Lcom/vector/view/pager/ViewPager2$AccessibilityProvider;", "getAccessibilityProvider", "()Lcom/vector/view/pager/ViewPager2$AccessibilityProvider;", "setAccessibilityProvider", "(Lcom/vector/view/pager/ViewPager2$AccessibilityProvider;)V", "value", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "currentItem", "getCurrentItem", "()I", "setCurrentItem", "(I)V", "indicator", "Lcom/vector/view/pager/indicator/PageIndicator;", "getIndicator", "()Lcom/vector/view/pager/indicator/PageIndicator;", "setIndicator", "(Lcom/vector/view/pager/indicator/PageIndicator;)V", "", "isScrollable", "()Z", "setScrollable", "(Z)V", "mediator", "Lcom/vector/view/pager/TabLayoutMediator;", "getMediator", "()Lcom/vector/view/pager/TabLayoutMediator;", "setMediator", "(Lcom/vector/view/pager/TabLayoutMediator;)V", "offscreenPageLimit", "getOffscreenPageLimit$annotations", "()V", "getOffscreenPageLimit", "setOffscreenPageLimit", "orientation", "getOrientation", "setOrientation", "smoothScroll", "getSmoothScroll", "setSmoothScroll", "tmpChildRect", "Landroid/graphics/Rect;", "tmpContainerRect", "xViewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "getXViewPager2", "()Landroidx/viewpager2/widget/ViewPager2;", "addOnPageChangeListener", "", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Lcom/vector/view/pager/ViewPager2$OnPageChangeListenerBuilder;", "Lkotlin/ExtensionFunctionType;", "notifyDataSetChanged", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", NotifyType.LIGHTS, am.aI, "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "registerOnPageChangeCallback", "callback", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "item", "unregisterOnPageChangeCallback", "AccessibilityProvider", "Companion", "OnPageChangeListenerBuilder", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class ViewPager2 extends ViewGroup {
    @d

    /* renamed from: h  reason: collision with root package name */
    public static final b f7975h = new b(null);

    /* renamed from: i  reason: collision with root package name */
    public static final int f7976i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f7977j = 1;
    @e
    private e.t.v.h.d.c a;
    @d
    private final androidx.viewpager2.widget.ViewPager2 b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final Rect f7978c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final Rect f7979d;
    @e

    /* renamed from: e  reason: collision with root package name */
    private e.t.v.h.a f7980e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7981f;
    @e

    /* renamed from: g  reason: collision with root package name */
    private a f7982g;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/vector/view/pager/ViewPager2$AccessibilityProvider;", "", "()V", "onAttachAdapter", "", "newAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "onDetachAdapter", "oldAdapter", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class a {
        public void a(@e RecyclerView.Adapter<?> adapter) {
        }

        public void b(@e RecyclerView.Adapter<?> adapter) {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/vector/view/pager/ViewPager2$Companion;", "", "()V", "ORIENTATION_HORIZONTAL", "", "ORIENTATION_VERTICAL", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\tJ)\u0010\u0003\u001a\u00020\t2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004JW\u0010\u000b\u001a\u00020\t2O\u0010\u0015\u001aK\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\fj\u0002`\u0011J-\u0010\u0012\u001a\u00020\t2%\u0010\u0015\u001a!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\u0013R1\u0010\u0003\u001a%\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nX\u0082\u000e¢\u0006\u0002\n\u0000R[\u0010\u000b\u001aO\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\fj\u0004\u0018\u0001`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\u0012\u001a%\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/vector/view/pager/ViewPager2$OnPageChangeListenerBuilder;", "", "(Lcom/vector/view/pager/ViewPager2;)V", "onScrollStateChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "state", "", "Lcom/vector/view/pager/OnPageScrollStateChanged;", "onScrolled", "Lkotlin/Function3;", "position", "", "positionOffset", "positionOffsetPixels", "Lcom/vector/view/pager/OnPageScrolled;", "onSelected", "Lcom/vector/view/pager/OnPageSelected;", "build", ReportItem.LogTypeBlock, "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final class c {
        @e
        private l<? super Integer, t1> a;
        @e
        private q<? super Integer, ? super Float, ? super Integer, t1> b;
        @e

        /* renamed from: c  reason: collision with root package name */
        private l<? super Integer, t1> f7983c;

        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/vector/view/pager/ViewPager2$OnPageChangeListenerBuilder$build$listener$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class a extends ViewPager2.OnPageChangeCallback {
            public a() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i2) {
                l lVar = c.this.a;
                if (lVar == null) {
                    return;
                }
                lVar.invoke(Integer.valueOf(i2));
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i2, float f2, int i3) {
                q qVar = c.this.b;
                if (qVar == null) {
                    return;
                }
                qVar.invoke(Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3));
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                l lVar = c.this.f7983c;
                if (lVar == null) {
                    return;
                }
                lVar.invoke(Integer.valueOf(i2));
            }
        }

        public c() {
        }

        public final void d() {
            ViewPager2.this.d(new a());
        }

        public final void e(@d l<? super Integer, t1> lVar) {
            this.a = lVar;
        }

        public final void f(@d q<? super Integer, ? super Float, ? super Integer, t1> qVar) {
            this.b = qVar;
        }

        public final void g(@d l<? super Integer, t1> lVar) {
            this.f7983c = lVar;
        }
    }

    @h
    public ViewPager2(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public ViewPager2(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ViewPager2(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static /* synthetic */ void getOffscreenPageLimit$annotations() {
    }

    public final void a(@d l<? super c, t1> lVar) {
        c cVar = new c();
        lVar.invoke(cVar);
        cVar.d();
    }

    public final boolean b() {
        return this.b.isUserInputEnabled();
    }

    public final void c() {
        RecyclerView.Adapter<?> adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        e.t.v.h.d.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        cVar.e();
    }

    public final void d(@d ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.b.registerOnPageChangeCallback(onPageChangeCallback);
    }

    public final void e(int i2, boolean z) {
        this.b.setCurrentItem(i2, z);
    }

    public final void f(@d ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.b.unregisterOnPageChangeCallback(onPageChangeCallback);
    }

    @e
    public final a getAccessibilityProvider() {
        return this.f7982g;
    }

    @e
    public final RecyclerView.Adapter<?> getAdapter() {
        return this.b.getAdapter();
    }

    public final int getCurrentItem() {
        return this.b.getCurrentItem();
    }

    @e
    public final e.t.v.h.d.c getIndicator() {
        return this.a;
    }

    @e
    public final e.t.v.h.a getMediator() {
        return this.f7980e;
    }

    public final int getOffscreenPageLimit() {
        return this.b.getOffscreenPageLimit();
    }

    public final int getOrientation() {
        return this.b.getOrientation();
    }

    public final boolean getSmoothScroll() {
        return this.f7981f;
    }

    @d
    public final androidx.viewpager2.widget.ViewPager2 getXViewPager2() {
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.t.v.h.a aVar = this.f7980e;
        if (aVar == null) {
            return;
        }
        aVar.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.t.v.h.a aVar = this.f7980e;
        if (aVar == null) {
            return;
        }
        aVar.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.b.getMeasuredWidth();
        int measuredHeight = this.b.getMeasuredHeight();
        this.f7978c.left = getPaddingStart();
        this.f7978c.right = (i4 - i2) - getPaddingEnd();
        this.f7978c.top = getPaddingTop();
        this.f7978c.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.r, measuredWidth, measuredHeight, this.f7978c, this.f7979d);
        androidx.viewpager2.widget.ViewPager2 viewPager2 = this.b;
        Rect rect = this.f7979d;
        viewPager2.layout(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        measureChild(this.b, i2, i3);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@e Parcelable parcelable) {
        try {
            super.onRestoreInstanceState(parcelable);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void setAccessibilityProvider(@e a aVar) {
        this.f7982g = aVar;
    }

    public final void setAdapter(@e RecyclerView.Adapter<?> adapter) {
        RecyclerView.Adapter<?> adapter2 = this.b.getAdapter();
        a aVar = this.f7982g;
        if (aVar != null) {
            aVar.b(adapter2);
        }
        this.b.setAdapter(adapter);
        a aVar2 = this.f7982g;
        if (aVar2 == null) {
            return;
        }
        aVar2.a(adapter);
    }

    public final void setCurrentItem(int i2) {
        e(i2, this.f7981f);
    }

    public final void setIndicator(@e e.t.v.h.d.c cVar) {
        this.a = cVar;
    }

    public final void setMediator(@e e.t.v.h.a aVar) {
        this.f7980e = aVar;
    }

    public final void setOffscreenPageLimit(int i2) {
        if (i2 == 0 || this.b.getOffscreenPageLimit() == i2) {
            return;
        }
        this.b.setOffscreenPageLimit(i2);
    }

    public final void setOrientation(int i2) {
        this.b.setOrientation(i2);
    }

    public final void setScrollable(boolean z) {
        this.b.setUserInputEnabled(z);
    }

    public final void setSmoothScroll(boolean z) {
        this.f7981f = z;
    }

    @h
    public ViewPager2(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        androidx.viewpager2.widget.ViewPager2 viewPager2 = new androidx.viewpager2.widget.ViewPager2(context, attributeSet, i2);
        this.b = viewPager2;
        this.f7978c = new Rect();
        this.f7979d = new Rect();
        this.f7981f = true;
        viewPager2.setId(ViewCompat.generateViewId());
        viewPager2.setLayoutParams(p.v(-1, -1));
        attachViewToParent(viewPager2, 0, viewPager2.getLayoutParams());
    }
}

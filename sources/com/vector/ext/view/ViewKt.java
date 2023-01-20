package com.vector.ext.view;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.runtime.R;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.qiniu.android.collect.ReportItem;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.vector.ext.BitmapKt;
import com.vector.ext.view.ViewKt;
import e.t.l.d0.f;
import e.t.l.d0.h;
import e.t.l.k;
import e.t.u.o;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u0004\u001a\u001e\u0010\t\u001a\u00020\u0005*\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u001a\u0012\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005\u001a5\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\bø\u0001\u0000\u001a5\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\bø\u0001\u0000\u001a?\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052#\b\u0004\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\bø\u0001\u0000\u001a\f\u0010\u0015\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\n\b\u0000\u0010\u0018\u0018\u0001*\u00020\u0002*\u00020\u0002H\u0086\b\u001a \u0010\u0019\u001a\u0004\u0018\u0001H\u0018\"\n\b\u0000\u0010\u0018\u0018\u0001*\u00020\u0002*\u00020\u0002H\u0086\b¢\u0006\u0002\u0010\u001a\u001a\f\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u00020\u0002\u001a\f\u0010\u001d\u001a\u0004\u0018\u00010\u001e*\u00020\u0002\u001a\f\u0010\u001f\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010 \u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\n\u0010!\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\"\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010#\u001a\u00020\u0005*\u00020\u0002\u001a?\u0010$\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010&¢\u0006\u0002\u0010*\u001a/\u0010+\u001a\u00020\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0002*\u0004\u0018\u0001H\u00182\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\u0010,\u001a/\u0010-\u001a\u00020\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0002*\u0004\u0018\u0001H\u00182\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010,\u001a/\u0010.\u001a\u00020\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0002*\u0004\u0018\u0001H\u00182\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\u0010,\u001a\n\u0010/\u001a\u00020\u0001*\u00020\u0002\u001a\n\u00100\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u00101\u001a\u00020\u0001*\u00020\u00022\u0006\u00102\u001a\u00020\u0005\u001a\u0012\u00103\u001a\u00020\u0001*\u00020\u00022\u0006\u00104\u001a\u00020&\u001a\u0012\u00105\u001a\u00020\u0001*\u00020\u00022\u0006\u00106\u001a\u00020\u001e\u001a\u0012\u00107\u001a\u00020\u0001*\u00020\u00022\u0006\u00108\u001a\u00020&\u001a\f\u00109\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\n\u0010:\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010;\u001a\u00020<*\u00020\u00022\b\b\u0002\u0010=\u001a\u00020>\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006?"}, d2 = {"OnFocusChanged", "", "Landroid/view/View;", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "hasFocus", "bindForeground", "old", "Landroid/graphics/drawable/Drawable;", "new", "disableHardwareAcc", "compatible", "doOnLayout", "action", "view", "doOnNextLayout", "doOnPreDraw", "always", "ensureIdExist", "findAll", "", ExifInterface.GPS_DIRECTION_TRUE, "findFirst", "(Landroid/view/View;)Landroid/view/View;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "gone", "hide", "hideKeyboard", "isNotVisible", "isVisible", "margin", "left", "", "top", "right", "bottom", "(Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "onClick", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "onLongClick", "onSingleClick", "removeOnClick", "removeOnLongClick", "requestFocus", "focus", "setHeight", "height", "setLifecycleOwner", TUIConstants.TUIChat.OWNER, "setWidth", "width", TTLogUtil.TAG_EVENT_SHOW, "showKeyboard", "toBitmap", "Landroid/graphics/Bitmap;", "config", "Landroid/graphics/Bitmap$Config;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewKt {

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"com/vector/ext/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ l a;

        public a(l lVar) {
            this.a = lVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@k.e.a.d View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            view.removeOnLayoutChangeListener(this);
            this.a.invoke(view);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"com/vector/ext/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ l<View, t1> a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(l<? super View, t1> lVar) {
            this.a = lVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@k.e.a.d View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            view.removeOnLayoutChangeListener(this);
            this.a.invoke(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/vector/ext/view/ViewKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ l<View, t1> a;
        public final /* synthetic */ View b;

        /* renamed from: c */
        public final /* synthetic */ boolean f7808c;

        /* renamed from: d */
        public final /* synthetic */ ViewTreeObserver f7809d;

        /* JADX WARN: Multi-variable type inference failed */
        public c(l<? super View, t1> lVar, View view, boolean z, ViewTreeObserver viewTreeObserver) {
            this.a = lVar;
            this.b = view;
            this.f7808c = z;
            this.f7809d = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.a.invoke(this.b);
            if (this.f7808c) {
                return true;
            }
            if (this.f7809d.isAlive()) {
                this.f7809d.removeOnPreDrawListener(this);
                return true;
            }
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/vector/ext/view/ViewKt$onSingleClick$1", "Lcom/vector/ext/view/SingleClickListener;", "onSingleClick", "", "v", "Landroid/view/View;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class d extends f {

        /* renamed from: d */
        public final /* synthetic */ l<View, t1> f7810d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(l<? super View, t1> lVar) {
            this.f7810d = lVar;
        }

        @Override // e.t.l.d0.f
        public void c(@k.e.a.d View view) {
            this.f7810d.invoke(view);
        }
    }

    public static final boolean A(l lVar, View view) {
        return ((Boolean) lVar.invoke(view)).booleanValue();
    }

    public static final <T extends View> void B(@e T t, @k.e.a.d l<? super View, t1> lVar) {
        if (t == null) {
            return;
        }
        t.setOnClickListener(new d(lVar));
    }

    public static final void C(@k.e.a.d View view) {
        view.setOnClickListener(null);
        view.setClickable(false);
    }

    public static final void D(@k.e.a.d View view) {
        view.setOnLongClickListener(null);
    }

    public static final void E(@k.e.a.d View view, boolean z) {
        if (z) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        } else if (z) {
        } else {
            view.clearFocus();
        }
    }

    public static final void F(@k.e.a.d View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    public static final void G(@k.e.a.d View view, @k.e.a.d LifecycleOwner lifecycleOwner) {
        int i2 = R.id.view_tree_lifecycle_owner;
        Object tag = view.getTag(i2);
        LifecycleOwner lifecycleOwner2 = tag instanceof LifecycleOwner ? (LifecycleOwner) tag : null;
        if (lifecycleOwner2 == null || !f0.g(lifecycleOwner2, lifecycleOwner)) {
            view.setTag(i2, lifecycleOwner);
        }
    }

    public static final void H(@k.e.a.d View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = i2;
        view.setLayoutParams(layoutParams);
    }

    public static final void I(@e View view) {
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        view.setVisibility(0);
    }

    public static final void J(@k.e.a.d View view) {
        o.a.h(view);
    }

    @k.e.a.d
    public static final Bitmap K(@k.e.a.d View view, @k.e.a.d Bitmap.Config config) {
        if (ViewCompat.isLaidOut(view)) {
            return BitmapKt.a(Bitmap.createBitmap(view.getWidth(), view.getHeight(), config), new ViewKt$toBitmap$1(view));
        }
        throw new IllegalStateException("View needs to be laid out before calling toBitmap()");
    }

    public static /* synthetic */ Bitmap L(View view, Bitmap.Config config, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return K(view, config);
    }

    public static final void a(@k.e.a.d View view, @k.e.a.d final l<? super Boolean, t1> lVar) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: e.t.l.d0.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z) {
                ViewKt.b(lVar, view2, z);
            }
        });
    }

    public static final void b(l lVar, View view, boolean z) {
        lVar.invoke(Boolean.valueOf(z));
    }

    public static final boolean c(@k.e.a.d View view, @e Drawable drawable, @e Drawable drawable2) {
        if (f0.g(drawable, drawable2)) {
            return false;
        }
        if (drawable != null) {
            drawable.setCallback(null);
            view.unscheduleDrawable(drawable);
        }
        if (drawable2 != null) {
            view.setWillNotDraw(false);
            drawable2.setCallback(view);
            if (drawable2.isStateful()) {
                drawable2.setState(view.getDrawableState());
            }
        } else {
            view.setWillNotDraw(true);
        }
        view.requestLayout();
        view.invalidate();
        return true;
    }

    public static final void d(@k.e.a.d View view, boolean z) {
        if (z) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 18 || i2 < 11) {
                return;
            }
            view.setLayerType(1, null);
            return;
        }
        view.setLayerType(1, null);
    }

    public static final void e(@k.e.a.d View view, @k.e.a.d l<? super View, t1> lVar) {
        if (ViewCompat.isLaidOut(view) && !view.isLayoutRequested()) {
            lVar.invoke(view);
        } else {
            view.addOnLayoutChangeListener(new a(lVar));
        }
    }

    public static final void f(@k.e.a.d View view, @k.e.a.d l<? super View, t1> lVar) {
        view.addOnLayoutChangeListener(new b(lVar));
    }

    public static final void g(@k.e.a.d View view, boolean z, @k.e.a.d l<? super View, t1> lVar) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnPreDrawListener(new c(lVar, view, z, viewTreeObserver));
        }
    }

    public static /* synthetic */ void h(View view, boolean z, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnPreDrawListener(new c(lVar, view, z, viewTreeObserver));
        }
    }

    public static final void i(@e View view) {
        if (view != null && view.getId() == -1) {
            view.setId(View.generateViewId());
        }
    }

    public static final /* synthetic */ <T extends View> List<T> j(View view) {
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(view);
        while (!arrayDeque.isEmpty()) {
            View view2 = (View) arrayDeque.getFirst();
            if (view2 instanceof ViewGroup) {
                h.a((ViewGroup) view2, new ViewKt$findAll$1(arrayDeque));
            }
            f0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (view2 instanceof View) {
                arrayList.add(view2);
            }
            arrayDeque.pollFirst();
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T extends View> T k(View view) {
        if (view instanceof ViewGroup) {
            int i2 = 0;
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount <= 0) {
                return null;
            }
            while (true) {
                int i3 = i2 + 1;
                T t = (T) viewGroup.getChildAt(i2);
                f0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (t instanceof View) {
                    return t;
                }
                if (i3 >= childCount) {
                    return null;
                }
                i2 = i3;
            }
        } else {
            f0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (view instanceof View) {
                return view;
            }
            return null;
        }
    }

    @e
    public static final Lifecycle l(@k.e.a.d View view) {
        Object tag = view.getTag(R.id.view_tree_lifecycle_owner);
        LifecycleOwner lifecycleOwner = tag instanceof LifecycleOwner ? (LifecycleOwner) tag : null;
        Lifecycle lifecycle = lifecycleOwner == null ? null : lifecycleOwner.getLifecycle();
        if (lifecycle == null) {
            LifecycleOwner findViewTreeLifecycleOwner = androidx.lifecycle.ViewKt.findViewTreeLifecycleOwner(view);
            Lifecycle lifecycle2 = findViewTreeLifecycleOwner != null ? findViewTreeLifecycleOwner.getLifecycle() : null;
            return lifecycle2 == null ? k.f(view.getContext()) : lifecycle2;
        }
        return lifecycle;
    }

    @e
    public static final LifecycleOwner m(@k.e.a.d View view) {
        Object tag = view.getTag(R.id.view_tree_lifecycle_owner);
        LifecycleOwner lifecycleOwner = tag instanceof LifecycleOwner ? (LifecycleOwner) tag : null;
        if (lifecycleOwner == null) {
            LifecycleOwner findViewTreeLifecycleOwner = androidx.lifecycle.ViewKt.findViewTreeLifecycleOwner(view);
            return findViewTreeLifecycleOwner == null ? k.a(view.getContext()) : findViewTreeLifecycleOwner;
        }
        return lifecycleOwner;
    }

    public static final void n(@e View view) {
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        view.setVisibility(8);
    }

    public static final void o(@e View view) {
        if (view == null || view.getVisibility() == 4) {
            return;
        }
        view.setVisibility(4);
    }

    public static final void p(@k.e.a.d View view) {
        if (o.a.f(view)) {
            o.c(view, false, 2, null);
        }
    }

    public static final boolean q(@k.e.a.d View view) {
        return view.getVisibility() != 0;
    }

    public static final boolean r(@k.e.a.d View view) {
        return view.getVisibility() == 0;
    }

    public static final void v(@k.e.a.d View view, @e Integer num, @e Integer num2, @e Integer num3, @e Integer num4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if (num != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = num.intValue();
            }
            if (num2 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = num2.intValue();
            }
            if (num3 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = num3.intValue();
            }
            if (num4 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = num4.intValue();
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static /* synthetic */ void w(View view, Integer num, Integer num2, Integer num3, Integer num4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        if ((i2 & 2) != 0) {
            num2 = null;
        }
        if ((i2 & 4) != 0) {
            num3 = null;
        }
        if ((i2 & 8) != 0) {
            num4 = null;
        }
        v(view, num, num2, num3, num4);
    }

    public static final <T extends View> void x(@e T t, @k.e.a.d final l<? super View, t1> lVar) {
        if (t == null) {
            return;
        }
        t.setOnClickListener(new View.OnClickListener() { // from class: e.t.l.d0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewKt.y(lVar, view);
            }
        });
    }

    public static final void y(l lVar, View view) {
        lVar.invoke(view);
    }

    public static final <T extends View> void z(@e T t, @k.e.a.d final l<? super View, Boolean> lVar) {
        if (t == null) {
            return;
        }
        t.setOnLongClickListener(new View.OnLongClickListener() { // from class: e.t.l.d0.c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean A;
                A = ViewKt.A(lVar, view);
                return A;
            }
        });
    }
}

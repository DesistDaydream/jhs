package com.vector.design.ui.decor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.vector.ext.AnyKt;
import h.k2.h;
import h.k2.u.a;
import h.k2.v.u;
import h.t1;
import java.lang.ref.WeakReference;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\r\u0010\u001e\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u001fJ\u001f\u0010\u001e\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b\u001fJ\u0018\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0018\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!H\u0002J\u0012\u0010(\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u0007H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/vector/design/ui/decor/PlaceHolder;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "replaceView", "getReplaceView", "()Landroid/view/View;", "setReplaceView", "(Landroid/view/View;)V", "viewConstructor", "Lkotlin/Function0;", "Lcom/vector/design/ui/decor/CreateView;", "getViewConstructor", "()Lkotlin/jvm/functions/Function0;", "setViewConstructor", "(Lkotlin/jvm/functions/Function0;)V", "viewRef", "Ljava/lang/ref/WeakReference;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "draw", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "inflate", "inflate$vector_release", "parent", "Landroid/view/ViewGroup;", "params", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "replaceSelfWithView", "view", "setLayoutParams", "setVisibility", "visibility", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PlaceHolder extends View {
    @e
    private View a;
    @e
    private a<? extends View> b;
    @e

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<View> f7748c;

    @h
    public PlaceHolder(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public PlaceHolder(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ PlaceHolder(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void c(View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = super.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    public final void a() {
        WeakReference<View> weakReference = this.f7748c;
        if ((weakReference == null ? null : weakReference.get()) != null) {
            return;
        }
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            View view = this.a;
            if (view == null) {
                a<? extends View> aVar = this.b;
                View invoke = aVar != null ? aVar.invoke() : null;
                view = invoke == null ? (View) AnyKt.I(this, "view can not be null") : invoke;
            }
            c(view, (ViewGroup) parent);
            this.f7748c = new WeakReference<>(view);
            return;
        }
        throw new IllegalStateException("viewParent is null or is not ViewGroup");
    }

    public final void b(@d ViewGroup viewGroup, @e ViewGroup.LayoutParams layoutParams) {
        WeakReference<View> weakReference = this.f7748c;
        if ((weakReference == null ? null : weakReference.get()) != null) {
            return;
        }
        View view = this.a;
        if (view == null) {
            a<? extends View> aVar = this.b;
            View invoke = aVar != null ? aVar.invoke() : null;
            view = invoke == null ? (View) AnyKt.I(this, "view can not be null") : invoke;
        }
        if (layoutParams != null) {
            viewGroup.addView(view, layoutParams);
        } else {
            viewGroup.addView(view);
        }
        this.f7748c = new WeakReference<>(view);
    }

    @Override // android.view.View
    public void dispatchDraw(@d Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(@d Canvas canvas) {
    }

    @Override // android.view.View
    @e
    public ViewGroup.LayoutParams getLayoutParams() {
        View view;
        WeakReference<View> weakReference = this.f7748c;
        ViewGroup.LayoutParams layoutParams = null;
        if (weakReference != null && (view = weakReference.get()) != null) {
            layoutParams = view.getLayoutParams();
        }
        return layoutParams == null ? super.getLayoutParams() : layoutParams;
    }

    @e
    public final View getReplaceView() {
        return this.a;
    }

    @e
    public final a<View> getViewConstructor() {
        return this.b;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void setLayoutParams(@e ViewGroup.LayoutParams layoutParams) {
        View view;
        WeakReference<View> weakReference = this.f7748c;
        t1 t1Var = null;
        if (weakReference != null && (view = weakReference.get()) != null) {
            view.setLayoutParams(layoutParams);
            t1Var = t1.a;
        }
        if (t1Var == null) {
            super.setLayoutParams(layoutParams);
        }
    }

    public final void setReplaceView(@e View view) {
        this.a = view;
    }

    public final void setViewConstructor(@e a<? extends View> aVar) {
        this.b = aVar;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        WeakReference<View> weakReference = this.f7748c;
        if (weakReference != null) {
            View view = weakReference == null ? null : weakReference.get();
            if (view != null) {
                view.setVisibility(i2);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i2);
        if (i2 == 0 || i2 == 4) {
            a();
        }
    }

    @h
    public PlaceHolder(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setVisibility(8);
        setWillNotDraw(true);
    }
}

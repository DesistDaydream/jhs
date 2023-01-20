package com.bytedance.msdk.core.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.bytedance.msdk.adapter.util.Logger;

/* loaded from: classes.dex */
public class RefreshableBannerView extends FrameLayout {
    private boolean a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2187c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f2188d;

    /* renamed from: e  reason: collision with root package name */
    private final ViewTreeObserver.OnScrollChangedListener f2189e;

    /* renamed from: f  reason: collision with root package name */
    private c f2190f;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            RefreshableBannerView refreshableBannerView = RefreshableBannerView.this;
            refreshableBannerView.b = refreshableBannerView.getGlobalVisibleRect(refreshableBannerView.f2188d);
            RefreshableBannerView refreshableBannerView2 = RefreshableBannerView.this;
            refreshableBannerView2.b(refreshableBannerView2.b);
        }
    }

    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (RefreshableBannerView.this.getChildCount() > 1) {
                RefreshableBannerView.this.removeViewAt(0);
                Logger.d("TMe", "--==-- after remove, view count: " + RefreshableBannerView.this.getChildCount());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z);
    }

    public RefreshableBannerView(Context context) {
        super(context);
        this.a = true;
        this.b = true;
        this.f2187c = true;
        this.f2188d = new Rect();
        this.f2189e = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        boolean z2 = this.a && this.b;
        if (z) {
            if (!z2 || this.f2187c) {
                return;
            }
            this.f2187c = true;
            c cVar = this.f2190f;
            if (cVar != null) {
                cVar.a(true);
            }
        } else if (z2 || !this.f2187c) {
        } else {
            this.f2187c = false;
            c cVar2 = this.f2190f;
            if (cVar2 != null) {
                cVar2.a(false);
            }
        }
    }

    @UiThread
    public void a(View view) {
        view.setTranslationX(getWidth());
        addView(view);
        ObjectAnimator.ofFloat(view, "translationX", 0.0f).setDuration(250L).start();
        if (getChildCount() > 1) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(getChildAt(0), "translationX", -getWidth()).setDuration(250L);
            duration.addListener(new b());
            duration.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.f2189e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.f2189e);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        boolean z = i2 == 0;
        this.a = z;
        b(z);
    }

    public void setVisibilityChangeListener(c cVar) {
        this.f2190f = cVar;
    }
}

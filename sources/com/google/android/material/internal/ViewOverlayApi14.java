package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import e.j.a.c.s.o;
import e.j.a.c.s.s;
import e.j.a.c.s.t;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ViewOverlayApi14 implements s {
    public OverlayViewGroup a;

    @SuppressLint({"ViewConstructor", "PrivateApi"})
    /* loaded from: classes2.dex */
    public static class OverlayViewGroup extends ViewGroup {

        /* renamed from: f  reason: collision with root package name */
        public static Method f2955f;
        public ViewGroup a;
        public View b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<Drawable> f2956c;

        /* renamed from: d  reason: collision with root package name */
        public ViewOverlayApi14 f2957d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2958e;

        static {
            try {
                Class cls = Integer.TYPE;
                f2955f = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        public OverlayViewGroup(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
            super(context);
            this.f2956c = null;
            this.a = viewGroup;
            this.b = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f2957d = viewOverlayApi14;
        }

        private void c() {
            if (this.f2958e) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void d() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f2956c;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f2958e = true;
                    this.a.removeView(this);
                }
            }
        }

        private void e(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.a.getLocationOnScreen(iArr2);
            this.b.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void a(Drawable drawable) {
            c();
            if (this.f2956c == null) {
                this.f2956c = new ArrayList<>();
            }
            if (this.f2956c.contains(drawable)) {
                return;
            }
            this.f2956c.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(View view) {
            c();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.a && viewGroup.getParent() != null && ViewCompat.isAttachedToWindow(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.a.getLocationOnScreen(iArr2);
                    ViewCompat.offsetLeftAndRight(view, iArr[0] - iArr2[0]);
                    ViewCompat.offsetTopAndBottom(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.a.getLocationOnScreen(iArr);
            this.b.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.b.getWidth(), this.b.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f2956c;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f2956c.get(i2).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ViewParent f(int i2, int i3, Rect rect) {
            if (this.a == null || f2955f == null) {
                return null;
            }
            try {
                e(new int[2]);
                f2955f.invoke(this.a, Integer.valueOf(i2), Integer.valueOf(i3), rect);
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return null;
            }
        }

        public void g(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f2956c;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                d();
            }
        }

        public void h(View view) {
            super.removeView(view);
            d();
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.a != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.a != null) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    e(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
                return null;
            }
            return null;
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        @Override // android.view.View
        public boolean verifyDrawable(@NonNull Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f2956c) != null && arrayList.contains(drawable));
        }
    }

    public ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        this.a = new OverlayViewGroup(context, viewGroup, view, this);
    }

    public static ViewOverlayApi14 a(View view) {
        ViewGroup f2 = t.f(view);
        if (f2 != null) {
            int childCount = f2.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = f2.getChildAt(i2);
                if (childAt instanceof OverlayViewGroup) {
                    return ((OverlayViewGroup) childAt).f2957d;
                }
            }
            return new o(f2.getContext(), f2, view);
        }
        return null;
    }

    @Override // e.j.a.c.s.s
    public void add(@NonNull Drawable drawable) {
        this.a.a(drawable);
    }

    @Override // e.j.a.c.s.s
    public void remove(@NonNull Drawable drawable) {
        this.a.g(drawable);
    }
}

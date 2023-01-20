package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import e.j.a.c.q.b;
import java.util.List;

@Deprecated
/* loaded from: classes2.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private static final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3132c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f3133d = 2;
    private int a;

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f3134c;

        public a(View view, int i2, b bVar) {
            this.a = view;
            this.b = i2;
            this.f3134c = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.a == this.b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                b bVar = this.f3134c;
                expandableBehavior.e((View) bVar, this.a, bVar.b(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.a = 0;
    }

    private boolean b(boolean z) {
        if (!z) {
            return this.a == 1;
        }
        int i2 = this.a;
        return i2 == 0 || i2 == 2;
    }

    @Nullable
    public static <T extends ExpandableBehavior> T d(@NonNull View view, @NonNull Class<T> cls) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof ExpandableBehavior) {
                return cls.cast(behavior);
            }
            throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    @Nullable
    public b c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = dependencies.get(i2);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (b) view2;
            }
        }
        return null;
    }

    public abstract boolean e(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b bVar = (b) view2;
        if (b(bVar.b())) {
            this.a = bVar.b() ? 1 : 2;
            return e((View) bVar, view, bVar.b(), true);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
        b c2;
        if (ViewCompat.isLaidOut(view) || (c2 = c(coordinatorLayout, view)) == null || !b(c2.b())) {
            return false;
        }
        int i3 = c2.b() ? 1 : 2;
        this.a = i3;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i3, c2));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
    }
}

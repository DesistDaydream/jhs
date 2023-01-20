package com.google.android.material.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import e.j.a.c.s.f;
import e.j.a.c.s.g;
import e.j.a.c.z.j;
import e.j.a.c.z.k;
import e.j.a.c.z.o;

/* loaded from: classes2.dex */
public class NavigationView extends ScrimInsetsFrameLayout {

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f2993m = {16842912};
    private static final int[] n = {-16842910};
    private static final int o = R.style.Widget_Design_NavigationView;
    private static final int p = 1;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final f f2994f;

    /* renamed from: g  reason: collision with root package name */
    private final g f2995g;

    /* renamed from: h  reason: collision with root package name */
    public c f2996h;

    /* renamed from: i  reason: collision with root package name */
    private final int f2997i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f2998j;

    /* renamed from: k  reason: collision with root package name */
    private MenuInflater f2999k;

    /* renamed from: l  reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f3000l;

    /* loaded from: classes2.dex */
    public class a implements MenuBuilder.Callback {
        public a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            c cVar = NavigationView.this.f2996h;
            return cVar != null && cVar.a(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.f2998j);
            boolean z = true;
            boolean z2 = NavigationView.this.f2998j[1] == 0;
            NavigationView.this.f2995g.p(z2);
            NavigationView.this.setDrawTopInsetForeground(z2);
            Activity activity = e.j.a.c.s.b.getActivity(NavigationView.this.getContext());
            if (activity == null || Build.VERSION.SDK_INT < 21) {
                return;
            }
            NavigationView.this.setDrawBottomInsetForeground(((activity.findViewById(16908290).getHeight() == NavigationView.this.getHeight()) && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0)) ? false : false);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean a(@NonNull MenuItem menuItem);
    }

    public NavigationView(@NonNull Context context) {
        this(context, null);
    }

    @Nullable
    private ColorStateList e(int i2) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
            if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
                int i3 = typedValue.data;
                int defaultColor = colorStateList.getDefaultColor();
                int[] iArr = n;
                return new ColorStateList(new int[][]{iArr, f2993m, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i3, defaultColor});
            }
            return null;
        }
        return null;
    }

    @NonNull
    private final Drawable f(@NonNull TintTypedArray tintTypedArray) {
        j jVar = new j(o.b(getContext(), tintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearance, 0), tintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).m());
        jVar.n0(e.j.a.c.w.c.b(getContext(), tintTypedArray, R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable((Drawable) jVar, tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetStart, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetTop, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetEnd, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private MenuInflater getMenuInflater() {
        if (this.f2999k == null) {
            this.f2999k = new SupportMenuInflater(getContext());
        }
        return this.f2999k;
    }

    private boolean h(@NonNull TintTypedArray tintTypedArray) {
        return tintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearance) || tintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    private void l() {
        this.f3000l = new b();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f3000l);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.f2995g.c(windowInsetsCompat);
    }

    public void d(@NonNull View view) {
        this.f2995g.b(view);
    }

    public View g(int i2) {
        return this.f2995g.f(i2);
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.f2995g.d();
    }

    public int getHeaderCount() {
        return this.f2995g.e();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f2995g.g();
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.f2995g.h();
    }

    @Dimension
    public int getItemIconPadding() {
        return this.f2995g.i();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f2995g.l();
    }

    public int getItemMaxLines() {
        return this.f2995g.j();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f2995g.k();
    }

    @NonNull
    public Menu getMenu() {
        return this.f2994f;
    }

    public View i(@LayoutRes int i2) {
        return this.f2995g.m(i2);
    }

    public void j(int i2) {
        this.f2995g.B(true);
        getMenuInflater().inflate(i2, this.f2994f);
        this.f2995g.B(false);
        this.f2995g.updateMenuView(false);
    }

    public void k(@NonNull View view) {
        this.f2995g.o(view);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.e(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.f3000l);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.f3000l);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.f2997i), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.f2997i, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2994f.restorePresenterStates(savedState.menuState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.f2994f.savePresenterStates(bundle);
        return savedState;
    }

    public void setCheckedItem(@IdRes int i2) {
        MenuItem findItem = this.f2994f.findItem(i2);
        if (findItem != null) {
            this.f2995g.q((MenuItemImpl) findItem);
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f2);
        }
        k.d(this, f2);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f2995g.s(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setItemHorizontalPadding(@Dimension int i2) {
        this.f2995g.t(i2);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int i2) {
        this.f2995g.t(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconPadding(@Dimension int i2) {
        this.f2995g.u(i2);
    }

    public void setItemIconPaddingResource(int i2) {
        this.f2995g.u(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconSize(@Dimension int i2) {
        this.f2995g.v(i2);
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f2995g.w(colorStateList);
    }

    public void setItemMaxLines(int i2) {
        this.f2995g.x(i2);
    }

    public void setItemTextAppearance(@StyleRes int i2) {
        this.f2995g.y(i2);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f2995g.z(colorStateList);
    }

    public void setNavigationItemSelectedListener(@Nullable c cVar) {
        this.f2996h = cVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        super.setOverScrollMode(i2);
        g gVar = this.f2995g;
        if (gVar != null) {
            gVar.A(i2);
        }
    }

    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        @Nullable
        public Bundle menuState;

        /* loaded from: classes2.dex */
        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.menuState);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NavigationView(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem findItem = this.f2994f.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.f2995g.q((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}

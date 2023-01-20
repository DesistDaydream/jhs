package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import e.j.a.c.s.m;
import e.j.a.c.s.t;
import e.j.a.c.z.j;
import e.j.a.c.z.k;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public abstract class NavigationBarView extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public static final int f2983h = -1;

    /* renamed from: i  reason: collision with root package name */
    public static final int f2984i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f2985j = 1;

    /* renamed from: k  reason: collision with root package name */
    public static final int f2986k = 2;

    /* renamed from: l  reason: collision with root package name */
    private static final int f2987l = 1;
    @NonNull
    private final e.j.a.c.u.a a;
    @NonNull
    private final NavigationBarMenuView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final NavigationBarPresenter f2988c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f2989d;

    /* renamed from: e  reason: collision with root package name */
    private MenuInflater f2990e;

    /* renamed from: f  reason: collision with root package name */
    private e f2991f;

    /* renamed from: g  reason: collision with root package name */
    private d f2992g;

    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        @Nullable
        public Bundle menuPresenterState;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void readFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            this.menuPresenterState = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.menuPresenterState);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            readFromParcel(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    /* loaded from: classes2.dex */
    public class a implements MenuBuilder.Callback {
        public a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            if (NavigationBarView.this.f2992g == null || menuItem.getItemId() != NavigationBarView.this.getSelectedItemId()) {
                return (NavigationBarView.this.f2991f == null || NavigationBarView.this.f2991f.a(menuItem)) ? false : true;
            }
            NavigationBarView.this.f2992g.a(menuItem);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    /* loaded from: classes2.dex */
    public class b implements t.e {
        public b() {
        }

        @Override // e.j.a.c.s.t.e
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull t.f fVar) {
            fVar.f11007d += windowInsetsCompat.getSystemWindowInsetBottom();
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
            int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
            fVar.a += z ? systemWindowInsetRight : systemWindowInsetLeft;
            int i2 = fVar.f11006c;
            if (!z) {
                systemWindowInsetLeft = systemWindowInsetRight;
            }
            fVar.f11006c = i2 + systemWindowInsetLeft;
            fVar.a(view);
            return windowInsetsCompat;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface c {
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(@NonNull MenuItem menuItem);
    }

    /* loaded from: classes2.dex */
    public interface e {
        boolean a(@NonNull MenuItem menuItem);
    }

    public NavigationBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(e.j.a.c.e0.a.a.c(context, attributeSet, i2, i3), attributeSet, i2);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.f2988c = navigationBarPresenter;
        Context context2 = getContext();
        int[] iArr = R.styleable.NavigationBarView;
        int i4 = R.styleable.NavigationBarView_itemTextAppearanceInactive;
        int i5 = R.styleable.NavigationBarView_itemTextAppearanceActive;
        TintTypedArray k2 = m.k(context2, attributeSet, iArr, i2, i3, i4, i5);
        e.j.a.c.u.a aVar = new e.j.a.c.u.a(context2, getClass(), getMaxItemCount());
        this.a = aVar;
        NavigationBarMenuView e2 = e(context2);
        this.b = e2;
        navigationBarPresenter.b(e2);
        navigationBarPresenter.a(1);
        e2.setPresenter(navigationBarPresenter);
        aVar.addMenuPresenter(navigationBarPresenter);
        navigationBarPresenter.initForMenu(getContext(), aVar);
        int i6 = R.styleable.NavigationBarView_itemIconTint;
        if (k2.hasValue(i6)) {
            e2.setIconTintList(k2.getColorStateList(i6));
        } else {
            e2.setIconTintList(e2.d(16842808));
        }
        setItemIconSize(k2.getDimensionPixelSize(R.styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (k2.hasValue(i4)) {
            setItemTextAppearanceInactive(k2.getResourceId(i4, 0));
        }
        if (k2.hasValue(i5)) {
            setItemTextAppearanceActive(k2.getResourceId(i5, 0));
        }
        int i7 = R.styleable.NavigationBarView_itemTextColor;
        if (k2.hasValue(i7)) {
            setItemTextColor(k2.getColorStateList(i7));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            ViewCompat.setBackground(this, d(context2));
        }
        int i8 = R.styleable.NavigationBarView_elevation;
        if (k2.hasValue(i8)) {
            setElevation(k2.getDimensionPixelSize(i8, 0));
        }
        DrawableCompat.setTintList(getBackground().mutate(), e.j.a.c.w.c.b(context2, k2, R.styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(k2.getInteger(R.styleable.NavigationBarView_labelVisibilityMode, -1));
        int resourceId = k2.getResourceId(R.styleable.NavigationBarView_itemBackground, 0);
        if (resourceId != 0) {
            e2.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(e.j.a.c.w.c.b(context2, k2, R.styleable.NavigationBarView_itemRippleColor));
        }
        int i9 = R.styleable.NavigationBarView_menu;
        if (k2.hasValue(i9)) {
            h(k2.getResourceId(i9, 0));
        }
        k2.recycle();
        addView(e2);
        aVar.setCallback(new a());
        c();
    }

    private void c() {
        t.d(this, new b());
    }

    @NonNull
    private j d(Context context) {
        j jVar = new j();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            jVar.n0(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        jVar.Y(context);
        return jVar;
    }

    private MenuInflater getMenuInflater() {
        if (this.f2990e == null) {
            this.f2990e = new SupportMenuInflater(getContext());
        }
        return this.f2990e;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract NavigationBarMenuView e(@NonNull Context context);

    @Nullable
    public BadgeDrawable f(int i2) {
        return this.b.g(i2);
    }

    @NonNull
    public BadgeDrawable g(int i2) {
        return this.b.h(i2);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.b.getItemBackground();
    }

    @DrawableRes
    @Deprecated
    public int getItemBackgroundResource() {
        return this.b.getItemBackgroundRes();
    }

    @Dimension
    public int getItemIconSize() {
        return this.b.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.b.getIconTintList();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.f2989d;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.b.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.b.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return this.a;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MenuView getMenuView() {
        return this.b;
    }

    @NonNull
    public NavigationBarPresenter getPresenter() {
        return this.f2988c;
    }

    @IdRes
    public int getSelectedItemId() {
        return this.b.getSelectedItemId();
    }

    public void h(int i2) {
        this.f2988c.c(true);
        getMenuInflater().inflate(i2, this.a);
        this.f2988c.c(false);
        this.f2988c.updateMenuView(true);
    }

    public void i(int i2) {
        this.b.k(i2);
    }

    public void j(int i2, @Nullable View.OnTouchListener onTouchListener) {
        this.b.m(i2, onTouchListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.e(this);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.a.restorePresenterStates(savedState.menuPresenterState);
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuPresenterState = bundle;
        this.a.savePresenterStates(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f2);
        }
        k.d(this, f2);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.b.setItemBackground(drawable);
        this.f2989d = null;
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        this.b.setItemBackgroundRes(i2);
        this.f2989d = null;
    }

    public void setItemIconSize(@Dimension int i2) {
        this.b.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(@DimenRes int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.b.setIconTintList(colorStateList);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f2989d == colorStateList) {
            if (colorStateList != null || this.b.getItemBackground() == null) {
                return;
            }
            this.b.setItemBackground(null);
            return;
        }
        this.f2989d = colorStateList;
        if (colorStateList == null) {
            this.b.setItemBackground(null);
            return;
        }
        ColorStateList a2 = e.j.a.c.x.b.a(colorStateList);
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.setItemBackground(new RippleDrawable(a2, null, null));
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(1.0E-5f);
        Drawable wrap = DrawableCompat.wrap(gradientDrawable);
        DrawableCompat.setTintList(wrap, a2);
        this.b.setItemBackground(wrap);
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        this.b.setItemTextAppearanceActive(i2);
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        this.b.setItemTextAppearanceInactive(i2);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.b.getLabelVisibilityMode() != i2) {
            this.b.setLabelVisibilityMode(i2);
            this.f2988c.updateMenuView(false);
        }
    }

    public void setOnItemReselectedListener(@Nullable d dVar) {
        this.f2992g = dVar;
    }

    public void setOnItemSelectedListener(@Nullable e eVar) {
        this.f2991f = eVar;
    }

    public void setSelectedItemId(@IdRes int i2) {
        MenuItem findItem = this.a.findItem(i2);
        if (findItem == null || this.a.performItemAction(findItem, this.f2988c, 0)) {
            return;
        }
        findItem.setChecked(true);
    }
}

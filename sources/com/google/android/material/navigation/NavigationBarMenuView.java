package com.google.android.material.navigation;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.badge.BadgeDrawable;
import e.j.a.c.s.k;
import java.util.HashSet;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final long t = 115;
    private static final int u = 5;
    private static final int[] v = {16842912};
    private static final int[] w = {-16842910};
    @NonNull
    private final TransitionSet a;
    @NonNull
    private final View.OnClickListener b;

    /* renamed from: c  reason: collision with root package name */
    private final Pools.Pool<NavigationBarItemView> f2970c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final SparseArray<View.OnTouchListener> f2971d;

    /* renamed from: e  reason: collision with root package name */
    private int f2972e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private NavigationBarItemView[] f2973f;

    /* renamed from: g  reason: collision with root package name */
    private int f2974g;

    /* renamed from: h  reason: collision with root package name */
    private int f2975h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private ColorStateList f2976i;
    @Dimension

    /* renamed from: j  reason: collision with root package name */
    private int f2977j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f2978k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private final ColorStateList f2979l;
    @StyleRes

    /* renamed from: m  reason: collision with root package name */
    private int f2980m;
    @StyleRes
    private int n;
    private Drawable o;
    private int p;
    @NonNull
    private SparseArray<BadgeDrawable> q;
    private NavigationBarPresenter r;
    private MenuBuilder s;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MenuItemImpl itemData = ((NavigationBarItemView) view).getItemData();
            if (NavigationBarMenuView.this.s.performItemAction(itemData, NavigationBarMenuView.this.r, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public NavigationBarMenuView(@NonNull Context context) {
        super(context);
        this.f2970c = new Pools.SynchronizedPool(5);
        this.f2971d = new SparseArray<>(5);
        this.f2974g = 0;
        this.f2975h = 0;
        this.q = new SparseArray<>(5);
        this.f2979l = d(16842808);
        AutoTransition autoTransition = new AutoTransition();
        this.a = autoTransition;
        autoTransition.setOrdering(0);
        autoTransition.setDuration(t);
        autoTransition.setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator());
        autoTransition.addTransition(new k());
        this.b = new a();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView acquire = this.f2970c.acquire();
        return acquire == null ? e(getContext()) : acquire;
    }

    private boolean j(int i2) {
        return i2 != -1;
    }

    private void l() {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            hashSet.add(Integer.valueOf(this.s.getItem(i2).getItemId()));
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            int keyAt = this.q.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.q.delete(keyAt);
            }
        }
    }

    private void p(int i2) {
        if (j(i2)) {
            return;
        }
        throw new IllegalArgumentException(i2 + " is not a valid view id");
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id = navigationBarItemView.getId();
        if (j(id) && (badgeDrawable = this.q.get(id)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void c() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f2973f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.f2970c.release(navigationBarItemView);
                    navigationBarItemView.f();
                }
            }
        }
        if (this.s.size() == 0) {
            this.f2974g = 0;
            this.f2975h = 0;
            this.f2973f = null;
            return;
        }
        l();
        this.f2973f = new NavigationBarItemView[this.s.size()];
        boolean i2 = i(this.f2972e, this.s.getVisibleItems().size());
        for (int i3 = 0; i3 < this.s.size(); i3++) {
            this.r.c(true);
            this.s.getItem(i3).setCheckable(true);
            this.r.c(false);
            NavigationBarItemView newItem = getNewItem();
            this.f2973f[i3] = newItem;
            newItem.setIconTintList(this.f2976i);
            newItem.setIconSize(this.f2977j);
            newItem.setTextColor(this.f2979l);
            newItem.setTextAppearanceInactive(this.f2980m);
            newItem.setTextAppearanceActive(this.n);
            newItem.setTextColor(this.f2978k);
            Drawable drawable = this.o;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.p);
            }
            newItem.setShifting(i2);
            newItem.setLabelVisibilityMode(this.f2972e);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.s.getItem(i3);
            newItem.initialize(menuItemImpl, 0);
            newItem.setItemPosition(i3);
            int itemId = menuItemImpl.getItemId();
            newItem.setOnTouchListener(this.f2971d.get(itemId));
            newItem.setOnClickListener(this.b);
            int i4 = this.f2974g;
            if (i4 != 0 && itemId == i4) {
                this.f2975h = i3;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.s.size() - 1, this.f2975h);
        this.f2975h = min;
        this.s.getItem(min).setChecked(true);
    }

    @Nullable
    public ColorStateList d(int i2) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
            if (getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
                int i3 = typedValue.data;
                int defaultColor = colorStateList.getDefaultColor();
                int[] iArr = w;
                return new ColorStateList(new int[][]{iArr, v, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i3, defaultColor});
            }
            return null;
        }
        return null;
    }

    @NonNull
    public abstract NavigationBarItemView e(@NonNull Context context);

    @Nullable
    public NavigationBarItemView f(int i2) {
        p(i2);
        NavigationBarItemView[] navigationBarItemViewArr = this.f2973f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getId() == i2) {
                    return navigationBarItemView;
                }
            }
            return null;
        }
        return null;
    }

    @Nullable
    public BadgeDrawable g(int i2) {
        return this.q.get(i2);
    }

    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.q;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.f2976i;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f2973f;
        if (navigationBarItemViewArr != null && navigationBarItemViewArr.length > 0) {
            return navigationBarItemViewArr[0].getBackground();
        }
        return this.o;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.p;
    }

    @Dimension
    public int getItemIconSize() {
        return this.f2977j;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.n;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.f2980m;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f2978k;
    }

    public int getLabelVisibilityMode() {
        return this.f2972e;
    }

    @Nullable
    public MenuBuilder getMenu() {
        return this.s;
    }

    public int getSelectedItemId() {
        return this.f2974g;
    }

    public int getSelectedItemPosition() {
        return this.f2975h;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    public BadgeDrawable h(int i2) {
        p(i2);
        BadgeDrawable badgeDrawable = this.q.get(i2);
        if (badgeDrawable == null) {
            badgeDrawable = BadgeDrawable.d(getContext());
            this.q.put(i2, badgeDrawable);
        }
        NavigationBarItemView f2 = f(i2);
        if (f2 != null) {
            f2.setBadge(badgeDrawable);
        }
        return badgeDrawable;
    }

    public boolean i(int i2, int i3) {
        if (i2 == -1) {
            if (i3 > 3) {
                return true;
            }
        } else if (i2 == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(@NonNull MenuBuilder menuBuilder) {
        this.s = menuBuilder;
    }

    public void k(int i2) {
        p(i2);
        BadgeDrawable badgeDrawable = this.q.get(i2);
        NavigationBarItemView f2 = f(i2);
        if (f2 != null) {
            f2.f();
        }
        if (badgeDrawable != null) {
            this.q.remove(i2);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void m(int i2, @Nullable View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.f2971d.remove(i2);
        } else {
            this.f2971d.put(i2, onTouchListener);
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f2973f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getItemData().getItemId() == i2) {
                    navigationBarItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void n(int i2) {
        int size = this.s.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.s.getItem(i3);
            if (i2 == item.getItemId()) {
                this.f2974g = i2;
                this.f2975h = i3;
                item.setChecked(true);
                return;
            }
        }
    }

    public void o() {
        MenuBuilder menuBuilder = this.s;
        if (menuBuilder == null || this.f2973f == null) {
            return;
        }
        int size = menuBuilder.size();
        if (size != this.f2973f.length) {
            c();
            return;
        }
        int i2 = this.f2974g;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.s.getItem(i3);
            if (item.isChecked()) {
                this.f2974g = item.getItemId();
                this.f2975h = i3;
            }
        }
        if (i2 != this.f2974g) {
            TransitionManager.beginDelayedTransition(this, this.a);
        }
        boolean i4 = i(this.f2972e, this.s.getVisibleItems().size());
        for (int i5 = 0; i5 < size; i5++) {
            this.r.c(true);
            this.f2973f[i5].setLabelVisibilityMode(this.f2972e);
            this.f2973f[i5].setShifting(i4);
            this.f2973f[i5].initialize((MenuItemImpl) this.s.getItem(i5), 0);
            this.r.c(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.s.getVisibleItems().size(), false, 1));
    }

    public void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        this.q = sparseArray;
        NavigationBarItemView[] navigationBarItemViewArr = this.f2973f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setBadge(sparseArray.get(navigationBarItemView.getId()));
            }
        }
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f2976i = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f2973f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.o = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f2973f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.p = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f2973f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i2);
            }
        }
    }

    public void setItemIconSize(@Dimension int i2) {
        this.f2977j = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f2973f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i2);
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        this.n = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f2973f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.f2978k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        this.f2980m = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f2973f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.f2978k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f2978k = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f2973f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.f2972e = i2;
    }

    public void setPresenter(@NonNull NavigationBarPresenter navigationBarPresenter) {
        this.r = navigationBarPresenter;
    }
}

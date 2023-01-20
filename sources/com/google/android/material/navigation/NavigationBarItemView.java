package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public abstract class NavigationBarItemView extends FrameLayout implements MenuView.ItemView {
    private static final int q = -1;
    private static final int[] r = {16842912};
    private final int a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f2959c;

    /* renamed from: d  reason: collision with root package name */
    private float f2960d;

    /* renamed from: e  reason: collision with root package name */
    private int f2961e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2962f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f2963g;

    /* renamed from: h  reason: collision with root package name */
    private final ViewGroup f2964h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f2965i;

    /* renamed from: j  reason: collision with root package name */
    private final TextView f2966j;

    /* renamed from: k  reason: collision with root package name */
    private int f2967k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private MenuItemImpl f2968l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f2969m;
    @Nullable
    private Drawable n;
    @Nullable
    private Drawable o;
    @Nullable
    private BadgeDrawable p;

    /* loaded from: classes2.dex */
    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (NavigationBarItemView.this.f2963g.getVisibility() == 0) {
                NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                navigationBarItemView.k(navigationBarItemView.f2963g);
            }
        }
    }

    public NavigationBarItemView(@NonNull Context context) {
        super(context);
        this.f2967k = -1;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f2963g = (ImageView) findViewById(R.id.navigation_bar_item_icon_view);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.navigation_bar_item_labels_group);
        this.f2964h = viewGroup;
        TextView textView = (TextView) findViewById(R.id.navigation_bar_item_small_label_view);
        this.f2965i = textView;
        TextView textView2 = (TextView) findViewById(R.id.navigation_bar_item_large_label_view);
        this.f2966j = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.a = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        viewGroup.setTag(R.id.mtrl_view_tag_bottom_padding, Integer.valueOf(viewGroup.getPaddingBottom()));
        ViewCompat.setImportantForAccessibility(textView, 2);
        ViewCompat.setImportantForAccessibility(textView2, 2);
        setFocusable(true);
        c(textView.getTextSize(), textView2.getTextSize());
        ImageView imageView = this.f2963g;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new a());
        }
    }

    private void c(float f2, float f3) {
        this.b = f2 - f3;
        this.f2959c = (f3 * 1.0f) / f2;
        this.f2960d = (f2 * 1.0f) / f3;
    }

    @Nullable
    private FrameLayout d(View view) {
        ImageView imageView = this.f2963g;
        if (view == imageView && e.j.a.c.c.a.a) {
            return (FrameLayout) imageView.getParent();
        }
        return null;
    }

    private boolean e() {
        return this.p != null;
    }

    private static void g(@NonNull View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i2 = 0;
        for (int i3 = 0; i3 < indexOfChild; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i2++;
            }
        }
        return i2;
    }

    private int getSuggestedIconHeight() {
        BadgeDrawable badgeDrawable = this.p;
        int minimumHeight = badgeDrawable != null ? badgeDrawable.getMinimumHeight() / 2 : 0;
        return Math.max(minimumHeight, ((FrameLayout.LayoutParams) this.f2963g.getLayoutParams()).topMargin) + this.f2963g.getMeasuredWidth() + minimumHeight;
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable badgeDrawable = this.p;
        int minimumWidth = badgeDrawable == null ? 0 : badgeDrawable.getMinimumWidth() - this.p.q();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2963g.getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.f2963g.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private static void h(@NonNull View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    private void i(@Nullable View view) {
        if (e() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            e.j.a.c.c.a.b(this.p, view, d(view));
        }
    }

    private void j(@Nullable View view) {
        if (e()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                e.j.a.c.c.a.g(this.p, view);
            }
            this.p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(View view) {
        if (e()) {
            e.j.a.c.c.a.j(this.p, view, d(view));
        }
    }

    private static void l(@NonNull View view, int i2) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i2);
    }

    public void f() {
        j(this.f2963g);
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.p;
    }

    @DrawableRes
    public int getItemBackgroundResId() {
        return R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    @Nullable
    public MenuItemImpl getItemData() {
        return this.f2968l;
    }

    @DimenRes
    public int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    @LayoutRes
    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f2967k;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2964h.getLayoutParams();
        return getSuggestedIconHeight() + layoutParams.topMargin + this.f2964h.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2964h.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.f2964h.getMeasuredWidth() + layoutParams.rightMargin);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i2) {
        CharSequence title;
        this.f2968l = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        if (!TextUtils.isEmpty(menuItemImpl.getTooltipText())) {
            title = menuItemImpl.getTooltipText();
        } else {
            title = menuItemImpl.getTitle();
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 21 || i3 > 23) {
            TooltipCompat.setTooltipText(this, title);
        }
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        MenuItemImpl menuItemImpl = this.f2968l;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f2968l.isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, r);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.p;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.f2968l.getTitle();
            if (!TextUtils.isEmpty(this.f2968l.getContentDescription())) {
                title = this.f2968l.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.p.o()));
        }
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            wrap.setClickable(false);
            wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setBadge(@NonNull BadgeDrawable badgeDrawable) {
        this.p = badgeDrawable;
        ImageView imageView = this.f2963g;
        if (imageView != null) {
            i(imageView);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        TextView textView = this.f2966j;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.f2966j;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.f2965i;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.f2965i;
        textView4.setPivotY(textView4.getBaseline());
        int i2 = this.f2961e;
        if (i2 != -1) {
            if (i2 == 0) {
                if (z) {
                    g(this.f2963g, this.a, 49);
                    ViewGroup viewGroup = this.f2964h;
                    l(viewGroup, ((Integer) viewGroup.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                    this.f2966j.setVisibility(0);
                } else {
                    g(this.f2963g, this.a, 17);
                    l(this.f2964h, 0);
                    this.f2966j.setVisibility(4);
                }
                this.f2965i.setVisibility(4);
            } else if (i2 == 1) {
                ViewGroup viewGroup2 = this.f2964h;
                l(viewGroup2, ((Integer) viewGroup2.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                if (z) {
                    g(this.f2963g, (int) (this.a + this.b), 49);
                    h(this.f2966j, 1.0f, 1.0f, 0);
                    TextView textView5 = this.f2965i;
                    float f2 = this.f2959c;
                    h(textView5, f2, f2, 4);
                } else {
                    g(this.f2963g, this.a, 49);
                    TextView textView6 = this.f2966j;
                    float f3 = this.f2960d;
                    h(textView6, f3, f3, 4);
                    h(this.f2965i, 1.0f, 1.0f, 0);
                }
            } else if (i2 == 2) {
                g(this.f2963g, this.a, 17);
                this.f2966j.setVisibility(8);
                this.f2965i.setVisibility(8);
            }
        } else if (this.f2962f) {
            if (z) {
                g(this.f2963g, this.a, 49);
                ViewGroup viewGroup3 = this.f2964h;
                l(viewGroup3, ((Integer) viewGroup3.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                this.f2966j.setVisibility(0);
            } else {
                g(this.f2963g, this.a, 17);
                l(this.f2964h, 0);
                this.f2966j.setVisibility(4);
            }
            this.f2965i.setVisibility(4);
        } else {
            ViewGroup viewGroup4 = this.f2964h;
            l(viewGroup4, ((Integer) viewGroup4.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
            if (z) {
                g(this.f2963g, (int) (this.a + this.b), 49);
                h(this.f2966j, 1.0f, 1.0f, 0);
                TextView textView7 = this.f2965i;
                float f4 = this.f2959c;
                h(textView7, f4, f4, 4);
            } else {
                g(this.f2963g, this.a, 49);
                TextView textView8 = this.f2966j;
                float f5 = this.f2960d;
                h(textView8, f5, f5, 4);
                h(this.f2965i, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f2965i.setEnabled(z);
        this.f2966j.setEnabled(z);
        this.f2963g.setEnabled(z);
        if (z) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        } else {
            ViewCompat.setPointerIcon(this, null);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable == this.n) {
            return;
        }
        this.n = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            this.o = drawable;
            ColorStateList colorStateList = this.f2969m;
            if (colorStateList != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
        this.f2963g.setImageDrawable(drawable);
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2963g.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f2963g.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        this.f2969m = colorStateList;
        if (this.f2968l == null || (drawable = this.o) == null) {
            return;
        }
        DrawableCompat.setTintList(drawable, colorStateList);
        this.o.invalidateSelf();
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : ContextCompat.getDrawable(getContext(), i2));
    }

    public void setItemPosition(int i2) {
        this.f2967k = i2;
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f2961e != i2) {
            this.f2961e = i2;
            MenuItemImpl menuItemImpl = this.f2968l;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.f2962f != z) {
            this.f2962f = z;
            MenuItemImpl menuItemImpl = this.f2968l;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c2) {
    }

    public void setTextAppearanceActive(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.f2966j, i2);
        c(this.f2965i.getTextSize(), this.f2966j.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.f2965i, i2);
        c(this.f2965i.getTextSize(), this.f2966j.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f2965i.setTextColor(colorStateList);
            this.f2966j.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(@Nullable CharSequence charSequence) {
        this.f2965i.setText(charSequence);
        this.f2966j.setText(charSequence);
        MenuItemImpl menuItemImpl = this.f2968l;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.f2968l;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.f2968l.getTooltipText();
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21 || i2 > 23) {
            TooltipCompat.setTooltipText(this, charSequence);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        ViewCompat.setBackground(this, drawable);
    }
}

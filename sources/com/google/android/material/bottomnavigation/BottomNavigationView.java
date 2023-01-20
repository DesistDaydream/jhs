package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import e.j.a.c.s.m;
import e.j.a.c.z.j;

/* loaded from: classes2.dex */
public class BottomNavigationView extends NavigationBarView {

    /* renamed from: m  reason: collision with root package name */
    public static final int f2788m = 5;

    @Deprecated
    /* loaded from: classes2.dex */
    public interface a extends NavigationBarView.d {
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface b extends NavigationBarView.e {
    }

    public BottomNavigationView(@NonNull Context context) {
        this(context, null);
    }

    private void k(@NonNull Context context) {
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.getColor(context, R.color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    private boolean m() {
        return Build.VERSION.SDK_INT < 21 && !(getBackground() instanceof j);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarMenuView e(@NonNull Context context) {
        return new BottomNavigationMenuView(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    public boolean l() {
        return ((BottomNavigationMenuView) getMenuView()).q();
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.q() != z) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z);
            getPresenter().updateMenuView(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@Nullable a aVar) {
        setOnItemReselectedListener(aVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@Nullable b bVar) {
        setOnItemSelectedListener(bVar);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, R.style.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Context context2 = getContext();
        TintTypedArray k2 = m.k(context2, attributeSet, R.styleable.BottomNavigationView, i2, i3, new int[0]);
        setItemHorizontalTranslationEnabled(k2.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        k2.recycle();
        if (m()) {
            k(context2);
        }
    }
}

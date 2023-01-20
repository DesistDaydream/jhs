package e.j.a.c.c0;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import e.j.a.c.s.t;

/* loaded from: classes2.dex */
public class b {
    @Dimension(unit = 0)
    private static final int a = 24;

    public static RectF a(TabLayout tabLayout, @Nullable View view) {
        if (view == null) {
            return new RectF();
        }
        if (!tabLayout.C() && (view instanceof TabLayout.TabView)) {
            return b((TabLayout.TabView) view, 24);
        }
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    public static RectF b(@NonNull TabLayout.TabView tabView, @Dimension(unit = 0) int i2) {
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int e2 = (int) t.e(tabView.getContext(), i2);
        if (contentWidth < e2) {
            contentWidth = e2;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i3 = contentWidth / 2;
        return new RectF(left - i3, top - (contentHeight / 2), i3 + left, top + (left / 2));
    }

    public void c(TabLayout tabLayout, View view, View view2, @FloatRange(from = 0.0d, to = 1.0d) float f2, @NonNull Drawable drawable) {
        RectF a2 = a(tabLayout, view);
        RectF a3 = a(tabLayout, view2);
        drawable.setBounds(e.j.a.c.a.a.c((int) a2.left, (int) a3.left, f2), drawable.getBounds().top, e.j.a.c.a.a.c((int) a2.right, (int) a3.right, f2), drawable.getBounds().bottom);
    }

    public void d(TabLayout tabLayout, View view, @NonNull Drawable drawable) {
        RectF a2 = a(tabLayout, view);
        drawable.setBounds((int) a2.left, drawable.getBounds().top, (int) a2.right, drawable.getBounds().bottom);
    }
}

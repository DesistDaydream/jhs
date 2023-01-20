package e.j.a.c.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ParcelableSparseArray;
import e.j.a.c.s.n;

@b
/* loaded from: classes2.dex */
public class a {
    public static final boolean a;
    private static final String b = "BadgeUtils";

    /* renamed from: e.j.a.c.c.a$a */
    /* loaded from: classes2.dex */
    public static class RunnableC0351a implements Runnable {
        public final /* synthetic */ Toolbar a;
        public final /* synthetic */ int b;

        /* renamed from: c */
        public final /* synthetic */ BadgeDrawable f10577c;

        /* renamed from: d */
        public final /* synthetic */ FrameLayout f10578d;

        public RunnableC0351a(Toolbar toolbar, int i2, BadgeDrawable badgeDrawable, FrameLayout frameLayout) {
            this.a = toolbar;
            this.b = i2;
            this.f10577c = badgeDrawable;
            this.f10578d = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuItemView a = n.a(this.a, this.b);
            if (a != null) {
                a.k(this.f10577c, this.a.getResources());
                a.b(this.f10577c, a, this.f10578d);
            }
        }
    }

    static {
        a = Build.VERSION.SDK_INT < 18;
    }

    private a() {
    }

    public static void a(@NonNull BadgeDrawable badgeDrawable, @NonNull View view) {
        b(badgeDrawable, view, null);
    }

    public static void b(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        j(badgeDrawable, view, frameLayout);
        if (badgeDrawable.p() != null) {
            badgeDrawable.p().setForeground(badgeDrawable);
        } else if (!a) {
            view.getOverlay().add(badgeDrawable);
        } else {
            throw new IllegalArgumentException("Trying to reference null customBadgeParent");
        }
    }

    public static void c(@NonNull BadgeDrawable badgeDrawable, @NonNull Toolbar toolbar, @IdRes int i2) {
        d(badgeDrawable, toolbar, i2, null);
    }

    public static void d(@NonNull BadgeDrawable badgeDrawable, @NonNull Toolbar toolbar, @IdRes int i2, @Nullable FrameLayout frameLayout) {
        toolbar.post(new RunnableC0351a(toolbar, i2, badgeDrawable, frameLayout));
    }

    @NonNull
    public static SparseArray<BadgeDrawable> e(Context context, @NonNull ParcelableSparseArray parcelableSparseArray) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i2 = 0; i2 < parcelableSparseArray.size(); i2++) {
            int keyAt = parcelableSparseArray.keyAt(i2);
            BadgeDrawable.SavedState savedState = (BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i2);
            if (savedState != null) {
                sparseArray.put(keyAt, BadgeDrawable.g(context, savedState));
            } else {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
        }
        return sparseArray;
    }

    @NonNull
    public static ParcelableSparseArray f(@NonNull SparseArray<BadgeDrawable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            int keyAt = sparseArray.keyAt(i2);
            BadgeDrawable valueAt = sparseArray.valueAt(i2);
            if (valueAt != null) {
                parcelableSparseArray.put(keyAt, valueAt.t());
            } else {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
        }
        return parcelableSparseArray;
    }

    public static void g(@Nullable BadgeDrawable badgeDrawable, @NonNull View view) {
        if (badgeDrawable == null) {
            return;
        }
        if (!a && badgeDrawable.p() == null) {
            view.getOverlay().remove(badgeDrawable);
        } else {
            badgeDrawable.p().setForeground(null);
        }
    }

    public static void h(@Nullable BadgeDrawable badgeDrawable, @NonNull Toolbar toolbar, @IdRes int i2) {
        if (badgeDrawable == null) {
            return;
        }
        ActionMenuItemView a2 = n.a(toolbar, i2);
        if (a2 != null) {
            i(badgeDrawable);
            g(badgeDrawable, a2);
            return;
        }
        Log.w(b, "Trying to remove badge from a null menuItemView: " + i2);
    }

    @VisibleForTesting
    public static void i(BadgeDrawable badgeDrawable) {
        badgeDrawable.z(0);
        badgeDrawable.A(0);
    }

    public static void j(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.S(view, frameLayout);
    }

    @VisibleForTesting
    public static void k(BadgeDrawable badgeDrawable, Resources resources) {
        badgeDrawable.z(resources.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset));
        badgeDrawable.A(resources.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset));
    }

    public static void l(@NonNull Rect rect, float f2, float f3, float f4, float f5) {
        rect.set((int) (f2 - f4), (int) (f3 - f5), (int) (f2 + f4), (int) (f3 + f5));
    }
}

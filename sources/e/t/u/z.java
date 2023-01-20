package e.t.u;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.vector.util.UIUtil;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/vector/util/SoftKeyboardFixerForFullscreen;", "", "()V", "barStatusHeight", "", "lastUsableHeight", "assistActivity", "", "activity", "Landroid/app/Activity;", "computeUsableHeight", "contentView", "Landroid/view/View;", "setHeight", "params", "Landroid/widget/FrameLayout$LayoutParams;", "height", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class z {
    @k.e.a.d
    public static final z a = new z();
    private static int b;

    /* renamed from: c */
    private static int f14679c;

    private z() {
    }

    public static final void b(FrameLayout frameLayout, View view, WeakReference weakReference, FrameLayout.LayoutParams layoutParams) {
        int height = frameLayout.getHeight();
        z zVar = a;
        int c2 = zVar.c(view);
        if (c2 != f14679c) {
            f14679c = c2;
            int i2 = height - c2;
            if (Build.VERSION.SDK_INT >= 24) {
                Activity activity = (Activity) weakReference.get();
                boolean z = false;
                if (activity != null && activity.isInMultiWindowMode()) {
                    z = true;
                }
                if (z) {
                    if (i2 > 0) {
                        zVar.e(view, layoutParams, height - i2);
                        return;
                    } else {
                        zVar.e(view, layoutParams, -1);
                        return;
                    }
                }
            }
            if (i2 > height / 4) {
                zVar.e(view, layoutParams, (height - i2) + b);
            } else {
                zVar.e(view, layoutParams, -1);
            }
        }
    }

    private final int c(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    public static /* synthetic */ void d(FrameLayout frameLayout, View view, WeakReference weakReference, FrameLayout.LayoutParams layoutParams) {
        b(frameLayout, view, weakReference, layoutParams);
    }

    private final void e(View view, FrameLayout.LayoutParams layoutParams, int i2) {
        if (layoutParams.height != i2) {
            layoutParams.height = i2;
            view.requestLayout();
        }
    }

    public final void a(@k.e.a.d Activity activity) {
        final WeakReference weakReference = new WeakReference(activity);
        b = UIUtil.c();
        Activity activity2 = (Activity) weakReference.get();
        final FrameLayout frameLayout = activity2 == null ? null : (FrameLayout) activity2.findViewById(16908290);
        if (frameLayout == null) {
            return;
        }
        final View childAt = frameLayout.getChildAt(0);
        ViewGroup.LayoutParams layoutParams = childAt != null ? childAt.getLayoutParams() : null;
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        final FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: e.t.u.a
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                z.d(frameLayout, childAt, weakReference, layoutParams2);
            }
        });
    }
}

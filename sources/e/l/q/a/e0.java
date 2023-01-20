package e.l.q.a;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import com.effective.android.panel.Constants;
import com.jihuanshe.ui.dialog.BaseDialog;
import com.vector.ext.view.ViewKt;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class e0 {
    @k.e.a.d
    public static final e0 a = new e0();
    private static int b;

    /* renamed from: c */
    private static int f14126c;

    private e0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b(ArrayList<EditText> arrayList, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof EditText) && childAt.getVisibility() == 0) {
                arrayList.add(childAt);
            } else if (childAt instanceof ViewGroup) {
                b(arrayList, (ViewGroup) childAt);
            }
            if (i3 >= childCount) {
                return;
            }
            i2 = i3;
        }
    }

    private final int c() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier(Constants.NAVIGATION_BAR_HEIGHT_RES_NAME, Constants.DIMEN, Constants.ANDROID);
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final int e() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier(Constants.STATUS_BAR_HEIGHT_RES_NAME, Constants.DIMEN, Constants.ANDROID));
    }

    public static final void i(int i2, BaseDialog baseDialog) {
        a.j(i2, baseDialog);
    }

    private final void j(int i2, BaseDialog baseDialog) {
        EditText editText;
        int i3;
        int i4;
        int i5;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator translationY;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator interpolator;
        int i6;
        ArrayList<EditText> arrayList = new ArrayList<>();
        b(arrayList, baseDialog);
        Iterator<EditText> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                editText = null;
                break;
            }
            editText = it.next();
            if (editText.isFocused()) {
                break;
            }
        }
        View contentView = baseDialog.getContentView();
        int height = contentView == null ? 0 : contentView.getHeight();
        if (baseDialog.getContentView() != null) {
            View contentView2 = baseDialog.getContentView();
            height = h.o2.q.u(height, contentView2 == null ? 0 : contentView2.getMeasuredHeight());
        }
        int measuredHeight = baseDialog.getMeasuredHeight();
        if (editText != null) {
            int[] iArr = new int[2];
            editText.getLocationInWindow(iArr);
            i3 = iArr[1];
            i4 = editText.getMeasuredHeight() + i3;
        } else {
            i3 = 0;
            i4 = 0;
        }
        if (height != measuredHeight || i4 + i2 >= measuredHeight) {
            if (baseDialog.getGravity() == 17) {
                int i7 = (((height + measuredHeight) / 2) + i2) - measuredHeight;
                if (editText != null && (i6 = i3 - i7) < 0) {
                    i7 += i6 - e();
                }
                i2 = h.o2.q.n(0, i7);
            } else if (baseDialog.getGravity() != 80) {
                i2 = 0;
            } else if (editText != null && (i5 = i3 - i2) < 0) {
                i2 += i5 - e();
            }
            if (i2 == 0) {
                View contentView3 = baseDialog.getContentView();
                if (!h.k2.v.f0.e(contentView3 != null ? Float.valueOf(contentView3.getTranslationY()) : null, 0.0f)) {
                    return;
                }
            }
            View contentView4 = baseDialog.getContentView();
            if (contentView4 == null || (animate = contentView4.animate()) == null || (translationY = animate.translationY(-i2)) == null || (duration = translationY.setDuration(200L)) == null || (interpolator = duration.setInterpolator(new OvershootInterpolator(0.0f))) == null) {
                return;
            }
            interpolator.start();
        }
    }

    public final void a(@k.e.a.d BaseDialog baseDialog) {
        ArrayList<EditText> arrayList = new ArrayList<>();
        b(arrayList, baseDialog);
        for (EditText editText : arrayList) {
            editText.clearFocus();
            ViewKt.E(editText, false);
            ViewKt.p(editText);
        }
    }

    public final int d(@k.e.a.e Window window) {
        View decorView = window == null ? null : window.getDecorView();
        if (decorView == null) {
            return 0;
        }
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs <= c()) {
            b = abs;
            return 0;
        }
        return abs - b;
    }

    public final void g(@k.e.a.d BaseDialog baseDialog) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator translationY;
        ViewPropertyAnimator duration;
        View contentView = baseDialog.getContentView();
        if (contentView == null || (animate = contentView.animate()) == null || (translationY = animate.translationY(0.0f)) == null || (duration = translationY.setDuration(100L)) == null) {
            return;
        }
        duration.start();
    }

    public final void h(final int i2, @k.e.a.d final BaseDialog baseDialog) {
        f14126c = i2;
        baseDialog.post(new Runnable() { // from class: e.l.q.a.n
            @Override // java.lang.Runnable
            public final void run() {
                e0.i(i2, baseDialog);
            }
        });
    }
}

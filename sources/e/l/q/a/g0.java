package e.l.q.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class g0 extends Dialog {
    private View a;

    public g0(@k.e.a.d Context context, int i2) {
        super(context, i2);
    }

    private final void b(int i2, boolean z) {
        int i3;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        if (attributes == null) {
            return;
        }
        if (z) {
            i3 = i2 | attributes.flags;
        } else {
            i3 = (~i2) & attributes.flags;
        }
        attributes.flags = i3;
        Window window2 = getWindow();
        if (window2 == null) {
            return;
        }
        window2.setAttributes(attributes);
    }

    private final void c() {
        View decorView;
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window2 = getWindow();
        if (window2 != null && (decorView = window2.getDecorView()) != null) {
            decorView.setPadding(0, 0, 0, 0);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setFlags(16777216, 16777216);
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.clearFlags(2);
        }
        Window window5 = getWindow();
        if (window5 != null) {
            window5.setSoftInputMode(16);
        }
        Window window6 = getWindow();
        View decorView2 = window6 == null ? null : window6.getDecorView();
        if (decorView2 != null) {
            decorView2.setSystemUiVisibility(1280);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            b(201326592, false);
            Window window7 = getWindow();
            if (window7 != null) {
                window7.setStatusBarColor(0);
            }
            Window window8 = getWindow();
            if (window8 == null) {
                return;
            }
            window8.addFlags(Integer.MIN_VALUE);
        }
    }

    public final void a(@k.e.a.d View view) {
        if (view.getParent() != null) {
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            new e.t.l.h();
        }
        this.a = view;
    }

    @Override // android.app.Dialog
    public void onCreate(@k.e.a.e Bundle bundle) {
        super.onCreate(bundle);
        if (getWindow() == null || this.a == null) {
            return;
        }
        c();
        View view = this.a;
        Objects.requireNonNull(view);
        setContentView(view);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        e.t.l.b0.k(window, ViewCompat.MEASURED_STATE_MASK);
    }

    public g0(@k.e.a.d Context context) {
        this(context, 2131820992);
    }
}

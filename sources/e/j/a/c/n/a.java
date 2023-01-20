package e.j.a.c.n;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a implements View.OnTouchListener {
    @NonNull
    private final Dialog a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10919c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10920d;

    public a(@NonNull Dialog dialog, @NonNull Rect rect) {
        this.a = dialog;
        this.b = rect.left;
        this.f10919c = rect.top;
        this.f10920d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = this.b + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        int top = this.f10919c + findViewById.getTop();
        if (new RectF(left, top, width, findViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i2 = this.f10920d;
            obtain.setLocation((-i2) - 1, (-i2) - 1);
        }
        view.performClick();
        return this.a.onTouchEvent(obtain);
    }
}

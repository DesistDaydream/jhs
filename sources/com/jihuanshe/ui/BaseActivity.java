package com.jihuanshe.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.jihuanshe.R;
import com.vector.design.ui.activity.ActivityEx;
import com.vector.util.Res;
import e.l.h.d.f;
import e.l.h.l.b;
import e.l.r.q0;
import e.t.u.o;
import f.a.a.a;
import h.w;
import h.z;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public abstract class BaseActivity<VM extends b> extends ActivityEx<VM> {

    /* renamed from: l  reason: collision with root package name */
    private long f3928l;
    @d

    /* renamed from: m  reason: collision with root package name */
    private final w f3929m = z.c(BaseActivity$statusHeight$2.INSTANCE);
    @a(true)
    @d
    private String from = "";

    private final boolean P(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        EditText editText = (EditText) view;
        editText.getLocationInWindow(iArr);
        int i2 = iArr[1];
        return motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) (editText.getHeight() + i2));
    }

    @d
    public final String M() {
        return this.from;
    }

    public final int N() {
        return ((Number) this.f3929m.getValue()).intValue();
    }

    public final long O() {
        return (System.currentTimeMillis() - this.f3928l) / 1000;
    }

    public void Q() {
    }

    public void R() {
    }

    public void S() {
    }

    public void T(long j2) {
    }

    public final void U(@d String str) {
        this.from = str;
    }

    public void V() {
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setNavigationBarColor(Res.k(R.color.white));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(@d MotionEvent motionEvent) {
        View currentFocus;
        if (motionEvent.getAction() == 1 && (currentFocus = getCurrentFocus()) != null && P(currentFocus, motionEvent)) {
            o.c(currentFocus, false, 2, null);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.vector.design.ui.activity.ActivityEx, com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void g() {
        super.g();
        f fVar = f.b;
        fVar.e(this).g(e.l.j.a.b, new BaseActivity$initializeFlow$1(this));
        fVar.e(this).g(e.l.j.a.f12233c, new BaseActivity$initializeFlow$2(this));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@e Bundle bundle) {
        super.onCreate(bundle);
        V();
        S();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        q0.a.b(getClass().getSimpleName());
        T((System.currentTimeMillis() - this.f3928l) / 1000);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        q0.a.c(getClass().getSimpleName());
        this.f3928l = System.currentTimeMillis();
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        if (Build.VERSION.SDK_INT == 26) {
            return;
        }
        super.setRequestedOrientation(i2);
    }
}

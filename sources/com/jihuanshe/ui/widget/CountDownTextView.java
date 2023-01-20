package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.eth.ext.CoroutineKt;
import com.jihuanshe.R;
import com.vector.util.Res;
import h.k2.h;
import h.k2.v.u;
import i.b.b1;
import i.b.b2;
import i.b.n0;
import i.b.o0;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class CountDownTextView extends AppCompatTextView {
    @d

    /* renamed from: c  reason: collision with root package name */
    public static final a f4053c = new a(null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final String f4054d = "CountDownTextView";

    /* renamed from: e  reason: collision with root package name */
    private static final int f4055e = 5;
    @d
    private n0 a;
    @e
    private b2 b;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @h
    public CountDownTextView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ CountDownTextView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public final void e() {
        b2 b2Var = this.b;
        if (b2Var == null) {
            return;
        }
        b2.a.b(b2Var, null, 1, null);
    }

    public final void f() {
        this.b = CoroutineKt.g(i.b.v3.h.w(i.b.v3.h.l1(i.b.v3.h.m1(i.b.v3.h.S0(i.b.v3.h.N0(new CountDownTextView$start$1(null)), b1.e()), new CountDownTextView$start$2(this, null)), new CountDownTextView$start$3(this, null)), new CountDownTextView$start$4(this, null)), this.a, null, null, 6, null);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        e();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean performClick() {
        e();
        return super.performClick();
    }

    @h
    public CountDownTextView(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        setText(Res.a.v(R.string.ad_count_down_text, 5));
        setGravity(17);
        this.a = o0.b();
    }
}

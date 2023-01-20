package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.jihuanshe.ui.widget.VerifyView;
import com.jyn.vcview.VerificationCodeView;
import e.t.u.o;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class VerifyView extends VerificationCodeView {
    public VerifyView(@e Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static /* synthetic */ void h(VerifyView verifyView) {
        i(verifyView);
    }

    public static final void i(VerifyView verifyView) {
        o.a.h(verifyView.getChildAt(0));
    }

    @Override // com.jyn.vcview.VerificationCodeView
    @d
    public LinearLayout.LayoutParams c(int i2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getmEtWidth(), getmEtWidth());
        int measuredWidth = (getMeasuredWidth() - (getmEtNumber() * getmEtWidth())) / (getmEtNumber() - 1);
        if (i2 < getmEtNumber() - 1) {
            layoutParams.rightMargin = measuredWidth;
        }
        layoutParams.gravity = 17;
        return layoutParams;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@d View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            postDelayed(new Runnable() { // from class: e.l.q.c.e0
                @Override // java.lang.Runnable
                public final void run() {
                    VerifyView.h(VerifyView.this);
                }
            }, 100L);
        }
    }
}

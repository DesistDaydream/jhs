package com.jihuanshe.base.magicindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import e.l.h.h.f.a;

/* loaded from: classes2.dex */
public class MagicIndicator extends FrameLayout {
    private a a;

    public MagicIndicator(Context context) {
        super(context);
    }

    public void a(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.onPageScrollStateChanged(i2);
        }
    }

    public void b(int i2, float f2, int i3) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.onPageScrolled(i2, f2, i3);
        }
    }

    public void c(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.onPageSelected(i2);
        }
    }

    public a getNavigator() {
        return this.a;
    }

    public void setNavigator(a aVar) {
        a aVar2 = this.a;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            aVar2.g();
        }
        this.a = aVar;
        removeAllViews();
        if (this.a instanceof View) {
            addView((View) this.a, new FrameLayout.LayoutParams(-1, -1));
            this.a.f();
        }
    }

    public MagicIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

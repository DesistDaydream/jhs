package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import e.l.h.h.g.a.d;
import e.t.o.d;
import h.k2.h;
import h.k2.v.u;
import h.t1;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class IndicatorDividerView extends FrameLayout implements d {
    @h
    public IndicatorDividerView(@k.e.a.d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public IndicatorDividerView(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ IndicatorDividerView(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Override // e.l.h.h.g.a.d
    public void a(int i2, int i3) {
    }

    @Override // e.l.h.h.g.a.d
    public void b(int i2, int i3, float f2, boolean z) {
    }

    @Override // e.l.h.h.g.a.d
    public void c(int i2, int i3) {
    }

    @Override // e.l.h.h.g.a.d
    public void d(int i2, int i3, float f2, boolean z) {
    }

    @h
    public IndicatorDividerView(@k.e.a.d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View view = new View(context);
        view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        t1 t1Var = t1.a;
        d.a aVar = e.t.o.d.a;
        addView(view, new FrameLayout.LayoutParams(d.a.c(aVar, null, 1, null).d(1), d.a.c(aVar, null, 1, null).d(12), 17));
    }
}

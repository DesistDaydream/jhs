package com.jihuanshe.ui.widget.exam;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.jihuanshe.R;
import e.t.o.d;
import h.k2.h;
import h.k2.v.u;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public final class ExamIndicatorView extends LinearLayout {
    private int a;
    @d
    private List<View> b;

    @h
    public ExamIndicatorView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ ExamIndicatorView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    private final void a(int i2) {
        int i3;
        View view = new View(getContext());
        if (i2 == 0) {
            i3 = R.drawable.sel_exam_start;
        } else {
            i3 = i2 == this.a - 1 ? R.drawable.sel_exam_end : R.drawable.sel_exam_mid;
        }
        view.setBackgroundResource(i3);
        this.b.add(view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        if (i2 > 0) {
            layoutParams.setMarginStart(d.a.c(e.t.o.d.a, null, 1, null).d(1));
        }
        t1 t1Var = t1.a;
        addView(view, layoutParams);
    }

    private final void b() {
        this.b.clear();
        removeAllViews();
        int i2 = this.a;
        if (i2 <= 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            a(i3);
            if (i4 >= i2) {
                return;
            }
            i3 = i4;
        }
    }

    public final void c(@k.e.a.d List<Integer> list) {
        for (Number number : list) {
            View view = (View) CollectionsKt___CollectionsKt.J2(this.b, number.intValue());
            if (view != null) {
                view.setSelected(false);
            }
        }
    }

    public final void setClear(int i2) {
        if (i2 < 0) {
            return;
        }
        int i3 = 0;
        if (i2 < 0) {
            return;
        }
        while (true) {
            int i4 = i3 + 1;
            View view = (View) CollectionsKt___CollectionsKt.J2(this.b, i3);
            if (view != null) {
                view.setSelected(true);
            }
            if (i3 == i2) {
                return;
            }
            i3 = i4;
        }
    }

    public final void setCount(int i2) {
        this.a = i2;
        b();
    }

    @h
    public ExamIndicatorView(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        this.b = new ArrayList();
    }
}

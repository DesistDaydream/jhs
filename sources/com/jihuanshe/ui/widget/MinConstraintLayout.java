package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.vector.util.UIUtil;
import e.t.o.d;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class MinConstraintLayout extends ConstraintLayout {
    public MinConstraintLayout(@d Context context) {
        super(context);
        setMinimumHeight(d.a.c(e.t.o.d.a, null, 1, null).d(48) + UIUtil.c());
    }

    public MinConstraintLayout(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        setMinimumHeight(d.a.c(e.t.o.d.a, null, 1, null).d(48) + UIUtil.c());
    }

    public MinConstraintLayout(@k.e.a.d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setMinimumHeight(d.a.c(e.t.o.d.a, null, 1, null).d(48) + UIUtil.c());
    }
}

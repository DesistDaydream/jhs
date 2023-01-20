package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.jihuanshe.R;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ConsignmentProcessView extends ConstraintLayout {
    public ConsignmentProcessView(@d Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.view_consignment_process, (ViewGroup) this, true);
    }

    public ConsignmentProcessView(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(R.layout.view_consignment_process, (ViewGroup) this, true);
    }

    public ConsignmentProcessView(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(getContext()).inflate(R.layout.view_consignment_process, (ViewGroup) this, true);
    }
}

package com.jihuanshe.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.jihuanshe.R;
import com.vector.util.Res;
import h.k2.h;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class SortImageView extends FrameLayout {
    @d
    private ImageView a;
    @d
    private ImageView b;

    @h
    public SortImageView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ SortImageView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public final void setup(boolean z) {
        if (z) {
            this.a.setImageTintList(ColorStateList.valueOf(Res.k(R.color.common_color_1)));
            this.b.setImageTintList(null);
            return;
        }
        this.b.setImageTintList(ColorStateList.valueOf(Res.k(R.color.common_color_1)));
        this.a.setImageTintList(null);
    }

    @h
    public SortImageView(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.view_sort, (ViewGroup) this, true);
        this.a = (ImageView) findViewById(R.id.upIv);
        this.b = (ImageView) findViewById(R.id.downIv);
    }
}

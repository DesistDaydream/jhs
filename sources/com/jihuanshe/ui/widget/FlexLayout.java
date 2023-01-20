package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.databinding.ViewDataBinding;
import com.google.android.flexbox.FlexboxLayout;
import e.t.k.a.c.b;
import e.t.k.a.c.c;
import h.k2.h;
import h.k2.v.u;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class FlexLayout extends FlexboxLayout {
    @d
    private final List<b> v;
    @e
    private c<?> w;

    @h
    public FlexLayout(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ FlexLayout(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    private final void B() {
        removeAllViews();
        c<?> cVar = this.w;
        if (cVar == null) {
            return;
        }
        int i2 = 0;
        int k2 = cVar.k();
        if (k2 <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            b onCreateViewHolder = cVar.onCreateViewHolder(this, cVar.getItemViewType(i2));
            this.v.add(onCreateViewHolder);
            cVar.onBindViewHolder(onCreateViewHolder, i2);
            ViewDataBinding a = onCreateViewHolder.a();
            addView(a == null ? null : a.getRoot());
            if (i3 >= k2) {
                return;
            }
            i2 = i3;
        }
    }

    @e
    public final c<?> getAdapter() {
        return this.w;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c<?> cVar = this.w;
        if (cVar == null) {
            return;
        }
        for (b bVar : this.v) {
            cVar.onViewRecycled(bVar);
        }
    }

    public final void setAdapter(@e c<?> cVar) {
        if (cVar == null) {
            return;
        }
        this.w = cVar;
        B();
    }

    @h
    public FlexLayout(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v = new ArrayList();
    }
}

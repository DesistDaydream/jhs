package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jihuanshe.R;
import com.jihuanshe.model.Category;
import com.jihuanshe.ui.widget.CustomHorizontalScrollView;
import com.vector.util.Res;
import e.l.q.c.g0;
import e.t.o.d;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class CustomHorizontalScrollView extends HorizontalScrollView {
    private int a;
    @d
    private List<Category> b;
    @d

    /* renamed from: c */
    private g0 f4056c;
    @e

    /* renamed from: d */
    private l<? super Integer, t1> f4057d;

    @h
    public CustomHorizontalScrollView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ CustomHorizontalScrollView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    private final TextView a(Category category) {
        TextView textView = new TextView(getContext());
        textView.setText(category.getName());
        textView.setGravity(17);
        textView.setTextColor(Res.k(R.color.black));
        textView.setTextSize(2, 12.0f);
        d.a aVar = e.t.o.d.a;
        textView.setPadding(d.a.c(aVar, null, 1, null).d(21), 0, d.a.c(aVar, null, 1, null).d(21), 0);
        return textView;
    }

    private final void b() {
        removeAllViews();
        final LinearLayout linearLayout = new LinearLayout(getContext());
        final int i2 = 0;
        linearLayout.setOrientation(0);
        for (Object obj : this.b) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            final TextView a = a((Category) obj);
            a.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CustomHorizontalScrollView.c(linearLayout, this, a, i2, view);
                }
            });
            linearLayout.addView(a, new FrameLayout.LayoutParams(-2, -1));
            i2 = i3;
        }
        linearLayout.getChildAt(this.a).setBackground(this.f4056c);
        addView(linearLayout, new FrameLayout.LayoutParams(-2, -1));
    }

    public static final void c(LinearLayout linearLayout, CustomHorizontalScrollView customHorizontalScrollView, TextView textView, int i2, View view) {
        linearLayout.getChildAt(customHorizontalScrollView.a).setBackground(null);
        textView.setBackground(customHorizontalScrollView.f4056c);
        customHorizontalScrollView.a = i2;
        l<Integer, t1> listener = customHorizontalScrollView.getListener();
        if (listener == null) {
            return;
        }
        listener.invoke(Integer.valueOf(customHorizontalScrollView.a));
    }

    @e
    public final l<Integer, t1> getListener() {
        return this.f4057d;
    }

    public final void setData(@e List<Category> list) {
        if (list == null) {
            return;
        }
        this.b.clear();
        this.b.addAll(list);
        b();
    }

    public final void setListener(@e l<? super Integer, t1> lVar) {
        this.f4057d = lVar;
    }

    @h
    public CustomHorizontalScrollView(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new ArrayList();
        this.f4056c = new g0(Res.k(R.color.white));
    }
}

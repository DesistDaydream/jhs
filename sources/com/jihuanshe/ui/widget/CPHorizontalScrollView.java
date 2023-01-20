package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.jihuanshe.R;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.ui.widget.CPHorizontalScrollView;
import com.vector.network.image.NImageView;
import e.l.k.we;
import e.l.k.ye;
import e.t.o.d;
import e.t.r.a.a;
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
public final class CPHorizontalScrollView extends HorizontalScrollView {
    private int a;
    @d
    private List<CardPackage> b;
    @d

    /* renamed from: c */
    private final a f4042c;
    @e

    /* renamed from: d */
    private l<? super Integer, t1> f4043d;

    /* renamed from: e */
    private int f4044e;

    @h
    public CPHorizontalScrollView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ CPHorizontalScrollView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    private final View a(CardPackage cardPackage) {
        we e2 = we.e(LayoutInflater.from(getContext()));
        e2.i(cardPackage);
        e2.j(this.f4042c);
        String image = cardPackage.getImage();
        boolean z = false;
        if (image != null && h.t2.u.J1(image, "svg", false, 2, null)) {
            z = true;
        }
        if (z) {
            NImageView nImageView = e2.a;
            d.a aVar = e.t.o.d.a;
            nImageView.setPadding(d.a.c(aVar, null, 1, null).d(12), d.a.c(aVar, null, 1, null).d(10), d.a.c(aVar, null, 1, null).d(12), d.a.c(aVar, null, 1, null).d(10));
            e2.a.setScaleType(ImageView.ScaleType.FIT_XY);
            e2.a.setBackgroundResource(R.drawable.bg_card_package);
        }
        return e2.getRoot();
    }

    private final View b(CardPackage cardPackage) {
        ye e2 = ye.e(LayoutInflater.from(getContext()));
        e2.i(cardPackage);
        e2.j(this.f4042c);
        String image = cardPackage.getImage();
        boolean z = false;
        if (image != null && h.t2.u.J1(image, "svg", false, 2, null)) {
            z = true;
        }
        if (z) {
            NImageView nImageView = e2.f14003c;
            d.a aVar = e.t.o.d.a;
            nImageView.setPadding(d.a.c(aVar, null, 1, null).d(12), d.a.c(aVar, null, 1, null).d(10), d.a.c(aVar, null, 1, null).d(12), d.a.c(aVar, null, 1, null).d(10));
            e2.f14003c.setScaleType(ImageView.ScaleType.FIT_XY);
            e2.f14003c.setBackgroundResource(R.drawable.bg_card_package);
        }
        return e2.getRoot();
    }

    private final void c() {
        final View a;
        final int i2 = 0;
        scrollTo(0, 0);
        removeAllViews();
        this.a = 0;
        final LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        for (Object obj : this.b) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            CardPackage cardPackage = (CardPackage) obj;
            if (getFirstType() != 1) {
                a = a(cardPackage);
            } else if (i2 == 0) {
                a = b(cardPackage);
            } else {
                a = a(cardPackage);
            }
            a.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CPHorizontalScrollView.d(linearLayout, this, a, i2, view);
                }
            });
            linearLayout.addView(a, new FrameLayout.LayoutParams(-2, -1));
            i2 = i3;
        }
        View childAt = linearLayout.getChildAt(this.a);
        if (childAt != null) {
            childAt.setSelected(true);
        }
        addView(linearLayout, new FrameLayout.LayoutParams(-2, -1));
    }

    public static final void d(LinearLayout linearLayout, CPHorizontalScrollView cPHorizontalScrollView, View view, int i2, View view2) {
        linearLayout.getChildAt(cPHorizontalScrollView.a).setSelected(false);
        view.setSelected(true);
        cPHorizontalScrollView.a = i2;
        l<Integer, t1> listener = cPHorizontalScrollView.getListener();
        if (listener != null) {
            listener.invoke(Integer.valueOf(cPHorizontalScrollView.a));
        }
        cPHorizontalScrollView.smoothScrollTo((int) ((view.getLeft() + (view.getWidth() / 2)) - (cPHorizontalScrollView.getWidth() * 0.3f)), 0);
    }

    public final void f(@e Integer num) {
        this.f4044e = num == null ? 0 : num.intValue();
    }

    public final int getFirstType() {
        return this.f4044e;
    }

    @e
    public final l<Integer, t1> getListener() {
        return this.f4043d;
    }

    public final void setData(@e List<CardPackage> list) {
        if (list == null) {
            return;
        }
        this.b.clear();
        this.b.addAll(list);
        c();
    }

    public final void setFirstType(int i2) {
        this.f4044e = i2;
    }

    public final void setListener(@e l<? super Integer, t1> lVar) {
        this.f4043d = lVar;
    }

    @h
    public CPHorizontalScrollView(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new ArrayList();
        this.f4042c = new a(0, 0, 3, null);
    }
}

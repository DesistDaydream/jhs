package com.jihuanshe.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.FilterInfoBtn;
import com.vector.util.Res;
import e.l.k.kf;
import e.l.s.a;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class FilterInfoBtn extends FrameLayout {
    @e
    private TextView a;
    @e
    private List<a> b;
    @e

    /* renamed from: c */
    private l<? super a, t1> f4069c;
    @e

    /* renamed from: d */
    private l<? super Boolean, t1> f4070d;

    @h
    public FilterInfoBtn(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ FilterInfoBtn(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static final void b(FilterInfoBtn filterInfoBtn, View view) {
        filterInfoBtn.f();
        l<Boolean, t1> showState = filterInfoBtn.getShowState();
        if (showState == null) {
            return;
        }
        showState.invoke(Boolean.TRUE);
    }

    public static /* synthetic */ void c(FilterInfoBtn filterInfoBtn, View view) {
        b(filterInfoBtn, view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(FilterInfoBtn filterInfoBtn, List list, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = null;
        }
        filterInfoBtn.d(list, i2);
    }

    private final void f() {
        if (this.b == null) {
            return;
        }
        new FilterInfoPopupWindow(getContext(), this, this.b, new FilterInfoBtn$showPopWindow$filterPopupWindow$1(this), new FilterInfoBtn$showPopWindow$filterPopupWindow$2(this)).showAsDropDown(this);
    }

    public final void a() {
        kf d2 = kf.d(LayoutInflater.from(getContext()), this, true);
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        d2.setLifecycleOwner((LifecycleOwner) context);
        AppCompatTextView appCompatTextView = d2.a;
        this.a = appCompatTextView;
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterInfoBtn.c(FilterInfoBtn.this, view);
            }
        });
    }

    public final void d(@e List<a> list, int i2) {
        this.b = list;
        if (list != null) {
            TextView textView = this.a;
            if (textView != null) {
                textView.setText(list.get(i2).f());
            }
            TextView textView2 = this.a;
            if (textView2 != null) {
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_down, 0);
                TextViewCompat.setCompoundDrawableTintList(textView2, ColorStateList.valueOf(Res.k(R.color.black)));
            }
            l<? super a, t1> lVar = this.f4069c;
            if (lVar == null) {
                return;
            }
            lVar.invoke(list.get(i2));
        }
    }

    @e
    public final List<a> getData() {
        return this.b;
    }

    @e
    public final l<a, t1> getListener() {
        return this.f4069c;
    }

    @e
    public final l<Boolean, t1> getShowState() {
        return this.f4070d;
    }

    @e
    public final TextView getTvName() {
        return this.a;
    }

    public final void setChooseListener(@e l<? super a, t1> lVar) {
        this.f4069c = lVar;
    }

    public final void setData(@e List<a> list) {
        this.b = list;
    }

    public final void setListener(@e l<? super a, t1> lVar) {
        this.f4069c = lVar;
    }

    public final void setOnShowStateListener(@e l<? super Boolean, t1> lVar) {
        this.f4070d = lVar;
    }

    public final void setShowState(@e l<? super Boolean, t1> lVar) {
        this.f4070d = lVar;
    }

    public final void setTvName(@e TextView textView) {
        this.a = textView;
    }

    @h
    public FilterInfoBtn(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}

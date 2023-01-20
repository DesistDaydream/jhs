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
import com.jihuanshe.ui.widget.FilterTextView;
import com.vector.util.Res;
import e.l.k.kf;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;

/* loaded from: classes2.dex */
public final class FilterTextView extends FrameLayout {
    @e
    private TextView a;
    @e
    private List<Pair<String, String>> b;
    @e

    /* renamed from: c */
    private l<? super Pair<String, String>, t1> f4093c;
    @e

    /* renamed from: d */
    private l<? super Pair<String, String>, t1> f4094d;
    @e

    /* renamed from: e */
    private l<? super Boolean, t1> f4095e;

    @h
    public FilterTextView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ FilterTextView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static final void b(FilterTextView filterTextView, View view) {
        filterTextView.e();
        l<Boolean, t1> showState = filterTextView.getShowState();
        if (showState == null) {
            return;
        }
        showState.invoke(Boolean.TRUE);
    }

    public static /* synthetic */ void c(FilterTextView filterTextView, View view) {
        b(filterTextView, view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(FilterTextView filterTextView, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = null;
        }
        filterTextView.setDataList(list);
    }

    private final void e() {
        if (this.b == null) {
            return;
        }
        new FilterPopupWindow(getContext(), this, this.b, new FilterTextView$showPopWindow$filterPopupWindow$1(this), new FilterTextView$showPopWindow$filterPopupWindow$2(this)).showAsDropDown(this);
    }

    public final void a() {
        kf d2 = kf.d(LayoutInflater.from(getContext()), this, true);
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        d2.setLifecycleOwner((LifecycleOwner) context);
        AppCompatTextView appCompatTextView = d2.a;
        this.a = appCompatTextView;
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterTextView.c(FilterTextView.this, view);
            }
        });
    }

    @e
    public final List<Pair<String, String>> getData() {
        return this.b;
    }

    @e
    public final l<Pair<String, String>, t1> getListener() {
        return this.f4093c;
    }

    @e
    public final l<Boolean, t1> getShowState() {
        return this.f4095e;
    }

    @e
    public final l<Pair<String, String>, t1> getStatListener() {
        return this.f4094d;
    }

    @e
    public final TextView getTvName() {
        return this.a;
    }

    public final void setChooseListener(@e l<? super Pair<String, String>, t1> lVar) {
        this.f4093c = lVar;
    }

    public final void setData(@e List<Pair<String, String>> list) {
        this.b = list;
    }

    public final void setDataList(@e List<Pair<String, String>> list) {
        this.b = list;
        if (list != null) {
            TextView textView = this.a;
            if (textView != null) {
                textView.setText(list.get(0).getFirst());
            }
            TextView textView2 = this.a;
            if (textView2 != null) {
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_down, 0);
                TextViewCompat.setCompoundDrawableTintList(textView2, ColorStateList.valueOf(Res.k(R.color.black)));
            }
            l<? super Pair<String, String>, t1> lVar = this.f4093c;
            if (lVar == null) {
                return;
            }
            lVar.invoke(list.get(0));
        }
    }

    public final void setListener(@e l<? super Pair<String, String>, t1> lVar) {
        this.f4093c = lVar;
    }

    public final void setOnShowStateListener(@e l<? super Boolean, t1> lVar) {
        this.f4095e = lVar;
    }

    public final void setShowState(@e l<? super Boolean, t1> lVar) {
        this.f4095e = lVar;
    }

    public final void setStatListener(@e l<? super Pair<String, String>, t1> lVar) {
        this.f4094d = lVar;
    }

    public final void setTvName(@e TextView textView) {
        this.a = textView;
    }

    @h
    public FilterTextView(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}

package com.jihuanshe.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.jihuanshe.R;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.dialog.ConditionSideDialog;
import com.jihuanshe.ui.widget.ConditionFilterBtn;
import com.vector.util.Res;
import e.t.o.d;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ConditionFilterBtn extends AppCompatTextView {
    @e
    private List<Rarity> a;
    @d
    private List<Rarity> b;
    @e

    /* renamed from: c */
    private l<? super List<Rarity>, t1> f4049c;
    @e

    /* renamed from: d */
    private Drawable f4050d;

    @h
    public ConditionFilterBtn(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ ConditionFilterBtn(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static final void e(ConditionFilterBtn conditionFilterBtn, Context context, View view) {
        if (conditionFilterBtn.getData() == null) {
            return;
        }
        new ConditionSideDialog(context, conditionFilterBtn.getData(), conditionFilterBtn.getCurrent(), new ConditionFilterBtn$1$1(conditionFilterBtn)).y();
    }

    public static /* synthetic */ void f(ConditionFilterBtn conditionFilterBtn, Context context, View view) {
        e(conditionFilterBtn, context, view);
    }

    @d
    public final List<Rarity> getCurrent() {
        return this.b;
    }

    @e
    public final List<Rarity> getData() {
        return this.a;
    }

    @e
    public final Drawable getDrawable() {
        return this.f4050d;
    }

    @e
    public final l<List<Rarity>, t1> getListener() {
        return this.f4049c;
    }

    public final void setCurrent(@d List<Rarity> list) {
        this.b = list;
    }

    public final void setData(@e List<Rarity> list) {
        this.a = list;
    }

    public final void setDrawable(@e Drawable drawable) {
        this.f4050d = drawable;
    }

    public final void setListener(@e l<? super List<Rarity>, t1> lVar) {
        this.f4049c = lVar;
    }

    @h
    public ConditionFilterBtn(@d final Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new ArrayList();
        Res res = Res.a;
        Drawable q = Res.q(res, R.drawable.svg_rarity, null, 2, null);
        Drawable mutate = q == null ? null : q.mutate();
        this.f4050d = mutate;
        setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, mutate, (Drawable) null);
        setCompoundDrawablePadding(d.a.c(e.t.o.d.a, null, 1, null).d(6));
        setText(Res.w(res, R.string.card_detail_condition_1, null, 2, null));
        setGravity(8388629);
        setMaxEms(6);
        setEllipsize(TextUtils.TruncateAt.END);
        setSingleLine();
        setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConditionFilterBtn.f(ConditionFilterBtn.this, context, view);
            }
        });
    }
}

package com.jihuanshe.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.jihuanshe.R;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.dialog.RaritySideDialog;
import com.jihuanshe.ui.widget.RarityFilterBtn;
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
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class RarityFilterBtn extends AppCompatTextView {
    @e
    private List<Rarity> a;
    @d
    private List<Rarity> b;
    @e

    /* renamed from: c */
    private l<? super List<Rarity>, t1> f4195c;
    @e

    /* renamed from: d */
    private l<? super List<Rarity>, t1> f4196d;
    @e

    /* renamed from: e */
    private Drawable f4197e;

    @h
    public RarityFilterBtn(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ RarityFilterBtn(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static final void e(Context context, RarityFilterBtn rarityFilterBtn, View view) {
        List<Rarity> data = rarityFilterBtn.getData();
        if (data == null) {
            data = CollectionsKt__CollectionsKt.E();
        }
        new RaritySideDialog(context, data, rarityFilterBtn.getCurrent(), new RarityFilterBtn$1$1(rarityFilterBtn)).y();
    }

    public static /* synthetic */ void f(Context context, RarityFilterBtn rarityFilterBtn, View view) {
        e(context, rarityFilterBtn, view);
    }

    public static /* synthetic */ void h(RarityFilterBtn rarityFilterBtn, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        rarityFilterBtn.g(z);
    }

    public final void g(boolean z) {
        l<? super List<Rarity>, t1> lVar;
        this.b.clear();
        Drawable drawable = this.f4197e;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, null);
        }
        if (!z || (lVar = this.f4195c) == null) {
            return;
        }
        lVar.invoke(new ArrayList());
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
        return this.f4197e;
    }

    @e
    public final l<List<Rarity>, t1> getListener() {
        return this.f4195c;
    }

    @e
    public final l<List<Rarity>, t1> getStatListener() {
        return this.f4196d;
    }

    public final void setCurrent(@d List<Rarity> list) {
        this.b = list;
    }

    public final void setData(@e List<Rarity> list) {
        this.a = list;
    }

    public final void setDrawable(@e Drawable drawable) {
        this.f4197e = drawable;
    }

    public final void setListener(@e l<? super List<Rarity>, t1> lVar) {
        this.f4195c = lVar;
    }

    public final void setStatListener(@e l<? super List<Rarity>, t1> lVar) {
        this.f4196d = lVar;
    }

    @h
    public RarityFilterBtn(@d final Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new ArrayList();
        Res res = Res.a;
        Drawable q = Res.q(res, R.drawable.svg_rarity, null, 2, null);
        Drawable mutate = q == null ? null : q.mutate();
        this.f4197e = mutate;
        setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, mutate, (Drawable) null);
        setCompoundDrawablePadding(d.a.c(e.t.o.d.a, null, 1, null).d(6));
        setText(Res.w(res, R.string.common_filter, null, 2, null));
        setGravity(8388629);
        setMaxEms(6);
        setEllipsize(TextUtils.TruncateAt.END);
        setSingleLine();
        setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RarityFilterBtn.f(context, this, view);
            }
        });
    }
}

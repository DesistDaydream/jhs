package com.jihuanshe.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.ui.widget.GameBarSmall;
import e.l.k.qf;
import e.n.i;
import e.t.o.d;
import h.k2.h;
import h.k2.v.u;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class GameBarSmall extends GameBar {
    @e

    /* renamed from: e */
    private ImageView f4098e;
    @e

    /* renamed from: f */
    private TextView f4099f;
    @d

    /* renamed from: g */
    private final i f4100g;

    @h
    public GameBarSmall(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ GameBarSmall(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static final void e(GameBarSmall gameBarSmall, View view) {
        PopupWindow popWindow = gameBarSmall.getPopWindow();
        if (popWindow == null) {
            return;
        }
        popWindow.showAsDropDown(gameBarSmall, d.a.c(e.t.o.d.a, null, 1, null).d(16), 0);
    }

    public static final void f(GameBarSmall gameBarSmall, View view) {
        Context context = gameBarSmall.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) context).finish();
    }

    @Override // com.jihuanshe.ui.widget.GameBar
    public void b() {
        qf e2 = qf.e(LayoutInflater.from(getContext()), this, true);
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        e2.setLifecycleOwner((LifecycleOwner) context);
        e2.h(this);
        this.f4098e = e2.a;
        TextView textView = e2.b;
        this.f4099f = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.q
            {
                GameBarSmall.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameBarSmall.e(GameBarSmall.this, view);
            }
        });
        e2.a.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.r
            {
                GameBarSmall.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameBarSmall.f(GameBarSmall.this, view);
            }
        });
    }

    @e
    public final ImageView getBackImage() {
        return this.f4098e;
    }

    @k.e.a.d
    public final i getDrawableTint() {
        return this.f4100g;
    }

    @e
    public final TextView getNameTextView() {
        return this.f4099f;
    }

    public final void setBackImage(@e ImageView imageView) {
        this.f4098e = imageView;
    }

    public final void setNameTextView(@e TextView textView) {
        this.f4099f = textView;
    }

    @h
    public GameBarSmall(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4100g = new i(Boolean.FALSE);
    }
}

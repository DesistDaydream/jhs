package com.jihuanshe.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.core.widget.TextViewCompat;
import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GameBarView;
import com.vector.util.Res;
import e.l.k.mf;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class GameBarView extends FrameLayout {
    @e
    private final l<Boolean, t1> a;
    @e
    private final l<Game, t1> b;
    @e

    /* renamed from: c */
    private TextView f4101c;

    /* renamed from: d */
    private boolean f4102d;
    @d

    /* renamed from: e */
    private final w f4103e;

    @h
    public GameBarView(@d Context context) {
        this(context, null, null, null, 14, null);
    }

    @h
    public GameBarView(@d Context context, @e l<? super Boolean, t1> lVar) {
        this(context, lVar, null, null, 12, null);
    }

    @h
    public GameBarView(@d Context context, @e l<? super Boolean, t1> lVar, @e l<? super Game, t1> lVar2) {
        this(context, lVar, lVar2, null, 8, null);
    }

    public /* synthetic */ GameBarView(Context context, l lVar, l lVar2, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : lVar, (i2 & 4) != 0 ? null : lVar2, (i2 & 8) != 0 ? null : attributeSet);
    }

    public static final void b(GameBarView gameBarView, View view) {
        gameBarView.getPopWindow().showAsDropDown(gameBarView);
        l<Boolean, t1> showState = gameBarView.getShowState();
        if (showState == null) {
            return;
        }
        showState.invoke(Boolean.TRUE);
    }

    public final void a() {
        mf d2 = mf.d(LayoutInflater.from(getContext()), this, true);
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        d2.setLifecycleOwner((LifecycleOwner) context);
        TextView textView = d2.a;
        this.f4101c = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.s
            {
                GameBarView.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameBarView.b(GameBarView.this, view);
            }
        });
    }

    public final boolean getFitter() {
        return this.f4102d;
    }

    @e
    public final l<Game, t1> getListener() {
        return this.b;
    }

    @d
    public final GamesPopupWindow getPopWindow() {
        return (GamesPopupWindow) this.f4103e.getValue();
    }

    @e
    public final l<Boolean, t1> getShowState() {
        return this.a;
    }

    @e
    public final TextView getTvName() {
        return this.f4101c;
    }

    public final void setFitter(boolean z) {
        this.f4102d = z;
    }

    public final void setGNColor(@ColorRes int i2) {
        TextView textView = this.f4101c;
        if (textView != null) {
            textView.setTextColor(Res.k(i2));
        }
        TextView textView2 = this.f4101c;
        if (textView2 == null) {
            return;
        }
        TextViewCompat.setCompoundDrawableTintList(textView2, ColorStateList.valueOf(Res.k(i2)));
    }

    public final void setTvName(@e TextView textView) {
        this.f4101c = textView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h
    public GameBarView(@d Context context, @e l<? super Boolean, t1> lVar, @e l<? super Game, t1> lVar2, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = lVar;
        this.b = lVar2;
        a();
        this.f4103e = z.c(new GameBarView$popWindow$2(context, this));
    }
}

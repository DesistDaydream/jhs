package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GameBar;
import e.l.k.of;
import e.n.f;
import e.t.o.d;
import h.k2.h;
import h.k2.k;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.w;
import h.z;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public class GameBar extends FrameLayout {
    @d

    /* renamed from: c */
    private static final String f4096c = "GameBar";
    @e
    private PopupWindow a;
    @d
    public static final a b = new a(null);
    @d

    /* renamed from: d */
    private static final w<f<Game>> f4097d = z.c(GameBar$Companion$curGame$2.INSTANCE);

    /* loaded from: classes2.dex */
    public static final class a {
        public static final /* synthetic */ n<Object>[] a = {n0.r(new PropertyReference1Impl(n0.d(a.class), "curGame", "getCurGame()Lcom/live/Live;"))};

        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public static /* synthetic */ void b() {
        }

        @d
        public final f<Game> a() {
            return (f) GameBar.f4097d.getValue();
        }
    }

    @h
    public GameBar(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ GameBar(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static final void c(GameBar gameBar, View view) {
        PopupWindow popWindow = gameBar.getPopWindow();
        if (popWindow == null) {
            return;
        }
        popWindow.showAsDropDown(gameBar, d.a.c(e.t.o.d.a, null, 1, null).d(16), 0);
    }

    @k.e.a.d
    public static final f<Game> getCurGame() {
        return b.a();
    }

    public void b() {
        of d2 = of.d(LayoutInflater.from(getContext()), this, true);
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        d2.setLifecycleOwner((LifecycleOwner) context);
        d2.a.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.p
            {
                GameBar.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameBar.c(GameBar.this, view);
            }
        });
    }

    @e
    public final PopupWindow getPopWindow() {
        return this.a;
    }

    public final void setPopWindow(@e PopupWindow popupWindow) {
        this.a = popupWindow;
    }

    @h
    public GameBar(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new GamePopupWindow(context, GameBar$popWindow$1.INSTANCE);
        b();
    }
}

package com.jihuanshe.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.widget.UserBar;
import e.l.k.qg;
import e.n.f;
import e.n.i;
import e.t.r.a.a;
import h.k2.h;
import h.k2.v.u;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class UserBar extends FrameLayout {
    @e
    private ImageView a;
    @d
    private final a b;
    @d

    /* renamed from: c */
    private final f<User> f4244c;
    @d

    /* renamed from: d */
    private final i f4245d;

    @h
    public UserBar(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ UserBar(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static final void b(UserBar userBar, View view) {
        Context context = userBar.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) context).finish();
    }

    public final void a() {
        qg e2 = qg.e(LayoutInflater.from(getContext()), this, true);
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        e2.setLifecycleOwner((LifecycleOwner) context);
        e2.h(this);
        ImageView imageView = e2.a;
        this.a = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.d0
            {
                UserBar.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserBar.b(UserBar.this, view);
            }
        });
    }

    @e
    public final ImageView getBackImage() {
        return this.a;
    }

    @d
    public final i getHideUser() {
        return this.f4245d;
    }

    @d
    public final a getShape() {
        return this.b;
    }

    @d
    public final f<User> getUser() {
        return this.f4244c;
    }

    public final void setBackImage(@e ImageView imageView) {
        this.a = imageView;
    }

    @h
    public UserBar(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new a(0, 0, 3, null);
        this.f4244c = new f<>(null, 1, null);
        this.f4245d = new i(Boolean.TRUE);
        a();
    }
}

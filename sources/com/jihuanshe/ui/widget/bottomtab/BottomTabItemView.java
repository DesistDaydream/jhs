package com.jihuanshe.ui.widget.bottomtab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.databinding.Observable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jihuanshe.ui.widget.bottomtab.BottomTabItemView;
import com.vector.util.Res;
import h.k2.v.u;
import h.t1;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class BottomTabItemView extends RelativeLayout {
    @d

    /* renamed from: h */
    public static final a f4247h = new a(null);

    /* renamed from: i */
    public static final float f4248i = 30.0f;

    /* renamed from: j */
    public static final float f4249j = 60.0f;

    /* renamed from: k */
    public static final float f4250k = 9.0f;

    /* renamed from: l */
    public static final int f4251l = 0;

    /* renamed from: m */
    public static final int f4252m = 1;
    @d
    private e.l.q.c.p0.c a;
    @e
    private ImageView b;
    @e

    /* renamed from: c */
    private TextView f4253c;
    @e

    /* renamed from: d */
    private TextView f4254d;
    @e

    /* renamed from: e */
    private View f4255e;
    @d

    /* renamed from: f */
    private final c f4256f;
    @e

    /* renamed from: g */
    private b f4257g;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(@d e.l.q.c.p0.c cVar);
    }

    /* loaded from: classes2.dex */
    public static final class c extends Observable.OnPropertyChangedCallback {
        public c() {
            BottomTabItemView.this = r1;
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(@e Observable observable, int i2) {
            BottomTabItemView.this.l();
        }
    }

    public BottomTabItemView(@e Context context, @d e.l.q.c.p0.c cVar) {
        super(context);
        this.f4256f = new c();
        this.a = cVar;
        c();
    }

    private final void c() {
        i();
        f();
        h();
        g();
        l();
        if (!this.a.k()) {
            setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.p0.a
                {
                    BottomTabItemView.this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BottomTabItemView.d(BottomTabItemView.this, view);
                }
            });
        } else {
            ImageView imageView = this.b;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.p0.b
                    {
                        BottomTabItemView.this = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BottomTabItemView.e(BottomTabItemView.this, view);
                    }
                });
            }
        }
        this.a.e().addOnPropertyChangedCallback(this.f4256f);
        this.a.d().addOnPropertyChangedCallback(this.f4256f);
    }

    public static final void d(BottomTabItemView bottomTabItemView, View view) {
        b bVar = bottomTabItemView.f4257g;
        if (bVar == null) {
            return;
        }
        bVar.a(bottomTabItemView.a);
    }

    public static final void e(BottomTabItemView bottomTabItemView, View view) {
        b bVar = bottomTabItemView.f4257g;
        if (bVar == null) {
            return;
        }
        bVar.a(bottomTabItemView.a);
    }

    private final void f() {
        ImageView floatingActionButton = this.a.k() ? new FloatingActionButton(getContext()) : new AppCompatImageView(getContext());
        floatingActionButton.setId(RelativeLayout.generateViewId());
        floatingActionButton.setImageResource(this.a.a());
        e.l.q.c.p0.d dVar = e.l.q.c.p0.d.a;
        int b2 = dVar.b(5.0f);
        floatingActionButton.setPadding(b2, b2, b2, b2);
        t1 t1Var = t1.a;
        this.b = floatingActionButton;
        int b3 = dVar.b(!this.a.k() ? 30.0f : 60.0f);
        View view = this.b;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b3, b3);
        layoutParams.addRule(14);
        if (!this.a.k()) {
            layoutParams.addRule(2, this.f4253c.getId());
        } else {
            layoutParams.topMargin = -dVar.b(20.0f);
        }
        addView(view, layoutParams);
    }

    private final void g() {
        TextView textView = new TextView(getContext());
        textView.setTextColor(-1);
        textView.setTextSize(2, 10.0f);
        textView.setIncludeFontPadding(false);
        float b2 = e.l.q.c.p0.d.a.b(9.0f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{b2, b2, b2, b2, b2, b2, b2, b2}, null, null));
        shapeDrawable.getPaint().setColor(-65536);
        textView.setBackground(shapeDrawable);
        t1 t1Var = t1.a;
        this.f4254d = textView;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(6, this.b.getId());
        layoutParams.addRule(19, this.b.getId());
        addView(textView, layoutParams);
    }

    private final void h() {
        View view = new View(getContext());
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(-65536);
        t1 t1Var = t1.a;
        view.setBackground(shapeDrawable);
        this.f4255e = view;
        e.l.q.c.p0.d dVar = e.l.q.c.p0.d.a;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dVar.b(5.0f), dVar.b(5.0f));
        layoutParams.addRule(6, this.b.getId());
        layoutParams.addRule(19, this.b.getId());
        addView(view, layoutParams);
    }

    private final void i() {
        if (this.a.k()) {
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setId(View.generateViewId());
        textView.setTextSize(2, 11.0f);
        textView.setText(this.a.h());
        textView.setPadding(0, 0, 0, e.l.q.c.p0.d.a.b(10.0f));
        textView.setTextColor(Res.k(this.a.i()));
        t1 t1Var = t1.a;
        this.f4253c = textView;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(textView, layoutParams);
    }

    public final void l() {
        String valueOf;
        TextView textView = this.f4254d;
        if (textView != null) {
            textView.setVisibility(this.a.f() > 0 ? 0 : 8);
            e.l.q.c.p0.d dVar = e.l.q.c.p0.d.a;
            textView.setPadding(dVar.b(5.0f), dVar.b(1.0f), dVar.b(5.0f), dVar.b(1.0f));
            if (this.a.f() > 99) {
                valueOf = "99+";
            } else {
                valueOf = this.a.f() > 0 ? String.valueOf(this.a.f()) : "";
            }
            textView.setText(valueOf);
        }
        View view = this.f4255e;
        if (view == null) {
            return;
        }
        view.setVisibility(this.a.l() ? 0 : 8);
    }

    public final void b(int i2) {
        ImageView imageView;
        TextView textView = this.f4253c;
        if (textView != null) {
            Context context = getContext();
            e.l.q.c.p0.c cVar = this.a;
            textView.setTextColor(ContextCompat.getColor(context, i2 == 1 ? cVar.j() : cVar.i()));
        }
        if (i2 == 1) {
            if (this.a.b() != 0) {
                ImageView imageView2 = this.b;
                if (imageView2 == null) {
                    return;
                }
                imageView2.setImageResource(this.a.b());
                return;
            } else if (this.a.c() == 0 || (imageView = this.b) == null) {
                return;
            } else {
                imageView.setImageTintList(ColorStateList.valueOf(this.a.c()));
                return;
            }
        }
        ImageView imageView3 = this.b;
        if (imageView3 != null) {
            imageView3.setImageTintList(null);
        }
        ImageView imageView4 = this.b;
        if (imageView4 == null) {
            return;
        }
        imageView4.setImageResource(this.a.a());
    }

    public final void setOnSelectListener(@d b bVar) {
        this.f4257g = bVar;
    }
}

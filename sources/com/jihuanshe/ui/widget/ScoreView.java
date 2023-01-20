package com.jihuanshe.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.StarView;
import com.vector.ext.view.ViewKt;
import com.vector.util.Res;
import e.l.h.k.b;
import e.t.o.d;
import h.k2.h;
import h.k2.v.u;
import h.t1;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public final class ScoreView extends LinearLayout {
    @d
    public static final a n = new a(null);
    @d
    private static final String o = "ScoreView";
    private final int a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f4205c;

    /* renamed from: d  reason: collision with root package name */
    private float f4206d;

    /* renamed from: e  reason: collision with root package name */
    private float f4207e;

    /* renamed from: f  reason: collision with root package name */
    private int f4208f;

    /* renamed from: g  reason: collision with root package name */
    private int f4209g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4210h;

    /* renamed from: i  reason: collision with root package name */
    private float f4211i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4212j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4213k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private final List<StarView> f4214l;
    @e

    /* renamed from: m  reason: collision with root package name */
    private TextView f4215m;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @h
    public ScoreView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ ScoreView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    private final void a() {
        float f2 = this.f4205c;
        int i2 = (int) (f2 / 2);
        int i3 = 0;
        boolean z = f2 % 2.0f >= 1.0f;
        if (i2 > 0) {
            while (true) {
                int i4 = i3 + 1;
                StarView starView = (StarView) CollectionsKt___CollectionsKt.J2(this.f4214l, i3);
                if (starView == null) {
                    break;
                }
                starView.setState(StarView.StarState.ALL);
                if (i4 >= i2) {
                    break;
                }
                i3 = i4;
            }
        }
        if (z) {
            StarView starView2 = (StarView) CollectionsKt___CollectionsKt.J2(this.f4214l, i2);
            if (starView2 == null) {
                return;
            }
            starView2.setState(StarView.StarState.HALF);
            e(i2 + 1);
            return;
        }
        e(i2);
    }

    private final void b(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        int i2 = 0;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.ScoreView, 0, 0);
        try {
            try {
                int indexCount = obtainStyledAttributes.getIndexCount();
                if (indexCount > 0) {
                    while (true) {
                        int i3 = i2 + 1;
                        int index = obtainStyledAttributes.getIndex(i2);
                        if (index == 0) {
                            this.f4211i = obtainStyledAttributes.getDimension(index, this.f4211i);
                        } else if (index == 1) {
                            this.f4213k = obtainStyledAttributes.getBoolean(index, this.f4213k);
                        } else if (index == 2) {
                            this.f4212j = obtainStyledAttributes.getBoolean(index, this.f4212j);
                        } else if (index == 5) {
                            this.b = obtainStyledAttributes.getDimension(index, this.b);
                        } else if (index == 6) {
                            this.f4210h = obtainStyledAttributes.getBoolean(index, this.f4210h);
                        } else if (index == 7) {
                            this.f4208f = obtainStyledAttributes.getColor(index, this.f4208f);
                        } else if (index == 8) {
                            this.f4206d = obtainStyledAttributes.getFloat(index, this.f4206d);
                        }
                        if (i3 >= indexCount) {
                            break;
                        }
                        i2 = i3;
                    }
                }
            } catch (Exception e2) {
                b bVar = b.a;
                String message = e2.getMessage();
                if (message == null) {
                    message = "init score view fail.";
                }
                bVar.b(o, message);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private final void c() {
        if (!this.f4213k) {
            return;
        }
        this.f4214l.clear();
        int i2 = 0;
        int i3 = this.a;
        if (i3 <= 0) {
            return;
        }
        while (true) {
            int i4 = i2 + 1;
            StarView starView = new StarView(getContext(), null, 2, null);
            this.f4214l.add(starView);
            float f2 = this.f4211i;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) f2, (int) f2);
            layoutParams.gravity = 16;
            if (i2 > 0) {
                layoutParams.leftMargin = (int) this.b;
            }
            if (i2 == this.a - 1 && this.f4212j) {
                layoutParams.rightMargin = (int) this.b;
            }
            addView(starView, layoutParams);
            if (i4 >= i3) {
                return;
            }
            i2 = i4;
        }
    }

    private final void d() {
        if (this.f4212j) {
            TextView textView = new TextView(getContext());
            this.f4215m = textView;
            textView.setTextSize(2, this.f4206d);
            this.f4215m.setTextColor(this.f4208f);
            this.f4215m.setSingleLine();
            if (this.f4210h) {
                this.f4215m.setTypeface(null, 1);
            }
            View view = this.f4215m;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (this.f4213k) {
                layoutParams.bottomMargin = d.a.c(e.t.o.d.a, null, 1, null).d(2);
            }
            t1 t1Var = t1.a;
            addView(view, layoutParams);
        }
    }

    private final void e(int i2) {
        int i3 = this.a;
        if (i2 >= i3) {
            return;
        }
        while (true) {
            int i4 = i2 + 1;
            StarView starView = (StarView) CollectionsKt___CollectionsKt.J2(this.f4214l, i2);
            if (starView != null) {
                starView.setState(StarView.StarState.NONE);
            }
            if (i4 >= i3) {
                return;
            }
            i2 = i4;
        }
    }

    public final void setScore(@e Float f2) {
        if (f2 == null) {
            TextView textView = this.f4215m;
            if (textView != null) {
                textView.setTextSize(2, this.f4207e);
            }
            TextView textView2 = this.f4215m;
            if (textView2 != null) {
                textView2.setTextColor(this.f4209g);
            }
            TextView textView3 = this.f4215m;
            if (textView3 != null) {
                textView3.setText(Res.w(Res.a, R.string.grade_no_point, null, 2, null));
            }
            for (StarView starView : this.f4214l) {
                ViewKt.n(starView);
            }
            return;
        }
        TextView textView4 = this.f4215m;
        if (textView4 != null) {
            textView4.setTextColor(this.f4208f);
        }
        TextView textView5 = this.f4215m;
        if (textView5 != null) {
            textView5.setTextSize(2, this.f4206d);
        }
        for (StarView starView2 : this.f4214l) {
            ViewKt.I(starView2);
        }
        float min = Math.min(Math.max(0.0f, f2.floatValue()), 10.0f);
        this.f4205c = min;
        if (min == 0.0f) {
            TextView textView6 = this.f4215m;
            if (textView6 != null) {
                textView6.setText("0");
            }
        } else {
            TextView textView7 = this.f4215m;
            if (textView7 != null) {
                textView7.setText(new DecimalFormat("##.0").format(Float.valueOf(this.f4205c)));
            }
        }
        a();
    }

    @h
    public ScoreView(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 5;
        d.a aVar = e.t.o.d.a;
        this.b = d.a.c(aVar, null, 1, null).d(1);
        this.f4206d = 12.0f;
        this.f4207e = 12.0f;
        this.f4208f = Res.k(R.color.black_b5b5b7);
        this.f4209g = Res.k(R.color.black_b5b5b7);
        this.f4210h = true;
        this.f4211i = d.a.c(aVar, null, 1, null).d(12);
        this.f4212j = true;
        this.f4213k = true;
        this.f4214l = new ArrayList();
        setOrientation(0);
        b(attributeSet);
        c();
        d();
    }
}

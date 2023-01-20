package e.l.i;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.AnimRes;
import androidx.databinding.BindingAdapter;
import com.vector.ext.view.ViewKt;
import com.vector.view.scrollable.ListView;
import e.t.o.d;

/* loaded from: classes2.dex */
public final class f0 {
    @k.e.a.d
    public static final f0 a = new f0();
    @k.e.a.d
    private static final String b = "android:view_blur_background";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12160c = "android:blur_sample";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12161d = "android:blur_filter_color";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f12162e = "android:blur_error_drawable";
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final String f12163f = "android:view_layout_height";
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final String f12164g = "android:blur_placeholder";
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private static final String f12165h = "android:view_verification_listener";
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    private static final String f12166i = "android:view_visibility";
    @k.e.a.d

    /* renamed from: j  reason: collision with root package name */
    private static final String f12167j = "android:view_anim";
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    private static final String f12168k = "android:under_score";
    @k.e.a.d

    /* renamed from: l  reason: collision with root package name */
    private static final String f12169l = "android:minHeight";
    @k.e.a.d

    /* renamed from: m  reason: collision with root package name */
    private static final String f12170m = "android:clickable";
    @k.e.a.d
    private static final String n = "android:textview_medium";
    @k.e.a.d
    private static final String o = "android:view_tag";
    @k.e.a.d
    private static final String p = "android:view_horizontal_margin";
    public static final int q = 5;
    public static final int r = 1;
    @k.e.a.d
    private static final String s = "android:listView_paddingTop";
    @k.e.a.d
    private static final String t = "android:listView_paddingBottom";

    /* loaded from: classes2.dex */
    public static final class a extends e.b.a.t.k.f<View, Drawable> {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View f12171h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            this.f12171h = view;
        }

        @Override // e.b.a.t.k.f
        public void f(@k.e.a.e Drawable drawable) {
        }

        @Override // e.b.a.t.k.p
        /* renamed from: m */
        public void onResourceReady(@k.e.a.d Drawable drawable, @k.e.a.e e.b.a.t.l.f<? super Drawable> fVar) {
            View view = this.f12171h;
            if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(drawable);
            } else {
                view.setBackground(drawable);
            }
        }

        @Override // e.b.a.t.k.p
        public void onLoadFailed(@k.e.a.e Drawable drawable) {
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements Animation.AnimationListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;

        public b(View view, int i2) {
            this.a = view;
            this.b = i2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@k.e.a.e Animation animation) {
            this.a.setVisibility(this.b);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@k.e.a.e Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@k.e.a.e Animation animation) {
        }
    }

    private f0() {
    }

    @BindingAdapter(requireAll = false, value = {b, f12160c, f12161d, f12162e, f12164g})
    @h.k2.k
    public static final void a(@k.e.a.d View view, @k.e.a.e String str, int i2, int i3, @k.e.a.e Drawable drawable, int i4) {
        e.b.a.c.D(view.getContext()).n().k(str).F1((e.b.a.i) e.b.a.c.D(view.getContext()).j(Integer.valueOf(i4)).L0(new g.a.a.a.b(5, i2))).Q0(new g.a.a.a.b(5, i2), new g.a.a.a.d(i3)).j1(new a(view));
    }

    public static /* synthetic */ void b(View view, String str, int i2, int i3, Drawable drawable, int i4, int i5, Object obj) {
        int i6 = (i5 & 4) != 0 ? 1 : i2;
        int i7 = (i5 & 8) != 0 ? 0 : i3;
        if ((i5 & 16) != 0) {
            drawable = null;
        }
        a(view, str, i6, i7, drawable, (i5 & 32) != 0 ? 0 : i4);
    }

    @BindingAdapter({f12170m})
    @h.k2.k
    public static final void c(@k.e.a.d View view, @k.e.a.e Boolean bool) {
        if (bool == null) {
            return;
        }
        view.setClickable(bool.booleanValue());
    }

    @BindingAdapter({"android:src"})
    @h.k2.k
    public static final void d(@k.e.a.d ImageView imageView, @k.e.a.e Integer num) {
        if (num == null) {
            return;
        }
        imageView.setImageResource(num.intValue());
    }

    @BindingAdapter({f12163f})
    @h.k2.k
    public static final void e(@k.e.a.d View view, float f2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) f2;
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter({p})
    @h.k2.k
    public static final void f(@k.e.a.d View view, @k.e.a.e Integer num) {
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        d.a aVar = e.t.o.d.a;
        ViewKt.v(view, Integer.valueOf(d.a.c(aVar, null, 1, null).d(intValue)), null, Integer.valueOf(d.a.c(aVar, null, 1, null).d(intValue)), null);
    }

    @BindingAdapter({n})
    @h.k2.k
    public static final void g(@k.e.a.d TextView textView, @k.e.a.e Boolean bool) {
        if (bool == null) {
            return;
        }
        textView.getPaint().setFakeBoldText(bool.booleanValue());
    }

    @BindingAdapter({f12169l})
    @h.k2.k
    public static final void h(@k.e.a.d View view, int i2) {
        view.setMinimumHeight(i2);
    }

    public static /* synthetic */ void i(View view, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        h(view, i2);
    }

    @BindingAdapter(requireAll = false, value = {s, t})
    @h.k2.k
    public static final void j(@k.e.a.d ListView listView, @k.e.a.e Integer num, @k.e.a.e Integer num2) {
        d.a aVar = e.t.o.d.a;
        listView.T(0, d.a.c(aVar, null, 1, null).d(num == null ? 0 : num.intValue()), 0, d.a.c(aVar, null, 1, null).d(num2 == null ? 0 : num2.intValue()));
    }

    @BindingAdapter({o})
    @h.k2.k
    public static final void k(@k.e.a.d View view, @k.e.a.e Object obj) {
        view.setTag(view.getId(), obj);
    }

    @BindingAdapter({f12168k})
    @h.k2.k
    public static final void l(@k.e.a.d TextView textView, boolean z) {
        if (z) {
            textView.getPaint().setFlags(9);
        } else {
            textView.getPaint().setFlags(17);
        }
    }

    @BindingAdapter({f12167j, f12166i})
    @h.k2.k
    public static final void m(@k.e.a.d View view, @AnimRes int i2, int i3) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), i2);
        loadAnimation.setAnimationListener(new b(view, i3));
        view.startAnimation(loadAnimation);
    }
}

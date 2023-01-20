package e.j.a.b.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import e.j.a.b.d.e;
import java.util.LinkedList;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public abstract class a<T extends e> {
    private T a;
    private Bundle b;

    /* renamed from: c  reason: collision with root package name */
    private LinkedList<InterfaceC0345a> f10488c;

    /* renamed from: d  reason: collision with root package name */
    private final g<T> f10489d = new i(this);

    /* renamed from: e.j.a.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0345a {
        void a(e eVar);

        int getState();
    }

    @e.j.a.b.c.m.a
    public static void o(FrameLayout frameLayout) {
        e.j.a.b.c.e v = e.j.a.b.c.e.v();
        Context context = frameLayout.getContext();
        int j2 = v.j(context);
        String d2 = e.j.a.b.c.r.g.d(context, j2);
        String c2 = e.j.a.b.c.r.g.c(context, j2);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(d2);
        linearLayout.addView(textView);
        Intent e2 = v.e(context, j2, null);
        if (e2 != null) {
            Button button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(c2);
            linearLayout.addView(button);
            button.setOnClickListener(new m(context, e2));
        }
    }

    private final void s(Bundle bundle, InterfaceC0345a interfaceC0345a) {
        T t = this.a;
        if (t != null) {
            interfaceC0345a.a(t);
            return;
        }
        if (this.f10488c == null) {
            this.f10488c = new LinkedList<>();
        }
        this.f10488c.add(interfaceC0345a);
        if (bundle != null) {
            Bundle bundle2 = this.b;
            if (bundle2 == null) {
                this.b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        a(this.f10489d);
    }

    private final void u(int i2) {
        while (!this.f10488c.isEmpty() && this.f10488c.getLast().getState() >= i2) {
            this.f10488c.removeLast();
        }
    }

    @e.j.a.b.c.m.a
    public abstract void a(g<T> gVar);

    @e.j.a.b.c.m.a
    public T b() {
        return this.a;
    }

    @e.j.a.b.c.m.a
    public void c(FrameLayout frameLayout) {
        o(frameLayout);
    }

    @e.j.a.b.c.m.a
    public void d(Bundle bundle) {
        s(bundle, new k(this, bundle));
    }

    @e.j.a.b.c.m.a
    public View e(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        s(bundle, new l(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.a == null) {
            c(frameLayout);
        }
        return frameLayout;
    }

    @e.j.a.b.c.m.a
    public void f() {
        T t = this.a;
        if (t != null) {
            t.onDestroy();
        } else {
            u(1);
        }
    }

    @e.j.a.b.c.m.a
    public void g() {
        T t = this.a;
        if (t != null) {
            t.a();
        } else {
            u(2);
        }
    }

    @e.j.a.b.c.m.a
    public void h(Activity activity, Bundle bundle, Bundle bundle2) {
        s(bundle2, new j(this, activity, bundle, bundle2));
    }

    @e.j.a.b.c.m.a
    public void i() {
        T t = this.a;
        if (t != null) {
            t.onLowMemory();
        }
    }

    @e.j.a.b.c.m.a
    public void j() {
        T t = this.a;
        if (t != null) {
            t.onPause();
        } else {
            u(5);
        }
    }

    @e.j.a.b.c.m.a
    public void k() {
        s(null, new o(this));
    }

    @e.j.a.b.c.m.a
    public void l(Bundle bundle) {
        T t = this.a;
        if (t != null) {
            t.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    @e.j.a.b.c.m.a
    public void m() {
        s(null, new n(this));
    }

    @e.j.a.b.c.m.a
    public void n() {
        T t = this.a;
        if (t != null) {
            t.onStop();
        } else {
            u(4);
        }
    }
}

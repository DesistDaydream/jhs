package e.j.a.c.b;

import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes2.dex */
public class a {
    private final View a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f10565c;

    /* renamed from: d  reason: collision with root package name */
    private int f10566d;

    /* renamed from: e  reason: collision with root package name */
    private int f10567e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10568f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10569g = true;

    public a(View view) {
        this.a = view;
    }

    public void a() {
        View view = this.a;
        ViewCompat.offsetTopAndBottom(view, this.f10566d - (view.getTop() - this.b));
        View view2 = this.a;
        ViewCompat.offsetLeftAndRight(view2, this.f10567e - (view2.getLeft() - this.f10565c));
    }

    public int b() {
        return this.f10565c;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.f10567e;
    }

    public int e() {
        return this.f10566d;
    }

    public boolean f() {
        return this.f10569g;
    }

    public boolean g() {
        return this.f10568f;
    }

    public void h() {
        this.b = this.a.getTop();
        this.f10565c = this.a.getLeft();
    }

    public void i(boolean z) {
        this.f10569g = z;
    }

    public boolean j(int i2) {
        if (!this.f10569g || this.f10567e == i2) {
            return false;
        }
        this.f10567e = i2;
        a();
        return true;
    }

    public boolean k(int i2) {
        if (!this.f10568f || this.f10566d == i2) {
            return false;
        }
        this.f10566d = i2;
        a();
        return true;
    }

    public void l(boolean z) {
        this.f10568f = z;
    }
}

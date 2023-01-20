package e.j.a.a;

import android.view.View;
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f {

    /* renamed from: e  reason: collision with root package name */
    public int f10085e;

    /* renamed from: f  reason: collision with root package name */
    public int f10086f;

    /* renamed from: g  reason: collision with root package name */
    public int f10087g;

    /* renamed from: h  reason: collision with root package name */
    public int f10088h;

    /* renamed from: i  reason: collision with root package name */
    public int f10089i;

    /* renamed from: j  reason: collision with root package name */
    public float f10090j;

    /* renamed from: k  reason: collision with root package name */
    public float f10091k;

    /* renamed from: l  reason: collision with root package name */
    public int f10092l;

    /* renamed from: m  reason: collision with root package name */
    public int f10093m;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public int a = Integer.MAX_VALUE;
    public int b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public int f10083c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f10084d = Integer.MIN_VALUE;
    public List<Integer> n = new ArrayList();

    public int a() {
        return this.f10087g;
    }

    public int b() {
        return this.o;
    }

    public int c() {
        return this.f10088h;
    }

    public int d() {
        return this.f10088h - this.f10089i;
    }

    public int e() {
        return this.f10085e;
    }

    public float f() {
        return this.f10090j;
    }

    public float g() {
        return this.f10091k;
    }

    public void h(View view, int i2, int i3, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.a = Math.min(this.a, (view.getLeft() - flexItem.getMarginLeft()) - i2);
        this.b = Math.min(this.b, (view.getTop() - flexItem.getMarginTop()) - i3);
        this.f10083c = Math.max(this.f10083c, view.getRight() + flexItem.getMarginRight() + i4);
        this.f10084d = Math.max(this.f10084d, view.getBottom() + flexItem.getMarginBottom() + i5);
    }
}

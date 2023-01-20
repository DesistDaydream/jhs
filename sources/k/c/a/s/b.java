package k.c.a.s;

import android.content.res.Resources;
import android.util.Log;

/* loaded from: classes4.dex */
public class b {
    public final Resources a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f16305c;

    /* renamed from: e  reason: collision with root package name */
    public k.c.a.c f16307e;

    /* renamed from: g  reason: collision with root package name */
    public String f16309g;

    /* renamed from: h  reason: collision with root package name */
    public int f16310h;

    /* renamed from: i  reason: collision with root package name */
    public Class<?> f16311i;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16308f = true;

    /* renamed from: d  reason: collision with root package name */
    public final f f16306d = new f();

    public b(Resources resources, int i2, int i3) {
        this.a = resources;
        this.b = i2;
        this.f16305c = i3;
    }

    public b a(Class<? extends Throwable> cls, int i2) {
        this.f16306d.a(cls, i2);
        return this;
    }

    public void b() {
        this.f16308f = false;
    }

    public k.c.a.c c() {
        k.c.a.c cVar = this.f16307e;
        return cVar != null ? cVar : k.c.a.c.f();
    }

    public int d(Throwable th) {
        Integer b = this.f16306d.b(th);
        if (b != null) {
            return b.intValue();
        }
        String str = k.c.a.c.s;
        Log.d(str, "No specific message ressource ID found for " + th);
        return this.f16305c;
    }

    public void e(int i2) {
        this.f16310h = i2;
    }

    public void f(Class<?> cls) {
        this.f16311i = cls;
    }

    public void g(k.c.a.c cVar) {
        this.f16307e = cVar;
    }

    public void h(String str) {
        this.f16309g = str;
    }
}

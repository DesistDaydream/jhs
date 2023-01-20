package e.j.a.b.c.n.u;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class j {
    private final Object a;

    public j(Activity activity) {
        e.j.a.b.c.r.a0.l(activity, "Activity must not be null");
        this.a = activity;
    }

    @e.j.a.b.c.m.a
    public Activity a() {
        return (Activity) this.a;
    }

    @e.j.a.b.c.m.a
    public FragmentActivity b() {
        return (FragmentActivity) this.a;
    }

    @e.j.a.b.c.m.a
    public Object c() {
        return this.a;
    }

    @e.j.a.b.c.m.a
    public boolean d() {
        return false;
    }

    @e.j.a.b.c.m.a
    public boolean e() {
        return this.a instanceof FragmentActivity;
    }

    public final boolean f() {
        return this.a instanceof Activity;
    }

    @e.j.a.b.c.m.a
    public j(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }
}

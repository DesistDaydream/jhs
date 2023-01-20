package e.j.a.b.c.n.u;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.LifecycleCallback;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public interface k {
    @e.j.a.b.c.m.a
    void a(String str, @NonNull LifecycleCallback lifecycleCallback);

    @e.j.a.b.c.m.a
    <T extends LifecycleCallback> T e(String str, Class<T> cls);

    @e.j.a.b.c.m.a
    boolean i();

    @e.j.a.b.c.m.a
    boolean k();

    @e.j.a.b.c.m.a
    Activity n();

    @e.j.a.b.c.m.a
    void startActivityForResult(Intent intent, int i2);
}

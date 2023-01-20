package k.c.a.r;

import k.c.a.n;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes4.dex */
public abstract class a implements c {
    private final Class a;
    private final Class<? extends c> b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f16297c;

    public a(Class cls, Class<? extends c> cls2, boolean z) {
        this.a = cls;
        this.b = cls2;
        this.f16297c = z;
    }

    @Override // k.c.a.r.c
    public Class b() {
        return this.a;
    }

    @Override // k.c.a.r.c
    public c c() {
        Class<? extends c> cls = this.b;
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // k.c.a.r.c
    public boolean d() {
        return this.f16297c;
    }

    public n e(String str, Class<?> cls) {
        return g(str, cls, ThreadMode.POSTING, 0, false);
    }

    public n f(String str, Class<?> cls, ThreadMode threadMode) {
        return g(str, cls, threadMode, 0, false);
    }

    public n g(String str, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        try {
            return new n(this.a.getDeclaredMethod(str, cls), cls, threadMode, i2, z);
        } catch (NoSuchMethodException e2) {
            throw new EventBusException("Could not find subscriber method in " + this.a + ". Maybe a missing ProGuard rule?", e2);
        }
    }
}

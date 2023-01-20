package k.c.a;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes4.dex */
public class n {
    public final Method a;
    public final ThreadMode b;

    /* renamed from: c  reason: collision with root package name */
    public final Class<?> f16279c;

    /* renamed from: d  reason: collision with root package name */
    public final int f16280d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f16281e;

    /* renamed from: f  reason: collision with root package name */
    public String f16282f;

    public n(Method method, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        this.a = method;
        this.b = threadMode;
        this.f16279c = cls;
        this.f16280d = i2;
        this.f16281e = z;
    }

    private synchronized void a() {
        if (this.f16282f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.a.getName());
            sb.append('(');
            sb.append(this.f16279c.getName());
            this.f16282f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            a();
            n nVar = (n) obj;
            nVar.a();
            return this.f16282f.equals(nVar.f16282f);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

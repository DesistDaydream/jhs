package k.c.a.r;

import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes4.dex */
public class e {
    public final String a;
    public final ThreadMode b;

    /* renamed from: c  reason: collision with root package name */
    public final Class<?> f16299c;

    /* renamed from: d  reason: collision with root package name */
    public final int f16300d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f16301e;

    public e(String str, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        this.a = str;
        this.b = threadMode;
        this.f16299c = cls;
        this.f16300d = i2;
        this.f16301e = z;
    }

    public e(String str, Class<?> cls) {
        this(str, cls, ThreadMode.POSTING, 0, false);
    }

    public e(String str, Class<?> cls, ThreadMode threadMode) {
        this(str, cls, threadMode, 0, false);
    }
}

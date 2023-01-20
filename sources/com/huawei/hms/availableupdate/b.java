package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final b f3433c = new b();

    /* renamed from: d  reason: collision with root package name */
    public static final Object f3434d = new Object();
    public final AtomicBoolean a = new AtomicBoolean(false);
    public List<Activity> b = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f3434d) {
            for (Activity activity2 : this.b) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.b.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f3434d) {
            this.b.remove(activity);
        }
    }

    public void a(boolean z) {
        this.a.set(z);
    }

    public AtomicBoolean a() {
        return this.a;
    }
}

package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class c {
    public static final c b = new c();

    /* renamed from: c  reason: collision with root package name */
    public static final Object f3435c = new Object();
    public final List<Activity> a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f3435c) {
            for (Activity activity2 : this.a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f3435c) {
            this.a.remove(activity);
        }
    }
}

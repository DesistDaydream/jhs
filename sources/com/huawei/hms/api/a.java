package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class a {
    public static final a b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f3432c = new Object();
    public List<Activity> a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f3432c) {
            for (Activity activity2 : this.a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f3432c) {
            this.a.remove(activity);
        }
    }
}

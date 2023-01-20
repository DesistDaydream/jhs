package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.bm;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class bf implements Runnable {
    private String a;
    private WeakReference<Context> b;

    public bf(String str, WeakReference<Context> weakReference) {
        this.a = str;
        this.b = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.b;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (bs.a(this.a) <= be.b) {
            com.xiaomi.a.a.a.c.b("=====> do not need clean db");
            return;
        }
        bi a = bi.a(this.a);
        bh a2 = bh.a(this.a);
        a.a(a2);
        a2.a(bg.a(context, this.a, 1000));
        bm.a(context).a((bm.a) a);
    }
}

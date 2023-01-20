package com.xiaomi.b.b;

import android.content.Context;
import android.os.Process;
import com.xiaomi.push.gg;

/* loaded from: classes3.dex */
public class a {
    public static void a(Context context, com.xiaomi.b.a.a aVar) {
        if (aVar == null) {
            return;
        }
        b.a(context).a(aVar.c(), aVar.d(), aVar.f(), aVar.g());
    }

    public static void a(Context context, com.xiaomi.b.a.a aVar, com.xiaomi.b.c.a aVar2, com.xiaomi.b.c.b bVar) {
        com.xiaomi.a.a.a.c.c("init in  pid :" + Process.myPid() + " threadId: " + Thread.currentThread().getId());
        b.a(context).a(aVar, aVar2, bVar);
        if (gg.b(context)) {
            com.xiaomi.a.a.a.c.c("init in process\u3000start scheduleJob");
            b.a(context).b();
        }
    }

    public static void a(Context context, com.xiaomi.b.a.b bVar) {
        if (bVar != null) {
            b.a(context).a(bVar);
        }
    }

    public static void a(Context context, com.xiaomi.b.a.c cVar) {
        if (cVar != null) {
            b.a(context).a(cVar);
        }
    }
}

package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_try19;

import android.content.Context;
import android.os.Handler;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class c {
    private List<a> a;

    private c(Handler handler, Context context) {
        ArrayList arrayList = new ArrayList(3);
        this.a = arrayList;
        arrayList.add(new b(handler, 0L, 15000L));
    }

    public static c a(Handler handler, Context context) {
        return new c(handler, context);
    }

    public void a() {
        j.a("[ScheduleTaskManager] execute, task size=" + this.a.size());
        for (a aVar : this.a) {
            try {
                aVar.a();
            } catch (Throwable unused) {
            }
        }
    }
}

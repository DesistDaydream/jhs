package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public interface a {
        void startActivityFail(Throwable th);

        void startActivitySuccess();
    }

    public static void a(Context context, Intent intent, a aVar) {
        if (context == null || intent == null) {
            return;
        }
        try {
            context.startActivity(intent);
            if (aVar != null) {
                aVar.startActivitySuccess();
            }
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.startActivityFail(th);
            }
        }
    }
}

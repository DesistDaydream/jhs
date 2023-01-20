package e.b.a.q;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import e.b.a.q.c;

/* loaded from: classes.dex */
public class f implements d {
    private static final String a = "ConnectivityMonitor";
    private static final String b = "android.permission.ACCESS_NETWORK_STATE";

    @Override // e.b.a.q.d
    @NonNull
    public c a(@NonNull Context context, @NonNull c.a aVar) {
        boolean z = ContextCompat.checkSelfPermission(context, b) == 0;
        if (Log.isLoggable(a, 3)) {
            Log.d(a, z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        if (z) {
            return new e(context, aVar);
        }
        return new n();
    }
}

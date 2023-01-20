package e.j.d.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import javax.annotation.Nullable;

@e.j.a.b.c.x.d0
/* loaded from: classes2.dex */
public final class v extends BroadcastReceiver {
    @Nullable
    private w a;

    public v(w wVar) {
        this.a = wVar;
    }

    public final void a() {
        if (FirebaseInstanceId.C()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.a.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        w wVar = this.a;
        if (wVar != null && wVar.b()) {
            if (FirebaseInstanceId.C()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.r(this.a, 0L);
            this.a.a().unregisterReceiver(this);
            this.a = null;
        }
    }
}

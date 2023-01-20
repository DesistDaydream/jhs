package e.j.a.b.d;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/* loaded from: classes2.dex */
public final class m implements View.OnClickListener {
    private final /* synthetic */ Context a;
    private final /* synthetic */ Intent b;

    public m(Context context, Intent intent) {
        this.a = context;
        this.b = intent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.a.startActivity(this.b);
        } catch (ActivityNotFoundException e2) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e2);
        }
    }
}

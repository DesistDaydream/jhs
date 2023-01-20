package e.j.a.b.c.r;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public abstract class i implements DialogInterface.OnClickListener {
    public static i a(Activity activity, Intent intent, int i2) {
        return new m0(intent, activity, i2);
    }

    public static i b(@NonNull Fragment fragment, Intent intent, int i2) {
        return new n0(intent, fragment, i2);
    }

    public static i c(@NonNull e.j.a.b.c.n.u.k kVar, Intent intent, int i2) {
        return new o0(intent, kVar, i2);
    }

    public abstract void d();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        try {
            d();
        } catch (ActivityNotFoundException e2) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e2);
        } finally {
            dialogInterface.dismiss();
        }
    }
}

package e.q.a;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* loaded from: classes.dex */
public class c {
    public static b a(Fragment fragment) {
        return new b(fragment);
    }

    public static b b(FragmentActivity fragmentActivity) {
        return new b(fragmentActivity);
    }

    public static boolean c(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }
}

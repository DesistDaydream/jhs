package e.k.c.a.a.k;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.huawei.secure.android.common.exception.NoPermissionCheckerException;

/* loaded from: classes2.dex */
public class e {
    private static final String a = "PermissionUtil";

    public static boolean a(Context context, String str, String str2) throws NoPermissionCheckerException {
        if (Binder.getCallingPid() == Process.myPid()) {
            return false;
        }
        return b(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }

    public static boolean b(Context context, String str, int i2, int i3, String str2) throws NoPermissionCheckerException {
        try {
            return PermissionChecker.checkPermission(context, str, i2, i3, str2) == 0;
        } catch (Throwable th) {
            String str3 = a;
            Log.e(str3, "checkPermission: " + th.getMessage() + " , you should implementation support library or androidx library");
            throw new NoPermissionCheckerException("you should implementation support library or androidx library");
        }
    }

    public static boolean c(Context context, String str) throws NoPermissionCheckerException {
        return b(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}

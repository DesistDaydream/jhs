package e.j.a.b.c.w;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.List;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class c {
    @e.j.a.b.c.m.a
    public static String a(Context context, Intent intent) {
        return String.valueOf(System.identityHashCode(intent) | (System.identityHashCode(context) << 32));
    }

    @e.j.a.b.c.m.a
    public static String b(PowerManager.WakeLock wakeLock, String str) {
        String valueOf = String.valueOf(String.valueOf((Process.myPid() << 32) | System.identityHashCode(wakeLock)));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    @Nullable
    public static List<String> c(@Nullable List<String> list) {
        if (list != null && list.size() == 1 && "com.google.android.gms".equals(list.get(0))) {
            return null;
        }
        return list;
    }

    @Nullable
    public static String d(String str) {
        if ("com.google.android.gms".equals(str)) {
            return null;
        }
        return str;
    }
}

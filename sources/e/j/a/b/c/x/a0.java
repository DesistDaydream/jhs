package e.j.a.b.c.x;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class a0 {
    private a0() {
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static void a(Context context, SharedPreferences.Editor editor, String str) {
        File file = new File(context.getApplicationInfo().dataDir, "shared_prefs");
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.setExecutable(true, false);
        }
        file.setExecutable(true, false);
        editor.commit();
        new File(file, String.valueOf(str).concat(".xml")).setReadable(true, false);
    }
}

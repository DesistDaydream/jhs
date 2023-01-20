package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public class l {
    public static boolean a;

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                for (File file : externalFilesDir.listFiles()) {
                    if (a(file)) {
                        a = true;
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static boolean a(File file) {
        if (file != null && file.isFile()) {
            return file.getName().equals("gromore.debug");
        }
        return false;
    }
}

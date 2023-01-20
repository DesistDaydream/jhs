package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.util.Log;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;

/* loaded from: classes.dex */
public class c {
    public static void a(String str) {
        try {
            g b = j.l().b();
            if (b == null || !b.c()) {
                return;
            }
            String i2 = b.i();
            if (i2 == null) {
                i2 = "";
            }
            Log.d(i2 + "log", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, String str2) {
        try {
            g b = j.l().b();
            if (b == null || !b.c()) {
                return;
            }
            String i2 = b.i();
            if (i2 == null) {
                i2 = "";
            }
            Log.d((i2 + "log") + str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            g b = j.l().b();
            if (b == null || !b.c()) {
                return;
            }
            String i2 = b.i();
            if (i2 == null) {
                i2 = "";
            }
            Log.e(i2 + "log", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(String str, String str2) {
        try {
            g b = j.l().b();
            if (b == null || !b.c()) {
                return;
            }
            String i2 = b.i();
            if (i2 == null) {
                i2 = "";
            }
            Log.e((i2 + "log") + str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(String str) {
        try {
            g b = j.l().b();
            if (b == null || !b.c()) {
                return;
            }
            String i2 = b.i();
            if (i2 == null) {
                i2 = "";
            }
            Log.i(i2 + "log", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(String str, String str2) {
        try {
            g b = j.l().b();
            if (b == null || !b.c()) {
                return;
            }
            String i2 = b.i();
            if (i2 == null) {
                i2 = "";
            }
            Log.w((i2 + "log") + str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(String str) {
        try {
            g b = j.l().b();
            if (b == null || !b.c()) {
                return;
            }
            String i2 = b.i();
            if (i2 == null) {
                i2 = "";
            }
            Log.w(i2 + "log", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

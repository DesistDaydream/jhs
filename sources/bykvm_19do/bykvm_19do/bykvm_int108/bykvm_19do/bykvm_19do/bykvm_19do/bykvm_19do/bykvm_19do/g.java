package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;

/* loaded from: classes.dex */
public class g {
    public static String a = "com.bytedance.openadsdk";
    public static String b = "content://" + a + ".TTMultiProvider";

    static {
        a();
    }

    public static void a() {
        if (j.l().d() != null) {
            a = j.l().d().getPackageName();
            b = "content://" + a + ".TTMultiProvider";
        }
    }
}

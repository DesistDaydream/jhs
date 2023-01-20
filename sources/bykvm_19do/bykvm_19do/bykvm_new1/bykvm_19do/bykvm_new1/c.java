package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.i;

/* loaded from: classes.dex */
public class c {
    public static long a(int i2) {
        String[] d2 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.d.d("/proc/self/task/" + i2 + "/stat");
        if (d2 == null) {
            return -1L;
        }
        return (Long.parseLong(d2[11]) * i.a.a()) + (Long.parseLong(d2[12]) * i.a.a());
    }
}

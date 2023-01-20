package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_try19;

import android.os.Handler;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i;

/* loaded from: classes.dex */
public class b extends a {
    public b(Handler handler, long j2, long j3) {
        super(handler, j2, j3);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String c2 = i.e().c();
        if (TextUtils.isEmpty(c2) || "0".equals(c2)) {
            a(c());
            str = "[DeviceIdTask] did is null, continue check.";
        } else {
            i.j().a(c2);
            str = "[DeviceIdTask] did is " + c2;
        }
        j.a(str);
    }
}

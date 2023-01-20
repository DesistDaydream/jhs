package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b;
import com.bytedance.msdk.api.qatools.IGMEventCallBack;

/* loaded from: classes.dex */
public class a {
    public static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a aVar, boolean z) {
        if (aVar != null && b.I().v()) {
            try {
                Object invoke = Class.forName("com.bytedance.qatool.QAEventToolsUtil").getMethod("getEventCallBack", new Class[0]).invoke(null, new Object[0]);
                if (invoke instanceof IGMEventCallBack) {
                    IGMEventCallBack iGMEventCallBack = (IGMEventCallBack) invoke;
                    if (z) {
                        iGMEventCallBack.EventReportByV3(aVar.d());
                    } else {
                        iGMEventCallBack.EventReportByV1(aVar.d());
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

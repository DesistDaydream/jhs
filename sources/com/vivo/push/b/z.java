package com.vivo.push.b;

import com.baidu.mobads.sdk.internal.bc;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class z extends c {
    private ArrayList<String> a;

    public z(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? PushConstants.NOTIFICATION_SERVICE_SEND_MESSAGE_ERROR : PushConstants.NOTIFICATION_SERVICE_SEND_MESSAGE_BROADCAST, str);
        this.a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(bc.f1477l, (Serializable) this.a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.c(bc.f1477l);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final String toString() {
        return "TagCommand";
    }
}

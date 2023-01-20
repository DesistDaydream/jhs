package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class af extends z {
    public af(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.u uVar = (com.vivo.push.b.u) oVar;
        if (com.vivo.push.e.a().g() && !a(com.vivo.push.util.z.c(this.a), uVar.e(), uVar.i())) {
            com.vivo.push.util.p.d("OnUndoMsgTask", " vertify msg is error ");
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1021L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(com.heytap.mcssdk.constant.b.f3335c, String.valueOf(uVar.f()));
            Context context = this.a;
            String b = com.vivo.push.util.z.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            xVar.a(hashMap);
            com.vivo.push.e.a().a(xVar);
            return;
        }
        boolean repealNotifyById = NotifyAdapterUtil.repealNotifyById(this.a, uVar.d());
        com.vivo.push.util.p.d("OnUndoMsgTask", "undo message " + uVar.d() + ", " + repealNotifyById);
        if (repealNotifyById) {
            Context context2 = this.a;
            com.vivo.push.util.p.b(context2, "回收client通知成功, 上报埋点 1031, messageId = " + uVar.d());
            com.vivo.push.util.e.a(this.a, uVar.d(), 1031L);
            return;
        }
        com.vivo.push.util.p.d("OnUndoMsgTask", "undo message fail，messageId = " + uVar.d());
        Context context3 = this.a;
        com.vivo.push.util.p.c(context3, "回收client通知失败，messageId = " + uVar.d());
    }
}

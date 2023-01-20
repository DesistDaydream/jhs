package com.xiaomi.push.service;

import com.xiaomi.push.db;
import com.xiaomi.push.fc;
import com.xiaomi.push.fg;
import java.util.Map;

/* loaded from: classes3.dex */
public class bt extends fc {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ XMPushService f9134d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(XMPushService xMPushService, Map map, int i2, String str, fg fgVar) {
        super(map, i2, str, fgVar);
        this.f9134d = xMPushService;
    }

    @Override // com.xiaomi.push.fc
    public byte[] c() {
        try {
            db.b bVar = new db.b();
            bVar.a(ay.a().c());
            return bVar.z();
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("getOBBString err: " + e2.toString());
            return null;
        }
    }
}

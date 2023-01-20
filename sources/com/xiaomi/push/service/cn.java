package com.xiaomi.push.service;

import com.xiaomi.push.go;
import com.xiaomi.push.gu;
import java.util.List;

/* loaded from: classes3.dex */
public class cn implements go {
    private final XMPushService a;

    public cn(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.go
    public void a(List<gu> list, String str, String str2) {
        this.a.a(new co(this, 4, str, list, str2));
    }
}

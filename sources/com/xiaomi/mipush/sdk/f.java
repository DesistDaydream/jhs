package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gv;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class f implements AbstractPushManager {
    private static volatile f a;

    /* renamed from: a */
    private Context f48a;

    /* renamed from: a */
    private PushConfiguration f49a;

    /* renamed from: a */
    private boolean f51a = false;

    /* renamed from: a */
    private Map<e, AbstractPushManager> f50a = new HashMap();

    private f(Context context) {
        this.f48a = context.getApplicationContext();
    }

    public static f a(Context context) {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f(context);
                }
            }
        }
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.f.a():void");
    }

    public AbstractPushManager a(e eVar) {
        return this.f50a.get(eVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f49a = pushConfiguration;
        this.f51a = com.xiaomi.push.service.ad.a(this.f48a).a(gv.AggregatePushSwitch.a(), true);
        if (this.f49a.getOpenHmsPush() || this.f49a.getOpenFCMPush() || this.f49a.getOpenCOSPush() || this.f49a.getOpenFTOSPush()) {
            com.xiaomi.push.service.ad.a(this.f48a).a(new g(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a */
    public void m91a(e eVar) {
        this.f50a.remove(eVar);
    }

    public void a(e eVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f50a.containsKey(eVar)) {
                this.f50a.remove(eVar);
            }
            this.f50a.put(eVar, abstractPushManager);
        }
    }

    /* renamed from: a */
    public boolean m92a(e eVar) {
        return this.f50a.containsKey(eVar);
    }

    public boolean b(e eVar) {
        int i2 = h.a[eVar.ordinal()];
        boolean z = false;
        if (i2 == 1) {
            PushConfiguration pushConfiguration = this.f49a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        } else if (i2 == 2) {
            PushConfiguration pushConfiguration2 = this.f49a;
            if (pushConfiguration2 != null) {
                return pushConfiguration2.getOpenFCMPush();
            }
            return false;
        } else {
            if (i2 == 3) {
                PushConfiguration pushConfiguration3 = this.f49a;
                if (pushConfiguration3 != null) {
                    z = pushConfiguration3.getOpenCOSPush();
                }
            } else if (i2 != 4) {
                return false;
            }
            PushConfiguration pushConfiguration4 = this.f49a;
            return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : z;
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : assemble push register");
        if (this.f50a.size() <= 0) {
            a();
        }
        if (this.f50a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f50a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            i.m94a(this.f48a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f50a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f50a.clear();
    }
}

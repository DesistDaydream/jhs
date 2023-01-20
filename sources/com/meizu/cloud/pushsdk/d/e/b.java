package com.meizu.cloud.pushsdk.d.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.d.f.e;
import com.moor.imkf.IMChatManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class b {
    private static final String a = "b";
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f4877c;

    /* renamed from: d  reason: collision with root package name */
    private String f4878d;

    /* renamed from: e  reason: collision with root package name */
    private int f4879e;

    /* renamed from: f  reason: collision with root package name */
    private final String f4880f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    private final AtomicBoolean f4881g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    private long f4882h;

    /* renamed from: i  reason: collision with root package name */
    private final long f4883i;

    /* renamed from: j  reason: collision with root package name */
    private final long f4884j;

    /* renamed from: k  reason: collision with root package name */
    private final Context f4885k;

    public b(long j2, long j3, TimeUnit timeUnit, Context context) {
        this.f4877c = null;
        this.f4879e = 0;
        this.f4883i = timeUnit.toMillis(j2);
        this.f4884j = timeUnit.toMillis(j3);
        this.f4885k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get(TUIConstants.TUILive.USER_ID).toString();
                String obj2 = f2.get(IMChatManager.CONSTANT_SESSIONID).toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.b = obj;
                this.f4879e = intValue;
                this.f4877c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.d.f.c.a(a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.d.f.c.c(a, "Tracker Session Object created.", new Object[0]);
        }
        this.b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.d.f.c.c(a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f4878d = this.f4877c;
        this.f4877c = e.b();
        this.f4879e++;
        String str = a;
        com.meizu.cloud.pushsdk.d.f.c.b(str, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.d.f.c.b(str, " + Session ID: %s", this.f4877c);
        com.meizu.cloud.pushsdk.d.f.c.b(str, " + Previous Session ID: %s", this.f4878d);
        com.meizu.cloud.pushsdk.d.f.c.b(str, " + Session Index: %s", Integer.valueOf(this.f4879e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.d.f.a.a("snowplow_session_vars", c(), this.f4885k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.d.f.a.a("snowplow_session_vars", this.f4885k);
    }

    private void g() {
        this.f4882h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.d.a.b a() {
        com.meizu.cloud.pushsdk.d.f.c.c(a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.d.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.d.f.c.b(a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f4882h, System.currentTimeMillis(), this.f4881g.get() ? this.f4884j : this.f4883i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap(8);
        hashMap.put(TUIConstants.TUILive.USER_ID, this.b);
        hashMap.put(IMChatManager.CONSTANT_SESSIONID, this.f4877c);
        hashMap.put("previousSessionId", this.f4878d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f4879e));
        hashMap.put("storageMechanism", "SQLITE");
        return hashMap;
    }
}

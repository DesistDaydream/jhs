package com.huawei.hms.hatool;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.UUID;

/* loaded from: classes2.dex */
public class f0 {
    public long a = 1800000;
    public volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public a f3531c = null;

    /* loaded from: classes2.dex */
    public class a {
        public String a = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        public boolean b = true;

        /* renamed from: c  reason: collision with root package name */
        public long f3532c;

        public a(long j2) {
            this.a += "_" + j2;
            this.f3532c = j2;
            f0.this.b = false;
        }

        public void a(long j2) {
            if (f0.this.b) {
                f0.this.b = false;
                b(j2);
            } else if (b(this.f3532c, j2) || a(this.f3532c, j2)) {
                b(j2);
            } else {
                this.f3532c = j2;
                this.b = false;
            }
        }

        public final boolean a(long j2, long j3) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j3);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        public final void b(long j2) {
            y.c("hmsSdk", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.a = uuid;
            this.a = uuid.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            this.a += "_" + j2;
            this.f3532c = j2;
            this.b = true;
        }

        public final boolean b(long j2, long j3) {
            return j3 - j2 >= f0.this.a;
        }
    }

    public String a() {
        a aVar = this.f3531c;
        if (aVar == null) {
            y.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
            return "";
        }
        return aVar.a;
    }

    public void a(long j2) {
        a aVar = this.f3531c;
        if (aVar != null) {
            aVar.a(j2);
            return;
        }
        y.c("hmsSdk", "Session is first flush");
        this.f3531c = new a(j2);
    }

    public boolean b() {
        a aVar = this.f3531c;
        if (aVar == null) {
            y.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
            return false;
        }
        return aVar.b;
    }
}

package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bc;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.h;
import com.huawei.hms.framework.network.grs.g.i;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: i  reason: collision with root package name */
    private static final String f3457i = "c";

    /* renamed from: j  reason: collision with root package name */
    private static final ExecutorService f3458j = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");

    /* renamed from: k  reason: collision with root package name */
    private static AtomicInteger f3459k = new AtomicInteger(0);
    private GrsBaseInfo a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private h f3460c;

    /* renamed from: d  reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f3461d;

    /* renamed from: e  reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f3462e;

    /* renamed from: f  reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f3463f;

    /* renamed from: g  reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.a f3464g;

    /* renamed from: h  reason: collision with root package name */
    private FutureTask<Boolean> f3465h;

    /* loaded from: classes2.dex */
    public class a implements Callable<Boolean> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ GrsBaseInfo b;

        public a(Context context, GrsBaseInfo grsBaseInfo) {
            this.a = context;
            this.b = grsBaseInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            c.this.f3460c = new h();
            c cVar = c.this;
            Context context = this.a;
            cVar.f3462e = new com.huawei.hms.framework.network.grs.e.c(context, GrsApp.getInstance().getBrand("_") + "share_pre_grs_conf_");
            c cVar2 = c.this;
            Context context2 = this.a;
            cVar2.f3463f = new com.huawei.hms.framework.network.grs.e.c(context2, GrsApp.getInstance().getBrand("_") + "share_pre_grs_services_");
            c cVar3 = c.this;
            cVar3.f3461d = new com.huawei.hms.framework.network.grs.e.a(cVar3.f3462e, c.this.f3463f, c.this.f3460c);
            c cVar4 = c.this;
            cVar4.f3464g = new com.huawei.hms.framework.network.grs.a(cVar4.a, c.this.f3461d, c.this.f3460c, c.this.f3463f);
            if (c.f3459k.incrementAndGet() <= 2 || com.huawei.hms.framework.network.grs.f.b.a(this.a.getPackageName(), c.this.a) == null) {
                new com.huawei.hms.framework.network.grs.f.b(this.a, this.b, true).a(this.b);
            }
            String c2 = new com.huawei.hms.framework.network.grs.g.k.c(this.b, this.a).c();
            String str = c.f3457i;
            Logger.v(str, "scan serviceSet is:" + c2);
            String a = c.this.f3463f.a("services", "");
            String a2 = i.a(a, c2);
            if (!TextUtils.isEmpty(a2)) {
                c.this.f3463f.b("services", a2);
                String str2 = c.f3457i;
                Logger.i(str2, "postList is:" + StringUtils.anonymizeMessage(a2));
                String str3 = c.f3457i;
                Logger.i(str3, "currentServices:" + StringUtils.anonymizeMessage(a));
                if (!a2.equals(a)) {
                    c.this.f3460c.a(c.this.a.getGrsParasKey(true, true, this.a));
                    c.this.f3460c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.b, this.a), (String) null, c.this.f3463f);
                }
            }
            c cVar5 = c.this;
            cVar5.a(cVar5.f3462e.a());
            c.this.f3461d.b(this.b, this.a);
            return Boolean.TRUE;
        }
    }

    public c(Context context, GrsBaseInfo grsBaseInfo) {
        this.f3465h = null;
        this.b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.a;
        FutureTask<Boolean> futureTask = new FutureTask<>(new a(this.b, grsBaseInfo2));
        this.f3465h = futureTask;
        f3458j.execute(futureTask);
        Logger.i(f3457i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s", com.huawei.hms.framework.network.grs.h.a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry());
    }

    public c(GrsBaseInfo grsBaseInfo) {
        this.f3465h = null;
        a(grsBaseInfo);
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        try {
            this.a = grsBaseInfo.m13clone();
        } catch (CloneNotSupportedException e2) {
            Logger.w(f3457i, "GrsClient catch CloneNotSupportedException", e2);
            this.a = grsBaseInfo.copy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.v(f3457i, "sp's content is empty.");
            return;
        }
        for (String str : map.keySet()) {
            if (str.endsWith("time")) {
                String a2 = this.f3462e.a(str, "");
                long j2 = 0;
                if (!TextUtils.isEmpty(a2) && a2.matches("\\d+")) {
                    try {
                        j2 = Long.parseLong(a2);
                    } catch (NumberFormatException e2) {
                        Logger.w(f3457i, "convert expire time from String to Long catch NumberFormatException.", e2);
                    }
                }
                if (!a(j2)) {
                    Logger.i(f3457i, "init interface auto clear some invalid sp's data.");
                    String substring = str.substring(0, str.length() - 4);
                    this.f3462e.a(substring);
                    this.f3462e.a(str);
                    this.f3462e.a(substring + "ETag");
                }
            }
        }
    }

    private boolean a(long j2) {
        return System.currentTimeMillis() - j2 <= bc.f1469d;
    }

    private boolean e() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.f3465h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8L, TimeUnit.SECONDS).booleanValue();
        } catch (InterruptedException e2) {
            e = e2;
            str = f3457i;
            str2 = "init compute task interrupted.";
            Logger.w(str, str2, e);
            return false;
        } catch (CancellationException unused) {
            Logger.i(f3457i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e3) {
            e = e3;
            str = f3457i;
            str2 = "init compute task failed.";
            Logger.w(str, str2, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(f3457i, "init compute task timed out");
            return false;
        } catch (Exception e4) {
            e = e4;
            str = f3457i;
            str2 = "init compute task occur unknown Exception";
            Logger.w(str, str2, e);
            return false;
        }
    }

    public String a(String str, String str2) {
        if (this.a == null || str == null || str2 == null) {
            Logger.w(f3457i, "invalid para!");
            return null;
        } else if (e()) {
            return this.f3464g.a(str, str2, this.b);
        } else {
            return null;
        }
    }

    public Map<String, String> a(String str) {
        if (this.a != null && str != null) {
            return e() ? this.f3464g.a(str, this.b) : new HashMap();
        }
        Logger.w(f3457i, "invalid para!");
        return new HashMap();
    }

    public void a() {
        if (e()) {
            String grsParasKey = this.a.getGrsParasKey(true, true, this.b);
            this.f3462e.a(grsParasKey);
            com.huawei.hms.framework.network.grs.e.c cVar = this.f3462e;
            cVar.a(grsParasKey + "time");
            com.huawei.hms.framework.network.grs.e.c cVar2 = this.f3462e;
            cVar2.a(grsParasKey + "ETag");
            this.f3460c.a(grsParasKey);
        }
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(f3457i, "IQueryUrlsCallBack is must not null for process continue.");
        } else if (this.a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.f3464g.a(str, iQueryUrlsCallBack, this.b);
        } else {
            Logger.i(f3457i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        if (iQueryUrlCallBack == null) {
            Logger.w(f3457i, "IQueryUrlCallBack is must not null for process continue.");
        } else if (this.a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.f3464g.a(str, str2, iQueryUrlCallBack, this.b);
        } else {
            Logger.i(f3457i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    public boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass() && (obj instanceof c)) {
            return this.a.compare(((c) obj).a);
        }
        return false;
    }

    public boolean b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!e() || (grsBaseInfo = this.a) == null || (context = this.b) == null) {
            return false;
        }
        this.f3461d.a(grsBaseInfo, context);
        return true;
    }
}

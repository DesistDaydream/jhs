package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.h.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class c {
    private static final String n = "c";
    private final GrsBaseInfo a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.a f3487c;

    /* renamed from: d  reason: collision with root package name */
    private d f3488d;

    /* renamed from: j  reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.g.k.c f3494j;

    /* renamed from: k  reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.g.k.d f3495k;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Future<d>> f3489e = new ConcurrentHashMap(16);

    /* renamed from: f  reason: collision with root package name */
    private final List<d> f3490f = new CopyOnWriteArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final JSONArray f3491g = new JSONArray();

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f3492h = new CopyOnWriteArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final List<String> f3493i = new CopyOnWriteArrayList();

    /* renamed from: l  reason: collision with root package name */
    private String f3496l = "";

    /* renamed from: m  reason: collision with root package name */
    private long f3497m = 1;

    /* loaded from: classes2.dex */
    public class a implements Callable<d> {
        public final /* synthetic */ ExecutorService a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f3498c;

        public a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
            this.a = executorService;
            this.b = str;
            this.f3498c = cVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public d call() {
            return c.this.b(this.a, this.b, this.f3498c);
        }
    }

    public c(com.huawei.hms.framework.network.grs.g.k.c cVar, com.huawei.hms.framework.network.grs.e.a aVar) {
        this.f3494j = cVar;
        this.a = cVar.b();
        this.b = cVar.a();
        this.f3487c = aVar;
        c();
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0099 A[LOOP:0: B:3:0x0006->B:33:0x0099, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0091 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.framework.network.grs.g.d a(java.util.concurrent.ExecutorService r17, java.util.List<java.lang.String> r18, java.lang.String r19, com.huawei.hms.framework.network.grs.e.c r20) {
        /*
            r16 = this;
            r9 = r16
            r10 = 0
            r0 = 0
            r11 = r0
            r12 = 0
        L6:
            int r0 = r18.size()
            if (r12 >= r0) goto L9d
            r13 = r18
            java.lang.Object r0 = r13.get(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r14 = 1
            if (r1 != 0) goto L8c
            com.huawei.hms.framework.network.grs.g.a r15 = new com.huawei.hms.framework.network.grs.g.a
            android.content.Context r5 = r9.b
            com.huawei.hms.framework.network.grs.GrsBaseInfo r7 = r9.a
            r1 = r15
            r2 = r0
            r3 = r12
            r4 = r16
            r6 = r19
            r8 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Callable r1 = r15.g()
            r2 = r17
            java.util.concurrent.Future r1 = r2.submit(r1)
            java.util.Map<java.lang.String, java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d>> r3 = r9.f3489e
            r3.put(r0, r1)
            long r3 = r9.f3497m     // Catch: java.util.concurrent.TimeoutException -> L6a java.lang.InterruptedException -> L72 java.util.concurrent.ExecutionException -> L7b java.util.concurrent.CancellationException -> L84
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.util.concurrent.TimeoutException -> L6a java.lang.InterruptedException -> L72 java.util.concurrent.ExecutionException -> L7b java.util.concurrent.CancellationException -> L84
            java.lang.Object r0 = r1.get(r3, r0)     // Catch: java.util.concurrent.TimeoutException -> L6a java.lang.InterruptedException -> L72 java.util.concurrent.ExecutionException -> L7b java.util.concurrent.CancellationException -> L84
            r1 = r0
            com.huawei.hms.framework.network.grs.g.d r1 = (com.huawei.hms.framework.network.grs.g.d) r1     // Catch: java.util.concurrent.TimeoutException -> L6a java.lang.InterruptedException -> L72 java.util.concurrent.ExecutionException -> L7b java.util.concurrent.CancellationException -> L84
            if (r1 == 0) goto L68
            boolean r0 = r1.o()     // Catch: java.util.concurrent.TimeoutException -> L5e java.lang.InterruptedException -> L60 java.util.concurrent.ExecutionException -> L63 java.util.concurrent.CancellationException -> L66
            if (r0 != 0) goto L55
            boolean r0 = r1.m()     // Catch: java.util.concurrent.TimeoutException -> L5e java.lang.InterruptedException -> L60 java.util.concurrent.ExecutionException -> L63 java.util.concurrent.CancellationException -> L66
            if (r0 == 0) goto L68
        L55:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.c.n     // Catch: java.util.concurrent.TimeoutException -> L5e java.lang.InterruptedException -> L60 java.util.concurrent.ExecutionException -> L63 java.util.concurrent.CancellationException -> L66
            java.lang.String r3 = "grs request return body is not null and is OK."
            com.huawei.hms.framework.common.Logger.i(r0, r3)     // Catch: java.util.concurrent.TimeoutException -> L5e java.lang.InterruptedException -> L60 java.util.concurrent.ExecutionException -> L63 java.util.concurrent.CancellationException -> L66
            r11 = r1
            goto L8f
        L5e:
            r11 = r1
            goto L6a
        L60:
            r0 = move-exception
            r11 = r1
            goto L73
        L63:
            r0 = move-exception
            r11 = r1
            goto L7c
        L66:
            r11 = r1
            goto L84
        L68:
            r11 = r1
            goto L8e
        L6a:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.c.n
            java.lang.String r1 = "the wait timed out"
            com.huawei.hms.framework.common.Logger.w(r0, r1)
            goto L8e
        L72:
            r0 = move-exception
        L73:
            java.lang.String r1 = com.huawei.hms.framework.network.grs.g.c.n
            java.lang.String r3 = "the current thread was interrupted while waiting"
            com.huawei.hms.framework.common.Logger.w(r1, r3, r0)
            goto L8f
        L7b:
            r0 = move-exception
        L7c:
            java.lang.String r1 = com.huawei.hms.framework.network.grs.g.c.n
            java.lang.String r3 = "the computation threw an ExecutionException"
            com.huawei.hms.framework.common.Logger.w(r1, r3, r0)
            goto L8e
        L84:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.c.n
            java.lang.String r1 = "{requestServer} the computation was cancelled"
            com.huawei.hms.framework.common.Logger.i(r0, r1)
            goto L8f
        L8c:
            r2 = r17
        L8e:
            r14 = 0
        L8f:
            if (r14 == 0) goto L99
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.c.n
            java.lang.String r1 = "needBreak is true so need break current circulation"
            com.huawei.hms.framework.common.Logger.v(r0, r1)
            goto L9d
        L99:
            int r12 = r12 + 1
            goto L6
        L9d:
            com.huawei.hms.framework.network.grs.g.d r0 = r9.b(r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.c.a(java.util.concurrent.ExecutorService, java.util.List, java.lang.String, com.huawei.hms.framework.network.grs.e.c):com.huawei.hms.framework.network.grs.g.d");
    }

    private void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        String grsReqParamJoint = this.a.getGrsReqParamJoint(false, false, e(), this.b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb.append("?");
            sb.append(grsReqParamJoint);
        }
        this.f3493i.add(sb.toString());
    }

    private d b(d dVar) {
        String str;
        String str2;
        for (Map.Entry<String, Future<d>> entry : this.f3489e.entrySet()) {
            if (dVar != null && (dVar.o() || dVar.m())) {
                break;
            }
            try {
                dVar = entry.getValue().get(40000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                e = e2;
                str = n;
                str2 = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str, str2, e);
            } catch (CancellationException unused) {
                Logger.i(n, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e3) {
                e = e3;
                str = n;
                str2 = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str, str2, e);
            } catch (TimeoutException unused2) {
                Logger.w(n, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!entry.getValue().isCancelled()) {
                    entry.getValue().cancel(true);
                }
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d b(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        d a2 = a(executorService, this.f3493i, str, cVar);
        int b = a2 == null ? 0 : a2.b();
        String str2 = n;
        Logger.v(str2, "use 2.0 interface return http's code is：{%s}", Integer.valueOf(b));
        if (b == 404 || b == 401) {
            if (TextUtils.isEmpty(e()) && TextUtils.isEmpty(this.a.getAppName())) {
                Logger.i(str2, "request grs server use 1.0 API must set appName,please check.");
                return null;
            }
            this.f3489e.clear();
            Logger.i(str2, "this env has not deploy new interface,so use old interface.");
            a2 = a(executorService, this.f3492h, str, cVar);
        }
        e.a(new ArrayList(this.f3490f), SystemClock.elapsedRealtime() - elapsedRealtime, this.f3491g, this.b);
        this.f3490f.clear();
        return a2;
    }

    private void b(String str, String str2) {
        if (TextUtils.isEmpty(this.a.getAppName()) && TextUtils.isEmpty(e())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(e()) ? this.a.getAppName() : e();
        sb.append(String.format(locale, str, objArr));
        String grsReqParamJoint = this.a.getGrsReqParamJoint(false, false, "1.0", this.b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb.append("?");
            sb.append(grsReqParamJoint);
        }
        this.f3492h.add(sb.toString());
    }

    private void c() {
        com.huawei.hms.framework.network.grs.g.k.d a2 = com.huawei.hms.framework.network.grs.g.j.a.a(this.b);
        if (a2 == null) {
            Logger.w(n, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        a(a2);
        List<String> a3 = a2.a();
        if (a3 == null || a3.size() <= 0) {
            Logger.v(n, "maybe grs_base_url config with [],please check.");
        } else if (a3.size() > 10) {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        } else {
            String c2 = a2.c();
            String b = a2.b();
            if (a3.size() > 0) {
                for (String str : a3) {
                    if (str.startsWith("https://")) {
                        b(c2, str);
                        a(b, str);
                    } else {
                        Logger.w(n, "grs server just support https scheme url,please check.");
                    }
                }
            }
            Logger.v(n, "request to GRS server url is{%s} and {%s}", this.f3492h, this.f3493i);
        }
    }

    private void d() {
        String grsParasKey = this.a.getGrsParasKey(true, true, this.b);
        com.huawei.hms.framework.network.grs.e.c a2 = this.f3487c.a();
        this.f3496l = a2.a(grsParasKey + "ETag", "");
    }

    private String e() {
        com.huawei.hms.framework.network.grs.f.b a2 = com.huawei.hms.framework.network.grs.f.b.a(this.b.getPackageName(), this.a);
        com.huawei.hms.framework.network.grs.local.model.a a3 = a2 != null ? a2.a() : null;
        if (a3 != null) {
            String b = a3.b();
            Logger.v(n, "get appName from local assets is{%s}", b);
            return b;
        }
        return "";
    }

    public d a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        String str2;
        String str3;
        if (this.f3492h.isEmpty() && this.f3493i.isEmpty()) {
            return null;
        }
        try {
            com.huawei.hms.framework.network.grs.g.k.d b = b();
            return (d) executorService.submit(new a(executorService, str, cVar)).get(b != null ? b.d() : 10, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            e = e2;
            str2 = n;
            str3 = "{submitExcutorTaskWithTimeout} the current thread was interrupted while waiting";
            Logger.w(str2, str3, e);
            return null;
        } catch (CancellationException unused) {
            Logger.i(n, "{submitExcutorTaskWithTimeout} the computation was cancelled");
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            str2 = n;
            str3 = "{submitExcutorTaskWithTimeout} the computation threw an ExecutionException";
            Logger.w(str2, str3, e);
            return null;
        } catch (TimeoutException unused2) {
            Logger.w(n, "{submitExcutorTaskWithTimeout} the wait timed out");
            return null;
        } catch (Exception e4) {
            e = e4;
            str2 = n;
            str3 = "{submitExcutorTaskWithTimeout} catch Exception";
            Logger.w(str2, str3, e);
            return null;
        }
    }

    public String a() {
        return this.f3496l;
    }

    public synchronized void a(d dVar) {
        this.f3490f.add(dVar);
        d dVar2 = this.f3488d;
        if (dVar2 != null && (dVar2.o() || this.f3488d.m())) {
            Logger.v(n, "grsResponseResult is ok");
        } else if (dVar.n()) {
            Logger.i(n, "GRS server open 503 limiting strategy.");
            com.huawei.hms.framework.network.grs.h.d.a(this.a.getGrsParasKey(true, true, this.b), new d.a(dVar.k(), SystemClock.elapsedRealtime()));
        } else {
            if (dVar.m()) {
                Logger.i(n, "GRS server open 304 Not Modified.");
            }
            if (!dVar.o() && !dVar.m()) {
                Logger.v(n, "grsResponseResult has exception so need return");
                return;
            }
            this.f3488d = dVar;
            this.f3487c.a(this.a, dVar, this.b, this.f3494j);
            for (Map.Entry<String, Future<d>> entry : this.f3489e.entrySet()) {
                if (!entry.getKey().equals(dVar.l()) && !entry.getValue().isCancelled()) {
                    Logger.i(n, "future cancel");
                    entry.getValue().cancel(true);
                }
            }
        }
    }

    public void a(com.huawei.hms.framework.network.grs.g.k.d dVar) {
        this.f3495k = dVar;
    }

    public com.huawei.hms.framework.network.grs.g.k.d b() {
        return this.f3495k;
    }
}

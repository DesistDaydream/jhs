package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.ay;
import com.umeng.analytics.pro.bn;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

/* loaded from: classes3.dex */
public class c {
    private static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f7465c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f7466d = 3;
    private static final String o = "thtstart";
    private static final String p = "gkvc";
    private static final String q = "ekvc";
    public String a;

    /* renamed from: f  reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.c f7468f;

    /* renamed from: g  reason: collision with root package name */
    private ImprintHandler f7469g;

    /* renamed from: h  reason: collision with root package name */
    private e f7470h;

    /* renamed from: i  reason: collision with root package name */
    private ImprintHandler.a f7471i;

    /* renamed from: k  reason: collision with root package name */
    private Defcon f7473k;

    /* renamed from: l  reason: collision with root package name */
    private long f7474l;

    /* renamed from: m  reason: collision with root package name */
    private int f7475m;
    private int n;
    private Context r;

    /* renamed from: e  reason: collision with root package name */
    private final int f7467e = 1;

    /* renamed from: j  reason: collision with root package name */
    private ABTest f7472j = null;

    public c(Context context) {
        this.f7470h = null;
        this.f7471i = null;
        this.f7473k = null;
        this.f7474l = 0L;
        this.f7475m = 0;
        this.n = 0;
        this.a = null;
        this.r = context;
        this.f7471i = ImprintHandler.getImprintService(context).c();
        this.f7473k = Defcon.getService(this.r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.r);
        this.f7474l = sharedPreferences.getLong(o, 0L);
        this.f7475m = sharedPreferences.getInt(p, 0);
        this.n = sharedPreferences.getInt(q, 0);
        this.a = UMEnvelopeBuild.imprintProperty(this.r, "track_list", null);
        ImprintHandler imprintService = ImprintHandler.getImprintService(this.r);
        this.f7469g = imprintService;
        imprintService.a(new d() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.f7473k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.a = UMEnvelopeBuild.imprintProperty(cVar.r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.r)) {
            this.f7470h = e.a(this.r);
        }
        com.umeng.commonsdk.statistics.internal.c cVar = new com.umeng.commonsdk.statistics.internal.c(this.r);
        this.f7468f = cVar;
        cVar.a(StatTracer.getInstance(this.r));
    }

    public boolean a(File file) {
        String str;
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            com.umeng.commonsdk.statistics.internal.a a = com.umeng.commonsdk.statistics.internal.a.a(this.r);
            a.e(name);
            boolean a2 = a.a(name);
            boolean b2 = a.b(name);
            boolean c2 = a.c(name);
            boolean d2 = a.d(name);
            String d3 = com.umeng.commonsdk.stateless.d.d(name);
            if (!TextUtils.isEmpty(d3)) {
                str = com.umeng.commonsdk.stateless.d.c(d3);
            } else if (d2) {
                str = UMServerURL.SILENT_HEART_BEAT;
            } else if (c2) {
                str = UMServerURL.ZCFG_PATH;
            } else {
                str = UMServerURL.PATH_ANALYTICS;
            }
            byte[] a3 = this.f7468f.a(byteArray, a2, c2, str);
            int a4 = a3 == null ? 1 : a(a3);
            if (UMConfigure.isDebugLog()) {
                if (d2 && a4 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "heart beat req: succeed.");
                } else if (c2 && a4 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (b2 && a4 == 2) {
                    MLog.d("本次启动数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (a2 && a4 == 2) {
                    MLog.d("普通统计数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else if (a4 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (a4 == 2) {
                e eVar = this.f7470h;
                if (eVar != null) {
                    eVar.e();
                }
                StatTracer.getInstance(this.r).saveSate();
                if (d2) {
                    String imprintProperty = UMEnvelopeBuild.imprintProperty(this.r, "iss", "");
                    if (!TextUtils.isEmpty(imprintProperty)) {
                        if ("1".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新静默心跳最后一次成功请求时间.");
                            com.umeng.commonsdk.utils.c.a(this.r, System.currentTimeMillis());
                        } else if ("0".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默模式 -> 正常模式。重置 last req time");
                            com.umeng.commonsdk.utils.c.a(this.r, 0L);
                            com.umeng.commonsdk.utils.c.d(this.r);
                        }
                    }
                }
            } else if (a4 == 3) {
                StatTracer.getInstance(this.r).saveSate();
                if (c2) {
                    FieldManager.a().a(this.r);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                    Context context = this.r;
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(context).a(), null);
                    return true;
                }
            }
            return a4 == 2;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
            return false;
        }
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new ay(new bn.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.f7469g.b(response.getImprint());
                this.f7469g.d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}

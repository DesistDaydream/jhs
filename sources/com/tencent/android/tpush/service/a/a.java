package com.tencent.android.tpush.service.a;

import android.content.Context;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class a {
    private static volatile a L;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public String I;
    public JSONArray J;
    public Map<String, String> K;
    private Context M;
    public long a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f6218c;

    /* renamed from: d  reason: collision with root package name */
    public int f6219d;

    /* renamed from: e  reason: collision with root package name */
    public int f6220e;

    /* renamed from: f  reason: collision with root package name */
    public int f6221f;

    /* renamed from: g  reason: collision with root package name */
    public int f6222g;

    /* renamed from: h  reason: collision with root package name */
    public int f6223h;

    /* renamed from: i  reason: collision with root package name */
    public int f6224i;

    /* renamed from: j  reason: collision with root package name */
    public int f6225j;

    /* renamed from: k  reason: collision with root package name */
    public int f6226k;

    /* renamed from: l  reason: collision with root package name */
    public int f6227l;

    /* renamed from: m  reason: collision with root package name */
    public int f6228m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public String u;
    public int v;
    public int w;
    public String x;
    public int y;
    public int z;

    private a() {
        this.M = null;
        this.x = null;
        this.y = 1;
        this.z = 1;
        this.A = BaseConstants.Time.MINUTE;
        this.B = 1;
        this.C = 1;
        this.D = 1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = "xiaomi";
        this.J = null;
    }

    public static a a(Context context) {
        if (L == null) {
            synchronized (a.class) {
                if (L == null) {
                    L = new a(context);
                }
            }
        }
        return L;
    }

    public String toString() {
        return "ConfigurationManager [context=" + this.M + ", configurationVersion=" + this.a + ", receiveTimeout=" + this.b + ", heartbeatInterval=" + this.f6218c + ", httpHeartbeatInterval=" + this.f6219d + ", speedTestInterval=" + this.f6220e + ", channelMessageExpires=" + this.f6221f + ", freqencySuccess=" + this.f6222g + ", freqencyFailed=" + this.f6223h + ", reportInterval=" + this.f6224i + ", reportMaxCount=" + this.f6225j + ", httpRetryCount=" + this.f6226k + ", ackMaxCount=" + this.f6227l + ", ackDuration=" + this.f6228m + ", loadIpInerval=" + this.n + ", redirectConnectTimeOut=" + this.o + ", redirectSoTimeOut=" + this.p + ", strategyExpiredTime=" + this.q + ", logLevel=" + this.r + ", logFileSizeLimit=" + this.s + ", errCount=" + this.t + ", logUploadDomain=" + this.u + ", rptLive=" + this.v + ", rptLiveIntvl=" + this.w + ", disableXG=" + this.x + ", enableNewWd=" + this.y + ", enableMonitor=" + this.z + ", monitorFreg=" + this.A + ", enableReport=" + this.B + ", abTestVersion=" + this.C + ", isHttpDNSEnable=" + this.D + ", isLBSEnable=" + this.E + ", isAPPListEnable=" + this.F + ", isNotificatiobStatusEnable=" + this.G + ", isQgameEnable=" + this.H + ", pullup_Arr_ProviderAndActivty=" + this.J + ", pullup_packges_map=" + this.K + ", wakeupCtrl=" + this.I + "]";
    }

    private a(Context context) {
        this.M = null;
        this.x = null;
        this.y = 1;
        this.z = 1;
        this.A = BaseConstants.Time.MINUTE;
        this.B = 1;
        this.C = 1;
        this.D = 1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = "xiaomi";
        this.J = null;
        this.M = context.getApplicationContext();
    }
}

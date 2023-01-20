package com.huawei.hms.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.c;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class HMSBIInitializer {

    /* renamed from: d  reason: collision with root package name */
    public static final Object f3692d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static HMSBIInitializer f3693e;

    /* renamed from: f  reason: collision with root package name */
    public static HiAnalyticsInstance f3694f;
    public final Context a;
    public AtomicBoolean b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public boolean f3695c = c.a();

    /* loaded from: classes2.dex */
    public class a implements IQueryUrlCallBack {
        public a() {
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackFail(int i2) {
            HMSLog.e("HMSBIInitializer", "get grs failed, the errorcode is " + i2);
            HMSBIInitializer.this.b.set(false);
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackSuccess(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (!HMSBIInitializer.this.f3695c) {
                    HmsHiAnalyticsUtils.init(HMSBIInitializer.this.a, false, false, false, str, "com.huawei.hwid");
                } else {
                    HiAnalyticsConfig build = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build();
                    HiAnalyticsInstance unused = HMSBIInitializer.f3694f = new HiAnalyticsInstance.Builder(HMSBIInitializer.this.a).setOperConf(build).setMaintConf(new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build()).create(HiAnalyticsConstant.HA_SERVICE_TAG);
                    HMSBIInitializer.f3694f.setAppid("com.huawei.hwid");
                }
                HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");
            }
            HMSBIInitializer.this.b.set(false);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AsyncTask<String, Integer, Void> {
        public b() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            HMSBIInitializer.this.a(strArr[0]);
            return null;
        }

        public /* synthetic */ b(HMSBIInitializer hMSBIInitializer, a aVar) {
            this();
        }
    }

    public HMSBIInitializer(Context context) {
        this.a = context;
    }

    public static HMSBIInitializer getInstance(Context context) {
        synchronized (f3692d) {
            if (f3693e == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    f3693e = new HMSBIInitializer(applicationContext);
                } else {
                    f3693e = new HMSBIInitializer(context);
                }
            }
        }
        return f3693e;
    }

    public HiAnalyticsInstance getAnalyticsInstance() {
        return f3694f;
    }

    public void initBI() {
        boolean initFlag;
        if (!this.f3695c) {
            initFlag = HmsHiAnalyticsUtils.getInitFlag();
        } else {
            initFlag = HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
        }
        HMSLog.i("HMSBIInitializer", "Builder->biInitFlag :" + initFlag);
        if (initFlag || com.huawei.hms.stats.a.c(this.a) || !this.b.compareAndSet(false, true)) {
            return;
        }
        String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(this.a);
        if (!TextUtils.isEmpty(issueCountryCode)) {
            issueCountryCode = issueCountryCode.toUpperCase(Locale.ENGLISH);
        }
        if (!GrsBaseInfo.CountryCodeSource.UNKNOWN.equalsIgnoreCase(issueCountryCode) && !TextUtils.isEmpty(issueCountryCode)) {
            new b(this, null).execute(issueCountryCode);
            return;
        }
        HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
        this.b.set(false);
    }

    public boolean isInit() {
        if (!this.f3695c) {
            return HmsHiAnalyticsUtils.getInitFlag();
        }
        return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    public final void a(String str) {
        HMSLog.i("HMSBIInitializer", "Start to query GRS");
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setIssueCountry(str);
        new GrsClient(this.a, grsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOTV2", new a());
    }
}

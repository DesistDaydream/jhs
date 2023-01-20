package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes2.dex */
public class c {
    public static final Object a = new Object();
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f3678c = false;

    public static boolean a() {
        boolean z;
        synchronized (a) {
            if (!b) {
                boolean z2 = false;
                try {
                    Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                    z = true;
                } catch (ClassNotFoundException unused) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                    z = false;
                }
                try {
                    Class.forName("com.huawei.hms.hatool.HmsHiAnalyticsUtils");
                    z2 = true;
                } catch (ClassNotFoundException unused2) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HmsHiAnalyticsUtils.");
                }
                if (z && !z2) {
                    f3678c = true;
                }
                b = true;
                HMSLog.i("HianalyticsExist", "hianalytics exist: " + f3678c);
            }
        }
        return f3678c;
    }
}

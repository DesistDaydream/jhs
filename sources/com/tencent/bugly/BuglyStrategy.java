package com.tencent.bugly;

import java.util.Map;

/* loaded from: classes3.dex */
public class BuglyStrategy {

    /* renamed from: c  reason: collision with root package name */
    private String f6475c;

    /* renamed from: d  reason: collision with root package name */
    private String f6476d;

    /* renamed from: e  reason: collision with root package name */
    private String f6477e;

    /* renamed from: f  reason: collision with root package name */
    private long f6478f;

    /* renamed from: g  reason: collision with root package name */
    private String f6479g;

    /* renamed from: h  reason: collision with root package name */
    private String f6480h;

    /* renamed from: i  reason: collision with root package name */
    private String f6481i;
    private a u;

    /* renamed from: j  reason: collision with root package name */
    private boolean f6482j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6483k = true;

    /* renamed from: l  reason: collision with root package name */
    private boolean f6484l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f6485m = false;
    private boolean n = true;
    private Class<?> o = null;
    private boolean p = true;
    private boolean q = true;
    private boolean r = true;
    private boolean s = true;
    private boolean t = false;
    public int a = 31;
    public boolean b = false;
    private boolean v = false;

    /* loaded from: classes3.dex */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 100000;

        public synchronized Map<String, String> onCrashHandleStart(int i2, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i2, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        String str = this.f6476d;
        if (str == null) {
            return com.tencent.bugly.crashreport.common.info.a.b().f6527k;
        }
        return str;
    }

    public synchronized String getAppPackageName() {
        String str = this.f6477e;
        if (str == null) {
            return com.tencent.bugly.crashreport.common.info.a.b().f6519c;
        }
        return str;
    }

    public synchronized long getAppReportDelay() {
        return this.f6478f;
    }

    public synchronized String getAppVersion() {
        String str = this.f6475c;
        if (str == null) {
            return com.tencent.bugly.crashreport.common.info.a.b().f6525i;
        }
        return str;
    }

    public synchronized int getCallBackType() {
        return this.a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.b;
    }

    public synchronized a getCrashHandleCallback() {
        return this.u;
    }

    public synchronized String getDeviceID() {
        return this.f6480h;
    }

    public synchronized String getDeviceModel() {
        return this.f6481i;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f6479g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.o;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.p;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f6483k;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f6484l;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f6482j;
    }

    public boolean isEnableRecordAnrMainStack() {
        return this.f6485m;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.n;
    }

    public boolean isMerged() {
        return this.v;
    }

    public boolean isReplaceOldChannel() {
        return this.q;
    }

    public synchronized boolean isUploadProcess() {
        return this.r;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.s;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.t;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f6476d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f6477e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j2) {
        this.f6478f = j2;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f6475c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z) {
        this.p = z;
        return this;
    }

    public synchronized void setCallBackType(int i2) {
        this.a = i2;
    }

    public synchronized void setCloseErrorCallback(boolean z) {
        this.b = z;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.u = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f6480h = str;
        return this;
    }

    public synchronized BuglyStrategy setDeviceModel(String str) {
        this.f6481i = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.f6483k = z;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z) {
        this.f6484l = z;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.f6482j = z;
        return this;
    }

    public void setEnableRecordAnrMainStack(boolean z) {
        this.f6485m = z;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.n = z;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f6479g = str;
        return this;
    }

    @Deprecated
    public void setMerged(boolean z) {
        this.v = z;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.t = z;
        return this;
    }

    public void setReplaceOldChannel(boolean z) {
        this.q = z;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z) {
        this.r = z;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z) {
        this.s = z;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.o = cls;
        return this;
    }
}

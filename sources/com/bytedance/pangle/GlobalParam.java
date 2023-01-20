package com.bytedance.pangle;

import androidx.annotation.Keep;
import com.bytedance.pangle.download.IDownloaderProvider;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Keep
/* loaded from: classes.dex */
public class GlobalParam {
    private static GlobalParam mInstance;
    private boolean mCheckPermission;
    private boolean mCloseFlipped;
    private File mDownloadDir;
    private IDownloaderProvider mDownloaderProvider;
    private boolean mFastDex2oat;
    private String mHostUrl;
    private IZeusLogger mLogger;
    private IZeusReporter mReporter;
    private boolean hasInit = false;
    private boolean mDebug = true;
    private boolean mCloseDefaultReport = true;
    private int mInstallThreads = 4;
    private boolean mCheckMatchHostAbi = true;
    private Map<String, String> mRequestHeader = new HashMap();
    private Map<String, Boolean> unInstallPluginWhenHostChange = new HashMap();
    private Map<String, Map<String, String>> mCustomTag = new HashMap();

    private void ensureInit() {
        if (this.hasInit) {
            throw new RuntimeException();
        }
    }

    public static GlobalParam getInstance() {
        if (mInstance == null) {
            synchronized (GlobalParam.class) {
                if (mInstance == null) {
                    mInstance = new GlobalParam();
                }
            }
        }
        return mInstance;
    }

    public void addRequestHeader(String str, String str2) {
        ensureInit();
        this.mRequestHeader.put(str, str2);
    }

    public boolean checkMatchHostAbi() {
        return this.mCheckMatchHostAbi;
    }

    public boolean checkPermission() {
        return this.mCheckPermission;
    }

    public Map<String, String> getCustomTag(String str) {
        return this.mCustomTag.get(str);
    }

    public File getDownloadDir() {
        return this.mDownloadDir;
    }

    public IDownloaderProvider getDownloaderProvider() {
        return this.mDownloaderProvider;
    }

    public String getHostUrl() {
        return this.mHostUrl;
    }

    public int getInstallThreads() {
        return this.mInstallThreads;
    }

    public IZeusLogger getLogger() {
        return this.mLogger;
    }

    public IZeusReporter getReporter() {
        return this.mReporter;
    }

    public Map<String, String> getRequestHeader() {
        return this.mRequestHeader;
    }

    public void init() {
        this.hasInit = true;
    }

    public boolean isCloseDefaultReport() {
        return this.mCloseDefaultReport;
    }

    public boolean isCloseFlipped() {
        return this.mCloseFlipped;
    }

    public boolean isDebug() {
        return this.mDebug;
    }

    public boolean isFastDex2oat() {
        return this.mFastDex2oat;
    }

    public void setCheckMatchHostAbi(boolean z) {
        this.mCheckMatchHostAbi = z;
    }

    public void setCheckPermission(boolean z) {
        this.mCheckPermission = z;
    }

    public void setCloseDefaultReport(boolean z) {
        ensureInit();
        this.mCloseDefaultReport = z;
    }

    public void setCloseFlipped(boolean z) {
        ensureInit();
        this.mCloseFlipped = z;
    }

    public void setCustomTag(String str, Map<String, String> map) {
        this.mCustomTag.put(str, map);
    }

    public void setDebug(boolean z) {
        ensureInit();
        this.mDebug = z;
    }

    public void setDownloadDir(File file) {
        ensureInit();
        this.mDownloadDir = file;
    }

    public void setDownloaderProvider(IDownloaderProvider iDownloaderProvider) {
        ensureInit();
        this.mDownloaderProvider = iDownloaderProvider;
    }

    public void setFastDex2oat(boolean z) {
        this.mFastDex2oat = z;
    }

    public void setHostUrl(String str) {
        ensureInit();
        this.mHostUrl = str;
    }

    public void setInstallThreads(int i2) {
        ensureInit();
        this.mInstallThreads = i2;
    }

    public void setLogger(IZeusLogger iZeusLogger) {
        ensureInit();
        this.mLogger = iZeusLogger;
    }

    public void setReporter(IZeusReporter iZeusReporter) {
        ensureInit();
        this.mReporter = iZeusReporter;
    }

    public void setUnInstallPluginWhenHostChange(String str, boolean z) {
        ensureInit();
        this.unInstallPluginWhenHostChange.put(str, Boolean.valueOf(z));
    }

    public boolean unInstallPluginWhenHostChange(String str) {
        Boolean bool = this.unInstallPluginWhenHostChange.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}

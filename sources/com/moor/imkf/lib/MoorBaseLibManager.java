package com.moor.imkf.lib;

import android.content.Context;
import com.moor.imkf.lib.analytics.MoorReadUpAnalyticsThread;
import com.moor.imkf.lib.analytics.MoorRecordAnalyticsThread;
import com.moor.imkf.lib.http.MoorBaseHttpUtils;
import com.moor.imkf.lib.utils.MoorSysUtils;

/* loaded from: classes2.dex */
public class MoorBaseLibManager {
    private Context application;
    private boolean isDebug;

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        private static final MoorBaseLibManager sInstance = new MoorBaseLibManager();

        private SingletonHolder() {
        }
    }

    public static MoorBaseLibManager getInstance() {
        return SingletonHolder.sInstance;
    }

    public Context getApplication() {
        return this.application;
    }

    public void initBaseLib(Context context) {
        this.application = context;
        this.isDebug = MoorSysUtils.isApkInDebug(context);
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public void quitBaseLib() {
        try {
            MoorBaseHttpUtils.getInstance().cancelAll();
            MoorRecordAnalyticsThread.getInstance().quitRecordAnalytics();
            MoorReadUpAnalyticsThread.getInstance().quitReadAnalytics();
        } catch (Exception unused) {
        }
    }

    private MoorBaseLibManager() {
    }
}

package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.as;
import com.baidu.mobads.sdk.internal.cg;
import com.baidu.mobads.sdk.internal.y;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BDAdConfig {
    private Context mAppContext;
    private String mAppName;
    private String mAppsid;
    private String mChannelId;
    private boolean mCloseShake;
    private JSONObject mConfigObj;
    private JSONObject mDialogParams;
    private boolean mHttps;
    private boolean mLpMultiProcess;
    private boolean mMtjSwitch;
    private boolean mUseActivityDialog;
    private int mVideoCacheCapacityMb;
    private String mWXAPPid;

    /* loaded from: classes.dex */
    public static class Builder {
        private String mAppName;
        private String mAppsid;
        private String mChannelId;
        private JSONObject mDialogParams;
        private boolean mLpSupportMultiProcess;
        private int mVideoCacheCapacityMb;
        private String mWXAPPid;
        private boolean mHttps = true;
        private boolean mUseActivityDialog = true;
        private boolean mMtjSwitch = true;
        private boolean mCloseShake = false;

        public BDAdConfig build(Context context) {
            return new BDAdConfig(context, this);
        }

        public Builder setAppName(String str) {
            this.mAppName = str;
            return this;
        }

        public Builder setAppsid(String str) {
            this.mAppsid = str;
            return this;
        }

        public Builder setChannelId(String str) {
            this.mChannelId = str;
            return this;
        }

        public Builder setCloseShake(boolean z) {
            this.mCloseShake = z;
            return this;
        }

        public Builder setDialogParams(BDDialogParams bDDialogParams) {
            this.mDialogParams = bDDialogParams.toJson();
            return this;
        }

        public Builder setHttps(boolean z) {
            this.mHttps = z;
            return this;
        }

        public Builder setLpMultiProcess(boolean z) {
            this.mLpSupportMultiProcess = z;
            return this;
        }

        public Builder setMtjSwitch(boolean z) {
            this.mMtjSwitch = z;
            return this;
        }

        public Builder setVideoCacheCapacityMb(int i2) {
            this.mVideoCacheCapacityMb = i2;
            return this;
        }

        public Builder setWXAppid(String str) {
            this.mWXAPPid = str;
            return this;
        }

        @Deprecated
        public Builder useActivityDialog(Boolean bool) {
            this.mUseActivityDialog = bool.booleanValue();
            return this;
        }
    }

    public static void clearMemoryCache() {
        try {
            y.a().c().onTaskDistribute(as.f1448c, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void init() {
        JSONObject jSONObject = new JSONObject();
        this.mConfigObj = jSONObject;
        try {
            jSONObject.put("https", "" + this.mHttps);
            this.mConfigObj.put("appName", this.mAppName);
            JSONObject jSONObject2 = this.mConfigObj;
            jSONObject2.put("videoCacheSize", "" + this.mVideoCacheCapacityMb);
            this.mConfigObj.put("appsid", this.mAppsid);
            this.mConfigObj.put(RemoteMessageConst.Notification.CHANNEL_ID, this.mChannelId);
            JSONObject jSONObject3 = this.mConfigObj;
            jSONObject3.put("lpMultiProcess", "" + this.mLpMultiProcess);
            JSONObject jSONObject4 = this.mConfigObj;
            jSONObject4.put("useActivityDialog", "" + this.mUseActivityDialog);
            this.mConfigObj.put("dialog_params", this.mDialogParams);
            this.mConfigObj.put("mtj_switch", this.mMtjSwitch);
            this.mConfigObj.put("sp_shake", this.mCloseShake);
            this.mConfigObj.put("wxAppid", this.mWXAPPid);
            cg.a().a(this.mLpMultiProcess);
            cg.a().b(this.mHttps);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        y.a().a(this.mAppContext, new y.a() { // from class: com.baidu.mobads.sdk.api.BDAdConfig.1
            @Override // com.baidu.mobads.sdk.internal.y.a
            public void onFailure() {
            }

            @Override // com.baidu.mobads.sdk.internal.y.a
            public void onSuccess() {
                IXAdContainerFactory c2 = y.a().c();
                if (c2 != null) {
                    c2.initConfig(BDAdConfig.this.mConfigObj);
                    c2.onTaskDistribute(as.a, MobadsPermissionSettings.getPermissionInfo());
                }
            }
        });
    }

    private BDAdConfig(Context context, Builder builder) {
        this.mUseActivityDialog = true;
        this.mHttps = builder.mHttps;
        this.mAppContext = context;
        this.mVideoCacheCapacityMb = builder.mVideoCacheCapacityMb;
        this.mAppName = builder.mAppName;
        this.mAppsid = builder.mAppsid;
        this.mChannelId = builder.mChannelId;
        this.mLpMultiProcess = builder.mLpSupportMultiProcess;
        this.mUseActivityDialog = builder.mUseActivityDialog;
        this.mDialogParams = builder.mDialogParams;
        this.mMtjSwitch = builder.mMtjSwitch;
        this.mCloseShake = builder.mCloseShake;
        this.mWXAPPid = builder.mWXAPPid;
    }
}

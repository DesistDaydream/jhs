package com.bytedance.pangle.download;

import android.content.SharedPreferences;
import androidx.annotation.Keep;
import com.bytedance.pangle.util.m;
import java.util.List;

@Keep
/* loaded from: classes.dex */
public class PluginDownloadBean {
    public List<String> mBackupUrlList;
    public int mFlag;
    public long mFollowId;
    public String mMd5;
    public String mPackageName;
    public String mUrl;
    public int mVersionCode;
    public int mApiVersionMin = 0;
    public int mApiVersionMax = Integer.MAX_VALUE;

    public boolean allowDownload() {
        m a = m.a();
        String str = this.mPackageName;
        int i2 = this.mVersionCode;
        SharedPreferences sharedPreferences = a.a;
        return sharedPreferences.getBoolean("ALLOW_DOWNLOAD__" + str + "_" + i2, true);
    }

    public boolean isRevert() {
        return this.mFlag == 3;
    }

    public boolean isUnInstall() {
        return this.mFlag == 1;
    }
}

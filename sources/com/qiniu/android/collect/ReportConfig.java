package com.qiniu.android.collect;

import com.qiniu.android.common.Config;
import com.qiniu.android.utils.Utils;

/* loaded from: classes3.dex */
public class ReportConfig {
    private static ReportConfig instance = new ReportConfig();
    public long maxRecordFileSize;
    public final String recordDirectory;
    public int timeoutInterval;
    public long uploadThreshold;
    public boolean isReportEnable = Config.isRecord;
    public double interval = Config.interval;
    public final String serverURL = Config.upLogURL;

    private ReportConfig() {
        String str = Config.recordDir;
        if (str != null) {
            this.recordDirectory = str;
        } else {
            this.recordDirectory = Utils.sdkDirectory() + "/report";
        }
        this.maxRecordFileSize = Config.maxRecordFileSize;
        this.uploadThreshold = Config.uploadThreshold;
        this.timeoutInterval = 10;
    }

    public static ReportConfig getInstance() {
        return instance;
    }
}

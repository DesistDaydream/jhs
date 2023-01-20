package com.moor.imkf.lib.http.donwload;

/* loaded from: classes2.dex */
public interface IMoorOnDownloadListener {
    void onDownloadFailed();

    void onDownloadStart();

    void onDownloadSuccess(String str);

    void onDownloading(int i2);
}

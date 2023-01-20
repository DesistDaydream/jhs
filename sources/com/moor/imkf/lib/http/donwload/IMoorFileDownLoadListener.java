package com.moor.imkf.lib.http.donwload;

import java.io.File;

/* loaded from: classes2.dex */
public interface IMoorFileDownLoadListener {
    void onFailed();

    void onProgress(int i2);

    void onSuccess(File file);
}

package com.ss.android.socialbase.downloader.impls;

import com.moor.imkf.lib.jobqueue.base.JobManager;
import com.ss.android.socialbase.downloader.downloader.s;

/* loaded from: classes3.dex */
public class j implements s {
    @Override // com.ss.android.socialbase.downloader.downloader.s
    public long a(int i2, int i3) {
        if (i2 == 1) {
            return 3000L;
        }
        if (i2 == 2) {
            return 15000L;
        }
        return i2 == 3 ? JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS : i2 > 3 ? 300000L : 0L;
    }
}

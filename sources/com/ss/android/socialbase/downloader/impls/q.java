package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.s;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes3.dex */
public class q implements s {
    private final long[] a;

    public q(String str) {
        this.a = a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.s
    public long a(int i2, int i3) {
        long[] jArr = this.a;
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        int i4 = i2 - 1;
        if (i4 < 0) {
            i4 = 0;
        }
        if (i4 > jArr.length - 1) {
            i4 = jArr.length - 1;
        }
        return jArr[i4];
    }

    private long[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length == 0) {
                return null;
            }
            long[] jArr = new long[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                jArr[i2] = Long.parseLong(split[i2]);
            }
            return jArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}

package com.qiniu.android.http.serverRegion;

import com.qiniu.android.utils.Utils;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class UploadServerFreezeManager {
    private static final UploadServerFreezeManager manager = new UploadServerFreezeManager();
    private ConcurrentHashMap<String, UploadServerFreezeItem> frozenInfo = new ConcurrentHashMap<>();

    /* loaded from: classes3.dex */
    public static class UploadServerFreezeItem {
        private Date freezeDate;
        public final String type;

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void freeze(int i2) {
            this.freezeDate = new Date(Utils.currentTimestamp() + (i2 * 1000));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
            if (r1.getTime() < r6.getTime()) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized boolean isFrozenByDate(java.util.Date r6) {
            /*
                r5 = this;
                monitor-enter(r5)
                r0 = 1
                java.util.Date r1 = r5.freezeDate     // Catch: java.lang.Throwable -> L15
                if (r1 == 0) goto L12
                long r1 = r1.getTime()     // Catch: java.lang.Throwable -> L15
                long r3 = r6.getTime()     // Catch: java.lang.Throwable -> L15
                int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r6 >= 0) goto L13
            L12:
                r0 = 0
            L13:
                monitor-exit(r5)
                return r0
            L15:
                r6 = move-exception
                monitor-exit(r5)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.http.serverRegion.UploadServerFreezeManager.UploadServerFreezeItem.isFrozenByDate(java.util.Date):boolean");
        }

        private UploadServerFreezeItem(String str) {
            this.type = str;
        }
    }

    public static UploadServerFreezeManager getInstance() {
        return manager;
    }

    public void freezeType(String str, int i2) {
        if (str == null || str.length() == 0) {
            return;
        }
        UploadServerFreezeItem uploadServerFreezeItem = this.frozenInfo.get(str);
        if (uploadServerFreezeItem == null) {
            uploadServerFreezeItem = new UploadServerFreezeItem(str);
            this.frozenInfo.put(str, uploadServerFreezeItem);
        }
        uploadServerFreezeItem.freeze(i2);
    }

    public boolean isTypeFrozen(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        UploadServerFreezeItem uploadServerFreezeItem = this.frozenInfo.get(str);
        return uploadServerFreezeItem != null && uploadServerFreezeItem.isFrozenByDate(new Date());
    }

    public void unfreezeType(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        this.frozenInfo.remove(str);
    }
}

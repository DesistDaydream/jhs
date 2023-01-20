package com.qiniu.android.collect;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.request.RequestTransaction;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.transaction.TransactionManager;
import com.qiniu.android.utils.LogUtil;
import com.qiniu.android.utils.StringUtils;
import com.qiniu.android.utils.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UploadInfoReporter {
    private static final String DelayReportTransactionName = "com.qiniu.uplog";
    private static UploadInfoReporter instance = new UploadInfoReporter();
    private String X_Log_Client_Id;
    private RequestTransaction transaction;
    private ReportConfig config = ReportConfig.getInstance();
    private long lastReportTime = 0;
    private File recordDirectory = new File(this.config.recordDirectory);
    private File recorderFile = new File(this.config.recordDirectory + "/qiniu.log");
    private File recorderTempFile = new File(this.config.recordDirectory + "/qiniuTemp.log");
    private final ExecutorService executorService = new ThreadPoolExecutor(1, 2, 120, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    private boolean isReporting = false;

    private UploadInfoReporter() {
    }

    private boolean checkReportAvailable() {
        ReportConfig reportConfig = this.config;
        if (reportConfig.isReportEnable) {
            if (reportConfig.maxRecordFileSize <= reportConfig.uploadThreshold) {
                LogUtil.e("maxRecordFileSize must be larger than uploadThreshold");
                return false;
            }
            return true;
        }
        return false;
    }

    private void cleanRecorderFile() {
        if (this.recorderFile.exists()) {
            this.recorderFile.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanTempLogFile() {
        if (this.recorderTempFile.exists()) {
            this.recorderTempFile.delete();
        }
    }

    private synchronized RequestTransaction createUploadRequestTransaction(String str) {
        if (this.transaction != null) {
            return null;
        }
        if (this.config == null) {
            return null;
        }
        UpToken parse = UpToken.parse(str);
        if (parse == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.config.serverURL);
        RequestTransaction requestTransaction = new RequestTransaction(arrayList, "unknown", parse);
        this.transaction = requestTransaction;
        return requestTransaction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void destroyTransactionResource() {
        this.transaction = null;
    }

    public static UploadInfoReporter getInstance() {
        return instance;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
        if (r2 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
        if (r2 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] getLogData() {
        /*
            r6 = this;
            java.io.File r0 = r6.recorderTempFile
            r1 = 0
            if (r0 == 0) goto L50
            long r2 = r0.length()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L10
            goto L50
        L10:
            java.io.File r0 = r6.recorderTempFile
            long r2 = r0.length()
            int r0 = (int) r2
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L48 java.io.FileNotFoundException -> L4c
            java.io.File r3 = r6.recorderTempFile     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L48 java.io.FileNotFoundException -> L4c
            java.lang.String r4 = "r"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L48 java.io.FileNotFoundException -> L4c
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d java.io.FileNotFoundException -> L3f
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d java.io.FileNotFoundException -> L3f
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d java.io.FileNotFoundException -> L3f
        L27:
            int r4 = r2.read(r0)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d java.io.FileNotFoundException -> L3f
            if (r4 < 0) goto L32
            r5 = 0
            r3.write(r0, r5, r4)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d java.io.FileNotFoundException -> L3f
            goto L27
        L32:
            byte[] r1 = r3.toByteArray()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d java.io.FileNotFoundException -> L3f
        L36:
            r2.close()     // Catch: java.io.IOException -> L50
            goto L50
        L3a:
            r0 = move-exception
            r1 = r2
            goto L42
        L3d:
            goto L49
        L3f:
            goto L4d
        L41:
            r0 = move-exception
        L42:
            if (r1 == 0) goto L47
            r1.close()     // Catch: java.io.IOException -> L47
        L47:
            throw r0
        L48:
            r2 = r1
        L49:
            if (r2 == 0) goto L50
            goto L36
        L4c:
            r2 = r1
        L4d:
            if (r2 == 0) goto L50
            goto L36
        L50:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.collect.UploadInfoReporter.getLogData():byte[]");
    }

    private void reportToServer(String str) {
        byte[] logData;
        RequestTransaction createUploadRequestTransaction = createUploadRequestTransaction(str);
        if (createUploadRequestTransaction == null || (logData = getLogData()) == null || logData.length == 0) {
            return;
        }
        this.isReporting = true;
        createUploadRequestTransaction.reportLog(logData, this.X_Log_Client_Id, true, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.collect.UploadInfoReporter.3
            @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                Map<String, String> map;
                if (responseInfo.isOK()) {
                    UploadInfoReporter.this.lastReportTime = new Date().getTime();
                    if (UploadInfoReporter.this.X_Log_Client_Id == null && (map = responseInfo.responseHeader) != null && map.get("x-log-client-id") != null) {
                        UploadInfoReporter.this.X_Log_Client_Id = responseInfo.responseHeader.get("x-log-client-id");
                    }
                    UploadInfoReporter.this.cleanTempLogFile();
                }
                UploadInfoReporter.this.isReporting = false;
                UploadInfoReporter.this.destroyTransactionResource();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportToServerIfNeeded(final String str) {
        boolean z;
        TransactionManager.Transaction transaction;
        long currentSecondTimestamp = Utils.currentSecondTimestamp();
        long j2 = (long) (this.config.interval * 60.0d);
        if (!this.recorderTempFile.exists()) {
            long j3 = this.lastReportTime;
            if ((j3 != 0 && currentSecondTimestamp - j3 < j2 && this.recorderFile.length() <= this.config.uploadThreshold) || !this.recorderFile.renameTo(this.recorderTempFile)) {
                z = false;
                if (!z && !this.isReporting) {
                    reportToServer(str);
                    return;
                } else if (this.recorderFile.exists() || this.recorderFile.length() == 0) {
                } else {
                    ArrayList<TransactionManager.Transaction> transactionsForName = TransactionManager.getInstance().transactionsForName(DelayReportTransactionName);
                    if (transactionsForName == null || transactionsForName.size() <= 1) {
                        if (transactionsForName == null || transactionsForName.size() != 1 || (transaction = transactionsForName.get(0)) == null || transaction.isExecuting()) {
                            TransactionManager.getInstance().addTransaction(new TransactionManager.Transaction(DelayReportTransactionName, (int) j2, new Runnable() { // from class: com.qiniu.android.collect.UploadInfoReporter.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    UploadInfoReporter.this.reportToServerIfNeeded(str);
                                }
                            }));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
        z = true;
        if (!z) {
        }
        if (this.recorderFile.exists()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveReportJsonString(String str) {
        if (this.recordDirectory.exists() || this.recordDirectory.mkdirs()) {
            if (!this.recordDirectory.isDirectory()) {
                LogUtil.e("recordDirectory is not a directory");
                return;
            }
            if (!this.recorderFile.exists()) {
                try {
                    if (!this.recorderFile.createNewFile()) {
                        return;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (this.recorderFile.length() > this.config.maxRecordFileSize) {
                return;
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(this.recorderFile, true);
                    try {
                        fileOutputStream2.write((str + "\n").getBytes());
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (FileNotFoundException unused) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException unused4) {
                } catch (IOException unused5) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused6) {
            }
        }
    }

    public void clean() {
        cleanRecorderFile();
        cleanTempLogFile();
    }

    public synchronized void report(ReportItem reportItem, final String str) {
        if (checkReportAvailable() && reportItem != null && str != null && str.length() != 0) {
            final String json = reportItem.toJson();
            if (json == null) {
                return;
            }
            this.executorService.submit(new Runnable() { // from class: com.qiniu.android.collect.UploadInfoReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    LogUtil.i("up log:" + StringUtils.toNonnullString(json));
                    synchronized (this) {
                        UploadInfoReporter.this.saveReportJsonString(json);
                        UploadInfoReporter.this.reportToServerIfNeeded(str);
                    }
                }
            });
        }
    }
}

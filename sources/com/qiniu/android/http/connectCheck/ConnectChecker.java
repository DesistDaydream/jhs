package com.qiniu.android.http.connectCheck;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadSingleRequestMetrics;
import com.qiniu.android.http.request.IRequestClient;
import com.qiniu.android.http.request.Request;
import com.qiniu.android.http.request.httpclient.SystemHttpClient;
import com.qiniu.android.storage.GlobalConfiguration;
import com.qiniu.android.utils.LogUtil;
import com.qiniu.android.utils.SingleFlight;
import com.qiniu.android.utils.Wait;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConnectChecker {
    private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private static SingleFlight<UploadSingleRequestMetrics> singleFlight = new SingleFlight<>();

    /* loaded from: classes3.dex */
    public interface CheckCompleteHandler {
        void complete(UploadSingleRequestMetrics uploadSingleRequestMetrics);
    }

    /* loaded from: classes3.dex */
    public static class CheckResult {
        private UploadSingleRequestMetrics metrics;

        private CheckResult() {
        }
    }

    /* loaded from: classes3.dex */
    public static class CheckStatus {
        private int completeCount;
        private boolean isCompleted;
        private int totalCount;

        private CheckStatus() {
            this.totalCount = 0;
            this.completeCount = 0;
            this.isCompleted = false;
        }

        public static /* synthetic */ int access$512(CheckStatus checkStatus, int i2) {
            int i3 = checkStatus.completeCount + i2;
            checkStatus.completeCount = i3;
            return i3;
        }
    }

    public static UploadSingleRequestMetrics check() {
        final CheckResult checkResult = new CheckResult();
        final Wait wait = new Wait();
        check(new CheckCompleteHandler() { // from class: com.qiniu.android.http.connectCheck.ConnectChecker.1
            @Override // com.qiniu.android.http.connectCheck.ConnectChecker.CheckCompleteHandler
            public void complete(UploadSingleRequestMetrics uploadSingleRequestMetrics) {
                CheckResult.this.metrics = uploadSingleRequestMetrics;
                wait.stopWait();
            }
        });
        wait.startWait();
        return checkResult.metrics;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkAllHosts(final CheckCompleteHandler checkCompleteHandler) {
        String[] strArr = GlobalConfiguration.getInstance().connectCheckURLStrings;
        if (strArr == null) {
            checkCompleteHandler.complete(null);
            return;
        }
        String[] strArr2 = (String[]) strArr.clone();
        final CheckStatus checkStatus = new CheckStatus();
        checkStatus.totalCount = strArr2.length;
        checkStatus.completeCount = 0;
        checkStatus.isCompleted = false;
        for (String str : strArr2) {
            checkHost(str, new CheckCompleteHandler() { // from class: com.qiniu.android.http.connectCheck.ConnectChecker.4
                @Override // com.qiniu.android.http.connectCheck.ConnectChecker.CheckCompleteHandler
                public void complete(UploadSingleRequestMetrics uploadSingleRequestMetrics) {
                    boolean isConnected = ConnectChecker.isConnected(uploadSingleRequestMetrics);
                    synchronized (CheckStatus.this) {
                        CheckStatus.access$512(CheckStatus.this, 1);
                    }
                    if (!isConnected && CheckStatus.this.completeCount != CheckStatus.this.totalCount) {
                        LogUtil.i("== check all hosts not completed totalCount:" + CheckStatus.this.totalCount + " completeCount:" + CheckStatus.this.completeCount);
                        return;
                    }
                    synchronized (CheckStatus.this) {
                        if (CheckStatus.this.isCompleted) {
                            LogUtil.i("== check all hosts has completed totalCount:" + CheckStatus.this.totalCount + " completeCount:" + CheckStatus.this.completeCount);
                            return;
                        }
                        LogUtil.i("== check all hosts completed totalCount:" + CheckStatus.this.totalCount + " completeCount:" + CheckStatus.this.completeCount);
                        CheckStatus.this.isCompleted = true;
                        checkCompleteHandler.complete(uploadSingleRequestMetrics);
                    }
                }
            });
        }
    }

    private static void checkHost(final String str, final CheckCompleteHandler checkCompleteHandler) {
        final boolean[] zArr = {false};
        int i2 = GlobalConfiguration.getInstance().connectCheckTimeout;
        final UploadSingleRequestMetrics uploadSingleRequestMetrics = new UploadSingleRequestMetrics();
        uploadSingleRequestMetrics.start();
        executorService.schedule(new Callable<Object>() { // from class: com.qiniu.android.http.connectCheck.ConnectChecker.5
            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                synchronized (this) {
                    boolean[] zArr2 = zArr;
                    if (zArr2[0]) {
                        return null;
                    }
                    zArr2[0] = true;
                    uploadSingleRequestMetrics.end();
                    checkCompleteHandler.complete(uploadSingleRequestMetrics);
                    return null;
                }
            }
        }, i2, TimeUnit.SECONDS);
        Request request = new Request(str, Request.HttpMethodHEAD, null, null, i2);
        SystemHttpClient systemHttpClient = new SystemHttpClient();
        LogUtil.i("== checkHost:" + str);
        systemHttpClient.request(request, true, null, null, new IRequestClient.CompleteHandler() { // from class: com.qiniu.android.http.connectCheck.ConnectChecker.6
            @Override // com.qiniu.android.http.request.IRequestClient.CompleteHandler
            public void complete(ResponseInfo responseInfo, UploadSingleRequestMetrics uploadSingleRequestMetrics2, JSONObject jSONObject) {
                synchronized (this) {
                    boolean[] zArr2 = zArr;
                    if (zArr2[0]) {
                        return;
                    }
                    zArr2[0] = true;
                    LogUtil.i("== checkHost:" + str + " responseInfo:" + responseInfo);
                    checkCompleteHandler.complete(uploadSingleRequestMetrics2);
                }
            }
        });
    }

    public static boolean isConnected(UploadSingleRequestMetrics uploadSingleRequestMetrics) {
        return (uploadSingleRequestMetrics == null || uploadSingleRequestMetrics.getResponse() == null || uploadSingleRequestMetrics.getResponse().statusCode <= 99) ? false : true;
    }

    private static void check(final CheckCompleteHandler checkCompleteHandler) {
        try {
            singleFlight.perform("connect_check", new SingleFlight.ActionHandler<UploadSingleRequestMetrics>() { // from class: com.qiniu.android.http.connectCheck.ConnectChecker.2
                @Override // com.qiniu.android.utils.SingleFlight.ActionHandler
                public void action(final SingleFlight.CompleteHandler<UploadSingleRequestMetrics> completeHandler) throws Exception {
                    ConnectChecker.checkAllHosts(new CheckCompleteHandler() { // from class: com.qiniu.android.http.connectCheck.ConnectChecker.2.1
                        @Override // com.qiniu.android.http.connectCheck.ConnectChecker.CheckCompleteHandler
                        public void complete(UploadSingleRequestMetrics uploadSingleRequestMetrics) {
                            completeHandler.complete(uploadSingleRequestMetrics);
                        }
                    });
                }
            }, new SingleFlight.CompleteHandler<UploadSingleRequestMetrics>() { // from class: com.qiniu.android.http.connectCheck.ConnectChecker.3
                @Override // com.qiniu.android.utils.SingleFlight.CompleteHandler
                public void complete(UploadSingleRequestMetrics uploadSingleRequestMetrics) {
                    CheckCompleteHandler.this.complete(uploadSingleRequestMetrics);
                }
            });
        } catch (Exception unused) {
            checkCompleteHandler.complete(null);
        }
    }
}

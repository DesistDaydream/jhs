package com.qiniu.android.storage;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.request.RequestTransaction;
import com.qiniu.android.http.request.handler.RequestProgressHandler;
import com.qiniu.android.storage.BaseUpload;
import com.qiniu.android.utils.LogUtil;
import com.qiniu.android.utils.StringUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FormUpload extends BaseUpload {
    private boolean isAsync;
    private final UpProgress upProgress;
    private RequestTransaction uploadTransaction;

    public FormUpload(byte[] bArr, String str, String str2, UpToken upToken, UploadOptions uploadOptions, Configuration configuration, BaseUpload.UpTaskCompletionHandler upTaskCompletionHandler) {
        super(bArr, str, str2, upToken, uploadOptions, configuration, upTaskCompletionHandler);
        this.isAsync = true;
        this.upProgress = new UpProgress(this.option.progressHandler);
    }

    @Override // com.qiniu.android.storage.BaseUpload
    public String getUpType() {
        return "form";
    }

    @Override // com.qiniu.android.storage.BaseUpload
    public void startToUpload() {
        super.startToUpload();
        LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " form上传");
        this.uploadTransaction = new RequestTransaction(this.config, this.option, getTargetRegion(), getCurrentRegion(), this.key, this.token);
        this.uploadTransaction.uploadFormData(this.data, this.fileName, this.isAsync, new RequestProgressHandler() { // from class: com.qiniu.android.storage.FormUpload.1
            @Override // com.qiniu.android.http.request.handler.RequestProgressHandler
            public void progress(long j2, long j3) {
                FormUpload.this.upProgress.progress(FormUpload.this.key, j2, j3);
            }
        }, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.FormUpload.2
            @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                FormUpload.this.addRegionRequestMetricsOfOneFlow(uploadRegionRequestMetrics);
                if (responseInfo.isOK()) {
                    UpProgress upProgress = FormUpload.this.upProgress;
                    FormUpload formUpload = FormUpload.this;
                    upProgress.notifyDone(formUpload.key, formUpload.data.length);
                    FormUpload.this.completeAction(responseInfo, jSONObject);
                } else if (FormUpload.this.switchRegionAndUploadIfNeededWithErrorResponse(responseInfo)) {
                } else {
                    FormUpload.this.completeAction(responseInfo, jSONObject);
                }
            }
        });
    }
}

package com.qiniu.android.storage;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.qiniu.android.collect.ReportItem;
import com.qiniu.android.collect.UploadInfoReporter;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.metrics.UploadSingleRequestMetrics;
import com.qiniu.android.http.request.IUploadRegion;
import com.qiniu.android.storage.BaseUpload;
import com.qiniu.android.storage.PartsUploadPerformer;
import com.qiniu.android.utils.LogUtil;
import com.qiniu.android.utils.StringUtils;
import com.qiniu.android.utils.Utils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PartsUpload extends BaseUpload {
    private JSONObject uploadDataErrorResponse;
    private ResponseInfo uploadDataErrorResponseInfo;
    public PartsUploadPerformer uploadPerformer;

    /* renamed from: com.qiniu.android.storage.PartsUpload$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements UploadFileCompleteHandler {
        public AnonymousClass1() {
        }

        @Override // com.qiniu.android.storage.PartsUpload.UploadFileCompleteHandler
        public void complete(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (!responseInfo.isOK()) {
                if (PartsUpload.this.switchRegionAndUploadIfNeededWithErrorResponse(responseInfo)) {
                    return;
                }
                PartsUpload.this.completeAction(responseInfo, jSONObject);
                return;
            }
            LogUtil.i("key:" + StringUtils.toNonnullString(PartsUpload.this.key) + " uploadRestData");
            PartsUpload.this.uploadRestData(new UploadFileRestDataCompleteHandler() { // from class: com.qiniu.android.storage.PartsUpload.1.1
                @Override // com.qiniu.android.storage.PartsUpload.UploadFileRestDataCompleteHandler
                public void complete() {
                    if (!PartsUpload.this.isAllUploaded()) {
                        PartsUpload partsUpload = PartsUpload.this;
                        if (partsUpload.switchRegionAndUploadIfNeededWithErrorResponse(partsUpload.uploadDataErrorResponseInfo)) {
                            return;
                        }
                        PartsUpload partsUpload2 = PartsUpload.this;
                        partsUpload2.completeAction(partsUpload2.uploadDataErrorResponseInfo, PartsUpload.this.uploadDataErrorResponse);
                    } else if (PartsUpload.this.uploadPerformer.uploadInfo.getSourceSize() == 0) {
                        PartsUpload.this.completeAction(ResponseInfo.zeroSize("file is empty"), null);
                    } else {
                        LogUtil.i("key:" + StringUtils.toNonnullString(PartsUpload.this.key) + " completeUpload");
                        PartsUpload.this.completeUpload(new UploadFileCompleteHandler() { // from class: com.qiniu.android.storage.PartsUpload.1.1.1
                            @Override // com.qiniu.android.storage.PartsUpload.UploadFileCompleteHandler
                            public void complete(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                                if (!responseInfo2.isOK()) {
                                    if (PartsUpload.this.switchRegionAndUploadIfNeededWithErrorResponse(responseInfo2)) {
                                        return;
                                    }
                                    PartsUpload.this.completeAction(responseInfo2, jSONObject2);
                                    return;
                                }
                                PartsUpload.this.completeAction(responseInfo2, jSONObject2);
                            }
                        });
                    }
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public interface UploadFileCompleteHandler {
        void complete(ResponseInfo responseInfo, JSONObject jSONObject);
    }

    /* loaded from: classes3.dex */
    public interface UploadFileDataCompleteHandler {
        void complete(boolean z, ResponseInfo responseInfo, JSONObject jSONObject);
    }

    /* loaded from: classes3.dex */
    public interface UploadFileRestDataCompleteHandler {
        void complete();
    }

    public PartsUpload(UploadSource uploadSource, String str, UpToken upToken, UploadOptions uploadOptions, Configuration configuration, Recorder recorder, String str2, BaseUpload.UpTaskCompletionHandler upTaskCompletionHandler) {
        super(uploadSource, str, upToken, uploadOptions, configuration, recorder, str2, upTaskCompletionHandler);
    }

    private void reportBlock() {
        UpToken upToken = this.token;
        if (upToken == null || !upToken.isValid()) {
            return;
        }
        UploadRegionRequestMetrics currentRegionRequestMetrics = getCurrentRegionRequestMetrics();
        String str = null;
        if (currentRegionRequestMetrics == null) {
            currentRegionRequestMetrics = new UploadRegionRequestMetrics(null);
        }
        String str2 = (getCurrentRegion() == null || getCurrentRegion().getZoneInfo() == null || getCurrentRegion().getZoneInfo().regionId == null) ? null : getCurrentRegion().getZoneInfo().regionId;
        if (getTargetRegion() != null && getTargetRegion().getZoneInfo() != null && getTargetRegion().getZoneInfo().regionId != null) {
            str = getTargetRegion().getZoneInfo().regionId;
        }
        ReportItem reportItem = new ReportItem();
        reportItem.setReport(ReportItem.LogTypeBlock, "log_type");
        reportItem.setReport(Long.valueOf(Utils.currentTimestamp() / 1000), "up_time");
        reportItem.setReport(this.key, "target_key");
        reportItem.setReport(this.token.bucket, "target_bucket");
        reportItem.setReport(str2, "target_region_id");
        reportItem.setReport(str, "current_region_id");
        reportItem.setReport(Long.valueOf(currentRegionRequestMetrics.totalElapsedTime()), "total_elapsed_time");
        reportItem.setReport(currentRegionRequestMetrics.bytesSend(), "bytes_sent");
        reportItem.setReport(this.uploadPerformer.recoveredFrom, ReportItem.BlockKeyRecoveredFrom);
        reportItem.setReport(Long.valueOf(this.uploadSource.getSize()), "file_size");
        UploadSingleRequestMetrics lastMetrics = currentRegionRequestMetrics.lastMetrics();
        if (lastMetrics != null) {
            reportItem.setReport(lastMetrics.getHijacked(), "hijacking");
        }
        if (this.uploadDataErrorResponseInfo == null && this.uploadSource.getSize() > 0 && currentRegionRequestMetrics.totalElapsedTime() > 0) {
            reportItem.setReport(Utils.calculateSpeed(Long.valueOf(this.uploadSource.getSize()), Long.valueOf(currentRegionRequestMetrics.totalElapsedTime())), "perceptive_speed");
        }
        reportItem.setReport(Utils.getCurrentProcessID(), "pid");
        reportItem.setReport(Utils.getCurrentThreadID(), "tid");
        Configuration configuration = this.config;
        if (configuration != null && configuration.resumeUploadVersion == Configuration.RESUME_UPLOAD_VERSION_V1) {
            reportItem.setReport(1, ReportItem.BlockKeyUpApiVersion);
        } else {
            reportItem.setReport(2, ReportItem.BlockKeyUpApiVersion);
        }
        reportItem.setReport(Long.valueOf(Utils.currentTimestamp()), "client_time");
        reportItem.setReport(Utils.systemName(), "os_name");
        reportItem.setReport(Utils.systemVersion(), "os_version");
        reportItem.setReport(Utils.sdkLanguage(), "sdk_name");
        reportItem.setReport(Utils.sdkVerion(), "sdk_version");
        UploadInfoReporter.getInstance().report(reportItem, this.token.token);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorResponse(ResponseInfo responseInfo, JSONObject jSONObject) {
        if (responseInfo == null) {
            return;
        }
        if (this.uploadDataErrorResponseInfo == null || responseInfo.statusCode != -9) {
            this.uploadDataErrorResponseInfo = responseInfo;
            if (jSONObject == null) {
                this.uploadDataErrorResponse = responseInfo.response;
            } else {
                this.uploadDataErrorResponse = jSONObject;
            }
        }
    }

    private boolean shouldRemoveUploadInfoRecord(ResponseInfo responseInfo) {
        int i2;
        return responseInfo != null && (responseInfo.isOK() || (i2 = responseInfo.statusCode) == 612 || i2 == 614 || i2 == 701);
    }

    @Override // com.qiniu.android.storage.BaseUpload
    public void completeAction(ResponseInfo responseInfo, JSONObject jSONObject) {
        this.uploadPerformer.closeFile();
        if (shouldRemoveUploadInfoRecord(responseInfo)) {
            this.uploadPerformer.removeUploadInfoRecord();
        }
        super.completeAction(responseInfo, jSONObject);
        reportBlock();
    }

    public void completeUpload(final UploadFileCompleteHandler uploadFileCompleteHandler) {
        this.uploadPerformer.completeUpload(new PartsUploadPerformer.PartsUploadPerformerCompleteHandler() { // from class: com.qiniu.android.storage.PartsUpload.5
            @Override // com.qiniu.android.storage.PartsUploadPerformer.PartsUploadPerformerCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                if (responseInfo != null && !responseInfo.isOK()) {
                    PartsUpload.this.setErrorResponse(responseInfo, jSONObject);
                }
                PartsUpload.this.addRegionRequestMetricsOfOneFlow(uploadRegionRequestMetrics);
                uploadFileCompleteHandler.complete(responseInfo, jSONObject);
            }
        });
    }

    @Override // com.qiniu.android.storage.BaseUpload
    public String getUpType() {
        Configuration configuration = this.config;
        if (configuration == null) {
            return null;
        }
        if (configuration.resumeUploadVersion == Configuration.RESUME_UPLOAD_VERSION_V1) {
            return "resumable_v1<" + this.uploadSource.getSourceType() + SimpleComparison.GREATER_THAN_OPERATION;
        }
        return "resumable_v2<" + this.uploadSource.getSourceType() + SimpleComparison.GREATER_THAN_OPERATION;
    }

    @Override // com.qiniu.android.storage.BaseUpload
    public void initData() {
        super.initData();
        Configuration configuration = this.config;
        if (configuration != null && configuration.resumeUploadVersion == Configuration.RESUME_UPLOAD_VERSION_V1) {
            LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " 分片V1");
            this.uploadPerformer = new PartsUploadPerformerV1(this.uploadSource, this.fileName, this.key, this.token, this.option, this.config, this.recorderKey);
            return;
        }
        LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " 分片V2");
        this.uploadPerformer = new PartsUploadPerformerV2(this.uploadSource, this.fileName, this.key, this.token, this.option, this.config, this.recorderKey);
    }

    public boolean isAllUploaded() {
        UploadInfo uploadInfo = this.uploadPerformer.uploadInfo;
        if (uploadInfo == null) {
            return false;
        }
        return uploadInfo.isAllUploaded();
    }

    public void performUploadRestData(final UploadFileRestDataCompleteHandler uploadFileRestDataCompleteHandler) {
        if (isAllUploaded()) {
            uploadFileRestDataCompleteHandler.complete();
        } else {
            uploadNextData(new UploadFileDataCompleteHandler() { // from class: com.qiniu.android.storage.PartsUpload.2
                @Override // com.qiniu.android.storage.PartsUpload.UploadFileDataCompleteHandler
                public void complete(boolean z, ResponseInfo responseInfo, JSONObject jSONObject) {
                    if (!z && (responseInfo == null || responseInfo.isOK())) {
                        PartsUpload.this.performUploadRestData(uploadFileRestDataCompleteHandler);
                    } else {
                        uploadFileRestDataCompleteHandler.complete();
                    }
                }
            });
        }
    }

    @Override // com.qiniu.android.storage.BaseUpload
    public int prepareToUpload() {
        IUploadRegion iUploadRegion;
        int prepareToUpload = super.prepareToUpload();
        if (prepareToUpload != 0) {
            return prepareToUpload;
        }
        IUploadRegion iUploadRegion2 = this.uploadPerformer.currentRegion;
        if (iUploadRegion2 != null && iUploadRegion2.isValid()) {
            insertRegionAtFirst(this.uploadPerformer.currentRegion);
            LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " 使用缓存region");
        } else {
            this.uploadPerformer.switchRegion(getCurrentRegion());
        }
        PartsUploadPerformer partsUploadPerformer = this.uploadPerformer;
        if (partsUploadPerformer != null && (iUploadRegion = partsUploadPerformer.currentRegion) != null && iUploadRegion.getZoneInfo() != null) {
            LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " region:" + StringUtils.toNonnullString(this.uploadPerformer.currentRegion.getZoneInfo().regionId));
        }
        if (this.uploadPerformer.canReadFile()) {
            return prepareToUpload;
        }
        return -7;
    }

    public void serverInit(final UploadFileCompleteHandler uploadFileCompleteHandler) {
        this.uploadPerformer.serverInit(new PartsUploadPerformer.PartsUploadPerformerCompleteHandler() { // from class: com.qiniu.android.storage.PartsUpload.3
            @Override // com.qiniu.android.storage.PartsUploadPerformer.PartsUploadPerformerCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                if (responseInfo != null && !responseInfo.isOK()) {
                    PartsUpload.this.setErrorResponse(responseInfo, jSONObject);
                }
                PartsUpload.this.addRegionRequestMetricsOfOneFlow(uploadRegionRequestMetrics);
                uploadFileCompleteHandler.complete(responseInfo, jSONObject);
            }
        });
    }

    @Override // com.qiniu.android.storage.BaseUpload
    public void startToUpload() {
        super.startToUpload();
        this.uploadDataErrorResponse = null;
        this.uploadDataErrorResponseInfo = null;
        LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " serverInit");
        serverInit(new AnonymousClass1());
    }

    @Override // com.qiniu.android.storage.BaseUpload
    public boolean switchRegion() {
        IUploadRegion iUploadRegion;
        if (this.uploadPerformer.couldReloadInfo() && this.uploadPerformer.reloadInfo()) {
            boolean switchRegion = super.switchRegion();
            if (switchRegion) {
                this.uploadPerformer.switchRegion(getCurrentRegion());
                PartsUploadPerformer partsUploadPerformer = this.uploadPerformer;
                if (partsUploadPerformer != null && (iUploadRegion = partsUploadPerformer.currentRegion) != null && iUploadRegion.getZoneInfo() != null) {
                    LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " region:" + StringUtils.toNonnullString(this.uploadPerformer.currentRegion.getZoneInfo().regionId));
                }
            }
            return switchRegion;
        }
        return false;
    }

    @Override // com.qiniu.android.storage.BaseUpload
    public boolean switchRegionAndUpload() {
        reportBlock();
        return super.switchRegionAndUpload();
    }

    public void uploadNextData(final UploadFileDataCompleteHandler uploadFileDataCompleteHandler) {
        this.uploadPerformer.uploadNextData(new PartsUploadPerformer.PartsUploadPerformerDataCompleteHandler() { // from class: com.qiniu.android.storage.PartsUpload.4
            @Override // com.qiniu.android.storage.PartsUploadPerformer.PartsUploadPerformerDataCompleteHandler
            public void complete(boolean z, ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                if (responseInfo != null && !responseInfo.isOK()) {
                    PartsUpload.this.setErrorResponse(responseInfo, jSONObject);
                }
                PartsUpload.this.addRegionRequestMetricsOfOneFlow(uploadRegionRequestMetrics);
                uploadFileDataCompleteHandler.complete(z, responseInfo, jSONObject);
            }
        });
    }

    public void uploadRestData(UploadFileRestDataCompleteHandler uploadFileRestDataCompleteHandler) {
        LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " 串行分片");
        performUploadRestData(uploadFileRestDataCompleteHandler);
    }
}

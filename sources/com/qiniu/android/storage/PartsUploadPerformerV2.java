package com.qiniu.android.storage;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.request.RequestTransaction;
import com.qiniu.android.http.request.handler.RequestProgressHandler;
import com.qiniu.android.storage.PartsUploadPerformer;
import com.qiniu.android.storage.UploadData;
import com.qiniu.android.utils.LogUtil;
import com.qiniu.android.utils.StringUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PartsUploadPerformerV2 extends PartsUploadPerformer {
    public PartsUploadPerformerV2(UploadSource uploadSource, String str, String str2, UpToken upToken, UploadOptions uploadOptions, Configuration configuration, String str3) {
        super(uploadSource, str, str2, upToken, uploadOptions, configuration, str3);
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public void completeUpload(final PartsUploadPerformer.PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler) {
        UploadInfoV2 uploadInfoV2 = (UploadInfoV2) this.uploadInfo;
        List<Map<String, Object>> partInfoArray = uploadInfoV2.getPartInfoArray();
        final RequestTransaction createUploadRequestTransaction = createUploadRequestTransaction();
        createUploadRequestTransaction.completeParts(true, this.fileName, uploadInfoV2.uploadId, partInfoArray, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV2.4
            @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                if (responseInfo.isOK()) {
                    PartsUploadPerformerV2.this.notifyProgress(Boolean.TRUE);
                }
                PartsUploadPerformerV2.this.destroyUploadRequestTransaction(createUploadRequestTransaction);
                partsUploadPerformerCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public UploadInfo getDefaultUploadInfo() {
        return new UploadInfoV2(this.uploadSource, this.config);
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public UploadInfo getUploadInfoFromJson(UploadSource uploadSource, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return UploadInfoV2.infoFromJson(uploadSource, jSONObject);
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public void serverInit(final PartsUploadPerformer.PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler) {
        final UploadInfoV2 uploadInfoV2 = (UploadInfoV2) this.uploadInfo;
        if (uploadInfoV2 != null && uploadInfoV2.isValid()) {
            LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " serverInit success");
            partsUploadPerformerCompleteHandler.complete(ResponseInfo.successResponse(), null, null);
            return;
        }
        final RequestTransaction createUploadRequestTransaction = createUploadRequestTransaction();
        createUploadRequestTransaction.initPart(true, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV2.1
            @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                String str;
                Long l2;
                PartsUploadPerformerV2.this.destroyUploadRequestTransaction(createUploadRequestTransaction);
                Long l3 = null;
                l3 = null;
                String str2 = null;
                if (jSONObject != null) {
                    try {
                        str = jSONObject.getString("uploadId");
                        try {
                            l3 = Long.valueOf(jSONObject.getLong("expireAt"));
                        } catch (JSONException unused) {
                        }
                    } catch (JSONException unused2) {
                        str = null;
                    }
                    String str3 = str;
                    l2 = l3;
                    str2 = str3;
                } else {
                    l2 = null;
                }
                if (responseInfo.isOK() && str2 != null && l2 != null) {
                    UploadInfoV2 uploadInfoV22 = uploadInfoV2;
                    uploadInfoV22.uploadId = str2;
                    uploadInfoV22.expireAt = l2;
                    PartsUploadPerformerV2.this.recordUploadInfo();
                }
                partsUploadPerformerCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public void uploadNextData(final PartsUploadPerformer.PartsUploadPerformerDataCompleteHandler partsUploadPerformerDataCompleteHandler) {
        final UploadData nextUploadData;
        ResponseInfo sdkInteriorError;
        UploadInfoV2 uploadInfoV2 = (UploadInfoV2) this.uploadInfo;
        synchronized (this) {
            try {
                nextUploadData = uploadInfoV2.nextUploadData();
                if (nextUploadData != null) {
                    nextUploadData.updateState(UploadData.State.Uploading);
                }
            } catch (Exception e2) {
                LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + ExpandableTextView.N + e2.getMessage());
                ResponseInfo localIOError = ResponseInfo.localIOError(e2.getMessage());
                partsUploadPerformerDataCompleteHandler.complete(true, localIOError, null, localIOError.response);
                return;
            }
        }
        if (nextUploadData == null) {
            LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " no data left");
            if (this.uploadInfo.getSourceSize() == 0) {
                sdkInteriorError = ResponseInfo.zeroSize("file is empty");
            } else {
                sdkInteriorError = ResponseInfo.sdkInteriorError("no chunk left");
            }
            partsUploadPerformerDataCompleteHandler.complete(true, sdkInteriorError, null, null);
            return;
        }
        RequestProgressHandler requestProgressHandler = new RequestProgressHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV2.2
            @Override // com.qiniu.android.http.request.handler.RequestProgressHandler
            public void progress(long j2, long j3) {
                nextUploadData.setUploadSize(j2);
                PartsUploadPerformerV2.this.notifyProgress(Boolean.FALSE);
            }
        };
        final RequestTransaction createUploadRequestTransaction = createUploadRequestTransaction();
        createUploadRequestTransaction.uploadPart(true, uploadInfoV2.uploadId, uploadInfoV2.getPartIndexOfData(nextUploadData), nextUploadData.data, requestProgressHandler, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV2.3
            @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                String str;
                String str2;
                PartsUploadPerformerV2.this.destroyUploadRequestTransaction(createUploadRequestTransaction);
                String str3 = null;
                if (jSONObject != null) {
                    try {
                        str = jSONObject.getString("etag");
                        try {
                            str3 = jSONObject.getString("md5");
                        } catch (JSONException unused) {
                        }
                    } catch (JSONException unused2) {
                        str = null;
                    }
                    String str4 = str;
                    str2 = str3;
                    str3 = str4;
                } else {
                    str2 = null;
                }
                if (responseInfo.isOK() && str3 != null && str2 != null) {
                    UploadData uploadData = nextUploadData;
                    uploadData.etag = str3;
                    uploadData.updateState(UploadData.State.Complete);
                    PartsUploadPerformerV2.this.recordUploadInfo();
                    PartsUploadPerformerV2.this.notifyProgress(Boolean.FALSE);
                } else {
                    nextUploadData.updateState(UploadData.State.WaitToUpload);
                }
                partsUploadPerformerDataCompleteHandler.complete(false, responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }
}

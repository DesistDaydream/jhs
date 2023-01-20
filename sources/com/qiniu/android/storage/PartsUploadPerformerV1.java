package com.qiniu.android.storage;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.request.RequestTransaction;
import com.qiniu.android.http.request.handler.RequestProgressHandler;
import com.qiniu.android.storage.PartsUploadPerformer;
import com.qiniu.android.storage.UploadData;
import com.qiniu.android.utils.LogUtil;
import com.qiniu.android.utils.StringUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PartsUploadPerformerV1 extends PartsUploadPerformer {
    public PartsUploadPerformerV1(UploadSource uploadSource, String str, String str2, UpToken upToken, UploadOptions uploadOptions, Configuration configuration, String str3) {
        super(uploadSource, str, str2, upToken, uploadOptions, configuration, str3);
    }

    private void makeBlock(UploadBlock uploadBlock, UploadData uploadData, RequestProgressHandler requestProgressHandler, final PartsUploadPerformer.PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler) {
        final RequestTransaction createUploadRequestTransaction = createUploadRequestTransaction();
        createUploadRequestTransaction.makeBlock(uploadBlock.offset, uploadBlock.size, uploadData.data, true, requestProgressHandler, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV1.4
            @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                PartsUploadPerformerV1.this.destroyUploadRequestTransaction(createUploadRequestTransaction);
                partsUploadPerformerCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }

    private void uploadChunk(UploadBlock uploadBlock, UploadData uploadData, RequestProgressHandler requestProgressHandler, final PartsUploadPerformer.PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler) {
        final RequestTransaction createUploadRequestTransaction = createUploadRequestTransaction();
        createUploadRequestTransaction.uploadChunk(uploadBlock.ctx, uploadBlock.offset, uploadData.data, uploadData.offset, true, requestProgressHandler, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV1.5
            @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                PartsUploadPerformerV1.this.destroyUploadRequestTransaction(createUploadRequestTransaction);
                partsUploadPerformerCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public void completeUpload(final PartsUploadPerformer.PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler) {
        UploadInfoV1 uploadInfoV1 = (UploadInfoV1) this.uploadInfo;
        ArrayList<String> allBlocksContexts = uploadInfoV1.allBlocksContexts();
        String[] strArr = (allBlocksContexts == null || allBlocksContexts.size() <= 0) ? null : (String[]) allBlocksContexts.toArray(new String[allBlocksContexts.size()]);
        final RequestTransaction createUploadRequestTransaction = createUploadRequestTransaction();
        createUploadRequestTransaction.makeFile(uploadInfoV1.getSourceSize(), this.fileName, strArr, true, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV1.3
            @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                if (responseInfo.isOK()) {
                    PartsUploadPerformerV1.this.notifyProgress(Boolean.TRUE);
                }
                PartsUploadPerformerV1.this.destroyUploadRequestTransaction(createUploadRequestTransaction);
                partsUploadPerformerCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public UploadInfo getDefaultUploadInfo() {
        return new UploadInfoV1(this.uploadSource, this.config);
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public UploadInfo getUploadInfoFromJson(UploadSource uploadSource, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return UploadInfoV1.infoFromJson(uploadSource, jSONObject);
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public void serverInit(PartsUploadPerformer.PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler) {
        partsUploadPerformerCompleteHandler.complete(ResponseInfo.successResponse(), null, null);
    }

    @Override // com.qiniu.android.storage.PartsUploadPerformer
    public void uploadNextData(final PartsUploadPerformer.PartsUploadPerformerDataCompleteHandler partsUploadPerformerDataCompleteHandler) {
        final UploadBlock nextUploadBlock;
        final UploadData nextUploadData;
        ResponseInfo sdkInteriorError;
        UploadInfoV1 uploadInfoV1 = (UploadInfoV1) this.uploadInfo;
        synchronized (this) {
            try {
                nextUploadBlock = uploadInfoV1.nextUploadBlock();
                nextUploadData = uploadInfoV1.nextUploadData(nextUploadBlock);
                if (nextUploadData != null) {
                    nextUploadData.updateState(UploadData.State.Uploading);
                }
            } catch (Exception e2) {
                LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + e2.getMessage());
                partsUploadPerformerDataCompleteHandler.complete(true, ResponseInfo.localIOError(e2.getMessage()), null, null);
                return;
            }
        }
        if (nextUploadBlock != null && nextUploadData != null) {
            if (nextUploadData.data == null) {
                LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " get chunk null");
                partsUploadPerformerDataCompleteHandler.complete(true, ResponseInfo.invalidArgument("chunk data is null"), null, null);
                return;
            }
            RequestProgressHandler requestProgressHandler = new RequestProgressHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV1.1
                @Override // com.qiniu.android.http.request.handler.RequestProgressHandler
                public void progress(long j2, long j3) {
                    nextUploadData.setUploadSize(j2);
                    PartsUploadPerformerV1.this.notifyProgress(Boolean.FALSE);
                }
            };
            PartsUploadPerformer.PartsUploadPerformerCompleteHandler partsUploadPerformerCompleteHandler = new PartsUploadPerformer.PartsUploadPerformerCompleteHandler() { // from class: com.qiniu.android.storage.PartsUploadPerformerV1.2
                @Override // com.qiniu.android.storage.PartsUploadPerformer.PartsUploadPerformerCompleteHandler
                public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                    String string;
                    if (jSONObject != null) {
                        try {
                            string = jSONObject.getString("ctx");
                        } catch (JSONException unused) {
                        }
                        if (!responseInfo.isOK() && string != null) {
                            nextUploadBlock.ctx = string;
                            nextUploadData.updateState(UploadData.State.Complete);
                            PartsUploadPerformerV1.this.recordUploadInfo();
                            PartsUploadPerformerV1.this.notifyProgress(Boolean.FALSE);
                        } else {
                            nextUploadData.updateState(UploadData.State.WaitToUpload);
                        }
                        partsUploadPerformerDataCompleteHandler.complete(false, responseInfo, uploadRegionRequestMetrics, jSONObject);
                    }
                    string = null;
                    if (!responseInfo.isOK()) {
                    }
                    nextUploadData.updateState(UploadData.State.WaitToUpload);
                    partsUploadPerformerDataCompleteHandler.complete(false, responseInfo, uploadRegionRequestMetrics, jSONObject);
                }
            };
            if (uploadInfoV1.isFirstData(nextUploadData)) {
                LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " makeBlock");
                makeBlock(nextUploadBlock, nextUploadData, requestProgressHandler, partsUploadPerformerCompleteHandler);
                return;
            }
            LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " makeBlock");
            uploadChunk(nextUploadBlock, nextUploadData, requestProgressHandler, partsUploadPerformerCompleteHandler);
            return;
        }
        LogUtil.i("key:" + StringUtils.toNonnullString(this.key) + " no chunk left");
        if (this.uploadInfo.getSourceSize() == 0) {
            sdkInteriorError = ResponseInfo.zeroSize("file is empty");
        } else {
            sdkInteriorError = ResponseInfo.sdkInteriorError("no chunk left");
        }
        partsUploadPerformerDataCompleteHandler.complete(true, sdkInteriorError, null, null);
    }
}

package com.qiniu.android.storage;

import com.qiniu.android.common.Zone;
import com.qiniu.android.common.ZoneInfo;
import com.qiniu.android.common.ZonesInfo;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.metrics.UploadTaskMetrics;
import com.qiniu.android.http.request.IUploadRegion;
import com.qiniu.android.http.serverRegion.UploadDomainRegion;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class BaseUpload implements Runnable {
    public static final String UploadUpTypeForm = "form";
    public static final String UploadUpTypeResumableV1 = "resumable_v1";
    public static final String UploadUpTypeResumableV2 = "resumable_v2";
    public final UpTaskCompletionHandler completionHandler;
    public final Configuration config;
    private int currentRegionIndex;
    private UploadRegionRequestMetrics currentRegionRequestMetrics;
    public final byte[] data;
    public final String fileName;
    public final String key;
    private UploadTaskMetrics metrics;
    public final UploadOptions option;
    public final Recorder recorder;
    public final String recorderKey;
    private ArrayList<IUploadRegion> regions;
    public final UpToken token;
    public final UploadSource uploadSource;

    /* loaded from: classes3.dex */
    public interface UpTaskCompletionHandler {
        void complete(ResponseInfo responseInfo, String str, UploadTaskMetrics uploadTaskMetrics, JSONObject jSONObject);
    }

    private BaseUpload(UploadSource uploadSource, byte[] bArr, String str, String str2, UpToken upToken, UploadOptions uploadOptions, Configuration configuration, Recorder recorder, String str3, UpTaskCompletionHandler upTaskCompletionHandler) {
        this.uploadSource = uploadSource;
        this.data = bArr;
        this.fileName = str == null ? "?" : str;
        this.key = str2;
        this.token = upToken;
        this.option = uploadOptions == null ? UploadOptions.defaultOptions() : uploadOptions;
        this.config = configuration;
        this.recorder = recorder;
        this.recorderKey = str3;
        this.completionHandler = upTaskCompletionHandler;
        initData();
    }

    private boolean setupRegions() {
        Zone zone;
        ZonesInfo zonesInfo;
        ArrayList<ZoneInfo> arrayList;
        Configuration configuration = this.config;
        if (configuration == null || (zone = configuration.zone) == null || (zonesInfo = zone.getZonesInfo(this.token)) == null || (arrayList = zonesInfo.zonesInfo) == null || arrayList.size() == 0) {
            return false;
        }
        ArrayList<ZoneInfo> arrayList2 = zonesInfo.zonesInfo;
        ArrayList<IUploadRegion> arrayList3 = new ArrayList<>();
        Iterator<ZoneInfo> it = arrayList2.iterator();
        while (it.hasNext()) {
            UploadDomainRegion uploadDomainRegion = new UploadDomainRegion();
            uploadDomainRegion.setupRegionData(it.next());
            if (uploadDomainRegion.isValid()) {
                arrayList3.add(uploadDomainRegion);
            }
        }
        this.regions = arrayList3;
        this.metrics.regions = arrayList3;
        return arrayList3.size() > 0;
    }

    public void addRegionRequestMetricsOfOneFlow(UploadRegionRequestMetrics uploadRegionRequestMetrics) {
        if (uploadRegionRequestMetrics == null) {
            return;
        }
        UploadRegionRequestMetrics uploadRegionRequestMetrics2 = this.currentRegionRequestMetrics;
        if (uploadRegionRequestMetrics2 == null) {
            this.currentRegionRequestMetrics = uploadRegionRequestMetrics;
        } else {
            uploadRegionRequestMetrics2.addMetrics(uploadRegionRequestMetrics);
        }
    }

    public void completeAction(ResponseInfo responseInfo, JSONObject jSONObject) {
        UploadTaskMetrics uploadTaskMetrics;
        UploadTaskMetrics uploadTaskMetrics2 = this.metrics;
        if (uploadTaskMetrics2 != null) {
            uploadTaskMetrics2.end();
        }
        UploadRegionRequestMetrics uploadRegionRequestMetrics = this.currentRegionRequestMetrics;
        if (uploadRegionRequestMetrics != null) {
            uploadRegionRequestMetrics.end();
        }
        UploadRegionRequestMetrics uploadRegionRequestMetrics2 = this.currentRegionRequestMetrics;
        if (uploadRegionRequestMetrics2 != null && (uploadTaskMetrics = this.metrics) != null) {
            uploadTaskMetrics.addMetrics(uploadRegionRequestMetrics2);
        }
        UpTaskCompletionHandler upTaskCompletionHandler = this.completionHandler;
        if (upTaskCompletionHandler != null) {
            upTaskCompletionHandler.complete(responseInfo, this.key, this.metrics, jSONObject);
        }
    }

    public IUploadRegion getCurrentRegion() {
        IUploadRegion iUploadRegion;
        if (this.regions == null) {
            return null;
        }
        synchronized (this) {
            iUploadRegion = this.currentRegionIndex < this.regions.size() ? this.regions.get(this.currentRegionIndex) : null;
        }
        return iUploadRegion;
    }

    public UploadRegionRequestMetrics getCurrentRegionRequestMetrics() {
        return this.currentRegionRequestMetrics;
    }

    public IUploadRegion getTargetRegion() {
        ArrayList<IUploadRegion> arrayList = this.regions;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return this.regions.get(0);
    }

    public abstract String getUpType();

    public void initData() {
        this.currentRegionIndex = 0;
        this.metrics = new UploadTaskMetrics(getUpType());
    }

    public void insertRegionAtFirst(IUploadRegion iUploadRegion) {
        boolean z;
        if (iUploadRegion == null) {
            return;
        }
        Iterator<IUploadRegion> it = this.regions.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (iUploadRegion.isEqual(it.next())) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        this.regions.add(0, iUploadRegion);
    }

    public int prepareToUpload() {
        return !setupRegions() ? -1 : 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.metrics.start();
        this.config.zone.preQuery(this.token, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.BaseUpload.1
            @Override // com.qiniu.android.common.Zone.QueryHandler
            public void complete(int i2, ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics) {
                BaseUpload.this.metrics.setUcQueryMetrics(uploadRegionRequestMetrics);
                if (i2 == 0) {
                    int prepareToUpload = BaseUpload.this.prepareToUpload();
                    if (prepareToUpload == 0) {
                        BaseUpload.this.startToUpload();
                        return;
                    }
                    BaseUpload.this.completeAction(ResponseInfo.errorInfo(prepareToUpload, null), null);
                    return;
                }
                BaseUpload.this.completeAction(responseInfo, responseInfo.response);
            }
        });
    }

    public void startToUpload() {
        UploadRegionRequestMetrics uploadRegionRequestMetrics = new UploadRegionRequestMetrics(getCurrentRegion());
        this.currentRegionRequestMetrics = uploadRegionRequestMetrics;
        uploadRegionRequestMetrics.start();
    }

    public boolean switchRegion() {
        boolean z = false;
        if (this.regions == null) {
            return false;
        }
        synchronized (this) {
            int i2 = this.currentRegionIndex + 1;
            if (i2 < this.regions.size()) {
                this.currentRegionIndex = i2;
                z = true;
            }
        }
        return z;
    }

    public boolean switchRegionAndUpload() {
        UploadRegionRequestMetrics uploadRegionRequestMetrics = this.currentRegionRequestMetrics;
        if (uploadRegionRequestMetrics != null) {
            uploadRegionRequestMetrics.end();
            this.metrics.addMetrics(this.currentRegionRequestMetrics);
            this.currentRegionRequestMetrics = null;
        }
        boolean switchRegion = switchRegion();
        if (switchRegion) {
            startToUpload();
        }
        return switchRegion;
    }

    public boolean switchRegionAndUploadIfNeededWithErrorResponse(ResponseInfo responseInfo) {
        return responseInfo != null && !responseInfo.isOK() && responseInfo.couldRetry() && this.config.allowBackupHost && switchRegionAndUpload();
    }

    public BaseUpload(UploadSource uploadSource, String str, UpToken upToken, UploadOptions uploadOptions, Configuration configuration, Recorder recorder, String str2, UpTaskCompletionHandler upTaskCompletionHandler) {
        this(uploadSource, null, uploadSource.getFileName(), str, upToken, uploadOptions, configuration, recorder, str2, upTaskCompletionHandler);
    }

    public BaseUpload(byte[] bArr, String str, String str2, UpToken upToken, UploadOptions uploadOptions, Configuration configuration, UpTaskCompletionHandler upTaskCompletionHandler) {
        this(null, bArr, str2, str, upToken, uploadOptions, configuration, null, null, upTaskCompletionHandler);
    }
}

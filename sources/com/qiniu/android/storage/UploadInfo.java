package com.qiniu.android.storage;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class UploadInfo {
    public String fileName = null;
    private UploadSource source;
    private String sourceId;
    private long sourceSize;

    public UploadInfo(UploadSource uploadSource) {
        this.sourceSize = -1L;
        this.source = uploadSource;
        this.sourceSize = uploadSource.getSize();
        this.sourceId = uploadSource.getId() != null ? uploadSource.getId() : "";
    }

    public abstract void checkInfoStateAndUpdate();

    public abstract void clearUploadState();

    public void close() {
        this.source.close();
    }

    public boolean couldReloadSource() {
        return this.source.couldReloadSource();
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public long getSourceSize() {
        return this.source.getSize();
    }

    public boolean hasValidResource() {
        return this.source != null;
    }

    public abstract boolean isAllUploaded();

    public boolean isSameUploadInfo(UploadInfo uploadInfo) {
        if (uploadInfo == null || !this.sourceId.equals(uploadInfo.sourceId)) {
            return false;
        }
        long j2 = uploadInfo.sourceSize;
        if (j2 > -1) {
            long j3 = this.sourceSize;
            return j3 <= -1 || j2 == j3;
        }
        return true;
    }

    public boolean isValid() {
        return hasValidResource();
    }

    public byte[] readData(int i2, long j2) throws IOException {
        byte[] readData;
        UploadSource uploadSource = this.source;
        if (uploadSource != null) {
            synchronized (uploadSource) {
                readData = this.source.readData(i2, j2);
            }
            if (readData != null && (readData.length != i2 || readData.length == 0)) {
                this.sourceSize = j2 + readData.length;
            }
            return readData;
        }
        throw new IOException("file is not exist");
    }

    public boolean reloadSource() {
        return this.source.reloadSource();
    }

    public void setInfoFromJson(JSONObject jSONObject) {
        try {
            this.sourceSize = jSONObject.getLong("sourceSize");
            this.sourceId = jSONObject.optString("sourceId");
        } catch (JSONException unused) {
        }
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sourceId", this.sourceId);
            jSONObject.put("sourceSize", getSourceSize());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public abstract long uploadSize();
}

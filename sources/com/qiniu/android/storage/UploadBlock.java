package com.qiniu.android.storage;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UploadBlock {
    public final int index;
    public final long offset;
    public final int size;
    public final List<UploadData> uploadDataList;
    public String md5 = null;
    public String ctx = null;

    public UploadBlock(long j2, int i2, int i3, int i4) {
        this.offset = j2;
        this.size = i2;
        this.index = i4;
        this.uploadDataList = createDataList(i3);
    }

    public static UploadBlock blockFromJson(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        long j2 = jSONObject.getLong("offset");
        int i2 = jSONObject.getInt("size");
        int i3 = jSONObject.getInt("index");
        String optString = jSONObject.optString("md5");
        String optString2 = jSONObject.optString("ctx");
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("uploadDataList");
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            UploadData dataFromJson = UploadData.dataFromJson(jSONArray.getJSONObject(i4));
            if (dataFromJson != null) {
                arrayList.add(dataFromJson);
            }
        }
        UploadBlock uploadBlock = new UploadBlock(j2, i2, i3, arrayList);
        uploadBlock.md5 = optString;
        uploadBlock.ctx = optString2;
        return uploadBlock;
    }

    private ArrayList<UploadData> createDataList(int i2) {
        ArrayList<UploadData> arrayList = new ArrayList<>();
        long j2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = this.size;
            if (j2 >= i4) {
                return arrayList;
            }
            int min = Math.min((int) (i4 - j2), i2);
            arrayList.add(new UploadData(j2, min, i3));
            j2 += min;
            i3++;
        }
    }

    public void checkInfoStateAndUpdate() {
        for (UploadData uploadData : this.uploadDataList) {
            uploadData.checkStateAndUpdate();
        }
    }

    public void clearUploadState() {
        this.md5 = null;
        this.ctx = null;
        List<UploadData> list = this.uploadDataList;
        if (list == null || list.size() == 0) {
            return;
        }
        for (UploadData uploadData : this.uploadDataList) {
            uploadData.clearUploadState();
        }
    }

    public boolean isCompleted() {
        List<UploadData> list = this.uploadDataList;
        if (list == null) {
            return true;
        }
        for (UploadData uploadData : list) {
            if (!uploadData.isUploaded()) {
                return false;
            }
        }
        return true;
    }

    public UploadData nextUploadDataWithoutCheckData() {
        List<UploadData> list = this.uploadDataList;
        if (list == null || list.size() == 0) {
            return null;
        }
        for (UploadData uploadData : this.uploadDataList) {
            if (uploadData.needToUpload()) {
                return uploadData;
            }
        }
        return null;
    }

    public JSONObject toJsonObject() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("offset", Long.valueOf(this.offset));
        jSONObject.putOpt("size", Integer.valueOf(this.size));
        jSONObject.putOpt("index", Integer.valueOf(this.index));
        jSONObject.putOpt("md5", this.md5);
        jSONObject.putOpt("ctx", this.ctx);
        List<UploadData> list = this.uploadDataList;
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (UploadData uploadData : this.uploadDataList) {
                JSONObject jsonObject = uploadData.toJsonObject();
                if (jsonObject != null) {
                    jSONArray.put(jsonObject);
                }
            }
            jSONObject.put("uploadDataList", jSONArray);
        }
        return jSONObject;
    }

    public long uploadSize() {
        List<UploadData> list = this.uploadDataList;
        long j2 = 0;
        if (list == null) {
            return 0L;
        }
        for (UploadData uploadData : list) {
            j2 += uploadData.uploadSize();
        }
        return j2;
    }

    private UploadBlock(long j2, int i2, int i3, List<UploadData> list) {
        this.offset = j2;
        this.size = i2;
        this.index = i3;
        this.uploadDataList = list;
    }
}

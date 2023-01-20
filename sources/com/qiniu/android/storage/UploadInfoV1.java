package com.qiniu.android.storage;

import com.qiniu.android.storage.UploadData;
import com.qiniu.android.utils.BytesUtils;
import com.qiniu.android.utils.ListVector;
import com.qiniu.android.utils.MD5;
import com.qiniu.android.utils.StringUtils;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UploadInfoV1 extends UploadInfo {
    private static final int BlockListCapacityIncrement = 2;
    private static final int BlockSize = 4194304;
    private static final String TypeKey = "infoType";
    private static final String TypeValue = "UploadInfoV1";
    private ListVector<UploadBlock> blockList;
    private final int dataSize;
    private boolean isEOF;
    private IOException readException;

    private UploadInfoV1(UploadSource uploadSource, int i2, ListVector<UploadBlock> listVector) {
        super(uploadSource);
        this.isEOF = false;
        this.readException = null;
        this.dataSize = i2;
        this.blockList = listVector;
    }

    public static UploadInfoV1 infoFromJson(UploadSource uploadSource, JSONObject jSONObject) {
        String optString;
        UploadInfoV1 uploadInfoV1;
        if (jSONObject == null) {
            return null;
        }
        try {
            optString = jSONObject.optString(TypeKey);
            int i2 = jSONObject.getInt("dataSize");
            JSONArray jSONArray = jSONObject.getJSONArray("blockList");
            ListVector listVector = new ListVector(jSONArray.length(), 2);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    UploadBlock blockFromJson = UploadBlock.blockFromJson(jSONArray.getJSONObject(i3));
                    if (blockFromJson != null) {
                        listVector.add(blockFromJson);
                    }
                } catch (Exception unused) {
                }
            }
            uploadInfoV1 = new UploadInfoV1(uploadSource, i2, listVector);
            uploadInfoV1.setInfoFromJson(jSONObject);
        } catch (JSONException unused2) {
        }
        if (TypeValue.equals(optString) && uploadSource.getId().equals(uploadInfoV1.getSourceId())) {
            return uploadInfoV1;
        }
        return null;
    }

    private UploadBlock loadBlockData(UploadBlock uploadBlock) throws IOException {
        String str;
        if (uploadBlock == null) {
            return null;
        }
        UploadData nextUploadDataWithoutCheckData = uploadBlock.nextUploadDataWithoutCheckData();
        if (nextUploadDataWithoutCheckData.getState() != UploadData.State.WaitToUpload || nextUploadDataWithoutCheckData.data == null) {
            try {
                byte[] readData = readData(uploadBlock.size, uploadBlock.offset);
                if (readData == null || readData.length == 0) {
                    return null;
                }
                String encrypt = MD5.encrypt(readData);
                if (readData.length != uploadBlock.size || (str = uploadBlock.md5) == null || !str.equals(encrypt)) {
                    UploadBlock uploadBlock2 = new UploadBlock(uploadBlock.offset, readData.length, this.dataSize, uploadBlock.index);
                    uploadBlock2.md5 = encrypt;
                    uploadBlock = uploadBlock2;
                }
                for (UploadData uploadData : uploadBlock.uploadDataList) {
                    UploadData.State state = uploadData.getState();
                    UploadData.State state2 = UploadData.State.Complete;
                    if (state != state2) {
                        try {
                            uploadData.data = BytesUtils.subBytes(readData, (int) uploadData.offset, uploadData.size);
                            uploadData.updateState(UploadData.State.WaitToUpload);
                        } catch (IOException e2) {
                            throw e2;
                        }
                    } else {
                        uploadData.updateState(state2);
                    }
                }
                return uploadBlock;
            } catch (IOException e3) {
                throw e3;
            }
        }
        return uploadBlock;
    }

    private UploadBlock nextUploadBlockFormBlockList() {
        ListVector<UploadBlock> listVector = this.blockList;
        if (listVector == null || listVector.size() == 0) {
            return null;
        }
        final UploadBlock[] uploadBlockArr = {null};
        this.blockList.enumerateObjects(new ListVector.EnumeratorHandler<UploadBlock>() { // from class: com.qiniu.android.storage.UploadInfoV1.6
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadBlock uploadBlock) {
                if (uploadBlock.nextUploadDataWithoutCheckData() != null) {
                    uploadBlockArr[0] = uploadBlock;
                    return true;
                }
                return false;
            }
        });
        return uploadBlockArr[0];
    }

    public ArrayList<String> allBlocksContexts() {
        ListVector<UploadBlock> listVector = this.blockList;
        if (listVector == null || listVector.size() == 0) {
            return null;
        }
        final ArrayList<String> arrayList = new ArrayList<>();
        this.blockList.enumerateObjects(new ListVector.EnumeratorHandler<UploadBlock>() { // from class: com.qiniu.android.storage.UploadInfoV1.7
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadBlock uploadBlock) {
                String str = uploadBlock.ctx;
                if (StringUtils.isNullOrEmpty(str)) {
                    return false;
                }
                arrayList.add(str);
                return false;
            }
        });
        return arrayList;
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public void checkInfoStateAndUpdate() {
        this.blockList.enumerateObjects(new ListVector.EnumeratorHandler<UploadBlock>() { // from class: com.qiniu.android.storage.UploadInfoV1.4
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadBlock uploadBlock) {
                uploadBlock.checkInfoStateAndUpdate();
                return false;
            }
        });
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public void clearUploadState() {
        ListVector<UploadBlock> listVector = this.blockList;
        if (listVector == null || listVector.size() == 0) {
            return;
        }
        this.blockList.enumerateObjects(new ListVector.EnumeratorHandler<UploadBlock>() { // from class: com.qiniu.android.storage.UploadInfoV1.1
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadBlock uploadBlock) {
                uploadBlock.clearUploadState();
                return false;
            }
        });
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public boolean isAllUploaded() {
        if (this.isEOF) {
            ListVector<UploadBlock> listVector = this.blockList;
            if (listVector == null || listVector.size() == 0) {
                return true;
            }
            final boolean[] zArr = {true};
            this.blockList.enumerateObjects(new ListVector.EnumeratorHandler<UploadBlock>() { // from class: com.qiniu.android.storage.UploadInfoV1.3
                @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
                public boolean enumerate(UploadBlock uploadBlock) {
                    if (uploadBlock.isCompleted()) {
                        return false;
                    }
                    zArr[0] = false;
                    return true;
                }
            });
            return zArr[0];
        }
        return false;
    }

    public boolean isFirstData(UploadData uploadData) {
        return uploadData.index == 0;
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public boolean isSameUploadInfo(UploadInfo uploadInfo) {
        return super.isSameUploadInfo(uploadInfo) && (uploadInfo instanceof UploadInfoV1) && this.dataSize == ((UploadInfoV1) uploadInfo).dataSize;
    }

    public UploadBlock nextUploadBlock() throws IOException {
        UploadBlock nextUploadBlockFormBlockList = nextUploadBlockFormBlockList();
        if (nextUploadBlockFormBlockList == null) {
            if (this.isEOF) {
                return null;
            }
            IOException iOException = this.readException;
            if (iOException == null) {
                long j2 = 0;
                if (this.blockList.size() > 0) {
                    ListVector<UploadBlock> listVector = this.blockList;
                    UploadBlock uploadBlock = listVector.get(listVector.size() - 1);
                    j2 = uploadBlock.offset + uploadBlock.size;
                }
                nextUploadBlockFormBlockList = new UploadBlock(j2, 4194304, this.dataSize, this.blockList.size());
            } else {
                throw iOException;
            }
        }
        try {
            UploadBlock loadBlockData = loadBlockData(nextUploadBlockFormBlockList);
            if (loadBlockData == null) {
                this.isEOF = true;
                int size = this.blockList.size();
                int i2 = nextUploadBlockFormBlockList.index;
                if (size > i2) {
                    this.blockList = this.blockList.subList(0, i2);
                }
            } else {
                if (loadBlockData.index == this.blockList.size()) {
                    this.blockList.add(loadBlockData);
                } else if (loadBlockData != nextUploadBlockFormBlockList) {
                    this.blockList.set(loadBlockData.index, loadBlockData);
                }
                if (loadBlockData.size < 4194304) {
                    this.isEOF = true;
                    int size2 = this.blockList.size();
                    int i3 = nextUploadBlockFormBlockList.index;
                    if (size2 > i3 + 1) {
                        this.blockList = this.blockList.subList(0, i3 + 1);
                    }
                }
            }
            return loadBlockData;
        } catch (IOException e2) {
            this.readException = e2;
            throw e2;
        }
    }

    public UploadData nextUploadData(UploadBlock uploadBlock) throws IOException {
        if (uploadBlock == null) {
            return null;
        }
        return uploadBlock.nextUploadDataWithoutCheckData();
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public boolean reloadSource() {
        this.isEOF = false;
        this.readException = null;
        return super.reloadSource();
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public JSONObject toJsonObject() {
        JSONObject jsonObject = super.toJsonObject();
        if (jsonObject == null) {
            return null;
        }
        try {
            jsonObject.put(TypeKey, TypeValue);
            jsonObject.put("dataSize", this.dataSize);
            ListVector<UploadBlock> listVector = this.blockList;
            if (listVector != null && listVector.size() > 0) {
                final JSONArray jSONArray = new JSONArray();
                this.blockList.enumerateObjects(new ListVector.EnumeratorHandler<UploadBlock>() { // from class: com.qiniu.android.storage.UploadInfoV1.5
                    @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
                    public boolean enumerate(UploadBlock uploadBlock) {
                        try {
                            JSONObject jsonObject2 = uploadBlock.toJsonObject();
                            if (jsonObject2 != null) {
                                jSONArray.put(jsonObject2);
                                return false;
                            }
                            return false;
                        } catch (Exception unused) {
                            return true;
                        }
                    }
                });
                if (jSONArray.length() != this.blockList.size()) {
                    return null;
                }
                jsonObject.put("blockList", jSONArray);
            }
            return jsonObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.qiniu.android.storage.UploadInfo
    public long uploadSize() {
        ListVector<UploadBlock> listVector = this.blockList;
        if (listVector == null || listVector.size() == 0) {
            return 0L;
        }
        final long[] jArr = {0};
        this.blockList.enumerateObjects(new ListVector.EnumeratorHandler<UploadBlock>() { // from class: com.qiniu.android.storage.UploadInfoV1.2
            @Override // com.qiniu.android.utils.ListVector.EnumeratorHandler
            public boolean enumerate(UploadBlock uploadBlock) {
                long[] jArr2 = jArr;
                jArr2[0] = jArr2[0] + uploadBlock.uploadSize();
                return false;
            }
        });
        return jArr[0];
    }

    public UploadInfoV1(UploadSource uploadSource, Configuration configuration) {
        super(uploadSource);
        int i2;
        this.isEOF = false;
        this.readException = null;
        if (!configuration.useConcurrentResumeUpload && (i2 = configuration.chunkSize) <= 4194304) {
            this.dataSize = i2;
        } else {
            this.dataSize = 4194304;
        }
        this.blockList = new ListVector<>(2, 2);
    }
}

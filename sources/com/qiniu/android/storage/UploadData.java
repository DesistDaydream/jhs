package com.qiniu.android.storage;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UploadData {
    public byte[] data;
    public String etag;
    public final int index;
    public String md5;
    public final long offset;
    public final int size;
    private State state = State.NeedToCheck;
    private long uploadSize;

    /* renamed from: com.qiniu.android.storage.UploadData$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$qiniu$android$storage$UploadData$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$com$qiniu$android$storage$UploadData$State = iArr;
            try {
                iArr[State.NeedToCheck.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$qiniu$android$storage$UploadData$State[State.WaitToUpload.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$qiniu$android$storage$UploadData$State[State.Uploading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$qiniu$android$storage$UploadData$State[State.Complete.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum State {
        NeedToCheck,
        WaitToUpload,
        Uploading,
        Complete;

        /* JADX INFO: Access modifiers changed from: private */
        public int intValue() {
            return ordinal();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static State state(int i2) {
            State[] values = values();
            if (i2 >= 0 && i2 < values.length) {
                return values[i2];
            }
            return NeedToCheck;
        }
    }

    public UploadData(long j2, int i2, int i3) {
        this.uploadSize = 0L;
        this.offset = j2;
        this.size = i2;
        this.index = i3;
        this.uploadSize = 0L;
    }

    public static UploadData dataFromJson(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        long j2 = jSONObject.getLong("offset");
        int i2 = jSONObject.getInt("size");
        int i3 = jSONObject.getInt("index");
        String optString = jSONObject.optString("etag");
        State state = State.state(jSONObject.getInt("state"));
        String optString2 = jSONObject.optString("md5");
        UploadData uploadData = new UploadData(j2, i2, i3);
        uploadData.etag = optString;
        uploadData.md5 = optString2;
        uploadData.state = state;
        uploadData.uploadSize = 0L;
        return uploadData;
    }

    public void checkStateAndUpdate() {
        State state = this.state;
        if ((state == State.WaitToUpload || state == State.Uploading) && this.data == null) {
            this.state = State.NeedToCheck;
        }
    }

    public void clearUploadState() {
        this.etag = null;
        this.md5 = null;
        this.state = State.NeedToCheck;
    }

    public State getState() {
        return this.state;
    }

    public boolean isUploaded() {
        return this.state == State.Complete;
    }

    public boolean needToUpload() {
        int i2 = AnonymousClass1.$SwitchMap$com$qiniu$android$storage$UploadData$State[this.state.ordinal()];
        return i2 == 1 || i2 == 2;
    }

    public void setUploadSize(long j2) {
        this.uploadSize = j2;
    }

    public JSONObject toJsonObject() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("offset", Long.valueOf(this.offset));
        jSONObject.putOpt("size", Integer.valueOf(this.size));
        jSONObject.putOpt("index", Integer.valueOf(this.index));
        jSONObject.putOpt("etag", this.etag);
        jSONObject.putOpt("md5", this.md5);
        jSONObject.putOpt("state", Integer.valueOf(this.state.intValue()));
        return jSONObject;
    }

    public void updateState(State state) {
        int i2 = AnonymousClass1.$SwitchMap$com$qiniu$android$storage$UploadData$State[state.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            this.uploadSize = 0L;
            this.etag = null;
        } else if (i2 == 4) {
            this.data = null;
        }
        this.state = state;
    }

    public long uploadSize() {
        return this.state == State.Complete ? this.size : this.uploadSize;
    }
}

package com.tencent.qcloud.tuikit.tuiconversation.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class DraftInfo implements Serializable {
    private String draftText;
    private long draftTime;

    public String getDraftText() {
        return this.draftText;
    }

    public long getDraftTime() {
        return this.draftTime;
    }

    public void setDraftText(String str) {
        this.draftText = str;
    }

    public void setDraftTime(long j2) {
        this.draftTime = j2;
    }

    public String toString() {
        return "DraftInfo{draftText='" + this.draftText + "', draftTime=" + this.draftTime + '}';
    }
}

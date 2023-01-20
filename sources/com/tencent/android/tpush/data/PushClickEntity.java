package com.tencent.android.tpush.data;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class PushClickEntity implements Serializable {
    private static final long serialVersionUID = -166678396447407161L;
    public long accessId;
    public int action;
    public long broadcastId;
    public long clickTime;
    public String groupId;
    public long msgId;
    public String pkgName;
    public long timestamp;
    public long type;

    public PushClickEntity() {
        this.msgId = 0L;
        this.accessId = 0L;
        this.broadcastId = 0L;
        this.timestamp = 0L;
        this.pkgName = "";
        this.type = 1L;
        this.clickTime = 0L;
        this.action = 0;
        this.groupId = "";
    }

    public PushClickEntity(long j2, long j3, long j4, long j5, String str, long j6, long j7, int i2, String str2) {
        this.msgId = 0L;
        this.accessId = 0L;
        this.broadcastId = 0L;
        this.timestamp = 0L;
        this.pkgName = "";
        this.type = 1L;
        this.clickTime = 0L;
        this.action = 0;
        this.groupId = "";
        this.msgId = j2;
        this.accessId = j3;
        this.broadcastId = j4;
        this.timestamp = j5;
        this.pkgName = str;
        this.type = j6;
        this.clickTime = j7;
        this.action = i2;
        this.groupId = str2;
    }
}

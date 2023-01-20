package com.moor.imkf.model.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "msgunreadcount")
/* loaded from: classes2.dex */
public class MsgUnReadCount {
    @DatabaseField
    public int msgUnReadCount;
    @DatabaseField(id = true, unique = true)
    public String sessionId;
}

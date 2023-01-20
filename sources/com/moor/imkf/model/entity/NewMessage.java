package com.moor.imkf.model.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "newMessage")
/* loaded from: classes2.dex */
public class NewMessage {
    @DatabaseField
    public String _id;
    @DatabaseField
    public String from;
    @DatabaseField
    public String fromName;
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    public String img;
    @DatabaseField
    public String message;
    @DatabaseField
    public String msgType;
    @DatabaseField
    public String sessionId;
    @DatabaseField
    public Long time;
    @DatabaseField
    public String type;
    @DatabaseField
    public int unReadCount;
}

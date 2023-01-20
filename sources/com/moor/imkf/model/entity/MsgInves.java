package com.moor.imkf.model.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "msginves")
/* loaded from: classes2.dex */
public class MsgInves {
    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField(canBeNull = true, foreign = true, foreignAutoRefresh = true)
    public FromToMessage msg;
    @DatabaseField
    public String name;
    @DatabaseField
    public String value;
}

package com.moor.imkf.model.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "info")
/* loaded from: classes2.dex */
public class Info {
    @DatabaseField(generatedId = true)
    public int _id;
    @DatabaseField
    public String accessId;
    @DatabaseField
    public String connectionId;
    @DatabaseField
    public String imServiceNo;
    @DatabaseField
    public String loginName;
    @DatabaseField
    public String peedId;
    @DatabaseField
    public String userId;
}

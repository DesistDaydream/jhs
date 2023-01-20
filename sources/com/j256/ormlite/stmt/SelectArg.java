package com.j256.ormlite.stmt;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes2.dex */
public class SelectArg extends BaseArgumentHolder {
    private boolean hasBeenSet;
    private Object value;

    public SelectArg() {
        this.hasBeenSet = false;
        this.value = null;
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder
    public Object getValue() {
        return this.value;
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder
    public boolean isValueSet() {
        return this.hasBeenSet;
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder, com.j256.ormlite.stmt.ArgumentHolder
    public void setValue(Object obj) {
        this.hasBeenSet = true;
        this.value = obj;
    }

    public SelectArg(String str, Object obj) {
        super(str);
        this.hasBeenSet = false;
        this.value = null;
        setValue(obj);
    }

    public SelectArg(SqlType sqlType, Object obj) {
        super(sqlType);
        this.hasBeenSet = false;
        this.value = null;
        setValue(obj);
    }

    public SelectArg(SqlType sqlType) {
        super(sqlType);
        this.hasBeenSet = false;
        this.value = null;
    }

    public SelectArg(Object obj) {
        this.hasBeenSet = false;
        this.value = null;
        setValue(obj);
    }
}

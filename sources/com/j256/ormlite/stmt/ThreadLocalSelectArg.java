package com.j256.ormlite.stmt;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes2.dex */
public class ThreadLocalSelectArg extends BaseArgumentHolder {
    private ThreadLocal<ValueWrapper> threadValue;

    /* loaded from: classes2.dex */
    public static class ValueWrapper {
        public Object value;

        public ValueWrapper(Object obj) {
            this.value = obj;
        }
    }

    public ThreadLocalSelectArg() {
        this.threadValue = new ThreadLocal<>();
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder
    public Object getValue() {
        ValueWrapper valueWrapper = this.threadValue.get();
        if (valueWrapper == null) {
            return null;
        }
        return valueWrapper.value;
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder
    public boolean isValueSet() {
        return this.threadValue.get() != null;
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder, com.j256.ormlite.stmt.ArgumentHolder
    public void setValue(Object obj) {
        this.threadValue.set(new ValueWrapper(obj));
    }

    public ThreadLocalSelectArg(String str, Object obj) {
        super(str);
        this.threadValue = new ThreadLocal<>();
        setValue(obj);
    }

    public ThreadLocalSelectArg(SqlType sqlType, Object obj) {
        super(sqlType);
        this.threadValue = new ThreadLocal<>();
        setValue(obj);
    }

    public ThreadLocalSelectArg(Object obj) {
        this.threadValue = new ThreadLocal<>();
        setValue(obj);
    }
}

package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

/* loaded from: classes2.dex */
public class BaseException extends Exception {
    public final int a;
    public final ErrorEnum b;

    public BaseException(int i2) {
        ErrorEnum fromCode = ErrorEnum.fromCode(i2);
        this.b = fromCode;
        this.a = fromCode.getExternalCode();
    }

    public int getErrorCode() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b.getMessage();
    }
}

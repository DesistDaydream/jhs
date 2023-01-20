package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class j implements Callable<AAIDResult> {
    public Context a;

    public j(Context context) {
        this.a = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public AAIDResult call() throws Exception {
        Context context = this.a;
        if (context != null) {
            String c2 = o.c(context);
            AAIDResult aAIDResult = new AAIDResult();
            aAIDResult.setId(c2);
            return aAIDResult;
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}

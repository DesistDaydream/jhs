package com.moor.imkf.lib.http.log;

import com.moor.imkf.lib.http.log.MoorHttpLoggingInterceptor;
import com.moor.imkf.lib.http.utils.MoorNetJsonUtil;
import com.moor.imkf.lib.http.utils.MoorNetLogUtil;

/* loaded from: classes2.dex */
public class MoorHttpLogger implements MoorHttpLoggingInterceptor.Logger {
    private final StringBuilder mMessage = new StringBuilder();

    @Override // com.moor.imkf.lib.http.log.MoorHttpLoggingInterceptor.Logger
    public void log(String str) {
        if (str.startsWith("--> POST")) {
            this.mMessage.setLength(0);
        }
        if ((str.startsWith("{") && str.endsWith("}")) || (str.startsWith("[") && str.endsWith("]"))) {
            str = MoorNetJsonUtil.formatJson(str);
        }
        this.mMessage.append(str.concat("\n"));
        if (str.startsWith("<--------- END HTTP")) {
            MoorNetLogUtil.d(this.mMessage.toString());
        }
    }
}

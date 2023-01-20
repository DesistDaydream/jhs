package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class IntentCallable implements Callable<Void> {
    public Context a;
    public Intent b;

    /* renamed from: c  reason: collision with root package name */
    public String f3676c;

    public IntentCallable(Context context, Intent intent, String str) {
        this.a = context;
        this.b = intent;
        this.f3676c = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.a.sendBroadcast(this.b);
        PushBiUtil.reportExit(this.a, PushNaming.SET_NOTIFY_FLAG, this.f3676c, ErrorEnum.SUCCESS);
        return null;
    }
}

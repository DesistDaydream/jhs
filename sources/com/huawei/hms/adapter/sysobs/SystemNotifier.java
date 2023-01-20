package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

/* loaded from: classes2.dex */
public interface SystemNotifier {
    void notifyNoticeObservers(int i2);

    void notifyObservers(int i2);

    void notifyObservers(Intent intent, String str);

    void registerObserver(SystemObserver systemObserver);

    void unRegisterObserver(SystemObserver systemObserver);
}

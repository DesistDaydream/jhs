package com.huawei.agconnect.core;

import android.content.Context;
import java.util.List;

/* loaded from: classes2.dex */
public interface ServiceRegistrar {
    List<Service> getServices(Context context);

    void initialize(Context context);
}

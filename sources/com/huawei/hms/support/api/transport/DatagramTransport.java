package com.huawei.hms.support.api.transport;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;

/* loaded from: classes2.dex */
public interface DatagramTransport {

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i2, IMessageEntity iMessageEntity);
    }

    void post(ApiClient apiClient, a aVar);

    void send(ApiClient apiClient, a aVar);
}

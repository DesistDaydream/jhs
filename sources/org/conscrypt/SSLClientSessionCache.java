package org.conscrypt;

import javax.net.ssl.SSLSession;

/* loaded from: classes4.dex */
public interface SSLClientSessionCache {
    byte[] getSessionData(String str, int i2);

    void putSessionData(SSLSession sSLSession, byte[] bArr);
}

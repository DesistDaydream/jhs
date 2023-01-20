package com.qiniu.android.http.dns;

import java.net.UnknownHostException;
import java.util.List;

/* loaded from: classes3.dex */
public interface Dns {
    List<IDnsNetworkAddress> lookup(String str) throws UnknownHostException;
}

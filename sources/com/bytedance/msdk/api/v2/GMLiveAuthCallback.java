package com.bytedance.msdk.api.v2;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface GMLiveAuthCallback extends Serializable {
    void onAuth(GMLiveToken gMLiveToken);

    void onFailed(Throwable th);
}

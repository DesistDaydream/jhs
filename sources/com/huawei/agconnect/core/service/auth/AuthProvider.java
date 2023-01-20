package com.huawei.agconnect.core.service.auth;

import e.k.b.a.k;

/* loaded from: classes2.dex */
public interface AuthProvider {
    void addTokenListener(OnTokenListener onTokenListener);

    k<Token> getTokens();

    k<Token> getTokens(boolean z);

    String getUid();

    void removeTokenListener(OnTokenListener onTokenListener);
}

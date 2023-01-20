package com.huawei.agconnect.core.service.auth;

import e.k.b.a.k;

/* loaded from: classes2.dex */
public interface CredentialsProvider {
    k<Token> getTokens();

    k<Token> getTokens(boolean z);
}

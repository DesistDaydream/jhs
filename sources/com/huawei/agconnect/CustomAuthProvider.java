package com.huawei.agconnect;

import com.huawei.agconnect.core.service.auth.Token;
import e.k.b.a.k;

/* loaded from: classes2.dex */
public interface CustomAuthProvider {
    k<Token> getTokens(boolean z);

    String getUid();
}

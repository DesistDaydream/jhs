package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.ak;
import com.baidu.mobads.sdk.internal.c;
import com.baidu.mobads.sdk.internal.d;
import com.baidu.mobads.sdk.internal.q;
import dalvik.system.DexClassLoader;

@Route(path = c.a.a)
/* loaded from: classes.dex */
public class AdservRemoteLoaderImpl implements q {
    @Override // com.baidu.mobads.sdk.internal.q
    public void startLoadRemotePhp(double d2, ak.b bVar) {
        d.a().a(d2, bVar);
    }

    @Override // com.baidu.mobads.sdk.internal.q
    public DexClassLoader getClassLoaderFromJar(String str, String str2, String str3, ClassLoader classLoader) {
        return d.a().a(str, str2, str3, classLoader);
    }
}

package com.qiniu.android.storage;

import java.io.File;

/* loaded from: classes3.dex */
public interface KeyGenerator {
    @Deprecated
    String gen(String str, File file);

    String gen(String str, String str2);
}

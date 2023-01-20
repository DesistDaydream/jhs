package com.xiaomi.push;

import java.io.File;
import java.io.FileFilter;

/* loaded from: classes3.dex */
public final class d implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.isDirectory();
    }
}

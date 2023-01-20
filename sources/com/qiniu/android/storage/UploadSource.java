package com.qiniu.android.storage;

import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class UploadSource {
    public static final long UnknownSourceSize = -1;

    public abstract void close();

    public abstract boolean couldReloadSource();

    public abstract String getFileName();

    public abstract String getId();

    public abstract long getSize();

    public abstract String getSourceType();

    public abstract byte[] readData(int i2, long j2) throws IOException;

    public abstract boolean reloadSource();
}

package com.qiniu.android.storage;

import com.qiniu.android.utils.StringUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class UploadSourceStream extends UploadSource {
    private String fileName;
    private String id;
    private InputStream inputStream;
    private long readOffset = 0;
    private boolean hasSize = false;
    private long size = -1;

    public UploadSourceStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public void close() {
    }

    @Override // com.qiniu.android.storage.UploadSource
    public boolean couldReloadSource() {
        return false;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public String getFileName() {
        return this.fileName;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public String getId() {
        return !StringUtils.isNullOrEmpty(this.id) ? this.id : this.fileName;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public long getSize() {
        long j2 = this.size;
        if (j2 > -1) {
            return j2;
        }
        return -1L;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public String getSourceType() {
        return this.hasSize ? "Stream:HasSize" : "Stream:NoSize";
    }

    @Override // com.qiniu.android.storage.UploadSource
    public byte[] readData(int i2, long j2) throws IOException {
        byte[] bArr;
        boolean z;
        if (this.inputStream != null) {
            synchronized (this) {
                while (true) {
                    long j3 = this.readOffset;
                    if (j3 == j2) {
                        bArr = new byte[i2];
                        int i3 = 0;
                        while (true) {
                            if (i3 >= i2) {
                                z = false;
                                break;
                            }
                            int read = this.inputStream.read(bArr, i3, i2 - i3);
                            if (read < 0) {
                                z = true;
                                break;
                            }
                            i3 += read;
                        }
                        if (i3 < i2) {
                            byte[] bArr2 = new byte[i3];
                            System.arraycopy(bArr, 0, bArr2, 0, i3);
                            bArr = bArr2;
                        }
                        long j4 = this.readOffset + i3;
                        this.readOffset = j4;
                        if (z) {
                            this.size = j4;
                        }
                    } else if (j3 < j2) {
                        this.readOffset = j3 + this.inputStream.skip(j2 - j3);
                    } else {
                        throw new IOException("read stream data error");
                    }
                }
            }
            return bArr;
        }
        throw new IOException("inputStream is empty");
    }

    @Override // com.qiniu.android.storage.UploadSource
    public boolean reloadSource() {
        this.readOffset = 0L;
        return false;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setSize(long j2) {
        this.hasSize = j2 > 0;
        this.size = j2;
    }
}

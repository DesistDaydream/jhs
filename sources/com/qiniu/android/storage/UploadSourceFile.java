package com.qiniu.android.storage;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes3.dex */
public class UploadSourceFile extends UploadSource {
    private final File file;
    private final RandomAccessFile randomAccessFile;
    private Exception readException;

    public UploadSourceFile(File file) {
        RandomAccessFile randomAccessFile = null;
        this.readException = null;
        this.file = file;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Exception e2) {
            this.readException = e2;
        }
        this.randomAccessFile = randomAccessFile;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public void close() {
        RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile != null) {
            try {
                try {
                    randomAccessFile.close();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                this.randomAccessFile.close();
            }
        }
    }

    @Override // com.qiniu.android.storage.UploadSource
    public boolean couldReloadSource() {
        return this.randomAccessFile != null;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public String getFileName() {
        return this.file.getName();
    }

    @Override // com.qiniu.android.storage.UploadSource
    public String getId() {
        return getFileName() + "_" + this.file.lastModified();
    }

    @Override // com.qiniu.android.storage.UploadSource
    public long getSize() {
        return this.file.length();
    }

    @Override // com.qiniu.android.storage.UploadSource
    public String getSourceType() {
        return "File";
    }

    @Override // com.qiniu.android.storage.UploadSource
    public byte[] readData(int i2, long j2) throws IOException {
        RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile == null) {
            if (this.readException != null) {
                throw new IOException(this.readException);
            }
            throw new IOException("file is invalid");
        }
        byte[] bArr = new byte[i2];
        try {
            randomAccessFile.seek(j2);
            int i3 = 0;
            while (i3 < i2) {
                int read = this.randomAccessFile.read(bArr, i3, i2 - i3);
                if (read < 0) {
                    break;
                }
                i3 += read;
            }
            if (i3 < i2) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, 0, bArr2, 0, i3);
                return bArr2;
            }
            return bArr;
        } catch (IOException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    @Override // com.qiniu.android.storage.UploadSource
    public boolean reloadSource() {
        return true;
    }
}

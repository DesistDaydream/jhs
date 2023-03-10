package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.f;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes3.dex */
public class e implements Closeable {
    private BufferedOutputStream a;
    private FileDescriptor b;

    /* renamed from: c  reason: collision with root package name */
    private RandomAccessFile f5839c;

    public e(File file, int i2) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f5839c = randomAccessFile;
            this.b = randomAccessFile.getFD();
            if (i2 > 0) {
                if (i2 < 8192) {
                    i2 = 8192;
                } else if (i2 > 131072) {
                    i2 = 131072;
                }
                this.a = new BufferedOutputStream(new FileOutputStream(this.f5839c.getFD()), i2);
                return;
            }
            this.a = new BufferedOutputStream(new FileOutputStream(this.f5839c.getFD()));
        } catch (IOException e2) {
            throw new BaseException(1039, e2);
        }
    }

    public void a(byte[] bArr, int i2, int i3) throws IOException {
        this.a.write(bArr, i2, i3);
    }

    public void b() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.a;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void c() throws IOException {
        FileDescriptor fileDescriptor = this.b;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        f.a(this.f5839c, this.a);
    }

    public void a() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.a;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.b;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void b(long j2) throws IOException {
        this.f5839c.setLength(j2);
    }

    public void a(long j2) throws IOException {
        this.f5839c.seek(j2);
    }
}

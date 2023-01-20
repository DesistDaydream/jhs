package com.bytedance.pangle.util;

import com.caverock.androidsvg.SVG;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public final class n {

    /* loaded from: classes.dex */
    public static class a {
        public long a;
        public long b;
    }

    public static long a(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return a(randomAccessFile, a(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }

    private static a a(RandomAccessFile randomAccessFile) {
        long length = randomAccessFile.length() - 22;
        if (length >= 0) {
            long j2 = length - SVG.D;
            long j3 = j2 >= 0 ? j2 : 0L;
            int reverseBytes = Integer.reverseBytes(101010256);
            do {
                randomAccessFile.seek(length);
                if (randomAccessFile.readInt() == reverseBytes) {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    a aVar = new a();
                    aVar.b = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                    aVar.a = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                    return aVar;
                }
                length--;
            } while (length >= j3);
            throw new ZipException("End Of Central Directory signature not found");
        }
        throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
    }

    private static long a(RandomAccessFile randomAccessFile, a aVar) {
        CRC32 crc32 = new CRC32();
        long j2 = aVar.b;
        randomAccessFile.seek(aVar.a);
        int min = (int) Math.min(16384L, j2);
        byte[] bArr = new byte[16384];
        while (true) {
            int read = randomAccessFile.read(bArr, 0, min);
            if (read == -1) {
                break;
            }
            crc32.update(bArr, 0, read);
            j2 -= read;
            if (j2 == 0) {
                break;
            }
            min = (int) Math.min(16384L, j2);
        }
        return crc32.getValue();
    }
}

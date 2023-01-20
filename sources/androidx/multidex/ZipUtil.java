package androidx.multidex;

import com.caverock.androidsvg.SVG;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public final class ZipUtil {
    private static final int BUFFER_SIZE = 16384;
    private static final int ENDHDR = 22;
    private static final int ENDSIG = 101010256;

    /* loaded from: classes.dex */
    public static class CentralDirectory {
        public long offset;
        public long size;
    }

    public static long computeCrcOfCentralDir(RandomAccessFile randomAccessFile, CentralDirectory centralDirectory) throws IOException {
        CRC32 crc32 = new CRC32();
        long j2 = centralDirectory.size;
        randomAccessFile.seek(centralDirectory.offset);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j2));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j2 -= read;
            if (j2 == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j2));
        }
        return crc32.getValue();
    }

    public static CentralDirectory findCentralDirectory(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long length = randomAccessFile.length() - 22;
        if (length >= 0) {
            long j2 = length - SVG.D;
            long j3 = j2 >= 0 ? j2 : 0L;
            int reverseBytes = Integer.reverseBytes(ENDSIG);
            do {
                randomAccessFile.seek(length);
                if (randomAccessFile.readInt() == reverseBytes) {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    CentralDirectory centralDirectory = new CentralDirectory();
                    centralDirectory.size = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                    centralDirectory.offset = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                    return centralDirectory;
                }
                length--;
            } while (length >= j3);
            throw new ZipException("End Of Central Directory signature not found");
        }
        throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
    }

    public static long getZipCrc(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return computeCrcOfCentralDir(randomAccessFile, findCentralDirectory(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }
}

package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import e.b.a.v.l;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {
    private static final String b = "DfltImageHeaderParser";

    /* renamed from: c  reason: collision with root package name */
    private static final int f1702c = 4671814;

    /* renamed from: d  reason: collision with root package name */
    private static final int f1703d = -1991225785;

    /* renamed from: e  reason: collision with root package name */
    public static final int f1704e = 65496;

    /* renamed from: f  reason: collision with root package name */
    private static final int f1705f = 19789;

    /* renamed from: g  reason: collision with root package name */
    private static final int f1706g = 18761;

    /* renamed from: j  reason: collision with root package name */
    private static final int f1709j = 218;

    /* renamed from: k  reason: collision with root package name */
    private static final int f1710k = 217;

    /* renamed from: l  reason: collision with root package name */
    public static final int f1711l = 255;

    /* renamed from: m  reason: collision with root package name */
    public static final int f1712m = 225;
    private static final int n = 274;
    private static final int p = 1380533830;
    private static final int q = 1464156752;
    private static final int r = 1448097792;
    private static final int s = -256;
    private static final int t = 255;
    private static final int u = 88;
    private static final int v = 76;
    private static final int w = 16;
    private static final int x = 8;

    /* renamed from: h  reason: collision with root package name */
    private static final String f1707h = "Exif\u0000\u0000";

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f1708i = f1707h.getBytes(Charset.forName("UTF-8"));
    private static final int[] o = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* loaded from: classes.dex */
    public interface Reader {

        /* loaded from: classes.dex */
        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            public EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i2) throws IOException;

        long skip(long j2) throws IOException;
    }

    /* loaded from: classes.dex */
    public static final class a implements Reader {
        private final ByteBuffer a;

        public a(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws Reader.EndOfFileException {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws Reader.EndOfFileException {
            if (this.a.remaining() >= 1) {
                return (short) (this.a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i2) {
            int min = Math.min(i2, this.a.remaining());
            if (min == 0) {
                return -1;
            }
            this.a.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j2) {
            int min = (int) Math.min(this.a.remaining(), j2);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private final ByteBuffer a;

        public b(byte[] bArr, int i2) {
            this.a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        private boolean c(int i2, int i3) {
            return this.a.remaining() - i2 >= i3;
        }

        public short a(int i2) {
            if (c(i2, 2)) {
                return this.a.getShort(i2);
            }
            return (short) -1;
        }

        public int b(int i2) {
            if (c(i2, 4)) {
                return this.a.getInt(i2);
            }
            return -1;
        }

        public int d() {
            return this.a.remaining();
        }

        public void e(ByteOrder byteOrder) {
            this.a.order(byteOrder);
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements Reader {
        private final InputStream a;

        public c(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws IOException {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws IOException {
            int read = this.a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i2) throws IOException {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2 && (i4 = this.a.read(bArr, i3, i2 - i3)) != -1) {
                i3 += i4;
            }
            if (i3 == 0 && i4 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i3;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j2) throws IOException {
            if (j2 < 0) {
                return 0L;
            }
            long j3 = j2;
            while (j3 > 0) {
                long skip = this.a.skip(j3);
                if (skip <= 0) {
                    if (this.a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j3 -= skip;
            }
            return j2 - j3;
        }
    }

    private static int c(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    private int d(Reader reader, e.b.a.p.k.x.b bVar) throws IOException {
        try {
            int uInt16 = reader.getUInt16();
            if (!e(uInt16)) {
                if (Log.isLoggable(b, 3)) {
                    Log.d(b, "Parser doesn't handle magic number: " + uInt16);
                }
                return -1;
            }
            int g2 = g(reader);
            if (g2 == -1) {
                if (Log.isLoggable(b, 3)) {
                    Log.d(b, "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) bVar.c(g2, byte[].class);
            int i2 = i(reader, bArr, g2);
            bVar.e(bArr);
            return i2;
        } catch (Reader.EndOfFileException unused) {
            return -1;
        }
    }

    private static boolean e(int i2) {
        return (i2 & f1704e) == 65496 || i2 == f1705f || i2 == f1706g;
    }

    private boolean f(byte[] bArr, int i2) {
        boolean z = bArr != null && i2 > f1708i.length;
        if (z) {
            int i3 = 0;
            while (true) {
                byte[] bArr2 = f1708i;
                if (i3 >= bArr2.length) {
                    break;
                } else if (bArr[i3] != bArr2[i3]) {
                    return false;
                } else {
                    i3++;
                }
            }
        }
        return z;
    }

    private int g(Reader reader) throws IOException {
        short uInt8;
        short uInt82;
        int uInt16;
        long j2;
        long skip;
        do {
            if (reader.getUInt8() != 255) {
                if (Log.isLoggable(b, 3)) {
                    Log.d(b, "Unknown segmentId=" + ((int) uInt8));
                }
                return -1;
            }
            uInt82 = reader.getUInt8();
            if (uInt82 == f1709j) {
                return -1;
            }
            if (uInt82 == f1710k) {
                if (Log.isLoggable(b, 3)) {
                    Log.d(b, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            uInt16 = reader.getUInt16() - 2;
            if (uInt82 == 225) {
                return uInt16;
            }
            j2 = uInt16;
            skip = reader.skip(j2);
        } while (skip == j2);
        if (Log.isLoggable(b, 3)) {
            Log.d(b, "Unable to skip enough data, type: " + ((int) uInt82) + ", wanted to skip: " + uInt16 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    private static int h(b bVar) {
        ByteOrder byteOrder;
        short a2 = bVar.a(6);
        if (a2 == f1706g) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (a2 != f1705f) {
            if (Log.isLoggable(b, 3)) {
                Log.d(b, "Unknown endianness = " + ((int) a2));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.e(byteOrder);
        int b2 = bVar.b(10) + 6;
        short a3 = bVar.a(b2);
        for (int i2 = 0; i2 < a3; i2++) {
            int c2 = c(b2, i2);
            short a4 = bVar.a(c2);
            if (a4 == 274) {
                short a5 = bVar.a(c2 + 2);
                if (a5 >= 1 && a5 <= 12) {
                    int b3 = bVar.b(c2 + 4);
                    if (b3 < 0) {
                        if (Log.isLoggable(b, 3)) {
                            Log.d(b, "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable(b, 3)) {
                            Log.d(b, "Got tagIndex=" + i2 + " tagType=" + ((int) a4) + " formatCode=" + ((int) a5) + " componentCount=" + b3);
                        }
                        int i3 = b3 + o[a5];
                        if (i3 > 4) {
                            if (Log.isLoggable(b, 3)) {
                                Log.d(b, "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) a5));
                            }
                        } else {
                            int i4 = c2 + 8;
                            if (i4 >= 0 && i4 <= bVar.d()) {
                                if (i3 >= 0 && i3 + i4 <= bVar.d()) {
                                    return bVar.a(i4);
                                }
                                if (Log.isLoggable(b, 3)) {
                                    Log.d(b, "Illegal number of bytes for TI tag data tagType=" + ((int) a4));
                                }
                            } else if (Log.isLoggable(b, 3)) {
                                Log.d(b, "Illegal tagValueOffset=" + i4 + " tagType=" + ((int) a4));
                            }
                        }
                    }
                } else if (Log.isLoggable(b, 3)) {
                    Log.d(b, "Got invalid format code = " + ((int) a5));
                }
            }
        }
        return -1;
    }

    private int i(Reader reader, byte[] bArr, int i2) throws IOException {
        int read = reader.read(bArr, i2);
        if (read != i2) {
            if (Log.isLoggable(b, 3)) {
                Log.d(b, "Unable to read exif segment data, length: " + i2 + ", actually read: " + read);
            }
            return -1;
        } else if (f(bArr, i2)) {
            return h(new b(bArr, i2));
        } else {
            if (Log.isLoggable(b, 3)) {
                Log.d(b, "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(@NonNull ByteBuffer byteBuffer, @NonNull e.b.a.p.k.x.b bVar) throws IOException {
        return d(new a((ByteBuffer) l.d(byteBuffer)), (e.b.a.p.k.x.b) l.d(bVar));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int b(@NonNull InputStream inputStream, @NonNull e.b.a.p.k.x.b bVar) throws IOException {
        return d(new c((InputStream) l.d(inputStream)), (e.b.a.p.k.x.b) l.d(bVar));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream inputStream) throws IOException {
        return getType(new c((InputStream) l.d(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException {
        return getType(new a((ByteBuffer) l.d(byteBuffer)));
    }

    @NonNull
    private ImageHeaderParser.ImageType getType(Reader reader) throws IOException {
        try {
            int uInt16 = reader.getUInt16();
            if (uInt16 == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int uInt8 = (uInt16 << 8) | reader.getUInt8();
            if (uInt8 == f1702c) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int uInt82 = (uInt8 << 8) | reader.getUInt8();
            if (uInt82 == f1703d) {
                reader.skip(21L);
                try {
                    return reader.getUInt8() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            } else if (uInt82 != p) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            } else {
                reader.skip(4L);
                if (((reader.getUInt16() << 16) | reader.getUInt16()) != q) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int uInt162 = (reader.getUInt16() << 16) | reader.getUInt16();
                if ((uInt162 & (-256)) != r) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int i2 = uInt162 & 255;
                if (i2 == 88) {
                    reader.skip(4L);
                    return (reader.getUInt8() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                } else if (i2 == 76) {
                    reader.skip(4L);
                    return (reader.getUInt8() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                } else {
                    return ImageHeaderParser.ImageType.WEBP;
                }
            }
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }
}

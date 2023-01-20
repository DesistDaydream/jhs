package com.m7.imkfsdk.utils;

import android.graphics.Bitmap;
import androidx.core.view.ViewCompat;
import java.io.InputStream;
import java.util.Vector;

/* loaded from: classes2.dex */
public class GifDecoder {
    public static final int MaxStackSize = 4096;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public int[] act;
    public int bgColor;
    public int bgIndex;
    public int frameCount;
    public Vector<GifFrame> frames;
    public int[] gct;
    public boolean gctFlag;
    public int gctSize;
    public int height;
    public int ih;
    public Bitmap image;
    public InputStream in;
    public boolean interlace;
    public int iw;
    public int ix;
    public int iy;
    public int lastBgColor;
    public Bitmap lastImage;
    public int[] lct;
    public boolean lctFlag;
    public int lctSize;
    public int lrh;
    public int lrw;
    public int lrx;
    public int lry;
    public int pixelAspect;
    public byte[] pixelStack;
    public byte[] pixels;
    public short[] prefix;
    public int status;
    public byte[] suffix;
    public int transIndex;
    public int width;
    public int loopCount = 1;
    public int frameindex = 0;
    public byte[] block = new byte[256];
    public int blockSize = 0;
    public int dispose = 0;
    public int lastDispose = 0;
    public boolean transparency = false;
    public int delay = 0;

    /* loaded from: classes2.dex */
    public class GifFrame {
        public int delay;
        public Bitmap image;

        public GifFrame(Bitmap bitmap, int i2) {
            this.image = bitmap;
            this.delay = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void decodeImageData() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        short s;
        int i7 = this.iw * this.ih;
        byte[] bArr = this.pixels;
        if (bArr == null || bArr.length < i7) {
            this.pixels = new byte[i7];
        }
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        int read = read();
        int i8 = 1 << read;
        int i9 = i8 + 1;
        int i10 = i8 + 2;
        int i11 = read + 1;
        int i12 = (1 << i11) - 1;
        for (int i13 = 0; i13 < i8; i13++) {
            this.prefix[i13] = 0;
            this.suffix[i13] = (byte) i13;
        }
        int i14 = i11;
        int i15 = i10;
        int i16 = i12;
        int i17 = -1;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i18 < i7) {
            if (i19 != 0) {
                i2 = i11;
                i3 = i9;
                int i26 = i24;
                i4 = i8;
                i5 = i26;
            } else if (i20 >= i14) {
                int i27 = i21 & i16;
                i21 >>= i14;
                i20 -= i14;
                if (i27 > i15 || i27 == i9) {
                    break;
                } else if (i27 == i8) {
                    i14 = i11;
                    i15 = i10;
                    i16 = i12;
                    i17 = -1;
                } else if (i17 == -1) {
                    this.pixelStack[i19] = this.suffix[i27];
                    i17 = i27;
                    i24 = i17;
                    i19++;
                    i11 = i11;
                } else {
                    i2 = i11;
                    if (i27 == i15) {
                        i6 = i27;
                        this.pixelStack[i19] = (byte) i24;
                        s = i17;
                        i19++;
                    } else {
                        i6 = i27;
                        s = i6;
                    }
                    while (s > i8) {
                        this.pixelStack[i19] = this.suffix[s];
                        s = this.prefix[s];
                        i19++;
                        i8 = i8;
                    }
                    i4 = i8;
                    byte[] bArr2 = this.suffix;
                    i5 = bArr2[s] & 255;
                    if (i15 >= 4096) {
                        break;
                    }
                    int i28 = i19 + 1;
                    i3 = i9;
                    byte b = (byte) i5;
                    this.pixelStack[i19] = b;
                    this.prefix[i15] = (short) i17;
                    bArr2[i15] = b;
                    i15++;
                    if ((i15 & i16) == 0 && i15 < 4096) {
                        i14++;
                        i16 += i15;
                    }
                    i19 = i28;
                    i17 = i6;
                }
            } else {
                if (i22 == 0) {
                    i22 = readBlock();
                    if (i22 <= 0) {
                        break;
                    }
                    i23 = 0;
                }
                i21 += (this.block[i23] & 255) << i20;
                i20 += 8;
                i23++;
                i22--;
            }
            i19--;
            this.pixels[i25] = this.pixelStack[i19];
            i18++;
            i25++;
            i8 = i4;
            i9 = i3;
            i24 = i5;
            i11 = i2;
        }
        for (int i29 = i25; i29 < i7; i29++) {
            this.pixels[i29] = 0;
        }
    }

    public boolean err() {
        return this.status != 0;
    }

    public int getDelay(int i2) {
        this.delay = -1;
        if (i2 >= 0 && i2 < this.frameCount) {
            this.delay = this.frames.elementAt(i2).delay;
        }
        return this.delay;
    }

    public Bitmap getFrame(int i2) {
        if (i2 < 0 || i2 >= this.frameCount) {
            return null;
        }
        return this.frames.elementAt(i2).image;
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    public int getFrameindex() {
        return this.frameindex;
    }

    public int getHeigh() {
        return this.height;
    }

    public Bitmap getImage() {
        return getFrame(0);
    }

    public int getLoopCount() {
        return this.loopCount;
    }

    public int getWidth() {
        return this.width;
    }

    public void init() {
        this.status = 0;
        this.frameCount = 0;
        this.frames = new Vector<>();
        this.gct = null;
        this.lct = null;
    }

    public Bitmap nextBitmap() {
        int i2 = this.frameindex + 1;
        this.frameindex = i2;
        if (i2 > this.frames.size() - 1) {
            this.frameindex = 0;
        }
        return this.frames.elementAt(this.frameindex).image;
    }

    public int nextDelay() {
        return this.frames.elementAt(this.frameindex).delay;
    }

    public int read(InputStream inputStream) {
        init();
        if (inputStream != null) {
            this.in = inputStream;
            readHeader();
            if (!err()) {
                readContents();
                if (this.frameCount < 0) {
                    this.status = 1;
                }
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.status;
    }

    public int readBlock() {
        int read = read();
        this.blockSize = read;
        int i2 = 0;
        if (read > 0) {
            while (true) {
                try {
                    int i3 = this.blockSize;
                    if (i2 >= i3) {
                        break;
                    }
                    int read2 = this.in.read(this.block, i2, i3 - i2);
                    if (read2 == -1) {
                        break;
                    }
                    i2 += read2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (i2 < this.blockSize) {
                this.status = 1;
            }
        }
        return i2;
    }

    public int[] readColorTable(int i2) {
        int i3;
        int i4 = i2 * 3;
        byte[] bArr = new byte[i4];
        try {
            i3 = this.in.read(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            i3 = 0;
        }
        if (i3 < i4) {
            this.status = 1;
            return null;
        }
        int[] iArr = new int[256];
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = i5 + 1;
            int i8 = i7 + 1;
            iArr[i6] = ((bArr[i5] & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
            i5 = i8 + 1;
        }
        return iArr;
    }

    public void readContents() {
        boolean z = false;
        while (!z && !err()) {
            int read = read();
            if (read != 0) {
                if (read == 33) {
                    int read2 = read();
                    if (read2 == 249) {
                        readGraphicControlExt();
                    } else if (read2 != 255) {
                        skip();
                    } else {
                        readBlock();
                        String str = "";
                        for (int i2 = 0; i2 < 11; i2++) {
                            str = str + ((char) this.block[i2]);
                        }
                        if (str.equals("NETSCAPE2.0")) {
                            readNetscapeExt();
                        } else {
                            skip();
                        }
                    }
                } else if (read == 44) {
                    readImage();
                } else if (read != 59) {
                    this.status = 1;
                } else {
                    z = true;
                }
            }
        }
    }

    public void readGraphicControlExt() {
        read();
        int read = read();
        int i2 = (read & 28) >> 2;
        this.dispose = i2;
        if (i2 == 0) {
            this.dispose = 1;
        }
        this.transparency = (read & 1) != 0;
        this.delay = readShort() * 10;
        this.transIndex = read();
        read();
    }

    public void readHeader() {
        String str = "";
        for (int i2 = 0; i2 < 6; i2++) {
            str = str + ((char) read());
        }
        if (!str.startsWith("GIF")) {
            this.status = 1;
            return;
        }
        readLSD();
        if (!this.gctFlag || err()) {
            return;
        }
        int[] readColorTable = readColorTable(this.gctSize);
        this.gct = readColorTable;
        this.bgColor = readColorTable[this.bgIndex];
    }

    public void readImage() {
        this.ix = readShort();
        this.iy = readShort();
        this.iw = readShort();
        this.ih = readShort();
        int read = read();
        int i2 = 0;
        boolean z = (read & 128) != 0;
        this.lctFlag = z;
        this.interlace = (read & 64) != 0;
        int i3 = 2 << (read & 7);
        this.lctSize = i3;
        if (z) {
            int[] readColorTable = readColorTable(i3);
            this.lct = readColorTable;
            this.act = readColorTable;
        } else {
            this.act = this.gct;
            if (this.bgIndex == this.transIndex) {
                this.bgColor = 0;
            }
        }
        if (this.transparency) {
            int[] iArr = this.act;
            int i4 = this.transIndex;
            int i5 = iArr[i4];
            iArr[i4] = 0;
            i2 = i5;
        }
        if (this.act == null) {
            this.status = 1;
        }
        if (err()) {
            return;
        }
        decodeImageData();
        skip();
        if (err()) {
            return;
        }
        this.frameCount++;
        this.image = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_4444);
        setPixels();
        this.frames.addElement(new GifFrame(this.image, this.delay));
        if (this.transparency) {
            this.act[this.transIndex] = i2;
        }
        resetFrame();
    }

    public void readLSD() {
        this.width = readShort();
        this.height = readShort();
        int read = read();
        this.gctFlag = (read & 128) != 0;
        this.gctSize = 2 << (read & 7);
        this.bgIndex = read();
        this.pixelAspect = read();
    }

    public void readNetscapeExt() {
        do {
            readBlock();
            byte[] bArr = this.block;
            if (bArr[0] == 1) {
                this.loopCount = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    public int readShort() {
        return read() | (read() << 8);
    }

    public void resetFrame() {
        this.lastDispose = this.dispose;
        this.lrx = this.ix;
        this.lry = this.iy;
        this.lrw = this.iw;
        this.lrh = this.ih;
        this.lastImage = this.image;
        this.lastBgColor = this.bgColor;
        this.dispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.lct = null;
    }

    public void setFrameindex(int i2) {
        this.frameindex = i2;
        int size = this.frames.size() - 1;
    }

    public void setPixels() {
        int i2;
        int[] iArr = new int[this.width * this.height];
        int i3 = this.lastDispose;
        int i4 = 0;
        if (i3 > 0) {
            if (i3 == 3) {
                int i5 = this.frameCount - 2;
                if (i5 > 0) {
                    this.lastImage = getFrame(i5 - 1);
                } else {
                    this.lastImage = null;
                }
            }
            Bitmap bitmap = this.lastImage;
            if (bitmap != null) {
                int i6 = this.width;
                bitmap.getPixels(iArr, 0, i6, 0, 0, i6, this.height);
                if (this.lastDispose == 2) {
                    int i7 = !this.transparency ? this.lastBgColor : 0;
                    for (int i8 = 0; i8 < this.lrh; i8++) {
                        int i9 = ((this.lry + i8) * this.width) + this.lrx;
                        int i10 = this.lrw + i9;
                        while (i9 < i10) {
                            iArr[i9] = i7;
                            i9++;
                        }
                    }
                }
            }
        }
        int i11 = 8;
        int i12 = 0;
        int i13 = 1;
        while (true) {
            int i14 = this.ih;
            if (i4 < i14) {
                if (this.interlace) {
                    if (i12 >= i14) {
                        i13++;
                        if (i13 == 2) {
                            i12 = 4;
                        } else if (i13 == 3) {
                            i11 = 4;
                            i12 = 2;
                        } else if (i13 == 4) {
                            i11 = 2;
                            i12 = 1;
                        }
                    }
                    i2 = i12 + i11;
                } else {
                    i2 = i12;
                    i12 = i4;
                }
                int i15 = i12 + this.iy;
                if (i15 < this.height) {
                    int i16 = this.width;
                    int i17 = i15 * i16;
                    int i18 = this.ix + i17;
                    int i19 = this.iw;
                    int i20 = i18 + i19;
                    if (i17 + i16 < i20) {
                        i20 = i17 + i16;
                    }
                    int i21 = i19 * i4;
                    while (i18 < i20) {
                        int i22 = i21 + 1;
                        int i23 = this.act[this.pixels[i21] & 255];
                        if (i23 != 0) {
                            iArr[i18] = i23;
                        }
                        i18++;
                        i21 = i22;
                    }
                }
                i4++;
                i12 = i2;
            } else {
                this.image = Bitmap.createBitmap(iArr, this.width, this.height, Bitmap.Config.ARGB_4444);
                return;
            }
        }
    }

    public void skip() {
        do {
            readBlock();
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    public int read() {
        try {
            return this.in.read();
        } catch (Exception unused) {
            this.status = 1;
            return 0;
        }
    }
}

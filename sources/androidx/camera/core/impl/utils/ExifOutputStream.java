package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.utils.ExifData;
import androidx.core.util.Preconditions;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ExifOutputStream extends FilterOutputStream {
    private static final short BYTE_ALIGN_II = 18761;
    private static final short BYTE_ALIGN_MM = 19789;
    private static final boolean DEBUG = false;
    private static final byte[] IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(ExifAttribute.ASCII);
    private static final int IFD_OFFSET = 8;
    private static final byte START_CODE = 42;
    private static final int STATE_FRAME_HEADER = 1;
    private static final int STATE_JPEG_DATA = 2;
    private static final int STATE_SOI = 0;
    private static final int STREAMBUFFER_SIZE = 65536;
    private static final String TAG = "ExifOutputStream";
    private final ByteBuffer mBuffer;
    private int mByteToCopy;
    private int mByteToSkip;
    private final ExifData mExifData;
    private final byte[] mSingleByteArray;
    private int mState;

    /* loaded from: classes.dex */
    public static final class JpegHeader {
        public static final short APP1 = -31;
        public static final short DAC = -52;
        public static final short DHT = -60;
        public static final short EOI = -39;
        public static final short JPG = -56;
        public static final short SOF0 = -64;
        public static final short SOF15 = -49;
        public static final short SOI = -40;

        private JpegHeader() {
        }

        public static boolean isSofMarker(short s) {
            return (s < -64 || s > -49 || s == -60 || s == -56 || s == -52) ? false : true;
        }
    }

    public ExifOutputStream(@NonNull OutputStream outputStream, @NonNull ExifData exifData) {
        super(new BufferedOutputStream(outputStream, 65536));
        this.mSingleByteArray = new byte[1];
        this.mBuffer = ByteBuffer.allocate(4);
        this.mState = 0;
        this.mExifData = exifData;
    }

    private int requestByteToBuffer(int i2, byte[] bArr, int i3, int i4) {
        int min = Math.min(i4, i2 - this.mBuffer.position());
        this.mBuffer.put(bArr, i3, min);
        return min;
    }

    private void writeExifSegment(@NonNull ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        ExifTag[] exifTagArr;
        ExifTag[][] exifTagArr2 = ExifData.EXIF_TAGS;
        int[] iArr = new int[exifTagArr2.length];
        int[] iArr2 = new int[exifTagArr2.length];
        for (ExifTag exifTag : ExifData.EXIF_POINTER_TAGS) {
            for (int i2 = 0; i2 < ExifData.EXIF_TAGS.length; i2++) {
                this.mExifData.getAttributes(i2).remove(exifTag.name);
            }
        }
        if (!this.mExifData.getAttributes(1).isEmpty()) {
            this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0L, this.mExifData.getByteOrder()));
        }
        if (!this.mExifData.getAttributes(2).isEmpty()) {
            this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0L, this.mExifData.getByteOrder()));
        }
        if (!this.mExifData.getAttributes(3).isEmpty()) {
            this.mExifData.getAttributes(1).put(ExifData.EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0L, this.mExifData.getByteOrder()));
        }
        for (int i3 = 0; i3 < ExifData.EXIF_TAGS.length; i3++) {
            int i4 = 0;
            for (Map.Entry<String, ExifAttribute> entry : this.mExifData.getAttributes(i3).entrySet()) {
                int size = entry.getValue().size();
                if (size > 4) {
                    i4 += size;
                }
            }
            iArr2[i3] = iArr2[i3] + i4;
        }
        int i5 = 8;
        for (int i6 = 0; i6 < ExifData.EXIF_TAGS.length; i6++) {
            if (!this.mExifData.getAttributes(i6).isEmpty()) {
                iArr[i6] = i5;
                i5 += (this.mExifData.getAttributes(i6).size() * 12) + 2 + 4 + iArr2[i6];
            }
        }
        int i7 = i5 + 8;
        if (!this.mExifData.getAttributes(1).isEmpty()) {
            this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(iArr[1], this.mExifData.getByteOrder()));
        }
        if (!this.mExifData.getAttributes(2).isEmpty()) {
            this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(iArr[2], this.mExifData.getByteOrder()));
        }
        if (!this.mExifData.getAttributes(3).isEmpty()) {
            this.mExifData.getAttributes(1).put(ExifData.EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(iArr[3], this.mExifData.getByteOrder()));
        }
        byteOrderedDataOutputStream.writeUnsignedShort(i7);
        byteOrderedDataOutputStream.write(IDENTIFIER_EXIF_APP1);
        byteOrderedDataOutputStream.writeShort(this.mExifData.getByteOrder() == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        byteOrderedDataOutputStream.setByteOrder(this.mExifData.getByteOrder());
        byteOrderedDataOutputStream.writeUnsignedShort(42);
        byteOrderedDataOutputStream.writeUnsignedInt(8L);
        for (int i8 = 0; i8 < ExifData.EXIF_TAGS.length; i8++) {
            if (!this.mExifData.getAttributes(i8).isEmpty()) {
                byteOrderedDataOutputStream.writeUnsignedShort(this.mExifData.getAttributes(i8).size());
                int size2 = iArr[i8] + 2 + (this.mExifData.getAttributes(i8).size() * 12) + 4;
                for (Map.Entry<String, ExifAttribute> entry2 : this.mExifData.getAttributes(i8).entrySet()) {
                    int i9 = ((ExifTag) Preconditions.checkNotNull(ExifData.Builder.sExifTagMapsForWriting.get(i8).get(entry2.getKey()), "Tag not supported: " + entry2.getKey() + ". Tag needs to be ported from ExifInterface to ExifData.")).number;
                    ExifAttribute value = entry2.getValue();
                    int size3 = value.size();
                    byteOrderedDataOutputStream.writeUnsignedShort(i9);
                    byteOrderedDataOutputStream.writeUnsignedShort(value.format);
                    byteOrderedDataOutputStream.writeInt(value.numberOfComponents);
                    if (size3 > 4) {
                        byteOrderedDataOutputStream.writeUnsignedInt(size2);
                        size2 += size3;
                    } else {
                        byteOrderedDataOutputStream.write(value.bytes);
                        if (size3 < 4) {
                            while (size3 < 4) {
                                byteOrderedDataOutputStream.writeByte(0);
                                size3++;
                            }
                        }
                    }
                }
                byteOrderedDataOutputStream.writeUnsignedInt(0L);
                for (Map.Entry<String, ExifAttribute> entry3 : this.mExifData.getAttributes(i8).entrySet()) {
                    byte[] bArr = entry3.getValue().bytes;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        byteOrderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0106, code lost:
        if (r9 <= 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0108, code lost:
        ((java.io.FilterOutputStream) r6).out.write(r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
        return;
     */
    @Override // java.io.FilterOutputStream, java.io.OutputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(@androidx.annotation.NonNull byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifOutputStream.write(byte[], int, int):void");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.mSingleByteArray;
        bArr[0] = (byte) (i2 & 255);
        write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}

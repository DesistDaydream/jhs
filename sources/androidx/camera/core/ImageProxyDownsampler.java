package androidx.camera.core;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProxy;
import java.nio.ByteBuffer;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ImageProxyDownsampler {

    /* renamed from: androidx.camera.core.ImageProxyDownsampler$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod;

        static {
            int[] iArr = new int[DownsamplingMethod.values().length];
            $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod = iArr;
            try {
                iArr[DownsamplingMethod.NEAREST_NEIGHBOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod[DownsamplingMethod.AVERAGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum DownsamplingMethod {
        NEAREST_NEIGHBOR,
        AVERAGING
    }

    /* loaded from: classes.dex */
    public static final class ForwardingImageProxyImpl extends ForwardingImageProxy {
        private final int mDownsampledHeight;
        private final ImageProxy.PlaneProxy[] mDownsampledPlanes;
        private final int mDownsampledWidth;

        public ForwardingImageProxyImpl(ImageProxy imageProxy, ImageProxy.PlaneProxy[] planeProxyArr, int i2, int i3) {
            super(imageProxy);
            this.mDownsampledPlanes = planeProxyArr;
            this.mDownsampledWidth = i2;
            this.mDownsampledHeight = i3;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public synchronized int getHeight() {
            return this.mDownsampledHeight;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        @NonNull
        public synchronized ImageProxy.PlaneProxy[] getPlanes() {
            return this.mDownsampledPlanes;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public synchronized int getWidth() {
            return this.mDownsampledWidth;
        }
    }

    private ImageProxyDownsampler() {
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(int i2, int i3, byte[] bArr) {
        return new ImageProxy.PlaneProxy(bArr, i2, i3) { // from class: androidx.camera.core.ImageProxyDownsampler.1
            public final ByteBuffer mBuffer;
            public final /* synthetic */ byte[] val$data;
            public final /* synthetic */ int val$pixelStride;
            public final /* synthetic */ int val$rowStride;

            {
                this.val$data = bArr;
                this.val$rowStride = i2;
                this.val$pixelStride = i3;
                this.mBuffer = ByteBuffer.wrap(bArr);
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            @NonNull
            public ByteBuffer getBuffer() {
                return this.mBuffer;
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public int getPixelStride() {
                return this.val$pixelStride;
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public int getRowStride() {
                return this.val$rowStride;
            }
        };
    }

    public static ForwardingImageProxy downsample(ImageProxy imageProxy, int i2, int i3, DownsamplingMethod downsamplingMethod) {
        byte[] bArr;
        if (imageProxy.getFormat() == 35) {
            if (imageProxy.getWidth() >= i2 && imageProxy.getHeight() >= i3) {
                if (imageProxy.getWidth() == i2 && imageProxy.getHeight() == i3) {
                    return new ForwardingImageProxyImpl(imageProxy, imageProxy.getPlanes(), i2, i3);
                }
                int[] iArr = {imageProxy.getWidth(), imageProxy.getWidth() / 2, imageProxy.getWidth() / 2};
                int[] iArr2 = {imageProxy.getHeight(), imageProxy.getHeight() / 2, imageProxy.getHeight() / 2};
                int i4 = i2 / 2;
                int[] iArr3 = {i2, i4, i4};
                int i5 = i3 / 2;
                int[] iArr4 = {i3, i5, i5};
                ImageProxy.PlaneProxy[] planeProxyArr = new ImageProxy.PlaneProxy[3];
                for (int i6 = 0; i6 < 3; i6++) {
                    ImageProxy.PlaneProxy planeProxy = imageProxy.getPlanes()[i6];
                    ByteBuffer buffer = planeProxy.getBuffer();
                    byte[] bArr2 = new byte[iArr3[i6] * iArr4[i6]];
                    int i7 = AnonymousClass2.$SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod[downsamplingMethod.ordinal()];
                    if (i7 == 1) {
                        bArr = bArr2;
                        resizeNearestNeighbor(buffer, iArr[i6], planeProxy.getPixelStride(), planeProxy.getRowStride(), iArr2[i6], bArr, iArr3[i6], iArr4[i6]);
                    } else if (i7 != 2) {
                        bArr = bArr2;
                    } else {
                        bArr = bArr2;
                        resizeAveraging(buffer, iArr[i6], planeProxy.getPixelStride(), planeProxy.getRowStride(), iArr2[i6], bArr, iArr3[i6], iArr4[i6]);
                    }
                    planeProxyArr[i6] = createPlaneProxy(iArr3[i6], 1, bArr);
                }
                return new ForwardingImageProxyImpl(imageProxy, planeProxyArr, i2, i3);
            }
            throw new IllegalArgumentException("Downsampled dimension " + new Size(i2, i3) + " is not <= original dimension " + new Size(imageProxy.getWidth(), imageProxy.getHeight()) + ".");
        }
        throw new UnsupportedOperationException("Only YUV_420_888 format is currently supported.");
    }

    private static void resizeAveraging(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, byte[] bArr, int i6, int i7) {
        float f2 = i2 / i6;
        float f3 = i5 / i7;
        byte[] bArr2 = new byte[i4];
        byte[] bArr3 = new byte[i4];
        int[] iArr = new int[i6];
        int i8 = 0;
        for (int i9 = 0; i9 < i6; i9++) {
            iArr[i9] = ((int) (i9 * f2)) * i3;
        }
        synchronized (byteBuffer) {
            byteBuffer.rewind();
            int i10 = 0;
            while (i10 < i7) {
                int i11 = (int) (i10 * f3);
                int i12 = i5 - 1;
                int i13 = i10 * i6;
                byteBuffer.position(Math.min(i11, i12) * i4);
                byteBuffer.get(bArr2, i8, Math.min(i4, byteBuffer.remaining()));
                byteBuffer.position(Math.min(i11 + 1, i12) * i4);
                byteBuffer.get(bArr3, i8, Math.min(i4, byteBuffer.remaining()));
                for (int i14 = 0; i14 < i6; i14++) {
                    bArr[i13 + i14] = (byte) ((((((bArr2[iArr[i14]] & 255) + (bArr2[iArr[i14] + i3] & 255)) + (bArr3[iArr[i14]] & 255)) + (bArr3[iArr[i14] + i3] & 255)) / 4) & 255);
                }
                i10++;
                i8 = 0;
            }
        }
    }

    private static void resizeNearestNeighbor(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, byte[] bArr, int i6, int i7) {
        float f2 = i2 / i6;
        float f3 = i5 / i7;
        byte[] bArr2 = new byte[i4];
        int[] iArr = new int[i6];
        for (int i8 = 0; i8 < i6; i8++) {
            iArr[i8] = ((int) (i8 * f2)) * i3;
        }
        synchronized (byteBuffer) {
            byteBuffer.rewind();
            for (int i9 = 0; i9 < i7; i9++) {
                int i10 = i9 * i6;
                byteBuffer.position(Math.min((int) (i9 * f3), i5 - 1) * i4);
                byteBuffer.get(bArr2, 0, Math.min(i4, byteBuffer.remaining()));
                for (int i11 = 0; i11 < i6; i11++) {
                    bArr[i10 + i11] = bArr2[iArr[i11]];
                }
            }
        }
    }
}

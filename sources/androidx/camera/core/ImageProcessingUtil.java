package androidx.camera.core;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Locale;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ImageProcessingUtil {
    private static final String TAG = "ImageProcessingUtil";
    private static int sImageCount;

    /* loaded from: classes.dex */
    public enum Result {
        UNKNOWN,
        SUCCESS,
        ERROR_CONVERSION
    }

    static {
        System.loadLibrary("image_processing_util_jni");
    }

    private ImageProcessingUtil() {
    }

    public static /* synthetic */ void a(ImageProxy imageProxy, ImageProxy imageProxy2, ImageProxy imageProxy3) {
        if (imageProxy == null || imageProxy2 == null) {
            return;
        }
        imageProxy2.close();
    }

    public static boolean applyPixelShiftForYUV(@NonNull ImageProxy imageProxy) {
        if (!isSupportedYUVFormat(imageProxy)) {
            Logger.e(TAG, "Unsupported format for YUV to RGB");
            return false;
        } else if (applyPixelShiftInternal(imageProxy) == Result.ERROR_CONVERSION) {
            Logger.e(TAG, "One pixel shift for YUV failure");
            return false;
        } else {
            return true;
        }
    }

    @NonNull
    private static Result applyPixelShiftInternal(@NonNull ImageProxy imageProxy) {
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int rowStride = imageProxy.getPlanes()[0].getRowStride();
        int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
        int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
        int pixelStride = imageProxy.getPlanes()[0].getPixelStride();
        int pixelStride2 = imageProxy.getPlanes()[1].getPixelStride();
        if (nativeShiftPixel(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, pixelStride2, width, height, pixelStride, pixelStride2, pixelStride2) != 0) {
            return Result.ERROR_CONVERSION;
        }
        return Result.SUCCESS;
    }

    public static /* synthetic */ void b(ImageProxy imageProxy, ImageProxy imageProxy2, ImageProxy imageProxy3) {
        if (imageProxy == null || imageProxy2 == null) {
            return;
        }
        imageProxy2.close();
    }

    @Nullable
    public static ImageProxy convertJpegBytesToImage(@NonNull ImageReaderProxy imageReaderProxy, @NonNull byte[] bArr) {
        Preconditions.checkArgument(imageReaderProxy.getImageFormat() == 256);
        Preconditions.checkNotNull(bArr);
        Surface surface = imageReaderProxy.getSurface();
        Preconditions.checkNotNull(surface);
        if (nativeWriteJpegToSurface(bArr, surface) != 0) {
            Logger.e(TAG, "Failed to enqueue JPEG image.");
            return null;
        }
        ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
        if (acquireLatestImage == null) {
            Logger.e(TAG, "Failed to get acquire JPEG image.");
        }
        return acquireLatestImage;
    }

    @Nullable
    public static ImageProxy convertYUVToRGB(@NonNull final ImageProxy imageProxy, @NonNull ImageReaderProxy imageReaderProxy, @Nullable ByteBuffer byteBuffer, @IntRange(from = 0, to = 359) int i2, boolean z) {
        if (!isSupportedYUVFormat(imageProxy)) {
            Logger.e(TAG, "Unsupported format for YUV to RGB");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!isSupportedRotationDegrees(i2)) {
            Logger.e(TAG, "Unsupported rotation degrees for rotate RGB");
            return null;
        } else if (convertYUVToRGBInternal(imageProxy, imageReaderProxy.getSurface(), byteBuffer, i2, z) == Result.ERROR_CONVERSION) {
            Logger.e(TAG, "YUV to RGB conversion failure");
            return null;
        } else {
            if (Log.isLoggable("MH", 3)) {
                Logger.d(TAG, String.format(Locale.US, "Image processing performance profiling, duration: [%d], image count: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(sImageCount)));
                sImageCount++;
            }
            final ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (acquireLatestImage == null) {
                Logger.e(TAG, "YUV to RGB acquireLatestImage failure");
                return null;
            }
            SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(acquireLatestImage);
            singleCloseImageProxy.addOnImageCloseListener(new ForwardingImageProxy.OnImageCloseListener() { // from class: c.b.b.l0
                @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
                public final void onImageClose(ImageProxy imageProxy2) {
                    ImageProcessingUtil.a(ImageProxy.this, imageProxy, imageProxy2);
                }
            });
            return singleCloseImageProxy;
        }
    }

    @NonNull
    private static Result convertYUVToRGBInternal(@NonNull ImageProxy imageProxy, @NonNull Surface surface, @Nullable ByteBuffer byteBuffer, int i2, boolean z) {
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int rowStride = imageProxy.getPlanes()[0].getRowStride();
        int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
        int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
        int pixelStride = imageProxy.getPlanes()[0].getPixelStride();
        int pixelStride2 = imageProxy.getPlanes()[1].getPixelStride();
        if (nativeConvertAndroid420ToABGR(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, pixelStride2, surface, byteBuffer, width, height, z ? pixelStride : 0, z ? pixelStride2 : 0, z ? pixelStride2 : 0, i2) != 0) {
            return Result.ERROR_CONVERSION;
        }
        return Result.SUCCESS;
    }

    private static boolean isSupportedRotationDegrees(@IntRange(from = 0, to = 359) int i2) {
        return i2 == 0 || i2 == 90 || i2 == 180 || i2 == 270;
    }

    private static boolean isSupportedYUVFormat(@NonNull ImageProxy imageProxy) {
        return imageProxy.getFormat() == 35 && imageProxy.getPlanes().length == 3;
    }

    private static native int nativeConvertAndroid420ToABGR(@NonNull ByteBuffer byteBuffer, int i2, @NonNull ByteBuffer byteBuffer2, int i3, @NonNull ByteBuffer byteBuffer3, int i4, int i5, int i6, @NonNull Surface surface, @Nullable ByteBuffer byteBuffer4, int i7, int i8, int i9, int i10, int i11, int i12);

    private static native int nativeRotateYUV(@NonNull ByteBuffer byteBuffer, int i2, @NonNull ByteBuffer byteBuffer2, int i3, @NonNull ByteBuffer byteBuffer3, int i4, int i5, @NonNull ByteBuffer byteBuffer4, int i6, int i7, @NonNull ByteBuffer byteBuffer5, int i8, int i9, @NonNull ByteBuffer byteBuffer6, int i10, int i11, @NonNull ByteBuffer byteBuffer7, @NonNull ByteBuffer byteBuffer8, @NonNull ByteBuffer byteBuffer9, int i12, int i13, int i14);

    private static native int nativeShiftPixel(@NonNull ByteBuffer byteBuffer, int i2, @NonNull ByteBuffer byteBuffer2, int i3, @NonNull ByteBuffer byteBuffer3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11);

    private static native int nativeWriteJpegToSurface(@NonNull byte[] bArr, @NonNull Surface surface);

    @Nullable
    public static ImageProxy rotateYUV(@NonNull final ImageProxy imageProxy, @NonNull ImageReaderProxy imageReaderProxy, @NonNull ImageWriter imageWriter, @NonNull ByteBuffer byteBuffer, @NonNull ByteBuffer byteBuffer2, @NonNull ByteBuffer byteBuffer3, @IntRange(from = 0, to = 359) int i2) {
        if (!isSupportedYUVFormat(imageProxy)) {
            Logger.e(TAG, "Unsupported format for rotate YUV");
            return null;
        } else if (!isSupportedRotationDegrees(i2)) {
            Logger.e(TAG, "Unsupported rotation degrees for rotate YUV");
            return null;
        } else {
            Result result = Result.ERROR_CONVERSION;
            if (((Build.VERSION.SDK_INT < 23 || i2 <= 0) ? result : rotateYUVInternal(imageProxy, imageWriter, byteBuffer, byteBuffer2, byteBuffer3, i2)) == result) {
                Logger.e(TAG, "rotate YUV failure");
                return null;
            }
            final ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (acquireLatestImage == null) {
                Logger.e(TAG, "YUV rotation acquireLatestImage failure");
                return null;
            }
            SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(acquireLatestImage);
            singleCloseImageProxy.addOnImageCloseListener(new ForwardingImageProxy.OnImageCloseListener() { // from class: c.b.b.k0
                @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
                public final void onImageClose(ImageProxy imageProxy2) {
                    ImageProcessingUtil.b(ImageProxy.this, imageProxy, imageProxy2);
                }
            });
            return singleCloseImageProxy;
        }
    }

    @Nullable
    @RequiresApi(23)
    private static Result rotateYUVInternal(@NonNull ImageProxy imageProxy, @NonNull ImageWriter imageWriter, @NonNull ByteBuffer byteBuffer, @NonNull ByteBuffer byteBuffer2, @NonNull ByteBuffer byteBuffer3, int i2) {
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int rowStride = imageProxy.getPlanes()[0].getRowStride();
        int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
        int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
        int pixelStride = imageProxy.getPlanes()[1].getPixelStride();
        Image dequeueInputImage = ImageWriterCompat.dequeueInputImage(imageWriter);
        if (dequeueInputImage == null) {
            return Result.ERROR_CONVERSION;
        }
        if (nativeRotateYUV(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, dequeueInputImage.getPlanes()[0].getBuffer(), dequeueInputImage.getPlanes()[0].getRowStride(), dequeueInputImage.getPlanes()[0].getPixelStride(), dequeueInputImage.getPlanes()[1].getBuffer(), dequeueInputImage.getPlanes()[1].getRowStride(), dequeueInputImage.getPlanes()[1].getPixelStride(), dequeueInputImage.getPlanes()[2].getBuffer(), dequeueInputImage.getPlanes()[2].getRowStride(), dequeueInputImage.getPlanes()[2].getPixelStride(), byteBuffer, byteBuffer2, byteBuffer3, width, height, i2) != 0) {
            return Result.ERROR_CONVERSION;
        }
        ImageWriterCompat.queueInputImage(imageWriter, dequeueInputImage);
        return Result.SUCCESS;
    }
}

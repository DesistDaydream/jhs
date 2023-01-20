package e.b.a.p.m.d;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import e.b.a.p.m.d.v;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: f  reason: collision with root package name */
    public static final String f9762f = "Downsampler";

    /* renamed from: g  reason: collision with root package name */
    public static final e.b.a.p.e<DecodeFormat> f9763g = e.b.a.p.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);

    /* renamed from: h  reason: collision with root package name */
    public static final e.b.a.p.e<PreferredColorSpace> f9764h = e.b.a.p.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    @Deprecated

    /* renamed from: i  reason: collision with root package name */
    public static final e.b.a.p.e<DownsampleStrategy> f9765i = DownsampleStrategy.f1718h;

    /* renamed from: j  reason: collision with root package name */
    public static final e.b.a.p.e<Boolean> f9766j;

    /* renamed from: k  reason: collision with root package name */
    public static final e.b.a.p.e<Boolean> f9767k;

    /* renamed from: l  reason: collision with root package name */
    private static final String f9768l = "image/vnd.wap.wbmp";

    /* renamed from: m  reason: collision with root package name */
    private static final String f9769m = "image/x-ico";
    private static final Set<String> n;
    private static final b o;
    private static final Set<ImageHeaderParser.ImageType> p;
    private static final Queue<BitmapFactory.Options> q;
    private final e.b.a.p.k.x.e a;
    private final DisplayMetrics b;

    /* renamed from: c  reason: collision with root package name */
    private final e.b.a.p.k.x.b f9770c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ImageHeaderParser> f9771d;

    /* renamed from: e  reason: collision with root package name */
    private final u f9772e = u.d();

    /* loaded from: classes.dex */
    public class a implements b {
        @Override // e.b.a.p.m.d.o.b
        public void a(e.b.a.p.k.x.e eVar, Bitmap bitmap) {
        }

        @Override // e.b.a.p.m.d.o.b
        public void b() {
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(e.b.a.p.k.x.e eVar, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f9766j = e.b.a.p.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f9767k = e.b.a.p.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        n = Collections.unmodifiableSet(new HashSet(Arrays.asList(f9768l, f9769m)));
        o = new a();
        p = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        q = e.b.a.v.n.f(0);
    }

    public o(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, e.b.a.p.k.x.e eVar, e.b.a.p.k.x.b bVar) {
        this.f9771d = list;
        this.b = (DisplayMetrics) e.b.a.v.l.d(displayMetrics);
        this.a = (e.b.a.p.k.x.e) e.b.a.v.l.d(eVar);
        this.f9770c = (e.b.a.p.k.x.b) e.b.a.v.l.d(bVar);
    }

    private static int a(double d2) {
        int l2 = l(d2);
        int x = x(l2 * d2);
        return x((d2 / (x / l2)) * x);
    }

    private void b(v vVar, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        if (this.f9772e.k(i2, i3, options, z, z2)) {
            return;
        }
        if (decodeFormat != DecodeFormat.PREFER_ARGB_8888 && Build.VERSION.SDK_INT != 16) {
            boolean z3 = false;
            try {
                z3 = vVar.d().hasAlpha();
            } catch (IOException e2) {
                if (Log.isLoggable(f9762f, 3)) {
                    Log.d(f9762f, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e2);
                }
            }
            Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    private static void c(ImageHeaderParser.ImageType imageType, v vVar, b bVar, e.b.a.p.k.x.e eVar, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int min;
        int i9;
        int floor;
        double floor2;
        int i10;
        if (i3 > 0 && i4 > 0) {
            if (r(i2)) {
                i8 = i3;
                i7 = i4;
            } else {
                i7 = i3;
                i8 = i4;
            }
            float b2 = downsampleStrategy.b(i7, i8, i5, i6);
            if (b2 > 0.0f) {
                DownsampleStrategy.SampleSizeRounding a2 = downsampleStrategy.a(i7, i8, i5, i6);
                if (a2 != null) {
                    float f2 = i7;
                    float f3 = i8;
                    int x = i7 / x(b2 * f2);
                    int x2 = i8 / x(b2 * f3);
                    DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
                    if (a2 == sampleSizeRounding) {
                        min = Math.max(x, x2);
                    } else {
                        min = Math.min(x, x2);
                    }
                    int i11 = Build.VERSION.SDK_INT;
                    if (i11 > 23 || !n.contains(options.outMimeType)) {
                        int max = Math.max(1, Integer.highestOneBit(min));
                        if (a2 == sampleSizeRounding && max < 1.0f / b2) {
                            max <<= 1;
                        }
                        i9 = max;
                    } else {
                        i9 = 1;
                    }
                    options.inSampleSize = i9;
                    if (imageType == ImageHeaderParser.ImageType.JPEG) {
                        float min2 = Math.min(i9, 8);
                        floor = (int) Math.ceil(f2 / min2);
                        i10 = (int) Math.ceil(f3 / min2);
                        int i12 = i9 / 8;
                        if (i12 > 0) {
                            floor /= i12;
                            i10 /= i12;
                        }
                    } else {
                        if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                            if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                                if (i11 >= 24) {
                                    float f4 = i9;
                                    floor = Math.round(f2 / f4);
                                    i10 = Math.round(f3 / f4);
                                } else {
                                    float f5 = i9;
                                    floor = (int) Math.floor(f2 / f5);
                                    floor2 = Math.floor(f3 / f5);
                                }
                            } else if (i7 % i9 == 0 && i8 % i9 == 0) {
                                floor = i7 / i9;
                                i10 = i8 / i9;
                            } else {
                                int[] m2 = m(vVar, options, bVar, eVar);
                                floor = m2[0];
                                i10 = m2[1];
                            }
                        } else {
                            float f6 = i9;
                            floor = (int) Math.floor(f2 / f6);
                            floor2 = Math.floor(f3 / f6);
                        }
                        i10 = (int) floor2;
                    }
                    double b3 = downsampleStrategy.b(floor, i10, i5, i6);
                    if (i11 >= 19) {
                        options.inTargetDensity = a(b3);
                        options.inDensity = l(b3);
                    }
                    if (s(options)) {
                        options.inScaled = true;
                    } else {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    }
                    if (Log.isLoggable(f9762f, 2)) {
                        Log.v(f9762f, "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + floor + "x" + i10 + "], exact scale factor: " + b2 + ", power of 2 sample size: " + i9 + ", adjusted scale factor: " + b3 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + b2 + " from: " + downsampleStrategy + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        } else if (Log.isLoggable(f9762f, 3)) {
            Log.d(f9762f, "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]");
        }
    }

    private e.b.a.p.k.s<Bitmap> e(v vVar, int i2, int i3, e.b.a.p.f fVar, b bVar) throws IOException {
        byte[] bArr = (byte[]) this.f9770c.c(65536, byte[].class);
        BitmapFactory.Options k2 = k();
        k2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) fVar.a(f9763g);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) fVar.a(f9764h);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) fVar.a(DownsampleStrategy.f1718h);
        boolean booleanValue = ((Boolean) fVar.a(f9766j)).booleanValue();
        e.b.a.p.e<Boolean> eVar = f9767k;
        try {
            return g.d(h(vVar, k2, downsampleStrategy, decodeFormat, preferredColorSpace, fVar.a(eVar) != null && ((Boolean) fVar.a(eVar)).booleanValue(), i2, i3, booleanValue, bVar), this.a);
        } finally {
            v(k2);
            this.f9770c.e(bArr);
        }
    }

    private Bitmap h(v vVar, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i2, int i3, boolean z2, b bVar) throws IOException {
        int i4;
        int i5;
        int i6;
        o oVar;
        int round;
        int round2;
        int i7;
        ColorSpace colorSpace;
        long b2 = e.b.a.v.h.b();
        int[] m2 = m(vVar, options, bVar, this.a);
        boolean z3 = false;
        int i8 = m2[0];
        int i9 = m2[1];
        String str = options.outMimeType;
        boolean z4 = (i8 == -1 || i9 == -1) ? false : z;
        int c2 = vVar.c();
        int j2 = d0.j(c2);
        boolean m3 = d0.m(c2);
        if (i2 == Integer.MIN_VALUE) {
            i4 = i3;
            i5 = r(j2) ? i9 : i8;
        } else {
            i4 = i3;
            i5 = i2;
        }
        if (i4 == Integer.MIN_VALUE) {
            i6 = r(j2) ? i8 : i9;
        } else {
            i6 = i4;
        }
        ImageHeaderParser.ImageType d2 = vVar.d();
        c(d2, vVar, bVar, this.a, downsampleStrategy, j2, i8, i9, i5, i6, options);
        b(vVar, decodeFormat, z4, m3, options, i5, i6);
        int i10 = Build.VERSION.SDK_INT;
        boolean z5 = i10 >= 19;
        if (options.inSampleSize == 1 || z5) {
            oVar = this;
            if (oVar.z(d2)) {
                if (i8 < 0 || i9 < 0 || !z2 || !z5) {
                    float f2 = s(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i11 = options.inSampleSize;
                    float f3 = i11;
                    float f4 = f2;
                    round = Math.round(((int) Math.ceil(i8 / f3)) * f4);
                    round2 = Math.round(((int) Math.ceil(i9 / f3)) * f4);
                    if (Log.isLoggable(f9762f, 2)) {
                        Log.v(f9762f, "Calculated target [" + round + "x" + round2 + "] for source [" + i8 + "x" + i9 + "], sampleSize: " + i11 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f4);
                    }
                } else {
                    round = i5;
                    round2 = i6;
                }
                if (round > 0 && round2 > 0) {
                    y(options, oVar.a, round, round2);
                }
            }
        } else {
            oVar = this;
        }
        if (i10 >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                z3 = true;
            }
            options.inPreferredColorSpace = ColorSpace.get(z3 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (i10 >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap i12 = i(vVar, options, bVar, oVar.a);
        bVar.a(oVar.a, i12);
        if (Log.isLoggable(f9762f, 2)) {
            i7 = c2;
            t(i8, i9, str, options, i12, i2, i3, b2);
        } else {
            i7 = c2;
        }
        Bitmap bitmap = null;
        if (i12 != null) {
            i12.setDensity(oVar.b.densityDpi);
            bitmap = d0.o(oVar.a, i12, i7);
            if (!i12.equals(bitmap)) {
                oVar.a.d(i12);
            }
        }
        return bitmap;
    }

    private static Bitmap i(v vVar, BitmapFactory.Options options, b bVar, e.b.a.p.k.x.e eVar) throws IOException {
        if (!options.inJustDecodeBounds) {
            bVar.b();
            vVar.b();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str = options.outMimeType;
        d0.i().lock();
        try {
            try {
                Bitmap a2 = vVar.a(options);
                d0.i().unlock();
                return a2;
            } catch (IllegalArgumentException e2) {
                IOException u = u(e2, i2, i3, str, options);
                if (Log.isLoggable(f9762f, 3)) {
                    Log.d(f9762f, "Failed to decode with inBitmap, trying again without Bitmap re-use", u);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap != null) {
                    try {
                        eVar.d(bitmap);
                        options.inBitmap = null;
                        Bitmap i4 = i(vVar, options, bVar, eVar);
                        d0.i().unlock();
                        return i4;
                    } catch (IOException unused) {
                        throw u;
                    }
                }
                throw u;
            }
        } catch (Throwable th) {
            d0.i().unlock();
            throw th;
        }
    }

    @Nullable
    @TargetApi(19)
    private static String j(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options poll;
        synchronized (o.class) {
            Queue<BitmapFactory.Options> queue = q;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                w(poll);
            }
        }
        return poll;
    }

    private static int l(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static int[] m(v vVar, BitmapFactory.Options options, b bVar, e.b.a.p.k.x.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        i(vVar, options, bVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private static boolean s(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    private static void t(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v(f9762f, "Decoded " + j(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + n(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + e.b.a.v.h.a(j2));
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue<BitmapFactory.Options> queue = q;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int x(double d2) {
        return (int) (d2 + 0.5d);
    }

    @TargetApi(26)
    private static void y(BitmapFactory.Options options, e.b.a.p.k.x.e eVar, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.g(i2, i3, config);
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return p.contains(imageType);
    }

    @RequiresApi(21)
    public e.b.a.p.k.s<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, e.b.a.p.f fVar) throws IOException {
        return e(new v.b(parcelFileDescriptor, this.f9771d, this.f9770c), i2, i3, fVar, o);
    }

    public e.b.a.p.k.s<Bitmap> f(InputStream inputStream, int i2, int i3, e.b.a.p.f fVar) throws IOException {
        return g(inputStream, i2, i3, fVar, o);
    }

    public e.b.a.p.k.s<Bitmap> g(InputStream inputStream, int i2, int i3, e.b.a.p.f fVar, b bVar) throws IOException {
        return e(new v.a(inputStream, this.f9771d, this.f9770c), i2, i3, fVar, bVar);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }
}

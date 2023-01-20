package com.vector.filecompatnew;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.qiniu.android.collect.ReportItem;
import e.t.a;
import e.t.l.g;
import e.t.l.w;
import h.h2.b;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a#\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t\u001a(\u0010\n\u001a\u00020\u0004*\u00020\u00042\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a$\u0010\u0011\u001a\u00020\u0010*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0017*\u00020\u00042\b\b\u0001\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u0014\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a,\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a,\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a\n\u0010 \u001a\u00020\u001a*\u00020\u0004\u001a\u0014\u0010!\u001a\u00020\u0004*\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0004\u001a\u001e\u0010#\u001a\u00020\u0004*\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010$\u001a\u00020\u0010\u001a\f\u0010%\u001a\u00020\b*\u0004\u0018\u00010\u0004\u001a\u0014\u0010&\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010'\u001a\u00020\u001c\u001a\u001e\u0010&\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\u001d\u001a\u00020\u001c\u001a\u001e\u0010&\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010'\u001a\u00020\u001c2\b\b\u0001\u0010(\u001a\u00020\f\u001a\u001e\u0010&\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\f2\b\b\u0001\u0010\u001d\u001a\u00020\f\u001a\u0014\u0010)\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010*\u001a\u00020\f\u001a\u001c\u0010)\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0010\u001a.\u0010,\u001a\u00020\u0010*\u00020\u00042\u0006\u0010-\u001a\u00020.2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0003\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a&\u0010/\u001a\u00020\u0010*\u00020\u00042\u0006\u00100\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0003\u0010\u0014\u001a\u00020\f\u001a\f\u00101\u001a\u0004\u0018\u00010\u0017*\u00020\u0004\u001a\n\u00102\u001a\u00020\u0004*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"MAX_DOUBLE", "", "MIN_DOUBLE", "applyCanvas", "Landroid/graphics/Bitmap;", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "blur", "radius", "", "context", "Landroid/content/Context;", "alloc", "", "compress", "toFile", "Ljava/io/File;", ReportItem.LogTypeQuality, "format", "Landroid/graphics/Bitmap$CompressFormat;", "", "copy", "config", "Landroid/graphics/Bitmap$Config;", IAdInterListener.AdReqParam.WIDTH, "", "h", "matrix", "Landroid/graphics/Matrix;", "getAlphaSafeConfig", "masking", "mask", "multiply", "useAlpha", "recycle", "resize", "scale", "degree", "rotate", "degrees", "isVertical", "saveToAlbum", "filePath", "", "saveToFile", "file", "toBytes", "toCircle", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BitmapKt {
    public static final double a = 2.147483647E9d;
    public static final double b = 1.0d;

    @e
    public static final byte[] A(@d Bitmap bitmap) {
        return e(bitmap, 100, Bitmap.CompressFormat.PNG);
    }

    @d
    public static final Bitmap B(@d Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            width = height;
        }
        return a(Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888), new BitmapKt$toCircle$1(width, paint, bitmap));
    }

    @d
    public static final Bitmap a(@d Bitmap bitmap, @d l<? super Canvas, t1> lVar) {
        if (!bitmap.isMutable()) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        Canvas canvas = new Canvas(bitmap);
        g.c(canvas);
        lVar.invoke(canvas);
        canvas.setBitmap(null);
        return bitmap;
    }

    @d
    public static final Bitmap b(@d Bitmap bitmap, @IntRange(from = 1, to = 25) int i2, @d Context context, boolean z) {
        RenderScript renderScript;
        Bitmap createBitmap = z ? Bitmap.createBitmap(bitmap) : bitmap;
        try {
            renderScript = RenderScript.create(context);
            if (renderScript != null) {
                try {
                    renderScript.setMessageHandler(new RenderScript.RSMessageHandler());
                } catch (Throwable th) {
                    th = th;
                    if (renderScript != null) {
                        renderScript.destroy();
                    }
                    throw th;
                }
            }
            Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation createTyped = Allocation.createTyped(renderScript, createFromBitmap.getType());
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            create.setInput(createFromBitmap);
            create.setRadius(i2);
            create.forEach(createTyped);
            createTyped.copyTo(createBitmap);
            if (renderScript != null) {
                renderScript.destroy();
            }
            return createBitmap;
        } catch (Throwable th2) {
            th = th2;
            renderScript = null;
        }
    }

    public static /* synthetic */ Bitmap c(Bitmap bitmap, int i2, Context context, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 20;
        }
        if ((i3 & 2) != 0) {
            context = a.b();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return b(bitmap, i2, context, z);
    }

    public static final boolean d(@d Bitmap bitmap, @d File file, @IntRange(from = 1, to = 100) int i2, @d Bitmap.CompressFormat compressFormat) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        Boolean bool = null;
        try {
            Boolean valueOf = Boolean.valueOf(bitmap.compress(compressFormat, i2, fileOutputStream));
            b.a(fileOutputStream, null);
            bool = valueOf;
        } catch (Throwable th) {
            Log.e("safeUse", String.valueOf(th.getMessage()));
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @e
    public static final byte[] e(@d Bitmap bitmap, @IntRange(from = 1, to = 100) int i2, @d Bitmap.CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] byteArray = bitmap.compress(compressFormat, i2, byteArrayOutputStream) ? byteArrayOutputStream.toByteArray() : null;
            b.a(byteArrayOutputStream, null);
            return byteArray;
        } catch (Throwable th) {
            Log.e("safeUse", String.valueOf(th.getMessage()));
            return null;
        }
    }

    @d
    public static final Bitmap f(@d Bitmap bitmap, float f2, float f3, @d Matrix matrix, @d Bitmap.Config config) {
        return g(bitmap, (int) f2, (int) f3, matrix, config);
    }

    @d
    public static final Bitmap g(@d Bitmap bitmap, int i2, int i3, @d Matrix matrix, @d Bitmap.Config config) {
        return a(Bitmap.createBitmap(i2, i3, config), new BitmapKt$copy$1(bitmap, matrix));
    }

    @d
    public static final Bitmap h(@d Bitmap bitmap, @d Bitmap.Config config) {
        return bitmap.copy(config, true);
    }

    public static /* synthetic */ Bitmap i(Bitmap bitmap, float f2, float f3, Matrix matrix, Bitmap.Config config, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return f(bitmap, f2, f3, matrix, config);
    }

    public static /* synthetic */ Bitmap j(Bitmap bitmap, int i2, int i3, Matrix matrix, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return g(bitmap, i2, i3, matrix, config);
    }

    public static /* synthetic */ Bitmap k(Bitmap bitmap, Bitmap.Config config, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return h(bitmap, config);
    }

    @d
    public static final Bitmap.Config l(@d Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16 == bitmap.getConfig()) {
            return Bitmap.Config.RGBA_F16;
        }
        return Bitmap.Config.ARGB_8888;
    }

    @d
    public static final Bitmap m(@d Bitmap bitmap, @e Bitmap bitmap2) {
        Bitmap bitmap3;
        if (bitmap2 != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = bitmap2.getWidth();
            int height2 = bitmap2.getHeight();
            if (width == width2 && height == height2) {
                bitmap3 = bitmap2;
            } else {
                Bitmap t = t(bitmap2, width, height);
                bitmap2.recycle();
                bitmap3 = t;
            }
            int i2 = width * height;
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            bitmap3.getPixels(iArr2, 0, width, 0, 0, width, height);
            int i3 = 0;
            int i4 = i2 - 1;
            if (i4 >= 0) {
                while (true) {
                    int i5 = i3 + 1;
                    int i6 = iArr[i3];
                    iArr[i3] = Color.argb(Color.red(iArr2[i3]), Color.red(i6), Color.green(i6), Color.blue(i6));
                    if (i5 > i4) {
                        break;
                    }
                    i3 = i5;
                }
            }
            bitmap2.setPixels(iArr, 0, width, 0, 0, width, height);
            return bitmap2;
        }
        throw new IllegalArgumentException("mask can not be null".toString());
    }

    @d
    public static final Bitmap n(@d Bitmap bitmap, @e Bitmap bitmap2, boolean z) {
        Bitmap t;
        if (bitmap2 != null) {
            Bitmap copy = bitmap.isMutable() ? bitmap : bitmap.copy(bitmap.getConfig(), true);
            int width = copy.getWidth();
            int height = copy.getHeight();
            int width2 = bitmap2.getWidth();
            int height2 = bitmap2.getHeight();
            if (width == width2 && height == height2) {
                t = bitmap2;
            } else {
                t = t(bitmap2, width, height);
                bitmap2.recycle();
            }
            int i2 = width * height;
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            t.getPixels(iArr2, 0, width, 0, 0, width, height);
            int i3 = 0;
            int i4 = i2 - 1;
            if (i4 >= 0) {
                while (true) {
                    int i5 = i3 + 1;
                    int i6 = iArr[i3];
                    int red = Color.red(i6);
                    int green = Color.green(i6);
                    int blue = Color.blue(i6);
                    int i7 = iArr2[i3];
                    int red2 = Color.red(i7);
                    int green2 = Color.green(i7);
                    int blue2 = Color.blue(i7);
                    int alpha = Color.alpha(i6);
                    int alpha2 = Color.alpha(i7);
                    if (alpha2 == 0) {
                        iArr[i3] = Color.argb(alpha, red, green, blue);
                    } else {
                        int i8 = (red * red2) / 255;
                        int i9 = (green * green2) / 255;
                        int i10 = (blue * blue2) / 255;
                        if (z) {
                            alpha = (alpha * alpha2) / 255;
                        }
                        iArr[i3] = Color.argb(alpha, i8, i9, i10);
                    }
                    if (i5 > i4) {
                        break;
                    }
                    i3 = i5;
                }
            }
            copy.setPixels(iArr, 0, width, 0, 0, width, height);
            return copy;
        }
        throw new IllegalArgumentException("mask can not be null".toString());
    }

    public static /* synthetic */ Bitmap o(Bitmap bitmap, Bitmap bitmap2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return n(bitmap, bitmap2, z);
    }

    public static final void p(@e Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    @d
    public static final Bitmap q(@d Bitmap bitmap, @FloatRange(from = 1.0d, to = 2.147483647E9d) float f2) {
        float width = bitmap.getWidth() * f2;
        float height = bitmap.getHeight() * f2;
        float f3 = ((double) width) < 1.0d ? 1.0f : width;
        float f4 = ((double) height) < 1.0d ? 1.0f : height;
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f2);
        t1 t1Var = t1.a;
        return i(bitmap, f3, f4, matrix, null, 8, null);
    }

    @d
    public static final Bitmap r(@d Bitmap bitmap, @FloatRange(from = 1.0d, to = 2.147483647E9d) float f2, @FloatRange(from = 1.0d, to = 2.147483647E9d) float f3) {
        Matrix matrix = new Matrix();
        matrix.setScale(f2 / bitmap.getWidth(), f3 / bitmap.getHeight());
        return i(bitmap, f2, f3, matrix, null, 8, null);
    }

    @d
    public static final Bitmap s(@d Bitmap bitmap, @FloatRange(from = 1.0d, to = 2.147483647E9d) float f2, @IntRange(from = 0, to = 360) int i2) {
        Matrix matrix = new Matrix();
        matrix.preScale(f2, f2);
        matrix.postRotate(i2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    @d
    public static final Bitmap t(@d Bitmap bitmap, @IntRange(from = 1, to = Long.MAX_VALUE) int i2, @IntRange(from = 1, to = Long.MAX_VALUE) int i3) {
        Matrix matrix = new Matrix();
        matrix.setScale(i2 / bitmap.getWidth(), i3 / bitmap.getHeight());
        return j(bitmap, i2, i3, matrix, null, 8, null);
    }

    @d
    public static final Bitmap u(@d Bitmap bitmap, @IntRange(from = 0, to = 360) int i2) {
        if (i2 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    @d
    public static final Bitmap v(@d Bitmap bitmap, @IntRange(from = 0, to = 360) int i2, boolean z) {
        boolean z2 = true;
        if (!z ? bitmap.getHeight() <= bitmap.getWidth() : bitmap.getHeight() >= bitmap.getWidth()) {
            z2 = false;
        }
        return z2 ? u(bitmap, i2) : bitmap;
    }

    public static final boolean w(@d Bitmap bitmap, @d String str, @d Bitmap.CompressFormat compressFormat, @IntRange(from = 0, to = 100) int i2, @d Context context) {
        ContentValues contentValues = new ContentValues();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = context.getContentResolver();
        e.t.u.g gVar = e.t.u.g.a;
        if (gVar.p()) {
            contentValues.put("relative_path", f0.C("DCIM/", str));
        } else {
            contentValues.put("_data", str);
        }
        contentValues.put("mime_type", "image/jpeg");
        Uri insert = contentResolver.insert(uri, contentValues);
        if (insert == null) {
            return false;
        }
        if (gVar.p()) {
            return e.t.n.b.a(w.m(str), insert, context);
        }
        return true;
    }

    public static /* synthetic */ boolean x(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i2, Context context, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            compressFormat = Bitmap.CompressFormat.PNG;
        }
        if ((i3 & 4) != 0) {
            i2 = 100;
        }
        return w(bitmap, str, compressFormat, i2, context);
    }

    public static final boolean y(@d Bitmap bitmap, @d File file, @d Bitmap.CompressFormat compressFormat, @IntRange(from = 0, to = 100) int i2) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = fileOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) fileOutputStream : new BufferedOutputStream(fileOutputStream, 8192);
        Boolean bool = null;
        try {
            Boolean valueOf = Boolean.valueOf(bitmap.compress(compressFormat, i2, bufferedOutputStream));
            b.a(bufferedOutputStream, null);
            bool = valueOf;
        } catch (Throwable th) {
            Log.e("safeUse", String.valueOf(th.getMessage()));
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static /* synthetic */ boolean z(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            compressFormat = Bitmap.CompressFormat.PNG;
        }
        if ((i3 & 4) != 0) {
            i2 = 100;
        }
        return y(bitmap, file, compressFormat, i2);
    }
}

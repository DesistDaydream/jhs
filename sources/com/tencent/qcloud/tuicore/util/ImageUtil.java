package com.tencent.qcloud.tuicore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUILogin;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class ImageUtil {
    public static final String SP_IMAGE = "_conversation_group_face";

    public static Bitmap adaptBitmapFormPath(String str, int i2, int i3) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = calculateInSampleSize(options, i2, i3);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                i6 *= 2;
            }
        }
        return i6;
    }

    public static Bitmap compressImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int i2 = 100;
        while (byteArrayOutputStream.toByteArray().length / 1024 > 100) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
            i2 -= 10;
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }

    public static String generateImagePath(String str, int i2) {
        return TUIConfig.getImageDownloadDir() + str + "_" + i2;
    }

    public static int getBitmapDegree(Uri uri) {
        try {
            int attributeInt = new ExifInterface(FileUtil.getPathFromUri(uri)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap getBitmapFormPath(android.net.Uri r9) {
        /*
            r0 = 0
            android.content.Context r1 = com.tencent.qcloud.tuicore.TUIConfig.getAppContext()     // Catch: java.lang.Exception -> L80
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Exception -> L80
            java.io.InputStream r1 = r1.openInputStream(r9)     // Catch: java.lang.Exception -> L80
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Exception -> L80
            r2.<init>()     // Catch: java.lang.Exception -> L80
            r3 = 1
            r2.inJustDecodeBounds = r3     // Catch: java.lang.Exception -> L80
            r2.inDither = r3     // Catch: java.lang.Exception -> L80
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.lang.Exception -> L80
            r2.inPreferredConfig = r4     // Catch: java.lang.Exception -> L80
            android.graphics.BitmapFactory.decodeStream(r1, r0, r2)     // Catch: java.lang.Exception -> L80
            r1.close()     // Catch: java.lang.Exception -> L80
            int r1 = r2.outWidth     // Catch: java.lang.Exception -> L80
            int r2 = r2.outHeight     // Catch: java.lang.Exception -> L80
            r4 = -1
            if (r1 == r4) goto L7f
            if (r2 != r4) goto L2b
            goto L7f
        L2b:
            int r4 = getBitmapDegree(r9)     // Catch: java.lang.Exception -> L80
            r5 = 90
            r6 = 1139802112(0x43f00000, float:480.0)
            r7 = 1145569280(0x44480000, float:800.0)
            if (r4 == r5) goto L3b
            r5 = 270(0x10e, float:3.78E-43)
            if (r4 != r5) goto L3f
        L3b:
            r6 = 1145569280(0x44480000, float:800.0)
            r7 = 1139802112(0x43f00000, float:480.0)
        L3f:
            if (r1 <= r2) goto L49
            float r5 = (float) r1     // Catch: java.lang.Exception -> L80
            int r8 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r8 <= 0) goto L49
            float r5 = r5 / r6
            int r1 = (int) r5     // Catch: java.lang.Exception -> L80
            goto L54
        L49:
            if (r1 >= r2) goto L53
            float r1 = (float) r2     // Catch: java.lang.Exception -> L80
            int r2 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r2 <= 0) goto L53
            float r1 = r1 / r7
            int r1 = (int) r1     // Catch: java.lang.Exception -> L80
            goto L54
        L53:
            r1 = 1
        L54:
            if (r1 > 0) goto L57
            r1 = 1
        L57:
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Exception -> L80
            r2.<init>()     // Catch: java.lang.Exception -> L80
            r2.inSampleSize = r1     // Catch: java.lang.Exception -> L80
            r2.inDither = r3     // Catch: java.lang.Exception -> L80
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.lang.Exception -> L80
            r2.inPreferredConfig = r1     // Catch: java.lang.Exception -> L80
            android.content.Context r1 = com.tencent.qcloud.tuicore.TUIConfig.getAppContext()     // Catch: java.lang.Exception -> L80
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Exception -> L80
            java.io.InputStream r9 = r1.openInputStream(r9)     // Catch: java.lang.Exception -> L80
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r9, r0, r2)     // Catch: java.lang.Exception -> L80
            r9.close()     // Catch: java.lang.Exception -> L80
            compressImage(r0)     // Catch: java.lang.Exception -> L80
            android.graphics.Bitmap r9 = rotateBitmapByDegree(r0, r4)     // Catch: java.lang.Exception -> L80
            goto L85
        L7f:
            return r0
        L80:
            r9 = move-exception
            r9.printStackTrace()
            r9 = r0
        L85:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuicore.util.ImageUtil.getBitmapFormPath(android.net.Uri):android.graphics.Bitmap");
    }

    public static String getGroupConversationAvatar(String str) {
        Context appContext = TUIConfig.getAppContext();
        String string = appContext.getSharedPreferences(TUILogin.getSdkAppId() + SP_IMAGE, 0).getString(str, "");
        return (!TextUtils.isEmpty(string) && new File(string).isFile() && new File(string).exists()) ? string : "";
    }

    public static String getImagePathAfterRotate(Uri uri) {
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(TUIConfig.getAppContext().getContentResolver().openInputStream(uri), null, null);
            int bitmapDegree = getBitmapDegree(uri);
            if (bitmapDegree == 0) {
                return FileUtil.getPathFromUri(uri);
            }
            Bitmap rotateBitmapByDegree = rotateBitmapByDegree(decodeStream, bitmapDegree);
            File generateFileName = FileUtil.generateFileName(FileUtil.getFileName(TUIConfig.getAppContext(), uri), FileUtil.getDocumentCacheDir(TUIConfig.getAppContext()));
            if (generateFileName == null) {
                return FileUtil.getPathFromUri(uri);
            }
            storeBitmap(generateFileName, rotateBitmapByDegree);
            rotateBitmapByDegree.recycle();
            return generateFileName.getAbsolutePath();
        } catch (FileNotFoundException unused) {
            return FileUtil.getPathFromUri(uri);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] getImageSize(java.lang.String r10) {
        /*
            r0 = 2
            int[] r0 = new int[r0]
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Exception -> L68
            r1.<init>()     // Catch: java.lang.Exception -> L68
            r2 = 1
            r1.inJustDecodeBounds = r2     // Catch: java.lang.Exception -> L68
            android.graphics.BitmapFactory.decodeFile(r10, r1)     // Catch: java.lang.Exception -> L68
            int r3 = r1.outWidth     // Catch: java.lang.Exception -> L68
            int r1 = r1.outHeight     // Catch: java.lang.Exception -> L68
            int r4 = getBitmapDegree(r10)     // Catch: java.lang.Exception -> L68
            r5 = 0
            if (r4 != 0) goto L1e
            r0[r5] = r3     // Catch: java.lang.Exception -> L68
            r0[r2] = r1     // Catch: java.lang.Exception -> L68
            goto L6c
        L1e:
            r6 = 90
            r7 = 1139802112(0x43f00000, float:480.0)
            r8 = 1145569280(0x44480000, float:800.0)
            if (r4 == r6) goto L2a
            r6 = 270(0x10e, float:3.78E-43)
            if (r4 != r6) goto L2e
        L2a:
            r7 = 1145569280(0x44480000, float:800.0)
            r8 = 1139802112(0x43f00000, float:480.0)
        L2e:
            if (r3 <= r1) goto L38
            float r6 = (float) r3     // Catch: java.lang.Exception -> L68
            int r9 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r9 <= 0) goto L38
            float r6 = r6 / r7
            int r1 = (int) r6     // Catch: java.lang.Exception -> L68
            goto L43
        L38:
            if (r3 >= r1) goto L42
            float r1 = (float) r1     // Catch: java.lang.Exception -> L68
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 <= 0) goto L42
            float r1 = r1 / r8
            int r1 = (int) r1     // Catch: java.lang.Exception -> L68
            goto L43
        L42:
            r1 = 1
        L43:
            if (r1 > 0) goto L46
            r1 = 1
        L46:
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Exception -> L68
            r3.<init>()     // Catch: java.lang.Exception -> L68
            r3.inSampleSize = r1     // Catch: java.lang.Exception -> L68
            r3.inDither = r2     // Catch: java.lang.Exception -> L68
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.lang.Exception -> L68
            r3.inPreferredConfig = r1     // Catch: java.lang.Exception -> L68
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeFile(r10, r3)     // Catch: java.lang.Exception -> L68
            android.graphics.Bitmap r10 = rotateBitmapByDegree(r10, r4)     // Catch: java.lang.Exception -> L68
            int r1 = r10.getWidth()     // Catch: java.lang.Exception -> L68
            r0[r5] = r1     // Catch: java.lang.Exception -> L68
            int r10 = r10.getHeight()     // Catch: java.lang.Exception -> L68
            r0[r2] = r10     // Catch: java.lang.Exception -> L68
            goto L6c
        L68:
            r10 = move-exception
            r10.printStackTrace()
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuicore.util.ImageUtil.getImageSize(java.lang.String):int[]");
    }

    public static Bitmap rotateBitmapByDegree(Bitmap bitmap, int i2) {
        Bitmap bitmap2;
        Matrix matrix = new Matrix();
        matrix.postRotate(i2);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            bitmap2 = null;
        }
        if (bitmap2 == null) {
            bitmap2 = bitmap;
        }
        if (bitmap != bitmap2) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    public static void setGroupConversationAvatar(String str, String str2) {
        Context appContext = TUIConfig.getAppContext();
        SharedPreferences.Editor edit = appContext.getSharedPreferences(TUILogin.getSdkAppId() + SP_IMAGE, 0).edit();
        edit.putString(str, str2);
        if (edit.commit()) {
            return;
        }
        Log.e("ImageUtil", "setGroupConversationAvatar failed , id : " + str + " , url : " + str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static File storeBitmap(File file, Bitmap bitmap) {
        if (!file.exists() || file.isDirectory()) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        try {
        } catch (IOException e2) {
            e2.printStackTrace();
            file.deleteOnExit();
        }
        try {
            try {
                file.deleteOnExit();
                file.createNewFile();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                    bitmap.compress(compressFormat, 100, fileOutputStream2);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    fileOutputStream = compressFormat;
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    file.deleteOnExit();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                        fileOutputStream = fileOutputStream;
                    }
                    return file;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            file.deleteOnExit();
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            }
            return file;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Bitmap toRoundBitmap(Bitmap bitmap) {
        float f2;
        float f3;
        float f4;
        float f5;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            f5 = width / 2;
            f4 = width;
            f3 = f4;
            f2 = 0.0f;
        } else {
            f2 = (width - height) / 2;
            f3 = height;
            f4 = width - f2;
            width = height;
            f5 = height / 2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect((int) f2, (int) 0.0f, (int) f4, (int) f3);
        Rect rect2 = new Rect((int) 0.0f, (int) 0.0f, (int) f3, (int) f3);
        new RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawCircle(f5, f5, f5, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    public static int getBitmapDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static Bitmap getBitmapFormPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getBitmapFormPath(Uri.fromFile(new File(str)));
    }
}

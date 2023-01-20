package com.m7.imkfsdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import com.m7.imkfsdk.chat.model.MoorImageInfoBean;
import com.m7.imkfsdk.chat.model.MoorImageType;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import e.l.r.g0;
import java.io.IOException;

/* loaded from: classes2.dex */
public class MoorImageUtil {
    private static final int MOOR_IMAGEVIEW_MAX = MoorDensityUtil.dp2px(160.0f);
    private static final int MOOR_IMAGEVIEW_MIN = MoorDensityUtil.dp2px(80.0f);
    private static final String TAG = "ImageUtil";

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

    public static Bitmap getImageBitmap(String str, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z = true;
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = (int) 1.0f;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inDither = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        if (decodeFile != null && !decodeFile.isRecycled()) {
            decodeFile.recycle();
        }
        try {
            decodeFile = BitmapFactory.decodeFile(str, options);
            z = false;
        } catch (Exception unused) {
            Runtime.getRuntime().gc();
        } catch (OutOfMemoryError unused2) {
            if (decodeFile != null && !decodeFile.isRecycled()) {
                decodeFile.recycle();
            }
            Runtime.getRuntime().gc();
        }
        if (z) {
            try {
                decodeFile = BitmapFactory.decodeFile(str, options);
            } catch (Exception unused3) {
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                decodeFile = BitmapFactory.decodeFile(str, options);
            }
        }
        if (decodeFile != null) {
            if (i2 == 90) {
                i2 += 180;
            }
            Bitmap rotateBitmapByDegree = rotateBitmapByDegree(decodeFile, i2);
            return rotateBitmapByDegree.getWidth() >= 1080 ? zoomBitmap(rotateBitmapByDegree, g0.b.f14277h, (rotateBitmapByDegree.getHeight() * g0.b.f14277h) / rotateBitmapByDegree.getWidth()) : rotateBitmapByDegree;
        }
        return decodeFile;
    }

    public static String getImageTypeWithMime(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        String str2 = options.outMimeType;
        Log.d(TAG, "getImageTypeWithMime: type1 = " + str2);
        String substring = TextUtils.isEmpty(str2) ? "" : str2.substring(6);
        Log.d(TAG, "getImageTypeWithMime: type2 = " + substring);
        return substring;
    }

    public static int[] getImageWidthHeight(String str) {
        int i2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, -1);
            if (attributeInt != -1) {
                if (attributeInt == 6) {
                    i3 = options.outHeight;
                    i2 = options.outWidth;
                } else if (attributeInt == 8) {
                    i3 = options.outHeight;
                    i2 = options.outWidth;
                }
                i4 = i2;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return new int[]{i3, i4};
    }

    public static float getLongImageMaxScale(Context context, String str) {
        return getLongImageMinScale(context, str) * 2.0f;
    }

    public static float getLongImageMinScale(Context context, String str) {
        return MoorDensityUtil.getScreenWidth(context.getApplicationContext()) / getWidthHeight(str)[0];
    }

    public static int getOrientation(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static float getSmallImageMaxScale(Context context, String str) {
        return (MoorDensityUtil.getScreenWidth(context.getApplicationContext()) * 2.0f) / getWidthHeight(str)[0];
    }

    public static float getSmallImageMinScale(Context context, String str) {
        return MoorDensityUtil.getScreenWidth(context.getApplicationContext()) / getWidthHeight(str)[0];
    }

    public static float getWideImageDoubleScale(Context context, String str) {
        return MoorDensityUtil.getScreenHeight(context.getApplicationContext()) / getWidthHeight(str)[1];
    }

    public static int[] getWidthHeight(String str) {
        Bitmap decodeFile;
        if (str.isEmpty()) {
            return new int[]{0, 0};
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (i3 == -1 || i2 == -1) {
            try {
                ExifInterface exifInterface = new ExifInterface(str);
                i3 = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, 1);
                i2 = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, 1);
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        if ((i2 <= 0 || i3 <= 0) && (decodeFile = BitmapFactory.decodeFile(str)) != null) {
            i2 = decodeFile.getWidth();
            i3 = decodeFile.getHeight();
            try {
                if (!decodeFile.isRecycled()) {
                    decodeFile.recycle();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        int orientation = getOrientation(str);
        return (orientation == 90 || orientation == 270) ? new int[]{i3, i2} : new int[]{i2, i3};
    }

    public static boolean isBmpImageWithMime(String str, String str2) {
        return "bmp".equalsIgnoreCase(getImageTypeWithMime(str2)) || str.toLowerCase().endsWith("bmp");
    }

    public static boolean isGifImageWithMime(String str, String str2) {
        return "gif".equalsIgnoreCase(getImageTypeWithMime(str2)) || str.toLowerCase().endsWith("gif");
    }

    public static boolean isJpegImageWithMime(String str, String str2) {
        return "jpeg".equalsIgnoreCase(getImageTypeWithMime(str2)) || "jpg".equalsIgnoreCase(getImageTypeWithMime(str2)) || str.toLowerCase().endsWith("jpeg") || str.toLowerCase().endsWith("jpg");
    }

    public static boolean isLongImage(Context context, String str) {
        int[] widthHeight = getWidthHeight(str);
        float f2 = widthHeight[0];
        float f3 = widthHeight[1];
        return f2 > 0.0f && f3 > 0.0f && f3 > f2 && f3 / f2 >= MoorDensityUtil.getPhoneRatio(context.getApplicationContext()) + 0.1f;
    }

    public static boolean isNullImageWithMime(String str, String str2) {
        return "".equalsIgnoreCase(getImageTypeWithMime(str2)) || str.toLowerCase().endsWith("");
    }

    public static boolean isPngImageWithMime(String str, String str2) {
        return "png".equalsIgnoreCase(getImageTypeWithMime(str2)) || str.toLowerCase().endsWith("png");
    }

    public static boolean isSmallImage(Context context, String str) {
        return getWidthHeight(str)[0] < MoorDensityUtil.getScreenWidth(context.getApplicationContext());
    }

    public static boolean isStandardImage(String str, String str2) {
        return isJpegImageWithMime(str, str2) || isPngImageWithMime(str, str2) || isBmpImageWithMime(str, str2) || isNullImageWithMime(str, str2);
    }

    public static boolean isWideImage(Context context, String str) {
        int[] widthHeight = getWidthHeight(str);
        float f2 = widthHeight[0];
        float f3 = widthHeight[1];
        return f2 > 0.0f && f3 > 0.0f && f2 > f3 && f2 / f3 >= 2.0f;
    }

    public static MoorImageInfoBean resizeImageView(float f2, float f3) {
        MoorImageInfoBean moorImageInfoBean = new MoorImageInfoBean();
        moorImageInfoBean.setLayoutW(0);
        moorImageInfoBean.setLayoutH(0);
        moorImageInfoBean.setRealSize(0);
        MoorImageType moorImageType = MoorImageType.COMMON;
        moorImageInfoBean.setType(moorImageType);
        if (Math.abs(f2 - f3) == 0.0f) {
            int i2 = MOOR_IMAGEVIEW_MAX;
            moorImageInfoBean.setLayoutW(i2);
            moorImageInfoBean.setLayoutH(i2);
            moorImageInfoBean.setType(moorImageType);
            return moorImageInfoBean;
        } else if (f2 <= f3) {
            if (f2 < f3) {
                moorImageInfoBean.setLayoutH(MOOR_IMAGEVIEW_MAX);
                float f4 = f3 / f2;
                if (f4 >= 3.0d) {
                    moorImageInfoBean.setLayoutW(MOOR_IMAGEVIEW_MIN);
                    moorImageInfoBean.setRealSize((int) (moorImageInfoBean.getLayoutW() * f4));
                } else {
                    moorImageInfoBean.setLayoutW((int) (moorImageInfoBean.getLayoutH() / f4));
                    moorImageInfoBean.setRealSize(moorImageInfoBean.getLayoutH());
                }
                moorImageInfoBean.setType(MoorImageType.VERTICAL);
            }
            return moorImageInfoBean;
        } else {
            int i3 = MOOR_IMAGEVIEW_MAX;
            moorImageInfoBean.setLayoutW(i3);
            float f5 = f2 / f3;
            if (f5 >= 3.0d) {
                int i4 = (int) ((f5 - 2.0f) * 10.0f);
                if (i4 > 40) {
                    i4 = 40;
                }
                moorImageInfoBean.setLayoutW(i3 + MoorDensityUtil.dp2px(i4));
                moorImageInfoBean.setLayoutH(MOOR_IMAGEVIEW_MIN);
                moorImageInfoBean.setRealSize((int) (moorImageInfoBean.getLayoutH() * f5));
            } else {
                moorImageInfoBean.setLayoutH((int) (moorImageInfoBean.getLayoutW() / f5));
                moorImageInfoBean.setRealSize(moorImageInfoBean.getLayoutW());
            }
            moorImageInfoBean.setType(MoorImageType.HORIZONTAL);
            return moorImageInfoBean;
        }
    }

    public static Bitmap rotateBitmapByDegree(Bitmap bitmap, int i2) {
        Bitmap bitmap2;
        Matrix matrix = new Matrix();
        matrix.postRotate(i2);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
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

    private static Bitmap zoomBitmap(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}

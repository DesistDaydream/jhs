package com.moor.imkf.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.YKFConstants;
import com.qiniu.android.common.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class MoorUtils {
    private static Application sApplication;

    public static String ToDBC(String str) {
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] == 12288) {
                charArray[i2] = ' ';
            } else if (charArray[i2] > 65280 && charArray[i2] < 65375) {
                charArray[i2] = (char) (charArray[i2] - 65248);
            }
        }
        return new String(charArray);
    }

    public static String bitmaptoString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static Application getApp() {
        Application application = sApplication;
        if (application != null) {
            return application;
        }
        return null;
    }

    public static String getAppProcessName() {
        return getApp().getPackageName();
    }

    public static String getDeviceId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(YKFConstants.MOOR_SP, 0);
        String string = sharedPreferences.getString(YKFConstants.MOORDEVICEUUID, "");
        try {
            if (TextUtils.isEmpty(string)) {
                string = new UUID(("80455555" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.DEVICE.length() % 10) + (Build.HARDWARE.length() % 10) + (Build.ID.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10)).hashCode(), Build.ID.hashCode()).toString();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(YKFConstants.MOORDEVICEUUID, string);
                edit.commit();
            }
        } catch (Exception unused) {
            string = "111";
        }
        return TextUtils.isEmpty(string) ? "111" : string;
    }

    public static String getDeviceModel() {
        String str;
        try {
            str = Build.MODEL;
        } catch (Exception e2) {
            e2.printStackTrace();
            str = "Android";
        }
        return isChinese(str) ? "Android" : str;
    }

    public static List<String> getEmojiFile(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            InputStream open = context.getResources().getAssets().open("emojikf");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Constants.UTF_8));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    arrayList.add(readLine);
                } else {
                    open.close();
                    bufferedReader.close();
                    return arrayList;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < digest.length; i2++) {
                if (Integer.toHexString(digest[i2] & 255).length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(Integer.toHexString(digest[i2] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(digest[i2] & 255));
                }
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String getSDPath() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().getPath();
        }
        return null;
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void init(@NonNull Application application) {
        sApplication = application;
    }

    public static void initForUnread(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(YKFConstants.MOOR_SP, 0).edit();
        edit.putBoolean(YKFConstants.ISINIT, true);
        edit.commit();
    }

    public static boolean isChinese(char c2) {
        return c2 >= 19968 && c2 <= 40869;
    }

    public static boolean isChinese(String str) {
        if (str == null) {
            return false;
        }
        for (char c2 : str.toCharArray()) {
            if (isChinese(c2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExitsSdcard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static Boolean isInitForUnread(Context context) {
        if (IMChatManager.getInstance().getAppContext() == null) {
            IMChatManager.getInstance().setAppContext(context);
        }
        return Boolean.valueOf(context.getSharedPreferences(YKFConstants.MOOR_SP, 0).getBoolean(YKFConstants.ISINIT, false));
    }

    public static boolean isNetWorkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context != null && (activeNetworkInfo = (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
            if (activeNetworkInfo.getType() == 0 && connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED) {
                return activeNetworkInfo.isAvailable();
            }
            if (1 == activeNetworkInfo.getType() && connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
                return activeNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static String replaceBlank(String str) {
        return str != null ? Pattern.compile("\\s*|\t|\r|\n|\\n|\\\\").matcher(str).replaceAll("") : "";
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static String string2Unicode(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            stringBuffer.append("\\u" + Integer.toHexString(charAt));
        }
        return stringBuffer.toString();
    }

    public static CharSequence trimTrailingWhitespace(CharSequence charSequence) {
        if (charSequence == null) {
            return "";
        }
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (Character.isWhitespace(charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }
}

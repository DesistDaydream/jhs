package com.tencent.qcloud.tuicore;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TUIConfig {
    public static final String COMMON_SP = "common_sp";
    private static final String CRASH_LOG_DIR_SUFFIX = "/crash/";
    private static final String FILE_DOWNLOAD_DIR_SUFFIX = "/file/download/";
    public static final String GLOBAL_CONFIG = "globalConfig";
    private static final String IMAGE_BASE_DIR_SUFFIX = "/image/";
    private static final String IMAGE_DOWNLOAD_DIR_SUFFIX = "/image/download/";
    private static final String MEDIA_DIR_SUFFIX = "/media/";
    private static final String RECORD_DIR_SUFFIX = "/record/";
    private static final String RECORD_DOWNLOAD_DIR_SUFFIX = "/record/download/";
    public static final String TUICORE_SETTINGS_SP_NAME = "TUICoreSettings";
    private static final String VIDEO_DOWNLOAD_DIR_SUFFIX = "/video/download/";
    public static Context appContext = null;
    private static String appDir = "";
    private static int gender = 0;
    private static boolean initialized = false;
    private static int selfAllowType = 0;
    private static long selfBirthDay = 0;
    private static String selfFaceUrl = "";
    private static String selfNickName = "";
    private static String selfSignature = "";

    public static void clearSelfInfo() {
        selfFaceUrl = "";
        selfNickName = "";
        selfAllowType = 0;
        selfBirthDay = 0L;
        selfSignature = "";
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static String getCrashLogDir() {
        return getDefaultAppDir() + CRASH_LOG_DIR_SUFFIX;
    }

    public static String getDefaultAppDir() {
        if (TextUtils.isEmpty(appDir)) {
            Context context = null;
            Context context2 = appContext;
            if (context2 != null) {
                context = context2;
            } else if (TUIRouter.getContext() != null) {
                context = TUIRouter.getContext();
            } else if (TUILogin.getAppContext() != null) {
                context = TUILogin.getAppContext();
            }
            if (context != null) {
                appDir = context.getFilesDir().getAbsolutePath();
            }
        }
        return appDir;
    }

    public static String getFileDownloadDir() {
        return getDefaultAppDir() + FILE_DOWNLOAD_DIR_SUFFIX;
    }

    public static int getGender() {
        return gender;
    }

    public static String getImageBaseDir() {
        return getDefaultAppDir() + IMAGE_BASE_DIR_SUFFIX;
    }

    public static String getImageDownloadDir() {
        return getDefaultAppDir() + IMAGE_DOWNLOAD_DIR_SUFFIX;
    }

    public static String getMediaDir() {
        return getDefaultAppDir() + MEDIA_DIR_SUFFIX;
    }

    public static String getRecordDir() {
        return getDefaultAppDir() + RECORD_DIR_SUFFIX;
    }

    public static String getRecordDownloadDir() {
        return getDefaultAppDir() + RECORD_DOWNLOAD_DIR_SUFFIX;
    }

    public static int getSelfAllowType() {
        return selfAllowType;
    }

    public static long getSelfBirthDay() {
        return selfBirthDay;
    }

    public static String getSelfFaceUrl() {
        return selfFaceUrl;
    }

    public static String getSelfNickName() {
        return selfNickName;
    }

    public static String getSelfSignature() {
        return selfSignature;
    }

    public static String getVideoDownloadDir() {
        return getDefaultAppDir() + VIDEO_DOWNLOAD_DIR_SUFFIX;
    }

    public static void init(Context context) {
        if (initialized) {
            return;
        }
        appContext = context;
        initPath();
        initialized = true;
    }

    public static void initPath() {
        File file = new File(getMediaDir());
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(getRecordDir());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(getRecordDownloadDir());
        if (!file3.exists()) {
            file3.mkdirs();
        }
        File file4 = new File(getVideoDownloadDir());
        if (!file4.exists()) {
            file4.mkdirs();
        }
        File file5 = new File(getImageDownloadDir());
        if (!file5.exists()) {
            file5.mkdirs();
        }
        File file6 = new File(getFileDownloadDir());
        if (!file6.exists()) {
            file6.mkdirs();
        }
        File file7 = new File(getCrashLogDir());
        if (file7.exists()) {
            return;
        }
        file7.mkdirs();
    }

    public static void setDefaultAppDir(String str) {
        appDir = str;
    }

    public static void setGender(int i2) {
        gender = i2;
    }

    public static void setSceneOptimizParams(final String str) {
        new Thread(new Runnable() { // from class: com.tencent.qcloud.tuicore.TUIConfig.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String str2 = TUILogin.getSdkAppId() + "";
                    String userId = TUILogin.getUserId();
                    String packageName = TUIConfig.getAppContext() != null ? TUIConfig.getAppContext().getPackageName() : "";
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://demos.trtc.tencent-cloud.com/prod/base/v1/events/stat").openConnection();
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sdkappid", str2);
                    jSONObject.put("bundleId", "");
                    jSONObject.put("component", str);
                    jSONObject.put("package", packageName);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(TUIConstants.TUILive.USER_ID, userId);
                    jSONObject2.put("event", "useScenario");
                    jSONObject2.put("msg", jSONObject);
                    String valueOf = String.valueOf(jSONObject2);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(valueOf.getBytes());
                    outputStream.flush();
                    outputStream.close();
                    if (httpURLConnection.getResponseCode() == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                Log.d("setSceneOptimizParams", "msg:" + new String(byteArrayOutputStream.toByteArray()));
                                inputStream.close();
                                byteArrayOutputStream.close();
                                httpURLConnection.disconnect();
                                return;
                            }
                        }
                    } else {
                        Log.d("setSceneOptimizParams", "ResponseCode:" + httpURLConnection.getResponseCode());
                    }
                } catch (Exception unused) {
                    Log.d("TUICore", "setSceneOptimizParams exception");
                }
            }
        }).start();
    }

    public static void setSelfAllowType(int i2) {
        selfAllowType = i2;
    }

    public static void setSelfBirthDay(long j2) {
        selfBirthDay = j2;
    }

    public static void setSelfFaceUrl(String str) {
        selfFaceUrl = str;
    }

    public static void setSelfInfo(V2TIMUserFullInfo v2TIMUserFullInfo) {
        selfFaceUrl = v2TIMUserFullInfo.getFaceUrl();
        selfNickName = v2TIMUserFullInfo.getNickName();
        selfAllowType = v2TIMUserFullInfo.getAllowType();
        selfBirthDay = v2TIMUserFullInfo.getBirthday();
        selfSignature = v2TIMUserFullInfo.getSelfSignature();
        gender = v2TIMUserFullInfo.getGender();
    }

    public static void setSelfNickName(String str) {
        selfNickName = str;
    }

    public static void setSelfSignature(String str) {
        selfSignature = str;
    }
}

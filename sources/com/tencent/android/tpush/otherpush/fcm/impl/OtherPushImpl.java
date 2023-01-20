package com.tencent.android.tpush.otherpush.fcm.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.android.fcm.Constants;
import com.tencent.android.fcm.Util;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import e.j.a.b.c.e;
import e.j.a.b.c.f;
import e.j.a.b.j.k;
import e.j.d.i.a;

/* loaded from: classes3.dex */
public class OtherPushImpl {
    private static final int FCM_API_VERSION_22 = 22;
    private static final int FCM_API_VERSION_ERROR = -1;
    private static final int FCM_API_VERSION_LOWER_22 = 17;
    private static final String SP_FILE = "xg.otherpush.xml";
    public static final String TPUSH_FCM_TOKEN = "XG_V2_FCM_APP_TOKEN";
    private static int fcmApiVersion = 0;
    public static String fcmToken = "";
    private static int isAvailable = -1;

    public static boolean checkDevice(Context context) {
        int j2;
        if (isAvailable == -1) {
            try {
                j2 = e.v().j(context);
            } catch (Throwable unused) {
                j2 = f.i().j(context);
            }
            TLogger.d(Constants.OTHER_PUSH_TAG, " GooglePlayServices service resultCode = " + j2);
            if (j2 != 0 && j2 != 2 && j2 != 21) {
                TLogger.d(Constants.OTHER_PUSH_TAG, " GooglePlayServices is not supported");
                isAvailable = 0;
            } else {
                TLogger.d(Constants.OTHER_PUSH_TAG, "This device is supported, GooglePlayServices service is running");
                isAvailable = 1;
            }
        }
        return isAvailable == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getFCMVersion() {
        if (fcmApiVersion == 0) {
            try {
                Class.forName("e.j.d.i.a").getDeclaredMethod("getToken", new Class[0]);
                TLogger.i(Constants.OTHER_PUSH_TAG, "get FCM version over 22");
                fcmApiVersion = 22;
            } catch (NoSuchMethodException unused) {
                TLogger.i(Constants.OTHER_PUSH_TAG, "get FCM version lower 22");
                fcmApiVersion = 17;
            } catch (Throwable unused2) {
                TLogger.w(Constants.OTHER_PUSH_TAG, "Missing FCM SDK");
                fcmApiVersion = -1;
            }
        }
        return fcmApiVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences getOtherPushSharedPreferences(Context context) {
        if (Build.VERSION.SDK_INT >= 11) {
            return context.getSharedPreferences(SP_FILE, 4);
        }
        return context.getSharedPreferences(SP_FILE, 0);
    }

    public static String getPushInfo() {
        return "fcm";
    }

    public static String getToken(final Context context) {
        try {
            if (!Util.isNullOrEmptyString(fcmToken)) {
                return fcmToken;
            }
            SharedPreferences otherPushSharedPreferences = getOtherPushSharedPreferences(context);
            if (otherPushSharedPreferences != null) {
                String string = otherPushSharedPreferences.getString("XG_V2_FCM_APP_TOKEN," + context.getPackageName(), null);
                if (!Util.isNullOrEmptyString(string)) {
                    String decrypt = Rijndael.decrypt(string);
                    fcmToken = decrypt;
                    if (!Util.isNullOrEmptyString(decrypt)) {
                        return fcmToken;
                    }
                }
            }
            if (getFCMVersion() == -1) {
                return fcmToken;
            }
            if (getFCMVersion() == 22) {
                a.a().getToken().e(new e.j.a.b.j.e<String>() { // from class: com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl.4
                    @Override // e.j.a.b.j.e
                    public void onComplete(@NonNull k<String> kVar) {
                        if (!kVar.v()) {
                            TLogger.w(Constants.OTHER_PUSH_TAG, "getToken failed", kVar.q());
                            return;
                        }
                        OtherPushImpl.fcmToken = kVar.r();
                        SharedPreferences otherPushSharedPreferences2 = OtherPushImpl.getOtherPushSharedPreferences(context);
                        if (otherPushSharedPreferences2 != null) {
                            SharedPreferences.Editor edit = otherPushSharedPreferences2.edit();
                            edit.putString("XG_V2_FCM_APP_TOKEN," + context.getPackageName(), Rijndael.encrypt(OtherPushImpl.fcmToken));
                            edit.commit();
                        }
                    }
                });
            } else {
                FirebaseInstanceId.e().f().e(new e.j.a.b.j.e<e.j.d.f.a>() { // from class: com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl.5
                    @Override // e.j.a.b.j.e
                    public void onComplete(@NonNull k<e.j.d.f.a> kVar) {
                        if (!kVar.v()) {
                            TLogger.w("OTHER_PUSH_TAG", "getInstanceId failed", kVar.q());
                            return;
                        }
                        OtherPushImpl.fcmToken = kVar.r().getToken();
                        SharedPreferences otherPushSharedPreferences2 = OtherPushImpl.getOtherPushSharedPreferences(context);
                        if (otherPushSharedPreferences2 != null) {
                            SharedPreferences.Editor edit = otherPushSharedPreferences2.edit();
                            edit.putString("XG_V2_FCM_APP_TOKEN," + context.getPackageName(), Rijndael.encrypt(OtherPushImpl.fcmToken));
                            edit.commit();
                        }
                    }
                });
            }
            return fcmToken;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void registerPush(final Context context) {
        try {
            if (getFCMVersion() == -1) {
                return;
            }
            if (getFCMVersion() == 22) {
                a.a().getToken().e(new e.j.a.b.j.e<String>() { // from class: com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl.1
                    @Override // e.j.a.b.j.e
                    public void onComplete(@NonNull k<String> kVar) {
                        if (!kVar.v()) {
                            TLogger.w(Constants.OTHER_PUSH_TAG, "getToken failed", kVar.q());
                            return;
                        }
                        OtherPushImpl.fcmToken = kVar.r();
                        TLogger.d(Constants.OTHER_PUSH_TAG, " OtherPushImpl registerFcmPush getToken= " + OtherPushImpl.fcmToken);
                        SharedPreferences otherPushSharedPreferences = OtherPushImpl.getOtherPushSharedPreferences(context);
                        if (otherPushSharedPreferences != null) {
                            SharedPreferences.Editor edit = otherPushSharedPreferences.edit();
                            edit.putString("XG_V2_FCM_APP_TOKEN," + context.getPackageName(), Rijndael.encrypt(OtherPushImpl.fcmToken));
                            edit.commit();
                        }
                    }
                });
            } else {
                FirebaseInstanceId.e().f().e(new e.j.a.b.j.e<e.j.d.f.a>() { // from class: com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl.2
                    @Override // e.j.a.b.j.e
                    public void onComplete(@NonNull k<e.j.d.f.a> kVar) {
                        if (!kVar.v()) {
                            TLogger.w(Constants.OTHER_PUSH_TAG, "getInstanceId failed", kVar.q());
                            return;
                        }
                        OtherPushImpl.fcmToken = kVar.r().getToken();
                        TLogger.d(Constants.OTHER_PUSH_TAG, " OtherPushImpl registerFcmPush getToken= " + OtherPushImpl.fcmToken);
                        SharedPreferences otherPushSharedPreferences = OtherPushImpl.getOtherPushSharedPreferences(context);
                        if (otherPushSharedPreferences != null) {
                            SharedPreferences.Editor edit = otherPushSharedPreferences.edit();
                            edit.putString("XG_V2_FCM_APP_TOKEN," + context.getPackageName(), Rijndael.encrypt(OtherPushImpl.fcmToken));
                            edit.commit();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            TLogger.e(Constants.OTHER_PUSH_TAG, "FCM Register error! " + th);
            fcmToken = null;
        }
    }

    public static void setToken(Context context, String str) {
        fcmToken = str;
        if (str == null) {
            fcmToken = "";
        }
        SharedPreferences otherPushSharedPreferences = getOtherPushSharedPreferences(context);
        if (otherPushSharedPreferences != null) {
            SharedPreferences.Editor edit = otherPushSharedPreferences.edit();
            edit.putString("XG_V2_FCM_APP_TOKEN," + context.getPackageName(), Rijndael.encrypt(fcmToken));
            edit.commit();
        }
    }

    public static void unregisterPush(Context context) {
        try {
            if (getFCMVersion() == -1) {
                return;
            }
            new Thread(new Runnable() { // from class: com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (FirebaseApp.getInstance() != null) {
                            if (FirebaseApp.getInstance().getOptions() != null) {
                                if (OtherPushImpl.getFCMVersion() == 22) {
                                    a.a().deleteToken();
                                } else {
                                    FirebaseInstanceId.e().b(FirebaseApp.getInstance().getOptions().getGcmSenderId(), a.b);
                                    TLogger.i(Constants.OTHER_PUSH_TAG, "FCM unregisterPush success !");
                                }
                            } else {
                                TLogger.i(Constants.OTHER_PUSH_TAG, "FCM unregisterPush fail !");
                            }
                        } else {
                            TLogger.i(Constants.OTHER_PUSH_TAG, "FCM unregisterPush fail !");
                        }
                    } catch (IllegalStateException unused) {
                    } catch (Throwable th) {
                        TLogger.e(Constants.OTHER_PUSH_TAG, "FCM deleteInstanceId error! " + th);
                    }
                }
            }).start();
        } catch (Throwable th) {
            TLogger.e(Constants.OTHER_PUSH_TAG, "FCM unregister error! " + th);
        }
    }
}

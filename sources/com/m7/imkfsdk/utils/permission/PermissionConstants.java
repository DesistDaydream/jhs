package com.m7.imkfsdk.utils.permission;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class PermissionConstants {
    public static final String CALL_PHONE = "android.permission.CALL_PHONE";
    public static final String CAMERA = "android.permission.CAMERA";
    public static final String PHONE_STATE = "android.permission.READ_PHONE_STATE";
    public static final String READ_CONTACTS = "android.permission.READ_CONTACTS";
    public static final String RECORD_AUDIO = "android.permission.RECORD_AUDIO";
    public static final String STORE = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static PermissionConstants instance;
    private static HashMap<String, String> perMap = new HashMap<>();

    public PermissionConstants() {
        perMap.put(STORE, "存储");
        perMap.put(CAMERA, "相机");
        perMap.put(RECORD_AUDIO, "麦克风");
    }

    public static synchronized PermissionConstants getInstance() {
        PermissionConstants permissionConstants;
        synchronized (PermissionConstants.class) {
            if (instance == null) {
                synchronized (PermissionConstants.class) {
                    if (instance == null) {
                        instance = new PermissionConstants();
                    }
                }
            }
            permissionConstants = instance;
        }
        return permissionConstants;
    }

    public String getPermissionName(String str) {
        return perMap.get(str);
    }
}

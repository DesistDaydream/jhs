package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e {
    public static volatile String a = "";
    public static volatile String b = "";

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f5569c = "";

    /* renamed from: d  reason: collision with root package name */
    public static long f5570d = 512000;

    /* renamed from: e  reason: collision with root package name */
    public static long f5571e = 50;

    /* renamed from: f  reason: collision with root package name */
    public static long f5572f = 5242880;

    /* renamed from: g  reason: collision with root package name */
    public static long f5573g = 31457280;

    /* renamed from: h  reason: collision with root package name */
    public static long f5574h = 10485760;

    /* renamed from: i  reason: collision with root package name */
    public static final JSONObject f5575i = new JSONObject();

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a = str;
    }
}

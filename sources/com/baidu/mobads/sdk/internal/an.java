package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class an {
    private static final String a = v.n;
    private static final String b = "pauseDlByPk";

    /* renamed from: c  reason: collision with root package name */
    private static final String f1443c = "resumeDownload";

    /* renamed from: d  reason: collision with root package name */
    private static final String f1444d = "getDownloadStatus";

    /* renamed from: f  reason: collision with root package name */
    private static an f1445f;

    /* renamed from: e  reason: collision with root package name */
    private ao f1446e;

    private an(Context context) {
        this.f1446e = ao.a(context, a);
    }

    public static an a(Context context) {
        if (f1445f == null) {
            synchronized (an.class) {
                if (f1445f == null) {
                    f1445f = new an(context);
                }
            }
        }
        return f1445f;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f1446e.a(null, b, str);
    }

    public boolean a(Context context, JSONObject jSONObject, String str, String str2) {
        if (context != null && jSONObject != null) {
            Object b2 = this.f1446e.b(null, f1443c, context, jSONObject, str, str2);
            if (b2 instanceof Boolean) {
                return ((Boolean) b2).booleanValue();
            }
        }
        return false;
    }

    public int a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (bk.a(context, str)) {
            return 103;
        }
        Object b2 = this.f1446e.b(null, f1444d, str);
        if (b2 instanceof Integer) {
            return ((Integer) b2).intValue();
        }
        return -1;
    }
}

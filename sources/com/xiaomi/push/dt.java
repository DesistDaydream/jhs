package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.e.comm.constants.ErrorCode;

/* loaded from: classes3.dex */
public class dt {
    private static volatile dt a;
    private Context b;

    private dt(Context context) {
        this.b = context;
    }

    public static dt a(Context context) {
        if (a == null) {
            synchronized (dt.class) {
                if (a == null) {
                    a = new dt(context);
                }
            }
        }
        return a;
    }

    private void a(com.xiaomi.b.a.d dVar) {
        if (dVar instanceof com.xiaomi.b.a.c) {
            com.xiaomi.b.b.a.a(this.b, (com.xiaomi.b.a.c) dVar);
        } else if (dVar instanceof com.xiaomi.b.a.b) {
            com.xiaomi.b.b.a.a(this.b, (com.xiaomi.b.a.b) dVar);
        }
    }

    public void a(String str, int i2, long j2, long j3) {
        if (i2 < 0 || j3 < 0 || j2 <= 0) {
            return;
        }
        com.xiaomi.b.a.c a2 = ds.a(this.b, i2, j2, j3);
        a2.a(str);
        a2.b("4_9_1");
        a(a2);
    }

    public void a(String str, Intent intent, int i2, String str2) {
        if (intent == null) {
            return;
        }
        a(str, ds.a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i2, System.currentTimeMillis(), str2);
    }

    public void a(String str, Intent intent, String str2) {
        if (intent == null) {
            return;
        }
        a(str, ds.a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), ErrorCode.SERVER_JSON_PARSE_ERROR, System.currentTimeMillis(), str2);
    }

    public void a(String str, String str2, String str3, int i2, long j2, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.xiaomi.b.a.b a2 = ds.a(this.b, str2, str3, i2, j2, str4);
        a2.a(str);
        a2.b("4_9_1");
        a(a2);
    }

    public void a(String str, String str2, String str3, int i2, String str4) {
        a(str, str2, str3, i2, System.currentTimeMillis(), str4);
    }

    public void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, ErrorCode.VIDEO_DOWNLOAD_FAIL, System.currentTimeMillis(), str4);
    }

    public void b(String str, String str2, String str3, String str4) {
        a(str, str2, str3, ErrorCode.SERVER_JSON_PARSE_ERROR, System.currentTimeMillis(), str4);
    }

    public void c(String str, String str2, String str3, String str4) {
        a(str, str2, str3, ErrorCode.MANIFEST_ERROR, System.currentTimeMillis(), str4);
    }
}

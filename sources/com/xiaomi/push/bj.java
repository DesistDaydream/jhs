package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.android.tpush.common.Constants;
import com.xiaomi.push.bm;

/* loaded from: classes3.dex */
public class bj extends bm.e {
    private String a;

    public bj(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.a = "MessageInsertJob";
        this.a = str2;
    }

    public static bj a(Context context, String str, gu guVar) {
        byte[] a = ib.a(guVar);
        if (a == null || a.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", guVar.m());
        contentValues.put("messageItem", a);
        contentValues.put("appId", az.a(context).b());
        contentValues.put(Constants.FLAG_PACKAGE_NAME, az.a(context).a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new bj(str, contentValues, "a job build to insert message to db");
    }
}

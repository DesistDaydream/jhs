package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes3.dex */
public class ag implements z {
    private static final String a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(Uri.parse(a), null, null, null, null);
        if (query != null) {
            r0 = query.moveToNext() ? query.getString(query.getColumnIndex("device_ids_grndid")) : null;
            query.close();
        }
        return r0;
    }
}

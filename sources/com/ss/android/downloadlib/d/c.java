package com.ss.android.downloadlib.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.qiniu.android.collect.ReportItem;
import com.ss.android.downloadlib.addownload.j;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c {
    private static volatile c b;
    private SQLiteDatabase a;

    private c() {
        try {
            this.a = new b(j.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.e.c.a().a(th, "ClickEventHelper");
        }
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public boolean b() {
        return com.ss.android.socialbase.downloader.g.a.c().a("click_event_switch", 0) == 1;
    }

    public boolean c() {
        return com.ss.android.socialbase.downloader.g.a.c().a("click_event_switch", 0) == 2;
    }

    private void c(long j2, String str) {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString(ReportItem.RequestKeyRequestId);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.a.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j2), optString});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean b(long j2, String str) {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                String optString = new JSONObject(str).optString(ReportItem.RequestKeyRequestId);
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                cursor = this.a.query("click_event", b.a, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j2), optString}, null, null, null, null);
                boolean z = cursor.getCount() > 0;
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void a(long j2, String str) {
        String optString;
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            optString = new JSONObject(str).optString(ReportItem.RequestKeyRequestId);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(GMAdConstant.EXTRA_ADID, Long.valueOf(j2));
        contentValues.put(ReportItem.RequestKeyRequestId, optString);
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        this.a.insert("click_event", null, contentValues);
        c(j2, str);
    }
}

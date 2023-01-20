package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class c {
    public static Cursor a(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        Cursor a;
        synchronized (c.class) {
            a = TextUtils.isEmpty(str) ? null : a.a(context).a().a(str, strArr, str2, strArr2, null, null, str5);
        }
        return a;
    }

    public static void a(Context context, String str) {
        synchronized (c.class) {
            if (!TextUtils.isEmpty(str)) {
                a.a(context).a().a(Uri.decode(str));
            }
        }
    }

    public static void a(Context context, String str, ContentValues contentValues) {
        synchronized (c.class) {
            if (contentValues != null) {
                if (!TextUtils.isEmpty(str)) {
                    a.a(context).a().a(str, null, contentValues);
                }
            }
        }
    }
}

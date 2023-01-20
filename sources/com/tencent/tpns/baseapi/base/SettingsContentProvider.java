package com.tencent.tpns.baseapi.base;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;
import com.tencent.tpns.baseapi.base.util.Util;
import java.util.Map;

/* loaded from: classes3.dex */
public class SettingsContentProvider extends ContentProvider {
    public static Uri BASE_URI = null;
    public static final String BOOLEAN_TYPE = "boolean";
    public static final String FLOAT_TYPE = "float";
    public static final String INT_TYPE = "integer";
    public static final String KEY = "key";
    public static final String LONG_TYPE = "long";
    public static final String MEMORY_TYPE = "memory";
    public static final String PREFFERENCE_AUTHORITY = "XG_SETTINGS_PROVIDER";
    public static final String STRING_TYPE = "string";
    public static final String TYPE = "type";
    private static UriMatcher a;
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private static int f6838c;

    /* renamed from: d  reason: collision with root package name */
    private static SharedPreferences f6839d;

    private void a(Context context) {
        if (b == null) {
            b = context.getPackageName() + "." + PREFFERENCE_AUTHORITY;
        }
        if (a == null) {
            UriMatcher uriMatcher = new UriMatcher(-1);
            a = uriMatcher;
            uriMatcher.addURI(b, "*/*", 65536);
        }
        if (BASE_URI == null) {
            BASE_URI = Uri.parse("content://" + b);
        }
        if (f6839d == null) {
            f6839d = context.getApplicationContext().getSharedPreferences(".xg.vip.settings.xml", 0);
        }
    }

    public static boolean getBooleanValue(Cursor cursor, boolean z) {
        if (cursor == null) {
            return z;
        }
        if (cursor.moveToFirst()) {
            z = false;
            if (cursor.getInt(0) > 0) {
                z = true;
            }
        }
        cursor.close();
        return z;
    }

    public static final Uri getContentUri(Context context, String str, String str2) {
        if (BASE_URI == null) {
            if (b == null) {
                b = context.getPackageName() + "." + PREFFERENCE_AUTHORITY;
            }
            BASE_URI = Uri.parse("content://" + b);
        }
        return BASE_URI.buildUpon().appendPath(str).appendPath(str2).build();
    }

    public static float getFloatValue(Cursor cursor, float f2) {
        if (cursor == null) {
            return f2;
        }
        if (cursor.moveToFirst()) {
            f2 = cursor.getFloat(0);
        }
        cursor.close();
        return f2;
    }

    public static int getIntValue(Cursor cursor, int i2) {
        if (cursor == null) {
            return i2;
        }
        if (cursor.moveToFirst()) {
            i2 = cursor.getInt(0);
        }
        cursor.close();
        return i2;
    }

    public static long getLongValue(Cursor cursor, long j2) {
        if (cursor == null) {
            return j2;
        }
        if (cursor.moveToFirst()) {
            j2 = cursor.getLong(0);
        }
        cursor.close();
        return j2;
    }

    public static Object getObjectValue(Cursor cursor, String str) {
        if (cursor == null) {
            return str;
        }
        if (cursor.moveToFirst()) {
            str = cursor.getString(0);
        }
        cursor.close();
        return str;
    }

    public static int getProviderPid() {
        return f6838c;
    }

    public static String getStringValue(Cursor cursor, String str) {
        if (cursor == null) {
            return str;
        }
        if (cursor.moveToFirst()) {
            str = cursor.getString(0);
        }
        cursor.close();
        return str;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (a.match(uri) != 65536) {
            Logger.e("SettingsContentProvider", "Unsupported uri " + uri);
            return 0;
        }
        f6839d.edit().clear().commit();
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "vnd.android.cursor.item/vnd.XG_SETTINGS_PROVIDER.item";
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"NewApi"})
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (a.match(uri) != 65536) {
            Logger.e("SettingsContentProvider", "Unsupported uri " + uri);
            return null;
        }
        SharedPreferences.Editor edit = f6839d.edit();
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            Object value = entry.getValue();
            String key = Util.getKey(entry.getKey());
            if (value == null) {
                edit.remove(key);
            } else if (value instanceof String) {
                edit.putString(key, (String) value);
            } else if (value instanceof Boolean) {
                edit.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Long) {
                edit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Integer) {
                edit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Float) {
                edit.putFloat(key, ((Float) value).floatValue());
            } else {
                Logger.e("SettingsContentProvider", "Unsupported type " + uri);
            }
        }
        if (Build.VERSION.SDK_INT > 8) {
            edit.apply();
            return null;
        }
        edit.commit();
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Logger.i("SettingsContentProvider", "SettingsContentProvider onCreate");
        f6838c = Process.myPid();
        a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object loadWithIPC;
        if (a.match(uri) != 65536) {
            Logger.e("SettingsContentProvider", "Unsupported uri " + uri);
            return null;
        }
        String str3 = uri.getPathSegments().get(0);
        String key = Util.getKey(str3);
        String str4 = uri.getPathSegments().get(1);
        boolean equals = MEMORY_TYPE.equals(str4);
        if (!f6839d.contains(key) && !equals) {
            key = uri.getPathSegments().get(0);
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{key});
        if (f6839d.contains(key) || equals) {
            MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
            if ("string".equals(str4)) {
                loadWithIPC = f6839d.getString(key, null);
            } else if ("boolean".equals(str4)) {
                loadWithIPC = Integer.valueOf(f6839d.getBoolean(key, false) ? 1 : 0);
            } else if ("long".equals(str4)) {
                loadWithIPC = Long.valueOf(f6839d.getLong(key, 0L));
            } else if ("integer".equals(str4)) {
                loadWithIPC = Integer.valueOf(f6839d.getInt(key, 0));
            } else if ("float".equals(str4)) {
                loadWithIPC = Float.valueOf(f6839d.getFloat(key, 0.0f));
            } else if (equals) {
                loadWithIPC = TGlobalHelper.loadWithIPC(str3);
            } else {
                Logger.e("SettingsContentProvider", "Unsupported type " + uri);
                return matrixCursor;
            }
            newRow.add(loadWithIPC);
            return matrixCursor;
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Logger.e("SettingsContentProvider", "UnsupportedOperation: update!");
        return 0;
    }
}

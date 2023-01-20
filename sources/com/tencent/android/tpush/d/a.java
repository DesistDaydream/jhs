package com.tencent.android.tpush.d;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Build;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.f;
import java.net.URISyntaxException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class a {
    private static long a = 0;
    private static long b = 172800000;

    /* renamed from: c  reason: collision with root package name */
    private static com.tencent.android.tpush.d.a.a f6100c;

    public static boolean a(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("msgId", -1L);
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgid", Long.valueOf(longExtra));
        boolean z = true;
        contentValues.put("message", Rijndael.encrypt(intent.toUri(1)));
        contentValues.put("time", Long.valueOf(f.b(intent)));
        contentValues.put("busiid", Long.valueOf(intent.getLongExtra("busiMsgId", 0L)));
        contentValues.put("showedtime", (Integer) 0);
        contentValues.put("status", (Integer) 0);
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            if (writableDatabase.insert("messagetoshow", null, contentValues) <= 0) {
                TLogger.e("MessageInfoManager", "addCacheMessage Error! ");
                z = false;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            TLogger.e("MessageInfoManager", "addNewCacheMessage Error! " + th);
            return false;
        }
    }

    public static boolean b(Context context, long j2) {
        e(context);
        return a(context, j2, 2);
    }

    public static boolean c(Context context, long j2) {
        return a(context, j2, 3);
    }

    private static com.tencent.android.tpush.d.a.a d(Context context) {
        if (f6100c == null) {
            synchronized (a.class) {
                if (f6100c == null) {
                    f6100c = new com.tencent.android.tpush.d.a.a(context.getApplicationContext());
                }
            }
        }
        return f6100c;
    }

    private static boolean e(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = a;
        boolean z = true;
        if (j2 == 0 || currentTimeMillis - j2 > 86400000) {
            a = currentTimeMillis;
            long j3 = currentTimeMillis - b;
            try {
                SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
                if (writableDatabase.delete("messagetoshow", "status >= ? AND showedtime < ? ", new String[]{"1", j3 + ""}) <= 0) {
                    TLogger.d("MessageInfoManager", "delOldShowedCacheMessage Error! toDelTime: " + j3);
                    z = false;
                }
                writableDatabase.close();
            } catch (Throwable th) {
                TLogger.e("MessageInfoManager", "delOldShowedCacheMessage Error! " + th);
                return false;
            }
        }
        return z;
    }

    public static boolean f(Context context, long j2) {
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            boolean z = true;
            if (writableDatabase.delete("messagetoshow", "busiid=?", new String[]{j2 + ""}) <= 0) {
                TLogger.d("MessageInfoManager", "delCacheMessageByBusiId Error! msgid to delete which busiId = : " + j2);
                z = false;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            TLogger.e("MessageInfoManager", "delCacheMessageByBusiId Error! " + th);
            return false;
        }
    }

    public static boolean g(Context context, long j2) {
        boolean z = false;
        try {
            SQLiteDatabase readableDatabase = d(context).getReadableDatabase();
            SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
            sQLiteQueryBuilder.setTables("messagetoshow");
            Cursor query = sQLiteQueryBuilder.query(readableDatabase, new String[]{"message"}, "msgid=?", new String[]{j2 + ""}, null, null, null);
            if (query != null) {
                z = query.moveToFirst();
                query.close();
            }
            readableDatabase.close();
        } catch (Throwable th) {
            TLogger.e("MessageInfoManager", "isMessageCached Error! " + th);
        }
        return z;
    }

    public static ArrayList<Intent> c(Context context) {
        ArrayList<Intent> arrayList = new ArrayList<>();
        try {
            SQLiteDatabase readableDatabase = d(context).getReadableDatabase();
            SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
            sQLiteQueryBuilder.setTables("messagetoshow");
            Cursor query = sQLiteQueryBuilder.query(readableDatabase, new String[]{"message"}, "status=0", null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        Intent parseUri = Intent.parseUri(Rijndael.decrypt(query.getString(0)), 1);
                        parseUri.addCategory("android.intent.category.BROWSABLE");
                        parseUri.setComponent(null);
                        if (Build.VERSION.SDK_INT >= 15) {
                            try {
                                parseUri.getClass().getMethod("setSelector", Intent.class).invoke(parseUri, null);
                            } catch (Throwable th) {
                                TLogger.w("MessageInfoManager", "invoke intent.setComponent error.", th);
                            }
                        }
                        arrayList.add(parseUri);
                    } catch (URISyntaxException e2) {
                        TLogger.e("MessageInfoManager", "getCacheMessages Error: " + e2);
                    }
                }
                query.close();
            }
            readableDatabase.close();
        } catch (Throwable th2) {
            TLogger.e("MessageInfoManager", "getNewCacheMessages Error! " + th2);
        }
        return arrayList;
    }

    public static boolean b(Context context) {
        boolean z;
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            if (writableDatabase.delete("messagetoshow", "msgid < 0", null) <= 0) {
                TLogger.d("MessageInfoManager", "deleteAllLocalCacheMsgIntent Error! ");
                z = false;
            } else {
                z = true;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            TLogger.e("MessageInfoManager", "deleteAllLocalCacheMsgIntent Error! " + th);
            return false;
        }
    }

    public static boolean d(Context context, long j2) {
        return a(context, j2, 4);
    }

    public static boolean e(Context context, long j2) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = d(context).getWritableDatabase();
            if (sQLiteDatabase.delete("messagetoshow", "msgid=?", new String[]{j2 + ""}) > 0) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Throwable unused) {
                        TLogger.w("MessageInfoManager", "unexpected for delCacheMessage, db close error");
                    }
                }
                return true;
            }
            TLogger.d("MessageInfoManager", "delCacheMessage Error! msgid to delete: " + j2);
            return false;
        } catch (Throwable th) {
            try {
                TLogger.e("MessageInfoManager", "delCacheMessage Error! msgid to delete: " + j2 + th);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Throwable unused2) {
                        TLogger.w("MessageInfoManager", "unexpected for delCacheMessage, db close error");
                    }
                }
                return false;
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Throwable unused3) {
                        TLogger.w("MessageInfoManager", "unexpected for delCacheMessage, db close error");
                    }
                }
            }
        }
    }

    public static boolean a(Context context, long j2) {
        e(context);
        return a(context, j2, 1);
    }

    private static boolean a(Context context, long j2, int i2) {
        ContentValues contentValues = new ContentValues();
        boolean z = true;
        if (i2 == 1 || i2 == 2) {
            contentValues.put("showedtime", Long.valueOf(System.currentTimeMillis()));
        }
        contentValues.put("status", Integer.valueOf(i2));
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            if (writableDatabase.update("messagetoshow", contentValues, "msgid=?", new String[]{j2 + ""}) <= 0) {
                TLogger.d("MessageInfoManager", "updateCacheMessage Error! msgId:" + j2 + ", status:" + i2);
                z = false;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            TLogger.e("MessageInfoManager", "updateCacheMessage Error! " + th);
            return false;
        }
    }

    public static boolean a(Context context) {
        boolean z;
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            if (writableDatabase.delete("messagetoshow", null, null) <= 0) {
                TLogger.w("MessageInfoManager", "delAllCacheMessage but no mssgage in db");
                z = false;
            } else {
                z = true;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            TLogger.e("MessageInfoManager", "delAllCacheMessage Error! " + th);
            return false;
        }
    }
}

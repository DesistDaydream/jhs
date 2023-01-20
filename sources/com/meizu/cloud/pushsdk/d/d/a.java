package com.meizu.cloud.pushsdk.d.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class a implements d {
    private static final String a = "a";
    private SQLiteDatabase b;

    /* renamed from: c  reason: collision with root package name */
    private final b f4848c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f4849d = {"id", "eventData", "dateCreated"};

    /* renamed from: e  reason: collision with root package name */
    private long f4850e = -1;

    /* renamed from: f  reason: collision with root package name */
    private final int f4851f;

    public a(Context context, int i2) {
        this.f4848c = b.a(context, a(context));
        b();
        this.f4851f = i2;
    }

    private String a(Context context) {
        String processName = MzSystemUtils.getProcessName(context);
        if (TextUtils.isEmpty(processName)) {
            return "PushEvents.db";
        }
        return processName + "_PushEvents.db";
    }

    public static Map<String, String> a(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            HashMap hashMap = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            return hashMap;
        } catch (IOException | ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(Map<String, String> map) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<Map<String, Object>> a(int i2) {
        return a(null, "id ASC LIMIT " + i2);
    }

    public List<Map<String, Object>> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (e()) {
            Cursor query = this.b.query(com.umeng.analytics.pro.d.ar, this.f4849d, str, null, null, null, str2);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("id", Long.valueOf(query.getLong(0)));
                hashMap.put("eventData", a(query.getBlob(1)));
                hashMap.put("dateCreated", query.getString(2));
                query.moveToNext();
                arrayList.add(hashMap);
            }
            query.close();
        }
        return arrayList;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public void a(com.meizu.cloud.pushsdk.d.a.a aVar) {
        b(aVar);
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public boolean a() {
        return e();
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public boolean a(long j2) {
        int i2;
        if (e()) {
            SQLiteDatabase sQLiteDatabase = this.b;
            i2 = sQLiteDatabase.delete(com.umeng.analytics.pro.d.ar, "id=" + j2, null);
        } else {
            i2 = -1;
        }
        String str = a;
        com.meizu.cloud.pushsdk.d.f.c.b(str, "Removed event from database: " + j2, new Object[0]);
        return i2 == 1;
    }

    public long b(com.meizu.cloud.pushsdk.d.a.a aVar) {
        if (e()) {
            byte[] a2 = a(aVar.a());
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("eventData", a2);
            this.f4850e = this.b.insert(com.umeng.analytics.pro.d.ar, null, contentValues);
        }
        String str = a;
        com.meizu.cloud.pushsdk.d.f.c.b(str, "Added event to database: " + this.f4850e, new Object[0]);
        return this.f4850e;
    }

    public void b() {
        if (e()) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.f4848c.getWritableDatabase();
            this.b = writableDatabase;
            writableDatabase.enableWriteAheadLogging();
        } catch (Exception e2) {
            String str = a;
            com.meizu.cloud.pushsdk.d.f.c.a(str, " open database error " + e2.getMessage(), new Object[0]);
        }
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public long c() {
        if (e()) {
            return DatabaseUtils.queryNumEntries(this.b, com.umeng.analytics.pro.d.ar);
        }
        return 0L;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public com.meizu.cloud.pushsdk.d.b.c d() {
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : a(this.f4851f)) {
            com.meizu.cloud.pushsdk.d.a.c cVar = new com.meizu.cloud.pushsdk.d.a.c();
            cVar.a((Map) map.get("eventData"));
            linkedList.add((Long) map.get("id"));
            arrayList.add(cVar);
        }
        return new com.meizu.cloud.pushsdk.d.b.c(arrayList, linkedList);
    }

    public boolean e() {
        SQLiteDatabase sQLiteDatabase = this.b;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }
}

package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_if122;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import java.util.HashMap;

/* loaded from: classes.dex */
public class b extends a<bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_19do.a> {
    public b() {
        super("duplicatelog");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_if122.a
    public ContentValues a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_19do.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", aVar.a);
        contentValues.put("insert_time", Long.valueOf(aVar.b));
        return contentValues;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_if122.a
    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", "TEXT");
        hashMap.put("insert_time", "INTEGER");
        hashMap.put("ext1", "TEXT");
        hashMap.put("ext2", "TEXT");
        return hashMap;
    }

    public void a(SQLiteDatabase sQLiteDatabase, bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_19do.a aVar) {
        if (aVar == null || a(sQLiteDatabase, aVar.a)) {
            return;
        }
        super.a(sQLiteDatabase, (SQLiteDatabase) aVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.a + " where _id in (select _id from " + this.a + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e2) {
            j.b(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.database.sqlite.SQLiteDatabase r12, java.lang.String r13) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            if (r12 == 0) goto L2e
            boolean r2 = android.text.TextUtils.isEmpty(r13)
            if (r2 == 0) goto Lb
            goto L2e
        Lb:
            java.lang.String r4 = r11.a     // Catch: java.lang.Exception -> L26
            r5 = 0
            java.lang.String r6 = "path=?"
            java.lang.String[] r7 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L26
            r7[r1] = r13     // Catch: java.lang.Exception -> L26
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r12
            android.database.Cursor r12 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L26
            int r13 = r12.getCount()     // Catch: java.lang.Exception -> L26
            r12.close()     // Catch: java.lang.Exception -> L24
            goto L2b
        L24:
            r12 = move-exception
            goto L28
        L26:
            r12 = move-exception
            r13 = 0
        L28:
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j.b(r12)
        L2b:
            if (r13 <= 0) goto L2e
            goto L2f
        L2e:
            r0 = 0
        L2f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_if122.b.a(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }
}

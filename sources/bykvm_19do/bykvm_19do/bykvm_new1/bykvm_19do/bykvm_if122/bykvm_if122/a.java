package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_if122;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class a<T> {
    public final String a;

    public a(String str) {
        this.a = str;
    }

    public abstract ContentValues a(T t);

    public abstract HashMap<String, String> a();

    public void a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(this.a);
            sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> a = a();
            if (a != null) {
                for (String str : a.keySet()) {
                    sb.append(str);
                    sb.append(ExpandableTextView.N);
                    sb.append(a.get(str));
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.a, null, a((a<T>) t));
        } catch (Exception e2) {
            j.b(e2);
        }
    }
}

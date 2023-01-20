package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;

/* loaded from: classes.dex */
public final class x0 implements a1 {
    private o0<Boolean> a = new a(this);

    /* loaded from: classes.dex */
    public class a extends o0<Boolean> {
        public a(x0 x0Var) {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.o0
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return Boolean.FALSE;
        }
    }

    private String a(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                return cursor.getString(columnIndex);
            }
        }
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return this.a.b(context).booleanValue();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public a1.a b(Context context) {
        Throwable th;
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        if (cursor == null) {
            if (cursor == null) {
                return null;
            }
            return null;
        }
        try {
            a1.a aVar = new a1.a();
            aVar.a = a(cursor);
            if (cursor != null) {
                cursor.close();
            }
            return aVar;
        } catch (Throwable th3) {
            th = th3;
            try {
                th.printStackTrace();
                if (cursor == null) {
                    return null;
                }
                return null;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }
}

package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes.dex */
public class n implements bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e {
    public static final n b = new n();
    private volatile SQLiteDatabase a;

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e
    public SQLiteDatabase a(Context context) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.h.a(context).a().a();
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("---------------DB CREATE  SUCCESS------------");
                }
            }
        }
        return this.a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e
    public String a() {
        return "adevent";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e
    public String b() {
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e
    public String c() {
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e
    public String d() {
        return "adevent_applog";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e
    public String e() {
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e
    public String f() {
        return null;
    }
}

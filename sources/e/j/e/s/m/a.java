package e.j.e.s.m;

import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.sql.SqlDateTypeAdapter;
import com.google.gson.internal.sql.SqlTimeTypeAdapter;
import com.google.gson.internal.sql.SqlTimestampTypeAdapter;
import e.j.e.q;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes2.dex */
public final class a {
    public static final boolean a;
    public static final DefaultDateTypeAdapter.b<? extends Date> b;

    /* renamed from: c  reason: collision with root package name */
    public static final DefaultDateTypeAdapter.b<? extends Date> f11298c;

    /* renamed from: d  reason: collision with root package name */
    public static final q f11299d;

    /* renamed from: e  reason: collision with root package name */
    public static final q f11300e;

    /* renamed from: f  reason: collision with root package name */
    public static final q f11301f;

    /* renamed from: e.j.e.s.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0379a extends DefaultDateTypeAdapter.b<java.sql.Date> {
        public C0379a(Class cls) {
            super(cls);
        }

        @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.b
        /* renamed from: g */
        public java.sql.Date f(Date date) {
            return new java.sql.Date(date.getTime());
        }
    }

    /* loaded from: classes2.dex */
    public class b extends DefaultDateTypeAdapter.b<Timestamp> {
        public b(Class cls) {
            super(cls);
        }

        @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.b
        /* renamed from: g */
        public Timestamp f(Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        a = z;
        if (z) {
            b = new C0379a(java.sql.Date.class);
            f11298c = new b(Timestamp.class);
            f11299d = SqlDateTypeAdapter.b;
            f11300e = SqlTimeTypeAdapter.b;
            f11301f = SqlTimestampTypeAdapter.b;
            return;
        }
        b = null;
        f11298c = null;
        f11299d = null;
        f11300e = null;
        f11301f = null;
    }

    private a() {
    }
}

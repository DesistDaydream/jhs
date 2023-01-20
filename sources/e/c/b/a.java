package e.c.b;

import android.util.Log;

/* loaded from: classes.dex */
public interface a {

    /* renamed from: e.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0329a implements a {
        @Override // e.c.b.a
        public void a(String str, String str2, Throwable th) {
            Log.v(str, str2, th);
        }

        @Override // e.c.b.a
        public void b(String str, String str2, Throwable th) {
            Log.d(str, str2, th);
        }
    }

    void a(String str, String str2, Throwable th);

    void b(String str, String str2, Throwable th);
}

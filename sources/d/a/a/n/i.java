package d.a.a.n;

import android.content.SharedPreferences;
import d.a.a.o.n;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class i extends a<String> {
    public i(Future<SharedPreferences> future) {
        super(future, "randomDeviceID");
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
    @Override // d.a.a.n.a
    public void c(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences.getString(this.b, "");
    }

    @Override // d.a.a.n.a
    /* renamed from: g */
    public String a() {
        return n.h(16);
    }

    @Override // d.a.a.n.a
    /* renamed from: h */
    public void b(SharedPreferences.Editor editor, String str) {
        editor.putString(this.b, str);
        editor.apply();
    }
}

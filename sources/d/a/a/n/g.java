package d.a.a.n;

import android.content.SharedPreferences;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class g extends a<Boolean> {
    public g(Future<SharedPreferences> future) {
        super(future, "optOutFlag");
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Boolean] */
    @Override // d.a.a.n.a
    public void c(SharedPreferences sharedPreferences) {
        this.a = Boolean.valueOf(sharedPreferences.getBoolean(this.b, false));
    }

    @Override // d.a.a.n.a
    /* renamed from: g */
    public void b(SharedPreferences.Editor editor, Boolean bool) {
        editor.putBoolean(this.b, bool.booleanValue());
        editor.apply();
    }
}

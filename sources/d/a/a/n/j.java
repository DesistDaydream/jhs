package d.a.a.n;

import android.content.SharedPreferences;
import java.util.UUID;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class j extends a<String> {
    public j(Future<SharedPreferences> future) {
        super(future, "randomID");
    }

    @Override // d.a.a.n.a
    /* renamed from: g */
    public String a() {
        return UUID.randomUUID().toString();
    }
}

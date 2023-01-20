package d.a.a.n;

import android.content.SharedPreferences;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class d extends a<Integer> {

    /* renamed from: d  reason: collision with root package name */
    private final int f9302d;

    public d(Future<SharedPreferences> future, int i2) {
        super(future, "flushInterval");
        this.f9302d = i2;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Integer] */
    @Override // d.a.a.n.a
    public void c(SharedPreferences sharedPreferences) {
        this.a = Integer.valueOf(sharedPreferences.getInt(this.b, this.f9302d));
    }

    @Override // d.a.a.n.a
    /* renamed from: g */
    public void b(SharedPreferences.Editor editor, Integer num) {
        editor.putInt(this.b, num.intValue());
        editor.apply();
    }
}

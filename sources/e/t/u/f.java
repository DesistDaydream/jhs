package e.t.u;

import android.content.Context;
import android.content.SharedPreferences;
import h.k2.v.f0;
import java.nio.charset.Charset;
import java.util.UUID;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/vector/util/DeviceIdUtil;", "", "()V", "PREF_DEVICE_ID", "", "PREF_FILE", "id", "getId", "()Ljava/lang/String;", "mId", "putId", "pref", "Landroid/content/SharedPreferences;", "uuid", "Ljava/util/UUID;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class f {
    @k.e.a.d
    public static final f a = new f();
    @k.e.a.d
    private static final String b = "device_id.xml";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f14664c = "device_id";
    @k.e.a.e

    /* renamed from: d  reason: collision with root package name */
    private static String f14665d;

    private f() {
    }

    private final String b(SharedPreferences sharedPreferences, UUID uuid) {
        f14665d = uuid.toString();
        sharedPreferences.edit().putString("device_id", f14665d).apply();
        return f14665d;
    }

    @k.e.a.e
    public final String a() {
        String b2;
        String str = f14665d;
        if (str != null) {
            return str;
        }
        Context b3 = e.t.a.b();
        SharedPreferences sharedPreferences = b3.getSharedPreferences(b, 0);
        String string = sharedPreferences.getString("device_id", null);
        if (string != null) {
            f14665d = string;
            return string;
        }
        try {
            b2 = g.a.b(b3);
        } catch (Exception unused) {
        }
        if (!f0.g(b2, "9774d56d682e549c")) {
            Charset charset = h.t2.d.a;
            if (b2 != null) {
                return b(sharedPreferences, UUID.nameUUIDFromBytes(b2.getBytes(charset)));
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        b(sharedPreferences, UUID.randomUUID());
        return f14665d;
    }
}

package com.vector.util;

import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import h.k2.v.f0;
import h.w;
import h.z;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004J\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0015J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u001aJ \u0010\u001b\u001a\u0004\u0018\u0001H\u001c\"\u0006\b\u0000\u0010\u001c\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020!J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0004J\u001a\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\u0016\u0010#\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0001J\u000e\u0010%\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0004J'\u0010&\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040(\"\u00020\u0004¢\u0006\u0002\u0010)R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006*"}, d2 = {"Lcom/vector/util/SpEx;", "", "()V", "fileName", "", "getFileName", "()Ljava/lang/String;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "sp", "Landroid/content/SharedPreferences;", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "clear", "", "contains", "", "key", "getBoolean", "defValue", "getFloat", "", "getFromJson", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)Ljava/lang/Object;", "getInt", "", "getLong", "", "getString", "put", "value", "remove", "removeKeys", "keys", "", "(Landroid/content/SharedPreferences;[Ljava/lang/String;)V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SpEx {
    @d
    private final w a = z.c(new SpEx$sp$2(this));
    @d
    private final w b = z.c(SpEx$gson$2.INSTANCE);

    public static /* synthetic */ boolean d(SpEx spEx, String str, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return spEx.c(str, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBoolean");
    }

    public static /* synthetic */ float g(SpEx spEx, String str, float f2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                f2 = -1.0f;
            }
            return spEx.f(str, f2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFloat");
    }

    public static /* synthetic */ int k(SpEx spEx, String str, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = -1;
            }
            return spEx.j(str, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInt");
    }

    public static /* synthetic */ long m(SpEx spEx, String str, long j2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                j2 = -1;
            }
            return spEx.l(str, j2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLong");
    }

    private final SharedPreferences n() {
        return (SharedPreferences) this.a.getValue();
    }

    public final void a() {
        SharedPreferences.Editor edit = n().edit();
        edit.clear();
        edit.apply();
    }

    public final boolean b(@d String str) {
        return n().contains(str);
    }

    public final boolean c(@d String str, boolean z) {
        return n().getBoolean(str, z);
    }

    @d
    public abstract String e();

    public final float f(@d String str, float f2) {
        return n().getFloat(str, f2);
    }

    public final /* synthetic */ <T> T h(String str) {
        String o = o(str);
        if (o == null) {
            return null;
        }
        Gson i2 = i();
        f0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) i2.n(o, Object.class);
    }

    @d
    public final Gson i() {
        return (Gson) this.b.getValue();
    }

    public final int j(@d String str, int i2) {
        return n().getInt(str, i2);
    }

    public final long l(@d String str, long j2) {
        return n().getLong(str, j2);
    }

    @e
    public final String o(@d String str) {
        return p(str, null);
    }

    @e
    public final String p(@d String str, @e String str2) {
        return n().getString(str, str2);
    }

    public final boolean q(@d String str, @d Object obj) {
        SharedPreferences.Editor edit = n().edit();
        if (obj instanceof Integer) {
            edit.putInt(str, ((Number) obj).intValue());
        } else if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Number) obj).longValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Number) obj).floatValue());
        } else if (obj instanceof Double) {
            edit.putFloat(str, (float) ((Number) obj).doubleValue());
        } else {
            try {
                edit.putString(str, i().z(obj));
            } catch (JsonIOException unused) {
                return false;
            }
        }
        return edit.commit();
    }

    public final void r(@d String str) {
        SharedPreferences.Editor edit = n().edit();
        edit.remove(str);
        edit.apply();
    }

    public final void s(@d SharedPreferences sharedPreferences, @d String... strArr) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String str : strArr) {
            edit.remove(str);
        }
        edit.apply();
    }
}

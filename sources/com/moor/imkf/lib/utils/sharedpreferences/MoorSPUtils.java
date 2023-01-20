package com.moor.imkf.lib.utils.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import com.moor.imkf.lib.MoorBaseLibManager;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@SuppressLint({"ApplySharedPref"})
/* loaded from: classes2.dex */
public final class MoorSPUtils {
    private static final SimpleArrayMap<String, MoorSPUtils> SP_UTILS_MAP = new SimpleArrayMap<>();
    private SharedPreferences sp;

    private MoorSPUtils(String str) {
        this.sp = MoorBaseLibManager.getInstance().getApplication().getSharedPreferences(str, 0);
    }

    public static MoorSPUtils getInstance() {
        return getInstance("");
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        clear(false);
    }

    public boolean contains(@NonNull String str) {
        return this.sp.contains(str);
    }

    public Map<String, ?> getAll() {
        return this.sp.getAll();
    }

    public boolean getBoolean(@NonNull String str) {
        return getBoolean(str, false);
    }

    public float getFloat(@NonNull String str) {
        return getFloat(str, -1.0f);
    }

    public int getInt(@NonNull String str) {
        return getInt(str, -1);
    }

    public long getLong(@NonNull String str) {
        return getLong(str, -1L);
    }

    public String getString(@NonNull String str) {
        return getString(str, "");
    }

    public Set<String> getStringSet(@NonNull String str) {
        return getStringSet(str, Collections.emptySet());
    }

    public void put(@NonNull String str, @NonNull String str2, boolean z) {
        if (z) {
            this.sp.edit().putString(str, str2).commit();
        } else {
            this.sp.edit().putString(str, str2).apply();
        }
    }

    public void remove(@NonNull String str) {
        remove(str, false);
    }

    private static MoorSPUtils getInstance(String str) {
        if (isSpace(str)) {
            str = "moor_sp";
        }
        SimpleArrayMap<String, MoorSPUtils> simpleArrayMap = SP_UTILS_MAP;
        MoorSPUtils moorSPUtils = simpleArrayMap.get(str);
        if (moorSPUtils == null) {
            MoorSPUtils moorSPUtils2 = new MoorSPUtils(str);
            simpleArrayMap.put(str, moorSPUtils2);
            return moorSPUtils2;
        }
        return moorSPUtils;
    }

    public void clear(boolean z) {
        if (z) {
            this.sp.edit().clear().commit();
        } else {
            this.sp.edit().clear().apply();
        }
    }

    public boolean getBoolean(@NonNull String str, boolean z) {
        return this.sp.getBoolean(str, z);
    }

    public float getFloat(@NonNull String str, float f2) {
        return this.sp.getFloat(str, f2);
    }

    public int getInt(@NonNull String str, int i2) {
        return this.sp.getInt(str, i2);
    }

    public long getLong(@NonNull String str, long j2) {
        return this.sp.getLong(str, j2);
    }

    public String getString(@NonNull String str, @NonNull String str2) {
        return this.sp.getString(str, str2);
    }

    public Set<String> getStringSet(@NonNull String str, @NonNull Set<String> set) {
        return this.sp.getStringSet(str, set);
    }

    public void remove(@NonNull String str, boolean z) {
        if (z) {
            this.sp.edit().remove(str).commit();
        } else {
            this.sp.edit().remove(str).apply();
        }
    }

    public void put(@NonNull String str, int i2, boolean z) {
        if (z) {
            this.sp.edit().putInt(str, i2).commit();
        } else {
            this.sp.edit().putInt(str, i2).apply();
        }
    }

    public void put(@NonNull String str, long j2, boolean z) {
        if (z) {
            this.sp.edit().putLong(str, j2).commit();
        } else {
            this.sp.edit().putLong(str, j2).apply();
        }
    }

    public void put(@NonNull String str, float f2, boolean z) {
        if (z) {
            this.sp.edit().putFloat(str, f2).commit();
        } else {
            this.sp.edit().putFloat(str, f2).apply();
        }
    }

    public void put(@NonNull String str, boolean z, boolean z2) {
        if (z2) {
            this.sp.edit().putBoolean(str, z).commit();
        } else {
            this.sp.edit().putBoolean(str, z).apply();
        }
    }

    public void put(@NonNull String str, @NonNull Set<String> set, boolean z) {
        if (z) {
            this.sp.edit().putStringSet(str, set).commit();
        } else {
            this.sp.edit().putStringSet(str, set).apply();
        }
    }
}

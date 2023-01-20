package e.j.a.b.c.x;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.regex.Pattern;

@e.j.a.b.c.m.a
@d0
/* loaded from: classes2.dex */
public class b0 {
    private static final Pattern a = Pattern.compile("\\$\\{(.*?)\\}");

    private b0() {
    }

    @Nullable
    @e.j.a.b.c.m.a
    public static String a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    @e.j.a.b.c.m.a
    public static boolean b(@Nullable String str) {
        return str == null || str.trim().isEmpty();
    }
}

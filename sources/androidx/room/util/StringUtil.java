package androidx.room.util;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.Room;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    private StringUtil() {
    }

    public static void appendPlaceholders(StringBuilder builder, int count) {
        for (int i2 = 0; i2 < count; i2++) {
            builder.append("?");
            if (i2 < count - 1) {
                builder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
    }

    @Nullable
    public static String joinIntoString(@Nullable List<Integer> input) {
        if (input == null) {
            return null;
        }
        int size = input.size();
        if (size == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(Integer.toString(input.get(i2).intValue()));
            if (i2 < size - 1) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        return sb.toString();
    }

    public static StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    @Nullable
    public static List<Integer> splitToIntList(@Nullable String input) {
        if (input == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(input, Constants.ACCEPT_TIME_SEPARATOR_SP);
        while (stringTokenizer.hasMoreElements()) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
            } catch (NumberFormatException e2) {
                Log.e(Room.LOG_TAG, "Malformed integer list", e2);
            }
        }
        return arrayList;
    }
}

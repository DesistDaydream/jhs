package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class CursorUtil {
    private CursorUtil() {
    }

    @NonNull
    public static Cursor copyAndClose(@NonNull Cursor c2) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(c2.getColumnNames(), c2.getCount());
            while (c2.moveToNext()) {
                Object[] objArr = new Object[c2.getColumnCount()];
                for (int i2 = 0; i2 < c2.getColumnCount(); i2++) {
                    int type = c2.getType(i2);
                    if (type == 0) {
                        objArr[i2] = null;
                    } else if (type == 1) {
                        objArr[i2] = Long.valueOf(c2.getLong(i2));
                    } else if (type == 2) {
                        objArr[i2] = Double.valueOf(c2.getDouble(i2));
                    } else if (type == 3) {
                        objArr[i2] = c2.getString(i2);
                    } else if (type == 4) {
                        objArr[i2] = c2.getBlob(i2);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        } finally {
            c2.close();
        }
    }

    private static int findColumnIndexBySuffix(@NonNull Cursor cursor, @NonNull String name) {
        if (Build.VERSION.SDK_INT <= 25 && name.length() != 0) {
            return findColumnIndexBySuffix(cursor.getColumnNames(), name);
        }
        return -1;
    }

    public static int getColumnIndex(@NonNull Cursor c2, @NonNull String name) {
        int columnIndex = c2.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c2.getColumnIndex("`" + name + "`");
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(c2, name);
    }

    public static int getColumnIndexOrThrow(@NonNull Cursor c2, @NonNull String name) {
        String str;
        int columnIndex = getColumnIndex(c2, name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            str = Arrays.toString(c2.getColumnNames());
        } catch (Exception e2) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e2);
            str = "";
        }
        throw new IllegalArgumentException("column '" + name + "' does not exist. Available columns: " + str);
    }

    @VisibleForTesting(otherwise = 2)
    public static int findColumnIndexBySuffix(String[] columnNames, String name) {
        String str = "." + name;
        String str2 = "." + name + "`";
        for (int i2 = 0; i2 < columnNames.length; i2++) {
            String str3 = columnNames[i2];
            if (str3.length() >= name.length() + 2) {
                if (str3.endsWith(str)) {
                    return i2;
                }
                if (str3.charAt(0) == '`' && str3.endsWith(str2)) {
                    return i2;
                }
            }
        }
        return -1;
    }
}

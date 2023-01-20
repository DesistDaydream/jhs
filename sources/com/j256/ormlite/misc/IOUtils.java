package com.j256.ormlite.misc;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public class IOUtils {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void closeThrowSqlException(Closeable closeable, String str) throws SQLException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                throw SqlExceptionUtil.create("could not close " + str, e2);
            }
        }
    }
}

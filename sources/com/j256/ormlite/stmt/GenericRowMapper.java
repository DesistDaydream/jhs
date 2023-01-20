package com.j256.ormlite.stmt;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public interface GenericRowMapper<T> {
    T mapRow(DatabaseResults databaseResults) throws SQLException;
}

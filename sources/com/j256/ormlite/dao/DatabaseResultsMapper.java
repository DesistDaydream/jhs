package com.j256.ormlite.dao;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public interface DatabaseResultsMapper<T> {
    T mapRow(DatabaseResults databaseResults) throws SQLException;
}

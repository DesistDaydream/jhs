package androidx.room;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* loaded from: classes.dex */
public interface DelegatingOpenHelper {
    @NonNull
    SupportSQLiteOpenHelper getDelegate();
}

package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public interface AutoMigrationCallback {
    void onPostMigrate(@NonNull SupportSQLiteDatabase db);
}

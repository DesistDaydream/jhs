package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* loaded from: classes.dex */
public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public Migration(int startVersion, int endVersion) {
        this.startVersion = startVersion;
        this.endVersion = endVersion;
    }

    public abstract void migrate(@NonNull SupportSQLiteDatabase database);
}

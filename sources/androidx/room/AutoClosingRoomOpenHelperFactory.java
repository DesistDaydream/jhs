package androidx.room;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    @NonNull
    private final AutoCloser mAutoCloser;
    @NonNull
    private final SupportSQLiteOpenHelper.Factory mDelegate;

    public AutoClosingRoomOpenHelperFactory(@NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull AutoCloser autoCloser) {
        this.mDelegate = factory;
        this.mAutoCloser = autoCloser;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @NonNull
    public AutoClosingRoomOpenHelper create(@NonNull SupportSQLiteOpenHelper.Configuration configuration) {
        return new AutoClosingRoomOpenHelper(this.mDelegate.create(configuration), this.mAutoCloser);
    }
}

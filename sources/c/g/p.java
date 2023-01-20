package c.g;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* loaded from: classes.dex */
public final /* synthetic */ class p implements Function {
    public static final /* synthetic */ p a = new p();

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.i((SupportSQLiteDatabase) obj);
    }
}

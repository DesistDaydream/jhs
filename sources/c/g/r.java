package c.g;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* loaded from: classes.dex */
public final /* synthetic */ class r implements Function {
    public static final /* synthetic */ r a = new r();

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.k((SupportSQLiteDatabase) obj);
    }
}

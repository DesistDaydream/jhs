package c.g;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* loaded from: classes.dex */
public final /* synthetic */ class r0 implements Function {
    public static final /* synthetic */ r0 a = new r0();

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Long.valueOf(((SupportSQLiteDatabase) obj).getPageSize());
    }
}

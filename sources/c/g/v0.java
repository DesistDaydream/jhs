package c.g;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* loaded from: classes.dex */
public final /* synthetic */ class v0 implements Function {
    public static final /* synthetic */ v0 a = new v0();

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return ((SupportSQLiteDatabase) obj).getAttachedDbs();
    }
}

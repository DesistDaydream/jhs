package c.g;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes.dex */
public final /* synthetic */ class t0 implements Function {
    public static final /* synthetic */ t0 a = new t0();

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Long.valueOf(((SupportSQLiteStatement) obj).executeInsert());
    }
}

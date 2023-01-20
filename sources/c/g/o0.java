package c.g;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes.dex */
public final /* synthetic */ class o0 implements Function {
    public static final /* synthetic */ o0 a = new o0();

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Long.valueOf(((SupportSQLiteStatement) obj).simpleQueryForLong());
    }
}

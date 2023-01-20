package c.g;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes.dex */
public final /* synthetic */ class x0 implements Function {
    public static final /* synthetic */ x0 a = new x0();

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Integer.valueOf(((SupportSQLiteStatement) obj).executeUpdateDelete());
    }
}

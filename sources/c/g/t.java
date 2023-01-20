package c.g;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes.dex */
public final /* synthetic */ class t implements Function {
    public static final /* synthetic */ t a = new t();

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return ((SupportSQLiteStatement) obj).execute();
    }
}

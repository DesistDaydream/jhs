package c.g;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes.dex */
public final /* synthetic */ class w implements Function {
    public static final /* synthetic */ w a = new w();

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return ((SupportSQLiteStatement) obj).simpleQueryForString();
    }
}

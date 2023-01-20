package c.g;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Function {
    public static final /* synthetic */ d a = new d();

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Long.valueOf(((SupportSQLiteDatabase) obj).getMaximumSize());
    }
}

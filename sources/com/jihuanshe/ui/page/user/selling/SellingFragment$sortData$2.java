package com.jihuanshe.ui.page.user.selling;

import com.jihuanshe.model.Constants;
import h.k2.u.a;
import java.util.List;
import k.e.a.d;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingFragment$sortData$2 extends Lambda implements a<List<Pair<? extends String, ? extends String>>> {
    public static final SellingFragment$sortData$2 INSTANCE = new SellingFragment$sortData$2();

    public SellingFragment$sortData$2() {
        super(0);
    }

    @Override // h.k2.u.a
    @d
    public final List<Pair<? extends String, ? extends String>> invoke() {
        return Constants.Companion.getSORTING_NEWEST();
    }
}

package com.jihuanshe.model;

import com.jihuanshe.R;
import com.vector.util.Res;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class CardProductKt {
    @d
    public static final String getConditionStr(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return i2 != 4 ? "" : Res.w(Res.a, R.string.card_detail_condition_4, null, 2, null);
                }
                return Res.w(Res.a, R.string.card_detail_condition_3, null, 2, null);
            }
            return Res.w(Res.a, R.string.card_detail_condition_2, null, 2, null);
        }
        return Res.w(Res.a, R.string.card_detail_condition_1, null, 2, null);
    }
}

package com.jihuanshe.ui.page.entrepot;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class ConsignmentOrderFragmentCreator {
    private String type;
    private Integer typeOrder;

    private ConsignmentOrderFragmentCreator() {
    }

    public static ConsignmentOrderFragmentCreator create(@Nullable String str, @Nullable Integer num) {
        ConsignmentOrderFragmentCreator consignmentOrderFragmentCreator = new ConsignmentOrderFragmentCreator();
        consignmentOrderFragmentCreator.type = str;
        consignmentOrderFragmentCreator.typeOrder = num;
        return consignmentOrderFragmentCreator;
    }

    public static void inject(ConsignmentOrderFragment consignmentOrderFragment) {
        Bundle arguments = consignmentOrderFragment.getArguments();
        if (arguments == null) {
            return;
        }
        if (arguments.containsKey("type")) {
            consignmentOrderFragment.m0((String) arguments.get("type"));
        }
        if (arguments.containsKey("typeOrder")) {
            consignmentOrderFragment.n0((Integer) arguments.get("typeOrder"));
        }
    }

    public ConsignmentOrderFragment get() {
        Bundle bundle = new Bundle();
        String str = this.type;
        if (str != null) {
            bundle.putString("type", str);
        }
        Integer num = this.typeOrder;
        if (num != null) {
            bundle.putInt("typeOrder", num.intValue());
        }
        ConsignmentOrderFragment consignmentOrderFragment = new ConsignmentOrderFragment();
        consignmentOrderFragment.setArguments(bundle);
        return consignmentOrderFragment;
    }
}

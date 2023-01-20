package com.jihuanshe.ui.page.search.fragments.cardrepo;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.jihuanshe.model.CardPackage;

/* loaded from: classes2.dex */
public final class CardRepoSearchFragmentCreator {
    private CardPackage cardPackage;
    private Integer type;
    private Integer wid;

    private CardRepoSearchFragmentCreator() {
    }

    public static CardRepoSearchFragmentCreator create(@Nullable Integer num, @Nullable Integer num2, @Nullable CardPackage cardPackage) {
        CardRepoSearchFragmentCreator cardRepoSearchFragmentCreator = new CardRepoSearchFragmentCreator();
        cardRepoSearchFragmentCreator.type = num;
        cardRepoSearchFragmentCreator.wid = num2;
        cardRepoSearchFragmentCreator.cardPackage = cardPackage;
        return cardRepoSearchFragmentCreator;
    }

    public static void inject(CardRepoSearchFragment cardRepoSearchFragment) {
        Bundle arguments = cardRepoSearchFragment.getArguments();
        if (arguments == null) {
            return;
        }
        if (arguments.containsKey("type")) {
            cardRepoSearchFragment.F0((Integer) arguments.get("type"));
        }
        if (arguments.containsKey("wid")) {
            cardRepoSearchFragment.G0((Integer) arguments.get("wid"));
        }
        if (arguments.containsKey("cardPackage")) {
            try {
                cardRepoSearchFragment.C0((CardPackage) arguments.getParcelable("cardPackage"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public CardRepoSearchFragment get() {
        Bundle bundle = new Bundle();
        Integer num = this.type;
        if (num != null) {
            bundle.putInt("type", num.intValue());
        }
        Integer num2 = this.wid;
        if (num2 != null) {
            bundle.putInt("wid", num2.intValue());
        }
        CardPackage cardPackage = this.cardPackage;
        if (cardPackage != null) {
            bundle.putParcelable("cardPackage", cardPackage);
        }
        CardRepoSearchFragment cardRepoSearchFragment = new CardRepoSearchFragment();
        cardRepoSearchFragment.setArguments(bundle);
        return cardRepoSearchFragment;
    }
}

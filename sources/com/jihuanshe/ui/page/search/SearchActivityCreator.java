package com.jihuanshe.ui.page.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.Constants;

/* loaded from: classes2.dex */
public final class SearchActivityCreator {
    private CardPackage cardPackage;
    private Integer cardRepoType;
    private String from;
    private Boolean sellerOrderList;
    private Integer type;
    private Integer uid;
    private Integer wid;

    private SearchActivityCreator() {
    }

    public static SearchActivityCreator create(@Nullable Integer num) {
        SearchActivityCreator searchActivityCreator = new SearchActivityCreator();
        searchActivityCreator.type = num;
        return searchActivityCreator;
    }

    public static void inject(SearchActivity searchActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("type")) {
            searchActivity.r0(((Integer) extras.get("type")).intValue());
        }
        if (extras.containsKey(Constants.KEY_PARAM_USER_ID)) {
            searchActivity.s0((Integer) extras.get(Constants.KEY_PARAM_USER_ID));
        }
        if (extras.containsKey("cardRepoType")) {
            searchActivity.p0((Integer) extras.get("cardRepoType"));
        }
        if (extras.containsKey("wid")) {
            searchActivity.t0((Integer) extras.get("wid"));
        }
        if (extras.containsKey("cardPackage")) {
            try {
                searchActivity.o0((CardPackage) extras.getParcelable("cardPackage"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (extras.containsKey("sellerOrderList")) {
            searchActivity.q0(((Boolean) extras.get("sellerOrderList")).booleanValue());
        }
        if (extras.containsKey("from")) {
            searchActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable CardPackage cardPackage, @Nullable Boolean bool, @Nullable String str) {
        Intent intent = new Intent(context, SearchActivity.class);
        if (num != null) {
            intent.putExtra("type", num);
        }
        if (num2 != null) {
            intent.putExtra(Constants.KEY_PARAM_USER_ID, num2);
        }
        if (num3 != null) {
            intent.putExtra("cardRepoType", num3);
        }
        if (num4 != null) {
            intent.putExtra("wid", num4);
        }
        if (cardPackage != null) {
            intent.putExtra("cardPackage", cardPackage);
        }
        if (bool != null) {
            intent.putExtra("sellerOrderList", bool);
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public SearchActivityCreator cardPackage(CardPackage cardPackage) {
        this.cardPackage = cardPackage;
        return this;
    }

    public SearchActivityCreator cardRepoType(Integer num) {
        this.cardRepoType = num;
        return this;
    }

    public SearchActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public SearchActivityCreator sellerOrderList(Boolean bool) {
        this.sellerOrderList = bool;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, SearchActivity.class);
        Integer num = this.type;
        if (num != null) {
            intent.putExtra("type", num);
        }
        Integer num2 = this.uid;
        if (num2 != null) {
            intent.putExtra(Constants.KEY_PARAM_USER_ID, num2);
        }
        Integer num3 = this.cardRepoType;
        if (num3 != null) {
            intent.putExtra("cardRepoType", num3);
        }
        Integer num4 = this.wid;
        if (num4 != null) {
            intent.putExtra("wid", num4);
        }
        CardPackage cardPackage = this.cardPackage;
        if (cardPackage != null) {
            intent.putExtra("cardPackage", cardPackage);
        }
        Boolean bool = this.sellerOrderList;
        if (bool != null) {
            intent.putExtra("sellerOrderList", bool);
        }
        String str = this.from;
        if (str != null) {
            intent.putExtra("from", str);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public SearchActivityCreator uid(Integer num) {
        this.uid = num;
        return this;
    }

    public SearchActivityCreator wid(Integer num) {
        this.wid = num;
        return this;
    }

    public void start(Object obj, int i2) {
        Context context;
        boolean z = obj instanceof Activity;
        if (z) {
            context = (Context) obj;
        } else if (obj instanceof Fragment) {
            context = ((Fragment) obj).getContext();
        } else {
            throw new IllegalStateException("objectHost must be one of activity or fragment");
        }
        Intent intent = new Intent(context, SearchActivity.class);
        Integer num = this.type;
        if (num != null) {
            intent.putExtra("type", num);
        }
        Integer num2 = this.uid;
        if (num2 != null) {
            intent.putExtra(Constants.KEY_PARAM_USER_ID, num2);
        }
        Integer num3 = this.cardRepoType;
        if (num3 != null) {
            intent.putExtra("cardRepoType", num3);
        }
        Integer num4 = this.wid;
        if (num4 != null) {
            intent.putExtra("wid", num4);
        }
        CardPackage cardPackage = this.cardPackage;
        if (cardPackage != null) {
            intent.putExtra("cardPackage", cardPackage);
        }
        Boolean bool = this.sellerOrderList;
        if (bool != null) {
            intent.putExtra("sellerOrderList", bool);
        }
        String str = this.from;
        if (str != null) {
            intent.putExtra("from", str);
        }
        if (z) {
            ((Activity) obj).startActivityForResult(intent, i2);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).startActivityForResult(intent, i2);
        }
    }
}

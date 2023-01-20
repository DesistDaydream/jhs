package com.jihuanshe.ui.page.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.jihuanshe.model.Constants;

/* loaded from: classes2.dex */
public final class SellerDetailActivityCreator {
    private Integer cid;
    private String from;
    private Boolean ignoreVersion;
    private Integer uid;
    private Integer wid;
    private Boolean wish;

    private SellerDetailActivityCreator() {
    }

    public static SellerDetailActivityCreator create(@Nullable Integer num, @Nullable Integer num2) {
        SellerDetailActivityCreator sellerDetailActivityCreator = new SellerDetailActivityCreator();
        sellerDetailActivityCreator.uid = num;
        sellerDetailActivityCreator.cid = num2;
        return sellerDetailActivityCreator;
    }

    public static void inject(SellerDetailActivity sellerDetailActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey(Constants.KEY_PARAM_USER_ID)) {
            sellerDetailActivity.u1(((Integer) extras.get(Constants.KEY_PARAM_USER_ID)).intValue());
        }
        if (extras.containsKey("cid")) {
            sellerDetailActivity.q1(((Integer) extras.get("cid")).intValue());
        }
        if (extras.containsKey("wid")) {
            sellerDetailActivity.v1((Integer) extras.get("wid"));
        }
        if (extras.containsKey("ignoreVersion")) {
            sellerDetailActivity.s1(((Boolean) extras.get("ignoreVersion")).booleanValue());
        }
        if (extras.containsKey("wish")) {
            sellerDetailActivity.w1((Boolean) extras.get("wish"));
        }
        if (extras.containsKey("from")) {
            sellerDetailActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str) {
        Intent intent = new Intent(context, SellerDetailActivity.class);
        if (num != null) {
            intent.putExtra(Constants.KEY_PARAM_USER_ID, num);
        }
        if (num2 != null) {
            intent.putExtra("cid", num2);
        }
        if (num3 != null) {
            intent.putExtra("wid", num3);
        }
        if (bool != null) {
            intent.putExtra("ignoreVersion", bool);
        }
        if (bool2 != null) {
            intent.putExtra("wish", bool2);
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public SellerDetailActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public SellerDetailActivityCreator ignoreVersion(Boolean bool) {
        this.ignoreVersion = bool;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, SellerDetailActivity.class);
        Integer num = this.uid;
        if (num != null) {
            intent.putExtra(Constants.KEY_PARAM_USER_ID, num);
        }
        Integer num2 = this.cid;
        if (num2 != null) {
            intent.putExtra("cid", num2);
        }
        Integer num3 = this.wid;
        if (num3 != null) {
            intent.putExtra("wid", num3);
        }
        Boolean bool = this.ignoreVersion;
        if (bool != null) {
            intent.putExtra("ignoreVersion", bool);
        }
        Boolean bool2 = this.wish;
        if (bool2 != null) {
            intent.putExtra("wish", bool2);
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

    public SellerDetailActivityCreator wid(Integer num) {
        this.wid = num;
        return this;
    }

    public SellerDetailActivityCreator wish(Boolean bool) {
        this.wish = bool;
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
        Intent intent = new Intent(context, SellerDetailActivity.class);
        Integer num = this.uid;
        if (num != null) {
            intent.putExtra(Constants.KEY_PARAM_USER_ID, num);
        }
        Integer num2 = this.cid;
        if (num2 != null) {
            intent.putExtra("cid", num2);
        }
        Integer num3 = this.wid;
        if (num3 != null) {
            intent.putExtra("wid", num3);
        }
        Boolean bool = this.ignoreVersion;
        if (bool != null) {
            intent.putExtra("ignoreVersion", bool);
        }
        Boolean bool2 = this.wish;
        if (bool2 != null) {
            intent.putExtra("wish", bool2);
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

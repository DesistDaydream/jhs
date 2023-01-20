package com.jihuanshe.ui.page.order;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.ShopCarInfo;

/* loaded from: classes2.dex */
public final class OrderConfirmActivityCreator {
    private String from;
    private ShopCarInfo shopCardInfo;
    private Integer uid;

    /* loaded from: classes2.dex */
    public class a extends e.j.e.t.a<ShopCarInfo> {
    }

    private OrderConfirmActivityCreator() {
    }

    public static OrderConfirmActivityCreator create(@Nullable Integer num, @Nullable ShopCarInfo shopCarInfo) {
        OrderConfirmActivityCreator orderConfirmActivityCreator = new OrderConfirmActivityCreator();
        orderConfirmActivityCreator.uid = num;
        orderConfirmActivityCreator.shopCardInfo = shopCarInfo;
        return orderConfirmActivityCreator;
    }

    public static void inject(OrderConfirmActivity orderConfirmActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey(Constants.KEY_PARAM_USER_ID)) {
            orderConfirmActivity.g0(((Integer) extras.get(Constants.KEY_PARAM_USER_ID)).intValue());
        }
        if (extras.containsKey("shopCardInfo")) {
            try {
                orderConfirmActivity.f0((ShopCarInfo) e.t.p.a.f(null, false).h((String) extras.get("shopCardInfo"), new a().getType()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (extras.containsKey("from")) {
            orderConfirmActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Integer num, @Nullable ShopCarInfo shopCarInfo, @Nullable String str) {
        Intent intent = new Intent(context, OrderConfirmActivity.class);
        if (num != null) {
            intent.putExtra(Constants.KEY_PARAM_USER_ID, num);
        }
        if (shopCarInfo != null) {
            try {
                intent.putExtra("shopCardInfo", e.t.p.a.f(null, false).i(shopCarInfo));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public OrderConfirmActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, OrderConfirmActivity.class);
        Integer num = this.uid;
        if (num != null) {
            intent.putExtra(Constants.KEY_PARAM_USER_ID, num);
        }
        if (this.shopCardInfo != null) {
            try {
                intent.putExtra("shopCardInfo", e.t.p.a.f(null, false).i(this.shopCardInfo));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
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
        Intent intent = new Intent(context, OrderConfirmActivity.class);
        Integer num = this.uid;
        if (num != null) {
            intent.putExtra(Constants.KEY_PARAM_USER_ID, num);
        }
        if (this.shopCardInfo != null) {
            try {
                intent.putExtra("shopCardInfo", e.t.p.a.f(null, false).i(this.shopCardInfo));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
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

package com.jihuanshe.ui.page.order;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.jihuanshe.model.UserAddress;

/* loaded from: classes2.dex */
public final class AddAddressActivityCreator {
    private String busEvent;
    private String from;
    private UserAddress oldAddress;

    private AddAddressActivityCreator() {
    }

    public static AddAddressActivityCreator create(@Nullable String str) {
        AddAddressActivityCreator addAddressActivityCreator = new AddAddressActivityCreator();
        addAddressActivityCreator.busEvent = str;
        return addAddressActivityCreator;
    }

    public static void inject(AddAddressActivity addAddressActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("busEvent")) {
            addAddressActivity.s0((String) extras.get("busEvent"));
        }
        if (extras.containsKey("oldAddress")) {
            try {
                addAddressActivity.u0((UserAddress) extras.getParcelable("oldAddress"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (extras.containsKey("from")) {
            addAddressActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable String str, @Nullable UserAddress userAddress, @Nullable String str2) {
        Intent intent = new Intent(context, AddAddressActivity.class);
        if (str != null) {
            intent.putExtra("busEvent", str);
        }
        if (userAddress != null) {
            intent.putExtra("oldAddress", userAddress);
        }
        if (str2 != null) {
            intent.putExtra("from", str2);
        }
        return intent;
    }

    public AddAddressActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public AddAddressActivityCreator oldAddress(UserAddress userAddress) {
        this.oldAddress = userAddress;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, AddAddressActivity.class);
        String str = this.busEvent;
        if (str != null) {
            intent.putExtra("busEvent", str);
        }
        UserAddress userAddress = this.oldAddress;
        if (userAddress != null) {
            intent.putExtra("oldAddress", userAddress);
        }
        String str2 = this.from;
        if (str2 != null) {
            intent.putExtra("from", str2);
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
        Intent intent = new Intent(context, AddAddressActivity.class);
        String str = this.busEvent;
        if (str != null) {
            intent.putExtra("busEvent", str);
        }
        UserAddress userAddress = this.oldAddress;
        if (userAddress != null) {
            intent.putExtra("oldAddress", userAddress);
        }
        String str2 = this.from;
        if (str2 != null) {
            intent.putExtra("from", str2);
        }
        if (z) {
            ((Activity) obj).startActivityForResult(intent, i2);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).startActivityForResult(intent, i2);
        }
    }
}

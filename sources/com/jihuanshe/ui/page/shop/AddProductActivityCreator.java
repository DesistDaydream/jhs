package com.jihuanshe.ui.page.shop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import e.l.r.r0;

/* loaded from: classes2.dex */
public final class AddProductActivityCreator {
    private Integer cardVersionId;
    private String from;
    private String gameKey;
    private String gameSubKey;
    private Integer wareHouseId;

    private AddProductActivityCreator() {
    }

    public static AddProductActivityCreator create(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        AddProductActivityCreator addProductActivityCreator = new AddProductActivityCreator();
        addProductActivityCreator.cardVersionId = num;
        addProductActivityCreator.gameKey = str;
        addProductActivityCreator.gameSubKey = str2;
        return addProductActivityCreator;
    }

    public static void inject(AddProductActivity addProductActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey(r0.f14316j)) {
            addProductActivity.n0(((Integer) extras.get(r0.f14316j)).intValue());
        }
        if (extras.containsKey(r0.f14314h)) {
            addProductActivity.o0((String) extras.get(r0.f14314h));
        }
        if (extras.containsKey(r0.f14315i)) {
            addProductActivity.p0((String) extras.get(r0.f14315i));
        }
        if (extras.containsKey("wareHouseId")) {
            addProductActivity.q0(((Integer) extras.get("wareHouseId")).intValue());
        }
        if (extras.containsKey("from")) {
            addProductActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Integer num2, @Nullable String str3) {
        Intent intent = new Intent(context, AddProductActivity.class);
        if (num != null) {
            intent.putExtra(r0.f14316j, num);
        }
        if (str != null) {
            intent.putExtra(r0.f14314h, str);
        }
        if (str2 != null) {
            intent.putExtra(r0.f14315i, str2);
        }
        if (num2 != null) {
            intent.putExtra("wareHouseId", num2);
        }
        if (str3 != null) {
            intent.putExtra("from", str3);
        }
        return intent;
    }

    public AddProductActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, AddProductActivity.class);
        Integer num = this.cardVersionId;
        if (num != null) {
            intent.putExtra(r0.f14316j, num);
        }
        String str = this.gameKey;
        if (str != null) {
            intent.putExtra(r0.f14314h, str);
        }
        String str2 = this.gameSubKey;
        if (str2 != null) {
            intent.putExtra(r0.f14315i, str2);
        }
        Integer num2 = this.wareHouseId;
        if (num2 != null) {
            intent.putExtra("wareHouseId", num2);
        }
        String str3 = this.from;
        if (str3 != null) {
            intent.putExtra("from", str3);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public AddProductActivityCreator wareHouseId(Integer num) {
        this.wareHouseId = num;
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
        Intent intent = new Intent(context, AddProductActivity.class);
        Integer num = this.cardVersionId;
        if (num != null) {
            intent.putExtra(r0.f14316j, num);
        }
        String str = this.gameKey;
        if (str != null) {
            intent.putExtra(r0.f14314h, str);
        }
        String str2 = this.gameSubKey;
        if (str2 != null) {
            intent.putExtra(r0.f14315i, str2);
        }
        Integer num2 = this.wareHouseId;
        if (num2 != null) {
            intent.putExtra("wareHouseId", num2);
        }
        String str3 = this.from;
        if (str3 != null) {
            intent.putExtra("from", str3);
        }
        if (z) {
            ((Activity) obj).startActivityForResult(intent, i2);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).startActivityForResult(intent, i2);
        }
    }
}

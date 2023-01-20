package com.jihuanshe.ui.page.shop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.jihuanshe.model.CardPackage;

/* loaded from: classes2.dex */
public final class ChooseCardActivityCreator {
    private CardPackage cardPackage;
    private String from;
    private String keyWord;
    private Integer type;
    private Integer wantSellCardId;
    private Integer wid;

    private ChooseCardActivityCreator() {
    }

    public static ChooseCardActivityCreator create(@Nullable Integer num, @Nullable Integer num2, @Nullable CardPackage cardPackage, @Nullable Integer num3) {
        ChooseCardActivityCreator chooseCardActivityCreator = new ChooseCardActivityCreator();
        chooseCardActivityCreator.type = num;
        chooseCardActivityCreator.wid = num2;
        chooseCardActivityCreator.cardPackage = cardPackage;
        chooseCardActivityCreator.wantSellCardId = num3;
        return chooseCardActivityCreator;
    }

    public static void inject(ChooseCardActivity chooseCardActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("type")) {
            chooseCardActivity.v0((Integer) extras.get("type"));
        }
        if (extras.containsKey("wid")) {
            chooseCardActivity.x0((Integer) extras.get("wid"));
        }
        if (extras.containsKey("cardPackage")) {
            try {
                chooseCardActivity.r0((CardPackage) extras.getParcelable("cardPackage"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (extras.containsKey("wantSellCardId")) {
            chooseCardActivity.w0((Integer) extras.get("wantSellCardId"));
        }
        if (extras.containsKey("keyWord")) {
            chooseCardActivity.s0((String) extras.get("keyWord"));
        }
        if (extras.containsKey("from")) {
            chooseCardActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Integer num, @Nullable Integer num2, @Nullable CardPackage cardPackage, @Nullable Integer num3, @Nullable String str, @Nullable String str2) {
        Intent intent = new Intent(context, ChooseCardActivity.class);
        if (num != null) {
            intent.putExtra("type", num);
        }
        if (num2 != null) {
            intent.putExtra("wid", num2);
        }
        if (cardPackage != null) {
            intent.putExtra("cardPackage", cardPackage);
        }
        if (num3 != null) {
            intent.putExtra("wantSellCardId", num3);
        }
        if (str != null) {
            intent.putExtra("keyWord", str);
        }
        if (str2 != null) {
            intent.putExtra("from", str2);
        }
        return intent;
    }

    public ChooseCardActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public ChooseCardActivityCreator keyWord(String str) {
        this.keyWord = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, ChooseCardActivity.class);
        Integer num = this.type;
        if (num != null) {
            intent.putExtra("type", num);
        }
        Integer num2 = this.wid;
        if (num2 != null) {
            intent.putExtra("wid", num2);
        }
        CardPackage cardPackage = this.cardPackage;
        if (cardPackage != null) {
            intent.putExtra("cardPackage", cardPackage);
        }
        Integer num3 = this.wantSellCardId;
        if (num3 != null) {
            intent.putExtra("wantSellCardId", num3);
        }
        String str = this.keyWord;
        if (str != null) {
            intent.putExtra("keyWord", str);
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
        Intent intent = new Intent(context, ChooseCardActivity.class);
        Integer num = this.type;
        if (num != null) {
            intent.putExtra("type", num);
        }
        Integer num2 = this.wid;
        if (num2 != null) {
            intent.putExtra("wid", num2);
        }
        CardPackage cardPackage = this.cardPackage;
        if (cardPackage != null) {
            intent.putExtra("cardPackage", cardPackage);
        }
        Integer num3 = this.wantSellCardId;
        if (num3 != null) {
            intent.putExtra("wantSellCardId", num3);
        }
        String str = this.keyWord;
        if (str != null) {
            intent.putExtra("keyWord", str);
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

package com.jihuanshe.ui.page.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import e.l.r.r0;

/* loaded from: classes2.dex */
public final class CardPackDetailActivityCreator {
    private String from;
    private String gameKey;
    private String gameSubKey;
    private Integer packId;

    private CardPackDetailActivityCreator() {
    }

    public static CardPackDetailActivityCreator create(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        CardPackDetailActivityCreator cardPackDetailActivityCreator = new CardPackDetailActivityCreator();
        cardPackDetailActivityCreator.packId = num;
        cardPackDetailActivityCreator.gameKey = str;
        cardPackDetailActivityCreator.gameSubKey = str2;
        return cardPackDetailActivityCreator;
    }

    public static void inject(CardPackDetailActivity cardPackDetailActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey(r0.f14317k)) {
            cardPackDetailActivity.A0(((Integer) extras.get(r0.f14317k)).intValue());
        }
        if (extras.containsKey(r0.f14314h)) {
            cardPackDetailActivity.y0((String) extras.get(r0.f14314h));
        }
        if (extras.containsKey(r0.f14315i)) {
            cardPackDetailActivity.z0((String) extras.get(r0.f14315i));
        }
        if (extras.containsKey("from")) {
            cardPackDetailActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intent intent = new Intent(context, CardPackDetailActivity.class);
        if (num != null) {
            intent.putExtra(r0.f14317k, num);
        }
        if (str != null) {
            intent.putExtra(r0.f14314h, str);
        }
        if (str2 != null) {
            intent.putExtra(r0.f14315i, str2);
        }
        if (str3 != null) {
            intent.putExtra("from", str3);
        }
        return intent;
    }

    public CardPackDetailActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, CardPackDetailActivity.class);
        Integer num = this.packId;
        if (num != null) {
            intent.putExtra(r0.f14317k, num);
        }
        String str = this.gameKey;
        if (str != null) {
            intent.putExtra(r0.f14314h, str);
        }
        String str2 = this.gameSubKey;
        if (str2 != null) {
            intent.putExtra(r0.f14315i, str2);
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
        Intent intent = new Intent(context, CardPackDetailActivity.class);
        Integer num = this.packId;
        if (num != null) {
            intent.putExtra(r0.f14317k, num);
        }
        String str = this.gameKey;
        if (str != null) {
            intent.putExtra(r0.f14314h, str);
        }
        String str2 = this.gameSubKey;
        if (str2 != null) {
            intent.putExtra(r0.f14315i, str2);
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

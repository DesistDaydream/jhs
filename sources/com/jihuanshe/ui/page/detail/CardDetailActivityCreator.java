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
public final class CardDetailActivityCreator {
    private String from;
    private String gameKey;
    private String gameSubKey;
    private Integer versionId;
    private Boolean wish;

    private CardDetailActivityCreator() {
    }

    public static CardDetailActivityCreator create(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        CardDetailActivityCreator cardDetailActivityCreator = new CardDetailActivityCreator();
        cardDetailActivityCreator.versionId = num;
        cardDetailActivityCreator.gameKey = str;
        cardDetailActivityCreator.gameSubKey = str2;
        return cardDetailActivityCreator;
    }

    public static void inject(CardDetailActivity cardDetailActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("versionId")) {
            cardDetailActivity.s1(((Integer) extras.get("versionId")).intValue());
        }
        if (extras.containsKey(r0.f14314h)) {
            cardDetailActivity.m1((String) extras.get(r0.f14314h));
        }
        if (extras.containsKey(r0.f14315i)) {
            cardDetailActivity.n1((String) extras.get(r0.f14315i));
        }
        if (extras.containsKey("wish")) {
            cardDetailActivity.t1((Boolean) extras.get("wish"));
        }
        if (extras.containsKey("from")) {
            cardDetailActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3) {
        Intent intent = new Intent(context, CardDetailActivity.class);
        if (num != null) {
            intent.putExtra("versionId", num);
        }
        if (str != null) {
            intent.putExtra(r0.f14314h, str);
        }
        if (str2 != null) {
            intent.putExtra(r0.f14315i, str2);
        }
        if (bool != null) {
            intent.putExtra("wish", bool);
        }
        if (str3 != null) {
            intent.putExtra("from", str3);
        }
        return intent;
    }

    public CardDetailActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, CardDetailActivity.class);
        Integer num = this.versionId;
        if (num != null) {
            intent.putExtra("versionId", num);
        }
        String str = this.gameKey;
        if (str != null) {
            intent.putExtra(r0.f14314h, str);
        }
        String str2 = this.gameSubKey;
        if (str2 != null) {
            intent.putExtra(r0.f14315i, str2);
        }
        Boolean bool = this.wish;
        if (bool != null) {
            intent.putExtra("wish", bool);
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

    public CardDetailActivityCreator wish(Boolean bool) {
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
        Intent intent = new Intent(context, CardDetailActivity.class);
        Integer num = this.versionId;
        if (num != null) {
            intent.putExtra("versionId", num);
        }
        String str = this.gameKey;
        if (str != null) {
            intent.putExtra(r0.f14314h, str);
        }
        String str2 = this.gameSubKey;
        if (str2 != null) {
            intent.putExtra(r0.f14315i, str2);
        }
        Boolean bool = this.wish;
        if (bool != null) {
            intent.putExtra("wish", bool);
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

package com.jihuanshe.ui.page.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.jihuanshe.model.PackDetailResult;
import e.l.r.r0;

/* loaded from: classes2.dex */
public final class CardPackListActivityCreator {
    private String from;
    private String gameKey;
    private String gameSubKey;
    private PackDetailResult packInfo;

    private CardPackListActivityCreator() {
    }

    public static CardPackListActivityCreator create(@Nullable PackDetailResult packDetailResult, @Nullable String str, @Nullable String str2) {
        CardPackListActivityCreator cardPackListActivityCreator = new CardPackListActivityCreator();
        cardPackListActivityCreator.packInfo = packDetailResult;
        cardPackListActivityCreator.gameKey = str;
        cardPackListActivityCreator.gameSubKey = str2;
        return cardPackListActivityCreator;
    }

    public static void inject(CardPackListActivity cardPackListActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("packInfo")) {
            try {
                cardPackListActivity.r0((PackDetailResult) extras.getParcelable("packInfo"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (extras.containsKey(r0.f14314h)) {
            cardPackListActivity.p0((String) extras.get(r0.f14314h));
        }
        if (extras.containsKey(r0.f14315i)) {
            cardPackListActivity.q0((String) extras.get(r0.f14315i));
        }
        if (extras.containsKey("from")) {
            cardPackListActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable PackDetailResult packDetailResult, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intent intent = new Intent(context, CardPackListActivity.class);
        if (packDetailResult != null) {
            intent.putExtra("packInfo", packDetailResult);
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

    public CardPackListActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, CardPackListActivity.class);
        PackDetailResult packDetailResult = this.packInfo;
        if (packDetailResult != null) {
            intent.putExtra("packInfo", packDetailResult);
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
        Intent intent = new Intent(context, CardPackListActivity.class);
        PackDetailResult packDetailResult = this.packInfo;
        if (packDetailResult != null) {
            intent.putExtra("packInfo", packDetailResult);
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

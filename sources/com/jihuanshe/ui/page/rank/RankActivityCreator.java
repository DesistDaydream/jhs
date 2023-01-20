package com.jihuanshe.ui.page.rank;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import e.l.r.r0;

/* loaded from: classes2.dex */
public final class RankActivityCreator {
    private Integer allGame;
    private String from;
    private String fromType;
    private String gameKey;
    private String gameSubKey;
    private Integer rankTypeId;

    private RankActivityCreator() {
    }

    public static RankActivityCreator create() {
        return new RankActivityCreator();
    }

    public static void inject(RankActivity rankActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("fromType")) {
            rankActivity.n0((String) extras.get("fromType"));
        }
        if (extras.containsKey("rankTypeId")) {
            rankActivity.q0((Integer) extras.get("rankTypeId"));
        }
        if (extras.containsKey("allGame")) {
            rankActivity.m0((Integer) extras.get("allGame"));
        }
        if (extras.containsKey(r0.f14314h)) {
            rankActivity.o0((String) extras.get(r0.f14314h));
        }
        if (extras.containsKey(r0.f14315i)) {
            rankActivity.p0((String) extras.get(r0.f14315i));
        }
        if (extras.containsKey("from")) {
            rankActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intent intent = new Intent(context, RankActivity.class);
        if (str != null) {
            intent.putExtra("fromType", str);
        }
        if (num != null) {
            intent.putExtra("rankTypeId", num);
        }
        if (num2 != null) {
            intent.putExtra("allGame", num2);
        }
        if (str2 != null) {
            intent.putExtra(r0.f14314h, str2);
        }
        if (str3 != null) {
            intent.putExtra(r0.f14315i, str3);
        }
        if (str4 != null) {
            intent.putExtra("from", str4);
        }
        return intent;
    }

    public RankActivityCreator allGame(Integer num) {
        this.allGame = num;
        return this;
    }

    public RankActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public RankActivityCreator fromType(String str) {
        this.fromType = str;
        return this;
    }

    public RankActivityCreator gameKey(String str) {
        this.gameKey = str;
        return this;
    }

    public RankActivityCreator gameSubKey(String str) {
        this.gameSubKey = str;
        return this;
    }

    public RankActivityCreator rankTypeId(Integer num) {
        this.rankTypeId = num;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, RankActivity.class);
        String str = this.fromType;
        if (str != null) {
            intent.putExtra("fromType", str);
        }
        Integer num = this.rankTypeId;
        if (num != null) {
            intent.putExtra("rankTypeId", num);
        }
        Integer num2 = this.allGame;
        if (num2 != null) {
            intent.putExtra("allGame", num2);
        }
        String str2 = this.gameKey;
        if (str2 != null) {
            intent.putExtra(r0.f14314h, str2);
        }
        String str3 = this.gameSubKey;
        if (str3 != null) {
            intent.putExtra(r0.f14315i, str3);
        }
        String str4 = this.from;
        if (str4 != null) {
            intent.putExtra("from", str4);
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
        Intent intent = new Intent(context, RankActivity.class);
        String str = this.fromType;
        if (str != null) {
            intent.putExtra("fromType", str);
        }
        Integer num = this.rankTypeId;
        if (num != null) {
            intent.putExtra("rankTypeId", num);
        }
        Integer num2 = this.allGame;
        if (num2 != null) {
            intent.putExtra("allGame", num2);
        }
        String str2 = this.gameKey;
        if (str2 != null) {
            intent.putExtra(r0.f14314h, str2);
        }
        String str3 = this.gameSubKey;
        if (str3 != null) {
            intent.putExtra(r0.f14315i, str3);
        }
        String str4 = this.from;
        if (str4 != null) {
            intent.putExtra("from", str4);
        }
        if (z) {
            ((Activity) obj).startActivityForResult(intent, i2);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).startActivityForResult(intent, i2);
        }
    }
}

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
public final class ReviewListActivityCreator {
    private Integer cvId;
    private String from;
    private String gameKey;
    private String gameSubKey;
    private Integer pId;
    private Integer reviewId;
    private String type;

    private ReviewListActivityCreator() {
    }

    public static ReviewListActivityCreator create(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str2, @Nullable String str3) {
        ReviewListActivityCreator reviewListActivityCreator = new ReviewListActivityCreator();
        reviewListActivityCreator.type = str;
        reviewListActivityCreator.cvId = num;
        reviewListActivityCreator.pId = num2;
        reviewListActivityCreator.reviewId = num3;
        reviewListActivityCreator.gameKey = str2;
        reviewListActivityCreator.gameSubKey = str3;
        return reviewListActivityCreator;
    }

    public static void inject(ReviewListActivity reviewListActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("type")) {
            reviewListActivity.i1((String) extras.get("type"));
        }
        if (extras.containsKey("cvId")) {
            reviewListActivity.Z0((Integer) extras.get("cvId"));
        }
        if (extras.containsKey("pId")) {
            reviewListActivity.g1((Integer) extras.get("pId"));
        }
        if (extras.containsKey("reviewId")) {
            reviewListActivity.h1((Integer) extras.get("reviewId"));
        }
        if (extras.containsKey(r0.f14314h)) {
            reviewListActivity.d1((String) extras.get(r0.f14314h));
        }
        if (extras.containsKey(r0.f14315i)) {
            reviewListActivity.e1((String) extras.get(r0.f14315i));
        }
        if (extras.containsKey("from")) {
            reviewListActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intent intent = new Intent(context, ReviewListActivity.class);
        if (str != null) {
            intent.putExtra("type", str);
        }
        if (num != null) {
            intent.putExtra("cvId", num);
        }
        if (num2 != null) {
            intent.putExtra("pId", num2);
        }
        if (num3 != null) {
            intent.putExtra("reviewId", num3);
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

    public ReviewListActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, ReviewListActivity.class);
        String str = this.type;
        if (str != null) {
            intent.putExtra("type", str);
        }
        Integer num = this.cvId;
        if (num != null) {
            intent.putExtra("cvId", num);
        }
        Integer num2 = this.pId;
        if (num2 != null) {
            intent.putExtra("pId", num2);
        }
        Integer num3 = this.reviewId;
        if (num3 != null) {
            intent.putExtra("reviewId", num3);
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
        Intent intent = new Intent(context, ReviewListActivity.class);
        String str = this.type;
        if (str != null) {
            intent.putExtra("type", str);
        }
        Integer num = this.cvId;
        if (num != null) {
            intent.putExtra("cvId", num);
        }
        Integer num2 = this.pId;
        if (num2 != null) {
            intent.putExtra("pId", num2);
        }
        Integer num3 = this.reviewId;
        if (num3 != null) {
            intent.putExtra("reviewId", num3);
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

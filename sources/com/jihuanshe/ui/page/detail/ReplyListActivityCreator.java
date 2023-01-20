package com.jihuanshe.ui.page.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public final class ReplyListActivityCreator {
    private String from;
    private Integer reviewId;
    private Integer sortIndex;

    private ReplyListActivityCreator() {
    }

    public static ReplyListActivityCreator create(@Nullable Integer num) {
        ReplyListActivityCreator replyListActivityCreator = new ReplyListActivityCreator();
        replyListActivityCreator.reviewId = num;
        return replyListActivityCreator;
    }

    public static void inject(ReplyListActivity replyListActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("reviewId")) {
            replyListActivity.K0((Integer) extras.get("reviewId"));
        }
        if (extras.containsKey("sortIndex")) {
            replyListActivity.L0((Integer) extras.get("sortIndex"));
        }
        if (extras.containsKey("from")) {
            replyListActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Integer num, @Nullable Integer num2, @Nullable String str) {
        Intent intent = new Intent(context, ReplyListActivity.class);
        if (num != null) {
            intent.putExtra("reviewId", num);
        }
        if (num2 != null) {
            intent.putExtra("sortIndex", num2);
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public ReplyListActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public ReplyListActivityCreator sortIndex(Integer num) {
        this.sortIndex = num;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, ReplyListActivity.class);
        Integer num = this.reviewId;
        if (num != null) {
            intent.putExtra("reviewId", num);
        }
        Integer num2 = this.sortIndex;
        if (num2 != null) {
            intent.putExtra("sortIndex", num2);
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
        Intent intent = new Intent(context, ReplyListActivity.class);
        Integer num = this.reviewId;
        if (num != null) {
            intent.putExtra("reviewId", num);
        }
        Integer num2 = this.sortIndex;
        if (num2 != null) {
            intent.putExtra("sortIndex", num2);
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

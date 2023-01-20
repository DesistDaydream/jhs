package com.jihuanshe.ui.page.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import e.l.r.r0;

/* loaded from: classes2.dex */
public final class ChoosePhotoActivityCreator {
    private String from;
    private String gameKey;
    private Integer versionId;

    private ChoosePhotoActivityCreator() {
    }

    public static ChoosePhotoActivityCreator create(@Nullable String str, @Nullable Integer num) {
        ChoosePhotoActivityCreator choosePhotoActivityCreator = new ChoosePhotoActivityCreator();
        choosePhotoActivityCreator.gameKey = str;
        choosePhotoActivityCreator.versionId = num;
        return choosePhotoActivityCreator;
    }

    public static void inject(ChoosePhotoActivity choosePhotoActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey(r0.f14314h)) {
            choosePhotoActivity.c0((String) extras.get(r0.f14314h));
        }
        if (extras.containsKey("versionId")) {
            choosePhotoActivity.d0((Integer) extras.get("versionId"));
        }
        if (extras.containsKey("from")) {
            choosePhotoActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable String str, @Nullable Integer num, @Nullable String str2) {
        Intent intent = new Intent(context, ChoosePhotoActivity.class);
        if (str != null) {
            intent.putExtra(r0.f14314h, str);
        }
        if (num != null) {
            intent.putExtra("versionId", num);
        }
        if (str2 != null) {
            intent.putExtra("from", str2);
        }
        return intent;
    }

    public ChoosePhotoActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, ChoosePhotoActivity.class);
        String str = this.gameKey;
        if (str != null) {
            intent.putExtra(r0.f14314h, str);
        }
        Integer num = this.versionId;
        if (num != null) {
            intent.putExtra("versionId", num);
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
        Intent intent = new Intent(context, ChoosePhotoActivity.class);
        String str = this.gameKey;
        if (str != null) {
            intent.putExtra(r0.f14314h, str);
        }
        Integer num = this.versionId;
        if (num != null) {
            intent.putExtra("versionId", num);
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

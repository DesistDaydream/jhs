package com.tencent.qcloud.tuicore;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class ServiceInitializer extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    public int getLightThemeResId() {
        return R.style.TUIBaseLightTheme;
    }

    public int getLivelyThemeResId() {
        return R.style.TUIBaseLivelyTheme;
    }

    public int getSeriousThemeResId() {
        return R.style.TUIBaseSeriousTheme;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    public void init(Context context) {
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context applicationContext = getContext().getApplicationContext();
        TUIRouter.init(applicationContext);
        TUIConfig.init(applicationContext);
        TUIThemeManager.addLightTheme(getLightThemeResId());
        TUIThemeManager.addLivelyTheme(getLivelyThemeResId());
        TUIThemeManager.addSeriousTheme(getSeriousThemeResId());
        TUIThemeManager.setTheme(applicationContext);
        init(applicationContext);
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}

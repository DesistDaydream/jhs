package com.tencent.android.tpush;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;

/* loaded from: classes3.dex */
public class XGVipPushKAProvider extends ContentProvider {
    private void a(Uri uri, Context context) {
        if (context != null) {
            try {
                if (!XGPushConfig.isUsedTpnsChannel(context)) {
                    TLogger.ii("XGVipPushKAProvider", "prepare startService abolish, not use Tpns channel service");
                    return;
                }
                TLogger.d("XGVipPushKAProvider", "prepare startService");
                Intent intent = new Intent();
                intent.setData(uri);
                intent.setClass(context, XGVipPushService.class);
                context.startService(intent);
            } catch (Throwable th) {
                TLogger.w("XGVipPushKAProvider", "start service failed.", th);
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        a(uri, getContext());
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        a(uri, getContext());
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        a(uri, getContext());
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        StringBuilder sb = new StringBuilder();
        sb.append("onCreate start service context: ");
        sb.append(context != null);
        TLogger.d("XGVipPushKAProvider", sb.toString());
        if (context != null) {
            com.tencent.android.tpush.service.b.a(context);
        }
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        a(uri, getContext());
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        a(uri, getContext());
        return 0;
    }
}

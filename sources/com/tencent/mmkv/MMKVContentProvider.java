package com.tencent.mmkv;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class MMKVContentProvider extends ContentProvider {
    public static final String FUNCTION_NAME = "mmkvFromAshmemID";
    public static final String KEY = "KEY";
    public static final String KEY_CRYPT = "KEY_CRYPT";
    public static final String KEY_MODE = "KEY_MODE";
    public static final String KEY_SIZE = "KEY_SIZE";
    private static Uri gUri;

    @Nullable
    public static Uri contentUri(Context context) {
        String queryAuthority;
        Uri uri = gUri;
        if (uri != null) {
            return uri;
        }
        if (context == null || (queryAuthority = queryAuthority(context)) == null) {
            return null;
        }
        Uri parse = Uri.parse("content://" + queryAuthority);
        gUri = parse;
        return parse;
    }

    public static String getProcessNameByPID(Context context, int pid) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == pid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        }
        return "";
    }

    private Bundle mmkvFromAshmemID(String ashmemID, int size, int mode, String cryptKey) throws RuntimeException {
        MMKV mmkvWithAshmemID = MMKV.mmkvWithAshmemID(getContext(), ashmemID, size, mode, cryptKey);
        ParcelableMMKV parcelableMMKV = new ParcelableMMKV(mmkvWithAshmemID);
        Log.i("MMKV", ashmemID + " fd = " + mmkvWithAshmemID.ashmemFD() + ", meta fd = " + mmkvWithAshmemID.ashmemMetaFD());
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY, parcelableMMKV);
        return bundle;
    }

    private static String queryAuthority(Context context) {
        ProviderInfo providerInfo;
        try {
            ComponentName componentName = new ComponentName(context, MMKVContentProvider.class.getName());
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (providerInfo = packageManager.getProviderInfo(componentName, 0)) == null) {
                return null;
            }
            return providerInfo.authority;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String method, @Nullable String mmapID, @Nullable Bundle extras) {
        if (method.equals(FUNCTION_NAME) && extras != null) {
            try {
                return mmkvFromAshmemID(mmapID, extras.getInt(KEY_SIZE), extras.getInt(KEY_MODE), extras.getString(KEY_CRYPT));
            } catch (Exception e2) {
                Log.e("MMKV", e2.getMessage());
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        String queryAuthority;
        Context context = getContext();
        if (context == null || (queryAuthority = queryAuthority(context)) == null) {
            return false;
        }
        if (gUri == null) {
            gUri = Uri.parse("content://" + queryAuthority);
            return true;
        }
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }
}

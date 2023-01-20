package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import e.j.a.b.c.r.a0;
import e.j.d.c.a;

@a
/* loaded from: classes2.dex */
public class FirebaseInitProvider extends ContentProvider {
    private static final String a = "FirebaseInitProvider";
    @VisibleForTesting
    public static final String b = "com.google.firebase.firebaseinitprovider";

    private static void a(@NonNull ProviderInfo providerInfo) {
        a0.l(providerInfo, "FirebaseInitProvider ProviderInfo cannot be null.");
        if (b.equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        a(providerInfo);
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (FirebaseApp.initializeApp(getContext()) == null) {
            Log.i(a, "FirebaseApp initialization unsuccessful");
            return false;
        }
        Log.i(a, "FirebaseApp initialization successful");
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}

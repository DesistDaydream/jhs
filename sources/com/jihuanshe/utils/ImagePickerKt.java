package com.jihuanshe.utils;

import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.fragment.app.FragmentActivity;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.PermissionDescDialog;
import java.io.File;
import java.io.IOException;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ImagePickerKt {
    private static final File a(Context context) {
        try {
            return File.createTempFile("IMG", ".jpg", context.getExternalCacheDir());
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @e
    public static final Uri b(@d Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", String.valueOf(System.currentTimeMillis()));
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", "Pictures");
        }
        contentValues.put("mime_type", "image/JPEG");
        return context.getContentResolver().insert(MediaStore.Images.Media.getContentUri("external"), contentValues);
    }

    @e
    public static final Uri c(@d Context context) {
        return Uri.fromFile(a(context));
    }

    public static final void d(@d Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }

    public static final void e(@d FragmentActivity fragmentActivity, int i2, int i3, int i4) {
        PermissionDescDialog permissionDescDialog = new PermissionDescDialog(fragmentActivity);
        permissionDescDialog.setTitleRes(R.string.permission_camera);
        permissionDescDialog.setPermissionRes(i2);
        permissionDescDialog.setDescResId(i3);
        permissionDescDialog.setDrawableId(i4);
        permissionDescDialog.setConfirmRes(R.string.common_confirm);
        permissionDescDialog.setOnConfirmClick(new ImagePickerKt$showPermissionDescDialog$1$1(fragmentActivity));
        permissionDescDialog.y();
    }
}

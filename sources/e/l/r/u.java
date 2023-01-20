package e.l.r;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class u {
    @k.e.a.d
    public static final u a = new u();

    private u() {
    }

    private final void e(Context context, Uri uri) {
        String string;
        Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (query == null) {
            string = uri.getPath();
        } else {
            query.moveToFirst();
            string = query.getString(query.getColumnIndex("_data"));
            query.close();
        }
        MediaScannerConnection.scanFile(context, new String[]{string}, null, null);
    }

    @k.e.a.e
    public final Uri a(@k.e.a.d Context context, @k.e.a.e Bitmap bitmap) throws IOException {
        File externalFilesDir;
        if (bitmap == null || (externalFilesDir = context.getExternalFilesDir(null)) == null) {
            return null;
        }
        File file = new File(externalFilesDir.toString() + ((Object) File.separator) + ((Object) context.getPackageName()));
        String str = "photo_" + System.currentTimeMillis() + ".jpg";
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.createNewFile();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            if (bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            return v.a(context, file2);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @k.e.a.e
    public final File b(@k.e.a.d Context context, @k.e.a.e Bitmap bitmap) throws IOException {
        File externalFilesDir;
        if (bitmap == null || (externalFilesDir = context.getExternalFilesDir(null)) == null) {
            return null;
        }
        File file = new File(externalFilesDir.toString() + ((Object) File.separator) + ((Object) context.getPackageName()));
        String str = "photo_" + System.currentTimeMillis() + ".jpg";
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.createNewFile();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            return file2;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @k.e.a.e
    public final Uri c(@k.e.a.d Context context, @k.e.a.d String str, @k.e.a.d String str2, @k.e.a.d Bitmap bitmap) {
        Uri uri;
        String str3 = str2 + System.currentTimeMillis() + ".png";
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str3);
        contentValues.put("mime_type", "image/png");
        int F3 = StringsKt__StringsKt.F3(str, MqttTopic.TOPIC_LEVEL_SEPARATOR, 0, false, 6, null);
        if (F3 == str.length()) {
            F3 = StringsKt__StringsKt.F3(str.substring(0, F3 - 1), MqttTopic.TOPIC_LEVEL_SEPARATOR, 0, false, 6, null);
        }
        contentValues.put("relative_path", h.k2.v.f0.C("DCIM/", str.substring(F3 + 1)));
        ContentResolver contentResolver = context.getContentResolver();
        if (h.k2.v.f0.g(Environment.getExternalStorageState(), "mounted")) {
            uri = MediaStore.Images.Media.getContentUri("external");
        } else {
            uri = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        }
        Uri insert = contentResolver.insert(uri, contentValues);
        if (insert == null) {
            return null;
        }
        try {
            OutputStream openOutputStream = contentResolver.openOutputStream(insert);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, openOutputStream);
            if (openOutputStream != null) {
                openOutputStream.flush();
                openOutputStream.close();
            }
            return insert;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0083, code lost:
        if (r4 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0086, code lost:
        r4.flush();
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0093, code lost:
        if (r4 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0097, code lost:
        if (r0 < 26) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0099, code lost:
        if (r2 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x009b, code lost:
        e.l.r.u.a.e(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00a0, code lost:
        return r1;
     */
    @k.e.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String d(@k.e.a.d android.content.Context r8, @k.e.a.d android.graphics.Bitmap r9) {
        /*
            r7 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = ""
            boolean r2 = r9.hasAlpha()
            r3 = 1
            if (r2 != r3) goto Le
            java.lang.String r2 = "png"
            goto L12
        Le:
            if (r2 != 0) goto Lb1
            java.lang.String r2 = "jpeg"
        L12:
            boolean r4 = r9.hasAlpha()
            if (r4 != r3) goto L1b
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG
            goto L1f
        L1b:
            if (r4 != 0) goto Lab
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG
        L1f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            long r5 = java.lang.System.currentTimeMillis()
            r4.append(r5)
            r5 = 46
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            android.content.ContentValues r5 = new android.content.ContentValues
            r5.<init>()
            java.lang.String r6 = "title"
            r5.put(r6, r4)
            java.lang.String r6 = "_display_name"
            r5.put(r6, r4)
            java.lang.String r4 = "description"
            java.lang.String r6 = "描述文件"
            r5.put(r4, r6)
            r4 = 29
            if (r0 < r4) goto L58
            java.lang.String r4 = "relative_path"
            java.lang.String r6 = "Pictures"
            r5.put(r4, r6)
        L58:
            java.lang.String r4 = "image/"
            java.lang.String r2 = h.k2.v.f0.C(r4, r2)
            java.lang.String r4 = "mime_type"
            r5.put(r4, r2)
            android.content.ContentResolver r2 = r8.getContentResolver()
            android.net.Uri r4 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            android.net.Uri r2 = r2.insert(r4, r5)
            r4 = 0
            android.content.ContentResolver r5 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            java.io.OutputStream r4 = r5.openOutputStream(r2)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r5 = 100
            r9.compress(r3, r5, r4)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            java.lang.String r9 = r2.getPath()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            if (r9 != 0) goto L82
            goto L83
        L82:
            r1 = r9
        L83:
            if (r4 != 0) goto L86
            goto L95
        L86:
            r4.flush()
            r4.close()
            goto L95
        L8d:
            r8 = move-exception
            goto La1
        L8f:
            r9 = move-exception
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L8d
            if (r4 != 0) goto L86
        L95:
            r9 = 26
            if (r0 < r9) goto La0
            if (r2 == 0) goto La0
            e.l.r.u r9 = e.l.r.u.a
            r9.e(r8, r2)
        La0:
            return r1
        La1:
            if (r4 != 0) goto La4
            goto Laa
        La4:
            r4.flush()
            r4.close()
        Laa:
            throw r8
        Lab:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        Lb1:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.r.u.d(android.content.Context, android.graphics.Bitmap):java.lang.String");
    }
}

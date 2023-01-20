package e.j.a.b.c.x;

import android.database.CharArrayBuffer;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class j {
    @e.j.a.b.c.m.a
    public static void a(String str, CharArrayBuffer charArrayBuffer) {
        if (TextUtils.isEmpty(str)) {
            charArrayBuffer.sizeCopied = 0;
        } else {
            char[] cArr = charArrayBuffer.data;
            if (cArr != null && cArr.length >= str.length()) {
                str.getChars(0, str.length(), charArrayBuffer.data, 0);
            } else {
                charArrayBuffer.data = str.toCharArray();
            }
        }
        charArrayBuffer.sizeCopied = str.length();
    }

    @e.j.a.b.c.m.a
    public static byte[] b(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}

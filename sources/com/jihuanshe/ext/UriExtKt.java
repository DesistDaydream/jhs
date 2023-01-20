package com.jihuanshe.ext;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.core.net.UriKt;
import e.t.a;
import h.k2.v.f0;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class UriExtKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(@k.e.a.d android.net.Uri r10, @k.e.a.d h.e2.c<? super java.io.File> r11) {
        /*
            boolean r0 = r11 instanceof com.jihuanshe.ext.UriExtKt$compress$1
            if (r0 == 0) goto L13
            r0 = r11
            com.jihuanshe.ext.UriExtKt$compress$1 r0 = (com.jihuanshe.ext.UriExtKt$compress$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.jihuanshe.ext.UriExtKt$compress$1 r0 = new com.jihuanshe.ext.UriExtKt$compress$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r10 = r0.L$0
            java.io.File r10 = (java.io.File) r10
            h.r0.n(r11)
            goto L90
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            h.r0.n(r11)
            goto La7
        L3d:
            h.r0.n(r11)
            e.l.r.g0 r11 = new e.l.r.g0
            r11.<init>()
            android.content.Context r2 = e.t.a.b()
            e.l.r.g0$b r6 = new e.l.r.g0$b
            r6.<init>()
            r7 = 0
            r6.j(r7)
            r6.i(r7)
            r6.l(r10)
            h.t1 r10 = h.t1.a
            android.graphics.Bitmap r10 = r11.b(r2, r6)
            e.l.r.u r11 = e.l.r.u.a
            android.content.Context r2 = e.t.a.b()
            java.io.File r10 = r11.b(r2, r10)
            if (r10 == 0) goto L95
            boolean r11 = r10.exists()
            if (r11 != 0) goto L71
            goto L95
        L71:
            long r6 = r10.length()
            r8 = 10485760(0xa00000, double:5.180654E-317)
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 <= 0) goto L94
            i.b.l2 r11 = i.b.b1.e()
            com.jihuanshe.ext.UriExtKt$compress$3 r2 = new com.jihuanshe.ext.UriExtKt$compress$3
            r2.<init>(r5)
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r11 = i.b.g.i(r11, r2, r0)
            if (r11 != r1) goto L90
            return r1
        L90:
            r10.delete()
            return r5
        L94:
            return r10
        L95:
            i.b.l2 r10 = i.b.b1.e()
            com.jihuanshe.ext.UriExtKt$compress$2 r11 = new com.jihuanshe.ext.UriExtKt$compress$2
            r11.<init>(r5)
            r0.label = r4
            java.lang.Object r10 = i.b.g.i(r10, r11, r0)
            if (r10 != r1) goto La7
            return r1
        La7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.ext.UriExtKt.a(android.net.Uri, h.e2.c):java.lang.Object");
    }

    @SuppressLint({"Range"})
    @d
    public static final String b(@d Uri uri) {
        String str;
        String scheme = uri.getScheme();
        if (f0.g(scheme, "file")) {
            return UriKt.toFile(uri).getName();
        }
        if (f0.g(scheme, "content")) {
            Cursor query = a.b().getContentResolver().query(uri, null, null, null, null, null);
            if (query == null) {
                str = null;
            } else {
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("_display_name"));
                query.close();
                str = string;
            }
            if (str == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                sb.append('.');
                sb.append((Object) MimeTypeMap.getSingleton().getExtensionFromMimeType(a.b().getContentResolver().getType(uri)));
                sb.append('}');
                return sb.toString();
            }
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        sb2.append('.');
        sb2.append((Object) MimeTypeMap.getSingleton().getExtensionFromMimeType(a.b().getContentResolver().getType(uri)));
        sb2.append('}');
        return sb2.toString();
    }
}

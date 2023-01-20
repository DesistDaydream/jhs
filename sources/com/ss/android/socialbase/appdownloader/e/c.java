package com.ss.android.socialbase.appdownloader.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.network.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class c {
    private static int a = 8;
    private static volatile c b;

    /* renamed from: c  reason: collision with root package name */
    private a<Integer, Bitmap> f5464c;

    /* loaded from: classes3.dex */
    public static class a<K, T> extends LinkedHashMap<K, T> {
        public final int a;

        public a(int i2, int i3) {
            super(i3, 0.75f, true);
            this.a = i2;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.a;
        }
    }

    private c() {
        this.f5464c = null;
        int i2 = a;
        this.f5464c = new a<>(i2, i2 / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
        }
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public Bitmap a(int i2) {
        return this.f5464c.get(Integer.valueOf(i2));
    }

    public void a(final int i2, final String str) {
        if (TextUtils.isEmpty(str) || a(i2) != null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.m().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.e.c.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable[]] */
            @Override // java.lang.Runnable
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                ByteArrayInputStream byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Throwable th;
                InputStream inputStream;
                Exception e2;
                int i3 = 4;
                i3 = 4;
                i3 = 4;
                i3 = 4;
                i3 = 4;
                try {
                    try {
                        i a2 = com.ss.android.socialbase.downloader.downloader.c.a(true, 0, str, null);
                        if (a2 == null) {
                            f.a(null, null, null, null);
                            return;
                        }
                        inputStream = a2.a();
                        try {
                            byteArrayOutputStream = c.b(inputStream);
                            try {
                                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                try {
                                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                } catch (Exception e3) {
                                    byteArrayInputStream2 = null;
                                    e2 = e3;
                                } catch (Throwable th2) {
                                    byteArrayInputStream2 = null;
                                    th = th2;
                                    Closeable[] closeableArr = new Closeable[i3];
                                    closeableArr[0] = inputStream;
                                    closeableArr[1] = byteArrayOutputStream;
                                    closeableArr[2] = byteArrayInputStream;
                                    closeableArr[3] = byteArrayInputStream2;
                                    f.a(closeableArr);
                                    throw th;
                                }
                            } catch (Exception e4) {
                                byteArrayInputStream2 = null;
                                e2 = e4;
                                byteArrayInputStream = null;
                            } catch (Throwable th3) {
                                byteArrayInputStream2 = null;
                                th = th3;
                                byteArrayInputStream = null;
                            }
                        } catch (Exception e5) {
                            byteArrayInputStream = null;
                            byteArrayInputStream2 = null;
                            e2 = e5;
                            byteArrayOutputStream = null;
                        } catch (Throwable th4) {
                            byteArrayInputStream = null;
                            byteArrayInputStream2 = null;
                            th = th4;
                            byteArrayOutputStream = null;
                        }
                        try {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                            int a3 = com.ss.android.socialbase.appdownloader.c.a(com.ss.android.socialbase.downloader.downloader.c.N(), 44.0f);
                            options.inSampleSize = c.a(a3, a3, options);
                            options.inJustDecodeBounds = false;
                            c.this.f5464c.put(Integer.valueOf(i2), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                            f.a(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                        } catch (Exception e6) {
                            e2 = e6;
                            e2.printStackTrace();
                            i3 = new Closeable[]{inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                            f.a((Closeable[]) i3);
                        }
                    } catch (Exception e7) {
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e2 = e7;
                        inputStream = null;
                    } catch (Throwable th5) {
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th = th5;
                        inputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        });
    }

    public static int a(int i2, int i3, BitmapFactory.Options options) {
        int i4 = options.outWidth;
        if (i4 > i2 || options.outHeight > i3) {
            return Math.min(Math.round(i4 / i2), Math.round(options.outHeight / i3));
        }
        return 1;
    }
}

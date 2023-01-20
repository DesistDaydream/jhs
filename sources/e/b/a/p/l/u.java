package e.b.a.p.l;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.p.l.n;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class u<Data> implements n<String, Data> {
    private final n<Uri, Data> a;

    /* loaded from: classes.dex */
    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        public n<String, AssetFileDescriptor> c(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: classes.dex */
    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<String, ParcelFileDescriptor> c(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: classes.dex */
    public static class c implements o<String, InputStream> {
        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<String, InputStream> c(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, InputStream.class));
        }
    }

    public u(n<Uri, Data> nVar) {
        this.a = nVar;
    }

    @Nullable
    private static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() == null ? f(str) : parse;
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // e.b.a.p.l.n
    /* renamed from: c */
    public n.a<Data> b(@NonNull String str, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        Uri e2 = e(str);
        if (e2 == null || !this.a.a(e2)) {
            return null;
        }
        return this.a.b(e2, i2, i3, fVar);
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@NonNull String str) {
        return true;
    }
}

package e.b.a.p.l;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import e.b.a.p.l.n;
import java.io.InputStream;

/* loaded from: classes.dex */
public class a<Data> implements n<Uri, Data> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9683c = "android_asset";

    /* renamed from: d  reason: collision with root package name */
    private static final String f9684d = "file:///android_asset/";

    /* renamed from: e  reason: collision with root package name */
    private static final int f9685e = 22;
    private final AssetManager a;
    private final InterfaceC0315a<Data> b;

    /* renamed from: e.b.a.p.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0315a<Data> {
        e.b.a.p.j.d<Data> b(AssetManager assetManager, String str);
    }

    /* loaded from: classes.dex */
    public static class b implements o<Uri, ParcelFileDescriptor>, InterfaceC0315a<ParcelFileDescriptor> {
        private final AssetManager a;

        public b(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.a.InterfaceC0315a
        public e.b.a.p.j.d<ParcelFileDescriptor> b(AssetManager assetManager, String str) {
            return new e.b.a.p.j.h(assetManager, str);
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> c(r rVar) {
            return new a(this.a, this);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements o<Uri, InputStream>, InterfaceC0315a<InputStream> {
        private final AssetManager a;

        public c(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.a.InterfaceC0315a
        public e.b.a.p.j.d<InputStream> b(AssetManager assetManager, String str) {
            return new e.b.a.p.j.m(assetManager, str);
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new a(this.a, this);
        }
    }

    public a(AssetManager assetManager, InterfaceC0315a<Data> interfaceC0315a) {
        this.a = assetManager;
        this.b = interfaceC0315a;
    }

    @Override // e.b.a.p.l.n
    /* renamed from: c */
    public n.a<Data> b(@NonNull Uri uri, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        return new n.a<>(new e.b.a.u.e(uri), this.b.b(this.a, uri.toString().substring(f9685e)));
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && f9683c.equals(uri.getPathSegments().get(0));
    }
}

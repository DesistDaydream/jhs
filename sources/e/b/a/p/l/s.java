package e.b.a.p.l;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import e.b.a.p.l.n;
import java.io.InputStream;

/* loaded from: classes.dex */
public class s<Data> implements n<Integer, Data> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9718c = "ResourceLoader";
    private final n<Uri, Data> a;
    private final Resources b;

    /* loaded from: classes.dex */
    public static final class a implements o<Integer, AssetFileDescriptor> {
        private final Resources a;

        public a(Resources resources) {
            this.a = resources;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        public n<Integer, AssetFileDescriptor> c(r rVar) {
            return new s(this.a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: classes.dex */
    public static class b implements o<Integer, ParcelFileDescriptor> {
        private final Resources a;

        public b(Resources resources) {
            this.a = resources;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<Integer, ParcelFileDescriptor> c(r rVar) {
            return new s(this.a, rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: classes.dex */
    public static class c implements o<Integer, InputStream> {
        private final Resources a;

        public c(Resources resources) {
            this.a = resources;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<Integer, InputStream> c(r rVar) {
            return new s(this.a, rVar.d(Uri.class, InputStream.class));
        }
    }

    /* loaded from: classes.dex */
    public static class d implements o<Integer, Uri> {
        private final Resources a;

        public d(Resources resources) {
            this.a = resources;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<Integer, Uri> c(r rVar) {
            return new s(this.a, v.c());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.b = resources;
        this.a = nVar;
    }

    @Nullable
    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.b.getResourcePackageName(num.intValue()) + Attributes.InternalPrefix + this.b.getResourceTypeName(num.intValue()) + Attributes.InternalPrefix + this.b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (Log.isLoggable(f9718c, 5)) {
                Log.w(f9718c, "Received invalid resource id: " + num, e2);
                return null;
            }
            return null;
        }
    }

    @Override // e.b.a.p.l.n
    /* renamed from: c */
    public n.a<Data> b(@NonNull Integer num, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        Uri d2 = d(num);
        if (d2 == null) {
            return null;
        }
        return this.a.b(d2, i2, i3, fVar);
    }

    @Override // e.b.a.p.l.n
    /* renamed from: e */
    public boolean a(@NonNull Integer num) {
        return true;
    }
}

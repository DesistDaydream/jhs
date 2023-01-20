package e.b.a;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.GeneratedAppGlideModule;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import e.b.a.d;
import e.b.a.p.j.k;
import e.b.a.p.k.a0.d;
import e.b.a.p.l.a;
import e.b.a.p.l.b;
import e.b.a.p.l.d;
import e.b.a.p.l.e;
import e.b.a.p.l.f;
import e.b.a.p.l.k;
import e.b.a.p.l.s;
import e.b.a.p.l.t;
import e.b.a.p.l.u;
import e.b.a.p.l.v;
import e.b.a.p.l.w;
import e.b.a.p.l.x;
import e.b.a.p.l.y.b;
import e.b.a.p.l.y.d;
import e.b.a.p.l.y.e;
import e.b.a.p.l.y.f;
import e.b.a.p.l.y.g;
import e.b.a.p.m.d.c0;
import e.b.a.p.m.d.e0;
import e.b.a.p.m.d.o;
import e.b.a.p.m.d.r;
import e.b.a.p.m.d.w;
import e.b.a.p.m.d.y;
import e.b.a.p.m.d.z;
import e.b.a.p.m.e.a;
import e.b.a.q.p;
import e.b.a.v.l;
import e.b.a.v.n;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class c implements ComponentCallbacks2 {

    /* renamed from: m */
    private static final String f9313m = "image_manager_disk_cache";
    private static final String n = "Glide";
    @GuardedBy("Glide.class")
    private static volatile c o;
    private static volatile boolean p;
    private final e.b.a.p.k.i a;
    private final e.b.a.p.k.x.e b;

    /* renamed from: c */
    private final e.b.a.p.k.y.j f9314c;

    /* renamed from: d */
    private final e f9315d;

    /* renamed from: e */
    private final Registry f9316e;

    /* renamed from: f */
    private final e.b.a.p.k.x.b f9317f;

    /* renamed from: g */
    private final p f9318g;

    /* renamed from: h */
    private final e.b.a.q.d f9319h;

    /* renamed from: j */
    private final a f9321j;
    @Nullable
    @GuardedBy("this")

    /* renamed from: l */
    private e.b.a.p.k.a0.b f9323l;
    @GuardedBy("managers")

    /* renamed from: i */
    private final List<j> f9320i = new ArrayList();

    /* renamed from: k */
    private MemoryCategory f9322k = MemoryCategory.NORMAL;

    /* loaded from: classes.dex */
    public interface a {
        @NonNull
        e.b.a.t.h build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v1, types: [e.b.a.p.m.d.k] */
    public c(@NonNull Context context, @NonNull e.b.a.p.k.i iVar, @NonNull e.b.a.p.k.y.j jVar, @NonNull e.b.a.p.k.x.e eVar, @NonNull e.b.a.p.k.x.b bVar, @NonNull p pVar, @NonNull e.b.a.q.d dVar, int i2, @NonNull a aVar, @NonNull Map<Class<?>, k<?, ?>> map, @NonNull List<e.b.a.t.g<Object>> list, f fVar) {
        e.b.a.p.g c0Var;
        e.b.a.p.m.d.j jVar2;
        this.a = iVar;
        this.b = eVar;
        this.f9317f = bVar;
        this.f9314c = jVar;
        this.f9318g = pVar;
        this.f9319h = dVar;
        this.f9321j = aVar;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f9316e = registry;
        registry.t(new DefaultImageHeaderParser());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 27) {
            registry.t(new r());
        }
        List<ImageHeaderParser> g2 = registry.g();
        e.b.a.p.m.h.a aVar2 = new e.b.a.p.m.h.a(context, g2, eVar, bVar);
        e.b.a.p.g<ParcelFileDescriptor, Bitmap> h2 = VideoDecoder.h(eVar);
        o oVar = new o(registry.g(), resources.getDisplayMetrics(), eVar, bVar);
        if (fVar.b(d.c.class) && i3 >= 28) {
            c0Var = new w();
            jVar2 = new e.b.a.p.m.d.k();
        } else {
            e.b.a.p.m.d.j jVar3 = new e.b.a.p.m.d.j(oVar);
            c0Var = new c0(oVar, bVar);
            jVar2 = jVar3;
        }
        e.b.a.p.m.f.e eVar2 = new e.b.a.p.m.f.e(context);
        s.c cVar = new s.c(resources);
        s.d dVar2 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar3 = new s.a(resources);
        e.b.a.p.m.d.e eVar3 = new e.b.a.p.m.d.e(bVar);
        e.b.a.p.m.i.a aVar4 = new e.b.a.p.m.i.a();
        e.b.a.p.m.i.d dVar3 = new e.b.a.p.m.i.d();
        ContentResolver contentResolver = context.getContentResolver();
        registry.a(ByteBuffer.class, new e.b.a.p.l.c()).a(InputStream.class, new t(bVar)).e(Registry.f1676l, ByteBuffer.class, Bitmap.class, jVar2).e(Registry.f1676l, InputStream.class, Bitmap.class, c0Var);
        if (ParcelFileDescriptorRewinder.c()) {
            registry.e(Registry.f1676l, ParcelFileDescriptor.class, Bitmap.class, new y(oVar));
        }
        registry.e(Registry.f1676l, ParcelFileDescriptor.class, Bitmap.class, h2).e(Registry.f1676l, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.c(eVar)).d(Bitmap.class, Bitmap.class, v.a.b()).e(Registry.f1676l, Bitmap.class, Bitmap.class, new e0()).b(Bitmap.class, eVar3).e(Registry.f1677m, ByteBuffer.class, BitmapDrawable.class, new e.b.a.p.m.d.a(resources, jVar2)).e(Registry.f1677m, InputStream.class, BitmapDrawable.class, new e.b.a.p.m.d.a(resources, c0Var)).e(Registry.f1677m, ParcelFileDescriptor.class, BitmapDrawable.class, new e.b.a.p.m.d.a(resources, h2)).b(BitmapDrawable.class, new e.b.a.p.m.d.b(eVar, eVar3)).e(Registry.f1675k, InputStream.class, e.b.a.p.m.h.c.class, new e.b.a.p.m.h.j(g2, aVar2, bVar)).e(Registry.f1675k, ByteBuffer.class, e.b.a.p.m.h.c.class, aVar2).b(e.b.a.p.m.h.c.class, new e.b.a.p.m.h.d()).d(e.b.a.n.a.class, e.b.a.n.a.class, v.a.b()).e(Registry.f1676l, e.b.a.n.a.class, Bitmap.class, new e.b.a.p.m.h.h(eVar)).c(Uri.class, Drawable.class, eVar2).c(Uri.class, Bitmap.class, new z(eVar2, eVar)).u(new a.C0321a()).d(File.class, ByteBuffer.class, new d.b()).d(File.class, InputStream.class, new f.e()).c(File.class, File.class, new e.b.a.p.m.g.a()).d(File.class, ParcelFileDescriptor.class, new f.b()).d(File.class, File.class, v.a.b()).u(new k.a(bVar));
        if (ParcelFileDescriptorRewinder.c()) {
            registry.u(new ParcelFileDescriptorRewinder.a());
        }
        Class cls = Integer.TYPE;
        registry.d(cls, InputStream.class, cVar).d(cls, ParcelFileDescriptor.class, bVar2).d(Integer.class, InputStream.class, cVar).d(Integer.class, ParcelFileDescriptor.class, bVar2).d(Integer.class, Uri.class, dVar2).d(cls, AssetFileDescriptor.class, aVar3).d(Integer.class, AssetFileDescriptor.class, aVar3).d(cls, Uri.class, dVar2).d(String.class, InputStream.class, new e.c()).d(Uri.class, InputStream.class, new e.c()).d(String.class, InputStream.class, new u.c()).d(String.class, ParcelFileDescriptor.class, new u.b()).d(String.class, AssetFileDescriptor.class, new u.a()).d(Uri.class, InputStream.class, new a.c(context.getAssets())).d(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).d(Uri.class, InputStream.class, new d.a(context)).d(Uri.class, InputStream.class, new e.a(context));
        if (i3 >= 29) {
            registry.d(Uri.class, InputStream.class, new f.c(context));
            registry.d(Uri.class, ParcelFileDescriptor.class, new f.b(context));
        }
        registry.d(Uri.class, InputStream.class, new w.d(contentResolver)).d(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).d(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).d(Uri.class, InputStream.class, new x.a()).d(URL.class, InputStream.class, new g.a()).d(Uri.class, File.class, new k.a(context)).d(e.b.a.p.l.g.class, InputStream.class, new b.a()).d(byte[].class, ByteBuffer.class, new b.a()).d(byte[].class, InputStream.class, new b.d()).d(Uri.class, Uri.class, v.a.b()).d(Drawable.class, Drawable.class, v.a.b()).c(Drawable.class, Drawable.class, new e.b.a.p.m.f.f()).x(Bitmap.class, BitmapDrawable.class, new e.b.a.p.m.i.b(resources)).x(Bitmap.class, byte[].class, aVar4).x(Drawable.class, byte[].class, new e.b.a.p.m.i.c(eVar, aVar4, dVar3)).x(e.b.a.p.m.h.c.class, byte[].class, dVar3);
        if (i3 >= 23) {
            e.b.a.p.g<ByteBuffer, Bitmap> d2 = VideoDecoder.d(eVar);
            registry.c(ByteBuffer.class, Bitmap.class, d2);
            registry.c(ByteBuffer.class, BitmapDrawable.class, new e.b.a.p.m.d.a(resources, d2));
        }
        this.f9315d = new e(context, bVar, registry, new e.b.a.t.k.k(), aVar, map, list, iVar, fVar, i2);
    }

    @NonNull
    public static j B(@NonNull Activity activity) {
        return o(activity).j(activity);
    }

    @NonNull
    @Deprecated
    public static j C(@NonNull Fragment fragment) {
        return o(fragment.getActivity()).k(fragment);
    }

    @NonNull
    public static j D(@NonNull Context context) {
        return o(context).l(context);
    }

    @NonNull
    public static j E(@NonNull View view) {
        return o(view.getContext()).m(view);
    }

    @NonNull
    public static j F(@NonNull androidx.fragment.app.Fragment fragment) {
        return o(fragment.getContext()).n(fragment);
    }

    @NonNull
    public static j G(@NonNull FragmentActivity fragmentActivity) {
        return o(fragmentActivity).o(fragmentActivity);
    }

    @GuardedBy("Glide.class")
    private static void a(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (!p) {
            p = true;
            r(context, generatedAppGlideModule);
            p = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @VisibleForTesting
    public static void d() {
        e.b.a.p.m.d.u.d().l();
    }

    @NonNull
    public static c e(@NonNull Context context) {
        if (o == null) {
            GeneratedAppGlideModule f2 = f(context.getApplicationContext());
            synchronized (c.class) {
                if (o == null) {
                    a(context, f2);
                }
            }
        }
        return o;
    }

    @Nullable
    private static GeneratedAppGlideModule f(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable(n, 5)) {
                Log.w(n, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e2) {
            y(e2);
            return null;
        } catch (InstantiationException e3) {
            y(e3);
            return null;
        } catch (NoSuchMethodException e4) {
            y(e4);
            return null;
        } catch (InvocationTargetException e5) {
            y(e5);
            return null;
        }
    }

    @Nullable
    public static File k(@NonNull Context context) {
        return l(context, "image_manager_disk_cache");
    }

    @Nullable
    public static File l(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.isDirectory() || file.mkdirs()) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable(n, 6)) {
            Log.e(n, "default disk cache dir is null");
        }
        return null;
    }

    @NonNull
    private static p o(@Nullable Context context) {
        l.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return e(context).n();
    }

    @VisibleForTesting
    public static void p(@NonNull Context context, @NonNull d dVar) {
        GeneratedAppGlideModule f2 = f(context);
        synchronized (c.class) {
            if (o != null) {
                x();
            }
            s(context, dVar, f2);
        }
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void q(c cVar) {
        synchronized (c.class) {
            if (o != null) {
                x();
            }
            o = cVar;
        }
    }

    @GuardedBy("Glide.class")
    private static void r(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        s(context, new d(), generatedAppGlideModule);
    }

    @GuardedBy("Glide.class")
    private static void s(@NonNull Context context, @NonNull d dVar, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<e.b.a.r.c> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new e.b.a.r.e(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> d2 = generatedAppGlideModule.d();
            Iterator<e.b.a.r.c> it = emptyList.iterator();
            while (it.hasNext()) {
                e.b.a.r.c next = it.next();
                if (d2.contains(next.getClass())) {
                    if (Log.isLoggable(n, 3)) {
                        Log.d(n, "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(n, 3)) {
            Iterator<e.b.a.r.c> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d(n, "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        dVar.t(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        for (e.b.a.r.c cVar : emptyList) {
            cVar.a(applicationContext, dVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, dVar);
        }
        c b = dVar.b(applicationContext);
        for (e.b.a.r.c cVar2 : emptyList) {
            try {
                cVar2.b(applicationContext, b, b.f9316e);
            } catch (AbstractMethodError e2) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + cVar2.getClass().getName(), e2);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, b, b.f9316e);
        }
        applicationContext.registerComponentCallbacks(b);
        o = b;
    }

    @VisibleForTesting
    public static void x() {
        synchronized (c.class) {
            if (o != null) {
                o.getContext().getApplicationContext().unregisterComponentCallbacks(o);
                o.a.m();
            }
            o = null;
        }
    }

    private static void y(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public void A(j jVar) {
        synchronized (this.f9320i) {
            if (this.f9320i.contains(jVar)) {
                this.f9320i.remove(jVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public void b() {
        n.a();
        this.a.e();
    }

    public void c() {
        n.b();
        this.f9314c.b();
        this.b.b();
        this.f9317f.b();
    }

    @NonNull
    public e.b.a.p.k.x.b g() {
        return this.f9317f;
    }

    @NonNull
    public Context getContext() {
        return this.f9315d.getBaseContext();
    }

    @NonNull
    public e.b.a.p.k.x.e h() {
        return this.b;
    }

    public e.b.a.q.d i() {
        return this.f9319h;
    }

    @NonNull
    public e j() {
        return this.f9315d;
    }

    @NonNull
    public Registry m() {
        return this.f9316e;
    }

    @NonNull
    public p n() {
        return this.f9318g;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        c();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        z(i2);
    }

    public synchronized void t(@NonNull d.a... aVarArr) {
        if (this.f9323l == null) {
            this.f9323l = new e.b.a.p.k.a0.b(this.f9314c, this.b, (DecodeFormat) this.f9321j.build().M().a(o.f9763g));
        }
        this.f9323l.c(aVarArr);
    }

    public void u(j jVar) {
        synchronized (this.f9320i) {
            if (!this.f9320i.contains(jVar)) {
                this.f9320i.add(jVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    public boolean v(@NonNull e.b.a.t.k.p<?> pVar) {
        synchronized (this.f9320i) {
            for (j jVar : this.f9320i) {
                if (jVar.R(pVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    @NonNull
    public MemoryCategory w(@NonNull MemoryCategory memoryCategory) {
        n.b();
        this.f9314c.c(memoryCategory.getMultiplier());
        this.b.c(memoryCategory.getMultiplier());
        MemoryCategory memoryCategory2 = this.f9322k;
        this.f9322k = memoryCategory;
        return memoryCategory2;
    }

    public void z(int i2) {
        n.b();
        synchronized (this.f9320i) {
            for (j jVar : this.f9320i) {
                jVar.onTrimMemory(i2);
            }
        }
        this.f9314c.a(i2);
        this.b.a(i2);
        this.f9317f.a(i2);
    }
}

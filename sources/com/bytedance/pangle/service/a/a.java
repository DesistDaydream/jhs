package com.bytedance.pangle.service.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.d;
import com.bytedance.pangle.f;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class a extends d.a {
    private static volatile a b;

    /* renamed from: c */
    private final HashMap<ComponentName, IBinder> f2340c = new HashMap<>();

    /* renamed from: d */
    private final HashMap<ComponentName, b> f2341d = new HashMap<>();

    /* renamed from: e */
    private final C0085a<Intent> f2342e = new C0085a<>();

    /* renamed from: f */
    private final HashMap<ComponentName, com.bytedance.pangle.service.a> f2343f = new HashMap<>();

    /* renamed from: g */
    private final HashSet<ComponentName> f2344g = new HashSet<>();

    /* renamed from: h */
    private final HashSet<ComponentName> f2345h = new HashSet<>();
    private final Handler a = new Handler(Looper.getMainLooper());

    /* renamed from: com.bytedance.pangle.service.a.a$a */
    /* loaded from: classes.dex */
    public class C0085a<T> extends HashMap<f, T> {
        public C0085a() {
            a.this = r1;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@Nullable Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (obj instanceof f) {
                for (f fVar : keySet()) {
                    try {
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                    if (fVar.a() == ((f) obj).a()) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public final T remove(@Nullable Object obj) {
            f fVar;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<f> it = keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    fVar = null;
                    break;
                }
                fVar = it.next();
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (fVar.a() == ((f) obj).a()) {
                    break;
                }
            }
            return (T) super.remove(fVar);
        }
    }

    /* loaded from: classes.dex */
    public class b extends HashSet<f> {
        public b() {
            a.this = r1;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@Nullable Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (obj instanceof f) {
                Iterator<f> it = iterator();
                while (it.hasNext()) {
                    try {
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                    if (it.next().a() == ((f) obj).a()) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@Nullable Object obj) {
            if (super.remove(obj)) {
                return true;
            }
            f fVar = null;
            Iterator<f> it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f next = it.next();
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (next.a() == ((f) obj).a()) {
                    fVar = next;
                    break;
                }
            }
            return super.remove(fVar);
        }
    }

    private a() {
    }

    public static a b() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public synchronized ComponentName c(Intent intent, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f2343f.containsKey(component)) {
            com.bytedance.pangle.service.a d2 = d(intent, str);
            if (d2 == null) {
                return component;
            }
            this.f2343f.put(component, d2);
            this.f2344g.add(component);
        }
        com.bytedance.pangle.service.a aVar = this.f2343f.get(component);
        if (aVar != null) {
            aVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    private static com.bytedance.pangle.service.a d(Intent intent, String str) {
        com.bytedance.pangle.service.a e2 = e(intent, str);
        if (e2 != null) {
            e2.onCreate();
        }
        return e2;
    }

    private static com.bytedance.pangle.service.a e(Intent intent, String str) {
        boolean z;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            z = Zeus.loadPlugin(str);
            try {
                com.bytedance.pangle.service.a aVar = (com.bytedance.pangle.service.a) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                aVar.attach(plugin);
                return aVar;
            } catch (Exception e2) {
                e = e2;
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(z)), e);
                throw new RuntimeException(e);
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
    }

    @Override // com.bytedance.pangle.d.a, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.bytedance.pangle.d
    public final ComponentName a(final Intent intent, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return c(intent, str);
        }
        this.a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.1
            {
                a.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.c(intent, str);
            }
        });
        return intent.getComponent();
    }

    @Override // com.bytedance.pangle.d
    public final boolean b(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b().a(intent.getComponent());
            return true;
        }
        this.a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.2
            {
                a.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.b().a(intent.getComponent());
            }
        });
        return true;
    }

    public final synchronized boolean a(ComponentName componentName) {
        if (this.f2343f.containsKey(componentName)) {
            this.f2345h.add(componentName);
            return b(componentName);
        }
        return false;
    }

    private boolean b(ComponentName componentName) {
        if (!this.f2344g.contains(componentName)) {
            if (this.f2341d.get(componentName) == null) {
                c(componentName);
                return true;
            }
            return false;
        } else if (!this.f2345h.contains(componentName) || this.f2341d.containsKey(componentName)) {
            return false;
        } else {
            c(componentName);
            return true;
        }
    }

    private void c(ComponentName componentName) {
        com.bytedance.pangle.service.a remove = this.f2343f.remove(componentName);
        this.f2345h.remove(componentName);
        this.f2340c.remove(componentName);
        this.f2344g.remove(componentName);
        if (remove != null) {
            remove.onDestroy();
        }
    }

    @Override // com.bytedance.pangle.d
    public final boolean a(final Intent intent, final f fVar, final int i2, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return a(intent, fVar, str);
        }
        this.a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.3
            {
                a.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(intent, fVar, str);
                } catch (RemoteException e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e2);
                }
            }
        });
        return true;
    }

    public synchronized boolean a(Intent intent, f fVar, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f2343f.containsKey(component)) {
            com.bytedance.pangle.service.a d2 = d(intent, str);
            if (d2 == null) {
                return false;
            }
            this.f2343f.put(component, d2);
        }
        com.bytedance.pangle.service.a aVar = this.f2343f.get(component);
        if (!this.f2340c.containsKey(component)) {
            this.f2340c.put(component, aVar.onBind(intent));
        }
        IBinder iBinder = this.f2340c.get(component);
        if (iBinder != null) {
            if (this.f2341d.containsKey(component)) {
                if (!this.f2341d.get(component).contains(fVar)) {
                    this.f2341d.get(component).add(fVar);
                    this.f2342e.put(fVar, intent);
                    fVar.a(component, iBinder);
                }
            } else {
                b bVar = new b();
                bVar.add(fVar);
                this.f2341d.put(component, bVar);
                this.f2342e.put(fVar, intent);
                fVar.a(component, iBinder);
            }
        }
        return true;
    }

    public synchronized void b(f fVar) {
        for (ComponentName componentName : this.f2341d.keySet()) {
            b bVar = this.f2341d.get(componentName);
            if (bVar.contains(fVar)) {
                bVar.remove(fVar);
                Intent remove = this.f2342e.remove(fVar);
                if (bVar.size() == 0) {
                    this.f2341d.remove(componentName);
                    com.bytedance.pangle.service.a aVar = this.f2343f.get(componentName);
                    if (aVar != null) {
                        aVar.onUnbind(remove);
                    }
                }
                b(componentName);
                return;
            }
        }
    }

    @Override // com.bytedance.pangle.d
    public final void a(final f fVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(fVar);
        } else {
            this.a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.4
                {
                    a.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.this.b(fVar);
                }
            });
        }
    }
}

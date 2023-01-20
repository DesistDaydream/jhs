package com.meizu.cloud.pushsdk.d.b.a;

import com.meizu.cloud.pushsdk.c.c.i;
import com.meizu.cloud.pushsdk.d.b.a;
import com.meizu.cloud.pushsdk.d.b.e;
import com.meizu.cloud.pushsdk.d.b.f;
import com.meizu.cloud.pushsdk.d.b.g;
import com.meizu.cloud.pushsdk.d.d.c;
import com.meizu.cloud.pushsdk.d.d.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class a extends com.meizu.cloud.pushsdk.d.b.a {

    /* renamed from: h  reason: collision with root package name */
    private final String f4812h;

    /* renamed from: i  reason: collision with root package name */
    private d f4813i;

    /* renamed from: j  reason: collision with root package name */
    private int f4814j;

    public a(a.C0158a c0158a) {
        super(c0158a);
        String simpleName = a.class.getSimpleName();
        this.f4812h = simpleName;
        com.meizu.cloud.pushsdk.d.d.a aVar = new com.meizu.cloud.pushsdk.d.d.a(this.a, this.f4803e);
        this.f4813i = aVar;
        if (aVar.a()) {
            return;
        }
        this.f4813i = new c(this.f4803e);
        com.meizu.cloud.pushsdk.d.f.c.a(simpleName, "init memory store", new Object[0]);
    }

    private LinkedList<g> a(LinkedList<e> linkedList) {
        LinkedList<g> linkedList2 = new LinkedList<>();
        LinkedList linkedList3 = new LinkedList();
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(b.a(b(it.next().a())));
        }
        com.meizu.cloud.pushsdk.d.f.c.b(this.f4812h, "Request Futures: %s", Integer.valueOf(linkedList3.size()));
        for (int i2 = 0; i2 < linkedList3.size(); i2++) {
            int i3 = -1;
            try {
                i3 = ((Integer) ((Future) linkedList3.get(i2)).get(5L, TimeUnit.SECONDS)).intValue();
            } catch (InterruptedException e2) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.f4812h, "Request Future was interrupted: %s", e2.getMessage());
            } catch (ExecutionException e3) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.f4812h, "Request Future failed: %s", e3.getMessage());
            } catch (TimeoutException e4) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.f4812h, "Request Future had a timeout: %s", e4.getMessage());
            }
            if (linkedList.get(i2).c()) {
                linkedList2.add(new g(true, linkedList.get(i2).b()));
            } else {
                linkedList2.add(new g(a(i3), linkedList.get(i2).b()));
            }
        }
        return linkedList2;
    }

    private Callable<Boolean> a(final Long l2) {
        return new Callable<Boolean>() { // from class: com.meizu.cloud.pushsdk.d.b.a.a.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                return Boolean.valueOf(a.this.f4813i.a(l2.longValue()));
            }
        };
    }

    private LinkedList<Boolean> b(LinkedList<Long> linkedList) {
        boolean z;
        LinkedList<Boolean> linkedList2 = new LinkedList<>();
        LinkedList linkedList3 = new LinkedList();
        Iterator<Long> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(b.a(a(it.next())));
        }
        com.meizu.cloud.pushsdk.d.f.c.b(this.f4812h, "Removal Futures: %s", Integer.valueOf(linkedList3.size()));
        for (int i2 = 0; i2 < linkedList3.size(); i2++) {
            try {
                z = ((Boolean) ((Future) linkedList3.get(i2)).get(5L, TimeUnit.SECONDS)).booleanValue();
            } catch (InterruptedException e2) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.f4812h, "Removal Future was interrupted: %s", e2.getMessage());
                z = false;
                linkedList2.add(Boolean.valueOf(z));
            } catch (ExecutionException e3) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.f4812h, "Removal Future failed: %s", e3.getMessage());
                z = false;
                linkedList2.add(Boolean.valueOf(z));
            } catch (TimeoutException e4) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.f4812h, "Removal Future had a timeout: %s", e4.getMessage());
                z = false;
                linkedList2.add(Boolean.valueOf(z));
            }
            linkedList2.add(Boolean.valueOf(z));
        }
        return linkedList2;
    }

    private Callable<Integer> b(final i iVar) {
        return new Callable<Integer>() { // from class: com.meizu.cloud.pushsdk.d.b.a.a.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Integer call() {
                return Integer.valueOf(a.this.a(iVar));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (com.meizu.cloud.pushsdk.d.f.e.a(this.a)) {
            if (this.f4813i.c() > 0) {
                this.f4814j = 0;
                LinkedList<g> a = a(a(this.f4813i.d()));
                com.meizu.cloud.pushsdk.d.f.c.c(this.f4812h, "Processing emitter results.", new Object[0]);
                LinkedList<Long> linkedList = new LinkedList<>();
                Iterator<g> it = a.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    g next = it.next();
                    if (next.a()) {
                        linkedList.addAll(next.b());
                        i2 += next.b().size();
                    } else {
                        i3 += next.b().size();
                        com.meizu.cloud.pushsdk.d.f.c.a(this.f4812h, "Request sending failed but we will retry later.", new Object[0]);
                    }
                }
                b(linkedList);
                com.meizu.cloud.pushsdk.d.f.c.b(this.f4812h, "Success Count: %s", Integer.valueOf(i2));
                com.meizu.cloud.pushsdk.d.f.c.b(this.f4812h, "Failure Count: %s", Integer.valueOf(i3));
                f fVar = this.b;
                if (fVar != null) {
                    if (i3 != 0) {
                        fVar.a(i2, i3);
                    } else {
                        fVar.a(i2);
                    }
                }
                if (i3 > 0 && i2 == 0) {
                    if (com.meizu.cloud.pushsdk.d.f.e.a(this.a)) {
                        com.meizu.cloud.pushsdk.d.f.c.a(this.f4812h, "Ensure collector path is valid: %s", b());
                    }
                    com.meizu.cloud.pushsdk.d.f.c.a(this.f4812h, "Emitter loop stopping: failures.", new Object[0]);
                }
            } else {
                int i4 = this.f4814j;
                if (i4 >= this.f4802d) {
                    com.meizu.cloud.pushsdk.d.f.c.a(this.f4812h, "Emitter loop stopping: empty limit reached.", new Object[0]);
                    this.f4805g.compareAndSet(true, false);
                    f fVar2 = this.b;
                    if (fVar2 != null) {
                        fVar2.a(true);
                        return;
                    }
                    return;
                }
                this.f4814j = i4 + 1;
                String str = this.f4812h;
                com.meizu.cloud.pushsdk.d.f.c.a(str, "Emitter database empty: " + this.f4814j, new Object[0]);
                try {
                    this.f4804f.sleep(this.f4801c);
                } catch (InterruptedException e2) {
                    String str2 = this.f4812h;
                    com.meizu.cloud.pushsdk.d.f.c.a(str2, "Emitter thread sleep interrupted: " + e2.toString(), new Object[0]);
                }
            }
            c();
            return;
        }
        com.meizu.cloud.pushsdk.d.f.c.a(this.f4812h, "Emitter loop stopping: emitter offline.", new Object[0]);
        this.f4805g.compareAndSet(true, false);
    }

    @Override // com.meizu.cloud.pushsdk.d.b.a
    public void a() {
        b.a(new Runnable() { // from class: com.meizu.cloud.pushsdk.d.b.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f4805g.compareAndSet(false, true)) {
                    a.this.c();
                }
            }
        });
    }

    @Override // com.meizu.cloud.pushsdk.d.b.a
    public void a(com.meizu.cloud.pushsdk.d.a.a aVar, boolean z) {
        this.f4813i.a(aVar);
        String str = this.f4812h;
        com.meizu.cloud.pushsdk.d.f.c.a(str, "isRunning " + this.f4805g + " attemptEmit " + z, new Object[0]);
        if (!z) {
            try {
                this.f4804f.sleep(1L);
            } catch (InterruptedException e2) {
                String str2 = this.f4812h;
                com.meizu.cloud.pushsdk.d.f.c.a(str2, "Emitter add thread sleep interrupted: " + e2.toString(), new Object[0]);
            }
        }
        if (this.f4805g.compareAndSet(false, true)) {
            c();
        }
    }
}

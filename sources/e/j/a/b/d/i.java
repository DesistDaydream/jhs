package e.j.a.b.d;

import e.j.a.b.d.a;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class i implements g<T> {
    private final /* synthetic */ a a;

    public i(a aVar) {
        this.a = aVar;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    @Override // e.j.a.b.d.g
    public final void a(e eVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        e eVar2;
        this.a.a = eVar;
        linkedList = this.a.f10488c;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            eVar2 = this.a.a;
            ((a.InterfaceC0345a) it.next()).a(eVar2);
        }
        linkedList2 = this.a.f10488c;
        linkedList2.clear();
        this.a.b = null;
    }
}

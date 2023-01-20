package h.p2.b0.g.t.c.d1;

import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;

/* loaded from: classes3.dex */
public final class u implements t {
    @k.e.a.d
    private final List<ModuleDescriptorImpl> a;
    @k.e.a.d
    private final Set<ModuleDescriptorImpl> b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final List<ModuleDescriptorImpl> f15156c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final Set<ModuleDescriptorImpl> f15157d;

    public u(@k.e.a.d List<ModuleDescriptorImpl> list, @k.e.a.d Set<ModuleDescriptorImpl> set, @k.e.a.d List<ModuleDescriptorImpl> list2, @k.e.a.d Set<ModuleDescriptorImpl> set2) {
        this.a = list;
        this.b = set;
        this.f15156c = list2;
        this.f15157d = set2;
    }

    @Override // h.p2.b0.g.t.c.d1.t
    @k.e.a.d
    public List<ModuleDescriptorImpl> a() {
        return this.a;
    }

    @Override // h.p2.b0.g.t.c.d1.t
    @k.e.a.d
    public List<ModuleDescriptorImpl> b() {
        return this.f15156c;
    }

    @Override // h.p2.b0.g.t.c.d1.t
    @k.e.a.d
    public Set<ModuleDescriptorImpl> c() {
        return this.b;
    }
}

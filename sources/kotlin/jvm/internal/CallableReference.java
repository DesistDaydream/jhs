package kotlin.jvm.internal;

import com.caverock.androidsvg.SVG;
import h.k2.v.n0;
import h.p2.c;
import h.p2.h;
import h.p2.r;
import h.p2.s;
import h.s0;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KParameter;
import kotlin.reflect.KVisibility;

/* loaded from: classes3.dex */
public abstract class CallableReference implements c, Serializable {
    @s0(version = "1.1")
    public static final Object NO_RECEIVER = NoReceiver.INSTANCE;
    @s0(version = "1.4")
    private final boolean isTopLevel;
    @s0(version = "1.4")
    private final String name;
    @s0(version = "1.4")
    private final Class owner;
    @s0(version = "1.1")
    public final Object receiver;
    private transient c reflected;
    @s0(version = "1.4")
    private final String signature;

    @s0(version = SVG.f2474i)
    /* loaded from: classes3.dex */
    public static class NoReceiver implements Serializable {
        private static final NoReceiver INSTANCE = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() throws ObjectStreamException {
            return INSTANCE;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @Override // h.p2.c
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // h.p2.c
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    @s0(version = "1.1")
    public c compute() {
        c cVar = this.reflected;
        if (cVar == null) {
            c computeReflected = computeReflected();
            this.reflected = computeReflected;
            return computeReflected;
        }
        return cVar;
    }

    public abstract c computeReflected();

    @Override // h.p2.b
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @s0(version = "1.1")
    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // h.p2.c
    public String getName() {
        return this.name;
    }

    public h getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? n0.g(cls) : n0.d(cls);
    }

    @Override // h.p2.c
    public List<KParameter> getParameters() {
        return getReflected().getParameters();
    }

    @s0(version = "1.1")
    public c getReflected() {
        c compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // h.p2.c
    public r getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // h.p2.c
    @s0(version = "1.1")
    public List<s> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // h.p2.c
    @s0(version = "1.1")
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // h.p2.c
    @s0(version = "1.1")
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // h.p2.c
    @s0(version = "1.1")
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // h.p2.c
    @s0(version = "1.1")
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // h.p2.c
    @s0(version = "1.3")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    @s0(version = "1.1")
    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    @s0(version = "1.4")
    public CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }
}

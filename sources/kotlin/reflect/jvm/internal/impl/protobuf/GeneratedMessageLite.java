package kotlin.reflect.jvm.internal.impl.protobuf;

import h.p2.b0.g.t.i.a;
import h.p2.b0.g.t.i.g;
import h.p2.b0.g.t.i.h;
import h.p2.b0.g.t.i.n;
import h.p2.b0.g.t.i.o;
import h.p2.b0.g.t.i.p;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

/* loaded from: classes3.dex */
public abstract class GeneratedMessageLite extends h.p2.b0.g.t.i.a implements Serializable {

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[WireFormat.JavaType.values().length];
            a = iArr;
            try {
                iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[WireFormat.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b<MessageType extends GeneratedMessageLite, BuilderType extends b> extends a.AbstractC0459a<BuilderType> {
        private h.p2.b0.g.t.i.d a = h.p2.b0.g.t.i.d.a;

        @Override // h.p2.b0.g.t.i.a.AbstractC0459a
        /* renamed from: e */
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        @Override // h.p2.b0.g.t.i.o
        /* renamed from: f */
        public abstract MessageType getDefaultInstanceForType();

        public final h.p2.b0.g.t.i.d g() {
            return this.a;
        }

        public abstract BuilderType h(MessageType messagetype);

        public final BuilderType j(h.p2.b0.g.t.i.d dVar) {
            this.a = dVar;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class c<MessageType extends ExtendableMessage<MessageType>, BuilderType extends c<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements d<MessageType> {
        private g<e> b = g.g();

        /* renamed from: c  reason: collision with root package name */
        private boolean f16736c;

        /* JADX INFO: Access modifiers changed from: private */
        public g<e> l() {
            this.b.q();
            this.f16736c = false;
            return this.b;
        }

        private void n() {
            if (this.f16736c) {
                return;
            }
            this.b = this.b.clone();
            this.f16736c = true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: m */
        public BuilderType e() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public boolean o() {
            return this.b.n();
        }

        public final void p(MessageType messagetype) {
            n();
            this.b.r(((ExtendableMessage) messagetype).extensions);
        }
    }

    /* loaded from: classes3.dex */
    public interface d<MessageType extends ExtendableMessage> extends o {
    }

    /* loaded from: classes3.dex */
    public static final class e implements g.b<e> {
        public final h.b<?> a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final WireFormat.FieldType f16737c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f16738d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f16739e;

        public e(h.b<?> bVar, int i2, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.a = bVar;
            this.b = i2;
            this.f16737c = fieldType;
            this.f16738d = z;
            this.f16739e = z2;
        }

        @Override // h.p2.b0.g.t.i.g.b
        public boolean I() {
            return this.f16738d;
        }

        @Override // h.p2.b0.g.t.i.g.b
        public WireFormat.FieldType J() {
            return this.f16737c;
        }

        @Override // h.p2.b0.g.t.i.g.b
        public WireFormat.JavaType K() {
            return this.f16737c.getJavaType();
        }

        @Override // h.p2.b0.g.t.i.g.b
        public boolean L() {
            return this.f16739e;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(e eVar) {
            return this.b - eVar.b;
        }

        public h.b<?> b() {
            return this.a;
        }

        @Override // h.p2.b0.g.t.i.g.b
        public n.a c(n.a aVar, n nVar) {
            return ((b) aVar).h((GeneratedMessageLite) nVar);
        }

        @Override // h.p2.b0.g.t.i.g.b
        public int getNumber() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    public static class f<ContainingType extends n, Type> {
        public final ContainingType a;
        public final Type b;

        /* renamed from: c  reason: collision with root package name */
        public final n f16740c;

        /* renamed from: d  reason: collision with root package name */
        public final e f16741d;

        /* renamed from: e  reason: collision with root package name */
        public final Class f16742e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f16743f;

        public f(ContainingType containingtype, Type type, n nVar, e eVar, Class cls) {
            if (containingtype != null) {
                if (eVar.J() == WireFormat.FieldType.MESSAGE && nVar == null) {
                    throw new IllegalArgumentException("Null messageDefaultInstance");
                }
                this.a = containingtype;
                this.b = type;
                this.f16740c = nVar;
                this.f16741d = eVar;
                this.f16742e = cls;
                if (h.a.class.isAssignableFrom(cls)) {
                    this.f16743f = GeneratedMessageLite.getMethodOrDie(cls, "valueOf", Integer.TYPE);
                    return;
                } else {
                    this.f16743f = null;
                    return;
                }
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        public Object a(Object obj) {
            if (this.f16741d.I()) {
                if (this.f16741d.K() == WireFormat.JavaType.ENUM) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : (List) obj) {
                        arrayList.add(e(obj2));
                    }
                    return arrayList;
                }
                return obj;
            }
            return e(obj);
        }

        public ContainingType b() {
            return this.a;
        }

        public n c() {
            return this.f16740c;
        }

        public int d() {
            return this.f16741d.getNumber();
        }

        public Object e(Object obj) {
            return this.f16741d.K() == WireFormat.JavaType.ENUM ? GeneratedMessageLite.invokeOrDie(this.f16743f, null, (Integer) obj) : obj;
        }

        public Object f(Object obj) {
            return this.f16741d.K() == WireFormat.JavaType.ENUM ? Integer.valueOf(((h.a) obj).getNumber()) : obj;
        }
    }

    public GeneratedMessageLite() {
    }

    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            String valueOf = String.valueOf(String.valueOf(cls.getName()));
            String valueOf2 = String.valueOf(String.valueOf(str));
            StringBuilder sb = new StringBuilder(valueOf.length() + 45 + valueOf2.length());
            sb.append("Generated message class \"");
            sb.append(valueOf);
            sb.append("\" missing method \"");
            sb.append(valueOf2);
            sb.append("\".");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static <ContainingType extends n, Type> f<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, n nVar, h.b<?> bVar, int i2, WireFormat.FieldType fieldType, boolean z, Class cls) {
        return new f<>(containingtype, Collections.emptyList(), nVar, new e(bVar, i2, fieldType, true, z), cls);
    }

    public static <ContainingType extends n, Type> f<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, n nVar, h.b<?> bVar, int i2, WireFormat.FieldType fieldType, Class cls) {
        return new f<>(containingtype, type, nVar, new e(bVar, i2, fieldType, false, false), cls);
    }

    @Override // h.p2.b0.g.t.i.n
    public p<? extends n> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public void makeExtensionsImmutable() {
    }

    public boolean parseUnknownField(h.p2.b0.g.t.i.e eVar, CodedOutputStream codedOutputStream, h.p2.b0.g.t.i.f fVar, int i2) throws IOException {
        return eVar.P(i2, codedOutputStream);
    }

    /* loaded from: classes3.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements d<MessageType> {
        private final g<e> extensions;

        /* loaded from: classes3.dex */
        public class a {
            private final Iterator<Map.Entry<e, Object>> a;
            private Map.Entry<e, Object> b;

            /* renamed from: c  reason: collision with root package name */
            private final boolean f16734c;

            public /* synthetic */ a(ExtendableMessage extendableMessage, boolean z, a aVar) {
                this(z);
            }

            public void a(int i2, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<e, Object> entry = this.b;
                    if (entry == null || entry.getKey().getNumber() >= i2) {
                        return;
                    }
                    e key = this.b.getKey();
                    if (this.f16734c && key.K() == WireFormat.JavaType.MESSAGE && !key.I()) {
                        codedOutputStream.f0(key.getNumber(), (n) this.b.getValue());
                    } else {
                        g.z(key, this.b.getValue(), codedOutputStream);
                    }
                    if (this.a.hasNext()) {
                        this.b = this.a.next();
                    } else {
                        this.b = null;
                    }
                }
            }

            private a(boolean z) {
                Iterator<Map.Entry<e, Object>> p = ExtendableMessage.this.extensions.p();
                this.a = p;
                if (p.hasNext()) {
                    this.b = p.next();
                }
                this.f16734c = z;
            }
        }

        public ExtendableMessage() {
            this.extensions = g.t();
        }

        private void verifyExtensionContainingType(f<MessageType, ?> fVar) {
            if (fVar.b() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.n();
        }

        public int extensionsSerializedSize() {
            return this.extensions.k();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type getExtension(f<MessageType, Type> fVar) {
            verifyExtensionContainingType(fVar);
            Object h2 = this.extensions.h(fVar.f16741d);
            if (h2 == null) {
                return fVar.b;
            }
            return (Type) fVar.a(h2);
        }

        public final <Type> int getExtensionCount(f<MessageType, List<Type>> fVar) {
            verifyExtensionContainingType(fVar);
            return this.extensions.j(fVar.f16741d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(f<MessageType, Type> fVar) {
            verifyExtensionContainingType(fVar);
            return this.extensions.m(fVar.f16741d);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public void makeExtensionsImmutable() {
            this.extensions.q();
        }

        public ExtendableMessage<MessageType>.a newExtensionWriter() {
            return new a(this, false, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public boolean parseUnknownField(h.p2.b0.g.t.i.e eVar, CodedOutputStream codedOutputStream, h.p2.b0.g.t.i.f fVar, int i2) throws IOException {
            return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), eVar, codedOutputStream, fVar, i2);
        }

        public ExtendableMessage(c<MessageType, ?> cVar) {
            this.extensions = cVar.l();
        }

        public final <Type> Type getExtension(f<MessageType, List<Type>> fVar, int i2) {
            verifyExtensionContainingType(fVar);
            return (Type) fVar.e(this.extensions.i(fVar.f16741d, i2));
        }
    }

    public GeneratedMessageLite(b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <MessageType extends h.p2.b0.g.t.i.n> boolean parseUnknownField(h.p2.b0.g.t.i.g<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.e> r5, MessageType r6, h.p2.b0.g.t.i.e r7, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r8, h.p2.b0.g.t.i.f r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.parseUnknownField(h.p2.b0.g.t.i.g, h.p2.b0.g.t.i.n, h.p2.b0.g.t.i.e, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream, h.p2.b0.g.t.i.f, int):boolean");
    }
}

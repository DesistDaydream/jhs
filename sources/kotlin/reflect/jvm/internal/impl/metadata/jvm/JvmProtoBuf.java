package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import h.p2.b0.g.t.f.a0.c;
import h.p2.b0.g.t.i.a;
import h.p2.b0.g.t.i.d;
import h.p2.b0.g.t.i.e;
import h.p2.b0.g.t.i.f;
import h.p2.b0.g.t.i.h;
import h.p2.b0.g.t.i.p;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

/* loaded from: classes3.dex */
public final class JvmProtoBuf {
    public static final GeneratedMessageLite.f<ProtoBuf.Constructor, JvmMethodSignature> a;
    public static final GeneratedMessageLite.f<ProtoBuf.Function, JvmMethodSignature> b;

    /* renamed from: c  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Function, Integer> f16704c;

    /* renamed from: d  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Property, JvmPropertySignature> f16705d;

    /* renamed from: e  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Property, Integer> f16706e;

    /* renamed from: f  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Type, List<ProtoBuf.Annotation>> f16707f;

    /* renamed from: g  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Type, Boolean> f16708g;

    /* renamed from: h  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> f16709h;

    /* renamed from: i  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Class, Integer> f16710i;

    /* renamed from: j  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Class, List<ProtoBuf.Property>> f16711j;

    /* renamed from: k  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Class, Integer> f16712k;

    /* renamed from: l  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Class, Integer> f16713l;

    /* renamed from: m  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Package, Integer> f16714m;
    public static final GeneratedMessageLite.f<ProtoBuf.Package, List<ProtoBuf.Property>> n;

    /* loaded from: classes3.dex */
    public static final class JvmFieldSignature extends GeneratedMessageLite implements h.p2.b0.g.t.f.a0.a {
        public static p<JvmFieldSignature> PARSER = new a();
        private static final JvmFieldSignature defaultInstance;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final d unknownFields;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<JvmFieldSignature> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public JvmFieldSignature c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new JvmFieldSignature(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.b<JvmFieldSignature, b> implements h.p2.b0.g.t.f.a0.a {
            private int b;

            /* renamed from: c  reason: collision with root package name */
            private int f16715c;

            /* renamed from: d  reason: collision with root package name */
            private int f16716d;

            private b() {
                q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b o() {
                return new b();
            }

            private void q() {
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                return true;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: l */
            public JvmFieldSignature build() {
                JvmFieldSignature m2 = m();
                if (m2.isInitialized()) {
                    return m2;
                }
                throw a.AbstractC0459a.c(m2);
            }

            public JvmFieldSignature m() {
                JvmFieldSignature jvmFieldSignature = new JvmFieldSignature(this);
                int i2 = this.b;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                jvmFieldSignature.name_ = this.f16715c;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                jvmFieldSignature.desc_ = this.f16716d;
                jvmFieldSignature.bitField0_ = i3;
                return jvmFieldSignature;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: n */
            public b e() {
                return o().h(m());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: p */
            public JvmFieldSignature getDefaultInstanceForType() {
                return JvmFieldSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: r */
            public b h(JvmFieldSignature jvmFieldSignature) {
                if (jvmFieldSignature == JvmFieldSignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmFieldSignature.hasName()) {
                    u(jvmFieldSignature.getName());
                }
                if (jvmFieldSignature.hasDesc()) {
                    t(jvmFieldSignature.getDesc());
                }
                j(g().b(jvmFieldSignature.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: s */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    h.p2.b0.g.t.i.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature$b");
            }

            public b t(int i2) {
                this.b |= 2;
                this.f16716d = i2;
                return this;
            }

            public b u(int i2) {
                this.b |= 1;
                this.f16715c = i2;
                return this;
            }
        }

        static {
            JvmFieldSignature jvmFieldSignature = new JvmFieldSignature(true);
            defaultInstance = jvmFieldSignature;
            jvmFieldSignature.initFields();
        }

        public static JvmFieldSignature getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        public static b newBuilder() {
            return b.o();
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<JvmFieldSignature> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.o(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                o += CodedOutputStream.o(2, this.desc_);
            }
            int size = o + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // h.p2.b0.g.t.i.o
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(2, this.desc_);
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(JvmFieldSignature jvmFieldSignature) {
            return newBuilder().h(jvmFieldSignature);
        }

        @Override // h.p2.b0.g.t.i.o
        public JvmFieldSignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // h.p2.b0.g.t.i.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // h.p2.b0.g.t.i.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private JvmFieldSignature(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.g();
        }

        private JvmFieldSignature(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        private JvmFieldSignature(e eVar, f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t = d.t();
            CodedOutputStream J = CodedOutputStream.J(t, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = eVar.s();
                            } else if (K != 16) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = eVar.s();
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = t.l();
                        throw th2;
                    }
                    this.unknownFields = t.l();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = t.l();
                throw th3;
            }
            this.unknownFields = t.l();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes3.dex */
    public static final class JvmMethodSignature extends GeneratedMessageLite implements h.p2.b0.g.t.f.a0.b {
        public static p<JvmMethodSignature> PARSER = new a();
        private static final JvmMethodSignature defaultInstance;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final d unknownFields;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<JvmMethodSignature> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public JvmMethodSignature c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new JvmMethodSignature(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.b<JvmMethodSignature, b> implements h.p2.b0.g.t.f.a0.b {
            private int b;

            /* renamed from: c  reason: collision with root package name */
            private int f16717c;

            /* renamed from: d  reason: collision with root package name */
            private int f16718d;

            private b() {
                q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b o() {
                return new b();
            }

            private void q() {
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                return true;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: l */
            public JvmMethodSignature build() {
                JvmMethodSignature m2 = m();
                if (m2.isInitialized()) {
                    return m2;
                }
                throw a.AbstractC0459a.c(m2);
            }

            public JvmMethodSignature m() {
                JvmMethodSignature jvmMethodSignature = new JvmMethodSignature(this);
                int i2 = this.b;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                jvmMethodSignature.name_ = this.f16717c;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                jvmMethodSignature.desc_ = this.f16718d;
                jvmMethodSignature.bitField0_ = i3;
                return jvmMethodSignature;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: n */
            public b e() {
                return o().h(m());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: p */
            public JvmMethodSignature getDefaultInstanceForType() {
                return JvmMethodSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: r */
            public b h(JvmMethodSignature jvmMethodSignature) {
                if (jvmMethodSignature == JvmMethodSignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmMethodSignature.hasName()) {
                    u(jvmMethodSignature.getName());
                }
                if (jvmMethodSignature.hasDesc()) {
                    t(jvmMethodSignature.getDesc());
                }
                j(g().b(jvmMethodSignature.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: s */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    h.p2.b0.g.t.i.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$b");
            }

            public b t(int i2) {
                this.b |= 2;
                this.f16718d = i2;
                return this;
            }

            public b u(int i2) {
                this.b |= 1;
                this.f16717c = i2;
                return this;
            }
        }

        static {
            JvmMethodSignature jvmMethodSignature = new JvmMethodSignature(true);
            defaultInstance = jvmMethodSignature;
            jvmMethodSignature.initFields();
        }

        public static JvmMethodSignature getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        public static b newBuilder() {
            return b.o();
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<JvmMethodSignature> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.o(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                o += CodedOutputStream.o(2, this.desc_);
            }
            int size = o + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // h.p2.b0.g.t.i.o
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(2, this.desc_);
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(JvmMethodSignature jvmMethodSignature) {
            return newBuilder().h(jvmMethodSignature);
        }

        @Override // h.p2.b0.g.t.i.o
        public JvmMethodSignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // h.p2.b0.g.t.i.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // h.p2.b0.g.t.i.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private JvmMethodSignature(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.g();
        }

        private JvmMethodSignature(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        private JvmMethodSignature(e eVar, f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t = d.t();
            CodedOutputStream J = CodedOutputStream.J(t, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = eVar.s();
                            } else if (K != 16) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = eVar.s();
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = t.l();
                        throw th2;
                    }
                    this.unknownFields = t.l();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = t.l();
                throw th3;
            }
            this.unknownFields = t.l();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes3.dex */
    public static final class JvmPropertySignature extends GeneratedMessageLite implements c {
        public static p<JvmPropertySignature> PARSER = new a();
        private static final JvmPropertySignature defaultInstance;
        private int bitField0_;
        private JvmFieldSignature field_;
        private JvmMethodSignature getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private JvmMethodSignature setter_;
        private JvmMethodSignature syntheticMethod_;
        private final d unknownFields;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<JvmPropertySignature> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public JvmPropertySignature c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new JvmPropertySignature(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.b<JvmPropertySignature, b> implements c {
            private int b;

            /* renamed from: c  reason: collision with root package name */
            private JvmFieldSignature f16719c = JvmFieldSignature.getDefaultInstance();

            /* renamed from: d  reason: collision with root package name */
            private JvmMethodSignature f16720d = JvmMethodSignature.getDefaultInstance();

            /* renamed from: e  reason: collision with root package name */
            private JvmMethodSignature f16721e = JvmMethodSignature.getDefaultInstance();

            /* renamed from: f  reason: collision with root package name */
            private JvmMethodSignature f16722f = JvmMethodSignature.getDefaultInstance();

            private b() {
                q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b o() {
                return new b();
            }

            private void q() {
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                return true;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: l */
            public JvmPropertySignature build() {
                JvmPropertySignature m2 = m();
                if (m2.isInitialized()) {
                    return m2;
                }
                throw a.AbstractC0459a.c(m2);
            }

            public JvmPropertySignature m() {
                JvmPropertySignature jvmPropertySignature = new JvmPropertySignature(this);
                int i2 = this.b;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                jvmPropertySignature.field_ = this.f16719c;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                jvmPropertySignature.syntheticMethod_ = this.f16720d;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                jvmPropertySignature.getter_ = this.f16721e;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                jvmPropertySignature.setter_ = this.f16722f;
                jvmPropertySignature.bitField0_ = i3;
                return jvmPropertySignature;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: n */
            public b e() {
                return o().h(m());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: p */
            public JvmPropertySignature getDefaultInstanceForType() {
                return JvmPropertySignature.getDefaultInstance();
            }

            public b r(JvmFieldSignature jvmFieldSignature) {
                if ((this.b & 1) == 1 && this.f16719c != JvmFieldSignature.getDefaultInstance()) {
                    this.f16719c = JvmFieldSignature.newBuilder(this.f16719c).h(jvmFieldSignature).m();
                } else {
                    this.f16719c = jvmFieldSignature;
                }
                this.b |= 1;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s */
            public b h(JvmPropertySignature jvmPropertySignature) {
                if (jvmPropertySignature == JvmPropertySignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmPropertySignature.hasField()) {
                    r(jvmPropertySignature.getField());
                }
                if (jvmPropertySignature.hasSyntheticMethod()) {
                    w(jvmPropertySignature.getSyntheticMethod());
                }
                if (jvmPropertySignature.hasGetter()) {
                    u(jvmPropertySignature.getGetter());
                }
                if (jvmPropertySignature.hasSetter()) {
                    v(jvmPropertySignature.getSetter());
                }
                j(g().b(jvmPropertySignature.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: t */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    h.p2.b0.g.t.i.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature$b");
            }

            public b u(JvmMethodSignature jvmMethodSignature) {
                if ((this.b & 4) == 4 && this.f16721e != JvmMethodSignature.getDefaultInstance()) {
                    this.f16721e = JvmMethodSignature.newBuilder(this.f16721e).h(jvmMethodSignature).m();
                } else {
                    this.f16721e = jvmMethodSignature;
                }
                this.b |= 4;
                return this;
            }

            public b v(JvmMethodSignature jvmMethodSignature) {
                if ((this.b & 8) == 8 && this.f16722f != JvmMethodSignature.getDefaultInstance()) {
                    this.f16722f = JvmMethodSignature.newBuilder(this.f16722f).h(jvmMethodSignature).m();
                } else {
                    this.f16722f = jvmMethodSignature;
                }
                this.b |= 8;
                return this;
            }

            public b w(JvmMethodSignature jvmMethodSignature) {
                if ((this.b & 2) == 2 && this.f16720d != JvmMethodSignature.getDefaultInstance()) {
                    this.f16720d = JvmMethodSignature.newBuilder(this.f16720d).h(jvmMethodSignature).m();
                } else {
                    this.f16720d = jvmMethodSignature;
                }
                this.b |= 2;
                return this;
            }
        }

        static {
            JvmPropertySignature jvmPropertySignature = new JvmPropertySignature(true);
            defaultInstance = jvmPropertySignature;
            jvmPropertySignature.initFields();
        }

        public static JvmPropertySignature getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.field_ = JvmFieldSignature.getDefaultInstance();
            this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
            this.getter_ = JvmMethodSignature.getDefaultInstance();
            this.setter_ = JvmMethodSignature.getDefaultInstance();
        }

        public static b newBuilder() {
            return b.o();
        }

        public JvmFieldSignature getField() {
            return this.field_;
        }

        public JvmMethodSignature getGetter() {
            return this.getter_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<JvmPropertySignature> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int s = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.s(1, this.field_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                s += CodedOutputStream.s(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                s += CodedOutputStream.s(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                s += CodedOutputStream.s(4, this.setter_);
            }
            int size = s + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public JvmMethodSignature getSetter() {
            return this.setter_;
        }

        public JvmMethodSignature getSyntheticMethod() {
            return this.syntheticMethod_;
        }

        public boolean hasField() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasGetter() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasSetter() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasSyntheticMethod() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // h.p2.b0.g.t.i.o
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.d0(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.d0(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.d0(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.d0(4, this.setter_);
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(JvmPropertySignature jvmPropertySignature) {
            return newBuilder().h(jvmPropertySignature);
        }

        @Override // h.p2.b0.g.t.i.o
        public JvmPropertySignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // h.p2.b0.g.t.i.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // h.p2.b0.g.t.i.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private JvmPropertySignature(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.g();
        }

        private JvmPropertySignature(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        private JvmPropertySignature(e eVar, f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t = d.t();
            CodedOutputStream J = CodedOutputStream.J(t, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 10) {
                                JvmFieldSignature.b builder = (this.bitField0_ & 1) == 1 ? this.field_.toBuilder() : null;
                                JvmFieldSignature jvmFieldSignature = (JvmFieldSignature) eVar.u(JvmFieldSignature.PARSER, fVar);
                                this.field_ = jvmFieldSignature;
                                if (builder != null) {
                                    builder.h(jvmFieldSignature);
                                    this.field_ = builder.m();
                                }
                                this.bitField0_ |= 1;
                            } else if (K == 18) {
                                JvmMethodSignature.b builder2 = (this.bitField0_ & 2) == 2 ? this.syntheticMethod_.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature = (JvmMethodSignature) eVar.u(JvmMethodSignature.PARSER, fVar);
                                this.syntheticMethod_ = jvmMethodSignature;
                                if (builder2 != null) {
                                    builder2.h(jvmMethodSignature);
                                    this.syntheticMethod_ = builder2.m();
                                }
                                this.bitField0_ |= 2;
                            } else if (K == 26) {
                                JvmMethodSignature.b builder3 = (this.bitField0_ & 4) == 4 ? this.getter_.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature2 = (JvmMethodSignature) eVar.u(JvmMethodSignature.PARSER, fVar);
                                this.getter_ = jvmMethodSignature2;
                                if (builder3 != null) {
                                    builder3.h(jvmMethodSignature2);
                                    this.getter_ = builder3.m();
                                }
                                this.bitField0_ |= 4;
                            } else if (K != 34) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                JvmMethodSignature.b builder4 = (this.bitField0_ & 8) == 8 ? this.setter_.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature3 = (JvmMethodSignature) eVar.u(JvmMethodSignature.PARSER, fVar);
                                this.setter_ = jvmMethodSignature3;
                                if (builder4 != null) {
                                    builder4.h(jvmMethodSignature3);
                                    this.setter_ = builder4.m();
                                }
                                this.bitField0_ |= 8;
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = t.l();
                        throw th2;
                    }
                    this.unknownFields = t.l();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = t.l();
                throw th3;
            }
            this.unknownFields = t.l();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: classes3.dex */
    public static final class StringTableTypes extends GeneratedMessageLite implements h.p2.b0.g.t.f.a0.e {
        public static p<StringTableTypes> PARSER = new a();
        private static final StringTableTypes defaultInstance;
        private int localNameMemoizedSerializedSize;
        private List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Record> record_;
        private final d unknownFields;

        /* loaded from: classes3.dex */
        public static final class Record extends GeneratedMessageLite implements h.p2.b0.g.t.f.a0.d {
            public static p<Record> PARSER = new a();
            private static final Record defaultInstance;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Operation operation_;
            private int predefinedIndex_;
            private int range_;
            private int replaceCharMemoizedSerializedSize;
            private List<Integer> replaceChar_;
            private Object string_;
            private int substringIndexMemoizedSerializedSize;
            private List<Integer> substringIndex_;
            private final d unknownFields;

            /* loaded from: classes3.dex */
            public enum Operation implements h.a {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);
                
                private static h.b<Operation> internalValueMap = new a();
                private final int value;

                /* loaded from: classes3.dex */
                public static class a implements h.b<Operation> {
                    @Override // h.p2.b0.g.t.i.h.b
                    /* renamed from: b */
                    public Operation a(int i2) {
                        return Operation.valueOf(i2);
                    }
                }

                Operation(int i2, int i3) {
                    this.value = i3;
                }

                @Override // h.p2.b0.g.t.i.h.a
                public final int getNumber() {
                    return this.value;
                }

                public static Operation valueOf(int i2) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                return null;
                            }
                            return DESC_TO_CLASS_ID;
                        }
                        return INTERNAL_TO_CLASS_ID;
                    }
                    return NONE;
                }
            }

            /* loaded from: classes3.dex */
            public static class a extends h.p2.b0.g.t.i.b<Record> {
                @Override // h.p2.b0.g.t.i.p
                /* renamed from: m */
                public Record c(e eVar, f fVar) throws InvalidProtocolBufferException {
                    return new Record(eVar, fVar);
                }
            }

            /* loaded from: classes3.dex */
            public static final class b extends GeneratedMessageLite.b<Record, b> implements h.p2.b0.g.t.f.a0.d {
                private int b;

                /* renamed from: d  reason: collision with root package name */
                private int f16724d;

                /* renamed from: c  reason: collision with root package name */
                private int f16723c = 1;

                /* renamed from: e  reason: collision with root package name */
                private Object f16725e = "";

                /* renamed from: f  reason: collision with root package name */
                private Operation f16726f = Operation.NONE;

                /* renamed from: g  reason: collision with root package name */
                private List<Integer> f16727g = Collections.emptyList();

                /* renamed from: h  reason: collision with root package name */
                private List<Integer> f16728h = Collections.emptyList();

                private b() {
                    s();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static b o() {
                    return new b();
                }

                private void p() {
                    if ((this.b & 32) != 32) {
                        this.f16728h = new ArrayList(this.f16728h);
                        this.b |= 32;
                    }
                }

                private void q() {
                    if ((this.b & 16) != 16) {
                        this.f16727g = new ArrayList(this.f16727g);
                        this.b |= 16;
                    }
                }

                private void s() {
                }

                @Override // h.p2.b0.g.t.i.o
                public final boolean isInitialized() {
                    return true;
                }

                @Override // h.p2.b0.g.t.i.n.a
                /* renamed from: l */
                public Record build() {
                    Record m2 = m();
                    if (m2.isInitialized()) {
                        return m2;
                    }
                    throw a.AbstractC0459a.c(m2);
                }

                public Record m() {
                    Record record = new Record(this);
                    int i2 = this.b;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    record.range_ = this.f16723c;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    record.predefinedIndex_ = this.f16724d;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    record.string_ = this.f16725e;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    record.operation_ = this.f16726f;
                    if ((this.b & 16) == 16) {
                        this.f16727g = Collections.unmodifiableList(this.f16727g);
                        this.b &= -17;
                    }
                    record.substringIndex_ = this.f16727g;
                    if ((this.b & 32) == 32) {
                        this.f16728h = Collections.unmodifiableList(this.f16728h);
                        this.b &= -33;
                    }
                    record.replaceChar_ = this.f16728h;
                    record.bitField0_ = i3;
                    return record;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: n */
                public b e() {
                    return o().h(m());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
                /* renamed from: r */
                public Record getDefaultInstanceForType() {
                    return Record.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: t */
                public b h(Record record) {
                    if (record == Record.getDefaultInstance()) {
                        return this;
                    }
                    if (record.hasRange()) {
                        x(record.getRange());
                    }
                    if (record.hasPredefinedIndex()) {
                        w(record.getPredefinedIndex());
                    }
                    if (record.hasString()) {
                        this.b |= 4;
                        this.f16725e = record.string_;
                    }
                    if (record.hasOperation()) {
                        v(record.getOperation());
                    }
                    if (!record.substringIndex_.isEmpty()) {
                        if (this.f16727g.isEmpty()) {
                            this.f16727g = record.substringIndex_;
                            this.b &= -17;
                        } else {
                            q();
                            this.f16727g.addAll(record.substringIndex_);
                        }
                    }
                    if (!record.replaceChar_.isEmpty()) {
                        if (this.f16728h.isEmpty()) {
                            this.f16728h = record.replaceChar_;
                            this.b &= -33;
                        } else {
                            p();
                            this.f16728h.addAll(record.replaceChar_);
                        }
                    }
                    j(g().b(record.unknownFields));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
                /* renamed from: u */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        if (r3 == 0) goto Le
                        r2.h(r3)
                    Le:
                        return r2
                    Lf:
                        r3 = move-exception
                        goto L1b
                    L11:
                        r3 = move-exception
                        h.p2.b0.g.t.i.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record) r4     // Catch: java.lang.Throwable -> Lf
                        throw r3     // Catch: java.lang.Throwable -> L19
                    L19:
                        r3 = move-exception
                        r0 = r4
                    L1b:
                        if (r0 == 0) goto L20
                        r2.h(r0)
                    L20:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record$b");
                }

                public b v(Operation operation) {
                    Objects.requireNonNull(operation);
                    this.b |= 8;
                    this.f16726f = operation;
                    return this;
                }

                public b w(int i2) {
                    this.b |= 2;
                    this.f16724d = i2;
                    return this;
                }

                public b x(int i2) {
                    this.b |= 1;
                    this.f16723c = i2;
                    return this;
                }
            }

            static {
                Record record = new Record(true);
                defaultInstance = record;
                record.initFields();
            }

            public static Record getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = Operation.NONE;
                this.substringIndex_ = Collections.emptyList();
                this.replaceChar_ = Collections.emptyList();
            }

            public static b newBuilder() {
                return b.o();
            }

            public Operation getOperation() {
                return this.operation_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
            public p<Record> getParserForType() {
                return PARSER;
            }

            public int getPredefinedIndex() {
                return this.predefinedIndex_;
            }

            public int getRange() {
                return this.range_;
            }

            public int getReplaceCharCount() {
                return this.replaceChar_.size();
            }

            public List<Integer> getReplaceCharList() {
                return this.replaceChar_;
            }

            @Override // h.p2.b0.g.t.i.n
            public int getSerializedSize() {
                int i2 = this.memoizedSerializedSize;
                if (i2 != -1) {
                    return i2;
                }
                int o = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.range_) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    o += CodedOutputStream.o(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    o += CodedOutputStream.h(3, this.operation_.getNumber());
                }
                int i3 = 0;
                for (int i4 = 0; i4 < this.substringIndex_.size(); i4++) {
                    i3 += CodedOutputStream.p(this.substringIndex_.get(i4).intValue());
                }
                int i5 = o + i3;
                if (!getSubstringIndexList().isEmpty()) {
                    i5 = i5 + 1 + CodedOutputStream.p(i3);
                }
                this.substringIndexMemoizedSerializedSize = i3;
                int i6 = 0;
                for (int i7 = 0; i7 < this.replaceChar_.size(); i7++) {
                    i6 += CodedOutputStream.p(this.replaceChar_.get(i7).intValue());
                }
                int i8 = i5 + i6;
                if (!getReplaceCharList().isEmpty()) {
                    i8 = i8 + 1 + CodedOutputStream.p(i6);
                }
                this.replaceCharMemoizedSerializedSize = i6;
                if ((this.bitField0_ & 4) == 4) {
                    i8 += CodedOutputStream.d(6, getStringBytes());
                }
                int size = i8 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public String getString() {
                Object obj = this.string_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                d dVar = (d) obj;
                String z = dVar.z();
                if (dVar.q()) {
                    this.string_ = z;
                }
                return z;
            }

            public d getStringBytes() {
                Object obj = this.string_;
                if (obj instanceof String) {
                    d g2 = d.g((String) obj);
                    this.string_ = g2;
                    return g2;
                }
                return (d) obj;
            }

            public int getSubstringIndexCount() {
                return this.substringIndex_.size();
            }

            public List<Integer> getSubstringIndexList() {
                return this.substringIndex_;
            }

            public boolean hasOperation() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean hasPredefinedIndex() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasRange() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasString() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                byte b2 = this.memoizedIsInitialized;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // h.p2.b0.g.t.i.n
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.a0(1, this.range_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.a0(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.S(3, this.operation_.getNumber());
                }
                if (getSubstringIndexList().size() > 0) {
                    codedOutputStream.o0(34);
                    codedOutputStream.o0(this.substringIndexMemoizedSerializedSize);
                }
                for (int i2 = 0; i2 < this.substringIndex_.size(); i2++) {
                    codedOutputStream.b0(this.substringIndex_.get(i2).intValue());
                }
                if (getReplaceCharList().size() > 0) {
                    codedOutputStream.o0(42);
                    codedOutputStream.o0(this.replaceCharMemoizedSerializedSize);
                }
                for (int i3 = 0; i3 < this.replaceChar_.size(); i3++) {
                    codedOutputStream.b0(this.replaceChar_.get(i3).intValue());
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.O(6, getStringBytes());
                }
                codedOutputStream.i0(this.unknownFields);
            }

            public static b newBuilder(Record record) {
                return newBuilder().h(record);
            }

            @Override // h.p2.b0.g.t.i.o
            public Record getDefaultInstanceForType() {
                return defaultInstance;
            }

            @Override // h.p2.b0.g.t.i.n
            public b newBuilderForType() {
                return newBuilder();
            }

            @Override // h.p2.b0.g.t.i.n
            public b toBuilder() {
                return newBuilder(this);
            }

            private Record(GeneratedMessageLite.b bVar) {
                super(bVar);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.g();
            }

            private Record(boolean z) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = d.a;
            }

            private Record(e eVar, f fVar) throws InvalidProtocolBufferException {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                d.b t = d.t();
                CodedOutputStream J = CodedOutputStream.J(t, 1);
                boolean z = false;
                boolean z2 = false;
                while (!z) {
                    try {
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 8) {
                                    this.bitField0_ |= 1;
                                    this.range_ = eVar.s();
                                } else if (K == 16) {
                                    this.bitField0_ |= 2;
                                    this.predefinedIndex_ = eVar.s();
                                } else if (K == 24) {
                                    int n = eVar.n();
                                    Operation valueOf = Operation.valueOf(n);
                                    if (valueOf == null) {
                                        J.o0(K);
                                        J.o0(n);
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.operation_ = valueOf;
                                    }
                                } else if (K == 32) {
                                    if (!(z2 & true)) {
                                        this.substringIndex_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.substringIndex_.add(Integer.valueOf(eVar.s()));
                                } else if (K == 34) {
                                    int j2 = eVar.j(eVar.A());
                                    if (!(z2 & true) && eVar.e() > 0) {
                                        this.substringIndex_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (eVar.e() > 0) {
                                        this.substringIndex_.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(j2);
                                } else if (K == 40) {
                                    if (!(z2 & true)) {
                                        this.replaceChar_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.replaceChar_.add(Integer.valueOf(eVar.s()));
                                } else if (K == 42) {
                                    int j3 = eVar.j(eVar.A());
                                    if (!(z2 & true) && eVar.e() > 0) {
                                        this.replaceChar_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (eVar.e() > 0) {
                                        this.replaceChar_.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(j3);
                                } else if (K != 50) {
                                    if (!parseUnknownField(eVar, J, fVar, K)) {
                                    }
                                } else {
                                    d l2 = eVar.l();
                                    this.bitField0_ |= 4;
                                    this.string_ = l2;
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        } catch (IOException e3) {
                            throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        if (z2 & true) {
                            this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                        }
                        if (z2 & true) {
                            this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                        }
                        try {
                            J.I();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.unknownFields = t.l();
                            throw th2;
                        }
                        this.unknownFields = t.l();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                if (z2 & true) {
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                }
                if (z2 & true) {
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                }
                try {
                    J.I();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.unknownFields = t.l();
                    throw th3;
                }
                this.unknownFields = t.l();
                makeExtensionsImmutable();
            }
        }

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<StringTableTypes> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public StringTableTypes c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new StringTableTypes(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.b<StringTableTypes, b> implements h.p2.b0.g.t.f.a0.e {
            private int b;

            /* renamed from: c  reason: collision with root package name */
            private List<Record> f16729c = Collections.emptyList();

            /* renamed from: d  reason: collision with root package name */
            private List<Integer> f16730d = Collections.emptyList();

            private b() {
                s();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b o() {
                return new b();
            }

            private void p() {
                if ((this.b & 2) != 2) {
                    this.f16730d = new ArrayList(this.f16730d);
                    this.b |= 2;
                }
            }

            private void q() {
                if ((this.b & 1) != 1) {
                    this.f16729c = new ArrayList(this.f16729c);
                    this.b |= 1;
                }
            }

            private void s() {
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                return true;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: l */
            public StringTableTypes build() {
                StringTableTypes m2 = m();
                if (m2.isInitialized()) {
                    return m2;
                }
                throw a.AbstractC0459a.c(m2);
            }

            public StringTableTypes m() {
                StringTableTypes stringTableTypes = new StringTableTypes(this);
                if ((this.b & 1) == 1) {
                    this.f16729c = Collections.unmodifiableList(this.f16729c);
                    this.b &= -2;
                }
                stringTableTypes.record_ = this.f16729c;
                if ((this.b & 2) == 2) {
                    this.f16730d = Collections.unmodifiableList(this.f16730d);
                    this.b &= -3;
                }
                stringTableTypes.localName_ = this.f16730d;
                return stringTableTypes;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: n */
            public b e() {
                return o().h(m());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: r */
            public StringTableTypes getDefaultInstanceForType() {
                return StringTableTypes.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: t */
            public b h(StringTableTypes stringTableTypes) {
                if (stringTableTypes == StringTableTypes.getDefaultInstance()) {
                    return this;
                }
                if (!stringTableTypes.record_.isEmpty()) {
                    if (this.f16729c.isEmpty()) {
                        this.f16729c = stringTableTypes.record_;
                        this.b &= -2;
                    } else {
                        q();
                        this.f16729c.addAll(stringTableTypes.record_);
                    }
                }
                if (!stringTableTypes.localName_.isEmpty()) {
                    if (this.f16730d.isEmpty()) {
                        this.f16730d = stringTableTypes.localName_;
                        this.b &= -3;
                    } else {
                        p();
                        this.f16730d.addAll(stringTableTypes.localName_);
                    }
                }
                j(g().b(stringTableTypes.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: u */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    h.p2.b0.g.t.i.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$b");
            }
        }

        static {
            StringTableTypes stringTableTypes = new StringTableTypes(true);
            defaultInstance = stringTableTypes;
            stringTableTypes.initFields();
        }

        public static StringTableTypes getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.o();
        }

        public static StringTableTypes parseDelimitedFrom(InputStream inputStream, f fVar) throws IOException {
            return PARSER.d(inputStream, fVar);
        }

        public List<Integer> getLocalNameList() {
            return this.localName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<StringTableTypes> getParserForType() {
            return PARSER;
        }

        public List<Record> getRecordList() {
            return this.record_;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.record_.size(); i4++) {
                i3 += CodedOutputStream.s(1, this.record_.get(i4));
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.localName_.size(); i6++) {
                i5 += CodedOutputStream.p(this.localName_.get(i6).intValue());
            }
            int i7 = i3 + i5;
            if (!getLocalNameList().isEmpty()) {
                i7 = i7 + 1 + CodedOutputStream.p(i5);
            }
            this.localNameMemoizedSerializedSize = i5;
            int size = i7 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // h.p2.b0.g.t.i.o
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i2 = 0; i2 < this.record_.size(); i2++) {
                codedOutputStream.d0(1, this.record_.get(i2));
            }
            if (getLocalNameList().size() > 0) {
                codedOutputStream.o0(42);
                codedOutputStream.o0(this.localNameMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.localName_.size(); i3++) {
                codedOutputStream.b0(this.localName_.get(i3).intValue());
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(StringTableTypes stringTableTypes) {
            return newBuilder().h(stringTableTypes);
        }

        @Override // h.p2.b0.g.t.i.o
        public StringTableTypes getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // h.p2.b0.g.t.i.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // h.p2.b0.g.t.i.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private StringTableTypes(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.g();
        }

        private StringTableTypes(boolean z) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private StringTableTypes(e eVar, f fVar) throws InvalidProtocolBufferException {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t = d.t();
            CodedOutputStream J = CodedOutputStream.J(t, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 10) {
                                if (!(z2 & true)) {
                                    this.record_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.record_.add(eVar.u(Record.PARSER, fVar));
                            } else if (K == 40) {
                                if (!(z2 & true)) {
                                    this.localName_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.localName_.add(Integer.valueOf(eVar.s()));
                            } else if (K != 42) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                int j2 = eVar.j(eVar.A());
                                if (!(z2 & true) && eVar.e() > 0) {
                                    this.localName_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (eVar.e() > 0) {
                                    this.localName_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j2);
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.record_ = Collections.unmodifiableList(this.record_);
                    }
                    if (z2 & true) {
                        this.localName_ = Collections.unmodifiableList(this.localName_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = t.l();
                        throw th2;
                    }
                    this.unknownFields = t.l();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.record_ = Collections.unmodifiableList(this.record_);
            }
            if (z2 & true) {
                this.localName_ = Collections.unmodifiableList(this.localName_);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = t.l();
                throw th3;
            }
            this.unknownFields = t.l();
            makeExtensionsImmutable();
        }
    }

    static {
        ProtoBuf.Constructor defaultInstance = ProtoBuf.Constructor.getDefaultInstance();
        JvmMethodSignature defaultInstance2 = JvmMethodSignature.getDefaultInstance();
        JvmMethodSignature defaultInstance3 = JvmMethodSignature.getDefaultInstance();
        WireFormat.FieldType fieldType = WireFormat.FieldType.MESSAGE;
        a = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance, defaultInstance2, defaultInstance3, null, 100, fieldType, JvmMethodSignature.class);
        b = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), null, 100, fieldType, JvmMethodSignature.class);
        ProtoBuf.Function defaultInstance4 = ProtoBuf.Function.getDefaultInstance();
        WireFormat.FieldType fieldType2 = WireFormat.FieldType.INT32;
        f16704c = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance4, 0, null, null, 101, fieldType2, Integer.class);
        f16705d = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), null, 100, fieldType, JvmPropertySignature.class);
        f16706e = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), 0, null, null, 101, fieldType2, Integer.class);
        f16707f = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, fieldType, false, ProtoBuf.Annotation.class);
        f16708g = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), Boolean.FALSE, null, null, 101, WireFormat.FieldType.BOOL, Boolean.class);
        f16709h = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, fieldType, false, ProtoBuf.Annotation.class);
        f16710i = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 101, fieldType2, Integer.class);
        f16711j = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, fieldType, false, ProtoBuf.Property.class);
        f16712k = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 103, fieldType2, Integer.class);
        f16713l = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 104, fieldType2, Integer.class);
        f16714m = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), 0, null, null, 101, fieldType2, Integer.class);
        n = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, fieldType, false, ProtoBuf.Property.class);
    }

    public static void a(f fVar) {
        fVar.a(a);
        fVar.a(b);
        fVar.a(f16704c);
        fVar.a(f16705d);
        fVar.a(f16706e);
        fVar.a(f16707f);
        fVar.a(f16708g);
        fVar.a(f16709h);
        fVar.a(f16710i);
        fVar.a(f16711j);
        fVar.a(f16712k);
        fVar.a(f16713l);
        fVar.a(f16714m);
        fVar.a(n);
    }
}

package kotlin.reflect.jvm.internal.impl.metadata;

import com.tencent.tpns.baseapi.base.util.ErrCode;
import h.p2.b0.g.t.f.c;
import h.p2.b0.g.t.f.g;
import h.p2.b0.g.t.f.i;
import h.p2.b0.g.t.f.j;
import h.p2.b0.g.t.f.k;
import h.p2.b0.g.t.f.l;
import h.p2.b0.g.t.f.m;
import h.p2.b0.g.t.f.n;
import h.p2.b0.g.t.f.o;
import h.p2.b0.g.t.f.r;
import h.p2.b0.g.t.f.s;
import h.p2.b0.g.t.f.t;
import h.p2.b0.g.t.f.u;
import h.p2.b0.g.t.f.v;
import h.p2.b0.g.t.f.w;
import h.p2.b0.g.t.f.x;
import h.p2.b0.g.t.i.a;
import h.p2.b0.g.t.i.d;
import h.p2.b0.g.t.i.e;
import h.p2.b0.g.t.i.f;
import h.p2.b0.g.t.i.h;
import h.p2.b0.g.t.i.p;
import h.p2.b0.g.t.i.q;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import org.conscrypt.NativeConstants;

/* loaded from: classes3.dex */
public final class ProtoBuf {

    /* loaded from: classes3.dex */
    public static final class Annotation extends GeneratedMessageLite implements c {
        public static p<Annotation> PARSER = new a();
        private static final Annotation defaultInstance;
        private List<Argument> argument_;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final d unknownFields;

        /* loaded from: classes3.dex */
        public static final class Argument extends GeneratedMessageLite implements h.p2.b0.g.t.f.b {
            public static p<Argument> PARSER = new a();
            private static final Argument defaultInstance;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int nameId_;
            private final d unknownFields;
            private Value value_;

            /* loaded from: classes3.dex */
            public static final class Value extends GeneratedMessageLite implements h.p2.b0.g.t.f.a {
                public static p<Value> PARSER = new a();
                private static final Value defaultInstance;
                private Annotation annotation_;
                private int arrayDimensionCount_;
                private List<Value> arrayElement_;
                private int bitField0_;
                private int classId_;
                private double doubleValue_;
                private int enumValueId_;
                private int flags_;
                private float floatValue_;
                private long intValue_;
                private byte memoizedIsInitialized;
                private int memoizedSerializedSize;
                private int stringValue_;
                private Type type_;
                private final d unknownFields;

                /* loaded from: classes3.dex */
                public enum Type implements h.a {
                    BYTE(0, 0),
                    CHAR(1, 1),
                    SHORT(2, 2),
                    INT(3, 3),
                    LONG(4, 4),
                    FLOAT(5, 5),
                    DOUBLE(6, 6),
                    BOOLEAN(7, 7),
                    STRING(8, 8),
                    CLASS(9, 9),
                    ENUM(10, 10),
                    ANNOTATION(11, 11),
                    ARRAY(12, 12);
                    
                    private static h.b<Type> internalValueMap = new a();
                    private final int value;

                    /* loaded from: classes3.dex */
                    public static class a implements h.b<Type> {
                        @Override // h.p2.b0.g.t.i.h.b
                        /* renamed from: b */
                        public Type a(int i2) {
                            return Type.valueOf(i2);
                        }
                    }

                    Type(int i2, int i3) {
                        this.value = i3;
                    }

                    @Override // h.p2.b0.g.t.i.h.a
                    public final int getNumber() {
                        return this.value;
                    }

                    public static Type valueOf(int i2) {
                        switch (i2) {
                            case 0:
                                return BYTE;
                            case 1:
                                return CHAR;
                            case 2:
                                return SHORT;
                            case 3:
                                return INT;
                            case 4:
                                return LONG;
                            case 5:
                                return FLOAT;
                            case 6:
                                return DOUBLE;
                            case 7:
                                return BOOLEAN;
                            case 8:
                                return STRING;
                            case 9:
                                return CLASS;
                            case 10:
                                return ENUM;
                            case 11:
                                return ANNOTATION;
                            case 12:
                                return ARRAY;
                            default:
                                return null;
                        }
                    }
                }

                /* loaded from: classes3.dex */
                public static class a extends h.p2.b0.g.t.i.b<Value> {
                    @Override // h.p2.b0.g.t.i.p
                    /* renamed from: m */
                    public Value c(e eVar, f fVar) throws InvalidProtocolBufferException {
                        return new Value(eVar, fVar);
                    }
                }

                /* loaded from: classes3.dex */
                public static final class b extends GeneratedMessageLite.b<Value, b> implements h.p2.b0.g.t.f.a {
                    private int b;

                    /* renamed from: d */
                    private long f16580d;

                    /* renamed from: e */
                    private float f16581e;

                    /* renamed from: f */
                    private double f16582f;

                    /* renamed from: g */
                    private int f16583g;

                    /* renamed from: h */
                    private int f16584h;

                    /* renamed from: i */
                    private int f16585i;

                    /* renamed from: l */
                    private int f16588l;

                    /* renamed from: m */
                    private int f16589m;

                    /* renamed from: c */
                    private Type f16579c = Type.BYTE;

                    /* renamed from: j */
                    private Annotation f16586j = Annotation.getDefaultInstance();

                    /* renamed from: k */
                    private List<Value> f16587k = Collections.emptyList();

                    private b() {
                        v();
                    }

                    public static b o() {
                        return new b();
                    }

                    private void p() {
                        if ((this.b & 256) != 256) {
                            this.f16587k = new ArrayList(this.f16587k);
                            this.b |= 256;
                        }
                    }

                    private void v() {
                    }

                    public b A(int i2) {
                        this.b |= 32;
                        this.f16584h = i2;
                        return this;
                    }

                    public b B(double d2) {
                        this.b |= 8;
                        this.f16582f = d2;
                        return this;
                    }

                    public b C(int i2) {
                        this.b |= 64;
                        this.f16585i = i2;
                        return this;
                    }

                    public b D(int i2) {
                        this.b |= 1024;
                        this.f16589m = i2;
                        return this;
                    }

                    public b E(float f2) {
                        this.b |= 4;
                        this.f16581e = f2;
                        return this;
                    }

                    public b F(long j2) {
                        this.b |= 2;
                        this.f16580d = j2;
                        return this;
                    }

                    public b G(int i2) {
                        this.b |= 16;
                        this.f16583g = i2;
                        return this;
                    }

                    public b H(Type type) {
                        Objects.requireNonNull(type);
                        this.b |= 1;
                        this.f16579c = type;
                        return this;
                    }

                    @Override // h.p2.b0.g.t.i.o
                    public final boolean isInitialized() {
                        if (!u() || q().isInitialized()) {
                            for (int i2 = 0; i2 < s(); i2++) {
                                if (!r(i2).isInitialized()) {
                                    return false;
                                }
                            }
                            return true;
                        }
                        return false;
                    }

                    @Override // h.p2.b0.g.t.i.n.a
                    /* renamed from: l */
                    public Value build() {
                        Value m2 = m();
                        if (m2.isInitialized()) {
                            return m2;
                        }
                        throw a.AbstractC0459a.c(m2);
                    }

                    public Value m() {
                        Value value = new Value(this);
                        int i2 = this.b;
                        int i3 = (i2 & 1) != 1 ? 0 : 1;
                        value.type_ = this.f16579c;
                        if ((i2 & 2) == 2) {
                            i3 |= 2;
                        }
                        value.intValue_ = this.f16580d;
                        if ((i2 & 4) == 4) {
                            i3 |= 4;
                        }
                        value.floatValue_ = this.f16581e;
                        if ((i2 & 8) == 8) {
                            i3 |= 8;
                        }
                        value.doubleValue_ = this.f16582f;
                        if ((i2 & 16) == 16) {
                            i3 |= 16;
                        }
                        value.stringValue_ = this.f16583g;
                        if ((i2 & 32) == 32) {
                            i3 |= 32;
                        }
                        value.classId_ = this.f16584h;
                        if ((i2 & 64) == 64) {
                            i3 |= 64;
                        }
                        value.enumValueId_ = this.f16585i;
                        if ((i2 & 128) == 128) {
                            i3 |= 128;
                        }
                        value.annotation_ = this.f16586j;
                        if ((this.b & 256) == 256) {
                            this.f16587k = Collections.unmodifiableList(this.f16587k);
                            this.b &= -257;
                        }
                        value.arrayElement_ = this.f16587k;
                        if ((i2 & 512) == 512) {
                            i3 |= 256;
                        }
                        value.arrayDimensionCount_ = this.f16588l;
                        if ((i2 & 1024) == 1024) {
                            i3 |= 512;
                        }
                        value.flags_ = this.f16589m;
                        value.bitField0_ = i3;
                        return value;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                    /* renamed from: n */
                    public b e() {
                        return o().h(m());
                    }

                    public Annotation q() {
                        return this.f16586j;
                    }

                    public Value r(int i2) {
                        return this.f16587k.get(i2);
                    }

                    public int s() {
                        return this.f16587k.size();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
                    /* renamed from: t */
                    public Value getDefaultInstanceForType() {
                        return Value.getDefaultInstance();
                    }

                    public boolean u() {
                        return (this.b & 128) == 128;
                    }

                    public b w(Annotation annotation) {
                        if ((this.b & 128) == 128 && this.f16586j != Annotation.getDefaultInstance()) {
                            this.f16586j = Annotation.newBuilder(this.f16586j).h(annotation).m();
                        } else {
                            this.f16586j = annotation;
                        }
                        this.b |= 128;
                        return this;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                    /* renamed from: x */
                    public b h(Value value) {
                        if (value == Value.getDefaultInstance()) {
                            return this;
                        }
                        if (value.hasType()) {
                            H(value.getType());
                        }
                        if (value.hasIntValue()) {
                            F(value.getIntValue());
                        }
                        if (value.hasFloatValue()) {
                            E(value.getFloatValue());
                        }
                        if (value.hasDoubleValue()) {
                            B(value.getDoubleValue());
                        }
                        if (value.hasStringValue()) {
                            G(value.getStringValue());
                        }
                        if (value.hasClassId()) {
                            A(value.getClassId());
                        }
                        if (value.hasEnumValueId()) {
                            C(value.getEnumValueId());
                        }
                        if (value.hasAnnotation()) {
                            w(value.getAnnotation());
                        }
                        if (!value.arrayElement_.isEmpty()) {
                            if (this.f16587k.isEmpty()) {
                                this.f16587k = value.arrayElement_;
                                this.b &= -257;
                            } else {
                                p();
                                this.f16587k.addAll(value.arrayElement_);
                            }
                        }
                        if (value.hasArrayDimensionCount()) {
                            z(value.getArrayDimensionCount());
                        }
                        if (value.hasFlags()) {
                            D(value.getFlags());
                        }
                        j(g().b(value.unknownFields));
                        return this;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
                    @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
                    /* renamed from: y */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                        /*
                            r2 = this;
                            r0 = 0
                            h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                            java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value) r4     // Catch: java.lang.Throwable -> Lf
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
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value$b");
                    }

                    public b z(int i2) {
                        this.b |= 512;
                        this.f16588l = i2;
                        return this;
                    }
                }

                static {
                    Value value = new Value(true);
                    defaultInstance = value;
                    value.initFields();
                }

                public static Value getDefaultInstance() {
                    return defaultInstance;
                }

                private void initFields() {
                    this.type_ = Type.BYTE;
                    this.intValue_ = 0L;
                    this.floatValue_ = 0.0f;
                    this.doubleValue_ = 0.0d;
                    this.stringValue_ = 0;
                    this.classId_ = 0;
                    this.enumValueId_ = 0;
                    this.annotation_ = Annotation.getDefaultInstance();
                    this.arrayElement_ = Collections.emptyList();
                    this.arrayDimensionCount_ = 0;
                    this.flags_ = 0;
                }

                public static b newBuilder() {
                    return b.o();
                }

                public Annotation getAnnotation() {
                    return this.annotation_;
                }

                public int getArrayDimensionCount() {
                    return this.arrayDimensionCount_;
                }

                public Value getArrayElement(int i2) {
                    return this.arrayElement_.get(i2);
                }

                public int getArrayElementCount() {
                    return this.arrayElement_.size();
                }

                public List<Value> getArrayElementList() {
                    return this.arrayElement_;
                }

                public int getClassId() {
                    return this.classId_;
                }

                public double getDoubleValue() {
                    return this.doubleValue_;
                }

                public int getEnumValueId() {
                    return this.enumValueId_;
                }

                public int getFlags() {
                    return this.flags_;
                }

                public float getFloatValue() {
                    return this.floatValue_;
                }

                public long getIntValue() {
                    return this.intValue_;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
                public p<Value> getParserForType() {
                    return PARSER;
                }

                @Override // h.p2.b0.g.t.i.n
                public int getSerializedSize() {
                    int i2 = this.memoizedSerializedSize;
                    if (i2 != -1) {
                        return i2;
                    }
                    int h2 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.h(1, this.type_.getNumber()) + 0 : 0;
                    if ((this.bitField0_ & 2) == 2) {
                        h2 += CodedOutputStream.A(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        h2 += CodedOutputStream.l(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        h2 += CodedOutputStream.f(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        h2 += CodedOutputStream.o(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        h2 += CodedOutputStream.o(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        h2 += CodedOutputStream.o(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        h2 += CodedOutputStream.s(8, this.annotation_);
                    }
                    for (int i3 = 0; i3 < this.arrayElement_.size(); i3++) {
                        h2 += CodedOutputStream.s(9, this.arrayElement_.get(i3));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        h2 += CodedOutputStream.o(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        h2 += CodedOutputStream.o(11, this.arrayDimensionCount_);
                    }
                    int size = h2 + this.unknownFields.size();
                    this.memoizedSerializedSize = size;
                    return size;
                }

                public int getStringValue() {
                    return this.stringValue_;
                }

                public Type getType() {
                    return this.type_;
                }

                public boolean hasAnnotation() {
                    return (this.bitField0_ & 128) == 128;
                }

                public boolean hasArrayDimensionCount() {
                    return (this.bitField0_ & 256) == 256;
                }

                public boolean hasClassId() {
                    return (this.bitField0_ & 32) == 32;
                }

                public boolean hasDoubleValue() {
                    return (this.bitField0_ & 8) == 8;
                }

                public boolean hasEnumValueId() {
                    return (this.bitField0_ & 64) == 64;
                }

                public boolean hasFlags() {
                    return (this.bitField0_ & 512) == 512;
                }

                public boolean hasFloatValue() {
                    return (this.bitField0_ & 4) == 4;
                }

                public boolean hasIntValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                public boolean hasStringValue() {
                    return (this.bitField0_ & 16) == 16;
                }

                public boolean hasType() {
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
                    if (hasAnnotation() && !getAnnotation().isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                    for (int i2 = 0; i2 < getArrayElementCount(); i2++) {
                        if (!getArrayElement(i2).isInitialized()) {
                            this.memoizedIsInitialized = (byte) 0;
                            return false;
                        }
                    }
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }

                @Override // h.p2.b0.g.t.i.n
                public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                    getSerializedSize();
                    if ((this.bitField0_ & 1) == 1) {
                        codedOutputStream.S(1, this.type_.getNumber());
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        codedOutputStream.t0(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        codedOutputStream.W(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        codedOutputStream.Q(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        codedOutputStream.a0(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        codedOutputStream.a0(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        codedOutputStream.a0(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        codedOutputStream.d0(8, this.annotation_);
                    }
                    for (int i2 = 0; i2 < this.arrayElement_.size(); i2++) {
                        codedOutputStream.d0(9, this.arrayElement_.get(i2));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        codedOutputStream.a0(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        codedOutputStream.a0(11, this.arrayDimensionCount_);
                    }
                    codedOutputStream.i0(this.unknownFields);
                }

                public static b newBuilder(Value value) {
                    return newBuilder().h(value);
                }

                @Override // h.p2.b0.g.t.i.o
                public Value getDefaultInstanceForType() {
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

                private Value(GeneratedMessageLite.b bVar) {
                    super(bVar);
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = bVar.g();
                }

                private Value(boolean z) {
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = d.a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r5v0 */
                /* JADX WARN: Type inference failed for: r5v1 */
                /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
                private Value(e eVar, f fVar) throws InvalidProtocolBufferException {
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    initFields();
                    d.b t = d.t();
                    CodedOutputStream J = CodedOutputStream.J(t, 1);
                    boolean z = false;
                    boolean z2 = false;
                    while (true) {
                        ?? r5 = 256;
                        if (!z) {
                            try {
                                try {
                                    int K = eVar.K();
                                    switch (K) {
                                        case 0:
                                            break;
                                        case 8:
                                            int n = eVar.n();
                                            Type valueOf = Type.valueOf(n);
                                            if (valueOf == null) {
                                                J.o0(K);
                                                J.o0(n);
                                            } else {
                                                this.bitField0_ |= 1;
                                                this.type_ = valueOf;
                                                continue;
                                            }
                                        case 16:
                                            this.bitField0_ |= 2;
                                            this.intValue_ = eVar.H();
                                            continue;
                                        case 29:
                                            this.bitField0_ |= 4;
                                            this.floatValue_ = eVar.q();
                                            continue;
                                        case 33:
                                            this.bitField0_ |= 8;
                                            this.doubleValue_ = eVar.m();
                                            continue;
                                        case 40:
                                            this.bitField0_ |= 16;
                                            this.stringValue_ = eVar.s();
                                            continue;
                                        case 48:
                                            this.bitField0_ |= 32;
                                            this.classId_ = eVar.s();
                                            continue;
                                        case 56:
                                            this.bitField0_ |= 64;
                                            this.enumValueId_ = eVar.s();
                                            continue;
                                        case 66:
                                            b builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                                            Annotation annotation = (Annotation) eVar.u(Annotation.PARSER, fVar);
                                            this.annotation_ = annotation;
                                            if (builder != null) {
                                                builder.h(annotation);
                                                this.annotation_ = builder.m();
                                            }
                                            this.bitField0_ |= 128;
                                            continue;
                                        case 74:
                                            if (!(z2 & true)) {
                                                this.arrayElement_ = new ArrayList();
                                                z2 |= true;
                                            }
                                            this.arrayElement_.add(eVar.u(PARSER, fVar));
                                            continue;
                                        case 80:
                                            this.bitField0_ |= 512;
                                            this.flags_ = eVar.s();
                                            continue;
                                        case 88:
                                            this.bitField0_ |= 256;
                                            this.arrayDimensionCount_ = eVar.s();
                                            continue;
                                        default:
                                            r5 = parseUnknownField(eVar, J, fVar, K);
                                            if (r5 == 0) {
                                                break;
                                            } else {
                                                continue;
                                            }
                                    }
                                    z = true;
                                } catch (InvalidProtocolBufferException e2) {
                                    throw e2.setUnfinishedMessage(this);
                                } catch (IOException e3) {
                                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                                }
                            } catch (Throwable th) {
                                if ((z2 & true) == r5) {
                                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                        } else {
                            if (z2 & true) {
                                this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                            return;
                        }
                    }
                }
            }

            /* loaded from: classes3.dex */
            public static class a extends h.p2.b0.g.t.i.b<Argument> {
                @Override // h.p2.b0.g.t.i.p
                /* renamed from: m */
                public Argument c(e eVar, f fVar) throws InvalidProtocolBufferException {
                    return new Argument(eVar, fVar);
                }
            }

            /* loaded from: classes3.dex */
            public static final class b extends GeneratedMessageLite.b<Argument, b> implements h.p2.b0.g.t.f.b {
                private int b;

                /* renamed from: c */
                private int f16590c;

                /* renamed from: d */
                private Value f16591d = Value.getDefaultInstance();

                private b() {
                    t();
                }

                public static b o() {
                    return new b();
                }

                private void t() {
                }

                @Override // h.p2.b0.g.t.i.o
                public final boolean isInitialized() {
                    return r() && s() && q().isInitialized();
                }

                @Override // h.p2.b0.g.t.i.n.a
                /* renamed from: l */
                public Argument build() {
                    Argument m2 = m();
                    if (m2.isInitialized()) {
                        return m2;
                    }
                    throw a.AbstractC0459a.c(m2);
                }

                public Argument m() {
                    Argument argument = new Argument(this);
                    int i2 = this.b;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    argument.nameId_ = this.f16590c;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    argument.value_ = this.f16591d;
                    argument.bitField0_ = i3;
                    return argument;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: n */
                public b e() {
                    return o().h(m());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
                /* renamed from: p */
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                public Value q() {
                    return this.f16591d;
                }

                public boolean r() {
                    return (this.b & 1) == 1;
                }

                public boolean s() {
                    return (this.b & 2) == 2;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: u */
                public b h(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasNameId()) {
                        x(argument.getNameId());
                    }
                    if (argument.hasValue()) {
                        w(argument.getValue());
                    }
                    j(g().b(argument.unknownFields));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
                @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
                /* renamed from: v */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$b");
                }

                public b w(Value value) {
                    if ((this.b & 2) == 2 && this.f16591d != Value.getDefaultInstance()) {
                        this.f16591d = Value.newBuilder(this.f16591d).h(value).m();
                    } else {
                        this.f16591d = value;
                    }
                    this.b |= 2;
                    return this;
                }

                public b x(int i2) {
                    this.b |= 1;
                    this.f16590c = i2;
                    return this;
                }
            }

            static {
                Argument argument = new Argument(true);
                defaultInstance = argument;
                argument.initFields();
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.nameId_ = 0;
                this.value_ = Value.getDefaultInstance();
            }

            public static b newBuilder() {
                return b.o();
            }

            public int getNameId() {
                return this.nameId_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
            public p<Argument> getParserForType() {
                return PARSER;
            }

            @Override // h.p2.b0.g.t.i.n
            public int getSerializedSize() {
                int i2 = this.memoizedSerializedSize;
                if (i2 != -1) {
                    return i2;
                }
                int o = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.o(1, this.nameId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    o += CodedOutputStream.s(2, this.value_);
                }
                int size = o + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public Value getValue() {
                return this.value_;
            }

            public boolean hasNameId() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasValue() {
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
                if (!hasNameId()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!hasValue()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!getValue().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
            }

            @Override // h.p2.b0.g.t.i.n
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.a0(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.d0(2, this.value_);
                }
                codedOutputStream.i0(this.unknownFields);
            }

            public static b newBuilder(Argument argument) {
                return newBuilder().h(argument);
            }

            @Override // h.p2.b0.g.t.i.o
            public Argument getDefaultInstanceForType() {
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

            private Argument(GeneratedMessageLite.b bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.g();
            }

            private Argument(boolean z) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = d.a;
            }

            private Argument(e eVar, f fVar) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                d.b t = d.t();
                CodedOutputStream J = CodedOutputStream.J(t, 1);
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            try {
                                int K = eVar.K();
                                if (K != 0) {
                                    if (K == 8) {
                                        this.bitField0_ |= 1;
                                        this.nameId_ = eVar.s();
                                    } else if (K != 18) {
                                        if (!parseUnknownField(eVar, J, fVar, K)) {
                                        }
                                    } else {
                                        Value.b builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                                        Value value = (Value) eVar.u(Value.PARSER, fVar);
                                        this.value_ = value;
                                        if (builder != null) {
                                            builder.h(value);
                                            this.value_ = builder.m();
                                        }
                                        this.bitField0_ |= 2;
                                    }
                                }
                                z = true;
                            } catch (IOException e2) {
                                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                            }
                        } catch (InvalidProtocolBufferException e3) {
                            throw e3.setUnfinishedMessage(this);
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
        public static class a extends h.p2.b0.g.t.i.b<Annotation> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public Annotation c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new Annotation(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.b<Annotation, b> implements c {
            private int b;

            /* renamed from: c */
            private int f16592c;

            /* renamed from: d */
            private List<Argument> f16593d = Collections.emptyList();

            private b() {
                u();
            }

            public static b o() {
                return new b();
            }

            private void p() {
                if ((this.b & 2) != 2) {
                    this.f16593d = new ArrayList(this.f16593d);
                    this.b |= 2;
                }
            }

            private void u() {
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                if (t()) {
                    for (int i2 = 0; i2 < r(); i2++) {
                        if (!q(i2).isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: l */
            public Annotation build() {
                Annotation m2 = m();
                if (m2.isInitialized()) {
                    return m2;
                }
                throw a.AbstractC0459a.c(m2);
            }

            public Annotation m() {
                Annotation annotation = new Annotation(this);
                int i2 = (this.b & 1) != 1 ? 0 : 1;
                annotation.id_ = this.f16592c;
                if ((this.b & 2) == 2) {
                    this.f16593d = Collections.unmodifiableList(this.f16593d);
                    this.b &= -3;
                }
                annotation.argument_ = this.f16593d;
                annotation.bitField0_ = i2;
                return annotation;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: n */
            public b e() {
                return o().h(m());
            }

            public Argument q(int i2) {
                return this.f16593d.get(i2);
            }

            public int r() {
                return this.f16593d.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: s */
            public Annotation getDefaultInstanceForType() {
                return Annotation.getDefaultInstance();
            }

            public boolean t() {
                return (this.b & 1) == 1;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: v */
            public b h(Annotation annotation) {
                if (annotation == Annotation.getDefaultInstance()) {
                    return this;
                }
                if (annotation.hasId()) {
                    x(annotation.getId());
                }
                if (!annotation.argument_.isEmpty()) {
                    if (this.f16593d.isEmpty()) {
                        this.f16593d = annotation.argument_;
                        this.b &= -3;
                    } else {
                        p();
                        this.f16593d.addAll(annotation.argument_);
                    }
                }
                j(g().b(annotation.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: w */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$b");
            }

            public b x(int i2) {
                this.b |= 1;
                this.f16592c = i2;
                return this;
            }
        }

        static {
            Annotation annotation = new Annotation(true);
            defaultInstance = annotation;
            annotation.initFields();
        }

        public static Annotation getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.id_ = 0;
            this.argument_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.o();
        }

        public Argument getArgument(int i2) {
            return this.argument_.get(i2);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getId() {
            return this.id_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<Annotation> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.id_) + 0 : 0;
            for (int i3 = 0; i3 < this.argument_.size(); i3++) {
                o += CodedOutputStream.s(2, this.argument_.get(i3));
            }
            int size = o + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasId() {
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
            if (!hasId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i2 = 0; i2 < getArgumentCount(); i2++) {
                if (!getArgument(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.id_);
            }
            for (int i2 = 0; i2 < this.argument_.size(); i2++) {
                codedOutputStream.d0(2, this.argument_.get(i2));
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Annotation annotation) {
            return newBuilder().h(annotation);
        }

        @Override // h.p2.b0.g.t.i.o
        public Annotation getDefaultInstanceForType() {
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

        private Annotation(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.g();
        }

        private Annotation(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Annotation(e eVar, f fVar) throws InvalidProtocolBufferException {
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
                                this.id_ = eVar.s();
                            } else if (K != 18) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                if (!(z2 & true)) {
                                    this.argument_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.argument_.add(eVar.u(Argument.PARSER, fVar));
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
                        this.argument_ = Collections.unmodifiableList(this.argument_);
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
                this.argument_ = Collections.unmodifiableList(this.argument_);
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
    public static final class Class extends GeneratedMessageLite.ExtendableMessage<Class> implements h.p2.b0.g.t.f.d {
        public static p<Class> PARSER = new a();
        private static final Class defaultInstance;
        private int bitField0_;
        private int companionObjectName_;
        private List<Constructor> constructor_;
        private List<EnumEntry> enumEntry_;
        private int flags_;
        private int fqName_;
        private List<Function> function_;
        private int inlineClassUnderlyingPropertyName_;
        private int inlineClassUnderlyingTypeId_;
        private Type inlineClassUnderlyingType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int nestedClassNameMemoizedSerializedSize;
        private List<Integer> nestedClassName_;
        private List<Property> property_;
        private int sealedSubclassFqNameMemoizedSerializedSize;
        private List<Integer> sealedSubclassFqName_;
        private int supertypeIdMemoizedSerializedSize;
        private List<Integer> supertypeId_;
        private List<Type> supertype_;
        private List<TypeAlias> typeAlias_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final d unknownFields;
        private VersionRequirementTable versionRequirementTable_;
        private List<Integer> versionRequirement_;

        /* loaded from: classes3.dex */
        public enum Kind implements h.a {
            CLASS(0, 0),
            INTERFACE(1, 1),
            ENUM_CLASS(2, 2),
            ENUM_ENTRY(3, 3),
            ANNOTATION_CLASS(4, 4),
            OBJECT(5, 5),
            COMPANION_OBJECT(6, 6);
            
            private static h.b<Kind> internalValueMap = new a();
            private final int value;

            /* loaded from: classes3.dex */
            public static class a implements h.b<Kind> {
                @Override // h.p2.b0.g.t.i.h.b
                /* renamed from: b */
                public Kind a(int i2) {
                    return Kind.valueOf(i2);
                }
            }

            Kind(int i2, int i3) {
                this.value = i3;
            }

            @Override // h.p2.b0.g.t.i.h.a
            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int i2) {
                switch (i2) {
                    case 0:
                        return CLASS;
                    case 1:
                        return INTERFACE;
                    case 2:
                        return ENUM_CLASS;
                    case 3:
                        return ENUM_ENTRY;
                    case 4:
                        return ANNOTATION_CLASS;
                    case 5:
                        return OBJECT;
                    case 6:
                        return COMPANION_OBJECT;
                    default:
                        return null;
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<Class> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public Class c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new Class(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.c<Class, b> implements h.p2.b0.g.t.f.d {

            /* renamed from: d */
            private int f16594d;

            /* renamed from: f */
            private int f16596f;

            /* renamed from: g */
            private int f16597g;
            private int r;
            private int t;

            /* renamed from: e */
            private int f16595e = 6;

            /* renamed from: h */
            private List<TypeParameter> f16598h = Collections.emptyList();

            /* renamed from: i */
            private List<Type> f16599i = Collections.emptyList();

            /* renamed from: j */
            private List<Integer> f16600j = Collections.emptyList();

            /* renamed from: k */
            private List<Integer> f16601k = Collections.emptyList();

            /* renamed from: l */
            private List<Constructor> f16602l = Collections.emptyList();

            /* renamed from: m */
            private List<Function> f16603m = Collections.emptyList();
            private List<Property> n = Collections.emptyList();
            private List<TypeAlias> o = Collections.emptyList();
            private List<EnumEntry> p = Collections.emptyList();
            private List<Integer> q = Collections.emptyList();
            private Type s = Type.getDefaultInstance();
            private TypeTable u = TypeTable.getDefaultInstance();
            private List<Integer> v = Collections.emptyList();
            private VersionRequirementTable w = VersionRequirementTable.getDefaultInstance();

            private b() {
                a0();
            }

            private void A() {
                if ((this.f16594d & 4096) != 4096) {
                    this.q = new ArrayList(this.q);
                    this.f16594d |= 4096;
                }
            }

            private void B() {
                if ((this.f16594d & 32) != 32) {
                    this.f16600j = new ArrayList(this.f16600j);
                    this.f16594d |= 32;
                }
            }

            private void C() {
                if ((this.f16594d & 16) != 16) {
                    this.f16599i = new ArrayList(this.f16599i);
                    this.f16594d |= 16;
                }
            }

            private void D() {
                if ((this.f16594d & 1024) != 1024) {
                    this.o = new ArrayList(this.o);
                    this.f16594d |= 1024;
                }
            }

            private void E() {
                if ((this.f16594d & 8) != 8) {
                    this.f16598h = new ArrayList(this.f16598h);
                    this.f16594d |= 8;
                }
            }

            private void F() {
                if ((this.f16594d & 131072) != 131072) {
                    this.v = new ArrayList(this.v);
                    this.f16594d |= 131072;
                }
            }

            private void a0() {
            }

            public static b u() {
                return new b();
            }

            private void v() {
                if ((this.f16594d & 128) != 128) {
                    this.f16602l = new ArrayList(this.f16602l);
                    this.f16594d |= 128;
                }
            }

            private void w() {
                if ((this.f16594d & 2048) != 2048) {
                    this.p = new ArrayList(this.p);
                    this.f16594d |= 2048;
                }
            }

            private void x() {
                if ((this.f16594d & 256) != 256) {
                    this.f16603m = new ArrayList(this.f16603m);
                    this.f16594d |= 256;
                }
            }

            private void y() {
                if ((this.f16594d & 64) != 64) {
                    this.f16601k = new ArrayList(this.f16601k);
                    this.f16594d |= 64;
                }
            }

            private void z() {
                if ((this.f16594d & 512) != 512) {
                    this.n = new ArrayList(this.n);
                    this.f16594d |= 512;
                }
            }

            public Constructor G(int i2) {
                return this.f16602l.get(i2);
            }

            public int H() {
                return this.f16602l.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: I */
            public Class getDefaultInstanceForType() {
                return Class.getDefaultInstance();
            }

            public EnumEntry J(int i2) {
                return this.p.get(i2);
            }

            public int K() {
                return this.p.size();
            }

            public Function L(int i2) {
                return this.f16603m.get(i2);
            }

            public int M() {
                return this.f16603m.size();
            }

            public Type N() {
                return this.s;
            }

            public Property O(int i2) {
                return this.n.get(i2);
            }

            public int P() {
                return this.n.size();
            }

            public Type Q(int i2) {
                return this.f16599i.get(i2);
            }

            public int R() {
                return this.f16599i.size();
            }

            public TypeAlias S(int i2) {
                return this.o.get(i2);
            }

            public int T() {
                return this.o.size();
            }

            public TypeParameter U(int i2) {
                return this.f16598h.get(i2);
            }

            public int V() {
                return this.f16598h.size();
            }

            public TypeTable W() {
                return this.u;
            }

            public boolean X() {
                return (this.f16594d & 2) == 2;
            }

            public boolean Y() {
                return (this.f16594d & 16384) == 16384;
            }

            public boolean Z() {
                return (this.f16594d & 65536) == 65536;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: b0 */
            public b h(Class r3) {
                if (r3 == Class.getDefaultInstance()) {
                    return this;
                }
                if (r3.hasFlags()) {
                    h0(r3.getFlags());
                }
                if (r3.hasFqName()) {
                    i0(r3.getFqName());
                }
                if (r3.hasCompanionObjectName()) {
                    g0(r3.getCompanionObjectName());
                }
                if (!r3.typeParameter_.isEmpty()) {
                    if (this.f16598h.isEmpty()) {
                        this.f16598h = r3.typeParameter_;
                        this.f16594d &= -9;
                    } else {
                        E();
                        this.f16598h.addAll(r3.typeParameter_);
                    }
                }
                if (!r3.supertype_.isEmpty()) {
                    if (this.f16599i.isEmpty()) {
                        this.f16599i = r3.supertype_;
                        this.f16594d &= -17;
                    } else {
                        C();
                        this.f16599i.addAll(r3.supertype_);
                    }
                }
                if (!r3.supertypeId_.isEmpty()) {
                    if (this.f16600j.isEmpty()) {
                        this.f16600j = r3.supertypeId_;
                        this.f16594d &= -33;
                    } else {
                        B();
                        this.f16600j.addAll(r3.supertypeId_);
                    }
                }
                if (!r3.nestedClassName_.isEmpty()) {
                    if (this.f16601k.isEmpty()) {
                        this.f16601k = r3.nestedClassName_;
                        this.f16594d &= -65;
                    } else {
                        y();
                        this.f16601k.addAll(r3.nestedClassName_);
                    }
                }
                if (!r3.constructor_.isEmpty()) {
                    if (this.f16602l.isEmpty()) {
                        this.f16602l = r3.constructor_;
                        this.f16594d &= -129;
                    } else {
                        v();
                        this.f16602l.addAll(r3.constructor_);
                    }
                }
                if (!r3.function_.isEmpty()) {
                    if (this.f16603m.isEmpty()) {
                        this.f16603m = r3.function_;
                        this.f16594d &= -257;
                    } else {
                        x();
                        this.f16603m.addAll(r3.function_);
                    }
                }
                if (!r3.property_.isEmpty()) {
                    if (this.n.isEmpty()) {
                        this.n = r3.property_;
                        this.f16594d &= ErrCode.GUID_HTTP_REQ_ERROR_CONNECT;
                    } else {
                        z();
                        this.n.addAll(r3.property_);
                    }
                }
                if (!r3.typeAlias_.isEmpty()) {
                    if (this.o.isEmpty()) {
                        this.o = r3.typeAlias_;
                        this.f16594d &= -1025;
                    } else {
                        D();
                        this.o.addAll(r3.typeAlias_);
                    }
                }
                if (!r3.enumEntry_.isEmpty()) {
                    if (this.p.isEmpty()) {
                        this.p = r3.enumEntry_;
                        this.f16594d &= -2049;
                    } else {
                        w();
                        this.p.addAll(r3.enumEntry_);
                    }
                }
                if (!r3.sealedSubclassFqName_.isEmpty()) {
                    if (this.q.isEmpty()) {
                        this.q = r3.sealedSubclassFqName_;
                        this.f16594d &= -4097;
                    } else {
                        A();
                        this.q.addAll(r3.sealedSubclassFqName_);
                    }
                }
                if (r3.hasInlineClassUnderlyingPropertyName()) {
                    j0(r3.getInlineClassUnderlyingPropertyName());
                }
                if (r3.hasInlineClassUnderlyingType()) {
                    d0(r3.getInlineClassUnderlyingType());
                }
                if (r3.hasInlineClassUnderlyingTypeId()) {
                    k0(r3.getInlineClassUnderlyingTypeId());
                }
                if (r3.hasTypeTable()) {
                    e0(r3.getTypeTable());
                }
                if (!r3.versionRequirement_.isEmpty()) {
                    if (this.v.isEmpty()) {
                        this.v = r3.versionRequirement_;
                        this.f16594d &= -131073;
                    } else {
                        F();
                        this.v.addAll(r3.versionRequirement_);
                    }
                }
                if (r3.hasVersionRequirementTable()) {
                    f0(r3.getVersionRequirementTable());
                }
                p(r3);
                j(g().b(r3.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: c0 */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$b");
            }

            public b d0(Type type) {
                if ((this.f16594d & 16384) == 16384 && this.s != Type.getDefaultInstance()) {
                    this.s = Type.newBuilder(this.s).h(type).s();
                } else {
                    this.s = type;
                }
                this.f16594d |= 16384;
                return this;
            }

            public b e0(TypeTable typeTable) {
                if ((this.f16594d & 65536) == 65536 && this.u != TypeTable.getDefaultInstance()) {
                    this.u = TypeTable.newBuilder(this.u).h(typeTable).m();
                } else {
                    this.u = typeTable;
                }
                this.f16594d |= 65536;
                return this;
            }

            public b f0(VersionRequirementTable versionRequirementTable) {
                if ((this.f16594d & 262144) == 262144 && this.w != VersionRequirementTable.getDefaultInstance()) {
                    this.w = VersionRequirementTable.newBuilder(this.w).h(versionRequirementTable).m();
                } else {
                    this.w = versionRequirementTable;
                }
                this.f16594d |= 262144;
                return this;
            }

            public b g0(int i2) {
                this.f16594d |= 4;
                this.f16597g = i2;
                return this;
            }

            public b h0(int i2) {
                this.f16594d |= 1;
                this.f16595e = i2;
                return this;
            }

            public b i0(int i2) {
                this.f16594d |= 2;
                this.f16596f = i2;
                return this;
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                if (X()) {
                    for (int i2 = 0; i2 < V(); i2++) {
                        if (!U(i2).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i3 = 0; i3 < R(); i3++) {
                        if (!Q(i3).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i4 = 0; i4 < H(); i4++) {
                        if (!G(i4).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i5 = 0; i5 < M(); i5++) {
                        if (!L(i5).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i6 = 0; i6 < P(); i6++) {
                        if (!O(i6).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i7 = 0; i7 < T(); i7++) {
                        if (!S(i7).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i8 = 0; i8 < K(); i8++) {
                        if (!J(i8).isInitialized()) {
                            return false;
                        }
                    }
                    if (!Y() || N().isInitialized()) {
                        return (!Z() || W().isInitialized()) && o();
                    }
                    return false;
                }
                return false;
            }

            public b j0(int i2) {
                this.f16594d |= 8192;
                this.r = i2;
                return this;
            }

            public b k0(int i2) {
                this.f16594d |= 32768;
                this.t = i2;
                return this;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: r */
            public Class build() {
                Class s = s();
                if (s.isInitialized()) {
                    return s;
                }
                throw a.AbstractC0459a.c(s);
            }

            public Class s() {
                Class r0 = new Class(this);
                int i2 = this.f16594d;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                r0.flags_ = this.f16595e;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                r0.fqName_ = this.f16596f;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                r0.companionObjectName_ = this.f16597g;
                if ((this.f16594d & 8) == 8) {
                    this.f16598h = Collections.unmodifiableList(this.f16598h);
                    this.f16594d &= -9;
                }
                r0.typeParameter_ = this.f16598h;
                if ((this.f16594d & 16) == 16) {
                    this.f16599i = Collections.unmodifiableList(this.f16599i);
                    this.f16594d &= -17;
                }
                r0.supertype_ = this.f16599i;
                if ((this.f16594d & 32) == 32) {
                    this.f16600j = Collections.unmodifiableList(this.f16600j);
                    this.f16594d &= -33;
                }
                r0.supertypeId_ = this.f16600j;
                if ((this.f16594d & 64) == 64) {
                    this.f16601k = Collections.unmodifiableList(this.f16601k);
                    this.f16594d &= -65;
                }
                r0.nestedClassName_ = this.f16601k;
                if ((this.f16594d & 128) == 128) {
                    this.f16602l = Collections.unmodifiableList(this.f16602l);
                    this.f16594d &= -129;
                }
                r0.constructor_ = this.f16602l;
                if ((this.f16594d & 256) == 256) {
                    this.f16603m = Collections.unmodifiableList(this.f16603m);
                    this.f16594d &= -257;
                }
                r0.function_ = this.f16603m;
                if ((this.f16594d & 512) == 512) {
                    this.n = Collections.unmodifiableList(this.n);
                    this.f16594d &= ErrCode.GUID_HTTP_REQ_ERROR_CONNECT;
                }
                r0.property_ = this.n;
                if ((this.f16594d & 1024) == 1024) {
                    this.o = Collections.unmodifiableList(this.o);
                    this.f16594d &= -1025;
                }
                r0.typeAlias_ = this.o;
                if ((this.f16594d & 2048) == 2048) {
                    this.p = Collections.unmodifiableList(this.p);
                    this.f16594d &= -2049;
                }
                r0.enumEntry_ = this.p;
                if ((this.f16594d & 4096) == 4096) {
                    this.q = Collections.unmodifiableList(this.q);
                    this.f16594d &= -4097;
                }
                r0.sealedSubclassFqName_ = this.q;
                if ((i2 & 8192) == 8192) {
                    i3 |= 8;
                }
                r0.inlineClassUnderlyingPropertyName_ = this.r;
                if ((i2 & 16384) == 16384) {
                    i3 |= 16;
                }
                r0.inlineClassUnderlyingType_ = this.s;
                if ((i2 & 32768) == 32768) {
                    i3 |= 32;
                }
                r0.inlineClassUnderlyingTypeId_ = this.t;
                if ((i2 & 65536) == 65536) {
                    i3 |= 64;
                }
                r0.typeTable_ = this.u;
                if ((this.f16594d & 131072) == 131072) {
                    this.v = Collections.unmodifiableList(this.v);
                    this.f16594d &= -131073;
                }
                r0.versionRequirement_ = this.v;
                if ((i2 & 262144) == 262144) {
                    i3 |= 128;
                }
                r0.versionRequirementTable_ = this.w;
                r0.bitField0_ = i3;
                return r0;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: t */
            public b m() {
                return u().h(s());
            }
        }

        static {
            Class r0 = new Class(true);
            defaultInstance = r0;
            r0.initFields();
        }

        public static Class getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.fqName_ = 0;
            this.companionObjectName_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.supertype_ = Collections.emptyList();
            this.supertypeId_ = Collections.emptyList();
            this.nestedClassName_ = Collections.emptyList();
            this.constructor_ = Collections.emptyList();
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.enumEntry_ = Collections.emptyList();
            this.sealedSubclassFqName_ = Collections.emptyList();
            this.inlineClassUnderlyingPropertyName_ = 0;
            this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
            this.inlineClassUnderlyingTypeId_ = 0;
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        public static b newBuilder() {
            return b.u();
        }

        public static Class parseFrom(InputStream inputStream, f fVar) throws IOException {
            return PARSER.a(inputStream, fVar);
        }

        public int getCompanionObjectName() {
            return this.companionObjectName_;
        }

        public Constructor getConstructor(int i2) {
            return this.constructor_.get(i2);
        }

        public int getConstructorCount() {
            return this.constructor_.size();
        }

        public List<Constructor> getConstructorList() {
            return this.constructor_;
        }

        public EnumEntry getEnumEntry(int i2) {
            return this.enumEntry_.get(i2);
        }

        public int getEnumEntryCount() {
            return this.enumEntry_.size();
        }

        public List<EnumEntry> getEnumEntryList() {
            return this.enumEntry_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFqName() {
            return this.fqName_;
        }

        public Function getFunction(int i2) {
            return this.function_.get(i2);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        public int getInlineClassUnderlyingPropertyName() {
            return this.inlineClassUnderlyingPropertyName_;
        }

        public Type getInlineClassUnderlyingType() {
            return this.inlineClassUnderlyingType_;
        }

        public int getInlineClassUnderlyingTypeId() {
            return this.inlineClassUnderlyingTypeId_;
        }

        public List<Integer> getNestedClassNameList() {
            return this.nestedClassName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<Class> getParserForType() {
            return PARSER;
        }

        public Property getProperty(int i2) {
            return this.property_.get(i2);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public List<Integer> getSealedSubclassFqNameList() {
            return this.sealedSubclassFqName_;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.flags_) + 0 : 0;
            int i3 = 0;
            for (int i4 = 0; i4 < this.supertypeId_.size(); i4++) {
                i3 += CodedOutputStream.p(this.supertypeId_.get(i4).intValue());
            }
            int i5 = o + i3;
            if (!getSupertypeIdList().isEmpty()) {
                i5 = i5 + 1 + CodedOutputStream.p(i3);
            }
            this.supertypeIdMemoizedSerializedSize = i3;
            if ((this.bitField0_ & 2) == 2) {
                i5 += CodedOutputStream.o(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i5 += CodedOutputStream.o(4, this.companionObjectName_);
            }
            for (int i6 = 0; i6 < this.typeParameter_.size(); i6++) {
                i5 += CodedOutputStream.s(5, this.typeParameter_.get(i6));
            }
            for (int i7 = 0; i7 < this.supertype_.size(); i7++) {
                i5 += CodedOutputStream.s(6, this.supertype_.get(i7));
            }
            int i8 = 0;
            for (int i9 = 0; i9 < this.nestedClassName_.size(); i9++) {
                i8 += CodedOutputStream.p(this.nestedClassName_.get(i9).intValue());
            }
            int i10 = i5 + i8;
            if (!getNestedClassNameList().isEmpty()) {
                i10 = i10 + 1 + CodedOutputStream.p(i8);
            }
            this.nestedClassNameMemoizedSerializedSize = i8;
            for (int i11 = 0; i11 < this.constructor_.size(); i11++) {
                i10 += CodedOutputStream.s(8, this.constructor_.get(i11));
            }
            for (int i12 = 0; i12 < this.function_.size(); i12++) {
                i10 += CodedOutputStream.s(9, this.function_.get(i12));
            }
            for (int i13 = 0; i13 < this.property_.size(); i13++) {
                i10 += CodedOutputStream.s(10, this.property_.get(i13));
            }
            for (int i14 = 0; i14 < this.typeAlias_.size(); i14++) {
                i10 += CodedOutputStream.s(11, this.typeAlias_.get(i14));
            }
            for (int i15 = 0; i15 < this.enumEntry_.size(); i15++) {
                i10 += CodedOutputStream.s(13, this.enumEntry_.get(i15));
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.sealedSubclassFqName_.size(); i17++) {
                i16 += CodedOutputStream.p(this.sealedSubclassFqName_.get(i17).intValue());
            }
            int i18 = i10 + i16;
            if (!getSealedSubclassFqNameList().isEmpty()) {
                i18 = i18 + 2 + CodedOutputStream.p(i16);
            }
            this.sealedSubclassFqNameMemoizedSerializedSize = i16;
            if ((this.bitField0_ & 8) == 8) {
                i18 += CodedOutputStream.o(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i18 += CodedOutputStream.s(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i18 += CodedOutputStream.o(19, this.inlineClassUnderlyingTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i18 += CodedOutputStream.s(30, this.typeTable_);
            }
            int i19 = 0;
            for (int i20 = 0; i20 < this.versionRequirement_.size(); i20++) {
                i19 += CodedOutputStream.p(this.versionRequirement_.get(i20).intValue());
            }
            int size = i18 + i19 + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 128) == 128) {
                size += CodedOutputStream.s(32, this.versionRequirementTable_);
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public Type getSupertype(int i2) {
            return this.supertype_.get(i2);
        }

        public int getSupertypeCount() {
            return this.supertype_.size();
        }

        public List<Integer> getSupertypeIdList() {
            return this.supertypeId_;
        }

        public List<Type> getSupertypeList() {
            return this.supertype_;
        }

        public TypeAlias getTypeAlias(int i2) {
            return this.typeAlias_.get(i2);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public TypeParameter getTypeParameter(int i2) {
            return this.typeParameter_.get(i2);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public boolean hasCompanionObjectName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasFqName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasInlineClassUnderlyingPropertyName() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasInlineClassUnderlyingType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasInlineClassUnderlyingTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasVersionRequirementTable() {
            return (this.bitField0_ & 128) == 128;
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
            if (!hasFqName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i2 = 0; i2 < getTypeParameterCount(); i2++) {
                if (!getTypeParameter(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < getSupertypeCount(); i3++) {
                if (!getSupertype(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < getConstructorCount(); i4++) {
                if (!getConstructor(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i5 = 0; i5 < getFunctionCount(); i5++) {
                if (!getFunction(i5).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i6 = 0; i6 < getPropertyCount(); i6++) {
                if (!getProperty(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i7 = 0; i7 < getTypeAliasCount(); i7++) {
                if (!getTypeAlias(i7).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i8 = 0; i8 < getEnumEntryCount(); i8++) {
                if (!getEnumEntry(i8).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasInlineClassUnderlyingType() && !getInlineClassUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.flags_);
            }
            if (getSupertypeIdList().size() > 0) {
                codedOutputStream.o0(18);
                codedOutputStream.o0(this.supertypeIdMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.supertypeId_.size(); i2++) {
                codedOutputStream.b0(this.supertypeId_.get(i2).intValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.a0(4, this.companionObjectName_);
            }
            for (int i3 = 0; i3 < this.typeParameter_.size(); i3++) {
                codedOutputStream.d0(5, this.typeParameter_.get(i3));
            }
            for (int i4 = 0; i4 < this.supertype_.size(); i4++) {
                codedOutputStream.d0(6, this.supertype_.get(i4));
            }
            if (getNestedClassNameList().size() > 0) {
                codedOutputStream.o0(58);
                codedOutputStream.o0(this.nestedClassNameMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.nestedClassName_.size(); i5++) {
                codedOutputStream.b0(this.nestedClassName_.get(i5).intValue());
            }
            for (int i6 = 0; i6 < this.constructor_.size(); i6++) {
                codedOutputStream.d0(8, this.constructor_.get(i6));
            }
            for (int i7 = 0; i7 < this.function_.size(); i7++) {
                codedOutputStream.d0(9, this.function_.get(i7));
            }
            for (int i8 = 0; i8 < this.property_.size(); i8++) {
                codedOutputStream.d0(10, this.property_.get(i8));
            }
            for (int i9 = 0; i9 < this.typeAlias_.size(); i9++) {
                codedOutputStream.d0(11, this.typeAlias_.get(i9));
            }
            for (int i10 = 0; i10 < this.enumEntry_.size(); i10++) {
                codedOutputStream.d0(13, this.enumEntry_.get(i10));
            }
            if (getSealedSubclassFqNameList().size() > 0) {
                codedOutputStream.o0(130);
                codedOutputStream.o0(this.sealedSubclassFqNameMemoizedSerializedSize);
            }
            for (int i11 = 0; i11 < this.sealedSubclassFqName_.size(); i11++) {
                codedOutputStream.b0(this.sealedSubclassFqName_.get(i11).intValue());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.a0(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.d0(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.a0(19, this.inlineClassUnderlyingTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.d0(30, this.typeTable_);
            }
            for (int i12 = 0; i12 < this.versionRequirement_.size(); i12++) {
                codedOutputStream.a0(31, this.versionRequirement_.get(i12).intValue());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.d0(32, this.versionRequirementTable_);
            }
            newExtensionWriter.a(19000, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Class r1) {
            return newBuilder().h(r1);
        }

        @Override // h.p2.b0.g.t.i.o
        public Class getDefaultInstanceForType() {
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

        private Class(GeneratedMessageLite.c<Class, ?> cVar) {
            super(cVar);
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.g();
        }

        private Class(boolean z) {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Class(e eVar, f fVar) throws InvalidProtocolBufferException {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
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
                        switch (K) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                this.bitField0_ |= 1;
                                this.flags_ = eVar.s();
                                break;
                            case 16:
                                if (!(z2 & true)) {
                                    this.supertypeId_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.supertypeId_.add(Integer.valueOf(eVar.s()));
                                break;
                            case 18:
                                int j2 = eVar.j(eVar.A());
                                if (!(z2 & true) && eVar.e() > 0) {
                                    this.supertypeId_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (eVar.e() > 0) {
                                    this.supertypeId_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j2);
                                break;
                            case 24:
                                this.bitField0_ |= 2;
                                this.fqName_ = eVar.s();
                                break;
                            case 32:
                                this.bitField0_ |= 4;
                                this.companionObjectName_ = eVar.s();
                                break;
                            case 42:
                                if (!(z2 & true)) {
                                    this.typeParameter_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.typeParameter_.add(eVar.u(TypeParameter.PARSER, fVar));
                                break;
                            case 50:
                                if (!(z2 & true)) {
                                    this.supertype_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.supertype_.add(eVar.u(Type.PARSER, fVar));
                                break;
                            case 56:
                                if (!(z2 & true)) {
                                    this.nestedClassName_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.nestedClassName_.add(Integer.valueOf(eVar.s()));
                                break;
                            case 58:
                                int j3 = eVar.j(eVar.A());
                                if (!(z2 & true) && eVar.e() > 0) {
                                    this.nestedClassName_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (eVar.e() > 0) {
                                    this.nestedClassName_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j3);
                                break;
                            case 66:
                                if (!(z2 & true)) {
                                    this.constructor_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.constructor_.add(eVar.u(Constructor.PARSER, fVar));
                                break;
                            case 74:
                                if (!(z2 & true)) {
                                    this.function_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.function_.add(eVar.u(Function.PARSER, fVar));
                                break;
                            case 82:
                                if (!(z2 & true)) {
                                    this.property_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.property_.add(eVar.u(Property.PARSER, fVar));
                                break;
                            case 90:
                                if (!(z2 & true)) {
                                    this.typeAlias_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.typeAlias_.add(eVar.u(TypeAlias.PARSER, fVar));
                                break;
                            case 106:
                                if (!(z2 & true)) {
                                    this.enumEntry_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.enumEntry_.add(eVar.u(EnumEntry.PARSER, fVar));
                                break;
                            case 128:
                                if (!(z2 & true)) {
                                    this.sealedSubclassFqName_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.sealedSubclassFqName_.add(Integer.valueOf(eVar.s()));
                                break;
                            case 130:
                                int j4 = eVar.j(eVar.A());
                                if (!(z2 & true) && eVar.e() > 0) {
                                    this.sealedSubclassFqName_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (eVar.e() > 0) {
                                    this.sealedSubclassFqName_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j4);
                                break;
                            case 136:
                                this.bitField0_ |= 8;
                                this.inlineClassUnderlyingPropertyName_ = eVar.s();
                                break;
                            case 146:
                                Type.b builder = (this.bitField0_ & 16) == 16 ? this.inlineClassUnderlyingType_.toBuilder() : null;
                                Type type = (Type) eVar.u(Type.PARSER, fVar);
                                this.inlineClassUnderlyingType_ = type;
                                if (builder != null) {
                                    builder.h(type);
                                    this.inlineClassUnderlyingType_ = builder.s();
                                }
                                this.bitField0_ |= 16;
                                break;
                            case 152:
                                this.bitField0_ |= 32;
                                this.inlineClassUnderlyingTypeId_ = eVar.s();
                                break;
                            case 242:
                                TypeTable.b builder2 = (this.bitField0_ & 64) == 64 ? this.typeTable_.toBuilder() : null;
                                TypeTable typeTable = (TypeTable) eVar.u(TypeTable.PARSER, fVar);
                                this.typeTable_ = typeTable;
                                if (builder2 != null) {
                                    builder2.h(typeTable);
                                    this.typeTable_ = builder2.m();
                                }
                                this.bitField0_ |= 64;
                                break;
                            case 248:
                                if (!(z2 & true)) {
                                    this.versionRequirement_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                break;
                            case 250:
                                int j5 = eVar.j(eVar.A());
                                if (!(z2 & true) && eVar.e() > 0) {
                                    this.versionRequirement_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (eVar.e() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j5);
                                break;
                            case 258:
                                VersionRequirementTable.b builder3 = (this.bitField0_ & 128) == 128 ? this.versionRequirementTable_.toBuilder() : null;
                                VersionRequirementTable versionRequirementTable = (VersionRequirementTable) eVar.u(VersionRequirementTable.PARSER, fVar);
                                this.versionRequirementTable_ = versionRequirementTable;
                                if (builder3 != null) {
                                    builder3.h(versionRequirementTable);
                                    this.versionRequirementTable_ = builder3.m();
                                }
                                this.bitField0_ |= 128;
                                break;
                            default:
                                if (parseUnknownField(eVar, J, fVar, K)) {
                                    break;
                                }
                                z = true;
                                break;
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                    }
                    if (z2 & true) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (z2 & true) {
                        this.supertype_ = Collections.unmodifiableList(this.supertype_);
                    }
                    if (z2 & true) {
                        this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                    }
                    if (z2 & true) {
                        this.constructor_ = Collections.unmodifiableList(this.constructor_);
                    }
                    if (z2 & true) {
                        this.function_ = Collections.unmodifiableList(this.function_);
                    }
                    if (z2 & true) {
                        this.property_ = Collections.unmodifiableList(this.property_);
                    }
                    if (z2 & true) {
                        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    }
                    if (z2 & true) {
                        this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                    }
                    if (z2 & true) {
                        this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                    }
                    if (z2 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
            }
            if (z2 & true) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
            }
            if (z2 & true) {
                this.supertype_ = Collections.unmodifiableList(this.supertype_);
            }
            if (z2 & true) {
                this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
            }
            if (z2 & true) {
                this.constructor_ = Collections.unmodifiableList(this.constructor_);
            }
            if (z2 & true) {
                this.function_ = Collections.unmodifiableList(this.function_);
            }
            if (z2 & true) {
                this.property_ = Collections.unmodifiableList(this.property_);
            }
            if (z2 & true) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
            }
            if (z2 & true) {
                this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
            }
            if (z2 & true) {
                this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
            }
            if (z2 & true) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
    public static final class Constructor extends GeneratedMessageLite.ExtendableMessage<Constructor> implements h.p2.b0.g.t.f.e {
        public static p<Constructor> PARSER = new a();
        private static final Constructor defaultInstance;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final d unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<Constructor> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public Constructor c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new Constructor(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.c<Constructor, b> implements h.p2.b0.g.t.f.e {

            /* renamed from: d */
            private int f16604d;

            /* renamed from: e */
            private int f16605e = 6;

            /* renamed from: f */
            private List<ValueParameter> f16606f = Collections.emptyList();

            /* renamed from: g */
            private List<Integer> f16607g = Collections.emptyList();

            private b() {
                A();
            }

            private void A() {
            }

            public static b u() {
                return new b();
            }

            private void v() {
                if ((this.f16604d & 2) != 2) {
                    this.f16606f = new ArrayList(this.f16606f);
                    this.f16604d |= 2;
                }
            }

            private void w() {
                if ((this.f16604d & 4) != 4) {
                    this.f16607g = new ArrayList(this.f16607g);
                    this.f16604d |= 4;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: B */
            public b h(Constructor constructor) {
                if (constructor == Constructor.getDefaultInstance()) {
                    return this;
                }
                if (constructor.hasFlags()) {
                    D(constructor.getFlags());
                }
                if (!constructor.valueParameter_.isEmpty()) {
                    if (this.f16606f.isEmpty()) {
                        this.f16606f = constructor.valueParameter_;
                        this.f16604d &= -3;
                    } else {
                        v();
                        this.f16606f.addAll(constructor.valueParameter_);
                    }
                }
                if (!constructor.versionRequirement_.isEmpty()) {
                    if (this.f16607g.isEmpty()) {
                        this.f16607g = constructor.versionRequirement_;
                        this.f16604d &= -5;
                    } else {
                        w();
                        this.f16607g.addAll(constructor.versionRequirement_);
                    }
                }
                p(constructor);
                j(g().b(constructor.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: C */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor$b");
            }

            public b D(int i2) {
                this.f16604d |= 1;
                this.f16605e = i2;
                return this;
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < z(); i2++) {
                    if (!y(i2).isInitialized()) {
                        return false;
                    }
                }
                return o();
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: r */
            public Constructor build() {
                Constructor s = s();
                if (s.isInitialized()) {
                    return s;
                }
                throw a.AbstractC0459a.c(s);
            }

            public Constructor s() {
                Constructor constructor = new Constructor(this);
                int i2 = (this.f16604d & 1) != 1 ? 0 : 1;
                constructor.flags_ = this.f16605e;
                if ((this.f16604d & 2) == 2) {
                    this.f16606f = Collections.unmodifiableList(this.f16606f);
                    this.f16604d &= -3;
                }
                constructor.valueParameter_ = this.f16606f;
                if ((this.f16604d & 4) == 4) {
                    this.f16607g = Collections.unmodifiableList(this.f16607g);
                    this.f16604d &= -5;
                }
                constructor.versionRequirement_ = this.f16607g;
                constructor.bitField0_ = i2;
                return constructor;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: t */
            public b m() {
                return u().h(s());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: x */
            public Constructor getDefaultInstanceForType() {
                return Constructor.getDefaultInstance();
            }

            public ValueParameter y(int i2) {
                return this.f16606f.get(i2);
            }

            public int z() {
                return this.f16606f.size();
            }
        }

        static {
            Constructor constructor = new Constructor(true);
            defaultInstance = constructor;
            constructor.initFields();
        }

        public static Constructor getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.valueParameter_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.u();
        }

        public int getFlags() {
            return this.flags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<Constructor> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.flags_) + 0 : 0;
            for (int i3 = 0; i3 < this.valueParameter_.size(); i3++) {
                o += CodedOutputStream.s(2, this.valueParameter_.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.versionRequirement_.size(); i5++) {
                i4 += CodedOutputStream.p(this.versionRequirement_.get(i5).intValue());
            }
            int size = o + i4 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public ValueParameter getValueParameter(int i2) {
            return this.valueParameter_.get(i2);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasFlags() {
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
            for (int i2 = 0; i2 < getValueParameterCount(); i2++) {
                if (!getValueParameter(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.flags_);
            }
            for (int i2 = 0; i2 < this.valueParameter_.size(); i2++) {
                codedOutputStream.d0(2, this.valueParameter_.get(i2));
            }
            for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
                codedOutputStream.a0(31, this.versionRequirement_.get(i3).intValue());
            }
            newExtensionWriter.a(19000, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Constructor constructor) {
            return newBuilder().h(constructor);
        }

        @Override // h.p2.b0.g.t.i.o
        public Constructor getDefaultInstanceForType() {
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

        private Constructor(GeneratedMessageLite.c<Constructor, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.g();
        }

        private Constructor(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Constructor(e eVar, f fVar) throws InvalidProtocolBufferException {
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
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 8) {
                                    this.bitField0_ |= 1;
                                    this.flags_ = eVar.s();
                                } else if (K == 18) {
                                    if (!(z2 & true)) {
                                        this.valueParameter_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.valueParameter_.add(eVar.u(ValueParameter.PARSER, fVar));
                                } else if (K == 248) {
                                    if (!(z2 & true)) {
                                        this.versionRequirement_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                } else if (K != 250) {
                                    if (!parseUnknownField(eVar, J, fVar, K)) {
                                    }
                                } else {
                                    int j2 = eVar.j(eVar.A());
                                    if (!(z2 & true) && eVar.e() > 0) {
                                        this.versionRequirement_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (eVar.e() > 0) {
                                        this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(j2);
                                }
                            }
                            z = true;
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw e3.setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if (z2 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
            }
            if (z2 & true) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
    public static final class Contract extends GeneratedMessageLite implements h.p2.b0.g.t.f.f {
        public static p<Contract> PARSER = new a();
        private static final Contract defaultInstance;
        private List<Effect> effect_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final d unknownFields;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<Contract> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public Contract c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new Contract(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.b<Contract, b> implements h.p2.b0.g.t.f.f {
            private int b;

            /* renamed from: c */
            private List<Effect> f16608c = Collections.emptyList();

            private b() {
                t();
            }

            public static b o() {
                return new b();
            }

            private void p() {
                if ((this.b & 1) != 1) {
                    this.f16608c = new ArrayList(this.f16608c);
                    this.b |= 1;
                }
            }

            private void t() {
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < s(); i2++) {
                    if (!r(i2).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: l */
            public Contract build() {
                Contract m2 = m();
                if (m2.isInitialized()) {
                    return m2;
                }
                throw a.AbstractC0459a.c(m2);
            }

            public Contract m() {
                Contract contract = new Contract(this);
                if ((this.b & 1) == 1) {
                    this.f16608c = Collections.unmodifiableList(this.f16608c);
                    this.b &= -2;
                }
                contract.effect_ = this.f16608c;
                return contract;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: n */
            public b e() {
                return o().h(m());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: q */
            public Contract getDefaultInstanceForType() {
                return Contract.getDefaultInstance();
            }

            public Effect r(int i2) {
                return this.f16608c.get(i2);
            }

            public int s() {
                return this.f16608c.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: u */
            public b h(Contract contract) {
                if (contract == Contract.getDefaultInstance()) {
                    return this;
                }
                if (!contract.effect_.isEmpty()) {
                    if (this.f16608c.isEmpty()) {
                        this.f16608c = contract.effect_;
                        this.b &= -2;
                    } else {
                        p();
                        this.f16608c.addAll(contract.effect_);
                    }
                }
                j(g().b(contract.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: v */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$b");
            }
        }

        static {
            Contract contract = new Contract(true);
            defaultInstance = contract;
            contract.initFields();
        }

        public static Contract getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.effect_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.o();
        }

        public Effect getEffect(int i2) {
            return this.effect_.get(i2);
        }

        public int getEffectCount() {
            return this.effect_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<Contract> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.effect_.size(); i4++) {
                i3 += CodedOutputStream.s(1, this.effect_.get(i4));
            }
            int size = i3 + this.unknownFields.size();
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
            for (int i2 = 0; i2 < getEffectCount(); i2++) {
                if (!getEffect(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i2 = 0; i2 < this.effect_.size(); i2++) {
                codedOutputStream.d0(1, this.effect_.get(i2));
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Contract contract) {
            return newBuilder().h(contract);
        }

        @Override // h.p2.b0.g.t.i.o
        public Contract getDefaultInstanceForType() {
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

        private Contract(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.g();
        }

        private Contract(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Contract(e eVar, f fVar) throws InvalidProtocolBufferException {
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
                            if (K != 10) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                if (!(z2 & true)) {
                                    this.effect_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.effect_.add(eVar.u(Effect.PARSER, fVar));
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
                        this.effect_ = Collections.unmodifiableList(this.effect_);
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
                this.effect_ = Collections.unmodifiableList(this.effect_);
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
    public static final class Effect extends GeneratedMessageLite implements g {
        public static p<Effect> PARSER = new a();
        private static final Effect defaultInstance;
        private int bitField0_;
        private Expression conclusionOfConditionalEffect_;
        private List<Expression> effectConstructorArgument_;
        private EffectType effectType_;
        private InvocationKind kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final d unknownFields;

        /* loaded from: classes3.dex */
        public enum EffectType implements h.a {
            RETURNS_CONSTANT(0, 0),
            CALLS(1, 1),
            RETURNS_NOT_NULL(2, 2);
            
            private static h.b<EffectType> internalValueMap = new a();
            private final int value;

            /* loaded from: classes3.dex */
            public static class a implements h.b<EffectType> {
                @Override // h.p2.b0.g.t.i.h.b
                /* renamed from: b */
                public EffectType a(int i2) {
                    return EffectType.valueOf(i2);
                }
            }

            EffectType(int i2, int i3) {
                this.value = i3;
            }

            @Override // h.p2.b0.g.t.i.h.a
            public final int getNumber() {
                return this.value;
            }

            public static EffectType valueOf(int i2) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return null;
                        }
                        return RETURNS_NOT_NULL;
                    }
                    return CALLS;
                }
                return RETURNS_CONSTANT;
            }
        }

        /* loaded from: classes3.dex */
        public enum InvocationKind implements h.a {
            AT_MOST_ONCE(0, 0),
            EXACTLY_ONCE(1, 1),
            AT_LEAST_ONCE(2, 2);
            
            private static h.b<InvocationKind> internalValueMap = new a();
            private final int value;

            /* loaded from: classes3.dex */
            public static class a implements h.b<InvocationKind> {
                @Override // h.p2.b0.g.t.i.h.b
                /* renamed from: b */
                public InvocationKind a(int i2) {
                    return InvocationKind.valueOf(i2);
                }
            }

            InvocationKind(int i2, int i3) {
                this.value = i3;
            }

            @Override // h.p2.b0.g.t.i.h.a
            public final int getNumber() {
                return this.value;
            }

            public static InvocationKind valueOf(int i2) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return null;
                        }
                        return AT_LEAST_ONCE;
                    }
                    return EXACTLY_ONCE;
                }
                return AT_MOST_ONCE;
            }
        }

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<Effect> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public Effect c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new Effect(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.b<Effect, b> implements g {
            private int b;

            /* renamed from: c */
            private EffectType f16609c = EffectType.RETURNS_CONSTANT;

            /* renamed from: d */
            private List<Expression> f16610d = Collections.emptyList();

            /* renamed from: e */
            private Expression f16611e = Expression.getDefaultInstance();

            /* renamed from: f */
            private InvocationKind f16612f = InvocationKind.AT_MOST_ONCE;

            private b() {
                v();
            }

            public static b o() {
                return new b();
            }

            private void p() {
                if ((this.b & 2) != 2) {
                    this.f16610d = new ArrayList(this.f16610d);
                    this.b |= 2;
                }
            }

            private void v() {
            }

            public b A(InvocationKind invocationKind) {
                Objects.requireNonNull(invocationKind);
                this.b |= 8;
                this.f16612f = invocationKind;
                return this;
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < t(); i2++) {
                    if (!s(i2).isInitialized()) {
                        return false;
                    }
                }
                return !u() || q().isInitialized();
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: l */
            public Effect build() {
                Effect m2 = m();
                if (m2.isInitialized()) {
                    return m2;
                }
                throw a.AbstractC0459a.c(m2);
            }

            public Effect m() {
                Effect effect = new Effect(this);
                int i2 = this.b;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                effect.effectType_ = this.f16609c;
                if ((this.b & 2) == 2) {
                    this.f16610d = Collections.unmodifiableList(this.f16610d);
                    this.b &= -3;
                }
                effect.effectConstructorArgument_ = this.f16610d;
                if ((i2 & 4) == 4) {
                    i3 |= 2;
                }
                effect.conclusionOfConditionalEffect_ = this.f16611e;
                if ((i2 & 8) == 8) {
                    i3 |= 4;
                }
                effect.kind_ = this.f16612f;
                effect.bitField0_ = i3;
                return effect;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: n */
            public b e() {
                return o().h(m());
            }

            public Expression q() {
                return this.f16611e;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: r */
            public Effect getDefaultInstanceForType() {
                return Effect.getDefaultInstance();
            }

            public Expression s(int i2) {
                return this.f16610d.get(i2);
            }

            public int t() {
                return this.f16610d.size();
            }

            public boolean u() {
                return (this.b & 4) == 4;
            }

            public b w(Expression expression) {
                if ((this.b & 4) == 4 && this.f16611e != Expression.getDefaultInstance()) {
                    this.f16611e = Expression.newBuilder(this.f16611e).h(expression).m();
                } else {
                    this.f16611e = expression;
                }
                this.b |= 4;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: x */
            public b h(Effect effect) {
                if (effect == Effect.getDefaultInstance()) {
                    return this;
                }
                if (effect.hasEffectType()) {
                    z(effect.getEffectType());
                }
                if (!effect.effectConstructorArgument_.isEmpty()) {
                    if (this.f16610d.isEmpty()) {
                        this.f16610d = effect.effectConstructorArgument_;
                        this.b &= -3;
                    } else {
                        p();
                        this.f16610d.addAll(effect.effectConstructorArgument_);
                    }
                }
                if (effect.hasConclusionOfConditionalEffect()) {
                    w(effect.getConclusionOfConditionalEffect());
                }
                if (effect.hasKind()) {
                    A(effect.getKind());
                }
                j(g().b(effect.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: y */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect$b");
            }

            public b z(EffectType effectType) {
                Objects.requireNonNull(effectType);
                this.b |= 1;
                this.f16609c = effectType;
                return this;
            }
        }

        static {
            Effect effect = new Effect(true);
            defaultInstance = effect;
            effect.initFields();
        }

        public static Effect getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.effectType_ = EffectType.RETURNS_CONSTANT;
            this.effectConstructorArgument_ = Collections.emptyList();
            this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            this.kind_ = InvocationKind.AT_MOST_ONCE;
        }

        public static b newBuilder() {
            return b.o();
        }

        public Expression getConclusionOfConditionalEffect() {
            return this.conclusionOfConditionalEffect_;
        }

        public Expression getEffectConstructorArgument(int i2) {
            return this.effectConstructorArgument_.get(i2);
        }

        public int getEffectConstructorArgumentCount() {
            return this.effectConstructorArgument_.size();
        }

        public EffectType getEffectType() {
            return this.effectType_;
        }

        public InvocationKind getKind() {
            return this.kind_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<Effect> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int h2 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.h(1, this.effectType_.getNumber()) + 0 : 0;
            for (int i3 = 0; i3 < this.effectConstructorArgument_.size(); i3++) {
                h2 += CodedOutputStream.s(2, this.effectConstructorArgument_.get(i3));
            }
            if ((this.bitField0_ & 2) == 2) {
                h2 += CodedOutputStream.s(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                h2 += CodedOutputStream.h(4, this.kind_.getNumber());
            }
            int size = h2 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasConclusionOfConditionalEffect() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasEffectType() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasKind() {
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
            for (int i2 = 0; i2 < getEffectConstructorArgumentCount(); i2++) {
                if (!getEffectConstructorArgument(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasConclusionOfConditionalEffect() && !getConclusionOfConditionalEffect().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.S(1, this.effectType_.getNumber());
            }
            for (int i2 = 0; i2 < this.effectConstructorArgument_.size(); i2++) {
                codedOutputStream.d0(2, this.effectConstructorArgument_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.d0(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.S(4, this.kind_.getNumber());
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Effect effect) {
            return newBuilder().h(effect);
        }

        @Override // h.p2.b0.g.t.i.o
        public Effect getDefaultInstanceForType() {
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

        private Effect(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.g();
        }

        private Effect(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Effect(e eVar, f fVar) throws InvalidProtocolBufferException {
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
                                int n = eVar.n();
                                EffectType valueOf = EffectType.valueOf(n);
                                if (valueOf == null) {
                                    J.o0(K);
                                    J.o0(n);
                                } else {
                                    this.bitField0_ |= 1;
                                    this.effectType_ = valueOf;
                                }
                            } else if (K == 18) {
                                if (!(z2 & true)) {
                                    this.effectConstructorArgument_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.effectConstructorArgument_.add(eVar.u(Expression.PARSER, fVar));
                            } else if (K == 26) {
                                Expression.b builder = (this.bitField0_ & 2) == 2 ? this.conclusionOfConditionalEffect_.toBuilder() : null;
                                Expression expression = (Expression) eVar.u(Expression.PARSER, fVar);
                                this.conclusionOfConditionalEffect_ = expression;
                                if (builder != null) {
                                    builder.h(expression);
                                    this.conclusionOfConditionalEffect_ = builder.m();
                                }
                                this.bitField0_ |= 2;
                            } else if (K != 32) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                int n2 = eVar.n();
                                InvocationKind valueOf2 = InvocationKind.valueOf(n2);
                                if (valueOf2 == null) {
                                    J.o0(K);
                                    J.o0(n2);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.kind_ = valueOf2;
                                }
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
                        this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
    public static final class EnumEntry extends GeneratedMessageLite.ExtendableMessage<EnumEntry> implements h.p2.b0.g.t.f.h {
        public static p<EnumEntry> PARSER = new a();
        private static final EnumEntry defaultInstance;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final d unknownFields;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<EnumEntry> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public EnumEntry c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new EnumEntry(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.c<EnumEntry, b> implements h.p2.b0.g.t.f.h {

            /* renamed from: d */
            private int f16613d;

            /* renamed from: e */
            private int f16614e;

            private b() {
                w();
            }

            public static b u() {
                return new b();
            }

            private void w() {
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                return o();
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: r */
            public EnumEntry build() {
                EnumEntry s = s();
                if (s.isInitialized()) {
                    return s;
                }
                throw a.AbstractC0459a.c(s);
            }

            public EnumEntry s() {
                EnumEntry enumEntry = new EnumEntry(this);
                int i2 = (this.f16613d & 1) != 1 ? 0 : 1;
                enumEntry.name_ = this.f16614e;
                enumEntry.bitField0_ = i2;
                return enumEntry;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: t */
            public b m() {
                return u().h(s());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: v */
            public EnumEntry getDefaultInstanceForType() {
                return EnumEntry.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: x */
            public b h(EnumEntry enumEntry) {
                if (enumEntry == EnumEntry.getDefaultInstance()) {
                    return this;
                }
                if (enumEntry.hasName()) {
                    z(enumEntry.getName());
                }
                p(enumEntry);
                j(g().b(enumEntry.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: y */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry$b");
            }

            public b z(int i2) {
                this.f16613d |= 1;
                this.f16614e = i2;
                return this;
            }
        }

        static {
            EnumEntry enumEntry = new EnumEntry(true);
            defaultInstance = enumEntry;
            enumEntry.initFields();
        }

        public static EnumEntry getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.name_ = 0;
        }

        public static b newBuilder() {
            return b.u();
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<EnumEntry> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int o = ((this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.o(1, this.name_) : 0) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = o;
            return o;
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
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.name_);
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(EnumEntry enumEntry) {
            return newBuilder().h(enumEntry);
        }

        @Override // h.p2.b0.g.t.i.o
        public EnumEntry getDefaultInstanceForType() {
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

        private EnumEntry(GeneratedMessageLite.c<EnumEntry, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.g();
        }

        private EnumEntry(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        private EnumEntry(e eVar, f fVar) throws InvalidProtocolBufferException {
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
                            if (K != 8) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.name_ = eVar.s();
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
    public static final class Expression extends GeneratedMessageLite implements i {
        public static p<Expression> PARSER = new a();
        private static final Expression defaultInstance;
        private List<Expression> andArgument_;
        private int bitField0_;
        private ConstantValue constantValue_;
        private int flags_;
        private int isInstanceTypeId_;
        private Type isInstanceType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Expression> orArgument_;
        private final d unknownFields;
        private int valueParameterReference_;

        /* loaded from: classes3.dex */
        public enum ConstantValue implements h.a {
            TRUE(0, 0),
            FALSE(1, 1),
            NULL(2, 2);
            
            private static h.b<ConstantValue> internalValueMap = new a();
            private final int value;

            /* loaded from: classes3.dex */
            public static class a implements h.b<ConstantValue> {
                @Override // h.p2.b0.g.t.i.h.b
                /* renamed from: b */
                public ConstantValue a(int i2) {
                    return ConstantValue.valueOf(i2);
                }
            }

            ConstantValue(int i2, int i3) {
                this.value = i3;
            }

            @Override // h.p2.b0.g.t.i.h.a
            public final int getNumber() {
                return this.value;
            }

            public static ConstantValue valueOf(int i2) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return null;
                        }
                        return NULL;
                    }
                    return FALSE;
                }
                return TRUE;
            }
        }

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<Expression> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public Expression c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new Expression(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.b<Expression, b> implements i {
            private int b;

            /* renamed from: c */
            private int f16615c;

            /* renamed from: d */
            private int f16616d;

            /* renamed from: g */
            private int f16619g;

            /* renamed from: e */
            private ConstantValue f16617e = ConstantValue.TRUE;

            /* renamed from: f */
            private Type f16618f = Type.getDefaultInstance();

            /* renamed from: h */
            private List<Expression> f16620h = Collections.emptyList();

            /* renamed from: i */
            private List<Expression> f16621i = Collections.emptyList();

            private b() {
                y();
            }

            public static b o() {
                return new b();
            }

            private void p() {
                if ((this.b & 32) != 32) {
                    this.f16620h = new ArrayList(this.f16620h);
                    this.b |= 32;
                }
            }

            private void q() {
                if ((this.b & 64) != 64) {
                    this.f16621i = new ArrayList(this.f16621i);
                    this.b |= 64;
                }
            }

            private void y() {
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: A */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression$b");
            }

            public b B(Type type) {
                if ((this.b & 8) == 8 && this.f16618f != Type.getDefaultInstance()) {
                    this.f16618f = Type.newBuilder(this.f16618f).h(type).s();
                } else {
                    this.f16618f = type;
                }
                this.b |= 8;
                return this;
            }

            public b C(ConstantValue constantValue) {
                Objects.requireNonNull(constantValue);
                this.b |= 4;
                this.f16617e = constantValue;
                return this;
            }

            public b D(int i2) {
                this.b |= 1;
                this.f16615c = i2;
                return this;
            }

            public b E(int i2) {
                this.b |= 16;
                this.f16619g = i2;
                return this;
            }

            public b F(int i2) {
                this.b |= 2;
                this.f16616d = i2;
                return this;
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                if (!x() || u().isInitialized()) {
                    for (int i2 = 0; i2 < s(); i2++) {
                        if (!r(i2).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i3 = 0; i3 < w(); i3++) {
                        if (!v(i3).isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: l */
            public Expression build() {
                Expression m2 = m();
                if (m2.isInitialized()) {
                    return m2;
                }
                throw a.AbstractC0459a.c(m2);
            }

            public Expression m() {
                Expression expression = new Expression(this);
                int i2 = this.b;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                expression.flags_ = this.f16615c;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                expression.valueParameterReference_ = this.f16616d;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                expression.constantValue_ = this.f16617e;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                expression.isInstanceType_ = this.f16618f;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                expression.isInstanceTypeId_ = this.f16619g;
                if ((this.b & 32) == 32) {
                    this.f16620h = Collections.unmodifiableList(this.f16620h);
                    this.b &= -33;
                }
                expression.andArgument_ = this.f16620h;
                if ((this.b & 64) == 64) {
                    this.f16621i = Collections.unmodifiableList(this.f16621i);
                    this.b &= -65;
                }
                expression.orArgument_ = this.f16621i;
                expression.bitField0_ = i3;
                return expression;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: n */
            public b e() {
                return o().h(m());
            }

            public Expression r(int i2) {
                return this.f16620h.get(i2);
            }

            public int s() {
                return this.f16620h.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: t */
            public Expression getDefaultInstanceForType() {
                return Expression.getDefaultInstance();
            }

            public Type u() {
                return this.f16618f;
            }

            public Expression v(int i2) {
                return this.f16621i.get(i2);
            }

            public int w() {
                return this.f16621i.size();
            }

            public boolean x() {
                return (this.b & 8) == 8;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: z */
            public b h(Expression expression) {
                if (expression == Expression.getDefaultInstance()) {
                    return this;
                }
                if (expression.hasFlags()) {
                    D(expression.getFlags());
                }
                if (expression.hasValueParameterReference()) {
                    F(expression.getValueParameterReference());
                }
                if (expression.hasConstantValue()) {
                    C(expression.getConstantValue());
                }
                if (expression.hasIsInstanceType()) {
                    B(expression.getIsInstanceType());
                }
                if (expression.hasIsInstanceTypeId()) {
                    E(expression.getIsInstanceTypeId());
                }
                if (!expression.andArgument_.isEmpty()) {
                    if (this.f16620h.isEmpty()) {
                        this.f16620h = expression.andArgument_;
                        this.b &= -33;
                    } else {
                        p();
                        this.f16620h.addAll(expression.andArgument_);
                    }
                }
                if (!expression.orArgument_.isEmpty()) {
                    if (this.f16621i.isEmpty()) {
                        this.f16621i = expression.orArgument_;
                        this.b &= -65;
                    } else {
                        q();
                        this.f16621i.addAll(expression.orArgument_);
                    }
                }
                j(g().b(expression.unknownFields));
                return this;
            }
        }

        static {
            Expression expression = new Expression(true);
            defaultInstance = expression;
            expression.initFields();
        }

        public static Expression getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 0;
            this.valueParameterReference_ = 0;
            this.constantValue_ = ConstantValue.TRUE;
            this.isInstanceType_ = Type.getDefaultInstance();
            this.isInstanceTypeId_ = 0;
            this.andArgument_ = Collections.emptyList();
            this.orArgument_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.o();
        }

        public Expression getAndArgument(int i2) {
            return this.andArgument_.get(i2);
        }

        public int getAndArgumentCount() {
            return this.andArgument_.size();
        }

        public ConstantValue getConstantValue() {
            return this.constantValue_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public Type getIsInstanceType() {
            return this.isInstanceType_;
        }

        public int getIsInstanceTypeId() {
            return this.isInstanceTypeId_;
        }

        public Expression getOrArgument(int i2) {
            return this.orArgument_.get(i2);
        }

        public int getOrArgumentCount() {
            return this.orArgument_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<Expression> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.flags_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                o += CodedOutputStream.o(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                o += CodedOutputStream.h(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                o += CodedOutputStream.s(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                o += CodedOutputStream.o(5, this.isInstanceTypeId_);
            }
            for (int i3 = 0; i3 < this.andArgument_.size(); i3++) {
                o += CodedOutputStream.s(6, this.andArgument_.get(i3));
            }
            for (int i4 = 0; i4 < this.orArgument_.size(); i4++) {
                o += CodedOutputStream.s(7, this.orArgument_.get(i4));
            }
            int size = o + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getValueParameterReference() {
            return this.valueParameterReference_;
        }

        public boolean hasConstantValue() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasIsInstanceType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasIsInstanceTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasValueParameterReference() {
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
            if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i2 = 0; i2 < getAndArgumentCount(); i2++) {
                if (!getAndArgument(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < getOrArgumentCount(); i3++) {
                if (!getOrArgument(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.S(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.d0(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.a0(5, this.isInstanceTypeId_);
            }
            for (int i2 = 0; i2 < this.andArgument_.size(); i2++) {
                codedOutputStream.d0(6, this.andArgument_.get(i2));
            }
            for (int i3 = 0; i3 < this.orArgument_.size(); i3++) {
                codedOutputStream.d0(7, this.orArgument_.get(i3));
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Expression expression) {
            return newBuilder().h(expression);
        }

        @Override // h.p2.b0.g.t.i.o
        public Expression getDefaultInstanceForType() {
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

        private Expression(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.g();
        }

        private Expression(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Expression(e eVar, f fVar) throws InvalidProtocolBufferException {
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
                                this.flags_ = eVar.s();
                            } else if (K == 16) {
                                this.bitField0_ |= 2;
                                this.valueParameterReference_ = eVar.s();
                            } else if (K == 24) {
                                int n = eVar.n();
                                ConstantValue valueOf = ConstantValue.valueOf(n);
                                if (valueOf == null) {
                                    J.o0(K);
                                    J.o0(n);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.constantValue_ = valueOf;
                                }
                            } else if (K == 34) {
                                Type.b builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : null;
                                Type type = (Type) eVar.u(Type.PARSER, fVar);
                                this.isInstanceType_ = type;
                                if (builder != null) {
                                    builder.h(type);
                                    this.isInstanceType_ = builder.s();
                                }
                                this.bitField0_ |= 8;
                            } else if (K == 40) {
                                this.bitField0_ |= 16;
                                this.isInstanceTypeId_ = eVar.s();
                            } else if (K == 50) {
                                if (!(z2 & true)) {
                                    this.andArgument_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.andArgument_.add(eVar.u(PARSER, fVar));
                            } else if (K != 58) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                if (!(z2 & true)) {
                                    this.orArgument_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.orArgument_.add(eVar.u(PARSER, fVar));
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
                        this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    }
                    if (z2 & true) {
                        this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
            }
            if (z2 & true) {
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
    public static final class Function extends GeneratedMessageLite.ExtendableMessage<Function> implements j {
        public static p<Function> PARSER = new a();
        private static final Function defaultInstance;
        private int bitField0_;
        private Contract contract_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final d unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<Function> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public Function c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new Function(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.c<Function, b> implements j {

            /* renamed from: d */
            private int f16622d;

            /* renamed from: g */
            private int f16625g;

            /* renamed from: i */
            private int f16627i;

            /* renamed from: l */
            private int f16630l;

            /* renamed from: e */
            private int f16623e = 6;

            /* renamed from: f */
            private int f16624f = 6;

            /* renamed from: h */
            private Type f16626h = Type.getDefaultInstance();

            /* renamed from: j */
            private List<TypeParameter> f16628j = Collections.emptyList();

            /* renamed from: k */
            private Type f16629k = Type.getDefaultInstance();

            /* renamed from: m */
            private List<ValueParameter> f16631m = Collections.emptyList();
            private TypeTable n = TypeTable.getDefaultInstance();
            private List<Integer> o = Collections.emptyList();
            private Contract p = Contract.getDefaultInstance();

            private b() {
                M();
            }

            private void M() {
            }

            public static b u() {
                return new b();
            }

            private void v() {
                if ((this.f16622d & 32) != 32) {
                    this.f16628j = new ArrayList(this.f16628j);
                    this.f16622d |= 32;
                }
            }

            private void w() {
                if ((this.f16622d & 256) != 256) {
                    this.f16631m = new ArrayList(this.f16631m);
                    this.f16622d |= 256;
                }
            }

            private void x() {
                if ((this.f16622d & 1024) != 1024) {
                    this.o = new ArrayList(this.o);
                    this.f16622d |= 1024;
                }
            }

            public Type A() {
                return this.f16629k;
            }

            public Type B() {
                return this.f16626h;
            }

            public TypeParameter C(int i2) {
                return this.f16628j.get(i2);
            }

            public int D() {
                return this.f16628j.size();
            }

            public TypeTable E() {
                return this.n;
            }

            public ValueParameter F(int i2) {
                return this.f16631m.get(i2);
            }

            public int G() {
                return this.f16631m.size();
            }

            public boolean H() {
                return (this.f16622d & 2048) == 2048;
            }

            public boolean I() {
                return (this.f16622d & 4) == 4;
            }

            public boolean J() {
                return (this.f16622d & 64) == 64;
            }

            public boolean K() {
                return (this.f16622d & 8) == 8;
            }

            public boolean L() {
                return (this.f16622d & 512) == 512;
            }

            public b N(Contract contract) {
                if ((this.f16622d & 2048) == 2048 && this.p != Contract.getDefaultInstance()) {
                    this.p = Contract.newBuilder(this.p).h(contract).m();
                } else {
                    this.p = contract;
                }
                this.f16622d |= 2048;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: O */
            public b h(Function function) {
                if (function == Function.getDefaultInstance()) {
                    return this;
                }
                if (function.hasFlags()) {
                    T(function.getFlags());
                }
                if (function.hasOldFlags()) {
                    V(function.getOldFlags());
                }
                if (function.hasName()) {
                    U(function.getName());
                }
                if (function.hasReturnType()) {
                    R(function.getReturnType());
                }
                if (function.hasReturnTypeId()) {
                    X(function.getReturnTypeId());
                }
                if (!function.typeParameter_.isEmpty()) {
                    if (this.f16628j.isEmpty()) {
                        this.f16628j = function.typeParameter_;
                        this.f16622d &= -33;
                    } else {
                        v();
                        this.f16628j.addAll(function.typeParameter_);
                    }
                }
                if (function.hasReceiverType()) {
                    Q(function.getReceiverType());
                }
                if (function.hasReceiverTypeId()) {
                    W(function.getReceiverTypeId());
                }
                if (!function.valueParameter_.isEmpty()) {
                    if (this.f16631m.isEmpty()) {
                        this.f16631m = function.valueParameter_;
                        this.f16622d &= -257;
                    } else {
                        w();
                        this.f16631m.addAll(function.valueParameter_);
                    }
                }
                if (function.hasTypeTable()) {
                    S(function.getTypeTable());
                }
                if (!function.versionRequirement_.isEmpty()) {
                    if (this.o.isEmpty()) {
                        this.o = function.versionRequirement_;
                        this.f16622d &= -1025;
                    } else {
                        x();
                        this.o.addAll(function.versionRequirement_);
                    }
                }
                if (function.hasContract()) {
                    N(function.getContract());
                }
                p(function);
                j(g().b(function.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: P */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function$b");
            }

            public b Q(Type type) {
                if ((this.f16622d & 64) == 64 && this.f16629k != Type.getDefaultInstance()) {
                    this.f16629k = Type.newBuilder(this.f16629k).h(type).s();
                } else {
                    this.f16629k = type;
                }
                this.f16622d |= 64;
                return this;
            }

            public b R(Type type) {
                if ((this.f16622d & 8) == 8 && this.f16626h != Type.getDefaultInstance()) {
                    this.f16626h = Type.newBuilder(this.f16626h).h(type).s();
                } else {
                    this.f16626h = type;
                }
                this.f16622d |= 8;
                return this;
            }

            public b S(TypeTable typeTable) {
                if ((this.f16622d & 512) == 512 && this.n != TypeTable.getDefaultInstance()) {
                    this.n = TypeTable.newBuilder(this.n).h(typeTable).m();
                } else {
                    this.n = typeTable;
                }
                this.f16622d |= 512;
                return this;
            }

            public b T(int i2) {
                this.f16622d |= 1;
                this.f16623e = i2;
                return this;
            }

            public b U(int i2) {
                this.f16622d |= 4;
                this.f16625g = i2;
                return this;
            }

            public b V(int i2) {
                this.f16622d |= 2;
                this.f16624f = i2;
                return this;
            }

            public b W(int i2) {
                this.f16622d |= 128;
                this.f16630l = i2;
                return this;
            }

            public b X(int i2) {
                this.f16622d |= 16;
                this.f16627i = i2;
                return this;
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                if (I()) {
                    if (!K() || B().isInitialized()) {
                        for (int i2 = 0; i2 < D(); i2++) {
                            if (!C(i2).isInitialized()) {
                                return false;
                            }
                        }
                        if (!J() || A().isInitialized()) {
                            for (int i3 = 0; i3 < G(); i3++) {
                                if (!F(i3).isInitialized()) {
                                    return false;
                                }
                            }
                            if (!L() || E().isInitialized()) {
                                return (!H() || y().isInitialized()) && o();
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: r */
            public Function build() {
                Function s = s();
                if (s.isInitialized()) {
                    return s;
                }
                throw a.AbstractC0459a.c(s);
            }

            public Function s() {
                Function function = new Function(this);
                int i2 = this.f16622d;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                function.flags_ = this.f16623e;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                function.oldFlags_ = this.f16624f;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                function.name_ = this.f16625g;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                function.returnType_ = this.f16626h;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                function.returnTypeId_ = this.f16627i;
                if ((this.f16622d & 32) == 32) {
                    this.f16628j = Collections.unmodifiableList(this.f16628j);
                    this.f16622d &= -33;
                }
                function.typeParameter_ = this.f16628j;
                if ((i2 & 64) == 64) {
                    i3 |= 32;
                }
                function.receiverType_ = this.f16629k;
                if ((i2 & 128) == 128) {
                    i3 |= 64;
                }
                function.receiverTypeId_ = this.f16630l;
                if ((this.f16622d & 256) == 256) {
                    this.f16631m = Collections.unmodifiableList(this.f16631m);
                    this.f16622d &= -257;
                }
                function.valueParameter_ = this.f16631m;
                if ((i2 & 512) == 512) {
                    i3 |= 128;
                }
                function.typeTable_ = this.n;
                if ((this.f16622d & 1024) == 1024) {
                    this.o = Collections.unmodifiableList(this.o);
                    this.f16622d &= -1025;
                }
                function.versionRequirement_ = this.o;
                if ((i2 & 2048) == 2048) {
                    i3 |= 256;
                }
                function.contract_ = this.p;
                function.bitField0_ = i3;
                return function;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: t */
            public b m() {
                return u().h(s());
            }

            public Contract y() {
                return this.p;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: z */
            public Function getDefaultInstanceForType() {
                return Function.getDefaultInstance();
            }
        }

        static {
            Function function = new Function(true);
            defaultInstance = function;
            function.initFields();
        }

        public static Function getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.oldFlags_ = 6;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.valueParameter_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.contract_ = Contract.getDefaultInstance();
        }

        public static b newBuilder() {
            return b.u();
        }

        public static Function parseFrom(InputStream inputStream, f fVar) throws IOException {
            return PARSER.a(inputStream, fVar);
        }

        public Contract getContract() {
            return this.contract_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<Function> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.bitField0_ & 2) == 2 ? CodedOutputStream.o(1, this.oldFlags_) + 0 : 0;
            if ((this.bitField0_ & 4) == 4) {
                o += CodedOutputStream.o(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                o += CodedOutputStream.s(3, this.returnType_);
            }
            for (int i3 = 0; i3 < this.typeParameter_.size(); i3++) {
                o += CodedOutputStream.s(4, this.typeParameter_.get(i3));
            }
            if ((this.bitField0_ & 32) == 32) {
                o += CodedOutputStream.s(5, this.receiverType_);
            }
            for (int i4 = 0; i4 < this.valueParameter_.size(); i4++) {
                o += CodedOutputStream.s(6, this.valueParameter_.get(i4));
            }
            if ((this.bitField0_ & 16) == 16) {
                o += CodedOutputStream.o(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                o += CodedOutputStream.o(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                o += CodedOutputStream.o(9, this.flags_);
            }
            if ((this.bitField0_ & 128) == 128) {
                o += CodedOutputStream.s(30, this.typeTable_);
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.versionRequirement_.size(); i6++) {
                i5 += CodedOutputStream.p(this.versionRequirement_.get(i6).intValue());
            }
            int size = o + i5 + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 256) == 256) {
                size += CodedOutputStream.s(32, this.contract_);
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public TypeParameter getTypeParameter(int i2) {
            return this.typeParameter_.get(i2);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public ValueParameter getValueParameter(int i2) {
            return this.valueParameter_.get(i2);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasContract() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 128) == 128;
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasReturnType() && !getReturnType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i2 = 0; i2 < getTypeParameterCount(); i2++) {
                    if (!getTypeParameter(i2).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                for (int i3 = 0; i3 < getValueParameterCount(); i3++) {
                    if (!getValueParameter(i3).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (hasTypeTable() && !getTypeTable().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (hasContract() && !getContract().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
            }
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.a0(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.d0(3, this.returnType_);
            }
            for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
                codedOutputStream.d0(4, this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.d0(5, this.receiverType_);
            }
            for (int i3 = 0; i3 < this.valueParameter_.size(); i3++) {
                codedOutputStream.d0(6, this.valueParameter_.get(i3));
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.a0(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.a0(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(9, this.flags_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.d0(30, this.typeTable_);
            }
            for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
                codedOutputStream.a0(31, this.versionRequirement_.get(i4).intValue());
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.d0(32, this.contract_);
            }
            newExtensionWriter.a(19000, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Function function) {
            return newBuilder().h(function);
        }

        @Override // h.p2.b0.g.t.i.o
        public Function getDefaultInstanceForType() {
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

        private Function(GeneratedMessageLite.c<Function, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.g();
        }

        private Function(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
        private Function(e eVar, f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t = d.t();
            CodedOutputStream J = CodedOutputStream.J(t, 1);
            boolean z = false;
            boolean z2 = false;
            while (true) {
                ?? r5 = 1024;
                if (!z) {
                    try {
                        try {
                            try {
                                int K = eVar.K();
                                switch (K) {
                                    case 0:
                                        break;
                                    case 8:
                                        this.bitField0_ |= 2;
                                        this.oldFlags_ = eVar.s();
                                        continue;
                                    case 16:
                                        this.bitField0_ |= 4;
                                        this.name_ = eVar.s();
                                        continue;
                                    case 26:
                                        Type.b builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                                        Type type = (Type) eVar.u(Type.PARSER, fVar);
                                        this.returnType_ = type;
                                        if (builder != null) {
                                            builder.h(type);
                                            this.returnType_ = builder.s();
                                        }
                                        this.bitField0_ |= 8;
                                        continue;
                                    case 34:
                                        if (!(z2 & true)) {
                                            this.typeParameter_ = new ArrayList();
                                            z2 |= true;
                                        }
                                        this.typeParameter_.add(eVar.u(TypeParameter.PARSER, fVar));
                                        continue;
                                    case 42:
                                        Type.b builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                                        Type type2 = (Type) eVar.u(Type.PARSER, fVar);
                                        this.receiverType_ = type2;
                                        if (builder2 != null) {
                                            builder2.h(type2);
                                            this.receiverType_ = builder2.s();
                                        }
                                        this.bitField0_ |= 32;
                                        continue;
                                    case 50:
                                        if (!(z2 & true)) {
                                            this.valueParameter_ = new ArrayList();
                                            z2 |= true;
                                        }
                                        this.valueParameter_.add(eVar.u(ValueParameter.PARSER, fVar));
                                        continue;
                                    case 56:
                                        this.bitField0_ |= 16;
                                        this.returnTypeId_ = eVar.s();
                                        continue;
                                    case 64:
                                        this.bitField0_ |= 64;
                                        this.receiverTypeId_ = eVar.s();
                                        continue;
                                    case 72:
                                        this.bitField0_ |= 1;
                                        this.flags_ = eVar.s();
                                        continue;
                                    case 242:
                                        TypeTable.b builder3 = (this.bitField0_ & 128) == 128 ? this.typeTable_.toBuilder() : null;
                                        TypeTable typeTable = (TypeTable) eVar.u(TypeTable.PARSER, fVar);
                                        this.typeTable_ = typeTable;
                                        if (builder3 != null) {
                                            builder3.h(typeTable);
                                            this.typeTable_ = builder3.m();
                                        }
                                        this.bitField0_ |= 128;
                                        continue;
                                    case 248:
                                        if (!(z2 & true)) {
                                            this.versionRequirement_ = new ArrayList();
                                            z2 |= true;
                                        }
                                        this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                        continue;
                                    case 250:
                                        int j2 = eVar.j(eVar.A());
                                        if (!(z2 & true) && eVar.e() > 0) {
                                            this.versionRequirement_ = new ArrayList();
                                            z2 |= true;
                                        }
                                        while (eVar.e() > 0) {
                                            this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                        }
                                        eVar.i(j2);
                                        continue;
                                        break;
                                    case 258:
                                        Contract.b builder4 = (this.bitField0_ & 256) == 256 ? this.contract_.toBuilder() : null;
                                        Contract contract = (Contract) eVar.u(Contract.PARSER, fVar);
                                        this.contract_ = contract;
                                        if (builder4 != null) {
                                            builder4.h(contract);
                                            this.contract_ = builder4.m();
                                        }
                                        this.bitField0_ |= 256;
                                        continue;
                                    default:
                                        r5 = parseUnknownField(eVar, J, fVar, K);
                                        if (r5 == 0) {
                                            break;
                                        } else {
                                            continue;
                                        }
                                }
                                z = true;
                            } catch (InvalidProtocolBufferException e2) {
                                throw e2.setUnfinishedMessage(this);
                            }
                        } catch (IOException e3) {
                            throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        if (z2 & true) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if (z2 & true) {
                            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                        }
                        if ((z2 & true) == r5) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                } else {
                    if (z2 & true) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (z2 & true) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if (z2 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum MemberKind implements h.a {
        DECLARATION(0, 0),
        FAKE_OVERRIDE(1, 1),
        DELEGATION(2, 2),
        SYNTHESIZED(3, 3);
        
        private static h.b<MemberKind> internalValueMap = new a();
        private final int value;

        /* loaded from: classes3.dex */
        public static class a implements h.b<MemberKind> {
            @Override // h.p2.b0.g.t.i.h.b
            /* renamed from: b */
            public MemberKind a(int i2) {
                return MemberKind.valueOf(i2);
            }
        }

        MemberKind(int i2, int i3) {
            this.value = i3;
        }

        @Override // h.p2.b0.g.t.i.h.a
        public final int getNumber() {
            return this.value;
        }

        public static MemberKind valueOf(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            return null;
                        }
                        return SYNTHESIZED;
                    }
                    return DELEGATION;
                }
                return FAKE_OVERRIDE;
            }
            return DECLARATION;
        }
    }

    /* loaded from: classes3.dex */
    public enum Modality implements h.a {
        FINAL(0, 0),
        OPEN(1, 1),
        ABSTRACT(2, 2),
        SEALED(3, 3);
        
        private static h.b<Modality> internalValueMap = new a();
        private final int value;

        /* loaded from: classes3.dex */
        public static class a implements h.b<Modality> {
            @Override // h.p2.b0.g.t.i.h.b
            /* renamed from: b */
            public Modality a(int i2) {
                return Modality.valueOf(i2);
            }
        }

        Modality(int i2, int i3) {
            this.value = i3;
        }

        @Override // h.p2.b0.g.t.i.h.a
        public final int getNumber() {
            return this.value;
        }

        public static Modality valueOf(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            return null;
                        }
                        return SEALED;
                    }
                    return ABSTRACT;
                }
                return OPEN;
            }
            return FINAL;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Package extends GeneratedMessageLite.ExtendableMessage<Package> implements l {
        public static p<Package> PARSER = new a();
        private static final Package defaultInstance;
        private int bitField0_;
        private List<Function> function_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Property> property_;
        private List<TypeAlias> typeAlias_;
        private TypeTable typeTable_;
        private final d unknownFields;
        private VersionRequirementTable versionRequirementTable_;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<Package> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public Package c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new Package(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.c<Package, b> implements l {

            /* renamed from: d */
            private int f16632d;

            /* renamed from: e */
            private List<Function> f16633e = Collections.emptyList();

            /* renamed from: f */
            private List<Property> f16634f = Collections.emptyList();

            /* renamed from: g */
            private List<TypeAlias> f16635g = Collections.emptyList();

            /* renamed from: h */
            private TypeTable f16636h = TypeTable.getDefaultInstance();

            /* renamed from: i */
            private VersionRequirementTable f16637i = VersionRequirementTable.getDefaultInstance();

            private b() {
                H();
            }

            private void H() {
            }

            public static b u() {
                return new b();
            }

            private void v() {
                if ((this.f16632d & 1) != 1) {
                    this.f16633e = new ArrayList(this.f16633e);
                    this.f16632d |= 1;
                }
            }

            private void w() {
                if ((this.f16632d & 2) != 2) {
                    this.f16634f = new ArrayList(this.f16634f);
                    this.f16632d |= 2;
                }
            }

            private void x() {
                if ((this.f16632d & 4) != 4) {
                    this.f16635g = new ArrayList(this.f16635g);
                    this.f16632d |= 4;
                }
            }

            public int A() {
                return this.f16633e.size();
            }

            public Property B(int i2) {
                return this.f16634f.get(i2);
            }

            public int C() {
                return this.f16634f.size();
            }

            public TypeAlias D(int i2) {
                return this.f16635g.get(i2);
            }

            public int E() {
                return this.f16635g.size();
            }

            public TypeTable F() {
                return this.f16636h;
            }

            public boolean G() {
                return (this.f16632d & 8) == 8;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: I */
            public b h(Package r3) {
                if (r3 == Package.getDefaultInstance()) {
                    return this;
                }
                if (!r3.function_.isEmpty()) {
                    if (this.f16633e.isEmpty()) {
                        this.f16633e = r3.function_;
                        this.f16632d &= -2;
                    } else {
                        v();
                        this.f16633e.addAll(r3.function_);
                    }
                }
                if (!r3.property_.isEmpty()) {
                    if (this.f16634f.isEmpty()) {
                        this.f16634f = r3.property_;
                        this.f16632d &= -3;
                    } else {
                        w();
                        this.f16634f.addAll(r3.property_);
                    }
                }
                if (!r3.typeAlias_.isEmpty()) {
                    if (this.f16635g.isEmpty()) {
                        this.f16635g = r3.typeAlias_;
                        this.f16632d &= -5;
                    } else {
                        x();
                        this.f16635g.addAll(r3.typeAlias_);
                    }
                }
                if (r3.hasTypeTable()) {
                    K(r3.getTypeTable());
                }
                if (r3.hasVersionRequirementTable()) {
                    L(r3.getVersionRequirementTable());
                }
                p(r3);
                j(g().b(r3.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: J */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$b");
            }

            public b K(TypeTable typeTable) {
                if ((this.f16632d & 8) == 8 && this.f16636h != TypeTable.getDefaultInstance()) {
                    this.f16636h = TypeTable.newBuilder(this.f16636h).h(typeTable).m();
                } else {
                    this.f16636h = typeTable;
                }
                this.f16632d |= 8;
                return this;
            }

            public b L(VersionRequirementTable versionRequirementTable) {
                if ((this.f16632d & 16) == 16 && this.f16637i != VersionRequirementTable.getDefaultInstance()) {
                    this.f16637i = VersionRequirementTable.newBuilder(this.f16637i).h(versionRequirementTable).m();
                } else {
                    this.f16637i = versionRequirementTable;
                }
                this.f16632d |= 16;
                return this;
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < A(); i2++) {
                    if (!z(i2).isInitialized()) {
                        return false;
                    }
                }
                for (int i3 = 0; i3 < C(); i3++) {
                    if (!B(i3).isInitialized()) {
                        return false;
                    }
                }
                for (int i4 = 0; i4 < E(); i4++) {
                    if (!D(i4).isInitialized()) {
                        return false;
                    }
                }
                return (!G() || F().isInitialized()) && o();
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: r */
            public Package build() {
                Package s = s();
                if (s.isInitialized()) {
                    return s;
                }
                throw a.AbstractC0459a.c(s);
            }

            public Package s() {
                Package r0 = new Package(this);
                int i2 = this.f16632d;
                if ((i2 & 1) == 1) {
                    this.f16633e = Collections.unmodifiableList(this.f16633e);
                    this.f16632d &= -2;
                }
                r0.function_ = this.f16633e;
                if ((this.f16632d & 2) == 2) {
                    this.f16634f = Collections.unmodifiableList(this.f16634f);
                    this.f16632d &= -3;
                }
                r0.property_ = this.f16634f;
                if ((this.f16632d & 4) == 4) {
                    this.f16635g = Collections.unmodifiableList(this.f16635g);
                    this.f16632d &= -5;
                }
                r0.typeAlias_ = this.f16635g;
                int i3 = (i2 & 8) != 8 ? 0 : 1;
                r0.typeTable_ = this.f16636h;
                if ((i2 & 16) == 16) {
                    i3 |= 2;
                }
                r0.versionRequirementTable_ = this.f16637i;
                r0.bitField0_ = i3;
                return r0;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: t */
            public b m() {
                return u().h(s());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: y */
            public Package getDefaultInstanceForType() {
                return Package.getDefaultInstance();
            }

            public Function z(int i2) {
                return this.f16633e.get(i2);
            }
        }

        static {
            Package r0 = new Package(true);
            defaultInstance = r0;
            r0.initFields();
        }

        public static Package getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        public static b newBuilder() {
            return b.u();
        }

        public static Package parseFrom(InputStream inputStream, f fVar) throws IOException {
            return PARSER.a(inputStream, fVar);
        }

        public Function getFunction(int i2) {
            return this.function_.get(i2);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<Package> getParserForType() {
            return PARSER;
        }

        public Property getProperty(int i2) {
            return this.property_.get(i2);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.function_.size(); i4++) {
                i3 += CodedOutputStream.s(3, this.function_.get(i4));
            }
            for (int i5 = 0; i5 < this.property_.size(); i5++) {
                i3 += CodedOutputStream.s(4, this.property_.get(i5));
            }
            for (int i6 = 0; i6 < this.typeAlias_.size(); i6++) {
                i3 += CodedOutputStream.s(5, this.typeAlias_.get(i6));
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 += CodedOutputStream.s(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.s(32, this.versionRequirementTable_);
            }
            int extensionsSerializedSize = i3 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public TypeAlias getTypeAlias(int i2) {
            return this.typeAlias_.get(i2);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasVersionRequirementTable() {
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
            for (int i2 = 0; i2 < getFunctionCount(); i2++) {
                if (!getFunction(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < getPropertyCount(); i3++) {
                if (!getProperty(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < getTypeAliasCount(); i4++) {
                if (!getTypeAlias(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            for (int i2 = 0; i2 < this.function_.size(); i2++) {
                codedOutputStream.d0(3, this.function_.get(i2));
            }
            for (int i3 = 0; i3 < this.property_.size(); i3++) {
                codedOutputStream.d0(4, this.property_.get(i3));
            }
            for (int i4 = 0; i4 < this.typeAlias_.size(); i4++) {
                codedOutputStream.d0(5, this.typeAlias_.get(i4));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.d0(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.d0(32, this.versionRequirementTable_);
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Package r1) {
            return newBuilder().h(r1);
        }

        @Override // h.p2.b0.g.t.i.o
        public Package getDefaultInstanceForType() {
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

        private Package(GeneratedMessageLite.c<Package, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.g();
        }

        private Package(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Package(e eVar, f fVar) throws InvalidProtocolBufferException {
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
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 26) {
                                    if (!(z2 & true)) {
                                        this.function_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.function_.add(eVar.u(Function.PARSER, fVar));
                                } else if (K == 34) {
                                    if (!(z2 & true)) {
                                        this.property_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.property_.add(eVar.u(Property.PARSER, fVar));
                                } else if (K != 42) {
                                    if (K == 242) {
                                        TypeTable.b builder = (this.bitField0_ & 1) == 1 ? this.typeTable_.toBuilder() : null;
                                        TypeTable typeTable = (TypeTable) eVar.u(TypeTable.PARSER, fVar);
                                        this.typeTable_ = typeTable;
                                        if (builder != null) {
                                            builder.h(typeTable);
                                            this.typeTable_ = builder.m();
                                        }
                                        this.bitField0_ |= 1;
                                    } else if (K != 258) {
                                        if (!parseUnknownField(eVar, J, fVar, K)) {
                                        }
                                    } else {
                                        VersionRequirementTable.b builder2 = (this.bitField0_ & 2) == 2 ? this.versionRequirementTable_.toBuilder() : null;
                                        VersionRequirementTable versionRequirementTable = (VersionRequirementTable) eVar.u(VersionRequirementTable.PARSER, fVar);
                                        this.versionRequirementTable_ = versionRequirementTable;
                                        if (builder2 != null) {
                                            builder2.h(versionRequirementTable);
                                            this.versionRequirementTable_ = builder2.m();
                                        }
                                        this.bitField0_ |= 2;
                                    }
                                } else {
                                    if (!(z2 & true)) {
                                        this.typeAlias_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.typeAlias_.add(eVar.u(TypeAlias.PARSER, fVar));
                                }
                            }
                            z = true;
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw e3.setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.function_ = Collections.unmodifiableList(this.function_);
                    }
                    if (z2 & true) {
                        this.property_ = Collections.unmodifiableList(this.property_);
                    }
                    if (z2 & true) {
                        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
                this.function_ = Collections.unmodifiableList(this.function_);
            }
            if (z2 & true) {
                this.property_ = Collections.unmodifiableList(this.property_);
            }
            if (z2 & true) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
    public static final class PackageFragment extends GeneratedMessageLite.ExtendableMessage<PackageFragment> implements k {
        public static p<PackageFragment> PARSER = new a();
        private static final PackageFragment defaultInstance;
        private int bitField0_;
        private List<Class> class__;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Package package_;
        private QualifiedNameTable qualifiedNames_;
        private StringTable strings_;
        private final d unknownFields;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<PackageFragment> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public PackageFragment c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new PackageFragment(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.c<PackageFragment, b> implements k {

            /* renamed from: d */
            private int f16638d;

            /* renamed from: e */
            private StringTable f16639e = StringTable.getDefaultInstance();

            /* renamed from: f */
            private QualifiedNameTable f16640f = QualifiedNameTable.getDefaultInstance();

            /* renamed from: g */
            private Package f16641g = Package.getDefaultInstance();

            /* renamed from: h */
            private List<Class> f16642h = Collections.emptyList();

            private b() {
                D();
            }

            private void D() {
            }

            public static b u() {
                return new b();
            }

            private void v() {
                if ((this.f16638d & 8) != 8) {
                    this.f16642h = new ArrayList(this.f16642h);
                    this.f16638d |= 8;
                }
            }

            public QualifiedNameTable A() {
                return this.f16640f;
            }

            public boolean B() {
                return (this.f16638d & 4) == 4;
            }

            public boolean C() {
                return (this.f16638d & 2) == 2;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: E */
            public b h(PackageFragment packageFragment) {
                if (packageFragment == PackageFragment.getDefaultInstance()) {
                    return this;
                }
                if (packageFragment.hasStrings()) {
                    I(packageFragment.getStrings());
                }
                if (packageFragment.hasQualifiedNames()) {
                    H(packageFragment.getQualifiedNames());
                }
                if (packageFragment.hasPackage()) {
                    G(packageFragment.getPackage());
                }
                if (!packageFragment.class__.isEmpty()) {
                    if (this.f16642h.isEmpty()) {
                        this.f16642h = packageFragment.class__;
                        this.f16638d &= -9;
                    } else {
                        v();
                        this.f16642h.addAll(packageFragment.class__);
                    }
                }
                p(packageFragment);
                j(g().b(packageFragment.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: F */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment$b");
            }

            public b G(Package r4) {
                if ((this.f16638d & 4) == 4 && this.f16641g != Package.getDefaultInstance()) {
                    this.f16641g = Package.newBuilder(this.f16641g).h(r4).s();
                } else {
                    this.f16641g = r4;
                }
                this.f16638d |= 4;
                return this;
            }

            public b H(QualifiedNameTable qualifiedNameTable) {
                if ((this.f16638d & 2) == 2 && this.f16640f != QualifiedNameTable.getDefaultInstance()) {
                    this.f16640f = QualifiedNameTable.newBuilder(this.f16640f).h(qualifiedNameTable).m();
                } else {
                    this.f16640f = qualifiedNameTable;
                }
                this.f16638d |= 2;
                return this;
            }

            public b I(StringTable stringTable) {
                if ((this.f16638d & 1) == 1 && this.f16639e != StringTable.getDefaultInstance()) {
                    this.f16639e = StringTable.newBuilder(this.f16639e).h(stringTable).m();
                } else {
                    this.f16639e = stringTable;
                }
                this.f16638d |= 1;
                return this;
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                if (!C() || A().isInitialized()) {
                    if (!B() || z().isInitialized()) {
                        for (int i2 = 0; i2 < x(); i2++) {
                            if (!w(i2).isInitialized()) {
                                return false;
                            }
                        }
                        return o();
                    }
                    return false;
                }
                return false;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: r */
            public PackageFragment build() {
                PackageFragment s = s();
                if (s.isInitialized()) {
                    return s;
                }
                throw a.AbstractC0459a.c(s);
            }

            public PackageFragment s() {
                PackageFragment packageFragment = new PackageFragment(this);
                int i2 = this.f16638d;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                packageFragment.strings_ = this.f16639e;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                packageFragment.qualifiedNames_ = this.f16640f;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                packageFragment.package_ = this.f16641g;
                if ((this.f16638d & 8) == 8) {
                    this.f16642h = Collections.unmodifiableList(this.f16642h);
                    this.f16638d &= -9;
                }
                packageFragment.class__ = this.f16642h;
                packageFragment.bitField0_ = i3;
                return packageFragment;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: t */
            public b m() {
                return u().h(s());
            }

            public Class w(int i2) {
                return this.f16642h.get(i2);
            }

            public int x() {
                return this.f16642h.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: y */
            public PackageFragment getDefaultInstanceForType() {
                return PackageFragment.getDefaultInstance();
            }

            public Package z() {
                return this.f16641g;
            }
        }

        static {
            PackageFragment packageFragment = new PackageFragment(true);
            defaultInstance = packageFragment;
            packageFragment.initFields();
        }

        public static PackageFragment getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.strings_ = StringTable.getDefaultInstance();
            this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            this.package_ = Package.getDefaultInstance();
            this.class__ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.u();
        }

        public static PackageFragment parseFrom(InputStream inputStream, f fVar) throws IOException {
            return PARSER.a(inputStream, fVar);
        }

        public Class getClass_(int i2) {
            return this.class__.get(i2);
        }

        public int getClass_Count() {
            return this.class__.size();
        }

        public List<Class> getClass_List() {
            return this.class__;
        }

        public Package getPackage() {
            return this.package_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<PackageFragment> getParserForType() {
            return PARSER;
        }

        public QualifiedNameTable getQualifiedNames() {
            return this.qualifiedNames_;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int s = (this.bitField0_ & 1) == 1 ? CodedOutputStream.s(1, this.strings_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                s += CodedOutputStream.s(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                s += CodedOutputStream.s(3, this.package_);
            }
            for (int i3 = 0; i3 < this.class__.size(); i3++) {
                s += CodedOutputStream.s(4, this.class__.get(i3));
            }
            int extensionsSerializedSize = s + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public StringTable getStrings() {
            return this.strings_;
        }

        public boolean hasPackage() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasQualifiedNames() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasStrings() {
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
            if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasPackage() && !getPackage().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i2 = 0; i2 < getClass_Count(); i2++) {
                    if (!getClass_(i2).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.d0(1, this.strings_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.d0(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.d0(3, this.package_);
            }
            for (int i2 = 0; i2 < this.class__.size(); i2++) {
                codedOutputStream.d0(4, this.class__.get(i2));
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(PackageFragment packageFragment) {
            return newBuilder().h(packageFragment);
        }

        @Override // h.p2.b0.g.t.i.o
        public PackageFragment getDefaultInstanceForType() {
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

        private PackageFragment(GeneratedMessageLite.c<PackageFragment, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.g();
        }

        private PackageFragment(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private PackageFragment(e eVar, f fVar) throws InvalidProtocolBufferException {
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
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 10) {
                                    StringTable.b builder = (this.bitField0_ & 1) == 1 ? this.strings_.toBuilder() : null;
                                    StringTable stringTable = (StringTable) eVar.u(StringTable.PARSER, fVar);
                                    this.strings_ = stringTable;
                                    if (builder != null) {
                                        builder.h(stringTable);
                                        this.strings_ = builder.m();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (K == 18) {
                                    QualifiedNameTable.b builder2 = (this.bitField0_ & 2) == 2 ? this.qualifiedNames_.toBuilder() : null;
                                    QualifiedNameTable qualifiedNameTable = (QualifiedNameTable) eVar.u(QualifiedNameTable.PARSER, fVar);
                                    this.qualifiedNames_ = qualifiedNameTable;
                                    if (builder2 != null) {
                                        builder2.h(qualifiedNameTable);
                                        this.qualifiedNames_ = builder2.m();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (K == 26) {
                                    Package.b builder3 = (this.bitField0_ & 4) == 4 ? this.package_.toBuilder() : null;
                                    Package r6 = (Package) eVar.u(Package.PARSER, fVar);
                                    this.package_ = r6;
                                    if (builder3 != null) {
                                        builder3.h(r6);
                                        this.package_ = builder3.s();
                                    }
                                    this.bitField0_ |= 4;
                                } else if (K != 34) {
                                    if (!parseUnknownField(eVar, J, fVar, K)) {
                                    }
                                } else {
                                    if (!(z2 & true)) {
                                        this.class__ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.class__.add(eVar.u(Class.PARSER, fVar));
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.class__ = Collections.unmodifiableList(this.class__);
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
                this.class__ = Collections.unmodifiableList(this.class__);
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
    public static final class Property extends GeneratedMessageLite.ExtendableMessage<Property> implements m {
        public static p<Property> PARSER = new a();
        private static final Property defaultInstance;
        private int bitField0_;
        private int flags_;
        private int getterFlags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private int setterFlags_;
        private ValueParameter setterValueParameter_;
        private List<TypeParameter> typeParameter_;
        private final d unknownFields;
        private List<Integer> versionRequirement_;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<Property> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public Property c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new Property(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.c<Property, b> implements m {

            /* renamed from: d */
            private int f16643d;

            /* renamed from: g */
            private int f16646g;

            /* renamed from: i */
            private int f16648i;

            /* renamed from: l */
            private int f16651l;
            private int n;
            private int o;

            /* renamed from: e */
            private int f16644e = 518;

            /* renamed from: f */
            private int f16645f = NativeConstants.SSL_SIGN_RSA_PSS_RSAE_SHA512;

            /* renamed from: h */
            private Type f16647h = Type.getDefaultInstance();

            /* renamed from: j */
            private List<TypeParameter> f16649j = Collections.emptyList();

            /* renamed from: k */
            private Type f16650k = Type.getDefaultInstance();

            /* renamed from: m */
            private ValueParameter f16652m = ValueParameter.getDefaultInstance();
            private List<Integer> p = Collections.emptyList();

            private b() {
                H();
            }

            private void H() {
            }

            public static b u() {
                return new b();
            }

            private void v() {
                if ((this.f16643d & 32) != 32) {
                    this.f16649j = new ArrayList(this.f16649j);
                    this.f16643d |= 32;
                }
            }

            private void w() {
                if ((this.f16643d & 2048) != 2048) {
                    this.p = new ArrayList(this.p);
                    this.f16643d |= 2048;
                }
            }

            public ValueParameter A() {
                return this.f16652m;
            }

            public TypeParameter B(int i2) {
                return this.f16649j.get(i2);
            }

            public int C() {
                return this.f16649j.size();
            }

            public boolean D() {
                return (this.f16643d & 4) == 4;
            }

            public boolean E() {
                return (this.f16643d & 64) == 64;
            }

            public boolean F() {
                return (this.f16643d & 8) == 8;
            }

            public boolean G() {
                return (this.f16643d & 256) == 256;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: I */
            public b h(Property property) {
                if (property == Property.getDefaultInstance()) {
                    return this;
                }
                if (property.hasFlags()) {
                    N(property.getFlags());
                }
                if (property.hasOldFlags()) {
                    Q(property.getOldFlags());
                }
                if (property.hasName()) {
                    P(property.getName());
                }
                if (property.hasReturnType()) {
                    L(property.getReturnType());
                }
                if (property.hasReturnTypeId()) {
                    S(property.getReturnTypeId());
                }
                if (!property.typeParameter_.isEmpty()) {
                    if (this.f16649j.isEmpty()) {
                        this.f16649j = property.typeParameter_;
                        this.f16643d &= -33;
                    } else {
                        v();
                        this.f16649j.addAll(property.typeParameter_);
                    }
                }
                if (property.hasReceiverType()) {
                    K(property.getReceiverType());
                }
                if (property.hasReceiverTypeId()) {
                    R(property.getReceiverTypeId());
                }
                if (property.hasSetterValueParameter()) {
                    M(property.getSetterValueParameter());
                }
                if (property.hasGetterFlags()) {
                    O(property.getGetterFlags());
                }
                if (property.hasSetterFlags()) {
                    T(property.getSetterFlags());
                }
                if (!property.versionRequirement_.isEmpty()) {
                    if (this.p.isEmpty()) {
                        this.p = property.versionRequirement_;
                        this.f16643d &= -2049;
                    } else {
                        w();
                        this.p.addAll(property.versionRequirement_);
                    }
                }
                p(property);
                j(g().b(property.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: J */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property$b");
            }

            public b K(Type type) {
                if ((this.f16643d & 64) == 64 && this.f16650k != Type.getDefaultInstance()) {
                    this.f16650k = Type.newBuilder(this.f16650k).h(type).s();
                } else {
                    this.f16650k = type;
                }
                this.f16643d |= 64;
                return this;
            }

            public b L(Type type) {
                if ((this.f16643d & 8) == 8 && this.f16647h != Type.getDefaultInstance()) {
                    this.f16647h = Type.newBuilder(this.f16647h).h(type).s();
                } else {
                    this.f16647h = type;
                }
                this.f16643d |= 8;
                return this;
            }

            public b M(ValueParameter valueParameter) {
                if ((this.f16643d & 256) == 256 && this.f16652m != ValueParameter.getDefaultInstance()) {
                    this.f16652m = ValueParameter.newBuilder(this.f16652m).h(valueParameter).s();
                } else {
                    this.f16652m = valueParameter;
                }
                this.f16643d |= 256;
                return this;
            }

            public b N(int i2) {
                this.f16643d |= 1;
                this.f16644e = i2;
                return this;
            }

            public b O(int i2) {
                this.f16643d |= 512;
                this.n = i2;
                return this;
            }

            public b P(int i2) {
                this.f16643d |= 4;
                this.f16646g = i2;
                return this;
            }

            public b Q(int i2) {
                this.f16643d |= 2;
                this.f16645f = i2;
                return this;
            }

            public b R(int i2) {
                this.f16643d |= 128;
                this.f16651l = i2;
                return this;
            }

            public b S(int i2) {
                this.f16643d |= 16;
                this.f16648i = i2;
                return this;
            }

            public b T(int i2) {
                this.f16643d |= 1024;
                this.o = i2;
                return this;
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                if (D()) {
                    if (!F() || z().isInitialized()) {
                        for (int i2 = 0; i2 < C(); i2++) {
                            if (!B(i2).isInitialized()) {
                                return false;
                            }
                        }
                        if (!E() || y().isInitialized()) {
                            return (!G() || A().isInitialized()) && o();
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: r */
            public Property build() {
                Property s = s();
                if (s.isInitialized()) {
                    return s;
                }
                throw a.AbstractC0459a.c(s);
            }

            public Property s() {
                Property property = new Property(this);
                int i2 = this.f16643d;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                property.flags_ = this.f16644e;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                property.oldFlags_ = this.f16645f;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                property.name_ = this.f16646g;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                property.returnType_ = this.f16647h;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                property.returnTypeId_ = this.f16648i;
                if ((this.f16643d & 32) == 32) {
                    this.f16649j = Collections.unmodifiableList(this.f16649j);
                    this.f16643d &= -33;
                }
                property.typeParameter_ = this.f16649j;
                if ((i2 & 64) == 64) {
                    i3 |= 32;
                }
                property.receiverType_ = this.f16650k;
                if ((i2 & 128) == 128) {
                    i3 |= 64;
                }
                property.receiverTypeId_ = this.f16651l;
                if ((i2 & 256) == 256) {
                    i3 |= 128;
                }
                property.setterValueParameter_ = this.f16652m;
                if ((i2 & 512) == 512) {
                    i3 |= 256;
                }
                property.getterFlags_ = this.n;
                if ((i2 & 1024) == 1024) {
                    i3 |= 512;
                }
                property.setterFlags_ = this.o;
                if ((this.f16643d & 2048) == 2048) {
                    this.p = Collections.unmodifiableList(this.p);
                    this.f16643d &= -2049;
                }
                property.versionRequirement_ = this.p;
                property.bitField0_ = i3;
                return property;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: t */
            public b m() {
                return u().h(s());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: x */
            public Property getDefaultInstanceForType() {
                return Property.getDefaultInstance();
            }

            public Type y() {
                return this.f16650k;
            }

            public Type z() {
                return this.f16647h;
            }
        }

        static {
            Property property = new Property(true);
            defaultInstance = property;
            property.initFields();
        }

        public static Property getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 518;
            this.oldFlags_ = NativeConstants.SSL_SIGN_RSA_PSS_RSAE_SHA512;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.setterValueParameter_ = ValueParameter.getDefaultInstance();
            this.getterFlags_ = 0;
            this.setterFlags_ = 0;
            this.versionRequirement_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.u();
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getGetterFlags() {
            return this.getterFlags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<Property> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.bitField0_ & 2) == 2 ? CodedOutputStream.o(1, this.oldFlags_) + 0 : 0;
            if ((this.bitField0_ & 4) == 4) {
                o += CodedOutputStream.o(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                o += CodedOutputStream.s(3, this.returnType_);
            }
            for (int i3 = 0; i3 < this.typeParameter_.size(); i3++) {
                o += CodedOutputStream.s(4, this.typeParameter_.get(i3));
            }
            if ((this.bitField0_ & 32) == 32) {
                o += CodedOutputStream.s(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                o += CodedOutputStream.s(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                o += CodedOutputStream.o(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                o += CodedOutputStream.o(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                o += CodedOutputStream.o(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                o += CodedOutputStream.o(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                o += CodedOutputStream.o(11, this.flags_);
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.versionRequirement_.size(); i5++) {
                i4 += CodedOutputStream.p(this.versionRequirement_.get(i5).intValue());
            }
            int size = o + i4 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getSetterFlags() {
            return this.setterFlags_;
        }

        public ValueParameter getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        public TypeParameter getTypeParameter(int i2) {
            return this.typeParameter_.get(i2);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasGetterFlags() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasSetterFlags() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean hasSetterValueParameter() {
            return (this.bitField0_ & 128) == 128;
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasReturnType() && !getReturnType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i2 = 0; i2 < getTypeParameterCount(); i2++) {
                    if (!getTypeParameter(i2).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
            }
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.a0(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.d0(3, this.returnType_);
            }
            for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
                codedOutputStream.d0(4, this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.d0(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.d0(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.a0(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.a0(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.a0(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.a0(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(11, this.flags_);
            }
            for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
                codedOutputStream.a0(31, this.versionRequirement_.get(i3).intValue());
            }
            newExtensionWriter.a(19000, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Property property) {
            return newBuilder().h(property);
        }

        @Override // h.p2.b0.g.t.i.o
        public Property getDefaultInstanceForType() {
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

        private Property(GeneratedMessageLite.c<Property, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.g();
        }

        private Property(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
        private Property(e eVar, f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t = d.t();
            CodedOutputStream J = CodedOutputStream.J(t, 1);
            boolean z = false;
            boolean z2 = false;
            while (true) {
                ?? r5 = 2048;
                if (!z) {
                    try {
                        try {
                            try {
                                int K = eVar.K();
                                switch (K) {
                                    case 0:
                                        break;
                                    case 8:
                                        this.bitField0_ |= 2;
                                        this.oldFlags_ = eVar.s();
                                        continue;
                                    case 16:
                                        this.bitField0_ |= 4;
                                        this.name_ = eVar.s();
                                        continue;
                                    case 26:
                                        Type.b builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                                        Type type = (Type) eVar.u(Type.PARSER, fVar);
                                        this.returnType_ = type;
                                        if (builder != null) {
                                            builder.h(type);
                                            this.returnType_ = builder.s();
                                        }
                                        this.bitField0_ |= 8;
                                        continue;
                                    case 34:
                                        if (!(z2 & true)) {
                                            this.typeParameter_ = new ArrayList();
                                            z2 |= true;
                                        }
                                        this.typeParameter_.add(eVar.u(TypeParameter.PARSER, fVar));
                                        continue;
                                    case 42:
                                        Type.b builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                                        Type type2 = (Type) eVar.u(Type.PARSER, fVar);
                                        this.receiverType_ = type2;
                                        if (builder2 != null) {
                                            builder2.h(type2);
                                            this.receiverType_ = builder2.s();
                                        }
                                        this.bitField0_ |= 32;
                                        continue;
                                    case 50:
                                        ValueParameter.b builder3 = (this.bitField0_ & 128) == 128 ? this.setterValueParameter_.toBuilder() : null;
                                        ValueParameter valueParameter = (ValueParameter) eVar.u(ValueParameter.PARSER, fVar);
                                        this.setterValueParameter_ = valueParameter;
                                        if (builder3 != null) {
                                            builder3.h(valueParameter);
                                            this.setterValueParameter_ = builder3.s();
                                        }
                                        this.bitField0_ |= 128;
                                        continue;
                                    case 56:
                                        this.bitField0_ |= 256;
                                        this.getterFlags_ = eVar.s();
                                        continue;
                                    case 64:
                                        this.bitField0_ |= 512;
                                        this.setterFlags_ = eVar.s();
                                        continue;
                                    case 72:
                                        this.bitField0_ |= 16;
                                        this.returnTypeId_ = eVar.s();
                                        continue;
                                    case 80:
                                        this.bitField0_ |= 64;
                                        this.receiverTypeId_ = eVar.s();
                                        continue;
                                    case 88:
                                        this.bitField0_ |= 1;
                                        this.flags_ = eVar.s();
                                        continue;
                                    case 248:
                                        if (!(z2 & true)) {
                                            this.versionRequirement_ = new ArrayList();
                                            z2 |= true;
                                        }
                                        this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                        continue;
                                    case 250:
                                        int j2 = eVar.j(eVar.A());
                                        if (!(z2 & true) && eVar.e() > 0) {
                                            this.versionRequirement_ = new ArrayList();
                                            z2 |= true;
                                        }
                                        while (eVar.e() > 0) {
                                            this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                        }
                                        eVar.i(j2);
                                        continue;
                                        break;
                                    default:
                                        r5 = parseUnknownField(eVar, J, fVar, K);
                                        if (r5 == 0) {
                                            break;
                                        } else {
                                            continue;
                                        }
                                }
                                z = true;
                            } catch (IOException e2) {
                                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                            }
                        } catch (InvalidProtocolBufferException e3) {
                            throw e3.setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        if (z2 & true) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if ((z2 & true) == r5) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                } else {
                    if (z2 & true) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (z2 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class QualifiedNameTable extends GeneratedMessageLite implements o {
        public static p<QualifiedNameTable> PARSER = new a();
        private static final QualifiedNameTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<QualifiedName> qualifiedName_;
        private final d unknownFields;

        /* loaded from: classes3.dex */
        public static final class QualifiedName extends GeneratedMessageLite implements n {
            public static p<QualifiedName> PARSER = new a();
            private static final QualifiedName defaultInstance;
            private int bitField0_;
            private Kind kind_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int parentQualifiedName_;
            private int shortName_;
            private final d unknownFields;

            /* loaded from: classes3.dex */
            public enum Kind implements h.a {
                CLASS(0, 0),
                PACKAGE(1, 1),
                LOCAL(2, 2);
                
                private static h.b<Kind> internalValueMap = new a();
                private final int value;

                /* loaded from: classes3.dex */
                public static class a implements h.b<Kind> {
                    @Override // h.p2.b0.g.t.i.h.b
                    /* renamed from: b */
                    public Kind a(int i2) {
                        return Kind.valueOf(i2);
                    }
                }

                Kind(int i2, int i3) {
                    this.value = i3;
                }

                @Override // h.p2.b0.g.t.i.h.a
                public final int getNumber() {
                    return this.value;
                }

                public static Kind valueOf(int i2) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                return null;
                            }
                            return LOCAL;
                        }
                        return PACKAGE;
                    }
                    return CLASS;
                }
            }

            /* loaded from: classes3.dex */
            public static class a extends h.p2.b0.g.t.i.b<QualifiedName> {
                @Override // h.p2.b0.g.t.i.p
                /* renamed from: m */
                public QualifiedName c(e eVar, f fVar) throws InvalidProtocolBufferException {
                    return new QualifiedName(eVar, fVar);
                }
            }

            /* loaded from: classes3.dex */
            public static final class b extends GeneratedMessageLite.b<QualifiedName, b> implements n {
                private int b;

                /* renamed from: d */
                private int f16654d;

                /* renamed from: c */
                private int f16653c = -1;

                /* renamed from: e */
                private Kind f16655e = Kind.PACKAGE;

                private b() {
                    r();
                }

                public static b o() {
                    return new b();
                }

                private void r() {
                }

                @Override // h.p2.b0.g.t.i.o
                public final boolean isInitialized() {
                    return q();
                }

                @Override // h.p2.b0.g.t.i.n.a
                /* renamed from: l */
                public QualifiedName build() {
                    QualifiedName m2 = m();
                    if (m2.isInitialized()) {
                        return m2;
                    }
                    throw a.AbstractC0459a.c(m2);
                }

                public QualifiedName m() {
                    QualifiedName qualifiedName = new QualifiedName(this);
                    int i2 = this.b;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    qualifiedName.parentQualifiedName_ = this.f16653c;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    qualifiedName.shortName_ = this.f16654d;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    qualifiedName.kind_ = this.f16655e;
                    qualifiedName.bitField0_ = i3;
                    return qualifiedName;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: n */
                public b e() {
                    return o().h(m());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
                /* renamed from: p */
                public QualifiedName getDefaultInstanceForType() {
                    return QualifiedName.getDefaultInstance();
                }

                public boolean q() {
                    return (this.b & 2) == 2;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: s */
                public b h(QualifiedName qualifiedName) {
                    if (qualifiedName == QualifiedName.getDefaultInstance()) {
                        return this;
                    }
                    if (qualifiedName.hasParentQualifiedName()) {
                        v(qualifiedName.getParentQualifiedName());
                    }
                    if (qualifiedName.hasShortName()) {
                        w(qualifiedName.getShortName());
                    }
                    if (qualifiedName.hasKind()) {
                        u(qualifiedName.getKind());
                    }
                    j(g().b(qualifiedName.unknownFields));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
                @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
                /* renamed from: t */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName$b");
                }

                public b u(Kind kind) {
                    Objects.requireNonNull(kind);
                    this.b |= 4;
                    this.f16655e = kind;
                    return this;
                }

                public b v(int i2) {
                    this.b |= 1;
                    this.f16653c = i2;
                    return this;
                }

                public b w(int i2) {
                    this.b |= 2;
                    this.f16654d = i2;
                    return this;
                }
            }

            static {
                QualifiedName qualifiedName = new QualifiedName(true);
                defaultInstance = qualifiedName;
                qualifiedName.initFields();
            }

            public static QualifiedName getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.parentQualifiedName_ = -1;
                this.shortName_ = 0;
                this.kind_ = Kind.PACKAGE;
            }

            public static b newBuilder() {
                return b.o();
            }

            public Kind getKind() {
                return this.kind_;
            }

            public int getParentQualifiedName() {
                return this.parentQualifiedName_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
            public p<QualifiedName> getParserForType() {
                return PARSER;
            }

            @Override // h.p2.b0.g.t.i.n
            public int getSerializedSize() {
                int i2 = this.memoizedSerializedSize;
                if (i2 != -1) {
                    return i2;
                }
                int o = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.o(1, this.parentQualifiedName_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    o += CodedOutputStream.o(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    o += CodedOutputStream.h(3, this.kind_.getNumber());
                }
                int size = o + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public int getShortName() {
                return this.shortName_;
            }

            public boolean hasKind() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasParentQualifiedName() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasShortName() {
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
                if (!hasShortName()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // h.p2.b0.g.t.i.n
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.a0(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.a0(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.S(3, this.kind_.getNumber());
                }
                codedOutputStream.i0(this.unknownFields);
            }

            public static b newBuilder(QualifiedName qualifiedName) {
                return newBuilder().h(qualifiedName);
            }

            @Override // h.p2.b0.g.t.i.o
            public QualifiedName getDefaultInstanceForType() {
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

            private QualifiedName(GeneratedMessageLite.b bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.g();
            }

            private QualifiedName(boolean z) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = d.a;
            }

            private QualifiedName(e eVar, f fVar) throws InvalidProtocolBufferException {
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
                                    this.parentQualifiedName_ = eVar.s();
                                } else if (K == 16) {
                                    this.bitField0_ |= 2;
                                    this.shortName_ = eVar.s();
                                } else if (K != 24) {
                                    if (!parseUnknownField(eVar, J, fVar, K)) {
                                    }
                                } else {
                                    int n = eVar.n();
                                    Kind valueOf = Kind.valueOf(n);
                                    if (valueOf == null) {
                                        J.o0(K);
                                        J.o0(n);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.kind_ = valueOf;
                                    }
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
        public static class a extends h.p2.b0.g.t.i.b<QualifiedNameTable> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public QualifiedNameTable c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new QualifiedNameTable(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.b<QualifiedNameTable, b> implements o {
            private int b;

            /* renamed from: c */
            private List<QualifiedName> f16656c = Collections.emptyList();

            private b() {
                t();
            }

            public static b o() {
                return new b();
            }

            private void p() {
                if ((this.b & 1) != 1) {
                    this.f16656c = new ArrayList(this.f16656c);
                    this.b |= 1;
                }
            }

            private void t() {
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < s(); i2++) {
                    if (!r(i2).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: l */
            public QualifiedNameTable build() {
                QualifiedNameTable m2 = m();
                if (m2.isInitialized()) {
                    return m2;
                }
                throw a.AbstractC0459a.c(m2);
            }

            public QualifiedNameTable m() {
                QualifiedNameTable qualifiedNameTable = new QualifiedNameTable(this);
                if ((this.b & 1) == 1) {
                    this.f16656c = Collections.unmodifiableList(this.f16656c);
                    this.b &= -2;
                }
                qualifiedNameTable.qualifiedName_ = this.f16656c;
                return qualifiedNameTable;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: n */
            public b e() {
                return o().h(m());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: q */
            public QualifiedNameTable getDefaultInstanceForType() {
                return QualifiedNameTable.getDefaultInstance();
            }

            public QualifiedName r(int i2) {
                return this.f16656c.get(i2);
            }

            public int s() {
                return this.f16656c.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: u */
            public b h(QualifiedNameTable qualifiedNameTable) {
                if (qualifiedNameTable == QualifiedNameTable.getDefaultInstance()) {
                    return this;
                }
                if (!qualifiedNameTable.qualifiedName_.isEmpty()) {
                    if (this.f16656c.isEmpty()) {
                        this.f16656c = qualifiedNameTable.qualifiedName_;
                        this.b &= -2;
                    } else {
                        p();
                        this.f16656c.addAll(qualifiedNameTable.qualifiedName_);
                    }
                }
                j(g().b(qualifiedNameTable.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: v */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$b");
            }
        }

        static {
            QualifiedNameTable qualifiedNameTable = new QualifiedNameTable(true);
            defaultInstance = qualifiedNameTable;
            qualifiedNameTable.initFields();
        }

        public static QualifiedNameTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.qualifiedName_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.o();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<QualifiedNameTable> getParserForType() {
            return PARSER;
        }

        public QualifiedName getQualifiedName(int i2) {
            return this.qualifiedName_.get(i2);
        }

        public int getQualifiedNameCount() {
            return this.qualifiedName_.size();
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.qualifiedName_.size(); i4++) {
                i3 += CodedOutputStream.s(1, this.qualifiedName_.get(i4));
            }
            int size = i3 + this.unknownFields.size();
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
            for (int i2 = 0; i2 < getQualifiedNameCount(); i2++) {
                if (!getQualifiedName(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i2 = 0; i2 < this.qualifiedName_.size(); i2++) {
                codedOutputStream.d0(1, this.qualifiedName_.get(i2));
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(QualifiedNameTable qualifiedNameTable) {
            return newBuilder().h(qualifiedNameTable);
        }

        @Override // h.p2.b0.g.t.i.o
        public QualifiedNameTable getDefaultInstanceForType() {
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

        private QualifiedNameTable(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.g();
        }

        private QualifiedNameTable(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private QualifiedNameTable(e eVar, f fVar) throws InvalidProtocolBufferException {
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
                            if (K != 10) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                if (!(z2 & true)) {
                                    this.qualifiedName_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.qualifiedName_.add(eVar.u(QualifiedName.PARSER, fVar));
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
                        this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
    public static final class StringTable extends GeneratedMessageLite implements h.p2.b0.g.t.f.p {
        public static p<StringTable> PARSER = new a();
        private static final StringTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private h.p2.b0.g.t.i.l string_;
        private final d unknownFields;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<StringTable> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public StringTable c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new StringTable(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.b<StringTable, b> implements h.p2.b0.g.t.f.p {
            private int b;

            /* renamed from: c */
            private h.p2.b0.g.t.i.l f16657c = h.p2.b0.g.t.i.k.b;

            private b() {
                r();
            }

            public static b o() {
                return new b();
            }

            private void p() {
                if ((this.b & 1) != 1) {
                    this.f16657c = new h.p2.b0.g.t.i.k(this.f16657c);
                    this.b |= 1;
                }
            }

            private void r() {
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                return true;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: l */
            public StringTable build() {
                StringTable m2 = m();
                if (m2.isInitialized()) {
                    return m2;
                }
                throw a.AbstractC0459a.c(m2);
            }

            public StringTable m() {
                StringTable stringTable = new StringTable(this);
                if ((this.b & 1) == 1) {
                    this.f16657c = this.f16657c.o();
                    this.b &= -2;
                }
                stringTable.string_ = this.f16657c;
                return stringTable;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: n */
            public b e() {
                return o().h(m());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: q */
            public StringTable getDefaultInstanceForType() {
                return StringTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s */
            public b h(StringTable stringTable) {
                if (stringTable == StringTable.getDefaultInstance()) {
                    return this;
                }
                if (!stringTable.string_.isEmpty()) {
                    if (this.f16657c.isEmpty()) {
                        this.f16657c = stringTable.string_;
                        this.b &= -2;
                    } else {
                        p();
                        this.f16657c.addAll(stringTable.string_);
                    }
                }
                j(g().b(stringTable.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: t */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable$b");
            }
        }

        static {
            StringTable stringTable = new StringTable(true);
            defaultInstance = stringTable;
            stringTable.initFields();
        }

        public static StringTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.string_ = h.p2.b0.g.t.i.k.b;
        }

        public static b newBuilder() {
            return b.o();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<StringTable> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.string_.size(); i4++) {
                i3 += CodedOutputStream.e(this.string_.k(i4));
            }
            int size = 0 + i3 + (getStringList().size() * 1) + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public String getString(int i2) {
            return this.string_.get(i2);
        }

        public q getStringList() {
            return this.string_;
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
            for (int i2 = 0; i2 < this.string_.size(); i2++) {
                codedOutputStream.O(1, this.string_.k(i2));
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(StringTable stringTable) {
            return newBuilder().h(stringTable);
        }

        @Override // h.p2.b0.g.t.i.o
        public StringTable getDefaultInstanceForType() {
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

        private StringTable(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.g();
        }

        private StringTable(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        private StringTable(e eVar, f fVar) throws InvalidProtocolBufferException {
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
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K != 10) {
                                    if (!parseUnknownField(eVar, J, fVar, K)) {
                                    }
                                } else {
                                    d l2 = eVar.l();
                                    if (!(z2 & true)) {
                                        this.string_ = new h.p2.b0.g.t.i.k();
                                        z2 |= true;
                                    }
                                    this.string_.l(l2);
                                }
                            }
                            z = true;
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw e3.setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.string_ = this.string_.o();
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
                this.string_ = this.string_.o();
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
    public static final class Type extends GeneratedMessageLite.ExtendableMessage<Type> implements s {
        public static p<Type> PARSER = new a();
        private static final Type defaultInstance;
        private int abbreviatedTypeId_;
        private Type abbreviatedType_;
        private List<Argument> argument_;
        private int bitField0_;
        private int className_;
        private int flags_;
        private int flexibleTypeCapabilitiesId_;
        private int flexibleUpperBoundId_;
        private Type flexibleUpperBound_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean nullable_;
        private int outerTypeId_;
        private Type outerType_;
        private int typeAliasName_;
        private int typeParameterName_;
        private int typeParameter_;
        private final d unknownFields;

        /* loaded from: classes3.dex */
        public static final class Argument extends GeneratedMessageLite implements h.p2.b0.g.t.f.q {
            public static p<Argument> PARSER = new a();
            private static final Argument defaultInstance;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Projection projection_;
            private int typeId_;
            private Type type_;
            private final d unknownFields;

            /* loaded from: classes3.dex */
            public enum Projection implements h.a {
                IN(0, 0),
                OUT(1, 1),
                INV(2, 2),
                STAR(3, 3);
                
                private static h.b<Projection> internalValueMap = new a();
                private final int value;

                /* loaded from: classes3.dex */
                public static class a implements h.b<Projection> {
                    @Override // h.p2.b0.g.t.i.h.b
                    /* renamed from: b */
                    public Projection a(int i2) {
                        return Projection.valueOf(i2);
                    }
                }

                Projection(int i2, int i3) {
                    this.value = i3;
                }

                @Override // h.p2.b0.g.t.i.h.a
                public final int getNumber() {
                    return this.value;
                }

                public static Projection valueOf(int i2) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    return null;
                                }
                                return STAR;
                            }
                            return INV;
                        }
                        return OUT;
                    }
                    return IN;
                }
            }

            /* loaded from: classes3.dex */
            public static class a extends h.p2.b0.g.t.i.b<Argument> {
                @Override // h.p2.b0.g.t.i.p
                /* renamed from: m */
                public Argument c(e eVar, f fVar) throws InvalidProtocolBufferException {
                    return new Argument(eVar, fVar);
                }
            }

            /* loaded from: classes3.dex */
            public static final class b extends GeneratedMessageLite.b<Argument, b> implements h.p2.b0.g.t.f.q {
                private int b;

                /* renamed from: c */
                private Projection f16658c = Projection.INV;

                /* renamed from: d */
                private Type f16659d = Type.getDefaultInstance();

                /* renamed from: e */
                private int f16660e;

                private b() {
                    r();
                }

                public static b o() {
                    return new b();
                }

                private void r() {
                }

                public Type getType() {
                    return this.f16659d;
                }

                @Override // h.p2.b0.g.t.i.o
                public final boolean isInitialized() {
                    return !q() || getType().isInitialized();
                }

                @Override // h.p2.b0.g.t.i.n.a
                /* renamed from: l */
                public Argument build() {
                    Argument m2 = m();
                    if (m2.isInitialized()) {
                        return m2;
                    }
                    throw a.AbstractC0459a.c(m2);
                }

                public Argument m() {
                    Argument argument = new Argument(this);
                    int i2 = this.b;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    argument.projection_ = this.f16658c;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    argument.type_ = this.f16659d;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    argument.typeId_ = this.f16660e;
                    argument.bitField0_ = i3;
                    return argument;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: n */
                public b e() {
                    return o().h(m());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
                /* renamed from: p */
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                public boolean q() {
                    return (this.b & 2) == 2;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: s */
                public b h(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasProjection()) {
                        v(argument.getProjection());
                    }
                    if (argument.hasType()) {
                        u(argument.getType());
                    }
                    if (argument.hasTypeId()) {
                        w(argument.getTypeId());
                    }
                    j(g().b(argument.unknownFields));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
                @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
                /* renamed from: t */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument$b");
                }

                public b u(Type type) {
                    if ((this.b & 2) == 2 && this.f16659d != Type.getDefaultInstance()) {
                        this.f16659d = Type.newBuilder(this.f16659d).h(type).s();
                    } else {
                        this.f16659d = type;
                    }
                    this.b |= 2;
                    return this;
                }

                public b v(Projection projection) {
                    Objects.requireNonNull(projection);
                    this.b |= 1;
                    this.f16658c = projection;
                    return this;
                }

                public b w(int i2) {
                    this.b |= 4;
                    this.f16660e = i2;
                    return this;
                }
            }

            static {
                Argument argument = new Argument(true);
                defaultInstance = argument;
                argument.initFields();
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.projection_ = Projection.INV;
                this.type_ = Type.getDefaultInstance();
                this.typeId_ = 0;
            }

            public static b newBuilder() {
                return b.o();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
            public p<Argument> getParserForType() {
                return PARSER;
            }

            public Projection getProjection() {
                return this.projection_;
            }

            @Override // h.p2.b0.g.t.i.n
            public int getSerializedSize() {
                int i2 = this.memoizedSerializedSize;
                if (i2 != -1) {
                    return i2;
                }
                int h2 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.h(1, this.projection_.getNumber()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    h2 += CodedOutputStream.s(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    h2 += CodedOutputStream.o(3, this.typeId_);
                }
                int size = h2 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public Type getType() {
                return this.type_;
            }

            public int getTypeId() {
                return this.typeId_;
            }

            public boolean hasProjection() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasType() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasTypeId() {
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
                if (hasType() && !getType().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // h.p2.b0.g.t.i.n
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.S(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.d0(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.a0(3, this.typeId_);
                }
                codedOutputStream.i0(this.unknownFields);
            }

            public static b newBuilder(Argument argument) {
                return newBuilder().h(argument);
            }

            @Override // h.p2.b0.g.t.i.o
            public Argument getDefaultInstanceForType() {
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

            private Argument(GeneratedMessageLite.b bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.g();
            }

            private Argument(boolean z) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = d.a;
            }

            private Argument(e eVar, f fVar) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                d.b t = d.t();
                CodedOutputStream J = CodedOutputStream.J(t, 1);
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            try {
                                int K = eVar.K();
                                if (K != 0) {
                                    if (K == 8) {
                                        int n = eVar.n();
                                        Projection valueOf = Projection.valueOf(n);
                                        if (valueOf == null) {
                                            J.o0(K);
                                            J.o0(n);
                                        } else {
                                            this.bitField0_ |= 1;
                                            this.projection_ = valueOf;
                                        }
                                    } else if (K == 18) {
                                        b builder = (this.bitField0_ & 2) == 2 ? this.type_.toBuilder() : null;
                                        Type type = (Type) eVar.u(Type.PARSER, fVar);
                                        this.type_ = type;
                                        if (builder != null) {
                                            builder.h(type);
                                            this.type_ = builder.s();
                                        }
                                        this.bitField0_ |= 2;
                                    } else if (K != 24) {
                                        if (!parseUnknownField(eVar, J, fVar, K)) {
                                        }
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.typeId_ = eVar.s();
                                    }
                                }
                                z = true;
                            } catch (IOException e2) {
                                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                            }
                        } catch (InvalidProtocolBufferException e3) {
                            throw e3.setUnfinishedMessage(this);
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
        public static class a extends h.p2.b0.g.t.i.b<Type> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public Type c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new Type(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.c<Type, b> implements s {

            /* renamed from: d */
            private int f16661d;

            /* renamed from: f */
            private boolean f16663f;

            /* renamed from: g */
            private int f16664g;

            /* renamed from: i */
            private int f16666i;

            /* renamed from: j */
            private int f16667j;

            /* renamed from: k */
            private int f16668k;

            /* renamed from: l */
            private int f16669l;

            /* renamed from: m */
            private int f16670m;
            private int o;
            private int q;
            private int r;

            /* renamed from: e */
            private List<Argument> f16662e = Collections.emptyList();

            /* renamed from: h */
            private Type f16665h = Type.getDefaultInstance();
            private Type n = Type.getDefaultInstance();
            private Type p = Type.getDefaultInstance();

            private b() {
                F();
            }

            private void F() {
            }

            public static b u() {
                return new b();
            }

            private void v() {
                if ((this.f16661d & 1) != 1) {
                    this.f16662e = new ArrayList(this.f16662e);
                    this.f16661d |= 1;
                }
            }

            public Type A() {
                return this.f16665h;
            }

            public Type B() {
                return this.n;
            }

            public boolean C() {
                return (this.f16661d & 2048) == 2048;
            }

            public boolean D() {
                return (this.f16661d & 8) == 8;
            }

            public boolean E() {
                return (this.f16661d & 512) == 512;
            }

            public b G(Type type) {
                if ((this.f16661d & 2048) == 2048 && this.p != Type.getDefaultInstance()) {
                    this.p = Type.newBuilder(this.p).h(type).s();
                } else {
                    this.p = type;
                }
                this.f16661d |= 2048;
                return this;
            }

            public b H(Type type) {
                if ((this.f16661d & 8) == 8 && this.f16665h != Type.getDefaultInstance()) {
                    this.f16665h = Type.newBuilder(this.f16665h).h(type).s();
                } else {
                    this.f16665h = type;
                }
                this.f16661d |= 8;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: I */
            public b h(Type type) {
                if (type == Type.getDefaultInstance()) {
                    return this;
                }
                if (!type.argument_.isEmpty()) {
                    if (this.f16662e.isEmpty()) {
                        this.f16662e = type.argument_;
                        this.f16661d &= -2;
                    } else {
                        v();
                        this.f16662e.addAll(type.argument_);
                    }
                }
                if (type.hasNullable()) {
                    Q(type.getNullable());
                }
                if (type.hasFlexibleTypeCapabilitiesId()) {
                    O(type.getFlexibleTypeCapabilitiesId());
                }
                if (type.hasFlexibleUpperBound()) {
                    H(type.getFlexibleUpperBound());
                }
                if (type.hasFlexibleUpperBoundId()) {
                    P(type.getFlexibleUpperBoundId());
                }
                if (type.hasClassName()) {
                    M(type.getClassName());
                }
                if (type.hasTypeParameter()) {
                    T(type.getTypeParameter());
                }
                if (type.hasTypeParameterName()) {
                    U(type.getTypeParameterName());
                }
                if (type.hasTypeAliasName()) {
                    S(type.getTypeAliasName());
                }
                if (type.hasOuterType()) {
                    K(type.getOuterType());
                }
                if (type.hasOuterTypeId()) {
                    R(type.getOuterTypeId());
                }
                if (type.hasAbbreviatedType()) {
                    G(type.getAbbreviatedType());
                }
                if (type.hasAbbreviatedTypeId()) {
                    L(type.getAbbreviatedTypeId());
                }
                if (type.hasFlags()) {
                    N(type.getFlags());
                }
                p(type);
                j(g().b(type.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: J */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$b");
            }

            public b K(Type type) {
                if ((this.f16661d & 512) == 512 && this.n != Type.getDefaultInstance()) {
                    this.n = Type.newBuilder(this.n).h(type).s();
                } else {
                    this.n = type;
                }
                this.f16661d |= 512;
                return this;
            }

            public b L(int i2) {
                this.f16661d |= 4096;
                this.q = i2;
                return this;
            }

            public b M(int i2) {
                this.f16661d |= 32;
                this.f16667j = i2;
                return this;
            }

            public b N(int i2) {
                this.f16661d |= 8192;
                this.r = i2;
                return this;
            }

            public b O(int i2) {
                this.f16661d |= 4;
                this.f16664g = i2;
                return this;
            }

            public b P(int i2) {
                this.f16661d |= 16;
                this.f16666i = i2;
                return this;
            }

            public b Q(boolean z) {
                this.f16661d |= 2;
                this.f16663f = z;
                return this;
            }

            public b R(int i2) {
                this.f16661d |= 1024;
                this.o = i2;
                return this;
            }

            public b S(int i2) {
                this.f16661d |= 256;
                this.f16670m = i2;
                return this;
            }

            public b T(int i2) {
                this.f16661d |= 64;
                this.f16668k = i2;
                return this;
            }

            public b U(int i2) {
                this.f16661d |= 128;
                this.f16669l = i2;
                return this;
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < y(); i2++) {
                    if (!x(i2).isInitialized()) {
                        return false;
                    }
                }
                if (!D() || A().isInitialized()) {
                    if (!E() || B().isInitialized()) {
                        return (!C() || w().isInitialized()) && o();
                    }
                    return false;
                }
                return false;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: r */
            public Type build() {
                Type s = s();
                if (s.isInitialized()) {
                    return s;
                }
                throw a.AbstractC0459a.c(s);
            }

            public Type s() {
                Type type = new Type(this);
                int i2 = this.f16661d;
                if ((i2 & 1) == 1) {
                    this.f16662e = Collections.unmodifiableList(this.f16662e);
                    this.f16661d &= -2;
                }
                type.argument_ = this.f16662e;
                int i3 = (i2 & 2) != 2 ? 0 : 1;
                type.nullable_ = this.f16663f;
                if ((i2 & 4) == 4) {
                    i3 |= 2;
                }
                type.flexibleTypeCapabilitiesId_ = this.f16664g;
                if ((i2 & 8) == 8) {
                    i3 |= 4;
                }
                type.flexibleUpperBound_ = this.f16665h;
                if ((i2 & 16) == 16) {
                    i3 |= 8;
                }
                type.flexibleUpperBoundId_ = this.f16666i;
                if ((i2 & 32) == 32) {
                    i3 |= 16;
                }
                type.className_ = this.f16667j;
                if ((i2 & 64) == 64) {
                    i3 |= 32;
                }
                type.typeParameter_ = this.f16668k;
                if ((i2 & 128) == 128) {
                    i3 |= 64;
                }
                type.typeParameterName_ = this.f16669l;
                if ((i2 & 256) == 256) {
                    i3 |= 128;
                }
                type.typeAliasName_ = this.f16670m;
                if ((i2 & 512) == 512) {
                    i3 |= 256;
                }
                type.outerType_ = this.n;
                if ((i2 & 1024) == 1024) {
                    i3 |= 512;
                }
                type.outerTypeId_ = this.o;
                if ((i2 & 2048) == 2048) {
                    i3 |= 1024;
                }
                type.abbreviatedType_ = this.p;
                if ((i2 & 4096) == 4096) {
                    i3 |= 2048;
                }
                type.abbreviatedTypeId_ = this.q;
                if ((i2 & 8192) == 8192) {
                    i3 |= 4096;
                }
                type.flags_ = this.r;
                type.bitField0_ = i3;
                return type;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: t */
            public b m() {
                return u().h(s());
            }

            public Type w() {
                return this.p;
            }

            public Argument x(int i2) {
                return this.f16662e.get(i2);
            }

            public int y() {
                return this.f16662e.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: z */
            public Type getDefaultInstanceForType() {
                return Type.getDefaultInstance();
            }
        }

        static {
            Type type = new Type(true);
            defaultInstance = type;
            type.initFields();
        }

        public static Type getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.argument_ = Collections.emptyList();
            this.nullable_ = false;
            this.flexibleTypeCapabilitiesId_ = 0;
            this.flexibleUpperBound_ = getDefaultInstance();
            this.flexibleUpperBoundId_ = 0;
            this.className_ = 0;
            this.typeParameter_ = 0;
            this.typeParameterName_ = 0;
            this.typeAliasName_ = 0;
            this.outerType_ = getDefaultInstance();
            this.outerTypeId_ = 0;
            this.abbreviatedType_ = getDefaultInstance();
            this.abbreviatedTypeId_ = 0;
            this.flags_ = 0;
        }

        public static b newBuilder() {
            return b.u();
        }

        public Type getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        public int getAbbreviatedTypeId() {
            return this.abbreviatedTypeId_;
        }

        public Argument getArgument(int i2) {
            return this.argument_.get(i2);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getClassName() {
            return this.className_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFlexibleTypeCapabilitiesId() {
            return this.flexibleTypeCapabilitiesId_;
        }

        public Type getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        public int getFlexibleUpperBoundId() {
            return this.flexibleUpperBoundId_;
        }

        public boolean getNullable() {
            return this.nullable_;
        }

        public Type getOuterType() {
            return this.outerType_;
        }

        public int getOuterTypeId() {
            return this.outerTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<Type> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.bitField0_ & 4096) == 4096 ? CodedOutputStream.o(1, this.flags_) + 0 : 0;
            for (int i3 = 0; i3 < this.argument_.size(); i3++) {
                o += CodedOutputStream.s(2, this.argument_.get(i3));
            }
            if ((this.bitField0_ & 1) == 1) {
                o += CodedOutputStream.a(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                o += CodedOutputStream.o(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                o += CodedOutputStream.s(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                o += CodedOutputStream.o(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                o += CodedOutputStream.o(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                o += CodedOutputStream.o(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                o += CodedOutputStream.o(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                o += CodedOutputStream.s(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                o += CodedOutputStream.o(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                o += CodedOutputStream.o(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                o += CodedOutputStream.s(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                o += CodedOutputStream.o(14, this.abbreviatedTypeId_);
            }
            int extensionsSerializedSize = o + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public int getTypeAliasName() {
            return this.typeAliasName_;
        }

        public int getTypeParameter() {
            return this.typeParameter_;
        }

        public int getTypeParameterName() {
            return this.typeParameterName_;
        }

        public boolean hasAbbreviatedType() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public boolean hasAbbreviatedTypeId() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public boolean hasClassName() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public boolean hasFlexibleTypeCapabilitiesId() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasFlexibleUpperBound() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlexibleUpperBoundId() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasNullable() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasOuterType() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasOuterTypeId() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean hasTypeAliasName() {
            return (this.bitField0_ & 128) == 128;
        }

        public boolean hasTypeParameter() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasTypeParameterName() {
            return (this.bitField0_ & 64) == 64;
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
            for (int i2 = 0; i2 < getArgumentCount(); i2++) {
                if (!getArgument(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasOuterType() && !getOuterType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasAbbreviatedType() && !getAbbreviatedType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.a0(1, this.flags_);
            }
            for (int i2 = 0; i2 < this.argument_.size(); i2++) {
                codedOutputStream.d0(2, this.argument_.get(i2));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.L(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.d0(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.a0(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.a0(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.a0(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.a0(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.d0(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.a0(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.a0(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.d0(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.a0(14, this.abbreviatedTypeId_);
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Type type) {
            return newBuilder().h(type);
        }

        @Override // h.p2.b0.g.t.i.o
        public Type getDefaultInstanceForType() {
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

        private Type(GeneratedMessageLite.c<Type, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.g();
        }

        private Type(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Type(e eVar, f fVar) throws InvalidProtocolBufferException {
            b builder;
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
                        switch (K) {
                            case 0:
                                break;
                            case 8:
                                this.bitField0_ |= 4096;
                                this.flags_ = eVar.s();
                                continue;
                            case 18:
                                if (!(z2 & true)) {
                                    this.argument_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.argument_.add(eVar.u(Argument.PARSER, fVar));
                                continue;
                            case 24:
                                this.bitField0_ |= 1;
                                this.nullable_ = eVar.k();
                                continue;
                            case 32:
                                this.bitField0_ |= 2;
                                this.flexibleTypeCapabilitiesId_ = eVar.s();
                                continue;
                            case 42:
                                builder = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.toBuilder() : null;
                                Type type = (Type) eVar.u(PARSER, fVar);
                                this.flexibleUpperBound_ = type;
                                if (builder != null) {
                                    builder.h(type);
                                    this.flexibleUpperBound_ = builder.s();
                                }
                                this.bitField0_ |= 4;
                                continue;
                            case 48:
                                this.bitField0_ |= 16;
                                this.className_ = eVar.s();
                                continue;
                            case 56:
                                this.bitField0_ |= 32;
                                this.typeParameter_ = eVar.s();
                                continue;
                            case 64:
                                this.bitField0_ |= 8;
                                this.flexibleUpperBoundId_ = eVar.s();
                                continue;
                            case 72:
                                this.bitField0_ |= 64;
                                this.typeParameterName_ = eVar.s();
                                continue;
                            case 82:
                                builder = (this.bitField0_ & 256) == 256 ? this.outerType_.toBuilder() : null;
                                Type type2 = (Type) eVar.u(PARSER, fVar);
                                this.outerType_ = type2;
                                if (builder != null) {
                                    builder.h(type2);
                                    this.outerType_ = builder.s();
                                }
                                this.bitField0_ |= 256;
                                continue;
                            case 88:
                                this.bitField0_ |= 512;
                                this.outerTypeId_ = eVar.s();
                                continue;
                            case 96:
                                this.bitField0_ |= 128;
                                this.typeAliasName_ = eVar.s();
                                continue;
                            case 106:
                                builder = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.toBuilder() : null;
                                Type type3 = (Type) eVar.u(PARSER, fVar);
                                this.abbreviatedType_ = type3;
                                if (builder != null) {
                                    builder.h(type3);
                                    this.abbreviatedType_ = builder.s();
                                }
                                this.bitField0_ |= 1024;
                                continue;
                            case 112:
                                this.bitField0_ |= 2048;
                                this.abbreviatedTypeId_ = eVar.s();
                                continue;
                            default:
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                    break;
                                } else {
                                    continue;
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
                        this.argument_ = Collections.unmodifiableList(this.argument_);
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
                this.argument_ = Collections.unmodifiableList(this.argument_);
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
    public static final class TypeAlias extends GeneratedMessageLite.ExtendableMessage<TypeAlias> implements r {
        public static p<TypeAlias> PARSER = new a();
        private static final TypeAlias defaultInstance;
        private List<Annotation> annotation_;
        private int bitField0_;
        private int expandedTypeId_;
        private Type expandedType_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private List<TypeParameter> typeParameter_;
        private int underlyingTypeId_;
        private Type underlyingType_;
        private final d unknownFields;
        private List<Integer> versionRequirement_;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<TypeAlias> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public TypeAlias c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new TypeAlias(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.c<TypeAlias, b> implements r {

            /* renamed from: d */
            private int f16671d;

            /* renamed from: f */
            private int f16673f;

            /* renamed from: i */
            private int f16676i;

            /* renamed from: k */
            private int f16678k;

            /* renamed from: e */
            private int f16672e = 6;

            /* renamed from: g */
            private List<TypeParameter> f16674g = Collections.emptyList();

            /* renamed from: h */
            private Type f16675h = Type.getDefaultInstance();

            /* renamed from: j */
            private Type f16677j = Type.getDefaultInstance();

            /* renamed from: l */
            private List<Annotation> f16679l = Collections.emptyList();

            /* renamed from: m */
            private List<Integer> f16680m = Collections.emptyList();

            private b() {
                I();
            }

            private void I() {
            }

            public static b u() {
                return new b();
            }

            private void v() {
                if ((this.f16671d & 128) != 128) {
                    this.f16679l = new ArrayList(this.f16679l);
                    this.f16671d |= 128;
                }
            }

            private void w() {
                if ((this.f16671d & 4) != 4) {
                    this.f16674g = new ArrayList(this.f16674g);
                    this.f16671d |= 4;
                }
            }

            private void x() {
                if ((this.f16671d & 256) != 256) {
                    this.f16680m = new ArrayList(this.f16680m);
                    this.f16671d |= 256;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: A */
            public TypeAlias getDefaultInstanceForType() {
                return TypeAlias.getDefaultInstance();
            }

            public Type B() {
                return this.f16677j;
            }

            public TypeParameter C(int i2) {
                return this.f16674g.get(i2);
            }

            public int D() {
                return this.f16674g.size();
            }

            public Type E() {
                return this.f16675h;
            }

            public boolean F() {
                return (this.f16671d & 32) == 32;
            }

            public boolean G() {
                return (this.f16671d & 2) == 2;
            }

            public boolean H() {
                return (this.f16671d & 8) == 8;
            }

            public b J(Type type) {
                if ((this.f16671d & 32) == 32 && this.f16677j != Type.getDefaultInstance()) {
                    this.f16677j = Type.newBuilder(this.f16677j).h(type).s();
                } else {
                    this.f16677j = type;
                }
                this.f16671d |= 32;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: K */
            public b h(TypeAlias typeAlias) {
                if (typeAlias == TypeAlias.getDefaultInstance()) {
                    return this;
                }
                if (typeAlias.hasFlags()) {
                    O(typeAlias.getFlags());
                }
                if (typeAlias.hasName()) {
                    P(typeAlias.getName());
                }
                if (!typeAlias.typeParameter_.isEmpty()) {
                    if (this.f16674g.isEmpty()) {
                        this.f16674g = typeAlias.typeParameter_;
                        this.f16671d &= -5;
                    } else {
                        w();
                        this.f16674g.addAll(typeAlias.typeParameter_);
                    }
                }
                if (typeAlias.hasUnderlyingType()) {
                    M(typeAlias.getUnderlyingType());
                }
                if (typeAlias.hasUnderlyingTypeId()) {
                    Q(typeAlias.getUnderlyingTypeId());
                }
                if (typeAlias.hasExpandedType()) {
                    J(typeAlias.getExpandedType());
                }
                if (typeAlias.hasExpandedTypeId()) {
                    N(typeAlias.getExpandedTypeId());
                }
                if (!typeAlias.annotation_.isEmpty()) {
                    if (this.f16679l.isEmpty()) {
                        this.f16679l = typeAlias.annotation_;
                        this.f16671d &= -129;
                    } else {
                        v();
                        this.f16679l.addAll(typeAlias.annotation_);
                    }
                }
                if (!typeAlias.versionRequirement_.isEmpty()) {
                    if (this.f16680m.isEmpty()) {
                        this.f16680m = typeAlias.versionRequirement_;
                        this.f16671d &= -257;
                    } else {
                        x();
                        this.f16680m.addAll(typeAlias.versionRequirement_);
                    }
                }
                p(typeAlias);
                j(g().b(typeAlias.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: L */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias$b");
            }

            public b M(Type type) {
                if ((this.f16671d & 8) == 8 && this.f16675h != Type.getDefaultInstance()) {
                    this.f16675h = Type.newBuilder(this.f16675h).h(type).s();
                } else {
                    this.f16675h = type;
                }
                this.f16671d |= 8;
                return this;
            }

            public b N(int i2) {
                this.f16671d |= 64;
                this.f16678k = i2;
                return this;
            }

            public b O(int i2) {
                this.f16671d |= 1;
                this.f16672e = i2;
                return this;
            }

            public b P(int i2) {
                this.f16671d |= 2;
                this.f16673f = i2;
                return this;
            }

            public b Q(int i2) {
                this.f16671d |= 16;
                this.f16676i = i2;
                return this;
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                if (G()) {
                    for (int i2 = 0; i2 < D(); i2++) {
                        if (!C(i2).isInitialized()) {
                            return false;
                        }
                    }
                    if (!H() || E().isInitialized()) {
                        if (!F() || B().isInitialized()) {
                            for (int i3 = 0; i3 < z(); i3++) {
                                if (!y(i3).isInitialized()) {
                                    return false;
                                }
                            }
                            return o();
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: r */
            public TypeAlias build() {
                TypeAlias s = s();
                if (s.isInitialized()) {
                    return s;
                }
                throw a.AbstractC0459a.c(s);
            }

            public TypeAlias s() {
                TypeAlias typeAlias = new TypeAlias(this);
                int i2 = this.f16671d;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                typeAlias.flags_ = this.f16672e;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                typeAlias.name_ = this.f16673f;
                if ((this.f16671d & 4) == 4) {
                    this.f16674g = Collections.unmodifiableList(this.f16674g);
                    this.f16671d &= -5;
                }
                typeAlias.typeParameter_ = this.f16674g;
                if ((i2 & 8) == 8) {
                    i3 |= 4;
                }
                typeAlias.underlyingType_ = this.f16675h;
                if ((i2 & 16) == 16) {
                    i3 |= 8;
                }
                typeAlias.underlyingTypeId_ = this.f16676i;
                if ((i2 & 32) == 32) {
                    i3 |= 16;
                }
                typeAlias.expandedType_ = this.f16677j;
                if ((i2 & 64) == 64) {
                    i3 |= 32;
                }
                typeAlias.expandedTypeId_ = this.f16678k;
                if ((this.f16671d & 128) == 128) {
                    this.f16679l = Collections.unmodifiableList(this.f16679l);
                    this.f16671d &= -129;
                }
                typeAlias.annotation_ = this.f16679l;
                if ((this.f16671d & 256) == 256) {
                    this.f16680m = Collections.unmodifiableList(this.f16680m);
                    this.f16671d &= -257;
                }
                typeAlias.versionRequirement_ = this.f16680m;
                typeAlias.bitField0_ = i3;
                return typeAlias;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: t */
            public b m() {
                return u().h(s());
            }

            public Annotation y(int i2) {
                return this.f16679l.get(i2);
            }

            public int z() {
                return this.f16679l.size();
            }
        }

        static {
            TypeAlias typeAlias = new TypeAlias(true);
            defaultInstance = typeAlias;
            typeAlias.initFields();
        }

        public static TypeAlias getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.name_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.underlyingType_ = Type.getDefaultInstance();
            this.underlyingTypeId_ = 0;
            this.expandedType_ = Type.getDefaultInstance();
            this.expandedTypeId_ = 0;
            this.annotation_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.u();
        }

        public static TypeAlias parseDelimitedFrom(InputStream inputStream, f fVar) throws IOException {
            return PARSER.d(inputStream, fVar);
        }

        public Annotation getAnnotation(int i2) {
            return this.annotation_.get(i2);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public Type getExpandedType() {
            return this.expandedType_;
        }

        public int getExpandedTypeId() {
            return this.expandedTypeId_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<TypeAlias> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.flags_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                o += CodedOutputStream.o(2, this.name_);
            }
            for (int i3 = 0; i3 < this.typeParameter_.size(); i3++) {
                o += CodedOutputStream.s(3, this.typeParameter_.get(i3));
            }
            if ((this.bitField0_ & 4) == 4) {
                o += CodedOutputStream.s(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                o += CodedOutputStream.o(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                o += CodedOutputStream.s(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                o += CodedOutputStream.o(7, this.expandedTypeId_);
            }
            for (int i4 = 0; i4 < this.annotation_.size(); i4++) {
                o += CodedOutputStream.s(8, this.annotation_.get(i4));
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.versionRequirement_.size(); i6++) {
                i5 += CodedOutputStream.p(this.versionRequirement_.get(i6).intValue());
            }
            int size = o + i5 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public TypeParameter getTypeParameter(int i2) {
            return this.typeParameter_.get(i2);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public Type getUnderlyingType() {
            return this.underlyingType_;
        }

        public int getUnderlyingTypeId() {
            return this.underlyingTypeId_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasExpandedType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasExpandedTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasUnderlyingType() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasUnderlyingTypeId() {
            return (this.bitField0_ & 8) == 8;
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i2 = 0; i2 < getTypeParameterCount(); i2++) {
                if (!getTypeParameter(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasExpandedType() && !getExpandedType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i3 = 0; i3 < getAnnotationCount(); i3++) {
                    if (!getAnnotation(i3).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(2, this.name_);
            }
            for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
                codedOutputStream.d0(3, this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.d0(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.a0(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.d0(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.a0(7, this.expandedTypeId_);
            }
            for (int i3 = 0; i3 < this.annotation_.size(); i3++) {
                codedOutputStream.d0(8, this.annotation_.get(i3));
            }
            for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
                codedOutputStream.a0(31, this.versionRequirement_.get(i4).intValue());
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(TypeAlias typeAlias) {
            return newBuilder().h(typeAlias);
        }

        @Override // h.p2.b0.g.t.i.o
        public TypeAlias getDefaultInstanceForType() {
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

        private TypeAlias(GeneratedMessageLite.c<TypeAlias, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.g();
        }

        private TypeAlias(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
        private TypeAlias(e eVar, f fVar) throws InvalidProtocolBufferException {
            Type.b builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t = d.t();
            CodedOutputStream J = CodedOutputStream.J(t, 1);
            boolean z = false;
            boolean z2 = false;
            while (true) {
                ?? r5 = 128;
                if (!z) {
                    try {
                        try {
                            try {
                                int K = eVar.K();
                                switch (K) {
                                    case 0:
                                        break;
                                    case 8:
                                        this.bitField0_ |= 1;
                                        this.flags_ = eVar.s();
                                        continue;
                                    case 16:
                                        this.bitField0_ |= 2;
                                        this.name_ = eVar.s();
                                        continue;
                                    case 26:
                                        if (!(z2 & true)) {
                                            this.typeParameter_ = new ArrayList();
                                            z2 |= true;
                                        }
                                        this.typeParameter_.add(eVar.u(TypeParameter.PARSER, fVar));
                                        continue;
                                    case 34:
                                        builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : null;
                                        Type type = (Type) eVar.u(Type.PARSER, fVar);
                                        this.underlyingType_ = type;
                                        if (builder != null) {
                                            builder.h(type);
                                            this.underlyingType_ = builder.s();
                                        }
                                        this.bitField0_ |= 4;
                                        continue;
                                    case 40:
                                        this.bitField0_ |= 8;
                                        this.underlyingTypeId_ = eVar.s();
                                        continue;
                                    case 50:
                                        builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : null;
                                        Type type2 = (Type) eVar.u(Type.PARSER, fVar);
                                        this.expandedType_ = type2;
                                        if (builder != null) {
                                            builder.h(type2);
                                            this.expandedType_ = builder.s();
                                        }
                                        this.bitField0_ |= 16;
                                        continue;
                                    case 56:
                                        this.bitField0_ |= 32;
                                        this.expandedTypeId_ = eVar.s();
                                        continue;
                                    case 66:
                                        if (!(z2 & true)) {
                                            this.annotation_ = new ArrayList();
                                            z2 |= true;
                                        }
                                        this.annotation_.add(eVar.u(Annotation.PARSER, fVar));
                                        continue;
                                    case 248:
                                        if (!(z2 & true)) {
                                            this.versionRequirement_ = new ArrayList();
                                            z2 |= true;
                                        }
                                        this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                        continue;
                                    case 250:
                                        int j2 = eVar.j(eVar.A());
                                        if (!(z2 & true) && eVar.e() > 0) {
                                            this.versionRequirement_ = new ArrayList();
                                            z2 |= true;
                                        }
                                        while (eVar.e() > 0) {
                                            this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                        }
                                        eVar.i(j2);
                                        continue;
                                        break;
                                    default:
                                        r5 = parseUnknownField(eVar, J, fVar, K);
                                        if (r5 == 0) {
                                            break;
                                        } else {
                                            continue;
                                        }
                                }
                                z = true;
                            } catch (InvalidProtocolBufferException e2) {
                                throw e2.setUnfinishedMessage(this);
                            }
                        } catch (IOException e3) {
                            throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        if (z2 & true) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if ((z2 & true) == r5) {
                            this.annotation_ = Collections.unmodifiableList(this.annotation_);
                        }
                        if (z2 & true) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                } else {
                    if (z2 & true) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (z2 & true) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    if (z2 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class TypeParameter extends GeneratedMessageLite.ExtendableMessage<TypeParameter> implements t {
        public static p<TypeParameter> PARSER = new a();
        private static final TypeParameter defaultInstance;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private boolean reified_;
        private final d unknownFields;
        private int upperBoundIdMemoizedSerializedSize;
        private List<Integer> upperBoundId_;
        private List<Type> upperBound_;
        private Variance variance_;

        /* loaded from: classes3.dex */
        public enum Variance implements h.a {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2);
            
            private static h.b<Variance> internalValueMap = new a();
            private final int value;

            /* loaded from: classes3.dex */
            public static class a implements h.b<Variance> {
                @Override // h.p2.b0.g.t.i.h.b
                /* renamed from: b */
                public Variance a(int i2) {
                    return Variance.valueOf(i2);
                }
            }

            Variance(int i2, int i3) {
                this.value = i3;
            }

            @Override // h.p2.b0.g.t.i.h.a
            public final int getNumber() {
                return this.value;
            }

            public static Variance valueOf(int i2) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return null;
                        }
                        return INV;
                    }
                    return OUT;
                }
                return IN;
            }
        }

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<TypeParameter> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public TypeParameter c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new TypeParameter(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.c<TypeParameter, b> implements t {

            /* renamed from: d */
            private int f16681d;

            /* renamed from: e */
            private int f16682e;

            /* renamed from: f */
            private int f16683f;

            /* renamed from: g */
            private boolean f16684g;

            /* renamed from: h */
            private Variance f16685h = Variance.INV;

            /* renamed from: i */
            private List<Type> f16686i = Collections.emptyList();

            /* renamed from: j */
            private List<Integer> f16687j = Collections.emptyList();

            private b() {
                C();
            }

            private void C() {
            }

            public static b u() {
                return new b();
            }

            private void v() {
                if ((this.f16681d & 32) != 32) {
                    this.f16687j = new ArrayList(this.f16687j);
                    this.f16681d |= 32;
                }
            }

            private void w() {
                if ((this.f16681d & 16) != 16) {
                    this.f16686i = new ArrayList(this.f16686i);
                    this.f16681d |= 16;
                }
            }

            public boolean A() {
                return (this.f16681d & 1) == 1;
            }

            public boolean B() {
                return (this.f16681d & 2) == 2;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: D */
            public b h(TypeParameter typeParameter) {
                if (typeParameter == TypeParameter.getDefaultInstance()) {
                    return this;
                }
                if (typeParameter.hasId()) {
                    F(typeParameter.getId());
                }
                if (typeParameter.hasName()) {
                    G(typeParameter.getName());
                }
                if (typeParameter.hasReified()) {
                    H(typeParameter.getReified());
                }
                if (typeParameter.hasVariance()) {
                    I(typeParameter.getVariance());
                }
                if (!typeParameter.upperBound_.isEmpty()) {
                    if (this.f16686i.isEmpty()) {
                        this.f16686i = typeParameter.upperBound_;
                        this.f16681d &= -17;
                    } else {
                        w();
                        this.f16686i.addAll(typeParameter.upperBound_);
                    }
                }
                if (!typeParameter.upperBoundId_.isEmpty()) {
                    if (this.f16687j.isEmpty()) {
                        this.f16687j = typeParameter.upperBoundId_;
                        this.f16681d &= -33;
                    } else {
                        v();
                        this.f16687j.addAll(typeParameter.upperBoundId_);
                    }
                }
                p(typeParameter);
                j(g().b(typeParameter.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: E */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter$b");
            }

            public b F(int i2) {
                this.f16681d |= 1;
                this.f16682e = i2;
                return this;
            }

            public b G(int i2) {
                this.f16681d |= 2;
                this.f16683f = i2;
                return this;
            }

            public b H(boolean z) {
                this.f16681d |= 4;
                this.f16684g = z;
                return this;
            }

            public b I(Variance variance) {
                Objects.requireNonNull(variance);
                this.f16681d |= 8;
                this.f16685h = variance;
                return this;
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                if (A() && B()) {
                    for (int i2 = 0; i2 < z(); i2++) {
                        if (!y(i2).isInitialized()) {
                            return false;
                        }
                    }
                    return o();
                }
                return false;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: r */
            public TypeParameter build() {
                TypeParameter s = s();
                if (s.isInitialized()) {
                    return s;
                }
                throw a.AbstractC0459a.c(s);
            }

            public TypeParameter s() {
                TypeParameter typeParameter = new TypeParameter(this);
                int i2 = this.f16681d;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                typeParameter.id_ = this.f16682e;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                typeParameter.name_ = this.f16683f;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                typeParameter.reified_ = this.f16684g;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                typeParameter.variance_ = this.f16685h;
                if ((this.f16681d & 16) == 16) {
                    this.f16686i = Collections.unmodifiableList(this.f16686i);
                    this.f16681d &= -17;
                }
                typeParameter.upperBound_ = this.f16686i;
                if ((this.f16681d & 32) == 32) {
                    this.f16687j = Collections.unmodifiableList(this.f16687j);
                    this.f16681d &= -33;
                }
                typeParameter.upperBoundId_ = this.f16687j;
                typeParameter.bitField0_ = i3;
                return typeParameter;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: t */
            public b m() {
                return u().h(s());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: x */
            public TypeParameter getDefaultInstanceForType() {
                return TypeParameter.getDefaultInstance();
            }

            public Type y(int i2) {
                return this.f16686i.get(i2);
            }

            public int z() {
                return this.f16686i.size();
            }
        }

        static {
            TypeParameter typeParameter = new TypeParameter(true);
            defaultInstance = typeParameter;
            typeParameter.initFields();
        }

        public static TypeParameter getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.id_ = 0;
            this.name_ = 0;
            this.reified_ = false;
            this.variance_ = Variance.INV;
            this.upperBound_ = Collections.emptyList();
            this.upperBoundId_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.u();
        }

        public int getId() {
            return this.id_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<TypeParameter> getParserForType() {
            return PARSER;
        }

        public boolean getReified() {
            return this.reified_;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.id_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                o += CodedOutputStream.o(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                o += CodedOutputStream.a(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                o += CodedOutputStream.h(4, this.variance_.getNumber());
            }
            for (int i3 = 0; i3 < this.upperBound_.size(); i3++) {
                o += CodedOutputStream.s(5, this.upperBound_.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.upperBoundId_.size(); i5++) {
                i4 += CodedOutputStream.p(this.upperBoundId_.get(i5).intValue());
            }
            int i6 = o + i4;
            if (!getUpperBoundIdList().isEmpty()) {
                i6 = i6 + 1 + CodedOutputStream.p(i4);
            }
            this.upperBoundIdMemoizedSerializedSize = i4;
            int extensionsSerializedSize = i6 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public Type getUpperBound(int i2) {
            return this.upperBound_.get(i2);
        }

        public int getUpperBoundCount() {
            return this.upperBound_.size();
        }

        public List<Integer> getUpperBoundIdList() {
            return this.upperBoundId_;
        }

        public List<Type> getUpperBoundList() {
            return this.upperBound_;
        }

        public Variance getVariance() {
            return this.variance_;
        }

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReified() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasVariance() {
            return (this.bitField0_ & 8) == 8;
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
            if (!hasId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i2 = 0; i2 < getUpperBoundCount(); i2++) {
                    if (!getUpperBound(i2).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.L(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.S(4, this.variance_.getNumber());
            }
            for (int i2 = 0; i2 < this.upperBound_.size(); i2++) {
                codedOutputStream.d0(5, this.upperBound_.get(i2));
            }
            if (getUpperBoundIdList().size() > 0) {
                codedOutputStream.o0(50);
                codedOutputStream.o0(this.upperBoundIdMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.upperBoundId_.size(); i3++) {
                codedOutputStream.b0(this.upperBoundId_.get(i3).intValue());
            }
            newExtensionWriter.a(1000, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(TypeParameter typeParameter) {
            return newBuilder().h(typeParameter);
        }

        @Override // h.p2.b0.g.t.i.o
        public TypeParameter getDefaultInstanceForType() {
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

        private TypeParameter(GeneratedMessageLite.c<TypeParameter, ?> cVar) {
            super(cVar);
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.g();
        }

        private TypeParameter(boolean z) {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private TypeParameter(e eVar, f fVar) throws InvalidProtocolBufferException {
            this.upperBoundIdMemoizedSerializedSize = -1;
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
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 8) {
                                    this.bitField0_ |= 1;
                                    this.id_ = eVar.s();
                                } else if (K == 16) {
                                    this.bitField0_ |= 2;
                                    this.name_ = eVar.s();
                                } else if (K == 24) {
                                    this.bitField0_ |= 4;
                                    this.reified_ = eVar.k();
                                } else if (K == 32) {
                                    int n = eVar.n();
                                    Variance valueOf = Variance.valueOf(n);
                                    if (valueOf == null) {
                                        J.o0(K);
                                        J.o0(n);
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.variance_ = valueOf;
                                    }
                                } else if (K == 42) {
                                    if (!(z2 & true)) {
                                        this.upperBound_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.upperBound_.add(eVar.u(Type.PARSER, fVar));
                                } else if (K == 48) {
                                    if (!(z2 & true)) {
                                        this.upperBoundId_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.upperBoundId_.add(Integer.valueOf(eVar.s()));
                                } else if (K != 50) {
                                    if (!parseUnknownField(eVar, J, fVar, K)) {
                                    }
                                } else {
                                    int j2 = eVar.j(eVar.A());
                                    if (!(z2 & true) && eVar.e() > 0) {
                                        this.upperBoundId_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (eVar.e() > 0) {
                                        this.upperBoundId_.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(j2);
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    }
                    if (z2 & true) {
                        this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
            }
            if (z2 & true) {
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
    public static final class TypeTable extends GeneratedMessageLite implements u {
        public static p<TypeTable> PARSER = new a();
        private static final TypeTable defaultInstance;
        private int bitField0_;
        private int firstNullable_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Type> type_;
        private final d unknownFields;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<TypeTable> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public TypeTable c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new TypeTable(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.b<TypeTable, b> implements u {
            private int b;

            /* renamed from: c */
            private List<Type> f16688c = Collections.emptyList();

            /* renamed from: d */
            private int f16689d = -1;

            private b() {
                s();
            }

            public static b o() {
                return new b();
            }

            private void p() {
                if ((this.b & 1) != 1) {
                    this.f16688c = new ArrayList(this.f16688c);
                    this.b |= 1;
                }
            }

            private void s() {
            }

            public Type getType(int i2) {
                return this.f16688c.get(i2);
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < r(); i2++) {
                    if (!getType(i2).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: l */
            public TypeTable build() {
                TypeTable m2 = m();
                if (m2.isInitialized()) {
                    return m2;
                }
                throw a.AbstractC0459a.c(m2);
            }

            public TypeTable m() {
                TypeTable typeTable = new TypeTable(this);
                int i2 = this.b;
                if ((i2 & 1) == 1) {
                    this.f16688c = Collections.unmodifiableList(this.f16688c);
                    this.b &= -2;
                }
                typeTable.type_ = this.f16688c;
                int i3 = (i2 & 2) != 2 ? 0 : 1;
                typeTable.firstNullable_ = this.f16689d;
                typeTable.bitField0_ = i3;
                return typeTable;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: n */
            public b e() {
                return o().h(m());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: q */
            public TypeTable getDefaultInstanceForType() {
                return TypeTable.getDefaultInstance();
            }

            public int r() {
                return this.f16688c.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: t */
            public b h(TypeTable typeTable) {
                if (typeTable == TypeTable.getDefaultInstance()) {
                    return this;
                }
                if (!typeTable.type_.isEmpty()) {
                    if (this.f16688c.isEmpty()) {
                        this.f16688c = typeTable.type_;
                        this.b &= -2;
                    } else {
                        p();
                        this.f16688c.addAll(typeTable.type_);
                    }
                }
                if (typeTable.hasFirstNullable()) {
                    v(typeTable.getFirstNullable());
                }
                j(g().b(typeTable.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: u */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$b");
            }

            public b v(int i2) {
                this.b |= 2;
                this.f16689d = i2;
                return this;
            }
        }

        static {
            TypeTable typeTable = new TypeTable(true);
            defaultInstance = typeTable;
            typeTable.initFields();
        }

        public static TypeTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.type_ = Collections.emptyList();
            this.firstNullable_ = -1;
        }

        public static b newBuilder() {
            return b.o();
        }

        public int getFirstNullable() {
            return this.firstNullable_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<TypeTable> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.type_.size(); i4++) {
                i3 += CodedOutputStream.s(1, this.type_.get(i4));
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 += CodedOutputStream.o(2, this.firstNullable_);
            }
            int size = i3 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public Type getType(int i2) {
            return this.type_.get(i2);
        }

        public int getTypeCount() {
            return this.type_.size();
        }

        public List<Type> getTypeList() {
            return this.type_;
        }

        public boolean hasFirstNullable() {
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
            for (int i2 = 0; i2 < getTypeCount(); i2++) {
                if (!getType(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i2 = 0; i2 < this.type_.size(); i2++) {
                codedOutputStream.d0(1, this.type_.get(i2));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(2, this.firstNullable_);
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(TypeTable typeTable) {
            return newBuilder().h(typeTable);
        }

        @Override // h.p2.b0.g.t.i.o
        public TypeTable getDefaultInstanceForType() {
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

        private TypeTable(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.g();
        }

        private TypeTable(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private TypeTable(e eVar, f fVar) throws InvalidProtocolBufferException {
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
                                    this.type_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.type_.add(eVar.u(Type.PARSER, fVar));
                            } else if (K != 16) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.firstNullable_ = eVar.s();
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
                        this.type_ = Collections.unmodifiableList(this.type_);
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
                this.type_ = Collections.unmodifiableList(this.type_);
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
    public static final class ValueParameter extends GeneratedMessageLite.ExtendableMessage<ValueParameter> implements v {
        public static p<ValueParameter> PARSER = new a();
        private static final ValueParameter defaultInstance;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int typeId_;
        private Type type_;
        private final d unknownFields;
        private int varargElementTypeId_;
        private Type varargElementType_;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<ValueParameter> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public ValueParameter c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new ValueParameter(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.c<ValueParameter, b> implements v {

            /* renamed from: d */
            private int f16690d;

            /* renamed from: e */
            private int f16691e;

            /* renamed from: f */
            private int f16692f;

            /* renamed from: h */
            private int f16694h;

            /* renamed from: j */
            private int f16696j;

            /* renamed from: g */
            private Type f16693g = Type.getDefaultInstance();

            /* renamed from: i */
            private Type f16695i = Type.getDefaultInstance();

            private b() {
                A();
            }

            private void A() {
            }

            public static b u() {
                return new b();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: B */
            public b h(ValueParameter valueParameter) {
                if (valueParameter == ValueParameter.getDefaultInstance()) {
                    return this;
                }
                if (valueParameter.hasFlags()) {
                    F(valueParameter.getFlags());
                }
                if (valueParameter.hasName()) {
                    G(valueParameter.getName());
                }
                if (valueParameter.hasType()) {
                    D(valueParameter.getType());
                }
                if (valueParameter.hasTypeId()) {
                    H(valueParameter.getTypeId());
                }
                if (valueParameter.hasVarargElementType()) {
                    E(valueParameter.getVarargElementType());
                }
                if (valueParameter.hasVarargElementTypeId()) {
                    I(valueParameter.getVarargElementTypeId());
                }
                p(valueParameter);
                j(g().b(valueParameter.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: C */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter$b");
            }

            public b D(Type type) {
                if ((this.f16690d & 4) == 4 && this.f16693g != Type.getDefaultInstance()) {
                    this.f16693g = Type.newBuilder(this.f16693g).h(type).s();
                } else {
                    this.f16693g = type;
                }
                this.f16690d |= 4;
                return this;
            }

            public b E(Type type) {
                if ((this.f16690d & 16) == 16 && this.f16695i != Type.getDefaultInstance()) {
                    this.f16695i = Type.newBuilder(this.f16695i).h(type).s();
                } else {
                    this.f16695i = type;
                }
                this.f16690d |= 16;
                return this;
            }

            public b F(int i2) {
                this.f16690d |= 1;
                this.f16691e = i2;
                return this;
            }

            public b G(int i2) {
                this.f16690d |= 2;
                this.f16692f = i2;
                return this;
            }

            public b H(int i2) {
                this.f16690d |= 8;
                this.f16694h = i2;
                return this;
            }

            public b I(int i2) {
                this.f16690d |= 32;
                this.f16696j = i2;
                return this;
            }

            public Type getType() {
                return this.f16693g;
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                if (x()) {
                    if (!y() || getType().isInitialized()) {
                        return (!z() || w().isInitialized()) && o();
                    }
                    return false;
                }
                return false;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: r */
            public ValueParameter build() {
                ValueParameter s = s();
                if (s.isInitialized()) {
                    return s;
                }
                throw a.AbstractC0459a.c(s);
            }

            public ValueParameter s() {
                ValueParameter valueParameter = new ValueParameter(this);
                int i2 = this.f16690d;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                valueParameter.flags_ = this.f16691e;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                valueParameter.name_ = this.f16692f;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                valueParameter.type_ = this.f16693g;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                valueParameter.typeId_ = this.f16694h;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                valueParameter.varargElementType_ = this.f16695i;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                valueParameter.varargElementTypeId_ = this.f16696j;
                valueParameter.bitField0_ = i3;
                return valueParameter;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: t */
            public b m() {
                return u().h(s());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: v */
            public ValueParameter getDefaultInstanceForType() {
                return ValueParameter.getDefaultInstance();
            }

            public Type w() {
                return this.f16695i;
            }

            public boolean x() {
                return (this.f16690d & 2) == 2;
            }

            public boolean y() {
                return (this.f16690d & 4) == 4;
            }

            public boolean z() {
                return (this.f16690d & 16) == 16;
            }
        }

        static {
            ValueParameter valueParameter = new ValueParameter(true);
            defaultInstance = valueParameter;
            valueParameter.initFields();
        }

        public static ValueParameter getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 0;
            this.name_ = 0;
            this.type_ = Type.getDefaultInstance();
            this.typeId_ = 0;
            this.varargElementType_ = Type.getDefaultInstance();
            this.varargElementTypeId_ = 0;
        }

        public static b newBuilder() {
            return b.u();
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<ValueParameter> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.o(1, this.flags_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                o += CodedOutputStream.o(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                o += CodedOutputStream.s(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                o += CodedOutputStream.s(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                o += CodedOutputStream.o(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                o += CodedOutputStream.o(6, this.varargElementTypeId_);
            }
            int extensionsSerializedSize = o + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public Type getType() {
            return this.type_;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public Type getVarargElementType() {
            return this.varargElementType_;
        }

        public int getVarargElementTypeId() {
            return this.varargElementTypeId_;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasType() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasVarargElementType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasVarargElementTypeId() {
            return (this.bitField0_ & 32) == 32;
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasType() && !getType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasVarargElementType() && !getVarargElementType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // h.p2.b0.g.t.i.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.d0(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.d0(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.a0(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.a0(6, this.varargElementTypeId_);
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(ValueParameter valueParameter) {
            return newBuilder().h(valueParameter);
        }

        @Override // h.p2.b0.g.t.i.o
        public ValueParameter getDefaultInstanceForType() {
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

        private ValueParameter(GeneratedMessageLite.c<ValueParameter, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.g();
        }

        private ValueParameter(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        private ValueParameter(e eVar, f fVar) throws InvalidProtocolBufferException {
            Type.b builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t = d.t();
            CodedOutputStream J = CodedOutputStream.J(t, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 8) {
                                    this.bitField0_ |= 1;
                                    this.flags_ = eVar.s();
                                } else if (K != 16) {
                                    if (K == 26) {
                                        builder = (this.bitField0_ & 4) == 4 ? this.type_.toBuilder() : null;
                                        Type type = (Type) eVar.u(Type.PARSER, fVar);
                                        this.type_ = type;
                                        if (builder != null) {
                                            builder.h(type);
                                            this.type_ = builder.s();
                                        }
                                        this.bitField0_ |= 4;
                                    } else if (K == 34) {
                                        builder = (this.bitField0_ & 16) == 16 ? this.varargElementType_.toBuilder() : null;
                                        Type type2 = (Type) eVar.u(Type.PARSER, fVar);
                                        this.varargElementType_ = type2;
                                        if (builder != null) {
                                            builder.h(type2);
                                            this.varargElementType_ = builder.s();
                                        }
                                        this.bitField0_ |= 16;
                                    } else if (K == 40) {
                                        this.bitField0_ |= 8;
                                        this.typeId_ = eVar.s();
                                    } else if (K != 48) {
                                        if (!parseUnknownField(eVar, J, fVar, K)) {
                                        }
                                    } else {
                                        this.bitField0_ |= 32;
                                        this.varargElementTypeId_ = eVar.s();
                                    }
                                } else {
                                    this.bitField0_ |= 2;
                                    this.name_ = eVar.s();
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
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
    public static final class VersionRequirement extends GeneratedMessageLite implements w {
        public static p<VersionRequirement> PARSER = new a();
        private static final VersionRequirement defaultInstance;
        private int bitField0_;
        private int errorCode_;
        private Level level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int message_;
        private final d unknownFields;
        private int versionFull_;
        private VersionKind versionKind_;
        private int version_;

        /* loaded from: classes3.dex */
        public enum Level implements h.a {
            WARNING(0, 0),
            ERROR(1, 1),
            HIDDEN(2, 2);
            
            private static h.b<Level> internalValueMap = new a();
            private final int value;

            /* loaded from: classes3.dex */
            public static class a implements h.b<Level> {
                @Override // h.p2.b0.g.t.i.h.b
                /* renamed from: b */
                public Level a(int i2) {
                    return Level.valueOf(i2);
                }
            }

            Level(int i2, int i3) {
                this.value = i3;
            }

            @Override // h.p2.b0.g.t.i.h.a
            public final int getNumber() {
                return this.value;
            }

            public static Level valueOf(int i2) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return null;
                        }
                        return HIDDEN;
                    }
                    return ERROR;
                }
                return WARNING;
            }
        }

        /* loaded from: classes3.dex */
        public enum VersionKind implements h.a {
            LANGUAGE_VERSION(0, 0),
            COMPILER_VERSION(1, 1),
            API_VERSION(2, 2);
            
            private static h.b<VersionKind> internalValueMap = new a();
            private final int value;

            /* loaded from: classes3.dex */
            public static class a implements h.b<VersionKind> {
                @Override // h.p2.b0.g.t.i.h.b
                /* renamed from: b */
                public VersionKind a(int i2) {
                    return VersionKind.valueOf(i2);
                }
            }

            VersionKind(int i2, int i3) {
                this.value = i3;
            }

            @Override // h.p2.b0.g.t.i.h.a
            public final int getNumber() {
                return this.value;
            }

            public static VersionKind valueOf(int i2) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return null;
                        }
                        return API_VERSION;
                    }
                    return COMPILER_VERSION;
                }
                return LANGUAGE_VERSION;
            }
        }

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<VersionRequirement> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public VersionRequirement c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new VersionRequirement(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.b<VersionRequirement, b> implements w {
            private int b;

            /* renamed from: c */
            private int f16697c;

            /* renamed from: d */
            private int f16698d;

            /* renamed from: f */
            private int f16700f;

            /* renamed from: g */
            private int f16701g;

            /* renamed from: e */
            private Level f16699e = Level.ERROR;

            /* renamed from: h */
            private VersionKind f16702h = VersionKind.LANGUAGE_VERSION;

            private b() {
                q();
            }

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
            public VersionRequirement build() {
                VersionRequirement m2 = m();
                if (m2.isInitialized()) {
                    return m2;
                }
                throw a.AbstractC0459a.c(m2);
            }

            public VersionRequirement m() {
                VersionRequirement versionRequirement = new VersionRequirement(this);
                int i2 = this.b;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                versionRequirement.version_ = this.f16697c;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                versionRequirement.versionFull_ = this.f16698d;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                versionRequirement.level_ = this.f16699e;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                versionRequirement.errorCode_ = this.f16700f;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                versionRequirement.message_ = this.f16701g;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                versionRequirement.versionKind_ = this.f16702h;
                versionRequirement.bitField0_ = i3;
                return versionRequirement;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: n */
            public b e() {
                return o().h(m());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: p */
            public VersionRequirement getDefaultInstanceForType() {
                return VersionRequirement.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: r */
            public b h(VersionRequirement versionRequirement) {
                if (versionRequirement == VersionRequirement.getDefaultInstance()) {
                    return this;
                }
                if (versionRequirement.hasVersion()) {
                    w(versionRequirement.getVersion());
                }
                if (versionRequirement.hasVersionFull()) {
                    x(versionRequirement.getVersionFull());
                }
                if (versionRequirement.hasLevel()) {
                    u(versionRequirement.getLevel());
                }
                if (versionRequirement.hasErrorCode()) {
                    t(versionRequirement.getErrorCode());
                }
                if (versionRequirement.hasMessage()) {
                    v(versionRequirement.getMessage());
                }
                if (versionRequirement.hasVersionKind()) {
                    y(versionRequirement.getVersionKind());
                }
                j(g().b(versionRequirement.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: s */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement$b");
            }

            public b t(int i2) {
                this.b |= 8;
                this.f16700f = i2;
                return this;
            }

            public b u(Level level) {
                Objects.requireNonNull(level);
                this.b |= 4;
                this.f16699e = level;
                return this;
            }

            public b v(int i2) {
                this.b |= 16;
                this.f16701g = i2;
                return this;
            }

            public b w(int i2) {
                this.b |= 1;
                this.f16697c = i2;
                return this;
            }

            public b x(int i2) {
                this.b |= 2;
                this.f16698d = i2;
                return this;
            }

            public b y(VersionKind versionKind) {
                Objects.requireNonNull(versionKind);
                this.b |= 32;
                this.f16702h = versionKind;
                return this;
            }
        }

        static {
            VersionRequirement versionRequirement = new VersionRequirement(true);
            defaultInstance = versionRequirement;
            versionRequirement.initFields();
        }

        public static VersionRequirement getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.version_ = 0;
            this.versionFull_ = 0;
            this.level_ = Level.ERROR;
            this.errorCode_ = 0;
            this.message_ = 0;
            this.versionKind_ = VersionKind.LANGUAGE_VERSION;
        }

        public static b newBuilder() {
            return b.o();
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public Level getLevel() {
            return this.level_;
        }

        public int getMessage() {
            return this.message_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<VersionRequirement> getParserForType() {
            return PARSER;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.o(1, this.version_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                o += CodedOutputStream.o(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                o += CodedOutputStream.h(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                o += CodedOutputStream.o(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                o += CodedOutputStream.o(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                o += CodedOutputStream.h(6, this.versionKind_.getNumber());
            }
            int size = o + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getVersion() {
            return this.version_;
        }

        public int getVersionFull() {
            return this.versionFull_;
        }

        public VersionKind getVersionKind() {
            return this.versionKind_;
        }

        public boolean hasErrorCode() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasLevel() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasMessage() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasVersion() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasVersionFull() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasVersionKind() {
            return (this.bitField0_ & 32) == 32;
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
                codedOutputStream.a0(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.S(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.a0(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.a0(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.S(6, this.versionKind_.getNumber());
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(VersionRequirement versionRequirement) {
            return newBuilder().h(versionRequirement);
        }

        @Override // h.p2.b0.g.t.i.o
        public VersionRequirement getDefaultInstanceForType() {
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

        private VersionRequirement(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.g();
        }

        private VersionRequirement(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        private VersionRequirement(e eVar, f fVar) throws InvalidProtocolBufferException {
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
                                this.version_ = eVar.s();
                            } else if (K == 16) {
                                this.bitField0_ |= 2;
                                this.versionFull_ = eVar.s();
                            } else if (K == 24) {
                                int n = eVar.n();
                                Level valueOf = Level.valueOf(n);
                                if (valueOf == null) {
                                    J.o0(K);
                                    J.o0(n);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.level_ = valueOf;
                                }
                            } else if (K == 32) {
                                this.bitField0_ |= 8;
                                this.errorCode_ = eVar.s();
                            } else if (K == 40) {
                                this.bitField0_ |= 16;
                                this.message_ = eVar.s();
                            } else if (K != 48) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                int n2 = eVar.n();
                                VersionKind valueOf2 = VersionKind.valueOf(n2);
                                if (valueOf2 == null) {
                                    J.o0(K);
                                    J.o0(n2);
                                } else {
                                    this.bitField0_ |= 32;
                                    this.versionKind_ = valueOf2;
                                }
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
    public static final class VersionRequirementTable extends GeneratedMessageLite implements x {
        public static p<VersionRequirementTable> PARSER = new a();
        private static final VersionRequirementTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<VersionRequirement> requirement_;
        private final d unknownFields;

        /* loaded from: classes3.dex */
        public static class a extends h.p2.b0.g.t.i.b<VersionRequirementTable> {
            @Override // h.p2.b0.g.t.i.p
            /* renamed from: m */
            public VersionRequirementTable c(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new VersionRequirementTable(eVar, fVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends GeneratedMessageLite.b<VersionRequirementTable, b> implements x {
            private int b;

            /* renamed from: c */
            private List<VersionRequirement> f16703c = Collections.emptyList();

            private b() {
                r();
            }

            public static b o() {
                return new b();
            }

            private void p() {
                if ((this.b & 1) != 1) {
                    this.f16703c = new ArrayList(this.f16703c);
                    this.b |= 1;
                }
            }

            private void r() {
            }

            @Override // h.p2.b0.g.t.i.o
            public final boolean isInitialized() {
                return true;
            }

            @Override // h.p2.b0.g.t.i.n.a
            /* renamed from: l */
            public VersionRequirementTable build() {
                VersionRequirementTable m2 = m();
                if (m2.isInitialized()) {
                    return m2;
                }
                throw a.AbstractC0459a.c(m2);
            }

            public VersionRequirementTable m() {
                VersionRequirementTable versionRequirementTable = new VersionRequirementTable(this);
                if ((this.b & 1) == 1) {
                    this.f16703c = Collections.unmodifiableList(this.f16703c);
                    this.b &= -2;
                }
                versionRequirementTable.requirement_ = this.f16703c;
                return versionRequirementTable;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: n */
            public b e() {
                return o().h(m());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, h.p2.b0.g.t.i.o
            /* renamed from: q */
            public VersionRequirementTable getDefaultInstanceForType() {
                return VersionRequirementTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s */
            public b h(VersionRequirementTable versionRequirementTable) {
                if (versionRequirementTable == VersionRequirementTable.getDefaultInstance()) {
                    return this;
                }
                if (!versionRequirementTable.requirement_.isEmpty()) {
                    if (this.f16703c.isEmpty()) {
                        this.f16703c = versionRequirementTable.requirement_;
                        this.b &= -2;
                    } else {
                        p();
                        this.f16703c.addAll(versionRequirementTable.requirement_);
                    }
                }
                j(g().b(versionRequirementTable.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:59:0x001d  */
            @Override // h.p2.b0.g.t.i.a.AbstractC0459a, h.p2.b0.g.t.i.n.a
            /* renamed from: t */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.b d(h.p2.b0.g.t.i.e r3, h.p2.b0.g.t.i.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    h.p2.b0.g.t.i.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.b.d(h.p2.b0.g.t.i.e, h.p2.b0.g.t.i.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$b");
            }
        }

        static {
            VersionRequirementTable versionRequirementTable = new VersionRequirementTable(true);
            defaultInstance = versionRequirementTable;
            versionRequirementTable.initFields();
        }

        public static VersionRequirementTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.requirement_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.o();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, h.p2.b0.g.t.i.n
        public p<VersionRequirementTable> getParserForType() {
            return PARSER;
        }

        public int getRequirementCount() {
            return this.requirement_.size();
        }

        public List<VersionRequirement> getRequirementList() {
            return this.requirement_;
        }

        @Override // h.p2.b0.g.t.i.n
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.requirement_.size(); i4++) {
                i3 += CodedOutputStream.s(1, this.requirement_.get(i4));
            }
            int size = i3 + this.unknownFields.size();
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
            for (int i2 = 0; i2 < this.requirement_.size(); i2++) {
                codedOutputStream.d0(1, this.requirement_.get(i2));
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(VersionRequirementTable versionRequirementTable) {
            return newBuilder().h(versionRequirementTable);
        }

        @Override // h.p2.b0.g.t.i.o
        public VersionRequirementTable getDefaultInstanceForType() {
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

        private VersionRequirementTable(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.g();
        }

        private VersionRequirementTable(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private VersionRequirementTable(e eVar, f fVar) throws InvalidProtocolBufferException {
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
                            if (K != 10) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                if (!(z2 & true)) {
                                    this.requirement_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.requirement_.add(eVar.u(VersionRequirement.PARSER, fVar));
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
                        this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
    public enum Visibility implements h.a {
        INTERNAL(0, 0),
        PRIVATE(1, 1),
        PROTECTED(2, 2),
        PUBLIC(3, 3),
        PRIVATE_TO_THIS(4, 4),
        LOCAL(5, 5);
        
        private static h.b<Visibility> internalValueMap = new a();
        private final int value;

        /* loaded from: classes3.dex */
        public static class a implements h.b<Visibility> {
            @Override // h.p2.b0.g.t.i.h.b
            /* renamed from: b */
            public Visibility a(int i2) {
                return Visibility.valueOf(i2);
            }
        }

        Visibility(int i2, int i3) {
            this.value = i3;
        }

        @Override // h.p2.b0.g.t.i.h.a
        public final int getNumber() {
            return this.value;
        }

        public static Visibility valueOf(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 5) {
                                    return null;
                                }
                                return LOCAL;
                            }
                            return PRIVATE_TO_THIS;
                        }
                        return PUBLIC;
                    }
                    return PROTECTED;
                }
                return PRIVATE;
            }
            return INTERNAL;
        }
    }
}

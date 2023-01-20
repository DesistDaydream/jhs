package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.a2.x;
import h.b2.b;
import h.p2.b0.g.q;
import h.p2.b0.g.t.c.g0;
import h.p2.b0.g.t.c.m0;
import java.util.ArrayList;
import java.util.Comparator;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KCallableImpl$_parameters$1 extends Lambda implements h.k2.u.a<ArrayList<KParameter>> {
    public final /* synthetic */ KCallableImpl this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "R", "invoke"}, k = 3, mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements h.k2.u.a<g0> {
        public final /* synthetic */ m0 $instanceReceiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(m0 m0Var) {
            super(0);
            this.$instanceReceiver = m0Var;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h.k2.u.a
        @d
        public final g0 invoke() {
            return this.$instanceReceiver;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "R", "invoke"}, k = 3, mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends Lambda implements h.k2.u.a<g0> {
        public final /* synthetic */ m0 $extensionReceiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(m0 m0Var) {
            super(0);
            this.$extensionReceiver = m0Var;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h.k2.u.a
        @d
        public final g0 invoke() {
            return this.$extensionReceiver;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "R", "invoke"}, k = 3, mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends Lambda implements h.k2.u.a<g0> {
        public final /* synthetic */ CallableMemberDescriptor $descriptor;
        public final /* synthetic */ int $i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(CallableMemberDescriptor callableMemberDescriptor, int i2) {
            super(0);
            this.$descriptor = callableMemberDescriptor;
            this.$i = i2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h.k2.u.a
        @d
        public final g0 invoke() {
            return this.$descriptor.h().get(this.$i);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, am.av, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return b.g(((KParameter) t).getName(), ((KParameter) t2).getName());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KCallableImpl$_parameters$1(KCallableImpl kCallableImpl) {
        super(0);
        this.this$0 = kCallableImpl;
    }

    @Override // h.k2.u.a
    public final ArrayList<KParameter> invoke() {
        int i2;
        CallableMemberDescriptor J = this.this$0.J();
        ArrayList<KParameter> arrayList = new ArrayList<>();
        int i3 = 0;
        if (this.this$0.L()) {
            i2 = 0;
        } else {
            m0 h2 = q.h(J);
            if (h2 != null) {
                arrayList.add(new KParameterImpl(this.this$0, 0, KParameter.Kind.INSTANCE, new AnonymousClass1(h2)));
                i2 = 1;
            } else {
                i2 = 0;
            }
            m0 Q = J.Q();
            if (Q != null) {
                arrayList.add(new KParameterImpl(this.this$0, i2, KParameter.Kind.EXTENSION_RECEIVER, new AnonymousClass2(Q)));
                i2++;
            }
        }
        int size = J.h().size();
        while (i3 < size) {
            arrayList.add(new KParameterImpl(this.this$0, i2, KParameter.Kind.VALUE, new AnonymousClass3(J, i3)));
            i3++;
            i2++;
        }
        if (this.this$0.K() && (J instanceof h.p2.b0.g.t.e.a.u.a) && arrayList.size() > 1) {
            x.p0(arrayList, new a());
        }
        arrayList.trimToSize();
        return arrayList;
    }
}

package kotlin.reflect.jvm.internal.calls;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import h.a2.u;
import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.n;
import h.t2.y;
import h.w;
import h.z;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;

@Metadata(d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001aI\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\u0010\u000b\u001a$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¨\u0006\u0014"}, d2 = {"createAnnotationInstance", ExifInterface.GPS_DIRECTION_TRUE, "", "annotationClass", "Ljava/lang/Class;", "values", "", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class AnnotationConstructorCallerKt {

    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u00012\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062,\u0010\u0007\u001a(\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\b0\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", ExifInterface.GPS_DIRECTION_TRUE, "<anonymous parameter 0>", PushConstants.MZ_PUSH_MESSAGE_METHOD, "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a implements InvocationHandler {
        public final /* synthetic */ Class a;
        public final /* synthetic */ w b;

        /* renamed from: c */
        public final /* synthetic */ n f16405c;

        /* renamed from: d */
        public final /* synthetic */ w f16406d;

        /* renamed from: e */
        public final /* synthetic */ n f16407e;

        /* renamed from: f */
        public final /* synthetic */ AnnotationConstructorCallerKt$createAnnotationInstance$2 f16408f;

        /* renamed from: g */
        public final /* synthetic */ Map f16409g;

        public a(Class cls, w wVar, n nVar, w wVar2, n nVar2, AnnotationConstructorCallerKt$createAnnotationInstance$2 annotationConstructorCallerKt$createAnnotationInstance$2, Map map) {
            this.a = cls;
            this.b = wVar;
            this.f16405c = nVar;
            this.f16406d = wVar2;
            this.f16407e = nVar2;
            this.f16408f = annotationConstructorCallerKt$createAnnotationInstance$2;
            this.f16409g = map;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != -1776922004) {
                    if (hashCode != 147696667) {
                        if (hashCode == 1444986633 && name.equals("annotationType")) {
                            return this.a;
                        }
                    } else if (name.equals(TTDownloadField.TT_HASHCODE)) {
                        return this.f16406d.getValue();
                    }
                } else if (name.equals("toString")) {
                    return this.b.getValue();
                }
            }
            if (f0.g(name, "equals") && objArr != null && objArr.length == 1) {
                return Boolean.valueOf(this.f16408f.invoke2(ArraysKt___ArraysKt.Cs(objArr)));
            }
            if (this.f16409g.containsKey(name)) {
                return this.f16409g.get(name);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Method is not supported: ");
            sb.append(method);
            sb.append(" (args: ");
            if (objArr == null) {
                objArr = new Object[0];
            }
            sb.append(ArraysKt___ArraysKt.ey(objArr));
            sb.append(')');
            throw new KotlinReflectionInternalError(sb.toString());
        }
    }

    @d
    public static final <T> T c(@d Class<T> cls, @d Map<String, ? extends Object> map, @d List<Method> list) {
        AnnotationConstructorCallerKt$createAnnotationInstance$2 annotationConstructorCallerKt$createAnnotationInstance$2 = new AnnotationConstructorCallerKt$createAnnotationInstance$2(cls, list, map);
        w c2 = z.c(new AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2(map));
        T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls, z.c(new AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(cls, map)), null, c2, null, annotationConstructorCallerKt$createAnnotationInstance$2, map));
        Objects.requireNonNull(t, "null cannot be cast to non-null type T");
        return t;
    }

    public static /* synthetic */ Object d(Class cls, Map map, List list, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            Set<String> keySet = map.keySet();
            ArrayList arrayList = new ArrayList(u.Y(keySet, 10));
            for (String str : keySet) {
                arrayList.add(cls.getDeclaredMethod(str, new Class[0]));
            }
            list = arrayList;
        }
        return c(cls, map, list);
    }

    public static final Void e(int i2, String str, Class<?> cls) {
        h.p2.d g2;
        String D;
        if (f0.g(cls, Class.class)) {
            g2 = n0.d(h.p2.d.class);
        } else if (cls.isArray() && f0.g(cls.getComponentType(), Class.class)) {
            g2 = n0.d(h.p2.d[].class);
        } else {
            g2 = h.k2.a.g(cls);
        }
        if (f0.g(g2.D(), n0.d(Object[].class).D())) {
            D = g2.D() + y.f15691d + h.k2.a.g(h.k2.a.c(g2).getComponentType()).D() + y.f15692e;
        } else {
            D = g2.D();
        }
        throw new IllegalArgumentException("Argument #" + i2 + ' ' + str + " is not of the required type " + D);
    }

    public static final Object f(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof h.p2.d) {
            obj = h.k2.a.c((h.p2.d) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof h.p2.d[]) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                h.p2.d[] dVarArr = (h.p2.d[]) obj;
                ArrayList arrayList = new ArrayList(dVarArr.length);
                for (h.p2.d dVar : dVarArr) {
                    arrayList.add(h.k2.a.c(dVar));
                }
                obj = arrayList.toArray(new Class[0]);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T>");
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }
}

package e.t.u;

import androidx.exifinterface.media.ExifInterface;
import com.vivo.push.PushClientConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u001a\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\t\"\u0006\u0012\u0002\b\u00030\n¢\u0006\u0002\u0010\u000bJ7\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\r\u0018\u00010\n2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t\"\u00020\u0001¢\u0006\u0002\u0010\u0010J;\u0010\u0011\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\r\u0018\u00010\n2\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\t\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0010J=\u0010\u0011\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00122\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\t\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/vector/util/ReflectUtil;", "", "()V", "getMethod", "Ljava/lang/reflect/Method;", PushClientConstants.TAG_CLASS_NAME, "", "methodName", "parameterTypes", "", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "newDeclaredInst", ExifInterface.GPS_DIRECTION_TRUE, "clz", "args", "(Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "newInst", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;[Ljava/lang/Object;)Ljava/lang/Object;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class v {
    @k.e.a.d
    public static final v a = new v();

    private v() {
    }

    @k.e.a.d
    public final Method a(@k.e.a.d String str, @k.e.a.d String str2, @k.e.a.d Class<?>... clsArr) throws ClassNotFoundException, NoSuchMethodException {
        return Class.forName(str).getMethod(str2, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
    }

    @k.e.a.e
    public final <T> T b(@k.e.a.e Class<T> cls, @k.e.a.d Object... objArr) {
        T t = null;
        if (cls == null) {
            return null;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int i2 = 0;
        int length = declaredConstructors.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = i2 + 1;
                try {
                    declaredConstructors[i2].setAccessible(true);
                    t = (T) declaredConstructors[i2].newInstance(Arrays.copyOf(objArr, objArr.length));
                    break;
                } catch (Exception unused) {
                    if (i3 > length) {
                        break;
                    }
                    i2 = i3;
                }
            }
        }
        return t;
    }

    @k.e.a.e
    public final <T> T c(@k.e.a.e Class<T> cls, @k.e.a.d Object... objArr) {
        T t = null;
        if (cls == null) {
            return null;
        }
        Constructor<?>[] constructors = cls.getConstructors();
        int i2 = 0;
        int length = constructors.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = i2 + 1;
                try {
                    t = (T) constructors[i2].newInstance(Arrays.copyOf(objArr, objArr.length));
                    break;
                } catch (Exception unused) {
                    if (i3 > length) {
                        break;
                    }
                    i2 = i3;
                }
            }
        }
        return t;
    }

    @k.e.a.e
    public final <T> T d(@k.e.a.d h.p2.d<T> dVar, @k.e.a.d Object... objArr) {
        return (T) c(h.k2.a.c(dVar), Arrays.copyOf(objArr, objArr.length));
    }
}

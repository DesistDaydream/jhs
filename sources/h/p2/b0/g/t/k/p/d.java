package h.p2.b0.g.t.k.p;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.tencent.android.tpns.mqtt.MqttTopic;

/* loaded from: classes3.dex */
public class d {
    private final String a;
    private h.p2.b0.g.t.g.c b;

    private d(@k.e.a.d String str) {
        if (str == null) {
            a(5);
        }
        this.a = str;
    }

    private static /* synthetic */ void a(int i2) {
        String str = (i2 == 3 || i2 == 6 || i2 == 7 || i2 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 3 || i2 == 6 || i2 == 7 || i2 == 8) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 5:
            default:
                objArr[0] = "internalName";
                break;
        }
        if (i2 == 3) {
            objArr[1] = "byFqNameWithoutInnerClasses";
        } else if (i2 == 6) {
            objArr[1] = "getFqNameForClassNameWithoutDollars";
        } else if (i2 == 7) {
            objArr[1] = "getPackageFqName";
        } else if (i2 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        } else {
            objArr[1] = "getInternalName";
        }
        switch (i2) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 != 3 && i2 != 6 && i2 != 7 && i2 != 8) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @k.e.a.d
    public static d b(@k.e.a.d h.p2.b0.g.t.g.b bVar) {
        if (bVar == null) {
            a(1);
        }
        h.p2.b0.g.t.g.c h2 = bVar.h();
        String replace = bVar.i().b().replace('.', '$');
        if (h2.d()) {
            return new d(replace);
        }
        return new d(h2.b().replace('.', Attributes.InternalPrefix) + MqttTopic.TOPIC_LEVEL_SEPARATOR + replace);
    }

    @k.e.a.d
    public static d c(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        if (cVar == null) {
            a(2);
        }
        d dVar = new d(cVar.b().replace('.', Attributes.InternalPrefix));
        dVar.b = cVar;
        return dVar;
    }

    @k.e.a.d
    public static d d(@k.e.a.d String str) {
        if (str == null) {
            a(0);
        }
        return new d(str);
    }

    @k.e.a.d
    public h.p2.b0.g.t.g.c e() {
        return new h.p2.b0.g.t.g.c(this.a.replace(Attributes.InternalPrefix, '.'));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((d) obj).a);
    }

    @k.e.a.d
    public String f() {
        String str = this.a;
        if (str == null) {
            a(8);
        }
        return str;
    }

    @k.e.a.d
    public h.p2.b0.g.t.g.c g() {
        int lastIndexOf = this.a.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (lastIndexOf == -1) {
            h.p2.b0.g.t.g.c cVar = h.p2.b0.g.t.g.c.f15413c;
            if (cVar == null) {
                a(7);
            }
            return cVar;
        }
        return new h.p2.b0.g.t.g.c(this.a.substring(0, lastIndexOf).replace(Attributes.InternalPrefix, '.'));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }
}

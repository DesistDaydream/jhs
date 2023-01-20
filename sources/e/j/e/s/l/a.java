package e.j.e.s.l;

import com.google.gson.JsonIOException;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class a {
    private a() {
    }

    private static String a(Constructor<?> constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        sb.append('#');
        sb.append(constructor.getDeclaringClass().getSimpleName());
        sb.append('(');
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i2].getSimpleName());
        }
        sb.append(')');
        return sb.toString();
    }

    public static void b(Field field) throws JsonIOException {
        try {
            field.setAccessible(true);
        } catch (Exception e2) {
            throw new JsonIOException("Failed making field '" + field.getDeclaringClass().getName() + MqttTopic.MULTI_LEVEL_WILDCARD + field.getName() + "' accessible; either change its visibility or write a custom TypeAdapter for its declaring type", e2);
        }
    }

    public static String c(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e2) {
            return "Failed making constructor '" + a(constructor) + "' accessible; either change its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e2.getMessage();
        }
    }
}

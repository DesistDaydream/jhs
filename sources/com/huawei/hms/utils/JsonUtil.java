package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class JsonUtil {
    private static final String BYTE_BYTE = "_byte_";
    private static final String LIST_FIELD_VALUE = "_value_";
    private static final String LIST_ITEM_VALUE = "_list_item_";
    private static final String LIST_SIZE = "_list_size_";
    private static final String MAP_MAP = "_map_";
    private static final String NEXT_ITEM = "_next_item_";
    private static final String PRE_PKG = "com.huawei";
    private static final String TAG = "JsonUtil";
    public static final int VAL_BYTE = 2;
    public static final int VAL_ENTITY = 0;
    public static final int VAL_LIST = 1;
    public static final int VAL_MAP = 3;
    public static final int VAL_NULL = -1;
    public static final String VAL_TYPE = "_val_type_";

    private static String createInnerJsonString(IMessageEntity iMessageEntity) throws IllegalAccessException, JSONException {
        Field[] declaredFields;
        JSONObject jSONObject = new JSONObject();
        for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(Packed.class)) {
                    boolean isAccessible = field.isAccessible();
                    setAccessible(field, true);
                    String name = field.getName();
                    Object obj = field.get(iMessageEntity);
                    setAccessible(field, isAccessible);
                    disposeType(name, obj, jSONObject);
                }
            }
        }
        return jSONObject.toString();
    }

    public static String createJsonString(IMessageEntity iMessageEntity) {
        if (iMessageEntity == null) {
            HMSLog.e(TAG, "createJsonString error, the input IMessageEntity is null");
            return "";
        }
        try {
            return createInnerJsonString(iMessageEntity);
        } catch (IllegalAccessException e2) {
            HMSLog.e(TAG, "catch IllegalAccessException " + e2.getMessage());
            return "";
        } catch (JSONException e3) {
            HMSLog.e(TAG, "catch JSONException " + e3.getMessage());
            return "";
        }
    }

    private static boolean disposeType(String str, Object obj, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        if (obj instanceof String) {
            jSONObject.put(str, (String) obj);
            return true;
        } else if (obj instanceof Integer) {
            jSONObject.put(str, ((Integer) obj).intValue());
            return true;
        } else if (obj instanceof Short) {
            jSONObject.put(str, (Short) obj);
            return true;
        } else if (obj instanceof Long) {
            jSONObject.put(str, (Long) obj);
            return true;
        } else if (obj instanceof Float) {
            jSONObject.put(str, (Float) obj);
            return true;
        } else if (obj instanceof Double) {
            jSONObject.put(str, (Double) obj);
            return true;
        } else if (obj instanceof Boolean) {
            jSONObject.put(str, (Boolean) obj);
            return true;
        } else if (obj instanceof JSONObject) {
            jSONObject.put(str, (JSONObject) obj);
            return true;
        } else if (obj instanceof byte[]) {
            writeByte(str, (byte[]) obj, jSONObject);
            return true;
        } else if (obj instanceof List) {
            writeList(str, (List) obj, jSONObject);
            return true;
        } else if (obj instanceof Map) {
            writeMap(str, (Map) obj, jSONObject);
            return true;
        } else {
            if (obj instanceof IMessageEntity) {
                try {
                    jSONObject.put(str, createInnerJsonString((IMessageEntity) obj));
                    return true;
                } catch (IllegalAccessException e2) {
                    HMSLog.e(TAG, "IllegalAccessException , " + e2);
                }
            }
            return false;
        }
    }

    public static Object getInfoFromJsonobject(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has(str2)) {
                    return null;
                }
                Object obj = jSONObject.get(str2);
                if (obj instanceof String) {
                    return obj;
                }
            } catch (JSONException unused) {
                HMSLog.e(TAG, "getInfoFromJsonobject:parser json error :" + str2);
            }
        }
        return null;
    }

    public static int getIntValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null || !jSONObject.has(str)) {
            return -1;
        }
        return jSONObject.getInt(str);
    }

    private static Object getObjectValue(String str, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.get(str);
        }
        if (jSONObject.has("header") && jSONObject.getJSONObject("header").has(str)) {
            return jSONObject.getJSONObject("header").get(str);
        }
        if (jSONObject.has("body") && jSONObject.getJSONObject("body").has(str)) {
            return jSONObject.getJSONObject("body").get(str);
        }
        return null;
    }

    public static String getStringValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }

    public static IMessageEntity jsonToEntity(String str, IMessageEntity iMessageEntity) {
        Field[] declaredFields;
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Packed.class)) {
                        try {
                            readFiled(iMessageEntity, field, jSONObject);
                        } catch (IllegalAccessException unused) {
                            HMSLog.e(TAG, "jsonToEntity, set value of the field exception, field name:" + field.getName());
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            HMSLog.e(TAG, "catch JSONException when parse jsonString" + e2.getMessage());
        }
        return iMessageEntity;
    }

    private static byte[] readByte(JSONObject jSONObject) throws JSONException {
        try {
            return Base64.decode(jSONObject.getString(BYTE_BYTE));
        } catch (IllegalArgumentException e2) {
            HMSLog.e(TAG, "readByte failed : " + e2.getMessage());
            return null;
        }
    }

    private static void readFiled(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        Object readJson = readJson(iMessageEntity, field, jSONObject);
        if (readJson != null) {
            boolean isAccessible = field.isAccessible();
            setAccessible(field, true);
            field.set(iMessageEntity, readJson);
            setAccessible(field, isAccessible);
        }
    }

    private static Object readJson(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        Object objectValue = getObjectValue(field.getName(), jSONObject);
        if (objectValue != null) {
            try {
                if (field.getType().getName().startsWith(PRE_PKG) && (field.getType().newInstance() instanceof IMessageEntity)) {
                    return jsonToEntity((String) objectValue, (IMessageEntity) field.getType().newInstance());
                }
                if ((objectValue instanceof JSONObject) && ((JSONObject) objectValue).has("_val_type_")) {
                    int i2 = ((JSONObject) objectValue).getInt("_val_type_");
                    if (i2 != 1 && i2 != 0) {
                        if (i2 == 2) {
                            return readByte((JSONObject) objectValue);
                        }
                        if (i2 == 3) {
                            return readMap(field.getGenericType(), (JSONObject) objectValue);
                        }
                        HMSLog.e(TAG, "cannot support type : " + i2);
                    }
                    return readList(field.getGenericType(), (JSONObject) objectValue);
                }
                return objectValue;
            } catch (InstantiationException unused) {
                HMSLog.e(TAG, "InstantiationException  ");
            }
        }
        return null;
    }

    private static List<Object> readList(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        int i2 = jSONObject.getInt(LIST_SIZE);
        int i3 = jSONObject.getInt("_val_type_");
        ArrayList arrayList = new ArrayList(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = jSONObject.get(LIST_ITEM_VALUE + i4);
            if (i3 == 0) {
                arrayList.add(jsonToEntity((String) obj, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
            } else if (i3 == 1) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static Map readMap(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        Class cls = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
        JSONArray jSONArray = new JSONArray(jSONObject.getString(MAP_MAP));
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < jSONArray.length(); i2 += 2) {
            if (cls.newInstance() instanceof IMessageEntity) {
                hashMap.put(jSONArray.get(i2), jsonToEntity(jSONArray.getString(i2 + 1), (IMessageEntity) cls.newInstance()));
            } else {
                hashMap.put(jSONArray.get(i2), jSONArray.get(i2 + 1));
            }
        }
        return hashMap;
    }

    private static void setAccessible(final Field field, final boolean z) {
        AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.utils.JsonUtil.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                field.setAccessible(z);
                return null;
            }
        });
    }

    private static void writeByte(String str, byte[] bArr, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("_val_type_", 2);
        try {
            jSONObject2.put(BYTE_BYTE, Base64.encode(bArr));
        } catch (IllegalArgumentException e2) {
            HMSLog.e(TAG, "writeByte failed : " + e2.getMessage());
        }
        jSONObject.put(str, jSONObject2);
    }

    private static void writeList(String str, List<?> list, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("_val_type_", 1);
        jSONObject2.put(LIST_SIZE, list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            disposeType(LIST_ITEM_VALUE + i2, list.get(i2), jSONObject2);
            if (list.get(i2) instanceof IMessageEntity) {
                jSONObject2.put("_val_type_", 0);
            }
        }
        jSONObject.put(str, jSONObject2);
    }

    private static void writeMap(String str, Map map, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key instanceof IMessageEntity) {
                jSONArray.put(createInnerJsonString((IMessageEntity) key));
            } else {
                jSONArray.put(key);
            }
            if (value instanceof IMessageEntity) {
                jSONArray.put(createInnerJsonString((IMessageEntity) value));
            } else {
                jSONArray.put(value);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("_val_type_", 3);
        jSONObject2.put(MAP_MAP, jSONArray.toString());
        jSONObject.put(str, jSONObject2);
    }
}

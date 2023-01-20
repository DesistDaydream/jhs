package com.huawei.hms.core.aidl;

import android.os.Bundle;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class a extends MessageCodec {
    @Override // com.huawei.hms.core.aidl.MessageCodec
    public List<Object> readList(Type type, Bundle bundle) throws InstantiationException, IllegalAccessException {
        int i2 = bundle.getInt("_list_size_");
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj = bundle.get("_list_item_" + i3);
            if (!obj.getClass().isPrimitive() && !(obj instanceof String) && !(obj instanceof Serializable)) {
                if (obj instanceof Bundle) {
                    Bundle bundle2 = (Bundle) obj;
                    int i4 = bundle2.getInt("_val_type_", -1);
                    if (i4 == 1) {
                        throw new InstantiationException("Nested List can not be supported");
                    }
                    if (i4 == 0) {
                        arrayList.add(decode(bundle2, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
                    } else {
                        throw new InstantiationException("Unknown type can not be supported");
                    }
                } else {
                    continue;
                }
            } else {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.core.aidl.MessageCodec
    public void writeList(String str, List list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("_val_type_", 1);
        bundle2.putInt("_list_size_", list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            writeValue("_list_item_" + i2, list.get(i2), bundle2);
        }
        bundle.putBundle(str, bundle2);
    }
}

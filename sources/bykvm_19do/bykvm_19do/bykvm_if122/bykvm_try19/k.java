package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.text.TextUtils;
import com.bytedance.msdk.api.AdSlot;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class k {
    public static List<String> a() {
        Field[] declaredFields = AdSlot.class.getDeclaredFields();
        Field[] declaredFields2 = AdSlot.class.getSuperclass().getDeclaredFields();
        if (declaredFields == null || declaredFields.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if (declaredFields != null && !TextUtils.isEmpty(field.getName()) && !Modifier.isFinal(field.getModifiers())) {
                arrayList.add(field.getName());
            }
        }
        if (declaredFields2 != null) {
            for (Field field2 : declaredFields2) {
                if (declaredFields != null && !TextUtils.isEmpty(field2.getName()) && !Modifier.isFinal(field2.getModifiers())) {
                    arrayList.add(field2.getName());
                }
            }
        }
        arrayList.remove("winCallback");
        arrayList.remove("failCallback");
        arrayList.remove("primeRitReqType");
        return arrayList;
    }

    public static void a(List<String> list, String str) {
    }

    public static List<String> b() {
        Field[] declaredFields = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c.class.getDeclaredFields();
        if (declaredFields == null || declaredFields.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if (declaredFields != null && !TextUtils.isEmpty(field.getName()) && !Modifier.isFinal(field.getModifiers())) {
                arrayList.add(field.getName());
            }
        }
        arrayList.remove("mTotalWaterFallCount");
        arrayList.remove("mWaterFallConfigList");
        arrayList.remove("mWaterFallConfMap");
        arrayList.remove("mTotalLoadLevelCount");
        arrayList.remove("mCurrentCommonAdMaxCpm");
        arrayList.remove("mLoadSortLevelList");
        arrayList.remove("hasServerBidding");
        arrayList.remove("hasClientOrMultiLevel");
        arrayList.remove("mRitInfoJson");
        return arrayList;
    }

    public static void b(List<String> list, String str) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        list.remove(str);
    }

    public static List<String> c() {
        Field[] declaredFields = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j.class.getDeclaredFields();
        if (declaredFields == null || declaredFields.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if (declaredFields != null && !TextUtils.isEmpty(field.getName()) && !Modifier.isFinal(field.getModifiers())) {
                arrayList.add(field.getName());
            }
        }
        arrayList.remove("mServerBiddingWinner");
        return arrayList;
    }
}

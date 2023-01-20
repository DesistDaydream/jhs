package com.jihuanshe.base;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tencent.qcloud.tuicore.TUIConstants;
import e.l.h.e.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final int a = 1;
    private static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f3771c;

    /* loaded from: classes2.dex */
    public static class a {
        public static final SparseArray<String> a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(3);
            a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, TUIConstants.TUIChat.OWNER);
            sparseArray.put(2, "toast");
        }

        private a() {
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static final HashMap<String, Integer> a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(2);
            a = hashMap;
            hashMap.put("layout/dialog_global_tips_0", Integer.valueOf(R.layout.dialog_global_tips));
            hashMap.put("layout/layout_toast_0", Integer.valueOf(R.layout.layout_toast));
        }

        private b() {
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        f3771c = sparseIntArray;
        sparseIntArray.put(R.layout.dialog_global_tips, 1);
        sparseIntArray.put(R.layout.layout_toast, 2);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.vector.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i2) {
        return a.a.get(i2);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        int i3 = f3771c.get(i2);
        if (i3 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                if (i3 == 1) {
                    if ("layout/dialog_global_tips_0".equals(tag)) {
                        return new e.l.h.e.b(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_global_tips is invalid. Received: " + tag);
                } else if (i3 != 2) {
                    return null;
                } else {
                    if ("layout/layout_toast_0".equals(tag)) {
                        return new d(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_toast is invalid. Received: " + tag);
                }
            }
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f3771c.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}

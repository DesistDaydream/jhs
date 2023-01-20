package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public interface ViewTypeStorage {

    /* loaded from: classes.dex */
    public static class IsolatedViewTypeStorage implements ViewTypeStorage {
        public SparseArray<NestedAdapterWrapper> mGlobalTypeToWrapper = new SparseArray<>();
        public int mNextViewType = 0;

        /* loaded from: classes.dex */
        public class WrapperViewTypeLookup implements ViewTypeLookup {
            public final NestedAdapterWrapper mWrapper;
            private SparseIntArray mLocalToGlobalMapping = new SparseIntArray(1);
            private SparseIntArray mGlobalToLocalMapping = new SparseIntArray(1);

            public WrapperViewTypeLookup(NestedAdapterWrapper nestedAdapterWrapper) {
                this.mWrapper = nestedAdapterWrapper;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public void dispose() {
                IsolatedViewTypeStorage.this.removeWrapper(this.mWrapper);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int globalToLocal(int i2) {
                int indexOfKey = this.mGlobalToLocalMapping.indexOfKey(i2);
                if (indexOfKey >= 0) {
                    return this.mGlobalToLocalMapping.valueAt(indexOfKey);
                }
                throw new IllegalStateException("requested global type " + i2 + " does not belong to the adapter:" + this.mWrapper.adapter);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int localToGlobal(int i2) {
                int indexOfKey = this.mLocalToGlobalMapping.indexOfKey(i2);
                if (indexOfKey > -1) {
                    return this.mLocalToGlobalMapping.valueAt(indexOfKey);
                }
                int obtainViewType = IsolatedViewTypeStorage.this.obtainViewType(this.mWrapper);
                this.mLocalToGlobalMapping.put(i2, obtainViewType);
                this.mGlobalToLocalMapping.put(obtainViewType, i2);
                return obtainViewType;
            }
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        @NonNull
        public ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            return new WrapperViewTypeLookup(nestedAdapterWrapper);
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        @NonNull
        public NestedAdapterWrapper getWrapperForGlobalType(int i2) {
            NestedAdapterWrapper nestedAdapterWrapper = this.mGlobalTypeToWrapper.get(i2);
            if (nestedAdapterWrapper != null) {
                return nestedAdapterWrapper;
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i2);
        }

        public int obtainViewType(NestedAdapterWrapper nestedAdapterWrapper) {
            int i2 = this.mNextViewType;
            this.mNextViewType = i2 + 1;
            this.mGlobalTypeToWrapper.put(i2, nestedAdapterWrapper);
            return i2;
        }

        public void removeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            for (int size = this.mGlobalTypeToWrapper.size() - 1; size >= 0; size--) {
                if (this.mGlobalTypeToWrapper.valueAt(size) == nestedAdapterWrapper) {
                    this.mGlobalTypeToWrapper.removeAt(size);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SharedIdRangeViewTypeStorage implements ViewTypeStorage {
        public SparseArray<List<NestedAdapterWrapper>> mGlobalTypeToWrapper = new SparseArray<>();

        /* loaded from: classes.dex */
        public class WrapperViewTypeLookup implements ViewTypeLookup {
            public final NestedAdapterWrapper mWrapper;

            public WrapperViewTypeLookup(NestedAdapterWrapper nestedAdapterWrapper) {
                this.mWrapper = nestedAdapterWrapper;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public void dispose() {
                SharedIdRangeViewTypeStorage.this.removeWrapper(this.mWrapper);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int globalToLocal(int i2) {
                return i2;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int localToGlobal(int i2) {
                List<NestedAdapterWrapper> list = SharedIdRangeViewTypeStorage.this.mGlobalTypeToWrapper.get(i2);
                if (list == null) {
                    list = new ArrayList<>();
                    SharedIdRangeViewTypeStorage.this.mGlobalTypeToWrapper.put(i2, list);
                }
                if (!list.contains(this.mWrapper)) {
                    list.add(this.mWrapper);
                }
                return i2;
            }
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        @NonNull
        public ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            return new WrapperViewTypeLookup(nestedAdapterWrapper);
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        @NonNull
        public NestedAdapterWrapper getWrapperForGlobalType(int i2) {
            List<NestedAdapterWrapper> list = this.mGlobalTypeToWrapper.get(i2);
            if (list != null && !list.isEmpty()) {
                return list.get(0);
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i2);
        }

        public void removeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            for (int size = this.mGlobalTypeToWrapper.size() - 1; size >= 0; size--) {
                List<NestedAdapterWrapper> valueAt = this.mGlobalTypeToWrapper.valueAt(size);
                if (valueAt.remove(nestedAdapterWrapper) && valueAt.isEmpty()) {
                    this.mGlobalTypeToWrapper.removeAt(size);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ViewTypeLookup {
        void dispose();

        int globalToLocal(int i2);

        int localToGlobal(int i2);
    }

    @NonNull
    ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper);

    @NonNull
    NestedAdapterWrapper getWrapperForGlobalType(int i2);
}

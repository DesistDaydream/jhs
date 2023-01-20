package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.ViewTypeStorage;

/* loaded from: classes.dex */
public class NestedAdapterWrapper {
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;
    private RecyclerView.AdapterDataObserver mAdapterObserver = new RecyclerView.AdapterDataObserver() { // from class: androidx.recyclerview.widget.NestedAdapterWrapper.1
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCachedItemCount = nestedAdapterWrapper.adapter.getItemCount();
            NestedAdapterWrapper nestedAdapterWrapper2 = NestedAdapterWrapper.this;
            nestedAdapterWrapper2.mCallback.onChanged(nestedAdapterWrapper2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCallback.onItemRangeChanged(nestedAdapterWrapper, i2, i3, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i2, int i3) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCachedItemCount += i3;
            nestedAdapterWrapper.mCallback.onItemRangeInserted(nestedAdapterWrapper, i2, i3);
            NestedAdapterWrapper nestedAdapterWrapper2 = NestedAdapterWrapper.this;
            if (nestedAdapterWrapper2.mCachedItemCount <= 0 || nestedAdapterWrapper2.adapter.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                return;
            }
            NestedAdapterWrapper nestedAdapterWrapper3 = NestedAdapterWrapper.this;
            nestedAdapterWrapper3.mCallback.onStateRestorationPolicyChanged(nestedAdapterWrapper3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i2, int i3, int i4) {
            Preconditions.checkArgument(i4 == 1, "moving more than 1 item is not supported in RecyclerView");
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCallback.onItemRangeMoved(nestedAdapterWrapper, i2, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i2, int i3) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCachedItemCount -= i3;
            nestedAdapterWrapper.mCallback.onItemRangeRemoved(nestedAdapterWrapper, i2, i3);
            NestedAdapterWrapper nestedAdapterWrapper2 = NestedAdapterWrapper.this;
            if (nestedAdapterWrapper2.mCachedItemCount >= 1 || nestedAdapterWrapper2.adapter.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                return;
            }
            NestedAdapterWrapper nestedAdapterWrapper3 = NestedAdapterWrapper.this;
            nestedAdapterWrapper3.mCallback.onStateRestorationPolicyChanged(nestedAdapterWrapper3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onStateRestorationPolicyChanged() {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCallback.onStateRestorationPolicyChanged(nestedAdapterWrapper);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3, @Nullable Object obj) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCallback.onItemRangeChanged(nestedAdapterWrapper, i2, i3, obj);
        }
    };
    public int mCachedItemCount;
    public final Callback mCallback;
    @NonNull
    private final StableIdStorage.StableIdLookup mStableIdLookup;
    @NonNull
    private final ViewTypeStorage.ViewTypeLookup mViewTypeLookup;

    /* loaded from: classes.dex */
    public interface Callback {
        void onChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper);

        void onItemRangeChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3);

        void onItemRangeChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3, @Nullable Object obj);

        void onItemRangeInserted(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3);

        void onItemRangeMoved(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3);

        void onItemRangeRemoved(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3);

        void onStateRestorationPolicyChanged(NestedAdapterWrapper nestedAdapterWrapper);
    }

    public NestedAdapterWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, Callback callback, ViewTypeStorage viewTypeStorage, StableIdStorage.StableIdLookup stableIdLookup) {
        this.adapter = adapter;
        this.mCallback = callback;
        this.mViewTypeLookup = viewTypeStorage.createViewTypeWrapper(this);
        this.mStableIdLookup = stableIdLookup;
        this.mCachedItemCount = adapter.getItemCount();
        adapter.registerAdapterDataObserver(this.mAdapterObserver);
    }

    public void dispose() {
        this.adapter.unregisterAdapterDataObserver(this.mAdapterObserver);
        this.mViewTypeLookup.dispose();
    }

    public int getCachedItemCount() {
        return this.mCachedItemCount;
    }

    public long getItemId(int i2) {
        return this.mStableIdLookup.localToGlobal(this.adapter.getItemId(i2));
    }

    public int getItemViewType(int i2) {
        return this.mViewTypeLookup.localToGlobal(this.adapter.getItemViewType(i2));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        this.adapter.bindViewHolder(viewHolder, i2);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return this.adapter.onCreateViewHolder(viewGroup, this.mViewTypeLookup.globalToLocal(i2));
    }
}

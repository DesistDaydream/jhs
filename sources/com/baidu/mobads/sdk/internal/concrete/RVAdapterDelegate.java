package com.baidu.mobads.sdk.internal.concrete;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Map;

/* loaded from: classes.dex */
public class RVAdapterDelegate extends RecyclerView.Adapter<RVViewHolderDelegate> implements a {
    private final b a;

    public RVAdapterDelegate(@NonNull IAdInterListener iAdInterListener) {
        this.a = b.a(iAdInterListener, this);
        registerAdapterDataObserver(new ViewPager2.DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.1
            {
                RVAdapterDelegate.this = this;
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                RVAdapterDelegate.this.a.a("onChanged");
            }
        });
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.a.getDelegator();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Object a = this.a.a("getItemCount", new Object[0]);
        if (a instanceof Integer) {
            return ((Integer) a).intValue();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        Object a = this.a.a("getItemId", Integer.valueOf(i2));
        if (a instanceof Integer) {
            return ((Integer) a).intValue();
        }
        return super.getItemId(i2);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.a.a("onAttachedToRecyclerView", recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.a.a("onDetachedFromRecyclerView", recyclerView);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.a.setTarget(obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RVViewHolderDelegate rVViewHolderDelegate, int i2) {
        this.a.a("onBindViewHolder", rVViewHolderDelegate.getDelegator(), Integer.valueOf(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RVViewHolderDelegate onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        Object a = this.a.a("onCreateViewHolder", viewGroup, Integer.valueOf(i2));
        if (a instanceof RVViewHolderDelegate) {
            return (RVViewHolderDelegate) a;
        }
        return new RVViewHolderDelegate(this.a.getDelegator(), viewGroup) { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.2
            {
                RVAdapterDelegate.this = this;
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        Object a = this.a.a("onFailedToRecycleView", rVViewHolderDelegate.getDelegator());
        if (a instanceof Boolean) {
            return ((Boolean) a).booleanValue();
        }
        return super.onFailedToRecycleView((RVAdapterDelegate) rVViewHolderDelegate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewAttachedToWindow((RVAdapterDelegate) rVViewHolderDelegate);
        this.a.a("onViewAttachedToWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewDetachedFromWindow((RVAdapterDelegate) rVViewHolderDelegate);
        this.a.a("onViewDetachedFromWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewRecycled((RVAdapterDelegate) rVViewHolderDelegate);
        this.a.a("onViewRecycled", rVViewHolderDelegate.getDelegator());
    }
}

package androidx.databinding.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.databinding.ObservableList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ObservableListAdapter<T> extends BaseAdapter {
    private final Context mContext;
    private final int mDropDownResourceId;
    private final LayoutInflater mLayoutInflater;
    private List<T> mList;
    private ObservableList.OnListChangedCallback mListChangedCallback;
    private final int mResourceId;
    private final int mTextViewResourceId;

    public ObservableListAdapter(Context context, List<T> list, int i2, int i3, int i4) {
        this.mContext = context;
        this.mResourceId = i2;
        this.mDropDownResourceId = i3;
        this.mTextViewResourceId = i4;
        this.mLayoutInflater = i2 == 0 ? null : (LayoutInflater) context.getSystemService("layout_inflater");
        setList(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mList.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        return getViewForResource(this.mDropDownResourceId, i2, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.mList.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        return getViewForResource(this.mResourceId, i2, view, viewGroup);
    }

    public View getViewForResource(int i2, int i3, View view, ViewGroup viewGroup) {
        CharSequence valueOf;
        if (view == null) {
            if (i2 == 0) {
                view = new TextView(this.mContext);
            } else {
                view = this.mLayoutInflater.inflate(i2, viewGroup, false);
            }
        }
        int i4 = this.mTextViewResourceId;
        TextView textView = (TextView) (i4 == 0 ? view : view.findViewById(i4));
        T t = this.mList.get(i3);
        if (t instanceof CharSequence) {
            valueOf = (CharSequence) t;
        } else {
            valueOf = String.valueOf(t);
        }
        textView.setText(valueOf);
        return view;
    }

    public void setList(List<T> list) {
        List<T> list2 = this.mList;
        if (list2 == list) {
            return;
        }
        if (list2 instanceof ObservableList) {
            ((ObservableList) list2).removeOnListChangedCallback(this.mListChangedCallback);
        }
        this.mList = list;
        if (list instanceof ObservableList) {
            if (this.mListChangedCallback == null) {
                this.mListChangedCallback = new ObservableList.OnListChangedCallback() { // from class: androidx.databinding.adapters.ObservableListAdapter.1
                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onChanged(ObservableList observableList) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onItemRangeChanged(ObservableList observableList, int i2, int i3) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onItemRangeInserted(ObservableList observableList, int i2, int i3) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onItemRangeMoved(ObservableList observableList, int i2, int i3, int i4) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onItemRangeRemoved(ObservableList observableList, int i2, int i3) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }
                };
            }
            ((ObservableList) this.mList).addOnListChangedCallback(this.mListChangedCallback);
        }
        notifyDataSetChanged();
    }
}

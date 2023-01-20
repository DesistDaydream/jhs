package com.m7.imkfsdk.view.pickerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.pickerview.view.BasePickerView;
import com.m7.imkfsdk.view.pickerview.view.WheelOptions;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class OptionsPickerView<T> extends BasePickerView implements View.OnClickListener {
    private static final String TAG_CANCEL = "cancel";
    private static final String TAG_SUBMIT = "submit";
    private View btnCancel;
    private View btnSubmit;
    private OnOptionsSelectListener optionsSelectListener;
    private TextView tvTitle;
    public WheelOptions<T> wheelOptions;

    /* loaded from: classes2.dex */
    public interface OnOptionsSelectListener {
        void onOptionsSelect(int i2, int i3, int i4);
    }

    public OptionsPickerView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.ykfsdk_kf_pickerview_options, this.contentContainer);
        View findViewById = findViewById(R.id.btnSubmit);
        this.btnSubmit = findViewById;
        findViewById.setTag(TAG_SUBMIT);
        View findViewById2 = findViewById(R.id.btnCancel);
        this.btnCancel = findViewById2;
        findViewById2.setTag(TAG_CANCEL);
        this.btnSubmit.setOnClickListener(this);
        this.btnCancel.setOnClickListener(this);
        this.tvTitle = (TextView) findViewById(R.id.tvTitle);
        this.wheelOptions = new WheelOptions<>(findViewById(R.id.optionspicker));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals(TAG_CANCEL)) {
            dismiss();
            return;
        }
        if (this.optionsSelectListener != null) {
            int[] currentItems = this.wheelOptions.getCurrentItems();
            this.optionsSelectListener.onOptionsSelect(currentItems[0], currentItems[1], currentItems[2]);
        }
        dismiss();
    }

    public void setCyclic(boolean z) {
        this.wheelOptions.setCyclic(z);
    }

    public void setLabels(String str) {
        this.wheelOptions.setLabels(str, null, null);
    }

    public void setOnoptionsSelectListener(OnOptionsSelectListener onOptionsSelectListener) {
        this.optionsSelectListener = onOptionsSelectListener;
    }

    public void setPicker(ArrayList<T> arrayList) {
        this.wheelOptions.setPicker(arrayList, null, null, false);
    }

    public void setSelectOptions(int i2) {
        this.wheelOptions.setCurrentItems(i2, 0, 0);
    }

    public void setTitle(String str) {
        this.tvTitle.setText(str);
    }

    public void setCyclic(boolean z, boolean z2, boolean z3) {
        this.wheelOptions.setCyclic(z, z2, z3);
    }

    public void setLabels(String str, String str2) {
        this.wheelOptions.setLabels(str, str2, null);
    }

    public void setPicker(ArrayList<T> arrayList, ArrayList<ArrayList<T>> arrayList2, boolean z) {
        this.wheelOptions.setPicker(arrayList, arrayList2, null, z);
    }

    public void setSelectOptions(int i2, int i3) {
        this.wheelOptions.setCurrentItems(i2, i3, 0);
    }

    public void setLabels(String str, String str2, String str3) {
        this.wheelOptions.setLabels(str, str2, str3);
    }

    public void setPicker(ArrayList<T> arrayList, ArrayList<ArrayList<T>> arrayList2, ArrayList<ArrayList<ArrayList<T>>> arrayList3, boolean z) {
        this.wheelOptions.setPicker(arrayList, arrayList2, arrayList3, z);
    }

    public void setSelectOptions(int i2, int i3, int i4) {
        this.wheelOptions.setCurrentItems(i2, i3, i4);
    }
}

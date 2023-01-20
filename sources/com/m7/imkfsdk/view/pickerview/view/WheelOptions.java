package com.m7.imkfsdk.view.pickerview.view;

import android.view.View;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.pickerview.adapter.ArrayWheelAdapter;
import com.m7.imkfsdk.view.pickerview.lib.WheelView;
import com.m7.imkfsdk.view.pickerview.listener.OnItemSelectedListener;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class WheelOptions<T> {
    private boolean linkage = false;
    private ArrayList<T> mOptions1Items;
    private ArrayList<ArrayList<T>> mOptions2Items;
    private ArrayList<ArrayList<ArrayList<T>>> mOptions3Items;
    private View view;
    private OnItemSelectedListener wheelListener_option1;
    private OnItemSelectedListener wheelListener_option2;
    private WheelView wv_option1;
    private WheelView wv_option2;
    private WheelView wv_option3;

    public WheelOptions(View view) {
        this.view = view;
        setView(view);
    }

    private void itemSelected(int i2, int i3, int i4) {
        ArrayList<ArrayList<T>> arrayList = this.mOptions2Items;
        if (arrayList != null) {
            this.wv_option2.setAdapter(new ArrayWheelAdapter(arrayList.get(i2)));
            this.wv_option2.setCurrentItem(i3);
        }
        ArrayList<ArrayList<ArrayList<T>>> arrayList2 = this.mOptions3Items;
        if (arrayList2 != null) {
            this.wv_option3.setAdapter(new ArrayWheelAdapter(arrayList2.get(i2).get(i3)));
            this.wv_option3.setCurrentItem(i4);
        }
    }

    public int[] getCurrentItems() {
        return new int[]{this.wv_option1.getCurrentItem(), this.wv_option2.getCurrentItem(), this.wv_option3.getCurrentItem()};
    }

    public View getView() {
        return this.view;
    }

    public void setCurrentItems(int i2, int i3, int i4) {
        if (this.linkage) {
            itemSelected(i2, i3, i4);
        }
        this.wv_option1.setCurrentItem(i2);
        this.wv_option2.setCurrentItem(i3);
        this.wv_option3.setCurrentItem(i4);
    }

    public void setCyclic(boolean z) {
        this.wv_option1.setCyclic(z);
        this.wv_option2.setCyclic(z);
        this.wv_option3.setCyclic(z);
    }

    public void setLabels(String str, String str2, String str3) {
        if (str != null) {
            this.wv_option1.setLabel(str);
        }
        if (str2 != null) {
            this.wv_option2.setLabel(str2);
        }
        if (str3 != null) {
            this.wv_option3.setLabel(str3);
        }
    }

    public void setOption2Cyclic(boolean z) {
        this.wv_option2.setCyclic(z);
    }

    public void setOption3Cyclic(boolean z) {
        this.wv_option3.setCyclic(z);
    }

    public void setPicker(ArrayList<T> arrayList) {
        setPicker(arrayList, null, null, false);
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setPicker(ArrayList<T> arrayList, ArrayList<ArrayList<T>> arrayList2, boolean z) {
        setPicker(arrayList, arrayList2, null, z);
    }

    public void setPicker(ArrayList<T> arrayList, ArrayList<ArrayList<T>> arrayList2, ArrayList<ArrayList<ArrayList<T>>> arrayList3, boolean z) {
        this.linkage = z;
        this.mOptions1Items = arrayList;
        this.mOptions2Items = arrayList2;
        this.mOptions3Items = arrayList3;
        int i2 = arrayList3 == null ? 8 : 4;
        if (arrayList2 == null) {
            i2 = 12;
        }
        WheelView wheelView = (WheelView) this.view.findViewById(R.id.options1);
        this.wv_option1 = wheelView;
        wheelView.setAdapter(new ArrayWheelAdapter(this.mOptions1Items, i2));
        this.wv_option1.setCurrentItem(0);
        WheelView wheelView2 = (WheelView) this.view.findViewById(R.id.options2);
        this.wv_option2 = wheelView2;
        ArrayList<ArrayList<T>> arrayList4 = this.mOptions2Items;
        if (arrayList4 != null) {
            wheelView2.setAdapter(new ArrayWheelAdapter(arrayList4.get(0)));
        }
        this.wv_option2.setCurrentItem(this.wv_option1.getCurrentItem());
        WheelView wheelView3 = (WheelView) this.view.findViewById(R.id.options3);
        this.wv_option3 = wheelView3;
        ArrayList<ArrayList<ArrayList<T>>> arrayList5 = this.mOptions3Items;
        if (arrayList5 != null) {
            wheelView3.setAdapter(new ArrayWheelAdapter(arrayList5.get(0).get(0)));
        }
        WheelView wheelView4 = this.wv_option3;
        wheelView4.setCurrentItem(wheelView4.getCurrentItem());
        float f2 = 25;
        this.wv_option1.setTextSize(f2);
        this.wv_option2.setTextSize(f2);
        this.wv_option3.setTextSize(f2);
        if (this.mOptions2Items == null) {
            this.wv_option2.setVisibility(8);
        }
        if (this.mOptions3Items == null) {
            this.wv_option3.setVisibility(8);
        }
        this.wheelListener_option1 = new OnItemSelectedListener() { // from class: com.m7.imkfsdk.view.pickerview.view.WheelOptions.1
            @Override // com.m7.imkfsdk.view.pickerview.listener.OnItemSelectedListener
            public void onItemSelected(int i3) {
                int i4;
                if (WheelOptions.this.mOptions2Items != null) {
                    i4 = WheelOptions.this.wv_option2.getCurrentItem();
                    if (i4 >= ((ArrayList) WheelOptions.this.mOptions2Items.get(i3)).size() - 1) {
                        i4 = ((ArrayList) WheelOptions.this.mOptions2Items.get(i3)).size() - 1;
                    }
                    WheelOptions.this.wv_option2.setAdapter(new ArrayWheelAdapter((ArrayList) WheelOptions.this.mOptions2Items.get(i3)));
                    WheelOptions.this.wv_option2.setCurrentItem(i4);
                } else {
                    i4 = 0;
                }
                if (WheelOptions.this.mOptions3Items != null) {
                    WheelOptions.this.wheelListener_option2.onItemSelected(i4);
                }
            }
        };
        this.wheelListener_option2 = new OnItemSelectedListener() { // from class: com.m7.imkfsdk.view.pickerview.view.WheelOptions.2
            @Override // com.m7.imkfsdk.view.pickerview.listener.OnItemSelectedListener
            public void onItemSelected(int i3) {
                if (WheelOptions.this.mOptions3Items != null) {
                    int currentItem = WheelOptions.this.wv_option1.getCurrentItem();
                    if (currentItem >= WheelOptions.this.mOptions3Items.size() - 1) {
                        currentItem = WheelOptions.this.mOptions3Items.size() - 1;
                    }
                    if (i3 >= ((ArrayList) WheelOptions.this.mOptions2Items.get(currentItem)).size() - 1) {
                        i3 = ((ArrayList) WheelOptions.this.mOptions2Items.get(currentItem)).size() - 1;
                    }
                    int currentItem2 = WheelOptions.this.wv_option3.getCurrentItem();
                    if (currentItem2 >= ((ArrayList) ((ArrayList) WheelOptions.this.mOptions3Items.get(currentItem)).get(i3)).size() - 1) {
                        currentItem2 = ((ArrayList) ((ArrayList) WheelOptions.this.mOptions3Items.get(currentItem)).get(i3)).size() - 1;
                    }
                    WheelOptions.this.wv_option3.setAdapter(new ArrayWheelAdapter((ArrayList) ((ArrayList) WheelOptions.this.mOptions3Items.get(WheelOptions.this.wv_option1.getCurrentItem())).get(i3)));
                    WheelOptions.this.wv_option3.setCurrentItem(currentItem2);
                }
            }
        };
        if (arrayList2 != null && z) {
            this.wv_option1.setOnItemSelectedListener(this.wheelListener_option1);
        }
        if (arrayList3 == null || !z) {
            return;
        }
        this.wv_option2.setOnItemSelectedListener(this.wheelListener_option2);
    }

    public void setCyclic(boolean z, boolean z2, boolean z3) {
        this.wv_option1.setCyclic(z);
        this.wv_option2.setCyclic(z2);
        this.wv_option3.setCyclic(z3);
    }
}

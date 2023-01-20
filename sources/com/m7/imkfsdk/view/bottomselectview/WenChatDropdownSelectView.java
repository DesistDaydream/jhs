package com.m7.imkfsdk.view.bottomselectview;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.utils.ToastUtils;
import com.m7.imkfsdk.view.bottomselectview.WebChatSelector;
import com.moor.imkf.model.entity.AddressData;
import com.moor.imkf.model.entity.AddressResult;
import com.moor.imkf.model.entity.WebChatInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class WenChatDropdownSelectView {
    private WebChatSelectAdapter adapter;
    private int count;
    private OnClickItemListent listen;
    private Dialog mCameraDialog;
    private Context mContext;
    private AddressResult maoption;
    private HashMap<Integer, AddressData> selectMap = new HashMap<>();
    private List<AddressData> options = new ArrayList();

    /* loaded from: classes2.dex */
    public interface OnClickItemListent {
        void cancel();

        void save(List<AddressData> list);
    }

    public WenChatDropdownSelectView(Context context, AddressResult addressResult, int i2) {
        this.mContext = context;
        this.maoption = addressResult;
        this.count = i2;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getKeyFromCityName(ArrayList<AddressData> arrayList, String str) {
        Iterator<AddressData> it = arrayList.iterator();
        String str2 = "";
        while (it.hasNext()) {
            AddressData next = it.next();
            if (next.label.equals(str)) {
                str2 = next.value;
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<AddressData> getOptionsByKey(List<AddressData> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (str != null && str.equals(list.get(i2).value)) {
                return list.get(i2).children;
            }
        }
        return new ArrayList();
    }

    private void initView() {
        this.mCameraDialog = new Dialog(this.mContext, R.style.ykfsdk_BottomDialog);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ykfsdk_view_chat_dropdown, (ViewGroup) null);
        ((TextView) linearLayout.findViewById(R.id.view_bottom_dropdown_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.bottomselectview.WenChatDropdownSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WenChatDropdownSelectView.this.listen.cancel();
                WenChatDropdownSelectView.this.cancel();
            }
        });
        ((TextView) linearLayout.findViewById(R.id.view_bottom_dropdown_save)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.bottomselectview.WenChatDropdownSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WenChatDropdownSelectView.this.count >= 1) {
                    Object[] array = WenChatDropdownSelectView.this.selectMap.keySet().toArray();
                    Arrays.sort(array);
                    for (int i2 = 0; i2 < array.length; i2++) {
                        WenChatDropdownSelectView.this.options.add(WenChatDropdownSelectView.this.selectMap.get(Integer.valueOf(i2)));
                    }
                }
                if (WenChatDropdownSelectView.this.options.size() - 1 < 0) {
                    ToastUtils.showShort(WenChatDropdownSelectView.this.mContext, WenChatDropdownSelectView.this.mContext.getString(R.string.ykfsdk_ykf_please_edit_complete));
                } else if (((AddressData) WenChatDropdownSelectView.this.options.get(WenChatDropdownSelectView.this.options.size() - 1)).children.size() > 0) {
                    ToastUtils.showShort(WenChatDropdownSelectView.this.mContext, WenChatDropdownSelectView.this.mContext.getString(R.string.ykfsdk_ykf_please_edit_complete));
                } else {
                    WenChatDropdownSelectView.this.listen.save(WenChatDropdownSelectView.this.options);
                    WenChatDropdownSelectView.this.cancel();
                }
            }
        });
        WebChatSelector webChatSelector = (WebChatSelector) linearLayout.findViewById(R.id.view_bottom_dropdown_addressselect);
        int i2 = this.count;
        webChatSelector.setVisibility(0);
        ((ListView) linearLayout.findViewById(R.id.view_bottom_dropdown_listview)).setVisibility(8);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        final ArrayList arrayList5 = new ArrayList();
        final ArrayList arrayList6 = new ArrayList();
        webChatSelector.setTabAmount(i2);
        arrayList.clear();
        arrayList.addAll(this.maoption.addressDatas);
        webChatSelector.setCities(arrayList);
        webChatSelector.setWebChatOnItemClickListener(new WebChatOnItemClickListener() { // from class: com.m7.imkfsdk.view.bottomselectview.WenChatDropdownSelectView.3
            @Override // com.m7.imkfsdk.view.bottomselectview.WebChatOnItemClickListener
            public void itemClick(WebChatSelector webChatSelector2, WebChatInterface webChatInterface, int i3) {
                AddressData addressData = new AddressData();
                addressData.label = webChatInterface.getCityName();
                addressData.value = webChatInterface.getCityId();
                addressData.children = webChatInterface.getOption();
                WenChatDropdownSelectView.this.selectMap.put(Integer.valueOf(i3), addressData);
                if (i3 == 0) {
                    List optionsByKey = WenChatDropdownSelectView.this.getOptionsByKey(arrayList, WenChatDropdownSelectView.this.getKeyFromCityName(arrayList, webChatInterface.getCityName()));
                    arrayList2.clear();
                    if (optionsByKey != null) {
                        arrayList2.addAll(optionsByKey);
                    }
                    webChatSelector2.setCities(arrayList2);
                } else if (i3 == 1) {
                    List optionsByKey2 = WenChatDropdownSelectView.this.getOptionsByKey(arrayList2, WenChatDropdownSelectView.this.getKeyFromCityName(arrayList2, webChatInterface.getCityName()));
                    arrayList3.clear();
                    if (optionsByKey2 != null) {
                        arrayList3.addAll(optionsByKey2);
                    }
                    webChatSelector2.setCities(arrayList3);
                } else if (i3 == 2) {
                    List optionsByKey3 = WenChatDropdownSelectView.this.getOptionsByKey(arrayList3, WenChatDropdownSelectView.this.getKeyFromCityName(arrayList3, webChatInterface.getCityName()));
                    arrayList4.clear();
                    if (optionsByKey3 != null) {
                        arrayList4.addAll(optionsByKey3);
                    }
                    webChatSelector2.setCities(arrayList4);
                } else if (i3 != 3) {
                    if (i3 != 4) {
                        return;
                    }
                    webChatSelector2.setCities(arrayList6);
                } else {
                    List optionsByKey4 = WenChatDropdownSelectView.this.getOptionsByKey(arrayList4, WenChatDropdownSelectView.this.getKeyFromCityName(arrayList4, webChatInterface.getCityName()));
                    arrayList5.clear();
                    if (optionsByKey4 != null) {
                        arrayList5.addAll(optionsByKey4);
                    }
                    webChatSelector2.setCities(arrayList5);
                }
            }
        });
        webChatSelector.setOnTabSelectedListener(new WebChatSelector.OnTabSelectedListener() { // from class: com.m7.imkfsdk.view.bottomselectview.WenChatDropdownSelectView.4
            @Override // com.m7.imkfsdk.view.bottomselectview.WebChatSelector.OnTabSelectedListener
            public void onTabReselected(WebChatSelector webChatSelector2, WebChatSelector.Tab tab) {
            }

            @Override // com.m7.imkfsdk.view.bottomselectview.WebChatSelector.OnTabSelectedListener
            public void onTabSelected(WebChatSelector webChatSelector2, WebChatSelector.Tab tab) {
                int index = tab.getIndex();
                if (index == 0) {
                    webChatSelector2.setCities(arrayList);
                } else if (index == 1) {
                    webChatSelector2.setCities(arrayList2);
                } else if (index == 2) {
                    webChatSelector2.setCities(arrayList3);
                } else if (index == 3) {
                    webChatSelector2.setCities(arrayList4);
                } else if (index != 4) {
                } else {
                    webChatSelector2.setCities(arrayList5);
                }
            }
        });
        this.mCameraDialog.setContentView(linearLayout);
        Window window = this.mCameraDialog.getWindow();
        window.setGravity(80);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = this.mContext.getResources().getDisplayMetrics().widthPixels;
        linearLayout.measure(0, 0);
        attributes.height = linearLayout.getMeasuredHeight();
        attributes.alpha = 9.0f;
        window.setAttributes(attributes);
    }

    public void cancel() {
        Dialog dialog = this.mCameraDialog;
        if (dialog != null) {
            dialog.cancel();
        }
    }

    public void setOnClickListent(OnClickItemListent onClickItemListent) {
        this.listen = onClickItemListent;
    }

    public void show() {
        Dialog dialog = this.mCameraDialog;
        if (dialog != null) {
            dialog.show();
        }
    }
}

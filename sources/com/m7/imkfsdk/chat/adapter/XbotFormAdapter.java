package com.m7.imkfsdk.chat.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.holder.XbotFromCityHolder;
import com.m7.imkfsdk.chat.holder.XbotFromDateHolder;
import com.m7.imkfsdk.chat.holder.XbotFromFileHolder;
import com.m7.imkfsdk.chat.holder.XbotFromMulitSelectHolder;
import com.m7.imkfsdk.chat.holder.XbotFromMulitTextHolder;
import com.m7.imkfsdk.chat.holder.XbotFromSingleSelectHolder;
import com.m7.imkfsdk.chat.holder.XbotFromSingleTextHolder;
import com.m7.imkfsdk.chat.holder.XbotHeadNoteHolder;
import com.m7.imkfsdk.chat.holder.XbotSubmitHolder;
import com.m7.imkfsdk.chat.model.Option;
import com.m7.imkfsdk.utils.FIleResourceUtil;
import com.m7.imkfsdk.utils.KFDrowDownUtils;
import com.m7.imkfsdk.utils.MimeTypesTools;
import com.m7.imkfsdk.utils.ToastUtils;
import com.m7.imkfsdk.view.MulitTagView;
import com.m7.imkfsdk.view.bottomselectview.WenChatDropdownSelectView;
import com.m7.imkfsdk.view.dropdownmenu.DropDownMenu;
import com.m7.imkfsdk.view.dropdownmenu.OnMenuSelectedListener;
import com.m7.imkfsdk.view.pickerview.newTimePickerView;
import com.moor.imkf.http.HttpManager;
import com.moor.imkf.model.entity.AddressData;
import com.moor.imkf.model.entity.AddressResult;
import com.moor.imkf.model.entity.UploadFileBean;
import com.moor.imkf.model.entity.XbotForm;
import com.moor.imkf.requesturl.RequestUrl;
import com.xiaomi.mipush.sdk.Constants;
import e.t.u.b0;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class XbotFormAdapter extends RecyclerView.Adapter {
    public int Type_FormCity;
    public int Type_FormFileList;
    public int Type_FormMulitSelect;
    public int Type_FormMulitText;
    public int Type_FormSingleSelect;
    public int Type_FormSingleText;
    public int Type_Formdate;
    public int Type_HeadNote;
    public int Type_Submit;
    private AddressResult addressResult;
    private List<XbotForm.FormInfoBean> formInfos;
    private boolean isDataHasFile;
    private Context mContext;
    private onSubmitClickListener submitClickListener;

    /* loaded from: classes2.dex */
    public interface onSubmitClickListener {
        void OnAddFileClick(int i2, XbotForm.FormInfoBean formInfoBean);

        void OnSubmitClick(List<XbotForm.FormInfoBean> list);
    }

    public XbotFormAdapter(Context context, List<XbotForm.FormInfoBean> list, AddressResult addressResult, boolean z) {
        ArrayList arrayList = new ArrayList();
        this.formInfos = arrayList;
        this.Type_FormSingleText = 0;
        this.Type_FormMulitText = 1;
        this.Type_FormSingleSelect = 2;
        this.Type_FormMulitSelect = 3;
        this.Type_FormFileList = 4;
        this.Type_Formdate = 5;
        this.Type_FormCity = 6;
        this.Type_Submit = 99;
        this.Type_HeadNote = 98;
        this.isDataHasFile = false;
        arrayList.clear();
        this.formInfos.addAll(list);
        this.mContext = context;
        this.addressResult = addressResult;
        this.isDataHasFile = z;
        XbotForm.FormInfoBean formInfoBean = new XbotForm.FormInfoBean();
        formInfoBean.type = XbotForm.Type_Submit;
        this.formInfos.add(formInfoBean);
    }

    public static newTimePickerView showDataDialogByDate(Context context, Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance();
        if (calendar == null) {
            calendar = calendar2;
        }
        newTimePickerView build = new newTimePickerView.Builder(context).setType(new boolean[]{true, true, true, false, false, false}).setLabel(context.getString(R.string.ykfsdk_pickerview_year), context.getString(R.string.ykfsdk_pickerview_month), context.getString(R.string.ykfsdk_pickerview_day), "", "", "").isCenterLabel(false).setDividerColor(-12303292).setContentSize(21).setDate(calendar).setRangDate(Calendar.getInstance(), Calendar.getInstance()).setDecorView(null).build();
        build.setDate(calendar);
        return build;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.formInfos.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (XbotForm.Type_DataSingleText.equals(this.formInfos.get(i2).type)) {
            return this.Type_FormSingleText;
        }
        if (XbotForm.Type_DataMulitText.equals(this.formInfos.get(i2).type)) {
            return this.Type_FormMulitText;
        }
        if (XbotForm.Type_DataSingleSelect.equals(this.formInfos.get(i2).type)) {
            return this.Type_FormSingleSelect;
        }
        if (XbotForm.Type_DataMulitSelect.equals(this.formInfos.get(i2).type)) {
            return this.Type_FormMulitSelect;
        }
        if (XbotForm.Type_Datadate.equals(this.formInfos.get(i2).type)) {
            return this.Type_Formdate;
        }
        if (XbotForm.Type_DataFile.equals(this.formInfos.get(i2).type)) {
            return this.Type_FormFileList;
        }
        if (XbotForm.Type_DataCity.equals(this.formInfos.get(i2).type)) {
            return this.Type_FormCity;
        }
        if (XbotForm.Type_Submit.equals(this.formInfos.get(i2).type)) {
            return this.Type_Submit;
        }
        if (XbotForm.Type_HeadNote.equals(this.formInfos.get(i2).type)) {
            return this.Type_HeadNote;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i2) {
        int itemViewType = viewHolder.getItemViewType();
        final XbotForm.FormInfoBean formInfoBean = this.formInfos.get(i2);
        if (formInfoBean != null) {
            int i3 = 0;
            if (itemViewType == this.Type_FormSingleText) {
                XbotFromSingleTextHolder xbotFromSingleTextHolder = (XbotFromSingleTextHolder) viewHolder;
                if (formInfoBean.flag == 1) {
                    xbotFromSingleTextHolder.tv_required.setVisibility(0);
                } else {
                    xbotFromSingleTextHolder.tv_required.setVisibility(8);
                }
                xbotFromSingleTextHolder.tv_title.setText(formInfoBean.name);
                if (TextUtils.isEmpty(formInfoBean.remarks)) {
                    xbotFromSingleTextHolder.et_single.setHint(this.mContext.getString(R.string.ykfsdk_ykf_please_input));
                } else {
                    xbotFromSingleTextHolder.et_single.setHint(formInfoBean.remarks);
                }
                if (!TextUtils.isEmpty(formInfoBean.value)) {
                    xbotFromSingleTextHolder.et_single.setText(formInfoBean.value);
                }
                xbotFromSingleTextHolder.et_single.addTextChangedListener(new TextWatcher() { // from class: com.m7.imkfsdk.chat.adapter.XbotFormAdapter.1
                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        formInfoBean.value = editable.toString();
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                    }
                });
            } else if (itemViewType == this.Type_FormMulitText) {
                XbotFromMulitTextHolder xbotFromMulitTextHolder = (XbotFromMulitTextHolder) viewHolder;
                if (formInfoBean.flag == 1) {
                    xbotFromMulitTextHolder.tv_required.setVisibility(0);
                } else {
                    xbotFromMulitTextHolder.tv_required.setVisibility(8);
                }
                xbotFromMulitTextHolder.tv_title.setText(formInfoBean.name);
                if (TextUtils.isEmpty(formInfoBean.remarks)) {
                    xbotFromMulitTextHolder.et_mulit.setHint(this.mContext.getString(R.string.ykfsdk_ykf_please_input));
                } else {
                    xbotFromMulitTextHolder.et_mulit.setHint(formInfoBean.remarks);
                }
                if (!TextUtils.isEmpty(formInfoBean.value)) {
                    xbotFromMulitTextHolder.et_mulit.setText(formInfoBean.value);
                }
                xbotFromMulitTextHolder.et_mulit.addTextChangedListener(new TextWatcher() { // from class: com.m7.imkfsdk.chat.adapter.XbotFormAdapter.2
                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        formInfoBean.value = editable.toString();
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                    }
                });
            } else if (itemViewType == this.Type_FormSingleSelect) {
                XbotFromSingleSelectHolder xbotFromSingleSelectHolder = (XbotFromSingleSelectHolder) viewHolder;
                if (formInfoBean.flag == 1) {
                    xbotFromSingleSelectHolder.tv_required.setVisibility(0);
                } else {
                    xbotFromSingleSelectHolder.tv_required.setVisibility(8);
                }
                xbotFromSingleSelectHolder.tv_title.setText(formInfoBean.name);
                DropDownMenu dropDownMenu = xbotFromSingleSelectHolder.drop_single;
                KFDrowDownUtils.setChatDropDownMenu(this.mContext, dropDownMenu, formInfoBean.select);
                if (!TextUtils.isEmpty(formInfoBean.value)) {
                    while (true) {
                        String[] strArr = formInfoBean.select;
                        if (i3 >= strArr.length) {
                            break;
                        }
                        if (formInfoBean.value.equals(strArr[i3])) {
                            dropDownMenu.setSelectIndex(i3);
                        }
                        i3++;
                    }
                }
                dropDownMenu.setMenuSelectedListener(new OnMenuSelectedListener() { // from class: com.m7.imkfsdk.chat.adapter.XbotFormAdapter.3
                    @Override // com.m7.imkfsdk.view.dropdownmenu.OnMenuSelectedListener
                    public void onSelected(View view, int i4, int i5) {
                        XbotForm.FormInfoBean formInfoBean2 = formInfoBean;
                        String[] strArr2 = formInfoBean2.select;
                        if (i4 < strArr2.length) {
                            formInfoBean2.value = strArr2[i4];
                        }
                    }
                });
            } else if (itemViewType == this.Type_FormMulitSelect) {
                XbotFromMulitSelectHolder xbotFromMulitSelectHolder = (XbotFromMulitSelectHolder) viewHolder;
                if (formInfoBean.flag == 1) {
                    xbotFromMulitSelectHolder.tv_required.setVisibility(0);
                } else {
                    xbotFromMulitSelectHolder.tv_required.setVisibility(8);
                }
                xbotFromMulitSelectHolder.tv_title.setText(formInfoBean.name);
                String[] strArr2 = new String[0];
                if (!TextUtils.isEmpty(formInfoBean.value)) {
                    strArr2 = formInfoBean.value.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < formInfoBean.select.length; i4++) {
                    Option option = new Option();
                    option.name = formInfoBean.select[i4];
                    for (String str : strArr2) {
                        if (formInfoBean.select[i4].equals(str)) {
                            option.isSelected = true;
                        }
                    }
                    arrayList.add(option);
                }
                xbotFromMulitSelectHolder.tagView.initTagView(arrayList, 1);
                xbotFromMulitSelectHolder.tagView.setOnSelectedChangeListener(new MulitTagView.OnSelectedChangeListener() { // from class: com.m7.imkfsdk.chat.adapter.XbotFormAdapter.4
                    @Override // com.m7.imkfsdk.view.MulitTagView.OnSelectedChangeListener
                    public void getTagList(List<Option> list) {
                        String str2 = "";
                        if (list != null && list.size() > 0) {
                            for (int i5 = 0; i5 < list.size(); i5++) {
                                str2 = str2 + list.get(i5).name + Constants.ACCEPT_TIME_SEPARATOR_SP;
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        formInfoBean.value = str2;
                    }
                });
            } else if (itemViewType == this.Type_FormFileList) {
                XbotFromFileHolder xbotFromFileHolder = (XbotFromFileHolder) viewHolder;
                if (formInfoBean.flag == 1) {
                    xbotFromFileHolder.tv_required.setVisibility(0);
                } else {
                    xbotFromFileHolder.tv_required.setVisibility(8);
                }
                xbotFromFileHolder.tv_title.setText(formInfoBean.name);
                xbotFromFileHolder.rl_xbot_form_addfile.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.adapter.XbotFormAdapter.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        XbotFormAdapter.this.submitClickListener.OnAddFileClick(i2, formInfoBean);
                    }
                });
                xbotFromFileHolder.ll_xbot_file.removeAllViews();
                while (i3 < formInfoBean.filelist.size()) {
                    final UploadFileBean uploadFileBean = formInfoBean.filelist.get(i3);
                    View inflate = View.inflate(this.mContext, R.layout.ykfsdk_kf_xbot_form_fileitem, null);
                    final ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_delete_file);
                    ((TextView) inflate.findViewById(R.id.tv_xbot_fileitem_name)).setText(uploadFileBean.getName());
                    ((ImageView) inflate.findViewById(R.id.iv_xbot_fileitem_type)).setImageResource(FIleResourceUtil.getFile_Icon(this.mContext, uploadFileBean.getName()));
                    imageView.setTag(uploadFileBean);
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.adapter.XbotFormAdapter.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            UploadFileBean uploadFileBean2 = (UploadFileBean) imageView.getTag();
                            if (!XbotFormAdapter.this.isDataHasFile) {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(uploadFileBean2.getUrl().replace(RequestUrl.QINIU_HTTP, ""));
                                HttpManager.delXbotFormFile(arrayList2, null);
                            }
                            formInfoBean.filelist.remove(uploadFileBean2);
                            XbotFormAdapter.this.notifyItemChanged(i2, formInfoBean);
                        }
                    });
                    inflate.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.adapter.XbotFormAdapter.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            try {
                                Intent intent = new Intent();
                                File file = new File(uploadFileBean.getLocalUrl());
                                if (Build.VERSION.SDK_INT < 24) {
                                    intent.setDataAndType(Uri.fromFile(file), MimeTypesTools.getMimeType(XbotFormAdapter.this.mContext, uploadFileBean.getLocalUrl()));
                                    intent.setFlags(268435456);
                                } else {
                                    intent.setFlags(1);
                                    intent.setAction("android.intent.action.VIEW");
                                    Context context = XbotFormAdapter.this.mContext;
                                    intent.setDataAndType(FileProvider.getUriForFile(context, XbotFormAdapter.this.mContext.getPackageName() + ".fileprovider", file), MimeTypesTools.getMimeType(XbotFormAdapter.this.mContext, uploadFileBean.getLocalUrl()));
                                }
                                XbotFormAdapter.this.mContext.startActivity(Intent.createChooser(intent, null));
                            } catch (Exception unused) {
                            }
                        }
                    });
                    xbotFromFileHolder.ll_xbot_file.addView(inflate);
                    i3++;
                }
            } else if (itemViewType == this.Type_Formdate) {
                final XbotFromDateHolder xbotFromDateHolder = (XbotFromDateHolder) viewHolder;
                if (formInfoBean.flag == 1) {
                    xbotFromDateHolder.tv_required.setVisibility(0);
                } else {
                    xbotFromDateHolder.tv_required.setVisibility(8);
                }
                xbotFromDateHolder.tv_title.setText(formInfoBean.name);
                if (TextUtils.isEmpty(formInfoBean.remarks)) {
                    xbotFromDateHolder.tv_date.setHint(this.mContext.getString(R.string.ykfsdk_ykf_please_input));
                } else {
                    xbotFromDateHolder.tv_date.setHint(formInfoBean.remarks);
                }
                if (!TextUtils.isEmpty(formInfoBean.value)) {
                    xbotFromDateHolder.tv_date.setText(formInfoBean.value);
                }
                xbotFromDateHolder.tv_date.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.adapter.XbotFormAdapter.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        newTimePickerView showDataDialogByDate = XbotFormAdapter.showDataDialogByDate(XbotFormAdapter.this.mContext, null);
                        showDataDialogByDate.setListener(new newTimePickerView.OnTimeSelectListener() { // from class: com.m7.imkfsdk.chat.adapter.XbotFormAdapter.8.1
                            @Override // com.m7.imkfsdk.view.pickerview.newTimePickerView.OnTimeSelectListener
                            public void onTimeSelect(Date date, View view2) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b0.a.b);
                                xbotFromDateHolder.tv_date.setText(simpleDateFormat.format(date));
                                formInfoBean.value = simpleDateFormat.format(date);
                            }
                        });
                        showDataDialogByDate.show();
                    }
                });
            } else if (itemViewType == this.Type_FormCity) {
                final XbotFromCityHolder xbotFromCityHolder = (XbotFromCityHolder) viewHolder;
                if (formInfoBean.flag == 1) {
                    xbotFromCityHolder.tv_required.setVisibility(0);
                } else {
                    xbotFromCityHolder.tv_required.setVisibility(8);
                }
                xbotFromCityHolder.tv_title.setText(formInfoBean.name);
                if (TextUtils.isEmpty(formInfoBean.remarks)) {
                    xbotFromCityHolder.tv_city.setHint(this.mContext.getString(R.string.ykfsdk_ykf_please_input));
                } else {
                    xbotFromCityHolder.tv_city.setHint(formInfoBean.remarks);
                }
                if (!TextUtils.isEmpty(formInfoBean.value)) {
                    xbotFromCityHolder.tv_city.setText(formInfoBean.value);
                }
                if (this.addressResult != null) {
                    xbotFromCityHolder.tv_city.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.adapter.XbotFormAdapter.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            WenChatDropdownSelectView wenChatDropdownSelectView = new WenChatDropdownSelectView(XbotFormAdapter.this.mContext, XbotFormAdapter.this.addressResult, 3);
                            wenChatDropdownSelectView.show();
                            wenChatDropdownSelectView.setOnClickListent(new WenChatDropdownSelectView.OnClickItemListent() { // from class: com.m7.imkfsdk.chat.adapter.XbotFormAdapter.9.1
                                @Override // com.m7.imkfsdk.view.bottomselectview.WenChatDropdownSelectView.OnClickItemListent
                                public void cancel() {
                                }

                                @Override // com.m7.imkfsdk.view.bottomselectview.WenChatDropdownSelectView.OnClickItemListent
                                public void save(List<AddressData> list) {
                                    String str2 = "";
                                    if (list != null && list.size() > 0) {
                                        for (int i5 = 0; i5 < list.size(); i5++) {
                                            str2 = str2 + list.get(i5).label + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
                                        }
                                    }
                                    if (!TextUtils.isEmpty(str2)) {
                                        str2 = str2.substring(0, str2.length() - 1);
                                    }
                                    xbotFromCityHolder.tv_city.setText(str2);
                                    formInfoBean.value = str2;
                                }
                            });
                        }
                    });
                }
            } else if (itemViewType == this.Type_HeadNote) {
                ((XbotHeadNoteHolder) viewHolder).tv_formNotes.setText(formInfoBean.name);
            } else if (itemViewType == this.Type_Submit) {
                ((XbotSubmitHolder) viewHolder).bt_form_submit.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.adapter.XbotFormAdapter.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.addAll(XbotFormAdapter.this.formInfos);
                        arrayList2.remove(arrayList2.size() - 1);
                        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                            XbotForm.FormInfoBean formInfoBean2 = (XbotForm.FormInfoBean) arrayList2.get(i5);
                            if (formInfoBean2.type.equals(XbotForm.Type_DataFile)) {
                                String str2 = "";
                                for (int i6 = 0; i6 < formInfoBean2.filelist.size(); i6++) {
                                    str2 = str2 + "<a href='" + formInfoBean2.filelist.get(i6).getUrl() + "'target='_blank'>" + formInfoBean2.filelist.get(i6).getName() + "</a>,";
                                    formInfoBean2.filelist.get(i6).setLocalUrl(null);
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    str2 = str2.substring(0, str2.length() - 1);
                                }
                                formInfoBean2.value = str2;
                            }
                            if (formInfoBean2.flag == 1 && TextUtils.isEmpty(formInfoBean2.value)) {
                                ToastUtils.showShort(XbotFormAdapter.this.mContext, formInfoBean2.name + XbotFormAdapter.this.mContext.getString(R.string.ykfsdk_ykf_required_form));
                                return;
                            }
                        }
                        XbotFormAdapter.this.submitClickListener.OnSubmitClick(arrayList2);
                    }
                });
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == this.Type_FormSingleText) {
            return new XbotFromSingleTextHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ykfsdk_kf_xbot_form_singletext, viewGroup, false));
        }
        if (i2 == this.Type_FormMulitText) {
            return new XbotFromMulitTextHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ykfsdk_kf_xbot_form_mulitetext, viewGroup, false));
        }
        if (i2 == this.Type_FormSingleSelect) {
            return new XbotFromSingleSelectHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ykfsdk_kf_xbot_form_singleselect, viewGroup, false));
        }
        if (i2 == this.Type_FormMulitSelect) {
            return new XbotFromMulitSelectHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ykfsdk_kf_xbot_form_mulitselect, viewGroup, false));
        }
        if (i2 == this.Type_FormFileList) {
            return new XbotFromFileHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ykfsdk_kf_xbot_form_file, viewGroup, false));
        }
        if (i2 == this.Type_Formdate) {
            return new XbotFromDateHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ykfsdk_kf_xbot_form_date, viewGroup, false));
        }
        if (i2 == this.Type_FormCity) {
            return new XbotFromCityHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ykfsdk_kf_xbot_form_city, viewGroup, false));
        }
        if (i2 == this.Type_Submit) {
            return new XbotSubmitHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ykfsdk_kf_xbot_form_submit, viewGroup, false));
        }
        if (i2 == this.Type_HeadNote) {
            return new XbotHeadNoteHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ykfsdk_kf_xbot_form_headnote, viewGroup, false));
        }
        return null;
    }

    public void setSubmitClickListener(onSubmitClickListener onsubmitclicklistener) {
        this.submitClickListener = onsubmitclicklistener;
    }
}

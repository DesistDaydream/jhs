package com.m7.imkfsdk.chat.dialog;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.listener.SubmitPingjiaListener;
import com.m7.imkfsdk.chat.model.Option;
import com.m7.imkfsdk.view.TagView;
import com.moor.imkf.IMChat;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.YKFConstants;
import com.moor.imkf.lib.utils.MoorAntiShakeUtils;
import com.moor.imkf.listener.SubmitInvestigateListener;
import com.moor.imkf.model.entity.Investigate;
import com.moor.imkf.utils.MoorUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ValidFragment"})
/* loaded from: classes2.dex */
public class InvestigateDialog extends DialogFragment {
    private final String connectionId;
    private EditText investigateEt;
    private RadioGroup investigateRadioGroup;
    private TagView investigateTag;
    private List<Investigate> investigates;
    private boolean labelRequired;
    public LoadingFragmentDialog loadingFragmentDialog;
    private Context mContext;
    private String name;
    private boolean proposalRequired;
    private List<Option> selectLabels;
    private final String sessionId;
    private final SubmitPingjiaListener submitListener;
    private String value;
    private final String way;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private String connectionId;
        private String sessionId;
        private SubmitPingjiaListener submitListener;
        private String type;

        public InvestigateDialog build() {
            return new InvestigateDialog(this.type, this.connectionId, this.sessionId, this.submitListener);
        }

        public Builder setConnectionId(String str) {
            this.connectionId = str;
            return this;
        }

        public Builder setSessionId(String str) {
            this.sessionId = str;
            return this;
        }

        public Builder setSubmitListener(SubmitPingjiaListener submitPingjiaListener) {
            this.submitListener = submitPingjiaListener;
            return this;
        }

        public Builder setType(String str) {
            this.type = str;
            return this;
        }
    }

    private void initView() {
        for (final int i2 = 0; i2 < this.investigates.size(); i2++) {
            RadioButton radioButton = new RadioButton(this.mContext);
            radioButton.setMaxEms(50);
            radioButton.setEllipsize(TextUtils.TruncateAt.END);
            radioButton.setText(ExpandableTextView.N + this.investigates.get(i2).name + "  ");
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(7, 7, 10, 7);
            radioButton.setLayoutParams(layoutParams);
            Drawable drawable = ContextCompat.getDrawable(this.mContext, R.drawable.ykfsdk_kf_radiobutton_selector);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            radioButton.setCompoundDrawables(drawable, null, null, null);
            radioButton.setButtonDrawable((Drawable) null);
            if (Build.VERSION.SDK_INT >= 16) {
                radioButton.setBackground(null);
            }
            this.investigateRadioGroup.addView(radioButton);
            radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.dialog.InvestigateDialog.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    InvestigateDialog.this.selectLabels.clear();
                    ArrayList arrayList = new ArrayList();
                    for (String str : ((Investigate) InvestigateDialog.this.investigates.get(i2)).reason) {
                        Option option = new Option();
                        option.name = str;
                        arrayList.add(option);
                        InvestigateDialog investigateDialog = InvestigateDialog.this;
                        investigateDialog.name = ((Investigate) investigateDialog.investigates.get(i2)).name;
                        InvestigateDialog investigateDialog2 = InvestigateDialog.this;
                        investigateDialog2.value = ((Investigate) investigateDialog2.investigates.get(i2)).value;
                        InvestigateDialog investigateDialog3 = InvestigateDialog.this;
                        investigateDialog3.labelRequired = ((Investigate) investigateDialog3.investigates.get(i2)).labelRequired;
                        InvestigateDialog investigateDialog4 = InvestigateDialog.this;
                        investigateDialog4.proposalRequired = ((Investigate) investigateDialog4.investigates.get(i2)).proposalRequired;
                    }
                    if (((Investigate) InvestigateDialog.this.investigates.get(i2)).reason.size() == 0) {
                        InvestigateDialog investigateDialog5 = InvestigateDialog.this;
                        investigateDialog5.name = ((Investigate) investigateDialog5.investigates.get(i2)).name;
                        InvestigateDialog investigateDialog6 = InvestigateDialog.this;
                        investigateDialog6.value = ((Investigate) investigateDialog6.investigates.get(i2)).value;
                        InvestigateDialog investigateDialog7 = InvestigateDialog.this;
                        investigateDialog7.labelRequired = ((Investigate) investigateDialog7.investigates.get(i2)).labelRequired;
                        InvestigateDialog investigateDialog8 = InvestigateDialog.this;
                        investigateDialog8.proposalRequired = ((Investigate) investigateDialog8.investigates.get(i2)).proposalRequired;
                    }
                    InvestigateDialog.this.investigateTag.initTagView(arrayList, 1);
                }
            });
        }
    }

    @Override // android.app.DialogFragment
    public void dismiss() {
        try {
            IMChat.getInstance().setNewinvestigate("");
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override // android.app.Fragment
    @NonNull
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.loadingFragmentDialog = new LoadingFragmentDialog();
        getDialog().setTitle(R.string.ykfsdk_ykf_submit_review);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.m7.imkfsdk.chat.dialog.InvestigateDialog.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return i2 == 4;
            }
        });
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(YKFConstants.MOOR_SP, 0);
        View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_dialog_investigate, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.investigate_title);
        this.investigateRadioGroup = (RadioGroup) inflate.findViewById(R.id.investigate_rg);
        this.investigateTag = (TagView) inflate.findViewById(R.id.investigate_second_tg);
        Button button = (Button) inflate.findViewById(R.id.investigate_save_btn);
        Button button2 = (Button) inflate.findViewById(R.id.investigate_cancel_btn);
        this.investigateEt = (EditText) inflate.findViewById(R.id.investigate_et);
        this.investigates = IMChatManager.getInstance().getInvestigate();
        initView();
        this.investigateTag.setOnSelectedChangeListener(new TagView.OnSelectedChangeListener() { // from class: com.m7.imkfsdk.chat.dialog.InvestigateDialog.2
            @Override // com.m7.imkfsdk.view.TagView.OnSelectedChangeListener
            public void getTagList(List<Option> list) {
                InvestigateDialog.this.selectLabels = list;
            }
        });
        Context context = this.mContext;
        int i2 = R.string.ykfsdk_ykf_submit_thanks;
        String string = sharedPreferences.getString(YKFConstants.SATISFYTITLE, context.getString(i2));
        if ("".equals(string)) {
            string = this.mContext.getString(i2);
        }
        textView.setText(string);
        Context context2 = this.mContext;
        int i3 = R.string.ykfsdk_ykf_submit_thankbay;
        final String string2 = sharedPreferences.getString(YKFConstants.SATISFYTHANK, context2.getString(i3));
        if ("".equals(string2)) {
            string2 = this.mContext.getString(i3);
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.dialog.InvestigateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!MoorUtils.isNetWorkConnected(InvestigateDialog.this.mContext)) {
                    Toast.makeText(InvestigateDialog.this.mContext, InvestigateDialog.this.mContext.getString(R.string.ykfsdk_notnetwork), 0).show();
                } else if (InvestigateDialog.this.proposalRequired && InvestigateDialog.this.investigateEt.getText().toString().trim().length() == 0) {
                    Toast.makeText(InvestigateDialog.this.mContext, R.string.ykfsdk_ykf_submit_reviewreason, 0).show();
                } else {
                    final ArrayList arrayList = new ArrayList();
                    if (InvestigateDialog.this.selectLabels.size() > 0) {
                        for (Option option : InvestigateDialog.this.selectLabels) {
                            arrayList.add(option.name);
                        }
                    }
                    if (!InvestigateDialog.this.labelRequired || arrayList.size() != 0) {
                        if (InvestigateDialog.this.name == null) {
                            Toast.makeText(InvestigateDialog.this.mContext, R.string.ykfsdk_ykf_submit_reviewchoose, 0).show();
                            return;
                        } else if (MoorAntiShakeUtils.getInstance().check()) {
                            return;
                        } else {
                            InvestigateDialog investigateDialog = InvestigateDialog.this;
                            investigateDialog.loadingFragmentDialog.show(investigateDialog.getFragmentManager(), "");
                            IMChatManager.getInstance().submitInvestigate(InvestigateDialog.this.sessionId, InvestigateDialog.this.connectionId, InvestigateDialog.this.way, InvestigateDialog.this.name, InvestigateDialog.this.value, arrayList, InvestigateDialog.this.investigateEt.getText().toString().trim(), new SubmitInvestigateListener() { // from class: com.m7.imkfsdk.chat.dialog.InvestigateDialog.3.1
                                @Override // com.moor.imkf.listener.SubmitInvestigateListener
                                public void onFailed() {
                                    InvestigateDialog.this.loadingFragmentDialog.dismiss();
                                    InvestigateDialog.this.submitListener.OnSubmitFailed();
                                    Toast.makeText(InvestigateDialog.this.mContext, R.string.ykfsdk_ykf_submit_reviewfail, 0).show();
                                    InvestigateDialog.this.dismiss();
                                }

                                @Override // com.moor.imkf.listener.SubmitInvestigateListener
                                public void onSuccess() {
                                    StringBuilder sb = new StringBuilder();
                                    if (arrayList.size() > 0) {
                                        for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                            sb.append((String) arrayList.get(i4));
                                            if (i4 != arrayList.size() - 1) {
                                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                            }
                                        }
                                    }
                                    InvestigateDialog.this.submitListener.OnSubmitSuccess(InvestigateDialog.this.getString(R.string.ykfsdk_ykf_user_commented) + ": " + InvestigateDialog.this.name + "; " + InvestigateDialog.this.getString(R.string.ykfsdk_ykf_investigate_lable) + ": " + ((Object) sb) + "; " + InvestigateDialog.this.getString(R.string.ykfsdk_ykf_detailed_information) + ": " + InvestigateDialog.this.investigateEt.getText().toString().trim(), string2);
                                    InvestigateDialog.this.loadingFragmentDialog.dismiss();
                                    InvestigateDialog.this.dismiss();
                                }
                            });
                            return;
                        }
                    }
                    Toast.makeText(InvestigateDialog.this.mContext, R.string.ykfsdk_ykf_submit_reviewtag, 0).show();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.dialog.InvestigateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvestigateDialog.this.submitListener.OnSubmitCancle();
                InvestigateDialog.this.dismiss();
            }
        });
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return inflate;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        if (isAdded()) {
            return;
        }
        try {
            super.show(fragmentManager, str);
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"ValidFragment"})
    private InvestigateDialog(String str, String str2, String str3, SubmitPingjiaListener submitPingjiaListener) {
        this.investigates = new ArrayList();
        this.selectLabels = new ArrayList();
        this.submitListener = submitPingjiaListener;
        this.way = str;
        this.connectionId = str2;
        this.sessionId = str3;
    }
}

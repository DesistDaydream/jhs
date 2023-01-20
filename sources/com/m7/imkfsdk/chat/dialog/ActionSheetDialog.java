package com.m7.imkfsdk.chat.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.m7.imkfsdk.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ActionSheetDialog {
    private Context context;
    private Dialog dialog;
    private dismiss dismissL;
    private Display display;
    private LinearLayout lLayout_content;
    private ScrollView sLayout_content;
    private List<SheetItem> sheetItemList;
    private boolean showTitle = false;
    private TextView txt_cancel;
    private TextView txt_title;

    /* loaded from: classes2.dex */
    public interface OnSheetItemClickListener {
        void onClick(int i2);
    }

    /* loaded from: classes2.dex */
    public class SheetItem {
        public SheetItemColor color;
        public OnSheetItemClickListener itemClickListener;
        public String name;

        public SheetItem(String str, SheetItemColor sheetItemColor, OnSheetItemClickListener onSheetItemClickListener) {
            this.name = str;
            this.color = sheetItemColor;
            this.itemClickListener = onSheetItemClickListener;
        }
    }

    /* loaded from: classes2.dex */
    public enum SheetItemColor {
        Blue("#037BFF"),
        Red("#FD4A2E"),
        BLACK("#23252F");
        
        private String name;

        SheetItemColor(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    /* loaded from: classes2.dex */
    public interface dismiss {
        void dismissListener();
    }

    public ActionSheetDialog(Context context) {
        this.context = context;
        this.display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private void setSheetItems() {
        List<SheetItem> list = this.sheetItemList;
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = this.sheetItemList.size();
        for (final int i2 = 1; i2 <= size; i2++) {
            SheetItem sheetItem = this.sheetItemList.get(i2 - 1);
            String str = sheetItem.name;
            SheetItemColor sheetItemColor = sheetItem.color;
            final OnSheetItemClickListener onSheetItemClickListener = sheetItem.itemClickListener;
            TextView textView = new TextView(this.context);
            textView.setText(str);
            textView.setTextSize(18.0f);
            textView.setGravity(17);
            if (this.showTitle) {
                if (i2 >= 1 && i2 < size) {
                    textView.setBackgroundResource(R.drawable.ykfsdk_white_shape_radius);
                } else {
                    textView.setBackgroundResource(R.drawable.ykfsdk_white_shape_radius);
                }
            } else if (i2 == 1) {
                textView.setBackgroundResource(R.drawable.ykfsdk_white_shape_radius);
            } else if (i2 < size) {
                textView.setBackgroundResource(R.drawable.ykfsdk_white_shape_radius);
            } else {
                textView.setBackgroundResource(R.drawable.ykfsdk_white_shape_radius);
            }
            if (sheetItemColor == null) {
                textView.setTextColor(Color.parseColor(SheetItemColor.Blue.getName()));
            } else {
                textView.setTextColor(Color.parseColor(sheetItemColor.getName()));
            }
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ((this.context.getResources().getDisplayMetrics().density * 45.0f) + 0.5f)));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.dialog.ActionSheetDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onSheetItemClickListener.onClick(i2);
                    ActionSheetDialog.this.dialog.dismiss();
                }
            });
            this.lLayout_content.addView(textView);
        }
    }

    public ActionSheetDialog addSheetItem(String str, SheetItemColor sheetItemColor, OnSheetItemClickListener onSheetItemClickListener) {
        if (this.sheetItemList == null) {
            this.sheetItemList = new ArrayList();
        }
        this.sheetItemList.add(new SheetItem(str, sheetItemColor, onSheetItemClickListener));
        return this;
    }

    public ActionSheetDialog builder() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.ykfsdk_pop_actionsheet, (ViewGroup) null);
        inflate.setMinimumWidth(this.display.getWidth());
        this.lLayout_content = (LinearLayout) inflate.findViewById(R.id.lLayout_content);
        this.txt_title = (TextView) inflate.findViewById(R.id.txt_title);
        TextView textView = (TextView) inflate.findViewById(R.id.txt_cancel);
        this.txt_cancel = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.dialog.ActionSheetDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActionSheetDialog.this.dialog.dismiss();
                if (ActionSheetDialog.this.dismissL != null) {
                    ActionSheetDialog.this.dismissL.dismissListener();
                }
            }
        });
        Dialog dialog = new Dialog(this.context, R.style.ykfsdk_ActionSheetDialogStyle);
        this.dialog = dialog;
        dialog.setContentView(inflate);
        Window window = this.dialog.getWindow();
        window.setGravity(83);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        return this;
    }

    public ActionSheetDialog setCanacleColor(SheetItemColor sheetItemColor) {
        this.txt_cancel.setTextColor(Color.parseColor(sheetItemColor.getName()));
        return this;
    }

    public ActionSheetDialog setCancelable(boolean z) {
        this.dialog.setCancelable(z);
        return this;
    }

    public ActionSheetDialog setCanceledOnTouchOutside(boolean z) {
        this.dialog.setCanceledOnTouchOutside(z);
        return this;
    }

    public ActionSheetDialog setDismissL(dismiss dismissVar) {
        this.dismissL = dismissVar;
        return this;
    }

    public ActionSheetDialog setTitle(String str) {
        this.showTitle = true;
        this.txt_title.setVisibility(0);
        this.txt_title.setText(str);
        return this;
    }

    public void show() {
        setSheetItems();
        this.dialog.show();
    }
}

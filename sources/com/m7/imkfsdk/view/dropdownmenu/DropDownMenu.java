package com.m7.imkfsdk.view.dropdownmenu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.m7.imkfsdk.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DropDownMenu extends LinearLayout {
    private boolean isDebug;
    private int mArrowMarginTitle;
    private int mCheckIcon;
    private int mColumnSelected;
    private Context mContext;
    private String[] mDefaultMenuTitle;
    private int mDownArrow;
    private boolean mDrawable;
    private List<ImageView> mIvMenuArrow;
    private List<MenuListAdapter> mMenuAdapters;
    private int mMenuBackColor;
    private int mMenuCount;
    private List<String[]> mMenuItems;
    private ListView mMenuList;
    private int mMenuListBackColor;
    private Drawable mMenuListBackDrawable;
    private Drawable mMenuListDivider;
    private int mMenuListSelectorRes;
    private int mMenuListTSelectedTextColor;
    private int mMenuListTextColor;
    private int mMenuListTextSize;
    private int mMenuPressedBackColor;
    private int mMenuPressedTitleTextColor;
    private OnMenuSelectedListener mMenuSelectedListener;
    private int mMenuTitleTextColor;
    private int mMenuTitleTextSize;
    private PopupWindow mPopupWindow;
    private List<RelativeLayout> mRlMenuBacks;
    private RelativeLayout mRlShadow;
    private int mRowSelected;
    private boolean mShowCheck;
    private int mShowCount;
    private boolean mShowDivider;
    private List<TextView> mTvMenuTitles;
    private int mUpArrow;

    public DropDownMenu(Context context) {
        super(context);
        this.mMenuAdapters = new ArrayList();
        this.mMenuItems = new ArrayList();
        this.mTvMenuTitles = new ArrayList();
        this.mRlMenuBacks = new ArrayList();
        this.mIvMenuArrow = new ArrayList();
        this.mRowSelected = 0;
        this.mColumnSelected = 0;
        this.mDrawable = false;
        this.isDebug = true;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.ykfsdk_kf_popupwindow_menu, (ViewGroup) null);
        this.mPopupWindow = new PopupWindow(inflate, -1, -2, true);
        this.mMenuList = (ListView) inflate.findViewById(R.id.lv_menu);
        this.mRlShadow = (RelativeLayout) inflate.findViewById(R.id.rl_menu_shadow);
        this.mMenuCount = 2;
        this.mShowCount = 5;
        this.mMenuTitleTextColor = getResources().getColor(R.color.ykfsdk_default_menu_text);
        this.mMenuPressedBackColor = getResources().getColor(R.color.ykfsdk_default_menu_press_back);
        this.mMenuPressedTitleTextColor = getResources().getColor(R.color.ykfsdk_default_menu_press_text);
        this.mMenuBackColor = getResources().getColor(R.color.ykfsdk_default_menu_back);
        Resources resources = getResources();
        int i2 = R.color.ykfsdk_all_white;
        this.mMenuListBackColor = resources.getColor(i2);
        this.mMenuListSelectorRes = getResources().getColor(i2);
        this.mMenuTitleTextSize = 18;
        this.mArrowMarginTitle = 10;
        this.mShowCheck = true;
        this.mShowDivider = true;
        this.mCheckIcon = R.drawable.ykfsdk_ico_make;
        this.mUpArrow = R.drawable.ykfsdk_arrow_up;
        this.mDownArrow = R.drawable.ykfsdk_arrow_down;
    }

    public String getmMenuItem(int i2, int i3) {
        return this.mMenuItems.get(i2)[i3];
    }

    public List<String[]> getmMenuItems() {
        return this.mMenuItems;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init();
    }

    public void setDefaultMenuTitle(String[] strArr) {
        this.mDefaultMenuTitle = strArr;
    }

    public void setIsDebug(boolean z) {
        this.isDebug = z;
    }

    public void setMenuSelectedListener(OnMenuSelectedListener onMenuSelectedListener) {
        this.mMenuSelectedListener = onMenuSelectedListener;
    }

    public void setSelectIndex(int i2) {
        init();
        if (this.mMenuListTSelectedTextColor != 0) {
            this.mMenuAdapters.get(0).setTextColorSelected(this.mMenuListTextColor);
        }
        this.mMenuList.setAdapter((ListAdapter) this.mMenuAdapters.get(0));
        if (this.mMenuAdapters.get(0).getCount() > this.mShowCount) {
            View view = this.mMenuAdapters.get(0).getView(0, null, this.mMenuList);
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.mMenuList.setLayoutParams(new RelativeLayout.LayoutParams(-1, view.getMeasuredHeight() * this.mShowCount));
        } else {
            this.mMenuAdapters.get(0).getView(0, null, this.mMenuList).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.mMenuList.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        }
        if (!this.mShowDivider) {
            this.mMenuList.setDivider(null);
        } else {
            Drawable drawable = this.mMenuListDivider;
            if (drawable != null) {
                this.mMenuList.setDivider(drawable);
            }
        }
        this.mMenuList.setBackgroundColor(this.mMenuListBackColor);
        Drawable drawable2 = this.mMenuListBackDrawable;
        if (drawable2 != null) {
            this.mMenuList.setBackgroundDrawable(drawable2);
        }
        this.mMenuList.setSelector(this.mMenuListSelectorRes);
        this.mColumnSelected = 0;
        this.mTvMenuTitles.get(0).setTextColor(this.mMenuPressedTitleTextColor);
        this.mIvMenuArrow.get(0).setImageResource(this.mUpArrow);
        this.mRowSelected = i2;
        this.mTvMenuTitles.get(this.mColumnSelected).setText(this.mMenuItems.get(this.mColumnSelected)[this.mRowSelected]);
        this.mIvMenuArrow.get(this.mColumnSelected).setImageResource(this.mDownArrow);
        this.mMenuAdapters.get(this.mColumnSelected).setSelectIndex(this.mRowSelected);
    }

    public void setShowCheck(boolean z) {
        this.mShowCheck = z;
    }

    public void setShowDivider(boolean z) {
        this.mShowDivider = z;
    }

    public void setmArrowMarginTitle(int i2) {
        this.mArrowMarginTitle = i2;
    }

    public void setmCheckIcon(int i2) {
        this.mCheckIcon = i2;
    }

    public void setmDownArrow(int i2) {
        this.mDownArrow = i2;
    }

    public void setmMenuBackColor(int i2) {
        this.mMenuBackColor = i2;
    }

    public void setmMenuCount(int i2) {
        this.mMenuCount = i2;
    }

    public void setmMenuItems(List<String[]> list) {
        this.mMenuItems = list;
        this.mDrawable = true;
        invalidate();
    }

    public void setmMenuListBackColor(int i2) {
        this.mMenuListBackColor = i2;
    }

    public void setmMenuListBackDrawable(Drawable drawable) {
        this.mMenuListBackDrawable = drawable;
    }

    public void setmMenuListDivider(Drawable drawable) {
        this.mMenuListDivider = drawable;
    }

    public void setmMenuListSelectedTextColor(int i2) {
        this.mMenuListTSelectedTextColor = i2;
    }

    public void setmMenuListSelectorRes(int i2) {
        this.mMenuListSelectorRes = i2;
    }

    public void setmMenuListTextColor(int i2) {
        this.mMenuListTextColor = i2;
        for (int i3 = 0; i3 < this.mMenuAdapters.size(); i3++) {
            this.mMenuAdapters.get(i3).setTextColor(this.mMenuListTextColor);
        }
    }

    public void setmMenuListTextSize(int i2) {
        this.mMenuListTextSize = i2;
        for (int i3 = 0; i3 < this.mMenuAdapters.size(); i3++) {
            this.mMenuAdapters.get(i3).setTextSize(i2);
        }
    }

    public void setmMenuPressedBackColor(int i2) {
        this.mMenuPressedBackColor = i2;
    }

    public void setmMenuPressedTitleTextColor(int i2) {
        this.mMenuPressedTitleTextColor = i2;
    }

    public void setmMenuTitleTextColor(int i2) {
        this.mMenuTitleTextColor = i2;
    }

    public void setmMenuTitleTextSize(int i2) {
        this.mMenuTitleTextSize = i2;
    }

    public void setmShowCount(int i2) {
        this.mShowCount = i2;
    }

    public void setmUpArrow(int i2) {
        this.mUpArrow = i2;
    }

    public DropDownMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMenuAdapters = new ArrayList();
        this.mMenuItems = new ArrayList();
        this.mTvMenuTitles = new ArrayList();
        this.mRlMenuBacks = new ArrayList();
        this.mIvMenuArrow = new ArrayList();
        this.mRowSelected = 0;
        this.mColumnSelected = 0;
        this.mDrawable = false;
        this.isDebug = true;
        init(context);
    }

    private void init() {
        if (this.mDrawable) {
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOutsideTouchable(true);
            this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
            this.mRlShadow.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.dropdownmenu.DropDownMenu.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DropDownMenu.this.mPopupWindow.dismiss();
                }
            });
            this.mMenuList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.m7.imkfsdk.view.dropdownmenu.DropDownMenu.2
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    DropDownMenu.this.mPopupWindow.dismiss();
                    DropDownMenu.this.mRowSelected = i2;
                    ((TextView) DropDownMenu.this.mTvMenuTitles.get(DropDownMenu.this.mColumnSelected)).setText(((String[]) DropDownMenu.this.mMenuItems.get(DropDownMenu.this.mColumnSelected))[DropDownMenu.this.mRowSelected]);
                    ((ImageView) DropDownMenu.this.mIvMenuArrow.get(DropDownMenu.this.mColumnSelected)).setImageResource(DropDownMenu.this.mDownArrow);
                    ((MenuListAdapter) DropDownMenu.this.mMenuAdapters.get(DropDownMenu.this.mColumnSelected)).setSelectIndex(DropDownMenu.this.mRowSelected);
                    if (DropDownMenu.this.mMenuSelectedListener != null || !DropDownMenu.this.isDebug) {
                        DropDownMenu.this.mMenuSelectedListener.onSelected(view, DropDownMenu.this.mRowSelected, DropDownMenu.this.mColumnSelected);
                    } else {
                        Toast.makeText(DropDownMenu.this.mContext, "MenuSelectedListener is  null", 1).show();
                    }
                }
            });
            this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.m7.imkfsdk.view.dropdownmenu.DropDownMenu.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    for (int i2 = 0; i2 < DropDownMenu.this.mMenuCount; i2++) {
                        ((ImageView) DropDownMenu.this.mIvMenuArrow.get(i2)).setImageDrawable(ContextCompat.getDrawable(DropDownMenu.this.getContext(), DropDownMenu.this.mDownArrow));
                        ((TextView) DropDownMenu.this.mTvMenuTitles.get(i2)).setTextColor(DropDownMenu.this.mMenuTitleTextColor);
                    }
                }
            });
            if (this.mMenuItems.size() != this.mMenuCount) {
                if (this.isDebug) {
                    Toast.makeText(this.mContext, "Menu item is not setted or incorrect", 1).show();
                    return;
                }
                return;
            }
            if (this.mMenuAdapters.size() == 0) {
                for (int i2 = 0; i2 < this.mMenuCount; i2++) {
                    MenuListAdapter menuListAdapter = new MenuListAdapter(this.mContext, this.mMenuItems.get(i2));
                    menuListAdapter.setShowCheck(this.mShowCheck);
                    menuListAdapter.setCheckIcon(this.mCheckIcon);
                    this.mMenuAdapters.add(menuListAdapter);
                }
            } else if (this.mMenuAdapters.size() != this.mMenuCount) {
                if (this.isDebug) {
                    Toast.makeText(this.mContext, "If you want set Adapter by yourself,please ensure the number of adpaters equal mMenuCount", 1).show();
                    return;
                }
                return;
            }
            getWidth();
            for (final int i3 = 0; i3 < this.mMenuCount; i3++) {
                final RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ykfsdk_kf_menu_item, (ViewGroup) null, false);
                TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_menu_title);
                textView.setTextColor(this.mMenuTitleTextColor);
                textView.setTextSize(this.mMenuTitleTextSize);
                String[] strArr = this.mDefaultMenuTitle;
                if (strArr != null && strArr.length != 0) {
                    textView.setText(this.mContext.getString(R.string.ykfsdk_ykf_please_choose));
                } else {
                    textView.setText(this.mMenuItems.get(i3)[0]);
                }
                addView(relativeLayout, i3);
                this.mTvMenuTitles.add(textView);
                this.mRlMenuBacks.add((RelativeLayout) relativeLayout.findViewById(R.id.rl_menu_head));
                this.mIvMenuArrow.add((ImageView) relativeLayout.findViewById(R.id.iv_menu_arrow));
                this.mIvMenuArrow.get(i3).setImageResource(this.mDownArrow);
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.dropdownmenu.DropDownMenu.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (DropDownMenu.this.mMenuListTSelectedTextColor != 0) {
                            ((MenuListAdapter) DropDownMenu.this.mMenuAdapters.get(i3)).setTextColorSelected(DropDownMenu.this.mMenuListTextColor);
                        }
                        DropDownMenu.this.mMenuList.setAdapter((ListAdapter) DropDownMenu.this.mMenuAdapters.get(i3));
                        if (((MenuListAdapter) DropDownMenu.this.mMenuAdapters.get(i3)).getCount() > DropDownMenu.this.mShowCount) {
                            View view2 = ((MenuListAdapter) DropDownMenu.this.mMenuAdapters.get(i3)).getView(0, null, DropDownMenu.this.mMenuList);
                            view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                            DropDownMenu.this.mMenuList.setLayoutParams(new RelativeLayout.LayoutParams(-1, view2.getMeasuredHeight() * DropDownMenu.this.mShowCount));
                        } else {
                            ((MenuListAdapter) DropDownMenu.this.mMenuAdapters.get(i3)).getView(0, null, DropDownMenu.this.mMenuList).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                            DropDownMenu.this.mMenuList.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                        }
                        if (!DropDownMenu.this.mShowDivider) {
                            DropDownMenu.this.mMenuList.setDivider(null);
                        } else if (DropDownMenu.this.mMenuListDivider != null) {
                            DropDownMenu.this.mMenuList.setDivider(DropDownMenu.this.mMenuListDivider);
                        }
                        DropDownMenu.this.mMenuList.setBackgroundColor(DropDownMenu.this.mMenuListBackColor);
                        if (DropDownMenu.this.mMenuListBackDrawable != null) {
                            DropDownMenu.this.mMenuList.setBackgroundDrawable(DropDownMenu.this.mMenuListBackDrawable);
                        }
                        DropDownMenu.this.mMenuList.setSelector(DropDownMenu.this.mMenuListSelectorRes);
                        DropDownMenu.this.mColumnSelected = i3;
                        ((TextView) DropDownMenu.this.mTvMenuTitles.get(i3)).setTextColor(DropDownMenu.this.mMenuPressedTitleTextColor);
                        ((ImageView) DropDownMenu.this.mIvMenuArrow.get(i3)).setImageResource(DropDownMenu.this.mUpArrow);
                        DropDownMenu.this.mPopupWindow.showAsDropDown(relativeLayout);
                    }
                });
            }
            this.mDrawable = false;
        }
    }
}

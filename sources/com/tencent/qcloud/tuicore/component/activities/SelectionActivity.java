package com.tencent.qcloud.tuicore.component.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SelectionActivity extends BaseLightActivity {
    private static OnResultReturnListener sOnResultReturnListener;
    private EditText input;
    private int mSelectionType;
    private OnItemClickListener onItemClickListener;
    private SelectAdapter selectListAdapter;
    private RecyclerView selectListView;
    private ArrayList<String> selectList = new ArrayList<>();
    private int selectedItem = -1;
    private boolean needConfirm = true;
    private boolean returnNow = true;

    /* loaded from: classes3.dex */
    public interface OnItemClickListener {
        void onClick(int i2);
    }

    /* loaded from: classes3.dex */
    public interface OnResultReturnListener {
        void onReturn(Object obj);
    }

    /* loaded from: classes3.dex */
    public class SelectAdapter extends RecyclerView.Adapter<SelectViewHolder> {
        public int selectedItem = -1;
        public ArrayList<String> data = new ArrayList<>();

        /* loaded from: classes3.dex */
        public class SelectViewHolder extends RecyclerView.ViewHolder {
            public TextView name;
            public ImageView selectedIcon;

            public SelectViewHolder(@NonNull View view) {
                super(view);
                this.name = (TextView) view.findViewById(R.id.name);
                this.selectedIcon = (ImageView) view.findViewById(R.id.selected_icon);
            }
        }

        public SelectAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.data.size();
        }

        public void setData(ArrayList<String> arrayList) {
            this.data.clear();
            this.data.addAll(arrayList);
        }

        public void setSelectedItem(int i2) {
            this.selectedItem = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull SelectViewHolder selectViewHolder, final int i2) {
            selectViewHolder.name.setText(this.data.get(i2));
            if (this.selectedItem == i2) {
                selectViewHolder.selectedIcon.setVisibility(0);
            } else {
                selectViewHolder.selectedIcon.setVisibility(8);
            }
            selectViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.activities.SelectionActivity.SelectAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SelectionActivity.this.onItemClickListener.onClick(i2);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public SelectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            return new SelectViewHolder(LayoutInflater.from(SelectionActivity.this).inflate(R.layout.core_select_item_layout, viewGroup, false));
        }
    }

    /* loaded from: classes3.dex */
    public static class Selection {
        public static final String CONTENT = "content";
        public static final String DEFAULT_SELECT_ITEM_INDEX = "default_select_item_index";
        public static final String INIT_CONTENT = "init_content";
        public static final String LIMIT = "limit";
        public static final String LIST = "list";
        public static final String NEED_CONFIRM = "needConfirm";
        public static final String RETURN_NOW = "returnNow";
        public static final String SELECT_ALL = "select_all";
        public static final String TITLE = "title";
        public static final String TYPE = "type";
        public static final int TYPE_LIST = 2;
        public static final int TYPE_TEXT = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void echoClick() {
        OnResultReturnListener onResultReturnListener;
        int i2 = this.mSelectionType;
        if (i2 == 1) {
            OnResultReturnListener onResultReturnListener2 = sOnResultReturnListener;
            if (onResultReturnListener2 != null) {
                onResultReturnListener2.onReturn(this.input.getText().toString());
            }
        } else if (i2 == 2 && (onResultReturnListener = sOnResultReturnListener) != null) {
            onResultReturnListener.onReturn(Integer.valueOf(this.selectedItem));
        }
        if (this.returnNow) {
            finish();
        }
    }

    public static void startListSelection(Context context, Bundle bundle, OnResultReturnListener onResultReturnListener) {
        bundle.putInt("type", 2);
        startSelection(context, bundle, onResultReturnListener);
    }

    private static void startSelection(Context context, Bundle bundle, OnResultReturnListener onResultReturnListener) {
        Intent intent = new Intent(context, SelectionActivity.class);
        intent.putExtra("content", bundle);
        intent.addFlags(268435456);
        context.startActivity(intent);
        sOnResultReturnListener = onResultReturnListener;
    }

    public static void startTextSelection(Context context, Bundle bundle, OnResultReturnListener onResultReturnListener) {
        bundle.putInt("type", 1);
        startSelection(context, bundle, onResultReturnListener);
    }

    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tuicore_selection_activity);
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.edit_title_bar);
        this.selectListView = (RecyclerView) findViewById(R.id.select_list);
        SelectAdapter selectAdapter = new SelectAdapter();
        this.selectListAdapter = selectAdapter;
        this.selectListView.setAdapter(selectAdapter);
        this.selectListView.setLayoutManager(new CustomLinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, 1);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.core_list_divider));
        this.selectListView.addItemDecoration(dividerItemDecoration);
        this.onItemClickListener = new OnItemClickListener() { // from class: com.tencent.qcloud.tuicore.component.activities.SelectionActivity.1
            @Override // com.tencent.qcloud.tuicore.component.activities.SelectionActivity.OnItemClickListener
            public void onClick(int i2) {
                SelectionActivity.this.selectedItem = i2;
                SelectionActivity.this.selectListAdapter.setSelectedItem(i2);
                SelectionActivity.this.selectListAdapter.notifyDataSetChanged();
                if (SelectionActivity.this.needConfirm) {
                    return;
                }
                SelectionActivity.this.echoClick();
            }
        };
        this.input = (EditText) findViewById(R.id.edit_content_et);
        Bundle bundleExtra = getIntent().getBundleExtra("content");
        int i2 = bundleExtra.getInt("type");
        if (i2 == 1) {
            this.selectListView.setVisibility(8);
            String string = bundleExtra.getString("init_content");
            int i3 = bundleExtra.getInt("limit");
            if (!TextUtils.isEmpty(string)) {
                this.input.setText(string);
                this.input.setSelection(string.length());
            }
            if (i3 > 0) {
                this.input.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3)});
            }
        } else if (i2 != 2) {
            finish();
            return;
        } else {
            this.input.setVisibility(8);
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("list");
            this.selectedItem = bundleExtra.getInt("default_select_item_index");
            if (stringArrayList == null || stringArrayList.size() == 0) {
                return;
            }
            this.selectList.clear();
            this.selectList.addAll(stringArrayList);
            this.selectListAdapter.setSelectedItem(this.selectedItem);
            this.selectListAdapter.setData(this.selectList);
            this.selectListAdapter.notifyDataSetChanged();
        }
        this.mSelectionType = bundleExtra.getInt("type");
        String string2 = bundleExtra.getString("title");
        this.needConfirm = bundleExtra.getBoolean(Selection.NEED_CONFIRM, true);
        this.returnNow = bundleExtra.getBoolean(Selection.RETURN_NOW, true);
        titleBarLayout.setTitle(string2, ITitleBarLayout.Position.MIDDLE);
        titleBarLayout.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.activities.SelectionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectionActivity.this.finish();
            }
        });
        titleBarLayout.getRightIcon().setVisibility(8);
        if (this.needConfirm) {
            titleBarLayout.getRightTitle().setText(getResources().getString(R.string.sure));
            titleBarLayout.setOnRightClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.activities.SelectionActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SelectionActivity.this.echoClick();
                }
            });
            return;
        }
        titleBarLayout.getRightGroup().setVisibility(8);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        sOnResultReturnListener = null;
    }
}

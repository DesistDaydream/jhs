package com.tencent.qcloud.tuikit.tuichat.component.popmenu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ChatPopMenu {
    private static final int COLUMN_NUM = 4;
    private static final int SHADOW_WIDTH = 10;
    private static final int Y_OFFSET = 8;
    private final MenuAdapter adapter;
    private final Context context;
    private MessageRecyclerView.OnEmptySpaceClickListener mEmptySpaceClickListener;
    private View popupView;
    private final PopupWindow popupWindow;
    private RecyclerView recyclerView;
    private final List<ChatPopMenuAction> chatPopMenuActionList = new ArrayList();
    private ChatPopMenu chatPopMenu = this;

    /* loaded from: classes3.dex */
    public static class ChatPopMenuAction {
        private OnClickListener actionClickListener;
        private int actionIcon;
        private String actionName;

        @FunctionalInterface
        /* loaded from: classes3.dex */
        public interface OnClickListener {
            void onClick();
        }

        public OnClickListener getActionClickListener() {
            return this.actionClickListener;
        }

        public int getActionIcon() {
            return this.actionIcon;
        }

        public String getActionName() {
            return this.actionName;
        }

        public void setActionClickListener(OnClickListener onClickListener) {
            this.actionClickListener = onClickListener;
        }

        public void setActionIcon(int i2) {
            this.actionIcon = i2;
        }

        public void setActionName(String str) {
            this.actionName = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class GridDecoration extends RecyclerView.ItemDecoration {
        private final int columnNum;
        private final Drawable divider;
        private final int leftRightSpace;
        private final int topBottomSpace;

        public GridDecoration(Drawable drawable, int i2, int i3, int i4) {
            this.divider = drawable;
            this.columnNum = i2;
            this.leftRightSpace = i3;
            this.topBottomSpace = i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i2 = this.columnNum;
            int i3 = childAdapterPosition % i2;
            int i4 = this.leftRightSpace;
            rect.left = (i3 * i4) / i2;
            rect.right = i4 - (((i3 + 1) * i4) / i2);
            if (childAdapterPosition >= i2) {
                rect.top = this.topBottomSpace;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            canvas.save();
            int ceil = ((int) Math.ceil((recyclerView.getChildCount() * 1.0f) / this.columnNum)) - 1;
            for (int i2 = 0; i2 < ceil; i2++) {
                View childAt = recyclerView.getChildAt(this.columnNum * i2);
                int i3 = this.columnNum;
                View childAt2 = recyclerView.getChildAt((i2 * i3) + (i3 - 1));
                int bottom = childAt.getBottom();
                this.divider.setBounds(childAt.getLeft(), (bottom - this.divider.getIntrinsicHeight()) + (this.topBottomSpace / 2), childAt2.getRight(), bottom + (this.topBottomSpace / 2));
                this.divider.draw(canvas);
            }
            canvas.restore();
        }
    }

    /* loaded from: classes3.dex */
    public class MenuAdapter extends RecyclerView.Adapter<MenuItemViewHolder> {

        /* loaded from: classes3.dex */
        public class MenuItemViewHolder extends RecyclerView.ViewHolder {
            public ImageView icon;
            public TextView title;

            public MenuItemViewHolder(@NonNull View view) {
                super(view);
                this.title = (TextView) view.findViewById(R.id.menu_title);
                this.icon = (ImageView) view.findViewById(R.id.menu_icon);
            }
        }

        public MenuAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ChatPopMenu.this.chatPopMenuActionList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull MenuItemViewHolder menuItemViewHolder, int i2) {
            final ChatPopMenuAction chatPopMenuAction = ChatPopMenu.this.getChatPopMenuAction(i2);
            menuItemViewHolder.title.setText(chatPopMenuAction.actionName);
            menuItemViewHolder.icon.setImageDrawable(ResourcesCompat.getDrawable(ChatPopMenu.this.context.getResources(), chatPopMenuAction.actionIcon, null));
            menuItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.popmenu.ChatPopMenu.MenuAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    chatPopMenuAction.actionClickListener.onClick();
                    ChatPopMenu.this.chatPopMenu.hide();
                    if (ChatPopMenu.this.mEmptySpaceClickListener != null) {
                        ChatPopMenu.this.mEmptySpaceClickListener.onClick();
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public MenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            return new MenuItemViewHolder(LayoutInflater.from(ChatPopMenu.this.context).inflate(R.layout.chat_pop_menu_item_layout, (ViewGroup) null));
        }
    }

    public ChatPopMenu(Context context) {
        this.context = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.chat_pop_menu_layout, (ViewGroup) null);
        this.popupView = inflate;
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.chat_pop_menu_content_view);
        this.recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        MenuAdapter menuAdapter = new MenuAdapter();
        this.adapter = menuAdapter;
        this.recyclerView.setAdapter(menuAdapter);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.chat_pop_menu_item_space_width);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.chat_pop_menu_item_space_height);
        this.recyclerView.addItemDecoration(new GridDecoration(context.getResources().getDrawable(R.drawable.chat_pop_menu_divider), 4, dimensionPixelSize, dimensionPixelSize2));
        PopupWindow popupWindow = new PopupWindow(this.popupView, -2, -2, false);
        this.popupWindow = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatPopMenuAction getChatPopMenuAction(int i2) {
        return this.chatPopMenuActionList.get(i2);
    }

    public Drawable getBackgroundDrawable(final float f2, final float f3, final float f4, final float f5, final boolean z, final float f6) {
        final Path path = new Path();
        return new Drawable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.popmenu.ChatPopMenu.1
            @Override // android.graphics.drawable.Drawable
            public void draw(@NonNull Canvas canvas) {
                Paint paint = new Paint();
                paint.setColor(-1);
                paint.setStyle(Paint.Style.FILL);
                paint.setShadowLayer(r2, 0.0f, 0.0f, -5592406);
                if (z) {
                    Path path2 = path;
                    int i2 = r2;
                    float f7 = f5;
                    RectF rectF = new RectF(i2, i2 + f7, f2 - i2, (f3 + f7) - i2);
                    float f8 = f6;
                    path2.addRoundRect(rectF, f8, f8, Path.Direction.CW);
                    Path path3 = path;
                    float f9 = f4;
                    float f10 = f5;
                    path3.moveTo(f9 - f10, f10 + r2);
                    path.lineTo(f4, r2);
                    Path path4 = path;
                    float f11 = f4;
                    float f12 = f5;
                    path4.lineTo(f11 + f12, f12 + r2);
                } else {
                    Path path5 = path;
                    int i3 = r2;
                    RectF rectF2 = new RectF(i3, i3, f2 - i3, f3 - i3);
                    float f13 = f6;
                    path5.addRoundRect(rectF2, f13, f13, Path.Direction.CW);
                    path.moveTo(f4 - f5, f3 - r2);
                    path.lineTo(f4, (f3 + f5) - r2);
                    path.lineTo(f4 + f5, f3 - r2);
                }
                path.close();
                canvas.drawPath(path, paint);
            }

            @Override // android.graphics.drawable.Drawable
            public int getOpacity() {
                return -3;
            }

            @Override // android.graphics.drawable.Drawable
            public void setAlpha(int i2) {
            }

            @Override // android.graphics.drawable.Drawable
            public void setColorFilter(@Nullable ColorFilter colorFilter) {
            }
        };
    }

    public void hide() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.popupWindow.dismiss();
    }

    public void setChatPopMenuActionList(List<ChatPopMenuAction> list) {
        this.chatPopMenuActionList.clear();
        this.chatPopMenuActionList.addAll(list);
        this.adapter.notifyDataSetChanged();
    }

    public void setEmptySpaceClickListener(MessageRecyclerView.OnEmptySpaceClickListener onEmptySpaceClickListener) {
        this.mEmptySpaceClickListener = onEmptySpaceClickListener;
    }

    public void show(View view, int i2) {
        float f2;
        if (this.chatPopMenuActionList.size() == 0) {
            return;
        }
        float width = view.getWidth();
        float height = view.getHeight();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.dimen.chat_pop_menu_indicator_height);
        int ceil = (int) Math.ceil((this.chatPopMenuActionList.size() * 1.0f) / 4.0f);
        if (this.popupWindow != null) {
            int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.chat_pop_menu_item_space_width);
            int dimensionPixelSize2 = this.context.getResources().getDimensionPixelSize(R.dimen.chat_pop_menu_item_space_height);
            int dip2px = ScreenUtil.dip2px(36.72f);
            int dip2px2 = ScreenUtil.dip2px(36.72f);
            int dip2px3 = ScreenUtil.dip2px(18.0f);
            int dip2px4 = ScreenUtil.dip2px(18.0f);
            int min = Math.min(this.chatPopMenuActionList.size(), 4);
            int i3 = (((dip2px * min) + (dip2px3 * 2)) + ((min - 1) * dimensionPixelSize)) - 10;
            int i4 = (((dip2px2 * ceil) + (dip2px4 * 2)) + ((ceil - 1) * dimensionPixelSize2)) - 10;
            float f3 = width / 2.0f;
            int screenWidth = ScreenUtil.getScreenWidth(this.context);
            int i5 = iArr[0];
            int i6 = ((iArr[1] - i4) - dimensionPixelOffset) - 8;
            if ((iArr[0] * 2) + width > screenWidth) {
                float f4 = i3;
                f3 = f4 - f3;
                i5 = (int) ((iArr[0] + width) - f4);
            }
            boolean z = i6 <= i2;
            if (z) {
                i6 = ((int) (iArr[1] + height)) + 8;
                i4 -= dimensionPixelOffset;
            }
            if (f3 > 0.0f) {
                float f5 = i3;
                if (f3 <= f5 && f5 >= width) {
                    f2 = f3;
                    this.popupView.setBackground(getBackgroundDrawable(i3, i4, f2, dimensionPixelOffset, z, 16.0f));
                    this.popupWindow.showAtLocation(view, 0, i5, i6);
                }
            }
            f2 = (i3 * 1.0f) / 2.0f;
            this.popupView.setBackground(getBackgroundDrawable(i3, i4, f2, dimensionPixelOffset, z, 16.0f));
            this.popupWindow.showAtLocation(view, 0, i5, i6);
        }
    }
}

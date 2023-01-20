package com.tencent.qcloud.tuikit.tuichat.ui.view.input.face;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuicore.util.SoftKeyBoardUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceGroup;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.BaseInputFragment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FaceFragment extends BaseInputFragment implements View.OnClickListener {
    public ArrayList<FaceGroup> customFaces;
    public ArrayList<Emoji> emojiList;
    public FaceGroupIcon faceFirstSetTv;
    public LinearLayout faceGroup;
    public EmojiIndicatorView faceIndicator;
    public ViewPager faceViewPager;
    private OnEmojiClickListener listener;
    public FaceGroupIcon mCurrentSelected;
    private RecentEmojiManager recentManager;
    public ArrayList<Emoji> recentlyEmojiList;
    public ArrayList<View> ViewPagerItems = new ArrayList<>();
    private int mCurrentGroupIndex = 0;
    private int columns = 7;
    private int rows = 3;
    private int vMargin = 0;

    /* loaded from: classes3.dex */
    public class FaceGVAdapter extends BaseAdapter {
        private List<Emoji> list;
        private Context mContext;

        /* loaded from: classes3.dex */
        public class ViewHolder {
            public ImageView iv;
            public TextView tv;

            public ViewHolder() {
            }
        }

        public FaceGVAdapter(List<Emoji> list, Context context) {
            this.list = list;
            this.mContext = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return this.list.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            ViewHolder viewHolder;
            Emoji emoji = this.list.get(i2);
            if (view == null) {
                viewHolder = new ViewHolder();
                view2 = LayoutInflater.from(this.mContext).inflate(R.layout.item_face, (ViewGroup) null);
                viewHolder.iv = (ImageView) view2.findViewById(R.id.face_image);
                viewHolder.tv = (TextView) view2.findViewById(R.id.face_tv);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewHolder.iv.getLayoutParams();
                if (emoji != null) {
                    layoutParams.width = emoji.getWidth();
                    layoutParams.height = emoji.getHeight();
                }
                viewHolder.iv.setLayoutParams(layoutParams);
                view2.setTag(viewHolder);
            } else {
                view2 = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            if (emoji != null) {
                viewHolder.iv.setImageBitmap(emoji.getIcon());
                viewHolder.tv.setText(emoji.getDesc());
            }
            return view2;
        }
    }

    /* loaded from: classes3.dex */
    public class FaceVPAdapter extends PagerAdapter {
        private List<View> views;

        public FaceVPAdapter(List<View> list) {
            this.views = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(View view, int i2, Object obj) {
            ((ViewPager) view).removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.views.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(View view, int i2) {
            ((ViewPager) view).addView(this.views.get(i2));
            return this.views.get(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: classes3.dex */
    public interface OnEmojiClickListener {
        void onCustomFaceClick(int i2, Emoji emoji);

        void onEmojiClick(Emoji emoji);

        void onEmojiDelete();
    }

    public static FaceFragment Instance() {
        FaceFragment faceFragment = new FaceFragment();
        faceFragment.setArguments(new Bundle());
        return faceFragment;
    }

    private int getPagerCount(ArrayList<Emoji> arrayList) {
        int size = arrayList.size();
        int i2 = this.mCurrentGroupIndex > 0 ? 0 : 1;
        int i3 = this.columns;
        int i4 = this.rows;
        return size % ((i3 * i4) - i2) == 0 ? size / ((i3 * i4) - i2) : (size / ((i3 * i4) - i2)) + 1;
    }

    private View getViewPagerItem(int i2, ArrayList<Emoji> arrayList) {
        GridView gridView = (GridView) ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.layout_face_grid, (ViewGroup) null).findViewById(R.id.chart_face_gv);
        final ArrayList arrayList2 = new ArrayList();
        int i3 = this.mCurrentGroupIndex > 0 ? 0 : 1;
        int i4 = this.columns;
        int i5 = this.rows;
        int i6 = ((i4 * i5) - i3) * i2;
        int i7 = i2 + 1;
        arrayList2.addAll(arrayList.subList(i6, ((i4 * i5) - i3) * i7 > arrayList.size() ? arrayList.size() : i7 * ((this.columns * this.rows) - i3)));
        if (this.mCurrentGroupIndex == 0 && arrayList2.size() < (this.columns * this.rows) - i3) {
            for (int size = arrayList2.size(); size < (this.columns * this.rows) - i3; size++) {
                arrayList2.add(null);
            }
        }
        if (this.mCurrentGroupIndex == 0) {
            Emoji emoji = new Emoji();
            emoji.setIcon(BitmapFactory.decodeResource(getResources(), R.drawable.face_delete));
            arrayList2.add(emoji);
        }
        gridView.setAdapter((ListAdapter) new FaceGVAdapter(arrayList2, getActivity()));
        gridView.setNumColumns(this.columns);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.face.FaceFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i8, long j2) {
                if (FaceFragment.this.mCurrentGroupIndex > 0) {
                    FaceFragment.this.listener.onCustomFaceClick(FaceFragment.this.mCurrentGroupIndex, (Emoji) arrayList2.get(i8));
                } else if (i8 == (FaceFragment.this.columns * FaceFragment.this.rows) - 1) {
                    if (FaceFragment.this.listener != null) {
                        FaceFragment.this.listener.onEmojiDelete();
                    }
                } else if (FaceFragment.this.listener != null) {
                    FaceFragment.this.listener.onEmojiClick((Emoji) arrayList2.get(i8));
                }
            }
        });
        return gridView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager(ArrayList<Emoji> arrayList, int i2, int i3) {
        this.columns = i2;
        this.rows = i3;
        if (arrayList.size() > 0) {
            this.vMargin = (SoftKeyBoardUtil.getSoftKeyBoardHeight() - (ScreenUtil.getPxByDp(60.0f) + (arrayList.get(0).getHeight() * i3))) / 4;
        }
        intiIndicator(arrayList);
        this.ViewPagerItems.clear();
        int pagerCount = getPagerCount(arrayList);
        for (int i4 = 0; i4 < pagerCount; i4++) {
            this.ViewPagerItems.add(getViewPagerItem(i4, arrayList));
        }
        this.faceViewPager.setAdapter(new FaceVPAdapter(this.ViewPagerItems));
        this.faceViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.face.FaceFragment.2
            public int oldPosition = 0;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i5) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i5, float f2, int i6) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i5) {
                FaceFragment.this.faceIndicator.playBy(this.oldPosition, i5);
                this.oldPosition = i5;
            }
        });
    }

    private void initViews() {
        this.customFaces = FaceManager.getCustomFaceList();
        int pxByDp = ScreenUtil.getPxByDp(70.0f);
        for (int size = this.customFaces.size() - 1; size >= 0; size--) {
            final FaceGroup faceGroup = this.customFaces.get(size);
            FaceGroupIcon faceGroupIcon = new FaceGroupIcon(getActivity());
            faceGroupIcon.setFaceTabIcon(faceGroup.getGroupIcon());
            this.mCurrentGroupIndex = faceGroup.getGroupId();
            ArrayList<Emoji> faces = faceGroup.getFaces();
            FaceGroupIcon faceGroupIcon2 = this.mCurrentSelected;
            if (faceGroupIcon2 != null) {
                faceGroupIcon2.setSelected(false);
            }
            initViewPager(faces, faceGroup.getPageColumnCount(), faceGroup.getPageRowCount());
            this.mCurrentSelected = faceGroupIcon;
            faceGroupIcon.setSelected(true);
            faceGroupIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.face.FaceFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FaceFragment faceFragment = FaceFragment.this;
                    if (faceFragment.mCurrentSelected != view) {
                        faceFragment.mCurrentGroupIndex = faceGroup.getGroupId();
                        ArrayList<Emoji> faces2 = faceGroup.getFaces();
                        FaceFragment.this.mCurrentSelected.setSelected(false);
                        FaceFragment.this.initViewPager(faces2, faceGroup.getPageColumnCount(), faceGroup.getPageRowCount());
                        FaceGroupIcon faceGroupIcon3 = (FaceGroupIcon) view;
                        FaceFragment.this.mCurrentSelected = faceGroupIcon3;
                        faceGroupIcon3.setSelected(true);
                    }
                }
            });
            this.faceGroup.addView(faceGroupIcon, 0, new LinearLayout.LayoutParams(pxByDp, -1));
        }
    }

    private void insertToRecentList(Emoji emoji) {
        if (emoji != null) {
            if (this.recentlyEmojiList.contains(emoji)) {
                this.recentlyEmojiList.set(this.recentlyEmojiList.indexOf(emoji), this.recentlyEmojiList.get(0));
                this.recentlyEmojiList.set(0, emoji);
                return;
            }
            int size = this.recentlyEmojiList.size();
            int i2 = this.rows;
            int i3 = this.columns;
            if (size == (i2 * i3) - 1) {
                this.recentlyEmojiList.remove((i2 * i3) - 2);
            }
            this.recentlyEmojiList.add(0, emoji);
        }
    }

    private void intiIndicator(ArrayList<Emoji> arrayList) {
        this.faceIndicator.init(getPagerCount(arrayList));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        if (activity instanceof OnEmojiClickListener) {
            this.listener = (OnEmojiClickListener) activity;
        }
        this.recentManager = RecentEmojiManager.make(activity);
        super.onAttach(activity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FaceGroupIcon faceGroupIcon;
        if (view.getId() != R.id.face_first_set || (faceGroupIcon = this.mCurrentSelected) == view) {
            return;
        }
        this.mCurrentGroupIndex = 0;
        faceGroupIcon.setSelected(false);
        this.mCurrentSelected = (FaceGroupIcon) view;
        initViewPager(this.emojiList, 7, 3);
        this.mCurrentSelected.setSelected(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        try {
            this.emojiList = FaceManager.getEmojiList();
            if (this.recentManager.getCollection(RecentEmojiManager.PREFERENCE_NAME) != null) {
                this.recentlyEmojiList = (ArrayList) this.recentManager.getCollection(RecentEmojiManager.PREFERENCE_NAME);
            } else {
                this.recentlyEmojiList = new ArrayList<>();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
        }
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_face, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        layoutParams.height = SoftKeyBoardUtil.getSoftKeyBoardHeight();
        inflate.setLayoutParams(layoutParams);
        this.faceViewPager = (ViewPager) inflate.findViewById(R.id.face_viewPager);
        this.faceIndicator = (EmojiIndicatorView) inflate.findViewById(R.id.face_indicator);
        this.faceFirstSetTv = (FaceGroupIcon) inflate.findViewById(R.id.face_first_set);
        this.faceGroup = (LinearLayout) inflate.findViewById(R.id.face_view_group);
        initViews();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        try {
            this.recentManager.putCollection(RecentEmojiManager.PREFERENCE_NAME, this.recentlyEmojiList);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void setListener(OnEmojiClickListener onEmojiClickListener) {
        this.listener = onEmojiClickListener;
    }
}

package e.l.r;

import com.jihuanshe.R;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuikit.tuichat.component.face.CustomFace;
import com.tencent.qcloud.tuikit.tuichat.component.face.CustomFaceConfig;
import com.tencent.qcloud.tuikit.tuichat.component.face.CustomFaceGroup;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import h.t1;

/* loaded from: classes2.dex */
public final class d0 {
    @k.e.a.d
    public static final d0 a = new d0();
    private static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f14270c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f14271d = 4;

    /* renamed from: e  reason: collision with root package name */
    private static final int f14272e = 4;

    /* loaded from: classes2.dex */
    public static final class a {
        private int a = -1;
        @k.e.a.e
        private String b;
        @k.e.a.e

        /* renamed from: c  reason: collision with root package name */
        private String f14273c;
        @k.e.a.e

        /* renamed from: d  reason: collision with root package name */
        private Integer f14274d;

        @k.e.a.d
        public final CustomFaceGroup a() {
            CustomFaceGroup customFaceGroup = new CustomFaceGroup();
            customFaceGroup.setFaceGroupId(this.a);
            customFaceGroup.setPageColumnCount(4);
            customFaceGroup.setPageRowCount(4);
            customFaceGroup.setFaceIconName(this.b);
            customFaceGroup.setFaceIconPath(this.f14273c);
            String[] stringArray = e.t.a.b().getResources().getStringArray(this.f14274d.intValue());
            int length = stringArray.length;
            int i2 = 0;
            while (i2 < length) {
                String str = stringArray[i2];
                i2++;
                CustomFace customFace = new CustomFace();
                customFace.setAssetPath("jihuanshe/" + this.a + Attributes.InternalPrefix + ((Object) str) + ".png");
                customFace.setFaceName(str);
                customFace.setFaceWidth(FaceManager.dip2px(e.t.a.b(), 80.0f));
                customFace.setFaceHeight(FaceManager.dip2px(e.t.a.b(), 80.0f));
                customFaceGroup.addCustomFace(customFace);
            }
            return customFaceGroup;
        }

        @k.e.a.d
        public final a b(@k.e.a.d String str) {
            this.b = str;
            return this;
        }

        @k.e.a.d
        public final a c(@k.e.a.d String str) {
            this.f14273c = str;
            return this;
        }

        @k.e.a.d
        public final a d(int i2) {
            this.f14274d = Integer.valueOf(i2);
            return this;
        }

        @k.e.a.d
        public final a e(int i2) {
            this.a = i2;
            return this;
        }
    }

    private d0() {
    }

    private final CustomFaceGroup a() {
        return new a().e(1).b("menu").c("jihuanshe/1/menu.png").d(R.array.jihuanshe_filter_key).a();
    }

    private final CustomFaceGroup b() {
        return new a().e(2).b("menu").c("jihuanshe/1/menu.png").d(R.array.jihuanwang_filter_key).a();
    }

    public final void c() {
        TUIChatConfigs configs = TUIChatConfigs.getConfigs();
        CustomFaceConfig customFaceConfig = new CustomFaceConfig();
        customFaceConfig.addFaceGroup(a.a());
        t1 t1Var = t1.a;
        configs.setCustomFaceConfig(customFaceConfig);
        if (TUIConfig.appContext == null) {
            TUIConfig.appContext = e.t.a.b();
        }
        FaceManager.loadFaceFiles();
    }
}

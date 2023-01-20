package e.l.n.c;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.ReasonResult;
import com.jihuanshe.model.ReplyDetailInfo;
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.model.ReviewMineInfo;
import com.jihuanshe.model.TopCommentInfo;
import com.jihuanshe.model.UpdateReviewBody;
import com.jihuanshe.net.config.NetService;
import com.jihuanshe.ui.widget.GameBar;
import h.t1;
import java.util.List;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.MARKET)
/* loaded from: classes2.dex */
public interface f {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Flow a(f fVar, String str, Integer num, Integer num2, Integer num3, String str2, String str3, int i2, Object obj) {
            String str4;
            String str5;
            if (obj == null) {
                if ((i2 & 16) != 0) {
                    Game value = GameBar.b.a().getValue();
                    String gameKey = value == null ? null : value.getGameKey();
                    if (gameKey == null) {
                        gameKey = "";
                    }
                    str4 = gameKey;
                } else {
                    str4 = str2;
                }
                if ((i2 & 32) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str5 = gameSubKey != null ? gameSubKey : "";
                } else {
                    str5 = str3;
                }
                return fVar.g(str, num, num2, num3, str4, str5);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTopComments");
        }

        public static /* synthetic */ Flow b(f fVar, int i2, String str, String str2, List list, String str3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 16) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str3 = value == null ? null : value.getGameKey();
                    if (str3 == null) {
                        str3 = "";
                    }
                }
                return fVar.k(i2, str, str2, list, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goErrorCorrect");
        }

        public static /* synthetic */ Flow c(f fVar, int i2, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str = value == null ? null : value.getGameKey();
                    if (str == null) {
                        str = "";
                    }
                }
                return fVar.b(i2, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goLike");
        }

        public static /* synthetic */ Flow d(f fVar, Integer num, Integer num2, String str, int i2, String str2, String str3, String str4, int i3, Object obj) {
            String str5;
            String str6;
            if (obj == null) {
                if ((i3 & 32) != 0) {
                    Game value = GameBar.b.a().getValue();
                    String gameKey = value == null ? null : value.getGameKey();
                    if (gameKey == null) {
                        gameKey = "";
                    }
                    str5 = gameKey;
                } else {
                    str5 = str3;
                }
                if ((i3 & 64) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str6 = gameSubKey != null ? gameSubKey : "";
                } else {
                    str6 = str4;
                }
                return fVar.h(num, num2, str, i2, str2, str5, str6);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goReviewsAndScore");
        }

        public static /* synthetic */ Flow e(f fVar, int i2, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str = value == null ? null : value.getGameKey();
                    if (str == null) {
                        str = "";
                    }
                }
                return fVar.a(i2, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goUnlike");
        }
    }

    @l.y.e
    @l.y.o("card-versions/unlike")
    @k.e.a.d
    Flow<t1> a(@l.y.c("card_version_id") int i2, @k.e.a.e @l.y.c("game_key") String str);

    @l.y.e
    @l.y.o("card-versions/like")
    @k.e.a.d
    Flow<t1> b(@l.y.c("card_version_id") int i2, @k.e.a.e @l.y.c("game_key") String str);

    @l.y.f("reviews/mine")
    @k.e.a.d
    Flow<ReviewMineInfo> c(@k.e.a.d @l.y.t("type") String str, @k.e.a.e @l.y.t("card_version_id") Integer num, @k.e.a.e @l.y.t("pack_id") Integer num2, @k.e.a.e @l.y.t("game_key") String str2, @k.e.a.e @l.y.t("game_sub_key") String str3);

    @l.y.f("reviews/reply-list")
    @k.e.a.d
    Flow<Result<e.l.h.i.e<ReplyDetailInfo>>> d(@l.y.t("review_id") int i2, @k.e.a.e @l.y.t("sort") String str, @l.y.t("page") int i3);

    @l.y.e
    @l.y.o("reviews/reply")
    @k.e.a.d
    Flow<t1> e(@l.y.c("parent_review_id") int i2, @l.y.c("content") @k.e.a.d String str);

    @l.y.f("reviews")
    @k.e.a.d
    Flow<e.l.h.i.e<ReviewListInfo>> f(@k.e.a.d @l.y.t("type") String str, @k.e.a.e @l.y.t("card_version_id") Integer num, @k.e.a.e @l.y.t("pack_id") Integer num2, @k.e.a.e @l.y.t("sort") String str2, @k.e.a.e @l.y.t("review_id") Integer num3, @k.e.a.e @l.y.t("ignore_card_version") Integer num4, @k.e.a.e @l.y.t("game_key") String str3, @k.e.a.e @l.y.t("game_sub_key") String str4, @l.y.t("page") int i2);

    @l.y.f("reviews/preview")
    @k.e.a.d
    Flow<e.l.h.i.e<TopCommentInfo>> g(@k.e.a.d @l.y.t("type") String str, @k.e.a.e @l.y.t("card_version_id") Integer num, @k.e.a.e @l.y.t("pack_id") Integer num2, @k.e.a.e @l.y.t("ignore_card_version") Integer num3, @k.e.a.e @l.y.t("game_key") String str2, @k.e.a.e @l.y.t("game_sub_key") String str3);

    @l.y.e
    @l.y.o("reviews")
    @k.e.a.d
    Flow<t1> h(@k.e.a.e @l.y.c("card_version_id") Integer num, @k.e.a.e @l.y.c("pack_id") Integer num2, @l.y.c("type") @k.e.a.d String str, @l.y.c("score") int i2, @l.y.c("content") @k.e.a.d String str2, @k.e.a.e @l.y.c("game_key") String str3, @k.e.a.e @l.y.c("game_sub_key") String str4);

    @l.y.e
    @l.y.o("reviews/unlike")
    @k.e.a.d
    Flow<t1> i(@l.y.c("review_id") int i2);

    @l.y.e
    @l.y.o("report-to-us/review")
    @k.e.a.d
    Flow<t1> j(@l.y.c("review_id") int i2, @l.y.c("reason") @k.e.a.d String str, @k.e.a.e @l.y.c("content") String str2, @k.e.a.e @l.y.c("images") List<String> list);

    @l.y.e
    @l.y.o("report-to-us/card-version-correction")
    @k.e.a.d
    Flow<t1> k(@l.y.c("card_version_id") int i2, @l.y.c("reason") @k.e.a.d String str, @l.y.c("content") @k.e.a.d String str2, @l.y.c("images") @k.e.a.d List<String> list, @k.e.a.e @l.y.c("game_key") String str3);

    @l.y.f("report-to-us/reason")
    @k.e.a.d
    Flow<ReasonResult> l();

    @l.y.e
    @l.y.o("reviews/like")
    @k.e.a.d
    Flow<t1> m(@l.y.c("review_id") int i2);

    @k.e.a.d
    @l.y.h(hasBody = true, method = "DELETE", path = "reviews/{review_id}")
    Flow<t1> n(@l.y.s("review_id") int i2);

    @l.y.e
    @k.e.a.d
    @l.y.p("reviews/{review_id}")
    Flow<t1> o(@l.y.s("review_id") int i2, @l.y.a @k.e.a.d UpdateReviewBody updateReviewBody);
}

package com.moor.imkf.model.parser;

import com.baidu.mobads.sdk.internal.bp;
import com.google.gson.Gson;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.moor.imkf.YKFConstants;
import com.moor.imkf.model.entity.CardInfo;
import com.moor.imkf.model.entity.GlobalSet;
import com.moor.imkf.model.entity.Peer;
import com.tencent.bugly.Bugly;
import e.j.e.t.a;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class HttpParser {
    private static String confidence = "";
    private static String ori_question = "";
    private static String std_question = "";

    public static boolean getCSRAging(String str) {
        try {
            return new JSONObject(str).getBoolean(YKFConstants.CSRAGING);
        } catch (JSONException unused) {
            return false;
        }
    }

    public static CardInfo getCardInfo(String str) {
        CardInfo cardInfo = new CardInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            cardInfo.icon = jSONObject.getJSONObject("left").getString("url");
            cardInfo.title = jSONObject.getJSONObject("right1").getString("text");
            cardInfo.name = jSONObject.getJSONObject("right2").getString("text");
            cardInfo.concent = jSONObject.getJSONObject("right3").getString("text");
            cardInfo.url = jSONObject.getString("url");
        } catch (Exception unused) {
        }
        return cardInfo;
    }

    public static String getContent(String str) {
        try {
            return new JSONObject(str).getString("content");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static GlobalSet getGlobalSet(String str) {
        GlobalSet globalSet = new GlobalSet();
        try {
            return (GlobalSet) new Gson().o(new JSONObject(str).getJSONObject("globalSet").toString(), new a<GlobalSet>() { // from class: com.moor.imkf.model.parser.HttpParser.2
            }.getType());
        } catch (JSONException e2) {
            e2.printStackTrace();
            return globalSet;
        }
    }

    public static String getHttpMsg(String str) {
        try {
            return new JSONObject(str).optString("Message");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getInvestigates(String str) {
        try {
            return new JSONObject(str).getString("List");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean getIsBreak(String str) {
        try {
            return new JSONObject(str).getBoolean("isBreak");
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean getIsChatExist(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (getSucceed(str).equals("true") && jSONObject.has("data")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (jSONObject2.has("_id")) {
                    return !"".equals(jSONObject2.getString("_id"));
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getLargeMsgId(String str) {
        try {
            return new JSONObject(str).getString("LargeMsgId");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getLeaveMessage(String str) {
        try {
            return new JSONObject(str).getString("LeaveMessage");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getMessage(String str) {
        try {
            return new JSONObject(str).getString("Message");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(75:6|7|(9:8|9|(1:11)|12|(1:14)|15|(1:17)|18|19)|(4:(1:218)(2:25|(74:27|(3:211|212|213)(2:29|(2:31|(8:33|(1:62)|41|42|43|44|(3:46|47|(4:49|50|51|(1:53)))(1:58)|57))(2:190|(5:201|202|203|204|205)(2:192|(1:194)(2:195|(1:197)(2:198|(1:200))))))|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|(1:120)|121|122|123|(1:125)|126|127|128|(4:130|(2:133|131)|134|135)|136|137|(1:139)(1:149)|140|141|142|143)(1:216))|141|142|143)|217|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|(0)|121|122|123|(0)|126|127|128|(0)|136|137|(0)(0)|140|4) */
    /* JADX WARN: Can't wrap try/catch for region: R(86:6|7|8|9|(1:11)|12|(1:14)|15|(1:17)|18|19|(1:218)(2:25|(74:27|(3:211|212|213)(2:29|(2:31|(8:33|(1:62)|41|42|43|44|(3:46|47|(4:49|50|51|(1:53)))(1:58)|57))(2:190|(5:201|202|203|204|205)(2:192|(1:194)(2:195|(1:197)(2:198|(1:200))))))|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|(1:120)|121|122|123|(1:125)|126|127|128|(4:130|(2:133|131)|134|135)|136|137|(1:139)(1:149)|140|141|142|143)(1:216))|217|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|(0)|121|122|123|(0)|126|127|128|(0)|136|137|(0)(0)|140|141|142|143|4) */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0208, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0212, code lost:
        r11 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x021d, code lost:
        r9 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0228, code lost:
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0233, code lost:
        r3 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x023e, code lost:
        r4 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0249, code lost:
        r4 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0254, code lost:
        r4 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x025f, code lost:
        r4 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x026a, code lost:
        r4 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0275, code lost:
        r3 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0282, code lost:
        r40 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x039f, code lost:
        r3 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x03a2, code lost:
        r3 = r32;
        r2 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01d2, code lost:
        r7 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01db, code lost:
        r10 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01f2, code lost:
        r6 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01fd, code lost:
        r15 = r24;
     */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0344 A[Catch: Exception -> 0x03a2, TRY_LEAVE, TryCatch #12 {Exception -> 0x03a2, blocks: (B:150:0x033e, B:152:0x0344), top: B:214:0x033e }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0352 A[Catch: Exception -> 0x039f, TRY_LEAVE, TryCatch #4 {Exception -> 0x039f, blocks: (B:154:0x034c, B:156:0x0352), top: B:198:0x034c }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0360 A[Catch: Exception -> 0x03a6, TryCatch #10 {Exception -> 0x03a6, blocks: (B:158:0x035a, B:160:0x0360, B:161:0x036a, B:163:0x0370, B:164:0x0393), top: B:210:0x035a }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03b4 A[Catch: JSONException -> 0x03e5, TRY_LEAVE, TryCatch #15 {JSONException -> 0x03e5, blocks: (B:8:0x0036, B:10:0x0054, B:11:0x005a, B:13:0x0060, B:14:0x0066, B:16:0x006c, B:17:0x0072, B:20:0x0098, B:22:0x009e, B:24:0x00a4, B:26:0x00ae, B:30:0x00c0, B:32:0x00c8, B:34:0x00d4, B:36:0x00e1, B:38:0x00eb, B:40:0x00f5, B:43:0x0101, B:60:0x0155, B:82:0x01c5, B:148:0x0284, B:169:0x03a8, B:171:0x03b4, B:62:0x015c, B:69:0x017d, B:70:0x018a, B:72:0x0190, B:73:0x0197, B:75:0x019d, B:76:0x01a4, B:78:0x01ac), top: B:220:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.moor.imkf.model.entity.FromToMessage> getMsgs(java.lang.String r41) {
        /*
            Method dump skipped, instructions count: 1009
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.model.parser.HttpParser.getMsgs(java.lang.String):java.util.List");
    }

    public static boolean getNotAllowCustomerCloseCsr(String str) {
        try {
            return new JSONObject(str).getBoolean(YKFConstants.NOT_ALLOW_CUSTOMERCLOSECSR);
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean getNotAllowCustomerPushCsr(String str) {
        try {
            return new JSONObject(str).getBoolean(YKFConstants.NOT_ALLOWCUSTOMER_PUSH_CSR);
        } catch (JSONException unused) {
            return false;
        }
    }

    public static List<Peer> getPeers(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            return (List) new Gson().o(new JSONObject(str).getJSONArray("Peers").toString(), new a<List<Peer>>() { // from class: com.moor.imkf.model.parser.HttpParser.1
            }.getType());
        } catch (JSONException e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    public static boolean getResult(String str) {
        try {
            return new JSONObject(str).getBoolean("result");
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String getRobotEnable(String str) {
        try {
            return new JSONObject(str).getString("RobotEnable");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getSatisfyThanks(String str) {
        try {
            return new JSONObject(str).getString(YKFConstants.SATISFYTHANK);
        } catch (JSONException unused) {
            return "感谢您对此次服务做出评价，祝您生活愉快，再见！";
        }
    }

    public static String getSatisfyTitle(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has(YKFConstants.SATISFYTITLE) ? jSONObject.getString(YKFConstants.SATISFYTITLE) : "感谢您使用我们的服务，请为此次服务评价！";
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "感谢您使用我们的服务，请为此次服务评价！";
        }
    }

    public static String getScheduleConfig(String str) {
        try {
            return new JSONObject(str).getString("scheduleConfig");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getSucceed(String str) {
        try {
            return new JSONObject(str).getBoolean("Succeed") ? "true" : Bugly.SDK_IS_DEV;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean getSuccess(String str) {
        try {
            return new JSONObject(str).getBoolean(bp.o);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String getTimeOut(String str) {
        try {
            return new JSONObject(str).getString("timeout");
        } catch (JSONException unused) {
            return "";
        }
    }

    public static String getToken(String str) {
        try {
            return new JSONObject(str).getString("token");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getUpToken(String str) {
        try {
            return new JSONObject(str).getString("uptoken");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static long getWhen(String str) {
        try {
            return new JSONObject(str).getLong(RemoteMessageConst.Notification.WHEN);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static boolean hasMoreMsgs(String str) {
        return new JSONObject(str).getBoolean("HasMore");
    }

    public static boolean isLargeMsg(String str) {
        return new JSONObject(str).getBoolean("HasLargeMsgs");
    }

    public static CardInfo getCardInfo(String str, int i2) {
        CardInfo cardInfo = new CardInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            cardInfo.icon = URLDecoder.decode(jSONObject.getJSONObject("left").getString("url"), "UTF-8");
            cardInfo.title = URLDecoder.decode(jSONObject.getJSONObject("right1").getString("text"), "UTF-8");
            cardInfo.name = URLDecoder.decode(jSONObject.getJSONObject("right2").getString("text"), "UTF-8");
            cardInfo.concent = URLDecoder.decode(jSONObject.getJSONObject("right3").getString("text"), "UTF-8");
            cardInfo.url = URLDecoder.decode(jSONObject.getString("url"), "UTF-8");
        } catch (Exception unused) {
        }
        return cardInfo;
    }
}

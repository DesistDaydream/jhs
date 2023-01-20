package j;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.moor.imkf.YKFConstants;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.cb;
import h.k2.v.s0;
import h.q0;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import okhttp3.internal.connection.RealConnection;
import okio.ByteString;
import okio.SegmentedByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Þ\u0001B\b¢\u0006\u0005\bæ\u0001\u0010sJ'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u0017J\u000f\u0010\u001c\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u0017J\u000f\u0010\u001d\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0001H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010&J+\u0010)\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b)\u0010*J'\u0010+\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u0007¢\u0006\u0004\b-\u0010.J!\u0010/\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00182\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b1\u00102J\u001d\u00103\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\u0007¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J\u0018\u0010;\u001a\u0002072\u0006\u0010:\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0007H\u0016¢\u0006\u0004\bC\u00106J\u000f\u0010D\u001a\u00020=H\u0016¢\u0006\u0004\bD\u0010?J\u000f\u0010E\u001a\u00020@H\u0016¢\u0006\u0004\bE\u0010BJ\u000f\u0010F\u001a\u00020\u0007H\u0016¢\u0006\u0004\bF\u00106J\u000f\u0010G\u001a\u00020\u0007H\u0016¢\u0006\u0004\bG\u00106J\u000f\u0010H\u001a\u00020\u0007H\u0016¢\u0006\u0004\bH\u00106J\u000f\u0010I\u001a\u00020\u0010H\u0016¢\u0006\u0004\bI\u0010JJ\u0017\u0010K\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020@2\u0006\u0010N\u001a\u00020MH\u0016¢\u0006\u0004\bO\u0010PJ\u001f\u0010R\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020TH\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u000eH\u0016¢\u0006\u0004\bW\u0010XJ\u0017\u0010Y\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bY\u0010ZJ\u0017\u0010]\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b]\u0010^J\u001f\u0010_\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b_\u0010`J\u0011\u0010a\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\ba\u0010XJ\u000f\u0010b\u001a\u00020\u000eH\u0016¢\u0006\u0004\bb\u0010XJ\u0017\u0010d\u001a\u00020\u000e2\u0006\u0010c\u001a\u00020\u0007H\u0016¢\u0006\u0004\bd\u0010ZJ\u000f\u0010e\u001a\u00020@H\u0016¢\u0006\u0004\be\u0010BJ\u000f\u0010g\u001a\u00020fH\u0016¢\u0006\u0004\bg\u0010hJ\u0017\u0010i\u001a\u00020f2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bi\u0010jJ\u0017\u0010k\u001a\u00020@2\u0006\u0010Q\u001a\u00020fH\u0016¢\u0006\u0004\bk\u0010lJ\u0017\u0010m\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020fH\u0016¢\u0006\u0004\bm\u0010nJ'\u0010k\u001a\u00020@2\u0006\u0010Q\u001a\u00020f2\u0006\u0010(\u001a\u00020@2\u0006\u0010\b\u001a\u00020@H\u0016¢\u0006\u0004\bk\u0010oJ\u0017\u0010k\u001a\u00020@2\u0006\u0010Q\u001a\u00020pH\u0016¢\u0006\u0004\bk\u0010qJ\r\u0010r\u001a\u00020\u000b¢\u0006\u0004\br\u0010sJ\u0017\u0010t\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bt\u0010 J\u0017\u0010v\u001a\u00020\u00002\u0006\u0010u\u001a\u00020\u0010H\u0016¢\u0006\u0004\bv\u0010wJ'\u0010x\u001a\u00020\u00002\u0006\u0010u\u001a\u00020\u00102\u0006\u0010(\u001a\u00020@2\u0006\u0010\b\u001a\u00020@H\u0016¢\u0006\u0004\bx\u0010yJ\u0017\u0010{\u001a\u00020\u00002\u0006\u0010z\u001a\u00020\u000eH\u0016¢\u0006\u0004\b{\u0010|J(\u0010\u007f\u001a\u00020\u00002\u0006\u0010z\u001a\u00020\u000e2\u0006\u0010}\u001a\u00020@2\u0006\u0010~\u001a\u00020@H\u0016¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u001b\u0010\u0082\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020@H\u0016¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\"\u0010\u0084\u0001\u001a\u00020\u00002\u0006\u0010z\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020[H\u0016¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J2\u0010\u0086\u0001\u001a\u00020\u00002\u0006\u0010z\u001a\u00020\u000e2\u0006\u0010}\u001a\u00020@2\u0006\u0010~\u001a\u00020@2\u0006\u0010\\\u001a\u00020[H\u0016¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001b\u0010\u0089\u0001\u001a\u00020\u00002\u0007\u0010\u0088\u0001\u001a\u00020fH\u0016¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J+\u0010\u008b\u0001\u001a\u00020\u00002\u0007\u0010\u0088\u0001\u001a\u00020f2\u0006\u0010(\u001a\u00020@2\u0006\u0010\b\u001a\u00020@H\u0016¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u001a\u0010\u008d\u0001\u001a\u00020@2\u0007\u0010\u0088\u0001\u001a\u00020pH\u0016¢\u0006\u0005\b\u008d\u0001\u0010qJ\u001c\u0010\u008f\u0001\u001a\u00020\u00072\b\u0010\u0088\u0001\u001a\u00030\u008e\u0001H\u0016¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J$\u0010\u0091\u0001\u001a\u00020\u00002\b\u0010\u0088\u0001\u001a\u00030\u008e\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\u00002\u0007\u0010\u0093\u0001\u001a\u00020@H\u0016¢\u0006\u0006\b\u0094\u0001\u0010\u0083\u0001J\u001b\u0010\u0096\u0001\u001a\u00020\u00002\u0007\u0010\u0095\u0001\u001a\u00020@H\u0016¢\u0006\u0006\b\u0096\u0001\u0010\u0083\u0001J\u001b\u0010\u0097\u0001\u001a\u00020\u00002\u0007\u0010\u0095\u0001\u001a\u00020@H\u0016¢\u0006\u0006\b\u0097\u0001\u0010\u0083\u0001J\u001b\u0010\u0099\u0001\u001a\u00020\u00002\u0007\u0010\u0098\u0001\u001a\u00020@H\u0016¢\u0006\u0006\b\u0099\u0001\u0010\u0083\u0001J\u001b\u0010\u009a\u0001\u001a\u00020\u00002\u0007\u0010\u0098\u0001\u001a\u00020@H\u0016¢\u0006\u0006\b\u009a\u0001\u0010\u0083\u0001J\u001b\u0010\u009c\u0001\u001a\u00020\u00002\u0007\u0010\u009b\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u001b\u0010\u009e\u0001\u001a\u00020\u00002\u0007\u0010\u009b\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u009e\u0001\u0010\u009d\u0001J\u001b\u0010\u009f\u0001\u001a\u00020\u00002\u0007\u0010\u009b\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u009f\u0001\u0010\u009d\u0001J\u001b\u0010 \u0001\u001a\u00020\u00002\u0007\u0010\u009b\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b \u0001\u0010\u009d\u0001J\u001c\u0010£\u0001\u001a\u00030¢\u00012\u0007\u0010¡\u0001\u001a\u00020@H\u0000¢\u0006\u0006\b£\u0001\u0010¤\u0001J\"\u0010\u008d\u0001\u001a\u00020\u000b2\u0007\u0010\u0088\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0005\b\u008d\u0001\u0010SJ \u0010k\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0005\bk\u0010¥\u0001J\u001b\u0010¦\u0001\u001a\u00020\u00072\u0007\u0010\u0093\u0001\u001a\u000207H\u0016¢\u0006\u0006\b¦\u0001\u0010§\u0001J$\u0010©\u0001\u001a\u00020\u00072\u0007\u0010\u0093\u0001\u001a\u0002072\u0007\u0010¨\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b©\u0001\u0010ª\u0001J-\u0010¬\u0001\u001a\u00020\u00072\u0007\u0010\u0093\u0001\u001a\u0002072\u0007\u0010¨\u0001\u001a\u00020\u00072\u0007\u0010«\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J\u001b\u0010¯\u0001\u001a\u00020\u00072\u0007\u0010®\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0006\b¯\u0001\u0010°\u0001J$\u0010±\u0001\u001a\u00020\u00072\u0007\u0010®\u0001\u001a\u00020\u00102\u0007\u0010¨\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b±\u0001\u0010²\u0001J\u001b\u0010´\u0001\u001a\u00020\u00072\u0007\u0010³\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0006\b´\u0001\u0010°\u0001J$\u0010µ\u0001\u001a\u00020\u00072\u0007\u0010³\u0001\u001a\u00020\u00102\u0007\u0010¨\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\bµ\u0001\u0010²\u0001J#\u0010¶\u0001\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00072\u0007\u0010®\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0006\b¶\u0001\u0010·\u0001J4\u0010¹\u0001\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00072\u0007\u0010®\u0001\u001a\u00020\u00102\u0007\u0010¸\u0001\u001a\u00020@2\u0006\u0010\b\u001a\u00020@H\u0016¢\u0006\u0006\b¹\u0001\u0010º\u0001J\u0011\u0010»\u0001\u001a\u00020\u000bH\u0016¢\u0006\u0005\b»\u0001\u0010sJ\u0011\u0010¼\u0001\u001a\u00020\tH\u0016¢\u0006\u0005\b¼\u0001\u0010\u001eJ\u0011\u0010½\u0001\u001a\u00020\u000bH\u0016¢\u0006\u0005\b½\u0001\u0010sJ\u0013\u0010¿\u0001\u001a\u00030¾\u0001H\u0016¢\u0006\u0006\b¿\u0001\u0010À\u0001J\u000f\u0010Á\u0001\u001a\u00020\u0010¢\u0006\u0005\bÁ\u0001\u0010JJ\u000f\u0010Â\u0001\u001a\u00020\u0010¢\u0006\u0005\bÂ\u0001\u0010JJ\u000f\u0010Ã\u0001\u001a\u00020\u0010¢\u0006\u0005\bÃ\u0001\u0010JJ\u000f\u0010Ä\u0001\u001a\u00020\u0010¢\u0006\u0005\bÄ\u0001\u0010JJ\u0018\u0010Å\u0001\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u0018\u0010Ç\u0001\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0006\bÇ\u0001\u0010Æ\u0001J\u0018\u0010È\u0001\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0006\bÈ\u0001\u0010Æ\u0001J\u001f\u0010Ë\u0001\u001a\u00020\t2\n\u0010Ê\u0001\u001a\u0005\u0018\u00010É\u0001H\u0096\u0002¢\u0006\u0006\bË\u0001\u0010Ì\u0001J\u0011\u0010Í\u0001\u001a\u00020@H\u0016¢\u0006\u0005\bÍ\u0001\u0010BJ\u0011\u0010Î\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bÎ\u0001\u0010XJ\u000f\u0010Ï\u0001\u001a\u00020\u0000¢\u0006\u0005\bÏ\u0001\u0010\u0017J\u0011\u0010Ð\u0001\u001a\u00020\u0000H\u0016¢\u0006\u0005\bÐ\u0001\u0010\u0017J\u000f\u0010Ñ\u0001\u001a\u00020\u0010¢\u0006\u0005\bÑ\u0001\u0010JJ\u0018\u0010Ò\u0001\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020@¢\u0006\u0006\bÒ\u0001\u0010Ó\u0001J\u001f\u0010Ö\u0001\u001a\u00030Ô\u00012\n\b\u0002\u0010Õ\u0001\u001a\u00030Ô\u0001H\u0007¢\u0006\u0006\bÖ\u0001\u0010×\u0001J\u001f\u0010Ø\u0001\u001a\u00030Ô\u00012\n\b\u0002\u0010Õ\u0001\u001a\u00030Ô\u0001H\u0007¢\u0006\u0006\bØ\u0001\u0010×\u0001J\u001a\u0010Ú\u0001\u001a\u0002072\u0007\u0010Ù\u0001\u001a\u00020\u0007H\u0007¢\u0006\u0005\bÚ\u0001\u0010<J\u0011\u0010Û\u0001\u001a\u00020\u0007H\u0007¢\u0006\u0005\bÛ\u0001\u00106R\u0018\u0010Ý\u0001\u001a\u00020\u00008V@\u0016X\u0096\u0004¢\u0006\u0007\u001a\u0005\bÜ\u0001\u0010\u0017R\u001c\u0010à\u0001\u001a\u0005\u0018\u00010¢\u00018\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001R0\u0010å\u0001\u001a\u00020\u00072\u0007\u0010á\u0001\u001a\u00020\u00078G@@X\u0086\u000e¢\u0006\u0016\n\u0006\b\u0093\u0001\u0010â\u0001\u001a\u0005\bã\u0001\u00106\"\u0005\bä\u0001\u0010 ¨\u0006ç\u0001"}, d2 = {"Lj/m;", "Lj/o;", "Lj/n;", "", "Ljava/nio/channels/ByteChannel;", "Ljava/io/InputStream;", "input", "", "byteCount", "", "forever", "Lh/t1;", "G0", "(Ljava/io/InputStream;JZ)V", "", "algorithm", "Lokio/ByteString;", "Y", "(Ljava/lang/String;)Lokio/ByteString;", "key", "o0", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", am.aH, "()Lj/m;", "Ljava/io/OutputStream;", "v0", "()Ljava/io/OutputStream;", "f0", "c0", "b0", "()Z", "R", "(J)V", "G", "(J)Z", "peek", "()Lj/o;", "inputStream", "()Ljava/io/InputStream;", YKFConstants.INVESTIGATE_TYPE_OUT, "offset", am.aI, "(Ljava/io/OutputStream;JJ)Lj/m;", "H", "(Lj/m;JJ)Lj/m;", "F", "(Lj/m;J)Lj/m;", "j1", "(Ljava/io/OutputStream;J)Lj/m;", "E0", "(Ljava/io/InputStream;)Lj/m;", "F0", "(Ljava/io/InputStream;J)Lj/m;", "o", "()J", "", "readByte", "()B", "pos", "m0", "(J)B", "", "readShort", "()S", "", "readInt", "()I", "readLong", "N", "n0", "O", "d0", "w0", "j0", "()Lokio/ByteString;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(J)Lokio/ByteString;", "Lj/c0;", "options", "y0", "(Lj/c0;)I", "sink", "h", "(Lj/m;J)V", "Lj/k0;", "s0", "(Lj/k0;)J", "p0", "()Ljava/lang/String;", "U", "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "g0", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "q0", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "y", ExpandableTextView.P, "limit", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "h0", "", "Z", "()[B", "L", "(J)[B", "read", "([B)I", "readFully", "([B)V", "([BII)I", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", NotifyType.LIGHTS, "()V", "skip", "byteString", "S0", "(Lokio/ByteString;)Lj/m;", "T0", "(Lokio/ByteString;II)Lj/m;", "string", "l1", "(Ljava/lang/String;)Lj/m;", "beginIndex", "endIndex", "m1", "(Ljava/lang/String;II)Lj/m;", "codePoint", "n1", "(I)Lj/m;", "h1", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lj/m;", "g1", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Lj/m;", MessageKey.MSG_SOURCE, "V0", "([B)Lj/m;", "W0", "([BII)Lj/m;", "write", "Lj/m0;", ExifInterface.LONGITUDE_EAST, "(Lj/m0;)J", "U0", "(Lj/m0;J)Lj/m;", "b", "X0", "s", "e1", "f1", "i", "a1", "b1", "v", "c1", "(J)Lj/m;", "d1", "Y0", "Z0", "minimumCapacity", "Lj/i0;", "R0", "(I)Lj/i0;", "(Lj/m;J)J", ExifInterface.GPS_DIRECTION_TRUE, "(B)J", "fromIndex", "g", "(BJ)J", "toIndex", "m", "(BJJ)J", "bytes", "f", "(Lokio/ByteString;)J", com.huawei.hms.push.e.a, "(Lokio/ByteString;J)J", "targetBytes", am.ax, "Q", "C", "(JLokio/ByteString;)Z", "bytesOffset", "K", "(JLokio/ByteString;II)Z", "flush", "isOpen", "close", "Lj/o0;", "timeout", "()Lj/o0;", "A0", "L0", "M0", "N0", "u0", "(Lokio/ByteString;)Lokio/ByteString;", "x0", "z0", "", "other", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "toString", "q", "n", "P0", "Q0", "(I)Lokio/ByteString;", "Lj/m$a;", "unsafeCursor", "I0", "(Lj/m$a;)Lj/m$a;", "C0", "index", "j", "k", "getBuffer", "buffer", am.av, "Lj/i0;", "head", "<set-?>", "J", "O0", "K0", "size", "<init>", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class m implements o, n, Cloneable, ByteChannel {
    @h.k2.d
    @k.e.a.e
    public i0 a;
    private long b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010\u0011J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006)"}, d2 = {"j/m$a", "Ljava/io/Closeable;", "", "j", "()I", "", "offset", NotifyType.LIGHTS, "(J)I", "newSize", "k", "(J)J", "minByteCount", am.av, "(I)J", "Lh/t1;", "close", "()V", "Lj/m;", "Lj/m;", "buffer", "", "b", "Z", "readWrite", "f", ExpandableTextView.P, MessageKey.MSG_ACCEPT_TIME_START, "", com.huawei.hms.push.e.a, "[B", "data", "g", MessageKey.MSG_ACCEPT_TIME_END, "Lj/i0;", "c", "Lj/i0;", "segment", e.j.a.b.c.f.f10128d, "J", "<init>", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements Closeable {
        @h.k2.d
        @k.e.a.e
        public m a;
        @h.k2.d
        public boolean b;

        /* renamed from: c  reason: collision with root package name */
        private i0 f15990c;
        @h.k2.d
        @k.e.a.e

        /* renamed from: e  reason: collision with root package name */
        public byte[] f15992e;
        @h.k2.d

        /* renamed from: d  reason: collision with root package name */
        public long f15991d = -1;
        @h.k2.d

        /* renamed from: f  reason: collision with root package name */
        public int f15993f = -1;
        @h.k2.d

        /* renamed from: g  reason: collision with root package name */
        public int f15994g = -1;

        public final long a(int i2) {
            if (!(i2 > 0)) {
                throw new IllegalArgumentException(("minByteCount <= 0: " + i2).toString());
            }
            if (i2 <= 8192) {
                m mVar = this.a;
                if (mVar != null) {
                    if (this.b) {
                        long O0 = mVar.O0();
                        i0 R0 = mVar.R0(i2);
                        int i3 = 8192 - R0.f15982c;
                        R0.f15982c = 8192;
                        long j2 = i3;
                        mVar.K0(O0 + j2);
                        this.f15990c = R0;
                        this.f15991d = O0;
                        this.f15992e = R0.a;
                        this.f15993f = 8192 - i3;
                        this.f15994g = 8192;
                        return j2;
                    }
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                }
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i2).toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.a != null) {
                this.a = null;
                this.f15990c = null;
                this.f15991d = -1L;
                this.f15992e = null;
                this.f15993f = -1;
                this.f15994g = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final int j() {
            if (this.f15991d != this.a.O0()) {
                long j2 = this.f15991d;
                return l(j2 == -1 ? 0L : j2 + (this.f15994g - this.f15993f));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final long k(long j2) {
            m mVar = this.a;
            if (mVar != null) {
                if (this.b) {
                    long O0 = mVar.O0();
                    int i2 = 1;
                    int i3 = (j2 > O0 ? 1 : (j2 == O0 ? 0 : -1));
                    if (i3 <= 0) {
                        if (j2 >= 0) {
                            long j3 = O0 - j2;
                            while (true) {
                                if (j3 <= 0) {
                                    break;
                                }
                                i0 i0Var = mVar.a.f15986g;
                                int i4 = i0Var.f15982c;
                                long j4 = i4 - i0Var.b;
                                if (j4 <= j3) {
                                    mVar.a = i0Var.b();
                                    j0.d(i0Var);
                                    j3 -= j4;
                                } else {
                                    i0Var.f15982c = i4 - ((int) j3);
                                    break;
                                }
                            }
                            this.f15990c = null;
                            this.f15991d = j2;
                            this.f15992e = null;
                            this.f15993f = -1;
                            this.f15994g = -1;
                        } else {
                            throw new IllegalArgumentException(("newSize < 0: " + j2).toString());
                        }
                    } else if (i3 > 0) {
                        long j5 = j2 - O0;
                        boolean z = true;
                        while (j5 > 0) {
                            i0 R0 = mVar.R0(i2);
                            int min = (int) Math.min(j5, 8192 - R0.f15982c);
                            int i5 = R0.f15982c + min;
                            R0.f15982c = i5;
                            j5 -= min;
                            if (z) {
                                this.f15990c = R0;
                                this.f15991d = O0;
                                this.f15992e = R0.a;
                                this.f15993f = i5 - min;
                                this.f15994g = i5;
                                z = false;
                            }
                            i2 = 1;
                        }
                    }
                    mVar.K0(j2);
                    return O0;
                }
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final int l(long j2) {
            i0 i0Var;
            m mVar = this.a;
            if (mVar != null) {
                if (j2 >= -1 && j2 <= mVar.O0()) {
                    if (j2 != -1 && j2 != mVar.O0()) {
                        long j3 = 0;
                        long O0 = mVar.O0();
                        i0 i0Var2 = mVar.a;
                        i0 i0Var3 = this.f15990c;
                        if (i0Var3 != null) {
                            long j4 = this.f15991d - (this.f15993f - i0Var3.b);
                            if (j4 > j2) {
                                i0Var = i0Var2;
                                i0Var2 = this.f15990c;
                                O0 = j4;
                            } else {
                                i0Var = this.f15990c;
                                j3 = j4;
                            }
                        } else {
                            i0Var = i0Var2;
                        }
                        if (O0 - j2 > j2 - j3) {
                            while (true) {
                                int i2 = i0Var.f15982c;
                                int i3 = i0Var.b;
                                if (j2 < (i2 - i3) + j3) {
                                    break;
                                }
                                j3 += i2 - i3;
                                i0Var = i0Var.f15985f;
                            }
                        } else {
                            while (O0 > j2) {
                                i0Var2 = i0Var2.f15986g;
                                O0 -= i0Var2.f15982c - i0Var2.b;
                            }
                            j3 = O0;
                            i0Var = i0Var2;
                        }
                        if (this.b && i0Var.f15983d) {
                            i0 f2 = i0Var.f();
                            if (mVar.a == i0Var) {
                                mVar.a = f2;
                            }
                            i0Var = i0Var.c(f2);
                            i0Var.f15986g.b();
                        }
                        this.f15990c = i0Var;
                        this.f15991d = j2;
                        this.f15992e = i0Var.a;
                        int i4 = i0Var.b + ((int) (j2 - j3));
                        this.f15993f = i4;
                        int i5 = i0Var.f15982c;
                        this.f15994g = i5;
                        return i5 - i4;
                    }
                    this.f15990c = null;
                    this.f15991d = j2;
                    this.f15992e = null;
                    this.f15993f = -1;
                    this.f15994g = -1;
                    return -1;
                }
                s0 s0Var = s0.a;
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j2), Long.valueOf(mVar.O0())}, 2)));
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"j/m$c", "Ljava/io/OutputStream;", "", "b", "Lh/t1;", "write", "(I)V", "", "data", "offset", "byteCount", "([BII)V", "flush", "()V", "close", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class c extends OutputStream {
        public c() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        @k.e.a.d
        public String toString() {
            return m.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i2) {
            m.this.writeByte(i2);
        }

        @Override // java.io.OutputStream
        public void write(@k.e.a.d byte[] bArr, int i2, int i3) {
            m.this.write(bArr, i2, i3);
        }
    }

    public static /* synthetic */ a D0(m mVar, a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = new a();
        }
        return mVar.C0(aVar);
    }

    private final void G0(InputStream inputStream, long j2, boolean z) throws IOException {
        while (true) {
            if (j2 <= 0 && !z) {
                return;
            }
            i0 R0 = R0(1);
            int read = inputStream.read(R0.a, R0.f15982c, (int) Math.min(j2, 8192 - R0.f15982c));
            if (read == -1) {
                if (R0.b == R0.f15982c) {
                    this.a = R0.b();
                    j0.d(R0);
                }
                if (!z) {
                    throw new EOFException();
                }
                return;
            }
            R0.f15982c += read;
            long j3 = read;
            this.b += j3;
            j2 -= j3;
        }
    }

    public static /* synthetic */ m J(m mVar, OutputStream outputStream, long j2, long j3, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            j3 = mVar.b - j4;
        }
        return mVar.t(outputStream, j4, j3);
    }

    public static /* synthetic */ a J0(m mVar, a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = new a();
        }
        return mVar.I0(aVar);
    }

    public static /* synthetic */ m M(m mVar, m mVar2, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        return mVar.F(mVar2, j2);
    }

    public static /* synthetic */ m X(m mVar, m mVar2, long j2, long j3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        return mVar.H(mVar2, j2, j3);
    }

    private final ByteString Y(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        i0 i0Var = this.a;
        if (i0Var != null) {
            byte[] bArr = i0Var.a;
            int i2 = i0Var.b;
            messageDigest.update(bArr, i2, i0Var.f15982c - i2);
            for (i0 i0Var2 = i0Var.f15985f; i0Var2 != i0Var; i0Var2 = i0Var2.f15985f) {
                byte[] bArr2 = i0Var2.a;
                int i3 = i0Var2.b;
                messageDigest.update(bArr2, i3, i0Var2.f15982c - i3);
            }
        }
        return new ByteString(messageDigest.digest());
    }

    public static /* synthetic */ m k1(m mVar, OutputStream outputStream, long j2, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            j2 = mVar.b;
        }
        return mVar.j1(outputStream, j2);
    }

    private final ByteString o0(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            i0 i0Var = this.a;
            if (i0Var != null) {
                byte[] bArr = i0Var.a;
                int i2 = i0Var.b;
                mac.update(bArr, i2, i0Var.f15982c - i2);
                for (i0 i0Var2 = i0Var.f15985f; i0Var2 != i0Var; i0Var2 = i0Var2.f15985f) {
                    byte[] bArr2 = i0Var2.a;
                    int i3 = i0Var2.b;
                    mac.update(bArr2, i3, i0Var2.f15982c - i3);
                }
            }
            return new ByteString(mac.doFinal());
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // j.o
    @k.e.a.d
    public String A(long j2) throws EOFException {
        if (j2 >= 0) {
            long j3 = j2 != Long.MAX_VALUE ? j2 + 1 : Long.MAX_VALUE;
            byte b2 = (byte) 10;
            long m2 = m(b2, 0L, j3);
            if (m2 != -1) {
                return j.q0.a.b0(this, m2);
            }
            if (j3 < O0() && m0(j3 - 1) == ((byte) 13) && m0(j3) == b2) {
                return j.q0.a.b0(this, j3);
            }
            m mVar = new m();
            H(mVar, 0L, Math.min(32, O0()));
            throw new EOFException("\\n not found: limit=" + Math.min(O0(), j2) + " content=" + mVar.j0().hex() + h.t2.y.E);
        }
        throw new IllegalArgumentException(("limit < 0: " + j2).toString());
    }

    @k.e.a.d
    public final ByteString A0() {
        return Y("MD5");
    }

    @h.k2.h
    @k.e.a.d
    public final a B0() {
        return D0(this, null, 1, null);
    }

    @Override // j.o
    public boolean C(long j2, @k.e.a.d ByteString byteString) {
        return K(j2, byteString, 0, byteString.size());
    }

    @h.k2.h
    @k.e.a.d
    public final a C0(@k.e.a.d a aVar) {
        if (aVar.a == null) {
            aVar.a = this;
            aVar.b = true;
            return aVar;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @Override // j.n
    public long E(@k.e.a.d m0 m0Var) throws IOException {
        long j2 = 0;
        while (true) {
            long read = m0Var.read(this, 8192);
            if (read == -1) {
                return j2;
            }
            j2 += read;
        }
    }

    @k.e.a.d
    public final m E0(@k.e.a.d InputStream inputStream) throws IOException {
        G0(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    @k.e.a.d
    public final m F(@k.e.a.d m mVar, long j2) {
        return H(mVar, j2, this.b - j2);
    }

    @k.e.a.d
    public final m F0(@k.e.a.d InputStream inputStream, long j2) throws IOException {
        if (j2 >= 0) {
            G0(inputStream, j2, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    @Override // j.o
    public boolean G(long j2) {
        return this.b >= j2;
    }

    @k.e.a.d
    public final m H(@k.e.a.d m mVar, long j2, long j3) {
        j.e(O0(), j2, j3);
        if (j3 != 0) {
            mVar.K0(mVar.O0() + j3);
            i0 i0Var = this.a;
            while (true) {
                int i2 = i0Var.f15982c;
                int i3 = i0Var.b;
                if (j2 < i2 - i3) {
                    break;
                }
                j2 -= i2 - i3;
                i0Var = i0Var.f15985f;
            }
            while (j3 > 0) {
                i0 d2 = i0Var.d();
                int i4 = d2.b + ((int) j2);
                d2.b = i4;
                d2.f15982c = Math.min(i4 + ((int) j3), d2.f15982c);
                i0 i0Var2 = mVar.a;
                if (i0Var2 == null) {
                    d2.f15986g = d2;
                    d2.f15985f = d2;
                    mVar.a = d2;
                } else {
                    i0Var2.f15986g.c(d2);
                }
                j3 -= d2.f15982c - d2.b;
                i0Var = i0Var.f15985f;
                j2 = 0;
            }
        }
        return this;
    }

    @h.k2.h
    @k.e.a.d
    public final a H0() {
        return J0(this, null, 1, null);
    }

    @Override // j.o
    @k.e.a.d
    public String I() throws EOFException {
        return A(Long.MAX_VALUE);
    }

    @h.k2.h
    @k.e.a.d
    public final a I0(@k.e.a.d a aVar) {
        if (aVar.a == null) {
            aVar.a = this;
            aVar.b = false;
            return aVar;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @Override // j.o
    public boolean K(long j2, @k.e.a.d ByteString byteString, int i2, int i3) {
        if (j2 < 0 || i2 < 0 || i3 < 0 || O0() - j2 < i3 || byteString.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (m0(i4 + j2) != byteString.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public final void K0(long j2) {
        this.b = j2;
    }

    @Override // j.o
    @k.e.a.d
    public byte[] L(long j2) throws EOFException {
        if (j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE)) {
            if (O0() >= j2) {
                byte[] bArr = new byte[(int) j2];
                readFully(bArr);
                return bArr;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j2).toString());
    }

    @k.e.a.d
    public final ByteString L0() {
        return Y("SHA-1");
    }

    @k.e.a.d
    public final ByteString M0() {
        return Y("SHA-256");
    }

    @Override // j.o
    public short N() throws EOFException {
        return j.j(readShort());
    }

    @k.e.a.d
    public final ByteString N0() {
        return Y("SHA-512");
    }

    @Override // j.o
    public long O() throws EOFException {
        return j.i(readLong());
    }

    @h.k2.g(name = "size")
    public final long O0() {
        return this.b;
    }

    @k.e.a.d
    public final ByteString P0() {
        if (O0() <= ((long) Integer.MAX_VALUE)) {
            return Q0((int) O0());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + O0()).toString());
    }

    @Override // j.o
    public long Q(@k.e.a.d ByteString byteString, long j2) {
        int i2;
        int i3;
        long j3 = 0;
        if (j2 >= 0) {
            i0 i0Var = this.a;
            if (i0Var != null) {
                if (O0() - j2 < j2) {
                    j3 = O0();
                    while (j3 > j2) {
                        i0Var = i0Var.f15986g;
                        j3 -= i0Var.f15982c - i0Var.b;
                    }
                    if (i0Var != null) {
                        if (byteString.size() == 2) {
                            byte b2 = byteString.getByte(0);
                            byte b3 = byteString.getByte(1);
                            while (j3 < O0()) {
                                byte[] bArr = i0Var.a;
                                i2 = (int) ((i0Var.b + j2) - j3);
                                int i4 = i0Var.f15982c;
                                while (i2 < i4) {
                                    byte b4 = bArr[i2];
                                    if (b4 != b2 && b4 != b3) {
                                        i2++;
                                    }
                                    i3 = i0Var.b;
                                }
                                j3 += i0Var.f15982c - i0Var.b;
                                i0Var = i0Var.f15985f;
                                j2 = j3;
                            }
                            return -1L;
                        }
                        byte[] internalArray$okio = byteString.internalArray$okio();
                        while (j3 < O0()) {
                            byte[] bArr2 = i0Var.a;
                            i2 = (int) ((i0Var.b + j2) - j3);
                            int i5 = i0Var.f15982c;
                            while (i2 < i5) {
                                byte b5 = bArr2[i2];
                                for (byte b6 : internalArray$okio) {
                                    if (b5 == b6) {
                                        i3 = i0Var.b;
                                    }
                                }
                                i2++;
                            }
                            j3 += i0Var.f15982c - i0Var.b;
                            i0Var = i0Var.f15985f;
                            j2 = j3;
                        }
                        return -1L;
                    }
                    return -1L;
                }
                while (true) {
                    long j4 = (i0Var.f15982c - i0Var.b) + j3;
                    if (j4 > j2) {
                        break;
                    }
                    i0Var = i0Var.f15985f;
                    j3 = j4;
                }
                if (i0Var != null) {
                    if (byteString.size() == 2) {
                        byte b7 = byteString.getByte(0);
                        byte b8 = byteString.getByte(1);
                        while (j3 < O0()) {
                            byte[] bArr3 = i0Var.a;
                            i2 = (int) ((i0Var.b + j2) - j3);
                            int i6 = i0Var.f15982c;
                            while (i2 < i6) {
                                byte b9 = bArr3[i2];
                                if (b9 != b7 && b9 != b8) {
                                    i2++;
                                }
                                i3 = i0Var.b;
                            }
                            j3 += i0Var.f15982c - i0Var.b;
                            i0Var = i0Var.f15985f;
                            j2 = j3;
                        }
                        return -1L;
                    }
                    byte[] internalArray$okio2 = byteString.internalArray$okio();
                    while (j3 < O0()) {
                        byte[] bArr4 = i0Var.a;
                        i2 = (int) ((i0Var.b + j2) - j3);
                        int i7 = i0Var.f15982c;
                        while (i2 < i7) {
                            byte b10 = bArr4[i2];
                            for (byte b11 : internalArray$okio2) {
                                if (b10 == b11) {
                                    i3 = i0Var.b;
                                }
                            }
                            i2++;
                        }
                        j3 += i0Var.f15982c - i0Var.b;
                        i0Var = i0Var.f15985f;
                        j2 = j3;
                    }
                    return -1L;
                }
                return -1L;
                return (i2 - i3) + j3;
            }
            return -1L;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
    }

    @k.e.a.d
    public final ByteString Q0(int i2) {
        if (i2 == 0) {
            return ByteString.EMPTY;
        }
        j.e(O0(), 0L, i2);
        i0 i0Var = this.a;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = i0Var.f15982c;
            int i7 = i0Var.b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                i0Var = i0Var.f15985f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i5];
        int[] iArr = new int[i5 * 2];
        i0 i0Var2 = this.a;
        int i8 = 0;
        while (i3 < i2) {
            bArr[i8] = i0Var2.a;
            i3 += i0Var2.f15982c - i0Var2.b;
            iArr[i8] = Math.min(i3, i2);
            iArr[i8 + i5] = i0Var2.b;
            i0Var2.f15983d = true;
            i8++;
            i0Var2 = i0Var2.f15985f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // j.o
    public void R(long j2) throws EOFException {
        if (this.b < j2) {
            throw new EOFException();
        }
    }

    @k.e.a.d
    public final i0 R0(int i2) {
        boolean z = true;
        if ((i2 < 1 || i2 > 8192) ? false : false) {
            i0 i0Var = this.a;
            if (i0Var == null) {
                i0 e2 = j0.e();
                this.a = e2;
                e2.f15986g = e2;
                e2.f15985f = e2;
                return e2;
            }
            i0 i0Var2 = i0Var.f15986g;
            return (i0Var2.f15982c + i2 > 8192 || !i0Var2.f15984e) ? i0Var2.c(j0.e()) : i0Var2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: S0 */
    public m r0(@k.e.a.d ByteString byteString) {
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // j.o
    public long T(byte b2) {
        return m(b2, 0L, Long.MAX_VALUE);
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: T0 */
    public m W(@k.e.a.d ByteString byteString, int i2, int i3) {
        byteString.write$okio(this, i2, i3);
        return this;
    }

    @Override // j.o
    @k.e.a.d
    public String U(long j2) throws EOFException {
        return q0(j2, h.t2.d.a);
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: U0 */
    public m l0(@k.e.a.d m0 m0Var, long j2) throws IOException {
        while (j2 > 0) {
            long read = m0Var.read(this, j2);
            if (read == -1) {
                throw new EOFException();
            }
            j2 -= read;
        }
        return this;
    }

    @Override // j.o
    @k.e.a.d
    public ByteString V(long j2) throws EOFException {
        if (j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE)) {
            if (O0() >= j2) {
                if (j2 >= 4096) {
                    ByteString Q0 = Q0((int) j2);
                    skip(j2);
                    return Q0;
                }
                return new ByteString(L(j2));
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j2).toString());
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: V0 */
    public m write(@k.e.a.d byte[] bArr) {
        return write(bArr, 0, bArr.length);
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: W0 */
    public m write(@k.e.a.d byte[] bArr, int i2, int i3) {
        long j2 = i3;
        j.e(bArr.length, i2, j2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            i0 R0 = R0(1);
            int min = Math.min(i4 - i2, 8192 - R0.f15982c);
            int i5 = i2 + min;
            h.a2.n.W0(bArr, R0.a, R0.f15982c, i2, i5);
            R0.f15982c += min;
            i2 = i5;
        }
        K0(O0() + j2);
        return this;
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: X0 */
    public m writeByte(int i2) {
        i0 R0 = R0(1);
        byte[] bArr = R0.a;
        int i3 = R0.f15982c;
        R0.f15982c = i3 + 1;
        bArr[i3] = (byte) i2;
        K0(O0() + 1);
        return this;
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: Y0 */
    public m S(long j2) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i3 = 1;
        if (i2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return B("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i3 = j2 < 1000000000000L ? j2 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= com.heytap.mcssdk.constant.a.q) {
            i3 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i3 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i3 = 2;
        }
        if (z) {
            i3++;
        }
        i0 R0 = R0(i3);
        byte[] bArr = R0.a;
        int i4 = R0.f15982c + i3;
        while (j2 != 0) {
            long j3 = 10;
            i4--;
            bArr[i4] = j.q0.a.Z()[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z) {
            bArr[i4 - 1] = (byte) 45;
        }
        R0.f15982c += i3;
        K0(O0() + i3);
        return this;
    }

    @Override // j.o
    @k.e.a.d
    public byte[] Z() {
        return L(O0());
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: Z0 */
    public m i0(long j2) {
        if (j2 == 0) {
            return writeByte(48);
        }
        long j3 = (j2 >>> 1) | j2;
        long j4 = j3 | (j3 >>> 2);
        long j5 = j4 | (j4 >>> 4);
        long j6 = j5 | (j5 >>> 8);
        long j7 = j6 | (j6 >>> 16);
        long j8 = j7 | (j7 >>> 32);
        long j9 = j8 - ((j8 >>> 1) & 6148914691236517205L);
        long j10 = ((j9 >>> 2) & 3689348814741910323L) + (j9 & 3689348814741910323L);
        long j11 = ((j10 >>> 4) + j10) & 1085102592571150095L;
        long j12 = j11 + (j11 >>> 8);
        long j13 = j12 + (j12 >>> 16);
        int i2 = (int) ((((j13 & 63) + ((j13 >>> 32) & 63)) + 3) / 4);
        i0 R0 = R0(i2);
        byte[] bArr = R0.a;
        int i3 = R0.f15982c;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            bArr[i4] = j.q0.a.Z()[(int) (15 & j2)];
            j2 >>>= 4;
        }
        R0.f15982c += i2;
        K0(O0() + i2);
        return this;
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: a1 */
    public m writeInt(int i2) {
        i0 R0 = R0(4);
        byte[] bArr = R0.a;
        int i3 = R0.f15982c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        R0.f15982c = i6 + 1;
        K0(O0() + 4);
        return this;
    }

    @Override // j.o
    public boolean b0() {
        return this.b == 0;
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: b1 */
    public m a0(int i2) {
        return writeInt(j.h(i2));
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: c0 */
    public m v() {
        return this;
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: c1 */
    public m t0(long j2) {
        i0 R0 = R0(8);
        byte[] bArr = R0.a;
        int i2 = R0.f15982c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j2 >>> 56) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j2 >>> 48) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j2 >>> 40) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j2 >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j2 >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j2 >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j2 >>> 8) & 255);
        bArr[i9] = (byte) (j2 & 255);
        R0.f15982c = i9 + 1;
        K0(O0() + 8);
        return this;
    }

    @Override // j.m0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bf A[EDGE_INSN: B:50:0x00bf->B:41:0x00bf ?: BREAK  , SYNTHETIC] */
    @Override // j.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long d0() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j.m.d0():long");
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: d1 */
    public m x(long j2) {
        return t0(j.i(j2));
    }

    @Override // j.o
    public long e(@k.e.a.d ByteString byteString, long j2) throws IOException {
        long j3 = j2;
        if (byteString.size() > 0) {
            long j4 = 0;
            if (j3 >= 0) {
                i0 i0Var = this.a;
                if (i0Var != null) {
                    if (O0() - j3 < j3) {
                        long O0 = O0();
                        while (O0 > j3) {
                            i0Var = i0Var.f15986g;
                            O0 -= i0Var.f15982c - i0Var.b;
                        }
                        if (i0Var != null) {
                            byte[] internalArray$okio = byteString.internalArray$okio();
                            byte b2 = internalArray$okio[0];
                            int size = byteString.size();
                            long O02 = (O0() - size) + 1;
                            while (O0 < O02) {
                                byte[] bArr = i0Var.a;
                                long j5 = O0;
                                int min = (int) Math.min(i0Var.f15982c, (i0Var.b + O02) - O0);
                                for (int i2 = (int) ((i0Var.b + j3) - j5); i2 < min; i2++) {
                                    if (bArr[i2] == b2 && j.q0.a.a0(i0Var, i2 + 1, internalArray$okio, 1, size)) {
                                        return (i2 - i0Var.b) + j5;
                                    }
                                }
                                O0 = j5 + (i0Var.f15982c - i0Var.b);
                                i0Var = i0Var.f15985f;
                                j3 = O0;
                            }
                        }
                    } else {
                        while (true) {
                            long j6 = (i0Var.f15982c - i0Var.b) + j4;
                            if (j6 > j3) {
                                break;
                            }
                            i0Var = i0Var.f15985f;
                            j4 = j6;
                        }
                        if (i0Var != null) {
                            byte[] internalArray$okio2 = byteString.internalArray$okio();
                            byte b3 = internalArray$okio2[0];
                            int size2 = byteString.size();
                            long O03 = (O0() - size2) + 1;
                            while (j4 < O03) {
                                byte[] bArr2 = i0Var.a;
                                long j7 = O03;
                                int min2 = (int) Math.min(i0Var.f15982c, (i0Var.b + O03) - j4);
                                for (int i3 = (int) ((i0Var.b + j3) - j4); i3 < min2; i3++) {
                                    if (bArr2[i3] == b3 && j.q0.a.a0(i0Var, i3 + 1, internalArray$okio2, 1, size2)) {
                                        return (i3 - i0Var.b) + j4;
                                    }
                                }
                                j4 += i0Var.f15982c - i0Var.b;
                                i0Var = i0Var.f15985f;
                                j3 = j4;
                                O03 = j7;
                            }
                        }
                    }
                }
                return -1L;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j3).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: e1 */
    public m writeShort(int i2) {
        i0 R0 = R0(2);
        byte[] bArr = R0.a;
        int i3 = R0.f15982c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        R0.f15982c = i4 + 1;
        K0(O0() + 2);
        return this;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this != obj) {
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            if (O0() != mVar.O0()) {
                return false;
            }
            if (O0() != 0) {
                i0 i0Var = this.a;
                i0 i0Var2 = mVar.a;
                int i2 = i0Var.b;
                int i3 = i0Var2.b;
                long j2 = 0;
                while (j2 < O0()) {
                    long min = Math.min(i0Var.f15982c - i2, i0Var2.f15982c - i3);
                    long j3 = 0;
                    while (j3 < min) {
                        int i4 = i2 + 1;
                        int i5 = i3 + 1;
                        if (i0Var.a[i2] != i0Var2.a[i3]) {
                            return false;
                        }
                        j3++;
                        i2 = i4;
                        i3 = i5;
                    }
                    if (i2 == i0Var.f15982c) {
                        i0Var = i0Var.f15985f;
                        i2 = i0Var.b;
                    }
                    if (i3 == i0Var2.f15982c) {
                        i0Var2 = i0Var2.f15985f;
                        i3 = i0Var2.b;
                    }
                    j2 += min;
                }
            }
        }
        return true;
    }

    @Override // j.o
    public long f(@k.e.a.d ByteString byteString) throws IOException {
        return e(byteString, 0L);
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: f0 */
    public m z() {
        return this;
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: f1 */
    public m e0(int i2) {
        return writeShort(j.j((short) i2));
    }

    @Override // j.n, j.k0, java.io.Flushable
    public void flush() {
    }

    @Override // j.o
    public long g(byte b2, long j2) {
        return m(b2, j2, Long.MAX_VALUE);
    }

    @Override // j.o
    @k.e.a.d
    public String g0(@k.e.a.d Charset charset) {
        return q0(this.b, charset);
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: g1 */
    public m P(@k.e.a.d String str, int i2, int i3, @k.e.a.d Charset charset) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
        }
        if (i3 >= i2) {
            if (i3 <= str.length()) {
                if (h.k2.v.f0.g(charset, h.t2.d.a)) {
                    return D(str, i2, i3);
                }
                String substring = str.substring(i2, i3);
                Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
                byte[] bytes = substring.getBytes(charset);
                return write(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
    }

    @Override // j.o
    @k.e.a.d
    public m getBuffer() {
        return this;
    }

    @Override // j.o
    public void h(@k.e.a.d m mVar, long j2) throws EOFException {
        if (O0() >= j2) {
            mVar.write(this, j2);
        } else {
            mVar.write(this, O0());
            throw new EOFException();
        }
    }

    @Override // j.o
    public int h0() throws EOFException {
        int i2;
        int i3;
        int i4;
        if (O0() != 0) {
            byte m0 = m0(0L);
            if ((m0 & h.k2.v.n.a) == 0) {
                i2 = m0 & h.k2.v.n.b;
                i3 = 1;
                i4 = 0;
            } else if ((m0 & 224) == 192) {
                i2 = m0 & 31;
                i3 = 2;
                i4 = 128;
            } else if ((m0 & 240) == 224) {
                i2 = m0 & cb.f7124m;
                i3 = 3;
                i4 = 2048;
            } else if ((m0 & 248) != 240) {
                skip(1L);
                return p0.f15998c;
            } else {
                i2 = m0 & 7;
                i3 = 4;
                i4 = 65536;
            }
            long j2 = i3;
            if (O0() >= j2) {
                for (int i5 = 1; i5 < i3; i5++) {
                    long j3 = i5;
                    byte m02 = m0(j3);
                    if ((m02 & 192) != 128) {
                        skip(j3);
                        return p0.f15998c;
                    }
                    i2 = (i2 << 6) | (m02 & p0.a);
                }
                skip(j2);
                return i2 > 1114111 ? p0.f15998c : ((55296 <= i2 && 57343 >= i2) || i2 < i4) ? p0.f15998c : i2;
            }
            throw new EOFException("size < " + i3 + ": " + O0() + " (to read code point prefixed 0x" + j.m(m0) + ')');
        }
        throw new EOFException();
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: h1 */
    public m k0(@k.e.a.d String str, @k.e.a.d Charset charset) {
        return P(str, 0, str.length(), charset);
    }

    public int hashCode() {
        i0 i0Var = this.a;
        if (i0Var != null) {
            int i2 = 1;
            do {
                int i3 = i0Var.f15982c;
                for (int i4 = i0Var.b; i4 < i3; i4++) {
                    i2 = (i2 * 31) + i0Var.a[i4];
                }
                i0Var = i0Var.f15985f;
            } while (i0Var != this.a);
            return i2;
        }
        return 0;
    }

    @h.k2.h
    @k.e.a.d
    public final m i1(@k.e.a.d OutputStream outputStream) throws IOException {
        return k1(this, outputStream, 0L, 2, null);
    }

    @Override // j.o
    @k.e.a.d
    public InputStream inputStream() {
        return new b();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @h.k2.g(name = "-deprecated_getByte")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @q0(expression = "this[index]", imports = {}))
    public final byte j(long j2) {
        return m0(j2);
    }

    @Override // j.o
    @k.e.a.d
    public ByteString j0() {
        return V(O0());
    }

    @h.k2.h
    @k.e.a.d
    public final m j1(@k.e.a.d OutputStream outputStream, long j2) throws IOException {
        j.e(this.b, 0L, j2);
        i0 i0Var = this.a;
        while (j2 > 0) {
            int min = (int) Math.min(j2, i0Var.f15982c - i0Var.b);
            outputStream.write(i0Var.a, i0Var.b, min);
            int i2 = i0Var.b + min;
            i0Var.b = i2;
            long j3 = min;
            this.b -= j3;
            j2 -= j3;
            if (i2 == i0Var.f15982c) {
                i0 b2 = i0Var.b();
                this.a = b2;
                j0.d(i0Var);
                i0Var = b2;
            }
        }
        return this;
    }

    @h.k2.g(name = "-deprecated_size")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "size", imports = {}))
    public final long k() {
        return this.b;
    }

    public final void l() {
        skip(O0());
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: l1 */
    public m B(@k.e.a.d String str) {
        return D(str, 0, str.length());
    }

    @Override // j.o
    public long m(byte b2, long j2, long j3) {
        i0 i0Var;
        int i2;
        long j4 = 0;
        if (0 <= j2 && j3 >= j2) {
            if (j3 > O0()) {
                j3 = O0();
            }
            if (j2 == j3 || (i0Var = this.a) == null) {
                return -1L;
            }
            if (O0() - j2 < j2) {
                j4 = O0();
                while (j4 > j2) {
                    i0Var = i0Var.f15986g;
                    j4 -= i0Var.f15982c - i0Var.b;
                }
                if (i0Var != null) {
                    while (j4 < j3) {
                        byte[] bArr = i0Var.a;
                        int min = (int) Math.min(i0Var.f15982c, (i0Var.b + j3) - j4);
                        i2 = (int) ((i0Var.b + j2) - j4);
                        while (i2 < min) {
                            if (bArr[i2] != b2) {
                                i2++;
                            }
                        }
                        j4 += i0Var.f15982c - i0Var.b;
                        i0Var = i0Var.f15985f;
                        j2 = j4;
                    }
                    return -1L;
                }
                return -1L;
            }
            while (true) {
                long j5 = (i0Var.f15982c - i0Var.b) + j4;
                if (j5 > j2) {
                    break;
                }
                i0Var = i0Var.f15985f;
                j4 = j5;
            }
            if (i0Var != null) {
                while (j4 < j3) {
                    byte[] bArr2 = i0Var.a;
                    int min2 = (int) Math.min(i0Var.f15982c, (i0Var.b + j3) - j4);
                    i2 = (int) ((i0Var.b + j2) - j4);
                    while (i2 < min2) {
                        if (bArr2[i2] != b2) {
                            i2++;
                        }
                    }
                    j4 += i0Var.f15982c - i0Var.b;
                    i0Var = i0Var.f15985f;
                    j2 = j4;
                }
                return -1L;
            }
            return -1L;
            return (i2 - i0Var.b) + j4;
        }
        throw new IllegalArgumentException(("size=" + O0() + " fromIndex=" + j2 + " toIndex=" + j3).toString());
    }

    @h.k2.g(name = "getByte")
    public final byte m0(long j2) {
        j.e(O0(), j2, 1L);
        i0 i0Var = this.a;
        if (i0Var != null) {
            if (O0() - j2 < j2) {
                long O0 = O0();
                while (O0 > j2) {
                    i0Var = i0Var.f15986g;
                    O0 -= i0Var.f15982c - i0Var.b;
                }
                return i0Var.a[(int) ((i0Var.b + j2) - O0)];
            }
            long j3 = 0;
            while (true) {
                long j4 = (i0Var.f15982c - i0Var.b) + j3;
                if (j4 > j2) {
                    return i0Var.a[(int) ((i0Var.b + j2) - j3)];
                }
                i0Var = i0Var.f15985f;
                j3 = j4;
            }
        } else {
            i0 i0Var2 = null;
            return i0Var2.a[(int) ((i0Var2.b + j2) - (-1))];
        }
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: m1 */
    public m D(@k.e.a.d String str, int i2, int i3) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
        }
        if (i3 >= i2) {
            if (!(i3 <= str.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
            }
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    i0 R0 = R0(1);
                    byte[] bArr = R0.a;
                    int i4 = R0.f15982c - i2;
                    int min = Math.min(i3, 8192 - i4);
                    int i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) charAt;
                    while (i5 < min) {
                        char charAt2 = str.charAt(i5);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i5 + i4] = (byte) charAt2;
                        i5++;
                    }
                    int i6 = R0.f15982c;
                    int i7 = (i4 + i5) - i6;
                    R0.f15982c = i6 + i7;
                    K0(O0() + i7);
                    i2 = i5;
                } else {
                    if (charAt < 2048) {
                        i0 R02 = R0(2);
                        byte[] bArr2 = R02.a;
                        int i8 = R02.f15982c;
                        bArr2[i8] = (byte) ((charAt >> 6) | 192);
                        bArr2[i8 + 1] = (byte) ((charAt & k.b.a.a.o.e.a) | 128);
                        R02.f15982c = i8 + 2;
                        K0(O0() + 2);
                    } else if (charAt >= 55296 && charAt <= 57343) {
                        int i9 = i2 + 1;
                        char charAt3 = i9 < i3 ? str.charAt(i9) : (char) 0;
                        if (charAt <= 56319 && 56320 <= charAt3 && 57343 >= charAt3) {
                            int i10 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + 65536;
                            i0 R03 = R0(4);
                            byte[] bArr3 = R03.a;
                            int i11 = R03.f15982c;
                            bArr3[i11] = (byte) ((i10 >> 18) | 240);
                            bArr3[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                            bArr3[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                            bArr3[i11 + 3] = (byte) ((i10 & 63) | 128);
                            R03.f15982c = i11 + 4;
                            K0(O0() + 4);
                            i2 += 2;
                        } else {
                            writeByte(63);
                            i2 = i9;
                        }
                    } else {
                        i0 R04 = R0(3);
                        byte[] bArr4 = R04.a;
                        int i12 = R04.f15982c;
                        bArr4[i12] = (byte) ((charAt >> '\f') | 224);
                        bArr4[i12 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                        bArr4[i12 + 2] = (byte) ((charAt & k.b.a.a.o.e.a) | 128);
                        R04.f15982c = i12 + 3;
                        K0(O0() + 3);
                    }
                    i2++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
    }

    @k.e.a.d
    /* renamed from: n */
    public m clone() {
        return q();
    }

    @Override // j.o
    public int n0() throws EOFException {
        return j.h(readInt());
    }

    @Override // j.n
    @k.e.a.d
    /* renamed from: n1 */
    public m w(int i2) {
        if (i2 < 128) {
            writeByte(i2);
        } else if (i2 < 2048) {
            i0 R0 = R0(2);
            byte[] bArr = R0.a;
            int i3 = R0.f15982c;
            bArr[i3] = (byte) ((i2 >> 6) | 192);
            bArr[i3 + 1] = (byte) ((i2 & 63) | 128);
            R0.f15982c = i3 + 2;
            K0(O0() + 2);
        } else if (55296 <= i2 && 57343 >= i2) {
            writeByte(63);
        } else if (i2 < 65536) {
            i0 R02 = R0(3);
            byte[] bArr2 = R02.a;
            int i4 = R02.f15982c;
            bArr2[i4] = (byte) ((i2 >> 12) | 224);
            bArr2[i4 + 1] = (byte) (((i2 >> 6) & 63) | 128);
            bArr2[i4 + 2] = (byte) ((i2 & 63) | 128);
            R02.f15982c = i4 + 3;
            K0(O0() + 3);
        } else if (i2 <= 1114111) {
            i0 R03 = R0(4);
            byte[] bArr3 = R03.a;
            int i5 = R03.f15982c;
            bArr3[i5] = (byte) ((i2 >> 18) | 240);
            bArr3[i5 + 1] = (byte) (((i2 >> 12) & 63) | 128);
            bArr3[i5 + 2] = (byte) (((i2 >> 6) & 63) | 128);
            bArr3[i5 + 3] = (byte) ((i2 & 63) | 128);
            R03.f15982c = i5 + 4;
            K0(O0() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + j.n(i2));
        }
        return this;
    }

    public final long o() {
        long O0 = O0();
        if (O0 == 0) {
            return 0L;
        }
        i0 i0Var = this.a.f15986g;
        int i2 = i0Var.f15982c;
        if (i2 < 8192 && i0Var.f15984e) {
            O0 -= i2 - i0Var.b;
        }
        return O0;
    }

    @Override // j.o
    public long p(@k.e.a.d ByteString byteString) {
        return Q(byteString, 0L);
    }

    @Override // j.o
    @k.e.a.d
    public String p0() {
        return q0(this.b, h.t2.d.a);
    }

    @Override // j.o
    @k.e.a.d
    public o peek() {
        return z.d(new e0(this));
    }

    @k.e.a.d
    public final m q() {
        m mVar = new m();
        if (O0() != 0) {
            i0 i0Var = this.a;
            i0 d2 = i0Var.d();
            mVar.a = d2;
            d2.f15986g = d2;
            d2.f15985f = d2;
            for (i0 i0Var2 = i0Var.f15985f; i0Var2 != i0Var; i0Var2 = i0Var2.f15985f) {
                d2.f15986g.c(i0Var2.d());
            }
            mVar.K0(O0());
        }
        return mVar;
    }

    @Override // j.o
    @k.e.a.d
    public String q0(long j2, @k.e.a.d Charset charset) throws EOFException {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 >= 0 && j2 <= ((long) Integer.MAX_VALUE)) {
            if (this.b >= j2) {
                if (i2 == 0) {
                    return "";
                }
                i0 i0Var = this.a;
                int i3 = i0Var.b;
                if (i3 + j2 > i0Var.f15982c) {
                    return new String(L(j2), charset);
                }
                int i4 = (int) j2;
                String str = new String(i0Var.a, i3, i4, charset);
                int i5 = i0Var.b + i4;
                i0Var.b = i5;
                this.b -= j2;
                if (i5 == i0Var.f15982c) {
                    this.a = i0Var.b();
                    j0.d(i0Var);
                }
                return str;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j2).toString());
    }

    @h.k2.h
    @k.e.a.d
    public final m r(@k.e.a.d OutputStream outputStream) throws IOException {
        return J(this, outputStream, 0L, 0L, 6, null);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@k.e.a.d ByteBuffer byteBuffer) throws IOException {
        i0 i0Var = this.a;
        if (i0Var != null) {
            int min = Math.min(byteBuffer.remaining(), i0Var.f15982c - i0Var.b);
            byteBuffer.put(i0Var.a, i0Var.b, min);
            int i2 = i0Var.b + min;
            i0Var.b = i2;
            this.b -= min;
            if (i2 == i0Var.f15982c) {
                this.a = i0Var.b();
                j0.d(i0Var);
            }
            return min;
        }
        return -1;
    }

    @Override // j.o
    public byte readByte() throws EOFException {
        if (O0() != 0) {
            i0 i0Var = this.a;
            int i2 = i0Var.b;
            int i3 = i0Var.f15982c;
            int i4 = i2 + 1;
            byte b2 = i0Var.a[i2];
            K0(O0() - 1);
            if (i4 == i3) {
                this.a = i0Var.b();
                j0.d(i0Var);
            } else {
                i0Var.b = i4;
            }
            return b2;
        }
        throw new EOFException();
    }

    @Override // j.o
    public void readFully(@k.e.a.d byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = read(bArr, i2, bArr.length - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 += read;
        }
    }

    @Override // j.o
    public int readInt() throws EOFException {
        if (O0() >= 4) {
            i0 i0Var = this.a;
            int i2 = i0Var.b;
            int i3 = i0Var.f15982c;
            if (i3 - i2 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = i0Var.a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i7 = i5 + 1;
            int i8 = i6 | ((bArr[i5] & 255) << 8);
            int i9 = i7 + 1;
            int i10 = i8 | (bArr[i7] & 255);
            K0(O0() - 4);
            if (i9 == i3) {
                this.a = i0Var.b();
                j0.d(i0Var);
            } else {
                i0Var.b = i9;
            }
            return i10;
        }
        throw new EOFException();
    }

    @Override // j.o
    public long readLong() throws EOFException {
        if (O0() >= 8) {
            i0 i0Var = this.a;
            int i2 = i0Var.b;
            int i3 = i0Var.f15982c;
            if (i3 - i2 < 8) {
                return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
            }
            byte[] bArr = i0Var.a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            long j2 = ((bArr[i2] & 255) << 56) | ((bArr[i4] & 255) << 48) | ((bArr[i5] & 255) << 40);
            int i7 = i6 + 1;
            long j3 = ((bArr[i6] & 255) << 32) | j2;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            long j4 = j3 | ((bArr[i7] & 255) << 24) | ((bArr[i8] & 255) << 16);
            int i10 = i9 + 1;
            int i11 = i10 + 1;
            long j5 = j4 | ((bArr[i9] & 255) << 8) | (bArr[i10] & 255);
            K0(O0() - 8);
            if (i11 == i3) {
                this.a = i0Var.b();
                j0.d(i0Var);
            } else {
                i0Var.b = i11;
            }
            return j5;
        }
        throw new EOFException();
    }

    @Override // j.o
    public short readShort() throws EOFException {
        if (O0() >= 2) {
            i0 i0Var = this.a;
            int i2 = i0Var.b;
            int i3 = i0Var.f15982c;
            if (i3 - i2 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = i0Var.a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            K0(O0() - 2);
            if (i5 == i3) {
                this.a = i0Var.b();
                j0.d(i0Var);
            } else {
                i0Var.b = i5;
            }
            return (short) i6;
        }
        throw new EOFException();
    }

    @h.k2.h
    @k.e.a.d
    public final m s(@k.e.a.d OutputStream outputStream, long j2) throws IOException {
        return J(this, outputStream, j2, 0L, 4, null);
    }

    @Override // j.o
    public long s0(@k.e.a.d k0 k0Var) throws IOException {
        long O0 = O0();
        if (O0 > 0) {
            k0Var.write(this, O0);
        }
        return O0;
    }

    @Override // j.o
    public void skip(long j2) throws EOFException {
        while (j2 > 0) {
            i0 i0Var = this.a;
            if (i0Var != null) {
                int min = (int) Math.min(j2, i0Var.f15982c - i0Var.b);
                long j3 = min;
                K0(O0() - j3);
                j2 -= j3;
                int i2 = i0Var.b + min;
                i0Var.b = i2;
                if (i2 == i0Var.f15982c) {
                    this.a = i0Var.b();
                    j0.d(i0Var);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @h.k2.h
    @k.e.a.d
    public final m t(@k.e.a.d OutputStream outputStream, long j2, long j3) throws IOException {
        int i2;
        j.e(this.b, j2, j3);
        if (j3 == 0) {
            return this;
        }
        i0 i0Var = this.a;
        while (true) {
            int i3 = i0Var.f15982c;
            int i4 = i0Var.b;
            if (j2 < i3 - i4) {
                break;
            }
            j2 -= i3 - i4;
            i0Var = i0Var.f15985f;
        }
        while (j3 > 0) {
            int min = (int) Math.min(i0Var.f15982c - i2, j3);
            outputStream.write(i0Var.a, (int) (i0Var.b + j2), min);
            j3 -= min;
            i0Var = i0Var.f15985f;
            j2 = 0;
        }
        return this;
    }

    @Override // j.m0
    @k.e.a.d
    public o0 timeout() {
        return o0.NONE;
    }

    @k.e.a.d
    public String toString() {
        return P0().toString();
    }

    @Override // j.o
    @k.e.a.d
    public m u() {
        return this;
    }

    @k.e.a.d
    public final ByteString u0(@k.e.a.d ByteString byteString) {
        return o0("HmacSHA1", byteString);
    }

    @Override // j.n
    @k.e.a.d
    public OutputStream v0() {
        return new c();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ab A[EDGE_INSN: B:42:0x00ab->B:37:0x00ab ?: BREAK  , SYNTHETIC] */
    @Override // j.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long w0() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.O0()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lb5
            r0 = 0
            r4 = r2
            r1 = 0
        Ld:
            j.i0 r6 = r15.a
            byte[] r7 = r6.a
            int r8 = r6.b
            int r9 = r6.f15982c
        L15:
            if (r8 >= r9) goto L97
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L26
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L26
            int r11 = r10 - r11
            goto L40
        L26:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L35
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L35
        L30:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L40
        L35:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L78
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L78
            goto L30
        L40:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L50
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L15
        L50:
            j.m r0 = new j.m
            r0.<init>()
            j.m r0 = r0.i0(r4)
            j.m r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.p0()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L78:
            if (r0 == 0) goto L7c
            r1 = 1
            goto L97
        L7c:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = j.j.m(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L97:
            if (r8 != r9) goto La3
            j.i0 r7 = r6.b()
            r15.a = r7
            j.j0.d(r6)
            goto La5
        La3:
            r6.b = r8
        La5:
            if (r1 != 0) goto Lab
            j.i0 r6 = r15.a
            if (r6 != 0) goto Ld
        Lab:
            long r1 = r15.O0()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.K0(r1)
            return r4
        Lb5:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j.m.w0():long");
    }

    @k.e.a.d
    public final ByteString x0(@k.e.a.d ByteString byteString) {
        return o0("HmacSHA256", byteString);
    }

    @Override // j.o
    @k.e.a.e
    public String y() throws EOFException {
        long T = T((byte) 10);
        if (T != -1) {
            return j.q0.a.b0(this, T);
        }
        if (O0() != 0) {
            return U(O0());
        }
        return null;
    }

    @Override // j.o
    public int y0(@k.e.a.d c0 c0Var) {
        int e0 = j.q0.a.e0(this, c0Var, false, 2, null);
        if (e0 == -1) {
            return -1;
        }
        skip(c0Var.g()[e0].size());
        return e0;
    }

    @k.e.a.d
    public final ByteString z0(@k.e.a.d ByteString byteString) {
        return o0("HmacSHA512", byteString);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"j/m$b", "Ljava/io/InputStream;", "", "read", "()I", "", "sink", "offset", "byteCount", "([BII)I", "available", "Lh/t1;", "close", "()V", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(m.this.O0(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (m.this.O0() > 0) {
                return m.this.readByte() & 255;
            }
            return -1;
        }

        @k.e.a.d
        public String toString() {
            return m.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(@k.e.a.d byte[] bArr, int i2, int i3) {
            return m.this.read(bArr, i2, i3);
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@k.e.a.d ByteBuffer byteBuffer) throws IOException {
        int remaining = byteBuffer.remaining();
        int i2 = remaining;
        while (i2 > 0) {
            i0 R0 = R0(1);
            int min = Math.min(i2, 8192 - R0.f15982c);
            byteBuffer.get(R0.a, R0.f15982c, min);
            i2 -= min;
            R0.f15982c += min;
        }
        this.b += remaining;
        return remaining;
    }

    @Override // j.o
    public int read(@k.e.a.d byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // j.k0
    public void write(@k.e.a.d m mVar, long j2) {
        if (mVar != this) {
            j.e(mVar.O0(), 0L, j2);
            while (j2 > 0) {
                if (j2 < mVar.a.f15982c - mVar.a.b) {
                    i0 i0Var = this.a;
                    i0 i0Var2 = i0Var != null ? i0Var.f15986g : null;
                    if (i0Var2 != null && i0Var2.f15984e) {
                        if ((i0Var2.f15982c + j2) - (i0Var2.f15983d ? 0 : i0Var2.b) <= 8192) {
                            mVar.a.g(i0Var2, (int) j2);
                            mVar.K0(mVar.O0() - j2);
                            K0(O0() + j2);
                            return;
                        }
                    }
                    mVar.a = mVar.a.e((int) j2);
                }
                i0 i0Var3 = mVar.a;
                long j3 = i0Var3.f15982c - i0Var3.b;
                mVar.a = i0Var3.b();
                i0 i0Var4 = this.a;
                if (i0Var4 == null) {
                    this.a = i0Var3;
                    i0Var3.f15986g = i0Var3;
                    i0Var3.f15985f = i0Var3;
                } else {
                    i0Var4.f15986g.c(i0Var3).a();
                }
                mVar.K0(mVar.O0() - j3);
                K0(O0() + j3);
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    @Override // j.o
    public int read(@k.e.a.d byte[] bArr, int i2, int i3) {
        j.e(bArr.length, i2, i3);
        i0 i0Var = this.a;
        if (i0Var != null) {
            int min = Math.min(i3, i0Var.f15982c - i0Var.b);
            byte[] bArr2 = i0Var.a;
            int i4 = i0Var.b;
            h.a2.n.W0(bArr2, bArr, i2, i4, i4 + min);
            i0Var.b += min;
            K0(O0() - min);
            if (i0Var.b == i0Var.f15982c) {
                this.a = i0Var.b();
                j0.d(i0Var);
                return min;
            }
            return min;
        }
        return -1;
    }

    @Override // j.m0
    public long read(@k.e.a.d m mVar, long j2) {
        if (j2 >= 0) {
            if (O0() == 0) {
                return -1L;
            }
            if (j2 > O0()) {
                j2 = O0();
            }
            mVar.write(this, j2);
            return j2;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }
}

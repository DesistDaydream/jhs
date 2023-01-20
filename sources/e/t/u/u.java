package e.t.u;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.moor.imkf.model.entity.FromToMessage;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.vector.util.IntentAction;
import com.xiaomi.mipush.sdk.Constants;
import h.k2.v.f0;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007J;\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nJ\u001c\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u001c"}, d2 = {"Lcom/vector/util/PhotoUtil;", "", "()V", "fromAlbum", "", ReportItem.RequestKeyHost, "requestCode", "", "fromCamera", "path", "", "getDataColumn", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getImageNameFormPath", "getPath", "isDownloadsDocument", "", "isExternalStorageDocument", "isGooglePhotosUri", "isMediaDocument", "isOtherImageUri", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class u {
    @k.e.a.d
    public static final u a = new u();

    private u() {
    }

    private final String c(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        query.close();
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final boolean f(Uri uri) {
        return f0.g("com.android.providers.downloads.documents", uri.getAuthority());
    }

    private final boolean g(Uri uri) {
        return f0.g("com.android.externalstorage.documents", uri.getAuthority());
    }

    private final boolean h(Uri uri) {
        return f0.g("com.google.android.apps.photos.content", uri.getAuthority());
    }

    private final boolean i(Uri uri) {
        return f0.g("com.android.providers.media.documents", uri.getAuthority());
    }

    private final boolean j(Uri uri) {
        int hashCode;
        String authority = uri.getAuthority();
        return authority != null && ((hashCode = authority.hashCode()) == -785965904 ? authority.equals("com.meizu.notepaper.fileprovider") : hashCode == 467297391 ? authority.equals("org.telegram.messenger.provider") : hashCode == 1125994298 && authority.equals("com.example.android.notepad.files"));
    }

    public final void a(@k.e.a.d Object obj, int i2) {
        IntentAction.a.k().l(obj).k(i2).n(IntentAction.PhotoSource.ALBUM).i();
    }

    public final void b(@k.e.a.d Object obj, @k.e.a.d String str, int i2) {
        IntentAction.a.k().l(obj).m(str).n(IntentAction.PhotoSource.CAMERA).k(i2).i();
    }

    @k.e.a.d
    public final String d(@k.e.a.d String str) {
        List S4 = StringsKt__StringsKt.S4(str, new String[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, false, 0, 6, null);
        if (!S4.isEmpty()) {
            List S42 = StringsKt__StringsKt.S4((CharSequence) S4.get(S4.size() - 1), new String[]{"."}, false, 0, 6, null);
            if (S42.size() > 1) {
                int length = ((String) S42.get(S42.size() - 1)).length();
                String str2 = (String) S4.get(S4.size() - 1);
                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                return f0.C(str2.substring(0, (str2.length() - length) - 1), Integer.valueOf((int) (Math.random() * 10)));
            }
            return (String) S4.get(S4.size() - 1);
        }
        return str;
    }

    @k.e.a.e
    @TargetApi(19)
    public final String e(@k.e.a.d Context context, @k.e.a.e Uri uri) {
        List E;
        boolean z;
        List E2;
        boolean z2;
        Uri uri2 = null;
        if (uri == null) {
            return null;
        }
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (g(uri)) {
                List<String> split = new Regex(Constants.COLON_SEPARATOR).split(DocumentsContract.getDocumentId(uri), 0);
                if (!split.isEmpty()) {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() == 0) {
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (!z2) {
                            E2 = CollectionsKt___CollectionsKt.w5(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                E2 = CollectionsKt__CollectionsKt.E();
                Object[] array = E2.toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                String[] strArr = (String[]) array;
                if (h.t2.u.K1("primary", strArr[0], true)) {
                    return Environment.getExternalStorageDirectory().toString() + Attributes.InternalPrefix + strArr[1];
                }
            } else if (f(uri)) {
                return c(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(DocumentsContract.getDocumentId(uri))), null, null);
            } else {
                if (i(uri)) {
                    List<String> split2 = new Regex(Constants.COLON_SEPARATOR).split(DocumentsContract.getDocumentId(uri), 0);
                    if (!split2.isEmpty()) {
                        ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                        while (listIterator2.hasPrevious()) {
                            if (listIterator2.previous().length() == 0) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (!z) {
                                E = CollectionsKt___CollectionsKt.w5(split2, listIterator2.nextIndex() + 1);
                                break;
                            }
                        }
                    }
                    E = CollectionsKt__CollectionsKt.E();
                    Object[] array2 = E.toArray(new String[0]);
                    Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                    String[] strArr2 = (String[]) array2;
                    String str = strArr2[0];
                    if (f0.g(FromToMessage.MSG_TYPE_IMAGE, str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if (f0.g("video", str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if (f0.g(TUIConstants.TUICalling.TYPE_AUDIO, str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return c(context, uri2, "_id=?", new String[]{strArr2[1]});
                }
            }
        } else if (h.t2.u.K1("content", uri.getScheme(), true)) {
            return h(uri) ? uri.getLastPathSegment() : j(uri) ? c0.c(context, uri) : c(context, uri, null, null);
        } else if (h.t2.u.K1("file", uri.getScheme(), true)) {
            return uri.getPath();
        }
        return null;
    }
}

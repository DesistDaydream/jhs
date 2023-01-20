package com.bytedance.pangle;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {
    private static final String[] a = {"_display_name", "_size"};
    private static final File b = new File(MqttTopic.TOPIC_LEVEL_SEPARATOR);

    /* renamed from: c */
    private static a f2191c;

    /* loaded from: classes.dex */
    public interface a {
        Uri a(File file);

        File a(Uri uri);
    }

    public static void a(Plugin plugin, XmlResourceParser xmlResourceParser) {
        int i2 = Build.VERSION.SDK_INT;
        try {
            try {
                String str = plugin.mPkgName;
                Context wrapperContext = ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), plugin.mPkgName);
                b bVar = (b) f2191c;
                while (true) {
                    int next = xmlResourceParser.next();
                    if (next == 1) {
                        return;
                    }
                    if (next == 2) {
                        String name = xmlResourceParser.getName();
                        File file = null;
                        String attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, "path");
                        if ("root-path".equals(name)) {
                            file = b;
                        } else if ("files-path".equals(name)) {
                            file = wrapperContext.getFilesDir();
                        } else if ("cache-path".equals(name)) {
                            file = wrapperContext.getCacheDir();
                        } else if ("external-path".equals(name)) {
                            file = Environment.getExternalStorageDirectory();
                        } else if ("external-files-path".equals(name)) {
                            File[] externalFilesDirs = i2 >= 19 ? wrapperContext.getExternalFilesDirs(null) : new File[]{wrapperContext.getExternalFilesDir(null)};
                            if (externalFilesDirs.length > 0) {
                                file = externalFilesDirs[0];
                            }
                        } else if ("external-cache-path".equals(name)) {
                            File[] externalCacheDirs = i2 >= 19 ? wrapperContext.getExternalCacheDirs() : new File[]{wrapperContext.getExternalCacheDir()};
                            if (externalCacheDirs.length > 0) {
                                file = externalCacheDirs[0];
                            }
                        } else if (i2 >= 21 && "external-media-path".equals(name)) {
                            File[] externalMediaDirs = wrapperContext.getExternalMediaDirs();
                            if (externalMediaDirs.length > 0) {
                                file = externalMediaDirs[0];
                            }
                        }
                        if (file != null) {
                            String str2 = str + "_" + attributeValue;
                            File a2 = a(file, attributeValue2);
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    bVar.a.put(str2, a2.getCanonicalFile());
                                } catch (IOException e2) {
                                    throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(a2)), e2);
                                }
                            } else {
                                throw new IllegalArgumentException("Name must not be empty");
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
            }
        } catch (XmlPullParserException e4) {
            e = e4;
            e.printStackTrace();
        }
    }

    @Keep
    public static Uri getUriForFile(@NonNull File file) {
        return f2191c.a(file);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@NonNull Context context, @NonNull ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (!providerInfo.exported) {
            if (providerInfo.grantUriPermissions) {
                if (f2191c == null) {
                    f2191c = new b(providerInfo.authority);
                    return;
                }
                throw new SecurityException("仅允许定义一个FileProvider");
            }
            throw new SecurityException("Provider must grant uri permissions");
        }
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return f2191c.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(@NonNull Uri uri) {
        File a2 = f2191c.a(uri);
        int lastIndexOf = a2.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a2.getName().substring(lastIndexOf + 1));
            return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) {
        int i2;
        File a2 = f2191c.a(uri);
        if ("r".equals(str)) {
            i2 = 268435456;
        } else if (IAdInterListener.AdReqParam.WIDTH.equals(str) || "wt".equals(str)) {
            i2 = 738197504;
        } else if ("wa".equals(str)) {
            i2 = 704643072;
        } else if ("rw".equals(str)) {
            i2 = 939524096;
        } else if (!"rwt".equals(str)) {
            throw new IllegalArgumentException("Invalid mode: ".concat(String.valueOf(str)));
        } else {
            i2 = 1006632960;
        }
        return ParcelFileDescriptor.open(a2, i2);
    }

    @Override // android.content.ContentProvider
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int i2;
        File a2 = f2191c.a(uri);
        if (strArr == null) {
            strArr = a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i3 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i3] = "_display_name";
                i2 = i3 + 1;
                objArr[i3] = a2.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i3] = "_size";
                i2 = i3 + 1;
                objArr[i3] = Long.valueOf(a2.length());
            }
            i3 = i2;
        }
        String[] strArr4 = new String[i3];
        System.arraycopy(strArr3, 0, strArr4, 0, i3);
        Object[] objArr2 = new Object[i3];
        System.arraycopy(objArr, 0, objArr2, 0, i3);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    /* loaded from: classes.dex */
    public static class b implements a {
        public final HashMap<String, File> a = new HashMap<>();
        private final String b;

        public b(String str) {
            this.b = str;
        }

        @Override // com.bytedance.pangle.FileProvider.a
        public final Uri a(File file) {
            String substring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.a.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry != null) {
                    String path2 = entry.getValue().getPath();
                    if (path2.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                        substring = canonicalPath.substring(path2.length());
                    } else {
                        substring = canonicalPath.substring(path2.length() + 1);
                    }
                    return new Uri.Builder().scheme("content").authority(this.b).encodedPath(Uri.encode(entry.getKey()) + Attributes.InternalPrefix + Uri.encode(substring, MqttTopic.TOPIC_LEVEL_SEPARATOR)).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains ".concat(String.valueOf(canonicalPath)));
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)));
            }
        }

        @Override // com.bytedance.pangle.FileProvider.a
        public final File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.a.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file2)));
                }
            }
            throw new IllegalArgumentException("Unable to find configured root for ".concat(String.valueOf(uri)));
        }
    }

    private static File a(File file, String... strArr) {
        for (int i2 = 0; i2 <= 0; i2++) {
            String str = strArr[0];
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }
}

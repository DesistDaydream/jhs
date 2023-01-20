package com.bytedance.pangle.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.multidex.MultiDexExtractor;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.log.ZeusLogger;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public final class b {
    private static final Set<File> a = new HashSet();
    private static final boolean b = a(System.getProperty("java.vm.version"));

    /* loaded from: classes.dex */
    public static final class a {
        private static final int a = 4;
        private final InterfaceC0076a b;

        /* renamed from: com.bytedance.pangle.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0076a {
            Object a(File file, DexFile dexFile);
        }

        /* renamed from: com.bytedance.pangle.d.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0077b implements InterfaceC0076a {
            private final Constructor<?> a;

            public C0077b(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
                this.a = constructor;
                constructor.setAccessible(true);
            }

            @Override // com.bytedance.pangle.d.b.a.InterfaceC0076a
            public final Object a(File file, DexFile dexFile) {
                return this.a.newInstance(file, new ZipFile(file), dexFile);
            }
        }

        /* loaded from: classes.dex */
        public static class c implements InterfaceC0076a {
            private final Constructor<?> a;

            public c(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(File.class, File.class, DexFile.class);
                this.a = constructor;
                constructor.setAccessible(true);
            }

            @Override // com.bytedance.pangle.d.b.a.InterfaceC0076a
            public final Object a(File file, DexFile dexFile) {
                return this.a.newInstance(file, file, dexFile);
            }
        }

        /* loaded from: classes.dex */
        public static class d implements InterfaceC0076a {
            private final Constructor<?> a;

            public d(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                this.a = constructor;
                constructor.setAccessible(true);
            }

            @Override // com.bytedance.pangle.d.b.a.InterfaceC0076a
            public final Object a(File file, DexFile dexFile) {
                return this.a.newInstance(file, Boolean.FALSE, file, dexFile);
            }
        }

        private a() {
            InterfaceC0076a dVar;
            Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
            try {
                try {
                    dVar = new C0077b(cls);
                } catch (NoSuchMethodException unused) {
                    dVar = new d(cls);
                }
            } catch (NoSuchMethodException unused2) {
                dVar = new c(cls);
            }
            this.b = dVar;
        }

        public static void a(ClassLoader classLoader, List<? extends File> list) {
            Object obj = b.b(classLoader, "pathList").get(classLoader);
            a aVar = new a();
            int size = list.size();
            Object[] objArr = new Object[size];
            for (int i2 = 0; i2 < size; i2++) {
                File file = list.get(i2);
                InterfaceC0076a interfaceC0076a = aVar.b;
                String path = file.getPath();
                File parentFile = file.getParentFile();
                String name = file.getName();
                objArr[i2] = interfaceC0076a.a(file, DexFile.loadDex(path, new File(parentFile, name.substring(0, name.length() - a) + MultiDexExtractor.DEX_SUFFIX).getPath(), 0));
            }
            try {
                b.a(obj, "dexElements", objArr);
            } catch (NoSuchFieldException e2) {
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed find field 'dexElements' attempting 'pathElements'", e2);
                b.a(obj, "pathElements", objArr);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        public static void a(ClassLoader classLoader, List<? extends File> list) {
            int size = list.size();
            Field b = b.b(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) b.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<? extends File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = next;
                zipFileArr[previousIndex] = new ZipFile(next);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + MultiDexExtractor.DEX_SUFFIX, 0);
            }
            b.set(classLoader, sb.toString());
            b.a(classLoader, "mPaths", strArr);
            b.a(classLoader, "mFiles", fileArr);
            b.a(classLoader, "mZips", zipFileArr);
            b.a(classLoader, "mDexs", dexFileArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field b(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    public static void a(PluginContext pluginContext) {
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Installing application");
        if (b) {
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 4) {
            try {
                ApplicationInfo a2 = a((Context) pluginContext);
                if (a2 == null) {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                a(a2, pluginContext, new File(pluginContext.mPlugin.mHostApplicationInfoHookSomeField.sourceDir), "secondary-dexes", a2.packageName);
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex install done");
                return;
            } catch (Exception e2) {
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex MultiDex installation failure", e2);
                throw new RuntimeException("MultiDex installation failed (" + e2.getMessage() + ").");
            }
        }
        throw new RuntimeException("MultiDex installation failed. SDK " + i2 + " is unsupported. Min SDK version is 4.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method b(Object obj, String str, Class... clsArr) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static void b(PluginContext pluginContext) {
        File file = new File(pluginContext.getDataDir().getAbsolutePath() + "/files/secondary-dexes");
        if (file.isDirectory()) {
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (file2.delete()) {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Deleted old file " + file2.getPath());
                } else {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to delete old file " + file2.getPath());
                }
            }
            if (!file.delete()) {
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to delete secondary dex dir " + file.getPath());
                return;
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Deleted old secondary dex dir " + file.getPath());
        }
    }

    private static void a(@NonNull ApplicationInfo applicationInfo, PluginContext pluginContext, File file, String str, String str2) {
        Set<File> set = a;
        synchronized (set) {
            if (!set.contains(file)) {
                set.add(file);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 > 20) {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex MultiDex is not guaranteed to work in SDK version " + i2 + ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
                }
                try {
                    PluginClassLoader pluginClassLoader = pluginContext.mPlugin.mClassLoader;
                    if (pluginClassLoader == null) {
                        ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginMultiDex Context class loader is null. Must be running in test mode. Skip patching.");
                    } else {
                        String str3 = applicationInfo.packageName;
                        b(pluginContext);
                        File a2 = a(pluginContext, pluginContext.getDataDir(), str);
                        com.bytedance.pangle.d.a aVar = new com.bytedance.pangle.d.a(file, a2);
                        IOException e2 = null;
                        try {
                            a(pluginClassLoader, a2, aVar.a(pluginContext, str2, false));
                        } catch (IOException e3) {
                            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginMultiDexFailed to install extracted secondary dex files, retrying with forced extraction", e3);
                            a(pluginClassLoader, a2, aVar.a(pluginContext, str2, true));
                        }
                        try {
                            aVar.close();
                        } catch (IOException e4) {
                            e2 = e4;
                        }
                        if (e2 != null) {
                            throw e2;
                        }
                    }
                } catch (RuntimeException e5) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginMultiDex Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e5);
                }
            }
        }
    }

    /* renamed from: com.bytedance.pangle.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0078b {
        public static void a(ClassLoader classLoader, List<? extends File> list, File file) {
            IOException[] iOExceptionArr;
            Object obj = b.b(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            b.a(obj, "dexElements", a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginMultiDex Exception in makeDexElement", (IOException) it.next());
                }
                Field b = b.b(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) b.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                b.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        private static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            return (Object[]) b.b(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, arrayList, file, arrayList2);
        }
    }

    private static ApplicationInfo a(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginMultiDexFailure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e2);
            return null;
        }
    }

    private static boolean a(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder("PluginMultiDex VM with version ");
        sb.append(str);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        ZeusLogger.i(ZeusLogger.TAG_LOAD, sb.toString());
        return z;
    }

    private static void a(ClassLoader classLoader, File file, List<? extends File> list) {
        if (list.isEmpty()) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            C0078b.a(classLoader, list, file);
        } else if (i2 >= 14) {
            a.a(classLoader, list);
        } else {
            c.a(classLoader, list);
        }
    }

    private static File a(Context context, File file, String str) {
        File file2 = new File(file, "code_cache");
        try {
            a(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), "code_cache");
            a(file2);
        }
        File file3 = new File(file2, str);
        a(file3);
        return file3;
    }

    private static void a(File file) {
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to create dir " + file.getPath() + ". Parent file is null.");
        } else {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
        }
        throw new IOException("Failed to create directory " + file.getPath());
    }

    public static /* synthetic */ void a(Object obj, String str, Object[] objArr) {
        Field b2 = b(obj, str);
        Object[] objArr2 = (Object[]) b2.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        b2.set(obj, objArr3);
    }
}

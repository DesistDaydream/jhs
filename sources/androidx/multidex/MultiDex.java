package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public final class MultiDex {
    private static final String CODE_CACHE_NAME = "code_cache";
    private static final String CODE_CACHE_SECONDARY_FOLDER_NAME = "secondary-dexes";
    private static final int MAX_SUPPORTED_SDK_VERSION = 20;
    private static final int MIN_SDK_VERSION = 4;
    private static final String NO_KEY_PREFIX = "";
    private static final String OLD_SECONDARY_FOLDER_NAME = "secondary-dexes";
    public static final String TAG = "MultiDex";
    private static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
    private static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;
    private static final Set<File> installedApk = new HashSet();
    private static final boolean IS_VM_MULTIDEX_CAPABLE = isVMMultidexCapable(System.getProperty("java.vm.version"));

    /* loaded from: classes.dex */
    public static final class V14 {
        private static final int EXTRACTED_SUFFIX_LENGTH = 4;
        private final ElementConstructor elementConstructor;

        /* loaded from: classes.dex */
        public interface ElementConstructor {
            Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
        }

        /* loaded from: classes.dex */
        public static class ICSElementConstructor implements ElementConstructor {
            private final Constructor<?> elementConstructor;

            public ICSElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Constructor<?> constructor = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
                this.elementConstructor = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
                return this.elementConstructor.newInstance(file, new ZipFile(file), dexFile);
            }
        }

        /* loaded from: classes.dex */
        public static class JBMR11ElementConstructor implements ElementConstructor {
            private final Constructor<?> elementConstructor;

            public JBMR11ElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Constructor<?> constructor = cls.getConstructor(File.class, File.class, DexFile.class);
                this.elementConstructor = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.elementConstructor.newInstance(file, file, dexFile);
            }
        }

        /* loaded from: classes.dex */
        public static class JBMR2ElementConstructor implements ElementConstructor {
            private final Constructor<?> elementConstructor;

            public JBMR2ElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Constructor<?> constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                this.elementConstructor = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.elementConstructor.newInstance(file, Boolean.FALSE, file, dexFile);
            }
        }

        private V14() throws ClassNotFoundException, SecurityException, NoSuchMethodException {
            ElementConstructor jBMR2ElementConstructor;
            Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
            try {
                try {
                    jBMR2ElementConstructor = new ICSElementConstructor(cls);
                } catch (NoSuchMethodException unused) {
                    jBMR2ElementConstructor = new JBMR2ElementConstructor(cls);
                }
            } catch (NoSuchMethodException unused2) {
                jBMR2ElementConstructor = new JBMR11ElementConstructor(cls);
            }
            this.elementConstructor = jBMR2ElementConstructor;
        }

        public static void install(ClassLoader classLoader, List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
            Object obj = MultiDex.findField(classLoader, "pathList").get(classLoader);
            Object[] makeDexElements = new V14().makeDexElements(list);
            try {
                MultiDex.expandFieldArray(obj, "dexElements", makeDexElements);
            } catch (NoSuchFieldException e2) {
                Log.w(MultiDex.TAG, "Failed find field 'dexElements' attempting 'pathElements'", e2);
                MultiDex.expandFieldArray(obj, "pathElements", makeDexElements);
            }
        }

        private Object[] makeDexElements(List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
            int size = list.size();
            Object[] objArr = new Object[size];
            for (int i2 = 0; i2 < size; i2++) {
                File file = list.get(i2);
                objArr[i2] = this.elementConstructor.newInstance(file, DexFile.loadDex(file.getPath(), optimizedPathFor(file), 0));
            }
            return objArr;
        }

        private static String optimizedPathFor(File file) {
            File parentFile = file.getParentFile();
            String name = file.getName();
            return new File(parentFile, name.substring(0, name.length() - EXTRACTED_SUFFIX_LENGTH) + MultiDexExtractor.DEX_SUFFIX).getPath();
        }
    }

    /* loaded from: classes.dex */
    public static final class V19 {
        private V19() {
        }

        public static void install(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            IOException[] iOExceptionArr;
            Object obj = MultiDex.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            MultiDex.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w(MultiDex.TAG, "Exception in makeDexElement", (IOException) it.next());
                }
                Field findField = MultiDex.findField(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) findField.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                findField.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) MultiDex.findMethod(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, arrayList, file, arrayList2);
        }
    }

    /* loaded from: classes.dex */
    public static final class V4 {
        private V4() {
        }

        public static void install(ClassLoader classLoader, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            Field findField = MultiDex.findField(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) findField.get(classLoader));
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
            findField.set(classLoader, sb.toString());
            MultiDex.expandFieldArray(classLoader, "mPaths", strArr);
            MultiDex.expandFieldArray(classLoader, "mFiles", fileArr);
            MultiDex.expandFieldArray(classLoader, "mZips", zipFileArr);
            MultiDex.expandFieldArray(classLoader, "mDexs", dexFileArr);
        }
    }

    private MultiDex() {
    }

    private static void clearOldDexDir(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i(TAG, "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Log.w(TAG, "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                Log.i(TAG, "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (file2.delete()) {
                    Log.i(TAG, "Deleted old file " + file2.getPath());
                } else {
                    Log.w(TAG, "Failed to delete old file " + file2.getPath());
                }
            }
            if (!file.delete()) {
                Log.w(TAG, "Failed to delete secondary dex dir " + file.getPath());
                return;
            }
            Log.i(TAG, "Deleted old secondary dex dir " + file.getPath());
        }
    }

    private static void doInstallation(Context context, File file, File file2, String str, String str2, boolean z) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
        Set<File> set = installedApk;
        synchronized (set) {
            if (set.contains(file)) {
                return;
            }
            set.add(file);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 20) {
                Log.w(TAG, "MultiDex is not guaranteed to work in SDK version " + i2 + ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
            }
            ClassLoader dexClassloader = getDexClassloader(context);
            if (dexClassloader == null) {
                return;
            }
            clearOldDexDir(context);
            File dexDir = getDexDir(context, file2, str);
            MultiDexExtractor multiDexExtractor = new MultiDexExtractor(file, dexDir);
            IOException e2 = null;
            try {
                installSecondaryDexes(dexClassloader, dexDir, multiDexExtractor.load(context, str2, false));
            } catch (IOException e3) {
                if (z) {
                    Log.w(TAG, "Failed to install extracted secondary dex files, retrying with forced extraction", e3);
                    installSecondaryDexes(dexClassloader, dexDir, multiDexExtractor.load(context, str2, true));
                } else {
                    throw e3;
                }
            }
            try {
                multiDexExtractor.close();
            } catch (IOException e4) {
                e2 = e4;
            }
            if (e2 != null) {
                throw e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void expandFieldArray(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field findField = findField(obj, str);
        Object[] objArr2 = (Object[]) findField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        findField.set(obj, objArr3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field findField(Object obj, String str) throws NoSuchFieldException {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static Method findMethod(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
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

    private static ApplicationInfo getApplicationInfo(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e2) {
            Log.w(TAG, "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e2);
            return null;
        }
    }

    private static ClassLoader getDexClassloader(Context context) {
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (Build.VERSION.SDK_INT >= 14) {
                if (classLoader instanceof BaseDexClassLoader) {
                    return classLoader;
                }
            } else if ((classLoader instanceof DexClassLoader) || (classLoader instanceof PathClassLoader)) {
                return classLoader;
            }
            Log.e(TAG, "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
            return null;
        } catch (RuntimeException e2) {
            Log.w(TAG, "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e2);
            return null;
        }
    }

    private static File getDexDir(Context context, File file, String str) throws IOException {
        File file2 = new File(file, CODE_CACHE_NAME);
        try {
            mkdirChecked(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), CODE_CACHE_NAME);
            mkdirChecked(file2);
        }
        File file3 = new File(file2, str);
        mkdirChecked(file3);
        return file3;
    }

    public static void install(Context context) {
        Log.i(TAG, "Installing application");
        if (IS_VM_MULTIDEX_CAPABLE) {
            Log.i(TAG, "VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 4) {
            try {
                ApplicationInfo applicationInfo = getApplicationInfo(context);
                if (applicationInfo == null) {
                    Log.i(TAG, "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                doInstallation(context, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir), "secondary-dexes", "", true);
                Log.i(TAG, "install done");
                return;
            } catch (Exception e2) {
                Log.e(TAG, "MultiDex installation failure", e2);
                throw new RuntimeException("MultiDex installation failed (" + e2.getMessage() + ").");
            }
        }
        throw new RuntimeException("MultiDex installation failed. SDK " + i2 + " is unsupported. Min SDK version is 4.");
    }

    public static void installInstrumentation(Context context, Context context2) {
        Log.i(TAG, "Installing instrumentation");
        if (IS_VM_MULTIDEX_CAPABLE) {
            Log.i(TAG, "VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 4) {
            try {
                ApplicationInfo applicationInfo = getApplicationInfo(context);
                if (applicationInfo == null) {
                    Log.i(TAG, "No ApplicationInfo available for instrumentation, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                ApplicationInfo applicationInfo2 = getApplicationInfo(context2);
                if (applicationInfo2 == null) {
                    Log.i(TAG, "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                String str = context.getPackageName() + ".";
                File file = new File(applicationInfo2.dataDir);
                doInstallation(context2, new File(applicationInfo.sourceDir), file, str + "secondary-dexes", str, false);
                doInstallation(context2, new File(applicationInfo2.sourceDir), file, "secondary-dexes", "", false);
                Log.i(TAG, "Installation done");
                return;
            } catch (Exception e2) {
                Log.e(TAG, "MultiDex installation failure", e2);
                throw new RuntimeException("MultiDex installation failed (" + e2.getMessage() + ").");
            }
        }
        throw new RuntimeException("MultiDex installation failed. SDK " + i2 + " is unsupported. Min SDK version is 4.");
    }

    private static void installSecondaryDexes(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        if (list.isEmpty()) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            V19.install(classLoader, list, file);
        } else if (i2 >= 14) {
            V14.install(classLoader, list);
        } else {
            V4.install(classLoader, list);
        }
    }

    public static boolean isVMMultidexCapable(String str) {
        boolean z = false;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            String nextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (nextToken != null && nextToken2 != null) {
                try {
                    int parseInt = Integer.parseInt(nextToken);
                    int parseInt2 = Integer.parseInt(nextToken2);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VM with version ");
        sb.append(str);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        Log.i(TAG, sb.toString());
        return z;
    }

    private static void mkdirChecked(File file) throws IOException {
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            Log.e(TAG, "Failed to create dir " + file.getPath() + ". Parent file is null.");
        } else {
            Log.e(TAG, "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
        }
        throw new IOException("Failed to create directory " + file.getPath());
    }
}

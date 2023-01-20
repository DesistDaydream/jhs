package androidx.constraintlayout.core.motion.utils;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/* loaded from: classes.dex */
public class Utils {
    private static int clamp(int i2) {
        int i3 = (i2 & (~(i2 >> 31))) - 255;
        return (i3 & (i3 >> 31)) + 255;
    }

    public static void log(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println(str + " : " + str2);
    }

    public static void logStack(String str, int i2) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i2, stackTrace.length - 1);
        String str2 = ExpandableTextView.N;
        for (int i3 = 1; i3 <= min; i3++) {
            StackTraceElement stackTraceElement = stackTrace[i3];
            str2 = str2 + ExpandableTextView.N;
            PrintStream printStream = System.out;
            printStream.println(str + str2 + (".(" + stackTrace[i3].getFileName() + Constants.COLON_SEPARATOR + stackTrace[i3].getLineNumber() + ") " + stackTrace[i3].getMethodName()) + str2);
        }
    }

    public static void loge(String str, String str2) {
        PrintStream printStream = System.err;
        printStream.println(str + " : " + str2);
    }

    public static int rgbaTocColor(float f2, float f3, float f4, float f5) {
        int clamp = clamp((int) (f2 * 255.0f));
        int clamp2 = clamp((int) (f3 * 255.0f));
        return (clamp << 16) | (clamp((int) (f5 * 255.0f)) << 24) | (clamp2 << 8) | clamp((int) (f4 * 255.0f));
    }

    public static void socketSend(String str) {
        try {
            OutputStream outputStream = new Socket("127.0.0.1", 5327).getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public int getInterpolatedColor(float[] fArr) {
        int clamp = clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f));
        int clamp2 = clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f));
        return (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp << 16) | (clamp2 << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public static void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String substring = (stackTraceElement.getMethodName() + "                  ").substring(0, 17);
        String str2 = ".(" + stackTraceElement.getFileName() + Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + ")" + "    ".substring(Integer.toString(stackTraceElement.getLineNumber()).length()) + substring;
        System.out.println(str2 + ExpandableTextView.N + str);
    }
}

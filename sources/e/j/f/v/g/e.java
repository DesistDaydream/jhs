package e.j.f.v.g;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.zxing.WriterException;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;
import org.conscrypt.NativeConstants;

/* loaded from: classes2.dex */
public final class e {
    private static final int[][] a = {new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, 308, 436, 284, 646, 653, 428, 379}, new int[]{TUIMessageBean.MSG_STATUS_DELETE, TTAdConstant.STYLE_SIZE_RADIO_9_16, 232, 755, 599, 524, 801, 132, 295, 116, 442, 428, 295, 42, 176, 65}, new int[]{361, 575, 922, 525, 176, 586, 640, 321, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NOTICE, 147, 593, 800, 571, 320, 803, 133, 231, 390, 685, 330, 63, TTAdConstant.IMAGE_LIST_SIZE_CODE}, new int[]{539, TypedValues.Cycle.TYPE_CUSTOM_WAVE_SHAPE, 6, 93, 862, NativeConstants.TLS1_2_VERSION, 453, 106, TypedValues.Motion.TYPE_QUANTIZE_MOTIONSTEPS, 287, 107, TypedValues.Position.TYPE_SIZE_PERCENT, 733, 877, 381, TypedValues.Motion.TYPE_QUANTIZE_INTERPOLATOR_ID, 723, 476, 462, 172, 430, TypedValues.Motion.TYPE_POLAR_RELATIVETO, 858, 822, 543, 376, FrameMetricsAggregator.EVERY_DURATION, 400, 672, 762, 283, 184, 440, 35, 519, 31, 460, 594, 225, 535, 517, 352, TypedValues.Motion.TYPE_ANIMATE_RELATIVE_TO, 158, 651, AdEventType.VIDEO_CACHE, 488, TypedValues.Position.TYPE_DRAWPATH, 648, 733, 717, 83, 404, 97, 280, NativeConstants.TLS1_2_VERSION, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, TTAdConstant.VIDEO_COVER_URL_CODE, 822, 93, 217, AdEventType.VIDEO_CLICKED, e.j.f.v.a.b, 244, 583, 620, 246, e.j.f.u.d.f11631g, 447, 631, 292, 908, 490, TypedValues.Transition.TYPE_AUTO_TRANSITION, 516, 258, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, TypedValues.Motion.TYPE_ANIMATE_CIRCLEANGLE_TO, 860, 569, 193, 219, ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, 156, 732, 95, 270, 447, 90, TypedValues.Position.TYPE_PERCENT_Y, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME, 380, TypedValues.Motion.TYPE_QUANTIZE_MOTION_PHASE, 754, 336, 89, 614, 87, 432, 670, 616, 157, 374, 242, 726, 600, 269, 375, 898, 845, 454, 354, 130, 814, 587, 804, 34, AdEventType.VIDEO_LOADING, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, 801, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, AdEventType.VIDEO_PAUSE, 82, 586, 708, 250, TypedValues.Custom.TYPE_DIMENSION, 786, 138, 720, 858, 194, 311, 913, TUIMessageBean.MSG_STATUS_REVOKE, 190, 375, 850, 438, 733, 194, 280, AdEventType.VIDEO_CACHE, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, AdEventType.VIDEO_PAUSE, 796, TypedValues.Motion.TYPE_ANIMATE_RELATIVE_TO, 540, 913, 801, 700, 799, 137, 439, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 592, 668, 353, 859, 370, 694, 325, 240, 216, 257, 284, 549, AdEventType.VIDEO_INIT, 884, 315, 70, 329, 793, 490, TUIMessageBean.MSG_STATUS_DELETE, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, 803, 712, 19, 358, 399, 908, 103, FrameMetricsAggregator.EVERY_DURATION, 51, 8, 517, 225, 289, 470, 637, 731, 66, 255, 917, 269, 463, 830, 730, 433, 848, 585, 136, 538, TypedValues.Custom.TYPE_REFERENCE, 90, 2, 290, 743, 199, 655, TypedValues.Custom.TYPE_STRING, 329, 49, 802, 580, 355, 588, 188, 462, 10, 134, 628, 320, 479, 130, 739, 71, TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NOTICE, TypedValues.Attributes.TYPE_PIVOT_TARGET, 374, 601, 192, TypedValues.Motion.TYPE_ANIMATE_RELATIVE_TO, 142, 673, 687, 234, 722, 384, 177, 752, TypedValues.Motion.TYPE_PATHMOTION_ARC, 640, 455, 193, 689, TypedValues.Transition.TYPE_TRANSITION_FLAGS, 805, 641, 48, 60, 732, 621, 895, 544, TipsMessageBean.MSG_TYPE_GROUP_KICK, 852, 655, 309, 697, 755, 756, 60, 231, 773, 434, 421, 726, 528, 503, 118, 49, 795, 32, CameraInterface.TYPE_RECORDER, 500, 238, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, TypedValues.Motion.TYPE_POLAR_RELATIVETO, 441, 180, 791, 893, 754, TypedValues.Motion.TYPE_ANIMATE_RELATIVE_TO, 383, 228, 749, 760, AdEventType.VIDEO_PRELOAD_ERROR, 54, 297, 134, 54, 834, 299, 922, 191, 910, 532, TypedValues.Motion.TYPE_POLAR_RELATIVETO, 829, 189, 20, 167, 29, 872, 449, 83, 402, 41, 656, TypedValues.Position.TYPE_SIZE_PERCENT, 579, 481, 173, 404, 251, 688, 95, 497, 555, 642, 543, 307, 159, 924, 558, 648, 55, 497, 10}, new int[]{352, 77, 373, TypedValues.Position.TYPE_PERCENT_HEIGHT, 35, 599, 428, AdEventType.VIDEO_ERROR, TTAdConstant.IMAGE_LIST_CODE, 574, 118, 498, MqttConfigImpl.DEFAULT_KEEP_ALIVE_INTERVAL, 380, 350, 492, 197, 265, 920, 155, 914, 299, 229, 643, 294, 871, 306, 88, 87, 193, 352, 781, 846, 75, 327, 520, 435, 543, AdEventType.VIDEO_RESUME, TTAdConstant.STYLE_SIZE_RADIO_2_3, 249, 346, 781, 621, 640, 268, 794, 534, 539, 781, 408, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, 383, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, AdEventType.VIDEO_PAUSE, 681, 407, 855, 85, 99, 62, 482, 180, 20, 297, 451, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, 192, 516, 258, 240, 518, 794, 395, 768, 848, 51, TypedValues.Motion.TYPE_QUANTIZE_MOTIONSTEPS, 384, 168, 190, 826, 328, 596, 786, 303, 570, 381, TTAdConstant.VIDEO_COVER_URL_CODE, 641, 156, 237, 151, 429, 531, AdEventType.VIDEO_ERROR, 676, 710, 89, 168, 304, 402, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, 358, 785, 288, 357, 850, 836, 827, 736, TypedValues.Transition.TYPE_TRANSITION_FLAGS, 94, 8, 494, 114, 521, 2, 499, 851, 543, 152, 729, NativeConstants.TLS1_2_VERSION, 95, 248, 361, 578, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, TypedValues.Custom.TYPE_COLOR, 452, 167, 342, 244, 173, 35, 463, 651, 51, 699, 591, 452, 578, 37, 124, 298, 332, 552, 43, 427, 119, 662, 777, 475, 850, 764, 364, 578, 911, 283, 711, 472, TypedValues.Cycle.TYPE_EASING, 245, 288, 594, 394, FrameMetricsAggregator.EVERY_DURATION, 327, 589, 777, 699, 688, 43, 408, 842, 383, 721, 521, 560, 644, 714, 559, 62, CameraInterface.TYPE_CAPTURE, 873, 663, 713, 159, 672, 729, 624, 59, 193, TTAdConstant.LIVE_FEED_URL_CODE, 158, AdEventType.VIDEO_INIT, 563, 564, 343, 693, 109, TypedValues.Motion.TYPE_DRAW_PATH, 563, 365, 181, NativeConstants.TLS1_3_VERSION, 677, 310, 248, 353, 708, TTAdConstant.IMAGE_LIST_SIZE_CODE, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, 618, 586, TypedValues.Cycle.TYPE_WAVE_OFFSET, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, 247, 184, 45, 787, 680, 18, 66, 407, 369, 54, 492, 228, 613, 830, 922, 437, 519, 644, TypedValues.Custom.TYPE_DIMENSION, 789, TypedValues.Cycle.TYPE_EASING, 305, 441, AdEventType.VIDEO_ERROR, 300, 892, 827, 141, 537, 381, 662, 513, 56, 252, 341, 242, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, 309, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, TypedValues.Cycle.TYPE_WAVE_PHASE, 216, 548, 249, 321, 881, 699, 535, 673, 782, AdEventType.VIDEO_READY, 815, TypedValues.Custom.TYPE_DIMENSION, 303, 843, 922, 281, 73, 469, 791, 660, 162, 498, 308, 155, TypedValues.Cycle.TYPE_CUSTOM_WAVE_SHAPE, 907, 817, 187, 62, 16, TypedValues.Cycle.TYPE_WAVE_PHASE, 535, 336, 286, 437, 375, 273, TypedValues.Motion.TYPE_QUANTIZE_MOTIONSTEPS, 296, 183, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, 357, 720, 742, 330, 5, 39, 923, 311, TypedValues.Cycle.TYPE_WAVE_OFFSET, 242, 749, 321, 54, 669, TypedValues.Attributes.TYPE_PATH_ROTATE, 342, 299, 534, 105, 667, 488, 640, 672, 576, 540, TypedValues.Attributes.TYPE_PATH_ROTATE, 486, 721, TypedValues.Motion.TYPE_QUANTIZE_MOTIONSTEPS, 46, 656, 447, 171, 616, 464, 190, 531, 297, 321, 762, 752, 533, HideBottomViewOnScrollBehavior.f2749f, 134, 14, 381, 433, 717, 45, 111, 20, 596, 284, 736, 138, 646, TTAdConstant.IMAGE_CODE, 877, 669, 141, 919, 45, 780, 407, 164, 332, 899, 165, 726, 600, 325, 498, 655, 357, 752, 768, 223, 849, 647, 63, 310, 863, 251, 366, 304, 282, 738, 675, TTAdConstant.IMAGE_LIST_SIZE_CODE, 389, 244, 31, 121, 303, TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NOTICE}};

    private e() {
    }

    public static String a(CharSequence charSequence, int i2) {
        int b = b(i2);
        char[] cArr = new char[b];
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = b - 1;
            int charAt = (charSequence.charAt(i3) + cArr[i4]) % e.j.f.v.a.a;
            while (i4 > 0) {
                cArr[i4] = (char) ((cArr[i4 - 1] + (929 - ((a[i2][i4] * charAt) % e.j.f.v.a.a))) % e.j.f.v.a.a);
                i4--;
            }
            cArr[0] = (char) ((929 - ((charAt * a[i2][0]) % e.j.f.v.a.a)) % e.j.f.v.a.a);
        }
        StringBuilder sb = new StringBuilder(b);
        for (int i5 = b - 1; i5 >= 0; i5--) {
            if (cArr[i5] != 0) {
                cArr[i5] = (char) (929 - cArr[i5]);
            }
            sb.append(cArr[i5]);
        }
        return sb.toString();
    }

    public static int b(int i2) {
        if (i2 < 0 || i2 > 8) {
            throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
        }
        return 1 << (i2 + 1);
    }

    public static int c(int i2) throws WriterException {
        if (i2 > 0) {
            if (i2 <= 40) {
                return 2;
            }
            if (i2 <= 160) {
                return 3;
            }
            if (i2 <= 320) {
                return 4;
            }
            if (i2 <= 863) {
                return 5;
            }
            throw new WriterException("No recommendation possible");
        }
        throw new IllegalArgumentException("n must be > 0");
    }
}

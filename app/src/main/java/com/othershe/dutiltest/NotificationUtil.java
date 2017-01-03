package com.othershe.dutiltest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import java.util.HashMap;
import java.util.Map;

public class NotificationUtil {

    private static Map<Integer, NotificationCompat.Builder> notificationMap = new HashMap<>();

    private static NotificationManager notificationManager;


    private static NotificationManager initNotificationManager(Context context) {
        if (notificationManager == null) {
            notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return notificationManager;
    }

    /**
     * 创建进度通知栏
     *
     * @param context
     * @param title
     * @param content
     * @param smallIcon
     * @param largeIcon
     */
    public static int createProgressNotification(Context context, String title, String content,
                                                 int smallIcon, int largeIcon) {
        initNotificationManager(context);

        NotificationCompat.Builder builder = initBaseBuilder(context, title, content, smallIcon, largeIcon);
        builder.setOngoing(true);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            Intent intent = new Intent();
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, 0);
            builder.setContentIntent(contentIntent);
        }

        int notifyId = (int) System.currentTimeMillis();

        notificationManager.notify(notifyId, builder.build());

        notificationMap.put(notifyId, builder);

        return notifyId;
    }


    /**
     * 初始化Builder
     *
     * @param context
     * @param title
     * @param content
     * @param smallIcon
     * @param largeIcon
     * @return
     */
    private static NotificationCompat.Builder initBaseBuilder(Context context, String title, String content,
                                                              int smallIcon, int largeIcon) {

        return new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(smallIcon)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), largeIcon))
                .setDefaults(Notification.DEFAULT_ALL)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis());
    }

    /**
     * 取消进度通知栏
     *
     * @param notifyId
     */
    public static void cancelNotification(int notifyId) {
        notificationManager.cancel(notifyId);
    }

    /**
     * 更新通知栏进度
     *
     * @param notifyId
     * @param progress
     */
    public static void updateNotification(int notifyId, int progress) {
        NotificationCompat.Builder builder = notificationMap.get(notifyId);
        builder.setProgress(100, progress, false);
        builder.setContentText(progress + "%");
        notificationManager.notify(notifyId, builder.build());
    }
}

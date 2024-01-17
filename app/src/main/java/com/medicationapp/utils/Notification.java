package com.medicationapp.utils;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.medicationapp.R;

import java.util.Random;

/**
 * Example usage:
 * send notification one second after initializing
 * long notificationTimeMillis = System.currentTimeMillis() + 1000;
 * Notification notification = new Notification(requireContext(), notificationTimeMillis, "test title", "take your meds");
 * notification.initialize();
 */
public class Notification {
    private final long time;
    private final String title;
    private final String description;
    private final Context context;

    /**
     * Creates a new notification
     *
     * @param context     Current context - you can just do something like ``requireContext()``
     * @param time        Unix Time Stamp - you can do something like ``System.currentTimeMillis() + 1000`` to send it after one second
     * @param title       Title of the notification
     * @param description Description of the notification
     */
    public Notification(Context context, long time, String title, String description) {
        this.context = context;
        this.time = time;
        this.title = title;
        this.description = description;
    }

    /**
     * Initializes the notification and starts it
     * logic in a different method because of conventions
     */
    public void initialize(Activity activity) {
        // intents for the notification
        Intent intent = new Intent(this.context, Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this.context, 0, intent, PendingIntent.FLAG_IMMUTABLE);


        // create notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.context, "channel_id") // DON'T TOUCH THIS STRING (yes, this is literally the id of our channel)
                .setSmallIcon(R.drawable.health)
                .setContentTitle(this.title)
                .setContentText(this.description)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        // id of the notification
        int id = new Random().nextInt(1000000) + 1;

        Intent notificationIntent = new Intent(this.context, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, id);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, builder.build());

        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(this.context, id, notificationIntent, PendingIntent.FLAG_IMMUTABLE);


        AlarmManager alarmManager = (AlarmManager) this.context.getSystemService(Context.ALARM_SERVICE);
        if (alarmManager != null)
            alarmManager.set(AlarmManager.RTC_WAKEUP, this.time, pendingIntent2);
    }
}

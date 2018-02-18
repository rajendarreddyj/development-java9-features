package com.rajendarreddyj.bank.email.notifications.impl;

import com.rajendarreddyj.bank.notifications.Notification;

/**
 * @author rajendarreddy.jagapathi
 */
public class EmailNotificationImpl implements Notification {

    /* (non-Javadoc)
     * @see com.rajendarreddyj.bank.notification.Notification#sendNotificaion(java.lang.String, java.lang.String)
     */
    @Override
    public void sendNotificaion(final String message, final String email) {
        System.out.println(String.format("Sent email notification \"%s\" to %s", message, email));
    }

}

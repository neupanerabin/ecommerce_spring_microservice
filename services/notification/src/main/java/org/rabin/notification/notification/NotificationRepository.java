package org.rabin.notification.notification;

import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * @author : rabin
 */
public interface NotificationRepository extends MongoRepository<Notification, String> {

}

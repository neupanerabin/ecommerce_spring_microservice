package org.rabin.ecommerce.notification;

import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * @author : rabin
 */
public interface NotificationRepository extends MongoRepository<Notification, String> {

}

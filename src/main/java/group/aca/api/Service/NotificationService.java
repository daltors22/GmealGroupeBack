package group.aca.api.Service;

import group.aca.api.Entity.Notification;
import group.aca.api.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Integer id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public Notification createOrUpdateNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void deleteNotification(Integer id) {
        notificationRepository.deleteById(id);
    }
}

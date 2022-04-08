package com.factorymethod;

interface Notification{
	public void notifyUser();
}
class EmailNotification implements Notification{
	@Override
	public void notifyUser() {
		System.out.println("showing Email notification");
	}
}
class SMSNotification implements Notification{
	@Override
	public void notifyUser() {
		System.out.println("showing sms notification");
	}
}
class PushNotification implements Notification{
	@Override
	public void notifyUser() {
		System.out.println("showing push notification");
	}
}

class NotificationFactory{
	public Notification createNotification(String channel) {//factory method for notification
		if(channel==null || channel.isEmpty()) {
			return null;
			}
			switch(channel) {
				case "Email":
					return new EmailNotification();
				case "SMS":
					return new SMSNotification();
				case "Push":
					return new PushNotification();
				default:
				throw new IllegalArgumentException("unknown notification channel");
			}
		}
	}

//test main method
public class FactoryMethodDemo {

	public static void main(String[] args) {
		
		Notification emailNotificationObj = new EmailNotification();//tight coupling:classes are dependent 
		Notification smsNotificationObj = new SMSNotification();
		Notification pushNotificationObj = new PushNotification();
		emailNotificationObj.notifyUser();
		smsNotificationObj.notifyUser();
		pushNotificationObj.notifyUser();
		System.out.println();
		
		System.out.println("loose coupling");//loose coupling no need of the client to create an obj
		
		NotificationFactory factory = new NotificationFactory();
		Notification notification = factory.createNotification("Email");
		notification.notifyUser();
	}

}

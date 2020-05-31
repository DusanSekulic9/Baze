package observer;

import model.Entity;
import model.InformationResource;

public class Notification {
	
	private NotificationCode code;
    private Object data;
	
	public Notification(NotificationCode resourceLoaded, InformationResource ir) {
		code = resourceLoaded;
		data = ir;
	}

	
	public Notification(NotificationCode show, Entity entity) {
		code = show;
		data = entity;
	}

	public NotificationCode getCode() {
		return code;
	}

	public void setCode(NotificationCode code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}

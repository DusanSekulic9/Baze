package model;

import java.util.ArrayList;

import nodes.DBNode;
import nodes.DBNodeComposite;
import observer.Publisher;
import observer.Subscriber;

public class Entity extends DBNodeComposite implements Publisher{
	
	private ArrayList<Subscriber> subscribers = new ArrayList<Subscriber>();

	public Entity(String name, DBNode parent) {
		super(name, parent);
	}

	@Override
	public void addSubscriber(Subscriber subscriber) {
		if(subscriber == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(subscriber))
            return;
        this.subscribers.add(subscriber);
	}

	@Override
	public void removeSubscriber(Subscriber subscriber) {
		 if(subscriber == null || this.subscribers == null || !this.subscribers.contains(subscriber))
	            return;
	        this.subscribers.remove(subscriber);
	}

	@Override
	public void notifySubscribers(Object notification) {
		 if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
	            return;

	        for(Subscriber listener : subscribers){
	            listener.update(notification);
	        }
	}

}

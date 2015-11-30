package org.lunifera.christmastree.control;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.vaadin.event.MouseEvents;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;

public abstract class AbstractControllerComponent extends CustomComponent implements MqttCallback {

	protected AbsoluteLayout mainLayout;
	protected GridLayout contentLayout;
	protected CommandDelegate delegate;
	protected MouseEvents.ClickListener listener = new Listener();

	protected Embedded button_smooth;
	protected Embedded button_lightpurple;
	protected Embedded button_darkcyan;
	protected Embedded button_yellow;
	protected Embedded button_fade;
	protected Embedded button_purple;
	protected Embedded button_cyan;
	protected Embedded button_lightorange;
	protected Embedded button_strobe;
	protected Embedded button_darkpurple;
	protected Embedded button_lightcyan;
	protected Embedded button_orange;
	protected Embedded button_flash;
	protected Embedded button_lightblue;
	protected Embedded button_lightgreen;
	protected Embedded button_darkorange;
	protected Embedded button_white;
	protected Embedded button_blue;
	protected Embedded button_green;
	protected Embedded button_red;
	protected Embedded button_on;
	protected Embedded button_off;
	protected Embedded button_darker;
	protected Embedded button_brighter;
	protected Embedded button_star;
	protected Embedded button_snow;
	protected Embedded button_angel;

	public AbstractControllerComponent() {
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// nothing to do
	}

	@Override
	public void connectionLost(Throwable arg0) {
		// nothing to do
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// nothing to do
	}

	protected abstract AbsoluteLayout buildMainLayout();

	public interface CommandDelegate {
		public static final int SMOOTH = 24;
		public static final int FADE = 23;
		public static final int FLASH = 21;
		public static final int LIGHTPURPLE = 19;
		public static final int PURPLE = 18;
		public static final int DARKPURPLE = 17;
		public static final int LIGHTBLUE = 16;
		public static final int LIGHTCYAN = 12;
		public static final int CYAN = 13;
		public static final int DARKCYAN = 14;
		public static final int LIGHTGREEN = 11;
		public static final int YELLOW = 9;
		public static final int LIGHTORANGE = 8;
		public static final int ORANGE = 7;
		public static final int DARKORANGE = 6;
		public static final int WHITE = 20;
		public static final int BLUE = 15;
		public static final int GREEN = 10;
		public static final int RED = 5;
		public static final int DARKER = 2;
		public static final int BRIGHTER = 1;
		public static final int ON = 4;
		public static final int OFF = 3;
		public static final int STROBE = 22;
		public static final int STAR = 25;
		public static final int ANGEL = 26;
		public static final int SNOWING = 27;

		void execute(int command);

		void register(MqttCallback callback, String topic);

	}

	public class Listener implements MouseEvents.ClickListener {
		@Override
		public void click(com.vaadin.event.MouseEvents.ClickEvent event) {
			Embedded button = (Embedded) event.getSource();
			if (button == button_on) {
				delegate.execute(CommandDelegate.ON);
			} else if (button == button_off) {
				delegate.execute(CommandDelegate.OFF);
			} else if (button == button_brighter) {
				delegate.execute(CommandDelegate.BRIGHTER);
			} else if (button == button_darker) {
				delegate.execute(CommandDelegate.DARKER);
			} else if (button == button_red) {
				delegate.execute(CommandDelegate.RED);
			} else if (button == button_green) {
				delegate.execute(CommandDelegate.GREEN);
			} else if (button == button_blue) {
				delegate.execute(CommandDelegate.BLUE);
			} else if (button == button_white) {
				delegate.execute(CommandDelegate.WHITE);
			} else if (button == button_darkorange) {
				delegate.execute(CommandDelegate.DARKORANGE);
			} else if (button == button_orange) {
				delegate.execute(CommandDelegate.ORANGE);
			} else if (button == button_lightorange) {
				delegate.execute(CommandDelegate.LIGHTORANGE);
			} else if (button == button_yellow) {
				delegate.execute(CommandDelegate.YELLOW);
			} else if (button == button_lightgreen) {
				delegate.execute(CommandDelegate.LIGHTGREEN);
			} else if (button == button_darkcyan) {
				delegate.execute(CommandDelegate.DARKCYAN);
			} else if (button == button_cyan) {
				delegate.execute(CommandDelegate.CYAN);
			} else if (button == button_lightcyan) {
				delegate.execute(CommandDelegate.LIGHTCYAN);
			} else if (button == button_lightblue) {
				delegate.execute(CommandDelegate.LIGHTBLUE);
			} else if (button == button_darkpurple) {
				delegate.execute(CommandDelegate.DARKPURPLE);
			} else if (button == button_purple) {
				delegate.execute(CommandDelegate.PURPLE);
			} else if (button == button_lightpurple) {
				delegate.execute(CommandDelegate.LIGHTPURPLE);
			} else if (button == button_flash) {
				delegate.execute(CommandDelegate.FLASH);
			} else if (button == button_strobe) {
				delegate.execute(CommandDelegate.STROBE);
			} else if (button == button_fade) {
				delegate.execute(CommandDelegate.FADE);
			} else if (button == button_smooth) {
				delegate.execute(CommandDelegate.SMOOTH);
			} else if (button == button_angel) {
				delegate.execute(CommandDelegate.ANGEL);
			} else if (button == button_star) {
				delegate.execute(CommandDelegate.STAR);
			} else if (button == button_snow) {
				delegate.execute(CommandDelegate.SNOWING);
			}
		}
	}

}
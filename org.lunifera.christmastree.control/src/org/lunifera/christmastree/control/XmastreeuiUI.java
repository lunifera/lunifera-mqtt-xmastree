package org.lunifera.christmastree.control;

import javax.servlet.annotation.WebServlet;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.WebBrowser;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("christmastree")
@Push
public class XmastreeuiUI extends UI implements DesktopControlComponent.CommandDelegate {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = XmastreeuiUI.class, widgetset = "org.lunifera.christmastree.control.widgetset.Org_lunifera_christmastree_controlWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	public MqttClient client = null;

	@Override
	protected void init(VaadinRequest request) {

		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSizeFull();
		setContent(layout);

		WebBrowser browser = getPage().getWebBrowser();
		AbstractControllerComponent ui = null;
		if (browser.isAndroid() || browser.isIOS() || browser.isWindowsPhone()) {
			ui = new MobileControlComponent(this);
		} else {
			ui = new DesktopControlComponent(this);
		}

		ui.setSizeFull();
		layout.addComponent(ui);

		layout.setExpandRatio(ui, 1.0f);

		try {
			client = new MqttClient("tcp://lun.lunifera.org:1883", MqttClient.generateClientId());
			client.connect();
			client.setCallback(ui);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void execute(int command) {

		MqttMessage msg = new MqttMessage();
		msg.setPayload(String.format("button:%s", String.valueOf(command)).getBytes());

		try {
			client.publish("xmastree_command", msg);
		} catch (MqttPersistenceException e) {
			e.printStackTrace();
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void register(MqttCallback callback, String topic) {
		// do nothing
	}
}
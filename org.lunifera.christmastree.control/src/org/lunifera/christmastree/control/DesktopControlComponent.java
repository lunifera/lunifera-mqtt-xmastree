package org.lunifera.christmastree.control;

import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class DesktopControlComponent extends AbstractControllerComponent {

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public DesktopControlComponent(CommandDelegate delegate) {
		super();
		this.delegate = delegate;
		buildMainLayout();
		setCompositionRoot(mainLayout);
	}

	protected AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");

		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");

		// title area
		ThemeResource resource = new ThemeResource("images/Title.png");
		Image title = new Image(" ", resource);
		title.setHeight("108px");
		title.setWidth("827px");
		mainLayout.addComponent(title, "top:22.0px;left:120.0px");

		VerticalLayout vl = new VerticalLayout();
		vl.setHeight("500px");
		vl.setWidth("400px");
		vl.setSpacing(true);
		mainLayout.addComponent(vl, "top:140.0px;left:100.0px;");

		contentLayout = buildContent();
		vl.addComponent(contentLayout);
		vl.setExpandRatio(contentLayout, 1.0f);

		// licenses
		PopupView licenseLink = new PopupView("Attributions",
				new Label("<div><i>Monitor/tablet/smartphone</i> and <i>tree</i> icons </br> made by "
						+ "<a href=\"http://www.freepik.com\" title=\"Freepik\">Freepik</a> "
						+ "from <a href=\"http://www.flaticon.com\" title=\"Flaticon\">www.flaticon.com</a> </br>"
						+ "is licensed under <a href=\"http://creativecommons.org/licenses/by/3.0/\" "
						+ "title=\"Creative Commons BY 3.0\">CC BY 3.0</a></div>", ContentMode.HTML));
		licenseLink.setPrimaryStyleName("attributions");
		vl.addComponent(licenseLink);

		Label image = new Label();
		image.setHeight("400px");
		image.setWidth("100%");
		// image.setValue("<div style=\"overflow:hidden; width: 400px;
		// margin-left: -60px;\">"
		// + "<img src=\"http://77.119.240.22:8081\"/>" + "</div>");
		image.setValue("<div style=\"overflow:hidden; width: 370px; margin-left: -60px;\">"
				+ "<img src=\"http://192.168.0.108:8081\"/>" + "</div>");
		image.setContentMode(ContentMode.HTML);
		mainLayout.addComponent(image, "top:140.0px;left:600.0px;");

		return mainLayout;
	}

	@SuppressWarnings("deprecation")
	protected GridLayout buildContent() {
		// common part: create layout
		contentLayout = new GridLayout();
		contentLayout.setImmediate(false);
		contentLayout.setMargin(false);
		contentLayout.setColumns(4);
		contentLayout.setRows(7);

		// button_bighter
		button_brighter = new Embedded(null, new ThemeResource("./images/brighter.png"));
		button_brighter.setCaption("Brighter");
		button_brighter.setImmediate(true);
		button_brighter.setWidth("-1px");
		button_brighter.setHeight("-1px");
		button_brighter.addClickListener(listener);
		button_brighter.setStyleName("xmas-button-brighter");
		contentLayout.addComponent(button_brighter, 0, 0);
		contentLayout.setComponentAlignment(button_brighter, new Alignment(48));

		// button_darker
		button_darker = new Embedded(null, new ThemeResource("./images/darker.png"));
		button_darker.setCaption("Darker");
		button_darker.setImmediate(true);
		button_darker.setWidth("-1px");
		button_darker.setHeight("-1px");
		button_darker.addClickListener(listener);
		button_darker.setStyleName("xmas-button-darker");
		contentLayout.addComponent(button_darker, 1, 0);
		contentLayout.setComponentAlignment(button_darker, new Alignment(48));

		// button_off
		button_off = new Embedded(null, new ThemeResource("./images/off.png"));
		button_off.setCaption("Off");
		button_off.setImmediate(true);
		button_off.setWidth("-1px");
		button_off.setHeight("-1px");
		button_off.addClickListener(listener);
		button_off.setStyleName("xmas-button-off");
		contentLayout.addComponent(button_off, 2, 0);
		contentLayout.setComponentAlignment(button_off, new Alignment(48));

		// button_on
		button_on = new Embedded(null, new ThemeResource("./images/on.png"));
		button_on.setCaption("On");
		button_on.setImmediate(true);
		button_on.setWidth("-1px");
		button_on.setHeight("-1px");
		button_on.addListener(listener);
		button_on.setStyleName("xmas-button-on");
		contentLayout.addComponent(button_on, 3, 0);
		contentLayout.setComponentAlignment(button_on, new Alignment(48));

		// button_red
		button_red = new Embedded(null, new ThemeResource("./images/red.png"));
		button_red.setCaption("red");
		button_red.setImmediate(true);
		button_red.setWidth("-1px");
		button_red.setHeight("-1px");
		button_red.addListener(listener);
		button_red.setStyleName("xmas-button-red");
		contentLayout.addComponent(button_red, 0, 1);
		contentLayout.setComponentAlignment(button_red, new Alignment(48));

		// button_green
		button_green = new Embedded(null, new ThemeResource("./images/green.png"));
		button_green.setCaption("green");
		button_green.setImmediate(true);
		button_green.setWidth("-1px");
		button_green.setHeight("-1px");
		button_green.setStyleName("xmas-button-green");
		button_green.addListener(listener);
		contentLayout.addComponent(button_green, 1, 1);
		contentLayout.setComponentAlignment(button_green, new Alignment(48));

		// button_blue
		button_blue = new Embedded(null, new ThemeResource("./images/blue.png"));
		button_blue.setCaption("blue");
		button_blue.setImmediate(true);
		button_blue.setWidth("-1px");
		button_blue.setHeight("-1px");
		button_blue.setStyleName("xmas-button-blue");
		button_blue.addListener(listener);
		contentLayout.addComponent(button_blue, 2, 1);
		contentLayout.setComponentAlignment(button_blue, new Alignment(48));

		// button_white
		button_white = new Embedded(null, new ThemeResource("./images/white.png"));
		button_white.setCaption("white");
		button_white.setImmediate(true);
		button_white.setWidth("-1px");
		button_white.setHeight("-1px");
		button_white.addListener(listener);
		button_white.setStyleName("xmas-button-white");
		contentLayout.addComponent(button_white, 3, 1);
		contentLayout.setComponentAlignment(button_white, new Alignment(48));

		// button_darkorange
		button_darkorange = new Embedded(null, new ThemeResource("./images/darkorange.png"));
		button_darkorange.setCaption("dark orange");
		button_darkorange.setImmediate(true);
		button_darkorange.setWidth("-1px");
		button_darkorange.setHeight("-1px");
		button_darkorange.addListener(listener);
		button_darkorange.setStyleName("xmas-button-darkorange");
		contentLayout.addComponent(button_darkorange, 0, 2);
		contentLayout.setComponentAlignment(button_darkorange, new Alignment(48));

		// button_lightgreen
		button_lightgreen = new Embedded(null, new ThemeResource("./images/lightgreen.png"));
		button_lightgreen.setCaption("light green");
		button_lightgreen.setImmediate(true);
		button_lightgreen.setWidth("-1px");
		button_lightgreen.setHeight("-1px");
		button_lightgreen.addListener(listener);
		button_lightgreen.setStyleName("xmas-button-lightgreen");
		contentLayout.addComponent(button_lightgreen, 1, 2);
		contentLayout.setComponentAlignment(button_lightgreen, new Alignment(48));

		// button_lightblue
		button_lightblue = new Embedded(null, new ThemeResource("./images/lightblue.png"));
		button_lightblue.setCaption("light blue");
		button_lightblue.setImmediate(true);
		button_lightblue.setWidth("-1px");
		button_lightblue.setHeight("-1px");
		button_lightblue.addListener(listener);
		button_lightblue.setStyleName("xmas-button-lightblue");
		contentLayout.addComponent(button_lightblue, 2, 2);
		contentLayout.setComponentAlignment(button_lightblue, new Alignment(48));

		// button_flash
		button_flash = new Embedded(null, new ThemeResource("./images/flash.png"));
		button_flash.setCaption("Flash");
		button_flash.setImmediate(true);
		button_flash.setWidth("-1px");
		button_flash.setHeight("-1px");
		button_flash.addListener(listener);
		button_flash.setStyleName("xmas-button-flash");
		contentLayout.addComponent(button_flash, 3, 2);
		contentLayout.setComponentAlignment(button_flash, new Alignment(48));

		// button_orange
		button_orange = new Embedded(null, new ThemeResource("./images/orange.png"));
		button_orange.setCaption("orange");
		button_orange.setImmediate(true);
		button_orange.setWidth("-1px");
		button_orange.setHeight("-1px");
		button_orange.addListener(listener);
		button_orange.setStyleName("xmas-button-orange");
		contentLayout.addComponent(button_orange, 0, 3);
		contentLayout.setComponentAlignment(button_orange, new Alignment(48));

		// button_lightcyan
		button_lightcyan = new Embedded(null, new ThemeResource("./images/lightcyan.png"));
		button_lightcyan.setCaption("ligth cyan");
		button_lightcyan.setImmediate(true);
		button_lightcyan.setWidth("-1px");
		button_lightcyan.setHeight("-1px");
		button_lightcyan.addListener(listener);
		button_lightcyan.setStyleName("xmas-button-lightcyan");
		contentLayout.addComponent(button_lightcyan, 1, 3);
		contentLayout.setComponentAlignment(button_lightcyan, new Alignment(48));

		// button_darkpurple
		button_darkpurple = new Embedded(null, new ThemeResource("./images/darkpurple.png"));
		button_darkpurple.setCaption("dark purple");
		button_darkpurple.setImmediate(true);
		button_darkpurple.setWidth("-1px");
		button_darkpurple.setHeight("-1px");
		button_darkpurple.addListener(listener);
		button_darkpurple.setStyleName("xmas-button-darkpurple");
		contentLayout.addComponent(button_darkpurple, 2, 3);
		contentLayout.setComponentAlignment(button_darkpurple, new Alignment(48));

		// button_strobe
		button_strobe = new Embedded(null, new ThemeResource("./images/strobe.png"));
		button_strobe.setCaption("Strobo");
		button_strobe.setImmediate(true);
		button_strobe.setWidth("-1px");
		button_strobe.setHeight("-1px");
		button_strobe.addListener(listener);
		button_strobe.setStyleName("xmas-button-strobe");
		contentLayout.addComponent(button_strobe, 3, 3);
		contentLayout.setComponentAlignment(button_strobe, new Alignment(48));

		// button_lightorange
		button_lightorange = new Embedded(null, new ThemeResource("./images/lightorange.png"));
		button_lightorange.setCaption("light orange");
		button_lightorange.setImmediate(true);
		button_lightorange.setWidth("-1px");
		button_lightorange.setHeight("-1px");
		button_lightorange.addListener(listener);
		button_lightorange.setStyleName("xmas-button-lightorange");
		contentLayout.addComponent(button_lightorange, 0, 4);
		contentLayout.setComponentAlignment(button_lightorange, new Alignment(48));

		// button_cyan
		button_cyan = new Embedded(null, new ThemeResource("./images/cyan.png"));
		button_cyan.setCaption("cyan");
		button_cyan.setImmediate(false);
		button_cyan.setWidth("-1px");
		button_cyan.setHeight("-1px");
		button_cyan.addListener(listener);
		button_cyan.setStyleName("xmas-button-cyan");
		contentLayout.addComponent(button_cyan, 1, 4);
		contentLayout.setComponentAlignment(button_cyan, new Alignment(48));

		// button_purple
		button_purple = new Embedded(null, new ThemeResource("./images/purple.png"));
		button_purple.setCaption("purple");
		button_purple.setImmediate(true);
		button_purple.setWidth("-1px");
		button_purple.setHeight("-1px");
		button_purple.addListener(listener);
		button_purple.setStyleName("xmas-button-purple");
		contentLayout.addComponent(button_purple, 2, 4);
		contentLayout.setComponentAlignment(button_purple, new Alignment(48));

		// button_fade
		button_fade = new Embedded(null, new ThemeResource("./images/fade.png"));
		button_fade.setCaption("Fade");
		button_fade.setImmediate(true);
		button_fade.setWidth("-1px");
		button_fade.setHeight("-1px");
		button_fade.addListener(listener);
		button_fade.setStyleName("xmas-button-fade");
		contentLayout.addComponent(button_fade, 3, 4);
		contentLayout.setComponentAlignment(button_fade, new Alignment(48));

		// button_yellow
		button_yellow = new Embedded(null, new ThemeResource("./images/yellow.png"));
		button_yellow.setCaption("yellow");
		button_yellow.setImmediate(true);
		button_yellow.setWidth("-1px");
		button_yellow.setHeight("-1px");
		button_yellow.addListener(listener);
		button_yellow.setStyleName("xmas-button-yellow");
		contentLayout.addComponent(button_yellow, 0, 5);
		contentLayout.setComponentAlignment(button_yellow, new Alignment(48));

		// button_darkcyan
		button_darkcyan = new Embedded(null, new ThemeResource("./images/darkcyan.png"));
		button_darkcyan.setCaption("dark cyan");
		button_darkcyan.setImmediate(true);
		button_darkcyan.setWidth("-1px");
		button_darkcyan.setHeight("-1px");
		button_darkcyan.addListener(listener);
		button_darkcyan.setStyleName("xmas-button-darkcyan");
		contentLayout.addComponent(button_darkcyan, 1, 5);
		contentLayout.setComponentAlignment(button_darkcyan, new Alignment(48));

		// button_lightpurple
		button_lightpurple = new Embedded(null, new ThemeResource("./images/lightpurple.png"));
		button_lightpurple.setCaption("light purple");
		button_lightpurple.setImmediate(true);
		button_lightpurple.setWidth("-1px");
		button_lightpurple.setHeight("-1px");
		button_lightpurple.addListener(listener);
		button_lightpurple.setStyleName("xmas-button-lightpurple");
		contentLayout.addComponent(button_lightpurple, 2, 5);
		contentLayout.setComponentAlignment(button_lightpurple, new Alignment(48));

		// button_smooth
		button_smooth = new Embedded(null, new ThemeResource("./images/smooth.png"));
		button_smooth.setCaption("Smooth");
		button_smooth.setImmediate(true);
		button_smooth.setWidth("-1px");
		button_smooth.setHeight("-1px");
		button_smooth.addListener(listener);
		button_smooth.setStyleName("xmas-button-smooth");
		contentLayout.addComponent(button_smooth, 3, 5);
		contentLayout.setComponentAlignment(button_smooth, new Alignment(48));

		// button_snow
		button_snow = new Embedded(null, new ThemeResource("./images/snowflake.png"));
		button_snow.setCaption("Let it snow");
		button_snow.setImmediate(true);
		button_snow.setWidth("-1px");
		button_snow.setHeight("-1px");
		button_snow.addListener(listener);
		button_snow.setStyleName("xmas-button-snow");
		contentLayout.addComponent(button_snow, 0, 6);
		contentLayout.setComponentAlignment(button_snow, new Alignment(48));

		// button_star
		button_star = new Embedded(null, new ThemeResource("./images/star.png"));
		button_star.setCaption("Star");
		button_star.setImmediate(true);
		button_star.setWidth("-1px");
		button_star.setHeight("-1px");
		button_star.addListener(listener);
		button_star.setStyleName("xmas-button-star");
		contentLayout.addComponent(button_star, 1, 6);
		contentLayout.setComponentAlignment(button_star, new Alignment(48));

		// button_angel
		button_angel = new Embedded(null, new ThemeResource("./images/angel.png"));
		button_angel.setCaption("Angel");
		button_angel.setImmediate(true);
		button_angel.setWidth("-1px");
		button_angel.setHeight("-1px");
		button_angel.addListener(listener);
		button_angel.setStyleName("xmas-button-angel");
		contentLayout.addComponent(button_angel, 3, 6);
		contentLayout.setComponentAlignment(button_angel, new Alignment(48));

		return contentLayout;
	}

}

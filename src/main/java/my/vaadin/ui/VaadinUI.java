package my.vaadin.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;

import my.vaadin.ui.navigation.NavigationManager;

@Theme("apptheme")
@SpringUI
@Title("Watch Manager 0.1")
public class VaadinUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final NavigationManager navigationManager;

	private final MainView mainView;
	
	@Autowired
	public VaadinUI(SpringViewProvider viewProvider, NavigationManager navigationManager, MainView mainView) {
		this.navigationManager = navigationManager;
		this.mainView = mainView;
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		
		setContent(mainView);

		navigationManager.navigateToDefaultView();
	}

}

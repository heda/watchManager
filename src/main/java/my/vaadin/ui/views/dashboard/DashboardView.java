package my.vaadin.ui.views.dashboard;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;

import my.vaadin.ui.navigation.NavigationManager;

@SpringView
public class DashboardView extends DashboardViewDesign implements View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final NavigationManager navigationManager;
	
	@Autowired
	public DashboardView(NavigationManager navigationManager) {
		this.navigationManager = navigationManager;
	}
	
	@PostConstruct
	public void init() {
		setResponsive(true);
	}

}

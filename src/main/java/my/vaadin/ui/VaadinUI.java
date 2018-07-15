package my.vaadin.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import my.vaadin.backend.WatchRepository;
import my.vaadin.backend.data.entity.Watch;

@SpringUI
public class VaadinUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final WatchRepository watchRepo;
	
	private final Grid<Watch> watchGrid;
	
	private final Button addNewBtn;
	
	private final Label headerLabel;
	
	private final Label headerComment;
	
	@SuppressWarnings("deprecation")
	@Autowired
	public VaadinUI(WatchRepository watchRepo) {
		this.watchRepo = watchRepo;
		this.watchGrid = new Grid<>(Watch.class);
		this.addNewBtn = new Button("New Watch", FontAwesome.PLUS);
		this.headerLabel = new Label("The Ultimate Watch Manager 0.1");
		this.headerComment = new Label("for Vaadin 8");
	}

	@Override
	protected void init(VaadinRequest request) {
		// Set the root layout for the UI
		VerticalLayout root = new VerticalLayout();
		setContent(root);
		
		// Title bar
		HorizontalLayout titleBar = new HorizontalLayout();
		titleBar.setWidth("100%");
		root.addComponent(titleBar);
		
		titleBar.addComponent(headerLabel);
		titleBar.setExpandRatio(headerLabel, 1.0f);
		
		headerComment.setSizeUndefined(); // Take minimum space
		titleBar.addComponent(headerComment);
		
		VerticalLayout content = new VerticalLayout(addNewBtn, watchGrid);
		watchGrid.setSizeFull();
		root.addComponent(content);
		
		// Configure grid
		watchGrid.setHeight(300, Unit.PIXELS);
		watchGrid.setColumns("model", "reference");
		
		// Get watches from watchRepo
		listWatches(null);
	}
	
	void listWatches(String filterText) {
		if (StringUtils.isEmpty(filterText)) {
			watchGrid.setItems(watchRepo.findAll());
		}
		else {
			watchGrid.setItems(watchRepo.findByModelStartsWithIgnoreCase(filterText));
		}
	}

}

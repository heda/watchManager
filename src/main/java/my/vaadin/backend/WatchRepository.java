package my.vaadin.backend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import my.vaadin.backend.data.entity.Watch;

public interface WatchRepository extends JpaRepository<Watch, Long> {
	
	List<Watch> findByModelStartsWithIgnoreCase(String model);
	
	List<Watch> findByReferenceStartsWithIgnoreCase(String reference);

}

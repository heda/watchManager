package my.vaadin.watchManager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchRepository extends JpaRepository<Watch, Long> {
	
	List<Watch> findByModelStartsWithIgnoreCase(String model);
	
	List<Watch> findByReferenceStartsWithIgnoreCase(String reference);

}

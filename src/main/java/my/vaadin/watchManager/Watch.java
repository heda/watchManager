package my.vaadin.watchManager;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "watch")
public class Watch implements Serializable {
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "reference")
	private String reference;
	
	protected Watch() {
		
	}
	
	public Watch(String model, String reference) {
		this.model = model;
		this.reference = reference;
	}
	
	@Override
	public String toString() {
		return String.format("Watch[id=%d, model='%s', reference='%s']", id, model, reference);
	}
}

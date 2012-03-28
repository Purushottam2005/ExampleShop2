package classes;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Artikelgruppe implements java.io.Serializable{
	@Id
	@GeneratedValue
	private int id;
	private String bezeichnung;
	private String info;
	@OneToMany(mappedBy="artikelgruppe", cascade={CascadeType.ALL})
	private Set<Artikel> artikel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Set<Artikel> getArtikel() {
		return artikel;
	}
	public void setArtikel(Set<Artikel> artikel) {
		this.artikel = artikel;
	}
}

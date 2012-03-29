package classes;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import classes.Artikel;
/**
 * 
 * @author andreas monschau
 * 
 * entity class artikelgruppe is pojo except for function artikelhinzu which is used for safe saving of artikel and artikelgruppen 
 *
 */


@SuppressWarnings("serial")
@Entity(name="Artikelgruppe")
public class Artikelgruppe implements java.io.Serializable{

	@Id
	@GeneratedValue
	private int id;
	private String bezeichnung;
	private String info;
	@OneToMany(cascade={CascadeType.ALL})
	@JoinTable(name="ARTIKEL_ARTIKELGRUPPE")
	private List<Artikel> artikel;
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
	public List<Artikel> getArtikel() {
		return artikel;
	}
	public void setArtikel(List<Artikel> artikel) {
		this.artikel = artikel;
	}
	
	public void artikelhinzu(Artikel art){
		if(artikel == null){
			artikel = new ArrayList<Artikel>();
		}
		artikel.add(art);
	}
}

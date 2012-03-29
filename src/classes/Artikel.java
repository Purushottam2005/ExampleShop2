package classes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import classes.Artikelgruppe;


/**
 * 
 * @author andreas
 * 
 * entity-class Artikel is pojo. connected onetomany with artikelgruppe
 *
 */
@SuppressWarnings("serial")
@Entity(name="Artikel")
public class Artikel  implements java.io.Serializable{
	@Id
	@GeneratedValue
	private int id;
	private String bezeichnung;
	private String info;
	private double vk_brutto;
	private String img_url;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(length = 1024)
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	@Column(length = 2048)
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public double getVk_brutto() {
		return vk_brutto;
	}
	public void setVk_brutto(double vk_brutto) {
		this.vk_brutto = vk_brutto;
	}
	@Column(length = 1024)
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	
}

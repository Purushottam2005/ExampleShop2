package classes;

import interfaces.Warenkorb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

/**
 * 
 * @author andreas monschau
 * 
 * Non-Entity class Warenkorb. It´s stored in the user-session. 
 *
 */
@Stateful(name="WarenkorbImpl")
public class WarenkorbImpl implements Warenkorb{
	private Kunde kunde;
	private List<Artikel> artikel = new ArrayList<Artikel>();
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public List<Artikel> getArtikel(){
		return this.artikel;
	}
	@Override
	public void artikelhinzu(Artikel art) {
		if(artikel == null){
			artikel = new ArrayList<Artikel>();
		}
		artikel.add(art);		
	}

}

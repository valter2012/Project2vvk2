package example.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AdminUnit {

	   @Id
	   @GeneratedValue // võib panna ka täpsemalt kuidas (strategy = GenerationType.AUTO)
	   @Column(name = "riigi_admin_yksus_ID") // nime asendus
	   private Long id;
	   
	   @Column(length = 32, nullable = false)
	   private String avaja;
	   
	   @Temporal(TemporalType.DATE)
	   private Date	 avatud;
	   
	   @Column(length = 32, nullable = true)
	   private String muutja;
	   
	   @Temporal(TemporalType.DATE)
	   private Date	 muudetud;
	   
	   @Column(length = 32, nullable = true)
	   private String sulgeja;
	   
	   @Temporal(TemporalType.DATE)
	   private Date	 suletud;
	   
	   @Column(length = 10, nullable = false)
	   private String kood;
	   
	   @Column(length = 100, nullable = false)
	   private String nimetus;
	   
	   @Column(length = 3200, nullable = false)
	   private String kommentaar;
	   
	   @Temporal(TemporalType.DATE)
	   @Column(nullable = false)
	   private Date	 alates;
	   
	   @Temporal(TemporalType.DATE)
	   @Column(nullable = false)
	   private Date	 kuni;
	   
	   @Column(name = "riigi_admin_yksuse_lik_id") // nime asendus
	   private Long type_id;
	   
	    @Override
	    public String toString() {
	        return "[nimetus=" + nimetus + ", kood=" + kood + "]";
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAvaja() {
		return avaja;
	}

	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}

	public Date getAvatud() {
		return avatud;
	}

	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}

	public String getMuutja() {
		return muutja;
	}

	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}

	public Date getMuudetud() {
		return muudetud;
	}

	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}

	public String getSulgeja() {
		return sulgeja;
	}

	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}

	public Date getSuletud() {
		return suletud;
	}

	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}

	public String getKood() {
		return kood;
	}

	public void setKood(String kood) {
		this.kood = kood;
	}

	public String getNimetus() {
		return nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}

	public String getKommentaar() {
		return kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public Date getAlates() {
		return alates;
	}

	public void setAlates(Date alates) {
		this.alates = alates;
	}

	public Date getKuni() {
		return kuni;
	}

	public void setKuni(Date kuni) {
		this.kuni = kuni;
	}

	public Long getType_id() {
		return type_id;
	}

	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}
	   


}

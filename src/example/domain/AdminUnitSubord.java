package example.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class AdminUnitSubord {
	   @Id
	   @GeneratedValue 
	   @Column(name = "admin_alluvus_id") 
	   private Long id;
	   
	   @Column(name = "ylemus_yksus_ID", nullable = false)
	   private Long head_id;
	   
	   @Column(name = "alluv_yksus_ID", nullable = false)
	   private Long sub_id;
	   
	public AdminUnitSubord() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHead_id() {
		return head_id;
	}

	public void setHead_id(Long head_id) {
		this.head_id = head_id;
	}

	public Long getSub_id() {
		return sub_id;
	}

	public void setSub_id(Long sub_id) {
		this.sub_id = sub_id;
	}
}
//ADMIN_ALLUVUS (
//	       admin_alluvus_id     INTEGER,
//	       avaja                VARCHAR(32) NOT NULL,
//	       avatud               DATE NOT NULL,
//	       muutja               VARCHAR(32) NOT NULL,
//	       muudetud             DATE NOT NULL,
//	       sulgeja              VARCHAR(32),
//	       suletud              DATE NOT NULL,
//	       alates               CHAR(18),
//	       kuni                 CHAR(18),
//	       kommentaar           CHAR(18),
//	       ylemus_yksus_ID      INTEGER NOT NULL,
//	       alluv_yksus_ID       INTEGER NOT NULL,
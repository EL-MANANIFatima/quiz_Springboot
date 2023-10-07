package com.example.platform_quiz.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String password;
    private String nom;
    private String adresse;
    private String phone;
    

    public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public List<Reponce> getReponces() {
		return reponces;
	}


	public void setReponces(List<Reponce> reponces) {
		this.reponces = reponces;
	}


	public List<Resultat> getResultats() {
		return resultats;
	}


	public void setResultats(List<Resultat> resultats) {
		this.resultats = resultats;
	}


	public User(Integer id, String email, String password, String nom, String adresse, String phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.adresse = adresse;
        this.phone = phone;
    }
	

    public User() {
		super();
	}


	

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reponce> reponces;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Resultat> resultats;


}


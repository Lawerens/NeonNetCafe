package com.nncklient.neonnetcafe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name="klient")
public class Klient {

    @Id
    @Column(name="id")
    private int id;

    @NotBlank(message="Imię jest wymagane")
    @Column(name="imie")
    private String imie;

    @NotBlank(message="Imię jest wymagane")

    @Column(name="nazwisko")
    private String nazwisko;

    @NotBlank(message="Imię jest wymagane")
    @Column(name="telefon")
    private String telefon;

    @NotBlank(message="Imię jest wymagane")
    @Column(name="rezerwacja")
    private String rezerwacja;

    public Klient() {

    }

    @Override
    public String toString() {
        return "Klient{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon='" + telefon + '\'' +
                ", rezerwacja='" + rezerwacja + '\'' +
                '}';
    }

    public Klient(int id, String imie, String nazwisko, String telefon, String rezerwacja) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.rezerwacja = rezerwacja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getRezerwacja() {
        return rezerwacja;
    }

    public void setRezerwacja(String rezerwacja) {
        this.rezerwacja = rezerwacja;
    }
}

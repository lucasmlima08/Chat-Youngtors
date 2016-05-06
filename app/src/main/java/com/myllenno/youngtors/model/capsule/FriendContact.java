package com.myllenno.youngtors.model.capsule;

public class FriendContact {

    private String name;
    private String email;
    private String description;
    private String birth;
    private String genre;
    private String city;
    private String profession;
    private String company;
    private String phone;
    private String website;

    public FriendContact(String name,
                         String email,
                         String description,
                         String birth,
                         String genre,
                         String city,
                         String profession,
                         String company,
                         String phone,
                         String website)
    {
        this.name = name;
        this.email = email;
        this.description = description;
        this.birth = birth;
        this.genre = genre;
        this.city = city;
        this.profession = profession;
        this.company = company;
        this.phone = phone;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public String getBirth() {
        return birth;
    }

    public String getGenre() {
        return genre;
    }

    public String getCity() {
        return city;
    }

    public String getProfession() {
        return profession;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }
}

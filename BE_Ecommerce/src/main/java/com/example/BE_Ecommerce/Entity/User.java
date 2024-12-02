package com.example.BE_Ecommerce.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userId;

    @Column(name = "useremail")
    private String userEmail;

    @Column(name = "username")
    private String userName;

    @Column(name = "Userpassword")
    private String userPassword;

    @Column(name = "userfirstname")
    private String userFirstName;

    @Column(name = "userlastname")
    private String userLastName;

    @Column(name = "userphone")
    private String userPhone;

    @Column(name = "useraddress1")
    private String userAddress1;

    @Column(name = "useraddress2")
    private String userAddress2;
}

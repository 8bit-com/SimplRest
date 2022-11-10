package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {
    }
    public Role(String role) {
        this.role = role;
    }

}

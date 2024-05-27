package com.username.springboot_webservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* The @Entity annotation in the context of spring boot and JPA is
 used to mark a class as an entity */
@Entity
/* In this line the @NoArgsConstructor annotation is for
* no argument in the constructor and @AllArgsConstructor is for
* all argument in the constructor */
@NoArgsConstructor
@AllArgsConstructor
/* @Data annotation provide methods as toString(), equals(), hashCode()
and getters and setters */
@Data
/* The @Table annotation is used to specific the mapping details for a specific
* attribute or field of an entity class to a database column*/
@Table(name = "username")
public class Username {
    /* The @Id annotation is used to indicate the primary key attribute
    of an Entity class
     */
    @Id
    /* The annotation @GeneratedValue is used to specify the strategic for
    generating value for a primary key column
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /* The annotation @Column is used to specify the mapping details for a specific attribute
    or field of the entity class to the database column
     */
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;


}

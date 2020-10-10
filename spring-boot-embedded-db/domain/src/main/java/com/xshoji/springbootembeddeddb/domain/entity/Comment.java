package com.xshoji.springbootembeddeddb.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *  - [java - Specifying an Index (Non-Unique Key) Using JPA - Stack Overflow](https://stackoverflow.com/questions/3405229/specifying-an-index-non-unique-key-using-jpa)
 *  - [spring - unexpected token： LIMIT - Stack Overflow](https://stackoverflow.com/questions/40574674/unexpected-token-limit/40576183#40576183)
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c ")})
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String message;

    /**
     *  - [java - Date format in the json output using spring boot - Stack Overflow](https://stackoverflow.com/questions/29027475/date-format-in-the-json-output-using-spring-boot)
     *  - [Guide to @JsonFormat in Jackson | Baeldung](http://www.baeldung.com/jackson-jsonformat)
     */
    @Getter
    protected Date createdOn;

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
    }
}

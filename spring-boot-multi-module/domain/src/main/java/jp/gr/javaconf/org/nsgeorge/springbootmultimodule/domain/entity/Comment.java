package jp.gr.javaconf.org.nsgeorge.springbootmultimodule.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * # - [java - Specifying an Index (Non-Unique Key) Using JPA - Stack Overflow](https://stackoverflow.com/questions/3405229/specifying-an-index-non-unique-key-using-jpa)
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private Long recordId;

    private Long userId;

    private String contentJson;
}

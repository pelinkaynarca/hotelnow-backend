package com.tobeto.java4a.hotelnow.entities.concretes;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="images")
@Inheritance(strategy = InheritanceType.JOINED)
public class Image extends BaseEntity {

    @JoinColumn(name="image_name")
    private String imageName;

    @JoinColumn(name = "path")
    private String path;
}

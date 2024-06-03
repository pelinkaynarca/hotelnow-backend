package com.tobeto.java4a.hotelnow.entities.concretes;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;



@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cities")
public class City extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<District> districts;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}

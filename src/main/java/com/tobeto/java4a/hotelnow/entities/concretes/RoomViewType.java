package com.tobeto.java4a.hotelnow.entities.concretes;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room_view_types")
public class RoomViewType extends BaseEntity {

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "roomViewType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomType> roomTypes;
}

package com.tobeto.java4a.hotelnow.entities.concretes;

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
@Table(name = "room_type_images")
public class RoomTypeImage extends Image {

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
}

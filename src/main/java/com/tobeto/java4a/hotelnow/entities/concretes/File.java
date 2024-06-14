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
@Table(name="files")
public class File extends BaseEntity {

    @JoinColumn(name="file_name")
    private String fileName;

    @JoinColumn(name = "path")
    private String path;

    @OneToOne(mappedBy = "file", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RoomTypeImage roomTypeImage;
}

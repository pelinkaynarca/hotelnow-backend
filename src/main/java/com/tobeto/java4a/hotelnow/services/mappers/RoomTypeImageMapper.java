package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.File;
import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeImage;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypeimages.AddRoomTypeImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.files.FileDetailResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.files.ListFileResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.AddRoomTypeImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.ListRoomTypeImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface RoomTypeImageMapper {

    RoomTypeImageMapper INSTANCE = Mappers.getMapper(RoomTypeImageMapper.class);

    @Mappings({
            @Mapping(target = "roomTypeId", source = "roomTypeImage.roomType.id"),
            @Mapping(target = "photos", expression = "java(mapFilesToPhotos(files))")
    })
    ListRoomTypeImageResponse listResponseFromRoomTypeImage(RoomTypeImage roomTypeImage, List<File> files);

    @Mappings({
            @Mapping(target = "id", source = "file.id"),
            @Mapping(target = "fileName", source = "file.fileName"),
            @Mapping(target = "path", source = "file.path")
    })
    ListFileResponse listResponseFromFile(File file);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "roomType.id", source = "roomTypeId"),
            @Mapping(target = "file", ignore = true)
    })
    RoomTypeImage roomTypeImageFromAddRequest(AddRoomTypeImageRequest request);

    @Mappings({
            @Mapping(target = "roomTypeId", source = "roomTypeImage.roomType.id"),
            @Mapping(target = "photos", expression = "java(mapFilesToPhotos(files))")
    })
    AddRoomTypeImageResponse addResponseFromRoomTypeImage(RoomTypeImage roomTypeImage, List<File> files);

    default List<ListFileResponse> mapFilesToPhotos(List<File> files) {
        return files.stream()
                .map(this::listResponseFromFile)
                .collect(Collectors.toList());
    }

    default List<File> mapFileDetailsToFiles(List<FileDetailResponse> fileDetailResponses) {
        return fileDetailResponses.stream()
                .map(fileDetailResponse -> {
                    File file = new File();
                    file.setFileName(fileDetailResponse.getFileName());
                    file.setPath(fileDetailResponse.getPathOrContainerName());
                    return file;
                })
                .collect(Collectors.toList());
    }
}

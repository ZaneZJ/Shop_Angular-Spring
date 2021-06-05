package com.zane.shop.mapper;

import com.zane.shop.dto.PicturesDTO;
import com.zane.shop.model.Pictures;
import org.springframework.stereotype.Component;

@Component
public class PicturesMapper {

    public Pictures fromDTO(PicturesDTO picturesDTO){
        Pictures pictures = new Pictures();
        pictures.setPictureId(picturesDTO.getPictureId());
        pictures.setPicture(picturesDTO.getPicture());
        return pictures;
    }

    public PicturesDTO toDTO(Pictures pictures){
        PicturesDTO picturesDTO = new PicturesDTO();
        picturesDTO.setPictureId(pictures.getPictureId());
        picturesDTO.setPicture(pictures.getPicture());
        return picturesDTO;
    }
}

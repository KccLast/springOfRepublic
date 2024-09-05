package com.kcc.rich.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
@ToString
public class ReviewInsertDTO {
    private MultipartFile review_img;
    private Long reservation_id;
    private String review_content;
    private Integer review_score;
    private Integer member_id;


    private String fullPath;
}

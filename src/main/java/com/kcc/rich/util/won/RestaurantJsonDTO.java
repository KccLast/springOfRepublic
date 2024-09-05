package com.kcc.rich.util.won;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true) // 필요없는 필드 무시
public class RestaurantJsonDTO {
    private Long restaurant_id;
    @JsonProperty("CrtfcUpsoInfo")
    private CrtfcUpsoInfo crtfcUpsoInfo;

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true) // 필요없는 필드 무시
    public static class CrtfcUpsoInfo {

        @JsonProperty("list_total_count")
        private int listTotalCount;

        @JsonProperty("row")
        private List<ResInfo> resList = new ArrayList<>();
    }

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResInfo {

        private Long restaurant_id;

        @JsonProperty("CRTFC_GBN")
        private Integer res_certification_code;
        @JsonProperty("UPSO_NM")
        private String resName; // 업소 이름

        @JsonProperty("CGG_CODE_NM")
        private String resDistrict; // 구역

        @JsonProperty("BIZCND_CODE_NM")
        private String resType; // 유형

        @JsonProperty("MAP_INDICT_YN")
        private String mapIndictYn; // 지도 표시 여부

        @JsonProperty("Y_DNTS")
        private double restaurant_y; // Y 좌표

        @JsonProperty("X_CNTS")
        private double restaurant_x; // X 좌표

        @JsonProperty("TEL_NO")
        private String resPhone; // 전화번호

        @JsonProperty("RDN_CODE_NM")
        private String resAddress; // 주소

        @JsonProperty("FOOD_MENU")
        private String foodMenu; // 음식 메뉴
    }
}
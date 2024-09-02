package com.kcc.rich.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
    private Integer page;
    private Integer contentPerPage=8;

    private String type;
    private String keyword;
    private SearchKeyword searchKeyword;
    public Criteria() {
        this(1, 8);
    }

    public Criteria(int page, int contentPerPage) {
        this.page = page;
        this.contentPerPage= contentPerPage;
    }


}

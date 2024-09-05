package com.kcc.rich.util;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {
    private static final int PAGE_NUM_PER=5; //페이징 버튼에 표시할 번호수
    private int startPage;
    private int endPage;
    private boolean prev, next;
    private Integer total;
    private Criteria cri;


    public PageDTO(Criteria cri, int total) {

        this.cri = cri;
        this.total = total;

        this.endPage = (int) (Math.ceil(cri.getPage() / 5.0)) * PAGE_NUM_PER;

        this.startPage = this.endPage - (PAGE_NUM_PER-1);

        int realEnd = (int) (Math.ceil((total * 1.0) / cri.getContentPerPage()));

        if (realEnd <= this.endPage) {
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;

        this.next = this.endPage < realEnd;
    }
}

package com.kcc.rich.util.won;

import lombok.*;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RestDateTime implements Serializable {
    private String date;
    private List<String> time;
    private Long version;
}

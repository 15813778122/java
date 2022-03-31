package com.qfedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberSearcgCondition {
    private String gender;
    private Integer minAge;
    private Integer maxAge;
    private String city;
}

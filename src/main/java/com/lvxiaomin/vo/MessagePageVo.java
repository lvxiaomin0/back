package com.lvxiaomin.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Ming
 * @Date: 2023/3/30 14:53
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessagePageVo {

    private int currentPage;

    private int pageSize;
}

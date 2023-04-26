package com.lvxiaomin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: Ming
 * @Date: 2023/4/26 0026 12:43
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserGetEmailDto {

    @NotEmpty(message = "could not be empty")
    @JsonProperty(value ="userEmail")
    private String userEmail;
}

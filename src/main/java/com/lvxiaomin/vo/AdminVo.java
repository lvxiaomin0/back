package com.lvxiaomin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminVo implements Serializable {
    @JsonProperty(value = "id")
    private Integer adminId;

    @NotEmpty(message = "could not be empty")
    @JsonProperty(value = "email")
    private String adminLoginName;

    @NotEmpty(message = "could not be empty")
    @JsonProperty(value = "password")
    private String adminLoginPassword;
}

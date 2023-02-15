package com.lvxiaomin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author: Ming
 * @Date: 2023/2/15 18:00
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    @NotNull(message = "could not be NotNull")
    @JsonProperty(value = "comArtId")
    private Long comArtId;

    @NotEmpty(message = "could not be empty")
    @JsonProperty(value = "comContent")
    private String comContent;

    @NotNull(message = "could not be NotNull")
    @JsonProperty(value = "comUserId")
    private Long comUserId;
}

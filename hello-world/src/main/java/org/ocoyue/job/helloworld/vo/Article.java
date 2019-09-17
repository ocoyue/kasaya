package org.ocoyue.job.helloworld.vo;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * @author: Zoé
 * @date: 2019/9/14  上午9:47
 * @describe: TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder(value={"content","title"})

public class Article {

    //@JsonIgnore
    private Long id;

    @JsonProperty("auther")
    private String author;
    private String title;
    @NotEmpty(message = "文章内容不能为空，请检查您的输入")
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date createTime;
    private List<Reader> reader;


}

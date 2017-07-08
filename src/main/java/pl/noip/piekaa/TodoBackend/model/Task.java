package pl.noip.piekaa.TodoBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by pieka on 08.07.17.
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task
{
    @Id
    private Long id;
    private String name;
    private String description;
    @JsonProperty("parent_task")
    private Long parentTaskId;
    private Boolean done;

}

package pl.noip.piekaa.TodoBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by pieka on 08.07.17.
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TaskConnection
{
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("parent_id")
    private Long parentId;
    @JsonProperty("child_id")
    private Long childId;
}

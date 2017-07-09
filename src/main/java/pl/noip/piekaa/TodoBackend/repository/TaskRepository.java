package pl.noip.piekaa.TodoBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.noip.piekaa.TodoBackend.model.Task;

import java.util.List;

/**
 * Created by pieka on 08.07.17.
 */
public interface TaskRepository extends JpaRepository<Task, Long>
{
    List<Task> findByParentTaskId(Long parentId);
}

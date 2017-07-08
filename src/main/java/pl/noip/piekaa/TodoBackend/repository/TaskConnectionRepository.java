package pl.noip.piekaa.TodoBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.noip.piekaa.TodoBackend.model.TaskConnection;

/**
 * Created by pieka on 08.07.17.
 */
public interface TaskConnectionRepository extends JpaRepository<TaskConnection, Long>
{

}

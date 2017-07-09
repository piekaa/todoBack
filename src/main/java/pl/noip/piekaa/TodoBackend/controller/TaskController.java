package pl.noip.piekaa.TodoBackend.controller;

import org.springframework.web.bind.annotation.*;
import pl.noip.piekaa.TodoBackend.model.Task;
import pl.noip.piekaa.TodoBackend.model.TaskConnection;
import pl.noip.piekaa.TodoBackend.repository.TaskConnectionRepository;
import pl.noip.piekaa.TodoBackend.repository.TaskRepository;

import java.util.List;

/**
 * Created by pieka on 08.07.17.
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class TaskController {

    private TaskRepository taskRepository;
    private TaskConnectionRepository taskConnectionRepository;

    public TaskController(TaskRepository taskRepository, TaskConnectionRepository taskConnectionRepository) {
        this.taskRepository = taskRepository;
        this.taskConnectionRepository = taskConnectionRepository;
    }

    @RequestMapping(value = "/subtasks/{id}", method = RequestMethod.GET)
    public List<Task> getSubtasks(@PathVariable("id") Long id) {
        return taskRepository.findByParentTaskId(id);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public Task getTask(@PathVariable("id") Long id) {
        return taskRepository.getOne(id);
    }


    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public void addTask(@RequestBody Task task) {

        TaskConnection taskConnection = new TaskConnection();

        taskConnection.setParentId(task.getParentTaskId());
        taskConnection.setChildId(task.getId());
        taskRepository.save(task);
        taskConnectionRepository.save(taskConnection);
    }

    @RequestMapping(value = "/task/done/{id}", method = RequestMethod.PUT)
    public void setTaskAsDone(@PathVariable("id") Long id) {

        Task task = taskRepository.getOne(id);
        task.setDone(true);
        taskRepository.save(task);

    }


    @RequestMapping(value = "/task/undone/{id}", method = RequestMethod.PUT)
    public void setTaskAsNotDone(@PathVariable("id") Long id) {

        Task task = taskRepository.getOne(id);
        task.setDone(false);
        taskRepository.save(task);
    }


}

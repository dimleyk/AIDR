package qa.qcri.aidr.task.ejb;



import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;

import qa.qcri.aidr.task.entities.Document;
import qa.qcri.aidr.task.entities.TaskAssignment;

@Local
public interface TaskAssignmentService extends AbstractTaskManagerService<TaskAssignment, Long>  {

    public void insertTaskAssignment(List<Document> taskList, Long userID);
    public void insertOneTaskAssignment(Long documentID, Long userID);
    public void undoTaskAssignment(List<Document> taskList, Long userID);
    public void undoTaskAssignment(Map<Long, Long> taskMap);
    public void undoTaskAssignment(Long documentID, Long userID);
    public void undoTaskAssignmentByTimer();
    public TaskAssignment findTaskAssignment(Long documentID, Long userID);
    public List<TaskAssignment> findTaskAssignmentByID(Long documentID);
    public Integer getPendingTaskCount(Long userID);
}

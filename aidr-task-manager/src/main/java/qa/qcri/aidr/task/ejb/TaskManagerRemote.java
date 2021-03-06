package qa.qcri.aidr.task.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;

import org.hibernate.criterion.Criterion;

import qa.qcri.aidr.task.entities.Document;


@Remote
public interface TaskManagerRemote<T, Serializable> {
	
	public Class<T> getClassType();
	
	public String getAllTasks();
	
	public void insertNewTask(T task);
	public void insertNewTask(List<T> collection);
	
	public int deleteTaskById(Long id);
	public int deleteTask(T task);
	public int deleteTask(List<T> collection);
	public int deleteUnassignedTaskCollection(List<T> collection);
	public int deleteUnassignedTask(T task);
	public int deleteStaleTasks(String joinType, String joinTable, String joinColumn,  
						  	    String sortOrder, String[] orderBy,
						  	    final String maxTaskAge, final String scanInterval);
	
	public void updateTask(T task);
	public void updateTask(List<T> collection);
	public void taskUpdate(Criterion criterion, String joinType, String joinTable, 
			  			   String joinColumn, String sortOrder, String[] orderBy);
	
	public String getNewTask(Long crisisID);
	public String getNewTask(Long crisisID, Criterion criterion);
	public String getNewTaskCollection(Long crisisID, Criterion criterion);
	
	public String getTaskById(Long id);
	
	public String getTaskByCriterion(Long crisisID, Criterion criterion);
	public String getTaskCollectionByCriterion(Long crisisID, Criterion criterion);
	//public List<T> getByCriterion(Criterion criterion, String joinType, String[] joinTables, 
	//							  String joinColumn, String sortOrder, String[] orderBy);
	
	public <E> Boolean isTaskAssigned(E task);
	public <E> Boolean isTaskNew(E task);
	public <E> Boolean isTaskDone(E task);
	public <E> Boolean isExists(E task);
	
}

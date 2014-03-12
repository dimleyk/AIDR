package qa.qcri.aidr.predictui.facade.imp;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import qa.qcri.aidr.predictui.facade.TaskBufferScannerFacade;


/**
 *
 * @author Koushik
 */
@Stateless
public class TaskBufferScannerImp implements TaskBufferScannerFacade {

	private static Logger logger = LoggerFactory.getLogger(TaskBufferScannerImp.class);

	@PersistenceContext(unitName = "qa.qcri.aidr.predictui-EJBS")
	private EntityManager em;

	@Override
	public void ScanTaskBuffer(final String maxTaskAge, final String scanInterval) {
		// TODO Auto-generated method stub
		try {
			String deleteStaleDocsSql = "DELETE t FROM aidr_predict.document t LEFT JOIN "
					+ "aidr_predict.task_assignment b ON t.documentID = b.documentID WHERE "
					+ "(b.documentID IS NULL && TIMESTAMPDIFF(" 
					+ getMetric(scanInterval) + ", t.receivedAt, now()) > :task_expiry_age);";

			Query querySelect1 = em.createNativeQuery(deleteStaleDocsSql);
			querySelect1.setParameter("task_expiry_age", Integer.parseInt(getTimeValue(maxTaskAge)));

			// no need - Hibernate automatically acquires LockModeType.WRITE lock
			// Also, test showed that the problem is still coming from trainer-api
			//querySelect.setLockMode(LockModeType.OPTIMISTIC_FORCE_INCREMENT);		
			int result = querySelect1.executeUpdate();
			System.out.println("[ScanTaskBuffer] number of deleted stale records = " + result);
		} catch (Exception e) {
			logger.error("[ScanTaskBuffer] Exception in executing SQL delete stale docs query");
			e.printStackTrace();
		}
		try {
			String deleteNoAnswerDocsSql = "DELETE T from aidr_predict.document T LEFT JOIN "
					+ "   aidr_predict.task_assignment D ON T.documentID=D.documentID WHERE "
					+ "   (SELECT S.documentID FROM aidr_predict.task_assignment S WHERE "
					+ "   ((S.documentID NOT IN (SELECT TA.documentID from aidr_predict.task_answer TA)) "
					+ "   && (TIMESTAMPDIFF(" 
					+ getMetric(scanInterval) + ", S.assignedAt, now()) > :task_expiry_age)));";
			
			Query querySelect2 = em.createNativeQuery(deleteNoAnswerDocsSql);
			querySelect2.setParameter("task_expiry_age", Integer.parseInt(getTimeValue(maxTaskAge)));

			// no need - Hibernate automatically acquires LockModeType.WRITE lock
			// Also, test showed that the problem is still coming from trainer-api
			//querySelect.setLockMode(LockModeType.OPTIMISTIC_FORCE_INCREMENT);		
			int result = querySelect2.executeUpdate();
			System.out.println("[ScanTaskBuffer] number of deleted no answer records = " + result);
		} catch (Exception e) {
			logger.error("[ScanTaskBuffer] Exception in executing SQL delete no answer docs query");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param timeString
	 * @return duration in milliseconds. Negative indicates an invalid parse result
	 */
	@Override
	public long parseTime(final String timeString) {
		long duration = -1;		
		assert timeString != null;
		float value = Float.parseFloat(timeString.substring(0, timeString.length()-1));
		if (value > 0) {
			String suffix = timeString.substring(timeString.length() - 1, timeString.length());
			if (suffix != null) {
				if (suffix.equalsIgnoreCase("s"))
					duration = Math.round(value * 1000);
				else if (suffix.equalsIgnoreCase("m"))
					duration = Math.round(value * 60 * 1000) ;
				else if (suffix.equalsIgnoreCase("h"))
					duration = Math.round(value * 60 * 60 * 1000);
				else if (suffix.equalsIgnoreCase("d"))
					duration = Math.round(value * 60 * 60 * 24 * 1000);
				else
					duration = Math.round(value * 60 * 1000);		// default is minutes
			}
			else
				duration = Math.round(value * 60 * 1000);		// default is minutes
		}
		return duration;
	}

	@Override
	public String getTimeValue(final String timeString) {
		assert timeString != null;
		return timeString.substring(0, timeString.length()-1);
	}

	@Override
	public String getMetric(final String timeString) {
		assert timeString != null;
		String metric = "HOUR";			// default
		String suffix = timeString.substring(timeString.length() - 1, timeString.length());
		if (suffix != null) {
			if (suffix.equalsIgnoreCase("s"))
				metric = "SECOND"; 
			else if (suffix.equalsIgnoreCase("m"))
				metric = "MINUTE";
			else if (suffix.equalsIgnoreCase("h"))
				metric = "HOUR";
			else if (suffix.equalsIgnoreCase("d"))
				metric = "DAY";
		}
		return metric;
	}
}

package qa.qcri.aidr.trainer.api.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import qa.qcri.aidr.trainer.api.service.TaskAnswerService;
import qa.qcri.aidr.trainer.api.template.TaskAnswerResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: jilucas
 * Date: 9/15/13
 * Time: 8:37 AM
 * To change this template use File | Settings | File Templates.
 */
@Path("/taskanswer")
@Component
public class TaskAnswerController {

    protected static Logger logger = Logger.getLogger("service");

    @Autowired
    private TaskAnswerService taskAnswerService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/save")
    public void saveTaskAnswer(String data){
        logger.debug("saveTaskAnswer start: " + new Date());
        logger.debug("saveTaskAnswer..: " + data);
        // place into transaction block
        try{
            taskAnswerService.processTaskAnswer(data);
        }
        catch(Exception e){
            logger.error("saveTaskAnswer got exception : " + e);
        }



       // below is non transaction block
       /**
        try{
            TaskAnswerResponse taskAnswerResponse =  taskAnswerService.getTaskAnswerResponseData(data);
            taskAnswerService.markOnHasHumanTag(taskAnswerResponse.getDocumentID());
            taskAnswerService.addToTaskAnswer( taskAnswerResponse);
            taskAnswerService.addToDocumentNominalLabel(taskAnswerResponse);
            taskAnswerService.removeTaskAssignment(taskAnswerResponse);
            taskAnswerService.pushTaskAnswerToJedis(taskAnswerResponse);

        }
        catch(Exception e){
            System.out.println("saveTaskAnswer : " +  e);
        }  **/

    }
}

package MaxPointsParticipantsMV;


import Exceptions.ValidatorException;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.TemaLabXMLService;
import Validator.TemaLabValidator;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class AppTest {
    TemaLabXMLService tmLbSrv = new TemaLabXMLService(new TemaLabXMLRepo(new TemaLabValidator(), "TemaLaboratorXML.xml"));

    @Test
    public void addAssignmentAssignmentDueDateTooBig()
    {
        String id,descr,saptLim,saptPred;
        id = "1";
        descr = "smtg";
        saptLim = "20";
        saptPred = "10";
        String[] params={id,descr,saptLim,saptPred};
        try {
            tmLbSrv.add(params);
            fail();
        }catch (ValidatorException ex){
            assert true;
        }
    }

    @Test
    public void addAssignmentAssignmentDueDateTooSmall()
    {
        String id,descr,saptLim,saptPred;
        id = "1";
        descr = "smtg";
        saptLim = "-1";
        saptPred = "10";
        String[] params={id,descr,saptLim,saptPred};
        try {
            tmLbSrv.add(params);
            fail();
        }catch (ValidatorException ex){
            assert true;
        }
    }
}

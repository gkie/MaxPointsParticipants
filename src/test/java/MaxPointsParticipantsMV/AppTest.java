package MaxPointsParticipantsMV;


import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.TemaLabXMLService;
import Validator.NotaValidator;
import Validator.TemaLabValidator;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class AppTest {
    TemaLabXMLService tmLbSrv = new TemaLabXMLService(new TemaLabXMLRepo(new TemaLabValidator(), "TemaLaboratorXML.xml"));
    NotaXMLService notaSrv = new NotaXMLService(new NotaXMLRepo(new NotaValidator(), "NotaXML.xml"));

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

    @Test
    public void addGradeInvalidValue() {
        String id, ids, idt, val1, data;
        id = "1";
        ids = "100";
        idt = "100";
        val1 = "80";
        data = "2018-11-02T12:00";
        String[] params = {id, ids, idt, val1, data};
        try {
            notaSrv.add(params);
            fail();
        } catch (ValidatorException ex) {
            assert true;
        }
    }
}

package MaxPointsParticipantsMV;


import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.StudentXMLService;
import Service.XMLFileService.TemaLabXMLService;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class BigBangTest {
    StudentXMLService stdSrv = new StudentXMLService(new StudentXMLRepo(new StudentValidator(), "StudentXML.xml"));
    TemaLabXMLService tmLbSrv = new TemaLabXMLService(new TemaLabXMLRepo(new TemaLabValidator(), "TemaLaboratorXML.xml"));
    NotaXMLService notaSrv = new NotaXMLService(new NotaXMLRepo(new NotaValidator(), "NotaXML.xml"));

    @Test
    public void addGradeInvalidStudent() {
        String id, ids, idt, val1, data;
        id = "1";
        ids = "2";
        idt = "1";
        val1 = "8";
        data = "2018-11-02T12:00";
        String[] params = {id, ids, idt, val1, data};
        try {
            notaSrv.add(params);
            fail();
        } catch (ValidatorException ex) {
            assert true;
        }
    }

    @Test
    public void addAssignmentNormal()
    {
        String id,descr,saptLim,saptPred;
        id = "1";
        descr = "smtg";
        saptLim = "10";
        saptPred = "12";
        String[] params={id,descr,saptLim,saptPred};
        try {
            tmLbSrv.add(params);
        }catch (ValidatorException ex){
            fail();
        }
    }

    @Test
    public void addStudentNormal() {
        String id,nume,grupa,email,prof;
        id = "1";
        nume = "First Last";
        grupa = "933";
        email = "test@mail.com";
        prof = "Some Teacher";
        String[] params={id,nume,grupa,email,prof};
        try{
            stdSrv.add(params);
        }catch (ValidatorException ex){
            fail();
        }
    }

    @Test
    public void addGradeFullFlow()
    {
        addStudentNormal();
        addAssignmentNormal();
        addGradeInvalidStudent();
    }
}

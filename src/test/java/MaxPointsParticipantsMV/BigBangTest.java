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

    // Declarations
    TemaLabXMLService tmLbSrv = new TemaLabXMLService(
            new TemaLabXMLRepo(
                    new TemaLabValidator(), "TemaLaboratorXML.xml"));
    StudentXMLService stsrv = new StudentXMLService(
            new StudentXMLRepo(
                    new StudentValidator(), "StudentiXML.xml"));
    NotaXMLService notaSrv = new NotaXMLService(
            new NotaXMLRepo(
                    new NotaValidator(), "NotaXML.xml"));

    // Test case for add grade black box
    @Test
    public void addGradeTest() throws ValidatorException {
        String id,ids,idt,val,data;
        id = "1";
        ids = "1";
        idt = "1";
        val = "10";
        data = "2012-02-22T02:06:58";
        String[] params = {id, ids, idt, val, data};
        notaSrv.add(params);
        assert true;
    }

    @Test
    public void addStudentTest() throws ValidatorException {
        String id, nume, grupa, email, prof;
        id = "1";
        nume = "Oscar";
        grupa = "923";
        email = "oscar.gal@rodeapps.com";
        prof = "Profesor X";
        String[] params = {id, nume, grupa, email, prof};
        this.stsrv.add(params);
        assert true;
    }

    @Test
    public void addAssignmentTest() throws ValidatorException {
        String id,descr,saptLim,saptPred;
        id = "1";
        descr = "smtg";
        saptLim = "10";
        saptPred = "10";
        String[] params={id,descr,saptLim,saptPred};
        tmLbSrv.add(params);
    }

    @Test
    public void bingBangTesting() throws ValidatorException {
        String id, nume, grupa, email, prof;
        id = "1";
        nume = "Oscar";
        grupa = "923";
        email = "oscar.gal@rodeapps.com";
        prof = "Profesor X";
        String[] params = {id, nume, grupa, email, prof};
        this.stsrv.add(params);
        assert true;

        String ids,idt,val,data;
        id = "1";
        ids = "1";
        idt = "1";
        val = "10";
        data = "2012-02-22T02:06:58";
        String[] params2 = {id, ids, idt, val, data};
        notaSrv.add(params2);
        assert true;

        String descr,saptLim,saptPred;
        id = "1";
        descr = "smtg";
        saptLim = "10";
        saptPred = "10";
        String[] params3 = {id,descr,saptLim,saptPred};
        tmLbSrv.add(params3);

    }



}

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

public class LabAssignment3Test {

    TemaLabXMLService tmLbSrv = new TemaLabXMLService(
            new TemaLabXMLRepo(
                    new TemaLabValidator(), "TemaLaboratorXML.xml"));
    StudentXMLService stsrv = new StudentXMLService(
            new StudentXMLRepo(
                    new StudentValidator(), "StudentiXML.xml"));
    NotaXMLService notaSrv = new NotaXMLService(
            new NotaXMLRepo(
                    new NotaValidator(), "NotaXML.xml"));

    @Test
    public void addHomework1() throws ValidatorException {
        String id,descr,saptLim,saptPred;
        id = "1";
        descr = "Some D";
        saptLim = "10";
        saptPred = "9";
        String[] params={id,descr,saptLim,saptPred};
        tmLbSrv.add(params);
    }

    @Test
    public void addHomework2() {
        String id,descr,saptLim,saptPred;
        id = "1";
        descr = "Some d";
        saptLim = null;
        saptPred = null;
        String[] params={id,descr,saptLim,saptPred};
        try {
            tmLbSrv.add(params);
        } catch (ValidatorException | NumberFormatException e) {
            assert true;
        }
    }

    @Test
    public void addHomework3() throws ValidatorException {
        String id,descr,saptLim,saptPred;
        id = "3";
        descr = "Some D";
        saptLim = "10";
        saptPred = "9";
        String[] params={id,descr,saptLim,saptPred};
        tmLbSrv.add(params);
        tmLbSrv.add(params);
    }

}

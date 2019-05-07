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

public class IntegrationTests {
    StudentValidator vs = new StudentValidator();
    TemaLabValidator vt = new TemaLabValidator();
    NotaValidator vn = new NotaValidator();
    StudentXMLRepo strepo = new StudentXMLRepo(vs,"StudentiXML.xml");
    TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
    NotaXMLRepo ntrepo = new NotaXMLRepo(vn,"NotaXML.xml");
    StudentXMLService stsrv = new StudentXMLService(strepo);
    TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
    NotaXMLService ntsrv = new NotaXMLService(ntrepo);

    @Test
    public void addStudent() throws ValidatorException {
        // 1 Test case for addStudent
        String id, nume, grupa, email, prof;
        id = "2123";
        nume = "Gal Oscar";
        grupa = "933";
        email = "goie2123@scs.ubbcluj.ro";
        prof = "Nutu Maria";
        String[] params = {id, nume, grupa, email, prof};
        this.stsrv.add(params);
        assert true;
    }

    @Test
    public void addAssignment() throws ValidatorException {
        // 1 integration test for addAssignment (addStudent+addAssignment)
        String id, nume, grupa, email, prof;
        id = "2123";
        nume = "Gal Oscar";
        grupa = "933";
        email = "goie2123@scs.ubbcluj.ro";
        prof = "Nutu Maria";
        String[] params = {id, nume, grupa, email, prof};
        this.stsrv.add(params);

        String descr,saptLim,saptPred;
        id = "1";
        descr = "Generating test cases for different levels of testing, integration testing." +
                "Use JUnit for implementing the test cases." +
                "Use Jenkins for Continuous Integration." +
                "Use Testlink for test case management.";
        saptLim = "5";
        saptPred = "6";
        String[] params2 = {id, descr, saptLim, saptPred};
        tmsrv.add(params2);
        assert true;
    }

    @Test
    public void addGrade() throws ValidatorException {
        // 1 integration test for addGrade (addStudent+addAssignment+addGrade)
        String id, nume, grupa, email, prof;
        id = "2123";
        nume = "Gal Oscar";
        grupa = "933";
        email = "goie2123@scs.ubbcluj.ro";
        prof = "Nutu Maria";
        String[] params = {id, nume, grupa, email, prof};
        this.stsrv.add(params);

        String descr,saptLim,saptPred;
        id = "1";
        descr = "Generating test cases for different levels of testing, integration testing." +
                "Use JUnit for implementing the test cases." +
                "Use Jenkins for Continuous Integration." +
                "Use Testlink for test case management.";
        saptLim = "5";
        saptPred = "6";
        String[] params2 = {id, descr, saptLim, saptPred};
        tmsrv.add(params2);

        String id_student,id_assignment,val,data;
        id = "1";
        id_student = "2123";
        id_assignment = "1";
        val = "9";
        data = "2018-11-02T12:00";
        String[] params3 = {id, id_student, id_assignment, val, data};
        ntsrv.add(params3);
        assert true;
    }
}

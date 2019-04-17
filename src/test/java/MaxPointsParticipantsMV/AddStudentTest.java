package MaxPointsParticipantsMV;

import Exceptions.ValidatorException;
import Repository.XMLFileRepository.StudentXMLRepo;
import Service.XMLFileService.StudentXMLService;
import Validator.StudentValidator;
import org.junit.Test;
import static junit.framework.TestCase.fail;


public class AddStudentTest {
    StudentValidator vs = new StudentValidator();
    StudentXMLRepo strepo = new StudentXMLRepo(vs, "StudentiXML.xml");
    StudentXMLService stsrv = new StudentXMLService(strepo);

    @Test
    public void addStudentInputEverythingAsItIsSupposed() throws ValidatorException {
        String id, nume, grupa, email, prof;
        id = "1";
        nume = "Oscar";
        grupa = "933";
        email = "oscar.gal@rodeapps.com";
        prof = "Profesor X";
        String[] params = {id, nume, grupa, email, prof};
        this.stsrv.add(params);
        assert true;
    }

    @Test
    public void addStudentIdSmallerThan0() throws ValidatorException {
        String id, nume, grupa, email, prof;
        id = "-1";
        nume = "Oscar";
        grupa = "933";
        email = "oscar.gal@rodeapps.com";
        prof = "Profesor X";
        String[] params = {id, nume, grupa, email, prof};
        this.stsrv.add(params);
        assert true;
    }

    @Test
    public void addStudentIdAlpha() throws ValidatorException {
        String id, nume, grupa, email, prof;
        id = "abcd";
        nume = "Oscar";
        grupa = "933";
        email = "oscar.gal@rodeapps.com";
        prof = "Profesor X";
        String[] params = {id, nume, grupa, email, prof};
        this.stsrv.add(params);
        assert true;
    }

    @Test
    public void addStudentIdEmpty() {
        String id, nume, grupa, email, prof;
        id = "";
        nume = "Oscar";
        grupa = "933";
        email = "oscar.gal@rodeapps.com";
        prof = "Profesor X";
        String[] params = {id, nume, grupa, email, prof};
        try {
            this.stsrv.add(params);
            fail();
        } catch (ValidatorException ex) {
            assert true;
        }
    }

    @Test
    public void addStudentNameNumber() {
        String id, nume, grupa, email, prof;
        id = "1";
        nume = "12345";
        grupa = "933";
        email = "oscar.gal@rodeapps.com";
        prof = "Profesor X";
        String[] params = {id, nume, grupa, email, prof};
        try {
            this.stsrv.add(params);
        } catch (ValidatorException ex) {
            assert true;
        }
    }

    @Test
    public void addStudentNameEmpty() {
        String id, nume, grupa, email, prof;
        id = "1";
        nume = "";
        grupa = "933";
        email = "oscar.gal@rodeapps.com";
        prof = "Profesor X";
        String[] params = {id, nume, grupa, email, prof};
        try {
            this.stsrv.add(params);
            fail();
        } catch (ValidatorException ex) {
            assert true;
        }
    }


    @Test
    public void addStudentGroupString() throws ValidatorException {
        String id, nume, grupa, email, prof;
        id = "1";
        nume = "Oscar";
        grupa = "asdfghjk";
        email = "oscar.gal@rodeapps.com";
        prof = "Profesor X";
        String[] params = {id, nume, grupa, email, prof};
        try {
            this.stsrv.add(params);
            fail();
        } catch (ValidatorException ex) {
            assert true;
        }
    }

    @Test
    public void addStudentGroupEmpty() throws ValidatorException {
        String id, nume, grupa, email, prof;
        id = "1";
        nume = "Oscar";
        grupa = "";
        email = "oscar.gal@rodeapps.com";
        prof = "Profesor X";
        String[] params = {id, nume, grupa, email, prof};
        try {
            this.stsrv.add(params);
            fail();
        } catch (ValidatorException ex) {
            assert true;
        }
    }

    // email fara @
    @Test
    public void addStudentEmailWithoutAt() throws ValidatorException {
        String id, nume, grupa, email, prof;
        id = "1";
        nume = "Oscar";
        grupa = "931";
        email = "oscar.galrodeapps.com";
        prof = "Profesor X";
        String[] params = {id, nume, grupa, email, prof};
        this.stsrv.add(params);
        assert true;
    }

    @Test
    public void addStudentEmailEmpty() throws ValidatorException {
        String id, nume, grupa, email, prof;
        id = "1";
        nume = "Oscar";
        grupa = "931";
        email = "";
        prof = "Profesor X";
        String[] params = {id, nume, grupa, email, prof};
        try {
            this.stsrv.add(params);
            fail();
        } catch (ValidatorException ex) {
            assert true;
        }
    }


    @Test
    public void addStudentTeacherNumber() throws ValidatorException {
        String id, nume, grupa, email, prof;
        id = "1";
        nume = "Oscar";
        grupa = "931";
        email = "oscar.gal@rodeapps.com";
        prof = "12345";
        String[] params = {id, nume, grupa, email, prof};
        this.stsrv.add(params);
        assert true;
    }

    @Test
    public void addStudentTeacherEmpty() throws ValidatorException {
        String id, nume, grupa, email, prof;
        id = "1";
        nume = "Oscar";
        grupa = "931";
        email = "oscar.galrodeapps.com";
        prof = "";
        String[] params = {id, nume, grupa, email, prof};
        try {
            this.stsrv.add(params);
            fail();
        } catch (ValidatorException ex) {
            assert true;
        }
    }
}

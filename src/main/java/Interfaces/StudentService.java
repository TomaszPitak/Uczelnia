
package Interfaces;

import Entities.Student;
import java.util.List;

public interface StudentService {
   List<Student> wyszukajWgPeselu(String pesel);
   List<Student> wyszukajWgNazwiska(String nazwisko);
   List<Student> wyszukajWgKierunku(String nazwisko);
   Student saveStudent(String idKierunku, String idKolegium, String imie, String nazwisko, String pesel, String miejscowosc, String ulica, String nrMieszkania, String nrTelefonu, String email, String nrSemestru, String nrAlbumu);    
   void updateStudent(String nazwaKierunku, String nazwaKolegium, String imie, String nazwisko, String pesel, String miejscowosc, String ulica, String nrMieszkania, String nrTelefonu, String email, String nrSemestru, String nrAlbumu, String idStudenta);
   void deleteStudent(Student student);
   boolean wyszukajStudenta(String pesel);
}

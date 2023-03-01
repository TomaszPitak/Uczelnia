package DatabaseQueries;

import Singleton.SingletonConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Odpowiedzialna za utworzenie funkcji w bazie danych.
 *
 * @author Tomasz Pitak
 */
public class CreateFunctions {

    private SessionFactory sessionFactory;
    private Session session;

    public CreateFunctions() {
        this.sessionFactory = SingletonConnection.getSessionFactory();
    }

    /**
    * Tworzy funkcje w bazie danych.
    *
    * @author Tomasz Pitak, Karol Wereski
    */
    public void create() {
        session = sessionFactory.openSession();
        session.beginTransaction();

        session.createSQLQuery("create or replace function Login(z_login varchar2, z_haslo varchar2) return varchar2 is\n"
                + "  l_exst number(1);\n"
                + "begin\n"
                + " select case \n"
                + "           when exists(SELECT login FROM USERS WHERE login = z_login AND haslo = z_haslo)\n"
                + "           then 1\n"
                + "           else 0\n"
                + "         end  into l_exst\n"
                + "  from dual;\n"
                + "\n"
                + "if l_exst = 1 \n"
                + "  then\n"
                + "    return 'true';\n"
                + "  else\n"
                + "    return 'false'; \n"
                + "  end if;\n"
                + "end Login;").executeUpdate();

        session.createSQLQuery("CREATE or replace FUNCTION aktualizujStatystyki return number IS\n"
                + "        st statystyki%rowtype;\n"
                + "        \n"
                + "        procedure st_add(z_numer number, z_nazwa varchar2, z_wartosc number) AS\n"
                + "        begin \n"
                + "        	update statystyki set nazwa = z_nazwa, wartosc = z_wartosc, data = sysdate where numer = z_numer;\n"
                + "            if SQL%NOTFOUND then \n"
                + "                insert into statystyki (numer, nazwa, wartosc) values (z_numer, z_nazwa, z_wartosc);\n"
                + "            end IF;\n"
                + "            commit;\n"
                + "       end st_add;\n"
                + "       \n"
                + "BEGIN\n"
                + "    st.numer \\:= 1;\n"
                + "    st.nazwa \\:= 'Liczba studentów';\n"
                + "    st.wartosc \\:= 0;\n"
                + "    select count(*) into st.wartosc from studenci;\n"
                + "    st_add(st.numer, st.nazwa, st.wartosc);\n"
                + "    \n"
                + "    st.numer \\:= 2;\n"
                + "    st.nazwa \\:= 'Liczba wykladowców';\n"
                + "    st.wartosc \\:= 0;\n"
                + "    select count(*) into st.wartosc from wykladowcy;\n"
                + "    st_add(st.numer, st.nazwa, st.wartosc);\n"
                + "    \n"
                + "    st.numer \\:= 3;\n"
                + "    st.nazwa \\:= 'Liczba kierunków';\n"
                + "    st.wartosc \\:= 0;\n"
                + "    select count(*) into st.wartosc from kierunki;\n"
                + "    st_add(st.numer, st.nazwa, st.wartosc);\n"
                + "    \n"
                + "    return 1;\n"
                + "    \n"
                + "exception\n"
                + "    when others then return 0;\n"
                + "    \n"
                + "END aktualizujStatystyki;").executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

}

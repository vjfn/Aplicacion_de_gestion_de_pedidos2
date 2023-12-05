package domain;

import clase.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UsuarioDAOHib implements UsuarioDAO{
    @Override
    public Usuario loadUser(String mail, String password) {
        Usuario salida = null;

        try(Session s = HibernateUtil.getSessionFactory().openSession()){
            Query<Usuario> q  = s.createQuery("from Usuario where mail=:mail and password=:pass",Usuario.class);
            q.setParameter("mail",mail);
            q.setParameter("pass",password);
            var resultado = q.getResultList();
            if(!resultado.isEmpty()) salida = resultado.get(0);
        }

        return salida;
    }

    @Override
    public Usuario createUser(String mail, String password) {
        return null;
    }
}

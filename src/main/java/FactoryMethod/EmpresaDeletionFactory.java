package FactoryMethod;

import DAO.EmpresaDao;
import Model.Empresa;

public class EmpresaDeletionFactory {
    public static boolean deleteEmpresa(Empresa selecionada) {
        if (selecionada != null) {
            EmpresaDao dao = new EmpresaDao();
            return dao.delete(selecionada);
        }
        return false;
    }
}
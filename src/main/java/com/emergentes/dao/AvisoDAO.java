
package com.emergentes.dao;

import com.emergentes.modelo.Aviso;
import java.util.List;

public interface AvisoDAO {
    public void insert(Aviso aviso) throws Exception;
    public void update(Aviso aviso) throws Exception;
    public void delete(int id) throws Exception;
    public Aviso getById(int id) throws Exception;
    public List<Aviso> getAll() throws Exception;   
}

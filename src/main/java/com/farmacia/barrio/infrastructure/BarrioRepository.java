package com.farmacia.barrio.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacia.barrio.domain.emtity.Barrio;
import com.farmacia.barrio.domain.service.BarrioService;

public class BarrioRepository implements BarrioService {
    private Connection connection;

    public BarrioRepository(){
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    @Override
    public void createBarrio(Barrio barrio) {
        
    }

    @Override
    public void updateBarrio(Barrio barrio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBarrio'");
    }

    @Override
    public void deleteBarrio(String idCiudad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBarrio'");
    }

    @Override
    public Optional<Barrio> findBarrioDtoById(String idCiudad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBarrioDtoById'");
    }

    @Override
    public List<Barrio> findAllBarrioDto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllBarrioDto'");
    }
    
}

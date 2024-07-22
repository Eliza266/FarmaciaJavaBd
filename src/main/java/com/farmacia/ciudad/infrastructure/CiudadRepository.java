package com.farmacia.ciudad.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacia.ciudad.domain.emtity.Ciudad;
import com.farmacia.ciudad.domain.service.CiudadService;

public class CiudadRepository implements CiudadService {
    private Connection connection;

    public CiudadRepository(){
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
    public void createCiudad(Ciudad ciudad) {
        try {
            String query = "INSERT INTO ciudades(idCiudad, nombre) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ciudad.getIdCiudad());
            ps.setString(2, ciudad.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

    @Override
    public void updateCiudad(Ciudad ciudad) {
        try {
            String query = "UPDATE ciudades SET nombre = ? WHERE idCiudad = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ciudad.getNombre());
            ps.setString(2, ciudad.getIdCiudad());
            ps.executeUpdate();
            
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    @Override
    public void deleteCiudad(String idCiudad) {
        try {
            String query = "DELETE FROM ciudades WHERE idCiudad = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idCiudad);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }

    @Override
    public Optional<Ciudad> findCiudadById(String idCiudad) {
        try {
            String query = "SELECT idCiudad, nombre FROM ciudades WHERE idCiudad = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idCiudad);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Ciudad ciudad = new Ciudad(rs.getString("idCiudad"), rs.getString("nombre"));
                        return Optional.of(ciudad);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Ciudad> findAllCiudad() {
        List<Ciudad> ciudades = new ArrayList<>();
        String query = "SELECT idCiudad, nombre FROM ciudades";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String idCiudad = rs.getString("idCiudad");
                String nombre = rs.getString("nombre");
                Ciudad ciudad = new Ciudad(idCiudad, nombre);
                ciudades.add(ciudad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ciudades;
    }
}

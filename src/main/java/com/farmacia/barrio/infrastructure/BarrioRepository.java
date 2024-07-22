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
import com.farmacia.barrio.domain.emtity.BarrioDto;
import com.farmacia.barrio.domain.service.BarrioService;
import com.farmacia.ciudad.domain.emtity.Ciudad;

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
    private boolean existCiudad(String idCiudad) {
        String query = "SELECT COUNT(*) FROM ciudades WHERE idCiudad = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, idCiudad);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void createBarrio(Barrio barrio) {
        if (!existCiudad(barrio.getIdCiudad())) {
            throw new IllegalArgumentException("La ciudad con el ID proporcionado no existe");
        }
        String query = "INSERT INTO barrios(nombre, idCiudad) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, barrio.getNombre());
            ps.setString(2, barrio.getIdCiudad());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
    }

    @Override
    public void updateBarrio(Barrio barrio) {
        if (!existCiudad(barrio.getIdCiudad())) {
            throw new IllegalArgumentException("La ciudad con el ID proporcionado no existe");
        }
        try {
            String query = "UPDATE barrios SET nombre = ?, idCiudad = ? WHERE idBarrio = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, barrio.getNombre());
            ps.setString(2, barrio.getIdCiudad());
            ps.setInt(3, barrio.getIdBarrio());
            ps.executeUpdate();
            
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    @Override
    public void deleteBarrio(Integer idBarrio) {
        try {
            String query = "DELETE FROM barrios WHERE idBarrio = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idBarrio);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<BarrioDto> findBarrioDtoById(Integer idBarrio) {
        try {
            String query = "SELECT b.idBarrio, b.nombre, b.idCiudad, c.nombre AS nombreCiudad FROM barrios b "
                        + "INNER JOIN ciudades c ON b.idCiudad = c.idCiudad WHERE b.idBarrio = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idBarrio);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    BarrioDto barrioDto = new BarrioDto(
                        rs.getInt("idBarrio"),
                        rs.getString("nombre"),
                        rs.getString("idCiudad"),
                        rs.getString("nombreCiudad")
                    );
                    return Optional.of(barrioDto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    

    @Override
    public Optional<Barrio> findBarrioById(Integer idBarrio) {
        try {
            String query = "SELECT idBarrio, nombre, idCiudad FROM barrios WHERE idBarrio = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idBarrio);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Barrio barrio = new Barrio(rs.getInt("idBarrio"), rs.getString("nombre"), rs.getString("idCiudad"));
                        return Optional.of(barrio);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<BarrioDto> findAllBarrioDto() {
        List<BarrioDto> barrios = new ArrayList<>();
        String query = "SELECT b.idBarrio, b.nombre, b.idCiudad, c.nombre AS nombreCiudad FROM barrios b "
                        + "INNER JOIN ciudades c ON b.idCiudad = c.idCiudad";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Integer idBarrio = rs.getInt("idBarrio");
                String nombre = rs.getString("nombre");
                String idCiudad = rs.getString("idCiudad");
                String nombreCiudad = rs.getString("nombreCiudad");
                BarrioDto barrioDto = new BarrioDto(idBarrio, nombre, idCiudad, nombreCiudad);
                barrios.add(barrioDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return barrios;
    }


   
}

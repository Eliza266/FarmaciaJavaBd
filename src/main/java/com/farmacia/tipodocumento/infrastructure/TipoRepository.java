package com.farmacia.tipodocumento.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacia.tipodocumento.domain.emtity.TipoDocumento;
import com.farmacia.tipodocumento.domain.service.TipoDocumentoService;

public class TipoRepository implements TipoDocumentoService {
    private Connection connection;

    public TipoRepository(){
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
    public void createTipo(TipoDocumento tipoDocumento) {
        try {
            String query = "INSERT INTO tipos_documentos(tipo) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tipoDocumento.getTipo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void updateTipo(TipoDocumento tipoDocumento) {
       try {
            String query = "UPDATE tipos_datos SET tipo = ? WHERE idTipo= ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, tipoDocumento.getIdTipo());
            ps.setString(2, tipoDocumento.getTipo());
            ps.executeUpdate();
       } catch (SQLException e) {
        e.printStackTrace();
       }
    }

    @Override
    public List<TipoDocumento> findAllTipo() {
        List<TipoDocumento> tipos = new ArrayList<>();
        String query = "SELECT idTipo, tipo FROM tipos_documentos";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Integer idTipo = rs.getInt("idTipo");
                String tipo = rs.getString("tipo");
                TipoDocumento tipoDocumento = new TipoDocumento(idTipo, tipo);
                tipos.add(tipoDocumento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipos;
    }

    @Override
    public void deleteTipo(Integer idTipo) {
        try {
            String query = "DELETE FROM tipos_documentos WHERE idTipo = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idTipo);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Optional<TipoDocumento> findTipoById(Integer idTipo) {
         try {
            String query = "SELECT idTipo, tipo FROM tipos_documentos WHERE idTipo = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idTipo);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        TipoDocumento tipoDocumento = new TipoDocumento(rs.getInt("idTipo"), rs.getString("tipo"));
                        return Optional.of(tipoDocumento);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}

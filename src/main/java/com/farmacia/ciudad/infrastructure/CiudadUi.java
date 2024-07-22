package com.farmacia.ciudad.infrastructure;



import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.farmacia.ciudad.aplication.CreateCiudadUseCase;
import com.farmacia.ciudad.aplication.DeleteCiudadUseCase;
import com.farmacia.ciudad.aplication.FindAllCiudadUseCase;
import com.farmacia.ciudad.aplication.FindCiudadUseCase;
import com.farmacia.ciudad.aplication.UpdateCiudadUseCase;
import com.farmacia.ciudad.domain.emtity.Ciudad;

public class CiudadUi {
    private CreateCiudadUseCase createCiudadUseCase;
    private FindCiudadUseCase findCiudadUseCase;
    private UpdateCiudadUseCase updateCiudadUseCase;
    private DeleteCiudadUseCase deleteCiudadUseCase;
    private FindAllCiudadUseCase findAllCiudadUseCase;
    private String idCiudad;


    public CiudadUi(CreateCiudadUseCase createCiudadUseCase, FindCiudadUseCase findCiudadUseCase, UpdateCiudadUseCase updateCiudadUseCase, DeleteCiudadUseCase deleteCiudadUseCase, FindAllCiudadUseCase findAllCiudadUseCase) {
        this.createCiudadUseCase = createCiudadUseCase;
        this.findCiudadUseCase = findCiudadUseCase;
        this.updateCiudadUseCase = updateCiudadUseCase;
        this.deleteCiudadUseCase = deleteCiudadUseCase;
        this.findAllCiudadUseCase = findAllCiudadUseCase;
    }
  

    
    public void createCiudad() {
        Ciudad ciudad = new Ciudad();
        ciudad.setIdCiudad(JOptionPane.showInputDialog(null, "Ingrese Id"));
        ciudad.setNombre(JOptionPane.showInputDialog(null, "Ingrese Nombre de la Ciudad"));
        createCiudadUseCase.execute(ciudad);
    }
    public Optional<Ciudad> findCiudad() {
        idCiudad = JOptionPane.showInputDialog(null, "Ingrese el ID de la Ciudad: ");
        Optional<Ciudad> ciudad = findCiudadUseCase.execute(idCiudad);
        showCiudad(ciudad);
        return ciudad;
    }

    public void updateCiudad(){
        Optional<Ciudad> ciudadOptional = findCiudad();
        if (ciudadOptional.isPresent()) {
            Ciudad ciudad = ciudadOptional.get();
            ciudad.setNombre(JOptionPane.showInputDialog(null, "Ingrese el Nombre de la ciudad"));
            updateCiudadUseCase.execute(ciudad);
            showCiudad(ciudadOptional);
            }

    }
    public void deleteCiudad(){
        Optional<Ciudad> ciudadOptional = findCiudad();
        if ( ciudadOptional.isPresent()) {
            Ciudad ciudad = ciudadOptional.get();
            deleteCiudadUseCase.execute(ciudad.getIdCiudad());
        }
    }
    public void findAllCiudad(){
        List<Ciudad> ciudades = findAllCiudadUseCase.execute();

        String[] columns = {"ID", "Name"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Ciudad ciudad : ciudades) {
            Object[] row = {
                    ciudad.getIdCiudad(),
                    ciudad.getNombre()
            };
            model.addRow(row);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Cities List", JOptionPane.PLAIN_MESSAGE);
    
    }

    public void showCiudad(Optional<Ciudad> ciudad){

        String[] columns = {"ID", "Name"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        if (ciudad.isPresent()) {
            Ciudad ciudadd = ciudad.get();
            Object[] row = {
                    ciudadd.getIdCiudad(),
                    ciudadd.getNombre()
            };
            model.addRow(row);
        } else {
            JOptionPane.showMessageDialog(null, "No hay ciudad para mostrar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Cities List", JOptionPane.PLAIN_MESSAGE);
    

    }
}


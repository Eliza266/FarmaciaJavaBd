package com.farmacia.barrio.infrastructure;



import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.farmacia.barrio.aplication.CreateBarrioUseCase;
import com.farmacia.barrio.aplication.DeleteBarrioUseCase;
import com.farmacia.barrio.aplication.FindAllBarrioDtoUseCase;
import com.farmacia.barrio.aplication.FindBarrioDtoUseCase;
import com.farmacia.barrio.aplication.UpdateBarrioUseCase;
import com.farmacia.barrio.domain.emtity.Barrio;

public class BarrioUi {
    private CreateBarrioUseCase createBarrioUseCase;
    private FindBarrioDtoUseCase findBarrioUseCase;
    private UpdateBarrioUseCase updateBarrioUseCase;
    private DeleteBarrioUseCase deleteBarrioUseCase;
    private FindAllBarrioDtoUseCase findAllBarrioUseCase;
    private String idBarrio;


    public BarrioUi(CreateBarrioUseCase createBarrioUseCase, FindBarrioDtoUseCase findBarrioUseCase, UpdateBarrioUseCase updateBarrioUseCase, DeleteBarrioUseCase deleteBarrioUseCase, FindAllBarrioDtoUseCase findAllBarrioUseCase, String idBarrio) {
        this.createBarrioUseCase = createBarrioUseCase;
        this.findBarrioUseCase = findBarrioUseCase;
        this.updateBarrioUseCase = updateBarrioUseCase;
        this.deleteBarrioUseCase = deleteBarrioUseCase;
        this.findAllBarrioUseCase = findAllBarrioUseCase;
        this.idBarrio = idBarrio;
    }
  

    
    public void createBarrio() {
        Barrio barrio = new Barrio();
        barrio.setIdBarrio(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id del Barrio")));
        barrio.setNombre(JOptionPane.showInputDialog(null, "Ingrese Nombre del Barrio"));
        barrio.setIdCiudad(JOptionPane.showInputDialog(null, "Ingrese el Id de la ciudad"));
        createBarrioUseCase.execute(barrio);
    }
    // public Optional<Ciudad> findCiudad() {
    //     idCiudad = JOptionPane.showInputDialog(null, "Ingrese el ID de la Ciudad: ");
    //     Optional<Ciudad> ciudad = findCiudadUseCase.execute(idCiudad);
    //     showCiudad(ciudad);
    //     return ciudad;
    // }

    // public void updateCiudad(){
    //     Optional<Ciudad> ciudadOptional = findCiudad();
    //     if (ciudadOptional.isPresent()) {
    //         Ciudad ciudad = ciudadOptional.get();
    //         ciudad.setNombre(JOptionPane.showInputDialog(null, "Ingrese el Nombre de la ciudad"));
    //         updateCiudadUseCase.execute(ciudad);
    //         showCiudad(ciudadOptional);
    //         }

    // }
    // public void deleteCiudad(){
    //     Optional<Ciudad> ciudadOptional = findCiudad();
    //     if ( ciudadOptional.isPresent()) {
    //         Ciudad ciudad = ciudadOptional.get();
    //         deleteCiudadUseCase.execute(ciudad.getIdCiudad());
    //     }
    // }
    // public void findAllCiudad(){
    //     List<Ciudad> ciudades = findAllCiudadUseCase.execute();

    //     String[] columns = {"ID", "Name"};
    //     DefaultTableModel model = new DefaultTableModel(columns, 0);

    //     for (Ciudad ciudad : ciudades) {
    //         Object[] row = {
    //                 ciudad.getIdCiudad(),
    //                 ciudad.getNombre()
    //         };
    //         model.addRow(row);
    //     }

    //     JTable table = new JTable(model);
    //     JScrollPane scrollPane = new JScrollPane(table);
    //     JPanel panel = new JPanel();
    //     panel.add(scrollPane);

    //     JOptionPane.showMessageDialog(null, panel, "Cities List", JOptionPane.PLAIN_MESSAGE);
    
    // }

    // public void showCiudad(Optional<Ciudad> ciudad){

    //     String[] columns = {"ID", "Name"};
    //     DefaultTableModel model = new DefaultTableModel(columns, 0);

    //     if (ciudad.isPresent()) {
    //         Ciudad ciudadd = ciudad.get();
    //         Object[] row = {
    //                 ciudadd.getIdCiudad(),
    //                 ciudadd.getNombre()
    //         };
    //         model.addRow(row);
    //     } else {
    //         JOptionPane.showMessageDialog(null, "No hay ciudad para mostrar", "Error", JOptionPane.ERROR_MESSAGE);
    //         return;
    //     }

    //     JTable table = new JTable(model);
    //     JScrollPane scrollPane = new JScrollPane(table);
    //     JPanel panel = new JPanel();
    //     panel.add(scrollPane);

    //     JOptionPane.showMessageDialog(null, panel, "Cities List", JOptionPane.PLAIN_MESSAGE);
    

   // }
}


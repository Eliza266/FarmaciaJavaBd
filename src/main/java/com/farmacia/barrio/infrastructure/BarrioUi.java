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
import com.farmacia.barrio.aplication.FindBarrioUseCase;
import com.farmacia.barrio.aplication.UpdateBarrioUseCase;
import com.farmacia.barrio.domain.emtity.Barrio;
import com.farmacia.barrio.domain.emtity.BarrioDto;

public class BarrioUi {
    private CreateBarrioUseCase createBarrioUseCase;
    private FindBarrioDtoUseCase findBarrioDtoUseCase;
    private FindBarrioUseCase findBarrioUseCase;
    private UpdateBarrioUseCase updateBarrioUseCase;
    private DeleteBarrioUseCase deleteBarrioUseCase;
    private FindAllBarrioDtoUseCase findAllBarrioUseCase;
    private Integer idBarrio;

    public BarrioUi(CreateBarrioUseCase createBarrioUseCase, FindBarrioDtoUseCase findBarrioDtoUseCase, FindBarrioUseCase findBarrioUseCase, UpdateBarrioUseCase updateBarrioUseCase, DeleteBarrioUseCase deleteBarrioUseCase, FindAllBarrioDtoUseCase findAllBarrioUseCase) {
        this.createBarrioUseCase = createBarrioUseCase;
        this.findBarrioDtoUseCase = findBarrioDtoUseCase;
        this.findBarrioUseCase = findBarrioUseCase;
        this.updateBarrioUseCase = updateBarrioUseCase;
        this.deleteBarrioUseCase = deleteBarrioUseCase;
        this.findAllBarrioUseCase = findAllBarrioUseCase;
    }
    

    
    public void createBarrio() {
        try {
            Barrio barrio = new Barrio();
            barrio.setNombre(JOptionPane.showInputDialog(null, "Ingrese Nombre del Barrio"));
            barrio.setIdCiudad(JOptionPane.showInputDialog(null, "Ingrese el Id de la ciudad"));
            createBarrioUseCase.execute(barrio);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public Optional<Barrio> findBarrio() {
        idBarrio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del Barrio: "));
        Optional<Barrio> Barrio = findBarrioUseCase.execute(idBarrio);
        showBarrio(Barrio);
        return Barrio;
    }

    public void updateBarrio(){
        Optional<Barrio> barrioOptional = findBarrio();
        if (barrioOptional.isPresent()) {
            Barrio barrio = barrioOptional.get();
            barrio.setNombre(JOptionPane.showInputDialog(null, "Ingrese el Nombre de la Barrio"));
            updateBarrioUseCase.execute(barrio);
            showBarrio(barrioOptional);
            }
         }
    public void deleteBarrio(){
        Optional<Barrio> barrioOptional = findBarrio();
        if ( barrioOptional.isPresent()) {
            Barrio barrio = barrioOptional.get();
            deleteBarrioUseCase.execute(barrio.getIdBarrio());
        }
    }

    public Optional<BarrioDto> findBarrioDto() {
        idBarrio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del Barrio: "));
        Optional<BarrioDto> BarrioDto = findBarrioDtoUseCase.execute(idBarrio);
        showBarrioDto(BarrioDto);
        return BarrioDto;
    }

    public void findAllBarrioDto(){
        List<BarrioDto> barrios = findAllBarrioUseCase.execute();

        String[] columns = {"ID", "Name","ID-NOMBRE", "NOMBRE-CIUDAD"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (BarrioDto barrio : barrios) {
            Object[] row = {
                    barrio.getIdBarrio(),
                    barrio.getNombre(),
                    barrio.getIdCiudad(),
                    barrio.getNombreCiudad()
            };
            model.addRow(row);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Barrios List", JOptionPane.PLAIN_MESSAGE);
    
    }

    public void showBarrio(Optional<Barrio> barrio){

        String[] columns = {"ID", "Name", "ID-CIUDAD"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        if (barrio.isPresent()) {
            Barrio barrios = barrio.get();
            Object[] row = {
                    barrios.getIdBarrio(),
                    barrios.getNombre(),
                    barrios.getIdCiudad()
            };
            model.addRow(row);
        } else {
            JOptionPane.showMessageDialog(null, "No hay Barrio para mostrar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Barrios List", JOptionPane.PLAIN_MESSAGE);
    

   }
   public void showBarrioDto(Optional<BarrioDto> barrioDto){

    String[] columns = {"ID", "Name", "ID-CIUDAD", "NOMBRE-CIUDAD"};
    DefaultTableModel model = new DefaultTableModel(columns, 0);

    if (barrioDto.isPresent()) {
        BarrioDto barrios = barrioDto.get();
        Object[] row = {
                barrios.getIdBarrio(),
                barrios.getNombre(),
                barrios.getIdCiudad(),
                barrios.getNombreCiudad()
        };
        model.addRow(row);
    } else {
        JOptionPane.showMessageDialog(null, "No hay Barrio para mostrar", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);
    JPanel panel = new JPanel();
    panel.add(scrollPane);

    JOptionPane.showMessageDialog(null, panel, "Barrios List", JOptionPane.PLAIN_MESSAGE);


}
}


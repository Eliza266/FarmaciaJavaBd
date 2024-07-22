package com.farmacia.tipodocumento.infrastructure;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.farmacia.tipodocumento.aplication.CreateTipoUseCase;
import com.farmacia.tipodocumento.aplication.DeleteTipoUseCase;
import com.farmacia.tipodocumento.aplication.FindAllTipoUseCase;
import com.farmacia.tipodocumento.aplication.FindTipoUseCase;
import com.farmacia.tipodocumento.aplication.UpdateTipoUseCase;
import com.farmacia.tipodocumento.domain.emtity.TipoDocumento;

public class TipoUi {
    private CreateTipoUseCase createTipoUseCase;
    private FindTipoUseCase findTipoUseCase;
    private UpdateTipoUseCase updateTipoUseCase;
    private DeleteTipoUseCase deleteTipoUseCase;
    private FindAllTipoUseCase findAllTipoUseCase;
    private int idTipo;

    public TipoUi(CreateTipoUseCase createTipoUseCase, FindTipoUseCase findTipoUseCase, UpdateTipoUseCase updateTipoUseCase, DeleteTipoUseCase deleteTipoUseCase, FindAllTipoUseCase findAllTipoUseCase) {
        this.createTipoUseCase = createTipoUseCase;
        this.findTipoUseCase = findTipoUseCase;
        this.updateTipoUseCase = updateTipoUseCase;
        this.deleteTipoUseCase = deleteTipoUseCase;
        this.findAllTipoUseCase = findAllTipoUseCase;
    }

    public void createTipo() {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setTipo(JOptionPane.showInputDialog(null, "Ingrese el Nombre del Tipo de dato"));
        createTipoUseCase.execute(tipoDocumento);
    }

    public Optional<TipoDocumento> findTipo() {
        idTipo =Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID deL Tipo de Documento: "));
        Optional<TipoDocumento> tipoDocumento = findTipoUseCase.execute(idTipo);
        showTipo(tipoDocumento);
        return tipoDocumento;
    }

    public void showTipo(Optional<TipoDocumento> tipodocumento){

        String[] columns = {"ID", "Tipo"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        if (tipodocumento.isPresent()) {
            TipoDocumento tipo = tipodocumento.get();
            Object[] row = {
                    tipo.getIdTipo(),
                    tipo.getTipo()
            };
            model.addRow(row);
        } else {
            JOptionPane.showMessageDialog(null, "No hay Tipos de Documentos para mostrar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Tipes List", JOptionPane.PLAIN_MESSAGE);
    

    }
    public void deleteTipo(){
       Optional<TipoDocumento> tOptional = findTipo();
        if ( tOptional.isPresent()) {
            TipoDocumento tipo = tOptional.get();
            deleteTipoUseCase.execute(tipo.getIdTipo());
        }
    }

    public void updateTipo(){
        Optional<TipoDocumento> tOptional = findTipo();
        if (tOptional.isPresent()) {
            TipoDocumento tipoDocumento = tOptional.get();
            tipoDocumento.setTipo(JOptionPane.showInputDialog(null, "Ingrese el nombre del Tipo de Documento"));
            updateTipoUseCase.execute(tipoDocumento);
            showTipo(tOptional);
            }
    }

    public void findAllTipo(){
        List<TipoDocumento> tipos = findAllTipoUseCase.execute();

        String[] columns = {"ID", "Tipo"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (TipoDocumento tipoDocumento : tipos) {
            Object[] row = {
                    tipoDocumento.getIdTipo(),
                    tipoDocumento.getTipo()
            };
            model.addRow(row);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Tipes List", JOptionPane.PLAIN_MESSAGE);
    }

}

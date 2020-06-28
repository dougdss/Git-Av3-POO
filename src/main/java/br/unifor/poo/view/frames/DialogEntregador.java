package br.unifor.poo.view.frames;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import br.unifor.poo.modelo.Entregador;
import br.unifor.poo.view.components.IDialogT;
import br.unifor.poo.view.util.Misc;

@SuppressWarnings("serial")
public class DialogEntregador extends IDialogT<Entregador>{

	public DialogEntregador(Entregador _item, Frame parentFrame, String title, int width, int height) {
		super(_item, parentFrame, title, width, height);
	}

	protected void events() {
		super.events();
		tabela.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1 && tabela.getSelectedRow() != -1) {
		        	Entregador e = modelo.getValueAtRow(tabela.getSelectedRow());
		        	
		        	crudPanel.txtFiels.get("id").setText(e.getId()+"");
		        	crudPanel.txtFiels.get("nome").setText(e.getNome()+"");
		        	crudPanel.txtFiels.get("placa").setText(e.getPlaca()+"");
		        }
		    }
		});
	}
	
	@Override
	public void newItem() {
		try {
			Long code = Misc.code++;
			String nome = crudPanel.txtFiels.get("nome").getText();
			String placa = crudPanel.txtFiels.get("placa").getText();
			if(nome.isEmpty() || placa.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Verifique os campos vazios.", "Ops!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Entregador item = new Entregador(code, nome, placa);
			
			
			crudPanel.txtFiels.forEach((K,V)->{ V.setText(""); });
			modelo.add(item);
			modelo.fireTableDataChanged();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Verifique os campos", "Ops!", JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	public void updateItem() {
		Entregador item = modelo.getValueAtRow(tabela.getSelectedRow());
		if(item == null) {
			JOptionPane.showMessageDialog(this, "Selecione um item primeiro.", "Ops!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		item.setId(Long.parseLong(crudPanel.txtFiels.get("id").getText()));
		item.setNome(crudPanel.txtFiels.get("nome").getText());
		item.setPlaca(crudPanel.txtFiels.get("placa").getText());
		
		crudPanel.txtFiels.forEach((K,V)->{ V.setText(""); });
		modelo.fireTableDataChanged();
	}
	@Override
	public void deleteItem() {
		Entregador item = modelo.getValueAtRow(tabela.getSelectedRow());
		if(item == null) {
			JOptionPane.showMessageDialog(this, "Selecione um item primeiro.", "Ops!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		modelo.delete(item);
		crudPanel.txtFiels.forEach((K,V)->{ V.setText(""); });
		modelo.fireTableDataChanged();
	}
}

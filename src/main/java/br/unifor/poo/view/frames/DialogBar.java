package br.unifor.poo.view.frames;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

import br.unifor.poo.modelo.Cardapio;
import br.unifor.poo.modelo.Bar;
import br.unifor.poo.services.DadosTest;
import br.unifor.poo.view.components.ComboModel;
import br.unifor.poo.view.components.IDialogT;
import br.unifor.poo.view.util.Misc;

@SuppressWarnings("serial")
public class DialogBar extends IDialogT<Bar> {
	protected ComboModel<Cardapio> comboModel = null;
	protected JComboBox<Cardapio> comboBox = null;
	
	public DialogBar(Bar _item, Frame parentFrame, String title, int width, int height) {
		super(_item, parentFrame, title, width, height);
	}
	@Override
	protected void setCrudComponents() {
		super.setCrudComponents();
		comboModel = new ComboModel<Cardapio>();
		comboBox = new JComboBox<Cardapio>(comboModel);
		comboModel.addListItem(DadosTest.cardapios);
		
		this.crudPanel.insertComponets(comboBox);
		comboBox.setFont(Misc.FONT);
	}
	@Override
	protected void newItem() {
		Bar item = new Bar();
		item.setId(Misc.code++);
		item.setNome(crudPanel.txtFiels.get("nome").getText());
		item.setLema(crudPanel.txtFiels.get("lema").getText());
		item.setHistorico(crudPanel.txtFiels.get("historico").getText());
		crudPanel.txtFiels.forEach((K,V)->{ V.setText(""); });
		modelo.add(item);
		modelo.fireTableDataChanged();
	}
	@Override
	protected void updateItem() {
		//Falta programar a atualização de item, ver DialogCardapio como faz
	}
	@Override
	protected void deleteItem() {
		//Falta programar a exclusao de item, ver DialogCardapio como faz
	}
	protected void events() {
		super.events();
		tabela.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1 && tabela.getSelectedRow() != -1) {
		        	Bar c = modelo.getValueAtRow(tabela.getSelectedRow());
		        	
		        	crudPanel.txtFiels.get("id").setText(c.getId()+"");
		        	crudPanel.txtFiels.get("nome").setText(c.getNome()+"");
		        	crudPanel.txtFiels.get("lema").setText(c.getLema()+"");
		        	crudPanel.txtFiels.get("historico").setText(c.getHistorico()+"");
		        }
		    }
		});
	}
}

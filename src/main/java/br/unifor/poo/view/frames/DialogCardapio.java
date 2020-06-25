package br.unifor.poo.view.frames;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;

import br.unifor.poo.modelo.Cardapio;
import br.unifor.poo.view.components.IDialogT;
import br.unifor.poo.view.util.Misc;

@SuppressWarnings("serial")
public class DialogCardapio extends IDialogT<Cardapio> {
	public DialogCardapio(Cardapio _item, Frame parentFrame, String title, int width, int height) {
		super(_item, parentFrame, title, width, height);
	}
	public DialogCardapio(Cardapio _item, JDialog parentFrame, String title, int width, int height) {
		super(_item, parentFrame, title, width, height);
	}
	@Override
	protected void events() {
		super.events();
		tabela.addMouseListener(new MouseAdapter() {
			@Override
		    public void mousePressed(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1 && tabela.getSelectedRow() != -1) {
		        	Cardapio c = modelo.getValueAtRow(tabela.getSelectedRow());
		        	
		        	crudPanel.txtFiels.get("id").setText(c.getId()+"");
		        	crudPanel.txtFiels.get("nome").setText(c.getNome()+"");
		        	crudPanel.txtFiels.get("preco").setText(c.getPreco()+"");
		        	crudPanel.txtFiels.get("qtd").setText(c.getQtd()+"");
		        }
		    }
		});
	}
	@Override
	protected void newItem() {
		Cardapio item = new Cardapio(
			Misc.code++,
			crudPanel.txtFiels.get("nome").getText(),
			Double.parseDouble(crudPanel.txtFiels.get("preco").getText()),
			Integer.parseInt(crudPanel.txtFiels.get("qtd").getText())
		);
		crudPanel.txtFiels.forEach((K,V) -> {V.setText("");});
		modelo.add(item);
		modelo.fireTableDataChanged();
	}
	@Override
	protected void updateItem() {
		Cardapio item = modelo.getValueAtRow(tabela.getSelectedRow());
		item.setId(Long.parseLong(crudPanel.txtFiels.get("id").getText()));
		item.setNome(crudPanel.txtFiels.get("nome").getText());
		item.setPreco(Double.parseDouble(crudPanel.txtFiels.get("preco").getText()));
		item.setQtd(Integer.parseInt(crudPanel.txtFiels.get("qtd").getText()));
		
		crudPanel.txtFiels.forEach((K,V) -> { V.setText("");});
		modelo.fireTableDataChanged();
	}
	@Override
	protected void deleteItem() {
		Cardapio item = modelo.getValueAtRow(tabela.getSelectedRow());
		modelo.delete(item);
		crudPanel.txtFiels.forEach((K,V) -> { V.setText("");});
		modelo.fireTableDataChanged();
	}
}
